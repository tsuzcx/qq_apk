package com.tencent.mm.plugin.appbrand.jsapi.s;

import android.content.Context;
import android.view.View;

public abstract interface h<PipVideoContainer extends View>
{
  public abstract d Pz();
  
  public abstract PipVideoContainer aS(Context paramContext);
  
  public abstract void cf(PipVideoContainer paramPipVideoContainer);
  
  public abstract void cg(PipVideoContainer paramPipVideoContainer);
  
  public abstract void d(PipVideoContainer paramPipVideoContainer, Runnable paramRunnable);
  
  public abstract void e(PipVideoContainer paramPipVideoContainer, Runnable paramRunnable);
  
  public static abstract interface a<OriginVideoContainer extends g, PipVideoContainer extends View>
  {
    public abstract h<PipVideoContainer> a(OriginVideoContainer paramOriginVideoContainer);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.s.h
 * JD-Core Version:    0.7.0.1
 */