package com.tencent.mm.plugin.appbrand.jsapi.openvoice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.d.p;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.d.p.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import org.json.JSONObject;

public final class a
  extends i
{
  public static final int CTRL_INDEX = 517;
  public static final String NAME = "exitVoIPChat";
  
  public a()
  {
    AppMethodBeat.i(174844);
    com.tencent.mm.plugin.appbrand.permission.c.TP("exitVoIPChat");
    AppMethodBeat.o(174844);
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.service.c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(46670);
    ad.i("MicroMsg.OpenVoice.JsApiCloudVoiceExitVoIPChat", "hy: invoke JsApiCloudVoiceExitVoIPChat");
    gq(false);
    paramJSONObject = paramc.getAppId();
    long l = bt.HI();
    p.oXv.a(new a.1(this, l, paramJSONObject, paramc, paramInt), p.a.oZd);
    AppMethodBeat.o(46670);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.openvoice.a
 * JD-Core Version:    0.7.0.1
 */