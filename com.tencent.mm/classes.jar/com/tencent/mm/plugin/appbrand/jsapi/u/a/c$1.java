package com.tencent.mm.plugin.appbrand.jsapi.u.a;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnInfoListener;
import com.tencent.mm.sdk.platformtools.y;

final class c$1
  implements MediaPlayer.OnInfoListener
{
  c$1(c paramc) {}
  
  public final boolean onInfo(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    y.i("MicroMsg.AppBrand.SameLayer.AppBrandVideoPluginHandler", "handler onInfo, what:%d, extra:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt1 == 701)
    {
      this.gHQ.gHI = this.gHQ.gHr.isPlaying();
      y.i("MicroMsg.AppBrand.SameLayer.AppBrandVideoPluginHandler", "onInfo, buffering start, isPlayingBeforeBuffering:%b", new Object[] { Boolean.valueOf(this.gHQ.gHI) });
      if (this.gHQ.alv()) {
        this.gHQ.gHA.onVideoWaiting();
      }
    }
    boolean bool;
    do
    {
      do
      {
        do
        {
          return false;
        } while (paramInt1 != 702);
        bool = this.gHQ.gHr.isPlaying();
        y.i("MicroMsg.AppBrand.SameLayer.AppBrandVideoPluginHandler", "onInfo, buffering end, isPlayingBeforeBuffering:%b, isCurrentPlaying", new Object[] { Boolean.valueOf(this.gHQ.gHI), Boolean.valueOf(bool) });
        if (!this.gHQ.gHI) {
          break;
        }
        this.gHQ.gHI = false;
      } while ((!bool) || (!this.gHQ.alv()));
      y.i("MicroMsg.AppBrand.SameLayer.AppBrandVideoPluginHandler", "onInfo, buffering end, notify video play");
      this.gHQ.gHA.onVideoPlay();
      return false;
    } while ((bool) || (!this.gHQ.alv()));
    y.i("MicroMsg.AppBrand.SameLayer.AppBrandVideoPluginHandler", "onInfo, buffering end, notify video pause");
    this.gHQ.gHA.onVideoPause();
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.u.a.c.1
 * JD-Core Version:    0.7.0.1
 */