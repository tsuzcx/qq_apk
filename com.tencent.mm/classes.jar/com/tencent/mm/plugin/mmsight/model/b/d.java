package com.tencent.mm.plugin.mmsight.model.b;

import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.segment.MP4MuxerJNI;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;

public final class d
  implements a
{
  private long bvf;
  private int frameCount = 0;
  private int gOI = 0;
  private long gOz;
  private boolean hDs = false;
  private String icu;
  private h uNM;
  private byte[] uNN = null;
  private double uNO;
  private int videoFps;
  
  public final void a(h paramh)
  {
    this.uNM = paramh;
  }
  
  public final Point aJY()
  {
    AppMethodBeat.i(89618);
    Point localPoint = new Point(MP4MuxerJNI.ffmpegGetVideoWidthLock(), MP4MuxerJNI.ffmpegGetVideoHeightLock());
    AppMethodBeat.o(89618);
    return localPoint;
  }
  
  public final int aJZ()
  {
    return 2;
  }
  
  public final void dea()
  {
    AppMethodBeat.i(89617);
    ac.i("MicroMsg.FFMpegTranscodeDecoder", "startDecodeBlockLoop");
    this.hDs = true;
    this.frameCount = 0;
    boolean bool2;
    do
    {
      if (!this.hDs)
      {
        AppMethodBeat.o(89617);
        return;
      }
      long l = bs.Gn();
      this.uNN = MP4MuxerJNI.ffmpegGetNextVideoFrameDataLock(this.uNN);
      ac.d("MicroMsg.FFMpegTranscodeDecoder", "ffmpegGetNextVideoFrameData used %sms", new Object[] { Long.valueOf(bs.aO(l)) });
      bool2 = MP4MuxerJNI.ffmpegCheckIfReachEndTimestampLock();
      this.frameCount += 1;
    } while ((this.gOI > 1) && (this.frameCount % this.gOI == 0));
    h localh;
    byte[] arrayOfByte;
    if (this.uNM != null)
    {
      localh = this.uNM;
      arrayOfByte = this.uNN;
      if ((this.uNN != null) && (!bool2)) {
        break label227;
      }
    }
    label227:
    for (boolean bool1 = true;; bool1 = false)
    {
      localh.a(arrayOfByte, bool1, (this.frameCount * this.uNO * 1000.0D));
      if ((this.uNN != null) && (!bool2)) {
        break;
      }
      ac.e("MicroMsg.FFMpegTranscodeDecoder", "ret buffer is null or reachEnd? %s", new Object[] { Boolean.valueOf(bool2) });
      ac.i("MicroMsg.FFMpegTranscodeDecoder", "decode finish, frame count: %s", new Object[] { Integer.valueOf(this.frameCount) });
      this.hDs = false;
      AppMethodBeat.o(89617);
      return;
    }
  }
  
  public final int e(String paramString, long paramLong1, long paramLong2, int paramInt)
  {
    AppMethodBeat.i(89616);
    ac.i("MicroMsg.FFMpegTranscodeDecoder", "initDecoder, srcFilePath: %s, start: %s, end: %s, videoFps: %s", new Object[] { paramString, Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(paramInt) });
    this.icu = paramString;
    this.bvf = paramLong1;
    this.gOz = paramLong2;
    this.videoFps = paramInt;
    this.uNO = (1000.0D / paramInt);
    if (!bs.isNullOrNil(paramString))
    {
      long l = bs.Gn();
      paramInt = MP4MuxerJNI.ffmpegOpenAndSeekFileLock(paramString, paramLong1 * 1000.0D, paramLong2 * 1000.0D);
      ac.i("MicroMsg.FFMpegTranscodeDecoder", "ffmpegOpenAndSeekFile used %sms", new Object[] { Long.valueOf(bs.aO(l)) });
      AppMethodBeat.o(89616);
      return paramInt;
    }
    AppMethodBeat.o(89616);
    return -1;
  }
  
  public final void pK(int paramInt)
  {
    this.uNO = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.b.d
 * JD-Core Version:    0.7.0.1
 */