package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandVideoAutogirationParseHelper;", "", "()V", "IS_AUTOGIRATION_DEFAULT", "", "IS_AUTOGIRATION_KEY", "", "isAutogiration", "dataJsonObj", "Lorg/json/JSONObject;", "(Lorg/json/JSONObject;)Ljava/lang/Boolean;", "luggage-wxa-app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ac
{
  public static final ac rwL;
  
  static
  {
    AppMethodBeat.i(135570);
    rwL = new ac();
    AppMethodBeat.o(135570);
  }
  
  public static final Boolean Z(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(178663);
    s.u(paramJSONObject, "dataJsonObj");
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
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ac
 * JD-Core Version:    0.7.0.1
 */