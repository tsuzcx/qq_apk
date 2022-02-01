package com.tencent.mm.live;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.app.AppForegroundDelegate;
import com.tencent.mm.autogen.a.ny;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.live.core.core.a.b.a;
import com.tencent.mm.live.core.core.f.d.a;
import com.tencent.mm.live.model.m;
import com.tencent.mm.live.model.o;
import com.tencent.mm.live.model.u.d;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.messenger.foundation.a.t;
import com.tencent.mm.plugin.messenger.foundation.a.v;
import com.tencent.mm.protocal.protobuf.dio;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.ah.d;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/live/PluginLive;", "Lcom/tencent/mm/kernel/plugin/Plugin;", "Lcom/tencent/mm/live/IPluginLive;", "Lcom/tencent/mm/kernel/api/ICoreAccountCallback;", "Lcom/tencent/mm/kernel/api/bucket/ICollectDBFactoryBucket;", "()V", "appForegroundListener", "com/tencent/mm/live/PluginLive$appForegroundListener$1", "Lcom/tencent/mm/live/PluginLive$appForegroundListener$1;", "liveStatusMap", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "liveSysMsgReceiver", "Lcom/tencent/mm/live/model/LiveSysMsgReceiver;", "logoutEvent", "Lcom/tencent/mm/sdk/event/IListener;", "revokeMsgListener", "collectDatabaseFactory", "Lcom/tencent/mm/storagebase/SqliteDB$IFactory;", "curLiveId", "execute", "", "profile", "Lcom/tencent/mm/kernel/plugin/ProcessProfile;", "forceStopCurLive", "context", "Landroid/content/Context;", "getLiveTipsBarStorage", "Lcom/tencent/mm/live/model/storage/LiveTipsBarStorage;", "getLivingRoomId", "", "isAnchorLiving", "", "isFloatMode", "isVisitorLiving", "isVisitorMicing", "liveEntranceJumper", "Lcom/tencent/mm/live/api/ILiveEntranceJumper;", "onAccountInitialized", "upgrade", "Lcom/tencent/mm/kernel/CoreStorage$UpgradeInfo;", "onAccountRelease", "refreshLiveStatus", "liveId", "roomId", "callback", "Lcom/tencent/mm/live/IPluginLive$LiveStatusCallback;", "Companion", "plugin-logic_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class PluginLive
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.kernel.api.bucket.a, com.tencent.mm.kernel.api.c, a
{
  public static final PluginLive.a mIg;
  private final IListener<?> ltN;
  private final com.tencent.mm.live.model.q mIh;
  private final HashMap<Long, Integer> mIi;
  private final IListener<?> mIj;
  private final b mIk;
  
  static
  {
    AppMethodBeat.i(246031);
    mIg = new PluginLive.a((byte)0);
    AppMethodBeat.o(246031);
  }
  
  public PluginLive()
  {
    AppMethodBeat.i(245994);
    this.mIh = new com.tencent.mm.live.model.q();
    this.mIi = new HashMap();
    this.mIj = ((IListener)new IListener(com.tencent.mm.app.f.hfK) {});
    this.mIk = new b();
    this.ltN = ((IListener)new PluginLive.revokeMsgListener.1(com.tencent.mm.app.f.hfK));
    AppMethodBeat.o(245994);
  }
  
  private static final String[] collectDatabaseFactory$lambda-0()
  {
    return com.tencent.mm.live.model.c.c.SQL_CREATE;
  }
  
  private static final void refreshLiveStatus$lambda-2(long paramLong, PluginLive paramPluginLive, a.a parama, int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(246023);
    kotlin.g.b.s.u(paramPluginLive, "this$0");
    paramp.setHasCallbackToQueue(true);
    com.tencent.threadpool.h.ahAA.bm(new PluginLive..ExternalSyntheticLambda2(paramInt1, paramInt2, paramp, paramLong, paramPluginLive, parama));
    AppMethodBeat.o(246023);
  }
  
  private static final void refreshLiveStatus$lambda-2$lambda-1(int paramInt1, int paramInt2, p paramp, final long paramLong, PluginLive paramPluginLive, a.a parama)
  {
    AppMethodBeat.i(246010);
    kotlin.g.b.s.u(paramPluginLive, "this$0");
    ah.d locald = new ah.d();
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (paramp == null)
      {
        paramp = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.live.model.cgi.NetSceneGetLiveInfo");
        AppMethodBeat.o(246010);
        throw paramp;
      }
      paramp = ((com.tencent.mm.live.model.a.b)paramp).bie();
      if ((paramp == null) || (paramp.end_time != 0)) {
        break label138;
      }
    }
    label138:
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      if (paramInt1 == 0)
      {
        locald.aixb = 1;
        com.tencent.mm.live.model.c.c.getLiveTipsBarStorage().hT(paramLong);
      }
      ((Map)paramPluginLive.mIi).put(Long.valueOf(paramLong), Integer.valueOf(locald.aixb));
      com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new c(parama, paramLong, locald));
      AppMethodBeat.o(246010);
      return;
    }
  }
  
  public final HashMap<Integer, h.b> collectDatabaseFactory()
  {
    AppMethodBeat.i(246112);
    HashMap localHashMap = new HashMap();
    localHashMap.put(Integer.valueOf("LiveTipsBar".hashCode()), PluginLive..ExternalSyntheticLambda1.INSTANCE);
    AppMethodBeat.o(246112);
    return localHashMap;
  }
  
  public final long curLiveId()
  {
    AppMethodBeat.i(246128);
    com.tencent.mm.live.model.u localu = com.tencent.mm.live.model.u.mZl;
    long l = com.tencent.mm.live.model.u.bie().mMJ;
    AppMethodBeat.o(246128);
    return l;
  }
  
  public final void execute(g paramg) {}
  
  public final void forceStopCurLive(Context paramContext)
  {
    AppMethodBeat.i(246154);
    kotlin.g.b.s.u(paramContext, "context");
    Log.printInfoStack("MicroMsg.PluginLive", "forceStopCurLive", new Object[0]);
    paramContext = com.tencent.mm.live.core.core.a.b.mMo;
    if (b.a.bek())
    {
      paramContext = o.mZb;
      o.bhL();
      paramContext = com.tencent.mm.live.model.c.a.nbR;
      com.tencent.mm.live.model.c.a.bja();
      paramContext = com.tencent.mm.live.core.core.a.b.mMo;
      b.a.bej();
    }
    for (;;)
    {
      paramContext = com.tencent.mm.live.model.u.mZl;
      com.tencent.mm.live.model.u.biV();
      AppMethodBeat.o(246154);
      return;
      paramContext = com.tencent.mm.live.core.core.f.d.mUj;
      if (d.a.bek())
      {
        paramContext = com.tencent.mm.live.core.core.f.d.mUj;
        d.a.bfM();
      }
    }
  }
  
  public final com.tencent.mm.live.model.c.c getLiveTipsBarStorage()
  {
    AppMethodBeat.i(246069);
    com.tencent.mm.live.model.c.c localc = com.tencent.mm.live.model.c.c.getLiveTipsBarStorage();
    AppMethodBeat.o(246069);
    return localc;
  }
  
  public final String getLivingRoomId()
  {
    AppMethodBeat.i(246105);
    Object localObject = com.tencent.mm.live.model.u.mZl;
    localObject = com.tencent.mm.live.model.u.bhZ();
    AppMethodBeat.o(246105);
    return localObject;
  }
  
  public final boolean isAnchorLiving()
  {
    AppMethodBeat.i(246118);
    Object localObject = com.tencent.mm.live.model.u.mZl;
    if (com.tencent.mm.live.model.u.bie().mMJ != 0L)
    {
      localObject = com.tencent.mm.live.model.u.mZl;
      if (!com.tencent.mm.live.model.u.biq().nai)
      {
        localObject = com.tencent.mm.live.model.u.mZl;
        if (!com.tencent.mm.live.model.u.biq().nak)
        {
          localObject = com.tencent.mm.live.core.core.a.b.mMo;
          if (b.a.bek())
          {
            AppMethodBeat.o(246118);
            return true;
          }
        }
      }
    }
    AppMethodBeat.o(246118);
    return false;
  }
  
  public final boolean isFloatMode()
  {
    AppMethodBeat.i(246142);
    Object localObject = com.tencent.mm.live.core.core.f.d.mUj;
    boolean bool;
    if (d.a.bek())
    {
      localObject = com.tencent.mm.live.core.core.f.d.mUj;
      bool = d.a.bfM().mRB.isFloatMode();
      AppMethodBeat.o(246142);
      return bool;
    }
    localObject = com.tencent.mm.live.core.core.a.b.mMo;
    if (b.a.bek())
    {
      localObject = com.tencent.mm.live.core.core.a.b.mMo;
      bool = b.a.bej().mRB.isFloatMode();
      AppMethodBeat.o(246142);
      return bool;
    }
    AppMethodBeat.o(246142);
    return false;
  }
  
  public final boolean isVisitorLiving()
  {
    AppMethodBeat.i(246124);
    Object localObject = com.tencent.mm.live.model.u.mZl;
    if (com.tencent.mm.live.model.u.bie().mMJ != 0L)
    {
      localObject = com.tencent.mm.live.model.u.mZl;
      if (!com.tencent.mm.live.model.u.biq().nai)
      {
        localObject = com.tencent.mm.live.model.u.mZl;
        if (!com.tencent.mm.live.model.u.biq().nak)
        {
          localObject = com.tencent.mm.live.core.core.f.d.mUj;
          if (d.a.bek())
          {
            AppMethodBeat.o(246124);
            return true;
          }
        }
      }
    }
    AppMethodBeat.o(246124);
    return false;
  }
  
  public final boolean isVisitorMicing()
  {
    AppMethodBeat.i(246133);
    Object localObject = com.tencent.mm.live.model.u.mZl;
    if (com.tencent.mm.live.model.u.bie().mMJ != 0L)
    {
      localObject = com.tencent.mm.live.core.core.f.d.mUj;
      if (d.a.bek())
      {
        localObject = com.tencent.mm.live.core.core.f.d.mUj;
        if (d.a.bfM().beZ())
        {
          AppMethodBeat.o(246133);
          return true;
        }
      }
    }
    AppMethodBeat.o(246133);
    return false;
  }
  
  public final com.tencent.mm.live.api.a liveEntranceJumper()
  {
    return (com.tencent.mm.live.api.a)m.mYT;
  }
  
  public final void onAccountInitialized(f.c paramc)
  {
    AppMethodBeat.i(246086);
    Log.i("MicroMsg.PluginLive", "onAccountInitialized");
    this.mIj.alive();
    ((v)com.tencent.mm.kernel.h.az(v.class)).getSysCmdMsgExtension().a("ApplyLiveMic", (t)this.mIh);
    ((v)com.tencent.mm.kernel.h.az(v.class)).getSysCmdMsgExtension().a("AcceptLiveMic", (t)this.mIh);
    ((v)com.tencent.mm.kernel.h.az(v.class)).getSysCmdMsgExtension().a("CloseLive", (t)this.mIh);
    ((v)com.tencent.mm.kernel.h.az(v.class)).getSysCmdMsgExtension().a("CloseLiveMic", (t)this.mIh);
    ((v)com.tencent.mm.kernel.h.az(v.class)).getSysCmdMsgExtension().a("CloseApplyLiveMic", (t)this.mIh);
    ((v)com.tencent.mm.kernel.h.az(v.class)).getSysCmdMsgExtension().a("BanLiveComment", (t)this.mIh);
    ((v)com.tencent.mm.kernel.h.az(v.class)).getSysCmdMsgExtension().a("LiveMicSucc", (t)this.mIh);
    ((v)com.tencent.mm.kernel.h.az(v.class)).getSysCmdMsgExtension().a("OnlineLiveList", (t)this.mIh);
    ((v)com.tencent.mm.kernel.h.az(v.class)).getSysCmdMsgExtension().a("mmfinderlive_apply_live_mic_sys_msg", (t)this.mIh);
    ((v)com.tencent.mm.kernel.h.az(v.class)).getSysCmdMsgExtension().a("mmfinderlive_accept_live_mic_sys_msg", (t)this.mIh);
    ((v)com.tencent.mm.kernel.h.az(v.class)).getSysCmdMsgExtension().a("mmfinderlive_close_live_mic_sys_msg", (t)this.mIh);
    AppForegroundDelegate.heY.a((com.tencent.mm.app.q)this.mIk);
    paramc = com.tencent.mm.live.core.d.b.mWI;
    com.tencent.mm.live.core.d.b.bgX();
    this.ltN.alive();
    AppMethodBeat.o(246086);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(246093);
    Log.i("MicroMsg.PluginLive", "onAccountRelease");
    this.mIj.dead();
    ((v)com.tencent.mm.kernel.h.az(v.class)).getSysCmdMsgExtension().b("ApplyLiveMic", (t)this.mIh);
    ((v)com.tencent.mm.kernel.h.az(v.class)).getSysCmdMsgExtension().b("AcceptLiveMic", (t)this.mIh);
    ((v)com.tencent.mm.kernel.h.az(v.class)).getSysCmdMsgExtension().b("CloseLive", (t)this.mIh);
    ((v)com.tencent.mm.kernel.h.az(v.class)).getSysCmdMsgExtension().b("CloseLiveMic", (t)this.mIh);
    ((v)com.tencent.mm.kernel.h.az(v.class)).getSysCmdMsgExtension().b("CloseApplyLiveMic", (t)this.mIh);
    ((v)com.tencent.mm.kernel.h.az(v.class)).getSysCmdMsgExtension().b("BanLiveComment", (t)this.mIh);
    ((v)com.tencent.mm.kernel.h.az(v.class)).getSysCmdMsgExtension().b("LiveMicSucc", (t)this.mIh);
    ((v)com.tencent.mm.kernel.h.az(v.class)).getSysCmdMsgExtension().b("OnlineLiveList", (t)this.mIh);
    ((v)com.tencent.mm.kernel.h.az(v.class)).getSysCmdMsgExtension().b("mmfinderlive_apply_live_mic_sys_msg", (t)this.mIh);
    ((v)com.tencent.mm.kernel.h.az(v.class)).getSysCmdMsgExtension().b("mmfinderlive_accept_live_mic_sys_msg", (t)this.mIh);
    ((v)com.tencent.mm.kernel.h.az(v.class)).getSysCmdMsgExtension().b("mmfinderlive_close_live_mic_sys_msg", (t)this.mIh);
    AppForegroundDelegate.heY.b((com.tencent.mm.app.q)this.mIk);
    this.ltN.dead();
    AppMethodBeat.o(246093);
  }
  
  public final void refreshLiveStatus(long paramLong, String paramString, a.a parama)
  {
    AppMethodBeat.i(246151);
    kotlin.g.b.s.u(paramString, "roomId");
    Integer localInteger = (Integer)this.mIi.get(Long.valueOf(paramLong));
    if ((localInteger != null) && (localInteger.intValue() == 1))
    {
      if (parama != null)
      {
        parama.l(paramLong, localInteger.intValue());
        AppMethodBeat.o(246151);
      }
    }
    else
    {
      if (com.tencent.mm.kernel.h.aZW().oun != null)
      {
        new com.tencent.mm.live.model.a.b(paramLong, paramString, true).doScene(com.tencent.mm.kernel.h.aZW().oun, new PluginLive..ExternalSyntheticLambda0(paramLong, this, parama));
        AppMethodBeat.o(246151);
        return;
      }
      if (parama != null) {
        parama.l(paramLong, 0);
      }
    }
    AppMethodBeat.o(246151);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/live/PluginLive$appForegroundListener$1", "Lcom/tencent/mm/app/IAppForegroundListener;", "onAppBackground", "", "activity", "", "onAppForeground", "plugin-logic_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements com.tencent.mm.app.q
  {
    public final void onAppBackground(String paramString)
    {
      AppMethodBeat.i(245952);
      paramString = new StringBuilder("onAppBackground liveId:");
      com.tencent.mm.live.model.u localu = com.tencent.mm.live.model.u.mZl;
      paramString = paramString.append(com.tencent.mm.live.model.u.bie().mMJ).append(" liveName:");
      localu = com.tencent.mm.live.model.u.mZl;
      Log.i("MicroMsg.PluginLive", com.tencent.mm.live.model.u.bie().Zqd);
      AppMethodBeat.o(245952);
    }
    
    public final void onAppForeground(String paramString)
    {
      paramString = null;
      AppMethodBeat.i(245955);
      StringBuilder localStringBuilder = new StringBuilder("onAppForeground liveId:");
      Object localObject = com.tencent.mm.live.model.u.mZl;
      localStringBuilder = localStringBuilder.append(com.tencent.mm.live.model.u.bie().mMJ).append(" liveName:");
      localObject = com.tencent.mm.live.model.u.mZl;
      localStringBuilder = localStringBuilder.append(com.tencent.mm.live.model.u.bie().Zqd).append(" jumpName:");
      localObject = com.tencent.mm.live.model.u.mZl;
      localObject = com.tencent.mm.live.model.u.bii();
      if (localObject == null) {}
      for (;;)
      {
        Log.i("MicroMsg.PluginLive", paramString);
        AppMethodBeat.o(245955);
        return;
        localObject = ((com.tencent.mm.live.core.core.model.h)localObject).mNA;
        if (localObject != null) {
          paramString = ((com.tencent.mm.live.core.core.model.d)localObject).name;
        }
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ah>
  {
    c(a.a parama, long paramLong, ah.d paramd)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.live.PluginLive
 * JD-Core Version:    0.7.0.1
 */