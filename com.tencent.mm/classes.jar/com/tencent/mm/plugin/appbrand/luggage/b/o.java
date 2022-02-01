package com.tencent.mm.plugin.appbrand.luggage.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.wx_extension.a.a;
import com.tencent.mm.ipcinvoker.wx_extension.a.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.c;
import com.tencent.mm.ui.ao;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class o
  extends com.tencent.luggage.f.a.b
{
  public static Integer nan;
  
  private static int getMapType()
  {
    AppMethodBeat.i(47493);
    if (nan != null)
    {
      i = nan.intValue();
      AppMethodBeat.o(47493);
      return i;
    }
    Object localObject = a.a.hnM;
    localObject = a.Fu("100487");
    if ((localObject == null) || (!((c)localObject).isValid()))
    {
      Log.i("MicroMsg.WxaMapViewFactory", "[sMapType] item is null");
      AppMethodBeat.o(47493);
      return 1;
    }
    nan = Integer.valueOf(Util.getInt((String)((c)localObject).gzz().get("MapType"), 1));
    Log.i("MicroMsg.WxaMapViewFactory", "sMapType:%d", new Object[] { nan });
    int i = nan.intValue();
    AppMethodBeat.o(47493);
    return i;
  }
  
  public final com.tencent.mm.plugin.appbrand.jsapi.k.a.b a(Context paramContext, String paramString, Map<String, Object> paramMap)
  {
    int i = 0;
    AppMethodBeat.i(47495);
    if (paramContext == null)
    {
      AppMethodBeat.o(47495);
      return null;
    }
    int k = com.tencent.mm.plugin.appbrand.jsapi.k.a.f.a(paramMap, "mapType", getMapType());
    int j = com.tencent.mm.plugin.appbrand.jsapi.k.a.f.a(paramMap, "enableDarkMode", 0);
    if (!ao.isDarkMode()) {}
    for (;;)
    {
      paramMap.put("enableDarkMode", Integer.valueOf(i));
      if (k == 2)
      {
        paramContext = new com.tencent.mm.plugin.appbrand.jsapi.ag.d.b(paramContext, paramString, paramMap);
        AppMethodBeat.o(47495);
        return paramContext;
      }
      paramContext = super.a(paramContext, paramString, paramMap);
      AppMethodBeat.o(47495);
      return paramContext;
      i = j;
    }
  }
  
  public final com.tencent.mm.plugin.appbrand.jsapi.k.a.b b(com.tencent.mm.plugin.appbrand.jsapi.f paramf, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(47494);
    if (paramJSONObject != null) {}
    for (;;)
    {
      try
      {
        paramJSONObject.put("mapType", getMapType());
        bool = paramJSONObject.optBoolean("enableDarkMode", false);
        if (ao.isDarkMode()) {
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
      paramf = super.b(paramf, paramJSONObject);
      AppMethodBeat.o(47494);
      return paramf;
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.b.o
 * JD-Core Version:    0.7.0.1
 */