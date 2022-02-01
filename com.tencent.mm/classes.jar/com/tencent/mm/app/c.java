package com.tencent.mm.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.bbom.PluginBigBallOfMud;
import com.tencent.mm.plugin.report.PluginReport;
import com.tencent.mm.plugin.zero.PluginZero;
import com.tencent.mm.plugin.zero.a.d;
import com.tencent.mm.sdk.platformtools.ad;

public final class c
  extends i
{
  public c()
  {
    com.tencent.mm.plugin.appbrand.api.a.jCM = true;
  }
  
  public final void LE()
  {
    AppMethodBeat.i(160069);
    super.LE();
    ad.i("MicroMsg.AppBrandProcessIsolateBootStep", "helloWeChat()");
    AppMethodBeat.o(160069);
  }
  
  public final void LF()
  {
    AppMethodBeat.i(160070);
    ad.i("MicroMsg.AppBrandProcessIsolateBootStep", "installPlugins()");
    g.ajy().gBd = d.class;
    ah(PluginZero.class);
    ah(PluginReport.class);
    ah(PluginBigBallOfMud.class);
    xd("com.tencent.mm.plugin.bbom.PluginBigBallOfMudAsync");
    xd("com.tencent.mm.ipcinvoker.wx_extension.PluginIPC");
    xd("com.tencent.mm.plugin.abtest.PluginABTest");
    xd("com.tencent.mm.plugin.expt.PluginExpt");
    xd("com.tencent.mm.plugin.hardcoder.PluginHardcoder");
    xd("com.tencent.mm.plugin.brandservice.PluginBrandService");
    xd("com.tencent.mm.plugin.scanner.PluginScanner");
    xd("com.tencent.mm.plugin.expansions.PluginExpansions");
    xe("com.tencent.mm.plugin.performance.PluginPerformance");
    xe("com.tencent.mm.plugin.appbrand.app.PluginAppBrand");
    xe("com.tencent.mm.plugin.handoff.PluginHandOff");
    xe("com.tencent.mm.plugin.choosemsgfile.PluginChooseMsgFile");
    xe("com.tencent.mm.plugin.ball.PluginBall");
    xe("com.tencent.mm.chatroom.plugin.PluginChatroomUI");
    xe("com.tencent.mm.plugin.game.PluginGame");
    xe("com.tencent.mm.plugin.music.PluginMusic");
    xe("com.tencent.mm.plugin.recordvideo.appcamera.PluginMMSight");
    xe("com.tencent.mm.plugin.normsg.PluginNormsg");
    xe("com.tencent.mm.plugin.trafficmonitor.PluginTrafficMonitor");
    xe("com.tencent.mm.gpu.PluginGpuRes");
    xe("com.tencent.mm.plugin.crashfix.PluginSystemCrashFix");
    AppMethodBeat.o(160070);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.app.c
 * JD-Core Version:    0.7.0.1
 */