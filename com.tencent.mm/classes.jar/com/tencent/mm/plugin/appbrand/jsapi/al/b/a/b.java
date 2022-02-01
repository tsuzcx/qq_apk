package com.tencent.mm.plugin.appbrand.jsapi.al.b.a;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.base.c;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public final class b
  extends c
{
  private static final int CTRL_INDEX = 673;
  public static final String NAME = "removeXWebCanvas";
  
  public final int V(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(139454);
    int i = paramJSONObject.optInt("viewId");
    AppMethodBeat.o(139454);
    return i;
  }
  
  public final boolean b(h paramh, int paramInt, View paramView, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(327064);
    paramh = (View)((CoverViewContainer)paramView).aT(View.class);
    if ((paramh == null) || (!(paramh instanceof d)))
    {
      Log.w("Luggage.JsApiRemoveXWebCanvasTextureView", "the skia canvas view(%s) is null", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(327064);
      return false;
    }
    ((d)paramh).release();
    AppMethodBeat.o(327064);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.al.b.a.b
 * JD-Core Version:    0.7.0.1
 */