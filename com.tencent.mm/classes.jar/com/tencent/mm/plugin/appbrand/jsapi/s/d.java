package com.tencent.mm.plugin.appbrand.jsapi.s;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.t.a;
import com.tencent.mm.plugin.appbrand.t.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class d
  extends c
{
  public static final int CTRL_INDEX = 615;
  public static final String NAME = "checkNetworkAPIURL";
  
  public final void a(f paramf, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(144185);
    if (paramJSONObject == null)
    {
      paramf.callback(paramInt, ZP("fail:data nil"));
      Log.w("MicroMsg.JsApiCheckNetworkAPIURL", "data is null");
      AppMethodBeat.o(144185);
      return;
    }
    HashMap localHashMap = new HashMap();
    String str = paramJSONObject.optString("api", "");
    paramJSONObject = paramJSONObject.optString("url", "");
    if ((Util.isNullOrNil(str)) || (Util.isNullOrNil(paramJSONObject)))
    {
      Log.w("MicroMsg.JsApiCheckNetworkAPIURL", "invalid api:%s,url:%s", new Object[] { str, paramJSONObject });
      localHashMap.put("isValid", Boolean.FALSE);
      paramf.callback(paramInt, m("fail:api or url invalid", localHashMap));
      AppMethodBeat.o(144185);
      return;
    }
    Object localObject = (a)paramf.aN(a.class);
    boolean bool;
    if (str.equalsIgnoreCase("request"))
    {
      bool = i.b(((a)localObject).epU, paramJSONObject, false);
      localObject = (String)i.aed(paramJSONObject).get("host");
      if (Util.isNullOrNil((String)localObject)) {
        break label599;
      }
      Log.i("MicroMsg.JsApiCheckNetworkAPIURL", "ipHost:%s", new Object[] { localObject });
    }
    label266:
    label599:
    for (int i = i.aef((String)localObject);; i = 0)
    {
      Log.i("MicroMsg.JsApiCheckNetworkAPIURL", "checkRet:%b,ipCheckRet:%d,api:%s,url:%s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i), str, paramJSONObject });
      if (bool)
      {
        localHashMap.put("isInDomainList", Boolean.TRUE);
        switch (i)
        {
        }
      }
      for (;;)
      {
        paramf.callback(paramInt, m("ok", localHashMap));
        AppMethodBeat.o(144185);
        return;
        if (str.equalsIgnoreCase("websocket"))
        {
          bool = i.b(((a)localObject).epV, paramJSONObject, ((a)localObject).epM);
          break;
        }
        if (str.equalsIgnoreCase("downloadFile"))
        {
          bool = i.b(((a)localObject).epX, paramJSONObject, false);
          break;
        }
        if (str.equalsIgnoreCase("uploadFile"))
        {
          bool = i.b(((a)localObject).epW, paramJSONObject, false);
          break;
        }
        if (str.equalsIgnoreCase("udp"))
        {
          bool = i.b(((a)localObject).epY, paramJSONObject, false);
          break;
        }
        if (str.equalsIgnoreCase("tcp"))
        {
          bool = i.b(((a)localObject).epZ, paramJSONObject, false);
          break;
        }
        Log.w("MicroMsg.JsApiCheckNetworkAPIURL", "hy: unknown api: %s", new Object[] { str });
        localHashMap.put("isValid", Boolean.FALSE);
        paramf.callback(paramInt, m("fail:unknow api", localHashMap));
        AppMethodBeat.o(144185);
        return;
        localHashMap.put("isInDomainList", Boolean.FALSE);
        break label266;
        localHashMap.put("isInLAN", Boolean.FALSE);
        localHashMap.put("isLocalHost", Boolean.FALSE);
        continue;
        localHashMap.put("isInLAN", Boolean.TRUE);
        localHashMap.put("isLocalHost", Boolean.TRUE);
        continue;
        localHashMap.put("isInLAN", Boolean.TRUE);
        localHashMap.put("isLocalHost", Boolean.FALSE);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.s.d
 * JD-Core Version:    0.7.0.1
 */