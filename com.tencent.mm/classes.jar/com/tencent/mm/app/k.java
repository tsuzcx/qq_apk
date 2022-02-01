package com.tencent.mm.app;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build.VERSION;
import com.tencent.matrix.jectl.JeCtl;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.matrix.trace.tracer.SignalAnrTracer;
import com.tencent.mm.boot.R.raw;
import com.tencent.mm.flutter.plugin.data_sources.PluginFlutterDataSources;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.l;
import com.tencent.mm.mj_template.plugin.PluginMaasTemplate;
import com.tencent.mm.modelrecovery.PluginRecovery;
import com.tencent.mm.plugin.auth.PluginAuth;
import com.tencent.mm.plugin.bbom.PluginBigBallOfMud;
import com.tencent.mm.plugin.cast.PluginCast;
import com.tencent.mm.plugin.flutter.thumbplayer.PluginFlutterThumbPlayer;
import com.tencent.mm.plugin.flutter.voip.plugin.PluginFlutterVoip;
import com.tencent.mm.plugin.messenger.foundation.PluginMessengerFoundation;
import com.tencent.mm.plugin.messenger.foundation.a.v;
import com.tencent.mm.plugin.recordvideo.background.c.b.a;
import com.tencent.mm.plugin.recordvideo.res.PluginVideoRes;
import com.tencent.mm.plugin.report.PluginReport;
import com.tencent.mm.plugin.ringtone.PluginRingtone;
import com.tencent.mm.plugin.scanner.scan_goods_new.res.PluginScanProductRes;
import com.tencent.mm.plugin.zero.PluginZero;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.ImmutableBundle;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.SyncTask;
import com.tencent.mm.sns_compose.plugin.PluginSnsWithTa;
import com.tencent.mm.ui.aw;
import com.tencent.xweb.WebView.WebViewKind;
import com.tencent.xweb.ao;
import java.util.ArrayList;
import java.util.Map;
import org.xwalk.core.XWalkEnvironment.ForceDarkBehavior;

