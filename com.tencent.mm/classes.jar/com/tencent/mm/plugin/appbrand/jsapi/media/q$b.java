package com.tencent.mm.plugin.appbrand.jsapi.media;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/media/MediaConstants$MediaEnum;", "", "flag", "", "getFlag", "()I", "name", "", "getName", "()Ljava/lang/String;", "contains", "", "flags", "equals", "Parser", "plugin-appbrand-integration_release"})
public abstract interface q$b
{
  public static final b pcn = b.pco;
  
  public abstract int getFlag();
  
  public abstract String getName();
  
  @l(iBK={1, 1, 16})
  public static final class a
  {
    public static boolean a(q.b paramb, int paramInt)
    {
      AppMethodBeat.i(50569);
      if (paramInt == paramb.getFlag())
      {
        AppMethodBeat.o(50569);
        return true;
      }
      AppMethodBeat.o(50569);
      return false;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/media/MediaConstants$MediaEnum$Parser;", "", "()V", "parse", "", "json", "Lorg/json/JSONObject;", "field", "", "default", "enums", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/media/MediaConstants$MediaEnum;", "(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;[Lcom/tencent/mm/plugin/appbrand/jsapi/media/MediaConstants$MediaEnum;)I", "plugin-appbrand-integration_release"})
  public static final class b
  {
    static
    {
      AppMethodBeat.i(50571);
      pco = new b();
      AppMethodBeat.o(50571);
    }
    
    public static int a(JSONObject paramJSONObject, String paramString1, String paramString2, q.b[] paramArrayOfb)
    {
      AppMethodBeat.i(50570);
      p.k(paramJSONObject, "json");
      p.k(paramString1, "field");
      p.k(paramString2, "default");
      p.k(paramArrayOfb, "enums");
      paramJSONObject = paramJSONObject.optString(paramString1, paramString2);
      int k = paramArrayOfb.length;
      int i = 0;
      int j = 0;
      if (j < k)
      {
        paramString1 = paramArrayOfb[j];
        p.j(paramJSONObject, "value");
        paramString2 = (CharSequence)paramJSONObject;
        String str = paramString1.getName();
        if (str == null)
        {
          paramJSONObject = new t("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(50570);
          throw paramJSONObject;
        }
        str = str.toLowerCase();
        p.j(str, "(this as java.lang.String).toLowerCase()");
        if (!n.a(paramString2, (CharSequence)str, false)) {
          break label154;
        }
        i = paramString1.getFlag() | i;
      }
      label154:
      for (;;)
      {
        j += 1;
        break;
        AppMethodBeat.o(50570);
        return i;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.q.b
 * JD-Core Version:    0.7.0.1
 */