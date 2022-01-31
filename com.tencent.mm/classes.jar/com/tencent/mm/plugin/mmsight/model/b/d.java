package com.tencent.mm.plugin.mmsight.model.b;

import android.graphics.Point;
import com.tencent.mm.plugin.mmsight.segment.MP4MuxerJNI;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class d
  implements a
{
  private long aRW;
  private long eIR;
  private int eIV = 0;
  private String eJC;
  private boolean eku = false;
  private int frameCount = 0;
  private h mkZ;
  private byte[] mla = null;
  private double mlb;
  private int videoFps;
  
  public final Point SP()
  {
    return new Point(MP4MuxerJNI.ffmpegGetVideoWidth(), MP4MuxerJNI.ffmpegGetVideoHeight());
  }
  
  public final int SQ()
  {
    return 2;
  }
  
  public final void a(h paramh)
  {
    this.mkZ = paramh;
  }
  
  public final void bjJ()
  {
    y.i("MicroMsg.FFMpegTranscodeDecoder", "startDecodeBlockLoop");
    this.eku = true;
    this.frameCount = 0;
    boolean bool2;
    do
    {
      if (!this.eku) {
        return;
      }
      long l = bk.UZ();
      this.mla = MP4MuxerJNI.ffmpegGetNextVideoFrameData(this.mla);
      y.d("MicroMsg.FFMpegTranscodeDecoder", "ffmpegGetNextVideoFrameData used %sms", new Object[] { Long.valueOf(bk.cp(l)) });
      bool2 = MP4MuxerJNI.ffmpegCheckIfReachEndTimestamp();
      this.frameCount += 1;
    } while ((this.eIV > 1) && (this.frameCount % this.eIV == 0));
    h localh;
    byte[] arrayOfByte;
    if (this.mkZ != null)
    {
      localh = this.mkZ;
      arrayOfByte = this.mla;
      if ((this.mla != null) && (!bool2)) {
        break label212;
      }
    }
    label212:
    for (boolean bool1 = true;; bool1 = false)
    {
      localh.a(arrayOfByte, bool1, (this.frameCount * this.mlb * 1000.0D));
      if ((this.mla != null) && (!bool2)) {
        break;
      }
      y.e("MicroMsg.FFMpegTranscodeDecoder", "ret buffer is null or reachEnd? %s", new Object[] { Boolean.valueOf(bool2) });
      y.i("MicroMsg.FFMpegTranscodeDecoder", "decode finish, frame count: %s", new Object[] { Integer.valueOf(this.frameCount) });
      this.eku = false;
      return;
    }
  }
  
  public final int e(String paramString, long paramLong1, long paramLong2, int paramInt)
  {
    y.i("MicroMsg.FFMpegTranscodeDecoder", "initDecoder, srcFilePath: %s, start: %s, end: %s, videoFps: %s", new Object[] { paramString, Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(paramInt) });
    this.eJC = paramString;
    this.aRW = paramLong1;
    this.eIR = paramLong2;
    this.videoFps = paramInt;
    this.mlb = (1000.0D / paramInt);
    if (!bk.bl(paramString))
    {
      long l = bk.UZ();
      paramInt = MP4MuxerJNI.ffmpegOpenAndSeekFile(paramString, paramLong1 * 1000.0D, paramLong2 * 1000.0D);
      y.i("MicroMsg.FFMpegTranscodeDecoder", "ffmpegOpenAndSeekFile used %sms", new Object[] { Long.valueOf(bk.cp(l)) });
      return paramInt;
    }
    return -1;
  }
  
  public final void ju(int paramInt)
  {
    this.mlb = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.b.d
 * JD-Core Version:    0.7.0.1
 */