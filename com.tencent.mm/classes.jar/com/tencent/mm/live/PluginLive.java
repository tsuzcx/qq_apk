package com.tencent.mm.live;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.AppForegroundDelegate;
import com.tencent.mm.g.a.lj;
import com.tencent.mm.g.a.rz;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.live.b.g.d;
import com.tencent.mm.live.b.j;
import com.tencent.mm.live.core.core.b.d;
import com.tencent.mm.live.core.core.b.e;
import com.tencent.mm.model.cd;
import com.tencent.mm.plugin.messenger.foundation.a.r;
import com.tencent.mm.protocal.protobuf.buq;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.storagebase.h.b;
import d.g.b.p;
import d.g.b.y.d;
import d.l;
import d.v;
import java.util.HashMap;
import java.util.Map;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/live/PluginLive;", "Lcom/tencent/mm/kernel/plugin/Plugin;", "Lcom/tencent/mm/live/IPluginLive;", "Lcom/tencent/mm/kernel/api/ICoreAccountCallback;", "Lcom/tencent/mm/kernel/api/bucket/ICollectDBFactoryBucket;", "()V", "appForegroundListener", "com/tencent/mm/live/PluginLive$appForegroundListener$1", "Lcom/tencent/mm/live/PluginLive$appForegroundListener$1;", "liveStatusMap", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "liveSysMsgReceiver", "Lcom/tencent/mm/live/model/LiveSysMsgReceiver;", "logoutEvent", "Lcom/tencent/mm/sdk/event/IListener;", "revokeMsgListener", "collectDatabaseFactory", "Lcom/tencent/mm/storagebase/SqliteDB$IFactory;", "curLiveId", "execute", "", "profile", "Lcom/tencent/mm/kernel/plugin/ProcessProfile;", "forceStopCurLive", "context", "Landroid/content/Context;", "getLiveTipsBarStorage", "Lcom/tencent/mm/live/model/storage/LiveTipsBarStorage;", "getLivingRoomId", "", "isAnchorLiving", "", "isFloatMode", "isVisitorLiving", "isVisitorMicing", "liveEntranceJumper", "Lcom/tencent/mm/live/api/ILiveEntranceJumper;", "onAccountInitialized", "upgrade", "Lcom/tencent/mm/kernel/CoreStorage$UpgradeInfo;", "onAccountRelease", "refreshLiveStatus", "liveId", "roomId", "callback", "Lcom/tencent/mm/live/IPluginLive$LiveStatusCallback;", "Companion", "plugin-logic_release"})
public final class PluginLive
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.kernel.api.bucket.a, com.tencent.mm.kernel.api.c, a
{
  public static final PluginLive.a gGh;
  private final com.tencent.mm.sdk.b.c<?> fGq;
  private final j gGd;
  private final HashMap<Long, Integer> gGe;
  private final com.tencent.mm.sdk.b.c<?> gGf;
  private final b gGg;
  
  static
  {
    AppMethodBeat.i(212007);
    gGh = new PluginLive.a((byte)0);
    AppMethodBeat.o(212007);
  }
  
  public PluginLive()
  {
    AppMethodBeat.i(212006);
    this.gGd = new j();
    this.gGe = new HashMap();
    this.gGf = ((com.tencent.mm.sdk.b.c)new d(this));
    this.gGg = new b();
    this.fGq = ((com.tencent.mm.sdk.b.c)new f());
    AppMethodBeat.o(212006);
  }
  
  public final HashMap<Integer, h.b> collectDatabaseFactory()
  {
    AppMethodBeat.i(211998);
    HashMap localHashMap = new HashMap();
    localHashMap.put(Integer.valueOf("LiveTipsBar".hashCode()), PluginLive.c.gGi);
    AppMethodBeat.o(211998);
    return localHashMap;
  }
  
  public final long curLiveId()
  {
    AppMethodBeat.i(212001);
    com.tencent.mm.live.b.g localg = com.tencent.mm.live.b.g.gOr;
    long l = com.tencent.mm.live.b.g.ans().Fsa;
    AppMethodBeat.o(212001);
    return l;
  }
  
  public final void execute(com.tencent.mm.kernel.b.g paramg) {}
  
  public final void forceStopCurLive(Context paramContext)
  {
    AppMethodBeat.i(212005);
    p.h(paramContext, "context");
    ad.m("MicroMsg.PluginLive", "forceStopCurLive", new Object[0]);
    Object localObject = com.tencent.mm.live.core.core.a.b.gHl;
    if (com.tencent.mm.live.core.core.a.b.a.alz())
    {
      localObject = com.tencent.mm.live.b.i.gPh;
      com.tencent.mm.live.b.i.aop();
      localObject = com.tencent.mm.live.b.c.a.gRa;
      com.tencent.mm.live.b.c.a.aox();
      localObject = com.tencent.mm.live.core.core.a.b.gHl;
      paramContext = (com.tencent.mm.live.core.core.trtc.a)com.tencent.mm.live.core.core.a.b.a.cq(paramContext);
    }
    while (paramContext != null)
    {
      paramContext.alg();
      AppMethodBeat.o(212005);
      return;
      localObject = com.tencent.mm.live.core.core.c.b.gKd;
      if (com.tencent.mm.live.core.core.c.b.a.alz())
      {
        localObject = com.tencent.mm.live.core.core.c.b.gKd;
        paramContext = (com.tencent.mm.live.core.core.trtc.a)com.tencent.mm.live.core.core.c.b.a.cr(paramContext);
      }
      else
      {
        paramContext = null;
      }
    }
    AppMethodBeat.o(212005);
  }
  
  public final com.tencent.mm.live.b.c.c getLiveTipsBarStorage()
  {
    AppMethodBeat.i(211994);
    com.tencent.mm.live.b.c.c localc = com.tencent.mm.live.b.c.c.getLiveTipsBarStorage();
    AppMethodBeat.o(211994);
    return localc;
  }
  
  public final String getLivingRoomId()
  {
    AppMethodBeat.i(211997);
    Object localObject = com.tencent.mm.live.b.g.gOr;
    localObject = com.tencent.mm.live.b.g.anm();
    AppMethodBeat.o(211997);
    return localObject;
  }
  
  public final boolean isAnchorLiving()
  {
    AppMethodBeat.i(211999);
    Object localObject = com.tencent.mm.live.b.g.gOr;
    if (com.tencent.mm.live.b.g.ans().Fsa != 0L)
    {
      localObject = com.tencent.mm.live.b.g.gOr;
      if (!com.tencent.mm.live.b.g.anG().gOz)
      {
        localObject = com.tencent.mm.live.b.g.gOr;
        if (!com.tencent.mm.live.b.g.anG().gOB)
        {
          localObject = com.tencent.mm.live.core.core.a.b.gHl;
          if (com.tencent.mm.live.core.core.a.b.a.alz())
          {
            AppMethodBeat.o(211999);
            return true;
          }
        }
      }
    }
    AppMethodBeat.o(211999);
    return false;
  }
  
  public final boolean isFloatMode()
  {
    AppMethodBeat.i(212003);
    Object localObject = com.tencent.mm.live.core.core.c.b.gKd;
    boolean bool;
    if (com.tencent.mm.live.core.core.c.b.a.alz())
    {
      localObject = com.tencent.mm.live.core.core.c.b.gKd;
      localObject = aj.getContext();
      p.g(localObject, "MMApplicationContext.getContext()");
      bool = com.tencent.mm.live.core.core.c.b.a.cr((Context)localObject).gIt.isFloatMode();
      AppMethodBeat.o(212003);
      return bool;
    }
    localObject = com.tencent.mm.live.core.core.a.b.gHl;
    if (com.tencent.mm.live.core.core.a.b.a.alz())
    {
      localObject = com.tencent.mm.live.core.core.a.b.gHl;
      localObject = aj.getContext();
      p.g(localObject, "MMApplicationContext.getContext()");
      bool = com.tencent.mm.live.core.core.a.b.a.cq((Context)localObject).gIt.isFloatMode();
      AppMethodBeat.o(212003);
      return bool;
    }
    AppMethodBeat.o(212003);
    return false;
  }
  
  public final boolean isVisitorLiving()
  {
    AppMethodBeat.i(212000);
    Object localObject = com.tencent.mm.live.b.g.gOr;
    if (com.tencent.mm.live.b.g.ans().Fsa != 0L)
    {
      localObject = com.tencent.mm.live.b.g.gOr;
      if (!com.tencent.mm.live.b.g.anG().gOz)
      {
        localObject = com.tencent.mm.live.b.g.gOr;
        if (!com.tencent.mm.live.b.g.anG().gOB)
        {
          localObject = com.tencent.mm.live.core.core.c.b.gKd;
          if (com.tencent.mm.live.core.core.c.b.a.alz())
          {
            AppMethodBeat.o(212000);
            return true;
          }
        }
      }
    }
    AppMethodBeat.o(212000);
    return false;
  }
  
  public final boolean isVisitorMicing()
  {
    AppMethodBeat.i(212002);
    Object localObject = com.tencent.mm.live.b.g.gOr;
    if (com.tencent.mm.live.b.g.ans().Fsa != 0L)
    {
      localObject = com.tencent.mm.live.core.core.c.b.gKd;
      if (com.tencent.mm.live.core.core.c.b.a.alz())
      {
        localObject = com.tencent.mm.live.core.core.c.b.gKd;
        localObject = aj.getContext();
        p.g(localObject, "MMApplicationContext.getContext()");
        if (com.tencent.mm.live.core.core.c.b.a.cr((Context)localObject).alG())
        {
          AppMethodBeat.o(212002);
          return true;
        }
      }
    }
    AppMethodBeat.o(212002);
    return false;
  }
  
  public final com.tencent.mm.live.api.a liveEntranceJumper()
  {
    return (com.tencent.mm.live.api.a)com.tencent.mm.live.b.h.gOD;
  }
  
  public final void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(211995);
    ad.i("MicroMsg.PluginLive", "onAccountInitialized");
    com.tencent.mm.sdk.b.a.IbL.c(this.gGf);
    paramc = com.tencent.mm.kernel.g.ad(r.class);
    p.g(paramc, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
    ((r)paramc).getSysCmdMsgExtension().a("ApplyLiveMic", (com.tencent.mm.plugin.messenger.foundation.a.q)this.gGd);
    paramc = com.tencent.mm.kernel.g.ad(r.class);
    p.g(paramc, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
    ((r)paramc).getSysCmdMsgExtension().a("AcceptLiveMic", (com.tencent.mm.plugin.messenger.foundation.a.q)this.gGd);
    paramc = com.tencent.mm.kernel.g.ad(r.class);
    p.g(paramc, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
    ((r)paramc).getSysCmdMsgExtension().a("CloseLive", (com.tencent.mm.plugin.messenger.foundation.a.q)this.gGd);
    paramc = com.tencent.mm.kernel.g.ad(r.class);
    p.g(paramc, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
    ((r)paramc).getSysCmdMsgExtension().a("CloseLiveMic", (com.tencent.mm.plugin.messenger.foundation.a.q)this.gGd);
    paramc = com.tencent.mm.kernel.g.ad(r.class);
    p.g(paramc, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
    ((r)paramc).getSysCmdMsgExtension().a("CloseApplyLiveMic", (com.tencent.mm.plugin.messenger.foundation.a.q)this.gGd);
    paramc = com.tencent.mm.kernel.g.ad(r.class);
    p.g(paramc, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
    ((r)paramc).getSysCmdMsgExtension().a("BanLiveComment", (com.tencent.mm.plugin.messenger.foundation.a.q)this.gGd);
    paramc = com.tencent.mm.kernel.g.ad(r.class);
    p.g(paramc, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
    ((r)paramc).getSysCmdMsgExtension().a("LiveMicSucc", (com.tencent.mm.plugin.messenger.foundation.a.q)this.gGd);
    paramc = com.tencent.mm.kernel.g.ad(r.class);
    p.g(paramc, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
    ((r)paramc).getSysCmdMsgExtension().a("OnlineLiveList", (com.tencent.mm.plugin.messenger.foundation.a.q)this.gGd);
    AppForegroundDelegate.cSQ.a((com.tencent.mm.app.n)this.gGg);
    this.fGq.alive();
    AppMethodBeat.o(211995);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(211996);
    ad.i("MicroMsg.PluginLive", "onAccountRelease");
    com.tencent.mm.sdk.b.a.IbL.d(this.gGf);
    com.tencent.mm.kernel.b.a locala = com.tencent.mm.kernel.g.ad(r.class);
    p.g(locala, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
    ((r)locala).getSysCmdMsgExtension().b("ApplyLiveMic", (com.tencent.mm.plugin.messenger.foundation.a.q)this.gGd);
    locala = com.tencent.mm.kernel.g.ad(r.class);
    p.g(locala, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
    ((r)locala).getSysCmdMsgExtension().b("AcceptLiveMic", (com.tencent.mm.plugin.messenger.foundation.a.q)this.gGd);
    locala = com.tencent.mm.kernel.g.ad(r.class);
    p.g(locala, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
    ((r)locala).getSysCmdMsgExtension().b("CloseLive", (com.tencent.mm.plugin.messenger.foundation.a.q)this.gGd);
    locala = com.tencent.mm.kernel.g.ad(r.class);
    p.g(locala, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
    ((r)locala).getSysCmdMsgExtension().b("CloseLiveMic", (com.tencent.mm.plugin.messenger.foundation.a.q)this.gGd);
    locala = com.tencent.mm.kernel.g.ad(r.class);
    p.g(locala, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
    ((r)locala).getSysCmdMsgExtension().b("CloseApplyLiveMic", (com.tencent.mm.plugin.messenger.foundation.a.q)this.gGd);
    locala = com.tencent.mm.kernel.g.ad(r.class);
    p.g(locala, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
    ((r)locala).getSysCmdMsgExtension().b("BanLiveComment", (com.tencent.mm.plugin.messenger.foundation.a.q)this.gGd);
    locala = com.tencent.mm.kernel.g.ad(r.class);
    p.g(locala, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
    ((r)locala).getSysCmdMsgExtension().b("LiveMicSucc", (com.tencent.mm.plugin.messenger.foundation.a.q)this.gGd);
    locala = com.tencent.mm.kernel.g.ad(r.class);
    p.g(locala, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
    ((r)locala).getSysCmdMsgExtension().b("OnlineLiveList", (com.tencent.mm.plugin.messenger.foundation.a.q)this.gGd);
    AppForegroundDelegate.cSQ.b((com.tencent.mm.app.n)this.gGg);
    this.fGq.dead();
    AppMethodBeat.o(211996);
  }
  
  public final void refreshLiveStatus(final long paramLong, String paramString, a.a parama)
  {
    AppMethodBeat.i(212004);
    p.h(paramString, "roomId");
    Object localObject = (Integer)this.gGe.get(Long.valueOf(paramLong));
    if ((localObject != null) && (((Integer)localObject).intValue() == 1))
    {
      if (parama != null)
      {
        parama.c(paramLong, ((Integer)localObject).intValue());
        AppMethodBeat.o(212004);
        return;
      }
      AppMethodBeat.o(212004);
      return;
    }
    localObject = com.tencent.mm.kernel.g.aiU();
    p.g(localObject, "MMKernel.getNetSceneQueue()");
    if (((com.tencent.mm.al.q)localObject).aiY() != null)
    {
      paramString = new com.tencent.mm.live.b.a.b(paramLong, paramString, true);
      localObject = com.tencent.mm.kernel.g.aiU();
      p.g(localObject, "MMKernel.getNetSceneQueue()");
      paramString.doScene(((com.tencent.mm.al.q)localObject).aiY(), (com.tencent.mm.al.f)new e(this, paramLong, parama));
      AppMethodBeat.o(212004);
      return;
    }
    if (parama != null)
    {
      parama.c(paramLong, 0);
      AppMethodBeat.o(212004);
      return;
    }
    AppMethodBeat.o(212004);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/live/PluginLive$appForegroundListener$1", "Lcom/tencent/mm/app/IAppForegroundListener;", "onAppBackground", "", "activity", "", "onAppForeground", "plugin-logic_release"})
  public static final class b
    implements com.tencent.mm.app.n
  {
    public final void onAppBackground(String paramString)
    {
      AppMethodBeat.i(211987);
      paramString = new StringBuilder("onAppBackground liveId:");
      com.tencent.mm.live.b.g localg = com.tencent.mm.live.b.g.gOr;
      paramString = paramString.append(com.tencent.mm.live.b.g.ans().Fsa).append(" liveName:");
      localg = com.tencent.mm.live.b.g.gOr;
      ad.i("MicroMsg.PluginLive", com.tencent.mm.live.b.g.ans().Gbw);
      AppMethodBeat.o(211987);
    }
    
    public final void onAppForeground(String paramString)
    {
      AppMethodBeat.i(211988);
      paramString = new StringBuilder("onAppForeground liveId:");
      Object localObject = com.tencent.mm.live.b.g.gOr;
      paramString = paramString.append(com.tencent.mm.live.b.g.ans().Fsa).append(" liveName:");
      localObject = com.tencent.mm.live.b.g.gOr;
      localObject = paramString.append(com.tencent.mm.live.b.g.ans().Gbw).append(" jumpName:");
      paramString = com.tencent.mm.live.b.g.gOr;
      paramString = com.tencent.mm.live.b.g.anw();
      if (paramString != null)
      {
        paramString = paramString.gHE;
        if (paramString == null) {}
      }
      for (paramString = paramString.name;; paramString = null)
      {
        ad.i("MicroMsg.PluginLive", paramString);
        AppMethodBeat.o(211988);
        return;
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/live/PluginLive$logoutEvent$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/LogoutEvent;", "callback", "", "event", "plugin-logic_release"})
  public static final class d
    extends com.tencent.mm.sdk.b.c<lj>
  {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "kotlin.jvm.PlatformType", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onSceneEnd"})
  static final class e
    implements com.tencent.mm.al.f
  {
    e(PluginLive paramPluginLive, long paramLong, a.a parama) {}
    
    public final void onSceneEnd(final int paramInt1, final int paramInt2, String paramString, final com.tencent.mm.al.n paramn)
    {
      AppMethodBeat.i(211992);
      com.tencent.e.h.LTJ.aR((Runnable)new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(221638);
          paramn.setHasCallbackToQueue(true);
          Object localObject1 = new y.d();
          ((y.d)localObject1).MLT = 0;
          if ((paramInt1 == 0) && (paramInt2 == 0))
          {
            Object localObject2 = paramn;
            if (localObject2 == null)
            {
              localObject1 = new v("null cannot be cast to non-null type com.tencent.mm.live.model.cgi.NetSceneGetLiveInfo");
              AppMethodBeat.o(221638);
              throw ((Throwable)localObject1);
            }
            localObject2 = ((com.tencent.mm.live.b.a.b)localObject2).ans();
            if ((localObject2 == null) || (((buq)localObject2).oxQ != 0))
            {
              ((y.d)localObject1).MLT = 1;
              com.tencent.mm.live.b.c.c.getLiveTipsBarStorage().rn(this.gGm.gGk);
            }
            ((Map)PluginLive.access$getLiveStatusMap$p(this.gGm.gGj)).put(Long.valueOf(this.gGm.gGk), Integer.valueOf(((y.d)localObject1).MLT));
          }
          com.tencent.mm.ad.c.g((d.g.a.a)new PluginLive.e.1.1(this, (y.d)localObject1));
          AppMethodBeat.o(221638);
        }
      });
      AppMethodBeat.o(211992);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/live/PluginLive$revokeMsgListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/RevokeMsgEvent;", "callback", "", "event", "plugin-logic_release"})
  public static final class f
    extends com.tencent.mm.sdk.b.c<rz>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.PluginLive
 * JD-Core Version:    0.7.0.1
 */