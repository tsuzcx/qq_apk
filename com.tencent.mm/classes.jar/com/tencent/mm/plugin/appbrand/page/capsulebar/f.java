package com.tencent.mm.plugin.appbrand.page.capsulebar;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.animation.AccelerateInterpolator;

public abstract class f
  implements i
{
  public static Animator cF(View paramView)
  {
    paramView = ObjectAnimator.ofFloat(paramView, "alpha", new float[] { 1.0F, 0.0F, 1.0F });
    paramView.setDuration(2000L);
    paramView.setInterpolator(new AccelerateInterpolator());
    paramView.setRepeatCount(-1);
    paramView.setRepeatMode(1);
    return paramView;
  }
  
  protected abstract void E(CharSequence paramCharSequence);
  
  protected abstract void P(Runnable paramRunnable);
  
  protected abstract Context getContext();
  
  protected abstract void y(Drawable paramDrawable);
  
  protected abstract void yS(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.capsulebar.f
 * JD-Core Version:    0.7.0.1
 */