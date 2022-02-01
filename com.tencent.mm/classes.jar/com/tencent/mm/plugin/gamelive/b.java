package com.tencent.mm.plugin.gamelive;

import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Parcelable;
import com.tencent.c.a.a.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.appbrand.menu.h.c;
import com.tencent.mm.plugin.appbrand.menu.h.d;
import com.tencent.mm.plugin.findersdk.a.ag.a;
import com.tencent.mm.plugin.gamelive.event.GameLiveAppbrandEventService.LiveCommentWrapperInfoPayload;
import com.tencent.mm.plugin.gamelive.event.GameLiveAppbrandEventService.LiveNetWorkPayload;
import com.tencent.mm.plugin.gamelive.event.GameLiveAppbrandEventService.LiveSingleCommentPayload;
import com.tencent.mm.plugin.gamelive.event.GameLiveAppbrandEventService.SimpleLiveStateChangePayload;
import com.tencent.mm.plugin.gamelive.render.c;
import com.tencent.mm.plugin.gamelive.service.GameLiveForegroundService;
import com.tencent.mm.protocal.protobuf.azg;
import com.tencent.mm.protocal.protobuf.cub;
import com.tencent.mm.protocal.protobuf.cuc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.a.ae;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.o;
import kotlin.s;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/gamelive/GameLiveMainProcessService;", "Lcom/tencent/mm/plugin/gamelive/IGameLiveMainProcessService;", "()V", "callBack", "Lcom/tencent/plugin/finder/live/api/IExternalLiveCallback;", "getCallBack", "()Lcom/tencent/plugin/finder/live/api/IExternalLiveCallback;", "foregroundServiceActive", "", "isRegistered", "muteMic", "activateForegroundService", "", "activate", "disableAudio", "enableAudio", "enableVoiceCapture", "enable", "getMemberList", "callback", "Lcom/tencent/mm/plugin/gamelive/GameLiveMainProcessService$IGetMemberListCallback;", "getMemberList$plugin_gamelive_release", "getStartData", "getTime", "", "getTime$plugin_gamelive_release", "hideMinimizeGameLive", "launchWAGameForFinderLive", "context", "Landroid/content/Context;", "appId", "", "versionType", "isFirstLaunch", "isFromWeApp", "liveId", "", "makeSceneNote", "minimizeGameLive", "pauseLive", "registerFinderLiveCallback", "resumeGameLiveFromCrash", "resumeLive", "sendIPCEventToAppBrand", "action", "Lcom/tencent/mm/plugin/gamelive/PluginGameLive$IPCLiveControlData$IPCLiveControlAction;", "event", "reason", "sendVolumnCallBackDuration", "duration", "startGameLive", "ingnoreContinueLive", "startPush", "stopPush", "unRegisterFinderLiveCallback", "Companion", "IGetMemberListCallback", "plugin-gamelive_release"})
public final class b
  implements d
{
  public static final b.a DjX;
  private boolean DjV;
  private final a DjW;
  private boolean isRegistered;
  boolean zgs;
  
  static
  {
    AppMethodBeat.i(208469);
    DjX = new b.a((byte)0);
    AppMethodBeat.o(208469);
  }
  
  public b()
  {
    AppMethodBeat.i(208468);
    this.DjW = ((a)new c(this));
    AppMethodBeat.o(208468);
  }
  
  public static void Uc(int paramInt)
  {
    AppMethodBeat.i(208450);
    ((com.tencent.c.a.a.a.b)h.ag(com.tencent.c.a.a.a.b.class)).enableAudioVolumeEvaluation(paramInt);
    AppMethodBeat.o(208450);
  }
  
  public static void a(PluginGameLive.IPCLiveControlData.b paramb, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(208463);
    p.k(paramb, "action");
    XIPCInvoker.a(((PluginGameLive)h.ag(PluginGameLive.class)).getAppBrandPackageName$plugin_gamelive_release(), new PluginGameLive.IPCLiveControlData(paramb, null, (Parcelable)new GameLiveAppbrandEventService.SimpleLiveStateChangePayload(ae.e(new o[] { s.M("event", Integer.valueOf(paramInt1)), s.M("reason", Integer.valueOf(paramInt2)) })), 6), PluginGameLive.c.class, null);
    AppMethodBeat.o(208463);
  }
  
  public static void a(b.b paramb)
  {
    AppMethodBeat.i(208466);
    p.k(paramb, "callback");
    ((com.tencent.c.a.a.a.b)h.ag(com.tencent.c.a.a.a.b.class)).getFinderLiveMemberListInfo((ag.a)new b.d(paramb));
    AppMethodBeat.o(208466);
  }
  
  public static void bOM()
  {
    AppMethodBeat.i(208451);
    Log.i("MicroMsg.GameLiveMainProcessService", "start push");
    Object localObject = ((PluginGameLive)h.ag(PluginGameLive.class)).getMainProcessRenderService$plugin_gamelive_release();
    if (localObject != null)
    {
      Log.i("MicroMsg.GameLiveMainRenderMgrService", "start main process render");
      com.tencent.mm.plugin.gamelive.render.b.sy(true);
      ((com.tencent.mm.plugin.gamelive.render.b)localObject).DmA = new c();
      ((com.tencent.mm.plugin.gamelive.render.b)localObject).width = 0;
      ((com.tencent.mm.plugin.gamelive.render.b)localObject).height = 0;
    }
    localObject = ((PluginGameLive)h.ag(PluginGameLive.class)).getMainProcessAudioService$plugin_gamelive_release();
    if (localObject != null)
    {
      Log.i("MicroMsg.GameLiveMainAudioMgrService", "start main audio");
      com.tencent.mm.plugin.gamelive.a.d.DlY = true;
      com.tencent.c.a.a.a.b localb = (com.tencent.c.a.a.a.b)h.ag(com.tencent.c.a.a.a.b.class);
      localb.startLocalAudio(true);
      localb.enableMicExternalAudioFrame(true, false);
      ((com.tencent.mm.plugin.gamelive.a.d)localObject).Dli.execute(((com.tencent.mm.plugin.gamelive.a.d)localObject).DlX);
      AppMethodBeat.o(208451);
      return;
    }
    AppMethodBeat.o(208451);
  }
  
  public static void eAJ()
  {
    AppMethodBeat.i(208454);
    ((com.tencent.c.a.a.a.b)h.ag(com.tencent.c.a.a.a.b.class)).controlLiveMiniWindowVisibility(true, MMApplicationContext.getContext());
    AppMethodBeat.o(208454);
  }
  
  public static void eAK()
  {
    AppMethodBeat.i(208456);
    ((com.tencent.c.a.a.a.b)h.ag(com.tencent.c.a.a.a.b.class)).controlLiveMiniWindowVisibility(false, MMApplicationContext.getContext());
    AppMethodBeat.o(208456);
  }
  
  public static void eAN()
  {
    AppMethodBeat.i(208462);
    azg localazg = ((com.tencent.c.a.a.a.b)h.ag(com.tencent.c.a.a.a.b.class)).getFinderLiveExternalInfo();
    PluginGameLive localPluginGameLive = (PluginGameLive)h.ag(PluginGameLive.class);
    if (localazg != null)
    {
      if (!Util.isNullOrNil(localazg.yxR)) {
        localPluginGameLive.setGameLiveNickname$plugin_gamelive_release(localazg.yxR);
      }
      if (localazg.liveId != 0L) {
        localPluginGameLive.setGameLiveLiveId$plugin_gamelive_release(localazg.liveId);
      }
      if (!Util.isNullOrNil(localazg.Dmx)) {
        localPluginGameLive.setGameLiveJoinLiveTips$plugin_gamelive_release(localazg.Dmx);
      }
      if (!Util.isNullOrNil(localazg.zev)) {
        localPluginGameLive.setGameLiveAnchorHeadUrl$plugin_gamelive_release(localazg.zev);
      }
    }
    localPluginGameLive.setGameLiveFinderUsrName$plugin_gamelive_release(z.bdh());
    Log.i("MicroMsg.GameLiveMainProcessService", "zbql:getStartData:gameLiveNickname:%s ,gameLiveAnchorHeadUrl:%s", new Object[] { localPluginGameLive.getGameLiveNickname$plugin_gamelive_release(), localPluginGameLive.getGameLiveAnchorHeadUrl$plugin_gamelive_release() });
    AppMethodBeat.o(208462);
  }
  
  public static int eAO()
  {
    AppMethodBeat.i(208467);
    Log.i("MicroMsg.GameLiveMainProcessService", "getTime");
    azg localazg = ((com.tencent.c.a.a.a.b)h.ag(com.tencent.c.a.a.a.b.class)).getFinderLiveExternalInfo();
    if (localazg != null)
    {
      int i = localazg.fod;
      AppMethodBeat.o(208467);
      return i;
    }
    AppMethodBeat.o(208467);
    return 0;
  }
  
  public static void m(Context paramContext, String paramString, int paramInt)
  {
    AppMethodBeat.i(208458);
    p.k(paramContext, "context");
    p.k(paramString, "appId");
    ((PluginGameLive)h.ag(PluginGameLive.class)).startGameLivePrepare$plugin_gamelive_release();
    ((com.tencent.c.a.a.a.b)h.ag(com.tencent.c.a.a.a.b.class)).enterFinderGameLivePostVerifyUI(paramContext, paramString, paramInt, true);
    AppMethodBeat.o(208458);
  }
  
  public static void sx(boolean paramBoolean)
  {
    int i = 0;
    AppMethodBeat.i(208448);
    Log.i("MicroMsg.GameLiveMainProcessService", "enableVoiceCapture %b", new Object[] { Boolean.valueOf(paramBoolean) });
    com.tencent.c.a.a.a.b localb = (com.tencent.c.a.a.a.b)h.ag(com.tencent.c.a.a.a.b.class);
    if (paramBoolean) {
      i = 100;
    }
    localb.setVoiceCaptureVolume(i);
    AppMethodBeat.o(208448);
  }
  
  public final void eAI()
  {
    AppMethodBeat.i(208447);
    Log.i("MicroMsg.GameLiveMainProcessService", "enableAudio");
    this.zgs = false;
    sx(true);
    AppMethodBeat.o(208447);
  }
  
  public final void eAL()
  {
    AppMethodBeat.i(208460);
    Log.i("MicroMsg.GameLiveMainProcessService", "zbql:registerFinderLiveCallback");
    ((com.tencent.c.a.a.a.b)h.ag(com.tencent.c.a.a.a.b.class)).registerExternalLiveCallback(this.DjW);
    this.isRegistered = true;
    AppMethodBeat.o(208460);
  }
  
  public final void eAM()
  {
    AppMethodBeat.i(208461);
    if (this.isRegistered)
    {
      Log.i("MicroMsg.GameLiveMainProcessService", "zbql:unRegisterFinderLiveCallback");
      ((com.tencent.c.a.a.a.b)h.ag(com.tencent.c.a.a.a.b.class)).unregisterExternalLiveCallback(this.DjW);
      this.isRegistered = false;
    }
    AppMethodBeat.o(208461);
  }
  
  final void sw(boolean paramBoolean)
  {
    for (;;)
    {
      Context localContext1;
      try
      {
        AppMethodBeat.i(208445);
        Log.i("MicroMsg.GameLiveMainProcessService", "enableForegroundService current:" + this.DjV + " request:" + paramBoolean);
        localContext1 = MMApplicationContext.getContext();
        if (!paramBoolean) {
          break label148;
        }
        boolean bool = this.DjV;
        if (bool) {
          break label148;
        }
        try
        {
          if (Build.VERSION.SDK_INT < 26) {
            continue;
          }
          localContext1.startForegroundService(new Intent(localContext1, GameLiveForegroundService.class));
          this.DjV = true;
          AppMethodBeat.o(208445);
        }
        catch (Exception localException1)
        {
          Log.printErrStackTrace("MicroMsg.GameLiveMainProcessService", (Throwable)localException1, "start foreground service error", new Object[0]);
          AppMethodBeat.o(208445);
          continue;
        }
        return;
      }
      finally {}
      localContext1.startService(new Intent(localContext1, GameLiveForegroundService.class));
      continue;
      label148:
      if (!paramBoolean)
      {
        paramBoolean = this.DjV;
        if (paramBoolean) {
          try
          {
            localContext2.stopService(new Intent(localContext2, GameLiveForegroundService.class));
            this.DjV = false;
            AppMethodBeat.o(208445);
          }
          catch (Exception localException2)
          {
            Log.printErrStackTrace("MicroMsg.GameLiveMainProcessService", (Throwable)localException2, "stop foreground service error", new Object[0]);
          }
        }
      }
      AppMethodBeat.o(208445);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/gamelive/GameLiveMainProcessService$callBack$1", "Lcom/tencent/plugin/finder/live/api/IExternalLiveCallback;", "onLiveFinished", "", "onLiveInfoChanged", "msg", "", "Lcom/tencent/mm/protocal/protobuf/MMFinderLiveRoomMsg;", "info", "Lcom/tencent/mm/protocal/protobuf/MMFinderLiveRoomInfo;", "onLiveNetStatus", "netQuality", "", "threshold", "onLiveVoiceVolume", "volume", "onMiniWindowStatusChange", "isShown", "", "gameAppId", "", "gameVersionType", "(ZLjava/lang/String;Ljava/lang/Integer;)V", "onPostResult", "result", "errType", "onShareLiveToConversation", "shareUserCount", "shareRoomCount", "plugin-gamelive_release"})
  public static final class c
    implements a
  {
    public final void Ud(int paramInt)
    {
      AppMethodBeat.i(208085);
      if (!((PluginGameLive)h.ag(PluginGameLive.class)).getDisableMicInfo$plugin_gamelive_release())
      {
        Log.i("MicroMsg.GameLiveMainProcessService", "decide to send LiveVoiceVolume msg");
        XIPCInvoker.a(((PluginGameLive)h.ag(PluginGameLive.class)).getAppBrandPackageName$plugin_gamelive_release(), new PluginGameLive.IPCLiveControlData(PluginGameLive.IPCLiveControlData.b.DkR, null, (Parcelable)new GameLiveAppbrandEventService.SimpleLiveStateChangePayload(ae.d(s.M("micVolume", Integer.valueOf(paramInt)))), 6), PluginGameLive.c.class, null);
        AppMethodBeat.o(208085);
        return;
      }
      Log.i("MicroMsg.GameLiveMainProcessService", "receive LiveVoiceVolume msg, but disableMicInfo");
      AppMethodBeat.o(208085);
    }
    
    public final void V(boolean paramBoolean, int paramInt)
    {
      AppMethodBeat.i(208083);
      if (!paramBoolean)
      {
        switch (paramInt)
        {
        default: 
          Log.i("MicroMsg.GameLiveMainProcessService", "zbql:invalid errType");
          AppMethodBeat.o(208083);
          return;
        case 1: 
          Log.i("MicroMsg.GameLiveMainProcessService", "zbql:PostErrType.USER_CANCEL");
          b.a(PluginGameLive.IPCLiveControlData.b.DkM, h.d.qfo.ordinal(), h.c.qff.ordinal());
          ((PluginGameLive)h.ag(PluginGameLive.class)).resetState$plugin_gamelive_release();
          this.DjY.eAM();
          AppMethodBeat.o(208083);
          return;
        }
        Log.e("MicroMsg.GameLiveMainProcessService", "zbql:PostErrType.ENTER_ROOM_FAIL");
        ((PluginGameLive)h.ag(PluginGameLive.class)).resetState$plugin_gamelive_release();
        this.DjY.eAM();
        AppMethodBeat.o(208083);
        return;
      }
      Log.i("MicroMsg.GameLiveMainProcessService", "zbql:receive startLive success callback from finder");
      this.DjY.eAI();
      b.eAN();
      XIPCInvoker.a(((PluginGameLive)h.ag(PluginGameLive.class)).getAppBrandPackageName$plugin_gamelive_release(), new PluginGameLive.IPCLiveControlData(PluginGameLive.IPCLiveControlData.b.DkO, null, null, 14), PluginGameLive.c.class, null);
      AppMethodBeat.o(208083);
    }
    
    public final void a(List<? extends cuc> paramList, cub paramcub)
    {
      AppMethodBeat.i(208084);
      if (((PluginGameLive)h.ag(PluginGameLive.class)).getDisableLiveInfo$plugin_gamelive_release())
      {
        Log.i("MicroMsg.GameLiveMainProcessService", "receive onLiveInfoChanged,but is disableLiveInfo");
        AppMethodBeat.o(208084);
        return;
      }
      GameLiveAppbrandEventService.LiveCommentWrapperInfoPayload localLiveCommentWrapperInfoPayload = new GameLiveAppbrandEventService.LiveCommentWrapperInfoPayload();
      localLiveCommentWrapperInfoPayload.liveId = paramcub.liveId;
      localLiveCommentWrapperInfoPayload.Dmf = paramcub.TBK;
      localLiveCommentWrapperInfoPayload.Dmg = paramcub.TBJ;
      localLiveCommentWrapperInfoPayload.Dmh = paramcub.yNv;
      localLiveCommentWrapperInfoPayload.Dmi = paramcub.TBL;
      if (paramList != null)
      {
        paramcub = (List)new ArrayList();
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          cuc localcuc = (cuc)paramList.next();
          GameLiveAppbrandEventService.LiveSingleCommentPayload localLiveSingleCommentPayload = new GameLiveAppbrandEventService.LiveSingleCommentPayload();
          localLiveSingleCommentPayload.Dmm = Integer.valueOf(localcuc.msgType);
          localLiveSingleCommentPayload.Dmn = localcuc.TBM;
          localLiveSingleCommentPayload.Dmo = localcuc.TBQ;
          localLiveSingleCommentPayload.content = localcuc.content;
          localLiveSingleCommentPayload.Dmp = Integer.valueOf(localcuc.TBN);
          localLiveSingleCommentPayload.Dmq = Long.valueOf(localcuc.TBO);
          localLiveSingleCommentPayload.Dmr = Integer.valueOf(localcuc.Dmv);
          localLiveSingleCommentPayload.Dms = Integer.valueOf(localcuc.TBP);
          localLiveSingleCommentPayload.Dmt = localcuc.Dmt;
          localLiveSingleCommentPayload.Dmu = localcuc.Dmu;
          localLiveSingleCommentPayload.ySp = localcuc.ySp;
          localLiveSingleCommentPayload.Dmv = localcuc.Dmv;
          paramcub.add(localLiveSingleCommentPayload);
        }
        localLiveCommentWrapperInfoPayload.ziq = paramcub;
      }
      Log.i("MicroMsg.GameLiveMainProcessService", "decide to send IPC msg");
      XIPCInvoker.a(((PluginGameLive)h.ag(PluginGameLive.class)).getAppBrandPackageName$plugin_gamelive_release(), new PluginGameLive.IPCLiveControlData(PluginGameLive.IPCLiveControlData.b.DkQ, null, (Parcelable)localLiveCommentWrapperInfoPayload, 6), PluginGameLive.c.class, null);
      AppMethodBeat.o(208084);
    }
    
    public final void d(String paramString, Integer paramInteger)
    {
      int j = 0;
      AppMethodBeat.i(208089);
      Object localObject2 = "zbql:onMiniWindowStatusChange,isShown:true,isGameLiving:%b,appid:" + paramString + ",versionType:" + paramInteger + ",state:%s";
      PluginGameLive localPluginGameLive = (PluginGameLive)h.ag(PluginGameLive.class);
      if (paramString == null) {}
      for (Object localObject1 = "";; localObject1 = paramString)
      {
        int i;
        boolean bool;
        if (paramInteger != null)
        {
          i = paramInteger.intValue();
          bool = localPluginGameLive.isGameLiving((String)localObject1, i);
          localObject1 = ((PluginGameLive)h.ag(PluginGameLive.class)).getGameLiveCurrentState_$plugin_gamelive_release();
          if (localObject1 == null) {
            break label216;
          }
        }
        label216:
        for (localObject1 = ((PluginGameLive.b)localObject1).eAP();; localObject1 = null)
        {
          Log.i("MicroMsg.GameLiveMainProcessService", (String)localObject2, new Object[] { Boolean.valueOf(bool), localObject1 });
          localObject2 = (PluginGameLive)h.ag(PluginGameLive.class);
          localObject1 = paramString;
          if (paramString == null) {
            localObject1 = "";
          }
          i = j;
          if (paramInteger != null) {
            i = paramInteger.intValue();
          }
          if ((((PluginGameLive)localObject2).isGameLiving((String)localObject1, i)) && (((PluginGameLive)h.ag(PluginGameLive.class)).getGameLiveCurrentState_$plugin_gamelive_release() == PluginGameLive.b.Dko))
          {
            b.eAK();
            Log.i("MicroMsg.GameLiveMainProcessService", "hide MinimizeGameLive");
          }
          AppMethodBeat.o(208089);
          return;
          i = 0;
          break;
        }
      }
    }
    
    public final void dyo()
    {
      AppMethodBeat.i(208087);
      Log.i("MicroMsg.GameLiveMainProcessService", "zbql:onLiveFinished");
      b.a(PluginGameLive.IPCLiveControlData.b.DkN, h.d.qfl.ordinal(), h.c.qfj.ordinal());
      this.DjY.eAM();
      AppMethodBeat.o(208087);
    }
    
    public final void hH(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(208088);
      Log.i("MicroMsg.GameLiveMainProcessService", "onLiveNetStatus changed");
      XIPCInvoker.a(((PluginGameLive)h.ag(PluginGameLive.class)).getAppBrandPackageName$plugin_gamelive_release(), new PluginGameLive.IPCLiveControlData(PluginGameLive.IPCLiveControlData.b.DkS, null, (Parcelable)new GameLiveAppbrandEventService.LiveNetWorkPayload(paramInt1, paramInt2), 6), PluginGameLive.c.class, null);
      AppMethodBeat.o(208088);
    }
    
    public final void j(boolean paramBoolean, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(208086);
      Log.d("MicroMsg.GameLiveMainProcessService", "zbql:onShareLiveToConversation:result [%b],shareUserCount:%d,shareRoomCount:%d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      if (!paramBoolean)
      {
        Log.i("MicroMsg.GameLiveMainProcessService", "ShareLiveToConversation failed");
        AppMethodBeat.o(208086);
        return;
      }
      XIPCInvoker.a(((PluginGameLive)h.ag(PluginGameLive.class)).getAppBrandPackageName$plugin_gamelive_release(), new PluginGameLive.IPCLiveControlData(PluginGameLive.IPCLiveControlData.b.DkP, null, (Parcelable)new GameLiveAppbrandEventService.SimpleLiveStateChangePayload(ae.e(new o[] { s.M("shareUserCount", Integer.valueOf(paramInt1)), s.M("shareRoomCount", Integer.valueOf(paramInt2)) })), 6), PluginGameLive.c.class, null);
      AppMethodBeat.o(208086);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelive.b
 * JD-Core Version:    0.7.0.1
 */