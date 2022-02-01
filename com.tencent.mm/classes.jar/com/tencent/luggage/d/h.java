package com.tencent.luggage.d;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract class h
{
  protected l chl;
  public j chm;
  protected a chn;
  public Context mContext;
  
  public h(j paramj)
  {
    this.mContext = paramj.getContext();
    this.chl = new l();
    this.chm = paramj;
  }
  
  protected abstract View BQ();
  
  final void BR()
  {
    this.chl.O(l.e.class);
  }
  
  public final void BS()
  {
    onForeground();
    this.chl.O(l.d.class);
  }
  
  public final void BT()
  {
    onBackground();
    this.chl.O(l.b.class);
  }
  
  final boolean BU()
  {
    return (this.chl.O(l.a.class)) || (onBackPressed());
  }
  
  final void BV()
  {
    onDestroy();
    this.chl.O(l.c.class);
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
    this.chn = parama;
  }
  
  protected abstract void destroy();
  
  public abstract void g(String paramString, Bundle paramBundle);
  
  public abstract View getContentView();
  
  public final Context getContext()
  {
    return this.mContext;
  }
  
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
    protected a chp;
    
    public a() {}
    
    protected a(a parama)
    {
      this.chp = parama;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.luggage.d.h
 * JD-Core Version:    0.7.0.1
 */