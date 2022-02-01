package com.tencent.mm.plugin.appbrand.jsapi.l;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.base.c;
import com.tencent.mm.plugin.appbrand.jsapi.l.a.e;
import com.tencent.mm.plugin.appbrand.jsapi.l.a.f;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public final class x
  extends c
{
  public static final int CTRL_INDEX = 3;
  public static final String NAME = "removeMap";
  
  public final int K(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(143687);
    int i = f.af(paramJSONObject);
    AppMethodBeat.o(143687);
    return i;
  }
  
  public final boolean b(com.tencent.mm.plugin.appbrand.jsapi.g paramg, int paramInt, View paramView, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(143688);
    if (paramJSONObject == null)
    {
      Log.e("MicroMsg.JsApiRemoveMap", "data is null");
      AppMethodBeat.o(143688);
      return false;
    }
    e.AC(6);
    if (com.tencent.mm.plugin.appbrand.jsapi.l.a.g.dL(paramg.getAppId(), f.h(paramg, paramJSONObject))) {
      e.AC(7);
    }
    for (;;)
    {
      AppMethodBeat.o(143688);
      return true;
      e.AC(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.l.x
 * JD-Core Version:    0.7.0.1
 */