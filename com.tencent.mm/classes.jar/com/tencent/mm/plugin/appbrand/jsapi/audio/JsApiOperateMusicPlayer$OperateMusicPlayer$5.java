package com.tencent.mm.plugin.appbrand.jsapi.audio;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class JsApiOperateMusicPlayer$OperateMusicPlayer$5
  implements Runnable
{
  JsApiOperateMusicPlayer$OperateMusicPlayer$5(JsApiOperateMusicPlayer.OperateMusicPlayer paramOperateMusicPlayer) {}
  
  public final void run()
  {
    AppMethodBeat.i(130723);
    ab.i("MicroMsg.JsApiOperateMusicPlayer", "stop ok");
    this.hCl.action = -1;
    this.hCl.error = false;
    this.hCl.errorMsg = "";
    JsApiOperateMusicPlayer.OperateMusicPlayer.g(this.hCl);
    AppMethodBeat.o(130723);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiOperateMusicPlayer.OperateMusicPlayer.5
 * JD-Core Version:    0.7.0.1
 */