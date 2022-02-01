package com.tencent.mm.live;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.app.AppForegroundDelegate;
import com.tencent.mm.app.o;
import com.tencent.mm.g.a.lk;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.live.b.g.d;
import com.tencent.mm.live.b.j;
import com.tencent.mm.live.core.core.b.d;
import com.tencent.mm.live.core.core.b.e;
import com.tencent.mm.model.cf;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.protocal.protobuf.bvk;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.storagebase.h.b;
import d.g.b.p;
import d.g.b.y.d;
import d.l;
import d.v;
import d.z;
import java.util.HashMap;
import java.util.Map;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/live/PluginLive;", "Lcom/tencent/mm/kernel/plugin/Plugin;", "Lcom/tencent/mm/live/IPluginLive;", "Lcom/tencent/mm/kernel/api/ICoreAccountCallback;", "Lcom/tencent/mm/kernel/api/bucket/ICollectDBFactoryBucket;", "()V", "appForegroundListener", "com/tencent/mm/live/PluginLive$appForegroundListener$1", "Lcom/tencent/mm/live/PluginLive$appForegroundListener$1;", "liveStatusMap", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "liveSysMsgReceiver", "Lcom/tencent/mm/live/model/LiveSysMsgReceiver;", "logoutEvent", "Lcom/tencent/mm/sdk/event/IListener;", "revokeMsgListener", "collectDatabaseFactory", "Lcom/tencent/mm/storagebase/SqliteDB$IFactory;", "curLiveId", "execute", "", "profile", "Lcom/tencent/mm/kernel/plugin/ProcessProfile;", "forceStopCurLive", "context", "Landroid/content/Context;", "getLiveTipsBarStorage", "Lcom/tencent/mm/live/model/storage/LiveTipsBarStorage;", "getLivingRoomId", "", "isAnchorLiving", "", "isFloatMode", "isVisitorLiving", "isVisitorMicing", "liveEntranceJumper", "Lcom/tencent/mm/live/api/ILiveEntranceJumper;", "onAccountInitialized", "upgrade", "Lcom/tencent/mm/kernel/CoreStorage$UpgradeInfo;", "onAccountRelease", "refreshLiveStatus", "liveId", "roomId", "callback", "Lcom/tencent/mm/live/IPluginLive$LiveStatusCallback;", "Companion", "plugin-logic_release"})
public final class PluginLive
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.kernel.api.bucket.a, com.tencent.mm.kernel.api.c, a
{
  public static final PluginLive.a gIO;
  private final com.tencent.mm.sdk.b.c<?> fIu;
  private final j gIK;
  private final HashMap<Long, Integer> gIL;
  private final com.tencent.mm.sdk.b.c<?> gIM;
  private final b gIN;
  
  static
  {
    AppMethodBeat.i(215626);
    gIO = new PluginLive.a((byte)0);
    AppMethodBeat.o(215626);
  }
  
  public PluginLive()
  {
    AppMethodBeat.i(215625);
    this.gIK = new j();
    this.gIL = new HashMap();
    this.gIM = ((com.tencent.mm.sdk.b.c)new d(this));
    this.gIN = new b();
    this.fIu = ((com.tencent.mm.sdk.b.c)new PluginLive.f());
    AppMethodBeat.o(215625);
  }
  
  public final HashMap<Integer, h.b> collectDatabaseFactory()
  {
    AppMethodBeat.i(215617);
    HashMap localHashMap = new HashMap();
    localHashMap.put(Integer.valueOf("LiveTipsBar".hashCode()), PluginLive.c.gIP);
    AppMethodBeat.o(215617);
    return localHashMap;
  }
  
  public final long curLiveId()
  {
    AppMethodBeat.i(215620);
    com.tencent.mm.live.b.g localg = com.tencent.mm.live.b.g.gQZ;
    long l = com.tencent.mm.live.b.g.anH().FKy;
    AppMethodBeat.o(215620);
    return l;
  }
  
  public final void execute(com.tencent.mm.kernel.b.g paramg) {}
  
  public final void forceStopCurLive(Context paramContext)
  {
    AppMethodBeat.i(215624);
    p.h(paramContext, "context");
    ae.m("MicroMsg.PluginLive", "forceStopCurLive", new Object[0]);
    Object localObject = com.tencent.mm.live.core.core.a.b.gJU;
    if (com.tencent.mm.live.core.core.a.b.a.alO())
    {
      localObject = com.tencent.mm.live.b.i.gRP;
      com.tencent.mm.live.b.i.aoE();
      localObject = com.tencent.mm.live.b.c.a.gTI;
      com.tencent.mm.live.b.c.a.aoM();
      localObject = com.tencent.mm.live.core.core.a.b.gJU;
      paramContext = (com.tencent.mm.live.core.core.trtc.a)com.tencent.mm.live.core.core.a.b.a.cs(paramContext);
    }
    while (paramContext != null)
    {
      paramContext.alv();
      AppMethodBeat.o(215624);
      return;
      localObject = com.tencent.mm.live.core.core.c.b.gMM;
      if (com.tencent.mm.live.core.core.c.b.a.alO())
      {
        localObject = com.tencent.mm.live.core.core.c.b.gMM;
        paramContext = (com.tencent.mm.live.core.core.trtc.a)com.tencent.mm.live.core.core.c.b.a.ct(paramContext);
      }
      else
      {
        paramContext = null;
      }
    }
    AppMethodBeat.o(215624);
  }
  
  public final com.tencent.mm.live.b.c.c getLiveTipsBarStorage()
  {
    AppMethodBeat.i(215613);
    com.tencent.mm.live.b.c.c localc = com.tencent.mm.live.b.c.c.getLiveTipsBarStorage();
    AppMethodBeat.o(215613);
    return localc;
  }
  
  public final String getLivingRoomId()
  {
    AppMethodBeat.i(215616);
    Object localObject = com.tencent.mm.live.b.g.gQZ;
    localObject = com.tencent.mm.live.b.g.anC();
    AppMethodBeat.o(215616);
    return localObject;
  }
  
  public final boolean isAnchorLiving()
  {
    AppMethodBeat.i(215618);
    Object localObject = com.tencent.mm.live.b.g.gQZ;
    if (com.tencent.mm.live.b.g.anH().FKy != 0L)
    {
      localObject = com.tencent.mm.live.b.g.gQZ;
      if (!com.tencent.mm.live.b.g.anV().gRh)
      {
        localObject = com.tencent.mm.live.b.g.gQZ;
        if (!com.tencent.mm.live.b.g.anV().gRj)
        {
          localObject = com.tencent.mm.live.core.core.a.b.gJU;
          if (com.tencent.mm.live.core.core.a.b.a.alO())
          {
            AppMethodBeat.o(215618);
            return true;
          }
        }
      }
    }
    AppMethodBeat.o(215618);
    return false;
  }
  
  public final boolean isFloatMode()
  {
    AppMethodBeat.i(215622);
    Object localObject = com.tencent.mm.live.core.core.c.b.gMM;
    boolean bool;
    if (com.tencent.mm.live.core.core.c.b.a.alO())
    {
      localObject = com.tencent.mm.live.core.core.c.b.gMM;
      localObject = ak.getContext();
      p.g(localObject, "MMApplicationContext.getContext()");
      bool = com.tencent.mm.live.core.core.c.b.a.ct((Context)localObject).gLc.isFloatMode();
      AppMethodBeat.o(215622);
      return bool;
    }
    localObject = com.tencent.mm.live.core.core.a.b.gJU;
    if (com.tencent.mm.live.core.core.a.b.a.alO())
    {
      localObject = com.tencent.mm.live.core.core.a.b.gJU;
      localObject = ak.getContext();
      p.g(localObject, "MMApplicationContext.getContext()");
      bool = com.tencent.mm.live.core.core.a.b.a.cs((Context)localObject).gLc.isFloatMode();
      AppMethodBeat.o(215622);
      return bool;
    }
    AppMethodBeat.o(215622);
    return false;
  }
  
  public final boolean isVisitorLiving()
  {
    AppMethodBeat.i(215619);
    Object localObject = com.tencent.mm.live.b.g.gQZ;
    if (com.tencent.mm.live.b.g.anH().FKy != 0L)
    {
      localObject = com.tencent.mm.live.b.g.gQZ;
      if (!com.tencent.mm.live.b.g.anV().gRh)
      {
        localObject = com.tencent.mm.live.b.g.gQZ;
        if (!com.tencent.mm.live.b.g.anV().gRj)
        {
          localObject = com.tencent.mm.live.core.core.c.b.gMM;
          if (com.tencent.mm.live.core.core.c.b.a.alO())
          {
            AppMethodBeat.o(215619);
            return true;
          }
        }
      }
    }
    AppMethodBeat.o(215619);
    return false;
  }
  
  public final boolean isVisitorMicing()
  {
    AppMethodBeat.i(215621);
    Object localObject = com.tencent.mm.live.b.g.gQZ;
    if (com.tencent.mm.live.b.g.anH().FKy != 0L)
    {
      localObject = com.tencent.mm.live.core.core.c.b.gMM;
      if (com.tencent.mm.live.core.core.c.b.a.alO())
      {
        localObject = com.tencent.mm.live.core.core.c.b.gMM;
        localObject = ak.getContext();
        p.g(localObject, "MMApplicationContext.getContext()");
        if (com.tencent.mm.live.core.core.c.b.a.ct((Context)localObject).alV())
        {
          AppMethodBeat.o(215621);
          return true;
        }
      }
    }
    AppMethodBeat.o(215621);
    return false;
  }
  
  public final com.tencent.mm.live.api.a liveEntranceJumper()
  {
    return (com.tencent.mm.live.api.a)com.tencent.mm.live.b.h.gRl;
  }
  
  public final void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(215614);
    ae.i("MicroMsg.PluginLive", "onAccountInitialized");
    com.tencent.mm.sdk.b.a.IvT.c(this.gIM);
    paramc = com.tencent.mm.kernel.g.ad(s.class);
    p.g(paramc, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
    ((s)paramc).getSysCmdMsgExtension().a("ApplyLiveMic", (com.tencent.mm.plugin.messenger.foundation.a.q)this.gIK);
    paramc = com.tencent.mm.kernel.g.ad(s.class);
    p.g(paramc, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
    ((s)paramc).getSysCmdMsgExtension().a("AcceptLiveMic", (com.tencent.mm.plugin.messenger.foundation.a.q)this.gIK);
    paramc = com.tencent.mm.kernel.g.ad(s.class);
    p.g(paramc, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
    ((s)paramc).getSysCmdMsgExtension().a("CloseLive", (com.tencent.mm.plugin.messenger.foundation.a.q)this.gIK);
    paramc = com.tencent.mm.kernel.g.ad(s.class);
    p.g(paramc, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
    ((s)paramc).getSysCmdMsgExtension().a("CloseLiveMic", (com.tencent.mm.plugin.messenger.foundation.a.q)this.gIK);
    paramc = com.tencent.mm.kernel.g.ad(s.class);
    p.g(paramc, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
    ((s)paramc).getSysCmdMsgExtension().a("CloseApplyLiveMic", (com.tencent.mm.plugin.messenger.foundation.a.q)this.gIK);
    paramc = com.tencent.mm.kernel.g.ad(s.class);
    p.g(paramc, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
    ((s)paramc).getSysCmdMsgExtension().a("BanLiveComment", (com.tencent.mm.plugin.messenger.foundation.a.q)this.gIK);
    paramc = com.tencent.mm.kernel.g.ad(s.class);
    p.g(paramc, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
    ((s)paramc).getSysCmdMsgExtension().a("LiveMicSucc", (com.tencent.mm.plugin.messenger.foundation.a.q)this.gIK);
    paramc = com.tencent.mm.kernel.g.ad(s.class);
    p.g(paramc, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
    ((s)paramc).getSysCmdMsgExtension().a("OnlineLiveList", (com.tencent.mm.plugin.messenger.foundation.a.q)this.gIK);
    AppForegroundDelegate.cTA.a((o)this.gIN);
    this.fIu.alive();
    AppMethodBeat.o(215614);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(215615);
    ae.i("MicroMsg.PluginLive", "onAccountRelease");
    com.tencent.mm.sdk.b.a.IvT.d(this.gIM);
    com.tencent.mm.kernel.b.a locala = com.tencent.mm.kernel.g.ad(s.class);
    p.g(locala, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
    ((s)locala).getSysCmdMsgExtension().b("ApplyLiveMic", (com.tencent.mm.plugin.messenger.foundation.a.q)this.gIK);
    locala = com.tencent.mm.kernel.g.ad(s.class);
    p.g(locala, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
    ((s)locala).getSysCmdMsgExtension().b("AcceptLiveMic", (com.tencent.mm.plugin.messenger.foundation.a.q)this.gIK);
    locala = com.tencent.mm.kernel.g.ad(s.class);
    p.g(locala, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
    ((s)locala).getSysCmdMsgExtension().b("CloseLive", (com.tencent.mm.plugin.messenger.foundation.a.q)this.gIK);
    locala = com.tencent.mm.kernel.g.ad(s.class);
    p.g(locala, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
    ((s)locala).getSysCmdMsgExtension().b("CloseLiveMic", (com.tencent.mm.plugin.messenger.foundation.a.q)this.gIK);
    locala = com.tencent.mm.kernel.g.ad(s.class);
    p.g(locala, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
    ((s)locala).getSysCmdMsgExtension().b("CloseApplyLiveMic", (com.tencent.mm.plugin.messenger.foundation.a.q)this.gIK);
    locala = com.tencent.mm.kernel.g.ad(s.class);
    p.g(locala, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
    ((s)locala).getSysCmdMsgExtension().b("BanLiveComment", (com.tencent.mm.plugin.messenger.foundation.a.q)this.gIK);
    locala = com.tencent.mm.kernel.g.ad(s.class);
    p.g(locala, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
    ((s)locala).getSysCmdMsgExtension().b("LiveMicSucc", (com.tencent.mm.plugin.messenger.foundation.a.q)this.gIK);
    locala = com.tencent.mm.kernel.g.ad(s.class);
    p.g(locala, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
    ((s)locala).getSysCmdMsgExtension().b("OnlineLiveList", (com.tencent.mm.plugin.messenger.foundation.a.q)this.gIK);
    AppForegroundDelegate.cTA.b((o)this.gIN);
    this.fIu.dead();
    AppMethodBeat.o(215615);
  }
  
  public final void refreshLiveStatus(final long paramLong, String paramString, a.a parama)
  {
    AppMethodBeat.i(215623);
    p.h(paramString, "roomId");
    Object localObject = (Integer)this.gIL.get(Long.valueOf(paramLong));
    if ((localObject != null) && (((Integer)localObject).intValue() == 1))
    {
      if (parama != null)
      {
        parama.c(paramLong, ((Integer)localObject).intValue());
        AppMethodBeat.o(215623);
        return;
      }
      AppMethodBeat.o(215623);
      return;
    }
    localObject = com.tencent.mm.kernel.g.ajj();
    p.g(localObject, "MMKernel.getNetSceneQueue()");
    if (((com.tencent.mm.ak.q)localObject).ajn() != null)
    {
      paramString = new com.tencent.mm.live.b.a.b(paramLong, paramString, true);
      localObject = com.tencent.mm.kernel.g.ajj();
      p.g(localObject, "MMKernel.getNetSceneQueue()");
      paramString.doScene(((com.tencent.mm.ak.q)localObject).ajn(), (com.tencent.mm.ak.f)new e(this, paramLong, parama));
      AppMethodBeat.o(215623);
      return;
    }
    if (parama != null)
    {
      parama.c(paramLong, 0);
      AppMethodBeat.o(215623);
      return;
    }
    AppMethodBeat.o(215623);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/live/PluginLive$appForegroundListener$1", "Lcom/tencent/mm/app/IAppForegroundListener;", "onAppBackground", "", "activity", "", "onAppForeground", "plugin-logic_release"})
  public static final class b
    implements o
  {
    public final void onAppBackground(String paramString)
    {
      AppMethodBeat.i(215605);
      paramString = new StringBuilder("onAppBackground liveId:");
      com.tencent.mm.live.b.g localg = com.tencent.mm.live.b.g.gQZ;
      paramString = paramString.append(com.tencent.mm.live.b.g.anH().FKy).append(" liveName:");
      localg = com.tencent.mm.live.b.g.gQZ;
      ae.i("MicroMsg.PluginLive", com.tencent.mm.live.b.g.anH().Gud);
      AppMethodBeat.o(215605);
    }
    
    public final void onAppForeground(String paramString)
    {
      AppMethodBeat.i(215606);
      paramString = new StringBuilder("onAppForeground liveId:");
      Object localObject = com.tencent.mm.live.b.g.gQZ;
      paramString = paramString.append(com.tencent.mm.live.b.g.anH().FKy).append(" liveName:");
      localObject = com.tencent.mm.live.b.g.gQZ;
      localObject = paramString.append(com.tencent.mm.live.b.g.anH().Gud).append(" jumpName:");
      paramString = com.tencent.mm.live.b.g.gQZ;
      paramString = com.tencent.mm.live.b.g.anL();
      if (paramString != null)
      {
        paramString = paramString.gKn;
        if (paramString == null) {}
      }
      for (paramString = paramString.name;; paramString = null)
      {
        ae.i("MicroMsg.PluginLive", paramString);
        AppMethodBeat.o(215606);
        return;
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/live/PluginLive$logoutEvent$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/LogoutEvent;", "callback", "", "event", "plugin-logic_release"})
  public static final class d
    extends com.tencent.mm.sdk.b.c<lk>
  {}
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "kotlin.jvm.PlatformType", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onSceneEnd"})
  static final class e
    implements com.tencent.mm.ak.f
  {
    e(PluginLive paramPluginLive, long paramLong, a.a parama) {}
    
    public final void onSceneEnd(final int paramInt1, final int paramInt2, String paramString, final n paramn)
    {
      AppMethodBeat.i(215611);
      paramn.setHasCallbackToQueue(true);
      com.tencent.e.h.MqF.aO((Runnable)new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(215610);
          Object localObject1 = new y.d();
          ((y.d)localObject1).NiW = 0;
          if ((paramInt1 == 0) && (paramInt2 == 0))
          {
            Object localObject2 = paramn;
            if (localObject2 == null)
            {
              localObject1 = new v("null cannot be cast to non-null type com.tencent.mm.live.model.cgi.NetSceneGetLiveInfo");
              AppMethodBeat.o(215610);
              throw ((Throwable)localObject1);
            }
            localObject2 = ((com.tencent.mm.live.b.a.b)localObject2).anH();
            if ((localObject2 == null) || (((bvk)localObject2).oEs != 0))
            {
              ((y.d)localObject1).NiW = 1;
              com.tencent.mm.live.b.c.c.getLiveTipsBarStorage().rA(this.gIT.gIR);
            }
            ((Map)PluginLive.access$getLiveStatusMap$p(this.gIT.gIQ)).put(Long.valueOf(this.gIT.gIR), Integer.valueOf(((y.d)localObject1).NiW));
          }
          com.tencent.mm.ac.c.h((d.g.a.a)new d.g.b.q((y.d)localObject1) {});
          AppMethodBeat.o(215610);
        }
      });
      AppMethodBeat.o(215611);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.live.PluginLive
 * JD-Core Version:    0.7.0.1
 */