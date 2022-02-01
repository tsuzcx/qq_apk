package com.tencent.mm.plugin.mmsight.model.b;

import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.segment.MP4MuxerJNI;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public final class d
  implements a
{
  private long bxw;
  private int frameCount = 0;
  private long gnO;
  private int gnX = 0;
  private String hBT;
  private boolean hcP = false;
  private h tFr;
  private byte[] tFs = null;
  private double tFt;
  private int videoFps;
  
  public final void a(h paramh)
  {
    this.tFr = paramh;
  }
  
  public final Point aDh()
  {
    AppMethodBeat.i(89618);
    Point localPoint = new Point(MP4MuxerJNI.ffmpegGetVideoWidthLock(), MP4MuxerJNI.ffmpegGetVideoHeightLock());
    AppMethodBeat.o(89618);
    return localPoint;
  }
  
  public final int aDi()
  {
    return 2;
  }
  
  public final void cQs()
  {
    AppMethodBeat.i(89617);
    ad.i("MicroMsg.FFMpegTranscodeDecoder", "startDecodeBlockLoop");
    this.hcP = true;
    this.frameCount = 0;
    boolean bool2;
    do
    {
      if (!this.hcP)
      {
        AppMethodBeat.o(89617);
        return;
      }
      long l = bt.GC();
      this.tFs = MP4MuxerJNI.ffmpegGetNextVideoFrameDataLock(this.tFs);
      ad.d("MicroMsg.FFMpegTranscodeDecoder", "ffmpegGetNextVideoFrameData used %sms", new Object[] { Long.valueOf(bt.aS(l)) });
      bool2 = MP4MuxerJNI.ffmpegCheckIfReachEndTimestampLock();
      this.frameCount += 1;
    } while ((this.gnX > 1) && (this.frameCount % this.gnX == 0));
    h localh;
    byte[] arrayOfByte;
    if (this.tFr != null)
    {
      localh = this.tFr;
      arrayOfByte = this.tFs;
      if ((this.tFs != null) && (!bool2)) {
        break label227;
      }
    }
    label227:
    for (boolean bool1 = true;; bool1 = false)
    {
      localh.a(arrayOfByte, bool1, (this.frameCount * this.tFt * 1000.0D));
      if ((this.tFs != null) && (!bool2)) {
        break;
      }
      ad.e("MicroMsg.FFMpegTranscodeDecoder", "ret buffer is null or reachEnd? %s", new Object[] { Boolean.valueOf(bool2) });
      ad.i("MicroMsg.FFMpegTranscodeDecoder", "decode finish, frame count: %s", new Object[] { Integer.valueOf(this.frameCount) });
      this.hcP = false;
      AppMethodBeat.o(89617);
      return;
    }
  }
  
  public final int d(String paramString, long paramLong1, long paramLong2, int paramInt)
  {
    AppMethodBeat.i(89616);
    ad.i("MicroMsg.FFMpegTranscodeDecoder", "initDecoder, srcFilePath: %s, start: %s, end: %s, videoFps: %s", new Object[] { paramString, Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(paramInt) });
    this.hBT = paramString;
    this.bxw = paramLong1;
    this.gnO = paramLong2;
    this.videoFps = paramInt;
    this.tFt = (1000.0D / paramInt);
    if (!bt.isNullOrNil(paramString))
    {
      long l = bt.GC();
      paramInt = MP4MuxerJNI.ffmpegOpenAndSeekFileLock(paramString, paramLong1 * 1000.0D, paramLong2 * 1000.0D);
      ad.i("MicroMsg.FFMpegTranscodeDecoder", "ffmpegOpenAndSeekFile used %sms", new Object[] { Long.valueOf(bt.aS(l)) });
      AppMethodBeat.o(89616);
      return paramInt;
    }
    AppMethodBeat.o(89616);
    return -1;
  }
  
  public final void oV(int paramInt)
  {
    this.tFt = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.b.d
 * JD-Core Version:    0.7.0.1
 */