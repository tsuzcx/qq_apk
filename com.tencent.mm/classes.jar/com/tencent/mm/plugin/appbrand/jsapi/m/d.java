package com.tencent.mm.plugin.appbrand.jsapi.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.o.j;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class d
  extends com.tencent.mm.plugin.appbrand.jsapi.a
{
  public static final int CTRL_INDEX = 615;
  public static final String NAME = "checkNetworkAPIURL";
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(144185);
    if (paramJSONObject == null)
    {
      paramc.h(paramInt, e("fail:data nil", null));
      ae.w("MicroMsg.JsApiCheckNetworkAPIURL", "data is null");
      AppMethodBeat.o(144185);
      return;
    }
    HashMap localHashMap = new HashMap();
    String str = paramJSONObject.optString("api", "");
    paramJSONObject = paramJSONObject.optString("url", "");
    if ((bu.isNullOrNil(str)) || (bu.isNullOrNil(paramJSONObject)))
    {
      ae.w("MicroMsg.JsApiCheckNetworkAPIURL", "invalid api:%s,url:%s", new Object[] { str, paramJSONObject });
      localHashMap.put("isValid", Boolean.FALSE);
      paramc.h(paramInt, n("fail:api or url invalid", localHashMap));
      AppMethodBeat.o(144185);
      return;
    }
    Object localObject = (com.tencent.mm.plugin.appbrand.o.a)paramc.ar(com.tencent.mm.plugin.appbrand.o.a.class);
    boolean bool;
    if (str.equalsIgnoreCase("request"))
    {
      bool = j.b(((com.tencent.mm.plugin.appbrand.o.a)localObject).cmX, paramJSONObject, false);
      localObject = (String)j.Ty(paramJSONObject).get("host");
      if (bu.isNullOrNil((String)localObject)) {
        break label574;
      }
      ae.i("MicroMsg.JsApiCheckNetworkAPIURL", "ipHost:%s", new Object[] { localObject });
    }
    label267:
    label574:
    for (int i = j.TA((String)localObject);; i = 0)
    {
      ae.i("MicroMsg.JsApiCheckNetworkAPIURL", "checkRet:%b,ipCheckRet:%d,api:%s,url:%s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i), str, paramJSONObject });
      if (bool)
      {
        localHashMap.put("isInDomainList", Boolean.TRUE);
        switch (i)
        {
        }
      }
      for (;;)
      {
        paramc.h(paramInt, n("ok", localHashMap));
        AppMethodBeat.o(144185);
        return;
        if (str.equalsIgnoreCase("websocket"))
        {
          bool = j.b(((com.tencent.mm.plugin.appbrand.o.a)localObject).cmY, paramJSONObject, ((com.tencent.mm.plugin.appbrand.o.a)localObject).cmT);
          break;
        }
        if (str.equalsIgnoreCase("downloadFile"))
        {
          bool = j.b(((com.tencent.mm.plugin.appbrand.o.a)localObject).cna, paramJSONObject, false);
          break;
        }
        if (str.equalsIgnoreCase("uploadFile"))
        {
          bool = j.b(((com.tencent.mm.plugin.appbrand.o.a)localObject).cmZ, paramJSONObject, false);
          break;
        }
        if (str.equalsIgnoreCase("udp"))
        {
          bool = j.b(((com.tencent.mm.plugin.appbrand.o.a)localObject).cnb, paramJSONObject, false);
          break;
        }
        ae.w("MicroMsg.JsApiCheckNetworkAPIURL", "hy: unknown api: %s", new Object[] { str });
        localHashMap.put("isValid", Boolean.FALSE);
        paramc.h(paramInt, n("fail:unknow api", localHashMap));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.m.d
 * JD-Core Version:    0.7.0.1
 */