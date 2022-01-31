package com.tencent.mm.plugin.appbrand.jsapi.u.a.b;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnVideoSizeChangedListener;

final class a$2
  implements MediaPlayer.OnVideoSizeChangedListener
{
  a$2(a parama) {}
  
  public final void onVideoSizeChanged(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    if (this.gIh.gIo != null) {
      this.gIh.gIo.onVideoSizeChanged(paramMediaPlayer, paramInt1, paramInt2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.u.a.b.a.2
 * JD-Core Version:    0.7.0.1
 */