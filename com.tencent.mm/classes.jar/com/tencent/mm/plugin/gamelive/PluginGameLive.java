package com.tencent.mm.plugin.gamelive;

import android.os.Parcelable;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.gamelive.render.GameLiveAppbrandRenderMgrService;
import com.tencent.mm.plugin.gamelive.render.g.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/gamelive/PluginGameLive;", "Lcom/tencent/mm/kernel/plugin/Plugin;", "Lcom/tencent/mm/plugin/gamelive/IPluginGameLive;", "Lcom/tencent/mm/kernel/api/ICoreAccountCallback;", "()V", "appbrandPackageName", "", "appbrandProcessAudioService", "Lcom/tencent/mm/plugin/gamelive/audio/GameLiveAppbrandAudioMgrService;", "getAppbrandProcessAudioService$plugin_gamelive_release", "()Lcom/tencent/mm/plugin/gamelive/audio/GameLiveAppbrandAudioMgrService;", "setAppbrandProcessAudioService$plugin_gamelive_release", "(Lcom/tencent/mm/plugin/gamelive/audio/GameLiveAppbrandAudioMgrService;)V", "appbrandProcessRenderService", "Lcom/tencent/mm/plugin/gamelive/render/GameLiveAppbrandRenderMgrService;", "getAppbrandProcessRenderService$plugin_gamelive_release", "()Lcom/tencent/mm/plugin/gamelive/render/GameLiveAppbrandRenderMgrService;", "setAppbrandProcessRenderService$plugin_gamelive_release", "(Lcom/tencent/mm/plugin/gamelive/render/GameLiveAppbrandRenderMgrService;)V", "appbrandProcessService", "Lcom/tencent/mm/plugin/gamelive/GameLiveAppbrandProcessService;", "getAppbrandProcessService$plugin_gamelive_release", "()Lcom/tencent/mm/plugin/gamelive/GameLiveAppbrandProcessService;", "setAppbrandProcessService$plugin_gamelive_release", "(Lcom/tencent/mm/plugin/gamelive/GameLiveAppbrandProcessService;)V", "value", "", "disableLiveInfo", "getDisableLiveInfo$plugin_gamelive_release", "()Z", "setDisableLiveInfo$plugin_gamelive_release", "(Z)V", "disableMicInfo", "getDisableMicInfo$plugin_gamelive_release", "setDisableMicInfo$plugin_gamelive_release", "enableAudioDebug", "getEnableAudioDebug", "enableAudioDebug$delegate", "Lkotlin/Lazy;", "gameLiveAnchorHeadUrl", "getGameLiveAnchorHeadUrl$plugin_gamelive_release", "()Ljava/lang/String;", "setGameLiveAnchorHeadUrl$plugin_gamelive_release", "(Ljava/lang/String;)V", "Lcom/tencent/mm/plugin/gamelive/PluginGameLive$GameLiveCurrentState;", "gameLiveCurrentState_", "getGameLiveCurrentState_$plugin_gamelive_release", "()Lcom/tencent/mm/plugin/gamelive/PluginGameLive$GameLiveCurrentState;", "setGameLiveCurrentState_$plugin_gamelive_release", "(Lcom/tencent/mm/plugin/gamelive/PluginGameLive$GameLiveCurrentState;)V", "gameLiveFinderUsrName", "getGameLiveFinderUsrName$plugin_gamelive_release", "setGameLiveFinderUsrName$plugin_gamelive_release", "gameLiveJoinLiveTips", "getGameLiveJoinLiveTips$plugin_gamelive_release", "setGameLiveJoinLiveTips$plugin_gamelive_release", "", "gameLiveLiveId", "getGameLiveLiveId$plugin_gamelive_release", "()J", "setGameLiveLiveId$plugin_gamelive_release", "(J)V", "gameLiveNickname", "getGameLiveNickname$plugin_gamelive_release", "setGameLiveNickname$plugin_gamelive_release", "Lcom/tencent/mm/plugin/gamelive/PluginGameLive$PrePareScene;", "gameLivePrepareScene_", "getGameLivePrepareScene_$plugin_gamelive_release", "()Lcom/tencent/mm/plugin/gamelive/PluginGameLive$PrePareScene;", "setGameLivePrepareScene_$plugin_gamelive_release", "(Lcom/tencent/mm/plugin/gamelive/PluginGameLive$PrePareScene;)V", "isLiving", "setLiving", "isPushing", "isPushing$plugin_gamelive_release", "setPushing$plugin_gamelive_release", "liveFinishListener", "com/tencent/mm/plugin/gamelive/PluginGameLive$liveFinishListener$1", "Lcom/tencent/mm/plugin/gamelive/PluginGameLive$liveFinishListener$1;", "mainProcessAudioService", "Lcom/tencent/mm/plugin/gamelive/audio/GameLiveMainAudioMgrService;", "getMainProcessAudioService$plugin_gamelive_release", "()Lcom/tencent/mm/plugin/gamelive/audio/GameLiveMainAudioMgrService;", "setMainProcessAudioService$plugin_gamelive_release", "(Lcom/tencent/mm/plugin/gamelive/audio/GameLiveMainAudioMgrService;)V", "mainProcessRenderService", "Lcom/tencent/mm/plugin/gamelive/render/GameLiveMainRenderMgrService;", "getMainProcessRenderService$plugin_gamelive_release", "()Lcom/tencent/mm/plugin/gamelive/render/GameLiveMainRenderMgrService;", "setMainProcessRenderService$plugin_gamelive_release", "(Lcom/tencent/mm/plugin/gamelive/render/GameLiveMainRenderMgrService;)V", "mainProcessService", "Lcom/tencent/mm/plugin/gamelive/GameLiveMainProcessService;", "getMainProcessService$plugin_gamelive_release", "()Lcom/tencent/mm/plugin/gamelive/GameLiveMainProcessService;", "setMainProcessService$plugin_gamelive_release", "(Lcom/tencent/mm/plugin/gamelive/GameLiveMainProcessService;)V", "onLiveAppId", "getOnLiveAppId$plugin_gamelive_release", "setOnLiveAppId$plugin_gamelive_release", "onLiveAppIdForCrashCheck", "getOnLiveAppIdForCrashCheck$plugin_gamelive_release", "setOnLiveAppIdForCrashCheck$plugin_gamelive_release", "onLiveCrashReset", "getOnLiveCrashReset$plugin_gamelive_release", "setOnLiveCrashReset$plugin_gamelive_release", "", "onLiveVersionType", "getOnLiveVersionType$plugin_gamelive_release", "()I", "setOnLiveVersionType$plugin_gamelive_release", "(I)V", "onLiveVersionTypeForCrashCheck", "getOnLiveVersionTypeForCrashCheck$plugin_gamelive_release", "setOnLiveVersionTypeForCrashCheck$plugin_gamelive_release", "onLivingStatusForCrashCheck", "getOnLivingStatusForCrashCheck$plugin_gamelive_release", "setOnLivingStatusForCrashCheck$plugin_gamelive_release", "onLivingStatusForCrashCheckTemp", "getOnLivingStatusForCrashCheckTemp$plugin_gamelive_release", "setOnLivingStatusForCrashCheckTemp$plugin_gamelive_release", "execute", "", "profile", "Lcom/tencent/mm/kernel/plugin/ProcessProfile;", "getAppBrandPackageName", "getAppBrandPackageName$plugin_gamelive_release", "isGameLiving", "appId", "versionType", "onAccountInitialized", "upgrade", "Lcom/tencent/mm/kernel/CoreStorage$UpgradeInfo;", "onAccountRelease", "resetCrashCheckParam", "resetCrashCheckParam$plugin_gamelive_release", "resetState", "resetState$plugin_gamelive_release", "setAppBrandPackageName", "name", "setAppBrandPackageName$plugin_gamelive_release", "setLiveInfoEvent", "isLiveEventNotify", "setMicInfoEvent", "isMicEventNotify", "startGameLivePrepare", "startGameLivePrepare$plugin_gamelive_release", "updateIsLivingState", "updateIsLivingState$plugin_gamelive_release", "withCurrentState", "withCurrentState$plugin_gamelive_release", "Companion", "GameLiveCurrentState", "IPCLiveControlData", "IPCLiveControlTask", "PrePareScene", "plugin-gamelive_release"})
public final class PluginGameLive
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.kernel.api.c, e
{
  private static final MultiProcessMMKV Dkk;
  public static final PluginGameLive.a Dkl;
  private b Dka;
  private com.tencent.mm.plugin.gamelive.a.d Dkb;
  private com.tencent.mm.plugin.gamelive.render.b Dkc;
  private GameLiveAppbrandProcessService Dkd;
  private com.tencent.mm.plugin.gamelive.a.a Dke;
  private GameLiveAppbrandRenderMgrService Dkf;
  private final kotlin.f Dkg;
  private final PluginGameLive.f Dkh;
  private String Dki;
  private boolean Dkj;
  private boolean kGE;
  
  static
  {
    AppMethodBeat.i(208319);
    Dkl = new PluginGameLive.a((byte)0);
    Dkk = MultiProcessMMKV.getMMKV("PluginGameLive");
    AppMethodBeat.o(208319);
  }
  
  public PluginGameLive()
  {
    AppMethodBeat.i(208318);
    this.Dkg = kotlin.g.ar((kotlin.g.a.a)PluginGameLive.e.Dla);
    this.Dkh = new PluginGameLive.f(this);
    AppMethodBeat.o(208318);
  }
  
  private final boolean isLiving()
  {
    AppMethodBeat.i(208214);
    if (MMApplicationContext.isMainProcess()) {}
    for (boolean bool = ((com.tencent.c.a.a.a.b)h.ag(com.tencent.c.a.a.a.b.class)).isAnchorLiving();; bool = Dkk.getBoolean("isLiving", false))
    {
      setLiving(bool);
      bool = this.kGE;
      AppMethodBeat.o(208214);
      return bool;
    }
  }
  
  private final void setLiving(boolean paramBoolean)
  {
    AppMethodBeat.i(208216);
    this.kGE = paramBoolean;
    if (MMApplicationContext.isMainProcess())
    {
      Log.i("MicroMsg.PluginGameLive", withCurrentState$plugin_gamelive_release("zbql:update isLiving: ".concat(String.valueOf(paramBoolean))));
      Dkk.putBoolean("isLiving", paramBoolean);
    }
    AppMethodBeat.o(208216);
  }
  
  public final void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(208200);
    if ((paramg != null) && (paramg.aIE() == true))
    {
      this.Dkh.alive();
      this.Dka = new b();
      this.Dkb = new com.tencent.mm.plugin.gamelive.a.d();
      this.Dkc = new com.tencent.mm.plugin.gamelive.render.b();
      h.b(d.class, (com.tencent.mm.kernel.c.a)this.Dka);
      h.b(com.tencent.mm.plugin.gamelive.a.f.class, (com.tencent.mm.kernel.c.a)this.Dkb);
      h.b(com.tencent.mm.plugin.gamelive.render.g.class, (com.tencent.mm.kernel.c.a)this.Dkc);
      AppMethodBeat.o(208200);
      return;
    }
    if (paramg != null)
    {
      if (paramg.MZ(":appbrand") == true)
      {
        this.Dkd = new GameLiveAppbrandProcessService();
        this.Dke = new com.tencent.mm.plugin.gamelive.a.a();
        this.Dkf = new GameLiveAppbrandRenderMgrService();
        h.b(c.class, (com.tencent.mm.kernel.c.a)this.Dkd);
        h.b(com.tencent.mm.plugin.gamelive.a.e.class, (com.tencent.mm.kernel.c.a)this.Dke);
        h.b(com.tencent.mm.plugin.gamelive.render.f.class, (com.tencent.mm.kernel.c.a)this.Dkf);
      }
      AppMethodBeat.o(208200);
      return;
    }
    AppMethodBeat.o(208200);
  }
  
  public final String getAppBrandPackageName$plugin_gamelive_release()
  {
    AppMethodBeat.i(208218);
    this.Dki = Dkk.getString("appbrandPackageName", "");
    String str = this.Dki;
    AppMethodBeat.o(208218);
    return str;
  }
  
  public final com.tencent.mm.plugin.gamelive.a.a getAppbrandProcessAudioService$plugin_gamelive_release()
  {
    return this.Dke;
  }
  
  public final GameLiveAppbrandRenderMgrService getAppbrandProcessRenderService$plugin_gamelive_release()
  {
    return this.Dkf;
  }
  
  public final GameLiveAppbrandProcessService getAppbrandProcessService$plugin_gamelive_release()
  {
    return this.Dkd;
  }
  
  public final boolean getDisableLiveInfo$plugin_gamelive_release()
  {
    AppMethodBeat.i(208237);
    boolean bool = Dkk.getBoolean("disableLiveInfo", false);
    AppMethodBeat.o(208237);
    return bool;
  }
  
  public final boolean getDisableMicInfo$plugin_gamelive_release()
  {
    AppMethodBeat.i(208223);
    boolean bool = Dkk.getBoolean("disableMicInfo", false);
    AppMethodBeat.o(208223);
    return bool;
  }
  
  public final boolean getEnableAudioDebug()
  {
    AppMethodBeat.i(208195);
    boolean bool = ((Boolean)this.Dkg.getValue()).booleanValue();
    AppMethodBeat.o(208195);
    return bool;
  }
  
  public final String getGameLiveAnchorHeadUrl$plugin_gamelive_release()
  {
    AppMethodBeat.i(208273);
    String str = Dkk.getString("Game_Live_anchorHeadUrl", "");
    AppMethodBeat.o(208273);
    return str;
  }
  
  public final b getGameLiveCurrentState_$plugin_gamelive_release()
  {
    AppMethodBeat.i(208312);
    Object localObject = b.Dks;
    switch (Dkk.getInt("gameLiveCurrentState_", 0))
    {
    default: 
      localObject = b.Dkm;
      AppMethodBeat.o(208312);
      return localObject;
    case 1: 
      localObject = b.Dkn;
      AppMethodBeat.o(208312);
      return localObject;
    case 2: 
      localObject = b.Dko;
      AppMethodBeat.o(208312);
      return localObject;
    case 3: 
      localObject = b.Dkp;
      AppMethodBeat.o(208312);
      return localObject;
    }
    localObject = b.Dkq;
    AppMethodBeat.o(208312);
    return localObject;
  }
  
  public final String getGameLiveFinderUsrName$plugin_gamelive_release()
  {
    AppMethodBeat.i(208279);
    String str = Dkk.getString("Game_Live_finderUsrName", "");
    AppMethodBeat.o(208279);
    return str;
  }
  
  public final String getGameLiveJoinLiveTips$plugin_gamelive_release()
  {
    AppMethodBeat.i(208267);
    String str = Dkk.getString("Game_Live_joinLiveTips", "");
    AppMethodBeat.o(208267);
    return str;
  }
  
  public final long getGameLiveLiveId$plugin_gamelive_release()
  {
    AppMethodBeat.i(208286);
    long l = Dkk.getLong("Game_Live_liveId", 0L);
    AppMethodBeat.o(208286);
    return l;
  }
  
  public final String getGameLiveNickname$plugin_gamelive_release()
  {
    AppMethodBeat.i(208262);
    String str = Dkk.getString("Game_Live_Nickname", "");
    AppMethodBeat.o(208262);
    return str;
  }
  
  public final PluginGameLive.d getGameLivePrepareScene_$plugin_gamelive_release()
  {
    AppMethodBeat.i(208315);
    Object localObject = PluginGameLive.d.DkZ;
    switch (Dkk.getInt("gameLivePrepareScene", 0))
    {
    default: 
      localObject = PluginGameLive.d.DkU;
      AppMethodBeat.o(208315);
      return localObject;
    case 1: 
      localObject = PluginGameLive.d.DkV;
      AppMethodBeat.o(208315);
      return localObject;
    }
    localObject = PluginGameLive.d.DkW;
    AppMethodBeat.o(208315);
    return localObject;
  }
  
  public final com.tencent.mm.plugin.gamelive.a.d getMainProcessAudioService$plugin_gamelive_release()
  {
    return this.Dkb;
  }
  
  public final com.tencent.mm.plugin.gamelive.render.b getMainProcessRenderService$plugin_gamelive_release()
  {
    return this.Dkc;
  }
  
  public final b getMainProcessService$plugin_gamelive_release()
  {
    return this.Dka;
  }
  
  public final String getOnLiveAppId$plugin_gamelive_release()
  {
    AppMethodBeat.i(208206);
    String str = Dkk.getString("onLiveAppId", null);
    AppMethodBeat.o(208206);
    return str;
  }
  
  public final String getOnLiveAppIdForCrashCheck$plugin_gamelive_release()
  {
    AppMethodBeat.i(208302);
    String str = Dkk.getString("onLiveAppIdForCrashCheck", "");
    AppMethodBeat.o(208302);
    return str;
  }
  
  public final boolean getOnLiveCrashReset$plugin_gamelive_release()
  {
    AppMethodBeat.i(208307);
    boolean bool = Dkk.getBoolean("onLiveCrashReset", false);
    AppMethodBeat.o(208307);
    return bool;
  }
  
  public final int getOnLiveVersionType$plugin_gamelive_release()
  {
    AppMethodBeat.i(208210);
    int i = Dkk.getInt("onLiveVersionType", 0);
    AppMethodBeat.o(208210);
    return i;
  }
  
  public final int getOnLiveVersionTypeForCrashCheck$plugin_gamelive_release()
  {
    AppMethodBeat.i(208305);
    int i = Dkk.getInt("onLiveVersionTypeForCrashCheck", 0);
    AppMethodBeat.o(208305);
    return i;
  }
  
  public final boolean getOnLivingStatusForCrashCheck$plugin_gamelive_release()
  {
    AppMethodBeat.i(208291);
    boolean bool = Dkk.getBoolean("onLivingStatusForCrashCheck", false);
    AppMethodBeat.o(208291);
    return bool;
  }
  
  public final boolean getOnLivingStatusForCrashCheckTemp$plugin_gamelive_release()
  {
    return this.Dkj;
  }
  
  public final boolean isGameLiving(String paramString, int paramInt)
  {
    AppMethodBeat.i(208250);
    p.k(paramString, "appId");
    if ((p.h(getOnLiveAppId$plugin_gamelive_release(), paramString)) && (getOnLiveVersionType$plugin_gamelive_release() == paramInt) && (isLiving()))
    {
      AppMethodBeat.o(208250);
      return true;
    }
    AppMethodBeat.o(208250);
    return false;
  }
  
  public final boolean isPushing$plugin_gamelive_release()
  {
    AppMethodBeat.i(208212);
    boolean bool = Dkk.getBoolean("isPushing", false);
    AppMethodBeat.o(208212);
    return bool;
  }
  
  public final void onAccountInitialized(f.c paramc)
  {
    AppMethodBeat.i(208202);
    if (MMApplicationContext.isMainProcess())
    {
      Log.i("MicroMsg.PluginGameLive", "onAccountInitialized");
      resetState$plugin_gamelive_release();
      this.Dkj = getOnLivingStatusForCrashCheck$plugin_gamelive_release();
    }
    AppMethodBeat.o(208202);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(208203);
    Log.i("MicroMsg.PluginGameLive", "onAccountRelease");
    AppMethodBeat.o(208203);
  }
  
  public final void resetCrashCheckParam$plugin_gamelive_release()
  {
    AppMethodBeat.i(208310);
    setOnLivingStatusForCrashCheck$plugin_gamelive_release(false);
    setOnLiveAppIdForCrashCheck$plugin_gamelive_release("");
    setOnLiveVersionTypeForCrashCheck$plugin_gamelive_release(0);
    AppMethodBeat.o(208310);
  }
  
  public final void resetState$plugin_gamelive_release()
  {
    AppMethodBeat.i(208249);
    Log.i("MicroMsg.PluginGameLive", withCurrentState$plugin_gamelive_release("resetState"));
    setOnLiveAppId$plugin_gamelive_release("");
    this.Dki = "";
    setOnLiveVersionType$plugin_gamelive_release(0);
    setPushing$plugin_gamelive_release(false);
    setDisableMicInfo$plugin_gamelive_release(false);
    setDisableLiveInfo$plugin_gamelive_release(false);
    setGameLiveCurrentState_$plugin_gamelive_release(b.Dkm);
    setGameLivePrepareScene_$plugin_gamelive_release(PluginGameLive.d.DkU);
    updateIsLivingState$plugin_gamelive_release();
    AppMethodBeat.o(208249);
  }
  
  public final void setAppBrandPackageName$plugin_gamelive_release(String paramString)
  {
    AppMethodBeat.i(208220);
    p.k(paramString, "name");
    Log.i("MicroMsg.PluginGameLive", "zbql:setAppBrandPackageName,".concat(String.valueOf(paramString)));
    this.Dki = paramString;
    Dkk.putString("appbrandPackageName", paramString);
    AppMethodBeat.o(208220);
  }
  
  public final void setAppbrandProcessAudioService$plugin_gamelive_release(com.tencent.mm.plugin.gamelive.a.a parama)
  {
    this.Dke = parama;
  }
  
  public final void setAppbrandProcessRenderService$plugin_gamelive_release(GameLiveAppbrandRenderMgrService paramGameLiveAppbrandRenderMgrService)
  {
    this.Dkf = paramGameLiveAppbrandRenderMgrService;
  }
  
  public final void setAppbrandProcessService$plugin_gamelive_release(GameLiveAppbrandProcessService paramGameLiveAppbrandProcessService)
  {
    this.Dkd = paramGameLiveAppbrandProcessService;
  }
  
  public final void setDisableLiveInfo$plugin_gamelive_release(boolean paramBoolean)
  {
    AppMethodBeat.i(208241);
    Dkk.putBoolean("disableLiveInfo", paramBoolean);
    AppMethodBeat.o(208241);
  }
  
  public final void setDisableMicInfo$plugin_gamelive_release(boolean paramBoolean)
  {
    AppMethodBeat.i(208225);
    Dkk.putBoolean("disableMicInfo", paramBoolean);
    AppMethodBeat.o(208225);
  }
  
  public final void setGameLiveAnchorHeadUrl$plugin_gamelive_release(String paramString)
  {
    AppMethodBeat.i(208276);
    Dkk.putString("Game_Live_anchorHeadUrl", paramString);
    AppMethodBeat.o(208276);
  }
  
  public final void setGameLiveCurrentState_$plugin_gamelive_release(b paramb)
  {
    AppMethodBeat.i(208313);
    if (paramb != null)
    {
      Dkk.putInt("gameLiveCurrentState_", paramb.position);
      AppMethodBeat.o(208313);
      return;
    }
    AppMethodBeat.o(208313);
  }
  
  public final void setGameLiveFinderUsrName$plugin_gamelive_release(String paramString)
  {
    AppMethodBeat.i(208284);
    Dkk.putString("Game_Live_finderUsrName", paramString);
    AppMethodBeat.o(208284);
  }
  
  public final void setGameLiveJoinLiveTips$plugin_gamelive_release(String paramString)
  {
    AppMethodBeat.i(208270);
    Dkk.putString("Game_Live_joinLiveTips", paramString);
    AppMethodBeat.o(208270);
  }
  
  public final void setGameLiveLiveId$plugin_gamelive_release(long paramLong)
  {
    AppMethodBeat.i(208289);
    Dkk.putLong("Game_Live_liveId", paramLong);
    AppMethodBeat.o(208289);
  }
  
  public final void setGameLiveNickname$plugin_gamelive_release(String paramString)
  {
    AppMethodBeat.i(208265);
    Dkk.putString("Game_Live_Nickname", paramString);
    AppMethodBeat.o(208265);
  }
  
  public final void setGameLivePrepareScene_$plugin_gamelive_release(PluginGameLive.d paramd)
  {
    AppMethodBeat.i(208317);
    if (paramd != null)
    {
      Dkk.putInt("gameLivePrepareScene", paramd.DkY);
      AppMethodBeat.o(208317);
      return;
    }
    AppMethodBeat.o(208317);
  }
  
  public final void setLiveInfoEvent(boolean paramBoolean)
  {
    AppMethodBeat.i(208245);
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      setDisableLiveInfo$plugin_gamelive_release(paramBoolean);
      AppMethodBeat.o(208245);
      return;
    }
  }
  
  public final void setMainProcessAudioService$plugin_gamelive_release(com.tencent.mm.plugin.gamelive.a.d paramd)
  {
    this.Dkb = paramd;
  }
  
  public final void setMainProcessRenderService$plugin_gamelive_release(com.tencent.mm.plugin.gamelive.render.b paramb)
  {
    this.Dkc = paramb;
  }
  
  public final void setMainProcessService$plugin_gamelive_release(b paramb)
  {
    this.Dka = paramb;
  }
  
  public final void setMicInfoEvent(boolean paramBoolean)
  {
    AppMethodBeat.i(208227);
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      setDisableMicInfo$plugin_gamelive_release(paramBoolean);
      AppMethodBeat.o(208227);
      return;
    }
  }
  
  public final void setOnLiveAppId$plugin_gamelive_release(String paramString)
  {
    AppMethodBeat.i(208208);
    Dkk.putString("onLiveAppId", paramString);
    if (MMApplicationContext.isMainProcess()) {
      setLiving(((com.tencent.c.a.a.a.b)h.ag(com.tencent.c.a.a.a.b.class)).isAnchorLiving());
    }
    AppMethodBeat.o(208208);
  }
  
  public final void setOnLiveAppIdForCrashCheck$plugin_gamelive_release(String paramString)
  {
    AppMethodBeat.i(208304);
    Dkk.putString("onLiveAppIdForCrashCheck", paramString);
    AppMethodBeat.o(208304);
  }
  
  public final void setOnLiveCrashReset$plugin_gamelive_release(boolean paramBoolean)
  {
    AppMethodBeat.i(208309);
    Dkk.putBoolean("onLiveCrashReset", paramBoolean);
    AppMethodBeat.o(208309);
  }
  
  public final void setOnLiveVersionType$plugin_gamelive_release(int paramInt)
  {
    AppMethodBeat.i(208211);
    Dkk.putInt("onLiveVersionType", paramInt);
    AppMethodBeat.o(208211);
  }
  
  public final void setOnLiveVersionTypeForCrashCheck$plugin_gamelive_release(int paramInt)
  {
    AppMethodBeat.i(208306);
    Dkk.putInt("onLiveVersionTypeForCrashCheck", paramInt);
    AppMethodBeat.o(208306);
  }
  
  public final void setOnLivingStatusForCrashCheck$plugin_gamelive_release(boolean paramBoolean)
  {
    AppMethodBeat.i(208296);
    Dkk.putBoolean("onLivingStatusForCrashCheck", paramBoolean);
    AppMethodBeat.o(208296);
  }
  
  public final void setOnLivingStatusForCrashCheckTemp$plugin_gamelive_release(boolean paramBoolean)
  {
    this.Dkj = paramBoolean;
  }
  
  public final void setPushing$plugin_gamelive_release(boolean paramBoolean)
  {
    AppMethodBeat.i(208213);
    Dkk.putBoolean("isPushing", paramBoolean);
    AppMethodBeat.o(208213);
  }
  
  public final void startGameLivePrepare$plugin_gamelive_release()
  {
    AppMethodBeat.i(208259);
    b localb = this.Dka;
    if (localb != null)
    {
      localb.eAL();
      AppMethodBeat.o(208259);
      return;
    }
    AppMethodBeat.o(208259);
  }
  
  public final void updateIsLivingState$plugin_gamelive_release()
  {
    AppMethodBeat.i(208254);
    isLiving();
    AppMethodBeat.o(208254);
  }
  
  public final String withCurrentState$plugin_gamelive_release(String paramString)
  {
    AppMethodBeat.i(208256);
    p.k(paramString, "$this$withCurrentState");
    paramString = paramString + " [appId:" + getOnLiveAppId$plugin_gamelive_release() + " versionType:" + getOnLiveVersionType$plugin_gamelive_release() + ']';
    AppMethodBeat.o(208256);
    return paramString;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/gamelive/PluginGameLive$IPCLiveControlData$IPCLiveControlAction;", "", "(Ljava/lang/String;I)V", "IPCLiveControlActionUnknown", "IPCLiveControlActionSyncLiveState", "IPCLiveControlActionStartPush", "IPCLiveControlActionStopPush", "IPCLiveControlActionMinimizeGameLive", "IPCLiveControlActionHideMinimizeGameLive", "IPCLiveControlActionSetOnScreenSurfaceTexture", "IPCLiveControlActionGetInputSurfaceTexture", "IPCLiveControlActionSetSize", "IPCLiveControlActionGetMemberList", "IPCLiveControlActionGetTime", "IPCLiveControlActionResumeLive", "IPCLiveControlActionPauseLive", "IPCLiveControlActionEnableMute", "IPCLiveControlActionDisableMute", "IPCLiveControlActionSendVolumnCallBackDuration", "IPCLiveControlActionAudioReconnect", "IPCLiveEventUserCancel", "IPCLiveEventUserStopLiveFromFinderLive", "IPCLiveEventLiveDidStart", "IPCLiveShareToFriendCallBack", "IPCLiveSendCommentInfo", "IPCLiveSendVolumnInfo", "IPCLiveSendNetWorkInfo", "plugin-gamelive_release"})
  public static enum IPCLiveControlData$b
  {
    static
    {
      AppMethodBeat.i(208425);
      b localb1 = new b("IPCLiveControlActionUnknown", 0);
      Dkv = localb1;
      b localb2 = new b("IPCLiveControlActionSyncLiveState", 1);
      Dkw = localb2;
      b localb3 = new b("IPCLiveControlActionStartPush", 2);
      Dkx = localb3;
      b localb4 = new b("IPCLiveControlActionStopPush", 3);
      Dky = localb4;
      b localb5 = new b("IPCLiveControlActionMinimizeGameLive", 4);
      Dkz = localb5;
      b localb6 = new b("IPCLiveControlActionHideMinimizeGameLive", 5);
      DkA = localb6;
      b localb7 = new b("IPCLiveControlActionSetOnScreenSurfaceTexture", 6);
      DkB = localb7;
      b localb8 = new b("IPCLiveControlActionGetInputSurfaceTexture", 7);
      DkC = localb8;
      b localb9 = new b("IPCLiveControlActionSetSize", 8);
      DkD = localb9;
      b localb10 = new b("IPCLiveControlActionGetMemberList", 9);
      DkE = localb10;
      b localb11 = new b("IPCLiveControlActionGetTime", 10);
      DkF = localb11;
      b localb12 = new b("IPCLiveControlActionResumeLive", 11);
      DkG = localb12;
      b localb13 = new b("IPCLiveControlActionPauseLive", 12);
      DkH = localb13;
      b localb14 = new b("IPCLiveControlActionEnableMute", 13);
      DkI = localb14;
      b localb15 = new b("IPCLiveControlActionDisableMute", 14);
      DkJ = localb15;
      b localb16 = new b("IPCLiveControlActionSendVolumnCallBackDuration", 15);
      DkK = localb16;
      b localb17 = new b("IPCLiveControlActionAudioReconnect", 16);
      DkL = localb17;
      b localb18 = new b("IPCLiveEventUserCancel", 17);
      DkM = localb18;
      b localb19 = new b("IPCLiveEventUserStopLiveFromFinderLive", 18);
      DkN = localb19;
      b localb20 = new b("IPCLiveEventLiveDidStart", 19);
      DkO = localb20;
      b localb21 = new b("IPCLiveShareToFriendCallBack", 20);
      DkP = localb21;
      b localb22 = new b("IPCLiveSendCommentInfo", 21);
      DkQ = localb22;
      b localb23 = new b("IPCLiveSendVolumnInfo", 22);
      DkR = localb23;
      b localb24 = new b("IPCLiveSendNetWorkInfo", 23);
      DkS = localb24;
      DkT = new b[] { localb1, localb2, localb3, localb4, localb5, localb6, localb7, localb8, localb9, localb10, localb11, localb12, localb13, localb14, localb15, localb16, localb17, localb18, localb19, localb20, localb21, localb22, localb23, localb24 };
      AppMethodBeat.o(208425);
    }
    
    private IPCLiveControlData$b() {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/gamelive/PluginGameLive$GameLiveCurrentState;", "", "position", "", "(Ljava/lang/String;II)V", "getPosition", "()I", "getStateString", "", "GameLiveState_NotInited", "GameLiveState_PrePare", "GameLiveState_LivingForeGround", "GameLiveState_LivingBackGround", "GameLiveState_Destroy", "Companion", "plugin-gamelive_release"})
  public static enum b
  {
    public static final PluginGameLive.b.a Dks;
    final int position;
    
    static
    {
      AppMethodBeat.i(208539);
      b localb1 = new b("GameLiveState_NotInited", 0, 0);
      Dkm = localb1;
      b localb2 = new b("GameLiveState_PrePare", 1, 1);
      Dkn = localb2;
      b localb3 = new b("GameLiveState_LivingForeGround", 2, 2);
      Dko = localb3;
      b localb4 = new b("GameLiveState_LivingBackGround", 3, 3);
      Dkp = localb4;
      b localb5 = new b("GameLiveState_Destroy", 4, 4);
      Dkq = localb5;
      Dkr = new b[] { localb1, localb2, localb3, localb4, localb5 };
      Dks = new PluginGameLive.b.a((byte)0);
      AppMethodBeat.o(208539);
    }
    
    private b(int paramInt)
    {
      this.position = paramInt;
    }
    
    public final String eAP()
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
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/gamelive/PluginGameLive$IPCLiveControlTask;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/plugin/gamelive/PluginGameLive$IPCLiveControlData;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-gamelive_release"})
  public static final class c
    implements com.tencent.mm.ipcinvoker.d<PluginGameLive.IPCLiveControlData, PluginGameLive.IPCLiveControlData>
  {
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/Surface;", "gotSurface"})
    static final class a
      implements g.a
    {
      a(com.tencent.mm.ipcinvoker.f paramf) {}
      
      public final void i(Surface paramSurface)
      {
        AppMethodBeat.i(208093);
        com.tencent.mm.ipcinvoker.f localf = this.nyL;
        if (localf != null)
        {
          localf.aH(new PluginGameLive.IPCLiveControlData(PluginGameLive.IPCLiveControlData.b.Dkv, null, (Parcelable)paramSurface, 6));
          AppMethodBeat.o(208093);
          return;
        }
        AppMethodBeat.o(208093);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelive.PluginGameLive
 * JD-Core Version:    0.7.0.1
 */