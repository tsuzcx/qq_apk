package com.tencent.mm.plugin.gamelive;

import android.os.Parcelable;
import android.view.Surface;
import com.tencent.d.a.a.a.b.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.gamelive.event.GameLiveAppbrandEventService.LiveIntPayload;
import com.tencent.mm.plugin.gamelive.event.GameLiveAppbrandEventService.LiveMemberInfoListPayload;
import com.tencent.mm.plugin.gamelive.event.GameLiveAppbrandEventService.LiveTopicPayload;
import com.tencent.mm.plugin.gamelive.render.GameLiveAppbrandRenderMgrService;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/gamelive/PluginGameLive;", "Lcom/tencent/mm/kernel/plugin/Plugin;", "Lcom/tencent/mm/plugin/gamelive/IPluginGameLive;", "Lcom/tencent/mm/kernel/api/ICoreAccountCallback;", "()V", "appbrandPackageName", "", "appbrandProcessAudioService", "Lcom/tencent/mm/plugin/gamelive/audio/GameLiveAppbrandAudioMgrService;", "getAppbrandProcessAudioService$plugin_gamelive_release", "()Lcom/tencent/mm/plugin/gamelive/audio/GameLiveAppbrandAudioMgrService;", "setAppbrandProcessAudioService$plugin_gamelive_release", "(Lcom/tencent/mm/plugin/gamelive/audio/GameLiveAppbrandAudioMgrService;)V", "appbrandProcessRenderService", "Lcom/tencent/mm/plugin/gamelive/render/GameLiveAppbrandRenderMgrService;", "getAppbrandProcessRenderService$plugin_gamelive_release", "()Lcom/tencent/mm/plugin/gamelive/render/GameLiveAppbrandRenderMgrService;", "setAppbrandProcessRenderService$plugin_gamelive_release", "(Lcom/tencent/mm/plugin/gamelive/render/GameLiveAppbrandRenderMgrService;)V", "appbrandProcessService", "Lcom/tencent/mm/plugin/gamelive/GameLiveAppbrandProcessService;", "getAppbrandProcessService$plugin_gamelive_release", "()Lcom/tencent/mm/plugin/gamelive/GameLiveAppbrandProcessService;", "setAppbrandProcessService$plugin_gamelive_release", "(Lcom/tencent/mm/plugin/gamelive/GameLiveAppbrandProcessService;)V", "value", "", "disableLiveInfo", "getDisableLiveInfo$plugin_gamelive_release", "()Z", "setDisableLiveInfo$plugin_gamelive_release", "(Z)V", "disableMicInfo", "getDisableMicInfo$plugin_gamelive_release", "setDisableMicInfo$plugin_gamelive_release", "enableAudioDebug", "getEnableAudioDebug", "enableAudioDebug$delegate", "Lkotlin/Lazy;", "gameLiveAnchorHeadUrl", "getGameLiveAnchorHeadUrl$plugin_gamelive_release", "()Ljava/lang/String;", "setGameLiveAnchorHeadUrl$plugin_gamelive_release", "(Ljava/lang/String;)V", "Lcom/tencent/mm/plugin/gamelive/PluginGameLive$GameLiveCurrentState;", "gameLiveCurrentState_", "getGameLiveCurrentState_$plugin_gamelive_release", "()Lcom/tencent/mm/plugin/gamelive/PluginGameLive$GameLiveCurrentState;", "setGameLiveCurrentState_$plugin_gamelive_release", "(Lcom/tencent/mm/plugin/gamelive/PluginGameLive$GameLiveCurrentState;)V", "gameLiveFinderUsrName", "getGameLiveFinderUsrName$plugin_gamelive_release", "setGameLiveFinderUsrName$plugin_gamelive_release", "gameLiveJoinLiveTips", "getGameLiveJoinLiveTips$plugin_gamelive_release", "setGameLiveJoinLiveTips$plugin_gamelive_release", "", "gameLiveLiveId", "getGameLiveLiveId$plugin_gamelive_release", "()J", "setGameLiveLiveId$plugin_gamelive_release", "(J)V", "gameLiveNickname", "getGameLiveNickname$plugin_gamelive_release", "setGameLiveNickname$plugin_gamelive_release", "Lcom/tencent/mm/plugin/gamelive/PluginGameLive$PrePareScene;", "gameLivePrepareScene_", "getGameLivePrepareScene_$plugin_gamelive_release", "()Lcom/tencent/mm/plugin/gamelive/PluginGameLive$PrePareScene;", "setGameLivePrepareScene_$plugin_gamelive_release", "(Lcom/tencent/mm/plugin/gamelive/PluginGameLive$PrePareScene;)V", "isLiving", "setLiving", "isPushing", "isPushing$plugin_gamelive_release", "setPushing$plugin_gamelive_release", "liveFinishListener", "com/tencent/mm/plugin/gamelive/PluginGameLive$liveFinishListener$1", "Lcom/tencent/mm/plugin/gamelive/PluginGameLive$liveFinishListener$1;", "mainProcessAudioService", "Lcom/tencent/mm/plugin/gamelive/audio/GameLiveMainAudioMgrService;", "getMainProcessAudioService$plugin_gamelive_release", "()Lcom/tencent/mm/plugin/gamelive/audio/GameLiveMainAudioMgrService;", "setMainProcessAudioService$plugin_gamelive_release", "(Lcom/tencent/mm/plugin/gamelive/audio/GameLiveMainAudioMgrService;)V", "mainProcessRenderService", "Lcom/tencent/mm/plugin/gamelive/render/GameLiveMainRenderMgrService;", "getMainProcessRenderService$plugin_gamelive_release", "()Lcom/tencent/mm/plugin/gamelive/render/GameLiveMainRenderMgrService;", "setMainProcessRenderService$plugin_gamelive_release", "(Lcom/tencent/mm/plugin/gamelive/render/GameLiveMainRenderMgrService;)V", "mainProcessService", "Lcom/tencent/mm/plugin/gamelive/GameLiveMainProcessService;", "getMainProcessService$plugin_gamelive_release", "()Lcom/tencent/mm/plugin/gamelive/GameLiveMainProcessService;", "setMainProcessService$plugin_gamelive_release", "(Lcom/tencent/mm/plugin/gamelive/GameLiveMainProcessService;)V", "onLiveAppId", "getOnLiveAppId$plugin_gamelive_release", "setOnLiveAppId$plugin_gamelive_release", "onLiveAppIdForCrashCheck", "getOnLiveAppIdForCrashCheck$plugin_gamelive_release", "setOnLiveAppIdForCrashCheck$plugin_gamelive_release", "onLiveCrashReset", "getOnLiveCrashReset$plugin_gamelive_release", "setOnLiveCrashReset$plugin_gamelive_release", "", "onLiveVersionType", "getOnLiveVersionType$plugin_gamelive_release", "()I", "setOnLiveVersionType$plugin_gamelive_release", "(I)V", "onLiveVersionTypeForCrashCheck", "getOnLiveVersionTypeForCrashCheck$plugin_gamelive_release", "setOnLiveVersionTypeForCrashCheck$plugin_gamelive_release", "onLivingStatusForCrashCheck", "getOnLivingStatusForCrashCheck$plugin_gamelive_release", "setOnLivingStatusForCrashCheck$plugin_gamelive_release", "onLivingStatusForCrashCheckTemp", "getOnLivingStatusForCrashCheckTemp$plugin_gamelive_release", "setOnLivingStatusForCrashCheckTemp$plugin_gamelive_release", "wxaGameExportId", "getWxaGameExportId$plugin_gamelive_release", "setWxaGameExportId$plugin_gamelive_release", "execute", "", "profile", "Lcom/tencent/mm/kernel/plugin/ProcessProfile;", "getAppBrandPackageName", "getAppBrandPackageName$plugin_gamelive_release", "isGameLiving", "appId", "versionType", "(Ljava/lang/String;I)Ljava/lang/Boolean;", "onAccountInitialized", "upgrade", "Lcom/tencent/mm/kernel/CoreStorage$UpgradeInfo;", "onAccountRelease", "resetCrashCheckParam", "resetCrashCheckParam$plugin_gamelive_release", "resetState", "resetState$plugin_gamelive_release", "setAppBrandPackageName", "name", "setAppBrandPackageName$plugin_gamelive_release", "setLiveInfoEvent", "isLiveEventNotify", "setMicInfoEvent", "isMicEventNotify", "startGameLivePrepare", "startGameLivePrepare$plugin_gamelive_release", "updateIsLivingState", "updateIsLivingState$plugin_gamelive_release", "withCurrentState", "withCurrentState$plugin_gamelive_release", "Companion", "GameLiveCurrentState", "IPCLiveControlData", "IPCLiveControlTask", "PrePareScene", "plugin-gamelive_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class PluginGameLive
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.kernel.api.c, d
{
  public static final PluginGameLive.a Jdh;
  private static final MultiProcessMMKV Jds;
  private a Jdi;
  private com.tencent.mm.plugin.gamelive.a.d Jdj;
  private com.tencent.mm.plugin.gamelive.render.b Jdk;
  private GameLiveAppbrandProcessService Jdl;
  private com.tencent.mm.plugin.gamelive.a.a Jdm;
  private GameLiveAppbrandRenderMgrService Jdn;
  private final j Jdo;
  private final PluginGameLive.liveFinishListener.1 Jdp;
  private String Jdq;
  private boolean Jdr;
  private boolean njA;
  
  static
  {
    AppMethodBeat.i(277283);
    Jdh = new PluginGameLive.a((byte)0);
    Jds = MultiProcessMMKV.getMMKV("PluginGameLive");
    AppMethodBeat.o(277283);
  }
  
  public PluginGameLive()
  {
    AppMethodBeat.i(277267);
    this.Jdo = k.cm((kotlin.g.a.a)PluginGameLive.e.Jek);
    this.Jdp = new PluginGameLive.liveFinishListener.1(this, com.tencent.mm.app.f.hfK);
    AppMethodBeat.o(277267);
  }
  
  private final boolean isLiving()
  {
    AppMethodBeat.i(277272);
    if (MMApplicationContext.isMainProcess()) {}
    for (boolean bool = ((com.tencent.d.a.a.a.b)h.az(com.tencent.d.a.a.a.b.class)).isAnchorLiving();; bool = Jds.getBoolean("isLiving", false))
    {
      setLiving(bool);
      bool = this.njA;
      AppMethodBeat.o(277272);
      return bool;
    }
  }
  
  private final void setLiving(boolean paramBoolean)
  {
    AppMethodBeat.i(277276);
    this.njA = paramBoolean;
    if (MMApplicationContext.isMainProcess())
    {
      Log.i("MicroMsg.PluginGameLive", withCurrentState$plugin_gamelive_release(s.X("zbql:update isLiving: ", Boolean.valueOf(paramBoolean))));
      Jds.putBoolean("isLiving", paramBoolean);
    }
    AppMethodBeat.o(277276);
  }
  
  public final void execute(g paramg)
  {
    int j = 1;
    AppMethodBeat.i(277361);
    if ((paramg != null) && (paramg.bbA() == true)) {}
    for (int i = 1; i != 0; i = 0)
    {
      this.Jdp.alive();
      this.Jdi = new a();
      this.Jdj = new com.tencent.mm.plugin.gamelive.a.d();
      this.Jdk = new com.tencent.mm.plugin.gamelive.render.b();
      h.b(c.class, (com.tencent.mm.kernel.c.a)this.Jdi);
      h.b(com.tencent.mm.plugin.gamelive.a.f.class, (com.tencent.mm.kernel.c.a)this.Jdj);
      h.b(com.tencent.mm.plugin.gamelive.render.f.class, (com.tencent.mm.kernel.c.a)this.Jdk);
      AppMethodBeat.o(277361);
      return;
    }
    if ((paramg != null) && (paramg.FI(":appbrand") == true)) {}
    for (i = j;; i = 0)
    {
      if (i != 0)
      {
        this.Jdl = new GameLiveAppbrandProcessService();
        this.Jdm = new com.tencent.mm.plugin.gamelive.a.a();
        this.Jdn = new GameLiveAppbrandRenderMgrService();
        h.b(b.class, (com.tencent.mm.kernel.c.a)this.Jdl);
        h.b(com.tencent.mm.plugin.gamelive.a.e.class, (com.tencent.mm.kernel.c.a)this.Jdm);
        h.b(com.tencent.mm.plugin.gamelive.render.e.class, (com.tencent.mm.kernel.c.a)this.Jdn);
      }
      AppMethodBeat.o(277361);
      return;
    }
  }
  
  public final String getAppBrandPackageName$plugin_gamelive_release()
  {
    AppMethodBeat.i(277412);
    this.Jdq = Jds.getString("appbrandPackageName", "");
    String str = this.Jdq;
    AppMethodBeat.o(277412);
    return str;
  }
  
  public final com.tencent.mm.plugin.gamelive.a.a getAppbrandProcessAudioService$plugin_gamelive_release()
  {
    return this.Jdm;
  }
  
  public final GameLiveAppbrandRenderMgrService getAppbrandProcessRenderService$plugin_gamelive_release()
  {
    return this.Jdn;
  }
  
  public final GameLiveAppbrandProcessService getAppbrandProcessService$plugin_gamelive_release()
  {
    return this.Jdl;
  }
  
  public final boolean getDisableLiveInfo$plugin_gamelive_release()
  {
    AppMethodBeat.i(277436);
    boolean bool = Jds.getBoolean("disableLiveInfo", false);
    AppMethodBeat.o(277436);
    return bool;
  }
  
  public final boolean getDisableMicInfo$plugin_gamelive_release()
  {
    AppMethodBeat.i(277425);
    boolean bool = Jds.getBoolean("disableMicInfo", false);
    AppMethodBeat.o(277425);
    return bool;
  }
  
  public final boolean getEnableAudioDebug()
  {
    AppMethodBeat.i(277354);
    boolean bool = ((Boolean)this.Jdo.getValue()).booleanValue();
    AppMethodBeat.o(277354);
    return bool;
  }
  
  public final String getGameLiveAnchorHeadUrl$plugin_gamelive_release()
  {
    AppMethodBeat.i(277520);
    String str = Jds.getString("Game_Live_anchorHeadUrl", "");
    AppMethodBeat.o(277520);
    return str;
  }
  
  public final b getGameLiveCurrentState_$plugin_gamelive_release()
  {
    AppMethodBeat.i(277613);
    Object localObject = b.Jdt;
    switch (Jds.getInt("gameLiveCurrentState_", 0))
    {
    default: 
      localObject = b.Jdu;
      AppMethodBeat.o(277613);
      return localObject;
    case 1: 
      localObject = b.Jdv;
      AppMethodBeat.o(277613);
      return localObject;
    case 2: 
      localObject = b.Jdw;
      AppMethodBeat.o(277613);
      return localObject;
    case 3: 
      localObject = b.Jdx;
      AppMethodBeat.o(277613);
      return localObject;
    }
    localObject = b.Jdy;
    AppMethodBeat.o(277613);
    return localObject;
  }
  
  public final String getGameLiveFinderUsrName$plugin_gamelive_release()
  {
    AppMethodBeat.i(277532);
    String str = Jds.getString("Game_Live_finderUsrName", "");
    AppMethodBeat.o(277532);
    return str;
  }
  
  public final String getGameLiveJoinLiveTips$plugin_gamelive_release()
  {
    AppMethodBeat.i(277510);
    String str = Jds.getString("Game_Live_joinLiveTips", "");
    AppMethodBeat.o(277510);
    return str;
  }
  
  public final long getGameLiveLiveId$plugin_gamelive_release()
  {
    AppMethodBeat.i(277556);
    long l = Jds.getLong("Game_Live_liveId", 0L);
    AppMethodBeat.o(277556);
    return l;
  }
  
  public final String getGameLiveNickname$plugin_gamelive_release()
  {
    AppMethodBeat.i(277498);
    String str = Jds.getString("Game_Live_Nickname", "");
    AppMethodBeat.o(277498);
    return str;
  }
  
  public final PluginGameLive.d getGameLivePrepareScene_$plugin_gamelive_release()
  {
    AppMethodBeat.i(277626);
    Object localObject = PluginGameLive.d.Jee;
    switch (Jds.getInt("gameLivePrepareScene", 0))
    {
    default: 
      localObject = PluginGameLive.d.Jeg;
      AppMethodBeat.o(277626);
      return localObject;
    case 1: 
      localObject = PluginGameLive.d.Jeh;
      AppMethodBeat.o(277626);
      return localObject;
    }
    localObject = PluginGameLive.d.Jei;
    AppMethodBeat.o(277626);
    return localObject;
  }
  
  public final com.tencent.mm.plugin.gamelive.a.d getMainProcessAudioService$plugin_gamelive_release()
  {
    return this.Jdj;
  }
  
  public final com.tencent.mm.plugin.gamelive.render.b getMainProcessRenderService$plugin_gamelive_release()
  {
    return this.Jdk;
  }
  
  public final a getMainProcessService$plugin_gamelive_release()
  {
    return this.Jdi;
  }
  
  public final String getOnLiveAppId$plugin_gamelive_release()
  {
    AppMethodBeat.i(277378);
    String str = Jds.getString("onLiveAppId", null);
    AppMethodBeat.o(277378);
    return str;
  }
  
  public final String getOnLiveAppIdForCrashCheck$plugin_gamelive_release()
  {
    AppMethodBeat.i(277581);
    String str = Jds.getString("onLiveAppIdForCrashCheck", "");
    AppMethodBeat.o(277581);
    return str;
  }
  
  public final boolean getOnLiveCrashReset$plugin_gamelive_release()
  {
    AppMethodBeat.i(277599);
    boolean bool = Jds.getBoolean("onLiveCrashReset", false);
    AppMethodBeat.o(277599);
    return bool;
  }
  
  public final int getOnLiveVersionType$plugin_gamelive_release()
  {
    AppMethodBeat.i(277392);
    int i = Jds.getInt("onLiveVersionType", 0);
    AppMethodBeat.o(277392);
    return i;
  }
  
  public final int getOnLiveVersionTypeForCrashCheck$plugin_gamelive_release()
  {
    AppMethodBeat.i(277594);
    int i = Jds.getInt("onLiveVersionTypeForCrashCheck", 0);
    AppMethodBeat.o(277594);
    return i;
  }
  
  public final boolean getOnLivingStatusForCrashCheck$plugin_gamelive_release()
  {
    AppMethodBeat.i(277565);
    boolean bool = Jds.getBoolean("onLivingStatusForCrashCheck", false);
    AppMethodBeat.o(277565);
    return bool;
  }
  
  public final boolean getOnLivingStatusForCrashCheckTemp$plugin_gamelive_release()
  {
    return this.Jdr;
  }
  
  public final String getWxaGameExportId$plugin_gamelive_release()
  {
    AppMethodBeat.i(277544);
    String str = Jds.getString("Game_Live_finderGameExportId", "");
    AppMethodBeat.o(277544);
    return str;
  }
  
  public final Boolean isGameLiving(String paramString, int paramInt)
  {
    AppMethodBeat.i(277467);
    s.u(paramString, "appId");
    if ((s.p(getOnLiveAppId$plugin_gamelive_release(), paramString)) && (getOnLiveVersionType$plugin_gamelive_release() == paramInt) && (isLiving())) {}
    for (boolean bool = true;; bool = false)
    {
      AppMethodBeat.o(277467);
      return Boolean.valueOf(bool);
    }
  }
  
  public final boolean isPushing$plugin_gamelive_release()
  {
    AppMethodBeat.i(277403);
    boolean bool = Jds.getBoolean("isPushing", false);
    AppMethodBeat.o(277403);
    return bool;
  }
  
  public final void onAccountInitialized(f.c paramc)
  {
    AppMethodBeat.i(277368);
    if (MMApplicationContext.isMainProcess())
    {
      Log.i("MicroMsg.PluginGameLive", "onAccountInitialized");
      resetState$plugin_gamelive_release();
      this.Jdr = getOnLivingStatusForCrashCheck$plugin_gamelive_release();
    }
    AppMethodBeat.o(277368);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(277373);
    Log.i("MicroMsg.PluginGameLive", "onAccountRelease");
    AppMethodBeat.o(277373);
  }
  
  public final void resetCrashCheckParam$plugin_gamelive_release()
  {
    AppMethodBeat.i(277608);
    setOnLivingStatusForCrashCheck$plugin_gamelive_release(false);
    setOnLiveAppIdForCrashCheck$plugin_gamelive_release("");
    setOnLiveVersionTypeForCrashCheck$plugin_gamelive_release(0);
    AppMethodBeat.o(277608);
  }
  
  public final void resetState$plugin_gamelive_release()
  {
    AppMethodBeat.i(277460);
    Log.i("MicroMsg.PluginGameLive", withCurrentState$plugin_gamelive_release("resetState"));
    setOnLiveAppId$plugin_gamelive_release("");
    this.Jdq = "";
    setOnLiveVersionType$plugin_gamelive_release(0);
    setPushing$plugin_gamelive_release(false);
    setDisableMicInfo$plugin_gamelive_release(false);
    setDisableLiveInfo$plugin_gamelive_release(false);
    setGameLiveCurrentState_$plugin_gamelive_release(b.Jdu);
    setGameLivePrepareScene_$plugin_gamelive_release(PluginGameLive.d.Jeg);
    updateIsLivingState$plugin_gamelive_release();
    AppMethodBeat.o(277460);
  }
  
  public final void setAppBrandPackageName$plugin_gamelive_release(String paramString)
  {
    AppMethodBeat.i(277419);
    s.u(paramString, "name");
    Log.i("MicroMsg.PluginGameLive", s.X("zbql:setAppBrandPackageName,", paramString));
    this.Jdq = paramString;
    Jds.putString("appbrandPackageName", paramString);
    AppMethodBeat.o(277419);
  }
  
  public final void setAppbrandProcessAudioService$plugin_gamelive_release(com.tencent.mm.plugin.gamelive.a.a parama)
  {
    this.Jdm = parama;
  }
  
  public final void setAppbrandProcessRenderService$plugin_gamelive_release(GameLiveAppbrandRenderMgrService paramGameLiveAppbrandRenderMgrService)
  {
    this.Jdn = paramGameLiveAppbrandRenderMgrService;
  }
  
  public final void setAppbrandProcessService$plugin_gamelive_release(GameLiveAppbrandProcessService paramGameLiveAppbrandProcessService)
  {
    this.Jdl = paramGameLiveAppbrandProcessService;
  }
  
  public final void setDisableLiveInfo$plugin_gamelive_release(boolean paramBoolean)
  {
    AppMethodBeat.i(277444);
    Jds.putBoolean("disableLiveInfo", paramBoolean);
    AppMethodBeat.o(277444);
  }
  
  public final void setDisableMicInfo$plugin_gamelive_release(boolean paramBoolean)
  {
    AppMethodBeat.i(277428);
    Jds.putBoolean("disableMicInfo", paramBoolean);
    AppMethodBeat.o(277428);
  }
  
  public final void setGameLiveAnchorHeadUrl$plugin_gamelive_release(String paramString)
  {
    AppMethodBeat.i(277526);
    Jds.putString("Game_Live_anchorHeadUrl", paramString);
    AppMethodBeat.o(277526);
  }
  
  public final void setGameLiveCurrentState_$plugin_gamelive_release(b paramb)
  {
    AppMethodBeat.i(277618);
    if (paramb != null) {
      Jds.putInt("gameLiveCurrentState_", paramb.position);
    }
    AppMethodBeat.o(277618);
  }
  
  public final void setGameLiveFinderUsrName$plugin_gamelive_release(String paramString)
  {
    AppMethodBeat.i(277537);
    Jds.putString("Game_Live_finderUsrName", paramString);
    AppMethodBeat.o(277537);
  }
  
  public final void setGameLiveJoinLiveTips$plugin_gamelive_release(String paramString)
  {
    AppMethodBeat.i(277515);
    Jds.putString("Game_Live_joinLiveTips", paramString);
    AppMethodBeat.o(277515);
  }
  
  public final void setGameLiveLiveId$plugin_gamelive_release(long paramLong)
  {
    AppMethodBeat.i(277559);
    Jds.putLong("Game_Live_liveId", paramLong);
    AppMethodBeat.o(277559);
  }
  
  public final void setGameLiveNickname$plugin_gamelive_release(String paramString)
  {
    AppMethodBeat.i(277505);
    Jds.putString("Game_Live_Nickname", paramString);
    AppMethodBeat.o(277505);
  }
  
  public final void setGameLivePrepareScene_$plugin_gamelive_release(PluginGameLive.d paramd)
  {
    AppMethodBeat.i(277634);
    if (paramd != null) {
      Jds.putInt("gameLivePrepareScene", paramd.Jef);
    }
    AppMethodBeat.o(277634);
  }
  
  public final void setLiveInfoEvent(boolean paramBoolean)
  {
    AppMethodBeat.i(277452);
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      setDisableLiveInfo$plugin_gamelive_release(paramBoolean);
      AppMethodBeat.o(277452);
      return;
    }
  }
  
  public final void setMainProcessAudioService$plugin_gamelive_release(com.tencent.mm.plugin.gamelive.a.d paramd)
  {
    this.Jdj = paramd;
  }
  
  public final void setMainProcessRenderService$plugin_gamelive_release(com.tencent.mm.plugin.gamelive.render.b paramb)
  {
    this.Jdk = paramb;
  }
  
  public final void setMainProcessService$plugin_gamelive_release(a parama)
  {
    this.Jdi = parama;
  }
  
  public final void setMicInfoEvent(boolean paramBoolean)
  {
    AppMethodBeat.i(277432);
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      setDisableMicInfo$plugin_gamelive_release(paramBoolean);
      AppMethodBeat.o(277432);
      return;
    }
  }
  
  public final void setOnLiveAppId$plugin_gamelive_release(String paramString)
  {
    AppMethodBeat.i(277382);
    Jds.putString("onLiveAppId", paramString);
    if (MMApplicationContext.isMainProcess()) {
      setLiving(((com.tencent.d.a.a.a.b)h.az(com.tencent.d.a.a.a.b.class)).isAnchorLiving());
    }
    AppMethodBeat.o(277382);
  }
  
  public final void setOnLiveAppIdForCrashCheck$plugin_gamelive_release(String paramString)
  {
    AppMethodBeat.i(277586);
    Jds.putString("onLiveAppIdForCrashCheck", paramString);
    AppMethodBeat.o(277586);
  }
  
  public final void setOnLiveCrashReset$plugin_gamelive_release(boolean paramBoolean)
  {
    AppMethodBeat.i(277603);
    Jds.putBoolean("onLiveCrashReset", paramBoolean);
    AppMethodBeat.o(277603);
  }
  
  public final void setOnLiveVersionType$plugin_gamelive_release(int paramInt)
  {
    AppMethodBeat.i(277396);
    Jds.putInt("onLiveVersionType", paramInt);
    AppMethodBeat.o(277396);
  }
  
  public final void setOnLiveVersionTypeForCrashCheck$plugin_gamelive_release(int paramInt)
  {
    AppMethodBeat.i(277596);
    Jds.putInt("onLiveVersionTypeForCrashCheck", paramInt);
    AppMethodBeat.o(277596);
  }
  
  public final void setOnLivingStatusForCrashCheck$plugin_gamelive_release(boolean paramBoolean)
  {
    AppMethodBeat.i(277570);
    Jds.putBoolean("onLivingStatusForCrashCheck", paramBoolean);
    AppMethodBeat.o(277570);
  }
  
  public final void setOnLivingStatusForCrashCheckTemp$plugin_gamelive_release(boolean paramBoolean)
  {
    this.Jdr = paramBoolean;
  }
  
  public final void setPushing$plugin_gamelive_release(boolean paramBoolean)
  {
    AppMethodBeat.i(277407);
    Jds.putBoolean("isPushing", paramBoolean);
    AppMethodBeat.o(277407);
  }
  
  public final void setWxaGameExportId$plugin_gamelive_release(String paramString)
  {
    AppMethodBeat.i(277550);
    Jds.putString("Game_Live_finderGameExportId", paramString);
    AppMethodBeat.o(277550);
  }
  
  public final void startGameLivePrepare$plugin_gamelive_release()
  {
    AppMethodBeat.i(277492);
    a locala = this.Jdi;
    if (locala != null) {
      locala.fIN();
    }
    AppMethodBeat.o(277492);
  }
  
  public final void updateIsLivingState$plugin_gamelive_release()
  {
    AppMethodBeat.i(277476);
    isLiving();
    AppMethodBeat.o(277476);
  }
  
  public final String withCurrentState$plugin_gamelive_release(String paramString)
  {
    AppMethodBeat.i(277486);
    s.u(paramString, "<this>");
    paramString = paramString + " [appId:" + getOnLiveAppId$plugin_gamelive_release() + " versionType:" + getOnLiveVersionType$plugin_gamelive_release() + ']';
    AppMethodBeat.o(277486);
    return paramString;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/gamelive/PluginGameLive$IPCLiveControlData$IPCLiveControlAction;", "", "(Ljava/lang/String;I)V", "IPCLiveControlActionUnknown", "IPCLiveControlActionSyncLiveState", "IPCLiveControlActionStartPush", "IPCLiveControlActionStopPush", "IPCLiveControlActionMinimizeGameLive", "IPCLiveControlActionHideMinimizeGameLive", "IPCLiveControlActionSetOnScreenSurfaceTexture", "IPCLiveControlActionGetInputSurfaceTexture", "IPCLiveControlActionSetSize", "IPCLiveControlActionGetMemberList", "IPCLiveControlActionGetCurrentRoomInfo", "IPCLiveControlActionResumeLive", "IPCLiveControlActionPauseLive", "IPCLiveControlActionEnableMute", "IPCLiveControlActionDisableMute", "IPCLiveControlActionSendVolumnCallBackDuration", "IPCLiveControlActionAudioReconnect", "IPCLiveControlActionPlayGameCgi", "IPCLiveControlActionPlayGamePanelShowReport", "IPCLiveControlActionSetTopic", "IPCLiveEventUserCancel", "IPCLiveEventUserStopLiveFromFinderLive", "IPCLiveEventLiveDidStart", "IPCLiveShareToFriendCallBack", "IPCLiveSendCommentInfo", "IPCLiveSendVolumnInfo", "IPCLiveSendNetWorkInfo", "plugin-gamelive_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum IPCLiveControlData$b
  {
    static
    {
      AppMethodBeat.i(277218);
      JdC = new b("IPCLiveControlActionUnknown", 0);
      JdD = new b("IPCLiveControlActionSyncLiveState", 1);
      JdE = new b("IPCLiveControlActionStartPush", 2);
      JdF = new b("IPCLiveControlActionStopPush", 3);
      JdG = new b("IPCLiveControlActionMinimizeGameLive", 4);
      JdH = new b("IPCLiveControlActionHideMinimizeGameLive", 5);
      JdI = new b("IPCLiveControlActionSetOnScreenSurfaceTexture", 6);
      JdJ = new b("IPCLiveControlActionGetInputSurfaceTexture", 7);
      JdK = new b("IPCLiveControlActionSetSize", 8);
      JdL = new b("IPCLiveControlActionGetMemberList", 9);
      JdM = new b("IPCLiveControlActionGetCurrentRoomInfo", 10);
      JdN = new b("IPCLiveControlActionResumeLive", 11);
      JdO = new b("IPCLiveControlActionPauseLive", 12);
      JdP = new b("IPCLiveControlActionEnableMute", 13);
      JdQ = new b("IPCLiveControlActionDisableMute", 14);
      JdR = new b("IPCLiveControlActionSendVolumnCallBackDuration", 15);
      JdS = new b("IPCLiveControlActionAudioReconnect", 16);
      JdT = new b("IPCLiveControlActionPlayGameCgi", 17);
      JdU = new b("IPCLiveControlActionPlayGamePanelShowReport", 18);
      JdV = new b("IPCLiveControlActionSetTopic", 19);
      JdW = new b("IPCLiveEventUserCancel", 20);
      JdX = new b("IPCLiveEventUserStopLiveFromFinderLive", 21);
      JdY = new b("IPCLiveEventLiveDidStart", 22);
      JdZ = new b("IPCLiveShareToFriendCallBack", 23);
      Jea = new b("IPCLiveSendCommentInfo", 24);
      Jeb = new b("IPCLiveSendVolumnInfo", 25);
      Jec = new b("IPCLiveSendNetWorkInfo", 26);
      Jed = new b[] { JdC, JdD, JdE, JdF, JdG, JdH, JdI, JdJ, JdK, JdL, JdM, JdN, JdO, JdP, JdQ, JdR, JdS, JdT, JdU, JdV, JdW, JdX, JdY, JdZ, Jea, Jeb, Jec };
      AppMethodBeat.o(277218);
    }
    
    private IPCLiveControlData$b() {}
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/gamelive/PluginGameLive$GameLiveCurrentState;", "", "position", "", "(Ljava/lang/String;II)V", "getPosition", "()I", "getStateString", "", "GameLiveState_NotInited", "GameLiveState_PrePare", "GameLiveState_LivingForeGround", "GameLiveState_LivingBackGround", "GameLiveState_Destroy", "Companion", "plugin-gamelive_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum b
  {
    public static final PluginGameLive.b.a Jdt;
    final int position;
    
    static
    {
      AppMethodBeat.i(277257);
      Jdu = new b("GameLiveState_NotInited", 0, 0);
      Jdv = new b("GameLiveState_PrePare", 1, 1);
      Jdw = new b("GameLiveState_LivingForeGround", 2, 2);
      Jdx = new b("GameLiveState_LivingBackGround", 3, 3);
      Jdy = new b("GameLiveState_Destroy", 4, 4);
      Jdz = new b[] { Jdu, Jdv, Jdw, Jdx, Jdy };
      Jdt = new PluginGameLive.b.a((byte)0);
      AppMethodBeat.o(277257);
    }
    
    private b(int paramInt)
    {
      this.position = paramInt;
    }
    
    public final String fIR()
    {
      switch (this.position)
      {
      default: 
        return "unknown";
      case 0: 
        return "GameLiveState_NotInited";
      case 1: 
        return "GameLiveState_PrePare";
      case 2: 
        return "GameLiveState_LivingForeGround";
      case 3: 
        return "GameLiveState_LivingBackGround";
      }
      return "GameLiveState_Destroy";
    }
  }
  
  @com.tencent.mm.ipcinvoker.c.a
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/gamelive/PluginGameLive$IPCLiveControlTask;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/plugin/gamelive/PluginGameLive$IPCLiveControlData;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-gamelive_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements com.tencent.mm.ipcinvoker.d<PluginGameLive.IPCLiveControlData, PluginGameLive.IPCLiveControlData>
  {
    private static final void a(com.tencent.mm.ipcinvoker.f paramf, Surface paramSurface)
    {
      AppMethodBeat.i(277263);
      if (paramf != null) {
        paramf.onCallback(new PluginGameLive.IPCLiveControlData(PluginGameLive.IPCLiveControlData.b.JdC, null, (Parcelable)paramSurface, 6));
      }
      AppMethodBeat.o(277263);
    }
    
    @Metadata(d1={""}, d2={"com/tencent/mm/plugin/gamelive/PluginGameLive$IPCLiveControlTask$invoke$3", "Lcom/tencent/plugin/finder/live/api/IPluginFinderLive$IGameLiveActionCallBack;", "getErrCode", "", "errCode", "", "plugin-gamelive_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class b
      implements b.e
    {
      b(com.tencent.mm.ipcinvoker.f<PluginGameLive.IPCLiveControlData> paramf) {}
      
      public final void XZ(int paramInt)
      {
        AppMethodBeat.i(277286);
        GameLiveAppbrandEventService.LiveIntPayload localLiveIntPayload = new GameLiveAppbrandEventService.LiveIntPayload(paramInt);
        com.tencent.mm.ipcinvoker.f localf = this.mht;
        if (localf != null) {
          localf.onCallback(new PluginGameLive.IPCLiveControlData(PluginGameLive.IPCLiveControlData.b.JdC, null, (Parcelable)localLiveIntPayload, 6));
        }
        AppMethodBeat.o(277286);
      }
    }
    
    @Metadata(d1={""}, d2={"com/tencent/mm/plugin/gamelive/PluginGameLive$IPCLiveControlTask$invoke$4", "Lcom/tencent/mm/plugin/gamelive/GameLiveMainProcessService$ISetTopicCallback;", "callback", "", "ret", "", "errMsg", "", "plugin-gamelive_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class c
      implements a.c
    {
      c(com.tencent.mm.ipcinvoker.f<PluginGameLive.IPCLiveControlData> paramf) {}
      
      public final void ao(boolean paramBoolean, String paramString)
      {
        AppMethodBeat.i(277291);
        paramString = new GameLiveAppbrandEventService.LiveTopicPayload("", paramBoolean, paramString);
        com.tencent.mm.ipcinvoker.f localf = this.mht;
        if (localf != null) {
          localf.onCallback(new PluginGameLive.IPCLiveControlData(PluginGameLive.IPCLiveControlData.b.JdV, null, (Parcelable)paramString, 6));
        }
        AppMethodBeat.o(277291);
      }
    }
    
    @Metadata(d1={""}, d2={"com/tencent/mm/plugin/gamelive/PluginGameLive$IPCLiveControlTask$invoke$getMemberListCallback$1", "Lcom/tencent/mm/plugin/gamelive/GameLiveMainProcessService$IGetMemberListCallback;", "getMemberList", "", "list", "Lcom/tencent/mm/plugin/gamelive/event/GameLiveAppbrandEventService$LiveMemberInfoListPayload;", "plugin-gamelive_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class d
      implements a.b
    {
      d(com.tencent.mm.ipcinvoker.f<PluginGameLive.IPCLiveControlData> paramf) {}
      
      public final void a(GameLiveAppbrandEventService.LiveMemberInfoListPayload paramLiveMemberInfoListPayload)
      {
        AppMethodBeat.i(277280);
        s.u(paramLiveMemberInfoListPayload, "list");
        com.tencent.mm.ipcinvoker.f localf = this.mht;
        if (localf != null) {
          localf.onCallback(new PluginGameLive.IPCLiveControlData(PluginGameLive.IPCLiveControlData.b.JdC, null, (Parcelable)paramLiveMemberInfoListPayload, 6));
        }
        AppMethodBeat.o(277280);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelive.PluginGameLive
 * JD-Core Version:    0.7.0.1
 */