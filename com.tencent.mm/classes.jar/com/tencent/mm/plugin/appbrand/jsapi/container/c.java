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
import com.tencent.mm.plugin.appbrand.jsapi.base.d;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONException;
import org.json.JSONObject;

public final class c
  extends d
{
  public static final int CTRL_INDEX = 510;
  public static final String NAME = "updatePositioningContainer";
  
  public final int K(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(137515);
    int i = paramJSONObject.getInt("containerId");
    AppMethodBeat.o(137515);
    return i;
  }
  
  public final boolean c(final com.tencent.mm.plugin.appbrand.jsapi.g paramg, int paramInt, View paramView, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(137514);
    if (!(paramView instanceof WrapperNativeContainerView))
    {
      AppMethodBeat.o(137514);
      return false;
    }
    int i = com.tencent.mm.plugin.appbrand.ac.g.a(paramJSONObject, "contentOffsetLeft", 0);
    int j = com.tencent.mm.plugin.appbrand.ac.g.a(paramJSONObject, "contentOffsetTop", 0);
    int k = paramJSONObject.optInt("animate", 0);
    paramg = (WrapperNativeContainerView)paramView;
    try
    {
      if (!paramJSONObject.getBoolean("visible")) {
        break label337;
      }
      paramInt = 0;
      paramg.setVisibility(paramInt);
    }
    catch (JSONException paramView)
    {
      label71:
      ObjectAnimator localObjectAnimator;
      AnimatorSet localAnimatorSet;
      break label71;
    }
    paramg = (AppBrandNativeContainerView)paramg.aA(AppBrandNativeContainerView.class);
    Log.i("MicroMsg.JsApiUpdatePositioningContainer", "scrollLeft:%d, scrollTop:%d, animation:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) });
    if (k == 1)
    {
      paramView = ObjectAnimator.ofFloat(paramg, "x", new float[] { paramg.getX(), -i });
      localObjectAnimator = ObjectAnimator.ofFloat(paramg, "y", new float[] { paramg.getY(), -j });
      paramView.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(137509);
          float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          paramg.setX(f);
          AppMethodBeat.o(137509);
        }
      });
      localObjectAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(137510);
          float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          paramg.setY(f);
          AppMethodBeat.o(137510);
        }
      });
      localAnimatorSet = new AnimatorSet();
      localAnimatorSet.setDuration(1000L);
      localAnimatorSet.setInterpolator(new a());
      localAnimatorSet.setTarget(paramg);
      localAnimatorSet.playTogether(new Animator[] { paramView, localObjectAnimator });
      localAnimatorSet.start();
    }
    for (;;)
    {
      paramInt = com.tencent.mm.plugin.appbrand.ac.g.a(paramJSONObject, "innerHeight", paramg.getHeight());
      i = com.tencent.mm.plugin.appbrand.ac.g.a(paramJSONObject, "innerWidth", paramg.getWidth());
      Log.i("MicroMsg.JsApiUpdatePositioningContainer", "innerHeight:%d, innerWidth:%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
      paramView = paramg.getLayoutParams();
      paramView.height = paramInt;
      paramView.width = i;
      paramg.setLayoutParams(paramView);
      AppMethodBeat.o(137514);
      return true;
      label337:
      paramInt = 4;
      break;
      paramg.setX(-i);
      paramg.setY(-j);
    }
  }
  
  public final class a
    implements Interpolator
  {
    private int oPp;
    private final PointF oPq;
    private final PointF oPr;
    protected PointF oPs;
    protected PointF oPt;
    protected PointF oPu;
    protected PointF oPv;
    protected PointF oPw;
    
    public a()
    {
      this(new PointF(0.0F, 0.0F), new PointF(0.58F, 1.0F));
      AppMethodBeat.i(137512);
      AppMethodBeat.o(137512);
    }
    
    private a(PointF paramPointF1, PointF paramPointF2)
    {
      AppMethodBeat.i(137511);
      this.oPp = 0;
      this.oPq = new PointF();
      this.oPr = new PointF();
      this.oPu = new PointF();
      this.oPv = new PointF();
      this.oPw = new PointF();
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
      this.oPs = paramPointF1;
      this.oPt = paramPointF2;
      AppMethodBeat.o(137511);
    }
    
    public final float getInterpolation(float paramFloat)
    {
      AppMethodBeat.i(137513);
      int i = 1;
      float f1 = paramFloat;
      while (i < 14)
      {
        this.oPw.x = (this.oPs.x * 3.0F);
        this.oPv.x = ((this.oPt.x - this.oPs.x) * 3.0F - this.oPw.x);
        this.oPu.x = (1.0F - this.oPw.x - this.oPv.x);
        f2 = (this.oPw.x + (this.oPv.x + this.oPu.x * f1) * f1) * f1 - paramFloat;
        if (Math.abs(f2) < 0.001D) {
          break;
        }
        f1 -= f2 / (this.oPw.x + (2.0F * this.oPv.x + this.oPu.x * 3.0F * f1) * f1);
        i += 1;
      }
      this.oPw.y = (this.oPs.y * 3.0F);
      this.oPv.y = ((this.oPt.y - this.oPs.y) * 3.0F - this.oPw.y);
      this.oPu.y = (1.0F - this.oPw.y - this.oPv.y);
      paramFloat = this.oPw.y;
      float f2 = this.oPv.y;
      float f3 = this.oPu.y;
      AppMethodBeat.o(137513);
      return (paramFloat + (f2 + f3 * f1) * f1) * f1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.container.c
 * JD-Core Version:    0.7.0.1
 */