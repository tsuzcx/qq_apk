package com.tencent.mm.plugin.appbrand.backgroundrunning;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.HashSet;
import java.util.Iterator;

public final class a
  implements com.tencent.mm.kernel.c.b, f
{
  private final HashSet<f.b> jVk;
  private final HashSet<f.a> jVl;
  
  public a()
  {
    AppMethodBeat.i(44765);
    this.jVk = new HashSet();
    this.jVl = new HashSet();
    AppMethodBeat.o(44765);
  }
  
  public final void a(AppBrandBackgroundRunningOperationParcel paramAppBrandBackgroundRunningOperationParcel)
  {
    AppMethodBeat.i(44767);
    ae.i("MicroMsg.AppBrandBackgroundRunningManagerService", "sendOperation from appbrand process, operation:%s", new Object[] { paramAppBrandBackgroundRunningOperationParcel });
    synchronized (this.jVk)
    {
      Iterator localIterator = this.jVk.iterator();
      if (localIterator.hasNext()) {
        ((f.b)localIterator.next()).b(paramAppBrandBackgroundRunningOperationParcel);
      }
    }
    if (paramAppBrandBackgroundRunningOperationParcel.jVs)
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
    if ((paramMMBackgroundRunningOperationParcel != null) && (!bu.isNullOrNil(paramMMBackgroundRunningOperationParcel.appId)))
    {
      ae.i("MicroMsg.AppBrandBackgroundRunningManagerService", "receiveOperation in appbrand process, operation:%s", new Object[] { paramMMBackgroundRunningOperationParcel });
      synchronized (this.jVl)
      {
        Iterator localIterator = this.jVl.iterator();
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
    synchronized (this.jVl)
    {
      this.jVl.add(parama);
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
    synchronized (this.jVk)
    {
      this.jVk.add(paramb);
      AppMethodBeat.o(44769);
      return;
    }
  }
  
  public final void akM() {}
  
  public final void akN()
  {
    AppMethodBeat.i(44766);
    this.jVk.clear();
    this.jVl.clear();
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
    synchronized (this.jVl)
    {
      this.jVl.remove(parama);
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
    synchronized (this.jVk)
    {
      this.jVk.remove(paramb);
      AppMethodBeat.o(44770);
      return;
    }
  }
  
  static class a
    implements com.tencent.mm.ipcinvoker.b<AppBrandBackgroundRunningOperationParcel, IPCBoolean>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.backgroundrunning.a
 * JD-Core Version:    0.7.0.1
 */