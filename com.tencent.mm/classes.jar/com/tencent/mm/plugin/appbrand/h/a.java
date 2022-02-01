package com.tencent.mm.plugin.appbrand.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public final class a
{
  public static void a(boolean paramBoolean, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(139373);
    d(paramJSONObject, "useXWebVideo", Boolean.valueOf(paramBoolean));
    d(paramJSONObject, "XWebVideoMinVersion", Integer.valueOf(300));
    AppMethodBeat.o(139373);
  }
  
  public static void b(boolean paramBoolean, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(139374);
    d(paramJSONObject, "useXWebMap", Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(139374);
  }
  
  public static void c(boolean paramBoolean, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(139376);
    d(paramJSONObject, "useXWebTextarea", Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(139376);
  }
  
  private static void d(JSONObject paramJSONObject, String paramString, Object paramObject)
  {
    AppMethodBeat.i(139381);
    try
    {
      paramJSONObject.put(paramString, paramObject);
      AppMethodBeat.o(139381);
      return;
    }
    catch (Exception paramJSONObject)
    {
      Log.e("MicroMsg.SameLayer.AppBrandExtendPluginUtil", "build json object fail", new Object[] { paramJSONObject });
      AppMethodBeat.o(139381);
    }
  }
  
  public static void d(boolean paramBoolean, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(139377);
    d(paramJSONObject, "supportXWebTextarea", Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(139377);
  }
  
  public static void e(boolean paramBoolean, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(139378);
    d(paramJSONObject, "supportXWebTouch", Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(139378);
  }
  
  public static void f(boolean paramBoolean, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(139379);
    d(paramJSONObject, "useXWebLive", Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(139379);
  }
  
  public static void g(boolean paramBoolean, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(139380);
    d(paramJSONObject, "useXWebCamera", Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(139380);
  }
  
  public static void h(boolean paramBoolean, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(316830);
    d(paramJSONObject, "abtestXWebCameraEnable", Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(316830);
  }
  
  public static void i(boolean paramBoolean, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(316834);
    d(paramJSONObject, "useXWebVoipRoom", Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(316834);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.h.a
 * JD-Core Version:    0.7.0.1
 */