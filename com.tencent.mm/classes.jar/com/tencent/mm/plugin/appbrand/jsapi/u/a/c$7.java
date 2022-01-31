package com.tencent.mm.plugin.appbrand.jsapi.u.a;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnBufferingUpdateListener;
import com.tencent.mm.sdk.platformtools.y;

final class c$7
  implements MediaPlayer.OnBufferingUpdateListener
{
  c$7(c paramc) {}
  
  public final void onBufferingUpdate(MediaPlayer paramMediaPlayer, int paramInt)
  {
    if (paramInt != this.gHQ.gHN)
    {
      this.gHQ.gHN = paramInt;
      y.i("MicroMsg.AppBrand.SameLayer.AppBrandVideoPluginHandler", "handler onBufferingUpdate, percent:%s", new Object[] { Integer.valueOf(paramInt) });
    }
    if ((this.gHQ.alv()) && (this.gHQ.gHE)) {
      this.gHQ.gHA.lL(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.u.a.c.7
 * JD-Core Version:    0.7.0.1
 */