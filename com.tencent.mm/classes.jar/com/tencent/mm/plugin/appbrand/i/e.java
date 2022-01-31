package com.tencent.mm.plugin.appbrand.i;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.concurrent.atomic.AtomicInteger;

public class e
{
  private final e.a ijj;
  private final AtomicInteger ijk;
  final SparseArray<d> ijl;
  
  static
  {
    AppMethodBeat.i(113940);
    if (!e.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      AppMethodBeat.o(113940);
      return;
    }
  }
  
  public e(e.a parama)
  {
    AppMethodBeat.i(113937);
    this.ijj = parama;
    this.ijk = new AtomicInteger(1);
    this.ijl = new SparseArray();
    AppMethodBeat.o(113937);
  }
  
  public static int aGE()
  {
    return 1;
  }
  
  public final g aGC()
  {
    AppMethodBeat.i(113939);
    int i = this.ijk.incrementAndGet();
    f localf = new f(this.ijj.oB(i), i);
    synchronized (this.ijl)
    {
      this.ijl.put(i, localf);
      ab.i("MicroMsg.AppBrandJ2V8ContextMgr", "allocJsContext id:%d", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(113939);
      return localf;
    }
  }
  
  public final g ow(int paramInt)
  {
    AppMethodBeat.i(113938);
    synchronized (this.ijl)
    {
      g localg = (g)this.ijl.get(paramInt);
      AppMethodBeat.o(113938);
      return localg;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.i.e
 * JD-Core Version:    0.7.0.1
 */