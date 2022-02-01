package com.tencent.mm.plugin.appbrand.launching;

import android.content.res.Resources;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.e.i.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

abstract class be<T>
  implements g, Callable<T>
{
  protected volatile long lKV = 0L;
  protected volatile long lKW = 0L;
  protected volatile long lKX = 0L;
  private boolean lKY = true;
  
  public final void RO(String paramString)
  {
    if (!this.lKY)
    {
      ad.e(getTag(), "silent toast: %s", new Object[] { paramString });
      return;
    }
    bf.RO(paramString);
  }
  
  final Future<T> brC()
  {
    return h.LTJ.d(new a());
  }
  
  public final T brD()
  {
    this.lKV = bt.flT();
    try
    {
      Object localObject1 = call();
      return localObject1;
    }
    finally
    {
      this.lKW = bt.flT();
      this.lKX = (this.lKW - this.lKV);
    }
  }
  
  public void gZ(boolean paramBoolean)
  {
    this.lKY = paramBoolean;
  }
  
  public final String getKey()
  {
    return getTag();
  }
  
  abstract String getTag();
  
  public final void uk(int paramInt)
  {
    RO(aj.getResources().getString(paramInt));
  }
  
  final class a
    implements g, Callable<T>
  {
    a() {}
    
    public final T call()
    {
      AppMethodBeat.i(188624);
      be.this.lKV = bt.flT();
      try
      {
        Object localObject1 = be.this.call();
        return localObject1;
      }
      finally
      {
        be.this.lKW = bt.flT();
        be.this.lKX = (be.this.lKW - be.this.lKV);
        AppMethodBeat.o(188624);
      }
    }
    
    public final String getKey()
    {
      AppMethodBeat.i(188623);
      String str = be.this.getTag();
      AppMethodBeat.o(188623);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.be
 * JD-Core Version:    0.7.0.1
 */