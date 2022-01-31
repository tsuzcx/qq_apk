package com.tencent.mm.plugin.appbrand.jsapi.u.a.b;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;

final class a$6
  implements MediaPlayer.OnErrorListener
{
  a$6(a parama) {}
  
  public final boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    if (this.gIh.gIj != null) {
      this.gIh.gIj.onError(paramMediaPlayer, paramInt1, paramInt2);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.u.a.b.a.6
 * JD-Core Version:    0.7.0.1
 */