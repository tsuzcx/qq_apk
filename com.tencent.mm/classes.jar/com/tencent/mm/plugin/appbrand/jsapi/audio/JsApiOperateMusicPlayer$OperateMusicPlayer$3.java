package com.tencent.mm.plugin.appbrand.jsapi.audio;

import com.tencent.mm.sdk.platformtools.y;

final class JsApiOperateMusicPlayer$OperateMusicPlayer$3
  implements Runnable
{
  JsApiOperateMusicPlayer$OperateMusicPlayer$3(JsApiOperateMusicPlayer.OperateMusicPlayer paramOperateMusicPlayer) {}
  
  public final void run()
  {
    y.i("MicroMsg.JsApiOperateMusicPlayer", "pause ok");
    this.giR.action = -1;
    this.giR.error = false;
    this.giR.errorMsg = "";
    JsApiOperateMusicPlayer.OperateMusicPlayer.e(this.giR);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiOperateMusicPlayer.OperateMusicPlayer.3
 * JD-Core Version:    0.7.0.1
 */