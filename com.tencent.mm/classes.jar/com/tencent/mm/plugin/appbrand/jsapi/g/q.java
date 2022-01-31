package com.tencent.mm.plugin.appbrand.jsapi.g;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.base.b;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.f;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.g;
import com.tencent.mm.sdk.platformtools.ab;
import org.json.JSONObject;

public final class q
  extends b
{
  public static final int CTRL_INDEX = 3;
  public static final String NAME = "removeMap";
  
  public final boolean b(com.tencent.mm.plugin.appbrand.jsapi.e parame, int paramInt, View paramView, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(93868);
    if (paramJSONObject == null)
    {
      ab.e("MicroMsg.JsApiRemoveMap", "data is null");
      AppMethodBeat.o(93868);
      return false;
    }
    com.tencent.mm.plugin.appbrand.jsapi.g.a.e.oe(6);
    if (g.cm(parame.getAppId(), f.g(parame, paramJSONObject))) {
      com.tencent.mm.plugin.appbrand.jsapi.g.a.e.oe(7);
    }
    for (;;)
    {
      AppMethodBeat.o(93868);
      return true;
      com.tencent.mm.plugin.appbrand.jsapi.g.a.e.oe(8);
    }
  }
  
  public final int w(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(93867);
    int i = f.G(paramJSONObject);
    AppMethodBeat.o(93867);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.g.q
 * JD-Core Version:    0.7.0.1
 */