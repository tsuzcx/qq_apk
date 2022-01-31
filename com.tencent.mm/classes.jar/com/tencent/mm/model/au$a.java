package com.tencent.mm.model;

import com.tencent.mm.cf.h.d;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.kernel.a.b.a.a;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.model.b.d;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.l;
import com.tencent.mm.storage.n;
import java.util.HashMap;

class au$a
  implements com.tencent.mm.kernel.a.b.b, com.tencent.mm.kernel.api.a, com.tencent.mm.kernel.api.c, com.tencent.mm.kernel.api.e, com.tencent.mm.kernel.c.a
{
  au$a(au paramau) {}
  
  public HashMap<Integer, h.d> collectDatabaseFactory()
  {
    y.i("MicroMsg.MMCore", "collectDatabaseFactory ");
    HashMap localHashMap = new HashMap();
    localHashMap.putAll(c.dgp);
    return localHashMap;
  }
  
  public void onAccountInitialized(e.c paramc)
  {
    if (paramc.dKL) {
      com.tencent.mm.y.c.BS().v(262145, false);
    }
    com.tencent.mm.plugin.report.service.h.nFQ.a(598L, 13L, 1L, false);
    long l = System.currentTimeMillis();
    y.i("MicroMsg.MMCore", "summerasyncinit onAccountInitialized start tid[%d]", new Object[] { Long.valueOf(Thread.currentThread().getId()) });
    Object localObject1 = au.a(this.dVT);
    com.tencent.mm.cf.h localh = com.tencent.mm.kernel.g.DP().dKu;
    Object localObject2 = com.tencent.mm.kernel.g.DP().dKv;
    localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bhO();
    ((com.tencent.mm.plugin.messenger.foundation.a.a.g)localObject2).a(new com.tencent.mm.storage.au((com.tencent.mm.plugin.messenger.foundation.a.a.g)localObject2));
    com.tencent.mm.storage.h localh1 = new com.tencent.mm.storage.h((com.tencent.mm.plugin.messenger.foundation.a.a.g)localObject2);
    ((c)localObject1).dUj = localh1;
    ((com.tencent.mm.plugin.messenger.foundation.a.a.g)localObject2).a(localh1);
    ((c)localObject1).dUh = new bp(localh, ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).FB());
    ((c)localObject1).dUi = new bo(localh, ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw());
    ((c)localObject1).dUk = new com.tencent.mm.model.b.c();
    ((c)localObject1).dUl = new d();
    ((c)localObject1).dUp = new com.tencent.mm.model.b.b();
    ((c)localObject1).dUm = new com.tencent.mm.storage.j(localh);
    ((c)localObject1).dUn = new n(localh);
    ((c)localObject1).dUo = new l(localh);
    com.tencent.mm.plugin.report.service.h.nFQ.a(598L, 14L, 1L, false);
    y.i("MicroMsg.MMCore", "summerasyncinit onAccountInitialized done initDB take[%d]ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    localObject1 = this.dVT.dVJ;
    au.a(this.dVT);
    ((c.a)localObject1).bG(paramc.dKL);
    com.tencent.mm.plugin.report.service.h.nFQ.a(598L, 15L, 1L, false);
    y.i("MicroMsg.MMCore", "summerasyncinit onAccountInitialized done onAccountPostReset take[%d]ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    paramc = this.dVT.dVJ;
    f.zF();
    com.tencent.mm.plugin.report.service.h.nFQ.a(598L, 16L, 1L, false);
    y.i("MicroMsg.MMCore", "summerasyncinit onAccountInitialized done all take[%d]ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
  }
  
  public void onAccountRelease() {}
  
  public void onDataBaseClosed(com.tencent.mm.cf.h paramh1, com.tencent.mm.cf.h paramh2) {}
  
  public void onDataBaseOpened(com.tencent.mm.cf.h paramh1, com.tencent.mm.cf.h paramh2)
  {
    paramh1 = this.dVT.dVJ;
    au.a(this.dVT);
  }
  
  public void parallelsDependency()
  {
    com.tencent.mm.kernel.a.b.a.a(this, com.tencent.mm.kernel.api.c.class).ao(com.tencent.mm.kernel.g.t(p.class));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.model.au.a
 * JD-Core Version:    0.7.0.1
 */