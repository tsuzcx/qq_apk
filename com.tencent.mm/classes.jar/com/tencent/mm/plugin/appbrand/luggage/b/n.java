package com.tencent.mm.plugin.appbrand.luggage.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.wx_extension.a.a;
import com.tencent.mm.ipcinvoker.wx_extension.a.a.a;
import com.tencent.mm.plugin.appbrand.jsapi.f.a.f;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.aj;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class n
  extends com.tencent.luggage.f.a.b
{
  public static Integer lqO;
  
  private static int getMapType()
  {
    AppMethodBeat.i(47493);
    if (lqO != null)
    {
      i = lqO.intValue();
      AppMethodBeat.o(47493);
      return i;
    }
    Object localObject = a.a.geG;
    localObject = a.tJ("100487");
    if ((localObject == null) || (!((com.tencent.mm.storage.c)localObject).isValid()))
    {
      ac.i("MicroMsg.WxaMapViewFactory", "[sMapType] item is null");
      AppMethodBeat.o(47493);
      return 1;
    }
    lqO = Integer.valueOf(bs.getInt((String)((com.tencent.mm.storage.c)localObject).eYV().get("MapType"), 1));
    ac.i("MicroMsg.WxaMapViewFactory", "sMapType:%d", new Object[] { lqO });
    int i = lqO.intValue();
    AppMethodBeat.o(47493);
    return i;
  }
  
  public final com.tencent.mm.plugin.appbrand.jsapi.f.a.b a(Context paramContext, String paramString, Map<String, Object> paramMap)
  {
    int i = 0;
    AppMethodBeat.i(47495);
    if (paramContext == null)
    {
      AppMethodBeat.o(47495);
      return null;
    }
    int k = f.a(paramMap, "mapType", getMapType());
    int j = f.a(paramMap, "enableDarkMode", 0);
    if (!aj.DT()) {}
    for (;;)
    {
      paramMap.put("enableDarkMode", Integer.valueOf(i));
      if (k == 2)
      {
        paramContext = new com.tencent.mm.plugin.appbrand.jsapi.z.d.b(paramContext, paramString, paramMap);
        AppMethodBeat.o(47495);
        return paramContext;
      }
      paramContext = super.a(paramContext, paramString, paramMap);
      AppMethodBeat.o(47495);
      return paramContext;
      i = j;
    }
  }
  
  public final com.tencent.mm.plugin.appbrand.jsapi.f.a.b b(com.tencent.mm.plugin.appbrand.jsapi.c paramc, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(47494);
    if (paramJSONObject != null) {}
    for (;;)
    {
      try
      {
        paramJSONObject.put("mapType", getMapType());
        bool = paramJSONObject.optBoolean("enableDarkMode", false);
        if (aj.DT()) {
          continue;
        }
        bool = false;
      }
      catch (JSONException localJSONException)
      {
        boolean bool;
        ac.m("MicroMsg.WxaMapViewFactory", "", new Object[] { localJSONException });
        continue;
        if (!bool) {
          continue;
        }
        int i = 1;
        continue;
      }
      paramJSONObject.put("enableDarkMode", i);
      paramc = super.b(paramc, paramJSONObject);
      AppMethodBeat.o(47494);
      return paramc;
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.b.n
 * JD-Core Version:    0.7.0.1
 */