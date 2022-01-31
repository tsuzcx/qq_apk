package com.tencent.mm.app;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.os.Build;
import android.os.HandlerThread;
import android.os.Looper;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import com.tencent.mm.R.i;
import com.tencent.mm.blink.c.1;
import com.tencent.mm.boot.a.a;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.kiss.a.b;
import com.tencent.mm.kiss.a.b.1;
import com.tencent.mm.kiss.a.b.b;
import com.tencent.mm.modelrecovery.PluginRecovery;
import com.tencent.mm.plugin.auth.PluginAuth;
import com.tencent.mm.plugin.bbom.PluginBigBallOfMud;
import com.tencent.mm.plugin.messenger.foundation.PluginMessengerFoundation;
import com.tencent.mm.plugin.report.PluginReport;
import com.tencent.mm.plugin.zero.PluginZero;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.splash.i;
import com.tencent.mm.vfs.FileSystemManager;
import com.tencent.mm.vfs.FileSystemManager.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public final class g
  extends com.tencent.mm.kernel.a.d
{
  private static boolean bwo = true;
  private com.tencent.mm.ck.k bwm = new com.tencent.mm.ck.k();
  private volatile boolean bwn = false;
  
  private static void sL()
  {
    long l = System.currentTimeMillis();
    p.tb();
    l = System.currentTimeMillis() - l;
    com.tencent.mm.blink.a.n(4L, l);
    com.tencent.mm.blink.a.n(5L, 1L);
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.DefaultBootStep", "SVG newInstance done, spent %s", new Object[] { Long.valueOf(l) });
  }
  
  public final void a(final com.tencent.mm.kernel.b.g paramg)
  {
    FileSystemManager.setContext(paramg.bT);
    if (!paramg.Ex()) {}
    for (boolean bool = true;; bool = false)
    {
      FileSystemManager.oA(bool);
      FileSystemManager.a(new g.1(this));
      sL();
      if (((h)com.tencent.mm.kernel.g.DM().Dr()).Ex()) {
        new ai("Startup-SideWork").O(new Runnable()
        {
          public final void run()
          {
            for (;;)
            {
              try
              {
                localObject2 = g.a(g.this);
              }
              catch (Exception localException)
              {
                Object localObject2;
                Object localObject4;
                boolean bool;
                com.tencent.mm.sdk.platformtools.y.printErrStackTrace("MicroMsg.DefaultBootStep", localException, "", new Object[0]);
                com.tencent.mm.blink.a.n(10L, 1L);
                com.tencent.mm.sdk.platformtools.y.i("MicroMsg.DefaultBootStep", "found a crash, %s %s %s", new Object[] { ae.getResources(), paramg.bT.getResources(), paramg.bT.getResources().getAssets() });
                g.a(g.this, paramg);
                g.b(g.this);
                return;
                b.ED().a("R.layout.mm_bottom_tabitem", 4, R.i.mm_bottom_tabitem, new LinearLayout(localException), new int[0]);
                continue;
              }
              finally
              {
                g.a(g.this).done();
              }
              synchronized (((com.tencent.mm.ck.k)localObject2).dIn)
              {
                ((com.tencent.mm.ck.k)localObject2).dIn[0] = -1;
                com.tencent.mm.kernel.k.i("MicroMsg.WxWaitingLock", "markUse %s", new Object[] { localObject2 });
                g.a(g.this).done();
                localObject4 = new ContextWrapper(paramg.bT);
                ??? = b.ED();
                localObject2 = com.tencent.mm.kiss.a.a.EC().dNe.getLooper();
                localObject4 = com.tencent.mm.ui.y.gt((Context)localObject4);
                if (!((b)???).dNk)
                {
                  ((b)???).dNk = true;
                  ((b)???).Lu = ((LayoutInflater)localObject4);
                  ((b)???).dNi = ((Looper)localObject2);
                  ((b)???).mMode = 2;
                  ((b)???).dNj = new b.1((b)???, ((b)???).dNi);
                  if (com.tencent.mm.compatible.util.d.gG(26)) {
                    ((b)???).dNm = new b.b((Looper)localObject2);
                  }
                }
                com.tencent.mm.blink.a.vz();
                ??? = ((h)com.tencent.mm.kernel.g.DM().Dr()).bT.getBaseContext();
                bool = b.ED().a("R.layout.actionbar_title_launcher", 1, R.i.actionbar_title_launcher, new LinearLayout((Context)???), new int[0]);
                b.ED().a("R.layout.main_tab", 1, R.i.main_tab, new int[0]);
                if (com.tencent.mm.cb.a.fh((Context)???))
                {
                  b.ED().a("R.layout.mm_bottom_tabitem_large", 4, R.i.mm_bottom_tabitem_large, new LinearLayout((Context)???), new int[0]);
                  b.ED().a("R.layout.mm_activity", 4, R.i.mm_activity, new int[0]);
                  if ((!Build.BRAND.equals("vivo")) || (!com.tencent.mm.compatible.util.d.gG(20)))
                  {
                    b.ED().a("R.layout.main", 1, R.i.main, new int[0]);
                    b.ED().a("R.layout.address", 1, R.i.address, new int[0]);
                    b.ED().a("R.layout.mm_preference_fragment_list_content", 2, R.i.mm_preference_fragment_list_content, new int[0]);
                  }
                  b.ED().a("R.layout.actionview_with_dot_tips", 1, R.i.actionview_with_dot_tips, new int[0]);
                  if (!com.tencent.mm.cb.a.fh((Context)???)) {
                    break label540;
                  }
                  b.ED().a("R.layout.conversation_item_with_cache_large", 8, R.i.conversation_item_with_cache_large, null);
                  if (bool)
                  {
                    ??? = b.ED();
                    localObject2 = new c.1();
                    ((b)???).dNj.post((Runnable)localObject2);
                  }
                  g.a(g.this).done();
                }
              }
              label540:
              if (com.tencent.mm.cb.a.fi(localContext)) {
                b.ED().a("R.layout.conversation_item_with_cache_small", 8, R.i.conversation_item_with_cache_small, null);
              } else {
                b.ED().a("R.layout.conversation_item_with_cache", 8, R.i.conversation_item_with_cache, null);
              }
            }
          }
        });
      }
      if (paramg.Ex())
      {
        Object localObject = FileSystemManager.cVw();
        ((FileSystemManager)localObject).xwe = false;
        localObject = ((FileSystemManager)localObject).cVy();
        ((FileSystemManager.a)localObject).wuB.clear();
        ((FileSystemManager.a)localObject).wuC.clear();
        ((FileSystemManager.a)localObject).wuE.clear();
        ((FileSystemManager.a)localObject).wuV = null;
        ((FileSystemManager.a)localObject).wuW = true;
        ((FileSystemManager.a)localObject).commit();
      }
      super.a(paramg);
      return;
    }
  }
  
  public final void b(com.tencent.mm.kernel.b.g paramg)
  {
    com.tencent.mm.ck.k localk;
    if (((h)com.tencent.mm.kernel.g.DM().Dr()).Ex()) {
      localk = this.bwm;
    }
    synchronized (localk.dIn)
    {
      try
      {
        if (localk.dIn[0] == -1)
        {
          com.tencent.mm.kernel.k.i("MicroMsg.WxWaitingLock", "waiting %s", new Object[] { localk });
          localk.dIn.wait();
          com.tencent.mm.kernel.k.i("MicroMsg.WxWaitingLock", "after waiting %s", new Object[] { localk });
        }
        if (this.bwn) {
          com.tencent.mm.sdk.platformtools.y.e("MicroMsg.DefaultBootStep", "SVG still failed!");
        }
        super.b(paramg);
        return;
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          com.tencent.mm.sdk.platformtools.y.printErrStackTrace("MicroMsg.WxWaitingLock", localInterruptedException, "", new Object[0]);
        }
      }
    }
  }
  
  public final void sJ()
  {
    super.sJ();
    com.tencent.mm.kernel.a.a.j("Hello WeChat, DefaultBootStep load debugger and newInstance xlog...", new Object[0]);
    ae.getContext().getSystemService("audio");
    k.cl(((h)com.tencent.mm.kernel.g.DM().Dr()).dIA);
    p.n(a.a.class);
    p.cq("com.tencent.mm.boot");
    p.a(((h)com.tencent.mm.kernel.g.DM().Dr()).bT, ((h)com.tencent.mm.kernel.g.DM().Dr()).bT.getResources());
  }
  
  public final void sK()
  {
    com.tencent.mm.kernel.g.DL().dKk = com.tencent.mm.plugin.zero.a.d.class;
    x(PluginZero.class);
    x(PluginMessengerFoundation.class);
    x(PluginReport.class);
    x(PluginAuth.class);
    x(PluginBigBallOfMud.class);
    x(PluginRecovery.class);
    gl("com.tencent.mm.plugin.bbom.PluginCompatOldStructure");
    gl("com.tencent.mm.plugin.bbom.PluginBigBallOfMudAsync");
    gl("com.tencent.mm.plugin.avatar.PluginAvatar");
    gl("com.tencent.mm.plugin.comm.PluginComm");
    gl("com.tencent.mm.plugin.audio.PluginVoice");
    gl("com.tencent.mm.plugin.biz.PluginBiz");
    gm("com.tencent.mm.plugin.bizui.PluginBIZUI");
    gl("com.tencent.mm.plugin.brandservice.PluginBrandService");
    gl("com.tencent.mm.plugin.readerapp.PluginReaderApp");
    gl("com.tencent.mm.plugin.notification.PluginNotification");
    gl("com.tencent.mm.plugin.messenger.PluginMessenger");
    gl("com.tencent.mm.plugin.welab.PluginWelab");
    gl("com.tencent.mm.plugin.sport.PluginSport");
    gl("com.tencent.mm.plugin.fts.PluginFTS");
    gl("com.tencent.mm.openim.PluginOpenIM");
    gm("com.tencent.mm.plugin.misc.PluginMisc");
    gl("com.tencent.mm.openim.room.PluginOpenIMRoom");
    gl("com.tencent.mm.roomsdk.PluginRoomSdk");
    gl("com.tencent.mm.ipcinvoker.wx_extension.PluginIPC");
    gl("com.tencent.mm.plugin.abtest.PluginABTest");
    gl("com.tencent.mm.plugin.backup.PluginBackup");
    gl("com.tencent.mm.plugin.hardcoder.PluginHardcoder");
    gm("com.tencent.mm.plugin.performance.PluginPerformance");
    gm("com.tencent.mm.plugin.chatroom.PluginChatroom");
    gm("com.tencent.mm.PluginFunctionMsg");
    gm("com.tencent.mm.insane_statistic.PluginInsaneStatistic");
    gm("com.tencent.mm.plugin.appbrand.app.PluginAppBrand");
    gm("com.tencent.mm.plugin.appbrand.compat.PluginAppBrandCompat");
    gm("com.tencent.mm.plugin.uishow.PluginUIShow");
    gm("com.tencent.mm.plugin.emoji.PluginEmoji");
    gm("com.tencent.mm.chatroom.plugin.PluginChatroomUI");
    gm("com.tencent.mm.plugin.game.PluginGame");
    gm("com.tencent.mm.game.report.PluginGameReport");
    gm("com.tencent.mm.plugin.wepkg.PluginWePkg");
    gm("com.tencent.mm.plugin.game.commlib.PluginCommLib");
    gm("com.tencent.mm.plugin.video.PluginVideo");
    gm("com.tencent.mm.plugin.hardwareopt.PluginHardwareOpt");
    gm("com.tencent.mm.plugin.sns.PluginSns");
    gm("com.tencent.mm.plugin.downloader.PluginDownloader");
    gm("com.tencent.mm.plugin.fav.PluginFav");
    gm("com.tencent.mm.plugin.fav.ui.PluginFavUI");
    gm("com.tencent.mm.plugin.record.PluginRecord");
    gm("com.tencent.mm.plugin.music.PluginMusic");
    gm("com.tencent.mm.plugin.MMPhotoEditPlugin");
    gm("com.tencent.mm.plugin.account.PluginAccount");
    gm("com.tencent.mm.plugin.facedetect.PluginFace");
    gm("com.tencent.mm.plugin.soter.PluginSoter");
    gm("com.tencent.mm.plugin.walletlock.PluginWalletLock");
    gm("com.tencent.mm.plugin.wxpay.PluginWxPay");
    gm("com.tencent.mm.plugin.wxpaysdk.PluginWxPaySdk");
    gm("com.tencent.mm.plugin.wxpayapi.PluginWxPayApi");
    gm("com.tencent.mm.plugin.radar.PluginRadar");
    gm("com.tencent.mm.plugin.topstory.PluginTopStory");
    gm("com.tencent.mm.plugin.topstory.ui.PluginTopStoryUI");
    gm("com.tencent.mm.plugin.websearch.PluginWebSearch");
    gm("com.tencent.mm.plugin.fts.ui.PluginFTSUI");
    gm("com.tencent.mm.plugin.card.PluginCard");
    gm("com.tencent.mm.plugin.card.compat.PluginCardCompat");
    gm("com.tencent.mm.plugin.kitchen.PluginKitchen");
    gm("com.tencent.mm.plugin.expt.PluginExpt");
    gm("com.tencent.mm.plugin.monitor.PluginMonitor");
    gm("com.tencent.mm.plugin.emojicapture.model.PluginEmojiCapture");
    gm("com.tencent.mm.plugin.selectcontact.PluginSelectContact");
    gm("com.tencent.mm.plugin.cloudvoip.cloudvoice.PluginCloudVoice");
    gm("com.tencent.mm.plugin.webview.PluginWebView");
    gm("com.tencent.mm.plugin.mmsight.PluginMMSight");
    gm("com.tencent.mm.plugin.secinforeport.PluginSecInfoReport");
    gm("com.tencent.mm.plugin.normsg.PluginNormsg");
    gm("com.tencent.mm.plugin.netmock.PluginNetMock");
    if (com.tencent.mm.sdk.platformtools.d.ueg.Zd("ENABLE_STETHO")) {
      gm("com.tencent.mm.plugin.stetho.PluginStetho");
    }
    gm("com.tencent.mm.plugin.boots.PluginBoots");
    gm("com.tencent.mm.plugin.downloader_app.PluginDownloaderApp");
    gm("com.tencent.mm.plugin.game.luggage.PluginLuggageGame");
    gm("com.tencent.mm.plugin.trafficmonitor.PluginTrafficMonitor");
    com.tencent.mm.kernel.a.b.g localg = com.tencent.mm.kernel.a.c.DY().dLA;
    com.tencent.mm.kernel.b.a locala = com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.messenger.foundation.a.p.class);
    localg.dMM.put(com.tencent.mm.kernel.api.c.class, locala);
  }
  
  public final boolean sM()
  {
    if (bwo) {
      return true;
    }
    if (!((h)com.tencent.mm.kernel.g.DM().Dr()).Ex()) {
      return true;
    }
    com.tencent.mm.kernel.g.DN();
    if ((!com.tencent.mm.kernel.a.Db()) || (!com.tencent.mm.kernel.g.DN().Dc())) {
      return true;
    }
    if (i.ulE.size() == 1)
    {
      Activity localActivity = (Activity)i.ulE.get(0);
      if (ae.cqP().equals(i.W(localActivity)))
      {
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.DefaultBootStep", "Found LauncherUI only.");
        return false;
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.app.g
 * JD-Core Version:    0.7.0.1
 */