package com.tencent.luggage.xweb_ext.extendplugin.component;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.jsapi.k;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.pip.g;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONObject;

public final class f
{
  public static boolean a(p paramp, com.tencent.mm.plugin.appbrand.jsapi.f paramf, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(177123);
    if (!paramp.getName().contains("operate"))
    {
      AppMethodBeat.o(177123);
      return false;
    }
    Object localObject = paramJSONObject.optString("type");
    if (Util.isNullOrNil((String)localObject))
    {
      AppMethodBeat.o(177123);
      return false;
    }
    if (!((String)localObject).equalsIgnoreCase("exitPictureInPicture"))
    {
      AppMethodBeat.o(177123);
      return false;
    }
    localObject = null;
    if ((paramf instanceof k)) {
      localObject = ((k)paramf).getRuntime();
    }
    if (localObject == null)
    {
      paramf.callback(paramInt, paramp.ZP("fail"));
      AppMethodBeat.o(177123);
      return true;
    }
    localObject = ((AppBrandRuntime)localObject).qsM;
    if (localObject == null)
    {
      paramf.callback(paramInt, paramp.ZP("fail"));
      AppMethodBeat.o(177123);
      return true;
    }
    if (((g)localObject).CR(paramJSONObject.optInt("viewId"))) {}
    for (paramJSONObject = "ok";; paramJSONObject = "fail")
    {
      paramf.callback(paramInt, paramp.ZP(paramJSONObject));
      AppMethodBeat.o(177123);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.f
 * JD-Core Version:    0.7.0.1
 */