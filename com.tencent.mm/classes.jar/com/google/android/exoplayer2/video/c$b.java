package com.google.android.exoplayer2.video;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCodec.OnFrameRenderedListener;
import android.os.Handler;

@TargetApi(23)
final class c$b
  implements MediaCodec.OnFrameRenderedListener
{
  private c$b(c paramc, MediaCodec paramMediaCodec)
  {
    paramMediaCodec.setOnFrameRenderedListener(this, new Handler());
  }
  
  public final void onFrameRendered(MediaCodec paramMediaCodec, long paramLong1, long paramLong2)
  {
    if (this != this.aTT.aTP) {
      return;
    }
    this.aTT.ot();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.exoplayer2.video.c.b
 * JD-Core Version:    0.7.0.1
 */