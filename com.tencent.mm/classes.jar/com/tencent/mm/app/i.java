package com.tencent.mm.app;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build.VERSION;
import com.tencent.matrix.jectl.JeCtl;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.boot.R.raw;
import com.tencent.mm.cw.k;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.l;
import com.tencent.mm.l.a.a;
import com.tencent.mm.modelrecovery.PluginRecovery;
import com.tencent.mm.plugin.auth.PluginAuth;
import com.tencent.mm.plugin.bbom.PluginBigBallOfMud;
import com.tencent.mm.plugin.cast.PluginCast;
import com.tencent.mm.plugin.messenger.foundation.PluginMessengerFoundation;
import com.tencent.mm.plugin.messenger.foundation.a.v;
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
import com.tencent.mm.ui.ar;
import com.tencent.mm.vfs.ab;
import com.tencent.xweb.WebView.c;
import java.util.ArrayList;
import java.util.Map;
import org.xwalk.core.XWalkEnvironment;
import org.xwalk.core.XWalkEnvironment.ForceDarkBehavior;

public class i
  extends com.tencent.mm.kernel.a.d
{
  private static boolean fcu = true;
  private k fcs;
  private volatile boolean fct;
  
  public i()
  {
    AppMethodBeat.i(160118);
    this.fcs = new k();
    this.fct = false;
    AppMethodBeat.o(160118);
  }
  
  private static void aaH()
  {
    AppMethodBeat.i(160122);
    long l = System.currentTimeMillis();
    ac.abg();
    l = System.currentTimeMillis() - l;
    com.tencent.mm.blink.a.t(4L, l);
    com.tencent.mm.blink.a.t(5L, 1L);
    Log.i("MicroMsg.DefaultBootStep", "SVG newInstance done, spent %s", new Object[] { Long.valueOf(l) });
    AppMethodBeat.o(160122);
  }
  
  public final void a(final com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(160121);
    ab.i(paramg);
    aaH();
    if (((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.h.aHD().aHf()).aIE()) {
      new MMHandler("Startup-SideWork").post(new Runnable()
      {
        /* Error */
        public final void run()
        {
          // Byte code:
          //   0: ldc 29
          //   2: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
          //   5: aload_0
          //   6: getfield 19	com/tencent/mm/app/i$3:fcv	Lcom/tencent/mm/app/i;
          //   9: invokestatic 38	com/tencent/mm/app/i:a	(Lcom/tencent/mm/app/i;)Lcom/tencent/mm/cw/k;
          //   12: astore_2
          //   13: aload_2
          //   14: getfield 44	com/tencent/mm/cw/k:mLock	[B
          //   17: astore_1
          //   18: aload_1
          //   19: monitorenter
          //   20: aload_2
          //   21: getfield 44	com/tencent/mm/cw/k:mLock	[B
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
          //   39: invokestatic 53	com/tencent/mm/kernel/l:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
          //   42: aload_1
          //   43: monitorexit
          //   44: aload_0
          //   45: getfield 19	com/tencent/mm/app/i$3:fcv	Lcom/tencent/mm/app/i;
          //   48: invokestatic 38	com/tencent/mm/app/i:a	(Lcom/tencent/mm/app/i;)Lcom/tencent/mm/cw/k;
          //   51: invokevirtual 56	com/tencent/mm/cw/k:done	()V
          //   54: new 58	android/content/ContextWrapper
          //   57: dup
          //   58: aload_0
          //   59: getfield 21	com/tencent/mm/app/i$3:fcw	Lcom/tencent/mm/kernel/b/g;
          //   62: getfield 64	com/tencent/mm/kernel/b/g:Zw	Landroid/app/Application;
          //   65: invokespecial 67	android/content/ContextWrapper:<init>	(Landroid/content/Context;)V
          //   68: astore_3
          //   69: invokestatic 73	com/tencent/mm/kiss/a/b:aIK	()Lcom/tencent/mm/kiss/a/b;
          //   72: astore_1
          //   73: invokestatic 79	com/tencent/mm/kiss/a/a:aIJ	()Lcom/tencent/mm/kiss/a/a;
          //   76: getfield 83	com/tencent/mm/kiss/a/a:mHandler	Lcom/tencent/mm/sdk/platformtools/MMHandler;
          //   79: invokevirtual 89	com/tencent/mm/sdk/platformtools/MMHandler:getSerialTag	()Ljava/lang/String;
          //   82: astore_2
          //   83: aload_3
          //   84: invokestatic 95	com/tencent/mm/ui/ad:kS	(Landroid/content/Context;)Landroid/view/LayoutInflater;
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
          //   107: putfield 107	com/tencent/mm/kiss/a/b:kfI	Ljava/lang/String;
          //   110: aload_1
          //   111: iconst_2
          //   112: putfield 111	com/tencent/mm/kiss/a/b:mMode	I
          //   115: aload_1
          //   116: new 113	com/tencent/mm/kiss/a/b$1
          //   119: dup
          //   120: aload_1
          //   121: aload_1
          //   122: getfield 107	com/tencent/mm/kiss/a/b:kfI	Ljava/lang/String;
          //   125: invokespecial 116	com/tencent/mm/kiss/a/b$1:<init>	(Lcom/tencent/mm/kiss/a/b;Ljava/lang/String;)V
          //   128: putfield 119	com/tencent/mm/kiss/a/b:kfJ	Lcom/tencent/mm/sdk/platformtools/MMHandler;
          //   131: bipush 26
          //   133: invokestatic 125	com/tencent/mm/compatible/util/d:qW	(I)Z
          //   136: ifeq +14 -> 150
          //   139: new 127	com/tencent/mm/kiss/a/b$a
          //   142: dup
          //   143: aload_2
          //   144: invokespecial 130	com/tencent/mm/kiss/a/b$a:<init>	(Ljava/lang/String;)V
          //   147: putstatic 134	com/tencent/mm/kiss/a/b:kfL	Lcom/tencent/mm/kiss/a/b$a;
          //   150: aload_0
          //   151: getfield 19	com/tencent/mm/app/i$3:fcv	Lcom/tencent/mm/app/i;
          //   154: invokestatic 38	com/tencent/mm/app/i:a	(Lcom/tencent/mm/app/i;)Lcom/tencent/mm/cw/k;
          //   157: invokevirtual 56	com/tencent/mm/cw/k:done	()V
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
          //   213: getfield 21	com/tencent/mm/app/i$3:fcw	Lcom/tencent/mm/kernel/b/g;
          //   216: getfield 64	com/tencent/mm/kernel/b/g:Zw	Landroid/app/Application;
          //   219: invokevirtual 166	android/app/Application:getResources	()Landroid/content/res/Resources;
          //   222: aastore
          //   223: dup
          //   224: iconst_2
          //   225: aload_0
          //   226: getfield 21	com/tencent/mm/app/i$3:fcw	Lcom/tencent/mm/kernel/b/g;
          //   229: getfield 64	com/tencent/mm/kernel/b/g:Zw	Landroid/app/Application;
          //   232: invokevirtual 166	android/app/Application:getResources	()Landroid/content/res/Resources;
          //   235: invokevirtual 172	android/content/res/Resources:getAssets	()Landroid/content/res/AssetManager;
          //   238: aastore
          //   239: invokestatic 173	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
          //   242: aload_0
          //   243: getfield 19	com/tencent/mm/app/i$3:fcv	Lcom/tencent/mm/app/i;
          //   246: aload_0
          //   247: getfield 21	com/tencent/mm/app/i$3:fcw	Lcom/tencent/mm/kernel/b/g;
          //   250: invokestatic 175	com/tencent/mm/app/i:a	(Lcom/tencent/mm/app/i;Lcom/tencent/mm/kernel/b/g;)V
          //   253: aload_0
          //   254: getfield 19	com/tencent/mm/app/i$3:fcv	Lcom/tencent/mm/app/i;
          //   257: invokestatic 179	com/tencent/mm/app/i:b	(Lcom/tencent/mm/app/i;)Z
          //   260: pop
          //   261: aload_0
          //   262: getfield 19	com/tencent/mm/app/i$3:fcv	Lcom/tencent/mm/app/i;
          //   265: invokestatic 38	com/tencent/mm/app/i:a	(Lcom/tencent/mm/app/i;)Lcom/tencent/mm/cw/k;
          //   268: invokevirtual 56	com/tencent/mm/cw/k:done	()V
          //   271: ldc 29
          //   273: invokestatic 137	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   276: return
          //   277: astore_1
          //   278: aload_0
          //   279: getfield 19	com/tencent/mm/app/i$3:fcv	Lcom/tencent/mm/app/i;
          //   282: invokestatic 38	com/tencent/mm/app/i:a	(Lcom/tencent/mm/app/i;)Lcom/tencent/mm/cw/k;
          //   285: invokevirtual 56	com/tencent/mm/cw/k:done	()V
          //   288: ldc 29
          //   290: invokestatic 137	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   293: aload_1
          //   294: athrow
          // Local variable table:
          //   start	length	slot	name	signature
          //   0	295	0	this	3
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
    super.a(paramg);
    AppMethodBeat.o(160121);
  }
  
  public final boolean aaI()
  {
    AppMethodBeat.i(160124);
    if (fcu)
    {
      AppMethodBeat.o(160124);
      return true;
    }
    if (!((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.h.aHD().aHf()).aIE())
    {
      AppMethodBeat.o(160124);
      return true;
    }
    com.tencent.mm.kernel.h.aHE();
    if ((!com.tencent.mm.kernel.b.aGL()) || (!com.tencent.mm.kernel.h.aHE().aGM()))
    {
      AppMethodBeat.o(160124);
      return true;
    }
    if (com.tencent.mm.splash.i.UZl.size() == 1)
    {
      Activity localActivity = (Activity)com.tencent.mm.splash.i.UZl.get(0);
      if (MMApplicationContext.getLaunchName().equals(com.tencent.mm.splash.i.bg(localActivity)))
      {
        Log.i("MicroMsg.DefaultBootStep", "Found LauncherUI only.");
        AppMethodBeat.o(160124);
        return false;
      }
    }
    AppMethodBeat.o(160124);
    return true;
  }
  
  public void aau()
  {
    AppMethodBeat.i(160119);
    super.aau();
    com.tencent.mm.kernel.a.a.j("Hello WeChat, DefaultBootStep load debugger and newInstance xlog...", new Object[0]);
    MMApplicationContext.getContext().getSystemService("audio");
    t.f(true, ((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.h.aHD().aHf()).mProcessName);
    ac.ab(R.raw.class);
    ac.setPackageName("com.tencent.mm.boot");
    ac.a(((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.h.aHD().aHf()).Zw, ((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.h.aHD().aHf()).Zw.getResources());
    XWalkEnvironment.setForceDarkMode(ar.isDarkMode());
    if (MMApplicationContext.isAppBrandProcess()) {
      a.a.a(new com.tencent.mm.l.a()
      {
        public final boolean aaJ()
        {
          AppMethodBeat.i(160132);
          com.tencent.mm.xwebutil.c.a(WebView.c.aabm);
          boolean bool = com.tencent.mm.xwebutil.c.ikm();
          AppMethodBeat.o(160132);
          return bool;
        }
      });
    }
    XWalkEnvironment.setForceDarkBehavior(XWalkEnvironment.ForceDarkBehavior.MEDIA_QUERY_ONLY);
    com.tencent.mm.picker.c.a.mBV = new com.tencent.mm.l.b();
    com.tencent.e.i locali = com.tencent.e.h.ZvG;
    Runnable local2 = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(160137);
        if (!com.tencent.mm.kernel.h.aHH().kdc.kdw)
        {
          Log.e("MicroMsg.DefaultBootStep", "Kernel has not startup done!");
          try
          {
            com.tencent.mm.rabbiteye.a.hpL();
            AppMethodBeat.o(160137);
            return;
          }
          catch (Throwable localThrowable)
          {
            Log.e("MicroMsg.DefaultBootStep", "printTrace error, message = %s", new Object[] { localThrowable.getMessage() });
          }
        }
        AppMethodBeat.o(160137);
      }
    };
    if (MMApplicationContext.isMainProcess()) {}
    for (long l = 180000L;; l = 360000L)
    {
      locali.o(local2, l);
      AppMethodBeat.o(160119);
      return;
    }
  }
  
  public void aav()
  {
    AppMethodBeat.i(160120);
    if ((!BuildInfo.IS_ARM64) && (Build.VERSION.SDK_INT >= 30))
    {
      Log.i("MicroMsg.DefaultBootStep", "origin retain = %s", new Object[] { Boolean.valueOf(JeCtl.setRetain(true)) });
      Log.i("MicroMsg.DefaultBootStep", "now retain = %s", new Object[] { Boolean.valueOf(JeCtl.setRetain(true)) });
    }
    com.tencent.mm.kernel.h.aHC().kcs = com.tencent.mm.plugin.zero.a.d.class;
    ak(PluginZero.class);
    ak(PluginMessengerFoundation.class);
    ak(PluginReport.class);
    ak(PluginAuth.class);
    ak(PluginBigBallOfMud.class);
    ak(PluginRecovery.class);
    MW("com.tencent.mm.plugin.bbom.PluginCompatOldStructure");
    MW("com.tencent.mm.plugin.bbom.PluginBigBallOfMudAsync");
    MW("com.tencent.mm.plugin.avatar.PluginAvatar");
    MW("com.tencent.mm.plugin.image.PluginImageBase");
    MW("com.tencent.mm.plugin.comm.PluginComm");
    MW("com.tencent.mm.plugin.audio.PluginVoice");
    MW("com.tencent.mm.plugin.biz.PluginBiz");
    MX("com.tencent.mm.plugin.bizui.PluginBIZUI");
    MW("com.tencent.mm.plugin.brandservice.PluginBrandService");
    MW("com.tencent.mm.plugin.readerapp.PluginReaderApp");
    MW("com.tencent.mm.plugin.notification.PluginNotification");
    MW("com.tencent.mm.plugin.messenger.PluginMessenger");
    MW("com.tencent.mm.plugin.notification.PluginPNotification");
    MW("com.tencent.mm.plugin.welab.PluginWelab");
    MW("com.tencent.mm.plugin.sport.PluginSport");
    MW("com.tencent.mm.plugin.fts.PluginFTS");
    MW("com.tencent.mm.plugin.multitask.PluginMultiTask");
    MW("com.tencent.mm.plugin.taskbar.PluginTaskBar");
    MW("com.tencent.mm.plugin.updater.PluginUpdater");
    MW("com.tencent.mm.openim.PluginOpenIM");
    MX("com.tencent.mm.plugin.misc.PluginMisc");
    MW("com.tencent.mm.openim.room.PluginOpenIMRoom");
    MW("com.tencent.mm.roomsdk.PluginRoomSdk");
    MW("com.tencent.mm.ipcinvoker.wx_extension.PluginIPC");
    MW("com.tencent.mm.plugin.abtest.PluginABTest");
    MW("com.tencent.mm.plugin.hook.PluginHook");
    MW("com.tencent.mm.plugin.sensitive_api_check.Plugin");
    MW("com.tencent.mm.plugin.expt.PluginExpt");
    MW("com.tencent.mm.plugin.ai.PluginAi");
    MW("com.tencent.mm.plugin.backup.PluginBackup");
    MW("com.tencent.mm.pluginsdk.model.app.PluginAppMsg");
    MW("com.tencent.mm.plugin.hardcoder.PluginHardcoder");
    MW("com.tencent.mm.plugin.teenmode.PluginTeenMode");
    MX("com.tencent.mm.plugin.secdata.PluginSecData");
    MX("com.tencent.mm.plugin.repairer.PluginRepairer");
    MX("com.tencent.mm.plugin.performance.PluginPerformance");
    MX("com.tencent.mm.plugin.chatroom.PluginChatroom");
    MX("com.tencent.mm.PluginFunctionMsg");
    MX("com.tencent.mm.insane_statistic.PluginInsaneStatistic");
    MX("com.tencent.mm.plugin.appbrand.app.PluginAppBrand");
    MX("com.tencent.mm.plugin.handoff.PluginHandOff");
    MX("com.tencent.mm.plugin.choosemsgfile.PluginChooseMsgFile");
    MX("com.tencent.mm.plugin.ball.PluginBall");
    MX("com.tencent.mm.plugin.uishow.PluginUIShow");
    MX("com.tencent.mm.plugin.emoji.PluginEmoji");
    MX("com.tencent.mm.plugin.eggspring.PluginEggSpring");
    MX("com.tencent.mm.chatroom.plugin.PluginChatroomUI");
    MX("com.tencent.mm.plugin.patmsg.PluginPatMsg");
    MX("com.tencent.mm.plugin.game.PluginGame");
    MX("com.tencent.mm.game.report.PluginGameReport");
    MX("com.tencent.mm.plugin.wepkg.PluginWePkg");
    MX("com.tencent.mm.plugin.game.commlib.PluginCommLib");
    MX("com.tencent.mm.plugin.gamelife.PluginGameLife");
    MX("com.tencent.mm.plugin.game.chatroom.PluginGameChatRoom");
    MX("com.tencent.mm.plugin.recordvideo.PluginVideoEditor");
    MX("com.tencent.mm.plugin.video.PluginVideo");
    MX("com.tencent.mm.plugin.hardwareopt.PluginHardwareOpt");
    MX("com.tencent.mm.plugin.sns.PluginSns");
    MX("com.tencent.mm.plugin.downloader.PluginDownloader");
    MX("com.tencent.mm.plugin.fav.PluginFav");
    MX("com.tencent.mm.plugin.fav.ui.PluginFavUI");
    MX("com.tencent.mm.plugin.record.PluginRecord");
    MX("com.tencent.mm.plugin.music.PluginMusic");
    MX("com.tencent.mm.plugin.MMPhotoEditPlugin");
    MX("com.tencent.mm.plugin.account.PluginAccount");
    Object localObject = com.tencent.mm.plugin.recordvideo.background.c.b.HIz;
    MX(b.a.getCLASS());
    MX("com.tencent.mm.plugin.facedetect.PluginFace");
    MX("com.tencent.mm.plugin.soter.PluginSoter");
    MX("com.tencent.mm.plugin.walletlock.PluginWalletLock");
    MX("com.tencent.mm.plugin.wxpay.PluginWxPay");
    MX("com.tencent.mm.plugin.wxpaysdk.PluginWxPaySdk");
    MX("com.tencent.mm.plugin.wxpayapi.PluginWxPayApi");
    MX("com.tencent.kinda.framework.PluginWxKindaApi");
    MX("com.tencent.mm.plugin.festival.PluginFestival");
    if (BuildInfo.ENABLE_PAYTEST) {
      MX("com.tencent.mm.plugin.paytest.api.PluginPayTestHeaderApi");
    }
    MX("com.tencent.mm.plugin.radar.PluginRadar");
    MX("com.tencent.mm.plugin.topstory.PluginTopStory");
    MX("com.tencent.mm.plugin.topstory.ui.PluginTopStoryUI");
    MX("com.tencent.mm.plugin.websearch.PluginWebSearch");
    MX("com.tencent.mm.plugin.textstatus.PluginTextStatus");
    MX("com.tencent.mm.plugin.fts.ui.PluginFTSUI");
    MX("com.tencent.mm.plugin.card.PluginCard");
    MX("com.tencent.mm.plugin.card.compat.PluginCardCompat");
    MX("com.tencent.mm.plugin.forcenotify.PluginForceNotify");
    MX("com.tencent.mm.plugin.monitor.PluginMonitor");
    MW("com.tencent.mm.plugin.expansions.PluginExpansions");
    MX("com.tencent.mm.plugin.fcm.PluginFCM");
    MX("com.tencent.mm.plugin.emojicapture.model.PluginEmojiCapture");
    MX("com.tencent.mm.plugin.selectcontact.PluginSelectContact");
    MX("com.tencent.mm.plugin.cloudvoip.cloudvoice.PluginCloudVoice");
    MX("com.tencent.mm.plugin.webview.PluginWebView");
    MX("com.tencent.mm.plugin.priority.PluginPriority");
    MX("com.tencent.mm.plugin.qqmail.PluginQQMail");
    MX("com.tencent.mm.plugin.scanner.PluginScanTranslation");
    MX("com.tencent.mm.plugin.scanner.PluginScanner");
    MX("com.tencent.mm.plugin.newtips.PluginNewTips");
    MX("com.tencent.mm.plugin.groupsolitaire.PluginGroupSolitaire");
    MX("com.tencent.mm.plugin.groupcollect.PluginGroupCollect");
    MX("com.tencent.mm.plugin.editor.PluginEditor");
    MX("com.tencent.mm.plugin.fav.offline.PluginFavOffline");
    MX("com.tencent.mm.plugin.msgquote.PluginMsgQuote");
    MX("com.tencent.mm.plugin.selectrecord.PluginSelectRecord");
    MX("com.tencent.mm.contact.PluginContact");
    MX("com.tencent.mm.plugin.kidswatch.PluginKidsWatch");
    MX("com.tencent.mm.plugin.hld.PluginHld");
    MX("com.tencent.mm.plugin.mv.PluginMv");
    MX("com.tencent.mm.plugin.finder.live.PluginFinderLive");
    MX("com.tencent.mm.plugin.finder.nearby.PluginFinderNearby");
    MX("com.tencent.mm.plugin.finder.nearby.live.square.PluginFinderLiveSquare");
    MX("com.tencent.mm.plugin.recordvideo.appcamera.PluginMMSight");
    MX("com.tencent.mm.plugin.secinforeport.PluginSecInfoReport");
    MX("com.tencent.mm.plugin.multimediareport.PluginMultiMediaReport");
    MX("com.tencent.mm.plugin.normsg.PluginNormsg");
    MX("com.tencent.mm.plugin.netmock.PluginNetMock");
    MX("com.tencent.kinda.debug.PluginKindaReload");
    MX("com.tencent.mm.plugin.rubbishbin.PluginRubbishbin");
    if (BuildInfo.ext.getBoolean("ENABLE_STETHO")) {
      MX("com.tencent.mm.plugin.stetho.PluginStetho");
    }
    MX("com.tencent.mm.plugin.notifymessage.PluginNotifyMessage");
    MX("com.tencent.mm.plugin.boots.PluginBoots");
    MX("com.tencent.mm.plugin.downloader_app.PluginDownloaderApp");
    MX("com.tencent.mm.plugin.game.luggage.PluginLuggageGame");
    MX("com.tencent.mm.plugin.trafficmonitor.PluginTrafficMonitor");
    MX("com.tencent.mm.plugin.story.PluginStory");
    MX("com.tencent.mm.plugin.finder.PluginFinder");
    MX("com.tencent.mm.plugin.byp.PluginByp");
    MX("com.tencent.mm.plugin.thumbplayer.PluginThumbPlayer");
    MX("com.tencent.mm.plugin.audio.PluginAudio");
    MX("com.tencent.mm.plugin.crashfix.PluginSystemCrashFix");
    MX("com.tencent.mm.plugin.flutter.PluginFlutter");
    MX("com.tencent.mm.plugin.box.PluginBox");
    MX("com.tencent.mm.plugin.lite.PluginLiteApp");
    MX("com.tencent.mm.plugin.mobile.verify.PluginMobileVerify");
    MX("com.tencent.mm.gpu.PluginGpuRes");
    MX("com.tencent.mm.live.PluginLive");
    MX("com.tencent.mm.plugin.gamelive.PluginGameLive");
    MX(PluginCast.class.getCanonicalName());
    MX(PluginVideoRes.class.getCanonicalName());
    MX("com.tencent.mm.wlogcat.PluginLogcat");
    MX("com.tencent.mm.plugin.emoji.magicemoji.PluginMagicEmoji");
    MX("com.tencent.mm.plugin.emoji.magicemoji.PluginMagicEmoji");
    localObject = com.tencent.mm.kernel.a.c.aHV().kdO;
    com.tencent.mm.kernel.b.a locala = com.tencent.mm.kernel.h.ag(v.class);
    ((com.tencent.mm.kernel.a.b.g)localObject).kfd.put(com.tencent.mm.kernel.api.c.class, locala);
    AppMethodBeat.o(160120);
  }
  
  public final void b(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(160123);
    k localk;
    if (((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.h.aHD().aHf()).aIE()) {
      localk = this.fcs;
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
        if (this.fct) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.app.i
 * JD-Core Version:    0.7.0.1
 */