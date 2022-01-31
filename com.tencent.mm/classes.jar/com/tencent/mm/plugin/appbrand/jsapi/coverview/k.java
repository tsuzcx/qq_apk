package com.tencent.mm.plugin.appbrand.jsapi.coverview;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.base.c;
import com.tencent.mm.plugin.appbrand.jsapi.s.b;
import com.tencent.mm.sdk.platformtools.ab;
import org.json.JSONObject;

public final class k
  extends c
{
  private static final int CTRL_INDEX = 254;
  public static final String NAME = "updateTextView";
  
  public final boolean c(com.tencent.mm.plugin.appbrand.jsapi.e parame, int paramInt, View paramView, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(126320);
    ab.d("MicroMsg.JsApiUpdateTextView", "onUpdateView(viewId : %s, %s)", new Object[] { Integer.valueOf(paramInt), paramJSONObject });
    if (!(paramView instanceof CoverViewContainer))
    {
      ab.w("MicroMsg.JsApiUpdateTextView", "the view(%s) is not a instance of CoverViewContainer", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(126320);
      return false;
    }
    com.tencent.mm.plugin.appbrand.widget.e locale = (com.tencent.mm.plugin.appbrand.widget.e)((CoverViewContainer)paramView).aa(com.tencent.mm.plugin.appbrand.widget.e.class);
    if (locale == null) {
      ab.w("MicroMsg.JsApiUpdateTextView", "the target view(%s) is null", new Object[] { Integer.valueOf(paramInt) });
    }
    b.a(locale, paramJSONObject.optJSONObject("label"));
    com.tencent.mm.plugin.appbrand.jsapi.s.e.b(paramView, paramJSONObject.optJSONObject("style"));
    boolean bool = super.c(parame, paramInt, paramView, paramJSONObject);
    AppMethodBeat.o(126320);
    return bool;
  }
  
  public final int w(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(126319);
    int i = paramJSONObject.getInt("viewId");
    AppMethodBeat.o(126319);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.coverview.k
 * JD-Core Version:    0.7.0.1
 */