package com.tencent.mm.plugin.byp;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.au;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.protocal.j.h;
import com.tencent.mm.protocal.j.i;
import com.tencent.mm.protocal.x.b;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/byp/PluginByp;", "Lcom/tencent/mm/kernel/plugin/Plugin;", "Lcom/tencent/mm/plugin/byp/api/IPluginByp;", "Lcom/tencent/mm/kernel/api/ICoreAccountCallback;", "()V", "bypSyncEventListener", "com/tencent/mm/plugin/byp/PluginByp$bypSyncEventListener$1", "Lcom/tencent/mm/plugin/byp/PluginByp$bypSyncEventListener$1;", "syncExtension", "Lcom/tencent/mm/plugin/byp/BypSyncCore;", "addBypSyncHandler", "", "bizSyncKeyType", "", "handler", "Lcom/tencent/mm/plugin/byp/api/IBypSyncHandler;", "configure", "profile", "Lcom/tencent/mm/kernel/plugin/ProcessProfile;", "execute", "onAccountInitialized", "upgrade", "Lcom/tencent/mm/kernel/CoreStorage$UpgradeInfo;", "onAccountRelease", "removeBypSyncHandler", "Companion", "plugin-byp_release"})
public final class PluginByp
  extends f
  implements com.tencent.mm.kernel.api.c, com.tencent.mm.plugin.byp.a.c
{
  public static final PluginByp.a pPs;
  private final c pPq;
  private final b pPr;
  
  static
  {
    AppMethodBeat.i(199106);
    pPs = new PluginByp.a((byte)0);
    AppMethodBeat.o(199106);
  }
  
  public PluginByp()
  {
    AppMethodBeat.i(199105);
    this.pPq = new c();
    this.pPr = new b(this);
    AppMethodBeat.o(199105);
  }
  
  public final void addBypSyncHandler(int paramInt, com.tencent.mm.plugin.byp.a.b paramb)
  {
    AppMethodBeat.i(199104);
    p.h(paramb, "handler");
    c localc = this.pPq;
    p.h(paramb, "handler");
    localc.pOX.putIfAbsent(Integer.valueOf(paramInt), paramb);
    AppMethodBeat.o(199104);
  }
  
  public final void configure(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(199101);
    p.h(paramg, "profile");
    super.configure(paramg);
    if (paramg.aBb())
    {
      Log.i("Byp.PluginByp", "[configure]");
      ((com.tencent.mm.plugin.auth.a.c)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.auth.a.c.class)).addHandleAuthResponse((com.tencent.mm.plugin.auth.a.b)new c(this));
    }
    AppMethodBeat.o(199101);
  }
  
  public final void execute(com.tencent.mm.kernel.b.g paramg) {}
  
  public final void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(199102);
    Log.i("Byp.PluginByp", "[onAccountInitialized]");
    this.pPr.alive();
    this.pPq.pOY.alive();
    AppMethodBeat.o(199102);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(199100);
    Log.i("Byp.PluginByp", "[onAccountRelease]");
    this.pPr.dead();
    this.pPq.pOY.dead();
    AppMethodBeat.o(199100);
  }
  
  public final void removeBypSyncHandler(int paramInt)
  {
    AppMethodBeat.i(199103);
    this.pPq.pOX.remove(Integer.valueOf(paramInt));
    AppMethodBeat.o(199103);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/byp/PluginByp$bypSyncEventListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/BypNotifyEvent;", "callback", "", "event", "plugin-byp_release"})
  public static final class b
    extends IListener<au>
  {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/byp/PluginByp$configure$1", "Lcom/tencent/mm/plugin/auth/api/IHandleAuthResponse;", "onAuthResponse", "", "req", "Lcom/tencent/mm/protocal/MMAuth$Req;", "resp", "Lcom/tencent/mm/protocal/MMAuth$Resp;", "autoAuth", "", "onRegResponse", "Lcom/tencent/mm/protocal/MMReg2$Resp;", "alias", "", "bindUin", "", "nick", "mobile", "pluginFlag", "plugin-byp_release"})
  public static final class c
    implements com.tencent.mm.plugin.auth.a.b
  {
    public final void a(j.h paramh, j.i parami, boolean paramBoolean)
    {
      AppMethodBeat.i(199099);
      Log.i("Byp.PluginByp", "[onAuthResponse] autoAuth=".concat(String.valueOf(paramBoolean)));
      paramh = PluginByp.access$getSyncExtension$p(this.pPt);
      parami = a.a.pOV;
      c.a(paramh, a.a.crQ(), c.b.pPd, false, 12);
      AppMethodBeat.o(199099);
    }
    
    public final void a(x.b paramb, String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.byp.PluginByp
 * JD-Core Version:    0.7.0.1
 */