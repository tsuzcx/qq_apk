package com.tencent.mm.plugin.mmsight.model.b;

import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.segment.MP4MuxerJNI;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public final class d
  implements a
{
  private int frameCount = 0;
  private boolean hVX = false;
  private int hiI = 0;
  private long hiy;
  private String ivQ;
  private long startTimeMs;
  private h vQV;
  private byte[] vQW = null;
  private double vQX;
  private int videoFps;
  
  public final void a(h paramh)
  {
    this.vQV = paramh;
  }
  
  public final Point aNh()
  {
    AppMethodBeat.i(89618);
    Point localPoint = new Point(MP4MuxerJNI.ffmpegGetVideoWidthLock(), MP4MuxerJNI.ffmpegGetVideoHeightLock());
    AppMethodBeat.o(89618);
    return localPoint;
  }
  
  public final int aNi()
  {
    return 2;
  }
  
  public final void dny()
  {
    AppMethodBeat.i(89617);
    ad.i("MicroMsg.FFMpegTranscodeDecoder", "startDecodeBlockLoop");
    this.hVX = true;
    this.frameCount = 0;
    boolean bool2;
    do
    {
      if (!this.hVX)
      {
        AppMethodBeat.o(89617);
        return;
      }
      long l = bt.HI();
      this.vQW = MP4MuxerJNI.ffmpegGetNextVideoFrameDataLock(this.vQW);
      ad.d("MicroMsg.FFMpegTranscodeDecoder", "ffmpegGetNextVideoFrameData used %sms", new Object[] { Long.valueOf(bt.aO(l)) });
      bool2 = MP4MuxerJNI.ffmpegCheckIfReachEndTimestampLock();
      this.frameCount += 1;
    } while ((this.hiI > 1) && (this.frameCount % this.hiI == 0));
    h localh;
    byte[] arrayOfByte;
    if (this.vQV != null)
    {
      localh = this.vQV;
      arrayOfByte = this.vQW;
      if ((this.vQW != null) && (!bool2)) {
        break label227;
      }
    }
    label227:
    for (boolean bool1 = true;; bool1 = false)
    {
      localh.a(arrayOfByte, bool1, (this.frameCount * this.vQX * 1000.0D));
      if ((this.vQW != null) && (!bool2)) {
        break;
      }
      ad.e("MicroMsg.FFMpegTranscodeDecoder", "ret buffer is null or reachEnd? %s", new Object[] { Boolean.valueOf(bool2) });
      ad.i("MicroMsg.FFMpegTranscodeDecoder", "decode finish, frame count: %s", new Object[] { Integer.valueOf(this.frameCount) });
      this.hVX = false;
      AppMethodBeat.o(89617);
      return;
    }
  }
  
  public final int e(String paramString, long paramLong1, long paramLong2, int paramInt)
  {
    AppMethodBeat.i(89616);
    ad.i("MicroMsg.FFMpegTranscodeDecoder", "initDecoder, srcFilePath: %s, start: %s, end: %s, videoFps: %s", new Object[] { paramString, Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(paramInt) });
    this.ivQ = paramString;
    this.startTimeMs = paramLong1;
    this.hiy = paramLong2;
    this.videoFps = paramInt;
    this.vQX = (1000.0D / paramInt);
    if (!bt.isNullOrNil(paramString))
    {
      long l = bt.HI();
      paramInt = MP4MuxerJNI.ffmpegOpenAndSeekFileLock(paramString, paramLong1 * 1000.0D, paramLong2 * 1000.0D);
      ad.i("MicroMsg.FFMpegTranscodeDecoder", "ffmpegOpenAndSeekFile used %sms", new Object[] { Long.valueOf(bt.aO(l)) });
      AppMethodBeat.o(89616);
      return paramInt;
    }
    AppMethodBeat.o(89616);
    return -1;
  }
  
  public final void qm(int paramInt)
  {
    this.vQX = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.b.d
 * JD-Core Version:    0.7.0.1
 */