package com.tencent.mm.plugin.byp;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.as;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.plugin.byp.a.b;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.l;
import java.util.concurrent.ConcurrentHashMap;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/byp/PluginByp;", "Lcom/tencent/mm/kernel/plugin/Plugin;", "Lcom/tencent/mm/plugin/byp/api/IPluginByp;", "Lcom/tencent/mm/kernel/api/ICoreAccountCallback;", "()V", "bypSyncEventListener", "com/tencent/mm/plugin/byp/PluginByp$bypSyncEventListener$1", "Lcom/tencent/mm/plugin/byp/PluginByp$bypSyncEventListener$1;", "syncExtension", "Lcom/tencent/mm/plugin/byp/BypSyncCore;", "addBypSyncHandler", "", "bizSyncKeyType", "", "handler", "Lcom/tencent/mm/plugin/byp/api/IBypSyncHandler;", "execute", "profile", "Lcom/tencent/mm/kernel/plugin/ProcessProfile;", "onAccountInitialized", "upgrade", "Lcom/tencent/mm/kernel/CoreStorage$UpgradeInfo;", "onAccountRelease", "removeBypSyncHandler", "Companion", "plugin-byp_release"})
public final class PluginByp
  extends f
  implements com.tencent.mm.kernel.api.c, com.tencent.mm.plugin.byp.a.c
{
  public static final a ovg;
  private final c ove;
  private final b ovf;
  
  static
  {
    AppMethodBeat.i(219215);
    ovg = new a((byte)0);
    AppMethodBeat.o(219215);
  }
  
  public PluginByp()
  {
    AppMethodBeat.i(219214);
    this.ove = new c();
    this.ovf = new b(this);
    AppMethodBeat.o(219214);
  }
  
  public final void addBypSyncHandler(int paramInt, b paramb)
  {
    AppMethodBeat.i(219213);
    p.h(paramb, "handler");
    c localc = this.ove;
    p.h(paramb, "handler");
    localc.ouM.putIfAbsent(Integer.valueOf(paramInt), paramb);
    AppMethodBeat.o(219213);
  }
  
  public final void execute(g paramg) {}
  
  public final void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(219211);
    ad.i("Byp.PluginByp", "[onAccountInitialized]");
    this.ovf.alive();
    this.ove.ouN.alive();
    paramc = this.ove;
    a.a locala = a.a.ouK;
    c.a(paramc, a.a.bEd(), c.b.ouS, false, 12);
    AppMethodBeat.o(219211);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(219210);
    ad.i("Byp.PluginByp", "[onAccountRelease]");
    this.ovf.dead();
    this.ove.ouN.dead();
    AppMethodBeat.o(219210);
  }
  
  public final void removeBypSyncHandler(int paramInt)
  {
    AppMethodBeat.i(219212);
    this.ove.ouM.remove(Integer.valueOf(paramInt));
    AppMethodBeat.o(219212);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/byp/PluginByp$Companion;", "", "()V", "TAG", "", "plugin-byp_release"})
  public static final class a {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/byp/PluginByp$bypSyncEventListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/BypNotifyEvent;", "callback", "", "event", "plugin-byp_release"})
  public static final class b
    extends com.tencent.mm.sdk.b.c<as>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.byp.PluginByp
 * JD-Core Version:    0.7.0.1
 */