package com.tencent.mm.live;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.AppForegroundDelegate;
import com.tencent.mm.g.a.la;
import com.tencent.mm.g.a.rn;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.live.b.g.d;
import com.tencent.mm.live.b.h;
import com.tencent.mm.live.b.i;
import com.tencent.mm.live.b.j;
import com.tencent.mm.live.core.core.b.d;
import com.tencent.mm.live.core.core.b.e;
import com.tencent.mm.model.cc;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.protocal.protobuf.bqd;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.storagebase.h.b;
import d.g.b.k;
import d.g.b.v.d;
import d.v;
import d.y;
import java.util.HashMap;
import java.util.Map;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/live/PluginLive;", "Lcom/tencent/mm/kernel/plugin/Plugin;", "Lcom/tencent/mm/live/IPluginLive;", "Lcom/tencent/mm/kernel/api/ICoreAccountCallback;", "Lcom/tencent/mm/kernel/api/bucket/ICollectDBFactoryBucket;", "()V", "appForegroundListener", "com/tencent/mm/live/PluginLive$appForegroundListener$1", "Lcom/tencent/mm/live/PluginLive$appForegroundListener$1;", "liveStatusMap", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "liveSysMsgReceiver", "Lcom/tencent/mm/live/model/LiveSysMsgReceiver;", "logoutEvent", "Lcom/tencent/mm/sdk/event/IListener;", "revokeMsgListener", "collectDatabaseFactory", "Lcom/tencent/mm/storagebase/SqliteDB$IFactory;", "curLiveId", "execute", "", "profile", "Lcom/tencent/mm/kernel/plugin/ProcessProfile;", "forceStopCurLive", "context", "Landroid/content/Context;", "getLiveTipsBarStorage", "Lcom/tencent/mm/live/model/storage/LiveTipsBarStorage;", "getLivingRoomId", "", "isAnchorLiving", "", "isFloatMode", "isVisitorLiving", "isVisitorMicing", "liveEntranceJumper", "Lcom/tencent/mm/live/api/ILiveEntranceJumper;", "onAccountInitialized", "upgrade", "Lcom/tencent/mm/kernel/CoreStorage$UpgradeInfo;", "onAccountRelease", "refreshLiveStatus", "liveId", "roomId", "callback", "Lcom/tencent/mm/live/IPluginLive$LiveStatusCallback;", "Companion", "plugin-logic_release"})
public final class PluginLive
  extends f
  implements com.tencent.mm.kernel.api.bucket.a, com.tencent.mm.kernel.api.c, a
{
  public static final PluginLive.a gmy;
  private final com.tencent.mm.sdk.b.c<?> foi;
  private final j gmu;
  private final HashMap<Long, Integer> gmv;
  private final com.tencent.mm.sdk.b.c<?> gmw;
  private final b gmx;
  
  static
  {
    AppMethodBeat.i(189721);
    gmy = new PluginLive.a((byte)0);
    AppMethodBeat.o(189721);
  }
  
  public PluginLive()
  {
    AppMethodBeat.i(189720);
    this.gmu = new j();
    this.gmv = new HashMap();
    this.gmw = ((com.tencent.mm.sdk.b.c)new d(this));
    this.gmx = new b();
    this.foi = ((com.tencent.mm.sdk.b.c)new f());
    AppMethodBeat.o(189720);
  }
  
  public final HashMap<Integer, h.b> collectDatabaseFactory()
  {
    AppMethodBeat.i(189712);
    HashMap localHashMap = new HashMap();
    localHashMap.put(Integer.valueOf("LiveTipsBar".hashCode()), c.gmz);
    AppMethodBeat.o(189712);
    return localHashMap;
  }
  
  public final long curLiveId()
  {
    AppMethodBeat.i(189715);
    com.tencent.mm.live.b.g localg = com.tencent.mm.live.b.g.guG;
    long l = com.tencent.mm.live.b.g.akF().DMV;
    AppMethodBeat.o(189715);
    return l;
  }
  
  public final void execute(com.tencent.mm.kernel.b.g paramg) {}
  
  public final void forceStopCurLive(Context paramContext)
  {
    AppMethodBeat.i(189719);
    k.h(paramContext, "context");
    ac.m("MicroMsg.PluginLive", "forceStopCurLive", new Object[0]);
    Object localObject = com.tencent.mm.live.core.core.a.b.gnC;
    if (com.tencent.mm.live.core.core.a.b.a.aiN())
    {
      localObject = i.gvw;
      i.alC();
      localObject = com.tencent.mm.live.b.c.a.gxp;
      com.tencent.mm.live.b.c.a.alK();
      localObject = com.tencent.mm.live.core.core.a.b.gnC;
      paramContext = (com.tencent.mm.live.core.core.trtc.a)com.tencent.mm.live.core.core.a.b.a.ct(paramContext);
    }
    while (paramContext != null)
    {
      paramContext.aiu();
      AppMethodBeat.o(189719);
      return;
      localObject = com.tencent.mm.live.core.core.c.b.gqt;
      if (com.tencent.mm.live.core.core.c.b.a.aiN())
      {
        localObject = com.tencent.mm.live.core.core.c.b.gqt;
        paramContext = (com.tencent.mm.live.core.core.trtc.a)com.tencent.mm.live.core.core.c.b.a.cu(paramContext);
      }
      else
      {
        paramContext = null;
      }
    }
    AppMethodBeat.o(189719);
  }
  
  public final com.tencent.mm.live.b.c.c getLiveTipsBarStorage()
  {
    AppMethodBeat.i(189708);
    com.tencent.mm.live.b.c.c localc = com.tencent.mm.live.b.c.c.getLiveTipsBarStorage();
    AppMethodBeat.o(189708);
    return localc;
  }
  
  public final String getLivingRoomId()
  {
    AppMethodBeat.i(189711);
    Object localObject = com.tencent.mm.live.b.g.guG;
    localObject = com.tencent.mm.live.b.g.akA();
    AppMethodBeat.o(189711);
    return localObject;
  }
  
  public final boolean isAnchorLiving()
  {
    AppMethodBeat.i(189713);
    Object localObject = com.tencent.mm.live.b.g.guG;
    if (com.tencent.mm.live.b.g.akF().DMV != 0L)
    {
      localObject = com.tencent.mm.live.b.g.guG;
      if (!com.tencent.mm.live.b.g.akT().guO)
      {
        localObject = com.tencent.mm.live.b.g.guG;
        if (!com.tencent.mm.live.b.g.akT().guQ)
        {
          localObject = com.tencent.mm.live.core.core.a.b.gnC;
          if (com.tencent.mm.live.core.core.a.b.a.aiN())
          {
            AppMethodBeat.o(189713);
            return true;
          }
        }
      }
    }
    AppMethodBeat.o(189713);
    return false;
  }
  
  public final boolean isFloatMode()
  {
    AppMethodBeat.i(189717);
    Object localObject = com.tencent.mm.live.core.core.c.b.gqt;
    boolean bool;
    if (com.tencent.mm.live.core.core.c.b.a.aiN())
    {
      localObject = com.tencent.mm.live.core.core.c.b.gqt;
      localObject = ai.getContext();
      k.g(localObject, "MMApplicationContext.getContext()");
      bool = com.tencent.mm.live.core.core.c.b.a.cu((Context)localObject).goL.isFloatMode();
      AppMethodBeat.o(189717);
      return bool;
    }
    localObject = com.tencent.mm.live.core.core.a.b.gnC;
    if (com.tencent.mm.live.core.core.a.b.a.aiN())
    {
      localObject = com.tencent.mm.live.core.core.a.b.gnC;
      localObject = ai.getContext();
      k.g(localObject, "MMApplicationContext.getContext()");
      bool = com.tencent.mm.live.core.core.a.b.a.ct((Context)localObject).goL.isFloatMode();
      AppMethodBeat.o(189717);
      return bool;
    }
    AppMethodBeat.o(189717);
    return false;
  }
  
  public final boolean isVisitorLiving()
  {
    AppMethodBeat.i(189714);
    Object localObject = com.tencent.mm.live.b.g.guG;
    if (com.tencent.mm.live.b.g.akF().DMV != 0L)
    {
      localObject = com.tencent.mm.live.b.g.guG;
      if (!com.tencent.mm.live.b.g.akT().guO)
      {
        localObject = com.tencent.mm.live.b.g.guG;
        if (!com.tencent.mm.live.b.g.akT().guQ)
        {
          localObject = com.tencent.mm.live.core.core.c.b.gqt;
          if (com.tencent.mm.live.core.core.c.b.a.aiN())
          {
            AppMethodBeat.o(189714);
            return true;
          }
        }
      }
    }
    AppMethodBeat.o(189714);
    return false;
  }
  
  public final boolean isVisitorMicing()
  {
    AppMethodBeat.i(189716);
    Object localObject = com.tencent.mm.live.b.g.guG;
    if (com.tencent.mm.live.b.g.akF().DMV != 0L)
    {
      localObject = com.tencent.mm.live.core.core.c.b.gqt;
      if (com.tencent.mm.live.core.core.c.b.a.aiN())
      {
        localObject = com.tencent.mm.live.core.core.c.b.gqt;
        localObject = ai.getContext();
        k.g(localObject, "MMApplicationContext.getContext()");
        if (com.tencent.mm.live.core.core.c.b.a.cu((Context)localObject).aiU())
        {
          AppMethodBeat.o(189716);
          return true;
        }
      }
    }
    AppMethodBeat.o(189716);
    return false;
  }
  
  public final com.tencent.mm.live.api.a liveEntranceJumper()
  {
    return (com.tencent.mm.live.api.a)h.guS;
  }
  
  public final void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(189709);
    ac.i("MicroMsg.PluginLive", "onAccountInitialized");
    com.tencent.mm.sdk.b.a.GpY.c(this.gmw);
    paramc = com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class);
    k.g(paramc, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
    ((com.tencent.mm.plugin.messenger.foundation.a.q)paramc).getSysCmdMsgExtension().a("ApplyLiveMic", (p)this.gmu);
    paramc = com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class);
    k.g(paramc, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
    ((com.tencent.mm.plugin.messenger.foundation.a.q)paramc).getSysCmdMsgExtension().a("AcceptLiveMic", (p)this.gmu);
    paramc = com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class);
    k.g(paramc, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
    ((com.tencent.mm.plugin.messenger.foundation.a.q)paramc).getSysCmdMsgExtension().a("CloseLive", (p)this.gmu);
    paramc = com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class);
    k.g(paramc, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
    ((com.tencent.mm.plugin.messenger.foundation.a.q)paramc).getSysCmdMsgExtension().a("CloseLiveMic", (p)this.gmu);
    paramc = com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class);
    k.g(paramc, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
    ((com.tencent.mm.plugin.messenger.foundation.a.q)paramc).getSysCmdMsgExtension().a("CloseApplyLiveMic", (p)this.gmu);
    paramc = com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class);
    k.g(paramc, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
    ((com.tencent.mm.plugin.messenger.foundation.a.q)paramc).getSysCmdMsgExtension().a("BanLiveComment", (p)this.gmu);
    paramc = com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class);
    k.g(paramc, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
    ((com.tencent.mm.plugin.messenger.foundation.a.q)paramc).getSysCmdMsgExtension().a("LiveMicSucc", (p)this.gmu);
    paramc = com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class);
    k.g(paramc, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
    ((com.tencent.mm.plugin.messenger.foundation.a.q)paramc).getSysCmdMsgExtension().a("OnlineLiveList", (p)this.gmu);
    AppForegroundDelegate.cHM.a((com.tencent.mm.app.n)this.gmx);
    this.foi.alive();
    AppMethodBeat.o(189709);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(189710);
    ac.i("MicroMsg.PluginLive", "onAccountRelease");
    com.tencent.mm.sdk.b.a.GpY.d(this.gmw);
    com.tencent.mm.kernel.b.a locala = com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class);
    k.g(locala, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
    ((com.tencent.mm.plugin.messenger.foundation.a.q)locala).getSysCmdMsgExtension().b("ApplyLiveMic", (p)this.gmu);
    locala = com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class);
    k.g(locala, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
    ((com.tencent.mm.plugin.messenger.foundation.a.q)locala).getSysCmdMsgExtension().b("AcceptLiveMic", (p)this.gmu);
    locala = com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class);
    k.g(locala, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
    ((com.tencent.mm.plugin.messenger.foundation.a.q)locala).getSysCmdMsgExtension().b("CloseLive", (p)this.gmu);
    locala = com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class);
    k.g(locala, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
    ((com.tencent.mm.plugin.messenger.foundation.a.q)locala).getSysCmdMsgExtension().b("CloseLiveMic", (p)this.gmu);
    locala = com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class);
    k.g(locala, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
    ((com.tencent.mm.plugin.messenger.foundation.a.q)locala).getSysCmdMsgExtension().b("CloseApplyLiveMic", (p)this.gmu);
    locala = com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class);
    k.g(locala, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
    ((com.tencent.mm.plugin.messenger.foundation.a.q)locala).getSysCmdMsgExtension().b("BanLiveComment", (p)this.gmu);
    locala = com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class);
    k.g(locala, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
    ((com.tencent.mm.plugin.messenger.foundation.a.q)locala).getSysCmdMsgExtension().b("LiveMicSucc", (p)this.gmu);
    locala = com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class);
    k.g(locala, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
    ((com.tencent.mm.plugin.messenger.foundation.a.q)locala).getSysCmdMsgExtension().b("OnlineLiveList", (p)this.gmu);
    AppForegroundDelegate.cHM.b((com.tencent.mm.app.n)this.gmx);
    this.foi.dead();
    AppMethodBeat.o(189710);
  }
  
  public final void refreshLiveStatus(final long paramLong, String paramString, a.a parama)
  {
    AppMethodBeat.i(189718);
    k.h(paramString, "roomId");
    Object localObject = (Integer)this.gmv.get(Long.valueOf(paramLong));
    if ((localObject != null) && (((Integer)localObject).intValue() == 1))
    {
      if (parama != null)
      {
        parama.c(paramLong, ((Integer)localObject).intValue());
        AppMethodBeat.o(189718);
        return;
      }
      AppMethodBeat.o(189718);
      return;
    }
    localObject = com.tencent.mm.kernel.g.agi();
    k.g(localObject, "MMKernel.getNetSceneQueue()");
    if (((com.tencent.mm.ak.q)localObject).agm() != null)
    {
      paramString = new com.tencent.mm.live.b.a.b(paramLong, paramString, true);
      localObject = com.tencent.mm.kernel.g.agi();
      k.g(localObject, "MMKernel.getNetSceneQueue()");
      paramString.doScene(((com.tencent.mm.ak.q)localObject).agm(), (com.tencent.mm.ak.g)new e(this, paramLong, parama));
      AppMethodBeat.o(189718);
      return;
    }
    if (parama != null)
    {
      parama.c(paramLong, 0);
      AppMethodBeat.o(189718);
      return;
    }
    AppMethodBeat.o(189718);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/live/PluginLive$appForegroundListener$1", "Lcom/tencent/mm/app/IAppForegroundListener;", "onAppBackground", "", "activity", "", "onAppForeground", "plugin-logic_release"})
  public static final class b
    implements com.tencent.mm.app.n
  {
    public final void onAppBackground(String paramString)
    {
      AppMethodBeat.i(189701);
      paramString = new StringBuilder("onAppBackground liveId:");
      com.tencent.mm.live.b.g localg = com.tencent.mm.live.b.g.guG;
      paramString = paramString.append(com.tencent.mm.live.b.g.akF().DMV).append(" liveName:");
      localg = com.tencent.mm.live.b.g.guG;
      ac.i("MicroMsg.PluginLive", com.tencent.mm.live.b.g.akF().Eud);
      AppMethodBeat.o(189701);
    }
    
    public final void onAppForeground(String paramString)
    {
      AppMethodBeat.i(189702);
      paramString = new StringBuilder("onAppForeground liveId:");
      Object localObject = com.tencent.mm.live.b.g.guG;
      paramString = paramString.append(com.tencent.mm.live.b.g.akF().DMV).append(" liveName:");
      localObject = com.tencent.mm.live.b.g.guG;
      localObject = paramString.append(com.tencent.mm.live.b.g.akF().Eud).append(" jumpName:");
      paramString = com.tencent.mm.live.b.g.guG;
      paramString = com.tencent.mm.live.b.g.akJ();
      if (paramString != null)
      {
        paramString = paramString.gnV;
        if (paramString == null) {}
      }
      for (paramString = paramString.name;; paramString = null)
      {
        ac.i("MicroMsg.PluginLive", paramString);
        AppMethodBeat.o(189702);
        return;
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "", "kotlin.jvm.PlatformType", "getSQLs", "()[Ljava/lang/String;"})
  static final class c
    implements h.b
  {
    public static final c gmz;
    
    static
    {
      AppMethodBeat.i(189703);
      gmz = new c();
      AppMethodBeat.o(189703);
    }
    
    public final String[] getSQLs()
    {
      return com.tencent.mm.live.b.c.c.SQL_CREATE;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/live/PluginLive$logoutEvent$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/LogoutEvent;", "callback", "", "event", "plugin-logic_release"})
  public static final class d
    extends com.tencent.mm.sdk.b.c<la>
  {}
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "kotlin.jvm.PlatformType", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onSceneEnd"})
  static final class e
    implements com.tencent.mm.ak.g
  {
    e(PluginLive paramPluginLive, long paramLong, a.a parama) {}
    
    public final void onSceneEnd(int paramInt1, int paramInt2, final String paramString, com.tencent.mm.ak.n paramn)
    {
      AppMethodBeat.i(189706);
      paramn.setHasCallbackToQueue(true);
      paramString = new v.d();
      paramString.KUO = 0;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (paramn == null)
        {
          paramString = new v("null cannot be cast to non-null type com.tencent.mm.live.model.cgi.NetSceneGetLiveInfo");
          AppMethodBeat.o(189706);
          throw paramString;
        }
        paramn = ((com.tencent.mm.live.b.a.b)paramn).akF();
        if ((paramn == null) || (paramn.nUv != 0)) {
          paramString.KUO = 1;
        }
        ((Map)PluginLive.access$getLiveStatusMap$p(this.gmA)).put(Long.valueOf(paramLong), Integer.valueOf(paramString.KUO));
      }
      com.tencent.mm.ac.c.g((d.g.a.a)new d.g.b.l(paramString) {});
      AppMethodBeat.o(189706);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/live/PluginLive$revokeMsgListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/RevokeMsgEvent;", "callback", "", "event", "plugin-logic_release"})
  public static final class f
    extends com.tencent.mm.sdk.b.c<rn>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.PluginLive
 * JD-Core Version:    0.7.0.1
 */