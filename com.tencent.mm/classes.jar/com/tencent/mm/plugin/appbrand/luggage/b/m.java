package com.tencent.mm.plugin.appbrand.luggage.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.wx_extension.a.a;
import com.tencent.mm.ipcinvoker.wx_extension.a.a.a;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.l.a.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.c;
import com.tencent.mm.ui.ar;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class m
  extends com.tencent.luggage.h.a.b
{
  public static Integer qaC;
  
  private static int getMapType()
  {
    AppMethodBeat.i(47493);
    if (qaC != null)
    {
      i = qaC.intValue();
      AppMethodBeat.o(47493);
      return i;
    }
    Object localObject = a.a.jZD;
    localObject = a.Mu("100487");
    if ((localObject == null) || (!((c)localObject).isValid()))
    {
      Log.i("MicroMsg.WxaMapViewFactory", "[sMapType] item is null");
      AppMethodBeat.o(47493);
      return 1;
    }
    qaC = Integer.valueOf(Util.getInt((String)((c)localObject).hvz().get("MapType"), 1));
    Log.i("MicroMsg.WxaMapViewFactory", "sMapType:%d", new Object[] { qaC });
    int i = qaC.intValue();
    AppMethodBeat.o(47493);
    return i;
  }
  
  public final com.tencent.mm.plugin.appbrand.jsapi.l.a.b a(Context paramContext, String paramString, Map<String, Object> paramMap)
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
    if (!ar.isDarkMode()) {}
    for (;;)
    {
      paramMap.put("enableDarkMode", Integer.valueOf(i));
      if (k == 2)
      {
        paramContext = new com.tencent.mm.plugin.appbrand.jsapi.ai.d.b(paramContext, paramString, paramMap);
        AppMethodBeat.o(47495);
        return paramContext;
      }
      paramContext = super.a(paramContext, paramString, paramMap);
      AppMethodBeat.o(47495);
      return paramContext;
      i = j;
    }
  }
  
  public final com.tencent.mm.plugin.appbrand.jsapi.l.a.b b(e parame, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(47494);
    if (paramJSONObject != null) {}
    for (;;)
    {
      try
      {
        paramJSONObject.put("mapType", getMapType());
        bool = paramJSONObject.optBoolean("enableDarkMode", false);
        if (ar.isDarkMode()) {
          continue;
        }
        bool = false;
      }
      catch (JSONException localJSONException)
      {
        boolean bool;
        Log.printInfoStack("MicroMsg.WxaMapViewFactory", "", new Object[] { localJSONException });
        continue;
        if (!bool) {
          continue;
        }
        int i = 1;
        continue;
      }
      paramJSONObject.put("enableDarkMode", i);
      parame = super.b(parame, paramJSONObject);
      AppMethodBeat.o(47494);
      return parame;
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.b.m
 * JD-Core Version:    0.7.0.1
 */