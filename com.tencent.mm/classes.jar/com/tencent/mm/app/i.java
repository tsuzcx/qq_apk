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
import com.tencent.mm.plugin.messenger.foundation.a.q;
import com.tencent.mm.plugin.report.PluginReport;
import com.tencent.mm.plugin.zero.PluginZero;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bn;
import com.tencent.mm.sdk.platformtools.t;
import com.tencent.mm.ui.aj;
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
  private static boolean cIy = true;
  private k cIw;
  private volatile boolean cIx;
  
  public i()
  {
    AppMethodBeat.i(160118);
    this.cIw = new k();
    this.cIx = false;
    AppMethodBeat.o(160118);
  }
  
  private static void Kn()
  {
    AppMethodBeat.i(160122);
    long l = System.currentTimeMillis();
    ab.KT();
    l = System.currentTimeMillis() - l;
    com.tencent.mm.blink.a.s(4L, l);
    com.tencent.mm.blink.a.s(5L, 1L);
    ac.i("MicroMsg.DefaultBootStep", "SVG newInstance done, spent %s", new Object[] { Long.valueOf(l) });
    AppMethodBeat.o(160122);
  }
  
  public void Kf()
  {
    AppMethodBeat.i(160119);
    super.Kf();
    com.tencent.mm.kernel.a.a.h("Hello WeChat, DefaultBootStep load debugger and newInstance xlog...", new Object[0]);
    ai.getContext().getSystemService("audio");
    s.ep(((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.g.agO().agp()).mProcessName);
    ab.Y(com.tencent.mm.boot.a.a.class);
    ab.ey("com.tencent.mm.boot");
    ab.a(((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.g.agO().agp()).ca, ((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.g.agO().agp()).ca.getResources());
    XWalkEnvironment.setForceDarkMode(aj.DT());
    if (ai.isAppBrandProcess()) {
      com.tencent.mm.k.a.a.a(new com.tencent.mm.k.a()
      {
        public final boolean Kq()
        {
          AppMethodBeat.i(160132);
          com.tencent.mm.cq.d.a(WebView.c.KzZ);
          boolean bool = com.tencent.mm.cq.d.fBi();
          AppMethodBeat.o(160132);
          return bool;
        }
      });
    }
    XWalkEnvironment.setForceDarkBehavior(XWalkEnvironment.ForceDarkBehavior.MEDIA_QUERY_ONLY);
    AppMethodBeat.o(160119);
  }
  
  public void Kg()
  {
    AppMethodBeat.i(160120);
    com.tencent.mm.kernel.g.agN().ght = com.tencent.mm.plugin.zero.a.d.class;
    ah(PluginZero.class);
    ah(PluginMessengerFoundation.class);
    ah(PluginReport.class);
    ah(PluginAuth.class);
    ah(PluginBigBallOfMud.class);
    ah(PluginRecovery.class);
    un("com.tencent.mm.plugin.bbom.PluginCompatOldStructure");
    un("com.tencent.mm.plugin.bbom.PluginBigBallOfMudAsync");
    un("com.tencent.mm.plugin.avatar.PluginAvatar");
    un("com.tencent.mm.plugin.image.PluginImageBase");
    un("com.tencent.mm.plugin.comm.PluginComm");
    un("com.tencent.mm.plugin.audio.PluginVoice");
    un("com.tencent.mm.plugin.biz.PluginBiz");
    uo("com.tencent.mm.plugin.bizui.PluginBIZUI");
    un("com.tencent.mm.plugin.brandservice.PluginBrandService");
    un("com.tencent.mm.plugin.readerapp.PluginReaderApp");
    un("com.tencent.mm.plugin.notification.PluginNotification");
    un("com.tencent.mm.plugin.messenger.PluginMessenger");
    un("com.tencent.mm.plugin.welab.PluginWelab");
    un("com.tencent.mm.plugin.sport.PluginSport");
    un("com.tencent.mm.plugin.fts.PluginFTS");
    un("com.tencent.mm.openim.PluginOpenIM");
    uo("com.tencent.mm.plugin.misc.PluginMisc");
    un("com.tencent.mm.openim.room.PluginOpenIMRoom");
    un("com.tencent.mm.roomsdk.PluginRoomSdk");
    un("com.tencent.mm.ipcinvoker.wx_extension.PluginIPC");
    un("com.tencent.mm.plugin.abtest.PluginABTest");
    un("com.tencent.mm.plugin.expt.PluginExpt");
    un("com.tencent.mm.plugin.backup.PluginBackup");
    un("com.tencent.mm.pluginsdk.model.app.PluginAppMsg");
    un("com.tencent.mm.plugin.hardcoder.PluginHardcoder");
    uo("com.tencent.mm.plugin.performance.PluginPerformance");
    uo("com.tencent.mm.plugin.chatroom.PluginChatroom");
    uo("com.tencent.mm.PluginFunctionMsg");
    uo("com.tencent.mm.insane_statistic.PluginInsaneStatistic");
    uo("com.tencent.mm.plugin.appbrand.app.PluginAppBrand");
    uo("com.tencent.mm.plugin.handoff.PluginHandOff");
    uo("com.tencent.mm.plugin.choosemsgfile.PluginChooseMsgFile");
    uo("com.tencent.mm.plugin.ball.PluginBall");
    uo("com.tencent.mm.plugin.uishow.PluginUIShow");
    uo("com.tencent.mm.plugin.emoji.PluginEmoji");
    uo("com.tencent.mm.plugin.eggspring.PluginEggSpring");
    uo("com.tencent.mm.chatroom.plugin.PluginChatroomUI");
    uo("com.tencent.mm.plugin.game.PluginGame");
    uo("com.tencent.mm.game.report.PluginGameReport");
    uo("com.tencent.mm.plugin.wepkg.PluginWePkg");
    uo("com.tencent.mm.plugin.game.commlib.PluginCommLib");
    uo("com.tencent.mm.plugin.recordvideo.PluginVideoEditor");
    uo("com.tencent.mm.plugin.video.PluginVideo");
    uo("com.tencent.mm.plugin.hardwareopt.PluginHardwareOpt");
    uo("com.tencent.mm.plugin.sns.PluginSns");
    uo("com.tencent.mm.plugin.downloader.PluginDownloader");
    uo("com.tencent.mm.plugin.fav.PluginFav");
    uo("com.tencent.mm.plugin.fav.ui.PluginFavUI");
    uo("com.tencent.mm.plugin.record.PluginRecord");
    uo("com.tencent.mm.plugin.music.PluginMusic");
    uo("com.tencent.mm.plugin.MMPhotoEditPlugin");
    uo("com.tencent.mm.plugin.account.PluginAccount");
    Object localObject = com.tencent.mm.plugin.recordvideo.background.b.b.wou;
    uo(com.tencent.mm.plugin.recordvideo.background.b.b.a.duQ());
    uo("com.tencent.mm.plugin.facedetect.PluginFace");
    uo("com.tencent.mm.plugin.soter.PluginSoter");
    uo("com.tencent.mm.plugin.walletlock.PluginWalletLock");
    uo("com.tencent.mm.plugin.wxpay.PluginWxPay");
    uo("com.tencent.mm.plugin.wxpaysdk.PluginWxPaySdk");
    uo("com.tencent.mm.plugin.wxpayapi.PluginWxPayApi");
    uo("com.tencent.kinda.framework.PluginWxKindaApi");
    uo("com.tencent.mm.plugin.radar.PluginRadar");
    uo("com.tencent.mm.plugin.topstory.PluginTopStory");
    uo("com.tencent.mm.plugin.topstory.ui.PluginTopStoryUI");
    uo("com.tencent.mm.plugin.websearch.PluginWebSearch");
    uo("com.tencent.mm.plugin.fts.ui.PluginFTSUI");
    uo("com.tencent.mm.plugin.card.PluginCard");
    uo("com.tencent.mm.plugin.card.compat.PluginCardCompat");
    uo("com.tencent.mm.plugin.kitchen.PluginKitchen");
    uo("com.tencent.mm.plugin.forcenotify.PluginForceNotify");
    uo("com.tencent.mm.plugin.monitor.PluginMonitor");
    un("com.tencent.mm.plugin.expansions.PluginExpansions");
    uo("com.tencent.mm.plugin.fcm.PluginFCM");
    uo("com.tencent.mm.plugin.emojicapture.model.PluginEmojiCapture");
    uo("com.tencent.mm.plugin.selectcontact.PluginSelectContact");
    uo("com.tencent.mm.plugin.cloudvoip.cloudvoice.PluginCloudVoice");
    uo("com.tencent.mm.plugin.webview.PluginWebView");
    uo("com.tencent.mm.plugin.priority.PluginPriority");
    uo("com.tencent.mm.plugin.qqmail.PluginQQMail");
    uo("com.tencent.mm.plugin.scanner.PluginScanTranslation");
    uo("com.tencent.mm.plugin.scanner.PluginScanner");
    uo("com.tencent.mm.plugin.newtips.PluginNewTips");
    uo("com.tencent.mm.plugin.groupsolitaire.PluginGroupSolitaire");
    uo("com.tencent.mm.plugin.groupcollect.PluginGroupCollect");
    uo("com.tencent.mm.plugin.editor.PluginEditor");
    uo("com.tencent.mm.plugin.fav.offline.PluginFavOffline");
    uo("com.tencent.mm.plugin.msgquote.PluginMsgQuote");
    uo("com.tencent.mm.plugin.recordvideo.appcamera.PluginMMSight");
    uo("com.tencent.mm.plugin.secinforeport.PluginSecInfoReport");
    uo("com.tencent.mm.plugin.normsg.PluginNormsg");
    uo("com.tencent.mm.plugin.netmock.PluginNetMock");
    uo("com.tencent.kinda.debug.PluginKindaReload");
    uo("com.tencent.mm.plugin.rubbishbin.PluginRubbishbin");
    if (com.tencent.mm.sdk.platformtools.h.GqF.aKG("ENABLE_STETHO")) {
      uo("com.tencent.mm.plugin.stetho.PluginStetho");
    }
    uo("com.tencent.mm.plugin.boots.PluginBoots");
    uo("com.tencent.mm.plugin.downloader_app.PluginDownloaderApp");
    uo("com.tencent.mm.plugin.game.luggage.PluginLuggageGame");
    uo("com.tencent.mm.plugin.trafficmonitor.PluginTrafficMonitor");
    uo("com.tencent.mm.plugin.story.PluginStory");
    uo("com.tencent.mm.plugin.finder.PluginFinder");
    uo("com.tencent.mm.plugin.thumbplayer.PluginThumbPlayer");
    uo("com.tencent.mm.plugin.audio.PluginAudio");
    uo("com.tencent.mm.plugin.crashfix.PluginSystemCrashFix");
    uo("com.tencent.mm.gpu.PluginGpuRes");
    uo("com.tencent.mm.plugin.flutter.PluginFlutter");
    uo("com.tencent.mm.plugin.box.PluginBox");
    uo("com.tencent.mm.plugin.lite.PluginLiteApp");
    uo("com.tencent.mm.plugin.mobile.verify.PluginMobileVerify");
    uo("com.tencent.mm.live.PluginLive");
    localObject = com.tencent.mm.kernel.a.c.ahe().giO;
    com.tencent.mm.kernel.b.a locala = com.tencent.mm.kernel.g.ad(q.class);
    ((com.tencent.mm.kernel.a.b.g)localObject).gkd.put(com.tencent.mm.kernel.api.c.class, locala);
    AppMethodBeat.o(160120);
  }
  
  public final boolean Ko()
  {
    AppMethodBeat.i(160124);
    if (cIy)
    {
      AppMethodBeat.o(160124);
      return true;
    }
    if (!((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.g.agO().agp()).ahL())
    {
      AppMethodBeat.o(160124);
      return true;
    }
    com.tencent.mm.kernel.g.agP();
    if ((!com.tencent.mm.kernel.a.afX()) || (!com.tencent.mm.kernel.g.agP().afY()))
    {
      AppMethodBeat.o(160124);
      return true;
    }
    if (com.tencent.mm.splash.h.GyD.size() == 1)
    {
      Activity localActivity = (Activity)com.tencent.mm.splash.h.GyD.get(0);
      if (ai.eUV().equals(com.tencent.mm.splash.h.aW(localActivity)))
      {
        ac.i("MicroMsg.DefaultBootStep", "Found LauncherUI only.");
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
    Kn();
    if (((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.g.agO().agp()).ahL()) {
      new ao("Startup-SideWork").post(new Runnable()
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
              ac.printErrStackTrace("MicroMsg.DefaultBootStep", localException, "", new Object[0]);
              com.tencent.mm.blink.a.s(10L, 1L);
              ac.i("MicroMsg.DefaultBootStep", "found a crash, %s %s %s", new Object[] { ai.getResources(), paramg.ca.getResources(), paramg.ca.getResources().getAssets() });
              i.a(i.this, paramg);
              i.b(i.this);
              return;
              com.tencent.mm.kiss.a.b.ahR().a("R.layout.mm_bottom_tabitem", 4, 2131494776, new LinearLayout(localException), new int[0]);
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
              ??? = com.tencent.mm.kiss.a.b.ahR();
              localObject3 = com.tencent.mm.kiss.a.a.ahQ().mHandler.getSerialTag();
              localObject5 = z.jD((Context)localObject5);
              if (!((com.tencent.mm.kiss.a.b)???).mInitialized)
              {
                ((com.tencent.mm.kiss.a.b)???).mInitialized = true;
                ((com.tencent.mm.kiss.a.b)???).mInflater = ((LayoutInflater)localObject5);
                ((com.tencent.mm.kiss.a.b)???).gkG = ((String)localObject3);
                ((com.tencent.mm.kiss.a.b)???).mMode = 2;
                ((com.tencent.mm.kiss.a.b)???).gkH = new b.1((com.tencent.mm.kiss.a.b)???, ((com.tencent.mm.kiss.a.b)???).gkG);
                if (com.tencent.mm.compatible.util.d.la(26)) {
                  com.tencent.mm.kiss.a.b.gkJ = new com.tencent.mm.kiss.a.b.a((String)localObject3);
                }
              }
              com.tencent.mm.blink.a.TK();
              ??? = ai.getContext();
              bool = com.tencent.mm.kiss.a.b.ahR().a("R.layout.actionbar_title_launcher", 1, 2131492927, new LinearLayout((Context)???), new int[0]);
              com.tencent.mm.kiss.a.b.ahR().a("R.layout.main_tab", 1, 2131494684, new int[0]);
              if (com.tencent.mm.cc.a.ie((Context)???))
              {
                com.tencent.mm.kiss.a.b.ahR().a("R.layout.mm_bottom_tabitem_large", 4, 2131494777, new LinearLayout((Context)???), new int[0]);
                com.tencent.mm.kiss.a.b.ahR().a("R.layout.mm_activity", 4, 2131494760, new int[0]);
                if ((!Build.BRAND.equals("vivo")) || (!com.tencent.mm.compatible.util.d.la(20)))
                {
                  com.tencent.mm.kiss.a.b.ahR().a("R.layout.main", 1, 2131494680, new int[0]);
                  com.tencent.mm.kiss.a.b.ahR().a("R.layout.address", 1, 2131492947, new int[0]);
                  com.tencent.mm.kiss.a.b.ahR().a("R.layout.mm_preference_fragment_list_content", 2, 2131494856, new int[0]);
                }
                com.tencent.mm.kiss.a.b.ahR().a("R.layout.actionview_with_dot_tips", 1, 2131492929, new int[0]);
                if (bool)
                {
                  ??? = com.tencent.mm.kiss.a.b.ahR();
                  localObject3 = new c.1();
                  ((com.tencent.mm.kiss.a.b)???).gkH.post((Runnable)localObject3);
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
    if (((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.g.agO().agp()).ahL()) {
      localk = this.cIw;
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
        if (this.cIx) {
          ac.e("MicroMsg.DefaultBootStep", "SVG still failed!");
        }
        super.b(paramg);
        AppMethodBeat.o(160123);
        return;
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          ac.printErrStackTrace("MicroMsg.WxWaitingLock", localInterruptedException, "", new Object[0]);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.app.i
 * JD-Core Version:    0.7.0.1
 */