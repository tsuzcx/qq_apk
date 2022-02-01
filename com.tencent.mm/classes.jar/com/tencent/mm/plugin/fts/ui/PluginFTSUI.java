package com.tencent.mm.plugin.fts.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.fts.ui.c.a;
import com.tencent.mm.plugin.fts.ui.c.e;
import com.tencent.mm.plugin.fts.ui.c.f;
import com.tencent.mm.plugin.fts.ui.c.i;
import com.tencent.mm.plugin.fts.ui.c.j;
import com.tencent.mm.plugin.fts.ui.c.k;
import com.tencent.mm.plugin.fts.ui.c.l;
import com.tencent.mm.ui.component.PluginSupportUIC;

public class PluginFTSUI
  extends PluginSupportUIC
  implements com.tencent.mm.kernel.a.b.b, com.tencent.mm.kernel.api.bucket.c
{
  private void registerUILogic()
  {
    AppMethodBeat.i(112051);
    Object localObject = new l();
    ((n)com.tencent.mm.kernel.h.az(n.class)).registerFTSUILogic((com.tencent.mm.plugin.fts.a.d.d)localObject);
    localObject = new e();
    ((n)com.tencent.mm.kernel.h.az(n.class)).registerFTSUILogic((com.tencent.mm.plugin.fts.a.d.d)localObject);
    localObject = new com.tencent.mm.plugin.fts.ui.c.c();
    ((n)com.tencent.mm.kernel.h.az(n.class)).registerFTSUILogic((com.tencent.mm.plugin.fts.a.d.d)localObject);
    localObject = new com.tencent.mm.plugin.fts.ui.c.h();
    ((n)com.tencent.mm.kernel.h.az(n.class)).registerFTSUILogic((com.tencent.mm.plugin.fts.a.d.d)localObject);
    localObject = new com.tencent.mm.plugin.fts.ui.c.g();
    ((n)com.tencent.mm.kernel.h.az(n.class)).registerFTSUILogic((com.tencent.mm.plugin.fts.a.d.d)localObject);
    localObject = new j();
    ((n)com.tencent.mm.kernel.h.az(n.class)).registerFTSUILogic((com.tencent.mm.plugin.fts.a.d.d)localObject);
    localObject = new com.tencent.mm.plugin.fts.ui.c.d();
    ((n)com.tencent.mm.kernel.h.az(n.class)).registerFTSUILogic((com.tencent.mm.plugin.fts.a.d.d)localObject);
    localObject = new com.tencent.mm.plugin.fts.ui.c.b();
    ((n)com.tencent.mm.kernel.h.az(n.class)).registerFTSUILogic((com.tencent.mm.plugin.fts.a.d.d)localObject);
    localObject = new i();
    ((n)com.tencent.mm.kernel.h.az(n.class)).registerFTSUILogic((com.tencent.mm.plugin.fts.a.d.d)localObject);
    localObject = new a();
    ((n)com.tencent.mm.kernel.h.az(n.class)).registerFTSUILogic((com.tencent.mm.plugin.fts.a.d.d)localObject);
    localObject = new f();
    ((n)com.tencent.mm.kernel.h.az(n.class)).registerFTSUILogic((com.tencent.mm.plugin.fts.a.d.d)localObject);
    AppMethodBeat.o(112051);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg) {}
  
  public void onAccountInitialized(f.c paramc)
  {
    AppMethodBeat.i(112049);
    registerUILogic();
    paramc = k.HBV;
    k.onCreate();
    AppMethodBeat.o(112049);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(112050);
    k localk = k.HBV;
    k.onDestroy();
    ((n)com.tencent.mm.kernel.h.az(n.class)).unregisterFTSUILogic(16);
    ((n)com.tencent.mm.kernel.h.az(n.class)).unregisterFTSUILogic(32);
    ((n)com.tencent.mm.kernel.h.az(n.class)).unregisterFTSUILogic(48);
    ((n)com.tencent.mm.kernel.h.az(n.class)).unregisterFTSUILogic(64);
    ((n)com.tencent.mm.kernel.h.az(n.class)).unregisterFTSUILogic(112);
    ((n)com.tencent.mm.kernel.h.az(n.class)).unregisterFTSUILogic(4112);
    ((n)com.tencent.mm.kernel.h.az(n.class)).unregisterFTSUILogic(4128);
    ((n)com.tencent.mm.kernel.h.az(n.class)).unregisterFTSUILogic(4176);
    ((n)com.tencent.mm.kernel.h.az(n.class)).unregisterFTSUILogic(8192);
    ((n)com.tencent.mm.kernel.h.az(n.class)).unregisterFTSUILogic(160);
    AppMethodBeat.o(112050);
  }
  
  public void parallelsDependency() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.PluginFTSUI
 * JD-Core Version:    0.7.0.1
 */