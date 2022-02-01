package com.tencent.mm.plugin.appbrand.a;

import android.os.Looper;
import com.tencent.mm.sdk.d.d;
import com.tencent.mm.sdk.platformtools.ad;

public abstract class i
  extends d
{
  protected i(String paramString, Looper paramLooper)
  {
    super(paramString, paramLooper);
  }
  
  public final void LT(String paramString)
  {
    ad.e(this.mName, paramString);
  }
  
  public void log(String paramString)
  {
    ad.d(this.mName, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.a.i
 * JD-Core Version:    0.7.0.1
 */