package com.tencent.mm.plugin.mmsight.model.b;

import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.segment.MP4MuxerJNI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class d
  implements a
{
  private long endTimeMs;
  private int frameCount = 0;
  private boolean iTN = false;
  private int ies = 0;
  private String jtX;
  private long startTimeMs;
  private int videoFps;
  private h zxa;
  private byte[] zxb = null;
  private double zxc;
  
  public final void a(h paramh)
  {
    this.zxa = paramh;
  }
  
  public final Point bhJ()
  {
    AppMethodBeat.i(89618);
    Point localPoint = new Point(MP4MuxerJNI.ffmpegGetVideoWidthLock(), MP4MuxerJNI.ffmpegGetVideoHeightLock());
    AppMethodBeat.o(89618);
    return localPoint;
  }
  
  public final int bhK()
  {
    return 2;
  }
  
  public final int e(String paramString, long paramLong1, long paramLong2, int paramInt)
  {
    AppMethodBeat.i(89616);
    Log.i("MicroMsg.FFMpegTranscodeDecoder", "initDecoder, srcFilePath: %s, start: %s, end: %s, videoFps: %s", new Object[] { paramString, Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(paramInt) });
    this.jtX = paramString;
    this.startTimeMs = paramLong1;
    this.endTimeMs = paramLong2;
    this.videoFps = paramInt;
    this.zxc = (1000.0D / paramInt);
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
  
  public final void ekm()
  {
    AppMethodBeat.i(89617);
    Log.i("MicroMsg.FFMpegTranscodeDecoder", "startDecodeBlockLoop");
    this.iTN = true;
    this.frameCount = 0;
    boolean bool2;
    do
    {
      if (!this.iTN)
      {
        AppMethodBeat.o(89617);
        return;
      }
      long l = Util.currentTicks();
      this.zxb = MP4MuxerJNI.ffmpegGetNextVideoFrameDataLock(this.zxb);
      Log.d("MicroMsg.FFMpegTranscodeDecoder", "ffmpegGetNextVideoFrameData used %sms", new Object[] { Long.valueOf(Util.ticksToNow(l)) });
      bool2 = MP4MuxerJNI.ffmpegCheckIfReachEndTimestampLock();
      this.frameCount += 1;
    } while ((this.ies > 1) && (this.frameCount % this.ies == 0));
    h localh;
    byte[] arrayOfByte;
    if (this.zxa != null)
    {
      localh = this.zxa;
      arrayOfByte = this.zxb;
      if ((this.zxb != null) && (!bool2)) {
        break label227;
      }
    }
    label227:
    for (boolean bool1 = true;; bool1 = false)
    {
      localh.a(arrayOfByte, bool1, (this.frameCount * this.zxc * 1000.0D));
      if ((this.zxb != null) && (!bool2)) {
        break;
      }
      Log.e("MicroMsg.FFMpegTranscodeDecoder", "ret buffer is null or reachEnd? %s", new Object[] { Boolean.valueOf(bool2) });
      Log.i("MicroMsg.FFMpegTranscodeDecoder", "decode finish, frame count: %s", new Object[] { Integer.valueOf(this.frameCount) });
      this.iTN = false;
      AppMethodBeat.o(89617);
      return;
    }
  }
  
  public final void uf(int paramInt)
  {
    this.zxc = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.b.d
 * JD-Core Version:    0.7.0.1
 */