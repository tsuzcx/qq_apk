package com.tencent.mm.plugin.appbrand.jsapi.container;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.PointF;
import android.view.View;
import android.view.animation.Interpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.g;
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
  
  public final int H(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(137515);
    int i = paramJSONObject.getInt("containerId");
    AppMethodBeat.o(137515);
    return i;
  }
  
  public final boolean c(final h paramh, int paramInt, View paramView, JSONObject paramJSONObject)
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
    paramh = (AppBrandNativeContainerView)paramh.aB(AppBrandNativeContainerView.class);
    Log.i("MicroMsg.JsApiUpdatePositioningContainer", "scrollLeft:%d, scrollTop:%d, animation:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) });
    if (k == 1)
    {
      paramView = ObjectAnimator.ofFloat(paramh, "x", new float[] { paramh.getX(), -i });
      localObjectAnimator = ObjectAnimator.ofFloat(paramh, "y", new float[] { paramh.getY(), -j });
      paramView.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(137509);
          float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          paramh.setX(f);
          AppMethodBeat.o(137509);
        }
      });
      localObjectAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(137510);
          float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          paramh.setY(f);
          AppMethodBeat.o(137510);
        }
      });
      localAnimatorSet = new AnimatorSet();
      localAnimatorSet.setDuration(1000L);
      localAnimatorSet.setInterpolator(new a());
      localAnimatorSet.setTarget(paramh);
      localAnimatorSet.playTogether(new Animator[] { paramView, localObjectAnimator });
      localAnimatorSet.start();
    }
    for (;;)
    {
      paramInt = g.a(paramJSONObject, "innerHeight", paramh.getHeight());
      i = g.a(paramJSONObject, "innerWidth", paramh.getWidth());
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
  
  public final class a
    implements Interpolator
  {
    private int lSG;
    private final PointF lSH;
    private final PointF lSI;
    protected PointF lSJ;
    protected PointF lSK;
    protected PointF lSL;
    protected PointF lSM;
    protected PointF lSN;
    
    public a()
    {
      this(new PointF(0.0F, 0.0F), new PointF(0.58F, 1.0F));
      AppMethodBeat.i(137512);
      AppMethodBeat.o(137512);
    }
    
    private a(PointF paramPointF1, PointF paramPointF2)
    {
      AppMethodBeat.i(137511);
      this.lSG = 0;
      this.lSH = new PointF();
      this.lSI = new PointF();
      this.lSL = new PointF();
      this.lSM = new PointF();
      this.lSN = new PointF();
      if ((paramPointF1.x < 0.0F) || (paramPointF1.x > 1.0F))
      {
        this$1 = new IllegalArgumentException("startX value must be in the range [0, 1]");
        AppMethodBeat.o(137511);
        throw c.this;
      }
      if ((paramPointF2.x < 0.0F) || (paramPointF2.x > 1.0F))
      {
        this$1 = new IllegalArgumentException("endX value must be in the range [0, 1]");
        AppMethodBeat.o(137511);
        throw c.this;
      }
      this.lSJ = paramPointF1;
      this.lSK = paramPointF2;
      AppMethodBeat.o(137511);
    }
    
    public final float getInterpolation(float paramFloat)
    {
      AppMethodBeat.i(137513);
      int i = 1;
      float f1 = paramFloat;
      while (i < 14)
      {
        this.lSN.x = (this.lSJ.x * 3.0F);
        this.lSM.x = ((this.lSK.x - this.lSJ.x) * 3.0F - this.lSN.x);
        this.lSL.x = (1.0F - this.lSN.x - this.lSM.x);
        f2 = (this.lSN.x + (this.lSM.x + this.lSL.x * f1) * f1) * f1 - paramFloat;
        if (Math.abs(f2) < 0.001D) {
          break;
        }
        f1 -= f2 / (this.lSN.x + (2.0F * this.lSM.x + this.lSL.x * 3.0F * f1) * f1);
        i += 1;
      }
      this.lSN.y = (this.lSJ.y * 3.0F);
      this.lSM.y = ((this.lSK.y - this.lSJ.y) * 3.0F - this.lSN.y);
      this.lSL.y = (1.0F - this.lSN.y - this.lSM.y);
      paramFloat = this.lSN.y;
      float f2 = this.lSM.y;
      float f3 = this.lSL.y;
      AppMethodBeat.o(137513);
      return (paramFloat + (f2 + f3 * f1) * f1) * f1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.container.c
 * JD-Core Version:    0.7.0.1
 */