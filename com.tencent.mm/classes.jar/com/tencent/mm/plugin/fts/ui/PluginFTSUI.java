package com.tencent.mm.plugin.fts.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.fts.ui.b.a;
import com.tencent.mm.plugin.fts.ui.b.e;
import com.tencent.mm.plugin.fts.ui.b.i;
import com.tencent.mm.plugin.fts.ui.b.j;
import com.tencent.mm.plugin.fts.ui.b.k;
import com.tencent.mm.plugin.fts.ui.b.l;
import com.tencent.mm.plugin.fts.ui.b.m;

public class PluginFTSUI
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.kernel.a.b.b, com.tencent.mm.kernel.api.bucket.c
{
  private void registerUILogic()
  {
    AppMethodBeat.i(112051);
    Object localObject = new m();
    ((n)com.tencent.mm.kernel.h.ag(n.class)).registerFTSUILogic((com.tencent.mm.plugin.fts.a.d.d)localObject);
    localObject = new e();
    ((n)com.tencent.mm.kernel.h.ag(n.class)).registerFTSUILogic((com.tencent.mm.plugin.fts.a.d.d)localObject);
    localObject = new com.tencent.mm.plugin.fts.ui.b.c();
    ((n)com.tencent.mm.kernel.h.ag(n.class)).registerFTSUILogic((com.tencent.mm.plugin.fts.a.d.d)localObject);
    localObject = new i();
    ((n)com.tencent.mm.kernel.h.ag(n.class)).registerFTSUILogic((com.tencent.mm.plugin.fts.a.d.d)localObject);
    localObject = new com.tencent.mm.plugin.fts.ui.b.h();
    ((n)com.tencent.mm.kernel.h.ag(n.class)).registerFTSUILogic((com.tencent.mm.plugin.fts.a.d.d)localObject);
    localObject = new k();
    ((n)com.tencent.mm.kernel.h.ag(n.class)).registerFTSUILogic((com.tencent.mm.plugin.fts.a.d.d)localObject);
    localObject = new com.tencent.mm.plugin.fts.ui.b.d();
    ((n)com.tencent.mm.kernel.h.ag(n.class)).registerFTSUILogic((com.tencent.mm.plugin.fts.a.d.d)localObject);
    localObject = new com.tencent.mm.plugin.fts.ui.b.b();
    ((n)com.tencent.mm.kernel.h.ag(n.class)).registerFTSUILogic((com.tencent.mm.plugin.fts.a.d.d)localObject);
    localObject = new j();
    ((n)com.tencent.mm.kernel.h.ag(n.class)).registerFTSUILogic((com.tencent.mm.plugin.fts.a.d.d)localObject);
    localObject = new a();
    ((n)com.tencent.mm.kernel.h.ag(n.class)).registerFTSUILogic((com.tencent.mm.plugin.fts.a.d.d)localObject);
    localObject = new com.tencent.mm.plugin.fts.ui.b.f();
    ((n)com.tencent.mm.kernel.h.ag(n.class)).registerFTSUILogic((com.tencent.mm.plugin.fts.a.d.d)localObject);
    AppMethodBeat.o(112051);
  }
  
  public void execute(g paramg) {}
  
  public void onAccountInitialized(f.c paramc)
  {
    AppMethodBeat.i(112049);
    registerUILogic();
    paramc = l.BQo;
    l.onCreate();
    AppMethodBeat.o(112049);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(112050);
    l locall = l.BQo;
    l.onDestroy();
    ((n)com.tencent.mm.kernel.h.ag(n.class)).unregisterFTSUILogic(16);
    ((n)com.tencent.mm.kernel.h.ag(n.class)).unregisterFTSUILogic(32);
    ((n)com.tencent.mm.kernel.h.ag(n.class)).unregisterFTSUILogic(48);
    ((n)com.tencent.mm.kernel.h.ag(n.class)).unregisterFTSUILogic(64);
    ((n)com.tencent.mm.kernel.h.ag(n.class)).unregisterFTSUILogic(112);
    ((n)com.tencent.mm.kernel.h.ag(n.class)).unregisterFTSUILogic(4112);
    ((n)com.tencent.mm.kernel.h.ag(n.class)).unregisterFTSUILogic(4128);
    ((n)com.tencent.mm.kernel.h.ag(n.class)).unregisterFTSUILogic(4176);
    ((n)com.tencent.mm.kernel.h.ag(n.class)).unregisterFTSUILogic(8192);
    ((n)com.tencent.mm.kernel.h.ag(n.class)).unregisterFTSUILogic(160);
    AppMethodBeat.o(112050);
  }
  
  public void parallelsDependency() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.PluginFTSUI
 * JD-Core Version:    0.7.0.1
 */