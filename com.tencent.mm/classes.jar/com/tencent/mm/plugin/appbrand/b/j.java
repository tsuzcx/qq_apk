package com.tencent.mm.plugin.appbrand.b;

import android.os.Looper;

public abstract class j
  extends com.tencent.mm.sdk.d.d
{
  protected j(String paramString, Looper paramLooper)
  {
    super(paramString, paramLooper);
  }
  
  public void log(String paramString)
  {
    com.tencent.luggage.g.d.d(this.mName, paramString);
  }
  
  public final void yQ(String paramString)
  {
    com.tencent.luggage.g.d.e(this.mName, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.b.j
 * JD-Core Version:    0.7.0.1
 */