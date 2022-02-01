package com.tencent.mm.plugin.appbrand.jsapi.openvoice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.service.b;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.service.q;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.service.q.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONObject;

public final class a
  extends i
{
  public static final int CTRL_INDEX = 517;
  public static final String NAME = "exitVoIPChat";
  
  public a()
  {
    AppMethodBeat.i(174844);
    com.tencent.mm.plugin.appbrand.permission.c.afo("exitVoIPChat");
    AppMethodBeat.o(174844);
  }
  
  public final void a(final com.tencent.mm.plugin.appbrand.service.c paramc, JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(46670);
    Log.i("MicroMsg.OpenVoice.JsApiCloudVoiceExitVoIPChat", "hy: invoke JsApiCloudVoiceExitVoIPChat");
    ja(false);
    paramJSONObject = paramc.getAppId();
    final long l = Util.currentTicks();
    q.wVc.a(new b() {}, q.a.wWO);
    AppMethodBeat.o(46670);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.openvoice.a
 * JD-Core Version:    0.7.0.1
 */