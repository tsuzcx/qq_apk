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
import com.tencent.mm.cn.k;
import com.tencent.mm.kernel.j;
import com.tencent.mm.kiss.a.b.1;
import com.tencent.mm.modelrecovery.PluginRecovery;
import com.tencent.mm.plugin.auth.PluginAuth;
import com.tencent.mm.plugin.bbom.PluginBigBallOfMud;
import com.tencent.mm.plugin.messenger.foundation.PluginMessengerFoundation;
import com.tencent.mm.plugin.messenger.foundation.a.r;
import com.tencent.mm.plugin.recordvideo.res.PluginVideoRes;
import com.tencent.mm.plugin.report.PluginReport;
import com.tencent.mm.plugin.zero.PluginZero;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.z;
import com.tencent.mm.vfs.o;
import com.tencent.xweb.WebView.c;
import java.util.ArrayList;
import java.util.Map;
import org.xwalk.core.XWalkEnvironment;
import org.xwalk.core.XWalkEnvironment.ForceDarkBehavior;

public class i
  extends com.tencent.mm.kernel.a.d
{
  private static boolean cTG = true;
  private k cTE;
  private volatile boolean cTF;
  
  public i()
  {
    AppMethodBeat.i(160118);
    this.cTE = new k();
    this.cTF = false;
    AppMethodBeat.o(160118);
  }
  
  private static void LQ()
  {
    AppMethodBeat.i(160122);
    long l = System.currentTimeMillis();
    ab.MA();
    l = System.currentTimeMillis() - l;
    com.tencent.mm.blink.a.s(4L, l);
    com.tencent.mm.blink.a.s(5L, 1L);
    ad.i("MicroMsg.DefaultBootStep", "SVG newInstance done, spent %s", new Object[] { Long.valueOf(l) });
    AppMethodBeat.o(160122);
  }
  
  public void LE()
  {
    AppMethodBeat.i(160119);
    super.LE();
    com.tencent.mm.kernel.a.a.k("Hello WeChat, DefaultBootStep load debugger and newInstance xlog...", new Object[0]);
    aj.getContext().getSystemService("audio");
    s.fk(((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.g.ajz().ajb()).mProcessName);
    ab.Y(com.tencent.mm.boot.a.a.class);
    ab.ft("com.tencent.mm.boot");
    ab.a(((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.g.ajz().ajb()).ca, ((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.g.ajz().ajb()).ca.getResources());
    XWalkEnvironment.setForceDarkMode(al.isDarkMode());
    if (aj.isAppBrandProcess()) {
      com.tencent.mm.l.a.a.a(new com.tencent.mm.l.a()
      {
        public final boolean LT()
        {
          AppMethodBeat.i(160132);
          com.tencent.mm.cq.d.a(WebView.c.Mqu);
          boolean bool = com.tencent.mm.cq.d.fSx();
          AppMethodBeat.o(160132);
          return bool;
        }
      });
    }
    XWalkEnvironment.setForceDarkBehavior(XWalkEnvironment.ForceDarkBehavior.MEDIA_QUERY_ONLY);
    AppMethodBeat.o(160119);
  }
  
  public void LF()
  {
    AppMethodBeat.i(160120);
    com.tencent.mm.kernel.g.ajy().gBd = com.tencent.mm.plugin.zero.a.d.class;
    ah(PluginZero.class);
    ah(PluginMessengerFoundation.class);
    ah(PluginReport.class);
    ah(PluginAuth.class);
    ah(PluginBigBallOfMud.class);
    ah(PluginRecovery.class);
    xd("com.tencent.mm.plugin.bbom.PluginCompatOldStructure");
    xd("com.tencent.mm.plugin.bbom.PluginBigBallOfMudAsync");
    xd("com.tencent.mm.plugin.avatar.PluginAvatar");
    xd("com.tencent.mm.plugin.image.PluginImageBase");
    xd("com.tencent.mm.plugin.comm.PluginComm");
    xd("com.tencent.mm.plugin.audio.PluginVoice");
    xd("com.tencent.mm.plugin.biz.PluginBiz");
    xe("com.tencent.mm.plugin.bizui.PluginBIZUI");
    xd("com.tencent.mm.plugin.brandservice.PluginBrandService");
    xd("com.tencent.mm.plugin.readerapp.PluginReaderApp");
    xd("com.tencent.mm.plugin.notification.PluginNotification");
    xd("com.tencent.mm.plugin.messenger.PluginMessenger");
    xd("com.tencent.mm.plugin.welab.PluginWelab");
    xd("com.tencent.mm.plugin.sport.PluginSport");
    xd("com.tencent.mm.plugin.fts.PluginFTS");
    xd("com.tencent.mm.plugin.updater.PluginUpdater");
    xd("com.tencent.mm.openim.PluginOpenIM");
    xe("com.tencent.mm.plugin.misc.PluginMisc");
    xd("com.tencent.mm.openim.room.PluginOpenIMRoom");
    xd("com.tencent.mm.roomsdk.PluginRoomSdk");
    xd("com.tencent.mm.ipcinvoker.wx_extension.PluginIPC");
    xd("com.tencent.mm.plugin.abtest.PluginABTest");
    xd("com.tencent.mm.plugin.expt.PluginExpt");
    xd("com.tencent.mm.plugin.backup.PluginBackup");
    xd("com.tencent.mm.pluginsdk.model.app.PluginAppMsg");
    xd("com.tencent.mm.plugin.hardcoder.PluginHardcoder");
    xe("com.tencent.mm.plugin.performance.PluginPerformance");
    xe("com.tencent.mm.plugin.chatroom.PluginChatroom");
    xe("com.tencent.mm.PluginFunctionMsg");
    xe("com.tencent.mm.insane_statistic.PluginInsaneStatistic");
    xe("com.tencent.mm.plugin.appbrand.app.PluginAppBrand");
    xe("com.tencent.mm.plugin.handoff.PluginHandOff");
    xe("com.tencent.mm.plugin.choosemsgfile.PluginChooseMsgFile");
    xe("com.tencent.mm.plugin.ball.PluginBall");
    xe("com.tencent.mm.plugin.uishow.PluginUIShow");
    xe("com.tencent.mm.plugin.emoji.PluginEmoji");
    xe("com.tencent.mm.plugin.eggspring.PluginEggSpring");
    xe("com.tencent.mm.chatroom.plugin.PluginChatroomUI");
    xe("com.tencent.mm.plugin.patmsg.PluginPatMsg");
    xe("com.tencent.mm.plugin.game.PluginGame");
    xe("com.tencent.mm.game.report.PluginGameReport");
    xe("com.tencent.mm.plugin.wepkg.PluginWePkg");
    xe("com.tencent.mm.plugin.game.commlib.PluginCommLib");
    xe("com.tencent.mm.plugin.gamelife.PluginGameLife");
    xe("com.tencent.mm.plugin.recordvideo.PluginVideoEditor");
    xe("com.tencent.mm.plugin.video.PluginVideo");
    xe("com.tencent.mm.plugin.hardwareopt.PluginHardwareOpt");
    xe("com.tencent.mm.plugin.sns.PluginSns");
    xe("com.tencent.mm.plugin.downloader.PluginDownloader");
    xe("com.tencent.mm.plugin.fav.PluginFav");
    xe("com.tencent.mm.plugin.fav.ui.PluginFavUI");
    xe("com.tencent.mm.plugin.record.PluginRecord");
    xe("com.tencent.mm.plugin.music.PluginMusic");
    xe("com.tencent.mm.plugin.MMPhotoEditPlugin");
    xe("com.tencent.mm.plugin.account.PluginAccount");
    Object localObject = com.tencent.mm.plugin.recordvideo.background.c.b.xwk;
    xe(com.tencent.mm.plugin.recordvideo.background.c.b.a.getCLASS());
    xe("com.tencent.mm.plugin.facedetect.PluginFace");
    xe("com.tencent.mm.plugin.soter.PluginSoter");
    xe("com.tencent.mm.plugin.walletlock.PluginWalletLock");
    xe("com.tencent.mm.plugin.wxpay.PluginWxPay");
    xe("com.tencent.mm.plugin.wxpaysdk.PluginWxPaySdk");
    xe("com.tencent.mm.plugin.wxpayapi.PluginWxPayApi");
    xe("com.tencent.kinda.framework.PluginWxKindaApi");
    xe("com.tencent.mm.plugin.paytest.api.PluginPayTestHeaderApi");
    xe("com.tencent.mm.plugin.radar.PluginRadar");
    xe("com.tencent.mm.plugin.topstory.PluginTopStory");
    xe("com.tencent.mm.plugin.topstory.ui.PluginTopStoryUI");
    xe("com.tencent.mm.plugin.websearch.PluginWebSearch");
    xe("com.tencent.mm.plugin.fts.ui.PluginFTSUI");
    xe("com.tencent.mm.plugin.card.PluginCard");
    xe("com.tencent.mm.plugin.card.compat.PluginCardCompat");
    xe("com.tencent.mm.plugin.forcenotify.PluginForceNotify");
    xe("com.tencent.mm.plugin.monitor.PluginMonitor");
    xd("com.tencent.mm.plugin.expansions.PluginExpansions");
    xe("com.tencent.mm.plugin.fcm.PluginFCM");
    xe("com.tencent.mm.plugin.emojicapture.model.PluginEmojiCapture");
    xe("com.tencent.mm.plugin.selectcontact.PluginSelectContact");
    xe("com.tencent.mm.plugin.cloudvoip.cloudvoice.PluginCloudVoice");
    xe("com.tencent.mm.plugin.webview.PluginWebView");
    xe("com.tencent.mm.plugin.priority.PluginPriority");
    xe("com.tencent.mm.plugin.qqmail.PluginQQMail");
    xe("com.tencent.mm.plugin.scanner.PluginScanTranslation");
    xe("com.tencent.mm.plugin.scanner.PluginScanner");
    xe("com.tencent.mm.plugin.newtips.PluginNewTips");
    xe("com.tencent.mm.plugin.groupsolitaire.PluginGroupSolitaire");
    xe("com.tencent.mm.plugin.groupcollect.PluginGroupCollect");
    xe("com.tencent.mm.plugin.editor.PluginEditor");
    xe("com.tencent.mm.plugin.fav.offline.PluginFavOffline");
    xe("com.tencent.mm.plugin.msgquote.PluginMsgQuote");
    xe("com.tencent.mm.plugin.selectrecord.PluginSelectRecord");
    xe("com.tencent.mm.plugin.recordvideo.appcamera.PluginMMSight");
    xe("com.tencent.mm.plugin.secinforeport.PluginSecInfoReport");
    xe("com.tencent.mm.plugin.normsg.PluginNormsg");
    xe("com.tencent.mm.plugin.netmock.PluginNetMock");
    xe("com.tencent.kinda.debug.PluginKindaReload");
    xe("com.tencent.mm.plugin.rubbishbin.PluginRubbishbin");
    if (com.tencent.mm.sdk.platformtools.i.Ict.aQm("ENABLE_STETHO")) {
      xe("com.tencent.mm.plugin.stetho.PluginStetho");
    }
    xe("com.tencent.mm.plugin.boots.PluginBoots");
    xe("com.tencent.mm.plugin.downloader_app.PluginDownloaderApp");
    xe("com.tencent.mm.plugin.game.luggage.PluginLuggageGame");
    xe("com.tencent.mm.plugin.trafficmonitor.PluginTrafficMonitor");
    xe("com.tencent.mm.plugin.story.PluginStory");
    xe("com.tencent.mm.plugin.finder.PluginFinder");
    xe("com.tencent.mm.plugin.byp.PluginByp");
    xe("com.tencent.mm.plugin.thumbplayer.PluginThumbPlayer");
    xe("com.tencent.mm.plugin.audio.PluginAudio");
    xe("com.tencent.mm.plugin.crashfix.PluginSystemCrashFix");
    xe("com.tencent.mm.plugin.flutter.PluginFlutter");
    xe("com.tencent.mm.plugin.box.PluginBox");
    xe("com.tencent.mm.plugin.lite.PluginLiteApp");
    xe("com.tencent.mm.plugin.mobile.verify.PluginMobileVerify");
    xe("com.tencent.mm.gpu.PluginGpuRes");
    xe("com.tencent.mm.live.PluginLive");
    xe(PluginVideoRes.class.getCanonicalName());
    localObject = com.tencent.mm.kernel.a.c.ajP().gCy;
    com.tencent.mm.kernel.b.a locala = com.tencent.mm.kernel.g.ad(r.class);
    ((com.tencent.mm.kernel.a.b.g)localObject).gDN.put(com.tencent.mm.kernel.api.c.class, locala);
    AppMethodBeat.o(160120);
  }
  
  public final boolean LR()
  {
    AppMethodBeat.i(160124);
    if (cTG)
    {
      AppMethodBeat.o(160124);
      return true;
    }
    if (!((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.g.ajz().ajb()).akw())
    {
      AppMethodBeat.o(160124);
      return true;
    }
    com.tencent.mm.kernel.g.ajA();
    if ((!com.tencent.mm.kernel.a.aiJ()) || (!com.tencent.mm.kernel.g.ajA().aiK()))
    {
      AppMethodBeat.o(160124);
      return true;
    }
    if (com.tencent.mm.splash.h.Ikx.size() == 1)
    {
      Activity localActivity = (Activity)com.tencent.mm.splash.h.Ikx.get(0);
      if (aj.fkA().equals(com.tencent.mm.splash.h.aW(localActivity)))
      {
        ad.i("MicroMsg.DefaultBootStep", "Found LauncherUI only.");
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
    o.g(paramg);
    LQ();
    if (((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.g.ajz().ajb()).akw()) {
      new ap("Startup-SideWork").post(new Runnable()
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
              ad.printErrStackTrace("MicroMsg.DefaultBootStep", localException, "", new Object[0]);
              com.tencent.mm.blink.a.s(10L, 1L);
              ad.i("MicroMsg.DefaultBootStep", "found a crash, %s %s %s", new Object[] { aj.getResources(), paramg.ca.getResources(), paramg.ca.getResources().getAssets() });
              i.a(i.this, paramg);
              i.b(i.this);
              return;
              com.tencent.mm.kiss.a.b.akC().a("R.layout.mm_bottom_tabitem", 4, 2131494776, new LinearLayout(localException), new int[0]);
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
              j.i("MicroMsg.WxWaitingLock", "markUse %s", new Object[] { localObject3 });
              i.a(i.this).done();
              localObject5 = new ContextWrapper(paramg.ca);
              ??? = com.tencent.mm.kiss.a.b.akC();
              localObject3 = com.tencent.mm.kiss.a.a.akB().mHandler.getSerialTag();
              localObject5 = z.jO((Context)localObject5);
              if (!((com.tencent.mm.kiss.a.b)???).mInitialized)
              {
                ((com.tencent.mm.kiss.a.b)???).mInitialized = true;
                ((com.tencent.mm.kiss.a.b)???).mInflater = ((LayoutInflater)localObject5);
                ((com.tencent.mm.kiss.a.b)???).gEq = ((String)localObject3);
                ((com.tencent.mm.kiss.a.b)???).mMode = 2;
                ((com.tencent.mm.kiss.a.b)???).gEr = new b.1((com.tencent.mm.kiss.a.b)???, ((com.tencent.mm.kiss.a.b)???).gEq);
                if (com.tencent.mm.compatible.util.d.lz(26)) {
                  com.tencent.mm.kiss.a.b.gEt = new com.tencent.mm.kiss.a.b.a((String)localObject3);
                }
              }
              com.tencent.mm.blink.a.Wb();
              ??? = aj.getContext();
              bool = com.tencent.mm.kiss.a.b.akC().a("R.layout.actionbar_title_launcher", 1, 2131492927, new LinearLayout((Context)???), new int[0]);
              com.tencent.mm.kiss.a.b.akC().a("R.layout.main_tab", 1, 2131494684, new int[0]);
              if (com.tencent.mm.cc.a.in((Context)???))
              {
                com.tencent.mm.kiss.a.b.akC().a("R.layout.mm_bottom_tabitem_large", 4, 2131494777, new LinearLayout((Context)???), new int[0]);
                com.tencent.mm.kiss.a.b.akC().a("R.layout.mm_activity", 4, 2131494760, new int[0]);
                if ((!Build.BRAND.equals("vivo")) || (!com.tencent.mm.compatible.util.d.lz(20)))
                {
                  com.tencent.mm.kiss.a.b.akC().a("R.layout.main", 1, 2131494680, new int[0]);
                  com.tencent.mm.kiss.a.b.akC().a("R.layout.address", 1, 2131492947, new int[0]);
                  com.tencent.mm.kiss.a.b.akC().a("R.layout.mm_preference_fragment_list_content", 2, 2131494856, new int[0]);
                }
                com.tencent.mm.kiss.a.b.akC().a("R.layout.actionview_with_dot_tips", 1, 2131492929, new int[0]);
                if (bool)
                {
                  ??? = com.tencent.mm.kiss.a.b.akC();
                  localObject3 = new c.1();
                  ((com.tencent.mm.kiss.a.b)???).gEr.post((Runnable)localObject3);
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
    if (((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.g.ajz().ajb()).akw()) {
      localk = this.cTE;
    }
    synchronized (localk.mLock)
    {
      try
      {
        if (localk.mLock[0] == -1)
        {
          j.i("MicroMsg.WxWaitingLock", "waiting %s", new Object[] { localk });
          localk.mLock.wait();
          j.i("MicroMsg.WxWaitingLock", "after waiting %s", new Object[] { localk });
        }
        if (this.cTF) {
          ad.e("MicroMsg.DefaultBootStep", "SVG still failed!");
        }
        super.b(paramg);
        AppMethodBeat.o(160123);
        return;
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          ad.printErrStackTrace("MicroMsg.WxWaitingLock", localInterruptedException, "", new Object[0]);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.app.i
 * JD-Core Version:    0.7.0.1
 */