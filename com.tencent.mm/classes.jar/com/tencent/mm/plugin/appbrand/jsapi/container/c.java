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
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.z.g;
import com.tencent.mm.sdk.platformtools.ac;
import org.json.JSONException;
import org.json.JSONObject;

public final class c
  extends com.tencent.mm.plugin.appbrand.jsapi.base.c
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
  
  public final boolean c(final e parame, int paramInt, View paramView, JSONObject paramJSONObject)
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
    ac.i("MicroMsg.JsApiUpdatePositioningContainer", "scrollLeft:%d, scrollTop:%d, animation:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) });
    if (k == 1)
    {
      paramView = ObjectAnimator.ofFloat(parame, "x", new float[] { parame.getX(), -i });
      localObjectAnimator = ObjectAnimator.ofFloat(parame, "y", new float[] { parame.getY(), -j });
      paramView.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(137509);
          float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          parame.setX(f);
          AppMethodBeat.o(137509);
        }
      });
      localObjectAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(137510);
          float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          parame.setY(f);
          AppMethodBeat.o(137510);
        }
      });
      localAnimatorSet = new AnimatorSet();
      localAnimatorSet.setDuration(1000L);
      localAnimatorSet.setInterpolator(new a());
      localAnimatorSet.setTarget(parame);
      localAnimatorSet.playTogether(new Animator[] { paramView, localObjectAnimator });
      localAnimatorSet.start();
    }
    for (;;)
    {
      paramInt = g.a(paramJSONObject, "innerHeight", parame.getHeight());
      i = g.a(paramJSONObject, "innerWidth", parame.getWidth());
      ac.i("MicroMsg.JsApiUpdatePositioningContainer", "innerHeight:%d, innerWidth:%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
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
  
  public final class a
    implements Interpolator
  {
    private int kpB;
    private final PointF kpC;
    private final PointF kpD;
    protected PointF kpE;
    protected PointF kpF;
    protected PointF kpG;
    protected PointF kpH;
    protected PointF kpI;
    
    public a()
    {
      this(new PointF(0.0F, 0.0F), new PointF(0.58F, 1.0F));
      AppMethodBeat.i(137512);
      AppMethodBeat.o(137512);
    }
    
    private a(PointF paramPointF1, PointF paramPointF2)
    {
      AppMethodBeat.i(137511);
      this.kpB = 0;
      this.kpC = new PointF();
      this.kpD = new PointF();
      this.kpG = new PointF();
      this.kpH = new PointF();
      this.kpI = new PointF();
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
      this.kpE = paramPointF1;
      this.kpF = paramPointF2;
      AppMethodBeat.o(137511);
    }
    
    public final float getInterpolation(float paramFloat)
    {
      AppMethodBeat.i(137513);
      int i = 1;
      float f1 = paramFloat;
      while (i < 14)
      {
        this.kpI.x = (this.kpE.x * 3.0F);
        this.kpH.x = ((this.kpF.x - this.kpE.x) * 3.0F - this.kpI.x);
        this.kpG.x = (1.0F - this.kpI.x - this.kpH.x);
        f2 = (this.kpI.x + (this.kpH.x + this.kpG.x * f1) * f1) * f1 - paramFloat;
        if (Math.abs(f2) < 0.001D) {
          break;
        }
        f1 -= f2 / (this.kpI.x + (2.0F * this.kpH.x + this.kpG.x * 3.0F * f1) * f1);
        i += 1;
      }
      this.kpI.y = (this.kpE.y * 3.0F);
      this.kpH.y = ((this.kpF.y - this.kpE.y) * 3.0F - this.kpI.y);
      this.kpG.y = (1.0F - this.kpI.y - this.kpH.y);
      paramFloat = this.kpI.y;
      float f2 = this.kpH.y;
      float f3 = this.kpG.y;
      AppMethodBeat.o(137513);
      return (paramFloat + (f2 + f3 * f1) * f1) * f1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.container.c
 * JD-Core Version:    0.7.0.1
 */