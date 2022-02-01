package com.tencent.mm.plugin.appbrand.page.capsulebar;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.animation.AccelerateInterpolator;

public abstract class h
  implements m
{
  public static Animator dF(View paramView)
  {
    paramView = ObjectAnimator.ofFloat(paramView, "alpha", new float[] { 1.0F, 0.0F, 1.0F });
    paramView.setDuration(2000L);
    paramView.setInterpolator(new AccelerateInterpolator());
    paramView.setRepeatCount(-1);
    paramView.setRepeatMode(1);
    return paramView;
  }
  
  protected abstract void CM(int paramInt);
  
  protected abstract void M(Drawable paramDrawable);
  
  protected abstract void P(CharSequence paramCharSequence);
  
  protected abstract void V(Runnable paramRunnable);
  
  protected abstract Context getContext();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.capsulebar.h
 * JD-Core Version:    0.7.0.1
 */