package com.tencent.mm.plugin.appbrand.jsapi.p;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.o;
import com.tencent.mm.plugin.appbrand.s.a;
import com.tencent.mm.plugin.appbrand.s.j;
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
  
  public final void a(e parame, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(144185);
    if (paramJSONObject == null)
    {
      parame.j(paramInt, h("fail:data nil", null));
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
      parame.j(paramInt, m("fail:api or url invalid", localHashMap));
      AppMethodBeat.o(144185);
      return;
    }
    Object localObject = (a)parame.au(a.class);
    boolean bool;
    if (str.equalsIgnoreCase("request"))
    {
      bool = j.b(((a)localObject).cxA, paramJSONObject, false);
      localObject = (String)j.akW(paramJSONObject).get("host");
      if (Util.isNullOrNil((String)localObject)) {
        break label599;
      }
      Log.i("MicroMsg.JsApiCheckNetworkAPIURL", "ipHost:%s", new Object[] { localObject });
    }
    label267:
    label599:
    for (int i = j.akY((String)localObject);; i = 0)
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
        parame.j(paramInt, m("ok", localHashMap));
        AppMethodBeat.o(144185);
        return;
        if (str.equalsIgnoreCase("websocket"))
        {
          bool = j.b(((a)localObject).cxB, paramJSONObject, ((a)localObject).cxu);
          break;
        }
        if (str.equalsIgnoreCase("downloadFile"))
        {
          bool = j.b(((a)localObject).cxD, paramJSONObject, false);
          break;
        }
        if (str.equalsIgnoreCase("uploadFile"))
        {
          bool = j.b(((a)localObject).cxC, paramJSONObject, false);
          break;
        }
        if (str.equalsIgnoreCase("udp"))
        {
          bool = j.b(((a)localObject).cxE, paramJSONObject, false);
          break;
        }
        if (str.equalsIgnoreCase("tcp"))
        {
          bool = j.b(((a)localObject).cxF, paramJSONObject, false);
          break;
        }
        Log.w("MicroMsg.JsApiCheckNetworkAPIURL", "hy: unknown api: %s", new Object[] { str });
        localHashMap.put("isValid", Boolean.FALSE);
        parame.j(paramInt, m("fail:unknow api", localHashMap));
        AppMethodBeat.o(144185);
        return;
        localHashMap.put("isInDomainList", Boolean.FALSE);
        break label267;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.p.d
 * JD-Core Version:    0.7.0.1
 */