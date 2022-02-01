package com.tencent.mm.plugin.appbrand.jsapi.media;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/media/MediaConstants$MediaEnum;", "", "flag", "", "getFlag", "()I", "name", "", "getName", "()Ljava/lang/String;", "contains", "", "flags", "equals", "Parser", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface r$b
{
  public static final b shB = b.shC;
  
  public abstract int getFlag();
  
  public abstract String getName();
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static boolean a(r.b paramb, int paramInt)
    {
      AppMethodBeat.i(50569);
      s.u(paramb, "this");
      if (paramInt == paramb.getFlag())
      {
        AppMethodBeat.o(50569);
        return true;
      }
      AppMethodBeat.o(50569);
      return false;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/media/MediaConstants$MediaEnum$Parser;", "", "()V", "parse", "", "json", "Lorg/json/JSONObject;", "field", "", "default", "enums", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/media/MediaConstants$MediaEnum;", "(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;[Lcom/tencent/mm/plugin/appbrand/jsapi/media/MediaConstants$MediaEnum;)I", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
  {
    static
    {
      AppMethodBeat.i(50571);
      shC = new b();
      AppMethodBeat.o(50571);
    }
    
    public static int a(JSONObject paramJSONObject, String paramString1, String paramString2, r.b[] paramArrayOfb)
    {
      AppMethodBeat.i(50570);
      s.u(paramJSONObject, "json");
      s.u(paramString1, "field");
      s.u(paramString2, "default");
      s.u(paramArrayOfb, "enums");
      paramJSONObject = paramJSONObject.optString(paramString1, paramString2);
      int k = paramArrayOfb.length;
      int i = 0;
      int j = 0;
      if (j < k)
      {
        paramString1 = paramArrayOfb[j];
        s.s(paramJSONObject, "value");
        paramString2 = (CharSequence)paramJSONObject;
        String str = paramString1.getName();
        if (str == null)
        {
          paramJSONObject = new NullPointerException("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(50570);
          throw paramJSONObject;
        }
        str = str.toLowerCase();
        s.s(str, "(this as java.lang.String).toLowerCase()");
        if (!n.i(paramString2, (CharSequence)str)) {
          break label153;
        }
        i = paramString1.getFlag() | i;
      }
      label153:
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.r.b
 * JD-Core Version:    0.7.0.1
 */