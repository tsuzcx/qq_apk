package com.tencent.luggage.f.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.a;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.f;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class b
  implements com.tencent.mm.plugin.appbrand.jsapi.g.a.c
{
  public com.tencent.mm.plugin.appbrand.jsapi.g.a.b a(Context paramContext, String paramString, Map<String, Object> paramMap)
  {
    AppMethodBeat.i(51148);
    if (paramContext == null)
    {
      AppMethodBeat.o(51148);
      return null;
    }
    paramContext = new a(paramContext, paramString, paramMap);
    AppMethodBeat.o(51148);
    return paramContext;
  }
  
  public com.tencent.mm.plugin.appbrand.jsapi.g.a.b b(com.tencent.mm.plugin.appbrand.jsapi.c paramc, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(51147);
    if ((paramc == null) || (paramJSONObject == null))
    {
      AppMethodBeat.o(51147);
      return null;
    }
    Context localContext = paramc.getContext();
    String str1 = paramJSONObject.optString("theme", "");
    int i = paramJSONObject.optInt("mapType", 1);
    String str2 = paramJSONObject.optString("subKey", "");
    String str3 = paramc.getAppId();
    int j = paramJSONObject.optInt("styleId", 0);
    paramc = f.g(paramc, paramJSONObject);
    paramJSONObject = new HashMap(5);
    paramJSONObject.put("theme", str1);
    paramJSONObject.put("mapType", Integer.valueOf(i));
    paramJSONObject.put("subKey", str2);
    paramJSONObject.put("subId", str3);
    paramJSONObject.put("styleId", Integer.valueOf(j));
    paramc = new a(localContext, paramc, paramJSONObject);
    AppMethodBeat.o(51147);
    return paramc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.luggage.f.a.b
 * JD-Core Version:    0.7.0.1
 */