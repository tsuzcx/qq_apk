package com.tencent.mm.plugin.appbrand.jsapi.coverview;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.base.d;
import com.tencent.mm.plugin.appbrand.jsapi.z.c;
import com.tencent.mm.plugin.appbrand.jsapi.z.f;
import com.tencent.mm.sdk.platformtools.ad;
import org.json.JSONObject;

public final class o
  extends d
{
  private static final int CTRL_INDEX = 254;
  public static final String NAME = "updateTextView";
  
  public final int A(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(137547);
    int i = paramJSONObject.getInt("viewId");
    AppMethodBeat.o(137547);
    return i;
  }
  
  public final boolean c(com.tencent.mm.plugin.appbrand.jsapi.e parame, int paramInt, View paramView, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(137548);
    ad.d("MicroMsg.JsApiUpdateTextView", "onUpdateView(viewId : %s, %s)", new Object[] { Integer.valueOf(paramInt), paramJSONObject });
    if (!(paramView instanceof CoverViewContainer))
    {
      ad.w("MicroMsg.JsApiUpdateTextView", "the view(%s) is not a instance of CoverViewContainer", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(137548);
      return false;
    }
    com.tencent.mm.plugin.appbrand.widget.e locale = (com.tencent.mm.plugin.appbrand.widget.e)((CoverViewContainer)paramView).ax(com.tencent.mm.plugin.appbrand.widget.e.class);
    if (locale == null) {
      ad.w("MicroMsg.JsApiUpdateTextView", "the target view(%s) is null", new Object[] { Integer.valueOf(paramInt) });
    }
    c.a(locale, paramJSONObject.optJSONObject("label"));
    f.b(paramView, paramJSONObject.optJSONObject("style"));
    boolean bool = super.c(parame, paramInt, paramView, paramJSONObject);
    AppMethodBeat.o(137548);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.coverview.o
 * JD-Core Version:    0.7.0.1
 */