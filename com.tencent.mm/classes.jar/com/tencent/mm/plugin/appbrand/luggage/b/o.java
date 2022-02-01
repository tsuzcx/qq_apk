package com.tencent.mm.plugin.appbrand.luggage.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.wx_extension.a.a;
import com.tencent.mm.ipcinvoker.wx_extension.a.a.a;
import com.tencent.mm.plugin.appbrand.jsapi.i.a.f;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.al;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class o
  extends com.tencent.luggage.f.a.b
{
  public static Integer lSM;
  
  private static int getMapType()
  {
    AppMethodBeat.i(47493);
    if (lSM != null)
    {
      i = lSM.intValue();
      AppMethodBeat.o(47493);
      return i;
    }
    Object localObject = a.a.gAX;
    localObject = a.xi("100487");
    if ((localObject == null) || (!((com.tencent.mm.storage.c)localObject).isValid()))
    {
      ae.i("MicroMsg.WxaMapViewFactory", "[sMapType] item is null");
      AppMethodBeat.o(47493);
      return 1;
    }
    lSM = Integer.valueOf(bu.getInt((String)((com.tencent.mm.storage.c)localObject).fsy().get("MapType"), 1));
    ae.i("MicroMsg.WxaMapViewFactory", "sMapType:%d", new Object[] { lSM });
    int i = lSM.intValue();
    AppMethodBeat.o(47493);
    return i;
  }
  
  public final com.tencent.mm.plugin.appbrand.jsapi.i.a.b a(Context paramContext, String paramString, Map<String, Object> paramMap)
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
    if (!al.isDarkMode()) {}
    for (;;)
    {
      paramMap.put("enableDarkMode", Integer.valueOf(i));
      if (k == 2)
      {
        paramContext = new com.tencent.mm.plugin.appbrand.jsapi.ad.d.b(paramContext, paramString, paramMap);
        AppMethodBeat.o(47495);
        return paramContext;
      }
      paramContext = super.a(paramContext, paramString, paramMap);
      AppMethodBeat.o(47495);
      return paramContext;
      i = j;
    }
  }
  
  public final com.tencent.mm.plugin.appbrand.jsapi.i.a.b b(com.tencent.mm.plugin.appbrand.jsapi.c paramc, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(47494);
    if (paramJSONObject != null) {}
    for (;;)
    {
      try
      {
        paramJSONObject.put("mapType", getMapType());
        bool = paramJSONObject.optBoolean("enableDarkMode", false);
        if (al.isDarkMode()) {
          continue;
        }
        bool = false;
      }
      catch (JSONException localJSONException)
      {
        boolean bool;
        ae.m("MicroMsg.WxaMapViewFactory", "", new Object[] { localJSONException });
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.b.o
 * JD-Core Version:    0.7.0.1
 */