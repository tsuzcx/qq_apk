package com.tencent.mm.plugin.appbrand.jsapi.c;

import android.content.Context;
import android.view.View;
import com.tencent.luggage.b.b.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.e;
import com.tencent.mm.plugin.appbrand.canvas.widget.AppBrandDrawableView;
import com.tencent.mm.plugin.appbrand.canvas.widget.MCanvasView;
import com.tencent.mm.plugin.appbrand.canvas.widget.a;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.jsapi.i.b;
import com.tencent.mm.plugin.appbrand.jsapi.i.d;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public final class g
  extends com.tencent.mm.plugin.appbrand.jsapi.base.b
{
  public static final int CTRL_INDEX = 67;
  public static final String NAME = "insertCanvas";
  
  public final int V(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(145540);
    int i = paramJSONObject.getInt("canvasId");
    AppMethodBeat.o(145540);
    return i;
  }
  
  public final View a(h paramh, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(145539);
    paramJSONObject = paramh.getContext();
    final AppBrandDrawableView localAppBrandDrawableView = new AppBrandDrawableView(paramJSONObject);
    localAppBrandDrawableView.getDrawContext().qTo = ((e)paramh.T(e.class));
    localAppBrandDrawableView.getDrawContext().eqB = paramh;
    localAppBrandDrawableView.setContentDescription(paramJSONObject.getString(a.a.app_brand_accessibility_canvas_view));
    paramh.a(new i.b()
    {
      public final void onBackground()
      {
        AppMethodBeat.i(161176);
        AppBrandDrawableView localAppBrandDrawableView = localAppBrandDrawableView;
        Log.v("MicroMsg.MCanvasView", "onPause :%s", new Object[] { Integer.valueOf(localAppBrandDrawableView.hashCode()) });
        com.tencent.mm.plugin.appbrand.canvas.b localb = localAppBrandDrawableView.qUB;
        localb.qSS = 0L;
        localb.qSP.ab(localb.qSQ);
        localAppBrandDrawableView.ckm();
        AppMethodBeat.o(161176);
      }
    });
    paramh.a(new i.d()
    {
      public final void onForeground()
      {
        AppMethodBeat.i(161177);
        localAppBrandDrawableView.onResume();
        AppMethodBeat.o(161177);
      }
    });
    paramh = new CoverViewContainer(paramJSONObject, localAppBrandDrawableView);
    AppMethodBeat.o(145539);
    return paramh;
  }
  
  public final boolean cqx()
  {
    return true;
  }
  
  public final boolean cqy()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.c.g
 * JD-Core Version:    0.7.0.1
 */