package com.tencent.mm.plugin.appbrand.jsruntime;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.v8.m;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.concurrent.atomic.AtomicInteger;

public class e
{
  private final a lGg;
  private final AtomicInteger lGh;
  final SparseArray<d> lGi;
  
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
    this.lGg = parama;
    this.lGh = new AtomicInteger(1);
    this.lGi = new SparseArray();
    AppMethodBeat.o(144168);
  }
  
  public static int bqU()
  {
    return 1;
  }
  
  public final g bqS()
  {
    AppMethodBeat.i(144170);
    int i = this.lGh.incrementAndGet();
    f localf = new f(this.lGg.ud(i), i);
    synchronized (this.lGi)
    {
      this.lGi.put(i, localf);
      ae.i("MicroMsg.AppBrandJ2V8ContextMgr", "allocJsContext id:%d", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(144170);
      return localf;
    }
  }
  
  public final g tY(int paramInt)
  {
    AppMethodBeat.i(144169);
    synchronized (this.lGi)
    {
      g localg = (g)this.lGi.get(paramInt);
      AppMethodBeat.o(144169);
      return localg;
    }
  }
  
  public static abstract interface a
  {
    public abstract m ud(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsruntime.e
 * JD-Core Version:    0.7.0.1
 */