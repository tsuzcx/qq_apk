package com.tencent.mm.app;

import android.os.Build.VERSION;
import com.tencent.matrix.jectl.JeCtl;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.bbom.PluginBigBallOfMud;
import com.tencent.mm.plugin.messenger.foundation.PluginMessengerFoundation;
import com.tencent.mm.plugin.report.PluginReport;
import com.tencent.mm.plugin.zero.PluginZero;
import com.tencent.mm.plugin.zero.a.d;
import com.tencent.mm.pluginsdk.model.ab;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.xwebutil.c;

public final class aj
  extends i
{
  private boolean feQ;
  
  public aj(boolean paramBoolean)
  {
    this.feQ = paramBoolean;
  }
  
  public final void aav()
  {
    AppMethodBeat.i(160135);
    Log.i("MicroMsg.ToolsProcessBootStep", "installPlugins()");
    if (MMApplicationContext.isToolsProcess()) {
      ab.hhg();
    }
    if ((!BuildInfo.IS_ARM64) && (Build.VERSION.SDK_INT >= 30))
    {
      Log.i("MicroMsg.ToolsProcessBootStep", "origin retain = %s", new Object[] { Boolean.valueOf(JeCtl.setRetain(true)) });
      Log.i("MicroMsg.ToolsProcessBootStep", "now retain = %s", new Object[] { Boolean.valueOf(JeCtl.setRetain(true)) });
    }
    c.a(null);
    h.aHC().kcs = d.class;
    ak(PluginZero.class);
    ak(PluginMessengerFoundation.class);
    ak(PluginReport.class);
    ak(PluginBigBallOfMud.class);
    MW("com.tencent.mm.plugin.bbom.PluginBigBallOfMudAsync");
    MW("com.tencent.mm.plugin.comm.PluginComm");
    MW("com.tencent.mm.plugin.biz.PluginBiz");
    MX("com.tencent.mm.plugin.bizui.PluginBIZUI");
    MW("com.tencent.mm.ipcinvoker.wx_extension.PluginIPC");
    MW("com.tencent.mm.plugin.abtest.PluginABTest");
    MW("com.tencent.mm.plugin.hook.PluginHook");
    MW("com.tencent.mm.plugin.sensitive_api_check.Plugin");
    MW("com.tencent.mm.plugin.expt.PluginExpt");
    MW("com.tencent.mm.plugin.hardcoder.PluginHardcoder");
    MW("com.tencent.mm.plugin.brandservice.PluginBrandService");
    MW("com.tencent.mm.plugin.teenmode.PluginTeenMode");
    MW("com.tencent.mm.plugin.expansions.PluginExpansions");
    MX("com.tencent.mm.plugin.performance.PluginPerformance");
    MX("com.tencent.mm.plugin.appbrand.app.PluginAppBrand");
    MX("com.tencent.mm.plugin.multitask.PluginMultiTask");
    MW("com.tencent.mm.plugin.taskbar.PluginTaskBar");
    MX("com.tencent.mm.plugin.handoff.PluginHandOff");
    MX("com.tencent.mm.plugin.ball.PluginBall");
    MX("com.tencent.mm.plugin.emoji.PluginEmoji");
    MX("com.tencent.mm.plugin.webview.PluginWebView");
    MX("com.tencent.mm.plugin.normsg.PluginNormsg");
    MX("com.tencent.mm.plugin.trafficmonitor.PluginTrafficMonitor");
    MX("com.tencent.mm.gpu.PluginGpuRes");
    MX("com.tencent.mm.plugin.crashfix.PluginSystemCrashFix");
    MX("com.tencent.mm.wlogcat.PluginLogcat");
    MX("com.tencent.mm.plugin.websearch.PluginWebSearch");
    MX("com.tencent.mm.plugin.fts.ui.PluginFTSUI");
    MX("com.tencent.mm.plugin.game.PluginGame");
    MX("com.tencent.mm.game.report.PluginGameReport");
    MX("com.tencent.mm.plugin.wepkg.PluginWePkg");
    MX("com.tencent.mm.plugin.game.commlib.PluginCommLib");
    MX("com.tencent.mm.plugin.gamelife.PluginGameLife");
    MX("com.tencent.mm.plugin.byp.PluginByp");
    MX("com.tencent.mm.plugin.downloader_app.PluginDownloaderApp");
    MX("com.tencent.mm.plugin.game.luggage.PluginLuggageGame");
    MX("com.tencent.mm.plugin.boots.PluginBoots");
    MX("com.tencent.mm.plugin.lite.PluginLiteApp");
    MX("com.tencent.mm.plugin.scanner.PluginScanner");
    if (!this.feQ)
    {
      MX("com.tencent.mm.plugin.emojicapture.model.PluginEmojiCapture");
      MX("com.tencent.mm.plugin.qqmail.PluginQQMail");
      MX("com.tencent.mm.plugin.sns.PluginSns");
      MX("com.tencent.mm.plugin.MMPhotoEditPlugin");
      MX("com.tencent.mm.plugin.recordvideo.PluginVideoEditor");
      MX("com.tencent.mm.plugin.facedetect.PluginFace");
      MX("com.tencent.mm.plugin.recordvideo.appcamera.PluginMMSight");
    }
    AppMethodBeat.o(160135);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.app.aj
 * JD-Core Version:    0.7.0.1
 */