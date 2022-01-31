package com.tencent.luggage.e;

import android.animation.Animator;
import android.content.Context;
import android.os.Bundle;
import android.view.View;

public abstract class e
{
  public i bik;
  public g bil;
  protected e.a bim;
  public Context mContext;
  
  public e(g paramg)
  {
    this.mContext = paramg.getContext();
    this.bik = new i();
    this.bil = paramg;
  }
  
  final void a(Animator paramAnimator, Runnable paramRunnable)
  {
    paramAnimator.addListener(new e.1(this, paramRunnable));
    paramAnimator.start();
  }
  
  public void a(e.a parama)
  {
    this.bim = parama;
  }
  
  public abstract void c(String paramString, Bundle paramBundle);
  
  abstract void destroy();
  
  public abstract View getContentView();
  
  public void onDestroy() {}
  
  public abstract View pW();
  
  final void pX()
  {
    pY();
    this.bik.k(i.d.class);
  }
  
  public void pY() {}
  
  final void pZ()
  {
    qa();
    this.bik.k(i.b.class);
  }
  
  public void qa() {}
  
  final boolean qb()
  {
    return (this.bik.k(i.a.class)) || (qc());
  }
  
  protected boolean qc()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.luggage.e.e
 * JD-Core Version:    0.7.0.1
 */