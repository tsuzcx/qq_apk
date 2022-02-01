package com.tencent.mm.plugin.appbrand.jsapi.coverview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.base.d;
import com.tencent.mm.plugin.appbrand.jsapi.base.i;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.z.g;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public final class c
  extends d
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
  
  public final boolean b(e parame, int paramInt, View paramView, JSONObject paramJSONObject, final i parami)
  {
    AppMethodBeat.i(137520);
    int i = -1;
    for (;;)
    {
      String str;
      try
      {
        parame = paramJSONObject.getJSONObject("finalStyle");
        float f1 = g.a(parame, "left", g.aI(paramView.getX()));
        float f2 = g.a(parame, "top", g.aI(paramView.getY()));
        float f3 = (float)parame.optDouble("opacity", paramView.getAlpha());
        float f4 = (float)parame.optDouble("rotate", paramView.getRotation());
        float f5 = (float)parame.optDouble("scaleX", paramView.getScaleX());
        float f6 = (float)parame.optDouble("scaleY", paramView.getScaleY());
        if (!parame.has("width")) {
          break label638;
        }
        paramInt = g.a(parame, "width", g.vI(paramView.getWidth()));
        if (parame.has("height")) {
          i = g.a(parame, "height", g.vI(paramView.getWidth()));
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
              parami.Pr(c.this.e("ok", null));
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
            paramJSONObject.addUpdateListener(new c.2(this, paramView));
          }
          if (i != -1)
          {
            paramJSONObject = ValueAnimator.ofInt(new int[] { paramView.getHeight(), i });
            parame.add(paramJSONObject);
            paramJSONObject.addUpdateListener(new c.3(this, paramView));
          }
          localAnimatorSet.playTogether(parame);
          localAnimatorSet.start();
          AppMethodBeat.o(137520);
          return true;
        }
      }
      catch (JSONException parame)
      {
        ad.w("MicroMsg.JsApiAnimateCoverView", "get finalStyle error : %s", new Object[] { Log.getStackTraceString(parame) });
        parami.Pr(e("fail:missing finalStyle", null));
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
  
  public final boolean biW()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.coverview.c
 * JD-Core Version:    0.7.0.1
 */