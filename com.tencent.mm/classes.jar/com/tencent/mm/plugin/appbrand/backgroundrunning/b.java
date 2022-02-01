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
  private final HashSet<g.b> jRT;
  private final HashSet<g.a> jRU;
  
  public b()
  {
    AppMethodBeat.i(44765);
    this.jRT = new HashSet();
    this.jRU = new HashSet();
    AppMethodBeat.o(44765);
  }
  
  public final void a(AppBrandBackgroundRunningOperationParcel paramAppBrandBackgroundRunningOperationParcel)
  {
    AppMethodBeat.i(44767);
    ad.i("MicroMsg.AppBrandBackgroundRunningManagerService", "sendOperation from appbrand process, operation:%s", new Object[] { paramAppBrandBackgroundRunningOperationParcel });
    synchronized (this.jRT)
    {
      Iterator localIterator = this.jRT.iterator();
      if (localIterator.hasNext()) {
        ((g.b)localIterator.next()).b(paramAppBrandBackgroundRunningOperationParcel);
      }
    }
    if (paramAppBrandBackgroundRunningOperationParcel.jSb)
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
      synchronized (this.jRU)
      {
        Iterator localIterator = this.jRU.iterator();
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
    synchronized (this.jRU)
    {
      this.jRU.add(parama);
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
    synchronized (this.jRT)
    {
      this.jRT.add(paramb);
      AppMethodBeat.o(44769);
      return;
    }
  }
  
  public final void akx() {}
  
  public final void aky()
  {
    AppMethodBeat.i(44766);
    this.jRT.clear();
    this.jRU.clear();
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
    synchronized (this.jRU)
    {
      this.jRU.remove(parama);
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
    synchronized (this.jRT)
    {
      this.jRT.remove(paramb);
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