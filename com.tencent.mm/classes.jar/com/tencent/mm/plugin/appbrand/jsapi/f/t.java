package com.tencent.mm.plugin.appbrand.jsapi.f;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.base.b;
import com.tencent.mm.plugin.appbrand.jsapi.f.a.f;
import com.tencent.mm.plugin.appbrand.jsapi.f.a.g;
import com.tencent.mm.sdk.platformtools.ac;
import org.json.JSONObject;

public final class t
  extends b
{
  public static final int CTRL_INDEX = 3;
  public static final String NAME = "removeMap";
  
  public final int A(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(143687);
    int i = f.Q(paramJSONObject);
    AppMethodBeat.o(143687);
    return i;
  }
  
  public final boolean b(com.tencent.mm.plugin.appbrand.jsapi.e parame, int paramInt, View paramView, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(143688);
    if (paramJSONObject == null)
    {
      ac.e("MicroMsg.JsApiRemoveMap", "data is null");
      AppMethodBeat.o(143688);
      return false;
    }
    com.tencent.mm.plugin.appbrand.jsapi.f.a.e.sE(6);
    if (g.dh(parame.getAppId(), f.i(parame, paramJSONObject))) {
      com.tencent.mm.plugin.appbrand.jsapi.f.a.e.sE(7);
    }
    for (;;)
    {
      AppMethodBeat.o(143688);
      return true;
      com.tencent.mm.plugin.appbrand.jsapi.f.a.e.sE(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.f.t
 * JD-Core Version:    0.7.0.1
 */