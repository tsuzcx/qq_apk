package com.tencent.mm.plugin.appbrand.appusage;

import a.a.v;
import a.l;
import android.support.v7.h.c.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "run"})
final class f$e
  implements Runnable
{
  f$e(f paramf, List paramList, f.b paramb) {}
  
  public final void run()
  {
    AppMethodBeat.i(134514);
    Object localObject2 = f.a(this.haX);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = (List)v.BMx;
    }
    localObject2 = android.support.v7.h.c.a((c.a)new ab((List)localObject1, this.haY), true);
    c localc = (c)com.tencent.mm.kernel.g.E(c.class);
    a.f.b.j.p(localObject2, "diff");
    localObject1 = a.a.j.m((Iterable)localObject1);
    List localList = this.haY;
    if (localList == null) {
      a.f.b.j.ebi();
    }
    boolean bool = localc.a((android.support.v7.h.c.b)localObject2, (List)localObject1, a.a.j.m((Iterable)localList), (c.b)this.haZ);
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.AppBrandCollectionStorageExport[collection]", "[collection] reorderWithCallback, changed = ".concat(String.valueOf(bool)));
    if (bool) {
      ((s)com.tencent.mm.plugin.appbrand.app.g.w(s.class)).a(LocalUsageInfo.class, this.haY, null);
    }
    f.b(this.haX).set(false);
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.AppBrandCollectionStorageExport[collection]", "[collection] reorderWithCallback, before run callback");
    localObject1 = this.haZ;
    if (localObject1 != null)
    {
      ((f.b)localObject1).awT();
      AppMethodBeat.o(134514);
      return;
    }
    AppMethodBeat.o(134514);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.f.e
 * JD-Core Version:    0.7.0.1
 */