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
import com.tencent.mm.co.k;
import com.tencent.mm.kernel.j;
import com.tencent.mm.kiss.a.b.1;
import com.tencent.mm.modelrecovery.PluginRecovery;
import com.tencent.mm.plugin.auth.PluginAuth;
import com.tencent.mm.plugin.bbom.PluginBigBallOfMud;
import com.tencent.mm.plugin.messenger.foundation.PluginMessengerFoundation;
import com.tencent.mm.plugin.messenger.foundation.a.q;
import com.tencent.mm.plugin.report.PluginReport;
import com.tencent.mm.plugin.zero.PluginZero;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.ui.ai;
import com.tencent.mm.ui.y;
import com.tencent.mm.vfs.o;
import com.tencent.xweb.WebView.c;
import java.util.ArrayList;
import java.util.Map;
import org.xwalk.core.XWalkEnvironment;
import org.xwalk.core.XWalkEnvironment.ForceDarkBehavior;

public class i
  extends com.tencent.mm.kernel.a.d
{
  private static boolean cLq = true;
  private k cLo;
  private volatile boolean cLp;
  
  public i()
  {
    AppMethodBeat.i(160118);
    this.cLo = new k();
    this.cLp = false;
    AppMethodBeat.o(160118);
  }
  
  private static void KC()
  {
    AppMethodBeat.i(160122);
    long l = System.currentTimeMillis();
    aa.KV();
    l = System.currentTimeMillis() - l;
    com.tencent.mm.blink.a.w(4L, l);
    com.tencent.mm.blink.a.w(5L, 1L);
    ad.i("MicroMsg.DefaultBootStep", "SVG newInstance done, spent %s", new Object[] { Long.valueOf(l) });
    AppMethodBeat.o(160122);
  }
  
  public final boolean KD()
  {
    AppMethodBeat.i(160124);
    if (cLq)
    {
      AppMethodBeat.o(160124);
      return true;
    }
    if (!((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.g.afy().aeZ()).agu())
    {
      AppMethodBeat.o(160124);
      return true;
    }
    com.tencent.mm.kernel.g.afz();
    if ((!com.tencent.mm.kernel.a.aeH()) || (!com.tencent.mm.kernel.g.afz().aeI()))
    {
      AppMethodBeat.o(160124);
      return true;
    }
    if (com.tencent.mm.splash.h.Fbm.size() == 1)
    {
      Activity localActivity = (Activity)com.tencent.mm.splash.h.Fbm.get(0);
      if (aj.eFB().equals(com.tencent.mm.splash.h.aS(localActivity)))
      {
        ad.i("MicroMsg.DefaultBootStep", "Found LauncherUI only.");
        AppMethodBeat.o(160124);
        return false;
      }
    }
    AppMethodBeat.o(160124);
    return true;
  }
  
  public void Kv()
  {
    AppMethodBeat.i(160119);
    super.Kv();
    com.tencent.mm.kernel.a.a.h("Hello WeChat, DefaultBootStep load debugger and newInstance xlog...", new Object[0]);
    aj.getContext().getSystemService("audio");
    s.eA(((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.g.afy().aeZ()).mProcessName);
    aa.Y(com.tencent.mm.boot.a.a.class);
    aa.eI("com.tencent.mm.boot");
    aa.a(((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.g.afy().aeZ()).ca, ((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.g.afy().aeZ()).ca.getResources());
    XWalkEnvironment.setForceDarkMode(ai.Eq());
    if (aj.isAppBrandProcess()) {
      com.tencent.mm.k.a.a.a(new com.tencent.mm.k.a()
      {
        public final boolean KF()
        {
          AppMethodBeat.i(160132);
          com.tencent.mm.cr.d.a(WebView.c.INC);
          boolean bool = com.tencent.mm.cr.d.fkS();
          AppMethodBeat.o(160132);
          return bool;
        }
      });
    }
    XWalkEnvironment.setForceDarkBehavior(XWalkEnvironment.ForceDarkBehavior.MEDIA_QUERY_ONLY);
    AppMethodBeat.o(160119);
  }
  
  public void Kw()
  {
    AppMethodBeat.i(160120);
    com.tencent.mm.kernel.g.afx().gcN = com.tencent.mm.plugin.zero.a.d.class;
    ah(PluginZero.class);
    ah(PluginMessengerFoundation.class);
    ah(PluginReport.class);
    ah(PluginAuth.class);
    ah(PluginBigBallOfMud.class);
    ah(PluginRecovery.class);
    qY("com.tencent.mm.plugin.bbom.PluginCompatOldStructure");
    qY("com.tencent.mm.plugin.bbom.PluginBigBallOfMudAsync");
    qY("com.tencent.mm.plugin.avatar.PluginAvatar");
    qY("com.tencent.mm.plugin.image.PluginImageBase");
    qY("com.tencent.mm.plugin.comm.PluginComm");
    qY("com.tencent.mm.plugin.audio.PluginVoice");
    qY("com.tencent.mm.plugin.biz.PluginBiz");
    qZ("com.tencent.mm.plugin.bizui.PluginBIZUI");
    qY("com.tencent.mm.plugin.brandservice.PluginBrandService");
    qY("com.tencent.mm.plugin.readerapp.PluginReaderApp");
    qY("com.tencent.mm.plugin.notification.PluginNotification");
    qY("com.tencent.mm.plugin.messenger.PluginMessenger");
    qY("com.tencent.mm.plugin.welab.PluginWelab");
    qY("com.tencent.mm.plugin.sport.PluginSport");
    qY("com.tencent.mm.plugin.fts.PluginFTS");
    qY("com.tencent.mm.openim.PluginOpenIM");
    qZ("com.tencent.mm.plugin.misc.PluginMisc");
    qY("com.tencent.mm.openim.room.PluginOpenIMRoom");
    qY("com.tencent.mm.roomsdk.PluginRoomSdk");
    qY("com.tencent.mm.ipcinvoker.wx_extension.PluginIPC");
    qY("com.tencent.mm.plugin.abtest.PluginABTest");
    qY("com.tencent.mm.plugin.expt.PluginExpt");
    qY("com.tencent.mm.plugin.backup.PluginBackup");
    qY("com.tencent.mm.pluginsdk.model.app.PluginAppMsg");
    qY("com.tencent.mm.plugin.hardcoder.PluginHardcoder");
    qZ("com.tencent.mm.plugin.performance.PluginPerformance");
    qZ("com.tencent.mm.plugin.chatroom.PluginChatroom");
    qZ("com.tencent.mm.PluginFunctionMsg");
    qZ("com.tencent.mm.insane_statistic.PluginInsaneStatistic");
    qZ("com.tencent.mm.plugin.appbrand.app.PluginAppBrand");
    qZ("com.tencent.mm.plugin.handoff.PluginHandOff");
    qZ("com.tencent.mm.plugin.choosemsgfile.PluginChooseMsgFile");
    qZ("com.tencent.mm.plugin.ball.PluginBall");
    qZ("com.tencent.mm.plugin.uishow.PluginUIShow");
    qZ("com.tencent.mm.plugin.emoji.PluginEmoji");
    qZ("com.tencent.mm.plugin.eggspring.PluginEggSpring");
    qZ("com.tencent.mm.chatroom.plugin.PluginChatroomUI");
    qZ("com.tencent.mm.plugin.game.PluginGame");
    qZ("com.tencent.mm.game.report.PluginGameReport");
    qZ("com.tencent.mm.plugin.wepkg.PluginWePkg");
    qZ("com.tencent.mm.plugin.game.commlib.PluginCommLib");
    qZ("com.tencent.mm.plugin.recordvideo.PluginVideoEditor");
    qZ("com.tencent.mm.plugin.video.PluginVideo");
    qZ("com.tencent.mm.plugin.hardwareopt.PluginHardwareOpt");
    qZ("com.tencent.mm.plugin.sns.PluginSns");
    qZ("com.tencent.mm.plugin.downloader.PluginDownloader");
    qZ("com.tencent.mm.plugin.fav.PluginFav");
    qZ("com.tencent.mm.plugin.fav.ui.PluginFavUI");
    qZ("com.tencent.mm.plugin.record.PluginRecord");
    qZ("com.tencent.mm.plugin.music.PluginMusic");
    qZ("com.tencent.mm.plugin.MMPhotoEditPlugin");
    qZ("com.tencent.mm.plugin.account.PluginAccount");
    Object localObject = com.tencent.mm.plugin.recordvideo.background.b.b.vfI;
    qZ(com.tencent.mm.plugin.recordvideo.background.b.b.a.dhj());
    qZ("com.tencent.mm.plugin.facedetect.PluginFace");
    qZ("com.tencent.mm.plugin.soter.PluginSoter");
    qZ("com.tencent.mm.plugin.walletlock.PluginWalletLock");
    qZ("com.tencent.mm.plugin.wxpay.PluginWxPay");
    qZ("com.tencent.mm.plugin.wxpaysdk.PluginWxPaySdk");
    qZ("com.tencent.mm.plugin.wxpayapi.PluginWxPayApi");
    qZ("com.tencent.kinda.framework.PluginWxKindaApi");
    qZ("com.tencent.mm.plugin.radar.PluginRadar");
    qZ("com.tencent.mm.plugin.topstory.PluginTopStory");
    qZ("com.tencent.mm.plugin.topstory.ui.PluginTopStoryUI");
    qZ("com.tencent.mm.plugin.websearch.PluginWebSearch");
    qZ("com.tencent.mm.plugin.fts.ui.PluginFTSUI");
    qZ("com.tencent.mm.plugin.card.PluginCard");
    qZ("com.tencent.mm.plugin.card.compat.PluginCardCompat");
    qZ("com.tencent.mm.plugin.kitchen.PluginKitchen");
    qZ("com.tencent.mm.plugin.forcenotify.PluginForceNotify");
    qZ("com.tencent.mm.plugin.monitor.PluginMonitor");
    qY("com.tencent.mm.plugin.expansions.PluginExpansions");
    qZ("com.tencent.mm.plugin.fcm.PluginFCM");
    qZ("com.tencent.mm.plugin.emojicapture.model.PluginEmojiCapture");
    qZ("com.tencent.mm.plugin.selectcontact.PluginSelectContact");
    qZ("com.tencent.mm.plugin.cloudvoip.cloudvoice.PluginCloudVoice");
    qZ("com.tencent.mm.plugin.webview.PluginWebView");
    qZ("com.tencent.mm.plugin.priority.PluginPriority");
    qZ("com.tencent.mm.plugin.qqmail.PluginQQMail");
    qZ("com.tencent.mm.plugin.scanner.PluginScanTranslation");
    qZ("com.tencent.mm.plugin.scanner.PluginScanner");
    qZ("com.tencent.mm.plugin.newtips.PluginNewTips");
    qZ("com.tencent.mm.plugin.groupsolitaire.PluginGroupSolitaire");
    qZ("com.tencent.mm.plugin.groupcollect.PluginGroupCollect");
    qZ("com.tencent.mm.plugin.editor.PluginEditor");
    qZ("com.tencent.mm.plugin.fav.offline.PluginFavOffline");
    qZ("com.tencent.mm.plugin.msgquote.PluginMsgQuote");
    qZ("com.tencent.mm.plugin.recordvideo.appcamera.PluginMMSight");
    qZ("com.tencent.mm.plugin.secinforeport.PluginSecInfoReport");
    qZ("com.tencent.mm.plugin.normsg.PluginNormsg");
    qZ("com.tencent.mm.plugin.netmock.PluginNetMock");
    qZ("com.tencent.kinda.debug.PluginKindaReload");
    qZ("com.tencent.mm.plugin.rubbishbin.PluginRubbishbin");
    if (com.tencent.mm.sdk.platformtools.h.ETs.aFp("ENABLE_STETHO")) {
      qZ("com.tencent.mm.plugin.stetho.PluginStetho");
    }
    qZ("com.tencent.mm.plugin.boots.PluginBoots");
    qZ("com.tencent.mm.plugin.downloader_app.PluginDownloaderApp");
    qZ("com.tencent.mm.plugin.game.luggage.PluginLuggageGame");
    qZ("com.tencent.mm.plugin.trafficmonitor.PluginTrafficMonitor");
    qZ("com.tencent.mm.plugin.story.PluginStory");
    qZ("com.tencent.mm.plugin.finder.PluginFinder");
    qZ("com.tencent.mm.plugin.audio.PluginAudio");
    qZ("com.tencent.mm.plugin.crashfix.PluginSystemCrashFix");
    qZ("com.tencent.mm.plugin.flutter.PluginFlutter");
    qZ("com.tencent.mm.plugin.box.PluginBox");
    qZ("com.tencent.mm.plugin.lite.PluginLiteApp");
    qZ("com.tencent.mm.plugin.mobile.verify.PluginMobileVerify");
    qZ("com.tencent.mm.live.PluginLive");
    localObject = com.tencent.mm.kernel.a.c.afO().gei;
    com.tencent.mm.kernel.b.a locala = com.tencent.mm.kernel.g.ad(q.class);
    ((com.tencent.mm.kernel.a.b.g)localObject).gfx.put(com.tencent.mm.kernel.api.c.class, locala);
    AppMethodBeat.o(160120);
  }
  
  public final void a(final com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(160121);
    o.g(paramg);
    KC();
    if (((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.g.afy().aeZ()).agu()) {
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
              com.tencent.mm.blink.a.w(10L, 1L);
              ad.i("MicroMsg.DefaultBootStep", "found a crash, %s %s %s", new Object[] { aj.getResources(), paramg.ca.getResources(), paramg.ca.getResources().getAssets() });
              i.a(i.this, paramg);
              i.b(i.this);
              return;
              com.tencent.mm.kiss.a.b.agA().a("R.layout.mm_bottom_tabitem", 4, 2131494776, new LinearLayout(localException), new int[0]);
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
              ??? = com.tencent.mm.kiss.a.b.agA();
              localObject3 = com.tencent.mm.kiss.a.a.agz().mHandler.getSerialTag();
              localObject5 = y.js((Context)localObject5);
              if (!((com.tencent.mm.kiss.a.b)???).mInitialized)
              {
                ((com.tencent.mm.kiss.a.b)???).mInitialized = true;
                ((com.tencent.mm.kiss.a.b)???).mInflater = ((LayoutInflater)localObject5);
                ((com.tencent.mm.kiss.a.b)???).gga = ((String)localObject3);
                ((com.tencent.mm.kiss.a.b)???).mMode = 2;
                ((com.tencent.mm.kiss.a.b)???).ggb = new b.1((com.tencent.mm.kiss.a.b)???, ((com.tencent.mm.kiss.a.b)???).gga);
                if (com.tencent.mm.compatible.util.d.lg(26)) {
                  com.tencent.mm.kiss.a.b.ggd = new com.tencent.mm.kiss.a.b.a((String)localObject3);
                }
              }
              com.tencent.mm.blink.a.SQ();
              ??? = aj.getContext();
              bool = com.tencent.mm.kiss.a.b.agA().a("R.layout.actionbar_title_launcher", 1, 2131492927, new LinearLayout((Context)???), new int[0]);
              com.tencent.mm.kiss.a.b.agA().a("R.layout.main_tab", 1, 2131494684, new int[0]);
              if (com.tencent.mm.cd.a.hT((Context)???))
              {
                com.tencent.mm.kiss.a.b.agA().a("R.layout.mm_bottom_tabitem_large", 4, 2131494777, new LinearLayout((Context)???), new int[0]);
                com.tencent.mm.kiss.a.b.agA().a("R.layout.mm_activity", 4, 2131494760, new int[0]);
                if ((!Build.BRAND.equals("vivo")) || (!com.tencent.mm.compatible.util.d.lg(20)))
                {
                  com.tencent.mm.kiss.a.b.agA().a("R.layout.main", 1, 2131494680, new int[0]);
                  com.tencent.mm.kiss.a.b.agA().a("R.layout.address", 1, 2131492947, new int[0]);
                  com.tencent.mm.kiss.a.b.agA().a("R.layout.mm_preference_fragment_list_content", 2, 2131494856, new int[0]);
                }
                com.tencent.mm.kiss.a.b.agA().a("R.layout.actionview_with_dot_tips", 1, 2131492929, new int[0]);
                if (bool)
                {
                  ??? = com.tencent.mm.kiss.a.b.agA();
                  localObject3 = new c.1();
                  ((com.tencent.mm.kiss.a.b)???).ggb.post((Runnable)localObject3);
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
    if (((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.g.afy().aeZ()).agu()) {
      localk = this.cLo;
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
        if (this.cLp) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.app.i
 * JD-Core Version:    0.7.0.1
 */