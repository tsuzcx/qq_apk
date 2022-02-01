package com.tencent.mm.plugin.appbrand.jsapi.container;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.af.i;
import com.tencent.mm.plugin.appbrand.jsapi.base.d;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONException;
import org.json.JSONObject;

public final class c
  extends d
{
  public static final int CTRL_INDEX = 510;
  public static final String NAME = "updatePositioningContainer";
  
  public final int V(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(137515);
    int i = paramJSONObject.getInt("containerId");
    AppMethodBeat.o(137515);
    return i;
  }
  
  public final boolean c(h paramh, int paramInt, View paramView, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(137514);
    if (!(paramView instanceof WrapperNativeContainerView))
    {
      AppMethodBeat.o(137514);
      return false;
    }
    int i = i.a(paramJSONObject, "contentOffsetLeft", 0);
    int j = i.a(paramJSONObject, "contentOffsetTop", 0);
    int k = paramJSONObject.optInt("animate", 0);
    paramh = (WrapperNativeContainerView)paramView;
    try
    {
      if (!paramJSONObject.getBoolean("visible")) {
        break label337;
      }
      paramInt = 0;
      paramh.setVisibility(paramInt);
    }
    catch (JSONException paramView)
    {
      label71:
      ObjectAnimator localObjectAnimator;
      AnimatorSet localAnimatorSet;
      break label71;
    }
    paramh = (AppBrandNativeContainerView)paramh.aT(AppBrandNativeContainerView.class);
    Log.i("MicroMsg.JsApiUpdatePositioningContainer", "scrollLeft:%d, scrollTop:%d, animation:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) });
    if (k == 1)
    {
      paramView = ObjectAnimator.ofFloat(paramh, "x", new float[] { paramh.getX(), -i });
      localObjectAnimator = ObjectAnimator.ofFloat(paramh, "y", new float[] { paramh.getY(), -j });
      paramView.addUpdateListener(new c.1(this, paramh));
      localObjectAnimator.addUpdateListener(new c.2(this, paramh));
      localAnimatorSet = new AnimatorSet();
      localAnimatorSet.setDuration(1000L);
      localAnimatorSet.setInterpolator(new c.a(this));
      localAnimatorSet.setTarget(paramh);
      localAnimatorSet.playTogether(new Animator[] { paramView, localObjectAnimator });
      localAnimatorSet.start();
    }
    for (;;)
    {
      paramInt = i.a(paramJSONObject, "innerHeight", paramh.getHeight());
      i = i.a(paramJSONObject, "innerWidth", paramh.getWidth());
      Log.i("MicroMsg.JsApiUpdatePositioningContainer", "innerHeight:%d, innerWidth:%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
      paramView = paramh.getLayoutParams();
      paramView.height = paramInt;
      paramView.width = i;
      paramh.setLayoutParams(paramView);
      AppMethodBeat.o(137514);
      return true;
      label337:
      paramInt = 4;
      break;
      paramh.setX(-i);
      paramh.setY(-j);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.container.c
 * JD-Core Version:    0.7.0.1
 */