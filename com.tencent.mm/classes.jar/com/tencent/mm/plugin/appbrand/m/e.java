package com.tencent.mm.plugin.appbrand.m;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.v8.m;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.concurrent.atomic.AtomicInteger;

public class e
{
  private final a pOI;
  private final AtomicInteger pOJ;
  final SparseArray<d> pOK;
  
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
    this.pOI = parama;
    this.pOJ = new AtomicInteger(1);
    this.pOK = new SparseArray();
    AppMethodBeat.o(144168);
  }
  
  public static int bYX()
  {
    return 1;
  }
  
  public final g Bx(int paramInt)
  {
    AppMethodBeat.i(144169);
    synchronized (this.pOK)
    {
      g localg = (g)this.pOK.get(paramInt);
      AppMethodBeat.o(144169);
      return localg;
    }
  }
  
  public final g bYV()
  {
    AppMethodBeat.i(144170);
    int i = this.pOJ.incrementAndGet();
    f localf = new f(this.pOI.BC(i), i);
    synchronized (this.pOK)
    {
      this.pOK.put(i, localf);
      Log.i("MicroMsg.AppBrandJ2V8ContextMgr", "allocJsContext id:%d", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(144170);
      return localf;
    }
  }
  
  public static abstract interface a
  {
    public abstract m BC(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.m.e
 * JD-Core Version:    0.7.0.1
 */