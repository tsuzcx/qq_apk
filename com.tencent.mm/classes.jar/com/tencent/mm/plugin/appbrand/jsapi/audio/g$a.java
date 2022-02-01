package com.tencent.mm.plugin.appbrand.jsapi.audio;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.x;
import com.tencent.mm.g.a.x.b;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.sdk.platformtools.Log;

final class g$a
  extends a
{
  public String appId = "";
  public String dtX = "";
  public boolean error = false;
  private p lAw;
  public f lAx;
  public int lqe;
  
  public g$a(p paramp, f paramf, int paramInt)
  {
    this.lAw = paramp;
    this.lAx = paramf;
    this.lqe = paramInt;
  }
  
  public final void YC()
  {
    AppMethodBeat.i(145706);
    Log.i("MicroMsg.Audio.JsApiDestroyInstanceAudio", "runTask");
    String str = this.dtX;
    Log.i("MicroMsg.AudioPlayerHelper", "destroyAudio, audioId:%s", new Object[] { str });
    x localx = new x();
    localx.dCQ.action = 5;
    localx.dCQ.dtX = str;
    com.tencent.mm.plugin.music.b.a.a(localx);
    this.error = localx.dCR.result;
    callback();
    AppMethodBeat.o(145706);
  }
  
  public final void callback()
  {
    AppMethodBeat.i(145707);
    super.callback();
    Log.i("MicroMsg.Audio.JsApiDestroyInstanceAudio", "callback");
    if (this.lAx == null)
    {
      Log.e("MicroMsg.Audio.JsApiDestroyInstanceAudio", "server is null");
      AppMethodBeat.o(145707);
      return;
    }
    if (this.error)
    {
      this.lAx.i(this.lqe, this.lAw.h("fail", null));
      AppMethodBeat.o(145707);
      return;
    }
    this.lAx.i(this.lqe, this.lAw.h("ok", null));
    AppMethodBeat.o(145707);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.g.a
 * JD-Core Version:    0.7.0.1
 */