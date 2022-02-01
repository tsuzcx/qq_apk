package com.tencent.mm.plugin.appbrand.jsruntime;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.v8.m;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.concurrent.atomic.AtomicInteger;

public class e
{
  private final a lBH;
  private final AtomicInteger lBI;
  final SparseArray<d> lBJ;
  
  static
  {
    AppMethodBeat.i(144171);
    if (!e.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      AppMethodBeat.o(144171);
      return;
    }
  }
  
  public e(a parama)
  {
    AppMethodBeat.i(144168);
    this.lBH = parama;
    this.lBI = new AtomicInteger(1);
    this.lBJ = new SparseArray();
    AppMethodBeat.o(144168);
  }
  
  public static int bqk()
  {
    return 1;
  }
  
  public final g bqj()
  {
    AppMethodBeat.i(144170);
    int i = this.lBI.incrementAndGet();
    f localf = new f(this.lBH.tX(i), i);
    synchronized (this.lBJ)
    {
      this.lBJ.put(i, localf);
      ad.i("MicroMsg.AppBrandJ2V8ContextMgr", "allocJsContext id:%d", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(144170);
      return localf;
    }
  }
  
  public final g tS(int paramInt)
  {
    AppMethodBeat.i(144169);
    synchronized (this.lBJ)
    {
      g localg = (g)this.lBJ.get(paramInt);
      AppMethodBeat.o(144169);
      return localg;
    }
  }
  
  public static abstract interface a
  {
    public abstract m tX(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsruntime.e
 * JD-Core Version:    0.7.0.1
 */