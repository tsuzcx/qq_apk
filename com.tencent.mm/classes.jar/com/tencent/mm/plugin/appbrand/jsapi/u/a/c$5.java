package com.tencent.mm.plugin.appbrand.jsapi.u.a;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnSeekCompleteListener;
import com.tencent.mm.sdk.platformtools.y;

final class c$5
  implements MediaPlayer.OnSeekCompleteListener
{
  c$5(c paramc) {}
  
  public final void onSeekComplete(MediaPlayer paramMediaPlayer)
  {
    y.i("MicroMsg.AppBrand.SameLayer.AppBrandVideoPluginHandler", "handler onSeekComplete");
    if (this.gHQ.gHG)
    {
      y.i("MicroMsg.AppBrand.SameLayer.AppBrandVideoPluginHandler", "onSeekComplete, start when seek complete");
      this.gHQ.gHG = false;
      this.gHQ.play();
    }
    boolean bool;
    label234:
    do
    {
      do
      {
        return;
        bool = this.gHQ.gHr.isPlaying();
        if (!this.gHQ.gHH) {
          break label234;
        }
        y.i("MicroMsg.AppBrand.SameLayer.AppBrandVideoPluginHandler", "onSeekComplete, video playing before seeking, isCurrentPlaying:%b, position:%s, duration:%s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.gHQ.gHr.getCurrentPosition()), Integer.valueOf(this.gHQ.gHr.getDuration()) });
        this.gHQ.gHH = false;
        if (this.gHQ.gHr.getCurrentPosition() / 1000 >= this.gHQ.gHr.getDuration() / 1000) {
          break;
        }
        y.i("MicroMsg.AppBrand.SameLayer.AppBrandVideoPluginHandler", "onSeekComplete, video not end");
      } while ((!bool) || (!this.gHQ.alv()));
      y.i("MicroMsg.AppBrand.SameLayer.AppBrandVideoPluginHandler", "onSeekComplete, dispatch play again");
      this.gHQ.gHA.onVideoPlay();
      return;
      y.i("MicroMsg.AppBrand.SameLayer.AppBrandVideoPluginHandler", "onSeekComplete, video ends");
      this.gHQ.gHr.pause();
      this.gHQ.gHr.start();
      return;
      y.i("MicroMsg.AppBrand.SameLayer.AppBrandVideoPluginHandler", "onSeekComplete, video not playing before seeking, isCurrentPlaying:%b", new Object[] { Boolean.valueOf(bool) });
    } while ((bool) || (!this.gHQ.alv()));
    y.i("MicroMsg.AppBrand.SameLayer.AppBrandVideoPluginHandler", "onSeekComplete, dispatch pause again");
    this.gHQ.gHA.onVideoPause();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.u.a.c.5
 * JD-Core Version:    0.7.0.1
 */