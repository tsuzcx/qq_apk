package com.tencent.mm.plugin.appbrand.jsapi.k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.d.b;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.d.o;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.d.o.9;
import com.tencent.mm.sdk.platformtools.ad;
import org.json.JSONObject;

public final class h
  extends g
{
  public static final int CTRL_INDEX = 780;
  public static final String NAME = "subscribeVoIPMembers";
  private static String TAG = "MicroMsg.OpenVoice.JsApiSubscribeVoIPMembers";
  
  public h()
  {
    AppMethodBeat.i(180257);
    com.tencent.mm.plugin.appbrand.permission.c.Me("subscribeVoIPMembers");
    AppMethodBeat.o(180257);
  }
  
  public final void a(final com.tencent.mm.plugin.appbrand.service.c paramc, JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(180258);
    if (paramJSONObject == null)
    {
      paramc.h(paramInt, e("fail:data is null or nil", null));
      AppMethodBeat.o(180258);
      return;
    }
    Object localObject = paramc.getAppId();
    ad.i(TAG, "hy: appId:" + (String)localObject + ", parmas:" + paramJSONObject.toString());
    localObject = o.nQO;
    ((o)localObject).ae(new o.9((o)localObject, paramJSONObject, new b() {}));
    AppMethodBeat.o(180258);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.k.h
 * JD-Core Version:    0.7.0.1
 */