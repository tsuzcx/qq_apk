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

abstract class bb<T>
  implements g, Callable<T>
{
  protected volatile long kMg = 0L;
  protected volatile long kMh = 0L;
  protected volatile long kMi = 0L;
  private boolean kMj = true;
  
  public final void Kj(String paramString)
  {
    if (!this.kMj)
    {
      ad.e(getTag(), "silent toast: %s", new Object[] { paramString });
      return;
    }
    bc.Kj(paramString);
  }
  
  final Future<T> bgQ()
  {
    return h.Iye.d(new a());
  }
  
  final T bgR()
  {
    this.kMg = bt.eGO();
    Object localObject = call();
    this.kMh = bt.eGO();
    this.kMi = (this.kMh - this.kMg);
    return localObject;
  }
  
  public final String getKey()
  {
    return getTag();
  }
  
  abstract String getTag();
  
  public void gv(boolean paramBoolean)
  {
    this.kMj = paramBoolean;
  }
  
  public final void sP(int paramInt)
  {
    Kj(aj.getResources().getString(paramInt));
  }
  
  final class a
    implements g, Callable<T>
  {
    a() {}
    
    public final T call()
    {
      AppMethodBeat.i(196019);
      bb.this.kMg = bt.eGO();
      try
      {
        Object localObject1 = bb.this.call();
        return localObject1;
      }
      finally
      {
        bb.this.kMh = bt.eGO();
        bb.this.kMi = (bb.this.kMh - bb.this.kMg);
        AppMethodBeat.o(196019);
      }
    }
    
    public final String getKey()
    {
      AppMethodBeat.i(196018);
      String str = bb.this.getTag();
      AppMethodBeat.o(196018);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.bb
 * JD-Core Version:    0.7.0.1
 */