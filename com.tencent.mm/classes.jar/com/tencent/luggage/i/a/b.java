package com.tencent.luggage.i.a;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.o.a.a;
import com.tencent.mm.plugin.appbrand.jsapi.o.a.c;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class b
  implements c
{
  public com.tencent.mm.plugin.appbrand.jsapi.o.a.b a(Context paramContext, String paramString, Map<String, Object> paramMap)
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
  
  public com.tencent.mm.plugin.appbrand.jsapi.o.a.b b(com.tencent.mm.plugin.appbrand.jsapi.f paramf, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(146456);
    if ((paramf == null) || (paramJSONObject == null))
    {
      AppMethodBeat.o(146456);
      return null;
    }
    Context localContext = paramf.getContext();
    String str2 = paramJSONObject.optString("theme", "");
    int i = paramJSONObject.optInt("mapType", 1);
    String str3 = paramJSONObject.optString("subKey", "");
    Object localObject = paramf.getAppId();
    String str1 = paramJSONObject.optString("pluginId", "");
    if (!TextUtils.isEmpty(str1)) {
      localObject = str1;
    }
    for (;;)
    {
      int j = paramJSONObject.optInt("styleId", 0);
      paramf = com.tencent.mm.plugin.appbrand.jsapi.o.a.f.h(paramf, paramJSONObject);
      int k = paramJSONObject.optInt("enableDarkMode", 0);
      paramJSONObject = new HashMap(5);
      paramJSONObject.put("theme", str2);
      paramJSONObject.put("mapType", Integer.valueOf(i));
      paramJSONObject.put("subKey", str3);
      paramJSONObject.put("subId", localObject);
      paramJSONObject.put("styleId", Integer.valueOf(j));
      paramJSONObject.put("enableDarkMode", Integer.valueOf(k));
      paramJSONObject.put("isOverseasUser", Boolean.valueOf(isOverseasUser()));
      paramf = new a(localContext, paramf, paramJSONObject);
      AppMethodBeat.o(146456);
      return paramf;
    }
  }
  
  public boolean isOverseasUser()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.luggage.i.a.b
 * JD-Core Version:    0.7.0.1
 */