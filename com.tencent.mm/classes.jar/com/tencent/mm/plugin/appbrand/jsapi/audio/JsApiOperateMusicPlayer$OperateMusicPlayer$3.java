package com.tencent.mm.plugin.appbrand.jsapi.audio;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class JsApiOperateMusicPlayer$OperateMusicPlayer$3
  implements Runnable
{
  JsApiOperateMusicPlayer$OperateMusicPlayer$3(JsApiOperateMusicPlayer.OperateMusicPlayer paramOperateMusicPlayer) {}
  
  public final void run()
  {
    AppMethodBeat.i(130721);
    ab.i("MicroMsg.JsApiOperateMusicPlayer", "pause ok");
    this.hCl.action = -1;
    this.hCl.error = false;
    this.hCl.errorMsg = "";
    JsApiOperateMusicPlayer.OperateMusicPlayer.e(this.hCl);
    AppMethodBeat.o(130721);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiOperateMusicPlayer.OperateMusicPlayer.3
 * JD-Core Version:    0.7.0.1
 */