package com.tencent.mm.plugin.appbrand.jsapi.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.m.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class c
  extends com.tencent.mm.plugin.appbrand.jsapi.a
{
  public static final int CTRL_INDEX = 615;
  public static final String NAME = "checkNetworkAPIURL";
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(108020);
    if (paramJSONObject == null)
    {
      paramc.h(paramInt, j("fail:data nil", null));
      ab.w("MicroMsg.JsApiCheckNetworkAPIURL", "data is null");
      AppMethodBeat.o(108020);
      return;
    }
    HashMap localHashMap = new HashMap();
    String str = paramJSONObject.optString("api", "");
    paramJSONObject = paramJSONObject.optString("url", "");
    if ((bo.isNullOrNil(str)) || (bo.isNullOrNil(paramJSONObject)))
    {
      ab.w("MicroMsg.JsApiCheckNetworkAPIURL", "invalid api:%s,url:%s", new Object[] { str, paramJSONObject });
      localHashMap.put("isValid", Boolean.FALSE);
      paramc.h(paramInt, j("fail:api or url invalid", localHashMap));
      AppMethodBeat.o(108020);
      return;
    }
    Object localObject = (com.tencent.mm.plugin.appbrand.m.a)paramc.U(com.tencent.mm.plugin.appbrand.m.a.class);
    boolean bool;
    if (str.equalsIgnoreCase("request"))
    {
      bool = j.b(((com.tencent.mm.plugin.appbrand.m.a)localObject).bDz, paramJSONObject, false);
      localObject = (String)j.DV(paramJSONObject).get("host");
      if (bo.isNullOrNil((String)localObject)) {
        break label558;
      }
      ab.i("MicroMsg.JsApiCheckNetworkAPIURL", "ipHost:%s", new Object[] { localObject });
    }
    label267:
    label558:
    for (int i = j.DX((String)localObject);; i = 0)
    {
      ab.i("MicroMsg.JsApiCheckNetworkAPIURL", "checkRet:%b,ipCheckRet:%d,api:%s,url:%s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i), str, paramJSONObject });
      if (bool)
      {
        localHashMap.put("isInDomainList", Boolean.TRUE);
        switch (i)
        {
        }
      }
      for (;;)
      {
        paramc.h(paramInt, j("ok", localHashMap));
        AppMethodBeat.o(108020);
        return;
        if (str.equalsIgnoreCase("websocket"))
        {
          bool = j.b(((com.tencent.mm.plugin.appbrand.m.a)localObject).bDA, paramJSONObject, ((com.tencent.mm.plugin.appbrand.m.a)localObject).bDv);
          break;
        }
        if (str.equalsIgnoreCase("downloadFile"))
        {
          bool = j.b(((com.tencent.mm.plugin.appbrand.m.a)localObject).bDC, paramJSONObject, false);
          break;
        }
        if (str.equalsIgnoreCase("uploadFile"))
        {
          bool = j.b(((com.tencent.mm.plugin.appbrand.m.a)localObject).bDB, paramJSONObject, false);
          break;
        }
        if (str.equalsIgnoreCase("udp"))
        {
          bool = j.b(((com.tencent.mm.plugin.appbrand.m.a)localObject).bDD, paramJSONObject, false);
          break;
        }
        localHashMap.put("isValid", Boolean.FALSE);
        paramc.h(paramInt, j("fail:unknow api", localHashMap));
        AppMethodBeat.o(108020);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.j.c
 * JD-Core Version:    0.7.0.1
 */