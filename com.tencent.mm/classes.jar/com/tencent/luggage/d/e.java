package com.tencent.luggage.d;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract class e
{
  protected i bWV;
  public g bWW;
  protected a bWX;
  public Context mContext;
  
  public e(g paramg)
  {
    this.mContext = paramg.getContext();
    this.bWV = new i();
    this.bWW = paramg;
  }
  
  protected abstract View Ar();
  
  final void As()
  {
    this.bWV.O(i.e.class);
  }
  
  public final void At()
  {
    onForeground();
    this.bWV.O(i.d.class);
  }
  
  final void Au()
  {
    onBackground();
    this.bWV.O(i.b.class);
  }
  
  final boolean Av()
  {
    return (this.bWV.O(i.a.class)) || (onBackPressed());
  }
  
  final void Aw()
  {
    onDestroy();
    this.bWV.O(i.c.class);
  }
  
  final void a(Animator paramAnimator, final Runnable paramRunnable)
  {
    paramAnimator.addListener(new AnimatorListenerAdapter()
    {
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(140373);
        if (paramRunnable != null) {
          paramRunnable.run();
        }
        AppMethodBeat.o(140373);
      }
    });
    paramAnimator.start();
  }
  
  public void a(a parama)
  {
    this.bWX = parama;
  }
  
  protected abstract void destroy();
  
  public abstract void g(String paramString, Bundle paramBundle);
  
  public abstract View getContentView();
  
  final void h(Runnable paramRunnable)
  {
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(getContentView(), "translationX", new float[] { -(getContentView().getWidth() * 0.25F), 0.0F });
    localObjectAnimator.setDuration(250L);
    a(localObjectAnimator, paramRunnable);
  }
  
  final void i(Runnable paramRunnable)
  {
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(getContentView(), "translationX", new float[] { 0.0F, getContentView().getWidth() });
    localObjectAnimator.setDuration(250L);
    a(localObjectAnimator, paramRunnable);
  }
  
  protected boolean onBackPressed()
  {
    return false;
  }
  
  protected void onBackground() {}
  
  protected void onDestroy() {}
  
  protected void onForeground() {}
  
  public static class a
  {
    protected a bWZ;
    
    public a() {}
    
    protected a(a parama)
    {
      this.bWZ = parama;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.luggage.d.e
 * JD-Core Version:    0.7.0.1
 */