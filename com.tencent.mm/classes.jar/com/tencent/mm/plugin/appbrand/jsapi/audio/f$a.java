package com.tencent.mm.plugin.appbrand.jsapi.audio;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.v;
import com.tencent.mm.g.a.v.b;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.ac;

final class f$a
  extends a
{
  public String appId = "";
  public String cQO = "";
  public boolean error = false;
  public int jOT;
  private m jXc;
  public c jYG;
  
  public f$a(m paramm, c paramc, int paramInt)
  {
    this.jXc = paramm;
    this.jYG = paramc;
    this.jOT = paramInt;
  }
  
  public final void Am()
  {
    AppMethodBeat.i(145707);
    super.Am();
    ac.i("MicroMsg.Audio.JsApiDestroyInstanceAudio", "callback");
    if (this.jYG == null)
    {
      ac.e("MicroMsg.Audio.JsApiDestroyInstanceAudio", "server is null");
      AppMethodBeat.o(145707);
      return;
    }
    if (this.error)
    {
      this.jYG.h(this.jOT, this.jXc.e("fail", null));
      AppMethodBeat.o(145707);
      return;
    }
    this.jYG.h(this.jOT, this.jXc.e("ok", null));
    AppMethodBeat.o(145707);
  }
  
  public final void MO()
  {
    AppMethodBeat.i(145706);
    ac.i("MicroMsg.Audio.JsApiDestroyInstanceAudio", "runTask");
    String str = this.cQO;
    ac.i("MicroMsg.AudioPlayerHelper", "destroyAudio, audioId:%s", new Object[] { str });
    v localv = new v();
    localv.cZg.action = 5;
    localv.cZg.cQO = str;
    com.tencent.mm.plugin.music.b.a.a(localv);
    this.error = localv.cZh.result;
    Am();
    AppMethodBeat.o(145706);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.f.a
 * JD-Core Version:    0.7.0.1
 */