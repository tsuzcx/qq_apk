package com.tencent.mm.plugin.appbrand.jsapi.container;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.u.h;
import com.tencent.mm.sdk.platformtools.y;
import org.json.JSONException;
import org.json.JSONObject;

public final class c
  extends com.tencent.mm.plugin.appbrand.jsapi.base.c
{
  public static final int CTRL_INDEX = 510;
  public static final String NAME = "updatePositioningContainer";
  
  protected final boolean c(e parame, int paramInt, View paramView, JSONObject paramJSONObject)
  {
    if (!(paramView instanceof WrapperNativeContainerView)) {
      return false;
    }
    int i = h.a(paramJSONObject, "contentOffsetLeft", 0);
    int j = h.a(paramJSONObject, "contentOffsetTop", 0);
    int k = paramJSONObject.optInt("animate", 0);
    parame = (WrapperNativeContainerView)paramView;
    try
    {
      if (!paramJSONObject.getBoolean("visible")) {
        break label322;
      }
      paramInt = 0;
      parame.setVisibility(paramInt);
    }
    catch (JSONException paramView)
    {
      label61:
      ObjectAnimator localObjectAnimator;
      AnimatorSet localAnimatorSet;
      break label61;
    }
    parame = (AppBrandNativeContainerView)parame.K(AppBrandNativeContainerView.class);
    y.i("MicroMsg.JsApiUpdatePositioningContainer", "scrollLeft:%d, scrollTop:%d, animation:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) });
    if (k == 1)
    {
      paramView = ObjectAnimator.ofFloat(parame, "x", new float[] { parame.getX(), -i });
      localObjectAnimator = ObjectAnimator.ofFloat(parame, "y", new float[] { parame.getY(), -j });
      paramView.addUpdateListener(new c.1(this, parame));
      localObjectAnimator.addUpdateListener(new c.2(this, parame));
      localAnimatorSet = new AnimatorSet();
      localAnimatorSet.setDuration(1000L);
      localAnimatorSet.setInterpolator(new c.a(this));
      localAnimatorSet.setTarget(parame);
      localAnimatorSet.playTogether(new Animator[] { paramView, localObjectAnimator });
      localAnimatorSet.start();
    }
    for (;;)
    {
      paramInt = h.a(paramJSONObject, "innerHeight", parame.getHeight());
      i = h.a(paramJSONObject, "innerWidth", parame.getWidth());
      y.i("MicroMsg.JsApiUpdatePositioningContainer", "innerHeight:%d, innerWidth:%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
      paramView = parame.getLayoutParams();
      paramView.height = paramInt;
      paramView.width = i;
      parame.setLayoutParams(paramView);
      return true;
      label322:
      paramInt = 4;
      break;
      parame.setX(-i);
      parame.setY(-j);
    }
  }
  
  protected final int p(JSONObject paramJSONObject)
  {
    return paramJSONObject.getInt("containerId");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.container.c
 * JD-Core Version:    0.7.0.1
 */