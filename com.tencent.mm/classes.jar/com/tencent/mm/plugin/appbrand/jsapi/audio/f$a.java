package com.tencent.mm.plugin.appbrand.jsapi.audio;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.u;
import com.tencent.mm.g.a.u.b;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.ad;

final class f$a
  extends a
{
  public String appId = "";
  public String cTr = "";
  public boolean error = false;
  public int joH;
  private m jwG;
  public c jyl;
  
  public f$a(m paramm, c paramc, int paramInt)
  {
    this.jwG = paramm;
    this.jyl = paramc;
    this.joH = paramInt;
  }
  
  public final void AI()
  {
    AppMethodBeat.i(145707);
    super.AI();
    ad.i("MicroMsg.Audio.JsApiDestroyInstanceAudio", "callback");
    if (this.jyl == null)
    {
      ad.e("MicroMsg.Audio.JsApiDestroyInstanceAudio", "server is null");
      AppMethodBeat.o(145707);
      return;
    }
    if (this.error)
    {
      this.jyl.h(this.joH, this.jwG.e("fail", null));
      AppMethodBeat.o(145707);
      return;
    }
    this.jyl.h(this.joH, this.jwG.e("ok", null));
    AppMethodBeat.o(145707);
  }
  
  public final void MQ()
  {
    AppMethodBeat.i(145706);
    ad.i("MicroMsg.Audio.JsApiDestroyInstanceAudio", "runTask");
    String str = this.cTr;
    ad.i("MicroMsg.AudioPlayerHelper", "destroyAudio, audioId:%s", new Object[] { str });
    u localu = new u();
    localu.dbH.action = 5;
    localu.dbH.cTr = str;
    com.tencent.mm.plugin.music.b.a.a(localu);
    this.error = localu.dbI.result;
    AI();
    AppMethodBeat.o(145706);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.f.a
 * JD-Core Version:    0.7.0.1
 */