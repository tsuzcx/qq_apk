package com.tencent.mm.plugin.appbrand.jsapi.u.a.b;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnInfoListener;

final class a$4
  implements MediaPlayer.OnInfoListener
{
  a$4(a parama) {}
  
  public final boolean onInfo(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    if (this.gIh.gIi != null) {
      this.gIh.gIi.onInfo(paramMediaPlayer, paramInt1, paramInt2);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.u.a.b.a.4
 * JD-Core Version:    0.7.0.1
 */