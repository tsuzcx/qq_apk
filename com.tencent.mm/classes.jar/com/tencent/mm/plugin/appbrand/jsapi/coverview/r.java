package com.tencent.mm.plugin.appbrand.jsapi.coverview;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ac.c;
import com.tencent.mm.plugin.appbrand.jsapi.ac.f;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public final class r
  extends com.tencent.mm.plugin.appbrand.jsapi.base.d
{
  private static final int CTRL_INDEX = 254;
  public static final String NAME = "updateTextView";
  
  public final int H(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(137547);
    int i = paramJSONObject.getInt("viewId");
    AppMethodBeat.o(137547);
    return i;
  }
  
  public final boolean c(h paramh, int paramInt, View paramView, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(137548);
    Log.d("MicroMsg.JsApiUpdateTextView", "onUpdateView(viewId : %s, %s)", new Object[] { Integer.valueOf(paramInt), paramJSONObject });
    if (!(paramView instanceof CoverViewContainer))
    {
      Log.w("MicroMsg.JsApiUpdateTextView", "the view(%s) is not a instance of CoverViewContainer", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(137548);
      return false;
    }
    com.tencent.mm.plugin.appbrand.widget.d locald = (com.tencent.mm.plugin.appbrand.widget.d)((CoverViewContainer)paramView).aB(com.tencent.mm.plugin.appbrand.widget.d.class);
    if (locald == null) {
      Log.w("MicroMsg.JsApiUpdateTextView", "the target view(%s) is null", new Object[] { Integer.valueOf(paramInt) });
    }
    c.a(locald, paramJSONObject.optJSONObject("label"));
    f.b(paramView, paramJSONObject.optJSONObject("style"));
    boolean bool = super.c(paramh, paramInt, paramView, paramJSONObject);
    AppMethodBeat.o(137548);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.coverview.r
 * JD-Core Version:    0.7.0.1
 */