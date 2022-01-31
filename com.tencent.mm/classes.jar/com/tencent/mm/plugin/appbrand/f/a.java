package com.tencent.mm.plugin.appbrand.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import org.json.JSONObject;

public final class a
{
  public static void a(boolean paramBoolean, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(117340);
    b(paramJSONObject, "useXWebVideo", Boolean.valueOf(paramBoolean));
    b(paramJSONObject, "XWebVideoMinVersion", Integer.valueOf(300));
    AppMethodBeat.o(117340);
  }
  
  private static void b(JSONObject paramJSONObject, String paramString, Object paramObject)
  {
    AppMethodBeat.i(117342);
    try
    {
      paramJSONObject.put(paramString, paramObject);
      AppMethodBeat.o(117342);
      return;
    }
    catch (Exception paramJSONObject)
    {
      ab.e("MicroMsg.SameLayer.AppBrandExtendPluginUtil", "build json object fail", new Object[] { paramJSONObject });
      AppMethodBeat.o(117342);
    }
  }
  
  public static void b(boolean paramBoolean, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(117341);
    b(paramJSONObject, "useXWebMap", Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(117341);
  }
  
  public static void c(boolean paramBoolean, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(154428);
    b(paramJSONObject, "useXWebCanvas", Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(154428);
  }
  
  public static void d(boolean paramBoolean, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(154429);
    b(paramJSONObject, "supportXWebTouch", Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(154429);
  }
  
  public static void e(boolean paramBoolean, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(140010);
    b(paramJSONObject, "useXWebLive", Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(140010);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.f.a
 * JD-Core Version:    0.7.0.1
 */