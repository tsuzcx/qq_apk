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
  protected l ctf;
  public j ctg;
  protected a cth;
  public Context mContext;
  
  public h(j paramj)
  {
    this.mContext = paramj.getContext();
    this.ctf = new l();
    this.ctg = paramj;
  }
  
  protected abstract View Lf();
  
  public final j Lg()
  {
    return this.ctg;
  }
  
  final void Lh()
  {
    this.ctf.Q(l.e.class);
  }
  
  public final void Li()
  {
    onForeground();
    this.ctf.Q(l.d.class);
  }
  
  public final void Lj()
  {
    onBackground();
    this.ctf.Q(l.b.class);
  }
  
  public final boolean Lk()
  {
    return (this.ctf.Q(l.a.class)) || (onBackPressed());
  }
  
  final void Ll()
  {
    onDestroy();
    this.ctf.Q(l.c.class);
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
    this.cth = parama;
  }
  
  protected abstract void destroy();
  
  final void g(Runnable paramRunnable)
  {
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(getContentView(), "translationX", new float[] { -(getContentView().getWidth() * 0.25F), 0.0F });
    localObjectAnimator.setDuration(250L);
    a(localObjectAnimator, paramRunnable);
  }
  
  public abstract void g(String paramString, Bundle paramBundle);
  
  public abstract View getContentView();
  
  public final Context getContext()
  {
    return this.mContext;
  }
  
  final void h(Runnable paramRunnable)
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
    protected a ctj;
    
    public a() {}
    
    protected a(a parama)
    {
      this.ctj = parama;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.luggage.d.h
 * JD-Core Version:    0.7.0.1
 */