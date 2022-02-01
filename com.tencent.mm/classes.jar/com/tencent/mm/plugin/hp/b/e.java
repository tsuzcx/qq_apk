package com.tencent.mm.plugin.hp.b;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Process;
import android.text.TextUtils;
import androidx.core.app.e.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.ai;
import com.tencent.mm.app.ai.a;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.modelmulti.m.a;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.downloader.model.g.a;
import com.tencent.mm.plugin.hp.a.a.1;
import com.tencent.mm.protocal.protobuf.erv;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.vfs.u;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.SharePatchInfo;
import com.tencent.tinker.loader.shareutil.ShareSecurityCheck;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import java.io.File;
import java.util.Map;

public final class e
  implements com.tencent.mm.plugin.downloader.model.m
{
  final com.tencent.mm.plugin.hp.d.b DMG;
  private long DMH;
  
  public e(com.tencent.mm.plugin.hp.d.b paramb)
  {
    AppMethodBeat.i(117424);
    this.DMG = paramb;
    f.cPZ();
    com.tencent.mm.plugin.downloader.model.c.a(this);
    AppMethodBeat.o(117424);
  }
  
  private void eHY()
  {
    AppMethodBeat.i(117427);
    MMApplicationContext.getContext();
    com.tencent.mm.plugin.hp.d.d.eIx();
    com.tencent.mm.plugin.hp.d.d.eIy();
    g.a locala = new g.a();
    locala.atc(this.DMG.smT);
    locala.ate(this.DMG.coY);
    locala.setFileMD5(this.DMG.smU);
    locala.me(false);
    locala.mg(true);
    locala.IS(2);
    locala.mf(false);
    this.DMH = f.cPZ().a(locala.uhY);
    Log.i("Tinker.SyncResponseProcessor", "Download task id is :%d", new Object[] { Long.valueOf(this.DMH) });
    com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(614L, 2L, 1L, false);
    if (NetStatusUtil.isWifi(MMApplicationContext.getContext())) {
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(614L, 7L, 1L, false);
    }
    for (;;)
    {
      if ((this.DMG.smR.intValue() == 2) && (!Util.isNullOrNil(this.DMG.clientVersion))) {
        com.tencent.mm.plugin.hp.tinker.b.iv(com.tencent.mm.loader.j.a.CLIENT_VERSION, this.DMG.clientVersion).eIf();
      }
      if (this.DMG.smR.intValue() == 3)
      {
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(614L, 56L, 1L, false);
        Log.d("Tinker.SyncResponseProcessor", "boots download start silent.");
      }
      AppMethodBeat.o(117427);
      return;
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(614L, 8L, 1L, false);
    }
  }
  
  public final void Hp(long paramLong)
  {
    AppMethodBeat.i(117431);
    Log.i("Tinker.SyncResponseProcessor", "onTaskRemoved taskId:%d", new Object[] { Long.valueOf(paramLong) });
    f.cPZ();
    com.tencent.mm.plugin.downloader.model.c.b(this);
    AppMethodBeat.o(117431);
  }
  
  public final void Hq(long paramLong)
  {
    AppMethodBeat.i(117432);
    Log.d("Tinker.SyncResponseProcessor", "onTaskPaused taskId:%d", new Object[] { Long.valueOf(paramLong) });
    AppMethodBeat.o(117432);
  }
  
  public final void Hr(long paramLong) {}
  
  public final void a(long paramLong1, String paramString, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(195340);
    Log.d("Tinker.SyncResponseProcessor", "onTaskProgressChanged taskId:%d", new Object[] { Long.valueOf(paramLong1) });
    AppMethodBeat.o(195340);
  }
  
  public final void b(long paramLong, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(117430);
    Log.w("Tinker.SyncResponseProcessor", "onTaskFailed");
    if (this.DMH != paramLong)
    {
      Log.i("Tinker.SyncResponseProcessor", "onTaskFailed ignore. id is no equal. download id :%s callback id:%s", new Object[] { Long.valueOf(this.DMH), Long.valueOf(paramLong) });
      AppMethodBeat.o(117430);
      return;
    }
    b.UY(2);
    if (this.DMG.smR.intValue() == 3) {
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(614L, 51L, 1L, false);
    }
    f.cPZ();
    com.tencent.mm.plugin.downloader.model.c.b(this);
    AppMethodBeat.o(117430);
  }
  
  public final void b(long paramLong, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(117429);
    Log.i("Tinker.SyncResponseProcessor", "onTaskFinished id:%d path:%s hasChangeUrl:%s", new Object[] { Long.valueOf(paramLong), paramString, Boolean.valueOf(paramBoolean) });
    if (this.DMH != paramLong)
    {
      Log.i("Tinker.SyncResponseProcessor", "onTaskFinished ignore. id is no equal. download id :%s callback id:%s", new Object[] { Long.valueOf(this.DMH), Long.valueOf(paramLong) });
      AppMethodBeat.o(117429);
      return;
    }
    b.UX(2);
    Context localContext = MMApplicationContext.getContext();
    Object localObject2 = new File(u.n(paramString, false));
    ShareSecurityCheck localShareSecurityCheck = new ShareSecurityCheck(localContext);
    paramBoolean = false;
    try
    {
      boolean bool = localShareSecurityCheck.verifyPatchMetaSignature((File)localObject2);
      paramBoolean = bool;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        Log.printErrStackTrace("Tinker.SyncResponseProcessor", paramString, "verify patch signature failed.", new Object[0]);
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(614L, 39L, 1L, false);
      }
      paramString = localContext.getApplicationInfo();
      if (paramString != null) {
        break label334;
      }
      paramString = null;
      while (paramString != null)
      {
        paramString = paramString.listFiles();
        if (paramString == null) {
          break;
        }
        localObject1 = ((File)localObject2).getName();
        j = paramString.length;
        i = 0;
        while (i < j)
        {
          localFile = paramString[i];
          if (!localFile.getName().equals(localObject1)) {
            SharePatchFileUtil.safeDeleteFile(localFile);
          }
          i += 1;
        }
        label334:
        localObject1 = new File(paramString.dataDir, "tinker_server");
        paramString = (String)localObject1;
        if (!((File)localObject1).exists())
        {
          ((File)localObject1).mkdirs();
          paramString = (String)localObject1;
        }
      }
      switch (this.DMG.smR.intValue())
      {
      }
    }
    if ((this.DMG.smR.intValue() == 2) && (!paramBoolean))
    {
      Log.i("Tinker.SyncResponseProcessor", "verify patch signature failed.");
      b.UY(2);
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(614L, 31L, 1L, false);
      if (this.DMG.smR.intValue() == 3)
      {
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(614L, 54L, 1L, false);
        Log.d("Tinker.SyncResponseProcessor", "boots download patch md5 no equal.");
      }
      f.cPZ();
      com.tencent.mm.plugin.downloader.model.c.b(this);
      AppMethodBeat.o(117429);
      return;
    }
    for (;;)
    {
      Object localObject1;
      int j;
      int i;
      File localFile;
      com.tencent.mm.plugin.hp.tinker.h.bj(localContext, this.DMG.clientVersion);
      com.tencent.mm.plugin.hp.tinker.h.bi(localContext, com.tencent.mm.plugin.hp.d.b.a(this.DMG.DNw, 2));
      break;
      Log.i("Tinker.SyncResponseProcessor", "onReceiveUpgradePatch. try to start apply");
      if (!MMApplicationContext.isToolsIsolatedProcess()) {
        if (CrashReportFactory.isOnlinePatchBlocked())
        {
          Log.w("Tinker.SyncResponseProcessor", "[tomys] patch applying is blocked by assist.");
        }
        else if (!ai.a.feP.abp())
        {
          Log.w("Tinker.SyncResponseProcessor", "patch applying is blocked by TinkerEnsuranceOnFault, update basepack with different clientver to recover.");
        }
        else
        {
          paramString = localShareSecurityCheck.getPackagePropertiesIfPresent();
          if (paramString != null)
          {
            paramString = (String)paramString.get("patch.client.ver");
            if (TextUtils.isEmpty(paramString)) {
              break label549;
            }
            paramString = com.tencent.mm.plugin.hp.tinker.b.iv(com.tencent.mm.loader.j.a.CLIENT_VERSION, paramString);
            paramString.eIh();
            paramString.eIg();
          }
          for (;;)
          {
            com.tencent.tinker.lib.e.c.dj(localContext, ((File)localObject2).getAbsolutePath());
            break;
            label549:
            Log.e("Tinker.SyncResponseProcessor", "[-] Fail to get patch clientversion.");
          }
          paramString = ((File)localObject2).getAbsolutePath();
          localObject1 = this.DMG;
          Log.i("MicroMsg.Tinker.CTinkerInstaller", "onReceiveUpgradeBsDiff bsDiffPath:%s , new apk md5：%s", new Object[] { paramString, ((com.tencent.mm.plugin.hp.d.b)localObject1).DNx });
          localObject2 = com.tencent.mm.plugin.hp.d.d.aLU(((com.tencent.mm.plugin.hp.d.b)localObject1).DNx);
          com.tencent.mm.kernel.h.aHJ().postToWorker(new a.1((String)localObject2, localContext, paramString, (com.tencent.mm.plugin.hp.d.b)localObject1));
          continue;
          Log.i("Tinker.SyncResponseProcessor", "coming soon! now can not support full apk update.");
        }
      }
    }
  }
  
  final void eHX()
  {
    AppMethodBeat.i(117426);
    if (!g.avJ().equals("mounted"))
    {
      Log.e("Tinker.SyncResponseProcessor", "no sdcard.");
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(614L, 50L, 1L, false);
      AppMethodBeat.o(117426);
      return;
    }
    if (!com.tencent.mm.compatible.util.e.EY(this.DMG.fileSize))
    {
      Log.e("Tinker.SyncResponseProcessor", "sdcard is full.");
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(614L, 51L, 1L, false);
      if (this.DMG.smR.intValue() == 3) {
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(614L, 55L, 1L, false);
      }
      AppMethodBeat.o(117426);
      return;
    }
    Context localContext;
    String str;
    if ((this.DMG.smR.intValue() == 3) && (!Util.isNullOrNil(this.DMG.DNx)) && (u.agG(com.tencent.mm.plugin.hp.d.d.aLU(this.DMG.DNx))) && (com.tencent.mm.d.a.gz(com.tencent.mm.plugin.hp.d.d.aLU(this.DMG.DNx))))
    {
      localContext = MMApplicationContext.getContext();
      if (Util.isNullOrNil(this.DMG.eIs())) {
        str = localContext.getString(com.tencent.mm.plugin.boots.b.a.update_tip_recommended_down);
      }
    }
    for (;;)
    {
      erv localerv = new erv();
      localerv.coY = this.DMG.coY;
      localerv.title = localContext.getString(com.tencent.mm.plugin.boots.b.a.fmt_update);
      localerv.UtQ = localContext.getString(com.tencent.mm.plugin.boots.b.a.install_now);
      localerv.DaW = localContext.getString(com.tencent.mm.plugin.boots.b.a.update_cancel);
      localerv.DNx = this.DMG.DNx;
      localerv.DNy = this.DMG.DNy;
      localerv.qLX = this.DMG.fileSize;
      localerv.smT = this.DMG.smT;
      localerv.patchMd5 = this.DMG.smU;
      localerv.versionCode = this.DMG.versionCode;
      localerv.UtP = com.tencent.mm.plugin.hp.d.d.aLU(this.DMG.DNx);
      try
      {
        localerv.UtR = com.tencent.mm.plugin.hp.d.d.aLT(this.DMG.clientVersion);
        label348:
        localerv.msg = str;
        com.tencent.mm.plugin.hp.d.d.a(localerv);
        Log.i("Tinker.SyncResponseProcessor", "file is exist. need no to download. newApkMd5:%s", new Object[] { this.DMG.DNx });
        AppMethodBeat.o(117426);
        return;
        str = this.DMG.eIs();
        continue;
        this.DMG.smR.intValue();
        eHY();
        AppMethodBeat.o(117426);
        return;
      }
      catch (Exception localException)
      {
        break label348;
      }
    }
  }
  
  public final void m(long paramLong, String paramString)
  {
    AppMethodBeat.i(117428);
    Log.d("Tinker.SyncResponseProcessor", "onTaskStarted taskId %d", new Object[] { Long.valueOf(paramLong) });
    AppMethodBeat.o(117428);
  }
  
  public final void n(long paramLong, String paramString)
  {
    AppMethodBeat.i(117434);
    Log.d("Tinker.SyncResponseProcessor", "onTaskResumed taskId:%d filePath:%s", new Object[] { Long.valueOf(paramLong), paramString });
    AppMethodBeat.o(117434);
  }
  
  public final boolean tm(boolean paramBoolean)
  {
    AppMethodBeat.i(117425);
    Log.i("Tinker.SyncResponseProcessor", "process tinker response: %s", new Object[] { this.DMG.toString() });
    Object localObject1 = com.tencent.mm.util.i.YyX;
    if (com.tencent.mm.util.i.a(com.tencent.mm.util.b.a.Yyn, 0) == 1)
    {
      AppMethodBeat.o(117425);
      return false;
    }
    if (!this.DMG.eIt())
    {
      Log.i("Tinker.SyncResponseProcessor", "process check response fail, just return");
      AppMethodBeat.o(117425);
      return false;
    }
    if (this.DMG.eIu())
    {
      localObject3 = MMApplicationContext.getContext();
      localObject1 = com.tencent.tinker.lib.e.a.mi((Context)localObject3);
      if (!((com.tencent.tinker.lib.e.a)localObject1).ZML) {
        Log.w("Tinker.SyncResponseProcessor", "SyncResponseProcessor: onPatchRollback, tinker is not loaded, just return");
      }
      for (;;)
      {
        AppMethodBeat.o(117425);
        return true;
        Log.i("Tinker.SyncResponseProcessor", "tinker wait screen to clean patch and kill all process");
        new com.tencent.mm.modelmulti.m(MMApplicationContext.getContext(), new m.a()
        {
          public final void gt(boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(117423);
            if (!paramAnonymousBoolean)
            {
              Log.i("Tinker.SyncResponseProcessor", "app is background now, i can kill quietly");
              ShareTinkerInternals.killAllOtherProcess(this.val$context);
              this.DMJ.eIk();
              com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(Process.myPid(), new com.tencent.mm.hellhoundlib.b.a());
              Object localObject = new Object();
              com.tencent.mm.hellhoundlib.a.a.b(localObject, locala.aFh(), "com/tencent/mm/plugin/hp/model/SyncResponseProcessor$3", "onScreenStateChange", "(Z)V", "android/os/Process_EXEC_", "killProcess", "(I)V");
              Process.killProcess(((Integer)locala.sf(0)).intValue());
              com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/plugin/hp/model/SyncResponseProcessor$3", "onScreenStateChange", "(Z)V", "android/os/Process_EXEC_", "killProcess", "(I)V");
            }
            AppMethodBeat.o(117423);
          }
        });
        localObject3 = new SharePatchInfo(((com.tencent.tinker.lib.e.a)localObject1).ZMK.ZMP, "00000000000000000000000000000000", false, true, Build.FINGERPRINT, "odex", false);
        SharePatchInfo.rewritePatchInfoFileWithLock(((com.tencent.tinker.lib.e.a)localObject1).ZMH, (SharePatchInfo)localObject3, ((com.tencent.tinker.lib.e.a)localObject1).ZMI);
      }
    }
    if (!this.DMG.eIq())
    {
      AppMethodBeat.o(117425);
      return true;
    }
    if (this.DMG.eIv())
    {
      Log.w("Tinker.SyncResponseProcessor", "is lower version skip.");
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(614L, 78L, 1L, false);
      AppMethodBeat.o(117425);
      return true;
    }
    if (MMApplicationContext.isMainProcess()) {
      try
      {
        int i = Integer.decode(com.tencent.mm.loader.j.a.CLIENT_VERSION).intValue();
        if ((i >= 654316032) && (i <= 654316287) && ("vivo".equalsIgnoreCase(Build.MANUFACTURER)) && (Build.VERSION.SDK_INT == 29) && (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vYj, 0) == 0))
        {
          Log.w("Tinker.SyncResponseProcessor", "[!] [tomys] Patch was blocked due to some compatibility issues.");
          AppMethodBeat.o(117425);
          return true;
        }
      }
      catch (Throwable localThrowable)
      {
        Log.printErrStackTrace("Tinker.SyncResponseProcessor", localThrowable, "[-] [tomys] Error happened in tmp ctrl code.", new Object[0]);
      }
    }
    if (CrashReportFactory.isOnlinePatchBlocked())
    {
      Log.w("Tinker.SyncResponseProcessor", "[tomys] patch downloading is blocked by assist.");
      AppMethodBeat.o(117425);
      return true;
    }
    Object localObject4;
    Object localObject2;
    if ((this.DMG.smR.intValue() == 3) && (!Util.isNullOrNil(this.DMG.clientVersion)) && (com.tencent.mm.plugin.hp.d.c.aLR(this.DMG.clientVersion)))
    {
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(614L, 77L, 1L, false);
      localObject4 = this.DMG;
      Context localContext = MMApplicationContext.getContext();
      if (Util.isNullOrNil(((com.tencent.mm.plugin.hp.d.b)localObject4).DNz))
      {
        localObject2 = localContext.getString(com.tencent.mm.plugin.boots.b.a.app_recommend_update_alpha);
        if (!Util.isNullOrNil(((com.tencent.mm.plugin.hp.d.b)localObject4).DNA)) {
          break label712;
        }
        localObject3 = "";
        label478:
        if (!Util.isNullOrNil(((com.tencent.mm.plugin.hp.d.b)localObject4).DNB)) {
          break label722;
        }
        localObject4 = "http://" + WeChatHosts.domainString(com.tencent.mm.plugin.boots.b.a.host_support_weixin_qq_com) + "/cgi-bin/mmsupport-bin/readtemplate?t=page/android_exp__index";
        label519:
        Intent localIntent = new Intent("android.intent.action.VIEW");
        localIntent.setClassName(MMApplicationContext.getPackageName(), MMApplicationContext.getSourcePackageName() + ".plugin.webview.ui.tools.WebViewUI");
        localIntent.putExtra("rawUrl", (String)localObject4);
        localIntent.putExtra("useJs", true);
        localIntent.putExtra("vertical_scroll", true);
        localIntent.setFlags(872415232);
        localObject4 = PendingIntent.getActivity(localContext, 0, localIntent, 268435456);
        localObject2 = com.tencent.mm.bx.a.cp(localContext, "reminder_channel_id").n(null).e(System.currentTimeMillis()).k((CharSequence)localObject2).l((CharSequence)localObject3);
        ((e.d)localObject2).Ip = ((PendingIntent)localObject4);
        ((e.d)localObject2).bn(com.tencent.mm.bx.a.fkG());
        localObject2 = ((e.d)localObject2).gr();
        ((Notification)localObject2).flags |= 0x10;
        if (!paramBoolean) {
          break label732;
        }
        ((NotificationManager)localContext.getSystemService("notification")).notify(19841110, (Notification)localObject2);
      }
      for (;;)
      {
        AppMethodBeat.o(117425);
        return true;
        localObject2 = ((com.tencent.mm.plugin.hp.d.b)localObject4).DNz;
        break;
        label712:
        localObject3 = ((com.tencent.mm.plugin.hp.d.b)localObject4).DNA;
        break label478;
        label722:
        localObject4 = ((com.tencent.mm.plugin.hp.d.b)localObject4).DNB;
        break label519;
        label732:
        Log.i("Tinker.SyncResponseProcessor", "ignore action when load from cache,when response is alpha version");
      }
    }
    Log.i("Tinker.SyncResponseProcessor", "check need show before download. network type:%d msg:%s clientversion:%s", new Object[] { this.DMG.smS, this.DMG.eIs(), this.DMG.clientVersion });
    Object localObject3 = MMApplicationContext.getContext();
    if ((this.DMG.smS.intValue() == 2) && (NetStatusUtil.isMobile(MMApplicationContext.getContext())) && (this.DMG.eIr())) {
      if (!com.tencent.mm.plugin.hp.tinker.h.bg((Context)localObject3, this.DMG.coY)) {
        if (this.DMG.smR.intValue() == 2)
        {
          localObject2 = MMApplicationContext.getContext().getString(com.tencent.mm.plugin.boots.b.a.fmt_update_info, new Object[] { this.DMG.eIs(), MMApplicationContext.getContext().getString(com.tencent.mm.plugin.boots.b.a.update_increment_tips), Util.getSizeKB(this.DMG.fileSize) });
          i.a(MMApplicationContext.getContext().getString(com.tencent.mm.plugin.boots.b.a.fmt_update), (String)localObject2, MMApplicationContext.getContext().getString(com.tencent.mm.plugin.boots.b.a.update_now), new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(117421);
              if (e.this.DMG.eIp()) {
                e.this.eHX();
              }
              AppMethodBeat.o(117421);
            }
          }, MMApplicationContext.getContext().getString(com.tencent.mm.plugin.boots.b.a.update_cancel), new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(117422);
              com.tencent.mm.plugin.hp.tinker.h.bh(this.val$context, e.this.DMG.coY);
              AppMethodBeat.o(117422);
            }
          });
        }
      }
    }
    for (;;)
    {
      a.UW(4);
      label955:
      AppMethodBeat.o(117425);
      return true;
      if (this.DMG.smR.intValue() != 3) {
        continue;
      }
      Log.i("Tinker.SyncResponseProcessor", "showUpdateDialog ");
      if (Util.isNullOrNil(this.DMG.eIs()))
      {
        localObject2 = ((Context)localObject3).getString(com.tencent.mm.plugin.boots.b.a.update_tip_recommended_down);
        label1007:
        localObject4 = new erv();
        ((erv)localObject4).coY = this.DMG.coY;
        ((erv)localObject4).title = ((Context)localObject3).getString(com.tencent.mm.plugin.boots.b.a.fmt_update);
        ((erv)localObject4).UtQ = ((Context)localObject3).getString(com.tencent.mm.plugin.boots.b.a.update_now);
        ((erv)localObject4).DaW = ((Context)localObject3).getString(com.tencent.mm.plugin.boots.b.a.update_cancel);
        ((erv)localObject4).DNx = this.DMG.DNx;
        ((erv)localObject4).DNy = this.DMG.DNy;
        ((erv)localObject4).qLX = this.DMG.fileSize;
        ((erv)localObject4).smT = this.DMG.smT;
        ((erv)localObject4).patchMd5 = this.DMG.smU;
        ((erv)localObject4).versionCode = this.DMG.versionCode;
        ((erv)localObject4).UtP = com.tencent.mm.plugin.hp.d.d.aLU(this.DMG.DNx);
      }
      try
      {
        ((erv)localObject4).UtR = com.tencent.mm.plugin.hp.d.d.aLT(this.DMG.clientVersion);
        label1169:
        ((erv)localObject4).msg = ((String)localObject2);
        com.tencent.mm.plugin.hp.d.d.a((erv)localObject4);
        continue;
        localObject2 = this.DMG.eIs();
        break label1007;
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(614L, 44L, 1L, false);
        Log.i("Tinker.SyncResponseProcessor", "this patch id :%s show cancel before user, need show again.", new Object[] { this.DMG.coY });
        break label955;
        if ((!this.DMG.eIp()) || (com.tencent.mm.plugin.hp.tinker.h.bg((Context)localObject3, this.DMG.coY))) {
          break label955;
        }
        eHX();
      }
      catch (Exception localException)
      {
        break label1169;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.hp.b.e
 * JD-Core Version:    0.7.0.1
 */