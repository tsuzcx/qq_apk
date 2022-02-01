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
  protected l ejd;
  public j eje;
  protected a ejf;
  public Context mContext;
  
  public h(j paramj)
  {
    this.mContext = paramj.getContext();
    this.ejd = new l();
    this.eje = paramj;
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
    this.ejf = parama;
  }
  
  protected abstract View aog();
  
  public final void aoh()
  {
    onForeground();
    this.ejd.Y(l.d.class);
  }
  
  public final void aoi()
  {
    onBackground();
    this.ejd.Y(l.b.class);
  }
  
  public final boolean aoj()
  {
    return (this.ejd.Y(l.a.class)) || (onBackPressed());
  }
  
  final void aok()
  {
    onDestroy();
    this.ejd.Y(l.c.class);
  }
  
  protected abstract void destroy();
  
  public abstract View getContentView();
  
  public final Context getContext()
  {
    return this.mContext;
  }
  
  final void i(Runnable paramRunnable)
  {
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(getContentView(), "translationX", new float[] { -(getContentView().getWidth() * 0.25F), 0.0F });
    localObjectAnimator.setDuration(250L);
    a(localObjectAnimator, paramRunnable);
  }
  
  final void j(Runnable paramRunnable)
  {
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(getContentView(), "translationX", new float[] { 0.0F, getContentView().getWidth() });
    localObjectAnimator.setDuration(250L);
    a(localObjectAnimator, paramRunnable);
  }
  
  public abstract void l(String paramString, Bundle paramBundle);
  
  protected boolean onBackPressed()
  {
    return false;
  }
  
  protected void onBackground() {}
  
  protected void onDestroy() {}
  
  protected void onForeground() {}
  
  public static class a
  {
    protected a ejh;
    
    public a() {}
    
    protected a(a parama)
    {
      this.ejh = parama;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.luggage.d.h
 * JD-Core Version:    0.7.0.1
 */