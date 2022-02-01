package com.tencent.mm.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.bbom.PluginBigBallOfMud;
import com.tencent.mm.plugin.report.PluginReport;
import com.tencent.mm.plugin.zero.PluginZero;
import com.tencent.mm.plugin.zero.a.d;
import com.tencent.mm.sdk.platformtools.ac;

public final class c
  extends i
{
  public c()
  {
    com.tencent.mm.plugin.appbrand.a.a.jje = true;
  }
  
  public final void Kf()
  {
    AppMethodBeat.i(160069);
    super.Kf();
    ac.i("MicroMsg.AppBrandProcessIsolateBootStep", "helloWeChat()");
    AppMethodBeat.o(160069);
  }
  
  public final void Kg()
  {
    AppMethodBeat.i(160070);
    ac.i("MicroMsg.AppBrandProcessIsolateBootStep", "installPlugins()");
    g.agN().ght = d.class;
    ah(PluginZero.class);
    ah(PluginReport.class);
    ah(PluginBigBallOfMud.class);
    un("com.tencent.mm.plugin.bbom.PluginBigBallOfMudAsync");
    un("com.tencent.mm.ipcinvoker.wx_extension.PluginIPC");
    un("com.tencent.mm.plugin.abtest.PluginABTest");
    un("com.tencent.mm.plugin.expt.PluginExpt");
    un("com.tencent.mm.plugin.hardcoder.PluginHardcoder");
    un("com.tencent.mm.plugin.brandservice.PluginBrandService");
    un("com.tencent.mm.plugin.expansions.PluginExpansions");
    uo("com.tencent.mm.plugin.performance.PluginPerformance");
    uo("com.tencent.mm.plugin.appbrand.app.PluginAppBrand");
    uo("com.tencent.mm.plugin.handoff.PluginHandOff");
    uo("com.tencent.mm.plugin.choosemsgfile.PluginChooseMsgFile");
    uo("com.tencent.mm.plugin.ball.PluginBall");
    uo("com.tencent.mm.plugin.game.PluginGame");
    uo("com.tencent.mm.plugin.music.PluginMusic");
    uo("com.tencent.mm.plugin.recordvideo.appcamera.PluginMMSight");
    uo("com.tencent.mm.plugin.normsg.PluginNormsg");
    uo("com.tencent.mm.plugin.trafficmonitor.PluginTrafficMonitor");
    uo("com.tencent.mm.plugin.crashfix.PluginSystemCrashFix");
    uo("com.tencent.mm.gpu.PluginGpuRes");
    AppMethodBeat.o(160070);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.app.c
 * JD-Core Version:    0.7.0.1
 */