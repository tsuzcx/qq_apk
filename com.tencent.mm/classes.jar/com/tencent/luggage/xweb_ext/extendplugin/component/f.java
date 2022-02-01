package com.tencent.luggage.xweb_ext.extendplugin.component;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.j;
import com.tencent.mm.plugin.appbrand.jsapi.o;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONObject;

public final class f
{
  public static boolean a(o paramo, e parame, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(177123);
    if (!paramo.getName().contains("operate"))
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
    if ((parame instanceof j)) {}
    for (localObject = ((j)parame).getRuntime();; localObject = null)
    {
      if (localObject == null)
      {
        parame.j(paramInt, paramo.h("fail", null));
        AppMethodBeat.o(177123);
        return true;
      }
      localObject = ((AppBrandRuntime)localObject).nuc;
      if (localObject == null)
      {
        parame.j(paramInt, paramo.h("fail", null));
        AppMethodBeat.o(177123);
        return true;
      }
      if (((com.tencent.mm.plugin.appbrand.pip.f)localObject).CA(paramJSONObject.optInt("viewId"))) {}
      for (paramJSONObject = "ok";; paramJSONObject = "fail")
      {
        parame.j(paramInt, paramo.h(paramJSONObject, null));
        AppMethodBeat.o(177123);
        return true;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.f
 * JD-Core Version:    0.7.0.1
 */