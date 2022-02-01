package com.tencent.mm.plugin.appbrand.jsruntime;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.v8.m;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.concurrent.atomic.AtomicInteger;

public class e
{
  private final a leI;
  private final AtomicInteger leJ;
  final SparseArray<d> leK;
  
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
    this.leI = parama;
    this.leJ = new AtomicInteger(1);
    this.leK = new SparseArray();
    AppMethodBeat.o(144168);
  }
  
  public static int bmz()
  {
    return 1;
  }
  
  public final g bmy()
  {
    AppMethodBeat.i(144170);
    int i = this.leJ.incrementAndGet();
    f localf = new f(this.leI.tu(i), i);
    synchronized (this.leK)
    {
      this.leK.put(i, localf);
      ac.i("MicroMsg.AppBrandJ2V8ContextMgr", "allocJsContext id:%d", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(144170);
      return localf;
    }
  }
  
  public final g tp(int paramInt)
  {
    AppMethodBeat.i(144169);
    synchronized (this.leK)
    {
      g localg = (g)this.leK.get(paramInt);
      AppMethodBeat.o(144169);
      return localg;
    }
  }
  
  public static abstract interface a
  {
    public abstract m tu(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsruntime.e
 * JD-Core Version:    0.7.0.1
 */