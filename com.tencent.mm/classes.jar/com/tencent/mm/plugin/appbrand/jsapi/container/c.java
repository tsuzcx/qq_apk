package com.tencent.mm.plugin.appbrand.jsapi.container;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.base.d;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.z.g;
import com.tencent.mm.sdk.platformtools.ad;
import org.json.JSONException;
import org.json.JSONObject;

public final class c
  extends d
{
  public static final int CTRL_INDEX = 510;
  public static final String NAME = "updatePositioningContainer";
  
  public final int A(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(137515);
    int i = paramJSONObject.getInt("containerId");
    AppMethodBeat.o(137515);
    return i;
  }
  
  public final boolean c(e parame, int paramInt, View paramView, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(137514);
    if (!(paramView instanceof WrapperNativeContainerView))
    {
      AppMethodBeat.o(137514);
      return false;
    }
    int i = g.a(paramJSONObject, "contentOffsetLeft", 0);
    int j = g.a(paramJSONObject, "contentOffsetTop", 0);
    int k = paramJSONObject.optInt("animate", 0);
    parame = (WrapperNativeContainerView)paramView;
    try
    {
      if (!paramJSONObject.getBoolean("visible")) {
        break label337;
      }
      paramInt = 0;
      parame.setVisibility(paramInt);
    }
    catch (JSONException paramView)
    {
      label71:
      ObjectAnimator localObjectAnimator;
      AnimatorSet localAnimatorSet;
      break label71;
    }
    parame = (AppBrandNativeContainerView)parame.ax(AppBrandNativeContainerView.class);
    ad.i("MicroMsg.JsApiUpdatePositioningContainer", "scrollLeft:%d, scrollTop:%d, animation:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) });
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
      paramInt = g.a(paramJSONObject, "innerHeight", parame.getHeight());
      i = g.a(paramJSONObject, "innerWidth", parame.getWidth());
      ad.i("MicroMsg.JsApiUpdatePositioningContainer", "innerHeight:%d, innerWidth:%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
      paramView = parame.getLayoutParams();
      paramView.height = paramInt;
      paramView.width = i;
      parame.setLayoutParams(paramView);
      AppMethodBeat.o(137514);
      return true;
      label337:
      paramInt = 4;
      break;
      parame.setX(-i);
      parame.setY(-j);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.container.c
 * JD-Core Version:    0.7.0.1
 */