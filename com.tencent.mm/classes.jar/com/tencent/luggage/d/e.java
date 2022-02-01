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
  protected i bZY;
  public g bZZ;
  protected a caa;
  public Context mContext;
  
  public e(g paramg)
  {
    this.mContext = paramg.getContext();
    this.bZY = new i();
    this.bZZ = paramg;
  }
  
  protected abstract View AN();
  
  final void AO()
  {
    this.bZY.O(i.e.class);
  }
  
  public final void AP()
  {
    onForeground();
    this.bZY.O(i.d.class);
  }
  
  final void AQ()
  {
    onBackground();
    this.bZY.O(i.b.class);
  }
  
  final boolean AR()
  {
    return (this.bZY.O(i.a.class)) || (onBackPressed());
  }
  
  final void AS()
  {
    onDestroy();
    this.bZY.O(i.c.class);
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
    this.caa = parama;
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
    protected a cac;
    
    public a() {}
    
    protected a(a parama)
    {
      this.cac = parama;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.luggage.d.e
 * JD-Core Version:    0.7.0.1
 */