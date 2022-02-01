package com.tencent.mm.app;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.os.Build;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.blink.c.1;
import com.tencent.mm.cm.k;
import com.tencent.mm.kiss.a.b.1;
import com.tencent.mm.modelrecovery.PluginRecovery;
import com.tencent.mm.plugin.auth.PluginAuth;
import com.tencent.mm.plugin.bbom.PluginBigBallOfMud;
import com.tencent.mm.plugin.messenger.foundation.PluginMessengerFoundation;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.plugin.recordvideo.res.PluginVideoRes;
import com.tencent.mm.plugin.report.PluginReport;
import com.tencent.mm.plugin.zero.PluginZero;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bp;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.z;
import com.tencent.mm.vfs.u;
import com.tencent.xweb.WebView.c;
import java.util.ArrayList;
import java.util.Map;
import org.xwalk.core.XWalkEnvironment;
import org.xwalk.core.XWalkEnvironment.ForceDarkBehavior;

public class i
  extends com.tencent.mm.kernel.a.d
{
  private static boolean cUr = true;
  private k cUp;
  private volatile boolean cUq;
  
  public i()
  {
    AppMethodBeat.i(160118);
    this.cUp = new k();
    this.cUq = false;
    AppMethodBeat.o(160118);
  }
  
  private static void LY()
  {
    AppMethodBeat.i(160122);
    long l = System.currentTimeMillis();
    ab.Mv();
    l = System.currentTimeMillis() - l;
    com.tencent.mm.blink.a.s(4L, l);
    com.tencent.mm.blink.a.s(5L, 1L);
    ae.i("MicroMsg.DefaultBootStep", "SVG newInstance done, spent %s", new Object[] { Long.valueOf(l) });
    AppMethodBeat.o(160122);
  }
  
  public void LM()
  {
    AppMethodBeat.i(160119);
    super.LM();
    com.tencent.mm.kernel.a.a.k("Hello WeChat, DefaultBootStep load debugger and newInstance xlog...", new Object[0]);
    ak.getContext().getSystemService("audio");
    t.fq(((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.g.ajO().ajq()).mProcessName);
    ab.Y(com.tencent.mm.boot.a.a.class);
    ab.fz("com.tencent.mm.boot");
    ab.a(((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.g.ajO().ajq()).ca, ((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.g.ajO().ajq()).ca.getResources());
    XWalkEnvironment.setForceDarkMode(al.isDarkMode());
    if (ak.isAppBrandProcess()) {
      com.tencent.mm.l.a.a.a(new com.tencent.mm.l.a()
      {
        public final boolean Mb()
        {
          AppMethodBeat.i(160132);
          com.tencent.mm.cp.d.a(WebView.c.MNy);
          boolean bool = com.tencent.mm.cp.d.fWX();
          AppMethodBeat.o(160132);
          return bool;
        }
      });
    }
    XWalkEnvironment.setForceDarkBehavior(XWalkEnvironment.ForceDarkBehavior.MEDIA_QUERY_ONLY);
    AppMethodBeat.o(160119);
  }
  
  public void LN()
  {
    AppMethodBeat.i(160120);
    com.tencent.mm.kernel.g.ajN().gDK = com.tencent.mm.plugin.zero.a.d.class;
    ah(PluginZero.class);
    ah(PluginMessengerFoundation.class);
    ah(PluginReport.class);
    ah(PluginAuth.class);
    ah(PluginBigBallOfMud.class);
    ah(PluginRecovery.class);
    xM("com.tencent.mm.plugin.bbom.PluginCompatOldStructure");
    xM("com.tencent.mm.plugin.bbom.PluginBigBallOfMudAsync");
    xM("com.tencent.mm.plugin.avatar.PluginAvatar");
    xM("com.tencent.mm.plugin.image.PluginImageBase");
    xM("com.tencent.mm.plugin.comm.PluginComm");
    xM("com.tencent.mm.plugin.audio.PluginVoice");
    xM("com.tencent.mm.plugin.biz.PluginBiz");
    xN("com.tencent.mm.plugin.bizui.PluginBIZUI");
    xM("com.tencent.mm.plugin.brandservice.PluginBrandService");
    xM("com.tencent.mm.plugin.readerapp.PluginReaderApp");
    xM("com.tencent.mm.plugin.notification.PluginNotification");
    xM("com.tencent.mm.plugin.messenger.PluginMessenger");
    xM("com.tencent.mm.plugin.notification.PluginPNotification");
    xM("com.tencent.mm.plugin.welab.PluginWelab");
    xM("com.tencent.mm.plugin.sport.PluginSport");
    xM("com.tencent.mm.plugin.fts.PluginFTS");
    xM("com.tencent.mm.plugin.updater.PluginUpdater");
    xM("com.tencent.mm.openim.PluginOpenIM");
    xN("com.tencent.mm.plugin.misc.PluginMisc");
    xM("com.tencent.mm.openim.room.PluginOpenIMRoom");
    xM("com.tencent.mm.roomsdk.PluginRoomSdk");
    xM("com.tencent.mm.ipcinvoker.wx_extension.PluginIPC");
    xM("com.tencent.mm.plugin.abtest.PluginABTest");
    xM("com.tencent.mm.plugin.expt.PluginExpt");
    xM("com.tencent.mm.plugin.backup.PluginBackup");
    xM("com.tencent.mm.pluginsdk.model.app.PluginAppMsg");
    xM("com.tencent.mm.plugin.hardcoder.PluginHardcoder");
    xN("com.tencent.mm.plugin.performance.PluginPerformance");
    xN("com.tencent.mm.plugin.chatroom.PluginChatroom");
    xN("com.tencent.mm.PluginFunctionMsg");
    xN("com.tencent.mm.insane_statistic.PluginInsaneStatistic");
    xN("com.tencent.mm.plugin.appbrand.app.PluginAppBrand");
    xN("com.tencent.mm.plugin.handoff.PluginHandOff");
    xN("com.tencent.mm.plugin.choosemsgfile.PluginChooseMsgFile");
    xN("com.tencent.mm.plugin.ball.PluginBall");
    xN("com.tencent.mm.plugin.uishow.PluginUIShow");
    xN("com.tencent.mm.plugin.emoji.PluginEmoji");
    xN("com.tencent.mm.plugin.eggspring.PluginEggSpring");
    xN("com.tencent.mm.chatroom.plugin.PluginChatroomUI");
    xN("com.tencent.mm.plugin.patmsg.PluginPatMsg");
    xN("com.tencent.mm.plugin.game.PluginGame");
    xN("com.tencent.mm.game.report.PluginGameReport");
    xN("com.tencent.mm.plugin.wepkg.PluginWePkg");
    xN("com.tencent.mm.plugin.game.commlib.PluginCommLib");
    xN("com.tencent.mm.plugin.gamelife.PluginGameLife");
    xN("com.tencent.mm.plugin.recordvideo.PluginVideoEditor");
    xN("com.tencent.mm.plugin.video.PluginVideo");
    xN("com.tencent.mm.plugin.hardwareopt.PluginHardwareOpt");
    xN("com.tencent.mm.plugin.sns.PluginSns");
    xN("com.tencent.mm.plugin.downloader.PluginDownloader");
    xN("com.tencent.mm.plugin.fav.PluginFav");
    xN("com.tencent.mm.plugin.fav.ui.PluginFavUI");
    xN("com.tencent.mm.plugin.record.PluginRecord");
    xN("com.tencent.mm.plugin.music.PluginMusic");
    xN("com.tencent.mm.plugin.MMPhotoEditPlugin");
    xN("com.tencent.mm.plugin.account.PluginAccount");
    Object localObject = com.tencent.mm.plugin.recordvideo.background.c.b.xMh;
    xN(com.tencent.mm.plugin.recordvideo.background.c.b.a.getCLASS());
    xN("com.tencent.mm.plugin.facedetect.PluginFace");
    xN("com.tencent.mm.plugin.soter.PluginSoter");
    xN("com.tencent.mm.plugin.walletlock.PluginWalletLock");
    xN("com.tencent.mm.plugin.wxpay.PluginWxPay");
    xN("com.tencent.mm.plugin.wxpaysdk.PluginWxPaySdk");
    xN("com.tencent.mm.plugin.wxpayapi.PluginWxPayApi");
    xN("com.tencent.kinda.framework.PluginWxKindaApi");
    xN("com.tencent.mm.plugin.paytest.api.PluginPayTestHeaderApi");
    xN("com.tencent.mm.plugin.radar.PluginRadar");
    xN("com.tencent.mm.plugin.topstory.PluginTopStory");
    xN("com.tencent.mm.plugin.topstory.ui.PluginTopStoryUI");
    xN("com.tencent.mm.plugin.websearch.PluginWebSearch");
    xN("com.tencent.mm.plugin.fts.ui.PluginFTSUI");
    xN("com.tencent.mm.plugin.card.PluginCard");
    xN("com.tencent.mm.plugin.card.compat.PluginCardCompat");
    xN("com.tencent.mm.plugin.forcenotify.PluginForceNotify");
    xN("com.tencent.mm.plugin.monitor.PluginMonitor");
    xM("com.tencent.mm.plugin.expansions.PluginExpansions");
    xN("com.tencent.mm.plugin.fcm.PluginFCM");
    xN("com.tencent.mm.plugin.emojicapture.model.PluginEmojiCapture");
    xN("com.tencent.mm.plugin.selectcontact.PluginSelectContact");
    xN("com.tencent.mm.plugin.cloudvoip.cloudvoice.PluginCloudVoice");
    xN("com.tencent.mm.plugin.webview.PluginWebView");
    xN("com.tencent.mm.plugin.priority.PluginPriority");
    xN("com.tencent.mm.plugin.qqmail.PluginQQMail");
    xN("com.tencent.mm.plugin.scanner.PluginScanTranslation");
    xN("com.tencent.mm.plugin.scanner.PluginScanner");
    xN("com.tencent.mm.plugin.newtips.PluginNewTips");
    xN("com.tencent.mm.plugin.groupsolitaire.PluginGroupSolitaire");
    xN("com.tencent.mm.plugin.groupcollect.PluginGroupCollect");
    xN("com.tencent.mm.plugin.editor.PluginEditor");
    xN("com.tencent.mm.plugin.fav.offline.PluginFavOffline");
    xN("com.tencent.mm.plugin.msgquote.PluginMsgQuote");
    xN("com.tencent.mm.plugin.selectrecord.PluginSelectRecord");
    xN("com.tencent.mm.contact.PluginContact");
    xN("com.tencent.mm.plugin.recordvideo.appcamera.PluginMMSight");
    xN("com.tencent.mm.plugin.secinforeport.PluginSecInfoReport");
    xN("com.tencent.mm.plugin.normsg.PluginNormsg");
    xN("com.tencent.mm.plugin.netmock.PluginNetMock");
    xN("com.tencent.kinda.debug.PluginKindaReload");
    xN("com.tencent.mm.plugin.rubbishbin.PluginRubbishbin");
    if (com.tencent.mm.sdk.platformtools.j.IwE.aRJ("ENABLE_STETHO")) {
      xN("com.tencent.mm.plugin.stetho.PluginStetho");
    }
    xN("com.tencent.mm.plugin.boots.PluginBoots");
    xN("com.tencent.mm.plugin.downloader_app.PluginDownloaderApp");
    xN("com.tencent.mm.plugin.game.luggage.PluginLuggageGame");
    xN("com.tencent.mm.plugin.trafficmonitor.PluginTrafficMonitor");
    xN("com.tencent.mm.plugin.story.PluginStory");
    xN("com.tencent.mm.plugin.finder.PluginFinder");
    xN("com.tencent.mm.plugin.byp.PluginByp");
    xN("com.tencent.mm.plugin.thumbplayer.PluginThumbPlayer");
    xN("com.tencent.mm.plugin.audio.PluginAudio");
    xN("com.tencent.mm.plugin.crashfix.PluginSystemCrashFix");
    xN("com.tencent.mm.plugin.flutter.PluginFlutter");
    xN("com.tencent.mm.plugin.box.PluginBox");
    xN("com.tencent.mm.plugin.lite.PluginLiteApp");
    xN("com.tencent.mm.plugin.mobile.verify.PluginMobileVerify");
    xN("com.tencent.mm.gpu.PluginGpuRes");
    xN("com.tencent.mm.live.PluginLive");
    xN(PluginVideoRes.class.getCanonicalName());
    xN("com.tencent.mm.wlogcat.PluginLogcat");
    localObject = com.tencent.mm.kernel.a.c.ake().gFf;
    com.tencent.mm.kernel.b.a locala = com.tencent.mm.kernel.g.ad(s.class);
    ((com.tencent.mm.kernel.a.b.g)localObject).gGu.put(com.tencent.mm.kernel.api.c.class, locala);
    AppMethodBeat.o(160120);
  }
  
  public final boolean LZ()
  {
    AppMethodBeat.i(160124);
    if (cUr)
    {
      AppMethodBeat.o(160124);
      return true;
    }
    if (!((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.g.ajO().ajq()).akL())
    {
      AppMethodBeat.o(160124);
      return true;
    }
    com.tencent.mm.kernel.g.ajP();
    if ((!com.tencent.mm.kernel.a.aiY()) || (!com.tencent.mm.kernel.g.ajP().aiZ()))
    {
      AppMethodBeat.o(160124);
      return true;
    }
    if (com.tencent.mm.splash.h.IEI.size() == 1)
    {
      Activity localActivity = (Activity)com.tencent.mm.splash.h.IEI.get(0);
      if (ak.fou().equals(com.tencent.mm.splash.h.aX(localActivity)))
      {
        ae.i("MicroMsg.DefaultBootStep", "Found LauncherUI only.");
        AppMethodBeat.o(160124);
        return false;
      }
    }
    AppMethodBeat.o(160124);
    return true;
  }
  
  public final void a(final com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(160121);
    u.h(paramg);
    LY();
    if (((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.g.ajO().ajq()).akL()) {
      new aq("Startup-SideWork").post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(160137);
          for (;;)
          {
            try
            {
              localObject3 = i.a(i.this);
            }
            catch (Exception localException)
            {
              Object localObject3;
              Object localObject5;
              boolean bool;
              ae.printErrStackTrace("MicroMsg.DefaultBootStep", localException, "", new Object[0]);
              com.tencent.mm.blink.a.s(10L, 1L);
              ae.i("MicroMsg.DefaultBootStep", "found a crash, %s %s %s", new Object[] { ak.getResources(), paramg.ca.getResources(), paramg.ca.getResources().getAssets() });
              i.a(i.this, paramg);
              i.b(i.this);
              return;
              com.tencent.mm.kiss.a.b.akR().a("R.layout.mm_bottom_tabitem", 4, 2131494776, new LinearLayout(localException), new int[0]);
              continue;
            }
            finally
            {
              i.a(i.this).done();
              AppMethodBeat.o(160137);
            }
            synchronized (((k)localObject3).mLock)
            {
              ((k)localObject3).mLock[0] = -1;
              com.tencent.mm.kernel.j.i("MicroMsg.WxWaitingLock", "markUse %s", new Object[] { localObject3 });
              i.a(i.this).done();
              localObject5 = new ContextWrapper(paramg.ca);
              ??? = com.tencent.mm.kiss.a.b.akR();
              localObject3 = com.tencent.mm.kiss.a.a.akQ().mHandler.getSerialTag();
              localObject5 = z.jV((Context)localObject5);
              if (!((com.tencent.mm.kiss.a.b)???).mInitialized)
              {
                ((com.tencent.mm.kiss.a.b)???).mInitialized = true;
                ((com.tencent.mm.kiss.a.b)???).mInflater = ((LayoutInflater)localObject5);
                ((com.tencent.mm.kiss.a.b)???).gGX = ((String)localObject3);
                ((com.tencent.mm.kiss.a.b)???).mMode = 2;
                ((com.tencent.mm.kiss.a.b)???).gGY = new b.1((com.tencent.mm.kiss.a.b)???, ((com.tencent.mm.kiss.a.b)???).gGX);
                if (com.tencent.mm.compatible.util.d.lB(26)) {
                  com.tencent.mm.kiss.a.b.gHa = new com.tencent.mm.kiss.a.b.a((String)localObject3);
                }
              }
              com.tencent.mm.blink.a.Wj();
              ??? = ak.getContext();
              bool = com.tencent.mm.kiss.a.b.akR().a("R.layout.actionbar_title_launcher", 1, 2131492927, new LinearLayout((Context)???), new int[0]);
              com.tencent.mm.kiss.a.b.akR().a("R.layout.main_tab", 1, 2131494684, new int[0]);
              if (com.tencent.mm.cb.a.is((Context)???))
              {
                com.tencent.mm.kiss.a.b.akR().a("R.layout.mm_bottom_tabitem_large", 4, 2131494777, new LinearLayout((Context)???), new int[0]);
                com.tencent.mm.kiss.a.b.akR().a("R.layout.mm_activity", 4, 2131494760, new int[0]);
                if ((!Build.BRAND.equals("vivo")) || (!com.tencent.mm.compatible.util.d.lB(20)))
                {
                  com.tencent.mm.kiss.a.b.akR().a("R.layout.main", 1, 2131494680, new int[0]);
                  com.tencent.mm.kiss.a.b.akR().a("R.layout.address", 1, 2131492947, new int[0]);
                  com.tencent.mm.kiss.a.b.akR().a("R.layout.mm_preference_fragment_list_content", 2, 2131494856, new int[0]);
                }
                com.tencent.mm.kiss.a.b.akR().a("R.layout.actionview_with_dot_tips", 1, 2131492929, new int[0]);
                if (bool)
                {
                  ??? = com.tencent.mm.kiss.a.b.akR();
                  localObject3 = new c.1();
                  ((com.tencent.mm.kiss.a.b)???).gGY.post((Runnable)localObject3);
                }
                i.a(i.this).done();
                AppMethodBeat.o(160137);
                return;
              }
            }
          }
        }
      });
    }
    super.a(paramg);
    AppMethodBeat.o(160121);
  }
  
  public final void b(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(160123);
    k localk;
    if (((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.g.ajO().ajq()).akL()) {
      localk = this.cUp;
    }
    synchronized (localk.mLock)
    {
      try
      {
        if (localk.mLock[0] == -1)
        {
          com.tencent.mm.kernel.j.i("MicroMsg.WxWaitingLock", "waiting %s", new Object[] { localk });
          localk.mLock.wait();
          com.tencent.mm.kernel.j.i("MicroMsg.WxWaitingLock", "after waiting %s", new Object[] { localk });
        }
        if (this.cUq) {
          ae.e("MicroMsg.DefaultBootStep", "SVG still failed!");
        }
        super.b(paramg);
        AppMethodBeat.o(160123);
        return;
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          ae.printErrStackTrace("MicroMsg.WxWaitingLock", localInterruptedException, "", new Object[0]);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.app.i
 * JD-Core Version:    0.7.0.1
 */