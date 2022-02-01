package com.tencent.mm.plugin.hp.model;

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
import androidx.core.app.f.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.am;
import com.tencent.mm.app.am.a;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.modelmulti.r;
import com.tencent.mm.modelmulti.r.a;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.downloader.model.g.a;
import com.tencent.mm.plugin.downloader.model.m;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.hp.a.a.1;
import com.tencent.mm.protocal.protobuf.fne;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.util.i;
import com.tencent.mm.vfs.y;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.SharePatchInfo;
import com.tencent.tinker.loader.shareutil.ShareSecurityCheck;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import java.io.File;
import java.util.Map;

public final class e
  implements m
{
  final com.tencent.mm.plugin.hp.b.b JDU;
  private long JDV;
  
  public e(com.tencent.mm.plugin.hp.b.b paramb)
  {
    AppMethodBeat.i(117424);
    this.JDU = paramb;
    f.duv();
    com.tencent.mm.plugin.downloader.model.c.a(this);
    AppMethodBeat.o(117424);
  }
  
  private static void a(com.tencent.mm.plugin.hp.b.b paramb, boolean paramBoolean)
  {
    AppMethodBeat.i(261867);
    Context localContext = MMApplicationContext.getContext();
    Object localObject;
    String str;
    if (Util.isNullOrNil(paramb.JEN))
    {
      localObject = localContext.getString(com.tencent.mm.plugin.boots.b.a.app_recommend_update_alpha);
      if (!Util.isNullOrNil(paramb.JEO)) {
        break label255;
      }
      str = "";
      label42:
      if (!Util.isNullOrNil(paramb.JEP)) {
        break label263;
      }
    }
    label263:
    for (paramb = "http://" + WeChatHosts.domainString(com.tencent.mm.plugin.boots.b.a.host_support_weixin_qq_com) + "/cgi-bin/mmsupport-bin/readtemplate?t=page/android_exp__index";; paramb = paramb.JEP)
    {
      Intent localIntent = new Intent("android.intent.action.VIEW");
      localIntent.setClassName(MMApplicationContext.getPackageName(), MMApplicationContext.getSourcePackageName() + ".plugin.webview.ui.tools.WebViewUI");
      localIntent.putExtra("rawUrl", paramb);
      localIntent.putExtra("useJs", true);
      localIntent.putExtra("vertical_scroll", true);
      localIntent.setFlags(872415232);
      paramb = PendingIntent.getActivity(localContext, 0, localIntent, 268435456);
      localObject = com.tencent.mm.bq.a.cA(localContext, "reminder_channel_id").o(null).bt(System.currentTimeMillis()).l((CharSequence)localObject).m(str);
      ((f.d)localObject).bor = paramb;
      ((f.d)localObject).eb(com.tencent.mm.bq.a.guX());
      paramb = ((f.d)localObject).DA();
      paramb.flags |= 0x10;
      if (!paramBoolean) {
        break label271;
      }
      ((NotificationManager)localContext.getSystemService("notification")).notify(19841110, paramb);
      AppMethodBeat.o(261867);
      return;
      localObject = paramb.JEN;
      break;
      label255:
      str = paramb.JEO;
      break label42;
    }
    label271:
    Log.i("Tinker.SyncResponseProcessor", "ignore action when load from cache,when response is alpha version");
    AppMethodBeat.o(261867);
  }
  
  private void fPR()
  {
    AppMethodBeat.i(117427);
    MMApplicationContext.getContext();
    com.tencent.mm.plugin.hp.b.d.fQt();
    com.tencent.mm.plugin.hp.b.d.fQu();
    g.a locala = new g.a();
    locala.amR(this.JDU.mOI);
    locala.amT(this.JDU.egJ);
    locala.setFileMD5(this.JDU.vyS);
    locala.nA(false);
    locala.nC(true);
    locala.JA(2);
    locala.nB(false);
    this.JDV = f.duv().a(locala.xoe);
    Log.i("Tinker.SyncResponseProcessor", "Download task id is :%d", new Object[] { Long.valueOf(this.JDV) });
    com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(614L, 2L, 1L, false);
    if (NetStatusUtil.isWifi(MMApplicationContext.getContext())) {
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(614L, 7L, 1L, false);
    }
    for (;;)
    {
      if ((this.JDU.vyQ.intValue() == 2) && (!Util.isNullOrNil(this.JDU.clientVersion))) {
        com.tencent.mm.plugin.hp.tinker.b.jF(com.tencent.mm.loader.i.a.CLIENT_VERSION, this.JDU.clientVersion).fPY();
      }
      if (this.JDU.vyQ.intValue() == 3)
      {
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(614L, 56L, 1L, false);
        Log.d("Tinker.SyncResponseProcessor", "boots bsdiff download start silent.");
      }
      if (this.JDU.vyQ.intValue() == 4)
      {
        com.tencent.mm.plugin.hp.a.c.t(124, -100, 0L);
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(614L, 124L, 1L, false);
        Log.d("Tinker.SyncResponseProcessor", "boots hdiff download start silent.");
      }
      AppMethodBeat.o(117427);
      return;
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(614L, 8L, 1L, false);
    }
  }
  
  public final void a(long paramLong1, String paramString, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(261882);
    Log.d("Tinker.SyncResponseProcessor", "onTaskProgressChanged taskId:%d", new Object[] { Long.valueOf(paramLong1) });
    AppMethodBeat.o(261882);
  }
  
  public final void b(long paramLong, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(117429);
    Log.i("Tinker.SyncResponseProcessor", "onTaskFinished id:%d path:%s hasChangeUrl:%s", new Object[] { Long.valueOf(paramLong), paramString, Boolean.valueOf(paramBoolean) });
    if (this.JDV != paramLong)
    {
      Log.i("Tinker.SyncResponseProcessor", "onTaskFinished ignore. id is no equal. download id :%s callback id:%s", new Object[] { Long.valueOf(this.JDV), Long.valueOf(paramLong) });
      AppMethodBeat.o(117429);
      return;
    }
    c.YS(2);
    Context localContext = MMApplicationContext.getContext();
    File localFile1 = new File(y.n(paramString, false));
    ShareSecurityCheck localShareSecurityCheck = new ShareSecurityCheck(localContext);
    boolean bool = false;
    paramBoolean = bool;
    if (this.JDU.vyQ.intValue() != 4) {}
    Object localObject;
    try
    {
      paramBoolean = localShareSecurityCheck.verifyPatchMetaSignature(localFile1);
      if ((this.JDU.vyQ.intValue() == 2) && (!paramBoolean))
      {
        Log.i("Tinker.SyncResponseProcessor", "verify patch signature failed.");
        c.YT(2);
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(614L, 31L, 1L, false);
        if (this.JDU.vyQ.intValue() == 3)
        {
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(614L, 54L, 1L, false);
          Log.d("Tinker.SyncResponseProcessor", "boots download patch md5 no equal.");
        }
        f.duv();
        com.tencent.mm.plugin.downloader.model.c.b(this);
        AppMethodBeat.o(117429);
        return;
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        Log.printErrStackTrace("Tinker.SyncResponseProcessor", paramString, "verify patch signature failed.", new Object[0]);
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(614L, 39L, 1L, false);
        paramBoolean = bool;
      }
      paramString = localContext.getApplicationInfo();
      if (paramString == null) {
        paramString = null;
      }
      while (paramString != null)
      {
        paramString = paramString.listFiles();
        if (paramString == null) {
          break;
        }
        localObject = localFile1.getName();
        int j = paramString.length;
        int i = 0;
        while (i < j)
        {
          File localFile2 = paramString[i];
          if (!localFile2.getName().equals(localObject)) {
            SharePatchFileUtil.safeDeleteFile(localFile2);
          }
          i += 1;
        }
        localObject = new File(paramString.dataDir, "tinker_server");
        paramString = (String)localObject;
        if (!((File)localObject).exists())
        {
          ((File)localObject).mkdirs();
          paramString = (String)localObject;
        }
      }
      switch (this.JDU.vyQ.intValue())
      {
      }
    }
    for (;;)
    {
      com.tencent.mm.plugin.hp.tinker.h.bl(localContext, this.JDU.clientVersion);
      com.tencent.mm.plugin.hp.tinker.h.bk(localContext, com.tencent.mm.plugin.hp.b.b.a(this.JDU.JEK, 2));
      break;
      Log.i("Tinker.SyncResponseProcessor", "onReceiveUpgradePatch. try to start apply");
      if (!MMApplicationContext.isToolsIsolatedProcess()) {
        if (CrashReportFactory.isOnlinePatchBlocked())
        {
          Log.w("Tinker.SyncResponseProcessor", "[tomys] patch applying is blocked by assist.");
        }
        else if (!am.a.hiV.aDh())
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
              break label577;
            }
            paramString = com.tencent.mm.plugin.hp.tinker.b.jF(com.tencent.mm.loader.i.a.CLIENT_VERSION, paramString);
            paramString.fQa();
            paramString.fPZ();
          }
          for (;;)
          {
            com.tencent.tinker.lib.e.c.ds(localContext, localFile1.getAbsolutePath());
            break;
            label577:
            Log.e("Tinker.SyncResponseProcessor", "[-] Fail to get patch clientversion.");
          }
          paramString = localFile1.getAbsolutePath();
          localObject = this.JDU;
          if (4 == ((com.tencent.mm.plugin.hp.b.b)localObject).vyQ.intValue())
          {
            paramBoolean = true;
            label615:
            if (3 != ((com.tencent.mm.plugin.hp.b.b)localObject).vyQ.intValue()) {
              break label695;
            }
          }
          label695:
          for (bool = true;; bool = false)
          {
            Log.i("MicroMsg.Tinker.CTinkerInstaller", "onReceiveUpgradeDiff HdiffApk， patchPath:%s , new apk md5：%s, TinkerSyncResponse = %s.", new Object[] { paramString, ((com.tencent.mm.plugin.hp.b.b)localObject).JEL, ((com.tencent.mm.plugin.hp.b.b)localObject).toString() });
            com.tencent.mm.kernel.h.baH().postToWorker(new a.1((com.tencent.mm.plugin.hp.b.b)localObject, paramBoolean, localContext, paramString, bool));
            break;
            paramBoolean = false;
            break label615;
          }
          Log.i("Tinker.SyncResponseProcessor", "coming soon! now can not support full apk update.");
        }
      }
    }
  }
  
  public final void c(long paramLong, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(117430);
    Log.w("Tinker.SyncResponseProcessor", "onTaskFailed");
    if (this.JDV != paramLong)
    {
      Log.i("Tinker.SyncResponseProcessor", "onTaskFailed ignore. id is no equal. download id :%s callback id:%s", new Object[] { Long.valueOf(this.JDV), Long.valueOf(paramLong) });
      AppMethodBeat.o(117430);
      return;
    }
    c.YT(2);
    if (this.JDU.vyQ.intValue() == 3) {
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(614L, 51L, 1L, false);
    }
    for (;;)
    {
      f.duv();
      com.tencent.mm.plugin.downloader.model.c.b(this);
      AppMethodBeat.o(117430);
      return;
      if (this.JDU.vyQ.intValue() == 4)
      {
        Log.i("Tinker.SyncResponseProcessor", "HdiffApk, onTaskFailed taskId:%d", new Object[] { Long.valueOf(paramLong) });
        com.tencent.mm.plugin.hp.a.c.t(126, -100, 0L);
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(614L, 126L, 1L, false);
      }
    }
  }
  
  final void fPQ()
  {
    AppMethodBeat.i(117426);
    if (!g.aQd().equals("mounted"))
    {
      Log.e("Tinker.SyncResponseProcessor", "no sdcard.");
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(614L, 50L, 1L, false);
      AppMethodBeat.o(117426);
      return;
    }
    if (!com.tencent.mm.compatible.util.e.hq(this.JDU.fileSize))
    {
      Log.e("Tinker.SyncResponseProcessor", "sdcard is full.");
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(614L, 51L, 1L, false);
      if ((this.JDU.vyQ.intValue() == 3) || (this.JDU.vyQ.intValue() == 4)) {
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(614L, 55L, 1L, false);
      }
      AppMethodBeat.o(117426);
      return;
    }
    Context localContext;
    String str1;
    if (((this.JDU.vyQ.intValue() == 3) || (this.JDU.vyQ.intValue() == 4)) && (!Util.isNullOrNil(this.JDU.JEL)) && (y.ZC(com.tencent.mm.plugin.hp.b.d.aIO(this.JDU.JEL))) && (com.tencent.mm.d.a.hZ(com.tencent.mm.plugin.hp.b.d.aIO(this.JDU.JEL))))
    {
      localContext = MMApplicationContext.getContext();
      if (Util.isNullOrNil(this.JDU.fQl())) {
        str1 = localContext.getString(com.tencent.mm.plugin.boots.b.a.update_tip_recommended_down);
      }
    }
    for (;;)
    {
      if (this.JDU.vyQ.intValue() == 4)
      {
        b.a(this.JDU);
        localObject = this.JDU.JEL;
        String str2 = com.tencent.mm.plugin.hp.b.d.aIO((String)localObject);
        this.JDU.JEL = y.bub(str2);
        this.JDU.JEM = ((String)localObject);
      }
      Object localObject = new fne();
      ((fne)localObject).egJ = this.JDU.egJ;
      ((fne)localObject).title = localContext.getString(com.tencent.mm.plugin.boots.b.a.fmt_update);
      ((fne)localObject).abNm = localContext.getString(com.tencent.mm.plugin.boots.b.a.install_now);
      ((fne)localObject).IVk = localContext.getString(com.tencent.mm.plugin.boots.b.a.update_cancel);
      ((fne)localObject).JEL = this.JDU.JEL;
      ((fne)localObject).JEM = this.JDU.JEM;
      ((fne)localObject).tQE = this.JDU.fileSize;
      ((fne)localObject).mOI = this.JDU.mOI;
      ((fne)localObject).patchMd5 = this.JDU.vyS;
      ((fne)localObject).hDq = this.JDU.vyQ.intValue();
      ((fne)localObject).versionCode = this.JDU.versionCode;
      ((fne)localObject).abNl = com.tencent.mm.plugin.hp.b.d.aIO(this.JDU.JEL);
      try
      {
        ((fne)localObject).abNn = com.tencent.mm.plugin.hp.b.d.aIN(this.JDU.clientVersion);
        label445:
        ((fne)localObject).msg = str1;
        com.tencent.mm.plugin.hp.b.d.a((fne)localObject);
        Log.i("Tinker.SyncResponseProcessor", "HdiffApk, file is exist. need no to download. newApkMd5:%s", new Object[] { this.JDU.JEL });
        AppMethodBeat.o(117426);
        return;
        str1 = this.JDU.fQl();
        continue;
        this.JDU.vyQ.intValue();
        fPR();
        AppMethodBeat.o(117426);
        return;
      }
      catch (Exception localException)
      {
        break label445;
      }
    }
  }
  
  public final void jF(long paramLong)
  {
    AppMethodBeat.i(117431);
    Log.i("Tinker.SyncResponseProcessor", "onTaskRemoved taskId:%d", new Object[] { Long.valueOf(paramLong) });
    f.duv();
    com.tencent.mm.plugin.downloader.model.c.b(this);
    if ((this.JDU != null) && (this.JDU.vyQ.intValue() == 4))
    {
      Log.i("Tinker.SyncResponseProcessor", "HdiffApk, onTaskRemoved taskId:%d", new Object[] { Long.valueOf(paramLong) });
      com.tencent.mm.plugin.hp.a.c.t(127, -100, 0L);
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(614L, 127L, 1L, false);
    }
    AppMethodBeat.o(117431);
  }
  
  public final void jG(long paramLong)
  {
    AppMethodBeat.i(117432);
    Log.d("Tinker.SyncResponseProcessor", "onTaskPaused taskId:%d", new Object[] { Long.valueOf(paramLong) });
    AppMethodBeat.o(117432);
  }
  
  public final void jH(long paramLong) {}
  
  public final void v(long paramLong, String paramString)
  {
    AppMethodBeat.i(117428);
    Log.d("Tinker.SyncResponseProcessor", "onTaskStarted taskId %d", new Object[] { Long.valueOf(paramLong) });
    AppMethodBeat.o(117428);
  }
  
  public final void w(long paramLong, String paramString)
  {
    AppMethodBeat.i(117434);
    Log.d("Tinker.SyncResponseProcessor", "onTaskResumed taskId:%d filePath:%s", new Object[] { Long.valueOf(paramLong), paramString });
    AppMethodBeat.o(117434);
  }
  
  public final boolean xx(boolean paramBoolean)
  {
    AppMethodBeat.i(117425);
    Log.i("Tinker.SyncResponseProcessor", "process tinker response: %s", new Object[] { this.JDU.toString() });
    Object localObject1 = i.agtt;
    if (i.a(com.tencent.mm.util.b.a.agrM, 0) == 1)
    {
      AppMethodBeat.o(117425);
      return false;
    }
    if (!this.JDU.fQm())
    {
      Log.i("Tinker.SyncResponseProcessor", "process check response fail, just return");
      AppMethodBeat.o(117425);
      return false;
    }
    if (this.JDU.fQn())
    {
      localObject2 = MMApplicationContext.getContext();
      localObject1 = com.tencent.tinker.lib.e.a.oy((Context)localObject2);
      if (!((com.tencent.tinker.lib.e.a)localObject1).ahRN) {
        Log.w("Tinker.SyncResponseProcessor", "SyncResponseProcessor: onPatchRollback, tinker is not loaded, just return");
      }
      for (;;)
      {
        AppMethodBeat.o(117425);
        return true;
        Log.i("Tinker.SyncResponseProcessor", "tinker wait screen to clean patch and kill all process");
        new r(MMApplicationContext.getContext(), new r.a()
        {
          public final void onScreenStateChange(boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(117423);
            if (!paramAnonymousBoolean)
            {
              Log.i("Tinker.SyncResponseProcessor", "app is background now, i can kill quietly");
              ShareTinkerInternals.killAllOtherProcess(this.val$context);
              this.JDX.fQd();
              com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(Process.myPid(), new com.tencent.mm.hellhoundlib.b.a());
              Object localObject = new Object();
              com.tencent.mm.hellhoundlib.a.a.b(localObject, locala.aYi(), "com/tencent/mm/plugin/hp/model/SyncResponseProcessor$3", "onScreenStateChange", "(Z)V", "android/os/Process_EXEC_", "killProcess", "(I)V");
              Process.killProcess(((Integer)locala.sb(0)).intValue());
              com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/plugin/hp/model/SyncResponseProcessor$3", "onScreenStateChange", "(Z)V", "android/os/Process_EXEC_", "killProcess", "(I)V");
            }
            AppMethodBeat.o(117423);
          }
        });
        localObject2 = new SharePatchInfo(((com.tencent.tinker.lib.e.a)localObject1).ahRM.ahRR, "00000000000000000000000000000000", false, true, Build.FINGERPRINT, "odex", false);
        SharePatchInfo.rewritePatchInfoFileWithLock(((com.tencent.tinker.lib.e.a)localObject1).ahRJ, (SharePatchInfo)localObject2, ((com.tencent.tinker.lib.e.a)localObject1).ahRK);
      }
    }
    if (!this.JDU.fQj())
    {
      AppMethodBeat.o(117425);
      return true;
    }
    if (this.JDU.fQo())
    {
      Log.w("Tinker.SyncResponseProcessor", "is lower version skip.");
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(614L, 78L, 1L, false);
      AppMethodBeat.o(117425);
      return true;
    }
    if (MMApplicationContext.isMainProcess()) {
      try
      {
        int i = Integer.decode(com.tencent.mm.loader.i.a.CLIENT_VERSION).intValue();
        if ((i >= 654316032) && (i <= 654316287) && ("vivo".equalsIgnoreCase(Build.MANUFACTURER)) && (Build.VERSION.SDK_INT == 29) && (((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zqZ, 0) == 0))
        {
          Log.w("Tinker.SyncResponseProcessor", "[!] [tomys] Patch was blocked due to some compatibility issues.");
          AppMethodBeat.o(117425);
          return true;
        }
      }
      finally
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
    if ((this.JDU.vyQ.intValue() == 3) && (!Util.isNullOrNil(this.JDU.clientVersion)) && (com.tencent.mm.plugin.hp.b.c.aIL(this.JDU.clientVersion)))
    {
      Log.i("Tinker.SyncResponseProcessor", "auto,hdiff alpha package");
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(614L, 77L, 1L, false);
      a(this.JDU, paramBoolean);
      AppMethodBeat.o(117425);
      return true;
    }
    if ((!com.tencent.mm.plugin.hp.a.c.fPI()) && (this.JDU.vyQ.intValue() == 4) && (!Util.isNullOrNil(this.JDU.clientVersion)) && (com.tencent.mm.plugin.hp.b.c.aIL(this.JDU.clientVersion)))
    {
      Log.i("Tinker.SyncResponseProcessor", "HdiffApk,auto,hdiff alpha package");
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(614L, 79L, 1L, false);
      a(this.JDU, paramBoolean);
      AppMethodBeat.o(117425);
      return true;
    }
    Log.i("Tinker.SyncResponseProcessor", "check need show before download. network type:%d msg:%s clientversion:%s", new Object[] { this.JDU.vyR, this.JDU.fQl(), this.JDU.clientVersion });
    Object localObject2 = MMApplicationContext.getContext();
    String str;
    if ((this.JDU.vyR.intValue() == 2) && (NetStatusUtil.isMobile(MMApplicationContext.getContext())) && (this.JDU.fQk())) {
      if (!com.tencent.mm.plugin.hp.tinker.h.bi((Context)localObject2, this.JDU.egJ)) {
        if (this.JDU.vyQ.intValue() == 2)
        {
          str = MMApplicationContext.getContext().getString(com.tencent.mm.plugin.boots.b.a.fmt_update_info, new Object[] { this.JDU.fQl(), MMApplicationContext.getContext().getString(com.tencent.mm.plugin.boots.b.a.update_increment_tips), Util.getSizeKB(this.JDU.fileSize) });
          h.a(MMApplicationContext.getContext().getString(com.tencent.mm.plugin.boots.b.a.fmt_update), str, MMApplicationContext.getContext().getString(com.tencent.mm.plugin.boots.b.a.update_now), new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(117421);
              if (e.this.JDU.fQi()) {
                e.this.fPQ();
              }
              AppMethodBeat.o(117421);
            }
          }, MMApplicationContext.getContext().getString(com.tencent.mm.plugin.boots.b.a.update_cancel), new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(117422);
              com.tencent.mm.plugin.hp.tinker.h.bj(this.val$context, e.this.JDU.egJ);
              AppMethodBeat.o(117422);
            }
          });
        }
      }
    }
    for (;;)
    {
      a.YR(4);
      label751:
      AppMethodBeat.o(117425);
      return true;
      if ((this.JDU.vyQ.intValue() != 3) && (this.JDU.vyQ.intValue() != 4)) {
        continue;
      }
      Log.i("Tinker.SyncResponseProcessor", "showUpdateDialog syncResponse.packageType: %s.", new Object[] { this.JDU.vyQ });
      label831:
      fne localfne;
      if (Util.isNullOrNil(this.JDU.fQl()))
      {
        str = ((Context)localObject2).getString(com.tencent.mm.plugin.boots.b.a.update_tip_recommended_down);
        localfne = new fne();
        localfne.egJ = this.JDU.egJ;
        localfne.title = ((Context)localObject2).getString(com.tencent.mm.plugin.boots.b.a.fmt_update);
        localfne.abNm = ((Context)localObject2).getString(com.tencent.mm.plugin.boots.b.a.update_now);
        localfne.IVk = ((Context)localObject2).getString(com.tencent.mm.plugin.boots.b.a.update_cancel);
        localfne.JEL = this.JDU.JEL;
        localfne.JEM = this.JDU.JEM;
        localfne.tQE = this.JDU.fileSize;
        localfne.mOI = this.JDU.mOI;
        localfne.patchMd5 = this.JDU.vyS;
        localfne.hDq = this.JDU.vyQ.intValue();
        localfne.versionCode = this.JDU.versionCode;
        localfne.abNl = com.tencent.mm.plugin.hp.b.d.aIO(this.JDU.JEL);
      }
      try
      {
        localfne.abNn = com.tencent.mm.plugin.hp.b.d.aIN(this.JDU.clientVersion);
        label1008:
        localfne.msg = str;
        com.tencent.mm.plugin.hp.b.d.a(localfne);
        continue;
        str = this.JDU.fQl();
        break label831;
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(614L, 44L, 1L, false);
        Log.i("Tinker.SyncResponseProcessor", "this patch id :%s show cancel before user, need show again.", new Object[] { this.JDU.egJ });
        break label751;
        if ((!this.JDU.fQi()) || (com.tencent.mm.plugin.hp.tinker.h.bi((Context)localObject2, this.JDU.egJ))) {
          break label751;
        }
        fPQ();
      }
      catch (Exception localException)
      {
        break label1008;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.hp.model.e
 * JD-Core Version:    0.7.0.1
 */