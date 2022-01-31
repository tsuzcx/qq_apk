package com.tencent.mm.plugin.appbrand.jsapi.u.a.b;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnBufferingUpdateListener;

final class a$7
  implements MediaPlayer.OnBufferingUpdateListener
{
  a$7(a parama) {}
  
  public final void onBufferingUpdate(MediaPlayer paramMediaPlayer, int paramInt)
  {
    if (this.gIh.gIn != null) {
      this.gIh.gIn.onBufferingUpdate(paramMediaPlayer, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.u.a.b.a.7
 * JD-Core Version:    0.7.0.1
 */