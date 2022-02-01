package com.tencent.mm.plugin.gamelive;

import android.content.Context;
import android.content.Intent;
import android.view.MenuItem;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.e.i;
import com.tencent.luggage.game.page.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessResult;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.b;
import com.tencent.mm.plugin.appbrand.jsapi.r;
import com.tencent.mm.plugin.appbrand.menu.h.b;
import com.tencent.mm.plugin.appbrand.menu.h.c;
import com.tencent.mm.plugin.appbrand.menu.h.d;
import com.tencent.mm.plugin.appbrand.page.ah;
import com.tencent.mm.plugin.gamelive.event.GameLiveAppbrandEventService;
import com.tencent.mm.plugin.gamelive.event.GameLiveAppbrandEventService.LiveCommentWrapperInfoPayload;
import com.tencent.mm.plugin.gamelive.event.GameLiveAppbrandEventService.LiveSingleCommentPayload;
import com.tencent.mm.plugin.gamelive.event.GameLiveAppbrandEventService.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.widget.a.e.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.a.ae;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.s;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/gamelive/GameLiveAppbrandProcessService;", "Lcom/tencent/mm/plugin/gamelive/IGameLiveAppbrandProcessService;", "()V", "gameLiveEventService", "Lcom/tencent/mm/plugin/gamelive/event/GameLiveAppbrandEventService;", "isFloating", "", "isMicAlive", "isStopLive", "pushActionCallback", "Lcom/tencent/mm/plugin/gamelive/IGameLiveAppbrandProcessService$IPushActionCallback;", "shareToFriendCallback", "Lcom/tencent/mm/plugin/gamelive/IGameLiveAppbrandProcessService$IGameLiveShareCallback;", "doCleaning", "", "enterGameLiveRoom", "appId", "", "versionType", "", "context", "Landroid/content/Context;", "exitGameLive", "endReason", "callback", "Lcom/tencent/mm/plugin/gamelive/IGameLiveAppbrandProcessService$IGameExitLiveCallback;", "getMemberList", "callback1", "Lcom/tencent/mm/plugin/gamelive/IGameLiveAppbrandProcessService$IGameGetMemberListCallback;", "getMicAlive", "getStartTime", "Lcom/tencent/mm/plugin/gamelive/IGameLiveAppbrandProcessService$IGameGetTimeCallback;", "minimizeGameLive", "onAppbrandDestroy", "onAppbrandEnterBackGround", "onAppbrandEnterForeground", "runtime", "", "onAppbrandExit", "closeRunnable", "Ljava/lang/Runnable;", "registerPushActionCallback", "resetMicAliveFromFinder", "sendCommentEventProxy", "liveCommentWrapperInfoPayload", "Lcom/tencent/mm/plugin/gamelive/event/GameLiveAppbrandEventService$LiveCommentWrapperInfoPayload;", "sendCommentEventProxy$plugin_gamelive_release", "sendLiveStateChangeEventProxy", "event", "reason", "payload", "Lcom/tencent/mm/plugin/gamelive/event/GameLiveAppbrandEventService$LiveStartInfoPayload;", "sendLiveStateChangeEventProxy$plugin_gamelive_release", "sendNetWorkEventProxy", "netWork", "threshold", "sendNetWorkEventProxy$plugin_gamelive_release", "sendShareToFriendCallback", "shareUserCount", "shareRoomCount", "sendVolumnEventProxy", "volume", "sendVolumnEventProxy$plugin_gamelive_release", "setMicAlive", "isMicOpen", "setMicInfoEvent", "isMicEventNotify", "duration", "shareToFriend", "shareToSNS", "startGameLive", "startPush", "runtimeWC", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "stopGameLive", "needReopenAppbrand", "stopPush", "syncLiveState", "unregisterPushActionCallback", "Companion", "EnterFinderLiveRequest", "EnterFinderLiveResult", "EnterFinderLiveTask", "FinderLiveControlAction", "plugin-gamelive_release"})
public final class GameLiveAppbrandProcessService
  implements c
{
  public static final GameLiveAppbrandProcessService.a Djs;
  private c.e Djm;
  GameLiveAppbrandEventService Djn;
  private boolean Djo;
  boolean Djp = true;
  private boolean Djq;
  c.d Djr;
  
  static
  {
    AppMethodBeat.i(207952);
    Djs = new GameLiveAppbrandProcessService.a((byte)0);
    AppMethodBeat.o(207952);
  }
  
  private final void eAF()
  {
    AppMethodBeat.i(207920);
    if (!((PluginGameLive)com.tencent.mm.kernel.h.ag(PluginGameLive.class)).isPushing$plugin_gamelive_release())
    {
      Log.i("MicroMsg.GameLiveAppbrandProcessService", "stopPushing: isNotPushing return");
      AppMethodBeat.o(207920);
      return;
    }
    ((PluginGameLive)com.tencent.mm.kernel.h.ag(PluginGameLive.class)).setPushing$plugin_gamelive_release(false);
    c.e locale = this.Djm;
    if (locale != null)
    {
      locale.Z((Runnable)q.DjT);
      AppMethodBeat.o(207920);
      return;
    }
    AppMethodBeat.o(207920);
  }
  
  public final void a(final Context paramContext, final String paramString, int paramInt, final Runnable paramRunnable)
  {
    AppMethodBeat.i(207911);
    p.k(paramContext, "context");
    p.k(paramString, "appId");
    p.k(paramRunnable, "closeRunnable");
    if ((!((PluginGameLive)com.tencent.mm.kernel.h.ag(PluginGameLive.class)).isGameLiving(paramString, paramInt)) || (this.Djo))
    {
      paramRunnable.run();
      AppMethodBeat.o(207911);
      return;
    }
    com.tencent.mm.ui.widget.a.e locale = new com.tencent.mm.ui.widget.a.e(paramContext, 1, true);
    locale.a((q.f)new j(this, paramContext, paramString, paramRunnable));
    locale.a((q.g)new k(this, paramContext, paramString, paramRunnable));
    locale.icz();
    locale.j((CharSequence)com.tencent.mm.ci.a.ba(paramContext, g.c.Dlh), 17, com.tencent.mm.ci.a.fromDPToPix(paramContext, 14));
    locale.eik();
    AppMethodBeat.o(207911);
  }
  
  public final void a(c.b paramb)
  {
    AppMethodBeat.i(207948);
    p.k(paramb, "callback1");
    XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, new PluginGameLive.IPCLiveControlData(PluginGameLive.IPCLiveControlData.b.DkE, null, null, 14), PluginGameLive.c.class, (f)new GameLiveAppbrandProcessService.f(paramb));
    AppMethodBeat.o(207948);
  }
  
  public final void a(c.c paramc)
  {
    AppMethodBeat.i(207949);
    XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, new PluginGameLive.IPCLiveControlData(PluginGameLive.IPCLiveControlData.b.DkF, null, null, 14), PluginGameLive.c.class, (f)new g(paramc));
    AppMethodBeat.o(207949);
  }
  
  public final void a(c.e parame)
  {
    this.Djm = parame;
  }
  
  public final void a(GameLiveAppbrandEventService.LiveCommentWrapperInfoPayload paramLiveCommentWrapperInfoPayload)
  {
    AppMethodBeat.i(207934);
    p.k(paramLiveCommentWrapperInfoPayload, "liveCommentWrapperInfoPayload");
    Object localObject1 = this.Djn;
    if (localObject1 != null)
    {
      p.k(paramLiveCommentWrapperInfoPayload, "liveCommentInfoPayload");
      localObject1 = ((GameLiveAppbrandEventService)localObject1).nAH;
      if (localObject1 != null)
      {
        GameLiveAppbrandEventService.b localb = GameLiveAppbrandEventService.b.Dmc;
        List localList = (List)new ArrayList();
        Object localObject2 = paramLiveCommentWrapperInfoPayload.ziq;
        if ((localObject2 == null) || (((List)localObject2).size() != 0))
        {
          localObject2 = paramLiveCommentWrapperInfoPayload.ziq;
          if (localObject2 == null) {
            p.iCn();
          }
          localObject2 = ((List)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            GameLiveAppbrandEventService.LiveSingleCommentPayload localLiveSingleCommentPayload = (GameLiveAppbrandEventService.LiveSingleCommentPayload)((Iterator)localObject2).next();
            Map localMap = ae.e(new kotlin.o[] { s.M("msgType", localLiveSingleCommentPayload.Dmm), s.M("senderNickName", localLiveSingleCommentPayload.Dmn), s.M("senderHeadImgUrl", localLiveSingleCommentPayload.Dmo), s.M("content", localLiveSingleCommentPayload.content), s.M("msgCreateTime", localLiveSingleCommentPayload.Dmp), s.M("msgSeq", localLiveSingleCommentPayload.Dmq), s.M("comboRewardCount", localLiveSingleCommentPayload.Dmr), s.M("rankingPosition", localLiveSingleCommentPayload.Dms), s.M("rewardProduectId", localLiveSingleCommentPayload.Dmt), s.M("rewardThumbUrl", localLiveSingleCommentPayload.Dmu), s.M("rewardName", localLiveSingleCommentPayload.ySp), s.M("rewardAmount", Integer.valueOf(localLiveSingleCommentPayload.Dmv)) });
            Log.i("GameLiveAppbrandEventService", "LiveComment event,single info,msgType:%d", new Object[] { localLiveSingleCommentPayload.Dmm });
            if (localMap == null)
            {
              paramLiveCommentWrapperInfoPayload = new kotlin.t("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.Any>");
              AppMethodBeat.o(207934);
              throw paramLiveCommentWrapperInfoPayload;
            }
            localList.add(localMap);
          }
        }
        paramLiveCommentWrapperInfoPayload = ae.e(new kotlin.o[] { s.M("liveId", Long.valueOf(paramLiveCommentWrapperInfoPayload.liveId)), s.M("currOnlineCount", Long.valueOf(paramLiveCommentWrapperInfoPayload.Dmf)), s.M("totalViewCount", Long.valueOf(paramLiveCommentWrapperInfoPayload.Dmg)), s.M("currLikeCount", Long.valueOf(paramLiveCommentWrapperInfoPayload.Dmh)), s.M("totalRewardCount", Long.valueOf(paramLiveCommentWrapperInfoPayload.Dmi)), s.M("msgList", localList) });
        Log.i("GameLiveAppbrandEventService", "send LiveComment event,info list size:%d", new Object[] { Integer.valueOf(localList.size()) });
        localb.i((com.tencent.mm.plugin.appbrand.jsapi.e)((com.tencent.mm.plugin.appbrand.t)localObject1).bDA()).D(paramLiveCommentWrapperInfoPayload);
        localb.bPO();
        AppMethodBeat.o(207934);
        return;
      }
      AppMethodBeat.o(207934);
      return;
    }
    AppMethodBeat.o(207934);
  }
  
  public final void a(Object paramObject, Context paramContext, String paramString, int paramInt)
  {
    AppMethodBeat.i(207904);
    p.k(paramObject, "runtime");
    p.k(paramContext, "context");
    p.k(paramString, "appId");
    Log.i("MicroMsg.GameLiveAppbrandProcessService", "zbql:onAppbrandEnterForeground");
    PluginGameLive localPluginGameLive = (PluginGameLive)com.tencent.mm.kernel.h.ag(PluginGameLive.class);
    com.tencent.mm.plugin.appbrand.t localt = (com.tencent.mm.plugin.appbrand.t)paramObject;
    if (!localPluginGameLive.isGameLiving(paramString, paramInt))
    {
      paramObject = localt.bDv();
      if (paramObject != null) {}
      for (paramObject = (d)paramObject.R(d.class);; paramObject = null)
      {
        if (paramObject != null) {
          paramObject.PH();
        }
        paramObject = this.Djn;
        if (paramObject != null) {
          paramObject.nAH = null;
        }
        this.Djn = null;
        Log.i("MicroMsg.GameLiveAppbrandProcessService", "zbql:onAppbrandEnterForeground not gameLiving,return");
        AppMethodBeat.o(207904);
        return;
      }
    }
    this.Djn = new GameLiveAppbrandEventService(localt);
    paramObject = localPluginGameLive.getGameLiveCurrentState_$plugin_gamelive_release();
    if (paramObject == null)
    {
      paramObject = localPluginGameLive.getGameLiveCurrentState_$plugin_gamelive_release();
      if (paramObject == null) {
        break label788;
      }
    }
    label788:
    for (paramObject = paramObject.eAP();; paramObject = null)
    {
      Log.e("MicroMsg.GameLiveAppbrandProcessService", "gameLiving onAppbrandEnterForeground,but state is wrong,state:%s", new Object[] { paramObject });
      this.Djo = false;
      XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, new PluginGameLive.IPCLiveControlData(PluginGameLive.IPCLiveControlData.b.DkA, paramString, null, 12), PluginGameLive.c.class, null);
      this.Djq = false;
      AppMethodBeat.o(207904);
      return;
      switch (a.jLJ[paramObject.ordinal()])
      {
      default: 
        break;
      case 1: 
        paramObject = localPluginGameLive.getGameLiveCurrentState_$plugin_gamelive_release();
        if (paramObject != null)
        {
          paramObject = paramObject.eAP();
          Log.i("MicroMsg.GameLiveAppbrandProcessService", "state %s", new Object[] { paramObject });
          paramObject = com.tencent.mm.kernel.h.aHD().aHf();
          p.j(paramObject, "MMKernel.process().current()");
          paramObject = ((com.tencent.mm.kernel.b.h)paramObject).getProcessName();
          p.j(paramObject, "MMKernel.process().current().processName");
          localPluginGameLive.setAppBrandPackageName$plugin_gamelive_release(paramObject);
          paramObject = localPluginGameLive.getGameLivePrepareScene_$plugin_gamelive_release();
          if (paramObject != null) {
            break label379;
          }
          Log.e("MicroMsg.GameLiveAppbrandProcessService", "preparing, the scene is wrong");
        }
        for (;;)
        {
          hG(h.d.qfn.ordinal(), h.c.qff.ordinal());
          localPluginGameLive.setGameLiveCurrentState_$plugin_gamelive_release(PluginGameLive.b.Dko);
          break;
          paramObject = null;
          break label278;
          switch (a.$EnumSwitchMapping$0[paramObject.ordinal()])
          {
          default: 
            break;
          case 1: 
            Log.i("MicroMsg.GameLiveAppbrandProcessService", "from gamestart");
            com.tencent.mm.plugin.appbrand.ipc.a.a(paramContext, (AppBrandProxyUIProcessTask.ProcessRequest)new GameLiveAppbrandProcessService.EnterFinderLiveRequest(paramString, paramInt, c.Djx.ordinal(), 0, 8), (AppBrandProxyUIProcessTask.b)GameLiveAppbrandProcessService.h.DjK);
            break;
          case 2: 
            com.tencent.e.h.ZvG.n((Runnable)new GameLiveAppbrandProcessService.i(localt, paramContext, paramString, paramInt), 300L);
          }
        }
      case 2: 
      case 3: 
        label278:
        label379:
        paramObject = localPluginGameLive.getGameLiveCurrentState_$plugin_gamelive_release();
        if (paramObject != null)
        {
          paramObject = paramObject.eAP();
          label500:
          Log.i("MicroMsg.GameLiveAppbrandProcessService", "state %s", new Object[] { paramObject });
          XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, new PluginGameLive.IPCLiveControlData(PluginGameLive.IPCLiveControlData.b.DkG, paramString, null, 12), PluginGameLive.c.class, null);
          paramObject = localPluginGameLive.getAppbrandProcessAudioService$plugin_gamelive_release();
          if (paramObject != null) {
            paramObject.resume();
          }
          paramObject = localt.bDv();
          if (paramObject == null) {
            break label692;
          }
          paramObject = (d)paramObject.R(d.class);
          label575:
          if (paramObject != null) {
            paramObject.PH();
          }
          if (!((PluginGameLive)com.tencent.mm.kernel.h.ag(PluginGameLive.class)).isPushing$plugin_gamelive_release()) {
            break label697;
          }
          Log.i("MicroMsg.GameLiveAppbrandProcessService", "startPush: isPushing return");
        }
        for (;;)
        {
          if (localPluginGameLive.getGameLiveCurrentState_$plugin_gamelive_release() == PluginGameLive.b.Dkq)
          {
            paramObject = ((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.h.aHD().aHf()).getProcessName();
            p.j(paramObject, "MMKernel.process().current().getProcessName()");
            localPluginGameLive.setAppBrandPackageName$plugin_gamelive_release(paramObject);
            hG(h.d.qfn.ordinal(), h.c.qff.ordinal());
            hG(h.d.qfm.ordinal(), h.c.qff.ordinal());
          }
          localPluginGameLive.setGameLiveCurrentState_$plugin_gamelive_release(PluginGameLive.b.Dko);
          break;
          paramObject = null;
          break label500;
          label692:
          paramObject = null;
          break label575;
          label697:
          Log.i("MicroMsg.GameLiveAppbrandProcessService", "startPush");
          ((PluginGameLive)com.tencent.mm.kernel.h.ag(PluginGameLive.class)).setPushing$plugin_gamelive_release(true);
          paramObject = ((PluginGameLive)com.tencent.mm.kernel.h.ag(PluginGameLive.class)).getAppbrandProcessAudioService$plugin_gamelive_release();
          if (paramObject != null) {
            paramObject.U(localt);
          }
          ((PluginGameLive)com.tencent.mm.kernel.h.ag(PluginGameLive.class)).getAppbrandProcessRenderService$plugin_gamelive_release();
          XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, new PluginGameLive.IPCLiveControlData(PluginGameLive.IPCLiveControlData.b.Dkx, null, null, 14), PluginGameLive.c.class, (f)new o(this));
        }
      }
    }
  }
  
  public final void a(String paramString, int paramInt, Context paramContext)
  {
    AppMethodBeat.i(207909);
    p.k(paramString, "appId");
    com.tencent.mm.plugin.appbrand.ipc.a.a(paramContext, (AppBrandProxyUIProcessTask.ProcessRequest)new GameLiveAppbrandProcessService.EnterFinderLiveRequest(paramString, paramInt, c.Djw.ordinal(), 0, 8), (AppBrandProxyUIProcessTask.b)new GameLiveAppbrandProcessService.n(paramContext));
    AppMethodBeat.o(207909);
  }
  
  public final void a(final String paramString, final int paramInt1, final Context paramContext, final int paramInt2, final c.a parama)
  {
    AppMethodBeat.i(207913);
    p.k(paramString, "appId");
    p.k(paramContext, "context");
    com.tencent.e.h.ZvG.bc((Runnable)new e(this, paramString, paramInt1, paramContext, paramInt2, parama));
    AppMethodBeat.o(207913);
  }
  
  public final void a(String paramString, int paramInt, Context paramContext, c.d paramd)
  {
    AppMethodBeat.i(207943);
    p.k(paramString, "appId");
    p.k(paramContext, "context");
    this.Djr = paramd;
    if (((PluginGameLive)com.tencent.mm.kernel.h.ag(PluginGameLive.class)).isGameLiving(paramString, paramInt)) {
      com.tencent.mm.plugin.appbrand.ipc.a.a(paramContext, (AppBrandProxyUIProcessTask.ProcessRequest)new GameLiveAppbrandProcessService.EnterFinderLiveRequest(paramString, 0, c.Djz.ordinal(), 0, 10), (AppBrandProxyUIProcessTask.b)GameLiveAppbrandProcessService.l.DjQ);
    }
    AppMethodBeat.o(207943);
  }
  
  public final void aKQ(String paramString)
  {
    AppMethodBeat.i(207917);
    p.k(paramString, "appId");
    this.Djo = true;
    AppMethodBeat.o(207917);
  }
  
  public final void b(String paramString, int paramInt, Context paramContext)
  {
    AppMethodBeat.i(207946);
    p.k(paramString, "appId");
    p.k(paramContext, "context");
    if (((PluginGameLive)com.tencent.mm.kernel.h.ag(PluginGameLive.class)).isGameLiving(paramString, paramInt)) {
      com.tencent.mm.plugin.appbrand.ipc.a.a(paramContext, (AppBrandProxyUIProcessTask.ProcessRequest)new GameLiveAppbrandProcessService.EnterFinderLiveRequest(paramString, 0, c.Djy.ordinal(), 0, 10), (AppBrandProxyUIProcessTask.b)GameLiveAppbrandProcessService.m.DjR);
    }
    AppMethodBeat.o(207946);
  }
  
  public final void eAE()
  {
    AppMethodBeat.i(207919);
    XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, new PluginGameLive.IPCLiveControlData(PluginGameLive.IPCLiveControlData.b.Dkw, null, null, 14), PluginGameLive.c.class, null);
    AppMethodBeat.o(207919);
  }
  
  public final void eAG()
  {
    this.Djm = null;
  }
  
  public final void eK(String paramString, int paramInt)
  {
    AppMethodBeat.i(207907);
    p.k(paramString, "appId");
    if (!((PluginGameLive)com.tencent.mm.kernel.h.ag(PluginGameLive.class)).isGameLiving(paramString, paramInt))
    {
      AppMethodBeat.o(207907);
      return;
    }
    ((PluginGameLive)com.tencent.mm.kernel.h.ag(PluginGameLive.class)).setGameLiveCurrentState_$plugin_gamelive_release(PluginGameLive.b.Dkq);
    eAF();
    AppMethodBeat.o(207907);
  }
  
  public final void h(String paramString, Context paramContext)
  {
    AppMethodBeat.i(207915);
    p.k(paramString, "appId");
    p.k(paramContext, "context");
    com.tencent.mm.plugin.appbrand.ipc.a.a(paramContext, (AppBrandProxyUIProcessTask.ProcessRequest)new GameLiveAppbrandProcessService.EnterFinderLiveRequest(paramString, 0, c.DjB.ordinal(), 0, 10), (AppBrandProxyUIProcessTask.b)GameLiveAppbrandProcessService.d.DjD);
    AppMethodBeat.o(207915);
  }
  
  public final void hG(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(207926);
    Object localObject1 = this.Djn;
    if (localObject1 != null)
    {
      Object localObject2 = ((GameLiveAppbrandEventService)localObject1).nAH;
      if (localObject2 != null)
      {
        localObject1 = h.b.qfe;
        ((h.b)localObject1).i((com.tencent.mm.plugin.appbrand.jsapi.e)((com.tencent.mm.plugin.appbrand.t)localObject2).bDA()).D(ae.e(new kotlin.o[] { s.M("event", Integer.valueOf(paramInt1)), s.M("reason", Integer.valueOf(paramInt2)) }));
        Log.i("GameLiveAppbrandEventService", "zbql: send Event:" + paramInt1 + ",reason:" + paramInt2);
        if (paramInt1 == h.d.qfm.ordinal())
        {
          localObject2 = (PluginGameLive)com.tencent.mm.kernel.h.ag(PluginGameLive.class);
          Map localMap = ae.e(new kotlin.o[] { s.M("nickname", ((PluginGameLive)localObject2).getGameLiveNickname$plugin_gamelive_release()), s.M("headerUrl", ((PluginGameLive)localObject2).getGameLiveAnchorHeadUrl$plugin_gamelive_release()), s.M("joinLiveTips", ((PluginGameLive)localObject2).getGameLiveJoinLiveTips$plugin_gamelive_release()), s.M("liveId", Long.valueOf(((PluginGameLive)localObject2).getGameLiveLiveId$plugin_gamelive_release())), s.M("finderUsername", ((PluginGameLive)localObject2).getGameLiveFinderUsrName$plugin_gamelive_release()) });
          Log.i("GameLiveAppbrandEventService", "zbql: start Event,nickname:%s,blabla", new Object[] { ((PluginGameLive)localObject2).getGameLiveNickname$plugin_gamelive_release() });
          ((h.b)localObject1).o("extra", localMap);
        }
        ((h.b)localObject1).bPO();
        AppMethodBeat.o(207926);
        return;
      }
      AppMethodBeat.o(207926);
      return;
    }
    AppMethodBeat.o(207926);
  }
  
  public final void l(Context paramContext, String paramString, int paramInt)
  {
    AppMethodBeat.i(207906);
    p.k(paramContext, "context");
    p.k(paramString, "appId");
    Log.i("MicroMsg.GameLiveAppbrandProcessService", "zbql:onAppbrandEnterBackGround");
    if (((PluginGameLive)com.tencent.mm.kernel.h.ag(PluginGameLive.class)).isGameLiving(paramString, paramInt))
    {
      XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, new PluginGameLive.IPCLiveControlData(PluginGameLive.IPCLiveControlData.b.Dkz, paramString, null, 12), PluginGameLive.c.class, null);
      paramContext = ((PluginGameLive)com.tencent.mm.kernel.h.ag(PluginGameLive.class)).getAppbrandProcessAudioService$plugin_gamelive_release();
      if (paramContext != null) {
        paramContext.pause();
      }
      if (!this.Djq) {
        XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, new PluginGameLive.IPCLiveControlData(PluginGameLive.IPCLiveControlData.b.DkH, paramString, null, 12), PluginGameLive.c.class, null);
      }
      ((PluginGameLive)com.tencent.mm.kernel.h.ag(PluginGameLive.class)).setGameLiveCurrentState_$plugin_gamelive_release(PluginGameLive.b.Dkp);
    }
    AppMethodBeat.o(207906);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/gamelive/GameLiveAppbrandProcessService$EnterFinderLiveTask;", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask;", "()V", "TAG", "", "handleRequest", "", "request", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask$ProcessRequest;", "mmOnActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "plugin-gamelive_release"})
  public static final class b
    extends AppBrandProxyUIProcessTask
  {
    private final String TAG = "MicroMsg.GameLive.EnterFinderLiveTask";
    
    public final void a(final AppBrandProxyUIProcessTask.ProcessRequest paramProcessRequest)
    {
      AppMethodBeat.i(208696);
      if (!(paramProcessRequest instanceof GameLiveAppbrandProcessService.EnterFinderLiveRequest))
      {
        Log.w(this.TAG, "handleRequest#EnterFinderTask, request is not EnterFinderRequest");
        AppMethodBeat.o(208696);
        return;
      }
      Log.i(this.TAG, "handleRequest appid " + ((GameLiveAppbrandProcessService.EnterFinderLiveRequest)paramProcessRequest).appid);
      int i = ((GameLiveAppbrandProcessService.EnterFinderLiveRequest)paramProcessRequest).action;
      MMActivity localMMActivity;
      if (i == GameLiveAppbrandProcessService.c.Djw.ordinal())
      {
        if (!((com.tencent.c.a.a.a.b)com.tencent.mm.kernel.h.ag(com.tencent.c.a.a.a.b.class)).isAnchorLiving())
        {
          if (((PluginGameLive)com.tencent.mm.kernel.h.ag(PluginGameLive.class)).getOnLivingStatusForCrashCheckTemp$plugin_gamelive_release())
          {
            Log.i(this.TAG, "try to startGame, but in crash state, decide to recover");
            ((com.tencent.c.a.a.a.b)com.tencent.mm.kernel.h.ag(com.tencent.c.a.a.a.b.class)).checkLastLiveObject((Context)bPf(), (kotlin.g.a.b)new a(this, paramProcessRequest));
            AppMethodBeat.o(208696);
            return;
          }
          Log.i(this.TAG, "startGame");
          if (((PluginGameLive)com.tencent.mm.kernel.h.ag(PluginGameLive.class)).getMainProcessService$plugin_gamelive_release() != null)
          {
            localMMActivity = bPf();
            p.j(localMMActivity, "activityContext");
            b.m((Context)localMMActivity, ((GameLiveAppbrandProcessService.EnterFinderLiveRequest)paramProcessRequest).appid, ((GameLiveAppbrandProcessService.EnterFinderLiveRequest)paramProcessRequest).cBU);
          }
          b((AppBrandProxyUIProcessTask.ProcessResult)new GameLiveAppbrandProcessService.EnterFinderLiveResult(0));
          AppMethodBeat.o(208696);
          return;
        }
        Log.i(this.TAG, "try to startGame,but isAnchorLiving,finishProcess with error");
        b((AppBrandProxyUIProcessTask.ProcessResult)new GameLiveAppbrandProcessService.EnterFinderLiveResult(1));
        AppMethodBeat.o(208696);
        return;
      }
      if (i == GameLiveAppbrandProcessService.c.Djx.ordinal())
      {
        paramProcessRequest = (com.tencent.c.a.a.a.b)com.tencent.mm.kernel.h.ag(com.tencent.c.a.a.a.b.class);
        localMMActivity = bPf();
        p.j(localMMActivity, "activityContext");
        paramProcessRequest.enterFinderLiveCountDownUI((Context)localMMActivity);
        b((AppBrandProxyUIProcessTask.ProcessResult)new GameLiveAppbrandProcessService.EnterFinderLiveResult(0));
        AppMethodBeat.o(208696);
        return;
      }
      if (i == GameLiveAppbrandProcessService.c.Djy.ordinal())
      {
        paramProcessRequest = (com.tencent.c.a.a.a.b)com.tencent.mm.kernel.h.ag(com.tencent.c.a.a.a.b.class);
        localMMActivity = bPf();
        p.j(localMMActivity, "activityContext");
        paramProcessRequest.shareLiveToSns((AppCompatActivity)localMMActivity);
        b((AppBrandProxyUIProcessTask.ProcessResult)new GameLiveAppbrandProcessService.EnterFinderLiveResult(0));
        AppMethodBeat.o(208696);
        return;
      }
      if (i == GameLiveAppbrandProcessService.c.Djz.ordinal())
      {
        bPf().mmSetOnActivityResultCallback((MMActivity.a)this);
        paramProcessRequest = (com.tencent.c.a.a.a.b)com.tencent.mm.kernel.h.ag(com.tencent.c.a.a.a.b.class);
        localMMActivity = bPf();
        p.j(localMMActivity, "activityContext");
        paramProcessRequest.shareLiveToFriend((AppCompatActivity)localMMActivity);
        AppMethodBeat.o(208696);
        return;
      }
      if (i == GameLiveAppbrandProcessService.c.DjA.ordinal())
      {
        if (((GameLiveAppbrandProcessService.EnterFinderLiveRequest)paramProcessRequest).Djt == 1) {}
        for (boolean bool = true;; bool = false)
        {
          ((com.tencent.c.a.a.a.b)com.tencent.mm.kernel.h.ag(com.tencent.c.a.a.a.b.class)).backToFinderLiveAnchorUIOnExternalLive((Context)bPf(), true, bool);
          ((PluginGameLive)com.tencent.mm.kernel.h.ag(PluginGameLive.class)).resetState$plugin_gamelive_release();
          b((AppBrandProxyUIProcessTask.ProcessResult)new GameLiveAppbrandProcessService.EnterFinderLiveResult(0));
          AppMethodBeat.o(208696);
          return;
        }
      }
      if (i == GameLiveAppbrandProcessService.c.DjB.ordinal())
      {
        ((com.tencent.c.a.a.a.b)com.tencent.mm.kernel.h.ag(com.tencent.c.a.a.a.b.class)).backToFinderLiveAnchorUIOnExternalLive((Context)bPf(), false, false);
        b((AppBrandProxyUIProcessTask.ProcessResult)new GameLiveAppbrandProcessService.EnterFinderLiveResult(0));
      }
      AppMethodBeat.o(208696);
    }
    
    public final void d(int paramInt1, int paramInt2, Intent paramIntent)
    {
      AppMethodBeat.i(208697);
      super.d(paramInt1, paramInt2, paramIntent);
      b((AppBrandProxyUIProcessTask.ProcessResult)new GameLiveAppbrandProcessService.EnterFinderLiveResult(0));
      AppMethodBeat.o(208697);
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "", "invoke"})
    static final class a
      extends q
      implements kotlin.g.a.b<Boolean, x>
    {
      a(GameLiveAppbrandProcessService.b paramb, AppBrandProxyUIProcessTask.ProcessRequest paramProcessRequest)
      {
        super();
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/gamelive/GameLiveAppbrandProcessService$FinderLiveControlAction;", "", "(Ljava/lang/String;I)V", "FinderLiveControlActionStartGameLive", "FinderLiveControlActionShowCountDownActivity", "FinderLiveControlActionShareToSNS", "FinderLiveControlActionShareToFriend", "FinderLiveControlActionStopGameLive", "FinderLiveControlActionEnterGameLiveRoom", "plugin-gamelive_release"})
  public static enum c
  {
    static
    {
      AppMethodBeat.i(208030);
      c localc1 = new c("FinderLiveControlActionStartGameLive", 0);
      Djw = localc1;
      c localc2 = new c("FinderLiveControlActionShowCountDownActivity", 1);
      Djx = localc2;
      c localc3 = new c("FinderLiveControlActionShareToSNS", 2);
      Djy = localc3;
      c localc4 = new c("FinderLiveControlActionShareToFriend", 3);
      Djz = localc4;
      c localc5 = new c("FinderLiveControlActionStopGameLive", 4);
      DjA = localc5;
      c localc6 = new c("FinderLiveControlActionEnterGameLiveRoom", 5);
      DjB = localc6;
      DjC = new c[] { localc1, localc2, localc3, localc4, localc5, localc6 };
      AppMethodBeat.o(208030);
    }
    
    private c() {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class e
    implements Runnable
  {
    e(GameLiveAppbrandProcessService paramGameLiveAppbrandProcessService, String paramString, int paramInt1, Context paramContext, int paramInt2, c.a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(207974);
      Log.i("MicroMsg.GameLiveAppbrandProcessService", "zbql:exitGameLive from js or menu");
      if (((PluginGameLive)com.tencent.mm.kernel.h.ag(PluginGameLive.class)).isGameLiving(paramString, paramInt1))
      {
        com.tencent.mm.ui.widget.a.e locale = new com.tencent.mm.ui.widget.a.e(paramContext, 1, false);
        locale.a((q.f)new a(this));
        locale.a((q.g)new b(this));
        locale.a((e.a)new c(this));
        locale.eik();
      }
      AppMethodBeat.o(207974);
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu", "com/tencent/mm/plugin/gamelive/GameLiveAppbrandProcessService$exitGameLive$1$1$1"})
    static final class a
      implements q.f
    {
      a(GameLiveAppbrandProcessService.e parame) {}
      
      public final void onCreateMMMenu(com.tencent.mm.ui.base.o paramo)
      {
        AppMethodBeat.i(208710);
        paramo.a(0, com.tencent.mm.ci.a.w(this.DjH.$context, g.a.red_text_color), (CharSequence)com.tencent.mm.ci.a.ba(this.DjH.$context, g.c.Dlg));
        AppMethodBeat.o(208710);
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected", "com/tencent/mm/plugin/gamelive/GameLiveAppbrandProcessService$exitGameLive$1$1$2"})
    static final class b
      implements q.g
    {
      b(GameLiveAppbrandProcessService.e parame) {}
      
      public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
      {
        AppMethodBeat.i(208652);
        GameLiveAppbrandProcessService.a(this.DjH.DjE, this.DjH.cBD, this.DjH.$context, true);
        GameLiveAppbrandProcessService.a(this.DjH.DjE, h.d.qfl.ordinal(), this.DjH.DjF);
        paramMenuItem = this.DjH.DjG;
        if (paramMenuItem != null)
        {
          paramMenuItem.uR(1);
          AppMethodBeat.o(208652);
          return;
        }
        AppMethodBeat.o(208652);
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "onClick", "com/tencent/mm/plugin/gamelive/GameLiveAppbrandProcessService$exitGameLive$1$1$3"})
    static final class c
      implements e.a
    {
      c(GameLiveAppbrandProcessService.e parame) {}
      
      public final void onClick()
      {
        AppMethodBeat.i(208135);
        c.a locala = this.DjH.DjG;
        if (locala != null)
        {
          locala.uR(0);
          AppMethodBeat.o(208135);
          return;
        }
        AppMethodBeat.o(208135);
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/gamelive/PluginGameLive$IPCLiveControlData;", "kotlin.jvm.PlatformType", "onCallback"})
  static final class g<T>
    implements f<ResultType>
  {
    g(c.c paramc) {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu", "com/tencent/mm/plugin/gamelive/GameLiveAppbrandProcessService$onAppbrandExit$1$1"})
  static final class j
    implements q.f
  {
    j(GameLiveAppbrandProcessService paramGameLiveAppbrandProcessService, Context paramContext, String paramString, Runnable paramRunnable) {}
    
    public final void onCreateMMMenu(com.tencent.mm.ui.base.o paramo)
    {
      AppMethodBeat.i(208187);
      paramo.a(0, com.tencent.mm.ci.a.w(paramContext, g.a.red_text_color), (CharSequence)com.tencent.mm.ci.a.ba(paramContext, g.c.appbrand_gamelive_end_live));
      AppMethodBeat.o(208187);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected", "com/tencent/mm/plugin/gamelive/GameLiveAppbrandProcessService$onAppbrandExit$1$2"})
  static final class k
    implements q.g
  {
    k(GameLiveAppbrandProcessService paramGameLiveAppbrandProcessService, Context paramContext, String paramString, Runnable paramRunnable) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(208551);
      paramMenuItem = new com.tencent.mm.ui.widget.a.e(paramContext, 1, false);
      paramMenuItem.a((q.f)new q.f()
      {
        public final void onCreateMMMenu(com.tencent.mm.ui.base.o paramAnonymouso)
        {
          AppMethodBeat.i(207830);
          paramAnonymouso.a(0, com.tencent.mm.ci.a.w(this.DjP.$context$inlined, g.a.red_text_color), (CharSequence)com.tencent.mm.ci.a.ba(this.DjP.$context$inlined, g.c.Dlg));
          AppMethodBeat.o(207830);
        }
      });
      paramMenuItem.a((q.g)new q.g()
      {
        public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
        {
          AppMethodBeat.i(208566);
          GameLiveAppbrandProcessService.a(this.DjP.DjE, this.DjP.qyl, this.DjP.$context$inlined, false);
          GameLiveAppbrandProcessService.a(this.DjP.DjE, h.d.qfl.ordinal(), h.c.qfh.ordinal());
          this.DjP.DjO.run();
          AppMethodBeat.o(208566);
        }
      });
      paramMenuItem.eik();
      AppMethodBeat.o(208551);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/gamelive/PluginGameLive$IPCLiveControlData;", "kotlin.jvm.PlatformType", "onCallback"})
  static final class o<T>
    implements f<ResultType>
  {
    o(GameLiveAppbrandProcessService paramGameLiveAppbrandProcessService) {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class q
    implements Runnable
  {
    public static final q DjT;
    
    static
    {
      AppMethodBeat.i(208746);
      DjT = new q();
      AppMethodBeat.o(208746);
    }
    
    public final void run()
    {
      AppMethodBeat.i(208744);
      ((PluginGameLive)com.tencent.mm.kernel.h.ag(PluginGameLive.class)).getAppbrandProcessRenderService$plugin_gamelive_release();
      XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, new PluginGameLive.IPCLiveControlData(PluginGameLive.IPCLiveControlData.b.Dky, null, null, 14), PluginGameLive.c.class, (f)1.DjU);
      AppMethodBeat.o(208744);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelive.GameLiveAppbrandProcessService
 * JD-Core Version:    0.7.0.1
 */