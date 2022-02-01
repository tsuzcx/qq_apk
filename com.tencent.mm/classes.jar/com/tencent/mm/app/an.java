package com.tencent.mm.app;

import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.tencent.matrix.jectl.JeCtl;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.kernel.b;
import com.tencent.mm.plugin.bbom.PluginBigBallOfMud;
import com.tencent.mm.plugin.messenger.foundation.PluginMessengerFoundation;
import com.tencent.mm.plugin.report.PluginReport;
import com.tencent.mm.plugin.zero.PluginZero;
import com.tencent.mm.plugin.zero.a.d;
import com.tencent.mm.pluginsdk.model.ad;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.xwebutil.c;
import com.tencent.xweb.x5.a.e;

public final class an
  extends k
{
  private boolean hiW;
  
  public an(boolean paramBoolean)
  {
    this.hiW = paramBoolean;
  }
  
  public final void aBZ()
  {
    AppMethodBeat.i(160135);
    Bundle localBundle = new Bundle();
    localBundle.putString("wx_userid", q.aPj());
    if (b.aZP() != 0)
    {
      localBundle.putString("imsi", q.aOZ());
      localBundle.putString("android_id", q.getAndroidId());
      localBundle.putString("mac", q.aPd());
      localBundle.putString("model", Build.MODEL);
    }
    Log.i("MicroMsg.ToolsProcessBootStep", "userInfo: userid = %s", new Object[] { localBundle.getString("wx_userid") });
    e.setUserID(MMApplicationContext.getContext(), localBundle);
    if (MMApplicationContext.isToolsProcess()) {
      ad.iIg();
    }
    if ((!BuildInfo.IS_ARM64) && (Build.VERSION.SDK_INT >= 30) && (com.tencent.mm.compatible.util.h.aQh()))
    {
      Log.i("MicroMsg.ToolsProcessBootStep", "origin retain = %s", new Object[] { Boolean.valueOf(JeCtl.setRetain(true)) });
      Log.i("MicroMsg.ToolsProcessBootStep", "now retain = %s", new Object[] { Boolean.valueOf(JeCtl.setRetain(true)) });
    }
    FF("com.tencent.mm.plugin.expansions.PluginExpansions");
    c.a(new an.1(this));
    com.tencent.mm.kernel.h.baA().mCA = d.class;
    aD(PluginZero.class);
    aD(PluginMessengerFoundation.class);
    aD(PluginReport.class);
    aD(PluginBigBallOfMud.class);
    FF("com.tencent.mm.plugin.bbom.PluginBigBallOfMudAsync");
    FF("com.tencent.mm.plugin.comm.PluginComm");
    FF("com.tencent.mm.plugin.biz.PluginBiz");
    FG("com.tencent.mm.plugin.bizui.PluginBIZUI");
    FF("com.tencent.mm.ipcinvoker.wx_extension.PluginIPC");
    FF("com.tencent.mm.plugin.abtest.PluginABTest");
    FF("com.tencent.mm.plugin.hook.PluginHook");
    FF("com.tencent.mm.plugin.sensitive_api_check.Plugin");
    FF("com.tencent.mm.sensitive.PluginSensitive");
    FF("com.tencent.mm.plugin.expt.PluginExpt");
    FF("com.tencent.mm.plugin.datareport.PluginDataReport");
    FF("com.tencent.mm.plugin.hardcoder.PluginHardcoder");
    FF("com.tencent.mm.plugin.brandservice.PluginBrandService");
    FF("com.tencent.mm.plugin.teenmode.PluginTeenMode");
    FG("com.tencent.mm.plugin.performance.PluginPerformance");
    FG("com.tencent.mm.plugin.appbrand.app.PluginAppBrand");
    FG("com.tencent.mm.plugin.handoff.PluginHandOff");
    FG("com.tencent.mm.plugin.multitask.PluginMultiTask");
    FF("com.tencent.mm.plugin.taskbar.PluginTaskBar");
    FG("com.tencent.mm.plugin.ball.PluginBall");
    FG("com.tencent.mm.plugin.emoji.PluginEmoji");
    FG("com.tencent.mm.plugin.webview.PluginWebView");
    FG("com.tencent.mm.plugin.normsg.PluginNormsg");
    FG("com.tencent.mm.plugin.trafficmonitor.PluginTrafficMonitor");
    FG("com.tencent.mm.gpu.PluginGpuRes");
    FG("com.tencent.mm.plugin.crashfix.PluginSystemCrashFix");
    FG("com.tencent.mm.wlogcat.PluginLogcat");
    FG("com.tencent.mm.plugin.websearch.PluginWebSearch");
    FG("com.tencent.mm.plugin.fts.ui.PluginFTSUI");
    FG("com.tencent.mm.plugin.game.PluginGame");
    FG("com.tencent.mm.game.report.PluginGameReport");
    FG("com.tencent.mm.plugin.wepkg.PluginWePkg");
    FG("com.tencent.mm.plugin.game.commlib.PluginCommLib");
    FG("com.tencent.mm.plugin.gamelife.PluginGameLife");
    FG("com.tencent.mm.plugin.byp.PluginByp");
    FG("com.tencent.mm.plugin.downloader_app.PluginDownloaderApp");
    FG("com.tencent.mm.plugin.game.luggage.PluginLuggageGame");
    FG("com.tencent.mm.plugin.boots.PluginBoots");
    FG("com.tencent.mm.plugin.lite.PluginLiteApp");
    FG("com.tencent.mm.plugin.scanner.PluginScanner");
    FF("com.tencent.mm.plugin.PluginRecentForward");
    FF("com.tencent.mm.openim.PluginOpenIM");
    FG("com.tencent.mm.plugin.ai.PluginAi");
    FG("com.tencent.mm.accessibility.AccessibilityPlugin");
    FG("com.tencent.mm.plugin.wxpayreport.PluginWcPayReport");
    if (!this.hiW)
    {
      FG("com.tencent.mm.plugin.emojicapture.model.PluginEmojiCapture");
      FG("com.tencent.mm.plugin.qqmail.PluginQQMail");
      FG("com.tencent.mm.plugin.sns.PluginSns");
      FG("com.tencent.mm.plugin.MMPhotoEditPlugin");
      FG("com.tencent.mm.plugin.recordvideo.PluginVideoEditor");
      FG("com.tencent.mm.plugin.facedetect.PluginFace");
      FG("com.tencent.mm.plugin.recordvideo.appcamera.PluginMMSight");
      FG("com.tencent.mm.plugin.story.PluginStory");
    }
    AppMethodBeat.o(160135);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.app.an
 * JD-Core Version:    0.7.0.1
 */