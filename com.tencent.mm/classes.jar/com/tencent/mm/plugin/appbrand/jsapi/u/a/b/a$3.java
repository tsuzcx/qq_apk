package com.tencent.mm.plugin.appbrand.jsapi.u.a.b;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;

final class a$3
  implements MediaPlayer.OnCompletionListener
{
  a$3(a parama) {}
  
  public final void onCompletion(MediaPlayer paramMediaPlayer)
  {
    this.gIh.mCurrentState = 6;
    if (this.gIh.gIl != null) {
      this.gIh.gIl.onCompletion(paramMediaPlayer);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.u.a.b.a.3
 * JD-Core Version:    0.7.0.1
 */