package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.e.i.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

abstract class au<T>
  implements g, y, Callable<T>
{
  protected volatile long pWY = 0L;
  protected volatile long pWZ = 0L;
  protected volatile long pXa = 0L;
  private boolean pXb = true;
  
  public boolean bZy()
  {
    return this.pXb;
  }
  
  final Future<T> caf()
  {
    return h.ZvG.f(new a());
  }
  
  public final T cag()
  {
    this.pWY = Util.nowMilliSecond();
    try
    {
      Object localObject1 = call();
      return localObject1;
    }
    finally
    {
      this.pWZ = Util.nowMilliSecond();
      this.pXa = (this.pWZ - this.pWY);
    }
  }
  
  public final String getKey()
  {
    return getTag();
  }
  
  abstract String getTag();
  
  public void iR(boolean paramBoolean)
  {
    this.pXb = paramBoolean;
  }
  
  final class a
    implements g, Callable<T>
  {
    a() {}
    
    public final T call()
    {
      AppMethodBeat.i(249976);
      au.this.pWY = Util.nowMilliSecond();
      try
      {
        Object localObject1 = au.this.call();
        return localObject1;
      }
      finally
      {
        au.this.pWZ = Util.nowMilliSecond();
        au.this.pXa = (au.this.pWZ - au.this.pWY);
        AppMethodBeat.o(249976);
      }
    }
    
    public final String getKey()
    {
      AppMethodBeat.i(249975);
      String str = au.this.getKey();
      AppMethodBeat.o(249975);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.au
 * JD-Core Version:    0.7.0.1
 */