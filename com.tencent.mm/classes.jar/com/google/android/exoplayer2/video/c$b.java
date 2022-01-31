package com.google.android.exoplayer2.video;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCodec.OnFrameRenderedListener;
import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;

@TargetApi(23)
final class c$b
  implements MediaCodec.OnFrameRenderedListener
{
  private c$b(c paramc, MediaCodec paramMediaCodec)
  {
    AppMethodBeat.i(95996);
    paramMediaCodec.setOnFrameRenderedListener(this, new Handler());
    AppMethodBeat.o(95996);
  }
  
  public final void onFrameRendered(MediaCodec paramMediaCodec, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(95997);
    if (this != this.bcr.bcn)
    {
      AppMethodBeat.o(95997);
      return;
    }
    this.bcr.rf();
    AppMethodBeat.o(95997);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.android.exoplayer2.video.c.b
 * JD-Core Version:    0.7.0.1
 */