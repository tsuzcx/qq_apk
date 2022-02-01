package com.tencent.mm.plugin.appbrand.jsapi.w;

import android.content.Context;
import android.view.View;

public abstract interface h<PipVideoContainer extends View>
{
  public abstract d atE();
  
  public abstract PipVideoContainer bz(Context paramContext);
  
  public abstract void cR(PipVideoContainer paramPipVideoContainer);
  
  public abstract void cS(PipVideoContainer paramPipVideoContainer);
  
  public abstract void d(PipVideoContainer paramPipVideoContainer, Runnable paramRunnable);
  
  public abstract void e(PipVideoContainer paramPipVideoContainer, Runnable paramRunnable);
  
  public static abstract interface a<OriginVideoContainer extends g, PipVideoContainer extends View>
  {
    public abstract h<PipVideoContainer> a(OriginVideoContainer paramOriginVideoContainer);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.w.h
 * JD-Core Version:    0.7.0.1
 */