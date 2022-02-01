package com.tencent.mm.plugin.appbrand.backgroundrunning;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.HashSet;
import java.util.Iterator;

public final class b
  implements com.tencent.mm.kernel.c.b, g
{
  private final HashSet<g.b> iXH;
  private final HashSet<g.a> iXI;
  
  public b()
  {
    AppMethodBeat.i(44765);
    this.iXH = new HashSet();
    this.iXI = new HashSet();
    AppMethodBeat.o(44765);
  }
  
  public final void a(AppBrandBackgroundRunningOperationParcel paramAppBrandBackgroundRunningOperationParcel)
  {
    AppMethodBeat.i(44767);
    ad.i("MicroMsg.AppBrandBackgroundRunningManagerService", "sendOperation from appbrand process, operation:%s", new Object[] { paramAppBrandBackgroundRunningOperationParcel });
    synchronized (this.iXH)
    {
      Iterator localIterator = this.iXH.iterator();
      if (localIterator.hasNext()) {
        ((g.b)localIterator.next()).b(paramAppBrandBackgroundRunningOperationParcel);
      }
    }
    if (paramAppBrandBackgroundRunningOperationParcel.iXO)
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
    if ((paramMMBackgroundRunningOperationParcel != null) && (!bt.isNullOrNil(paramMMBackgroundRunningOperationParcel.appId)))
    {
      ad.i("MicroMsg.AppBrandBackgroundRunningManagerService", "receiveOperation in appbrand process, operation:%s", new Object[] { paramMMBackgroundRunningOperationParcel });
      synchronized (this.iXI)
      {
        Iterator localIterator = this.iXI.iterator();
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
    synchronized (this.iXI)
    {
      this.iXI.add(parama);
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
    synchronized (this.iXH)
    {
      this.iXH.add(paramb);
      AppMethodBeat.o(44769);
      return;
    }
  }
  
  public final void agv() {}
  
  public final void agw()
  {
    AppMethodBeat.i(44766);
    this.iXH.clear();
    this.iXI.clear();
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
    synchronized (this.iXI)
    {
      this.iXI.remove(parama);
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
    synchronized (this.iXH)
    {
      this.iXH.remove(paramb);
      AppMethodBeat.o(44770);
      return;
    }
  }
  
  static class a
    implements com.tencent.mm.ipcinvoker.b<AppBrandBackgroundRunningOperationParcel, IPCBoolean>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.backgroundrunning.b
 * JD-Core Version:    0.7.0.1
 */