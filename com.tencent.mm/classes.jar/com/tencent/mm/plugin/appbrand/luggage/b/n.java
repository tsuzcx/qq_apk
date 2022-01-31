package com.tencent.mm.plugin.appbrand.luggage.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.wx_extension.a.a;
import com.tencent.mm.ipcinvoker.wx_extension.a.a.b;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.f;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class n
  extends com.tencent.luggage.f.a.b
{
  public static Integer iov;
  
  private static int getMapType()
  {
    AppMethodBeat.i(132110);
    if (iov != null)
    {
      i = iov.intValue();
      AppMethodBeat.o(132110);
      return i;
    }
    Object localObject = a.b.eEW;
    localObject = a.me("100487");
    if ((localObject == null) || (!((com.tencent.mm.storage.c)localObject).isValid()))
    {
      ab.i("MicroMsg.WxaMapViewFactory", "[sMapType] item is null");
      AppMethodBeat.o(132110);
      return 1;
    }
    iov = Integer.valueOf(bo.getInt((String)((com.tencent.mm.storage.c)localObject).dvN().get("MapType"), 1));
    ab.i("MicroMsg.WxaMapViewFactory", "sMapType:%d", new Object[] { iov });
    int i = iov.intValue();
    AppMethodBeat.o(132110);
    return i;
  }
  
  public final com.tencent.mm.plugin.appbrand.jsapi.g.a.b a(Context paramContext, String paramString, Map<String, Object> paramMap)
  {
    AppMethodBeat.i(132112);
    if (paramContext == null)
    {
      AppMethodBeat.o(132112);
      return null;
    }
    if (f.a(paramMap, "mapType", getMapType()) == 2)
    {
      paramContext = new com.tencent.mm.plugin.appbrand.jsapi.v.c.b(paramContext, paramString, paramMap);
      AppMethodBeat.o(132112);
      return paramContext;
    }
    paramContext = super.a(paramContext, paramString, paramMap);
    AppMethodBeat.o(132112);
    return paramContext;
  }
  
  public final com.tencent.mm.plugin.appbrand.jsapi.g.a.b b(com.tencent.mm.plugin.appbrand.jsapi.c paramc, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(132111);
    if (paramJSONObject != null) {}
    try
    {
      paramJSONObject.put("mapType", getMapType());
      paramc = super.b(paramc, paramJSONObject);
      AppMethodBeat.o(132111);
      return paramc;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        ab.b("MicroMsg.WxaMapViewFactory", "", new Object[] { localJSONException });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.b.n
 * JD-Core Version:    0.7.0.1
 */