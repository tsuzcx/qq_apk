package com.tencent.mm.plugin.gamelive;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.net.LocalServerSocket;
import android.os.Looper;
import android.os.Parcelable;
import android.provider.Settings.System;
import android.view.MenuItem;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.luggage.game.page.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessResult;
import com.tencent.mm.plugin.appbrand.menu.h.b;
import com.tencent.mm.plugin.appbrand.menu.h.c;
import com.tencent.mm.plugin.appbrand.menu.h.d;
import com.tencent.mm.plugin.appbrand.n.q;
import com.tencent.mm.plugin.appbrand.w;
import com.tencent.mm.plugin.findersdk.receiver.HeadsetReceiver;
import com.tencent.mm.plugin.gamelive.a.a.2;
import com.tencent.mm.plugin.gamelive.a.a.3;
import com.tencent.mm.plugin.gamelive.event.GameLiveAppbrandEventService;
import com.tencent.mm.plugin.gamelive.event.GameLiveAppbrandEventService.LiveCommentWrapperInfoPayload;
import com.tencent.mm.plugin.gamelive.event.GameLiveAppbrandEventService.LiveCurrentRoomInfoPayload;
import com.tencent.mm.plugin.gamelive.event.GameLiveAppbrandEventService.LiveMemberInfoListPayload;
import com.tencent.mm.plugin.gamelive.event.GameLiveAppbrandEventService.LiveMemberInfoPayload;
import com.tencent.mm.plugin.gamelive.event.GameLiveAppbrandEventService.LiveSingleCommentPayload;
import com.tencent.mm.plugin.gamelive.event.GameLiveAppbrandEventService.LiveTopicPayload;
import com.tencent.mm.plugin.gamelive.event.GameLiveAppbrandEventService.b;
import com.tencent.mm.plugin.music.b.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.widget.a.g.a;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.a.ak;
import kotlin.g.b.u;
import kotlin.r;
import kotlin.v;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/gamelive/GameLiveAppbrandProcessService;", "Lcom/tencent/mm/plugin/gamelive/IGameLiveAppbrandProcessService;", "()V", "gameLiveEventService", "Lcom/tencent/mm/plugin/gamelive/event/GameLiveAppbrandEventService;", "isFloating", "", "isMicAlive", "isStopLive", "pushActionCallback", "Lcom/tencent/mm/plugin/gamelive/IGameLiveAppbrandProcessService$IPushActionCallback;", "shareToFriendCallback", "Lcom/tencent/mm/plugin/gamelive/IGameLiveAppbrandProcessService$IGameLiveShareCallback;", "widget", "Lcom/tencent/mm/plugin/gamelive/playgame/GameLivePlayGameAnchorInviteWidget;", "doCleaning", "", "enterGameLiveRoom", "appId", "", "versionType", "", "context", "Landroid/content/Context;", "exitGameLive", "endReason", "callback", "Lcom/tencent/mm/plugin/gamelive/IGameLiveAppbrandProcessService$IGameExitLiveCallback;", "getCurrentRoomInfo", "Lcom/tencent/mm/plugin/gamelive/IGameLiveAppbrandProcessService$IGameGetCurrentRoomInfoCallback;", "getMemberList", "callback1", "Lcom/tencent/mm/plugin/gamelive/IGameLiveAppbrandProcessService$IGameGetMemberListCallback;", "getMicAlive", "()Ljava/lang/Boolean;", "minimizeGameLive", "onAppbrandDestroy", "onAppbrandEnterBackGround", "onAppbrandEnterForeground", "runtime", "", "onAppbrandExit", "closeRunnable", "Ljava/lang/Runnable;", "registerPushActionCallback", "resetMicAliveFromFinder", "sendCommentEventProxy", "liveCommentWrapperInfoPayload", "Lcom/tencent/mm/plugin/gamelive/event/GameLiveAppbrandEventService$LiveCommentWrapperInfoPayload;", "sendCommentEventProxy$plugin_gamelive_release", "sendLiveStateChangeEventProxy", "event", "reason", "payload", "Lcom/tencent/mm/plugin/gamelive/event/GameLiveAppbrandEventService$LiveStartInfoPayload;", "sendLiveStateChangeEventProxy$plugin_gamelive_release", "sendNetWorkEventProxy", "netWork", "threshold", "sendNetWorkEventProxy$plugin_gamelive_release", "sendShareToFriendCallback", "shareUserCount", "shareRoomCount", "sendVolumnEventProxy", "volume", "sendVolumnEventProxy$plugin_gamelive_release", "setMicAlive", "isMicOpen", "setMicInfoEvent", "isMicEventNotify", "duration", "setTopic", "topic", "Lcom/tencent/mm/plugin/gamelive/IGameLiveAppbrandProcessService$IGameLiveSetTopicCallback;", "shareToFriend", "shareToSNS", "startGameLive", "path", "reportInfo", "startPlayGameAnchorSetting", "jsonObject", "Lorg/json/JSONObject;", "Lcom/tencent/mm/plugin/gamelive/IGameLiveAppbrandProcessService$IGameActionCallback;", "startPush", "runtimeWC", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "stopGameLive", "needReopenAppbrand", "stopPush", "syncLiveState", "unregisterPushActionCallback", "Companion", "EnterFinderLiveRequest", "EnterFinderLiveResult", "EnterFinderLiveTask", "FinderLiveControlAction", "plugin-gamelive_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class GameLiveAppbrandProcessService
  implements b
{
  public static final GameLiveAppbrandProcessService.a JcK;
  private b.g JcL;
  GameLiveAppbrandEventService JcM;
  private boolean JcN;
  boolean JcO = true;
  private boolean JcP;
  private com.tencent.mm.plugin.gamelive.b.a JcQ;
  b.f JcR;
  
  static
  {
    AppMethodBeat.i(277473);
    JcK = new GameLiveAppbrandProcessService.a((byte)0);
    AppMethodBeat.o(277473);
  }
  
  private static final void a(Context paramContext, GameLiveAppbrandProcessService.EnterFinderLiveResult paramEnterFinderLiveResult)
  {
    AppMethodBeat.i(277316);
    if (paramEnterFinderLiveResult.errCode != 0)
    {
      paramContext = new g.a(paramContext).bf((CharSequence)com.tencent.mm.cd.a.bt(MMApplicationContext.getContext(), e.c.Jen)).bDE(com.tencent.mm.cd.a.bt(MMApplicationContext.getContext(), e.c.Jem)).aEX(e.c.Jeo).NF(true);
      paramContext.Xdm = true;
      paramContext.show();
    }
    AppMethodBeat.o(277316);
  }
  
  private static final void a(Context paramContext, GameLiveAppbrandProcessService paramGameLiveAppbrandProcessService, String paramString, Runnable paramRunnable, MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(277353);
    kotlin.g.b.s.u(paramContext, "$context");
    kotlin.g.b.s.u(paramGameLiveAppbrandProcessService, "this$0");
    kotlin.g.b.s.u(paramString, "$appId");
    kotlin.g.b.s.u(paramRunnable, "$closeRunnable");
    paramMenuItem = new com.tencent.mm.ui.widget.a.f(paramContext, 1, false);
    paramMenuItem.Vtg = new GameLiveAppbrandProcessService..ExternalSyntheticLambda12(paramContext);
    paramMenuItem.GAC = new GameLiveAppbrandProcessService..ExternalSyntheticLambda17(paramGameLiveAppbrandProcessService, paramString, paramContext, paramRunnable);
    paramMenuItem.dDn();
    AppMethodBeat.o(277353);
  }
  
  private static final void a(w paramw, Context paramContext, String paramString, int paramInt)
  {
    AppMethodBeat.i(277307);
    kotlin.g.b.s.u(paramw, "$appbrandRuntime");
    kotlin.g.b.s.u(paramContext, "$context");
    kotlin.g.b.s.u(paramString, "$appId");
    paramw = paramw.ccK();
    if (paramw == null) {}
    for (paramw = null;; paramw = (d)paramw.aa(d.class))
    {
      if (paramw != null) {
        paramw.l(false, true);
      }
      com.tencent.mm.plugin.appbrand.ipc.a.a(paramContext, (AppBrandProxyUIProcessTask.ProcessRequest)new GameLiveAppbrandProcessService.EnterFinderLiveRequest(paramString, paramInt, c.JcW.ordinal(), 0, null, null, 56), GameLiveAppbrandProcessService..ExternalSyntheticLambda11.INSTANCE);
      AppMethodBeat.o(277307);
      return;
    }
  }
  
  private static final void a(GameLiveAppbrandProcessService.EnterFinderLiveResult paramEnterFinderLiveResult) {}
  
  private static final void a(GameLiveAppbrandProcessService paramGameLiveAppbrandProcessService, Context paramContext, JSONObject paramJSONObject, String paramString, int paramInt, b.a parama)
  {
    AppMethodBeat.i(277326);
    kotlin.g.b.s.u(paramGameLiveAppbrandProcessService, "this$0");
    kotlin.g.b.s.u(paramContext, "$context");
    kotlin.g.b.s.u(paramString, "$appId");
    if (paramGameLiveAppbrandProcessService.JcQ == null)
    {
      paramGameLiveAppbrandProcessService.JcQ = new com.tencent.mm.plugin.gamelive.b.a(paramContext, paramJSONObject, paramString, paramInt, parama);
      AppMethodBeat.o(277326);
      return;
    }
    paramGameLiveAppbrandProcessService = paramGameLiveAppbrandProcessService.JcQ;
    if (paramGameLiveAppbrandProcessService != null)
    {
      paramGameLiveAppbrandProcessService.eif = paramJSONObject;
      paramGameLiveAppbrandProcessService.Jgb = parama;
      paramGameLiveAppbrandProcessService.fB(paramString, paramInt);
      paramGameLiveAppbrandProcessService.refreshView();
    }
    AppMethodBeat.o(277326);
  }
  
  private static final void a(GameLiveAppbrandProcessService paramGameLiveAppbrandProcessService, PluginGameLive.IPCLiveControlData paramIPCLiveControlData)
  {
    AppMethodBeat.i(277405);
    kotlin.g.b.s.u(paramGameLiveAppbrandProcessService, "this$0");
    Log.i("MicroMsg.GameLiveAppbrandProcessService", "invoke startPush callback");
    paramGameLiveAppbrandProcessService = paramGameLiveAppbrandProcessService.JcL;
    if (paramGameLiveAppbrandProcessService != null) {
      paramGameLiveAppbrandProcessService.cpa();
    }
    AppMethodBeat.o(277405);
  }
  
  private static final void a(GameLiveAppbrandProcessService paramGameLiveAppbrandProcessService, String paramString, Context paramContext, int paramInt1, b.b paramb, MenuItem paramMenuItem, int paramInt2)
  {
    AppMethodBeat.i(277367);
    kotlin.g.b.s.u(paramGameLiveAppbrandProcessService, "this$0");
    kotlin.g.b.s.u(paramString, "$appId");
    kotlin.g.b.s.u(paramContext, "$context");
    paramGameLiveAppbrandProcessService.a(paramString, paramContext, true);
    paramGameLiveAppbrandProcessService.jj(h.d.tjQ.ordinal(), paramInt1);
    if (paramb != null) {
      paramb.AJ(1);
    }
    AppMethodBeat.o(277367);
  }
  
  private static final void a(GameLiveAppbrandProcessService paramGameLiveAppbrandProcessService, String paramString, Context paramContext, Runnable paramRunnable, MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(277348);
    kotlin.g.b.s.u(paramGameLiveAppbrandProcessService, "this$0");
    kotlin.g.b.s.u(paramString, "$appId");
    kotlin.g.b.s.u(paramContext, "$context");
    kotlin.g.b.s.u(paramRunnable, "$closeRunnable");
    paramGameLiveAppbrandProcessService.a(paramString, paramContext, false);
    paramGameLiveAppbrandProcessService.jj(h.d.tjQ.ordinal(), h.c.tjM.ordinal());
    paramRunnable.run();
    AppMethodBeat.o(277348);
  }
  
  private static final void a(PluginGameLive.IPCLiveControlData paramIPCLiveControlData)
  {
    AppMethodBeat.i(277420);
    paramIPCLiveControlData = ((PluginGameLive)com.tencent.mm.kernel.h.az(PluginGameLive.class)).getAppbrandProcessAudioService$plugin_gamelive_release();
    Object localObject1;
    if (paramIPCLiveControlData != null)
    {
      Log.i("MicroMsg.GameLiveAppbrandAudioMgrService", "stop appbrand audio");
      localObject1 = com.tencent.mm.plugin.music.b.i.glV();
      Object localObject2 = ((com.tencent.mm.plugin.music.b.i)localObject1).LJf;
      ((com.tencent.mm.audio.mix.f.c)localObject2).eh(false);
      ((com.tencent.mm.audio.mix.f.c)localObject2).ej(false);
      ((com.tencent.mm.audio.mix.f.c)localObject2).ei(false);
      ((com.tencent.mm.plugin.music.b.i)localObject1).ete = null;
      localObject1 = ((com.tencent.mm.plugin.music.b.i)localObject1).LII.values().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (l)((Iterator)localObject1).next();
        if (localObject2 != null) {
          ((l)localObject2).ete = null;
        }
      }
      if ((paramIPCLiveControlData.JeB != null) && (paramIPCLiveControlData.JeB.get() != null)) {
        ((com.tencent.mm.plugin.appbrand.game.b)paramIPCLiveControlData.JeB.get()).b(null);
      }
    }
    try
    {
      if (paramIPCLiveControlData.dke != null) {
        paramIPCLiveControlData.dke.close();
      }
      label152:
      localObject1 = paramIPCLiveControlData.Jew.values().iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((com.tencent.mm.plugin.gamelive.a.c)((Iterator)localObject1).next()).onStop();
      }
      paramIPCLiveControlData.Jew.clear();
      if (paramIPCLiveControlData.handler != null)
      {
        paramIPCLiveControlData.handler.getLooper().quit();
        paramIPCLiveControlData.handler.quit();
      }
      if (paramIPCLiveControlData.Jeu != null)
      {
        paramIPCLiveControlData.Jeu.getLooper().quit();
        paramIPCLiveControlData.Jeu.quit();
      }
      if (paramIPCLiveControlData.Jev != null) {}
      try
      {
        paramIPCLiveControlData.Jet.write(1);
        paramIPCLiveControlData.Jet.flush();
        paramIPCLiveControlData.Jet.close();
        paramIPCLiveControlData.Jet = null;
        paramIPCLiveControlData.Jev.close();
        paramIPCLiveControlData.Jev = null;
        paramIPCLiveControlData.handler = null;
        paramIPCLiveControlData.Jeu = null;
        MMApplicationContext.getContext().getContentResolver().unregisterContentObserver(paramIPCLiveControlData.JeA);
        if (!com.tencent.mm.plugin.gamelive.a.a.fIS()) {
          paramIPCLiveControlData.EKB.hy(MMApplicationContext.getContext());
        }
        AppMethodBeat.o(277420);
        return;
      }
      catch (IOException localIOException1)
      {
        for (;;)
        {
          Log.e("MicroMsg.GameLiveAppbrandAudioMgrService", "close localServerSocket exception", new Object[] { localIOException1 });
        }
      }
    }
    catch (IOException localIOException2)
    {
      break label152;
    }
  }
  
  private static final void a(b.b paramb)
  {
    AppMethodBeat.i(277374);
    if (paramb != null) {
      paramb.AJ(0);
    }
    AppMethodBeat.o(277374);
  }
  
  private static final void a(b.c paramc, PluginGameLive.IPCLiveControlData paramIPCLiveControlData)
  {
    AppMethodBeat.i(277457);
    paramIPCLiveControlData = paramIPCLiveControlData.JdB;
    if (paramIPCLiveControlData == null)
    {
      paramc = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.gamelive.event.GameLiveAppbrandEventService.LiveCurrentRoomInfoPayload");
      AppMethodBeat.o(277457);
      throw paramc;
    }
    paramIPCLiveControlData = (GameLiveAppbrandEventService.LiveCurrentRoomInfoPayload)paramIPCLiveControlData;
    if (paramc != null) {
      paramc.callback(paramIPCLiveControlData.startTime, paramIPCLiveControlData.topic);
    }
    AppMethodBeat.o(277457);
  }
  
  private static final void a(b.d paramd, PluginGameLive.IPCLiveControlData paramIPCLiveControlData)
  {
    AppMethodBeat.i(277448);
    kotlin.g.b.s.u(paramd, "$callback1");
    List localList = (List)new ArrayList();
    paramIPCLiveControlData = paramIPCLiveControlData.JdB;
    if (paramIPCLiveControlData == null)
    {
      paramd = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.gamelive.event.GameLiveAppbrandEventService.LiveMemberInfoListPayload");
      AppMethodBeat.o(277448);
      throw paramd;
    }
    paramIPCLiveControlData = ((GameLiveAppbrandEventService.LiveMemberInfoListPayload)paramIPCLiveControlData).EgE;
    if (paramIPCLiveControlData == null)
    {
      paramd = new NullPointerException("null cannot be cast to non-null type kotlin.collections.List<com.tencent.mm.plugin.gamelive.event.GameLiveAppbrandEventService.LiveMemberInfoPayload>");
      AppMethodBeat.o(277448);
      throw paramd;
    }
    paramIPCLiveControlData = paramIPCLiveControlData.iterator();
    while (paramIPCLiveControlData.hasNext())
    {
      GameLiveAppbrandEventService.LiveMemberInfoPayload localLiveMemberInfoPayload = (GameLiveAppbrandEventService.LiveMemberInfoPayload)paramIPCLiveControlData.next();
      localList.add(ak.e(new r[] { v.Y("nickname", localLiveMemberInfoPayload.nickname), v.Y("rewardAmountInHeat", Integer.valueOf(localLiveMemberInfoPayload.Jfs)) }));
    }
    paramd.dm(localList);
    AppMethodBeat.o(277448);
  }
  
  private static final void a(b.e parame, PluginGameLive.IPCLiveControlData paramIPCLiveControlData)
  {
    AppMethodBeat.i(277465);
    paramIPCLiveControlData = paramIPCLiveControlData.JdB;
    if (paramIPCLiveControlData == null)
    {
      parame = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.gamelive.event.GameLiveAppbrandEventService.LiveTopicPayload");
      AppMethodBeat.o(277465);
      throw parame;
    }
    paramIPCLiveControlData = (GameLiveAppbrandEventService.LiveTopicPayload)paramIPCLiveControlData;
    if (parame != null) {
      parame.callback(Boolean.valueOf(paramIPCLiveControlData.hCQ), paramIPCLiveControlData.errMsg);
    }
    AppMethodBeat.o(277465);
  }
  
  private static final void a(String paramString, int paramInt1, Context paramContext, GameLiveAppbrandProcessService paramGameLiveAppbrandProcessService, int paramInt2, b.b paramb)
  {
    AppMethodBeat.i(277387);
    kotlin.g.b.s.u(paramString, "$appId");
    kotlin.g.b.s.u(paramContext, "$context");
    kotlin.g.b.s.u(paramGameLiveAppbrandProcessService, "this$0");
    Log.i("MicroMsg.GameLiveAppbrandProcessService", "zbql:exitGameLive from js or menu");
    if (((PluginGameLive)com.tencent.mm.kernel.h.az(PluginGameLive.class)).isGameLiving(paramString, paramInt1).booleanValue())
    {
      com.tencent.mm.ui.widget.a.f localf = new com.tencent.mm.ui.widget.a.f(paramContext, 1, false);
      localf.sRz = true;
      localf.Vtg = new GameLiveAppbrandProcessService..ExternalSyntheticLambda13(paramContext);
      localf.GAC = new GameLiveAppbrandProcessService..ExternalSyntheticLambda16(paramGameLiveAppbrandProcessService, paramString, paramContext, paramInt2, paramb);
      localf.ages = new GameLiveAppbrandProcessService..ExternalSyntheticLambda18(paramb);
      localf.dDn();
    }
    AppMethodBeat.o(277387);
  }
  
  private final void a(String paramString, Context paramContext, boolean paramBoolean)
  {
    int i = 1;
    AppMethodBeat.i(277282);
    this.JcP = true;
    ((PluginGameLive)com.tencent.mm.kernel.h.az(PluginGameLive.class)).resetCrashCheckParam$plugin_gamelive_release();
    fIG();
    if (paramBoolean) {}
    for (;;)
    {
      com.tencent.mm.plugin.appbrand.ipc.a.a(paramContext, (AppBrandProxyUIProcessTask.ProcessRequest)new GameLiveAppbrandProcessService.EnterFinderLiveRequest(paramString, 0, c.JcZ.ordinal(), i, null, null, 50), GameLiveAppbrandProcessService..ExternalSyntheticLambda8.INSTANCE);
      AppMethodBeat.o(277282);
      return;
      i = 0;
    }
  }
  
  private static final void b(Context paramContext, com.tencent.mm.ui.base.s params)
  {
    AppMethodBeat.i(277334);
    kotlin.g.b.s.u(paramContext, "$context");
    params.a(0, com.tencent.mm.cd.a.w(paramContext, e.a.red_text_color), (CharSequence)com.tencent.mm.cd.a.bt(paramContext, e.c.appbrand_gamelive_end_live));
    AppMethodBeat.o(277334);
  }
  
  private static final void b(w paramw, Context paramContext, String paramString, int paramInt)
  {
    AppMethodBeat.i(277313);
    kotlin.g.b.s.u(paramw, "$appbrandRuntime");
    kotlin.g.b.s.u(paramContext, "$context");
    kotlin.g.b.s.u(paramString, "$appId");
    ((q)paramw.ccO().getJsRuntime().Z(q.class)).post(new GameLiveAppbrandProcessService..ExternalSyntheticLambda20(paramw, paramContext, paramString, paramInt));
    AppMethodBeat.o(277313);
  }
  
  private static final void b(GameLiveAppbrandProcessService.EnterFinderLiveResult paramEnterFinderLiveResult) {}
  
  private static final void c(Context paramContext, com.tencent.mm.ui.base.s params)
  {
    AppMethodBeat.i(277338);
    kotlin.g.b.s.u(paramContext, "$context");
    params.a(0, com.tencent.mm.cd.a.w(paramContext, e.a.red_text_color), (CharSequence)com.tencent.mm.cd.a.bt(paramContext, e.c.Jeq));
    AppMethodBeat.o(277338);
  }
  
  private static final void c(GameLiveAppbrandProcessService.EnterFinderLiveResult paramEnterFinderLiveResult) {}
  
  private static final void d(Context paramContext, com.tencent.mm.ui.base.s params)
  {
    AppMethodBeat.i(277358);
    kotlin.g.b.s.u(paramContext, "$context");
    params.a(0, com.tencent.mm.cd.a.w(paramContext, e.a.red_text_color), (CharSequence)com.tencent.mm.cd.a.bt(paramContext, e.c.Jeq));
    AppMethodBeat.o(277358);
  }
  
  private static final void d(GameLiveAppbrandProcessService.EnterFinderLiveResult paramEnterFinderLiveResult) {}
  
  private static final void e(GameLiveAppbrandProcessService.EnterFinderLiveResult paramEnterFinderLiveResult) {}
  
  private static final void f(GameLiveAppbrandProcessService.EnterFinderLiveResult paramEnterFinderLiveResult) {}
  
  private final void fIG()
  {
    AppMethodBeat.i(277287);
    if (!((PluginGameLive)com.tencent.mm.kernel.h.az(PluginGameLive.class)).isPushing$plugin_gamelive_release())
    {
      Log.i("MicroMsg.GameLiveAppbrandProcessService", "stopPushing: isNotPushing return");
      AppMethodBeat.o(277287);
      return;
    }
    ((PluginGameLive)com.tencent.mm.kernel.h.az(PluginGameLive.class)).setPushing$plugin_gamelive_release(false);
    b.g localg = this.JcL;
    if (localg != null) {
      localg.af(GameLiveAppbrandProcessService..ExternalSyntheticLambda23.INSTANCE);
    }
    AppMethodBeat.o(277287);
  }
  
  private static final void fIJ()
  {
    AppMethodBeat.i(277426);
    ((PluginGameLive)com.tencent.mm.kernel.h.az(PluginGameLive.class)).getAppbrandProcessRenderService$plugin_gamelive_release();
    XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, new PluginGameLive.IPCLiveControlData(PluginGameLive.IPCLiveControlData.b.JdF, null, null, 14), PluginGameLive.c.class, GameLiveAppbrandProcessService..ExternalSyntheticLambda4.INSTANCE);
    AppMethodBeat.o(277426);
  }
  
  public final void a(Context paramContext, String paramString, int paramInt, Runnable paramRunnable)
  {
    AppMethodBeat.i(277665);
    kotlin.g.b.s.u(paramContext, "context");
    kotlin.g.b.s.u(paramString, "appId");
    kotlin.g.b.s.u(paramRunnable, "closeRunnable");
    if ((!((PluginGameLive)com.tencent.mm.kernel.h.az(PluginGameLive.class)).isGameLiving(paramString, paramInt).booleanValue()) || (this.JcN))
    {
      paramRunnable.run();
      AppMethodBeat.o(277665);
      return;
    }
    com.tencent.mm.ui.widget.a.f localf = new com.tencent.mm.ui.widget.a.f(paramContext, 1, true);
    localf.sRz = true;
    localf.Vtg = new GameLiveAppbrandProcessService..ExternalSyntheticLambda14(paramContext);
    localf.GAC = new GameLiveAppbrandProcessService..ExternalSyntheticLambda15(paramContext, this, paramString, paramRunnable);
    localf.ageZ = true;
    localf.h((CharSequence)com.tencent.mm.cd.a.bt(paramContext, e.c.Jer), 17, com.tencent.mm.cd.a.fromDPToPix(paramContext, 14));
    localf.dDn();
    AppMethodBeat.o(277665);
  }
  
  public final void a(Context paramContext, String paramString, int paramInt, JSONObject paramJSONObject, b.a parama)
  {
    AppMethodBeat.i(277656);
    kotlin.g.b.s.u(paramContext, "context");
    kotlin.g.b.s.u(paramString, "appId");
    if (!((PluginGameLive)com.tencent.mm.kernel.h.az(PluginGameLive.class)).isGameLiving(paramString, paramInt).booleanValue())
    {
      Log.e("MicroMsg.GameLiveAppbrandProcessService", "startPlayGameAnchorSetting failed, not gameliving");
      AppMethodBeat.o(277656);
      return;
    }
    com.tencent.threadpool.h.ahAA.bk(new GameLiveAppbrandProcessService..ExternalSyntheticLambda21(this, paramContext, paramJSONObject, paramString, paramInt, parama));
    AppMethodBeat.o(277656);
  }
  
  public final void a(b.c paramc)
  {
    AppMethodBeat.i(277760);
    XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, new PluginGameLive.IPCLiveControlData(PluginGameLive.IPCLiveControlData.b.JdM, null, null, 14), PluginGameLive.c.class, new GameLiveAppbrandProcessService..ExternalSyntheticLambda1(paramc));
    AppMethodBeat.o(277760);
  }
  
  public final void a(b.d paramd)
  {
    AppMethodBeat.i(277752);
    kotlin.g.b.s.u(paramd, "callback1");
    XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, new PluginGameLive.IPCLiveControlData(PluginGameLive.IPCLiveControlData.b.JdL, null, null, 14), PluginGameLive.c.class, new GameLiveAppbrandProcessService..ExternalSyntheticLambda2(paramd));
    AppMethodBeat.o(277752);
  }
  
  public final void a(b.g paramg)
  {
    this.JcL = paramg;
  }
  
  public final void a(GameLiveAppbrandEventService.LiveCommentWrapperInfoPayload paramLiveCommentWrapperInfoPayload)
  {
    AppMethodBeat.i(277727);
    kotlin.g.b.s.u(paramLiveCommentWrapperInfoPayload, "liveCommentWrapperInfoPayload");
    Object localObject1 = this.JcM;
    if (localObject1 != null)
    {
      kotlin.g.b.s.u(paramLiveCommentWrapperInfoPayload, "liveCommentInfoPayload");
      localObject1 = ((GameLiveAppbrandEventService)localObject1).qxC;
      if (localObject1 != null)
      {
        GameLiveAppbrandEventService.b localb = GameLiveAppbrandEventService.b.Jfl;
        List localList = (List)new ArrayList();
        Object localObject2 = paramLiveCommentWrapperInfoPayload.EgE;
        if ((localObject2 != null) && (((List)localObject2).size() == 0)) {}
        for (int i = 1; i == 0; i = 0)
        {
          localObject2 = paramLiveCommentWrapperInfoPayload.EgE;
          kotlin.g.b.s.checkNotNull(localObject2);
          localObject2 = ((List)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            GameLiveAppbrandEventService.LiveSingleCommentPayload localLiveSingleCommentPayload = (GameLiveAppbrandEventService.LiveSingleCommentPayload)((Iterator)localObject2).next();
            localList.add(ak.e(new r[] { v.Y("msgType", localLiveSingleCommentPayload.JfA), v.Y("senderNickName", localLiveSingleCommentPayload.JfB), v.Y("senderHeadImgUrl", localLiveSingleCommentPayload.JfC), v.Y("content", localLiveSingleCommentPayload.content), v.Y("msgCreateTime", localLiveSingleCommentPayload.JfD), v.Y("msgSeq", localLiveSingleCommentPayload.JfE), v.Y("comboRewardCount", localLiveSingleCommentPayload.JfF), v.Y("rankingPosition", localLiveSingleCommentPayload.JfG), v.Y("rewardProduectId", localLiveSingleCommentPayload.JfH), v.Y("rewardThumbUrl", localLiveSingleCommentPayload.JfI), v.Y("rewardName", localLiveSingleCommentPayload.DKv), v.Y("rewardAmount", Integer.valueOf(localLiveSingleCommentPayload.JfJ)) }));
          }
        }
        paramLiveCommentWrapperInfoPayload = ak.e(new r[] { v.Y("liveId", Long.valueOf(paramLiveCommentWrapperInfoPayload.liveId)), v.Y("currOnlineCount", Long.valueOf(paramLiveCommentWrapperInfoPayload.Jfo)), v.Y("totalViewCount", Long.valueOf(paramLiveCommentWrapperInfoPayload.Jfp)), v.Y("currLikeCount", Long.valueOf(paramLiveCommentWrapperInfoPayload.Jfq)), v.Y("totalRewardCount", Long.valueOf(paramLiveCommentWrapperInfoPayload.Jfr)), v.Y("msgList", localList) });
        Log.i("GameLiveAppbrandEventService", "send LiveComment event,info list size:%d", new Object[] { Integer.valueOf(localList.size()) });
        localb.h((com.tencent.mm.plugin.appbrand.jsapi.f)((w)localObject1).ccO()).K(paramLiveCommentWrapperInfoPayload);
        localb.cpV();
      }
    }
    AppMethodBeat.o(277727);
  }
  
  public final void a(Object paramObject, Context paramContext, String paramString, int paramInt)
  {
    AppMethodBeat.i(277633);
    kotlin.g.b.s.u(paramObject, "runtime");
    kotlin.g.b.s.u(paramContext, "context");
    kotlin.g.b.s.u(paramString, "appId");
    Log.i("MicroMsg.GameLiveAppbrandProcessService", "zbql:onAppbrandEnterForeground");
    PluginGameLive localPluginGameLive = (PluginGameLive)com.tencent.mm.kernel.h.az(PluginGameLive.class);
    w localw = (w)paramObject;
    if (!localPluginGameLive.isGameLiving(paramString, paramInt).booleanValue())
    {
      paramObject = localw.ccK();
      if (paramObject == null) {}
      for (paramObject = null;; paramObject = (d)paramObject.aa(d.class))
      {
        if (paramObject != null) {
          paramObject.apR();
        }
        paramObject = this.JcM;
        if (paramObject != null) {
          paramObject.qxC = null;
        }
        this.JcM = null;
        Log.i("MicroMsg.GameLiveAppbrandProcessService", "zbql:onAppbrandEnterForeground not gameLiving,return");
        AppMethodBeat.o(277633);
        return;
      }
    }
    this.JcM = new GameLiveAppbrandEventService(localw);
    paramObject = localPluginGameLive.getGameLiveCurrentState_$plugin_gamelive_release();
    int i;
    if (paramObject == null)
    {
      i = -1;
      switch (i)
      {
      default: 
        paramObject = localPluginGameLive.getGameLiveCurrentState_$plugin_gamelive_release();
        if (paramObject == null) {
          paramObject = null;
        }
        break;
      }
    }
    for (;;)
    {
      Log.e("MicroMsg.GameLiveAppbrandProcessService", "gameLiving onAppbrandEnterForeground,but state is wrong,state:%s", new Object[] { paramObject });
      this.JcN = false;
      XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, new PluginGameLive.IPCLiveControlData(PluginGameLive.IPCLiveControlData.b.JdH, paramString, null, 12), PluginGameLive.c.class, null);
      this.JcP = false;
      AppMethodBeat.o(277633);
      return;
      i = d.$EnumSwitchMapping$0[paramObject.ordinal()];
      break;
      paramObject = localPluginGameLive.getGameLiveCurrentState_$plugin_gamelive_release();
      if (paramObject == null)
      {
        paramObject = null;
        label287:
        Log.i("MicroMsg.GameLiveAppbrandProcessService", "state %s", new Object[] { paramObject });
        paramObject = ((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.h.baB().bad()).mProcessName;
        kotlin.g.b.s.s(paramObject, "process().current().processName");
        localPluginGameLive.setAppBrandPackageName$plugin_gamelive_release(paramObject);
        paramObject = localPluginGameLive.getGameLivePrepareScene_$plugin_gamelive_release();
        if (paramObject != null) {
          break label412;
        }
        i = -1;
        switch (i)
        {
        default: 
          label343:
          Log.e("MicroMsg.GameLiveAppbrandProcessService", "preparing, the scene is wrong");
        }
      }
      for (;;)
      {
        jj(h.d.tjS.ordinal(), h.c.tjK.ordinal());
        localPluginGameLive.setGameLiveCurrentState_$plugin_gamelive_release(PluginGameLive.b.Jdw);
        break;
        paramObject = paramObject.fIR();
        break label287;
        label412:
        i = d.avl[paramObject.ordinal()];
        break label343;
        Log.i("MicroMsg.GameLiveAppbrandProcessService", "from gamestart");
        com.tencent.mm.plugin.appbrand.ipc.a.a(paramContext, (AppBrandProxyUIProcessTask.ProcessRequest)new GameLiveAppbrandProcessService.EnterFinderLiveRequest(paramString, paramInt, c.JcW.ordinal(), 0, null, null, 56), GameLiveAppbrandProcessService..ExternalSyntheticLambda10.INSTANCE);
        continue;
        com.tencent.threadpool.h.ahAA.o(new GameLiveAppbrandProcessService..ExternalSyntheticLambda19(localw, paramContext, paramString, paramInt), 300L);
      }
      paramObject = localPluginGameLive.getGameLiveCurrentState_$plugin_gamelive_release();
      if (paramObject == null)
      {
        paramObject = null;
        label508:
        Log.i("MicroMsg.GameLiveAppbrandProcessService", "state %s", new Object[] { paramObject });
        XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, new PluginGameLive.IPCLiveControlData(PluginGameLive.IPCLiveControlData.b.JdN, paramString, null, 12), PluginGameLive.c.class, null);
        paramObject = localPluginGameLive.getAppbrandProcessAudioService$plugin_gamelive_release();
        if (paramObject != null) {
          paramObject.resume();
        }
        paramObject = localw.ccK();
        if (paramObject != null) {
          break label697;
        }
      }
      label697:
      for (paramObject = null;; paramObject = (d)paramObject.aa(d.class))
      {
        if (paramObject != null) {
          paramObject.apR();
        }
        if (!((PluginGameLive)com.tencent.mm.kernel.h.az(PluginGameLive.class)).isPushing$plugin_gamelive_release()) {
          break label711;
        }
        Log.i("MicroMsg.GameLiveAppbrandProcessService", "startPush: isPushing return");
        label609:
        if (localPluginGameLive.getGameLiveCurrentState_$plugin_gamelive_release() == PluginGameLive.b.Jdy)
        {
          paramObject = ((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.h.baB().bad()).mProcessName;
          kotlin.g.b.s.s(paramObject, "process().current().getProcessName()");
          localPluginGameLive.setAppBrandPackageName$plugin_gamelive_release(paramObject);
          jj(h.d.tjS.ordinal(), h.c.tjK.ordinal());
          jj(h.d.tjR.ordinal(), h.c.tjK.ordinal());
        }
        localPluginGameLive.setGameLiveCurrentState_$plugin_gamelive_release(PluginGameLive.b.Jdw);
        break;
        paramObject = paramObject.fIR();
        break label508;
      }
      label711:
      Log.i("MicroMsg.GameLiveAppbrandProcessService", "startPush");
      ((PluginGameLive)com.tencent.mm.kernel.h.az(PluginGameLive.class)).setPushing$plugin_gamelive_release(true);
      paramObject = ((PluginGameLive)com.tencent.mm.kernel.h.az(PluginGameLive.class)).getAppbrandProcessAudioService$plugin_gamelive_release();
      if (paramObject != null)
      {
        paramObject.JeC = com.tencent.mm.b.g.getMessageDigest(String.format(Locale.US, "%s%d", new Object[] { "MicroMsgGameLiveAudio", Integer.valueOf(localw.getInitConfig().uin) }).getBytes());
        paramContext = (com.tencent.mm.plugin.appbrand.game.b)localw.ccO().aa(com.tencent.mm.plugin.appbrand.game.b.class);
        Log.i("MicroMsg.GameLiveAppbrandAudioMgrService", "start appbrand audio %s %s", new Object[] { paramContext, paramObject.JeC });
        paramObject.JeB = new WeakReference(paramContext);
        paramObject.orA = false;
        paramObject.Jes.execute(new a.2(paramObject));
        paramObject.Jes.execute(new a.3(paramObject, paramContext));
        if (!((PluginGameLive)com.tencent.mm.kernel.h.az(PluginGameLive.class)).getEnableAudioDebug()) {}
      }
      try
      {
        paramObject.dke = new FileOutputStream(new File("/sdcard/pcm/mix.pcm"));
        label916:
        paramObject.Jex.fIT();
        paramObject.wYi = paramObject.Jey.getStreamVolume(3);
        MMApplicationContext.getContext().getContentResolver().registerContentObserver(Settings.System.CONTENT_URI, true, paramObject.JeA);
        if (!com.tencent.mm.plugin.gamelive.a.a.fIS()) {
          paramObject.EKB.a(MMApplicationContext.getContext(), paramObject);
        }
        ((PluginGameLive)com.tencent.mm.kernel.h.az(PluginGameLive.class)).getAppbrandProcessRenderService$plugin_gamelive_release();
        XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, new PluginGameLive.IPCLiveControlData(PluginGameLive.IPCLiveControlData.b.JdE, null, null, 14), PluginGameLive.c.class, new GameLiveAppbrandProcessService..ExternalSyntheticLambda0(this));
        break label609;
        paramObject = paramObject.fIR();
      }
      catch (FileNotFoundException paramContext)
      {
        break label916;
      }
    }
  }
  
  public final void a(String paramString, int paramInt, Context paramContext)
  {
    AppMethodBeat.i(277746);
    kotlin.g.b.s.u(paramString, "appId");
    kotlin.g.b.s.u(paramContext, "context");
    if (((PluginGameLive)com.tencent.mm.kernel.h.az(PluginGameLive.class)).isGameLiving(paramString, paramInt).booleanValue()) {
      com.tencent.mm.plugin.appbrand.ipc.a.a(paramContext, (AppBrandProxyUIProcessTask.ProcessRequest)new GameLiveAppbrandProcessService.EnterFinderLiveRequest(paramString, 0, c.JcX.ordinal(), 0, null, null, 58), GameLiveAppbrandProcessService..ExternalSyntheticLambda6.INSTANCE);
    }
    AppMethodBeat.o(277746);
  }
  
  public final void a(String paramString, int paramInt1, Context paramContext, int paramInt2, b.b paramb)
  {
    AppMethodBeat.i(277674);
    kotlin.g.b.s.u(paramString, "appId");
    kotlin.g.b.s.u(paramContext, "context");
    com.tencent.threadpool.h.ahAA.bk(new GameLiveAppbrandProcessService..ExternalSyntheticLambda22(paramString, paramInt1, paramContext, this, paramInt2, paramb));
    AppMethodBeat.o(277674);
  }
  
  public final void a(String paramString, int paramInt, Context paramContext, b.f paramf)
  {
    AppMethodBeat.i(277737);
    kotlin.g.b.s.u(paramString, "appId");
    kotlin.g.b.s.u(paramContext, "context");
    this.JcR = paramf;
    if (((PluginGameLive)com.tencent.mm.kernel.h.az(PluginGameLive.class)).isGameLiving(paramString, paramInt).booleanValue()) {
      com.tencent.mm.plugin.appbrand.ipc.a.a(paramContext, (AppBrandProxyUIProcessTask.ProcessRequest)new GameLiveAppbrandProcessService.EnterFinderLiveRequest(paramString, 0, c.JcY.ordinal(), 0, null, null, 58), GameLiveAppbrandProcessService..ExternalSyntheticLambda7.INSTANCE);
    }
    AppMethodBeat.o(277737);
  }
  
  public final void a(String paramString1, int paramInt, Context paramContext, String paramString2, String paramString3)
  {
    AppMethodBeat.i(277651);
    kotlin.g.b.s.u(paramString1, "appId");
    kotlin.g.b.s.u(paramString2, "path");
    kotlin.g.b.s.u(paramString3, "reportInfo");
    com.tencent.mm.plugin.appbrand.ipc.a.a(paramContext, (AppBrandProxyUIProcessTask.ProcessRequest)new GameLiveAppbrandProcessService.EnterFinderLiveRequest(paramString1, paramInt, c.JcV.ordinal(), 0, paramString2, paramString3, 8), new GameLiveAppbrandProcessService..ExternalSyntheticLambda5(paramContext));
    AppMethodBeat.o(277651);
  }
  
  public final void a(String paramString, b.e parame)
  {
    AppMethodBeat.i(277767);
    kotlin.g.b.s.u(paramString, "topic");
    XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, new PluginGameLive.IPCLiveControlData(PluginGameLive.IPCLiveControlData.b.JdV, null, (Parcelable)new GameLiveAppbrandEventService.LiveTopicPayload(paramString, false, null), 6), PluginGameLive.c.class, new GameLiveAppbrandProcessService..ExternalSyntheticLambda3(parame));
    AppMethodBeat.o(277767);
  }
  
  public final void aHH(String paramString)
  {
    AppMethodBeat.i(277691);
    kotlin.g.b.s.u(paramString, "appId");
    this.JcN = true;
    AppMethodBeat.o(277691);
  }
  
  public final void fA(String paramString, int paramInt)
  {
    AppMethodBeat.i(277646);
    kotlin.g.b.s.u(paramString, "appId");
    if (!((PluginGameLive)com.tencent.mm.kernel.h.az(PluginGameLive.class)).isGameLiving(paramString, paramInt).booleanValue())
    {
      AppMethodBeat.o(277646);
      return;
    }
    ((PluginGameLive)com.tencent.mm.kernel.h.az(PluginGameLive.class)).setGameLiveCurrentState_$plugin_gamelive_release(PluginGameLive.b.Jdy);
    fIG();
    AppMethodBeat.o(277646);
  }
  
  public final void fIF()
  {
    AppMethodBeat.i(277696);
    XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, new PluginGameLive.IPCLiveControlData(PluginGameLive.IPCLiveControlData.b.JdD, null, null, 14), PluginGameLive.c.class, null);
    AppMethodBeat.o(277696);
  }
  
  public final void fIH()
  {
    this.JcL = null;
  }
  
  public final Boolean fII()
  {
    AppMethodBeat.i(277732);
    boolean bool = this.JcO;
    AppMethodBeat.o(277732);
    return Boolean.valueOf(bool);
  }
  
  public final void g(String paramString, Context paramContext)
  {
    AppMethodBeat.i(277684);
    kotlin.g.b.s.u(paramString, "appId");
    kotlin.g.b.s.u(paramContext, "context");
    com.tencent.mm.plugin.appbrand.ipc.a.a(paramContext, (AppBrandProxyUIProcessTask.ProcessRequest)new GameLiveAppbrandProcessService.EnterFinderLiveRequest(paramString, 0, c.Jda.ordinal(), 0, null, null, 58), GameLiveAppbrandProcessService..ExternalSyntheticLambda9.INSTANCE);
    AppMethodBeat.o(277684);
  }
  
  public final void jj(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(277719);
    Object localObject1 = this.JcM;
    if (localObject1 != null)
    {
      Object localObject2 = ((GameLiveAppbrandEventService)localObject1).qxC;
      if (localObject2 != null)
      {
        localObject1 = h.b.tjJ;
        ((h.b)localObject1).h((com.tencent.mm.plugin.appbrand.jsapi.f)((w)localObject2).ccO()).K(ak.e(new r[] { v.Y("event", Integer.valueOf(paramInt1)), v.Y("reason", Integer.valueOf(paramInt2)) }));
        Log.i("GameLiveAppbrandEventService", "zbql: send Event:" + paramInt1 + ",reason:" + paramInt2);
        if (paramInt1 == h.d.tjR.ordinal())
        {
          localObject2 = (PluginGameLive)com.tencent.mm.kernel.h.az(PluginGameLive.class);
          Map localMap = ak.e(new r[] { v.Y("nickname", ((PluginGameLive)localObject2).getGameLiveNickname$plugin_gamelive_release()), v.Y("headerUrl", ((PluginGameLive)localObject2).getGameLiveAnchorHeadUrl$plugin_gamelive_release()), v.Y("joinLiveTips", ((PluginGameLive)localObject2).getGameLiveJoinLiveTips$plugin_gamelive_release()), v.Y("liveId", Long.valueOf(((PluginGameLive)localObject2).getGameLiveLiveId$plugin_gamelive_release())), v.Y("finderUsername", ((PluginGameLive)localObject2).getGameLiveFinderUsrName$plugin_gamelive_release()), v.Y("wxaGameExportId", ((PluginGameLive)localObject2).getWxaGameExportId$plugin_gamelive_release()) });
          Log.i("GameLiveAppbrandEventService", "zbql: start Event,nickname:%s,blabla", new Object[] { ((PluginGameLive)localObject2).getGameLiveNickname$plugin_gamelive_release() });
          ((h.b)localObject1).w("extra", localMap);
        }
        ((h.b)localObject1).cpV();
      }
    }
    AppMethodBeat.o(277719);
  }
  
  public final void n(Context paramContext, String paramString, int paramInt)
  {
    AppMethodBeat.i(277640);
    kotlin.g.b.s.u(paramContext, "context");
    kotlin.g.b.s.u(paramString, "appId");
    Log.i("MicroMsg.GameLiveAppbrandProcessService", "zbql:onAppbrandEnterBackGround");
    if (((PluginGameLive)com.tencent.mm.kernel.h.az(PluginGameLive.class)).isGameLiving(paramString, paramInt).booleanValue())
    {
      XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, new PluginGameLive.IPCLiveControlData(PluginGameLive.IPCLiveControlData.b.JdG, paramString, null, 12), PluginGameLive.c.class, null);
      paramContext = ((PluginGameLive)com.tencent.mm.kernel.h.az(PluginGameLive.class)).getAppbrandProcessAudioService$plugin_gamelive_release();
      if (paramContext != null) {
        paramContext.pause();
      }
      if (!this.JcP) {
        XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, new PluginGameLive.IPCLiveControlData(PluginGameLive.IPCLiveControlData.b.JdO, paramString, null, 12), PluginGameLive.c.class, null);
      }
      ((PluginGameLive)com.tencent.mm.kernel.h.az(PluginGameLive.class)).setGameLiveCurrentState_$plugin_gamelive_release(PluginGameLive.b.Jdx);
    }
    AppMethodBeat.o(277640);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/gamelive/GameLiveAppbrandProcessService$EnterFinderLiveTask;", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask;", "()V", "TAG", "", "handleRequest", "", "request", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask$ProcessRequest;", "mmOnActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "plugin-gamelive_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends AppBrandProxyUIProcessTask
  {
    private final String TAG = "MicroMsg.GameLive.EnterFinderLiveTask";
    
    public final void handleRequest(final AppBrandProxyUIProcessTask.ProcessRequest paramProcessRequest)
    {
      AppMethodBeat.i(277252);
      if (!(paramProcessRequest instanceof GameLiveAppbrandProcessService.EnterFinderLiveRequest))
      {
        Log.w(this.TAG, "handleRequest#EnterFinderTask, request is not EnterFinderRequest");
        AppMethodBeat.o(277252);
        return;
      }
      Log.i(this.TAG, kotlin.g.b.s.X("handleRequest appid ", ((GameLiveAppbrandProcessService.EnterFinderLiveRequest)paramProcessRequest).appid));
      int i = ((GameLiveAppbrandProcessService.EnterFinderLiveRequest)paramProcessRequest).action;
      MMActivity localMMActivity;
      if (i == GameLiveAppbrandProcessService.c.JcV.ordinal())
      {
        if (!((com.tencent.d.a.a.a.b)com.tencent.mm.kernel.h.az(com.tencent.d.a.a.a.b.class)).isAnchorLiving())
        {
          if (((PluginGameLive)com.tencent.mm.kernel.h.az(PluginGameLive.class)).getOnLivingStatusForCrashCheckTemp$plugin_gamelive_release())
          {
            Log.i(this.TAG, "try to startGame, but in crash state, decide to recover");
            ((com.tencent.d.a.a.a.b)com.tencent.mm.kernel.h.az(com.tencent.d.a.a.a.b.class)).checkLastLiveObject((Context)getActivityContext(), (kotlin.g.a.b)new a(this, paramProcessRequest));
            AppMethodBeat.o(277252);
            return;
          }
          Log.i(this.TAG, "startGame");
          if (((PluginGameLive)com.tencent.mm.kernel.h.az(PluginGameLive.class)).getMainProcessService$plugin_gamelive_release() != null)
          {
            localMMActivity = getActivityContext();
            kotlin.g.b.s.s(localMMActivity, "activityContext");
            a.c((Context)localMMActivity, ((GameLiveAppbrandProcessService.EnterFinderLiveRequest)paramProcessRequest).appid, ((GameLiveAppbrandProcessService.EnterFinderLiveRequest)paramProcessRequest).euz, ((GameLiveAppbrandProcessService.EnterFinderLiveRequest)paramProcessRequest).path, ((GameLiveAppbrandProcessService.EnterFinderLiveRequest)paramProcessRequest).mxQ);
          }
          finishProcess((AppBrandProxyUIProcessTask.ProcessResult)new GameLiveAppbrandProcessService.EnterFinderLiveResult(0));
          AppMethodBeat.o(277252);
          return;
        }
        Log.i(this.TAG, "try to startGame,but isAnchorLiving,finishProcess with error");
        finishProcess((AppBrandProxyUIProcessTask.ProcessResult)new GameLiveAppbrandProcessService.EnterFinderLiveResult(1));
        AppMethodBeat.o(277252);
        return;
      }
      if (i == GameLiveAppbrandProcessService.c.JcW.ordinal())
      {
        paramProcessRequest = (com.tencent.d.a.a.a.b)com.tencent.mm.kernel.h.az(com.tencent.d.a.a.a.b.class);
        localMMActivity = getActivityContext();
        kotlin.g.b.s.s(localMMActivity, "activityContext");
        paramProcessRequest.enterFinderLiveCountDownUI((Context)localMMActivity);
        finishProcess((AppBrandProxyUIProcessTask.ProcessResult)new GameLiveAppbrandProcessService.EnterFinderLiveResult(0));
        AppMethodBeat.o(277252);
        return;
      }
      if (i == GameLiveAppbrandProcessService.c.JcX.ordinal())
      {
        paramProcessRequest = (com.tencent.d.a.a.a.b)com.tencent.mm.kernel.h.az(com.tencent.d.a.a.a.b.class);
        localMMActivity = getActivityContext();
        kotlin.g.b.s.s(localMMActivity, "activityContext");
        paramProcessRequest.shareLiveToSns((AppCompatActivity)localMMActivity);
        finishProcess((AppBrandProxyUIProcessTask.ProcessResult)new GameLiveAppbrandProcessService.EnterFinderLiveResult(0));
        AppMethodBeat.o(277252);
        return;
      }
      if (i == GameLiveAppbrandProcessService.c.JcY.ordinal())
      {
        getActivityContext().mmSetOnActivityResultCallback((MMActivity.a)this);
        paramProcessRequest = (com.tencent.d.a.a.a.b)com.tencent.mm.kernel.h.az(com.tencent.d.a.a.a.b.class);
        localMMActivity = getActivityContext();
        kotlin.g.b.s.s(localMMActivity, "activityContext");
        paramProcessRequest.shareLiveToFriend((AppCompatActivity)localMMActivity);
        AppMethodBeat.o(277252);
        return;
      }
      if (i == GameLiveAppbrandProcessService.c.JcZ.ordinal())
      {
        if (((GameLiveAppbrandProcessService.EnterFinderLiveRequest)paramProcessRequest).JcS == 1) {}
        for (boolean bool = true;; bool = false)
        {
          ((com.tencent.d.a.a.a.b)com.tencent.mm.kernel.h.az(com.tencent.d.a.a.a.b.class)).backToFinderLiveAnchorUIOnExternalLive((Context)getActivityContext(), true, bool);
          ((PluginGameLive)com.tencent.mm.kernel.h.az(PluginGameLive.class)).resetState$plugin_gamelive_release();
          finishProcess((AppBrandProxyUIProcessTask.ProcessResult)new GameLiveAppbrandProcessService.EnterFinderLiveResult(0));
          AppMethodBeat.o(277252);
          return;
        }
      }
      if (i == GameLiveAppbrandProcessService.c.Jda.ordinal())
      {
        ((com.tencent.d.a.a.a.b)com.tencent.mm.kernel.h.az(com.tencent.d.a.a.a.b.class)).backToFinderLiveAnchorUIOnExternalLive((Context)getActivityContext(), false, false);
        finishProcess((AppBrandProxyUIProcessTask.ProcessResult)new GameLiveAppbrandProcessService.EnterFinderLiveResult(0));
      }
      AppMethodBeat.o(277252);
    }
    
    public final void mmOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
    {
      AppMethodBeat.i(277259);
      super.mmOnActivityResult(paramInt1, paramInt2, paramIntent);
      finishProcess((AppBrandProxyUIProcessTask.ProcessResult)new GameLiveAppbrandProcessService.EnterFinderLiveResult(0));
      AppMethodBeat.o(277259);
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "it", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements kotlin.g.a.b<Boolean, kotlin.ah>
    {
      a(GameLiveAppbrandProcessService.b paramb, AppBrandProxyUIProcessTask.ProcessRequest paramProcessRequest)
      {
        super();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/gamelive/GameLiveAppbrandProcessService$FinderLiveControlAction;", "", "(Ljava/lang/String;I)V", "FinderLiveControlActionStartGameLive", "FinderLiveControlActionShowCountDownActivity", "FinderLiveControlActionShareToSNS", "FinderLiveControlActionShareToFriend", "FinderLiveControlActionStopGameLive", "FinderLiveControlActionEnterGameLiveRoom", "plugin-gamelive_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum c
  {
    static
    {
      AppMethodBeat.i(277233);
      JcV = new c("FinderLiveControlActionStartGameLive", 0);
      JcW = new c("FinderLiveControlActionShowCountDownActivity", 1);
      JcX = new c("FinderLiveControlActionShareToSNS", 2);
      JcY = new c("FinderLiveControlActionShareToFriend", 3);
      JcZ = new c("FinderLiveControlActionStopGameLive", 4);
      Jda = new c("FinderLiveControlActionEnterGameLiveRoom", 5);
      Jdb = new c[] { JcV, JcW, JcX, JcY, JcZ, Jda };
      AppMethodBeat.o(277233);
    }
    
    private c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelive.GameLiveAppbrandProcessService
 * JD-Core Version:    0.7.0.1
 */