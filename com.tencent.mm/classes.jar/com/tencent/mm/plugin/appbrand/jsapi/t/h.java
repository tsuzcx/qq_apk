package com.tencent.mm.plugin.appbrand.jsapi.t;

import android.content.Context;
import android.view.View;

public abstract interface h<PipVideoContainer extends View>
{
  public abstract d SZ();
  
  public abstract PipVideoContainer aP(Context paramContext);
  
  public abstract void cx(PipVideoContainer paramPipVideoContainer);
  
  public abstract void cy(PipVideoContainer paramPipVideoContainer);
  
  public abstract void d(PipVideoContainer paramPipVideoContainer, Runnable paramRunnable);
  
  public abstract void e(PipVideoContainer paramPipVideoContainer, Runnable paramRunnable);
  
  public static abstract interface a<OriginVideoContainer extends g, PipVideoContainer extends View>
  {
    public abstract h<PipVideoContainer> a(OriginVideoContainer paramOriginVideoContainer);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.t.h
 * JD-Core Version:    0.7.0.1
 */