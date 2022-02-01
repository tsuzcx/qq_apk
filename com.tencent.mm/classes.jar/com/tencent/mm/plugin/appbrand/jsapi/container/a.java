package com.tencent.mm.plugin.appbrand.jsapi.container;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.af.i;
import com.tencent.mm.plugin.appbrand.jsapi.ah.e;
import com.tencent.mm.plugin.appbrand.jsapi.base.b;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import org.json.JSONObject;

public final class a
  extends b
{
  public static final int CTRL_INDEX = 509;
  public static final String NAME = "insertPositioningContainer";
  
  public final int V(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(137506);
    int i = paramJSONObject.getInt("containerId");
    AppMethodBeat.o(137506);
    return i;
  }
  
  public final View a(h paramh, JSONObject paramJSONObject)
  {
    int i = 0;
    AppMethodBeat.i(137505);
    AppBrandNativeContainerView localAppBrandNativeContainerView = new AppBrandNativeContainerView(paramh.getContext());
    localAppBrandNativeContainerView.setBackgroundColor(0);
    boolean bool1 = paramJSONObject.optBoolean("visible", true);
    boolean bool2 = paramJSONObject.optBoolean("canFullScreenByChild", false);
    int j = i.a(paramJSONObject, "contentOffsetLeft", 0);
    int k = i.a(paramJSONObject, "contentOffsetTop", 0);
    localAppBrandNativeContainerView.setX(-j);
    localAppBrandNativeContainerView.setY(-k);
    paramh = new WrapperNativeContainerView(paramh.getContext(), localAppBrandNativeContainerView);
    if (bool1) {}
    for (;;)
    {
      paramh.setVisibility(i);
      paramh.setDuplicateParentStateEnabled(true);
      localAppBrandNativeContainerView.setDuplicateParentStateEnabled(true);
      localAppBrandNativeContainerView.setFullscreenWithChild(bool2);
      AppMethodBeat.o(137505);
      return paramh;
      i = 4;
    }
  }
  
  public final void a(h paramh, int paramInt, View paramView, JSONObject paramJSONObject)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.container.a
 * JD-Core Version:    0.7.0.1
 */