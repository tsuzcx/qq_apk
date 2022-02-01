package com.tencent.mm.plugin.appbrand.jsapi.o;

import android.content.Context;
import android.view.View;

public abstract interface i<PipVideoContainer extends View>
{
  public abstract e EI();
  
  public abstract void a(PipVideoContainer paramPipVideoContainer, com.tencent.mm.plugin.appbrand.utils.i parami);
  
  public abstract PipVideoContainer aH(Context paramContext);
  
  public abstract void cq(PipVideoContainer paramPipVideoContainer);
  
  public abstract void cr(PipVideoContainer paramPipVideoContainer);
  
  public static abstract interface a<OriginVideoContainer extends h, PipVideoContainer extends View>
  {
    public abstract i<PipVideoContainer> a(OriginVideoContainer paramOriginVideoContainer);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.o.i
 * JD-Core Version:    0.7.0.1
 */