package com.tencent.mm.plugin.appbrand.page.a;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.animation.AccelerateInterpolator;

public abstract class a
  implements c
{
  public static Animator cJ(View paramView)
  {
    paramView = ObjectAnimator.ofFloat(paramView, "alpha", new float[] { 1.0F, 0.0F, 1.0F });
    paramView.setDuration(2000L);
    paramView.setInterpolator(new AccelerateInterpolator());
    paramView.setRepeatCount(-1);
    paramView.setRepeatMode(1);
    return paramView;
  }
  
  protected abstract void A(CharSequence paramCharSequence);
  
  protected abstract void N(Runnable paramRunnable);
  
  protected abstract Context getContext();
  
  protected abstract void ug(int paramInt);
  
  protected abstract void x(Drawable paramDrawable);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.a.a
 * JD-Core Version:    0.7.0.1
 */