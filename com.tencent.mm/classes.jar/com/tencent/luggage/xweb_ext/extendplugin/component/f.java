package com.tencent.luggage.xweb_ext.extendplugin.component;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.jsapi.k;
import com.tencent.mm.plugin.appbrand.jsapi.p;
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
    if ((paramf instanceof k)) {}
    for (localObject = ((k)paramf).getRuntime();; localObject = null)
    {
      if (localObject == null)
      {
        paramf.i(paramInt, paramp.h("fail", null));
        AppMethodBeat.o(177123);
        return true;
      }
      localObject = ((AppBrandRuntime)localObject).kAQ;
      if (localObject == null)
      {
        paramf.i(paramInt, paramp.h("fail", null));
        AppMethodBeat.o(177123);
        return true;
      }
      if (((com.tencent.mm.plugin.appbrand.pip.f)localObject).yV(paramJSONObject.optInt("viewId"))) {}
      for (paramJSONObject = "ok";; paramJSONObject = "fail")
      {
        paramf.i(paramInt, paramp.h(paramJSONObject, null));
        AppMethodBeat.o(177123);
        return true;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.f
 * JD-Core Version:    0.7.0.1
 */