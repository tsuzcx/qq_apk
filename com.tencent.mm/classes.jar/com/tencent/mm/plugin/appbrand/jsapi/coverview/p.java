package com.tencent.mm.plugin.appbrand.jsapi.coverview;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ae.c;
import com.tencent.mm.plugin.appbrand.jsapi.ae.f;
import com.tencent.mm.plugin.appbrand.jsapi.base.d;
import com.tencent.mm.plugin.appbrand.jsapi.g;
import com.tencent.mm.plugin.appbrand.widget.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public final class p
  extends d
{
  private static final int CTRL_INDEX = 254;
  public static final String NAME = "updateImageView";
  
  public final int K(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(137542);
    int i = paramJSONObject.getInt("viewId");
    AppMethodBeat.o(137542);
    return i;
  }
  
  public final boolean c(g paramg, int paramInt, View paramView, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(137543);
    Log.d("MicroMsg.JsApiUpdateImageView", "onUpdateView(viewId : %s, %s)", new Object[] { Integer.valueOf(paramInt), paramJSONObject });
    if (!(paramView instanceof CoverViewContainer))
    {
      Log.w("MicroMsg.JsApiUpdateImageView", "the view(%s) is not a instance of CoverViewContainer", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(137543);
      return false;
    }
    a locala = (a)((CoverViewContainer)paramView).aA(a.class);
    if (locala == null)
    {
      Log.w("MicroMsg.JsApiUpdateImageView", "the target view(%s) is null", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(137543);
      return false;
    }
    f.b(paramView, paramJSONObject.optJSONObject("style"));
    c.a(paramg, paramInt, locala, paramJSONObject, new b(paramInt, locala.getKeyValueSet(), paramg));
    boolean bool = super.c(paramg, paramInt, paramView, paramJSONObject);
    AppMethodBeat.o(137543);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.coverview.p
 * JD-Core Version:    0.7.0.1
 */