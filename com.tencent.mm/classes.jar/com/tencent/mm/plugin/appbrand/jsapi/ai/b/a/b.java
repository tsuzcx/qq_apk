package com.tencent.mm.plugin.appbrand.jsapi.ai.b.a;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.base.c;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.jsapi.g;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public final class b
  extends c
{
  private static final int CTRL_INDEX = 673;
  public static final String NAME = "removeXWebCanvas";
  
  public final int K(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(139454);
    int i = paramJSONObject.optInt("viewId");
    AppMethodBeat.o(139454);
    return i;
  }
  
  public final boolean b(g paramg, int paramInt, View paramView, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(222745);
    paramg = (View)((CoverViewContainer)paramView).aA(View.class);
    if ((paramg == null) || (!(paramg instanceof d)))
    {
      Log.w("Luggage.JsApiRemoveXWebCanvasTextureView", "the skia canvas view(%s) is null", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(222745);
      return false;
    }
    ((d)paramg).release();
    AppMethodBeat.o(222745);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ai.b.a.b
 * JD-Core Version:    0.7.0.1
 */