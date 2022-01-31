package com.tencent.luggage.d;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Bundle;
import android.view.View;

public abstract class e
{
  protected i byI;
  public g byJ;
  protected e.a byK;
  public Context mContext;
  
  public e(g paramg)
  {
    this.mContext = paramg.getContext();
    this.byI = new i();
    this.byJ = paramg;
  }
  
  final void a(Animator paramAnimator, Runnable paramRunnable)
  {
    paramAnimator.addListener(new e.1(this, paramRunnable));
    paramAnimator.start();
  }
  
  public void a(e.a parama)
  {
    this.byK = parama;
  }
  
  abstract void destroy();
  
  final void f(Runnable paramRunnable)
  {
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(getContentView(), "translationX", new float[] { -(getContentView().getWidth() * 0.25F), 0.0F });
    localObjectAnimator.setDuration(250L);
    a(localObjectAnimator, paramRunnable);
  }
  
  final void g(Runnable paramRunnable)
  {
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(getContentView(), "translationX", new float[] { 0.0F, getContentView().getWidth() });
    localObjectAnimator.setDuration(250L);
    a(localObjectAnimator, paramRunnable);
  }
  
  public abstract void g(String paramString, Bundle paramBundle);
  
  public abstract View getContentView();
  
  protected boolean onBackPressed()
  {
    return false;
  }
  
  protected void onBackground() {}
  
  protected void onDestroy() {}
  
  protected void onForeground() {}
  
  protected abstract View tZ();
  
  final void ua()
  {
    this.byI.u(i.e.class);
  }
  
  public final void ub()
  {
    onForeground();
    this.byI.u(i.d.class);
  }
  
  final void uc()
  {
    onBackground();
    this.byI.u(i.b.class);
  }
  
  final boolean ud()
  {
    return (this.byI.u(i.a.class)) || (onBackPressed());
  }
  
  final void ue()
  {
    onDestroy();
    this.byI.u(i.c.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.luggage.d.e
 * JD-Core Version:    0.7.0.1
 */