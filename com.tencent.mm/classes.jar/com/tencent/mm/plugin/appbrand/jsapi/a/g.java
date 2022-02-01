package com.tencent.mm.plugin.appbrand.jsapi.a;

import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.widget.AppBrandDrawableView;
import com.tencent.mm.plugin.appbrand.canvas.widget.MCanvasView;
import com.tencent.mm.plugin.appbrand.canvas.widget.a;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.jsapi.f.b;
import com.tencent.mm.plugin.appbrand.jsapi.f.d;
import com.tencent.mm.sdk.platformtools.ae;
import org.json.JSONObject;

public final class g
  extends com.tencent.mm.plugin.appbrand.jsapi.base.b
{
  public static final int CTRL_INDEX = 67;
  public static final String NAME = "insertCanvas";
  
  public final int A(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(145540);
    int i = paramJSONObject.getInt("canvasId");
    AppMethodBeat.o(145540);
    return i;
  }
  
  public final View a(com.tencent.mm.plugin.appbrand.jsapi.e parame, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(145539);
    paramJSONObject = parame.getContext();
    final AppBrandDrawableView localAppBrandDrawableView = new AppBrandDrawableView(paramJSONObject);
    localAppBrandDrawableView.getDrawContext().jWv = ((com.tencent.mm.plugin.appbrand.canvas.e)parame.K(com.tencent.mm.plugin.appbrand.canvas.e.class));
    localAppBrandDrawableView.getDrawContext().cnn = parame;
    localAppBrandDrawableView.setContentDescription(paramJSONObject.getString(2131755285));
    parame.a(new f.b()
    {
      public final void onBackground()
      {
        AppMethodBeat.i(161176);
        AppBrandDrawableView localAppBrandDrawableView = localAppBrandDrawableView;
        ae.v("MicroMsg.MCanvasView", "onPause :%s", new Object[] { Integer.valueOf(localAppBrandDrawableView.hashCode()) });
        com.tencent.mm.plugin.appbrand.canvas.b localb = localAppBrandDrawableView.jXK;
        localb.jVZ = 0L;
        localb.jVW.P(localb.jVX);
        localAppBrandDrawableView.beg();
        AppMethodBeat.o(161176);
      }
    });
    parame.a(new f.d()
    {
      public final void onForeground()
      {
        AppMethodBeat.i(161177);
        localAppBrandDrawableView.onResume();
        AppMethodBeat.o(161177);
      }
    });
    parame = new CoverViewContainer(paramJSONObject, localAppBrandDrawableView);
    AppMethodBeat.o(145539);
    return parame;
  }
  
  public final boolean bjG()
  {
    return true;
  }
  
  public final boolean bjH()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.a.g
 * JD-Core Version:    0.7.0.1
 */