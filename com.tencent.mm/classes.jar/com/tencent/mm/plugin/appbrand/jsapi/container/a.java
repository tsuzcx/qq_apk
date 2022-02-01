package com.tencent.mm.plugin.appbrand.jsapi.container;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ae.e;
import com.tencent.mm.plugin.appbrand.jsapi.base.b;
import org.json.JSONObject;

public final class a
  extends b
{
  public static final int CTRL_INDEX = 509;
  public static final String NAME = "insertPositioningContainer";
  
  public final int K(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(137506);
    int i = paramJSONObject.getInt("containerId");
    AppMethodBeat.o(137506);
    return i;
  }
  
  public final View a(com.tencent.mm.plugin.appbrand.jsapi.g paramg, JSONObject paramJSONObject)
  {
    int i = 0;
    AppMethodBeat.i(137505);
    AppBrandNativeContainerView localAppBrandNativeContainerView = new AppBrandNativeContainerView(paramg.getContext());
    localAppBrandNativeContainerView.setBackgroundColor(0);
    boolean bool1 = paramJSONObject.optBoolean("visible", true);
    boolean bool2 = paramJSONObject.optBoolean("canFullScreenByChild", false);
    int j = com.tencent.mm.plugin.appbrand.ac.g.a(paramJSONObject, "contentOffsetLeft", 0);
    int k = com.tencent.mm.plugin.appbrand.ac.g.a(paramJSONObject, "contentOffsetTop", 0);
    localAppBrandNativeContainerView.setX(-j);
    localAppBrandNativeContainerView.setY(-k);
    paramg = new WrapperNativeContainerView(paramg.getContext(), localAppBrandNativeContainerView);
    if (bool1) {}
    for (;;)
    {
      paramg.setVisibility(i);
      paramg.setDuplicateParentStateEnabled(true);
      localAppBrandNativeContainerView.setDuplicateParentStateEnabled(true);
      localAppBrandNativeContainerView.setFullscreenWithChild(bool2);
      AppMethodBeat.o(137505);
      return paramg;
      i = 4;
    }
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.g paramg, int paramInt, View paramView, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(137507);
    paramView.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(137504);
        if (paramAnonymousMotionEvent.getAction() != 0) {
          e.a((ViewGroup)paramAnonymousView, paramAnonymousMotionEvent);
        }
        AppMethodBeat.o(137504);
        return false;
      }
    });
    AppMethodBeat.o(137507);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.container.a
 * JD-Core Version:    0.7.0.1
 */