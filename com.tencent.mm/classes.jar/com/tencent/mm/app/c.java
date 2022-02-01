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
    com.tencent.mm.plugin.appbrand.a.a.iJa = true;
  }
  
  public final void Kv()
  {
    AppMethodBeat.i(160069);
    super.Kv();
    ad.i("MicroMsg.AppBrandProcessIsolateBootStep", "helloWeChat()");
    AppMethodBeat.o(160069);
  }
  
  public final void Kw()
  {
    AppMethodBeat.i(160070);
    ad.i("MicroMsg.AppBrandProcessIsolateBootStep", "installPlugins()");
    g.afx().gcN = d.class;
    ah(PluginZero.class);
    ah(PluginReport.class);
    ah(PluginBigBallOfMud.class);
    qY("com.tencent.mm.plugin.bbom.PluginBigBallOfMudAsync");
    qY("com.tencent.mm.ipcinvoker.wx_extension.PluginIPC");
    qY("com.tencent.mm.plugin.abtest.PluginABTest");
    qY("com.tencent.mm.plugin.expt.PluginExpt");
    qY("com.tencent.mm.plugin.hardcoder.PluginHardcoder");
    qY("com.tencent.mm.plugin.brandservice.PluginBrandService");
    qY("com.tencent.mm.plugin.expansions.PluginExpansions");
    qZ("com.tencent.mm.plugin.performance.PluginPerformance");
    qZ("com.tencent.mm.plugin.appbrand.app.PluginAppBrand");
    qZ("com.tencent.mm.plugin.handoff.PluginHandOff");
    qZ("com.tencent.mm.plugin.choosemsgfile.PluginChooseMsgFile");
    qZ("com.tencent.mm.plugin.ball.PluginBall");
    qZ("com.tencent.mm.plugin.game.PluginGame");
    qZ("com.tencent.mm.plugin.music.PluginMusic");
    qZ("com.tencent.mm.plugin.recordvideo.appcamera.PluginMMSight");
    qZ("com.tencent.mm.plugin.normsg.PluginNormsg");
    qZ("com.tencent.mm.plugin.trafficmonitor.PluginTrafficMonitor");
    qZ("com.tencent.mm.plugin.crashfix.PluginSystemCrashFix");
    AppMethodBeat.o(160070);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.app.c
 * JD-Core Version:    0.7.0.1
 */