package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.f.i.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

abstract class aw<T>
  implements g, aa, Callable<T>
{
  protected volatile long mWG = 0L;
  protected volatile long mWH = 0L;
  protected volatile long mWI = 0L;
  private boolean mWJ = true;
  
  final Future<T> bNN()
  {
    return h.RTc.d(new a());
  }
  
  public final T bNO()
  {
    this.mWG = Util.nowMilliSecond();
    try
    {
      Object localObject1 = call();
      return localObject1;
    }
    finally
    {
      this.mWH = Util.nowMilliSecond();
      this.mWI = (this.mWH - this.mWG);
    }
  }
  
  public boolean bNh()
  {
    return this.mWJ;
  }
  
  public final String getKey()
  {
    return getTag();
  }
  
  abstract String getTag();
  
  public void hX(boolean paramBoolean)
  {
    this.mWJ = paramBoolean;
  }
  
  final class a
    implements g, Callable<T>
  {
    a() {}
    
    public final T call()
    {
      AppMethodBeat.i(227095);
      aw.this.mWG = Util.nowMilliSecond();
      try
      {
        Object localObject1 = aw.this.call();
        return localObject1;
      }
      finally
      {
        aw.this.mWH = Util.nowMilliSecond();
        aw.this.mWI = (aw.this.mWH - aw.this.mWG);
        AppMethodBeat.o(227095);
      }
    }
    
    public final String getKey()
    {
      AppMethodBeat.i(227094);
      String str = aw.this.getKey();
      AppMethodBeat.o(227094);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.aw
 * JD-Core Version:    0.7.0.1
 */