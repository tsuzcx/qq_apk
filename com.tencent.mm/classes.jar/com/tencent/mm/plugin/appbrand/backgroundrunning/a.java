package com.tencent.mm.plugin.appbrand.backgroundrunning;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashSet;
import java.util.Iterator;

public final class a
  implements com.tencent.mm.kernel.c.b, f
{
  private final HashSet<f.b> kYg;
  private final HashSet<f.a> kYh;
  
  public a()
  {
    AppMethodBeat.i(44765);
    this.kYg = new HashSet();
    this.kYh = new HashSet();
    AppMethodBeat.o(44765);
  }
  
  public final void a(AppBrandBackgroundRunningOperationParcel paramAppBrandBackgroundRunningOperationParcel)
  {
    AppMethodBeat.i(44767);
    Log.i("MicroMsg.AppBrandBackgroundRunningManagerService", "sendOperation from appbrand process, operation:%s", new Object[] { paramAppBrandBackgroundRunningOperationParcel });
    synchronized (this.kYg)
    {
      Iterator localIterator = this.kYg.iterator();
      if (localIterator.hasNext()) {
        ((f.b)localIterator.next()).b(paramAppBrandBackgroundRunningOperationParcel);
      }
    }
    if (paramAppBrandBackgroundRunningOperationParcel.kYo)
    {
      AppMethodBeat.o(44767);
      return;
    }
    h.a(MainProcessIPCService.dkO, paramAppBrandBackgroundRunningOperationParcel, a.class, new d() {});
    AppMethodBeat.o(44767);
  }
  
  public final void a(MMBackgroundRunningOperationParcel paramMMBackgroundRunningOperationParcel)
  {
    AppMethodBeat.i(44768);
    if ((paramMMBackgroundRunningOperationParcel != null) && (!Util.isNullOrNil(paramMMBackgroundRunningOperationParcel.appId)))
    {
      Log.i("MicroMsg.AppBrandBackgroundRunningManagerService", "receiveOperation in appbrand process, operation:%s", new Object[] { paramMMBackgroundRunningOperationParcel });
      synchronized (this.kYh)
      {
        Iterator localIterator = this.kYh.iterator();
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
    synchronized (this.kYh)
    {
      this.kYh.add(parama);
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
    synchronized (this.kYg)
    {
      this.kYg.add(paramb);
      AppMethodBeat.o(44769);
      return;
    }
  }
  
  public final void aBc() {}
  
  public final void aBd()
  {
    AppMethodBeat.i(44766);
    this.kYg.clear();
    this.kYh.clear();
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
    synchronized (this.kYh)
    {
      this.kYh.remove(parama);
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
    synchronized (this.kYg)
    {
      this.kYg.remove(paramb);
      AppMethodBeat.o(44770);
      return;
    }
  }
  
  static class a
    implements com.tencent.mm.ipcinvoker.b<AppBrandBackgroundRunningOperationParcel, IPCBoolean>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.backgroundrunning.a
 * JD-Core Version:    0.7.0.1
 */