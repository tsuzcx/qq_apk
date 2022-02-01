package com.tencent.mm.plugin.appbrand.launching;

import android.content.res.Resources;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.e.i.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

abstract class be<T>
  implements g, Callable<T>
{
  protected volatile long lPv = 0L;
  protected volatile long lPw = 0L;
  protected volatile long lPx = 0L;
  private boolean lPy = true;
  
  public final void Sx(String paramString)
  {
    if (!this.lPy)
    {
      ae.e(getTag(), "silent toast: %s", new Object[] { paramString });
      return;
    }
    bf.Sx(paramString);
  }
  
  final Future<T> bsn()
  {
    return h.MqF.d(new a());
  }
  
  public final T bso()
  {
    this.lPv = bu.fpO();
    try
    {
      Object localObject1 = call();
      return localObject1;
    }
    finally
    {
      this.lPw = bu.fpO();
      this.lPx = (this.lPw - this.lPv);
    }
  }
  
  public void gZ(boolean paramBoolean)
  {
    this.lPy = paramBoolean;
  }
  
  public final String getKey()
  {
    return getTag();
  }
  
  abstract String getTag();
  
  public final void uq(int paramInt)
  {
    Sx(ak.getResources().getString(paramInt));
  }
  
  final class a
    implements g, Callable<T>
  {
    a() {}
    
    public final T call()
    {
      AppMethodBeat.i(222783);
      be.this.lPv = bu.fpO();
      try
      {
        Object localObject1 = be.this.call();
        return localObject1;
      }
      finally
      {
        be.this.lPw = bu.fpO();
        be.this.lPx = (be.this.lPw - be.this.lPv);
        AppMethodBeat.o(222783);
      }
    }
    
    public final String getKey()
    {
      AppMethodBeat.i(222782);
      String str = be.this.getTag();
      AppMethodBeat.o(222782);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.be
 * JD-Core Version:    0.7.0.1
 */