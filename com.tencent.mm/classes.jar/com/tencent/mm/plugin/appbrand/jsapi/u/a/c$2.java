package com.tencent.mm.plugin.appbrand.jsapi.u.a;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import com.tencent.mm.sdk.platformtools.y;

final class c$2
  implements MediaPlayer.OnErrorListener
{
  c$2(c paramc) {}
  
  public final boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    y.i("MicroMsg.AppBrand.SameLayer.AppBrandVideoPluginHandler", "handler onError, what:%d, extra:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (this.gHQ.gHB != null)
    {
      this.gHQ.gHB.cb(paramInt1, paramInt2);
      if ((this.gHQ.gHC != null) && (paramInt1 == -1024)) {
        this.gHQ.gHC.cC(-paramInt2);
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.u.a.c.2
 * JD-Core Version:    0.7.0.1
 */