package com.tencent.mm.plugin.byp;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.aw;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.protocal.j.h;
import com.tencent.mm.protocal.j.i;
import com.tencent.mm.protocal.x.b;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/byp/PluginByp;", "Lcom/tencent/mm/kernel/plugin/Plugin;", "Lcom/tencent/mm/plugin/byp/api/IPluginByp;", "Lcom/tencent/mm/kernel/api/ICoreAccountCallback;", "()V", "bypSyncEventListener", "com/tencent/mm/plugin/byp/PluginByp$bypSyncEventListener$1", "Lcom/tencent/mm/plugin/byp/PluginByp$bypSyncEventListener$1;", "syncExtension", "Lcom/tencent/mm/plugin/byp/BypSyncCore;", "addBypSyncHandler", "", "bizSyncKeyType", "", "handler", "Lcom/tencent/mm/plugin/byp/api/IBypSyncHandler;", "configure", "profile", "Lcom/tencent/mm/kernel/plugin/ProcessProfile;", "execute", "getSyncExtension", "mergeSelectorAndDoScene", "onAccountInitialized", "upgrade", "Lcom/tencent/mm/kernel/CoreStorage$UpgradeInfo;", "onAccountRelease", "removeBypSyncHandler", "Companion", "plugin-byp_release"})
public final class PluginByp
  extends f
  implements com.tencent.mm.kernel.api.c, com.tencent.mm.plugin.byp.a.c
{
  public static final a sWr;
  private final c sWp;
  private final b sWq;
  
  static
  {
    AppMethodBeat.i(213505);
    sWr = new a((byte)0);
    AppMethodBeat.o(213505);
  }
  
  public PluginByp()
  {
    AppMethodBeat.i(213504);
    this.sWp = new c();
    this.sWq = new b(this);
    AppMethodBeat.o(213504);
  }
  
  public final void addBypSyncHandler(int paramInt, com.tencent.mm.plugin.byp.a.b paramb)
  {
    AppMethodBeat.i(213501);
    p.k(paramb, "handler");
    c localc = this.sWp;
    p.k(paramb, "handler");
    localc.sVV.putIfAbsent(Integer.valueOf(paramInt), paramb);
    AppMethodBeat.o(213501);
  }
  
  public final void configure(g paramg)
  {
    AppMethodBeat.i(213497);
    p.k(paramg, "profile");
    super.configure(paramg);
    if (paramg.aIE())
    {
      Log.i("Byp.PluginByp", "[configure]");
      ((com.tencent.mm.plugin.auth.a.c)h.ag(com.tencent.mm.plugin.auth.a.c.class)).addHandleAuthResponse((com.tencent.mm.plugin.auth.a.b)new c(this));
    }
    AppMethodBeat.o(213497);
  }
  
  public final void execute(g paramg) {}
  
  public final c getSyncExtension()
  {
    return this.sWp;
  }
  
  public final void mergeSelectorAndDoScene()
  {
    AppMethodBeat.i(213503);
    Object localObject = a.a.sVT;
    localObject = a.a.cEY();
    a.a locala = a.a.sVT;
    if (!((ArrayList)localObject).containsAll((Collection)a.a.cEX()))
    {
      localObject = a.a.sVT;
      localObject = a.a.cEY();
      locala = a.a.sVT;
      ((ArrayList)localObject).addAll((Collection)a.a.cEX());
    }
    localObject = this.sWp;
    locala = a.a.sVT;
    c.a((c)localObject, a.a.cEX(), c.b.sWg, false, 12);
    AppMethodBeat.o(213503);
  }
  
  public final void onAccountInitialized(f.c paramc)
  {
    AppMethodBeat.i(213499);
    Log.i("Byp.PluginByp", "[onAccountInitialized]");
    this.sWq.alive();
    this.sWp.sVW.alive();
    AppMethodBeat.o(213499);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(213494);
    Log.i("Byp.PluginByp", "[onAccountRelease]");
    this.sWq.dead();
    this.sWp.sVW.dead();
    AppMethodBeat.o(213494);
  }
  
  public final void removeBypSyncHandler(int paramInt)
  {
    AppMethodBeat.i(213500);
    this.sWp.sVV.remove(Integer.valueOf(paramInt));
    AppMethodBeat.o(213500);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/byp/PluginByp$Companion;", "", "()V", "TAG", "", "plugin-byp_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/byp/PluginByp$bypSyncEventListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/BypNotifyEvent;", "callback", "", "event", "plugin-byp_release"})
  public static final class b
    extends IListener<aw>
  {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/byp/PluginByp$configure$1", "Lcom/tencent/mm/plugin/auth/api/IHandleAuthResponse;", "onAuthResponse", "", "req", "Lcom/tencent/mm/protocal/MMAuth$Req;", "resp", "Lcom/tencent/mm/protocal/MMAuth$Resp;", "autoAuth", "", "onRegResponse", "Lcom/tencent/mm/protocal/MMReg2$Resp;", "alias", "", "bindUin", "", "nick", "mobile", "pluginFlag", "plugin-byp_release"})
  public static final class c
    implements com.tencent.mm.plugin.auth.a.b
  {
    public final void a(j.h paramh, j.i parami, boolean paramBoolean)
    {
      AppMethodBeat.i(213567);
      Log.i("Byp.PluginByp", "[onAuthResponse] autoAuth=".concat(String.valueOf(paramBoolean)));
      paramh = PluginByp.access$getSyncExtension$p(this.sWs);
      parami = a.a.sVT;
      c.a(paramh, (List)a.a.cEY(), c.b.sWb, false, 12);
      AppMethodBeat.o(213567);
    }
    
    public final void a(x.b paramb, String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.byp.PluginByp
 * JD-Core Version:    0.7.0.1
 */