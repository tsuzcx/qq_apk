package com.tencent.mm.plugin.appbrand.jsapi.coverview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.g;
import com.tencent.mm.plugin.appbrand.jsapi.base.d;
import com.tencent.mm.plugin.appbrand.jsapi.base.i;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public final class e
  extends d
{
  public static final int CTRL_INDEX = 342;
  public static final String NAME = "animateCoverView";
  
  public final int H(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(137519);
    int i = paramJSONObject.getInt("viewId");
    AppMethodBeat.o(137519);
    return i;
  }
  
  public final boolean b(h paramh, int paramInt, View paramView, JSONObject paramJSONObject, final i parami)
  {
    AppMethodBeat.i(137520);
    int i = -1;
    for (;;)
    {
      String str;
      try
      {
        paramh = paramJSONObject.getJSONObject("finalStyle");
        float f1 = g.a(paramh, "left", g.aS(paramView.getX()));
        float f2 = g.a(paramh, "top", g.aS(paramView.getY()));
        float f3 = (float)paramh.optDouble("opacity", paramView.getAlpha());
        float f4 = (float)paramh.optDouble("rotate", paramView.getRotation());
        float f5 = (float)paramh.optDouble("scaleX", paramView.getScaleX());
        float f6 = (float)paramh.optDouble("scaleY", paramView.getScaleY());
        if (!paramh.has("width")) {
          break label638;
        }
        paramInt = g.a(paramh, "width", g.zC(paramView.getWidth()));
        if (paramh.has("height")) {
          i = g.a(paramh, "height", g.zC(paramView.getWidth()));
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
        paramh = paramJSONObject;
        if (str != null)
        {
          if (str.equals("ease")) {
            paramh = new AccelerateDecelerateInterpolator();
          }
        }
        else
        {
          paramJSONObject = paramh;
          if (paramh == null) {
            paramJSONObject = new LinearInterpolator();
          }
          localAnimatorSet.setInterpolator(paramJSONObject);
          localAnimatorSet.addListener(new AnimatorListenerAdapter()
          {
            public final void onAnimationEnd(Animator paramAnonymousAnimator)
            {
              AppMethodBeat.i(137518);
              parami.ZA(e.this.h("ok", null));
              AppMethodBeat.o(137518);
            }
          });
          paramh = new ArrayList();
          paramh.add(localObjectAnimator1);
          paramh.add(localObjectAnimator2);
          paramh.add(localObjectAnimator3);
          paramh.add(localObjectAnimator4);
          paramh.add(localObjectAnimator5);
          paramh.add(localObjectAnimator6);
          if (paramInt != -1)
          {
            paramJSONObject = ValueAnimator.ofInt(new int[] { paramView.getWidth(), paramInt });
            paramh.add(paramJSONObject);
            paramJSONObject.addUpdateListener(new e.2(this, paramView));
          }
          if (i != -1)
          {
            paramJSONObject = ValueAnimator.ofInt(new int[] { paramView.getHeight(), i });
            paramh.add(paramJSONObject);
            paramJSONObject.addUpdateListener(new e.3(this, paramView));
          }
          localAnimatorSet.playTogether(paramh);
          localAnimatorSet.start();
          AppMethodBeat.o(137520);
          return true;
        }
      }
      catch (JSONException paramh)
      {
        com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.JsApiAnimateCoverView", "get finalStyle error : %s", new Object[] { android.util.Log.getStackTraceString(paramh) });
        parami.ZA(h("fail:missing finalStyle", null));
        AppMethodBeat.o(137520);
        return false;
      }
      if (str.equals("ease-in"))
      {
        paramh = new AccelerateInterpolator();
      }
      else
      {
        paramh = paramJSONObject;
        if (str.equals("ease-out"))
        {
          paramh = new DecelerateInterpolator();
          continue;
          label638:
          paramInt = -1;
        }
      }
    }
  }
  
  public final boolean bEV()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.coverview.e
 * JD-Core Version:    0.7.0.1
 */