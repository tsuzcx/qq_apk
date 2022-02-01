package com.tencent.mm.plugin.byp;

import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.bb;
import com.tencent.mm.autogen.a.bc;
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
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/byp/PluginByp;", "Lcom/tencent/mm/kernel/plugin/Plugin;", "Lcom/tencent/mm/plugin/byp/api/IPluginByp;", "Lcom/tencent/mm/kernel/api/ICoreAccountCallback;", "()V", "bypSyncEventListener", "com/tencent/mm/plugin/byp/PluginByp$bypSyncEventListener$1", "Lcom/tencent/mm/plugin/byp/PluginByp$bypSyncEventListener$1;", "bypSyncNewNotifyEventListener", "com/tencent/mm/plugin/byp/PluginByp$bypSyncNewNotifyEventListener$1", "Lcom/tencent/mm/plugin/byp/PluginByp$bypSyncNewNotifyEventListener$1;", "syncExtension", "Lcom/tencent/mm/plugin/byp/BypSyncCore;", "addBypSyncHandler", "", "bizSyncKeyType", "", "handler", "Lcom/tencent/mm/plugin/byp/api/IBypSyncHandler;", "configure", "profile", "Lcom/tencent/mm/kernel/plugin/ProcessProfile;", "execute", "getSyncExtension", "mergeSelectorAndDoScene", "onAccountInitialized", "upgrade", "Lcom/tencent/mm/kernel/CoreStorage$UpgradeInfo;", "onAccountRelease", "removeBypSyncHandler", "Companion", "plugin-byp_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class PluginByp
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.kernel.api.c, com.tencent.mm.plugin.byp.a.c
{
  public static final a way;
  private final bypSyncEventListener.1 waA;
  private final bypSyncNewNotifyEventListener.1 waB;
  private final c waz;
  
  static
  {
    AppMethodBeat.i(271968);
    way = new a((byte)0);
    AppMethodBeat.o(271968);
  }
  
  public PluginByp()
  {
    AppMethodBeat.i(271964);
    this.waz = new c();
    this.waA = new IListener(com.tencent.mm.app.f.hfK) {};
    this.waB = new IListener(com.tencent.mm.app.f.hfK) {};
    AppMethodBeat.o(271964);
  }
  
  public final void addBypSyncHandler(int paramInt, com.tencent.mm.plugin.byp.a.b paramb)
  {
    AppMethodBeat.i(271987);
    s.u(paramb, "handler");
    c localc = this.waz;
    s.u(paramb, "handler");
    localc.wai.putIfAbsent(Integer.valueOf(paramInt), paramb);
    AppMethodBeat.o(271987);
  }
  
  public final void configure(g paramg)
  {
    AppMethodBeat.i(271978);
    s.u(paramg, "profile");
    super.configure(paramg);
    if (paramg.bbA())
    {
      Log.i("Byp.PluginByp", "[configure]");
      ((com.tencent.mm.plugin.auth.a.c)h.az(com.tencent.mm.plugin.auth.a.c.class)).addHandleAuthResponse((com.tencent.mm.plugin.auth.a.b)new b(this));
    }
    AppMethodBeat.o(271978);
  }
  
  public final void execute(g paramg) {}
  
  public final c getSyncExtension()
  {
    return this.waz;
  }
  
  public final void mergeSelectorAndDoScene()
  {
    AppMethodBeat.i(272000);
    Object localObject = a.a.wab;
    localObject = a.a.dii();
    a.a locala = a.a.wab;
    if (!((ArrayList)localObject).containsAll((Collection)a.a.dih()))
    {
      localObject = a.a.wab;
      localObject = a.a.dii();
      locala = a.a.wab;
      ((ArrayList)localObject).addAll((Collection)a.a.dih());
    }
    localObject = this.waz;
    locala = a.a.wab;
    c.a((c)localObject, a.a.dih(), c.b.was, false, 12);
    AppMethodBeat.o(272000);
  }
  
  public final void onAccountInitialized(f.c paramc)
  {
    AppMethodBeat.i(271981);
    Log.i("Byp.PluginByp", "[onAccountInitialized]");
    this.waA.alive();
    this.waB.alive();
    this.waz.waj.alive();
    AppMethodBeat.o(271981);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(271974);
    Log.i("Byp.PluginByp", "[onAccountRelease]");
    this.waA.dead();
    this.waB.dead();
    this.waz.waj.dead();
    com.tencent.mm.plugin.byp.c.f.waY.dead();
    AppMethodBeat.o(271974);
  }
  
  public final void removeBypSyncHandler(int paramInt)
  {
    AppMethodBeat.i(271983);
    this.waz.wai.remove(Integer.valueOf(paramInt));
    AppMethodBeat.o(271983);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/byp/PluginByp$Companion;", "", "()V", "TAG", "", "plugin-byp_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/byp/PluginByp$configure$1", "Lcom/tencent/mm/plugin/auth/api/IHandleAuthResponse;", "onAuthResponse", "", "req", "Lcom/tencent/mm/protocal/MMAuth$Req;", "resp", "Lcom/tencent/mm/protocal/MMAuth$Resp;", "autoAuth", "", "onRegResponse", "Lcom/tencent/mm/protocal/MMReg2$Resp;", "alias", "", "bindUin", "", "nick", "mobile", "pluginFlag", "plugin-byp_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements com.tencent.mm.plugin.auth.a.b
  {
    b(PluginByp paramPluginByp) {}
    
    public final void onAuthResponse(j.h paramh, j.i parami, boolean paramBoolean)
    {
      AppMethodBeat.i(271960);
      Log.i("Byp.PluginByp", s.X("[onAuthResponse] autoAuth=", Boolean.valueOf(paramBoolean)));
      paramh = PluginByp.access$getSyncExtension$p(this.waC);
      parami = a.a.wab;
      c.a(paramh, (List)a.a.dii(), c.b.wan, false, 12);
      AppMethodBeat.o(271960);
    }
    
    public final void onRegResponse(x.b paramb, String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.byp.PluginByp
 * JD-Core Version:    0.7.0.1
 */