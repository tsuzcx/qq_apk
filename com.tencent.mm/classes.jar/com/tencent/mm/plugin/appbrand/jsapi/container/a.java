package com.tencent.mm.plugin.appbrand.jsapi.container;

import android.view.View;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.u.h;
import org.json.JSONObject;

public final class a
  extends com.tencent.mm.plugin.appbrand.jsapi.base.a
{
  public static final int CTRL_INDEX = 509;
  public static final String NAME = "insertPositioningContainer";
  
  protected final View a(e parame, JSONObject paramJSONObject)
  {
    int i = 0;
    AppBrandNativeContainerView localAppBrandNativeContainerView = new AppBrandNativeContainerView(parame.getContext());
    localAppBrandNativeContainerView.setBackgroundColor(0);
    boolean bool1 = paramJSONObject.optBoolean("visible", true);
    boolean bool2 = paramJSONObject.optBoolean("canFullScreenByChild", false);
    int j = h.a(paramJSONObject, "contentOffsetLeft", 0);
    int k = h.a(paramJSONObject, "contentOffsetTop", 0);
    localAppBrandNativeContainerView.setX(-j);
    localAppBrandNativeContainerView.setY(-k);
    parame = new WrapperNativeContainerView(parame.getContext(), localAppBrandNativeContainerView);
    if (bool1) {}
    for (;;)
    {
      parame.setVisibility(i);
      parame.setDuplicateParentStateEnabled(true);
      localAppBrandNativeContainerView.setDuplicateParentStateEnabled(true);
      localAppBrandNativeContainerView.setFullscreenWithChild(bool2);
      return parame;
      i = 4;
    }
  }
  
  protected final void a(e parame, int paramInt, View paramView, JSONObject paramJSONObject)
  {
    paramView.setOnTouchListener(new a.1(this));
  }
  
  protected final int p(JSONObject paramJSONObject)
  {
    return paramJSONObject.getInt("containerId");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.container.a
 * JD-Core Version:    0.7.0.1
 */