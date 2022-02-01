package com.tencent.mm.plugin.mmsight.model.b;

import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.segment.MP4MuxerJNI;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;

public final class d
  implements a
{
  private int frameCount = 0;
  private boolean hYP = false;
  private long hlm;
  private int hlw = 0;
  private String iyJ;
  private long startTimeMs;
  private int videoFps;
  private h wcZ;
  private byte[] wda = null;
  private double wdb;
  
  public final void a(h paramh)
  {
    this.wcZ = paramh;
  }
  
  public final Point aNF()
  {
    AppMethodBeat.i(89618);
    Point localPoint = new Point(MP4MuxerJNI.ffmpegGetVideoWidthLock(), MP4MuxerJNI.ffmpegGetVideoHeightLock());
    AppMethodBeat.o(89618);
    return localPoint;
  }
  
  public final int aNG()
  {
    return 2;
  }
  
  public final void dqw()
  {
    AppMethodBeat.i(89617);
    ae.i("MicroMsg.FFMpegTranscodeDecoder", "startDecodeBlockLoop");
    this.hYP = true;
    this.frameCount = 0;
    boolean bool2;
    do
    {
      if (!this.hYP)
      {
        AppMethodBeat.o(89617);
        return;
      }
      long l = bu.HQ();
      this.wda = MP4MuxerJNI.ffmpegGetNextVideoFrameDataLock(this.wda);
      ae.d("MicroMsg.FFMpegTranscodeDecoder", "ffmpegGetNextVideoFrameData used %sms", new Object[] { Long.valueOf(bu.aO(l)) });
      bool2 = MP4MuxerJNI.ffmpegCheckIfReachEndTimestampLock();
      this.frameCount += 1;
    } while ((this.hlw > 1) && (this.frameCount % this.hlw == 0));
    h localh;
    byte[] arrayOfByte;
    if (this.wcZ != null)
    {
      localh = this.wcZ;
      arrayOfByte = this.wda;
      if ((this.wda != null) && (!bool2)) {
        break label227;
      }
    }
    label227:
    for (boolean bool1 = true;; bool1 = false)
    {
      localh.a(arrayOfByte, bool1, (this.frameCount * this.wdb * 1000.0D));
      if ((this.wda != null) && (!bool2)) {
        break;
      }
      ae.e("MicroMsg.FFMpegTranscodeDecoder", "ret buffer is null or reachEnd? %s", new Object[] { Boolean.valueOf(bool2) });
      ae.i("MicroMsg.FFMpegTranscodeDecoder", "decode finish, frame count: %s", new Object[] { Integer.valueOf(this.frameCount) });
      this.hYP = false;
      AppMethodBeat.o(89617);
      return;
    }
  }
  
  public final int e(String paramString, long paramLong1, long paramLong2, int paramInt)
  {
    AppMethodBeat.i(89616);
    ae.i("MicroMsg.FFMpegTranscodeDecoder", "initDecoder, srcFilePath: %s, start: %s, end: %s, videoFps: %s", new Object[] { paramString, Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(paramInt) });
    this.iyJ = paramString;
    this.startTimeMs = paramLong1;
    this.hlm = paramLong2;
    this.videoFps = paramInt;
    this.wdb = (1000.0D / paramInt);
    if (!bu.isNullOrNil(paramString))
    {
      long l = bu.HQ();
      paramInt = MP4MuxerJNI.ffmpegOpenAndSeekFileLock(paramString, paramLong1 * 1000.0D, paramLong2 * 1000.0D);
      ae.i("MicroMsg.FFMpegTranscodeDecoder", "ffmpegOpenAndSeekFile used %sms", new Object[] { Long.valueOf(bu.aO(l)) });
      AppMethodBeat.o(89616);
      return paramInt;
    }
    AppMethodBeat.o(89616);
    return -1;
  }
  
  public final void qp(int paramInt)
  {
    this.wdb = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.b.d
 * JD-Core Version:    0.7.0.1
 */