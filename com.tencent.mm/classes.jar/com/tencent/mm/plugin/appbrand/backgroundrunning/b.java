package com.tencent.mm.plugin.appbrand.backgroundrunning;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.HashSet;
import java.util.Iterator;

public final class b
  implements com.tencent.mm.kernel.c.b, g
{
  private final HashSet<g.b> jxX;
  private final HashSet<g.a> jxY;
  
  public b()
  {
    AppMethodBeat.i(44765);
    this.jxX = new HashSet();
    this.jxY = new HashSet();
    AppMethodBeat.o(44765);
  }
  
  public final void a(AppBrandBackgroundRunningOperationParcel paramAppBrandBackgroundRunningOperationParcel)
  {
    AppMethodBeat.i(44767);
    ac.i("MicroMsg.AppBrandBackgroundRunningManagerService", "sendOperation from appbrand process, operation:%s", new Object[] { paramAppBrandBackgroundRunningOperationParcel });
    synchronized (this.jxX)
    {
      Iterator localIterator = this.jxX.iterator();
      if (localIterator.hasNext()) {
        ((g.b)localIterator.next()).b(paramAppBrandBackgroundRunningOperationParcel);
      }
    }
    if (paramAppBrandBackgroundRunningOperationParcel.jye)
    {
      AppMethodBeat.o(44767);
      return;
    }
    h.a("com.tencent.mm", paramAppBrandBackgroundRunningOperationParcel, a.class, new d() {});
    AppMethodBeat.o(44767);
  }
  
  public final void a(MMBackgroundRunningOperationParcel paramMMBackgroundRunningOperationParcel)
  {
    AppMethodBeat.i(44768);
    if ((paramMMBackgroundRunningOperationParcel != null) && (!bs.isNullOrNil(paramMMBackgroundRunningOperationParcel.appId)))
    {
      ac.i("MicroMsg.AppBrandBackgroundRunningManagerService", "receiveOperation in appbrand process, operation:%s", new Object[] { paramMMBackgroundRunningOperationParcel });
      synchronized (this.jxY)
      {
        Iterator localIterator = this.jxY.iterator();
        if (localIterator.hasNext()) {
          ((g.a)localIterator.next()).b(paramMMBackgroundRunningOperationParcel);
        }
      }
      AppMethodBeat.o(44768);
      return;
    }
    AppMethodBeat.o(44768);
  }
  
  public final void a(g.a parama)
  {
    AppMethodBeat.i(44771);
    if (parama == null)
    {
      AppMethodBeat.o(44771);
      return;
    }
    synchronized (this.jxY)
    {
      this.jxY.add(parama);
      AppMethodBeat.o(44771);
      return;
    }
  }
  
  public final void a(g.b paramb)
  {
    AppMethodBeat.i(44769);
    if (paramb == null)
    {
      AppMethodBeat.o(44769);
      return;
    }
    synchronized (this.jxX)
    {
      this.jxX.add(paramb);
      AppMethodBeat.o(44769);
      return;
    }
  }
  
  public final void ahM() {}
  
  public final void ahN()
  {
    AppMethodBeat.i(44766);
    this.jxX.clear();
    this.jxY.clear();
    AppMethodBeat.o(44766);
  }
  
  public final void b(g.a parama)
  {
    AppMethodBeat.i(44772);
    if (parama == null)
    {
      AppMethodBeat.o(44772);
      return;
    }
    synchronized (this.jxY)
    {
      this.jxY.remove(parama);
      AppMethodBeat.o(44772);
      return;
    }
  }
  
  public final void b(g.b paramb)
  {
    AppMethodBeat.i(44770);
    if (paramb == null)
    {
      AppMethodBeat.o(44770);
      return;
    }
    synchronized (this.jxX)
    {
      this.jxX.remove(paramb);
      AppMethodBeat.o(44770);
      return;
    }
  }
  
  static class a
    implements com.tencent.mm.ipcinvoker.b<AppBrandBackgroundRunningOperationParcel, IPCBoolean>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.backgroundrunning.b
 * JD-Core Version:    0.7.0.1
 */