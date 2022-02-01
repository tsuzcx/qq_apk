package com.tencent.mm.app;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.co.k;
import com.tencent.mm.kernel.j;
import com.tencent.mm.modelrecovery.PluginRecovery;
import com.tencent.mm.plugin.auth.PluginAuth;
import com.tencent.mm.plugin.bbom.PluginBigBallOfMud;
import com.tencent.mm.plugin.messenger.foundation.PluginMessengerFoundation;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.plugin.recordvideo.background.c.b;
import com.tencent.mm.plugin.recordvideo.background.c.b.a;
import com.tencent.mm.plugin.recordvideo.res.PluginVideoRes;
import com.tencent.mm.plugin.report.PluginReport;
import com.tencent.mm.plugin.zero.PluginZero;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.ImmutableBundle;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.SyncTask;
import com.tencent.mm.ui.ao;
import com.tencent.mm.vfs.y;
import com.tencent.xweb.WebView.c;
import java.util.ArrayList;
import java.util.Map;
import org.xwalk.core.XWalkEnvironment;
import org.xwalk.core.XWalkEnvironment.ForceDarkBehavior;

public class i
  extends com.tencent.mm.kernel.a.d
{
  private static boolean dkL = true;
  private k dkJ;
  private volatile boolean dkK;
  
  public i()
  {
    AppMethodBeat.i(160118);
    this.dkJ = new k();
    this.dkK = false;
    AppMethodBeat.o(160118);
  }
  
  private static void Wl()
  {
    AppMethodBeat.i(160122);
    long l = System.currentTimeMillis();
    ab.WH();
    l = System.currentTimeMillis() - l;
    com.tencent.mm.blink.a.t(4L, l);
    com.tencent.mm.blink.a.t(5L, 1L);
    Log.i("MicroMsg.DefaultBootStep", "SVG newInstance done, spent %s", new Object[] { Long.valueOf(l) });
    AppMethodBeat.o(160122);
  }
  
  public void VZ()
  {
    AppMethodBeat.i(160119);
    super.VZ();
    com.tencent.mm.kernel.a.a.k("Hello WeChat, DefaultBootStep load debugger and newInstance xlog...", new Object[0]);
    MMApplicationContext.getContext().getSystemService("audio");
    t.d(true, ((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.g.aAe().azG()).mProcessName);
    ab.ab(com.tencent.mm.boot.a.a.class);
    ab.gm("com.tencent.mm.boot");
    ab.a(((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.g.aAe().azG()).ca, ((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.g.aAe().azG()).ca.getResources());
    XWalkEnvironment.setForceDarkMode(ao.isDarkMode());
    if (MMApplicationContext.isAppBrandProcess()) {
      com.tencent.mm.l.a.a.a(new com.tencent.mm.l.a()
      {
        public final boolean Wo()
        {
          AppMethodBeat.i(160132);
          com.tencent.mm.cr.d.a(WebView.c.SAt);
          boolean bool = com.tencent.mm.cr.d.hiB();
          AppMethodBeat.o(160132);
          return bool;
        }
      });
    }
    XWalkEnvironment.setForceDarkBehavior(XWalkEnvironment.ForceDarkBehavior.MEDIA_QUERY_ONLY);
    AppMethodBeat.o(160119);
  }
  
  public void Wa()
  {
    AppMethodBeat.i(160120);
    com.tencent.mm.kernel.g.aAd().hqx = com.tencent.mm.plugin.zero.a.d.class;
    al(PluginZero.class);
    al(PluginMessengerFoundation.class);
    al(PluginReport.class);
    al(PluginAuth.class);
    al(PluginBigBallOfMud.class);
    al(PluginRecovery.class);
    FW("com.tencent.mm.plugin.bbom.PluginCompatOldStructure");
    FW("com.tencent.mm.plugin.bbom.PluginBigBallOfMudAsync");
    FW("com.tencent.mm.plugin.avatar.PluginAvatar");
    FW("com.tencent.mm.plugin.image.PluginImageBase");
    FW("com.tencent.mm.plugin.comm.PluginComm");
    FW("com.tencent.mm.plugin.audio.PluginVoice");
    FW("com.tencent.mm.plugin.biz.PluginBiz");
    FX("com.tencent.mm.plugin.bizui.PluginBIZUI");
    FW("com.tencent.mm.plugin.brandservice.PluginBrandService");
    FW("com.tencent.mm.plugin.readerapp.PluginReaderApp");
    FW("com.tencent.mm.plugin.notification.PluginNotification");
    FW("com.tencent.mm.plugin.messenger.PluginMessenger");
    FW("com.tencent.mm.plugin.notification.PluginPNotification");
    FW("com.tencent.mm.plugin.welab.PluginWelab");
    FW("com.tencent.mm.plugin.sport.PluginSport");
    FW("com.tencent.mm.plugin.fts.PluginFTS");
    FW("com.tencent.mm.plugin.multitask.PluginMultiTask");
    FW("com.tencent.mm.plugin.taskbar.PluginTaskBar");
    FW("com.tencent.mm.plugin.updater.PluginUpdater");
    FW("com.tencent.mm.openim.PluginOpenIM");
    FX("com.tencent.mm.plugin.misc.PluginMisc");
    FW("com.tencent.mm.openim.room.PluginOpenIMRoom");
    FW("com.tencent.mm.roomsdk.PluginRoomSdk");
    FW("com.tencent.mm.ipcinvoker.wx_extension.PluginIPC");
    FW("com.tencent.mm.plugin.abtest.PluginABTest");
    FW("com.tencent.mm.plugin.expt.PluginExpt");
    FW("com.tencent.mm.plugin.ai.PluginAi");
    FW("com.tencent.mm.plugin.backup.PluginBackup");
    FW("com.tencent.mm.pluginsdk.model.app.PluginAppMsg");
    FW("com.tencent.mm.plugin.hardcoder.PluginHardcoder");
    FW("com.tencent.mm.plugin.teenmode.PluginTeenMode");
    FX("com.tencent.mm.plugin.secdata.PluginSecData");
    FX("com.tencent.mm.plugin.performance.PluginPerformance");
    FX("com.tencent.mm.plugin.chatroom.PluginChatroom");
    FX("com.tencent.mm.PluginFunctionMsg");
    FX("com.tencent.mm.insane_statistic.PluginInsaneStatistic");
    FX("com.tencent.mm.plugin.appbrand.app.PluginAppBrand");
    FX("com.tencent.mm.plugin.handoff.PluginHandOff");
    FX("com.tencent.mm.plugin.choosemsgfile.PluginChooseMsgFile");
    FX("com.tencent.mm.plugin.ball.PluginBall");
    FX("com.tencent.mm.plugin.uishow.PluginUIShow");
    FX("com.tencent.mm.plugin.emoji.PluginEmoji");
    FX("com.tencent.mm.plugin.eggspring.PluginEggSpring");
    FX("com.tencent.mm.chatroom.plugin.PluginChatroomUI");
    FX("com.tencent.mm.plugin.patmsg.PluginPatMsg");
    FX("com.tencent.mm.plugin.game.PluginGame");
    FX("com.tencent.mm.game.report.PluginGameReport");
    FX("com.tencent.mm.plugin.wepkg.PluginWePkg");
    FX("com.tencent.mm.plugin.game.commlib.PluginCommLib");
    FX("com.tencent.mm.plugin.gamelife.PluginGameLife");
    FX("com.tencent.mm.plugin.recordvideo.PluginVideoEditor");
    FX("com.tencent.mm.plugin.video.PluginVideo");
    FX("com.tencent.mm.plugin.hardwareopt.PluginHardwareOpt");
    FX("com.tencent.mm.plugin.sns.PluginSns");
    FX("com.tencent.mm.plugin.downloader.PluginDownloader");
    FX("com.tencent.mm.plugin.fav.PluginFav");
    FX("com.tencent.mm.plugin.fav.ui.PluginFavUI");
    FX("com.tencent.mm.plugin.record.PluginRecord");
    FX("com.tencent.mm.plugin.music.PluginMusic");
    FX("com.tencent.mm.plugin.MMPhotoEditPlugin");
    FX("com.tencent.mm.plugin.account.PluginAccount");
    Object localObject = b.BMn;
    FX(b.a.getCLASS());
    FX("com.tencent.mm.plugin.facedetect.PluginFace");
    FX("com.tencent.mm.plugin.soter.PluginSoter");
    FX("com.tencent.mm.plugin.walletlock.PluginWalletLock");
    FX("com.tencent.mm.plugin.wxpay.PluginWxPay");
    FX("com.tencent.mm.plugin.wxpaysdk.PluginWxPaySdk");
    FX("com.tencent.mm.plugin.wxpayapi.PluginWxPayApi");
    FX("com.tencent.kinda.framework.PluginWxKindaApi");
    if (BuildInfo.ENABLE_PAYTEST) {
      FX("com.tencent.mm.plugin.paytest.api.PluginPayTestHeaderApi");
    }
    FX("com.tencent.mm.plugin.radar.PluginRadar");
    FX("com.tencent.mm.plugin.topstory.PluginTopStory");
    FX("com.tencent.mm.plugin.topstory.ui.PluginTopStoryUI");
    FX("com.tencent.mm.plugin.websearch.PluginWebSearch");
    FX("com.tencent.mm.plugin.textstatus.PluginTextStatus");
    FX("com.tencent.mm.plugin.fts.ui.PluginFTSUI");
    FX("com.tencent.mm.plugin.card.PluginCard");
    FX("com.tencent.mm.plugin.card.compat.PluginCardCompat");
    FX("com.tencent.mm.plugin.forcenotify.PluginForceNotify");
    FX("com.tencent.mm.plugin.monitor.PluginMonitor");
    FW("com.tencent.mm.plugin.expansions.PluginExpansions");
    FX("com.tencent.mm.plugin.fcm.PluginFCM");
    FX("com.tencent.mm.plugin.emojicapture.model.PluginEmojiCapture");
    FX("com.tencent.mm.plugin.selectcontact.PluginSelectContact");
    FX("com.tencent.mm.plugin.cloudvoip.cloudvoice.PluginCloudVoice");
    FX("com.tencent.mm.plugin.webview.PluginWebView");
    FX("com.tencent.mm.plugin.priority.PluginPriority");
    FX("com.tencent.mm.plugin.qqmail.PluginQQMail");
    FX("com.tencent.mm.plugin.scanner.PluginScanTranslation");
    FX("com.tencent.mm.plugin.scanner.PluginScanner");
    FX("com.tencent.mm.plugin.newtips.PluginNewTips");
    FX("com.tencent.mm.plugin.groupsolitaire.PluginGroupSolitaire");
    FX("com.tencent.mm.plugin.groupcollect.PluginGroupCollect");
    FX("com.tencent.mm.plugin.editor.PluginEditor");
    FX("com.tencent.mm.plugin.fav.offline.PluginFavOffline");
    FX("com.tencent.mm.plugin.msgquote.PluginMsgQuote");
    FX("com.tencent.mm.plugin.selectrecord.PluginSelectRecord");
    FX("com.tencent.mm.contact.PluginContact");
    FX("com.tencent.mm.plugin.kidswatch.PluginKidsWatch");
    FX("com.tencent.mm.plugin.hld.PluginHld");
    FX("com.tencent.mm.plugin.mv.PluginMv");
    FX("com.tencent.mm.plugin.recordvideo.appcamera.PluginMMSight");
    FX("com.tencent.mm.plugin.secinforeport.PluginSecInfoReport");
    FX("com.tencent.mm.plugin.multimediareport.PluginMultiMediaReport");
    FX("com.tencent.mm.plugin.normsg.PluginNormsg");
    FX("com.tencent.mm.plugin.netmock.PluginNetMock");
    FX("com.tencent.kinda.debug.PluginKindaReload");
    FX("com.tencent.mm.plugin.rubbishbin.PluginRubbishbin");
    if (BuildInfo.ext.getBoolean("ENABLE_STETHO")) {
      FX("com.tencent.mm.plugin.stetho.PluginStetho");
    }
    FX("com.tencent.mm.plugin.notifymessage.PluginNotifyMessage");
    FX("com.tencent.mm.plugin.boots.PluginBoots");
    FX("com.tencent.mm.plugin.downloader_app.PluginDownloaderApp");
    FX("com.tencent.mm.plugin.game.luggage.PluginLuggageGame");
    FX("com.tencent.mm.plugin.trafficmonitor.PluginTrafficMonitor");
    FX("com.tencent.mm.plugin.story.PluginStory");
    FX("com.tencent.mm.plugin.finder.PluginFinder");
    FX("com.tencent.mm.plugin.byp.PluginByp");
    FX("com.tencent.mm.plugin.thumbplayer.PluginThumbPlayer");
    FX("com.tencent.mm.plugin.audio.PluginAudio");
    FX("com.tencent.mm.plugin.crashfix.PluginSystemCrashFix");
    FX("com.tencent.mm.plugin.flutter.PluginFlutter");
    FX("com.tencent.mm.plugin.box.PluginBox");
    FX("com.tencent.mm.plugin.lite.PluginLiteApp");
    FX("com.tencent.mm.plugin.mobile.verify.PluginMobileVerify");
    FX("com.tencent.mm.gpu.PluginGpuRes");
    FX("com.tencent.mm.live.PluginLive");
    FX(PluginVideoRes.class.getCanonicalName());
    FX("com.tencent.mm.wlogcat.PluginLogcat");
    FX("com.tencent.mm.plugin.emoji.magicemoji.PluginMagicEmoji");
    FX("com.tencent.mm.plugin.emoji.magicemoji.PluginMagicEmoji");
    localObject = com.tencent.mm.kernel.a.c.aAu().hrT;
    com.tencent.mm.kernel.b.a locala = com.tencent.mm.kernel.g.ah(s.class);
    ((com.tencent.mm.kernel.a.b.g)localObject).hti.put(com.tencent.mm.kernel.api.c.class, locala);
    AppMethodBeat.o(160120);
  }
  
  public final boolean Wm()
  {
    AppMethodBeat.i(160124);
    if (dkL)
    {
      AppMethodBeat.o(160124);
      return true;
    }
    if (!((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.g.aAe().azG()).aBb())
    {
      AppMethodBeat.o(160124);
      return true;
    }
    com.tencent.mm.kernel.g.aAf();
    if ((!com.tencent.mm.kernel.a.azo()) || (!com.tencent.mm.kernel.g.aAf().azp()))
    {
      AppMethodBeat.o(160124);
      return true;
    }
    if (com.tencent.mm.splash.h.NLB.size() == 1)
    {
      Activity localActivity = (Activity)com.tencent.mm.splash.h.NLB.get(0);
      if (MMApplicationContext.getLaunchName().equals(com.tencent.mm.splash.h.bb(localActivity)))
      {
        Log.i("MicroMsg.DefaultBootStep", "Found LauncherUI only.");
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
    y.g(paramg);
    Wl();
    if (((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.g.aAe().azG()).aBb()) {
      new MMHandler("Startup-SideWork").post(new Runnable()
      {
        /* Error */
        public final void run()
        {
          // Byte code:
          //   0: ldc 29
          //   2: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
          //   5: aload_0
          //   6: getfield 19	com/tencent/mm/app/i$2:dkM	Lcom/tencent/mm/app/i;
          //   9: invokestatic 38	com/tencent/mm/app/i:a	(Lcom/tencent/mm/app/i;)Lcom/tencent/mm/co/k;
          //   12: astore_2
          //   13: aload_2
          //   14: getfield 44	com/tencent/mm/co/k:mLock	[B
          //   17: astore_1
          //   18: aload_1
          //   19: monitorenter
          //   20: aload_2
          //   21: getfield 44	com/tencent/mm/co/k:mLock	[B
          //   24: iconst_0
          //   25: iconst_m1
          //   26: bastore
          //   27: ldc 46
          //   29: ldc 48
          //   31: iconst_1
          //   32: anewarray 4	java/lang/Object
          //   35: dup
          //   36: iconst_0
          //   37: aload_2
          //   38: aastore
          //   39: invokestatic 53	com/tencent/mm/kernel/j:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
          //   42: aload_1
          //   43: monitorexit
          //   44: aload_0
          //   45: getfield 19	com/tencent/mm/app/i$2:dkM	Lcom/tencent/mm/app/i;
          //   48: invokestatic 38	com/tencent/mm/app/i:a	(Lcom/tencent/mm/app/i;)Lcom/tencent/mm/co/k;
          //   51: invokevirtual 56	com/tencent/mm/co/k:done	()V
          //   54: new 58	android/content/ContextWrapper
          //   57: dup
          //   58: aload_0
          //   59: getfield 21	com/tencent/mm/app/i$2:dkN	Lcom/tencent/mm/kernel/b/g;
          //   62: getfield 64	com/tencent/mm/kernel/b/g:ca	Landroid/app/Application;
          //   65: invokespecial 67	android/content/ContextWrapper:<init>	(Landroid/content/Context;)V
          //   68: astore_3
          //   69: invokestatic 73	com/tencent/mm/kiss/a/b:aBh	()Lcom/tencent/mm/kiss/a/b;
          //   72: astore_1
          //   73: invokestatic 79	com/tencent/mm/kiss/a/a:aBg	()Lcom/tencent/mm/kiss/a/a;
          //   76: getfield 83	com/tencent/mm/kiss/a/a:mHandler	Lcom/tencent/mm/sdk/platformtools/MMHandler;
          //   79: invokevirtual 89	com/tencent/mm/sdk/platformtools/MMHandler:getSerialTag	()Ljava/lang/String;
          //   82: astore_2
          //   83: aload_3
          //   84: invokestatic 95	com/tencent/mm/ui/aa:jQ	(Landroid/content/Context;)Landroid/view/LayoutInflater;
          //   87: astore_3
          //   88: aload_1
          //   89: getfield 99	com/tencent/mm/kiss/a/b:mInitialized	Z
          //   92: ifne +58 -> 150
          //   95: aload_1
          //   96: iconst_1
          //   97: putfield 99	com/tencent/mm/kiss/a/b:mInitialized	Z
          //   100: aload_1
          //   101: aload_3
          //   102: putfield 103	com/tencent/mm/kiss/a/b:mInflater	Landroid/view/LayoutInflater;
          //   105: aload_1
          //   106: aload_2
          //   107: putfield 107	com/tencent/mm/kiss/a/b:htL	Ljava/lang/String;
          //   110: aload_1
          //   111: iconst_2
          //   112: putfield 111	com/tencent/mm/kiss/a/b:mMode	I
          //   115: aload_1
          //   116: new 113	com/tencent/mm/kiss/a/b$1
          //   119: dup
          //   120: aload_1
          //   121: aload_1
          //   122: getfield 107	com/tencent/mm/kiss/a/b:htL	Ljava/lang/String;
          //   125: invokespecial 116	com/tencent/mm/kiss/a/b$1:<init>	(Lcom/tencent/mm/kiss/a/b;Ljava/lang/String;)V
          //   128: putfield 119	com/tencent/mm/kiss/a/b:htM	Lcom/tencent/mm/sdk/platformtools/MMHandler;
          //   131: bipush 26
          //   133: invokestatic 125	com/tencent/mm/compatible/util/d:oE	(I)Z
          //   136: ifeq +14 -> 150
          //   139: new 127	com/tencent/mm/kiss/a/b$a
          //   142: dup
          //   143: aload_2
          //   144: invokespecial 130	com/tencent/mm/kiss/a/b$a:<init>	(Ljava/lang/String;)V
          //   147: putstatic 134	com/tencent/mm/kiss/a/b:htO	Lcom/tencent/mm/kiss/a/b$a;
          //   150: aload_0
          //   151: getfield 19	com/tencent/mm/app/i$2:dkM	Lcom/tencent/mm/app/i;
          //   154: invokestatic 38	com/tencent/mm/app/i:a	(Lcom/tencent/mm/app/i;)Lcom/tencent/mm/co/k;
          //   157: invokevirtual 56	com/tencent/mm/co/k:done	()V
          //   160: ldc 29
          //   162: invokestatic 137	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   165: return
          //   166: astore_2
          //   167: aload_1
          //   168: monitorexit
          //   169: ldc 29
          //   171: invokestatic 137	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   174: aload_2
          //   175: athrow
          //   176: astore_1
          //   177: ldc 139
          //   179: aload_1
          //   180: ldc 141
          //   182: iconst_0
          //   183: anewarray 4	java/lang/Object
          //   186: invokestatic 147	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
          //   189: ldc2_w 148
          //   192: lconst_1
          //   193: invokestatic 155	com/tencent/mm/blink/a:t	(JJ)V
          //   196: ldc 139
          //   198: ldc 157
          //   200: iconst_3
          //   201: anewarray 4	java/lang/Object
          //   204: dup
          //   205: iconst_0
          //   206: invokestatic 163	com/tencent/mm/sdk/platformtools/MMApplicationContext:getResources	()Landroid/content/res/Resources;
          //   209: aastore
          //   210: dup
          //   211: iconst_1
          //   212: aload_0
          //   213: getfield 21	com/tencent/mm/app/i$2:dkN	Lcom/tencent/mm/kernel/b/g;
          //   216: getfield 64	com/tencent/mm/kernel/b/g:ca	Landroid/app/Application;
          //   219: invokevirtual 166	android/app/Application:getResources	()Landroid/content/res/Resources;
          //   222: aastore
          //   223: dup
          //   224: iconst_2
          //   225: aload_0
          //   226: getfield 21	com/tencent/mm/app/i$2:dkN	Lcom/tencent/mm/kernel/b/g;
          //   229: getfield 64	com/tencent/mm/kernel/b/g:ca	Landroid/app/Application;
          //   232: invokevirtual 166	android/app/Application:getResources	()Landroid/content/res/Resources;
          //   235: invokevirtual 172	android/content/res/Resources:getAssets	()Landroid/content/res/AssetManager;
          //   238: aastore
          //   239: invokestatic 173	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
          //   242: aload_0
          //   243: getfield 19	com/tencent/mm/app/i$2:dkM	Lcom/tencent/mm/app/i;
          //   246: aload_0
          //   247: getfield 21	com/tencent/mm/app/i$2:dkN	Lcom/tencent/mm/kernel/b/g;
          //   250: invokestatic 175	com/tencent/mm/app/i:a	(Lcom/tencent/mm/app/i;Lcom/tencent/mm/kernel/b/g;)V
          //   253: aload_0
          //   254: getfield 19	com/tencent/mm/app/i$2:dkM	Lcom/tencent/mm/app/i;
          //   257: invokestatic 179	com/tencent/mm/app/i:b	(Lcom/tencent/mm/app/i;)Z
          //   260: pop
          //   261: aload_0
          //   262: getfield 19	com/tencent/mm/app/i$2:dkM	Lcom/tencent/mm/app/i;
          //   265: invokestatic 38	com/tencent/mm/app/i:a	(Lcom/tencent/mm/app/i;)Lcom/tencent/mm/co/k;
          //   268: invokevirtual 56	com/tencent/mm/co/k:done	()V
          //   271: ldc 29
          //   273: invokestatic 137	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   276: return
          //   277: astore_1
          //   278: aload_0
          //   279: getfield 19	com/tencent/mm/app/i$2:dkM	Lcom/tencent/mm/app/i;
          //   282: invokestatic 38	com/tencent/mm/app/i:a	(Lcom/tencent/mm/app/i;)Lcom/tencent/mm/co/k;
          //   285: invokevirtual 56	com/tencent/mm/co/k:done	()V
          //   288: ldc 29
          //   290: invokestatic 137	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
          //   167	169	166	finally
          //   5	20	176	java/lang/Exception
          //   44	150	176	java/lang/Exception
          //   169	176	176	java/lang/Exception
          //   5	20	277	finally
          //   44	150	277	finally
          //   169	176	277	finally
          //   177	261	277	finally
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
    if (((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.g.aAe().azG()).aBb()) {
      localk = this.dkJ;
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
        if (this.dkK) {
          Log.e("MicroMsg.DefaultBootStep", "SVG still failed!");
        }
        super.b(paramg);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.app.i
 * JD-Core Version:    0.7.0.1
 */