package com.tencent.mm.plugin.appbrand.jsapi.k;

import com.tencent.luggage.g.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.c.o;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.c.o.a;
import com.tencent.mm.sdk.platformtools.bo;
import org.json.JSONObject;

public final class a
  extends g
{
  public static final int CTRL_INDEX = 517;
  public static final String NAME = "exitVoIPChat";
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(143421);
    d.i("MicroMsg.OpenVoice.JsApiCloudVoiceExitVoIPChat", "hy: invoke JsApiCloudVoiceExitVoIPChat");
    ec(false);
    paramJSONObject = paramc.getAppId();
    long l = bo.yB();
    o.kKN.a(new a.1(this, l, paramJSONObject, paramc, paramInt), o.a.kMe);
    AppMethodBeat.o(143421);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.k.a
 * JD-Core Version:    0.7.0.1
 */