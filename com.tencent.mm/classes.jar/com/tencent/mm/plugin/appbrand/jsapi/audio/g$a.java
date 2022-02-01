package com.tencent.mm.plugin.appbrand.jsapi.audio;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.v;
import com.tencent.mm.g.a.v.b;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.ae;

final class g$a
  extends a
{
  public String appId = "";
  public String ddg = "";
  public boolean error = false;
  public int kmu;
  private m kuO;
  public c kws;
  
  public g$a(m paramm, c paramc, int paramInt)
  {
    this.kuO = paramm;
    this.kws = paramc;
    this.kmu = paramInt;
  }
  
  public final void BK()
  {
    AppMethodBeat.i(145707);
    super.BK();
    ae.i("MicroMsg.Audio.JsApiDestroyInstanceAudio", "callback");
    if (this.kws == null)
    {
      ae.e("MicroMsg.Audio.JsApiDestroyInstanceAudio", "server is null");
      AppMethodBeat.o(145707);
      return;
    }
    if (this.error)
    {
      this.kws.h(this.kmu, this.kuO.e("fail", null));
      AppMethodBeat.o(145707);
      return;
    }
    this.kws.h(this.kmu, this.kuO.e("ok", null));
    AppMethodBeat.o(145707);
  }
  
  public final void Ov()
  {
    AppMethodBeat.i(145706);
    ae.i("MicroMsg.Audio.JsApiDestroyInstanceAudio", "runTask");
    String str = this.ddg;
    ae.i("MicroMsg.AudioPlayerHelper", "destroyAudio, audioId:%s", new Object[] { str });
    v localv = new v();
    localv.dlA.action = 5;
    localv.dlA.ddg = str;
    com.tencent.mm.plugin.music.b.a.a(localv);
    this.error = localv.dlB.result;
    BK();
    AppMethodBeat.o(145706);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.g.a
 * JD-Core Version:    0.7.0.1
 */