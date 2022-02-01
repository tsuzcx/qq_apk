package com.tencent.luggage.k.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.page.aj;
import com.tencent.mm.sdk.platformtools.bt;
import org.json.JSONObject;

public final class f
{
  public static boolean a(m paramm, c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(177123);
    if (!paramm.getName().contains("operate"))
    {
      AppMethodBeat.o(177123);
      return false;
    }
    Object localObject = paramJSONObject.optString("type");
    if (bt.isNullOrNil((String)localObject))
    {
      AppMethodBeat.o(177123);
      return false;
    }
    if (!((String)localObject).equalsIgnoreCase("exitPictureInPicture"))
    {
      AppMethodBeat.o(177123);
      return false;
    }
    if ((paramc instanceof h)) {}
    for (localObject = ((h)paramc).getRuntime();; localObject = null)
    {
      if (localObject == null)
      {
        paramc.h(paramInt, paramm.e("fail", null));
        AppMethodBeat.o(177123);
        return true;
      }
      localObject = ((AppBrandRuntime)localObject).iDT;
      if (localObject == null)
      {
        paramc.h(paramInt, paramm.e("fail", null));
        AppMethodBeat.o(177123);
        return true;
      }
      if (((aj)localObject).tv(paramJSONObject.optInt("viewId"))) {}
      for (paramJSONObject = "ok";; paramJSONObject = "fail")
      {
        paramc.h(paramInt, paramm.e(paramJSONObject, null));
        AppMethodBeat.o(177123);
        return true;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.luggage.k.a.a.f
 * JD-Core Version:    0.7.0.1
 */