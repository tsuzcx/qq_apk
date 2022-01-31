package com.tencent.mm.plugin.appbrand.jsapi.audio;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.s;
import com.tencent.mm.g.a.s.b;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.ab;

final class e$a
  extends a
{
  public String appId = "";
  public String ceu = "";
  public boolean error = false;
  public int hry;
  private m hxs;
  public c hyO;
  
  public e$a(m paramm, c paramc, int paramInt)
  {
    this.hxs = paramm;
    this.hyO = paramc;
    this.hry = paramInt;
  }
  
  public final void Dh()
  {
    AppMethodBeat.i(137723);
    ab.i("MicroMsg.Audio.JsApiDestroyInstanceAudio", "runTask");
    String str = this.ceu;
    ab.i("MicroMsg.AudioPlayerHelper", "destroyAudio, audioId:%s", new Object[] { str });
    s locals = new s();
    locals.cmS.action = 5;
    locals.cmS.ceu = str;
    com.tencent.mm.plugin.music.b.a.a(locals);
    this.error = locals.cmT.cmX;
    tU();
    AppMethodBeat.o(137723);
  }
  
  public final void tU()
  {
    AppMethodBeat.i(137724);
    super.tU();
    ab.i("MicroMsg.Audio.JsApiDestroyInstanceAudio", "callback");
    if (this.hyO == null)
    {
      ab.e("MicroMsg.Audio.JsApiDestroyInstanceAudio", "server is null");
      AppMethodBeat.o(137724);
      return;
    }
    if (this.error)
    {
      this.hyO.h(this.hry, this.hxs.j("fail", null));
      AppMethodBeat.o(137724);
      return;
    }
    this.hyO.h(this.hry, this.hxs.j("ok", null));
    AppMethodBeat.o(137724);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.e.a
 * JD-Core Version:    0.7.0.1
 */