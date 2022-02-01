package com.tencent.mm.plugin.appbrand.jsapi.openvoice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.service.b;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.service.q;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.service.q.11;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public final class k
  extends i
{
  public static final int CTRL_INDEX = 780;
  public static final String NAME = "subscribeVoIPMembers";
  private static String TAG = "MicroMsg.OpenVoice.JsApiSubscribeVoIPMembers";
  
  public k()
  {
    AppMethodBeat.i(180257);
    com.tencent.mm.plugin.appbrand.permission.c.afo("subscribeVoIPMembers");
    AppMethodBeat.o(180257);
  }
  
  public final void a(final com.tencent.mm.plugin.appbrand.service.c paramc, JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(180258);
    if (paramJSONObject == null)
    {
      paramc.callback(paramInt, ZP("fail:data is null or nil"));
      AppMethodBeat.o(180258);
      return;
    }
    Object localObject = paramc.getAppId();
    Log.i(TAG, "hy: appId:" + (String)localObject + ", parmas:" + paramJSONObject.toString());
    localObject = q.wVc;
    ((q)localObject).au(new q.11((q)localObject, new b() {}, paramJSONObject));
    AppMethodBeat.o(180258);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.openvoice.k
 * JD-Core Version:    0.7.0.1
 */