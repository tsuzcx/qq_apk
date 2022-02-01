package com.tencent.mm.live;

import android.content.Context;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.app.AppForegroundDelegate;
import com.tencent.mm.app.o;
import com.tencent.mm.g.a.ma;
import com.tencent.mm.g.a.sw;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.live.b.r;
import com.tencent.mm.live.b.x.d;
import com.tencent.mm.model.cj;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.protocal.protobuf.civ;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.z.d;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/PluginLive;", "Lcom/tencent/mm/kernel/plugin/Plugin;", "Lcom/tencent/mm/live/IPluginLive;", "Lcom/tencent/mm/kernel/api/ICoreAccountCallback;", "Lcom/tencent/mm/kernel/api/bucket/ICollectDBFactoryBucket;", "()V", "appForegroundListener", "com/tencent/mm/live/PluginLive$appForegroundListener$1", "Lcom/tencent/mm/live/PluginLive$appForegroundListener$1;", "liveStatusMap", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "liveSysMsgReceiver", "Lcom/tencent/mm/live/model/LiveSysMsgReceiver;", "logoutEvent", "Lcom/tencent/mm/sdk/event/IListener;", "revokeMsgListener", "collectDatabaseFactory", "Lcom/tencent/mm/storagebase/SqliteDB$IFactory;", "curLiveId", "execute", "", "profile", "Lcom/tencent/mm/kernel/plugin/ProcessProfile;", "forceStopCurLive", "context", "Landroid/content/Context;", "getLiveTipsBarStorage", "Lcom/tencent/mm/live/model/storage/LiveTipsBarStorage;", "getLivingRoomId", "", "isAnchorLiving", "", "isFloatMode", "isVisitorLiving", "isVisitorMicing", "liveEntranceJumper", "Lcom/tencent/mm/live/api/ILiveEntranceJumper;", "onAccountInitialized", "upgrade", "Lcom/tencent/mm/kernel/CoreStorage$UpgradeInfo;", "onAccountRelease", "refreshLiveStatus", "liveId", "roomId", "callback", "Lcom/tencent/mm/live/IPluginLive$LiveStatusCallback;", "Companion", "plugin-logic_release"})
public final class PluginLive
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.kernel.api.bucket.a, com.tencent.mm.kernel.api.c, a
{
  public static final a hvH;
  private final IListener<?> gnH;
  private final com.tencent.mm.live.b.t hvD;
  private final HashMap<Long, Integer> hvE;
  private final IListener<?> hvF;
  private final b hvG;
  
  static
  {
    AppMethodBeat.i(207539);
    hvH = new a((byte)0);
    AppMethodBeat.o(207539);
  }
  
  public PluginLive()
  {
    AppMethodBeat.i(207538);
    this.hvD = new com.tencent.mm.live.b.t();
    this.hvE = new HashMap();
    this.hvF = ((IListener)new d(this));
    this.hvG = new b();
    this.gnH = ((IListener)new f());
    AppMethodBeat.o(207538);
  }
  
  public final HashMap<Integer, h.b> collectDatabaseFactory()
  {
    AppMethodBeat.i(207530);
    HashMap localHashMap = new HashMap();
    localHashMap.put(Integer.valueOf("LiveTipsBar".hashCode()), c.hvI);
    AppMethodBeat.o(207530);
    return localHashMap;
  }
  
  public final long curLiveId()
  {
    AppMethodBeat.i(207533);
    com.tencent.mm.live.b.x localx = com.tencent.mm.live.b.x.hJf;
    long l = com.tencent.mm.live.b.x.aGr().hyH;
    AppMethodBeat.o(207533);
    return l;
  }
  
  public final void execute(com.tencent.mm.kernel.b.g paramg) {}
  
  public final void forceStopCurLive(Context paramContext)
  {
    AppMethodBeat.i(207537);
    kotlin.g.b.p.h(paramContext, "context");
    Log.printInfoStack("MicroMsg.PluginLive", "forceStopCurLive", new Object[0]);
    paramContext = com.tencent.mm.live.core.core.a.b.hyv;
    if (com.tencent.mm.live.core.core.a.b.a.aDp())
    {
      paramContext = r.hIg;
      r.aGa();
      paramContext = com.tencent.mm.live.b.c.a.hLc;
      com.tencent.mm.live.b.c.a.aHn();
      paramContext = com.tencent.mm.live.core.core.a.b.hyv;
      com.tencent.mm.live.core.core.a.b.a.aDo();
    }
    for (;;)
    {
      paramContext = com.tencent.mm.live.b.x.hJf;
      com.tencent.mm.live.b.x.aHi();
      AppMethodBeat.o(207537);
      return;
      paramContext = com.tencent.mm.live.core.core.d.b.hCo;
      if (com.tencent.mm.live.core.core.d.b.a.aDp())
      {
        paramContext = com.tencent.mm.live.core.core.d.b.hCo;
        com.tencent.mm.live.core.core.d.b.a.aEf();
      }
    }
  }
  
  public final com.tencent.mm.live.b.c.c getLiveTipsBarStorage()
  {
    AppMethodBeat.i(207526);
    com.tencent.mm.live.b.c.c localc = com.tencent.mm.live.b.c.c.getLiveTipsBarStorage();
    AppMethodBeat.o(207526);
    return localc;
  }
  
  public final String getLivingRoomId()
  {
    AppMethodBeat.i(207529);
    Object localObject = com.tencent.mm.live.b.x.hJf;
    localObject = com.tencent.mm.live.b.x.aGm();
    AppMethodBeat.o(207529);
    return localObject;
  }
  
  public final boolean isAnchorLiving()
  {
    AppMethodBeat.i(207531);
    Object localObject = com.tencent.mm.live.b.x.hJf;
    if (com.tencent.mm.live.b.x.aGr().hyH != 0L)
    {
      localObject = com.tencent.mm.live.b.x.hJf;
      if (!com.tencent.mm.live.b.x.aGD().hJn)
      {
        localObject = com.tencent.mm.live.b.x.hJf;
        if (!com.tencent.mm.live.b.x.aGD().hJp)
        {
          localObject = com.tencent.mm.live.core.core.a.b.hyv;
          if (com.tencent.mm.live.core.core.a.b.a.aDp())
          {
            AppMethodBeat.o(207531);
            return true;
          }
        }
      }
    }
    AppMethodBeat.o(207531);
    return false;
  }
  
  public final boolean isFloatMode()
  {
    AppMethodBeat.i(207535);
    Object localObject = com.tencent.mm.live.core.core.d.b.hCo;
    boolean bool;
    if (com.tencent.mm.live.core.core.d.b.a.aDp())
    {
      localObject = com.tencent.mm.live.core.core.d.b.hCo;
      MMApplicationContext.getContext();
      bool = com.tencent.mm.live.core.core.d.b.a.aEf().hAz.isFloatMode();
      AppMethodBeat.o(207535);
      return bool;
    }
    localObject = com.tencent.mm.live.core.core.a.b.hyv;
    if (com.tencent.mm.live.core.core.a.b.a.aDp())
    {
      localObject = com.tencent.mm.live.core.core.a.b.hyv;
      MMApplicationContext.getContext();
      bool = com.tencent.mm.live.core.core.a.b.a.aDo().hAz.isFloatMode();
      AppMethodBeat.o(207535);
      return bool;
    }
    AppMethodBeat.o(207535);
    return false;
  }
  
  public final boolean isVisitorLiving()
  {
    AppMethodBeat.i(207532);
    Object localObject = com.tencent.mm.live.b.x.hJf;
    if (com.tencent.mm.live.b.x.aGr().hyH != 0L)
    {
      localObject = com.tencent.mm.live.b.x.hJf;
      if (!com.tencent.mm.live.b.x.aGD().hJn)
      {
        localObject = com.tencent.mm.live.b.x.hJf;
        if (!com.tencent.mm.live.b.x.aGD().hJp)
        {
          localObject = com.tencent.mm.live.core.core.d.b.hCo;
          if (com.tencent.mm.live.core.core.d.b.a.aDp())
          {
            AppMethodBeat.o(207532);
            return true;
          }
        }
      }
    }
    AppMethodBeat.o(207532);
    return false;
  }
  
  public final boolean isVisitorMicing()
  {
    AppMethodBeat.i(207534);
    Object localObject = com.tencent.mm.live.b.x.hJf;
    if (com.tencent.mm.live.b.x.aGr().hyH != 0L)
    {
      localObject = com.tencent.mm.live.core.core.d.b.hCo;
      if (com.tencent.mm.live.core.core.d.b.a.aDp())
      {
        localObject = com.tencent.mm.live.core.core.d.b.hCo;
        MMApplicationContext.getContext();
        if (com.tencent.mm.live.core.core.d.b.a.aEf().aDx())
        {
          AppMethodBeat.o(207534);
          return true;
        }
      }
    }
    AppMethodBeat.o(207534);
    return false;
  }
  
  public final com.tencent.mm.live.api.a liveEntranceJumper()
  {
    return (com.tencent.mm.live.api.a)com.tencent.mm.live.b.p.hHC;
  }
  
  public final void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(207527);
    Log.i("MicroMsg.PluginLive", "onAccountInitialized");
    EventCenter.instance.addListener(this.hvF);
    paramc = com.tencent.mm.kernel.g.ah(s.class);
    kotlin.g.b.p.g(paramc, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
    ((s)paramc).getSysCmdMsgExtension().a("ApplyLiveMic", (com.tencent.mm.plugin.messenger.foundation.a.q)this.hvD);
    paramc = com.tencent.mm.kernel.g.ah(s.class);
    kotlin.g.b.p.g(paramc, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
    ((s)paramc).getSysCmdMsgExtension().a("AcceptLiveMic", (com.tencent.mm.plugin.messenger.foundation.a.q)this.hvD);
    paramc = com.tencent.mm.kernel.g.ah(s.class);
    kotlin.g.b.p.g(paramc, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
    ((s)paramc).getSysCmdMsgExtension().a("CloseLive", (com.tencent.mm.plugin.messenger.foundation.a.q)this.hvD);
    paramc = com.tencent.mm.kernel.g.ah(s.class);
    kotlin.g.b.p.g(paramc, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
    ((s)paramc).getSysCmdMsgExtension().a("CloseLiveMic", (com.tencent.mm.plugin.messenger.foundation.a.q)this.hvD);
    paramc = com.tencent.mm.kernel.g.ah(s.class);
    kotlin.g.b.p.g(paramc, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
    ((s)paramc).getSysCmdMsgExtension().a("CloseApplyLiveMic", (com.tencent.mm.plugin.messenger.foundation.a.q)this.hvD);
    paramc = com.tencent.mm.kernel.g.ah(s.class);
    kotlin.g.b.p.g(paramc, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
    ((s)paramc).getSysCmdMsgExtension().a("BanLiveComment", (com.tencent.mm.plugin.messenger.foundation.a.q)this.hvD);
    paramc = com.tencent.mm.kernel.g.ah(s.class);
    kotlin.g.b.p.g(paramc, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
    ((s)paramc).getSysCmdMsgExtension().a("LiveMicSucc", (com.tencent.mm.plugin.messenger.foundation.a.q)this.hvD);
    paramc = com.tencent.mm.kernel.g.ah(s.class);
    kotlin.g.b.p.g(paramc, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
    ((s)paramc).getSysCmdMsgExtension().a("OnlineLiveList", (com.tencent.mm.plugin.messenger.foundation.a.q)this.hvD);
    paramc = com.tencent.mm.kernel.g.ah(s.class);
    kotlin.g.b.p.g(paramc, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
    ((s)paramc).getSysCmdMsgExtension().a("mmfinderlive_apply_live_mic_sys_msg", (com.tencent.mm.plugin.messenger.foundation.a.q)this.hvD);
    paramc = com.tencent.mm.kernel.g.ah(s.class);
    kotlin.g.b.p.g(paramc, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
    ((s)paramc).getSysCmdMsgExtension().a("mmfinderlive_accept_live_mic_sys_msg", (com.tencent.mm.plugin.messenger.foundation.a.q)this.hvD);
    paramc = com.tencent.mm.kernel.g.ah(s.class);
    kotlin.g.b.p.g(paramc, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
    ((s)paramc).getSysCmdMsgExtension().a("mmfinderlive_close_live_mic_sys_msg", (com.tencent.mm.plugin.messenger.foundation.a.q)this.hvD);
    AppForegroundDelegate.djR.a((o)this.hvG);
    paramc = com.tencent.mm.live.core.d.a.hEN;
    com.tencent.mm.live.core.d.a.aEV();
    this.gnH.alive();
    AppMethodBeat.o(207527);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(207528);
    Log.i("MicroMsg.PluginLive", "onAccountRelease");
    EventCenter.instance.removeListener(this.hvF);
    com.tencent.mm.kernel.b.a locala = com.tencent.mm.kernel.g.ah(s.class);
    kotlin.g.b.p.g(locala, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
    ((s)locala).getSysCmdMsgExtension().b("ApplyLiveMic", (com.tencent.mm.plugin.messenger.foundation.a.q)this.hvD);
    locala = com.tencent.mm.kernel.g.ah(s.class);
    kotlin.g.b.p.g(locala, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
    ((s)locala).getSysCmdMsgExtension().b("AcceptLiveMic", (com.tencent.mm.plugin.messenger.foundation.a.q)this.hvD);
    locala = com.tencent.mm.kernel.g.ah(s.class);
    kotlin.g.b.p.g(locala, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
    ((s)locala).getSysCmdMsgExtension().b("CloseLive", (com.tencent.mm.plugin.messenger.foundation.a.q)this.hvD);
    locala = com.tencent.mm.kernel.g.ah(s.class);
    kotlin.g.b.p.g(locala, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
    ((s)locala).getSysCmdMsgExtension().b("CloseLiveMic", (com.tencent.mm.plugin.messenger.foundation.a.q)this.hvD);
    locala = com.tencent.mm.kernel.g.ah(s.class);
    kotlin.g.b.p.g(locala, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
    ((s)locala).getSysCmdMsgExtension().b("CloseApplyLiveMic", (com.tencent.mm.plugin.messenger.foundation.a.q)this.hvD);
    locala = com.tencent.mm.kernel.g.ah(s.class);
    kotlin.g.b.p.g(locala, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
    ((s)locala).getSysCmdMsgExtension().b("BanLiveComment", (com.tencent.mm.plugin.messenger.foundation.a.q)this.hvD);
    locala = com.tencent.mm.kernel.g.ah(s.class);
    kotlin.g.b.p.g(locala, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
    ((s)locala).getSysCmdMsgExtension().b("LiveMicSucc", (com.tencent.mm.plugin.messenger.foundation.a.q)this.hvD);
    locala = com.tencent.mm.kernel.g.ah(s.class);
    kotlin.g.b.p.g(locala, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
    ((s)locala).getSysCmdMsgExtension().b("OnlineLiveList", (com.tencent.mm.plugin.messenger.foundation.a.q)this.hvD);
    locala = com.tencent.mm.kernel.g.ah(s.class);
    kotlin.g.b.p.g(locala, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
    ((s)locala).getSysCmdMsgExtension().b("mmfinderlive_apply_live_mic_sys_msg", (com.tencent.mm.plugin.messenger.foundation.a.q)this.hvD);
    locala = com.tencent.mm.kernel.g.ah(s.class);
    kotlin.g.b.p.g(locala, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
    ((s)locala).getSysCmdMsgExtension().b("mmfinderlive_accept_live_mic_sys_msg", (com.tencent.mm.plugin.messenger.foundation.a.q)this.hvD);
    locala = com.tencent.mm.kernel.g.ah(s.class);
    kotlin.g.b.p.g(locala, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
    ((s)locala).getSysCmdMsgExtension().b("mmfinderlive_close_live_mic_sys_msg", (com.tencent.mm.plugin.messenger.foundation.a.q)this.hvD);
    AppForegroundDelegate.djR.b((o)this.hvG);
    this.gnH.dead();
    AppMethodBeat.o(207528);
  }
  
  public final void refreshLiveStatus(final long paramLong, String paramString, a.a parama)
  {
    AppMethodBeat.i(207536);
    kotlin.g.b.p.h(paramString, "roomId");
    Object localObject = (Integer)this.hvE.get(Long.valueOf(paramLong));
    if ((localObject != null) && (((Integer)localObject).intValue() == 1))
    {
      if (parama != null)
      {
        parama.c(paramLong, ((Integer)localObject).intValue());
        AppMethodBeat.o(207536);
        return;
      }
      AppMethodBeat.o(207536);
      return;
    }
    localObject = com.tencent.mm.kernel.g.azz();
    kotlin.g.b.p.g(localObject, "MMKernel.getNetSceneQueue()");
    if (((com.tencent.mm.ak.t)localObject).azD() != null)
    {
      paramString = new com.tencent.mm.live.b.a.b(paramLong, paramString, true);
      localObject = com.tencent.mm.kernel.g.azz();
      kotlin.g.b.p.g(localObject, "MMKernel.getNetSceneQueue()");
      paramString.doScene(((com.tencent.mm.ak.t)localObject).azD(), (com.tencent.mm.ak.i)new e(this, paramLong, parama));
      AppMethodBeat.o(207536);
      return;
    }
    if (parama != null)
    {
      parama.c(paramLong, 0);
      AppMethodBeat.o(207536);
      return;
    }
    AppMethodBeat.o(207536);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/PluginLive$Companion;", "", "()V", "TAG", "", "plugin-logic_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/live/PluginLive$appForegroundListener$1", "Lcom/tencent/mm/app/IAppForegroundListener;", "onAppBackground", "", "activity", "", "onAppForeground", "plugin-logic_release"})
  public static final class b
    implements o
  {
    public final void onAppBackground(String paramString)
    {
      AppMethodBeat.i(207518);
      paramString = new StringBuilder("onAppBackground liveId:");
      com.tencent.mm.live.b.x localx = com.tencent.mm.live.b.x.hJf;
      paramString = paramString.append(com.tencent.mm.live.b.x.aGr().hyH).append(" liveName:");
      localx = com.tencent.mm.live.b.x.hJf;
      Log.i("MicroMsg.PluginLive", com.tencent.mm.live.b.x.aGr().LpF);
      AppMethodBeat.o(207518);
    }
    
    public final void onAppForeground(String paramString)
    {
      AppMethodBeat.i(207519);
      paramString = new StringBuilder("onAppForeground liveId:");
      Object localObject = com.tencent.mm.live.b.x.hJf;
      paramString = paramString.append(com.tencent.mm.live.b.x.aGr().hyH).append(" liveName:");
      localObject = com.tencent.mm.live.b.x.hJf;
      localObject = paramString.append(com.tencent.mm.live.b.x.aGr().LpF).append(" jumpName:");
      paramString = com.tencent.mm.live.b.x.hJf;
      paramString = com.tencent.mm.live.b.x.aGv();
      if (paramString != null)
      {
        paramString = paramString.hzv;
        if (paramString == null) {}
      }
      for (paramString = paramString.name;; paramString = null)
      {
        Log.i("MicroMsg.PluginLive", paramString);
        AppMethodBeat.o(207519);
        return;
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "", "kotlin.jvm.PlatformType", "getSQLs", "()[Ljava/lang/String;"})
  static final class c
    implements h.b
  {
    public static final c hvI;
    
    static
    {
      AppMethodBeat.i(207520);
      hvI = new c();
      AppMethodBeat.o(207520);
    }
    
    public final String[] getSQLs()
    {
      return com.tencent.mm.live.b.c.c.SQL_CREATE;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/live/PluginLive$logoutEvent$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/LogoutEvent;", "callback", "", "event", "plugin-logic_release"})
  public static final class d
    extends IListener<ma>
  {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "kotlin.jvm.PlatformType", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onSceneEnd"})
  static final class e
    implements com.tencent.mm.ak.i
  {
    e(PluginLive paramPluginLive, long paramLong, a.a parama) {}
    
    public final void onSceneEnd(final int paramInt1, final int paramInt2, String paramString, final com.tencent.mm.ak.q paramq)
    {
      AppMethodBeat.i(207524);
      paramq.setHasCallbackToQueue(true);
      h.RTc.aX((Runnable)new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(207523);
          Object localObject1 = new z.d();
          ((z.d)localObject1).SYE = 0;
          if ((paramInt1 == 0) && (paramInt2 == 0))
          {
            Object localObject2 = paramq;
            if (localObject2 == null)
            {
              localObject1 = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.live.model.cgi.NetSceneGetLiveInfo");
              AppMethodBeat.o(207523);
              throw ((Throwable)localObject1);
            }
            localObject2 = ((com.tencent.mm.live.b.a.b)localObject2).aGr();
            if ((localObject2 == null) || (((civ)localObject2).pSb != 0))
            {
              ((z.d)localObject1).SYE = 1;
              com.tencent.mm.live.b.c.c.getLiveTipsBarStorage().zF(this.hvM.hvK);
            }
            ((Map)PluginLive.access$getLiveStatusMap$p(this.hvM.hvJ)).put(Long.valueOf(this.hvM.hvK), Integer.valueOf(((z.d)localObject1).SYE));
          }
          d.h((kotlin.g.a.a)new kotlin.g.b.q((z.d)localObject1) {});
          AppMethodBeat.o(207523);
        }
      });
      AppMethodBeat.o(207524);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/live/PluginLive$revokeMsgListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/RevokeMsgEvent;", "callback", "", "event", "plugin-logic_release"})
  public static final class f
    extends IListener<sw>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.PluginLive
 * JD-Core Version:    0.7.0.1
 */