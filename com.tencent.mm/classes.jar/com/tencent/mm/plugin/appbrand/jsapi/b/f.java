package com.tencent.mm.plugin.appbrand.jsapi.b;

import android.view.View;
import com.tencent.mm.plugin.appbrand.canvas.widget.AppBrandDrawableView;
import com.tencent.mm.plugin.appbrand.jsapi.base.a;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import org.json.JSONObject;

public final class f
  extends a
{
  public static final int CTRL_INDEX = 67;
  public static final String NAME = "insertCanvas";
  
  protected final View a(com.tencent.mm.plugin.appbrand.jsapi.e parame, JSONObject paramJSONObject)
  {
    paramJSONObject = parame.getContext();
    AppBrandDrawableView localAppBrandDrawableView = new AppBrandDrawableView(paramJSONObject);
    localAppBrandDrawableView.getDrawContext().fLv = ((com.tencent.mm.plugin.appbrand.canvas.e)parame.i(com.tencent.mm.plugin.appbrand.canvas.e.class));
    localAppBrandDrawableView.getDrawContext().fLx = parame;
    return new CoverViewContainer(paramJSONObject, localAppBrandDrawableView);
  }
  
  protected final boolean aii()
  {
    return true;
  }
  
  protected final boolean aij()
  {
    return true;
  }
  
  protected final int p(JSONObject paramJSONObject)
  {
    return paramJSONObject.getInt("canvasId");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.b.f
 * JD-Core Version:    0.7.0.1
 */