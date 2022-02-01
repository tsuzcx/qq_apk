package com.tencent.mm.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.bbom.PluginBigBallOfMud;
import com.tencent.mm.plugin.report.PluginReport;
import com.tencent.mm.plugin.zero.PluginZero;
import com.tencent.mm.plugin.zero.a.d;
import com.tencent.mm.sdk.platformtools.Log;

public final class c
  extends i
{
  public c()
  {
    com.tencent.mm.plugin.appbrand.api.a.kHt = true;
  }
  
  public final void VZ()
  {
    AppMethodBeat.i(160069);
    super.VZ();
    Log.i("MicroMsg.AppBrandProcessIsolateBootStep", "helloWeChat()");
    AppMethodBeat.o(160069);
  }
  
  public final void Wa()
  {
    AppMethodBeat.i(160070);
    Log.i("MicroMsg.AppBrandProcessIsolateBootStep", "installPlugins()");
    g.aAd().hqx = d.class;
    al(PluginZero.class);
    al(PluginReport.class);
    al(PluginBigBallOfMud.class);
    FW("com.tencent.mm.plugin.bbom.PluginBigBallOfMudAsync");
    FW("com.tencent.mm.ipcinvoker.wx_extension.PluginIPC");
    FW("com.tencent.mm.plugin.abtest.PluginABTest");
    FW("com.tencent.mm.plugin.expt.PluginExpt");
    FW("com.tencent.mm.plugin.hardcoder.PluginHardcoder");
    FW("com.tencent.mm.plugin.brandservice.PluginBrandService");
    FW("com.tencent.mm.plugin.scanner.PluginScanner");
    FW("com.tencent.mm.plugin.teenmode.PluginTeenMode");
    FW("com.tencent.mm.plugin.expansions.PluginExpansions");
    FX("com.tencent.mm.plugin.performance.PluginPerformance");
    FX("com.tencent.mm.plugin.appbrand.app.PluginAppBrand");
    FX("com.tencent.mm.plugin.multitask.PluginMultiTask");
    FX("com.tencent.mm.plugin.handoff.PluginHandOff");
    FX("com.tencent.mm.plugin.choosemsgfile.PluginChooseMsgFile");
    FX("com.tencent.mm.plugin.ball.PluginBall");
    FX("com.tencent.mm.chatroom.plugin.PluginChatroomUI");
    FX("com.tencent.mm.plugin.game.PluginGame");
    FX("com.tencent.mm.plugin.music.PluginMusic");
    FX("com.tencent.mm.plugin.recordvideo.appcamera.PluginMMSight");
    FX("com.tencent.mm.plugin.normsg.PluginNormsg");
    FX("com.tencent.mm.plugin.trafficmonitor.PluginTrafficMonitor");
    FX("com.tencent.mm.gpu.PluginGpuRes");
    FX("com.tencent.mm.plugin.crashfix.PluginSystemCrashFix");
    FX("com.tencent.mm.wlogcat.PluginLogcat");
    AppMethodBeat.o(160070);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.app.c
 * JD-Core Version:    0.7.0.1
 */