package com.tencent.mm.plugin.appbrand.jsapi.media;

import a.f.b.j;
import a.l;
import a.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/jsapi/media/MediaConstants;", "", "Capture", "MediaEnum", "MediaType", "SourceType", "plugin-appbrand-integration_release"})
public abstract interface m
{
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/jsapi/media/MediaConstants$MediaEnum$Parser;", "", "()V", "parse", "", "json", "Lorg/json/JSONObject;", "field", "", "default", "enums", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/media/MediaConstants$MediaEnum;", "(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;[Lcom/tencent/mm/plugin/appbrand/jsapi/media/MediaConstants$MediaEnum;)I", "plugin-appbrand-integration_release"})
  public static final class b$b
  {
    static
    {
      AppMethodBeat.i(143834);
      hSF = new b();
      AppMethodBeat.o(143834);
    }
    
    public static int a(JSONObject paramJSONObject, String paramString1, String paramString2, m.b[] paramArrayOfb)
    {
      AppMethodBeat.i(143833);
      j.q(paramJSONObject, "json");
      j.q(paramString1, "field");
      j.q(paramString2, "default");
      j.q(paramArrayOfb, "enums");
      paramJSONObject = paramJSONObject.optString(paramString1, paramString2);
      int k = paramArrayOfb.length;
      int i = 0;
      int j = 0;
      if (j < k)
      {
        paramString1 = paramArrayOfb[j];
        j.p(paramJSONObject, "value");
        paramString2 = (CharSequence)paramJSONObject;
        String str = paramString1.getName();
        if (str == null)
        {
          paramJSONObject = new v("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(143833);
          throw paramJSONObject;
        }
        str = str.toLowerCase();
        j.p(str, "(this as java.lang.String).toLowerCase()");
        if (!a.l.m.a(paramString2, (CharSequence)str, false)) {
          break label154;
        }
        i = paramString1.aDR() | i;
      }
      label154:
      for (;;)
      {
        j += 1;
        break;
        AppMethodBeat.o(143833);
        return i;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.m
 * JD-Core Version:    0.7.0.1
 */