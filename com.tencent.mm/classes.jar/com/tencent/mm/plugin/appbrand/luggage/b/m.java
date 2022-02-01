package com.tencent.mm.plugin.appbrand.luggage.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.ipcinvoker.wx_extension.a.a;
import com.tencent.mm.ipcinvoker.wx_extension.a.a.a;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.c;
import com.tencent.mm.ui.aw;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class m
  extends com.tencent.luggage.i.a.b
{
  public static Integer tfI;
  private boolean tfH = false;
  
  private static boolean cBg()
  {
    AppMethodBeat.i(319873);
    IPCBoolean localIPCBoolean = (IPCBoolean)XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, null, m.a.class);
    if (localIPCBoolean == null) {}
    for (boolean bool = false;; bool = localIPCBoolean.value)
    {
      Log.i("MicroMsg.WxaMapViewFactory", "isOverseasUserFromMainTask:%b", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(319873);
      return bool;
    }
  }
  
  private static int getMapType()
  {
    AppMethodBeat.i(47493);
    if (tfI != null)
    {
      i = tfI.intValue();
      AppMethodBeat.o(47493);
      return i;
    }
    Object localObject = a.a.mzH;
    localObject = a.Fd("100487");
    if ((localObject == null) || (!((c)localObject).isValid()))
    {
      Log.i("MicroMsg.WxaMapViewFactory", "[sMapType] item is null");
      AppMethodBeat.o(47493);
      return 1;
    }
    tfI = Integer.valueOf(Util.getInt((String)((c)localObject).iWZ().get("MapType"), 1));
    Log.i("MicroMsg.WxaMapViewFactory", "sMapType:%d", new Object[] { tfI });
    int i = tfI.intValue();
    AppMethodBeat.o(47493);
    return i;
  }
  
  public final com.tencent.mm.plugin.appbrand.jsapi.o.a.b a(Context paramContext, String paramString, Map<String, Object> paramMap)
  {
    int i = 0;
    AppMethodBeat.i(47495);
    if (paramContext == null)
    {
      AppMethodBeat.o(47495);
      return null;
    }
    int k = com.tencent.mm.plugin.appbrand.jsapi.o.a.f.a(paramMap, "mapType", getMapType());
    int j = com.tencent.mm.plugin.appbrand.jsapi.o.a.f.a(paramMap, "enableDarkMode", 0);
    if (!aw.isDarkMode()) {}
    for (;;)
    {
      paramMap.put("enableDarkMode", Integer.valueOf(i));
      paramMap.put("isOverseasUser", Boolean.valueOf(isOverseasUser()));
      if (k == 2)
      {
        paramContext = new com.tencent.mm.plugin.appbrand.jsapi.al.d.b(paramContext, paramString, paramMap);
        AppMethodBeat.o(47495);
        return paramContext;
      }
      paramContext = super.a(paramContext, paramString, paramMap);
      AppMethodBeat.o(47495);
      return paramContext;
      i = j;
    }
  }
  
  public final com.tencent.mm.plugin.appbrand.jsapi.o.a.b b(com.tencent.mm.plugin.appbrand.jsapi.f paramf, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(47494);
    if (paramJSONObject != null) {}
    for (;;)
    {
      try
      {
        paramJSONObject.put("mapType", getMapType());
        bool = paramJSONObject.optBoolean("enableDarkMode", false);
        if (aw.isDarkMode()) {
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
  
  public final boolean isOverseasUser()
  {
    AppMethodBeat.i(319894);
    if (this.tfH)
    {
      AppMethodBeat.o(319894);
      return true;
    }
    this.tfH = cBg();
    boolean bool = this.tfH;
    AppMethodBeat.o(319894);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.b.m
 * JD-Core Version:    0.7.0.1
 */