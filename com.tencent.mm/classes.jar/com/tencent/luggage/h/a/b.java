package com.tencent.luggage.h.a;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.l.a.a;
import com.tencent.mm.plugin.appbrand.jsapi.l.a.c;
import com.tencent.mm.plugin.appbrand.jsapi.l.a.f;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class b
  implements c
{
  public com.tencent.mm.plugin.appbrand.jsapi.l.a.b a(Context paramContext, String paramString, Map<String, Object> paramMap)
  {
    AppMethodBeat.i(146457);
    if (paramContext == null)
    {
      AppMethodBeat.o(146457);
      return null;
    }
    paramContext = new a(paramContext, paramString, paramMap);
    AppMethodBeat.o(146457);
    return paramContext;
  }
  
  public com.tencent.mm.plugin.appbrand.jsapi.l.a.b b(e parame, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(146456);
    if ((parame == null) || (paramJSONObject == null))
    {
      AppMethodBeat.o(146456);
      return null;
    }
    Context localContext = parame.getContext();
    String str2 = paramJSONObject.optString("theme", "");
    int i = paramJSONObject.optInt("mapType", 1);
    String str3 = paramJSONObject.optString("subKey", "");
    Object localObject = parame.getAppId();
    String str1 = paramJSONObject.optString("pluginId", "");
    if (!TextUtils.isEmpty(str1)) {
      localObject = str1;
    }
    for (;;)
    {
      int j = paramJSONObject.optInt("styleId", 0);
      parame = f.h(parame, paramJSONObject);
      int k = paramJSONObject.optInt("enableDarkMode", 0);
      paramJSONObject = new HashMap(5);
      paramJSONObject.put("theme", str2);
      paramJSONObject.put("mapType", Integer.valueOf(i));
      paramJSONObject.put("subKey", str3);
      paramJSONObject.put("subId", localObject);
      paramJSONObject.put("styleId", Integer.valueOf(j));
      paramJSONObject.put("enableDarkMode", Integer.valueOf(k));
      parame = new a(localContext, parame, paramJSONObject);
      AppMethodBeat.o(146456);
      return parame;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.h.a.b
 * JD-Core Version:    0.7.0.1
 */