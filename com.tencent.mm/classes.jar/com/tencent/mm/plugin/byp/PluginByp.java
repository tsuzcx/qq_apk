package com.tencent.mm.plugin.byp;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.as;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.plugin.byp.a.b;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;
import java.util.concurrent.ConcurrentHashMap;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/byp/PluginByp;", "Lcom/tencent/mm/kernel/plugin/Plugin;", "Lcom/tencent/mm/plugin/byp/api/IPluginByp;", "Lcom/tencent/mm/kernel/api/ICoreAccountCallback;", "()V", "bypSyncEventListener", "com/tencent/mm/plugin/byp/PluginByp$bypSyncEventListener$1", "Lcom/tencent/mm/plugin/byp/PluginByp$bypSyncEventListener$1;", "syncExtension", "Lcom/tencent/mm/plugin/byp/BypSyncCore;", "addBypSyncHandler", "", "bizSyncKeyType", "", "handler", "Lcom/tencent/mm/plugin/byp/api/IBypSyncHandler;", "execute", "profile", "Lcom/tencent/mm/kernel/plugin/ProcessProfile;", "onAccountInitialized", "upgrade", "Lcom/tencent/mm/kernel/CoreStorage$UpgradeInfo;", "onAccountRelease", "removeBypSyncHandler", "Companion", "plugin-byp_release"})
public final class PluginByp
  extends f
  implements com.tencent.mm.kernel.api.c, com.tencent.mm.plugin.byp.a.c
{
  public static final a oBG;
  private final c oBE;
  private final b oBF;
  
  static
  {
    AppMethodBeat.i(218330);
    oBG = new a((byte)0);
    AppMethodBeat.o(218330);
  }
  
  public PluginByp()
  {
    AppMethodBeat.i(218329);
    this.oBE = new c();
    this.oBF = new b(this);
    AppMethodBeat.o(218329);
  }
  
  public final void addBypSyncHandler(int paramInt, b paramb)
  {
    AppMethodBeat.i(218328);
    p.h(paramb, "handler");
    c localc = this.oBE;
    p.h(paramb, "handler");
    localc.oBm.putIfAbsent(Integer.valueOf(paramInt), paramb);
    AppMethodBeat.o(218328);
  }
  
  public final void execute(g paramg) {}
  
  public final void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(218326);
    ae.i("Byp.PluginByp", "[onAccountInitialized]");
    this.oBF.alive();
    this.oBE.oBn.alive();
    paramc = this.oBE;
    a.a locala = a.a.oBk;
    c.a(paramc, a.a.bUd(), c.b.oBs, false, 12);
    AppMethodBeat.o(218326);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(218325);
    ae.i("Byp.PluginByp", "[onAccountRelease]");
    this.oBF.dead();
    this.oBE.oBn.dead();
    AppMethodBeat.o(218325);
  }
  
  public final void removeBypSyncHandler(int paramInt)
  {
    AppMethodBeat.i(218327);
    this.oBE.oBm.remove(Integer.valueOf(paramInt));
    AppMethodBeat.o(218327);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/byp/PluginByp$Companion;", "", "()V", "TAG", "", "plugin-byp_release"})
  public static final class a {}
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/byp/PluginByp$bypSyncEventListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/BypNotifyEvent;", "callback", "", "event", "plugin-byp_release"})
  public static final class b
    extends com.tencent.mm.sdk.b.c<as>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.byp.PluginByp
 * JD-Core Version:    0.7.0.1
 */