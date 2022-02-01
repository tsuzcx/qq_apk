package com.tencent.mm.plugin.appbrand.jsapi.b;

import android.content.Context;
import android.view.View;
import com.tencent.luggage.b.b.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.e;
import com.tencent.mm.plugin.appbrand.canvas.widget.AppBrandDrawableView;
import com.tencent.mm.plugin.appbrand.canvas.widget.MCanvasView;
import com.tencent.mm.plugin.appbrand.canvas.widget.a;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.jsapi.h.b;
import com.tencent.mm.plugin.appbrand.jsapi.h.d;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public final class g
  extends com.tencent.mm.plugin.appbrand.jsapi.base.b
{
  public static final int CTRL_INDEX = 67;
  public static final String NAME = "insertCanvas";
  
  public final int K(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(145540);
    int i = paramJSONObject.getInt("canvasId");
    AppMethodBeat.o(145540);
    return i;
  }
  
  public final View a(com.tencent.mm.plugin.appbrand.jsapi.g paramg, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(145539);
    paramJSONObject = paramg.getContext();
    final AppBrandDrawableView localAppBrandDrawableView = new AppBrandDrawableView(paramJSONObject);
    localAppBrandDrawableView.getDrawContext().nTC = ((e)paramg.K(e.class));
    localAppBrandDrawableView.getDrawContext().cyi = paramg;
    localAppBrandDrawableView.setContentDescription(paramJSONObject.getString(a.a.app_brand_accessibility_canvas_view));
    paramg.a(new h.b()
    {
      public final void onBackground()
      {
        AppMethodBeat.i(161176);
        AppBrandDrawableView localAppBrandDrawableView = localAppBrandDrawableView;
        Log.v("MicroMsg.MCanvasView", "onPause :%s", new Object[] { Integer.valueOf(localAppBrandDrawableView.hashCode()) });
        com.tencent.mm.plugin.appbrand.canvas.b localb = localAppBrandDrawableView.nUR;
        localb.nTg = 0L;
        localb.nTd.V(localb.nTe);
        localAppBrandDrawableView.bKM();
        AppMethodBeat.o(161176);
      }
    });
    paramg.a(new h.d()
    {
      public final void onForeground()
      {
        AppMethodBeat.i(161177);
        localAppBrandDrawableView.onResume();
        AppMethodBeat.o(161177);
      }
    });
    paramg = new CoverViewContainer(paramJSONObject, localAppBrandDrawableView);
    AppMethodBeat.o(145539);
    return paramg;
  }
  
  public final boolean bQA()
  {
    return true;
  }
  
  public final boolean bQB()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.b.g
 * JD-Core Version:    0.7.0.1
 */