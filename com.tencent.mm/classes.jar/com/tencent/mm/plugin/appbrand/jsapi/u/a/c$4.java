package com.tencent.mm.plugin.appbrand.jsapi.u.a;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import com.tencent.mm.sdk.platformtools.y;

final class c$4
  implements MediaPlayer.OnCompletionListener
{
  c$4(c paramc) {}
  
  public final void onCompletion(MediaPlayer paramMediaPlayer)
  {
    y.i("MicroMsg.AppBrand.SameLayer.AppBrandVideoPluginHandler", "handler onCompletion");
    if (this.gHQ.alv()) {
      this.gHQ.gHA.alt();
    }
    if (this.gHQ.gHP)
    {
      y.i("MicroMsg.AppBrand.SameLayer.AppBrandVideoPluginHandler", "onCompletion, video loop playing");
      this.gHQ.gHG = true;
      this.gHQ.gHr.seekTo(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.u.a.c.4
 * JD-Core Version:    0.7.0.1
 */