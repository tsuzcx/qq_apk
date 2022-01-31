package com.tencent.mm.plugin.appbrand.jsapi.b;

import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.widget.AppBrandDrawableView;
import com.tencent.mm.plugin.appbrand.jsapi.base.a;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import org.json.JSONObject;

public final class f
  extends a
{
  public static final int CTRL_INDEX = 67;
  public static final String NAME = "insertCanvas";
  
  public final View a(com.tencent.mm.plugin.appbrand.jsapi.e parame, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(103853);
    paramJSONObject = parame.getContext();
    AppBrandDrawableView localAppBrandDrawableView = new AppBrandDrawableView(paramJSONObject);
    localAppBrandDrawableView.getDrawContext().heH = ((com.tencent.mm.plugin.appbrand.canvas.e)parame.q(com.tencent.mm.plugin.appbrand.canvas.e.class));
    localAppBrandDrawableView.getDrawContext().bDN = parame;
    localAppBrandDrawableView.setContentDescription(paramJSONObject.getString(2131296550));
    parame = new CoverViewContainer(paramJSONObject, localAppBrandDrawableView);
    AppMethodBeat.o(103853);
    return parame;
  }
  
  public final boolean aCc()
  {
    return true;
  }
  
  public final boolean aCd()
  {
    return true;
  }
  
  public final int w(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(103854);
    int i = paramJSONObject.getInt("canvasId");
    AppMethodBeat.o(103854);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.b.f
 * JD-Core Version:    0.7.0.1
 */