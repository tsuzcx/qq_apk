package com.tencent.mm.plugin.appbrand.jsapi.container;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.s.g;
import org.json.JSONObject;

public final class a
  extends com.tencent.mm.plugin.appbrand.jsapi.base.a
{
  public static final int CTRL_INDEX = 509;
  public static final String NAME = "insertPositioningContainer";
  
  public final View a(e parame, JSONObject paramJSONObject)
  {
    int i = 0;
    AppMethodBeat.i(126277);
    AppBrandNativeContainerView localAppBrandNativeContainerView = new AppBrandNativeContainerView(parame.getContext());
    localAppBrandNativeContainerView.setBackgroundColor(0);
    boolean bool1 = paramJSONObject.optBoolean("visible", true);
    boolean bool2 = paramJSONObject.optBoolean("canFullScreenByChild", false);
    int j = g.a(paramJSONObject, "contentOffsetLeft", 0);
    int k = g.a(paramJSONObject, "contentOffsetTop", 0);
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
      AppMethodBeat.o(126277);
      return parame;
      i = 4;
    }
  }
  
  public final void a(e parame, int paramInt, View paramView, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(126279);
    paramView.setOnTouchListener(new a.1(this));
    AppMethodBeat.o(126279);
  }
  
  public final int w(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(126278);
    int i = paramJSONObject.getInt("containerId");
    AppMethodBeat.o(126278);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.container.a
 * JD-Core Version:    0.7.0.1
 */