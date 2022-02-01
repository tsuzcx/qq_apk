package com.tencent.mm.plugin.appbrand.jsapi.openvoice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.d.b;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.d.p;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.d.p.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import org.json.JSONObject;

public final class a
  extends i
{
  public static final int CTRL_INDEX = 517;
  public static final String NAME = "exitVoIPChat";
  
  public a()
  {
    AppMethodBeat.i(174844);
    com.tencent.mm.plugin.appbrand.permission.c.Uy("exitVoIPChat");
    AppMethodBeat.o(174844);
  }
  
  public final void a(final com.tencent.mm.plugin.appbrand.service.c paramc, JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(46670);
    ae.i("MicroMsg.OpenVoice.JsApiCloudVoiceExitVoIPChat", "hy: invoke JsApiCloudVoiceExitVoIPChat");
    go(false);
    paramJSONObject = paramc.getAppId();
    final long l = bu.HQ();
    p.pdY.a(new b() {}, p.a.pfH);
    AppMethodBeat.o(46670);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.openvoice.a
 * JD-Core Version:    0.7.0.1
 */