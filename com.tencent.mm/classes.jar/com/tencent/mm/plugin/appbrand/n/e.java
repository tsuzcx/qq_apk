package com.tencent.mm.plugin.appbrand.n;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.v8.m;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.concurrent.atomic.AtomicInteger;

public class e
{
  private final a sTh;
  private final AtomicInteger sTi;
  final SparseArray<d> sTj;
  
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
    this.sTh = parama;
    this.sTi = new AtomicInteger(1);
    this.sTj = new SparseArray();
    AppMethodBeat.o(144168);
  }
  
  public static int czl()
  {
    return 1;
  }
  
  public final g BK(int paramInt)
  {
    AppMethodBeat.i(144169);
    synchronized (this.sTj)
    {
      g localg = (g)this.sTj.get(paramInt);
      AppMethodBeat.o(144169);
      return localg;
    }
  }
  
  public final g czj()
  {
    AppMethodBeat.i(144170);
    int i = this.sTi.incrementAndGet();
    f localf = new f(this.sTh.BP(i), i);
    synchronized (this.sTj)
    {
      this.sTj.put(i, localf);
      Log.i("MicroMsg.AppBrandJ2V8ContextMgr", "allocJsContext id:%d", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(144170);
      return localf;
    }
  }
  
  public static abstract interface a
  {
    public abstract m BP(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.n.e
 * JD-Core Version:    0.7.0.1
 */