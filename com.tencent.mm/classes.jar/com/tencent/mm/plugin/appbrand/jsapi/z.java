package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l;
import org.json.JSONObject;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandVideoAutogirationParseHelper;", "", "()V", "IS_AUTOGIRATION_DEFAULT", "", "IS_AUTOGIRATION_KEY", "", "isAutogiration", "dataJsonObj", "Lorg/json/JSONObject;", "(Lorg/json/JSONObject;)Ljava/lang/Boolean;", "luggage-wxa-app_release"})
public final class z
{
  public static final z jwi;
  
  static
  {
    AppMethodBeat.i(135570);
    jwi = new z();
    AppMethodBeat.o(135570);
  }
  
  public static final Boolean D(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(178663);
    k.h(paramJSONObject, "dataJsonObj");
    if (paramJSONObject.has("autoRotation"))
    {
      boolean bool = paramJSONObject.optBoolean("autoRotation", false);
      AppMethodBeat.o(178663);
      return Boolean.valueOf(bool);
    }
    AppMethodBeat.o(178663);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.z
 * JD-Core Version:    0.7.0.1
 */