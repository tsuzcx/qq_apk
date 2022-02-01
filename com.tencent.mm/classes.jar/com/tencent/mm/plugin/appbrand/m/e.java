package com.tencent.mm.plugin.appbrand.m;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.v8.m;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.concurrent.atomic.AtomicInteger;

public class e
{
  private final a mNQ;
  private final AtomicInteger mNR;
  final SparseArray<d> mNS;
  
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
    this.mNQ = parama;
    this.mNR = new AtomicInteger(1);
    this.mNS = new SparseArray();
    AppMethodBeat.o(144168);
  }
  
  public static int bMG()
  {
    return 1;
  }
  
  public final g bME()
  {
    AppMethodBeat.i(144170);
    int i = this.mNR.incrementAndGet();
    f localf = new f(this.mNQ.yc(i), i);
    synchronized (this.mNS)
    {
      this.mNS.put(i, localf);
      Log.i("MicroMsg.AppBrandJ2V8ContextMgr", "allocJsContext id:%d", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(144170);
      return localf;
    }
  }
  
  public final g xX(int paramInt)
  {
    AppMethodBeat.i(144169);
    synchronized (this.mNS)
    {
      g localg = (g)this.mNS.get(paramInt);
      AppMethodBeat.o(144169);
      return localg;
    }
  }
  
  public static abstract interface a
  {
    public abstract m yc(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.m.e
 * JD-Core Version:    0.7.0.1
 */