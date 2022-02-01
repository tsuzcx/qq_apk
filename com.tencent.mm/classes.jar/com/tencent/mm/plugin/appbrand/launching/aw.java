package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import com.tencent.threadpool.i.g;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

abstract class aw<T>
  implements aa, g, Callable<T>
{
  protected volatile long tbM = 0L;
  protected volatile long tbN = 0L;
  protected volatile long tbO = 0L;
  private boolean tbP = true;
  
  final Future<T> cAs()
  {
    return h.ahAA.h(new a());
  }
  
  public final T cAt()
  {
    this.tbM = Util.nowMilliSecond();
    try
    {
      Object localObject1 = call();
      return localObject1;
    }
    finally
    {
      this.tbN = Util.nowMilliSecond();
      this.tbO = (this.tbN - this.tbM);
    }
  }
  
  public boolean czJ()
  {
    return this.tbP;
  }
  
  public final String getKey()
  {
    return getTag();
  }
  
  abstract String getTag();
  
  public void jY(boolean paramBoolean)
  {
    this.tbP = paramBoolean;
  }
  
  final class a
    implements g, Callable<T>
  {
    a() {}
    
    public final T call()
    {
      AppMethodBeat.i(320774);
      aw.this.tbM = Util.nowMilliSecond();
      try
      {
        Object localObject1 = aw.this.call();
        return localObject1;
      }
      finally
      {
        aw.this.tbN = Util.nowMilliSecond();
        aw.this.tbO = (aw.this.tbN - aw.this.tbM);
        AppMethodBeat.o(320774);
      }
    }
    
    public final String getKey()
    {
      AppMethodBeat.i(320768);
      String str = aw.this.getKey();
      AppMethodBeat.o(320768);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.aw
 * JD-Core Version:    0.7.0.1
 */