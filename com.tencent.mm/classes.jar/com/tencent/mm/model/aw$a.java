package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cg.h.d;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.kernel.a.b.a.a;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.b.d;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.l;
import com.tencent.mm.storage.n;
import java.util.HashMap;

class aw$a
  implements com.tencent.mm.kernel.a.b.b, com.tencent.mm.kernel.api.a, com.tencent.mm.kernel.api.c, com.tencent.mm.kernel.api.e, com.tencent.mm.kernel.c.a
{
  aw$a(aw paramaw) {}
  
  public HashMap<Integer, h.d> collectDatabaseFactory()
  {
    AppMethodBeat.i(16284);
    ab.i("MicroMsg.MMCore", "collectDatabaseFactory ");
    HashMap localHashMap = new HashMap();
    localHashMap.putAll(c.baseDBFactories);
    AppMethodBeat.o(16284);
    return localHashMap;
  }
  
  public void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(16281);
    if (paramc.eIj) {
      com.tencent.mm.x.c.PJ().x(262145, false);
    }
    com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(598L, 13L, 1L, false);
    long l = System.currentTimeMillis();
    ab.i("MicroMsg.MMCore", "summerasyncinit onAccountInitialized start tid[%d]", new Object[] { Long.valueOf(Thread.currentThread().getId()) });
    Object localObject = aw.a(this.fmd);
    com.tencent.mm.cg.h localh = g.RL().eHS;
    g.RL();
    com.tencent.mm.plugin.messenger.foundation.a.a.h localh1 = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bPQ();
    localh1.a(new au(localh1));
    com.tencent.mm.storage.h localh2 = new com.tencent.mm.storage.h(localh1);
    ((c)localObject).fks = localh2;
    localh1.a(localh2);
    ((c)localObject).fkq = new br(localh, ((com.tencent.mm.plugin.messenger.foundation.a.j)g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YF());
    ((c)localObject).fkr = new bq(localh, ((com.tencent.mm.plugin.messenger.foundation.a.j)g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YA());
    ((c)localObject).fkt = new com.tencent.mm.model.b.c();
    ((c)localObject).fku = new d();
    ((c)localObject).fky = new com.tencent.mm.model.b.b();
    ((c)localObject).fkv = new com.tencent.mm.storage.j(localh);
    ((c)localObject).fkw = new n(localh);
    ((c)localObject).fkx = new l(localh);
    com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(598L, 14L, 1L, false);
    ab.i("MicroMsg.MMCore", "summerasyncinit onAccountInitialized done initDB take[%d]ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    localObject = this.fmd.flT;
    aw.a(this.fmd);
    ((c.a)localObject).cI(paramc.eIj);
    com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(598L, 15L, 1L, false);
    ab.i("MicroMsg.MMCore", "summerasyncinit onAccountInitialized done onAccountPostReset take[%d]ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    f.Mi();
    com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(598L, 16L, 1L, false);
    ab.i("MicroMsg.MMCore", "summerasyncinit onAccountInitialized done all take[%d]ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    AppMethodBeat.o(16281);
  }
  
  public void onAccountRelease() {}
  
  public void onDataBaseClosed(com.tencent.mm.cg.h paramh1, com.tencent.mm.cg.h paramh2) {}
  
  public void onDataBaseOpened(com.tencent.mm.cg.h paramh1, com.tencent.mm.cg.h paramh2)
  {
    AppMethodBeat.i(16283);
    aw.a(this.fmd);
    AppMethodBeat.o(16283);
  }
  
  public void parallelsDependency()
  {
    AppMethodBeat.i(16282);
    com.tencent.mm.kernel.a.b.a.a(this, com.tencent.mm.kernel.api.c.class).az(g.G(p.class));
    AppMethodBeat.o(16282);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.model.aw.a
 * JD-Core Version:    0.7.0.1
 */