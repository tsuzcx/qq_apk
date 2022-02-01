package com.tencent.mm.plugin.mmsight.model.b;

import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.segment.MP4MuxerJNI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class d
  implements a
{
  private h KYd;
  private byte[] KYe = null;
  private double KYf;
  private long endTimeMs;
  private int frameCount = 0;
  private int nyO = 0;
  private boolean oCI = false;
  private String pcY;
  private long startTimeMs;
  private int videoFps;
  
  public final void a(h paramh)
  {
    this.KYd = paramh;
  }
  
  public final Point bOM()
  {
    AppMethodBeat.i(89618);
    Point localPoint = new Point(MP4MuxerJNI.ffmpegGetVideoWidthLock(), MP4MuxerJNI.ffmpegGetVideoHeightLock());
    AppMethodBeat.o(89618);
    return localPoint;
  }
  
  public final int bON()
  {
    return 2;
  }
  
  public final int e(String paramString, long paramLong1, long paramLong2, int paramInt)
  {
    AppMethodBeat.i(89616);
    Log.i("MicroMsg.FFMpegTranscodeDecoder", "initDecoder, srcFilePath: %s, start: %s, end: %s, videoFps: %s", new Object[] { paramString, Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(paramInt) });
    this.pcY = paramString;
    this.startTimeMs = paramLong1;
    this.endTimeMs = paramLong2;
    this.videoFps = paramInt;
    this.KYf = (1000.0D / paramInt);
    if (!Util.isNullOrNil(paramString))
    {
      long l = Util.currentTicks();
      paramInt = MP4MuxerJNI.ffmpegOpenAndSeekFileLock(paramString, paramLong1 * 1000.0D, paramLong2 * 1000.0D);
      Log.i("MicroMsg.FFMpegTranscodeDecoder", "ffmpegOpenAndSeekFile used %sms", new Object[] { Long.valueOf(Util.ticksToNow(l)) });
      AppMethodBeat.o(89616);
      return paramInt;
    }
    AppMethodBeat.o(89616);
    return -1;
  }
  
  public final void gcH()
  {
    AppMethodBeat.i(89617);
    Log.i("MicroMsg.FFMpegTranscodeDecoder", "startDecodeBlockLoop");
    this.oCI = true;
    this.frameCount = 0;
    boolean bool2;
    do
    {
      if (!this.oCI)
      {
        AppMethodBeat.o(89617);
        return;
      }
      long l = Util.currentTicks();
      this.KYe = MP4MuxerJNI.ffmpegGetNextVideoFrameDataLock(this.KYe);
      Log.d("MicroMsg.FFMpegTranscodeDecoder", "ffmpegGetNextVideoFrameData used %sms", new Object[] { Long.valueOf(Util.ticksToNow(l)) });
      bool2 = MP4MuxerJNI.ffmpegCheckIfReachEndTimestampLock();
      this.frameCount += 1;
    } while ((this.nyO > 1) && (this.frameCount % this.nyO == 0));
    h localh;
    byte[] arrayOfByte;
    if (this.KYd != null)
    {
      localh = this.KYd;
      arrayOfByte = this.KYe;
      if ((this.KYe != null) && (!bool2)) {
        break label227;
      }
    }
    label227:
    for (boolean bool1 = true;; bool1 = false)
    {
      localh.a(arrayOfByte, bool1, (this.frameCount * this.KYf * 1000.0D));
      if ((this.KYe != null) && (!bool2)) {
        break;
      }
      Log.e("MicroMsg.FFMpegTranscodeDecoder", "ret buffer is null or reachEnd? %s", new Object[] { Boolean.valueOf(bool2) });
      Log.i("MicroMsg.FFMpegTranscodeDecoder", "decode finish, frame count: %s", new Object[] { Integer.valueOf(this.frameCount) });
      this.oCI = false;
      AppMethodBeat.o(89617);
      return;
    }
  }
  
  public final void xe(int paramInt)
  {
    this.KYf = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.b.d
 * JD-Core Version:    0.7.0.1
 */