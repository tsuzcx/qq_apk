package com.tencent.mm.app;

import android.os.Build.VERSION;
import com.tencent.matrix.jectl.JeCtl;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.bbom.PluginBigBallOfMud;
import com.tencent.mm.plugin.report.PluginReport;
import com.tencent.mm.plugin.zero.PluginZero;
import com.tencent.mm.plugin.zero.a.d;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;

public final class c
  extends i
{
  public c()
  {
    com.tencent.mm.plugin.appbrand.api.a.nBn = true;
  }
  
  public final void aau()
  {
    AppMethodBeat.i(160069);
    super.aau();
    Log.i("MicroMsg.AppBrandProcessIsolateBootStep", "helloWeChat()");
    AppMethodBeat.o(160069);
  }
  
  public final void aav()
  {
    AppMethodBeat.i(160070);
    Log.i("MicroMsg.AppBrandProcessIsolateBootStep", "installPlugins()");
    if ((!BuildInfo.IS_ARM64) && (Build.VERSION.SDK_INT >= 30))
    {
      Log.i("MicroMsg.AppBrandProcessIsolateBootStep", "origin retain = %s", new Object[] { Boolean.valueOf(JeCtl.setRetain(true)) });
      Log.i("MicroMsg.AppBrandProcessIsolateBootStep", "now retain = %s", new Object[] { Boolean.valueOf(JeCtl.setRetain(true)) });
    }
    h.aHC().kcs = d.class;
    ak(PluginZero.class);
    ak(PluginReport.class);
    ak(PluginBigBallOfMud.class);
    MW("com.tencent.mm.plugin.bbom.PluginBigBallOfMudAsync");
    MW("com.tencent.mm.ipcinvoker.wx_extension.PluginIPC");
    MW("com.tencent.mm.plugin.abtest.PluginABTest");
    MW("com.tencent.mm.plugin.hook.PluginHook");
    MW("com.tencent.mm.plugin.sensitive_api_check.Plugin");
    MW("com.tencent.mm.plugin.expt.PluginExpt");
    MW("com.tencent.mm.plugin.hardcoder.PluginHardcoder");
    MW("com.tencent.mm.plugin.brandservice.PluginBrandService");
    MW("com.tencent.mm.plugin.scanner.PluginScanner");
    MW("com.tencent.mm.plugin.teenmode.PluginTeenMode");
    MW("com.tencent.mm.plugin.expansions.PluginExpansions");
    MX("com.tencent.mm.plugin.performance.PluginPerformance");
    MX("com.tencent.mm.plugin.appbrand.app.PluginAppBrand");
    MX("com.tencent.mm.plugin.multitask.PluginMultiTask");
    MX("com.tencent.mm.plugin.handoff.PluginHandOff");
    MX("com.tencent.mm.plugin.choosemsgfile.PluginChooseMsgFile");
    MX("com.tencent.mm.plugin.ball.PluginBall");
    MX("com.tencent.mm.chatroom.plugin.PluginChatroomUI");
    MX("com.tencent.mm.plugin.game.PluginGame");
    MX("com.tencent.mm.plugin.music.PluginMusic");
    MX("com.tencent.mm.plugin.recordvideo.appcamera.PluginMMSight");
    MX("com.tencent.mm.plugin.normsg.PluginNormsg");
    MX("com.tencent.mm.plugin.trafficmonitor.PluginTrafficMonitor");
    MX("com.tencent.mm.gpu.PluginGpuRes");
    MX("com.tencent.mm.plugin.crashfix.PluginSystemCrashFix");
    MX("com.tencent.mm.wlogcat.PluginLogcat");
    MX("com.tencent.mm.plugin.gamelive.PluginGameLive");
    AppMethodBeat.o(160070);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.app.c
 * JD-Core Version:    0.7.0.1
 */