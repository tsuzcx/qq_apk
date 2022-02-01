package com.tencent.mm.plugin.appbrand.jsruntime;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.v8.m;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.concurrent.atomic.AtomicInteger;

public class e
{
  private final a kDq;
  private final AtomicInteger kDr;
  final SparseArray<d> kDs;
  
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
    this.kDq = parama;
    this.kDr = new AtomicInteger(1);
    this.kDs = new SparseArray();
    AppMethodBeat.o(144168);
  }
  
  public static int bfF()
  {
    return 1;
  }
  
  public final g bfE()
  {
    AppMethodBeat.i(144170);
    int i = this.kDr.incrementAndGet();
    f localf = new f(this.kDq.sD(i), i);
    synchronized (this.kDs)
    {
      this.kDs.put(i, localf);
      ad.i("MicroMsg.AppBrandJ2V8ContextMgr", "allocJsContext id:%d", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(144170);
      return localf;
    }
  }
  
  public final g sy(int paramInt)
  {
    AppMethodBeat.i(144169);
    synchronized (this.kDs)
    {
      g localg = (g)this.kDs.get(paramInt);
      AppMethodBeat.o(144169);
      return localg;
    }
  }
  
  public static abstract interface a
  {
    public abstract m sD(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsruntime.e
 * JD-Core Version:    0.7.0.1
 */