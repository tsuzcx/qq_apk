package com.tencent.mm.plugin.appbrand.jsapi.i;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.base.c;
import com.tencent.mm.plugin.appbrand.jsapi.i.a.f;
import com.tencent.mm.plugin.appbrand.jsapi.i.a.g;
import com.tencent.mm.sdk.platformtools.ad;
import org.json.JSONObject;

public final class x
  extends c
{
  public static final int CTRL_INDEX = 3;
  public static final String NAME = "removeMap";
  
  public final int A(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(143687);
    int i = f.S(paramJSONObject);
    AppMethodBeat.o(143687);
    return i;
  }
  
  public final boolean b(com.tencent.mm.plugin.appbrand.jsapi.e parame, int paramInt, View paramView, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(143688);
    if (paramJSONObject == null)
    {
      ad.e("MicroMsg.JsApiRemoveMap", "data is null");
      AppMethodBeat.o(143688);
      return false;
    }
    com.tencent.mm.plugin.appbrand.jsapi.i.a.e.th(6);
    if (g.dj(parame.getAppId(), f.i(parame, paramJSONObject))) {
      com.tencent.mm.plugin.appbrand.jsapi.i.a.e.th(7);
    }
    for (;;)
    {
      AppMethodBeat.o(143688);
      return true;
      com.tencent.mm.plugin.appbrand.jsapi.i.a.e.th(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.i.x
 * JD-Core Version:    0.7.0.1
 */