public class k
  extends com.tencent.mm.kernel.a.d
{
  private static boolean hgc = true;
  private com.tencent.mm.cp.k hga;
  private volatile boolean hgb;
  
  public k()
  {
    AppMethodBeat.i(160118);
    this.hga = new com.tencent.mm.cp.k();
    this.hgb = false;
    AppMethodBeat.o(160118);
  }
  
  private static void aCo()
  {
    AppMethodBeat.i(160122);
    long l = System.currentTimeMillis();
    af.aCS();
    l = System.currentTimeMillis() - l;
    com.tencent.mm.blink.a.Q(4L, l);
    com.tencent.mm.blink.a.Q(5L, 1L);
    Log.i("MicroMsg.DefaultBootStep", "SVG newInstance done, spent %s", new Object[] { Long.valueOf(l) });
    AppMethodBeat.o(160122);
  }
  
  public void aBY()
  {
    AppMethodBeat.i(160119);
    super.aBY();
    com.tencent.mm.kernel.a.a.j("Hello WeChat, DefaultBootStep load debugger and newInstance xlog...", new Object[0]);
    MMApplicationContext.getContext().getSystemService("audio");
    w.f(true, ((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.h.baB().bad()).mProcessName);
    af.at(R.raw.class);
    af.setPackageName("com.tencent.mm.boot");
    af.a(((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.h.baB().bad()).bGP, ((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.h.baB().bad()).bGP.getResources());
    ao.setForceDarkMode(aw.isDarkMode());
    if (MMApplicationContext.isAppBrandProcess())
    {
      com.tencent.mm.xwebutil.c.a(WebView.WebViewKind.aifI);
      if (!com.tencent.mm.xwebutil.c.isCurrentSupportCustomContext()) {
        com.tencent.mm.ce.c.iRD();
      }
    }
    ao.setForceDarkBehavior(XWalkEnvironment.ForceDarkBehavior.MEDIA_QUERY_ONLY);
    com.tencent.mm.picker.c.a.pyD = new com.tencent.mm.i.b();
    com.tencent.threadpool.i locali = com.tencent.threadpool.h.ahAA;
    Runnable local1 = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(239270);
        if (!com.tencent.mm.kernel.h.baF().mDl.mDG)
        {
          Log.e("MicroMsg.DefaultBootStep", "Kernel has not startup done!");
          try
          {
            SignalAnrTracer.azZ();
            AppMethodBeat.o(239270);
            return;
          }
          finally
          {
            Log.e("MicroMsg.DefaultBootStep", "printTrace error, message = %s", new Object[] { localObject.getMessage() });
          }
        }
        AppMethodBeat.o(239270);
      }
    };
    if (MMApplicationContext.isMainProcess()) {}
    for (long l = 180000L;; l = 360000L)
    {
      locali.p(local1, l);
      AppMethodBeat.o(160119);
      return;
    }
  }
  
  public void aBZ()
  {
    AppMethodBeat.i(160120);
    if ((!BuildInfo.IS_ARM64) && (Build.VERSION.SDK_INT >= 30) && (com.tencent.mm.compatible.util.h.aQh()))
    {
      Log.i("MicroMsg.DefaultBootStep", "origin retain = %s", new Object[] { Boolean.valueOf(JeCtl.setRetain(true)) });
      Log.i("MicroMsg.DefaultBootStep", "now retain = %s", new Object[] { Boolean.valueOf(JeCtl.setRetain(true)) });
    }
    com.tencent.mm.kernel.h.baA().mCA = com.tencent.mm.plugin.zero.a.d.class;
    aD(PluginZero.class);
    aD(PluginMessengerFoundation.class);
    aD(PluginReport.class);
    aD(PluginAuth.class);
    aD(PluginBigBallOfMud.class);
    aD(PluginRecovery.class);
    FF("com.tencent.mm.sensitive.PluginSensitive");
    FF("com.tencent.mm.plugin.bbom.PluginCompatOldStructure");
    FF("com.tencent.mm.plugin.bbom.PluginBigBallOfMudAsync");
    FF("com.tencent.mm.plugin.PluginRecentForward");
    FF("com.tencent.mm.plugin.avatar.PluginAvatar");
    FF("com.tencent.mm.plugin.image.PluginImageBase");
    FF("com.tencent.mm.plugin.comm.PluginComm");
    FF("com.tencent.mm.plugin.audio.PluginVoice");
    FF("com.tencent.mm.plugin.biz.PluginBiz");
    FG("com.tencent.mm.plugin.bizui.PluginBIZUI");
    FF("com.tencent.mm.plugin.brandservice.PluginBrandService");
    FF("com.tencent.mm.plugin.readerapp.PluginReaderApp");
    FF("com.tencent.mm.plugin.notification.PluginNotification");
    FF("com.tencent.mm.plugin.messenger.PluginMessenger");
    FF("com.tencent.mm.plugin.notification.PluginPNotification");
    FF("com.tencent.mm.plugin.welab.PluginWelab");
    FF("com.tencent.mm.plugin.sport.PluginSport");
    FF("com.tencent.mm.plugin.fts.PluginFTS");
    FF("com.tencent.mm.plugin.handoff.PluginHandOff");
    FF("com.tencent.mm.plugin.multitask.PluginMultiTask");
    FF("com.tencent.mm.plugin.taskbar.PluginTaskBar");
    FF("com.tencent.mm.plugin.updater.PluginUpdater");
    FF("com.tencent.mm.openim.PluginOpenIM");
    FG("com.tencent.mm.plugin.misc.PluginMisc");
    FF("com.tencent.mm.openim.room.PluginOpenIMRoom");
    FF("com.tencent.mm.roomsdk.PluginRoomSdk");
    FF("com.tencent.mm.ipcinvoker.wx_extension.PluginIPC");
    FF("com.tencent.mm.plugin.abtest.PluginABTest");
    FF("com.tencent.mm.plugin.hook.PluginHook");
    FF("com.tencent.mm.plugin.sensitive_api_check.Plugin");
    FF("com.tencent.mm.plugin.expt.PluginExpt");
    FF("com.tencent.mm.plugin.ai.PluginAi");
    FF("com.tencent.mm.plugin.datareport.PluginDataReport");
    FF("com.tencent.mm.plugin.backup.PluginBackup");
    FF("com.tencent.mm.pluginsdk.model.app.PluginAppMsg");
    FF("com.tencent.mm.plugin.hardcoder.PluginHardcoder");
    FF("com.tencent.mm.plugin.teenmode.PluginTeenMode");
    FG("com.tencent.mm.plugin.secdata.PluginSecData");
    FG("com.tencent.mm.plugin.repairer.PluginRepairer");
    FG("com.tencent.mm.plugin.performance.PluginPerformance");
    FG("com.tencent.mm.plugin.chatroom.PluginChatroom");
    FG("com.tencent.mm.PluginFunctionMsg");
    FG("com.tencent.mm.insane_statistic.PluginInsaneStatistic");
    FG("com.tencent.mm.plugin.appbrand.app.PluginAppBrand");
    FG("com.tencent.mm.plugin.choosemsgfile.PluginChooseMsgFile");
    FG("com.tencent.mm.plugin.ball.PluginBall");
    FG("com.tencent.mm.plugin.uishow.PluginUIShow");
    FG("com.tencent.mm.plugin.emoji.PluginEmoji");
    FG("com.tencent.mm.plugin.eggspring.PluginEggSpring");
    FG("com.tencent.mm.chatroom.plugin.PluginChatroomUI");
    FG("com.tencent.mm.plugin.patmsg.PluginPatMsg");
    FG("com.tencent.mm.plugin.game.PluginGame");
    FG("com.tencent.mm.game.report.PluginGameReport");
    FG("com.tencent.mm.plugin.wepkg.PluginWePkg");
    FG("com.tencent.mm.plugin.game.commlib.PluginCommLib");
    FG("com.tencent.mm.plugin.gamelife.PluginGameLife");
    FG("com.tencent.mm.plugin.game.chatroom.PluginGameChatRoom");
    FG("com.tencent.mm.plugin.recordvideo.PluginVideoEditor");
    FG("com.tencent.mm.plugin.video.PluginVideo");
    FG("com.tencent.mm.plugin.hardwareopt.PluginHardwareOpt");
    FG("com.tencent.mm.media.util.VideoColorSpaceDetectorApi");
    FG("com.tencent.mm.plugin.sns.PluginSns");
    FG("com.tencent.mm.plugin.downloader.PluginDownloader");
    FG("com.tencent.mm.plugin.fav.PluginFav");
    FG("com.tencent.mm.plugin.fav.ui.PluginFavUI");
    FG("com.tencent.mm.plugin.record.PluginRecord");
    FG("com.tencent.mm.plugin.music.PluginMusic");
    FG("com.tencent.mm.plugin.musicchat.PluginMusicChat");
    FG("com.tencent.mm.plugin.MMPhotoEditPlugin");
    FG("com.tencent.mm.plugin.account.PluginAccount");
    Object localObject = com.tencent.mm.plugin.recordvideo.background.c.b.NFR;
    FG(b.a.getCLASS());
    FG("com.tencent.mm.plugin.vlog.PluginVLog");
    FG("com.tencent.mm.plugin.facedetect.PluginFace");
    FG("com.tencent.mm.plugin.soter.PluginSoter");
    FG("com.tencent.mm.plugin.walletlock.PluginWalletLock");
    FG("com.tencent.mm.plugin.wxpay.PluginWxPay");
    FG("com.tencent.mm.plugin.wxpaysdk.PluginWxPaySdk");
    FG("com.tencent.mm.plugin.wxpayapi.PluginWxPayApi");
    FG("com.tencent.kinda.framework.PluginWxKindaApi");
    FG("com.tencent.mm.plugin.festival.PluginFestival");
    if (BuildInfo.ENABLE_PAYTEST) {
      FG("com.tencent.mm.plugin.paytest.api.PluginPayTestHeaderApi");
    }
    FG("com.tencent.mm.plugin.radar.PluginRadar");
    FG("com.tencent.mm.plugin.hashinfo.PluginHashInfo");
    FG("com.tencent.mm.plugin.topstory.PluginTopStory");
    FG("com.tencent.mm.plugin.topstory.ui.PluginTopStoryUI");
    FG("com.tencent.mm.plugin.websearch.PluginWebSearch");
    FG("com.tencent.mm.plugin.textstatus.PluginTextStatus");
    FG("com.tencent.mm.plugin.fts.ui.PluginFTSUI");
    FG("com.tencent.mm.plugin.card.PluginCard");
    FG("com.tencent.mm.plugin.card.compat.PluginCardCompat");
    FG("com.tencent.mm.plugin.forcenotify.PluginForceNotify");
    FG("com.tencent.mm.plugin.monitor.PluginMonitor");
    FF("com.tencent.mm.plugin.expansions.PluginExpansions");
    FG("com.tencent.mm.plugin.fcm.PluginFCM");
    FG("com.tencent.mm.plugin.emojicapture.model.PluginEmojiCapture");
    FG("com.tencent.mm.plugin.selectcontact.PluginSelectContact");
    FG("com.tencent.mm.plugin.cloudvoip.cloudvoice.PluginCloudVoice");
    FG("com.tencent.mm.plugin.webview.PluginWebView");
    FG("com.tencent.mm.plugin.priority.PluginPriority");
    FG("com.tencent.mm.plugin.qqmail.PluginQQMail");
    FG("com.tencent.mm.plugin.scanner.PluginScanTranslation");
    FG("com.tencent.mm.plugin.scanner.PluginScanner");
    FG("com.tencent.mm.plugin.newtips.PluginNewTips");
    FG("com.tencent.mm.plugin.groupsolitaire.PluginGroupSolitaire");
    FG("com.tencent.mm.plugin.groupcollect.PluginGroupCollect");
    FG("com.tencent.mm.plugin.editor.PluginEditor");
    FG("com.tencent.mm.plugin.fav.offline.PluginFavOffline");
    FG("com.tencent.mm.plugin.msgquote.PluginMsgQuote");
    FG("com.tencent.mm.plugin.selectrecord.PluginSelectRecord");
    FG("com.tencent.mm.contact.PluginContact");
    FG("com.tencent.mm.plugin.kidswatch.PluginKidsWatch");
    FG("com.tencent.mm.ui.conversation.fold.PluginFold");
    FG("com.tencent.mm.plugin.hld.PluginHld");
    FG("com.tencent.mm.plugin.mv.PluginMv");
    FG("com.tencent.mm.plugin.finder.live.PluginFinderLive");
    FG("com.tencent.mm.plugin.finder.nearby.PluginFinderNearby");
    FG("com.tencent.mm.plugin.finder.nearby.live.square.PluginFinderLiveSquare");
    FG("com.tencent.mm.plugin.finder.publish.PluginFinderPublish");
    FG("com.tencent.mm.plugin.recordvideo.appcamera.PluginMMSight");
    FG("com.tencent.mm.plugin.secinforeport.PluginSecInfoReport");
    FG("com.tencent.mm.plugin.multimediareport.PluginMultiMediaReport");
    FG("com.tencent.mm.plugin.normsg.PluginNormsg");
    FG("com.tencent.mm.plugin.netmock.PluginNetMock");
    FG("com.tencent.kinda.debug.PluginKindaReload");
    FG("com.tencent.mm.plugin.wxpayreport.PluginWcPayReport");
    FG("com.tencent.mm.plugin.rubbishbin.PluginRubbishbin");
    if (BuildInfo.ext.getBoolean("ENABLE_STETHO")) {
      FG("com.tencent.mm.plugin.stetho.PluginStetho");
    }
    FG("com.tencent.mm.plugin.notifymessage.PluginNotifyMessage");
    FG("com.tencent.mm.plugin.boots.PluginBoots");
    FG("com.tencent.mm.plugin.downloader_app.PluginDownloaderApp");
    FG("com.tencent.mm.plugin.game.luggage.PluginLuggageGame");
    FG("com.tencent.mm.plugin.trafficmonitor.PluginTrafficMonitor");
    FG("com.tencent.mm.plugin.story.PluginStory");
    FG("com.tencent.mm.plugin.finder.PluginFinder");
    FG("com.tencent.mm.plugin.byp.PluginByp");
    FG("com.tencent.mm.plugin.thumbplayer.PluginThumbPlayer");
    FG("com.tencent.mm.plugin.audio.PluginAudio");
    FG("com.tencent.mm.plugin.crashfix.PluginSystemCrashFix");
    FG("com.tencent.mm.plugin.flutter.PluginFlutter");
    FG("com.tencent.mm.plugin.box.PluginBox");
    FG("com.tencent.mm.plugin.lite.PluginLiteApp");
    FG("com.tencent.mm.plugin.mobile.verify.PluginMobileVerify");
    FG("com.tencent.mm.gpu.PluginGpuRes");
    FG("com.tencent.mm.live.PluginLive");
    FG("com.tencent.mm.plugin.gamelive.PluginGameLive");
    FG(PluginCast.class.getCanonicalName());
    FG(PluginRingtone.class.getCanonicalName());
    FG(PluginFlutterVoip.class.getCanonicalName());
    FG(PluginFlutterDataSources.class.getCanonicalName());
    FG(PluginFlutterThumbPlayer.class.getCanonicalName());
    FG(PluginVideoRes.class.getCanonicalName());
    FG(PluginScanProductRes.class.getCanonicalName());
    FG("com.tencent.mm.wlogcat.PluginLogcat");
    FG("com.tencent.mm.plugin.emoji.magicemoji.PluginMagicEmoji");
    FG("com.tencent.mm.plugin.finder.fts.PluginFinderFts");
    FG("com.tencent.mm.plugin.emoji.magicemoji.PluginMagicEmoji");
    if (BuildInfo.ext.getBoolean("ENABLE_DEVTOOLS")) {
      FG("com.tencent.mm.plugin.devtools.PluginDevTools");
    }
    FG("com.tencent.mm.plugin.surface.api.PluginSurface");
    FG("com.tencent.mm.accessibility.AccessibilityPlugin");
    FG(PluginSnsWithTa.class.getCanonicalName());
    FG(PluginMaasTemplate.class.getCanonicalName());
    localObject = com.tencent.mm.kernel.a.c.baR().mDY;
    com.tencent.mm.kernel.b.a locala = com.tencent.mm.kernel.h.az(v.class);
    ((com.tencent.mm.kernel.a.b.g)localObject).mFn.put(com.tencent.mm.kernel.api.c.class, locala);
    AppMethodBeat.o(160120);
  }
  
  public final boolean aCp()
  {
    AppMethodBeat.i(160124);
    if (hgc)
    {
      AppMethodBeat.o(160124);
      return true;
    }
    if (!((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.h.baB().bad()).bbA())
    {
      AppMethodBeat.o(160124);
      return true;
    }
    com.tencent.mm.kernel.h.baC();
    if ((!com.tencent.mm.kernel.b.aZM()) || (!com.tencent.mm.kernel.h.baC().aZN()))
    {
      AppMethodBeat.o(160124);
      return true;
    }
    if (com.tencent.mm.splash.i.acAD.size() == 1)
    {
      Activity localActivity = (Activity)com.tencent.mm.splash.i.acAD.get(0);
      if (MMApplicationContext.getLaunchName().equals(com.tencent.mm.splash.i.bL(localActivity)))
      {
        Log.i("MicroMsg.DefaultBootStep", "Found LauncherUI only.");
        AppMethodBeat.o(160124);
        return false;
      }
    }
    AppMethodBeat.o(160124);
    return true;
  }
  
  public final void b(final com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(160121);
    com.tencent.mm.vfs.af.j(paramg);
    aCo();
    if (((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.h.baB().bad()).bbA()) {
      new MMHandler("Startup-SideWork").post(new Runnable()
      {
        /* Error */
        public final void run()
        {
          // Byte code:
          //   0: ldc 29
          //   2: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
          //   5: aload_0
          //   6: getfield 19	com/tencent/mm/app/k$2:hgd	Lcom/tencent/mm/app/k;
          //   9: invokestatic 39	com/tencent/mm/app/k:a	(Lcom/tencent/mm/app/k;)Lcom/tencent/mm/cp/k;
          //   12: astore_2
          //   13: aload_2
          //   14: getfield 45	com/tencent/mm/cp/k:mLock	[B
          //   17: astore_1
          //   18: aload_1
          //   19: monitorenter
          //   20: aload_2
          //   21: getfield 45	com/tencent/mm/cp/k:mLock	[B
          //   24: iconst_0
          //   25: iconst_m1
          //   26: bastore
          //   27: ldc 47
          //   29: ldc 49
          //   31: iconst_1
          //   32: anewarray 4	java/lang/Object
          //   35: dup
          //   36: iconst_0
          //   37: aload_2
          //   38: aastore
          //   39: invokestatic 54	com/tencent/mm/kernel/l:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
          //   42: aload_1
          //   43: monitorexit
          //   44: aload_0
          //   45: getfield 19	com/tencent/mm/app/k$2:hgd	Lcom/tencent/mm/app/k;
          //   48: invokestatic 39	com/tencent/mm/app/k:a	(Lcom/tencent/mm/app/k;)Lcom/tencent/mm/cp/k;
          //   51: invokevirtual 57	com/tencent/mm/cp/k:done	()V
          //   54: new 59	android/content/ContextWrapper
          //   57: dup
          //   58: aload_0
          //   59: getfield 21	com/tencent/mm/app/k$2:hge	Lcom/tencent/mm/kernel/b/g;
          //   62: getfield 65	com/tencent/mm/kernel/b/g:bGP	Landroid/app/Application;
          //   65: invokespecial 68	android/content/ContextWrapper:<init>	(Landroid/content/Context;)V
          //   68: astore_3
          //   69: invokestatic 74	com/tencent/mm/kiss/layout/b:bbG	()Lcom/tencent/mm/kiss/layout/b;
          //   72: astore_1
          //   73: invokestatic 80	com/tencent/mm/kiss/layout/a:bbF	()Lcom/tencent/mm/kiss/layout/a;
          //   76: getfield 84	com/tencent/mm/kiss/layout/a:mHandler	Lcom/tencent/mm/sdk/platformtools/MMHandler;
          //   79: invokevirtual 90	com/tencent/mm/sdk/platformtools/MMHandler:getSerialTag	()Ljava/lang/String;
          //   82: astore_2
          //   83: aload_3
          //   84: invokestatic 96	com/tencent/mm/ui/af:mU	(Landroid/content/Context;)Landroid/view/LayoutInflater;
          //   87: astore_3
          //   88: aload_1
          //   89: getfield 100	com/tencent/mm/kiss/layout/b:mInitialized	Z
          //   92: ifne +58 -> 150
          //   95: aload_1
          //   96: iconst_1
          //   97: putfield 100	com/tencent/mm/kiss/layout/b:mInitialized	Z
          //   100: aload_1
          //   101: aload_3
          //   102: putfield 104	com/tencent/mm/kiss/layout/b:mInflater	Landroid/view/LayoutInflater;
          //   105: aload_1
          //   106: aload_2
          //   107: putfield 108	com/tencent/mm/kiss/layout/b:mGg	Ljava/lang/String;
          //   110: aload_1
          //   111: iconst_2
          //   112: putfield 112	com/tencent/mm/kiss/layout/b:mMode	I
          //   115: aload_1
          //   116: new 114	com/tencent/mm/kiss/layout/b$1
          //   119: dup
          //   120: aload_1
          //   121: aload_1
          //   122: getfield 108	com/tencent/mm/kiss/layout/b:mGg	Ljava/lang/String;
          //   125: invokespecial 117	com/tencent/mm/kiss/layout/b$1:<init>	(Lcom/tencent/mm/kiss/layout/b;Ljava/lang/String;)V
          //   128: putfield 120	com/tencent/mm/kiss/layout/b:mGh	Lcom/tencent/mm/sdk/platformtools/MMHandler;
          //   131: bipush 26
          //   133: invokestatic 126	com/tencent/mm/compatible/util/d:rc	(I)Z
          //   136: ifeq +14 -> 150
          //   139: new 128	com/tencent/mm/kiss/layout/b$a
          //   142: dup
          //   143: aload_2
          //   144: invokespecial 131	com/tencent/mm/kiss/layout/b$a:<init>	(Ljava/lang/String;)V
          //   147: putstatic 135	com/tencent/mm/kiss/layout/b:mGj	Lcom/tencent/mm/kiss/layout/b$a;
          //   150: aload_0
          //   151: getfield 19	com/tencent/mm/app/k$2:hgd	Lcom/tencent/mm/app/k;
          //   154: invokestatic 39	com/tencent/mm/app/k:a	(Lcom/tencent/mm/app/k;)Lcom/tencent/mm/cp/k;
          //   157: invokevirtual 57	com/tencent/mm/cp/k:done	()V
          //   160: ldc 29
          //   162: invokestatic 138	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   165: return
          //   166: astore_2
          //   167: aload_1
          //   168: monitorexit
          //   169: ldc 29
          //   171: invokestatic 138	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   174: aload_2
          //   175: athrow
          //   176: astore_1
          //   177: ldc 140
          //   179: aload_1
          //   180: ldc 142
          //   182: iconst_0
          //   183: anewarray 4	java/lang/Object
          //   186: invokestatic 148	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
          //   189: ldc2_w 149
          //   192: lconst_1
          //   193: invokestatic 156	com/tencent/mm/blink/a:Q	(JJ)V
          //   196: ldc 140
          //   198: ldc 158
          //   200: iconst_3
          //   201: anewarray 4	java/lang/Object
          //   204: dup
          //   205: iconst_0
          //   206: invokestatic 164	com/tencent/mm/sdk/platformtools/MMApplicationContext:getResources	()Landroid/content/res/Resources;
          //   209: aastore
          //   210: dup
          //   211: iconst_1
          //   212: aload_0
          //   213: getfield 21	com/tencent/mm/app/k$2:hge	Lcom/tencent/mm/kernel/b/g;
          //   216: getfield 65	com/tencent/mm/kernel/b/g:bGP	Landroid/app/Application;
          //   219: invokevirtual 167	android/app/Application:getResources	()Landroid/content/res/Resources;
          //   222: aastore
          //   223: dup
          //   224: iconst_2
          //   225: aload_0
          //   226: getfield 21	com/tencent/mm/app/k$2:hge	Lcom/tencent/mm/kernel/b/g;
          //   229: getfield 65	com/tencent/mm/kernel/b/g:bGP	Landroid/app/Application;
          //   232: invokevirtual 167	android/app/Application:getResources	()Landroid/content/res/Resources;
          //   235: invokevirtual 173	android/content/res/Resources:getAssets	()Landroid/content/res/AssetManager;
          //   238: aastore
          //   239: invokestatic 174	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
          //   242: aload_0
          //   243: getfield 19	com/tencent/mm/app/k$2:hgd	Lcom/tencent/mm/app/k;
          //   246: aload_0
          //   247: getfield 21	com/tencent/mm/app/k$2:hge	Lcom/tencent/mm/kernel/b/g;
          //   250: invokestatic 176	com/tencent/mm/app/k:a	(Lcom/tencent/mm/app/k;Lcom/tencent/mm/kernel/b/g;)V
          //   253: aload_0
          //   254: getfield 19	com/tencent/mm/app/k$2:hgd	Lcom/tencent/mm/app/k;
          //   257: invokestatic 179	com/tencent/mm/app/k:b	(Lcom/tencent/mm/app/k;)Z
          //   260: pop
          //   261: aload_0
          //   262: getfield 19	com/tencent/mm/app/k$2:hgd	Lcom/tencent/mm/app/k;
          //   265: invokestatic 39	com/tencent/mm/app/k:a	(Lcom/tencent/mm/app/k;)Lcom/tencent/mm/cp/k;
          //   268: invokevirtual 57	com/tencent/mm/cp/k:done	()V
          //   271: ldc 29
          //   273: invokestatic 138	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   276: return
          //   277: astore_1
          //   278: aload_0
          //   279: getfield 19	com/tencent/mm/app/k$2:hgd	Lcom/tencent/mm/app/k;
          //   282: invokestatic 39	com/tencent/mm/app/k:a	(Lcom/tencent/mm/app/k;)Lcom/tencent/mm/cp/k;
          //   285: invokevirtual 57	com/tencent/mm/cp/k:done	()V
          //   288: ldc 29
          //   290: invokestatic 138	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   293: aload_1
          //   294: athrow
          // Local variable table:
          //   start	length	slot	name	signature
          //   0	295	0	this	2
          //   176	4	1	localException	java.lang.Exception
          //   277	17	1	localObject2	Object
          //   12	132	2	localObject3	Object
          //   166	9	2	localObject4	Object
          //   68	34	3	localObject5	Object
          // Exception table:
          //   from	to	target	type
          //   20	44	166	finally
          //   5	20	176	java/lang/Exception
          //   44	150	176	java/lang/Exception
          //   167	176	176	java/lang/Exception
          //   5	20	277	finally
          //   44	150	277	finally
          //   167	176	277	finally
          //   177	261	277	finally
        }
      });
    }
    super.b(paramg);
    AppMethodBeat.o(160121);
  }
  
  public final void c(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(160123);
    com.tencent.mm.cp.k localk;
    if (((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.h.baB().bad()).bbA()) {
      localk = this.hga;
    }
    synchronized (localk.mLock)
    {
      try
      {
        if (localk.mLock[0] == -1)
        {
          l.i("MicroMsg.WxWaitingLock", "waiting %s", new Object[] { localk });
          localk.mLock.wait();
          l.i("MicroMsg.WxWaitingLock", "after waiting %s", new Object[] { localk });
        }
        if (this.hgb) {
          Log.e("MicroMsg.DefaultBootStep", "SVG still failed!");
        }
        super.c(paramg);
        AppMethodBeat.o(160123);
        return;
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.WxWaitingLock", localInterruptedException, "", new Object[0]);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.app.k
 * JD-Core Version:    0.7.0.1
 */