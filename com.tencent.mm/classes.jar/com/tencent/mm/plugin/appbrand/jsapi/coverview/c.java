package com.tencent.mm.plugin.appbrand.jsapi.coverview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public final class c
  extends com.tencent.mm.plugin.appbrand.jsapi.base.c
{
  public static final int CTRL_INDEX = 342;
  public static final String NAME = "animateCoverView";
  
  public final int A(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(137519);
    int i = paramJSONObject.getInt("viewId");
    AppMethodBeat.o(137519);
    return i;
  }
  
  public final boolean b(e parame, int paramInt, final View paramView, JSONObject paramJSONObject, final com.tencent.mm.plugin.appbrand.jsapi.base.g paramg)
  {
    AppMethodBeat.i(137520);
    int i = -1;
    for (;;)
    {
      String str;
      try
      {
        parame = paramJSONObject.getJSONObject("finalStyle");
        float f1 = com.tencent.mm.plugin.appbrand.z.g.a(parame, "left", com.tencent.mm.plugin.appbrand.z.g.aF(paramView.getX()));
        float f2 = com.tencent.mm.plugin.appbrand.z.g.a(parame, "top", com.tencent.mm.plugin.appbrand.z.g.aF(paramView.getY()));
        float f3 = (float)parame.optDouble("opacity", paramView.getAlpha());
        float f4 = (float)parame.optDouble("rotate", paramView.getRotation());
        float f5 = (float)parame.optDouble("scaleX", paramView.getScaleX());
        float f6 = (float)parame.optDouble("scaleY", paramView.getScaleY());
        if (!parame.has("width")) {
          break label638;
        }
        paramInt = com.tencent.mm.plugin.appbrand.z.g.a(parame, "width", com.tencent.mm.plugin.appbrand.z.g.vd(paramView.getWidth()));
        if (parame.has("height")) {
          i = com.tencent.mm.plugin.appbrand.z.g.a(parame, "height", com.tencent.mm.plugin.appbrand.z.g.vd(paramView.getWidth()));
        }
        int j = paramJSONObject.optInt("duration", 300);
        str = paramJSONObject.optString("easing", "linear");
        ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(paramView, "x", new float[] { paramView.getX(), f1 });
        ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(paramView, "y", new float[] { paramView.getY(), f2 });
        ObjectAnimator localObjectAnimator3 = ObjectAnimator.ofFloat(paramView, "alpha", new float[] { paramView.getAlpha(), f3 });
        ObjectAnimator localObjectAnimator4 = ObjectAnimator.ofFloat(paramView, "rotation", new float[] { paramView.getRotation(), f4 });
        ObjectAnimator localObjectAnimator5 = ObjectAnimator.ofFloat(paramView, "scaleX", new float[] { paramView.getScaleX(), f5 });
        ObjectAnimator localObjectAnimator6 = ObjectAnimator.ofFloat(paramView, "scaleY", new float[] { paramView.getScaleY(), f6 });
        AnimatorSet localAnimatorSet = new AnimatorSet();
        localAnimatorSet.setDuration(j);
        paramJSONObject = null;
        parame = paramJSONObject;
        if (str != null)
        {
          if (str.equals("ease")) {
            parame = new AccelerateDecelerateInterpolator();
          }
        }
        else
        {
          paramJSONObject = parame;
          if (parame == null) {
            paramJSONObject = new LinearInterpolator();
          }
          localAnimatorSet.setInterpolator(paramJSONObject);
          localAnimatorSet.addListener(new AnimatorListenerAdapter()
          {
            public final void onAnimationEnd(Animator paramAnonymousAnimator)
            {
              AppMethodBeat.i(137518);
              paramg.LV(c.this.e("ok", null));
              AppMethodBeat.o(137518);
            }
          });
          parame = new ArrayList();
          parame.add(localObjectAnimator1);
          parame.add(localObjectAnimator2);
          parame.add(localObjectAnimator3);
          parame.add(localObjectAnimator4);
          parame.add(localObjectAnimator5);
          parame.add(localObjectAnimator6);
          if (paramInt != -1)
          {
            paramJSONObject = ValueAnimator.ofInt(new int[] { paramView.getWidth(), paramInt });
            parame.add(paramJSONObject);
            paramJSONObject.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
            {
              public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
              {
                AppMethodBeat.i(206794);
                paramAnonymousValueAnimator = (Integer)paramAnonymousValueAnimator.getAnimatedValue();
                paramView.getLayoutParams().width = paramAnonymousValueAnimator.intValue();
                paramView.requestLayout();
                AppMethodBeat.o(206794);
              }
            });
          }
          if (i != -1)
          {
            paramJSONObject = ValueAnimator.ofInt(new int[] { paramView.getHeight(), i });
            parame.add(paramJSONObject);
            paramJSONObject.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
            {
              public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
              {
                AppMethodBeat.i(206795);
                paramAnonymousValueAnimator = (Integer)paramAnonymousValueAnimator.getAnimatedValue();
                paramView.getLayoutParams().height = paramAnonymousValueAnimator.intValue();
                paramView.requestLayout();
                AppMethodBeat.o(206795);
              }
            });
          }
          localAnimatorSet.playTogether(parame);
          localAnimatorSet.start();
          AppMethodBeat.o(137520);
          return true;
        }
      }
      catch (JSONException parame)
      {
        ac.w("MicroMsg.JsApiAnimateCoverView", "get finalStyle error : %s", new Object[] { Log.getStackTraceString(parame) });
        paramg.LV(e("fail:missing finalStyle", null));
        AppMethodBeat.o(137520);
        return false;
      }
      if (str.equals("ease-in"))
      {
        parame = new AccelerateInterpolator();
      }
      else
      {
        parame = paramJSONObject;
        if (str.equals("ease-out"))
        {
          parame = new DecelerateInterpolator();
          continue;
          label638:
          paramInt = -1;
        }
      }
    }
  }
  
  public final boolean bft()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.coverview.c
 * JD-Core Version:    0.7.0.1
 */