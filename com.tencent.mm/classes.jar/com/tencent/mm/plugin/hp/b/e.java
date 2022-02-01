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
import android.support.v4.app.s.c;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.ag;
import com.tencent.mm.app.ag.a;
import com.tencent.mm.modelmulti.m.a;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.downloader.model.g.a;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.hp.a.a.1;
import com.tencent.mm.protocal.protobuf.eht;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.vfs.s;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.SharePatchInfo;
import com.tencent.tinker.loader.shareutil.ShareSecurityCheck;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import java.io.File;
import java.util.Map;

public final class e
  implements com.tencent.mm.plugin.downloader.model.m
{
  final com.tencent.mm.plugin.hp.d.b ymE;
  private long ymF;
  
  public e(com.tencent.mm.plugin.hp.d.b paramb)
  {
    AppMethodBeat.i(117424);
    this.ymE = paramb;
    f.cBv();
    com.tencent.mm.plugin.downloader.model.c.a(this);
    AppMethodBeat.o(117424);
  }
  
  private void dZb()
  {
    AppMethodBeat.i(117427);
    MMApplicationContext.getContext();
    com.tencent.mm.plugin.hp.d.d.dZA();
    com.tencent.mm.plugin.hp.d.d.dZB();
    g.a locala = new g.a();
    locala.alj(this.ymE.pkK);
    locala.all(this.ymE.cri);
    locala.setFileMD5(this.ymE.pkL);
    locala.kS(false);
    locala.kU(true);
    locala.Fl(2);
    locala.kT(false);
    this.ymF = f.cBv().a(locala.qIY);
    Log.i("Tinker.SyncResponseProcessor", "Download task id is :%d", new Object[] { Long.valueOf(this.ymF) });
    com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(614L, 2L, 1L, false);
    if (NetStatusUtil.isWifi(MMApplicationContext.getContext())) {
      com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(614L, 7L, 1L, false);
    }
    for (;;)
    {
      if ((this.ymE.pkI.intValue() == 2) && (!Util.isNullOrNil(this.ymE.clientVersion))) {
        com.tencent.mm.plugin.hp.tinker.b.ii(com.tencent.mm.loader.j.a.CLIENT_VERSION, this.ymE.clientVersion).dZi();
      }
      if (this.ymE.pkI.intValue() == 3)
      {
        com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(614L, 56L, 1L, false);
        Log.d("Tinker.SyncResponseProcessor", "boots download start silent.");
      }
      AppMethodBeat.o(117427);
      return;
      com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(614L, 8L, 1L, false);
    }
  }
  
  public final void Bd(long paramLong)
  {
    AppMethodBeat.i(117431);
    Log.i("Tinker.SyncResponseProcessor", "onTaskRemoved taskId:%d", new Object[] { Long.valueOf(paramLong) });
    f.cBv();
    com.tencent.mm.plugin.downloader.model.c.b(this);
    AppMethodBeat.o(117431);
  }
  
  public final void Be(long paramLong)
  {
    AppMethodBeat.i(117432);
    Log.d("Tinker.SyncResponseProcessor", "onTaskPaused taskId:%d", new Object[] { Long.valueOf(paramLong) });
    AppMethodBeat.o(117432);
  }
  
  public final void Bf(long paramLong) {}
  
  public final void a(long paramLong1, String paramString, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(196771);
    Log.d("Tinker.SyncResponseProcessor", "onTaskProgressChanged taskId:%d", new Object[] { Long.valueOf(paramLong1) });
    AppMethodBeat.o(196771);
  }
  
  public final void b(long paramLong, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(117430);
    Log.w("Tinker.SyncResponseProcessor", "onTaskFailed");
    if (this.ymF != paramLong)
    {
      Log.i("Tinker.SyncResponseProcessor", "onTaskFailed ignore. id is no equal. download id :%s callback id:%s", new Object[] { Long.valueOf(this.ymF), Long.valueOf(paramLong) });
      AppMethodBeat.o(117430);
      return;
    }
    b.OQ(2);
    if (this.ymE.pkI.intValue() == 3) {
      com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(614L, 51L, 1L, false);
    }
    f.cBv();
    com.tencent.mm.plugin.downloader.model.c.b(this);
    AppMethodBeat.o(117430);
  }
  
  public final void b(long paramLong, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(117429);
    Log.i("Tinker.SyncResponseProcessor", "onTaskFinished id:%d path:%s hasChangeUrl:%s", new Object[] { Long.valueOf(paramLong), paramString, Boolean.valueOf(paramBoolean) });
    if (this.ymF != paramLong)
    {
      Log.i("Tinker.SyncResponseProcessor", "onTaskFinished ignore. id is no equal. download id :%s callback id:%s", new Object[] { Long.valueOf(this.ymF), Long.valueOf(paramLong) });
      AppMethodBeat.o(117429);
      return;
    }
    b.OP(2);
    Context localContext = MMApplicationContext.getContext();
    Object localObject2 = new File(s.k(paramString, false));
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
        com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(614L, 39L, 1L, false);
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
      switch (this.ymE.pkI.intValue())
      {
      }
    }
    if ((this.ymE.pkI.intValue() == 2) && (!paramBoolean))
    {
      Log.i("Tinker.SyncResponseProcessor", "verify patch signature failed.");
      b.OQ(2);
      com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(614L, 31L, 1L, false);
      if (this.ymE.pkI.intValue() == 3)
      {
        com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(614L, 54L, 1L, false);
        Log.d("Tinker.SyncResponseProcessor", "boots download patch md5 no equal.");
      }
      f.cBv();
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
      com.tencent.mm.plugin.hp.tinker.h.aX(localContext, this.ymE.clientVersion);
      com.tencent.mm.plugin.hp.tinker.h.aW(localContext, com.tencent.mm.plugin.hp.d.b.a(this.ymE.ynu, 2));
      break;
      Log.i("Tinker.SyncResponseProcessor", "onReceiveUpgradePatch. try to start apply");
      if (!MMApplicationContext.isToolsIsolatedProcess()) {
        if (CrashReportFactory.isOnlinePatchBlocked())
        {
          Log.w("Tinker.SyncResponseProcessor", "[tomys] patch applying is blocked by assist.");
        }
        else if (!ag.a.dmC.WN())
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
            paramString = com.tencent.mm.plugin.hp.tinker.b.ii(com.tencent.mm.loader.j.a.CLIENT_VERSION, paramString);
            paramString.dZk();
            paramString.dZj();
          }
          for (;;)
          {
            com.tencent.tinker.lib.e.c.cY(localContext, ((File)localObject2).getAbsolutePath());
            break;
            label549:
            Log.e("Tinker.SyncResponseProcessor", "[-] Fail to get patch clientversion.");
          }
          paramString = ((File)localObject2).getAbsolutePath();
          localObject1 = this.ymE;
          Log.i("MicroMsg.Tinker.CTinkerInstaller", "onReceiveUpgradeBsDiff bsDiffPath:%s , new apk md5：%s", new Object[] { paramString, ((com.tencent.mm.plugin.hp.d.b)localObject1).ynv });
          localObject2 = com.tencent.mm.plugin.hp.d.d.aBN(((com.tencent.mm.plugin.hp.d.b)localObject1).ynv);
          com.tencent.mm.kernel.g.aAk().postToWorker(new a.1((String)localObject2, localContext, paramString, (com.tencent.mm.plugin.hp.d.b)localObject1));
          continue;
          Log.i("Tinker.SyncResponseProcessor", "coming soon! now can not support full apk update.");
        }
      }
    }
  }
  
  final void dZa()
  {
    AppMethodBeat.i(117426);
    if (!com.tencent.mm.compatible.util.g.getExternalStorageState().equals("mounted"))
    {
      Log.e("Tinker.SyncResponseProcessor", "no sdcard.");
      com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(614L, 50L, 1L, false);
      AppMethodBeat.o(117426);
      return;
    }
    if (!com.tencent.mm.compatible.util.e.yV(this.ymE.fileSize))
    {
      Log.e("Tinker.SyncResponseProcessor", "sdcard is full.");
      com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(614L, 51L, 1L, false);
      if (this.ymE.pkI.intValue() == 3) {
        com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(614L, 55L, 1L, false);
      }
      AppMethodBeat.o(117426);
      return;
    }
    Context localContext;
    String str;
    if ((this.ymE.pkI.intValue() == 3) && (!Util.isNullOrNil(this.ymE.ynv)) && (s.YS(com.tencent.mm.plugin.hp.d.d.aBN(this.ymE.ynv))) && (com.tencent.mm.d.a.fP(com.tencent.mm.plugin.hp.d.d.aBN(this.ymE.ynv))))
    {
      localContext = MMApplicationContext.getContext();
      if (Util.isNullOrNil(this.ymE.dZv())) {
        str = localContext.getString(2131766934);
      }
    }
    for (;;)
    {
      eht localeht = new eht();
      localeht.cri = this.ymE.cri;
      localeht.title = localContext.getString(2131760888);
      localeht.Nhk = localContext.getString(2131761788);
      localeht.xWM = localContext.getString(2131766915);
      localeht.ynv = this.ymE.ynv;
      localeht.ynw = this.ymE.ynw;
      localeht.nJK = this.ymE.fileSize;
      localeht.pkK = this.ymE.pkK;
      localeht.patchMd5 = this.ymE.pkL;
      localeht.versionCode = this.ymE.versionCode;
      localeht.Nhj = com.tencent.mm.plugin.hp.d.d.aBN(this.ymE.ynv);
      try
      {
        localeht.Nhl = com.tencent.mm.plugin.hp.d.d.aBM(this.ymE.clientVersion);
        label348:
        localeht.msg = str;
        com.tencent.mm.plugin.hp.d.d.a(localeht);
        Log.i("Tinker.SyncResponseProcessor", "file is exist. need no to download. newApkMd5:%s", new Object[] { this.ymE.ynv });
        AppMethodBeat.o(117426);
        return;
        str = this.ymE.dZv();
        continue;
        this.ymE.pkI.intValue();
        dZb();
        AppMethodBeat.o(117426);
        return;
      }
      catch (Exception localException)
      {
        break label348;
      }
    }
  }
  
  public final void k(long paramLong, String paramString)
  {
    AppMethodBeat.i(117428);
    Log.d("Tinker.SyncResponseProcessor", "onTaskStarted taskId %d", new Object[] { Long.valueOf(paramLong) });
    AppMethodBeat.o(117428);
  }
  
  public final void l(long paramLong, String paramString)
  {
    AppMethodBeat.i(117434);
    Log.d("Tinker.SyncResponseProcessor", "onTaskResumed taskId:%d filePath:%s", new Object[] { Long.valueOf(paramLong), paramString });
    AppMethodBeat.o(117434);
  }
  
  public final boolean qk(boolean paramBoolean)
  {
    AppMethodBeat.i(117425);
    Log.i("Tinker.SyncResponseProcessor", "process tinker response: %s", new Object[] { this.ymE.toString() });
    Object localObject1 = com.tencent.mm.util.c.QYz;
    if (Util.getInt(com.tencent.mm.util.c.axY(com.tencent.mm.util.c.np("updater", "closeAutoTinkerPatch")), 0) == 1) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(117425);
      return false;
    }
    if (!this.ymE.dZw())
    {
      Log.i("Tinker.SyncResponseProcessor", "process check response fail, just return");
      AppMethodBeat.o(117425);
      return false;
    }
    if (this.ymE.dZx())
    {
      localObject3 = MMApplicationContext.getContext();
      localObject1 = com.tencent.tinker.lib.e.a.lk((Context)localObject3);
      if (!((com.tencent.tinker.lib.e.a)localObject1).Ska) {
        Log.w("Tinker.SyncResponseProcessor", "SyncResponseProcessor: onPatchRollback, tinker is not loaded, just return");
      }
      for (;;)
      {
        AppMethodBeat.o(117425);
        return true;
        Log.i("Tinker.SyncResponseProcessor", "tinker wait screen to clean patch and kill all process");
        new com.tencent.mm.modelmulti.m(MMApplicationContext.getContext(), new m.a()
        {
          public final void fH(boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(117423);
            if (!paramAnonymousBoolean)
            {
              Log.i("Tinker.SyncResponseProcessor", "app is background now, i can kill quietly");
              ShareTinkerInternals.killAllOtherProcess(this.val$context);
              this.ymH.dZn();
              com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(Process.myPid(), new com.tencent.mm.hellhoundlib.b.a());
              Object localObject = new Object();
              com.tencent.mm.hellhoundlib.a.a.a(localObject, locala.axQ(), "com/tencent/mm/plugin/hp/model/SyncResponseProcessor$3", "onScreenStateChange", "(Z)V", "android/os/Process_EXEC_", "killProcess", "(I)V");
              Process.killProcess(((Integer)locala.pG(0)).intValue());
              com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/hp/model/SyncResponseProcessor$3", "onScreenStateChange", "(Z)V", "android/os/Process_EXEC_", "killProcess", "(I)V");
            }
            AppMethodBeat.o(117423);
          }
        });
        localObject3 = new SharePatchInfo(((com.tencent.tinker.lib.e.a)localObject1).SjZ.Ske, "00000000000000000000000000000000", false, true, Build.FINGERPRINT, "odex", false);
        SharePatchInfo.rewritePatchInfoFileWithLock(((com.tencent.tinker.lib.e.a)localObject1).SjW, (SharePatchInfo)localObject3, ((com.tencent.tinker.lib.e.a)localObject1).SjX);
      }
    }
    if (!this.ymE.dZt())
    {
      AppMethodBeat.o(117425);
      return true;
    }
    if (this.ymE.dZy())
    {
      Log.w("Tinker.SyncResponseProcessor", "is lower version skip.");
      com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(614L, 78L, 1L, false);
      AppMethodBeat.o(117425);
      return true;
    }
    if (MMApplicationContext.isMainProcess()) {
      try
      {
        i = Integer.decode(com.tencent.mm.loader.j.a.CLIENT_VERSION).intValue();
        if ((i >= 654316032) && (i <= 654316287) && ("vivo".equalsIgnoreCase(Build.MANUFACTURER)) && (Build.VERSION.SDK_INT == 29) && (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.snh, 0) == 0))
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
    if ((this.ymE.pkI.intValue() == 3) && (!Util.isNullOrNil(this.ymE.clientVersion)) && (com.tencent.mm.plugin.hp.d.c.aBK(this.ymE.clientVersion)))
    {
      com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(614L, 77L, 1L, false);
      localObject4 = this.ymE;
      Context localContext = MMApplicationContext.getContext();
      if (Util.isNullOrNil(((com.tencent.mm.plugin.hp.d.b)localObject4).ynx))
      {
        localObject2 = localContext.getString(2131755960);
        if (!Util.isNullOrNil(((com.tencent.mm.plugin.hp.d.b)localObject4).yny)) {
          break label732;
        }
        localObject3 = "";
        label498:
        if (!Util.isNullOrNil(((com.tencent.mm.plugin.hp.d.b)localObject4).ynz)) {
          break label742;
        }
        localObject4 = "http://" + WeChatHosts.domainString(2131761742) + "/cgi-bin/mmsupport-bin/readtemplate?t=page/android_exp__index";
        label539:
        Intent localIntent = new Intent("android.intent.action.VIEW");
        localIntent.setClassName(MMApplicationContext.getPackageName(), MMApplicationContext.getSourcePackageName() + ".plugin.webview.ui.tools.WebViewUI");
        localIntent.putExtra("rawUrl", (String)localObject4);
        localIntent.putExtra("useJs", true);
        localIntent.putExtra("vertical_scroll", true);
        localIntent.setFlags(872415232);
        localObject4 = PendingIntent.getActivity(localContext, 0, localIntent, 268435456);
        localObject2 = com.tencent.mm.bq.a.cd(localContext, "reminder_channel_id").i(null).i(System.currentTimeMillis()).f((CharSequence)localObject2).g((CharSequence)localObject3);
        ((s.c)localObject2).Hv = ((PendingIntent)localObject4);
        ((s.c)localObject2).as(com.tencent.mm.bq.a.ezb());
        localObject2 = ((s.c)localObject2).build();
        ((Notification)localObject2).flags |= 0x10;
        if (!paramBoolean) {
          break label752;
        }
        ((NotificationManager)localContext.getSystemService("notification")).notify(19841110, (Notification)localObject2);
      }
      for (;;)
      {
        AppMethodBeat.o(117425);
        return true;
        localObject2 = ((com.tencent.mm.plugin.hp.d.b)localObject4).ynx;
        break;
        label732:
        localObject3 = ((com.tencent.mm.plugin.hp.d.b)localObject4).yny;
        break label498;
        label742:
        localObject4 = ((com.tencent.mm.plugin.hp.d.b)localObject4).ynz;
        break label539;
        label752:
        Log.i("Tinker.SyncResponseProcessor", "ignore action when load from cache,when response is alpha version");
      }
    }
    Log.i("Tinker.SyncResponseProcessor", "check need show before download. network type:%d msg:%s clientversion:%s", new Object[] { this.ymE.pkJ, this.ymE.dZv(), this.ymE.clientVersion });
    Object localObject3 = MMApplicationContext.getContext();
    if ((this.ymE.pkJ.intValue() == 2) && (NetStatusUtil.isMobile(MMApplicationContext.getContext())) && (this.ymE.dZu())) {
      if (!com.tencent.mm.plugin.hp.tinker.h.aU((Context)localObject3, this.ymE.cri)) {
        if (this.ymE.pkI.intValue() == 2)
        {
          localObject2 = MMApplicationContext.getContext().getString(2131760890, new Object[] { this.ymE.dZv(), MMApplicationContext.getContext().getString(2131766923), Util.getSizeKB(this.ymE.fileSize) });
          i.a(MMApplicationContext.getContext().getString(2131760888), (String)localObject2, MMApplicationContext.getContext().getString(2131766927), new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(117421);
              if (e.this.ymE.dZs()) {
                e.this.dZa();
              }
              AppMethodBeat.o(117421);
            }
          }, MMApplicationContext.getContext().getString(2131766915), new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(117422);
              com.tencent.mm.plugin.hp.tinker.h.aV(this.val$context, e.this.ymE.cri);
              AppMethodBeat.o(117422);
            }
          });
        }
      }
    }
    for (;;)
    {
      a.OO(4);
      label975:
      AppMethodBeat.o(117425);
      return true;
      if (this.ymE.pkI.intValue() != 3) {
        continue;
      }
      Log.i("Tinker.SyncResponseProcessor", "showUpdateDialog ");
      if (Util.isNullOrNil(this.ymE.dZv()))
      {
        localObject2 = ((Context)localObject3).getString(2131766934);
        label1027:
        localObject4 = new eht();
        ((eht)localObject4).cri = this.ymE.cri;
        ((eht)localObject4).title = ((Context)localObject3).getString(2131760888);
        ((eht)localObject4).Nhk = ((Context)localObject3).getString(2131766927);
        ((eht)localObject4).xWM = ((Context)localObject3).getString(2131766915);
        ((eht)localObject4).ynv = this.ymE.ynv;
        ((eht)localObject4).ynw = this.ymE.ynw;
        ((eht)localObject4).nJK = this.ymE.fileSize;
        ((eht)localObject4).pkK = this.ymE.pkK;
        ((eht)localObject4).patchMd5 = this.ymE.pkL;
        ((eht)localObject4).versionCode = this.ymE.versionCode;
        ((eht)localObject4).Nhj = com.tencent.mm.plugin.hp.d.d.aBN(this.ymE.ynv);
      }
      try
      {
        ((eht)localObject4).Nhl = com.tencent.mm.plugin.hp.d.d.aBM(this.ymE.clientVersion);
        label1189:
        ((eht)localObject4).msg = ((String)localObject2);
        com.tencent.mm.plugin.hp.d.d.a((eht)localObject4);
        continue;
        localObject2 = this.ymE.dZv();
        break label1027;
        com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(614L, 44L, 1L, false);
        Log.i("Tinker.SyncResponseProcessor", "this patch id :%s show cancel before user, need show again.", new Object[] { this.ymE.cri });
        break label975;
        if ((!this.ymE.dZs()) || (com.tencent.mm.plugin.hp.tinker.h.aU((Context)localObject3, this.ymE.cri))) {
          break label975;
        }
        dZa();
      }
      catch (Exception localException)
      {
        break label1189;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.hp.b.e
 * JD-Core Version:    0.7.0.1
 */