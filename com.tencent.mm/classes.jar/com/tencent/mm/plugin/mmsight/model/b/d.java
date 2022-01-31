package com.tencent.mm.plugin.mmsight.model.b;

import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.segment.MP4MuxerJNI;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class d
  implements a
{
  private long aZw;
  private long eRN;
  private int eRW = 0;
  private boolean fAK = false;
  private String fZg;
  private int frameCount = 0;
  private h oKg;
  private byte[] oKh = null;
  private double oKi;
  private int videoFps;
  
  public final void a(h paramh)
  {
    this.oKg = paramh;
  }
  
  public final Point amc()
  {
    AppMethodBeat.i(76703);
    Point localPoint = new Point(MP4MuxerJNI.ffmpegGetVideoWidthLock(), MP4MuxerJNI.ffmpegGetVideoHeightLock());
    AppMethodBeat.o(76703);
    return localPoint;
  }
  
  public final int amd()
  {
    return 2;
  }
  
  public final void bRx()
  {
    AppMethodBeat.i(76702);
    ab.i("MicroMsg.FFMpegTranscodeDecoder", "startDecodeBlockLoop");
    this.fAK = true;
    this.frameCount = 0;
    boolean bool2;
    do
    {
      if (!this.fAK)
      {
        AppMethodBeat.o(76702);
        return;
      }
      long l = bo.yB();
      this.oKh = MP4MuxerJNI.ffmpegGetNextVideoFrameDataLock(this.oKh);
      ab.d("MicroMsg.FFMpegTranscodeDecoder", "ffmpegGetNextVideoFrameData used %sms", new Object[] { Long.valueOf(bo.av(l)) });
      bool2 = MP4MuxerJNI.ffmpegCheckIfReachEndTimestampLock();
      this.frameCount += 1;
    } while ((this.eRW > 1) && (this.frameCount % this.eRW == 0));
    h localh;
    byte[] arrayOfByte;
    if (this.oKg != null)
    {
      localh = this.oKg;
      arrayOfByte = this.oKh;
      if ((this.oKh != null) && (!bool2)) {
        break label227;
      }
    }
    label227:
    for (boolean bool1 = true;; bool1 = false)
    {
      localh.a(arrayOfByte, bool1, (this.frameCount * this.oKi * 1000.0D));
      if ((this.oKh != null) && (!bool2)) {
        break;
      }
      ab.e("MicroMsg.FFMpegTranscodeDecoder", "ret buffer is null or reachEnd? %s", new Object[] { Boolean.valueOf(bool2) });
      ab.i("MicroMsg.FFMpegTranscodeDecoder", "decode finish, frame count: %s", new Object[] { Integer.valueOf(this.frameCount) });
      this.fAK = false;
      AppMethodBeat.o(76702);
      return;
    }
  }
  
  public final int e(String paramString, long paramLong1, long paramLong2, int paramInt)
  {
    AppMethodBeat.i(76701);
    ab.i("MicroMsg.FFMpegTranscodeDecoder", "initDecoder, srcFilePath: %s, start: %s, end: %s, videoFps: %s", new Object[] { paramString, Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(paramInt) });
    this.fZg = paramString;
    this.aZw = paramLong1;
    this.eRN = paramLong2;
    this.videoFps = paramInt;
    this.oKi = (1000.0D / paramInt);
    if (!bo.isNullOrNil(paramString))
    {
      long l = bo.yB();
      paramInt = MP4MuxerJNI.ffmpegOpenAndSeekFileLock(paramString, paramLong1 * 1000.0D, paramLong2 * 1000.0D);
      ab.i("MicroMsg.FFMpegTranscodeDecoder", "ffmpegOpenAndSeekFile used %sms", new Object[] { Long.valueOf(bo.av(l)) });
      AppMethodBeat.o(76701);
      return paramInt;
    }
    AppMethodBeat.o(76701);
    return -1;
  }
  
  public final void mm(int paramInt)
  {
    this.oKi = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.b.d
 * JD-Core Version:    0.7.0.1
 */