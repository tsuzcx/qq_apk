package com.tencent.mm.plugin.appbrand.jsapi.container;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.aa.g;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.x.d;
import org.json.JSONObject;

public final class a
  extends com.tencent.mm.plugin.appbrand.jsapi.base.a
{
  public static final int CTRL_INDEX = 509;
  public static final String NAME = "insertPositioningContainer";
  
  public final int A(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(137506);
    int i = paramJSONObject.getInt("containerId");
    AppMethodBeat.o(137506);
    return i;
  }
  
  public final View a(e parame, JSONObject paramJSONObject)
  {
    int i = 0;
    AppMethodBeat.i(137505);
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
      AppMethodBeat.o(137505);
      return parame;
      i = 4;
    }
  }
  
  public final void a(e parame, int paramInt, View paramView, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(137507);
    paramView.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(137504);
        if (paramAnonymousMotionEvent.getAction() != 0) {
          d.a((ViewGroup)paramAnonymousView, paramAnonymousMotionEvent);
        }
        AppMethodBeat.o(137504);
        return false;
      }
    });
    AppMethodBeat.o(137507);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.container.a
 * JD-Core Version:    0.7.0.1
 */