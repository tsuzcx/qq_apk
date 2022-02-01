package com.tencent.mm.plugin.appbrand.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import org.json.JSONObject;

public final class a
{
  public static void a(boolean paramBoolean, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(139373);
    c(paramJSONObject, "useXWebVideo", Boolean.valueOf(paramBoolean));
    c(paramJSONObject, "XWebVideoMinVersion", Integer.valueOf(300));
    AppMethodBeat.o(139373);
  }
  
  public static void b(boolean paramBoolean, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(139374);
    c(paramJSONObject, "useXWebMap", Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(139374);
  }
  
  private static void c(JSONObject paramJSONObject, String paramString, Object paramObject)
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
      ae.e("MicroMsg.SameLayer.AppBrandExtendPluginUtil", "build json object fail", new Object[] { paramJSONObject });
      AppMethodBeat.o(139381);
    }
  }
  
  public static void c(boolean paramBoolean, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(139376);
    c(paramJSONObject, "useXWebTextarea", Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(139376);
  }
  
  public static void d(boolean paramBoolean, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(139377);
    c(paramJSONObject, "supportXWebTextarea", Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(139377);
  }
  
  public static void e(boolean paramBoolean, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(139378);
    c(paramJSONObject, "supportXWebTouch", Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(139378);
  }
  
  public static void f(boolean paramBoolean, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(139379);
    c(paramJSONObject, "useXWebLive", Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(139379);
  }
  
  public static void g(boolean paramBoolean, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(139380);
    c(paramJSONObject, "useXWebCamera", Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(139380);
  }
  
  public static void h(boolean paramBoolean, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(220548);
    c(paramJSONObject, "abtestXWebCameraEnable", Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(220548);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.h.a
 * JD-Core Version:    0.7.0.1
 */