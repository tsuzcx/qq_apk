package com.tencent.mm.plugin.appbrand.a;

import android.os.Looper;
import com.tencent.mm.sdk.d.d;
import com.tencent.mm.sdk.platformtools.ae;

public abstract class i
  extends d
{
  protected i(String paramString, Looper paramLooper)
  {
    super(paramString, paramLooper);
  }
  
  public final void Mx(String paramString)
  {
    ae.e(this.mName, paramString);
  }
  
  public void log(String paramString)
  {
    ae.d(this.mName, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.a.i
 * JD-Core Version:    0.7.0.1
 */