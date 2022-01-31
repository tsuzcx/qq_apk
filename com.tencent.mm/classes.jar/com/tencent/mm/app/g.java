package com.tencent.mm.app;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cm.k;
import com.tencent.mm.kernel.j;
import com.tencent.mm.modelrecovery.PluginRecovery;
import com.tencent.mm.plugin.auth.PluginAuth;
import com.tencent.mm.plugin.bbom.PluginBigBallOfMud;
import com.tencent.mm.plugin.messenger.foundation.PluginMessengerFoundation;
import com.tencent.mm.plugin.report.PluginReport;
import com.tencent.mm.plugin.zero.PluginZero;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bj;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.vfs.FileSystemManager;
import com.tencent.mm.vfs.FileSystemManager.a;
import com.tencent.mm.vfs.FileSystemManager.b;
import com.tencent.xweb.WebView.d;
import java.security.Key;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import javax.crypto.spec.SecretKeySpec;

public final class g
  extends com.tencent.mm.kernel.a.d
{
  private static boolean bXT = true;
  private k bXR;
  private volatile boolean bXS;
  
  public g()
  {
    AppMethodBeat.i(137994);
    this.bXR = new k();
    this.bXS = false;
    AppMethodBeat.o(137994);
  }
  
  private static void Be()
  {
    AppMethodBeat.i(137998);
    long l = System.currentTimeMillis();
    s.By();
    l = System.currentTimeMillis() - l;
    com.tencent.mm.blink.a.u(4L, l);
    com.tencent.mm.blink.a.u(5L, 1L);
    ab.i("MicroMsg.DefaultBootStep", "SVG newInstance done, spent %s", new Object[] { Long.valueOf(l) });
    AppMethodBeat.o(137998);
  }
  
  public final void Bc()
  {
    AppMethodBeat.i(137995);
    super.Bc();
    com.tencent.mm.kernel.a.a.g("Hello WeChat, DefaultBootStep load debugger and newInstance xlog...", new Object[0]);
    ah.getContext().getSystemService("audio");
    m.dw(((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.g.RI().Rj()).mProcessName);
    s.A(com.tencent.mm.boot.a.a.class);
    s.dC("com.tencent.mm.boot");
    s.a(((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.g.RI().Rj()).bX, ((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.g.RI().Rj()).bX.getResources());
    if (ah.isAppBrandProcess()) {
      com.tencent.mm.k.a.a.a(new com.tencent.mm.k.a()
      {
        public final boolean Bh()
        {
          AppMethodBeat.i(138006);
          com.tencent.mm.cn.d.a(WebView.d.BEq, null);
          boolean bool = com.tencent.mm.cn.d.dTk();
          AppMethodBeat.o(138006);
          return bool;
        }
      });
    }
    AppMethodBeat.o(137995);
  }
  
  public final void Bd()
  {
    AppMethodBeat.i(137996);
    com.tencent.mm.kernel.g.RH().eHI = com.tencent.mm.plugin.zero.a.d.class;
    K(PluginZero.class);
    K(PluginMessengerFoundation.class);
    K(PluginReport.class);
    K(PluginAuth.class);
    K(PluginBigBallOfMud.class);
    K(PluginRecovery.class);
    mG("com.tencent.mm.plugin.bbom.PluginCompatOldStructure");
    mG("com.tencent.mm.plugin.bbom.PluginBigBallOfMudAsync");
    mG("com.tencent.mm.plugin.avatar.PluginAvatar");
    mG("com.tencent.mm.plugin.comm.PluginComm");
    mG("com.tencent.mm.plugin.audio.PluginVoice");
    mG("com.tencent.mm.plugin.biz.PluginBiz");
    mH("com.tencent.mm.plugin.bizui.PluginBIZUI");
    mG("com.tencent.mm.plugin.brandservice.PluginBrandService");
    mG("com.tencent.mm.plugin.readerapp.PluginReaderApp");
    mG("com.tencent.mm.plugin.notification.PluginNotification");
    mG("com.tencent.mm.plugin.messenger.PluginMessenger");
    mG("com.tencent.mm.plugin.welab.PluginWelab");
    mG("com.tencent.mm.plugin.sport.PluginSport");
    mG("com.tencent.mm.plugin.fts.PluginFTS");
    mG("com.tencent.mm.openim.PluginOpenIM");
    mH("com.tencent.mm.plugin.misc.PluginMisc");
    mG("com.tencent.mm.openim.room.PluginOpenIMRoom");
    mG("com.tencent.mm.roomsdk.PluginRoomSdk");
    mG("com.tencent.mm.ipcinvoker.wx_extension.PluginIPC");
    mG("com.tencent.mm.plugin.abtest.PluginABTest");
    mG("com.tencent.mm.plugin.expt.PluginExpt");
    mG("com.tencent.mm.plugin.backup.PluginBackup");
    mG("com.tencent.mm.plugin.hardcoder.PluginHardcoder");
    mH("com.tencent.mm.plugin.performance.PluginPerformance");
    mH("com.tencent.mm.plugin.chatroom.PluginChatroom");
    mH("com.tencent.mm.PluginFunctionMsg");
    mH("com.tencent.mm.insane_statistic.PluginInsaneStatistic");
    mH("com.tencent.mm.plugin.appbrand.app.PluginAppBrand");
    mH("com.tencent.mm.plugin.appbrand.compat.PluginAppBrandCompat");
    mH("com.tencent.mm.plugin.choosemsgfile.PluginChooseMsgFile");
    mH("com.tencent.mm.plugin.uishow.PluginUIShow");
    mH("com.tencent.mm.plugin.emoji.PluginEmoji");
    mH("com.tencent.mm.chatroom.plugin.PluginChatroomUI");
    mH("com.tencent.mm.plugin.game.PluginGame");
    mH("com.tencent.mm.game.report.PluginGameReport");
    mH("com.tencent.mm.plugin.wepkg.PluginWePkg");
    mH("com.tencent.mm.plugin.game.commlib.PluginCommLib");
    mH("com.tencent.mm.plugin.video.PluginVideo");
    mH("com.tencent.mm.plugin.hardwareopt.PluginHardwareOpt");
    mH("com.tencent.mm.plugin.sns.PluginSns");
    mH("com.tencent.mm.plugin.downloader.PluginDownloader");
    mH("com.tencent.mm.plugin.fav.PluginFav");
    mH("com.tencent.mm.plugin.fav.ui.PluginFavUI");
    mH("com.tencent.mm.plugin.record.PluginRecord");
    mH("com.tencent.mm.plugin.music.PluginMusic");
    mH("com.tencent.mm.plugin.MMPhotoEditPlugin");
    mH("com.tencent.mm.plugin.account.PluginAccount");
    mH("com.tencent.mm.plugin.facedetect.PluginFace");
    mH("com.tencent.mm.plugin.soter.PluginSoter");
    mH("com.tencent.mm.plugin.walletlock.PluginWalletLock");
    mH("com.tencent.mm.plugin.wxpay.PluginWxPay");
    mH("com.tencent.mm.plugin.wxpaysdk.PluginWxPaySdk");
    mH("com.tencent.mm.plugin.wxpayapi.PluginWxPayApi");
    mH("com.tencent.kinda.framework.PluginWxKindaApi");
    mH("com.tencent.mm.plugin.radar.PluginRadar");
    mH("com.tencent.mm.plugin.topstory.PluginTopStory");
    mH("com.tencent.mm.plugin.topstory.ui.PluginTopStoryUI");
    mH("com.tencent.mm.plugin.websearch.PluginWebSearch");
    mH("com.tencent.mm.plugin.fts.ui.PluginFTSUI");
    mH("com.tencent.mm.plugin.card.PluginCard");
    mH("com.tencent.mm.plugin.card.compat.PluginCardCompat");
    mH("com.tencent.mm.plugin.kitchen.PluginKitchen");
    mH("com.tencent.mm.plugin.forcenotify.PluginForceNotify");
    mH("com.tencent.mm.plugin.monitor.PluginMonitor");
    mH("com.tencent.mm.plugin.fcm.PluginFCM");
    mH("com.tencent.mm.plugin.emojicapture.model.PluginEmojiCapture");
    mH("com.tencent.mm.plugin.selectcontact.PluginSelectContact");
    mH("com.tencent.mm.plugin.cloudvoip.cloudvoice.PluginCloudVoice");
    mH("com.tencent.mm.plugin.webview.PluginWebView");
    mH("com.tencent.mm.plugin.priority.PluginPriority");
    mH("com.tencent.mm.plugin.mmsight.PluginMMSight");
    mH("com.tencent.mm.plugin.secinforeport.PluginSecInfoReport");
    mH("com.tencent.mm.plugin.normsg.PluginNormsg");
    mH("com.tencent.mm.plugin.netmock.PluginNetMock");
    if (f.ymH.apb("ENABLE_STETHO")) {
      mH("com.tencent.mm.plugin.stetho.PluginStetho");
    }
    if (f.ymH.apb("ENABLE_LUGGAGE_FUNCTIONS_INTEGRATION")) {
      mH("com.tencent.mm.plugin.appbrand.luggage.natives.PluginLFNatives");
    }
    mH("com.tencent.mm.plugin.boots.PluginBoots");
    mH("com.tencent.mm.plugin.downloader_app.PluginDownloaderApp");
    mH("com.tencent.mm.plugin.game.luggage.PluginLuggageGame");
    mH("com.tencent.mm.plugin.trafficmonitor.PluginTrafficMonitor");
    mH("com.tencent.mm.plugin.story.PluginStory");
    mH("com.tencent.mm.plugin.crashfix.PluginSystemCrashFix");
    com.tencent.mm.kernel.a.b.g localg = com.tencent.mm.kernel.a.c.RX().eIZ;
    com.tencent.mm.kernel.b.a locala = com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.messenger.foundation.a.p.class);
    localg.eKo.put(com.tencent.mm.kernel.api.c.class, locala);
    AppMethodBeat.o(137996);
  }
  
  public final boolean Bf()
  {
    AppMethodBeat.i(138000);
    if (bXT)
    {
      AppMethodBeat.o(138000);
      return true;
    }
    if (!((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.g.RI().Rj()).SD())
    {
      AppMethodBeat.o(138000);
      return true;
    }
    com.tencent.mm.kernel.g.RJ();
    if ((!com.tencent.mm.kernel.a.QT()) || (!com.tencent.mm.kernel.g.RJ().QU()))
    {
      AppMethodBeat.o(138000);
      return true;
    }
    if (com.tencent.mm.splash.h.yvj.size() == 1)
    {
      Activity localActivity = (Activity)com.tencent.mm.splash.h.yvj.get(0);
      if (ah.dsN().equals(com.tencent.mm.splash.h.av(localActivity)))
      {
        ab.i("MicroMsg.DefaultBootStep", "Found LauncherUI only.");
        AppMethodBeat.o(138000);
        return false;
      }
    }
    AppMethodBeat.o(138000);
    return true;
  }
  
  public final void a(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(137997);
    if (!paramg.SD()) {}
    for (boolean bool = true;; bool = false)
    {
      FileSystemManager.nT(bool);
      FileSystemManager.a(new FileSystemManager.b()
      {
        public final Key e(String paramAnonymousString, Map<String, String> paramAnonymousMap)
        {
          AppMethodBeat.i(154201);
          if (paramAnonymousMap.get("account") == null)
          {
            AppMethodBeat.o(154201);
            return null;
          }
          ab.i("VFS.Debug", "KeyGen.generate: ".concat(String.valueOf(paramAnonymousString)));
          if (((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.g.RI().Rj()).SD()) {
            com.tencent.mm.kernel.g.RJ();
          }
          for (paramAnonymousMap = com.tencent.mm.kernel.a.QC();; paramAnonymousMap = new com.tencent.mm.a.p(com.tencent.mm.kernel.a.QW()).toString())
          {
            paramAnonymousString = new SecretKeySpec(com.tencent.mm.a.g.x((paramAnonymousMap + paramAnonymousString).getBytes()), "RC4");
            AppMethodBeat.o(154201);
            return paramAnonymousString;
          }
        }
      });
      Be();
      if (((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.g.RI().Rj()).SD()) {
        new al("Startup-SideWork").ac(new g.3(this, paramg));
      }
      if (paramg.SD())
      {
        Object localObject = FileSystemManager.dQE();
        ((FileSystemManager)localObject).APU = false;
        localObject = ((FileSystemManager)localObject).erS();
        ((FileSystemManager.a)localObject).APz.clear();
        ((FileSystemManager.a)localObject).APA.clear();
        ((FileSystemManager.a)localObject).APC.clear();
        ((FileSystemManager.a)localObject).APW = null;
        ((FileSystemManager.a)localObject).APX = true;
        ((FileSystemManager.a)localObject).commit();
      }
      super.a(paramg);
      AppMethodBeat.o(137997);
      return;
    }
  }
  
  public final void b(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(137999);
    k localk;
    if (((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.g.RI().Rj()).SD()) {
      localk = this.bXR;
    }
    synchronized (localk.eFQ)
    {
      try
      {
        if (localk.eFQ[0] == -1)
        {
          j.i("MicroMsg.WxWaitingLock", "waiting %s", new Object[] { localk });
          localk.eFQ.wait();
          j.i("MicroMsg.WxWaitingLock", "after waiting %s", new Object[] { localk });
        }
        if (this.bXS) {
          ab.e("MicroMsg.DefaultBootStep", "SVG still failed!");
        }
        super.b(paramg);
        AppMethodBeat.o(137999);
        return;
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          ab.printErrStackTrace("MicroMsg.WxWaitingLock", localInterruptedException, "", new Object[0]);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.app.g
 * JD-Core Version:    0.7.0.1
 */