package com.tencent.mm.plugin.appbrand.jsapi.u.a.b;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnSeekCompleteListener;

final class a$5
  implements MediaPlayer.OnSeekCompleteListener
{
  a$5(a parama) {}
  
  public final void onSeekComplete(MediaPlayer paramMediaPlayer)
  {
    if (this.gIh.gIm != null) {
      this.gIh.gIm.onSeekComplete(paramMediaPlayer);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.u.a.b.a.5
 * JD-Core Version:    0.7.0.1
 */