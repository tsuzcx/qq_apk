package com.tencent.mm.plugin.appbrand.jsapi.audio;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class JsApiOperateMusicPlayer$OperateMusicPlayer$4
  implements Runnable
{
  JsApiOperateMusicPlayer$OperateMusicPlayer$4(JsApiOperateMusicPlayer.OperateMusicPlayer paramOperateMusicPlayer) {}
  
  public final void run()
  {
    AppMethodBeat.i(130722);
    ab.i("MicroMsg.JsApiOperateMusicPlayer", "seek ok");
    this.hCl.action = -1;
    this.hCl.error = false;
    this.hCl.errorMsg = "";
    JsApiOperateMusicPlayer.OperateMusicPlayer.f(this.hCl);
    AppMethodBeat.o(130722);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiOperateMusicPlayer.OperateMusicPlayer.4
 * JD-Core Version:    0.7.0.1
 */