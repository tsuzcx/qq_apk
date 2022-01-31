package com.tencent.mm.plugin.appbrand.jsapi.coverview;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.base.c;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.ab;
import org.json.JSONException;
import org.json.JSONObject;

public final class b
  extends c
{
  public static final int CTRL_INDEX = 342;
  public static final String NAME = "animateCoverView";
  
  public final boolean aCb()
  {
    return true;
  }
  
  public final boolean b(e parame, int paramInt, View paramView, JSONObject paramJSONObject, com.tencent.mm.plugin.appbrand.jsapi.base.g paramg)
  {
    AppMethodBeat.i(126292);
    for (;;)
    {
      String str;
      try
      {
        parame = paramJSONObject.getJSONObject("finalStyle");
        float f1 = com.tencent.mm.plugin.appbrand.s.g.a(parame, "left", com.tencent.mm.plugin.appbrand.s.g.az(paramView.getX()));
        float f2 = com.tencent.mm.plugin.appbrand.s.g.a(parame, "top", com.tencent.mm.plugin.appbrand.s.g.az(paramView.getY()));
        float f3 = (float)parame.optDouble("opacity", paramView.getAlpha());
        float f4 = (float)parame.optDouble("rotate", paramView.getRotation());
        float f5 = (float)parame.optDouble("scaleX", paramView.getScaleX());
        double d = parame.optDouble("scaleY", paramView.getScaleY());
        float f6 = (float)d;
        paramInt = paramJSONObject.optInt("duration", 300);
        str = paramJSONObject.optString("easing", "linear");
        paramJSONObject = ObjectAnimator.ofFloat(paramView, "x", new float[] { paramView.getX(), f1 });
        ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(paramView, "y", new float[] { paramView.getY(), f2 });
        ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(paramView, "alpha", new float[] { paramView.getAlpha(), f3 });
        ObjectAnimator localObjectAnimator3 = ObjectAnimator.ofFloat(paramView, "rotation", new float[] { paramView.getRotation(), f4 });
        ObjectAnimator localObjectAnimator4 = ObjectAnimator.ofFloat(paramView, "scaleX", new float[] { paramView.getScaleX(), f5 });
        ObjectAnimator localObjectAnimator5 = ObjectAnimator.ofFloat(paramView, "scaleY", new float[] { paramView.getScaleY(), f6 });
        AnimatorSet localAnimatorSet = new AnimatorSet();
        localAnimatorSet.setDuration(paramInt);
        paramView = null;
        parame = paramView;
        if (str != null)
        {
          if (str.equals("ease")) {
            parame = new AccelerateDecelerateInterpolator();
          }
        }
        else
        {
          paramView = parame;
          if (parame == null) {
            paramView = new LinearInterpolator();
          }
          localAnimatorSet.setInterpolator(paramView);
          localAnimatorSet.addListener(new b.1(this, paramg));
          localAnimatorSet.playTogether(new Animator[] { paramJSONObject, localObjectAnimator1, localObjectAnimator2, localObjectAnimator3, localObjectAnimator4, localObjectAnimator5 });
          localAnimatorSet.start();
          AppMethodBeat.o(126292);
          return true;
        }
      }
      catch (JSONException parame)
      {
        ab.w("MicroMsg.JsApiAnimateCoverView", "get finalStyle error : %s", new Object[] { Log.getStackTraceString(parame) });
        paramg.BS(j("fail:missing finalStyle", null));
        AppMethodBeat.o(126292);
        return false;
      }
      if (str.equals("ease-in"))
      {
        parame = new AccelerateInterpolator();
      }
      else
      {
        parame = paramView;
        if (str.equals("ease-out")) {
          parame = new DecelerateInterpolator();
        }
      }
    }
  }
  
  public final int w(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(126291);
    int i = paramJSONObject.getInt("viewId");
    AppMethodBeat.o(126291);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.coverview.b
 * JD-Core Version:    0.7.0.1
 */