package com.tencent.mm.plugin.appbrand.appusage;

import a.a.m;
import android.support.v7.g.c.a;
import com.tencent.mm.sdk.platformtools.y;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

final class f$e
  implements Runnable
{
  f$e(f paramf, List paramList, f.b paramb) {}
  
  public final void run()
  {
    Object localObject2 = f.a(this.fIf);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = (List)m.xol;
    }
    localObject2 = android.support.v7.g.c.a((c.a)new ab((List)localObject1, this.fIg), true);
    c localc = (c)com.tencent.mm.kernel.g.r(c.class);
    a.d.b.g.j(localObject2, "diff");
    localObject1 = a.a.e.c((Iterable)localObject1);
    List localList = this.fIg;
    if (localList == null) {
      a.d.b.g.cUk();
    }
    boolean bool = localc.a((android.support.v7.g.c.b)localObject2, (List)localObject1, a.a.e.c((Iterable)localList), (c.b)this.fIh);
    y.i("MicroMsg.AppBrandCollectionStorageExport[collection]", "[collection] reorderWithCallback, changed = " + bool);
    if (bool) {
      ((s)com.tencent.mm.plugin.appbrand.app.e.G(s.class)).a(LocalUsageInfo.class, this.fIg, null);
    }
    f.b(this.fIf).set(false);
    y.i("MicroMsg.AppBrandCollectionStorageExport[collection]", "[collection] reorderWithCallback, before run callback");
    localObject1 = this.fIh;
    if (localObject1 != null) {
      ((f.b)localObject1).acN();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.f.e
 * JD-Core Version:    0.7.0.1
 */