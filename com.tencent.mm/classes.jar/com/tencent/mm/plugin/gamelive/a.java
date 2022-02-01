package com.tencent.mm.plugin.gamelive;

import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Parcelable;
import com.tencent.d.a.a.a.b.e;
import com.tencent.d.a.a.a.b.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.appbrand.menu.h.c;
import com.tencent.mm.plugin.appbrand.menu.h.d;
import com.tencent.mm.plugin.gamelive.a.d;
import com.tencent.mm.plugin.gamelive.event.GameLiveAppbrandEventService.LiveCommentWrapperInfoPayload;
import com.tencent.mm.plugin.gamelive.event.GameLiveAppbrandEventService.LiveMemberInfoListPayload;
import com.tencent.mm.plugin.gamelive.event.GameLiveAppbrandEventService.LiveMemberInfoPayload;
import com.tencent.mm.plugin.gamelive.event.GameLiveAppbrandEventService.LiveNetWorkPayload;
import com.tencent.mm.plugin.gamelive.event.GameLiveAppbrandEventService.LivePlayGamePayLoad;
import com.tencent.mm.plugin.gamelive.event.GameLiveAppbrandEventService.LiveSingleCommentPayload;
import com.tencent.mm.plugin.gamelive.event.GameLiveAppbrandEventService.LiveTopicPayload;
import com.tencent.mm.plugin.gamelive.event.GameLiveAppbrandEventService.SimpleLiveStateChangePayload;
import com.tencent.mm.plugin.gamelive.service.GameLiveForegroundService;
import com.tencent.mm.protocal.protobuf.bgt;
import com.tencent.mm.protocal.protobuf.bjk;
import com.tencent.mm.protocal.protobuf.dld;
import com.tencent.mm.protocal.protobuf.dle;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.a.ak;
import kotlin.g.b.s;
import kotlin.r;
import kotlin.v;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/gamelive/GameLiveMainProcessService;", "Lcom/tencent/mm/plugin/gamelive/IGameLiveMainProcessService;", "()V", "callBack", "Lcom/tencent/plugin/finder/live/api/IExternalLiveCallback;", "getCallBack", "()Lcom/tencent/plugin/finder/live/api/IExternalLiveCallback;", "foregroundServiceActive", "", "isRegistered", "muteMic", "activateForegroundService", "", "activate", "disableAudio", "enableAudio", "enableVoiceCapture", "enable", "getCurrentRoomInfo", "", "", "getCurrentRoomInfo$plugin_gamelive_release", "getMemberList", "callback", "Lcom/tencent/mm/plugin/gamelive/GameLiveMainProcessService$IGetMemberListCallback;", "getMemberList$plugin_gamelive_release", "getStartData", "hideMinimizeGameLive", "launchWAGameForFinderLive", "context", "Landroid/content/Context;", "appId", "versionType", "", "isFirstLaunch", "isFromWeApp", "liveId", "", "makeSceneNote", "minimizeGameLive", "pauseLive", "registerFinderLiveCallback", "reportPlayGamePanelShowAction", "payload", "Lcom/tencent/mm/plugin/gamelive/event/GameLiveAppbrandEventService$LivePlayGamePayLoad;", "reportPlayGamePanelShowAction$plugin_gamelive_release", "resumeGameLiveFromCrash", "resumeLive", "sendIPCEventToAppBrand", "action", "Lcom/tencent/mm/plugin/gamelive/PluginGameLive$IPCLiveControlData$IPCLiveControlAction;", "event", "reason", "sendVolumnCallBackDuration", "duration", "setTopic", "topic", "Lcom/tencent/mm/plugin/gamelive/event/GameLiveAppbrandEventService$LiveTopicPayload;", "Lcom/tencent/mm/plugin/gamelive/GameLiveMainProcessService$ISetTopicCallback;", "startGameLive", "ingnoreContinueLive", "path", "reportInfo", "startPlayGameAnchorSetting", "Lcom/tencent/plugin/finder/live/api/IPluginFinderLive$IGameLiveActionCallBack;", "startPlayGameAnchorSetting$plugin_gamelive_release", "startPush", "stopPush", "unRegisterFinderLiveCallback", "Companion", "IGetMemberListCallback", "ISetTopicCallback", "plugin-gamelive_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  implements c
{
  public static final a.a Jdc;
  boolean Eem;
  private boolean Jdd;
  private final com.tencent.d.a.a.a.a Jde;
  private boolean isRegistered;
  
  static
  {
    AppMethodBeat.i(277305);
    Jdc = new a.a((byte)0);
    AppMethodBeat.o(277305);
  }
  
  public a()
  {
    AppMethodBeat.i(277223);
    this.Jde = ((com.tencent.d.a.a.a.a)new d(this));
    AppMethodBeat.o(277223);
  }
  
  public static void XX(int paramInt)
  {
    AppMethodBeat.i(277232);
    ((com.tencent.d.a.a.a.b)h.az(com.tencent.d.a.a.a.b.class)).enableAudioVolumeEvaluation(paramInt);
    AppMethodBeat.o(277232);
  }
  
  public static void a(PluginGameLive.IPCLiveControlData.b paramb, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(277281);
    s.u(paramb, "action");
    XIPCInvoker.a(((PluginGameLive)h.az(PluginGameLive.class)).getAppBrandPackageName$plugin_gamelive_release(), new PluginGameLive.IPCLiveControlData(paramb, null, (Parcelable)new GameLiveAppbrandEventService.SimpleLiveStateChangePayload(ak.e(new r[] { v.Y("event", Integer.valueOf(paramInt1)), v.Y("reason", Integer.valueOf(paramInt2)) })), 6), PluginGameLive.c.class, null);
    AppMethodBeat.o(277281);
  }
  
  public static void a(b paramb)
  {
    AppMethodBeat.i(277284);
    s.u(paramb, "callback");
    ((com.tencent.d.a.a.a.b)h.az(com.tencent.d.a.a.a.b.class)).getFinderLiveMemberListInfo(new a..ExternalSyntheticLambda0(paramb));
    AppMethodBeat.o(277284);
  }
  
  private static final void a(b paramb, List paramList)
  {
    AppMethodBeat.i(277302);
    s.u(paramb, "$callback");
    if (paramList == null)
    {
      paramb = new NullPointerException("null cannot be cast to non-null type kotlin.collections.List<com.tencent.mm.protocal.protobuf.FinderLiveMemberListInfo>");
      AppMethodBeat.o(277302);
      throw paramb;
    }
    List localList = (List)new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      bjk localbjk = (bjk)paramList.next();
      GameLiveAppbrandEventService.LiveMemberInfoPayload localLiveMemberInfoPayload = new GameLiveAppbrandEventService.LiveMemberInfoPayload();
      localLiveMemberInfoPayload.nickname = localbjk.nickname;
      localLiveMemberInfoPayload.Jfs = localbjk.Jfs;
      localList.add(localLiveMemberInfoPayload);
    }
    paramList = new GameLiveAppbrandEventService.LiveMemberInfoListPayload();
    paramList.EgE = localList;
    paramb.a(paramList);
    AppMethodBeat.o(277302);
  }
  
  public static void a(GameLiveAppbrandEventService.LivePlayGamePayLoad paramLivePlayGamePayLoad)
  {
    AppMethodBeat.i(277246);
    s.u(paramLivePlayGamePayLoad, "payload");
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("appid", paramLivePlayGamePayLoad.appid);
    localJSONObject.put("sourceid", paramLivePlayGamePayLoad.Jfz);
    localJSONObject.put("type", paramLivePlayGamePayLoad.type);
    localJSONObject.put("gametype", 1);
    ((com.tencent.d.a.a.a.b)h.az(com.tencent.d.a.a.a.b.class)).reportPlayGamePanelShowAction(localJSONObject);
    AppMethodBeat.o(277246);
  }
  
  public static void a(GameLiveAppbrandEventService.LivePlayGamePayLoad paramLivePlayGamePayLoad, b.e parame)
  {
    AppMethodBeat.i(277240);
    s.u(paramLivePlayGamePayLoad, "payload");
    s.u(parame, "callback");
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("join_team_mode", paramLivePlayGamePayLoad.Jfv);
    localJSONObject.put("title", paramLivePlayGamePayLoad.title);
    localJSONObject.put("teamup_desc", paramLivePlayGamePayLoad.Jfw);
    localJSONObject.put("member_desc", paramLivePlayGamePayLoad.Jfx);
    localJSONObject.put("teamup_extra_data", paramLivePlayGamePayLoad.Jfy);
    localJSONObject.put("appid", paramLivePlayGamePayLoad.appid);
    localJSONObject.put("versionType", paramLivePlayGamePayLoad.euz);
    localJSONObject.put("path", paramLivePlayGamePayLoad.path);
    localJSONObject.put("sourceid", paramLivePlayGamePayLoad.Jfz);
    ((com.tencent.d.a.a.a.b)h.az(com.tencent.d.a.a.a.b.class)).startPlayGameAnchorSetting(localJSONObject, parame);
    AppMethodBeat.o(277240);
  }
  
  public static void a(GameLiveAppbrandEventService.LiveTopicPayload paramLiveTopicPayload, a.c paramc)
  {
    AppMethodBeat.i(277297);
    s.u(paramLiveTopicPayload, "topic");
    s.u(paramc, "callback");
    ((com.tencent.d.a.a.a.b)h.az(com.tencent.d.a.a.a.b.class)).setTopic(paramLiveTopicPayload.topic, (b.f)new a.e(paramc));
    AppMethodBeat.o(277297);
  }
  
  public static void c(Context paramContext, String paramString1, int paramInt, String paramString2, String paramString3)
  {
    AppMethodBeat.i(277271);
    s.u(paramContext, "context");
    s.u(paramString1, "appId");
    s.u(paramString2, "path");
    s.u(paramString3, "reportInfo");
    ((PluginGameLive)h.az(PluginGameLive.class)).startGameLivePrepare$plugin_gamelive_release();
    ((com.tencent.d.a.a.a.b)h.az(com.tencent.d.a.a.a.b.class)).enterFinderGameLivePostVerifyUI(paramContext, paramString1, paramInt, true, paramString2, paramString3);
    AppMethodBeat.o(277271);
  }
  
  public static void cpa()
  {
    AppMethodBeat.i(277256);
    Log.i("MicroMsg.GameLiveMainProcessService", "start push");
    Object localObject = ((PluginGameLive)h.az(PluginGameLive.class)).getMainProcessRenderService$plugin_gamelive_release();
    if (localObject != null)
    {
      Log.i("MicroMsg.GameLiveMainRenderMgrService", "start main process render");
      com.tencent.mm.plugin.gamelive.render.b.wE(true);
      ((com.tencent.mm.plugin.gamelive.render.b)localObject).Jgl = new com.tencent.mm.plugin.gamelive.render.c();
      ((com.tencent.mm.plugin.gamelive.render.b)localObject).width = 0;
      ((com.tencent.mm.plugin.gamelive.render.b)localObject).height = 0;
    }
    localObject = ((PluginGameLive)h.az(PluginGameLive.class)).getMainProcessAudioService$plugin_gamelive_release();
    if (localObject != null)
    {
      Log.i("MicroMsg.GameLiveMainAudioMgrService", "start main audio");
      d.Jfi = true;
      com.tencent.d.a.a.a.b localb = (com.tencent.d.a.a.a.b)h.az(com.tencent.d.a.a.a.b.class);
      localb.startLocalAudio(true);
      localb.enableMicExternalAudioFrame(true, false);
      ((d)localObject).Jes.execute(((d)localObject).Jfh);
    }
    AppMethodBeat.o(277256);
  }
  
  public static void fIL()
  {
    AppMethodBeat.i(277262);
    ((com.tencent.d.a.a.a.b)h.az(com.tencent.d.a.a.a.b.class)).controlLiveMiniWindowVisibility(true, MMApplicationContext.getContext());
    AppMethodBeat.o(277262);
  }
  
  public static void fIM()
  {
    AppMethodBeat.i(277264);
    ((com.tencent.d.a.a.a.b)h.az(com.tencent.d.a.a.a.b.class)).controlLiveMiniWindowVisibility(false, MMApplicationContext.getContext());
    AppMethodBeat.o(277264);
  }
  
  public static void fIP()
  {
    AppMethodBeat.i(277278);
    bgt localbgt = ((com.tencent.d.a.a.a.b)h.az(com.tencent.d.a.a.a.b.class)).getFinderLiveExternalInfo();
    PluginGameLive localPluginGameLive = (PluginGameLive)h.az(PluginGameLive.class);
    if (localbgt != null)
    {
      if (!Util.isNullOrNil(localbgt.Dky)) {
        localPluginGameLive.setGameLiveNickname$plugin_gamelive_release(localbgt.Dky);
      }
      if (localbgt.liveId != 0L) {
        localPluginGameLive.setGameLiveLiveId$plugin_gamelive_release(localbgt.liveId);
      }
      if (!Util.isNullOrNil(localbgt.JfL)) {
        localPluginGameLive.setGameLiveJoinLiveTips$plugin_gamelive_release(localbgt.JfL);
      }
      if (!Util.isNullOrNil(localbgt.Ebo)) {
        localPluginGameLive.setGameLiveAnchorHeadUrl$plugin_gamelive_release(localbgt.Ebo);
      }
      if (!Util.isNullOrNil(localbgt.ZQh)) {
        localPluginGameLive.setWxaGameExportId$plugin_gamelive_release(localbgt.ZQh);
      }
    }
    localPluginGameLive.setGameLiveFinderUsrName$plugin_gamelive_release(z.bAW());
    Log.i("MicroMsg.GameLiveMainProcessService", "zbql:getStartData:gameLiveNickname:%s ,gameLiveAnchorHeadUrl:%s , exportId:%s", new Object[] { localPluginGameLive.getGameLiveNickname$plugin_gamelive_release(), localPluginGameLive.getGameLiveAnchorHeadUrl$plugin_gamelive_release(), localPluginGameLive.getWxaGameExportId$plugin_gamelive_release() });
    AppMethodBeat.o(277278);
  }
  
  public static Map<String, String> fIQ()
  {
    AppMethodBeat.i(277289);
    Object localObject = ((com.tencent.d.a.a.a.b)h.az(com.tencent.d.a.a.a.b.class)).getFinderLiveExternalInfo();
    r localr = v.Y("topic", ((com.tencent.d.a.a.a.b)h.az(com.tencent.d.a.a.a.b.class)).getTopic());
    if (localObject == null) {}
    for (localObject = null;; localObject = Integer.valueOf(((bgt)localObject).startTime).toString())
    {
      localObject = ak.e(new r[] { localr, v.Y("startTime", localObject) });
      AppMethodBeat.o(277289);
      return localObject;
    }
  }
  
  public static void wD(boolean paramBoolean)
  {
    int i = 0;
    AppMethodBeat.i(277229);
    Log.i("MicroMsg.GameLiveMainProcessService", "enableVoiceCapture %b", new Object[] { Boolean.valueOf(paramBoolean) });
    com.tencent.d.a.a.a.b localb = (com.tencent.d.a.a.a.b)h.az(com.tencent.d.a.a.a.b.class);
    if (paramBoolean) {
      i = 100;
    }
    localb.setVoiceCaptureVolume(i);
    AppMethodBeat.o(277229);
  }
  
  public final void fIK()
  {
    AppMethodBeat.i(277318);
    Log.i("MicroMsg.GameLiveMainProcessService", "enableAudio");
    this.Eem = false;
    wD(true);
    AppMethodBeat.o(277318);
  }
  
  public final void fIN()
  {
    AppMethodBeat.i(277323);
    Log.i("MicroMsg.GameLiveMainProcessService", "zbql:registerFinderLiveCallback");
    ((com.tencent.d.a.a.a.b)h.az(com.tencent.d.a.a.a.b.class)).registerExternalLiveCallback(this.Jde);
    this.isRegistered = true;
    AppMethodBeat.o(277323);
  }
  
  public final void fIO()
  {
    AppMethodBeat.i(277328);
    if (this.isRegistered)
    {
      Log.i("MicroMsg.GameLiveMainProcessService", "zbql:unRegisterFinderLiveCallback");
      ((com.tencent.d.a.a.a.b)h.az(com.tencent.d.a.a.a.b.class)).unregisterExternalLiveCallback(this.Jde);
      this.isRegistered = false;
    }
    AppMethodBeat.o(277328);
  }
  
  final void wC(boolean paramBoolean)
  {
    for (;;)
    {
      Context localContext1;
      try
      {
        AppMethodBeat.i(277315);
        Log.i("MicroMsg.GameLiveMainProcessService", "enableForegroundService current:" + this.Jdd + " request:" + paramBoolean);
        localContext1 = MMApplicationContext.getContext();
        if (!paramBoolean) {
          break label150;
        }
        boolean bool = this.Jdd;
        if (bool) {
          break label150;
        }
        try
        {
          if (Build.VERSION.SDK_INT < 26) {
            continue;
          }
          localContext1.startForegroundService(new Intent(localContext1, GameLiveForegroundService.class));
          this.Jdd = true;
          AppMethodBeat.o(277315);
        }
        catch (Exception localException1)
        {
          Log.printErrStackTrace("MicroMsg.GameLiveMainProcessService", (Throwable)localException1, "start foreground service error", new Object[0]);
          AppMethodBeat.o(277315);
          continue;
        }
        return;
      }
      finally {}
      localContext1.startService(new Intent(localContext1, GameLiveForegroundService.class));
      continue;
      label150:
      if (!paramBoolean)
      {
        paramBoolean = this.Jdd;
        if (paramBoolean) {
          try
          {
            localContext2.stopService(new Intent(localContext2, GameLiveForegroundService.class));
            this.Jdd = false;
            AppMethodBeat.o(277315);
          }
          catch (Exception localException2)
          {
            Log.printErrStackTrace("MicroMsg.GameLiveMainProcessService", (Throwable)localException2, "stop foreground service error", new Object[0]);
          }
        }
      }
      AppMethodBeat.o(277315);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/gamelive/GameLiveMainProcessService$IGetMemberListCallback;", "", "getMemberList", "", "list", "Lcom/tencent/mm/plugin/gamelive/event/GameLiveAppbrandEventService$LiveMemberInfoListPayload;", "plugin-gamelive_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface b
  {
    public abstract void a(GameLiveAppbrandEventService.LiveMemberInfoListPayload paramLiveMemberInfoListPayload);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/gamelive/GameLiveMainProcessService$callBack$1", "Lcom/tencent/plugin/finder/live/api/IExternalLiveCallback;", "onLiveFinished", "", "onLiveInfoChanged", "msg", "", "Lcom/tencent/mm/protocal/protobuf/MMFinderLiveRoomMsg;", "info", "Lcom/tencent/mm/protocal/protobuf/MMFinderLiveRoomInfo;", "onLiveNetStatus", "netQuality", "", "threshold", "onLiveVoiceVolume", "volume", "onMiniWindowStatusChange", "isShown", "", "gameAppId", "", "gameVersionType", "(ZLjava/lang/String;Ljava/lang/Integer;)V", "onPostResult", "result", "errType", "onShareLiveToConversation", "shareUserCount", "shareRoomCount", "plugin-gamelive_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    implements com.tencent.d.a.a.a.a
  {
    d(a parama) {}
    
    public final void X(boolean paramBoolean, int paramInt)
    {
      AppMethodBeat.i(277375);
      if (!paramBoolean)
      {
        switch (paramInt)
        {
        default: 
          Log.i("MicroMsg.GameLiveMainProcessService", "zbql:invalid errType");
          AppMethodBeat.o(277375);
          return;
        case 1: 
          Log.i("MicroMsg.GameLiveMainProcessService", "zbql:PostErrType.USER_CANCEL");
          a.a(PluginGameLive.IPCLiveControlData.b.JdW, h.d.tjT.ordinal(), h.c.tjK.ordinal());
          ((PluginGameLive)h.az(PluginGameLive.class)).resetState$plugin_gamelive_release();
          this.Jdf.fIO();
          AppMethodBeat.o(277375);
          return;
        }
        Log.e("MicroMsg.GameLiveMainProcessService", "zbql:PostErrType.ENTER_ROOM_FAIL");
        ((PluginGameLive)h.az(PluginGameLive.class)).resetState$plugin_gamelive_release();
        this.Jdf.fIO();
        AppMethodBeat.o(277375);
        return;
      }
      Log.i("MicroMsg.GameLiveMainProcessService", "zbql:receive startLive success callback from finder");
      this.Jdf.fIK();
      a.fIP();
      XIPCInvoker.a(((PluginGameLive)h.az(PluginGameLive.class)).getAppBrandPackageName$plugin_gamelive_release(), new PluginGameLive.IPCLiveControlData(PluginGameLive.IPCLiveControlData.b.JdY, null, null, 14), PluginGameLive.c.class, null);
      AppMethodBeat.o(277375);
    }
    
    public final void XY(int paramInt)
    {
      AppMethodBeat.i(277395);
      if (!((PluginGameLive)h.az(PluginGameLive.class)).getDisableMicInfo$plugin_gamelive_release())
      {
        Log.i("MicroMsg.GameLiveMainProcessService", "decide to send LiveVoiceVolume msg");
        XIPCInvoker.a(((PluginGameLive)h.az(PluginGameLive.class)).getAppBrandPackageName$plugin_gamelive_release(), new PluginGameLive.IPCLiveControlData(PluginGameLive.IPCLiveControlData.b.Jeb, null, (Parcelable)new GameLiveAppbrandEventService.SimpleLiveStateChangePayload(ak.l(v.Y("micVolume", Integer.valueOf(paramInt)))), 6), PluginGameLive.c.class, null);
        AppMethodBeat.o(277395);
        return;
      }
      Log.i("MicroMsg.GameLiveMainProcessService", "receive LiveVoiceVolume msg, but disableMicInfo");
      AppMethodBeat.o(277395);
    }
    
    public final void a(List<? extends dle> paramList, dld paramdld)
    {
      AppMethodBeat.i(277385);
      if (((PluginGameLive)h.az(PluginGameLive.class)).getDisableLiveInfo$plugin_gamelive_release())
      {
        Log.i("MicroMsg.GameLiveMainProcessService", "receive onLiveInfoChanged,but is disableLiveInfo");
        AppMethodBeat.o(277385);
        return;
      }
      GameLiveAppbrandEventService.LiveCommentWrapperInfoPayload localLiveCommentWrapperInfoPayload = new GameLiveAppbrandEventService.LiveCommentWrapperInfoPayload();
      localLiveCommentWrapperInfoPayload.liveId = paramdld.liveId;
      localLiveCommentWrapperInfoPayload.Jfo = paramdld.aaQZ;
      localLiveCommentWrapperInfoPayload.Jfp = paramdld.aaQY;
      localLiveCommentWrapperInfoPayload.Jfq = paramdld.DFW;
      localLiveCommentWrapperInfoPayload.Jfr = paramdld.aaRa;
      if (paramList != null)
      {
        paramdld = (List)new ArrayList();
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          dle localdle = (dle)paramList.next();
          GameLiveAppbrandEventService.LiveSingleCommentPayload localLiveSingleCommentPayload = new GameLiveAppbrandEventService.LiveSingleCommentPayload();
          localLiveSingleCommentPayload.JfA = Integer.valueOf(localdle.msgType);
          localLiveSingleCommentPayload.JfB = localdle.aaRb;
          localLiveSingleCommentPayload.JfC = localdle.aaRf;
          localLiveSingleCommentPayload.content = localdle.content;
          localLiveSingleCommentPayload.JfD = Integer.valueOf(localdle.aaRc);
          localLiveSingleCommentPayload.JfE = Long.valueOf(localdle.aaRd);
          localLiveSingleCommentPayload.JfF = Integer.valueOf(localdle.JfJ);
          localLiveSingleCommentPayload.JfG = Integer.valueOf(localdle.aaRe);
          localLiveSingleCommentPayload.JfH = localdle.JfH;
          localLiveSingleCommentPayload.JfI = localdle.JfI;
          localLiveSingleCommentPayload.DKv = localdle.DKv;
          localLiveSingleCommentPayload.JfJ = localdle.JfJ;
          paramdld.add(localLiveSingleCommentPayload);
        }
        localLiveCommentWrapperInfoPayload.EgE = paramdld;
      }
      Log.i("MicroMsg.GameLiveMainProcessService", "decide to send IPC msg");
      XIPCInvoker.a(((PluginGameLive)h.az(PluginGameLive.class)).getAppBrandPackageName$plugin_gamelive_release(), new PluginGameLive.IPCLiveControlData(PluginGameLive.IPCLiveControlData.b.Jea, null, (Parcelable)localLiveCommentWrapperInfoPayload, 6), PluginGameLive.c.class, null);
      AppMethodBeat.o(277385);
    }
    
    public final void c(String paramString, Integer paramInteger)
    {
      int j = 0;
      AppMethodBeat.i(277422);
      Object localObject2 = "zbql:onMiniWindowStatusChange,isShown:true,isGameLiving:%b,appid:" + paramString + ",versionType:" + paramInteger + ",state:%s";
      Object localObject3 = (PluginGameLive)h.az(PluginGameLive.class);
      Object localObject1;
      if (paramString == null)
      {
        localObject1 = "";
        if (paramInteger != null) {
          break label205;
        }
        i = 0;
        label69:
        localObject3 = ((PluginGameLive)localObject3).isGameLiving((String)localObject1, i);
        localObject1 = ((PluginGameLive)h.az(PluginGameLive.class)).getGameLiveCurrentState_$plugin_gamelive_release();
        if (localObject1 != null) {
          break label213;
        }
        localObject1 = null;
        label100:
        Log.i("MicroMsg.GameLiveMainProcessService", (String)localObject2, new Object[] { localObject3, localObject1 });
        localObject2 = (PluginGameLive)h.az(PluginGameLive.class);
        localObject1 = paramString;
        if (paramString == null) {
          localObject1 = "";
        }
        if (paramInteger != null) {
          break label223;
        }
      }
      label205:
      label213:
      label223:
      for (int i = j;; i = paramInteger.intValue())
      {
        if ((((PluginGameLive)localObject2).isGameLiving((String)localObject1, i).booleanValue()) && (((PluginGameLive)h.az(PluginGameLive.class)).getGameLiveCurrentState_$plugin_gamelive_release() == PluginGameLive.b.Jdw))
        {
          a.fIM();
          Log.i("MicroMsg.GameLiveMainProcessService", "hide MinimizeGameLive");
        }
        AppMethodBeat.o(277422);
        return;
        localObject1 = paramString;
        break;
        i = paramInteger.intValue();
        break label69;
        localObject1 = ((PluginGameLive.b)localObject1).fIR();
        break label100;
      }
    }
    
    public final void ekG()
    {
      AppMethodBeat.i(277408);
      Log.i("MicroMsg.GameLiveMainProcessService", "zbql:onLiveFinished");
      a.a(PluginGameLive.IPCLiveControlData.b.JdX, h.d.tjQ.ordinal(), h.c.tjO.ordinal());
      this.Jdf.fIO();
      AppMethodBeat.o(277408);
    }
    
    public final void jk(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(277414);
      Log.i("MicroMsg.GameLiveMainProcessService", "onLiveNetStatus changed");
      XIPCInvoker.a(((PluginGameLive)h.az(PluginGameLive.class)).getAppBrandPackageName$plugin_gamelive_release(), new PluginGameLive.IPCLiveControlData(PluginGameLive.IPCLiveControlData.b.Jec, null, (Parcelable)new GameLiveAppbrandEventService.LiveNetWorkPayload(paramInt1, paramInt2), 6), PluginGameLive.c.class, null);
      AppMethodBeat.o(277414);
    }
    
    public final void m(boolean paramBoolean, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(277402);
      Log.d("MicroMsg.GameLiveMainProcessService", "zbql:onShareLiveToConversation:result [%b],shareUserCount:%d,shareRoomCount:%d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      if (!paramBoolean)
      {
        Log.i("MicroMsg.GameLiveMainProcessService", "ShareLiveToConversation failed");
        AppMethodBeat.o(277402);
        return;
      }
      XIPCInvoker.a(((PluginGameLive)h.az(PluginGameLive.class)).getAppBrandPackageName$plugin_gamelive_release(), new PluginGameLive.IPCLiveControlData(PluginGameLive.IPCLiveControlData.b.JdZ, null, (Parcelable)new GameLiveAppbrandEventService.SimpleLiveStateChangePayload(ak.e(new r[] { v.Y("shareUserCount", Integer.valueOf(paramInt1)), v.Y("shareRoomCount", Integer.valueOf(paramInt2)) })), 6), PluginGameLive.c.class, null);
      AppMethodBeat.o(277402);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelive.a
 * JD-Core Version:    0.7.0.1
 */