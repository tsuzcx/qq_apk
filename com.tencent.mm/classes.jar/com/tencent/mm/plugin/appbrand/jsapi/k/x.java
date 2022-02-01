package com.tencent.mm.plugin.appbrand.jsapi.k;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.base.c;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.jsapi.k.a.e;
import com.tencent.mm.plugin.appbrand.jsapi.k.a.f;
import com.tencent.mm.plugin.appbrand.jsapi.k.a.g;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public final class x
  extends c
{
  public static final int CTRL_INDEX = 3;
  public static final String NAME = "removeMap";
  
  public final int H(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(143687);
    int i = f.ab(paramJSONObject);
    AppMethodBeat.o(143687);
    return i;
  }
  
  public final boolean b(h paramh, int paramInt, View paramView, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(143688);
    if (paramJSONObject == null)
    {
      Log.e("MicroMsg.JsApiRemoveMap", "data is null");
      AppMethodBeat.o(143688);
      return false;
    }
    e.xg(6);
    if (g.dA(paramh.getAppId(), f.i(paramh, paramJSONObject))) {
      e.xg(7);
    }
    for (;;)
    {
      AppMethodBeat.o(143688);
      return true;
      e.xg(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.k.x
 * JD-Core Version:    0.7.0.1
 */