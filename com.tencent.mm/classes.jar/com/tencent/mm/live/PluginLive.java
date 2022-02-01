package com.tencent.mm.live;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.app.AppForegroundDelegate;
import com.tencent.mm.f.a.mr;
import com.tencent.mm.f.a.tx;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.live.b.m;
import com.tencent.mm.live.b.u;
import com.tencent.mm.live.b.u.d;
import com.tencent.mm.live.core.core.a.b.b;
import com.tencent.mm.live.core.core.c.c.a;
import com.tencent.mm.model.ck;
import com.tencent.mm.plugin.messenger.foundation.a.v;
import com.tencent.mm.protocal.protobuf.crq;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.aa.d;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/PluginLive;", "Lcom/tencent/mm/kernel/plugin/Plugin;", "Lcom/tencent/mm/live/IPluginLive;", "Lcom/tencent/mm/kernel/api/ICoreAccountCallback;", "Lcom/tencent/mm/kernel/api/bucket/ICollectDBFactoryBucket;", "()V", "appForegroundListener", "com/tencent/mm/live/PluginLive$appForegroundListener$1", "Lcom/tencent/mm/live/PluginLive$appForegroundListener$1;", "liveStatusMap", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "liveSysMsgReceiver", "Lcom/tencent/mm/live/model/LiveSysMsgReceiver;", "logoutEvent", "Lcom/tencent/mm/sdk/event/IListener;", "revokeMsgListener", "collectDatabaseFactory", "Lcom/tencent/mm/storagebase/SqliteDB$IFactory;", "curLiveId", "execute", "", "profile", "Lcom/tencent/mm/kernel/plugin/ProcessProfile;", "forceStopCurLive", "context", "Landroid/content/Context;", "getLiveTipsBarStorage", "Lcom/tencent/mm/live/model/storage/LiveTipsBarStorage;", "getLivingRoomId", "", "isAnchorLiving", "", "isFloatMode", "isVisitorLiving", "isVisitorMicing", "liveEntranceJumper", "Lcom/tencent/mm/live/api/ILiveEntranceJumper;", "onAccountInitialized", "upgrade", "Lcom/tencent/mm/kernel/CoreStorage$UpgradeInfo;", "onAccountRelease", "refreshLiveStatus", "liveId", "roomId", "callback", "Lcom/tencent/mm/live/IPluginLive$LiveStatusCallback;", "Companion", "plugin-logic_release"})
public final class PluginLive
  extends f
  implements com.tencent.mm.kernel.api.bucket.a, com.tencent.mm.kernel.api.c, a
{
  public static final a khK;
  private final IListener<?> iRQ;
  private final com.tencent.mm.live.b.q khG;
  private final HashMap<Long, Integer> khH;
  private final IListener<?> khI;
  private final b khJ;
  
  static
  {
    AppMethodBeat.i(188453);
    khK = new a((byte)0);
    AppMethodBeat.o(188453);
  }
  
  public PluginLive()
  {
    AppMethodBeat.i(188452);
    this.khG = new com.tencent.mm.live.b.q();
    this.khH = new HashMap();
    this.khI = ((IListener)new d(this));
    this.khJ = new b();
    this.iRQ = ((IListener)new f());
    AppMethodBeat.o(188452);
  }
  
  public final HashMap<Integer, h.b> collectDatabaseFactory()
  {
    AppMethodBeat.i(188444);
    HashMap localHashMap = new HashMap();
    localHashMap.put(Integer.valueOf("LiveTipsBar".hashCode()), c.khL);
    AppMethodBeat.o(188444);
    return localHashMap;
  }
  
  public final long curLiveId()
  {
    AppMethodBeat.i(188447);
    u localu = u.kwz;
    long l = u.aOr().klE;
    AppMethodBeat.o(188447);
    return l;
  }
  
  public final void execute(com.tencent.mm.kernel.b.g paramg) {}
  
  public final void forceStopCurLive(Context paramContext)
  {
    AppMethodBeat.i(188451);
    p.k(paramContext, "context");
    Log.printInfoStack("MicroMsg.PluginLive", "forceStopCurLive", new Object[0]);
    paramContext = com.tencent.mm.live.core.core.a.b.klq;
    if (b.b.aLi())
    {
      paramContext = com.tencent.mm.live.b.o.kvA;
      com.tencent.mm.live.b.o.aOa();
      paramContext = com.tencent.mm.live.b.c.a.kyw;
      com.tencent.mm.live.b.c.a.aPn();
      paramContext = com.tencent.mm.live.core.core.a.b.klq;
      b.b.aLh();
    }
    for (;;)
    {
      paramContext = u.kwz;
      u.aPi();
      AppMethodBeat.o(188451);
      return;
      paramContext = com.tencent.mm.live.core.core.c.c.kqq;
      if (c.a.aLi())
      {
        paramContext = com.tencent.mm.live.core.core.c.c.kqq;
        c.a.aMm();
      }
    }
  }
  
  public final com.tencent.mm.live.b.c.c getLiveTipsBarStorage()
  {
    AppMethodBeat.i(188429);
    com.tencent.mm.live.b.c.c localc = com.tencent.mm.live.b.c.c.getLiveTipsBarStorage();
    AppMethodBeat.o(188429);
    return localc;
  }
  
  public final String getLivingRoomId()
  {
    AppMethodBeat.i(188441);
    Object localObject = u.kwz;
    localObject = u.aOm();
    AppMethodBeat.o(188441);
    return localObject;
  }
  
  public final boolean isAnchorLiving()
  {
    AppMethodBeat.i(188445);
    Object localObject = u.kwz;
    if (u.aOr().klE != 0L)
    {
      localObject = u.kwz;
      if (!u.aOD().kwH)
      {
        localObject = u.kwz;
        if (!u.aOD().kwJ)
        {
          localObject = com.tencent.mm.live.core.core.a.b.klq;
          if (b.b.aLi())
          {
            AppMethodBeat.o(188445);
            return true;
          }
        }
      }
    }
    AppMethodBeat.o(188445);
    return false;
  }
  
  public final boolean isFloatMode()
  {
    AppMethodBeat.i(188449);
    Object localObject = com.tencent.mm.live.core.core.c.c.kqq;
    boolean bool;
    if (c.a.aLi())
    {
      localObject = com.tencent.mm.live.core.core.c.c.kqq;
      bool = c.a.aMm().knA.isFloatMode();
      AppMethodBeat.o(188449);
      return bool;
    }
    localObject = com.tencent.mm.live.core.core.a.b.klq;
    if (b.b.aLi())
    {
      localObject = com.tencent.mm.live.core.core.a.b.klq;
      bool = b.b.aLh().knA.isFloatMode();
      AppMethodBeat.o(188449);
      return bool;
    }
    AppMethodBeat.o(188449);
    return false;
  }
  
  public final boolean isVisitorLiving()
  {
    AppMethodBeat.i(188446);
    Object localObject = u.kwz;
    if (u.aOr().klE != 0L)
    {
      localObject = u.kwz;
      if (!u.aOD().kwH)
      {
        localObject = u.kwz;
        if (!u.aOD().kwJ)
        {
          localObject = com.tencent.mm.live.core.core.c.c.kqq;
          if (c.a.aLi())
          {
            AppMethodBeat.o(188446);
            return true;
          }
        }
      }
    }
    AppMethodBeat.o(188446);
    return false;
  }
  
  public final boolean isVisitorMicing()
  {
    AppMethodBeat.i(188448);
    Object localObject = u.kwz;
    if (u.aOr().klE != 0L)
    {
      localObject = com.tencent.mm.live.core.core.c.c.kqq;
      if (c.a.aLi())
      {
        localObject = com.tencent.mm.live.core.core.c.c.kqq;
        if (c.a.aMm().aLA())
        {
          AppMethodBeat.o(188448);
          return true;
        }
      }
    }
    AppMethodBeat.o(188448);
    return false;
  }
  
  public final com.tencent.mm.live.api.a liveEntranceJumper()
  {
    return (com.tencent.mm.live.api.a)m.kuW;
  }
  
  public final void onAccountInitialized(f.c paramc)
  {
    AppMethodBeat.i(188434);
    Log.i("MicroMsg.PluginLive", "onAccountInitialized");
    EventCenter.instance.addListener(this.khI);
    paramc = com.tencent.mm.kernel.h.ag(v.class);
    p.j(paramc, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
    ((v)paramc).getSysCmdMsgExtension().a("ApplyLiveMic", (com.tencent.mm.plugin.messenger.foundation.a.t)this.khG);
    paramc = com.tencent.mm.kernel.h.ag(v.class);
    p.j(paramc, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
    ((v)paramc).getSysCmdMsgExtension().a("AcceptLiveMic", (com.tencent.mm.plugin.messenger.foundation.a.t)this.khG);
    paramc = com.tencent.mm.kernel.h.ag(v.class);
    p.j(paramc, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
    ((v)paramc).getSysCmdMsgExtension().a("CloseLive", (com.tencent.mm.plugin.messenger.foundation.a.t)this.khG);
    paramc = com.tencent.mm.kernel.h.ag(v.class);
    p.j(paramc, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
    ((v)paramc).getSysCmdMsgExtension().a("CloseLiveMic", (com.tencent.mm.plugin.messenger.foundation.a.t)this.khG);
    paramc = com.tencent.mm.kernel.h.ag(v.class);
    p.j(paramc, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
    ((v)paramc).getSysCmdMsgExtension().a("CloseApplyLiveMic", (com.tencent.mm.plugin.messenger.foundation.a.t)this.khG);
    paramc = com.tencent.mm.kernel.h.ag(v.class);
    p.j(paramc, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
    ((v)paramc).getSysCmdMsgExtension().a("BanLiveComment", (com.tencent.mm.plugin.messenger.foundation.a.t)this.khG);
    paramc = com.tencent.mm.kernel.h.ag(v.class);
    p.j(paramc, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
    ((v)paramc).getSysCmdMsgExtension().a("LiveMicSucc", (com.tencent.mm.plugin.messenger.foundation.a.t)this.khG);
    paramc = com.tencent.mm.kernel.h.ag(v.class);
    p.j(paramc, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
    ((v)paramc).getSysCmdMsgExtension().a("OnlineLiveList", (com.tencent.mm.plugin.messenger.foundation.a.t)this.khG);
    paramc = com.tencent.mm.kernel.h.ag(v.class);
    p.j(paramc, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
    ((v)paramc).getSysCmdMsgExtension().a("mmfinderlive_apply_live_mic_sys_msg", (com.tencent.mm.plugin.messenger.foundation.a.t)this.khG);
    paramc = com.tencent.mm.kernel.h.ag(v.class);
    p.j(paramc, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
    ((v)paramc).getSysCmdMsgExtension().a("mmfinderlive_accept_live_mic_sys_msg", (com.tencent.mm.plugin.messenger.foundation.a.t)this.khG);
    paramc = com.tencent.mm.kernel.h.ag(v.class);
    p.j(paramc, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
    ((v)paramc).getSysCmdMsgExtension().a("mmfinderlive_close_live_mic_sys_msg", (com.tencent.mm.plugin.messenger.foundation.a.t)this.khG);
    AppForegroundDelegate.fby.a((com.tencent.mm.app.o)this.khJ);
    paramc = com.tencent.mm.live.core.d.a.ksS;
    com.tencent.mm.live.core.d.a.aNm();
    this.iRQ.alive();
    AppMethodBeat.o(188434);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(188437);
    Log.i("MicroMsg.PluginLive", "onAccountRelease");
    EventCenter.instance.removeListener(this.khI);
    com.tencent.mm.kernel.b.a locala = com.tencent.mm.kernel.h.ag(v.class);
    p.j(locala, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
    ((v)locala).getSysCmdMsgExtension().b("ApplyLiveMic", (com.tencent.mm.plugin.messenger.foundation.a.t)this.khG);
    locala = com.tencent.mm.kernel.h.ag(v.class);
    p.j(locala, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
    ((v)locala).getSysCmdMsgExtension().b("AcceptLiveMic", (com.tencent.mm.plugin.messenger.foundation.a.t)this.khG);
    locala = com.tencent.mm.kernel.h.ag(v.class);
    p.j(locala, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
    ((v)locala).getSysCmdMsgExtension().b("CloseLive", (com.tencent.mm.plugin.messenger.foundation.a.t)this.khG);
    locala = com.tencent.mm.kernel.h.ag(v.class);
    p.j(locala, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
    ((v)locala).getSysCmdMsgExtension().b("CloseLiveMic", (com.tencent.mm.plugin.messenger.foundation.a.t)this.khG);
    locala = com.tencent.mm.kernel.h.ag(v.class);
    p.j(locala, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
    ((v)locala).getSysCmdMsgExtension().b("CloseApplyLiveMic", (com.tencent.mm.plugin.messenger.foundation.a.t)this.khG);
    locala = com.tencent.mm.kernel.h.ag(v.class);
    p.j(locala, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
    ((v)locala).getSysCmdMsgExtension().b("BanLiveComment", (com.tencent.mm.plugin.messenger.foundation.a.t)this.khG);
    locala = com.tencent.mm.kernel.h.ag(v.class);
    p.j(locala, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
    ((v)locala).getSysCmdMsgExtension().b("LiveMicSucc", (com.tencent.mm.plugin.messenger.foundation.a.t)this.khG);
    locala = com.tencent.mm.kernel.h.ag(v.class);
    p.j(locala, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
    ((v)locala).getSysCmdMsgExtension().b("OnlineLiveList", (com.tencent.mm.plugin.messenger.foundation.a.t)this.khG);
    locala = com.tencent.mm.kernel.h.ag(v.class);
    p.j(locala, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
    ((v)locala).getSysCmdMsgExtension().b("mmfinderlive_apply_live_mic_sys_msg", (com.tencent.mm.plugin.messenger.foundation.a.t)this.khG);
    locala = com.tencent.mm.kernel.h.ag(v.class);
    p.j(locala, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
    ((v)locala).getSysCmdMsgExtension().b("mmfinderlive_accept_live_mic_sys_msg", (com.tencent.mm.plugin.messenger.foundation.a.t)this.khG);
    locala = com.tencent.mm.kernel.h.ag(v.class);
    p.j(locala, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
    ((v)locala).getSysCmdMsgExtension().b("mmfinderlive_close_live_mic_sys_msg", (com.tencent.mm.plugin.messenger.foundation.a.t)this.khG);
    AppForegroundDelegate.fby.b((com.tencent.mm.app.o)this.khJ);
    this.iRQ.dead();
    AppMethodBeat.o(188437);
  }
  
  public final void refreshLiveStatus(final long paramLong, String paramString, a.a parama)
  {
    AppMethodBeat.i(188450);
    p.k(paramString, "roomId");
    Object localObject = (Integer)this.khH.get(Long.valueOf(paramLong));
    if ((localObject != null) && (((Integer)localObject).intValue() == 1))
    {
      if (parama != null)
      {
        parama.d(paramLong, ((Integer)localObject).intValue());
        AppMethodBeat.o(188450);
        return;
      }
      AppMethodBeat.o(188450);
      return;
    }
    localObject = com.tencent.mm.kernel.h.aGY();
    p.j(localObject, "MMKernel.getNetSceneQueue()");
    if (((com.tencent.mm.an.t)localObject).aHc() != null)
    {
      paramString = new com.tencent.mm.live.b.a.b(paramLong, paramString, true);
      localObject = com.tencent.mm.kernel.h.aGY();
      p.j(localObject, "MMKernel.getNetSceneQueue()");
      paramString.doScene(((com.tencent.mm.an.t)localObject).aHc(), (com.tencent.mm.an.i)new e(this, paramLong, parama));
      AppMethodBeat.o(188450);
      return;
    }
    if (parama != null)
    {
      parama.d(paramLong, 0);
      AppMethodBeat.o(188450);
      return;
    }
    AppMethodBeat.o(188450);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/PluginLive$Companion;", "", "()V", "TAG", "", "plugin-logic_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/live/PluginLive$appForegroundListener$1", "Lcom/tencent/mm/app/IAppForegroundListener;", "onAppBackground", "", "activity", "", "onAppForeground", "plugin-logic_release"})
  public static final class b
    implements com.tencent.mm.app.o
  {
    public final void onAppBackground(String paramString)
    {
      AppMethodBeat.i(192727);
      paramString = new StringBuilder("onAppBackground liveId:");
      u localu = u.kwz;
      paramString = paramString.append(u.aOr().klE).append(" liveName:");
      localu = u.kwz;
      Log.i("MicroMsg.PluginLive", u.aOr().Srb);
      AppMethodBeat.o(192727);
    }
    
    public final void onAppForeground(String paramString)
    {
      AppMethodBeat.i(192734);
      paramString = new StringBuilder("onAppForeground liveId:");
      Object localObject = u.kwz;
      paramString = paramString.append(u.aOr().klE).append(" liveName:");
      localObject = u.kwz;
      localObject = paramString.append(u.aOr().Srb).append(" jumpName:");
      paramString = u.kwz;
      paramString = u.aOv();
      if (paramString != null)
      {
        paramString = paramString.kmr;
        if (paramString == null) {}
      }
      for (paramString = paramString.name;; paramString = null)
      {
        Log.i("MicroMsg.PluginLive", paramString);
        AppMethodBeat.o(192734);
        return;
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "", "kotlin.jvm.PlatformType", "getSQLs", "()[Ljava/lang/String;"})
  static final class c
    implements h.b
  {
    public static final c khL;
    
    static
    {
      AppMethodBeat.i(200991);
      khL = new c();
      AppMethodBeat.o(200991);
    }
    
    public final String[] getSQLs()
    {
      return com.tencent.mm.live.b.c.c.SQL_CREATE;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/live/PluginLive$logoutEvent$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/LogoutEvent;", "callback", "", "event", "plugin-logic_release"})
  public static final class d
    extends IListener<mr>
  {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "kotlin.jvm.PlatformType", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onSceneEnd"})
  static final class e
    implements com.tencent.mm.an.i
  {
    e(PluginLive paramPluginLive, long paramLong, a.a parama) {}
    
    public final void onSceneEnd(final int paramInt1, final int paramInt2, String paramString, final com.tencent.mm.an.q paramq)
    {
      AppMethodBeat.i(188813);
      paramq.setHasCallbackToQueue(true);
      com.tencent.e.h.ZvG.be((Runnable)new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(201457);
          Object localObject1 = new aa.d();
          ((aa.d)localObject1).aaBA = 0;
          if ((paramInt1 == 0) && (paramInt2 == 0))
          {
            Object localObject2 = paramq;
            if (localObject2 == null)
            {
              localObject1 = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.live.model.cgi.NetSceneGetLiveInfo");
              AppMethodBeat.o(201457);
              throw ((Throwable)localObject1);
            }
            localObject2 = ((com.tencent.mm.live.b.a.b)localObject2).aOr();
            if ((localObject2 == null) || (((crq)localObject2).end_time != 0))
            {
              ((aa.d)localObject1).aaBA = 1;
              com.tencent.mm.live.b.c.c.getLiveTipsBarStorage().FM(this.khP.khN);
            }
            ((Map)PluginLive.access$getLiveStatusMap$p(this.khP.khM)).put(Long.valueOf(this.khP.khN), Integer.valueOf(((aa.d)localObject1).aaBA));
          }
          d.uiThread((kotlin.g.a.a)new kotlin.g.b.q((aa.d)localObject1) {});
          AppMethodBeat.o(201457);
        }
      });
      AppMethodBeat.o(188813);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/live/PluginLive$revokeMsgListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/RevokeMsgEvent;", "callback", "", "event", "plugin-logic_release"})
  public static final class f
    extends IListener<tx>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.PluginLive
 * JD-Core Version:    0.7.0.1
 */