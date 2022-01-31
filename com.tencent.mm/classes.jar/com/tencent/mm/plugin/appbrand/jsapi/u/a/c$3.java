package com.tencent.mm.plugin.appbrand.jsapi.u.a;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import com.tencent.mm.sdk.platformtools.y;

final class c$3
  implements MediaPlayer.OnPreparedListener
{
  c$3(c paramc) {}
  
  public final void onPrepared(MediaPlayer paramMediaPlayer)
  {
    y.i("MicroMsg.AppBrand.SameLayer.AppBrandVideoPluginHandler", "handler onPrepared");
    this.gHQ.gHE = true;
    this.gHQ.alu();
    if (this.gHQ.gHB != null) {
      this.gHQ.gHB.init();
    }
    if (this.gHQ.alv()) {
      this.gHQ.gHA.z(this.gHQ.gHr.getVideoWidth(), this.gHQ.gHr.getVideoHeight(), this.gHQ.gHr.getDuration());
    }
    if (this.gHQ.gHF)
    {
      y.i("MicroMsg.AppBrand.SameLayer.AppBrandVideoPluginHandler", "onPrepared, start when prepared");
      if (this.gHQ.alv()) {
        this.gHQ.gHA.onVideoPlay();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.u.a.c.3
 * JD-Core Version:    0.7.0.1
 */