package com.tencent.mm.plugin.appbrand.weishi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.page.z;
import com.tencent.mm.sdk.platformtools.ab;
import org.json.JSONObject;

public final class h
  extends a<com.tencent.mm.plugin.appbrand.jsapi.c>
{
  public static final int CTRL_INDEX = 621;
  public static final String NAME = "showShareActionSheet";
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(133645);
    if ((paramc instanceof com.tencent.mm.plugin.appbrand.service.c)) {
      paramJSONObject = ((com.tencent.mm.plugin.appbrand.service.c)paramc).aLy();
    }
    for (;;)
    {
      if (paramJSONObject == null)
      {
        ab.e("MicroMsg.JsApiShowShareActionSheet", "fail, page view is null");
        paramc.h(paramInt, j("fail:page don't exist", null));
        AppMethodBeat.o(133645);
        return;
        if ((paramc instanceof z)) {
          paramJSONObject = (z)paramc;
        }
      }
      else
      {
        ab.i("MicroMsg.JsApiShowShareActionSheet", "weishi show share action sheet");
        paramJSONObject.aJA();
        paramc.h(paramInt, j("ok", null));
        AppMethodBeat.o(133645);
        return;
      }
      paramJSONObject = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.weishi.h
 * JD-Core Version:    0.7.0.1
 */