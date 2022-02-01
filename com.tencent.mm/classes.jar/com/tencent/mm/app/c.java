package com.tencent.mm.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.bbom.PluginBigBallOfMud;
import com.tencent.mm.plugin.report.PluginReport;
import com.tencent.mm.plugin.zero.PluginZero;
import com.tencent.mm.plugin.zero.a.d;
import com.tencent.mm.sdk.platformtools.ae;

public final class c
  extends i
{
  public c()
  {
    com.tencent.mm.plugin.appbrand.api.a.jFK = true;
  }
  
  public final void LM()
  {
    AppMethodBeat.i(160069);
    super.LM();
    ae.i("MicroMsg.AppBrandProcessIsolateBootStep", "helloWeChat()");
    AppMethodBeat.o(160069);
  }
  
  public final void LN()
  {
    AppMethodBeat.i(160070);
    ae.i("MicroMsg.AppBrandProcessIsolateBootStep", "installPlugins()");
    g.ajN().gDK = d.class;
    ah(PluginZero.class);
    ah(PluginReport.class);
    ah(PluginBigBallOfMud.class);
    xM("com.tencent.mm.plugin.bbom.PluginBigBallOfMudAsync");
    xM("com.tencent.mm.ipcinvoker.wx_extension.PluginIPC");
    xM("com.tencent.mm.plugin.abtest.PluginABTest");
    xM("com.tencent.mm.plugin.expt.PluginExpt");
    xM("com.tencent.mm.plugin.hardcoder.PluginHardcoder");
    xM("com.tencent.mm.plugin.brandservice.PluginBrandService");
    xM("com.tencent.mm.plugin.scanner.PluginScanner");
    xM("com.tencent.mm.plugin.expansions.PluginExpansions");
    xN("com.tencent.mm.plugin.performance.PluginPerformance");
    xN("com.tencent.mm.plugin.appbrand.app.PluginAppBrand");
    xN("com.tencent.mm.plugin.handoff.PluginHandOff");
    xN("com.tencent.mm.plugin.choosemsgfile.PluginChooseMsgFile");
    xN("com.tencent.mm.plugin.ball.PluginBall");
    xN("com.tencent.mm.chatroom.plugin.PluginChatroomUI");
    xN("com.tencent.mm.plugin.game.PluginGame");
    xN("com.tencent.mm.plugin.music.PluginMusic");
    xN("com.tencent.mm.plugin.recordvideo.appcamera.PluginMMSight");
    xN("com.tencent.mm.plugin.normsg.PluginNormsg");
    xN("com.tencent.mm.plugin.trafficmonitor.PluginTrafficMonitor");
    xN("com.tencent.mm.gpu.PluginGpuRes");
    xN("com.tencent.mm.plugin.crashfix.PluginSystemCrashFix");
    xN("com.tencent.mm.wlogcat.PluginLogcat");
    AppMethodBeat.o(160070);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.app.c
 * JD-Core Version:    0.7.0.1
 */