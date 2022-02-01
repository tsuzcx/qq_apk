package com.tencent.mm.plugin.appbrand.backgroundrunning;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.j;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.kernel.c.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashSet;
import java.util.Iterator;

public final class a
  implements b, f
{
  private final HashSet<f.b> nSs;
  private final HashSet<f.a> nSt;
  
  public a()
  {
    AppMethodBeat.i(44765);
    this.nSs = new HashSet();
    this.nSt = new HashSet();
    AppMethodBeat.o(44765);
  }
  
  public final void a(AppBrandBackgroundRunningOperationParcel paramAppBrandBackgroundRunningOperationParcel)
  {
    AppMethodBeat.i(44767);
    Log.i("MicroMsg.AppBrandBackgroundRunningManagerService", "sendOperation from appbrand process, operation:%s", new Object[] { paramAppBrandBackgroundRunningOperationParcel });
    synchronized (this.nSs)
    {
      Iterator localIterator = this.nSs.iterator();
      if (localIterator.hasNext()) {
        ((f.b)localIterator.next()).b(paramAppBrandBackgroundRunningOperationParcel);
      }
    }
    if (paramAppBrandBackgroundRunningOperationParcel.nSA)
    {
      AppMethodBeat.o(44767);
      return;
    }
    j.a(MainProcessIPCService.PROCESS_NAME, paramAppBrandBackgroundRunningOperationParcel, a.class, new com.tencent.mm.ipcinvoker.f() {});
    AppMethodBeat.o(44767);
  }
  
  public final void a(MMBackgroundRunningOperationParcel paramMMBackgroundRunningOperationParcel)
  {
    AppMethodBeat.i(44768);
    if ((paramMMBackgroundRunningOperationParcel != null) && (!Util.isNullOrNil(paramMMBackgroundRunningOperationParcel.appId)))
    {
      Log.i("MicroMsg.AppBrandBackgroundRunningManagerService", "receiveOperation in appbrand process, operation:%s", new Object[] { paramMMBackgroundRunningOperationParcel });
      synchronized (this.nSt)
      {
        Iterator localIterator = this.nSt.iterator();
        if (localIterator.hasNext()) {
          ((f.a)localIterator.next()).b(paramMMBackgroundRunningOperationParcel);
        }
      }
      AppMethodBeat.o(44768);
      return;
    }
    AppMethodBeat.o(44768);
  }
  
  public final void a(f.a parama)
  {
    AppMethodBeat.i(44771);
    if (parama == null)
    {
      AppMethodBeat.o(44771);
      return;
    }
    synchronized (this.nSt)
    {
      this.nSt.add(parama);
      AppMethodBeat.o(44771);
      return;
    }
  }
  
  public final void a(f.b paramb)
  {
    AppMethodBeat.i(44769);
    if (paramb == null)
    {
      AppMethodBeat.o(44769);
      return;
    }
    synchronized (this.nSs)
    {
      this.nSs.add(paramb);
      AppMethodBeat.o(44769);
      return;
    }
  }
  
  public final void aIF() {}
  
  public final void aIG()
  {
    AppMethodBeat.i(44766);
    this.nSs.clear();
    this.nSt.clear();
    AppMethodBeat.o(44766);
  }
  
  public final void b(f.a parama)
  {
    AppMethodBeat.i(44772);
    if (parama == null)
    {
      AppMethodBeat.o(44772);
      return;
    }
    synchronized (this.nSt)
    {
      this.nSt.remove(parama);
      AppMethodBeat.o(44772);
      return;
    }
  }
  
  public final void b(f.b paramb)
  {
    AppMethodBeat.i(44770);
    if (paramb == null)
    {
      AppMethodBeat.o(44770);
      return;
    }
    synchronized (this.nSs)
    {
      this.nSs.remove(paramb);
      AppMethodBeat.o(44770);
      return;
    }
  }
  
  static class a
    implements d<AppBrandBackgroundRunningOperationParcel, IPCBoolean>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.backgroundrunning.a
 * JD-Core Version:    0.7.0.1
 */