package com.tencent.mm.app;

import android.os.Build.VERSION;
import com.tencent.matrix.jectl.JeCtl;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.address.AddressSelectorContract;
import com.tencent.mm.plugin.appbrand.jsapi.address.a;
import com.tencent.mm.plugin.bbom.PluginBigBallOfMud;
import com.tencent.mm.plugin.report.PluginReport;
import com.tencent.mm.plugin.zero.PluginZero;
import com.tencent.mm.plugin.zero.a.d;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;

public final class c
  extends k
{
  public c()
  {
    com.tencent.mm.plugin.appbrand.api.a.qAC = true;
  }
  
  public final void a(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(239279);
    super.a(paramg);
    com.tencent.mm.kernel.h.b(AddressSelectorContract.class, a.rBY);
    AppMethodBeat.o(239279);
  }
  
  public final void aBY()
  {
    AppMethodBeat.i(160069);
    super.aBY();
    Log.i("MicroMsg.AppBrandProcessIsolateBootStep", "helloWeChat()");
    AppMethodBeat.o(160069);
  }
  
  public final void aBZ()
  {
    AppMethodBeat.i(160070);
    Log.i("MicroMsg.AppBrandProcessIsolateBootStep", "installPlugins()");
    if (BuildInfo.DEBUG) {
      com.tencent.mm.kernel.g.bay();
    }
    if ((!BuildInfo.IS_ARM64) && (Build.VERSION.SDK_INT >= 30) && (com.tencent.mm.compatible.util.h.aQh()))
    {
      Log.i("MicroMsg.AppBrandProcessIsolateBootStep", "origin retain = %s", new Object[] { Boolean.valueOf(JeCtl.setRetain(true)) });
      Log.i("MicroMsg.AppBrandProcessIsolateBootStep", "now retain = %s", new Object[] { Boolean.valueOf(JeCtl.setRetain(true)) });
    }
    com.tencent.mm.kernel.h.baA().mCA = d.class;
    aD(PluginZero.class);
    aD(PluginReport.class);
    aD(PluginBigBallOfMud.class);
    FF("com.tencent.mm.sensitive.PluginSensitive");
    FF("com.tencent.mm.plugin.bbom.PluginBigBallOfMudAsync");
    FF("com.tencent.mm.plugin.PluginRecentForward");
    FG("com.tencent.mm.openim.PluginOpenIM");
    FF("com.tencent.mm.ipcinvoker.wx_extension.PluginIPC");
    FF("com.tencent.mm.plugin.abtest.PluginABTest");
    FF("com.tencent.mm.plugin.hook.PluginHook");
    FF("com.tencent.mm.plugin.sensitive_api_check.Plugin");
    FF("com.tencent.mm.plugin.expt.PluginExpt");
    FF("com.tencent.mm.plugin.datareport.PluginDataReport");
    FF("com.tencent.mm.plugin.hardcoder.PluginHardcoder");
    FF("com.tencent.mm.plugin.brandservice.PluginBrandService");
    FF("com.tencent.mm.plugin.scanner.PluginScanner");
    FF("com.tencent.mm.plugin.teenmode.PluginTeenMode");
    FF("com.tencent.mm.plugin.expansions.PluginExpansions");
    FG("com.tencent.mm.plugin.performance.PluginPerformance");
    FG("com.tencent.mm.plugin.appbrand.app.PluginAppBrand");
    FG("com.tencent.mm.plugin.handoff.PluginHandOff");
    FG("com.tencent.mm.plugin.multitask.PluginMultiTask");
    FG("com.tencent.mm.plugin.choosemsgfile.PluginChooseMsgFile");
    FG("com.tencent.mm.plugin.ball.PluginBall");
    FG("com.tencent.mm.chatroom.plugin.PluginChatroomUI");
    FG("com.tencent.mm.plugin.game.PluginGame");
    FG("com.tencent.mm.plugin.music.PluginMusic");
    FG("com.tencent.mm.plugin.recordvideo.appcamera.PluginMMSight");
    FG("com.tencent.mm.plugin.normsg.PluginNormsg");
    FG("com.tencent.mm.plugin.trafficmonitor.PluginTrafficMonitor");
    FG("com.tencent.mm.gpu.PluginGpuRes");
    FG("com.tencent.mm.plugin.crashfix.PluginSystemCrashFix");
    FG("com.tencent.mm.wlogcat.PluginLogcat");
    FG("com.tencent.mm.plugin.gamelive.PluginGameLive");
    FG("com.tencent.mm.plugin.ai.PluginAi");
    AppMethodBeat.o(160070);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.app.c
 * JD-Core Version:    0.7.0.1
 */