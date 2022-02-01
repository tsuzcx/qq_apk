package com.tencent.mm.plugin.appbrand.jsapi.o;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.base.c;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.jsapi.o.a.e;
import com.tencent.mm.plugin.appbrand.jsapi.o.a.f;
import com.tencent.mm.plugin.appbrand.jsapi.o.a.g;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public final class z
  extends c
{
  public static final int CTRL_INDEX = 3;
  public static final String NAME = "removeMap";
  
  public final int V(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(143687);
    int i = f.ap(paramJSONObject);
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
    e.AQ(6);
    if (g.ee(paramh.getAppId(), f.h(paramh, paramJSONObject))) {
      e.AQ(7);
    }
    for (;;)
    {
      AppMethodBeat.o(143688);
      return true;
      e.AQ(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.o.z
 * JD-Core Version:    0.7.0.1
 */