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
import com.tencent.mm.plugin.hp.tinker.h;
import com.tencent.mm.protocal.protobuf.dna;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.SharePatchInfo;
import com.tencent.tinker.loader.shareutil.ShareSecurityCheck;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import java.io.File;
import java.util.Map;

public final class e
  implements com.tencent.mm.plugin.downloader.model.m
{
  final com.tencent.mm.plugin.hp.d.b uIq;
  private long uIr;
  
  public e(com.tencent.mm.plugin.hp.d.b paramb)
  {
    AppMethodBeat.i(117424);
    this.uIq = paramb;
    f.ccl();
    com.tencent.mm.plugin.downloader.model.c.a(this);
    AppMethodBeat.o(117424);
  }
  
  private void dcp()
  {
    AppMethodBeat.i(117427);
    aj.getContext();
    com.tencent.mm.plugin.hp.d.d.dcO();
    com.tencent.mm.plugin.hp.d.d.dcP();
    g.a locala = new g.a();
    locala.aak(this.uIq.gHx);
    locala.aam(this.uIq.nUh);
    locala.aan(this.uIq.nUg);
    locala.jQ(false);
    locala.jS(true);
    locala.Bp(2);
    locala.jR(false);
    this.uIr = f.ccl().a(locala.pmN);
    ad.i("Tinker.SyncResponseProcessor", "Download task id is :%d", new Object[] { Long.valueOf(this.uIr) });
    com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(614L, 2L, 1L, false);
    if (ay.isWifi(aj.getContext())) {
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(614L, 7L, 1L, false);
    }
    for (;;)
    {
      if ((this.uIq.nUe.intValue() == 2) && (!bt.isNullOrNil(this.uIq.clientVersion))) {
        com.tencent.mm.plugin.hp.tinker.b.ht(com.tencent.mm.loader.j.a.hgG, this.uIq.clientVersion).dcw();
      }
      if (this.uIq.nUe.intValue() == 3)
      {
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(614L, 56L, 1L, false);
        ad.d("Tinker.SyncResponseProcessor", "boots download start silent.");
      }
      AppMethodBeat.o(117427);
      return;
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(614L, 8L, 1L, false);
    }
  }
  
  public final void a(long paramLong, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(117430);
    ad.w("Tinker.SyncResponseProcessor", "onTaskFailed");
    if (this.uIr != paramLong)
    {
      ad.i("Tinker.SyncResponseProcessor", "onTaskFailed ignore. id is no equal. download id :%s callback id:%s", new Object[] { Long.valueOf(this.uIr), Long.valueOf(paramLong) });
      AppMethodBeat.o(117430);
      return;
    }
    b.Ip(2);
    if (this.uIq.nUe.intValue() == 3) {
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(614L, 51L, 1L, false);
    }
    f.ccl();
    com.tencent.mm.plugin.downloader.model.c.b(this);
    AppMethodBeat.o(117430);
  }
  
  public final void a(long paramLong1, String paramString, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(218896);
    ad.d("Tinker.SyncResponseProcessor", "onTaskProgressChanged taskId:%d", new Object[] { Long.valueOf(paramLong1) });
    AppMethodBeat.o(218896);
  }
  
  public final void b(long paramLong, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(117429);
    ad.i("Tinker.SyncResponseProcessor", "onTaskFinished id:%d path:%s hasChangeUrl:%s", new Object[] { Long.valueOf(paramLong), paramString, Boolean.valueOf(paramBoolean) });
    if (this.uIr != paramLong)
    {
      ad.i("Tinker.SyncResponseProcessor", "onTaskFinished ignore. id is no equal. download id :%s callback id:%s", new Object[] { Long.valueOf(this.uIr), Long.valueOf(paramLong) });
      AppMethodBeat.o(117429);
      return;
    }
    b.Io(2);
    Context localContext = aj.getContext();
    Object localObject2 = new File(paramString);
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
        ad.printErrStackTrace("Tinker.SyncResponseProcessor", paramString, "verify patch signature failed.", new Object[0]);
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(614L, 39L, 1L, false);
      }
      paramString = localContext.getApplicationInfo();
      if (paramString != null) {
        break label327;
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
        label327:
        localObject1 = new File(paramString.dataDir, "tinker_server");
        paramString = (String)localObject1;
        if (!((File)localObject1).exists())
        {
          ((File)localObject1).mkdirs();
          paramString = (String)localObject1;
        }
      }
      switch (this.uIq.nUe.intValue())
      {
      }
    }
    if ((this.uIq.nUe.intValue() == 2) && (!paramBoolean))
    {
      ad.i("Tinker.SyncResponseProcessor", "verify patch signature failed.");
      b.Ip(2);
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(614L, 31L, 1L, false);
      if (this.uIq.nUe.intValue() == 3)
      {
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(614L, 54L, 1L, false);
        ad.d("Tinker.SyncResponseProcessor", "boots download patch md5 no equal.");
      }
      f.ccl();
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
      h.aI(localContext, this.uIq.clientVersion);
      h.aH(localContext, com.tencent.mm.plugin.hp.d.b.a(this.uIq.uJg, 2));
      break;
      ad.i("Tinker.SyncResponseProcessor", "onReceiveUpgradePatch. try to start apply");
      if (!aj.fkH()) {
        if (com.tencent.mm.sdk.a.b.fjQ())
        {
          ad.w("Tinker.SyncResponseProcessor", "[tomys] patch applying is blocked by assist.");
        }
        else if (!ag.a.cVi.ME())
        {
          ad.w("Tinker.SyncResponseProcessor", "patch applying is blocked by TinkerEnsuranceOnFault, update basepack with different clientver to recover.");
        }
        else
        {
          paramString = localShareSecurityCheck.getPackagePropertiesIfPresent();
          if (paramString != null)
          {
            paramString = (String)paramString.get("patch.client.ver");
            if (TextUtils.isEmpty(paramString)) {
              break label545;
            }
            paramString = com.tencent.mm.plugin.hp.tinker.b.ht(com.tencent.mm.loader.j.a.hgG, paramString);
            paramString.dcy();
            paramString.dcx();
          }
          for (;;)
          {
            com.tencent.tinker.lib.e.c.cD(localContext, ((File)localObject2).getAbsolutePath());
            break;
            label545:
            ad.e("Tinker.SyncResponseProcessor", "[-] Fail to get patch clientversion.");
          }
          paramString = ((File)localObject2).getAbsolutePath();
          localObject1 = this.uIq;
          ad.i("MicroMsg.Tinker.CTinkerInstaller", "onReceiveUpgradeBsDiff bsDiffPath:%s , new apk md5：%s", new Object[] { paramString, ((com.tencent.mm.plugin.hp.d.b)localObject1).uJh });
          localObject2 = com.tencent.mm.plugin.hp.d.d.anr(((com.tencent.mm.plugin.hp.d.b)localObject1).uJh);
          com.tencent.mm.kernel.g.ajF().ay(new a.1((String)localObject2, localContext, paramString, (com.tencent.mm.plugin.hp.d.b)localObject1));
          continue;
          ad.i("Tinker.SyncResponseProcessor", "coming soon! now can not support full apk update.");
        }
      }
    }
  }
  
  final void dco()
  {
    AppMethodBeat.i(117426);
    if (!com.tencent.mm.compatible.util.g.getExternalStorageState().equals("mounted"))
    {
      ad.e("Tinker.SyncResponseProcessor", "no sdcard.");
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(614L, 50L, 1L, false);
      AppMethodBeat.o(117426);
      return;
    }
    if (!com.tencent.mm.compatible.util.e.qR(this.uIq.fileSize))
    {
      ad.e("Tinker.SyncResponseProcessor", "sdcard is full.");
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(614L, 51L, 1L, false);
      if (this.uIq.nUe.intValue() == 3) {
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(614L, 55L, 1L, false);
      }
      AppMethodBeat.o(117426);
      return;
    }
    Context localContext;
    String str;
    if ((this.uIq.nUe.intValue() == 3) && (!bt.isNullOrNil(this.uIq.uJh)) && (com.tencent.mm.vfs.i.fv(com.tencent.mm.plugin.hp.d.d.anr(this.uIq.uJh))) && (com.tencent.mm.d.a.eW(com.tencent.mm.plugin.hp.d.d.anr(this.uIq.uJh))))
    {
      localContext = aj.getContext();
      if (bt.isNullOrNil(this.uIq.dcJ())) {
        str = localContext.getString(2131764588);
      }
    }
    for (;;)
    {
      dna localdna = new dna();
      localdna.nUh = this.uIq.nUh;
      localdna.title = localContext.getString(2131759571);
      localdna.HBn = localContext.getString(2131760343);
      localdna.utw = localContext.getString(2131764569);
      localdna.uJh = this.uIq.uJh;
      localdna.uJi = this.uIq.uJi;
      localdna.mtM = this.uIq.fileSize;
      localdna.gHx = this.uIq.gHx;
      localdna.patchMd5 = this.uIq.nUg;
      localdna.versionCode = this.uIq.versionCode;
      localdna.HBm = com.tencent.mm.plugin.hp.d.d.anr(this.uIq.uJh);
      try
      {
        localdna.HBo = Integer.parseInt(this.uIq.clientVersion, 16);
        label350:
        localdna.msg = str;
        com.tencent.mm.plugin.hp.d.d.a(localdna);
        ad.i("Tinker.SyncResponseProcessor", "file is exist. need no to download. newApkMd5:%s", new Object[] { this.uIq.uJh });
        AppMethodBeat.o(117426);
        return;
        str = this.uIq.dcJ();
        continue;
        this.uIq.nUe.intValue();
        dcp();
        AppMethodBeat.o(117426);
        return;
      }
      catch (Exception localException)
      {
        break label350;
      }
    }
  }
  
  public final void j(long paramLong, String paramString)
  {
    AppMethodBeat.i(117428);
    ad.d("Tinker.SyncResponseProcessor", "onTaskStarted taskId %d", new Object[] { Long.valueOf(paramLong) });
    AppMethodBeat.o(117428);
  }
  
  public final void k(long paramLong, String paramString)
  {
    AppMethodBeat.i(117434);
    ad.d("Tinker.SyncResponseProcessor", "onTaskResumed taskId:%d filePath:%s", new Object[] { Long.valueOf(paramLong), paramString });
    AppMethodBeat.o(117434);
  }
  
  public final boolean nx(boolean paramBoolean)
  {
    AppMethodBeat.i(117425);
    ad.i("Tinker.SyncResponseProcessor", "process tinker response: %s", new Object[] { this.uIq.toString() });
    if (!this.uIq.dcK())
    {
      ad.i("Tinker.SyncResponseProcessor", "process check response fail, just return");
      AppMethodBeat.o(117425);
      return false;
    }
    if (this.uIq.dcL())
    {
      localObject2 = aj.getContext();
      final com.tencent.tinker.lib.e.a locala = com.tencent.tinker.lib.e.a.lk((Context)localObject2);
      if (!locala.Mhb) {
        ad.w("Tinker.SyncResponseProcessor", "SyncResponseProcessor: onPatchRollback, tinker is not loaded, just return");
      }
      for (;;)
      {
        AppMethodBeat.o(117425);
        return true;
        ad.i("Tinker.SyncResponseProcessor", "tinker wait screen to clean patch and kill all process");
        new com.tencent.mm.modelmulti.m(aj.getContext(), new m.a()
        {
          public final void ch(boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(117423);
            if (!paramAnonymousBoolean)
            {
              ad.i("Tinker.SyncResponseProcessor", "app is background now, i can kill quietly");
              ShareTinkerInternals.killAllOtherProcess(this.val$context);
              locala.dcB();
              com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(Process.myPid(), new com.tencent.mm.hellhoundlib.b.a());
              Object localObject = new Object();
              com.tencent.mm.hellhoundlib.a.a.a(localObject, locala.ahp(), "com/tencent/mm/plugin/hp/model/SyncResponseProcessor$3", "onScreenStateChange", "(Z)V", "android/os/Process_EXEC_", "killProcess", "(I)V");
              Process.killProcess(((Integer)locala.mq(0)).intValue());
              com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/hp/model/SyncResponseProcessor$3", "onScreenStateChange", "(Z)V", "android/os/Process_EXEC_", "killProcess", "(I)V");
            }
            AppMethodBeat.o(117423);
          }
        });
        localObject2 = new SharePatchInfo(locala.Mha.Mhf, "00000000000000000000000000000000", false, true, Build.FINGERPRINT, "odex");
        SharePatchInfo.rewritePatchInfoFileWithLock(locala.MgX, (SharePatchInfo)localObject2, locala.MgY);
      }
    }
    if (!this.uIq.dcH())
    {
      AppMethodBeat.o(117425);
      return true;
    }
    if (this.uIq.dcM())
    {
      ad.w("Tinker.SyncResponseProcessor", "is lower version skip.");
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(614L, 78L, 1L, false);
      AppMethodBeat.o(117425);
      return true;
    }
    if (aj.cmR()) {
      try
      {
        int i = Integer.decode(com.tencent.mm.loader.j.a.hgG).intValue();
        if ((i >= 654316032) && (i <= 654316287) && ("vivo".equalsIgnoreCase(Build.MANUFACTURER)) && (Build.VERSION.SDK_INT == 29) && (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.CZo, 0) == 0))
        {
          ad.w("Tinker.SyncResponseProcessor", "[!] [tomys] Patch was blocked due to some compatibility issues.");
          AppMethodBeat.o(117425);
          return true;
        }
      }
      catch (Throwable localThrowable)
      {
        ad.printErrStackTrace("Tinker.SyncResponseProcessor", localThrowable, "[-] [tomys] Error happened in tmp ctrl code.", new Object[0]);
      }
    }
    if (com.tencent.mm.sdk.a.b.fjQ())
    {
      ad.w("Tinker.SyncResponseProcessor", "[tomys] patch downloading is blocked by assist.");
      AppMethodBeat.o(117425);
      return true;
    }
    Object localObject3;
    Object localObject1;
    if ((this.uIq.nUe.intValue() == 3) && (!bt.isNullOrNil(this.uIq.clientVersion)) && (com.tencent.mm.plugin.hp.d.c.anp(this.uIq.clientVersion)))
    {
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(614L, 77L, 1L, false);
      localObject3 = this.uIq;
      Context localContext = aj.getContext();
      if (bt.isNullOrNil(((com.tencent.mm.plugin.hp.d.b)localObject3).uJj))
      {
        localObject1 = localContext.getString(2131755871);
        if (!bt.isNullOrNil(((com.tencent.mm.plugin.hp.d.b)localObject3).uJk)) {
          break label663;
        }
        localObject2 = "";
        label454:
        if (!bt.isNullOrNil(((com.tencent.mm.plugin.hp.d.b)localObject3).uJl)) {
          break label673;
        }
        localObject3 = "http://support.weixin.qq.com/cgi-bin/mmsupport-bin/readtemplate?t=page/android_exp__index";
        label470:
        Intent localIntent = new Intent("android.intent.action.VIEW");
        localIntent.setClassName(aj.getPackageName(), aj.getPackageName() + ".plugin.webview.ui.tools.WebViewUI");
        localIntent.putExtra("rawUrl", (String)localObject3);
        localIntent.putExtra("useJs", true);
        localIntent.putExtra("vertical_scroll", true);
        localIntent.setFlags(872415232);
        localObject3 = PendingIntent.getActivity(localContext, 0, localIntent, 268435456);
        localObject1 = com.tencent.mm.br.a.bI(localContext, "reminder_channel_id").i(null).i(System.currentTimeMillis()).f((CharSequence)localObject1).g((CharSequence)localObject2);
        ((s.c)localObject1).Hl = ((PendingIntent)localObject3);
        ((s.c)localObject1).as(com.tencent.mm.br.a.dwe());
        localObject1 = ((s.c)localObject1).build();
        ((Notification)localObject1).flags |= 0x10;
        if (!paramBoolean) {
          break label683;
        }
        ((NotificationManager)localContext.getSystemService("notification")).notify(19841110, (Notification)localObject1);
      }
      for (;;)
      {
        AppMethodBeat.o(117425);
        return true;
        localObject1 = ((com.tencent.mm.plugin.hp.d.b)localObject3).uJj;
        break;
        label663:
        localObject2 = ((com.tencent.mm.plugin.hp.d.b)localObject3).uJk;
        break label454;
        label673:
        localObject3 = ((com.tencent.mm.plugin.hp.d.b)localObject3).uJl;
        break label470;
        label683:
        ad.i("Tinker.SyncResponseProcessor", "ignore action when load from cache,when response is alpha version");
      }
    }
    ad.i("Tinker.SyncResponseProcessor", "check need show before download. network type:%d msg:%s", new Object[] { this.uIq.nUf, this.uIq.dcJ() });
    Object localObject2 = aj.getContext();
    if ((this.uIq.nUf.intValue() == 2) && (ay.isMobile(aj.getContext())) && (this.uIq.dcI())) {
      if (!h.aF((Context)localObject2, this.uIq.nUh)) {
        if (this.uIq.nUe.intValue() == 2)
        {
          localObject1 = aj.getContext().getString(2131759573, new Object[] { this.uIq.dcJ(), aj.getContext().getString(2131764577), bt.sy(this.uIq.fileSize) });
          i.a(aj.getContext().getString(2131759571), (String)localObject1, aj.getContext().getString(2131764581), new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(117421);
              if (e.this.uIq.dcG()) {
                e.this.dco();
              }
              AppMethodBeat.o(117421);
            }
          }, aj.getContext().getString(2131764569), new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(117422);
              h.aG(this.val$context, e.this.uIq.nUh);
              AppMethodBeat.o(117422);
            }
          });
        }
      }
    }
    for (;;)
    {
      a.In(4);
      label896:
      AppMethodBeat.o(117425);
      return true;
      if (this.uIq.nUe.intValue() != 3) {
        continue;
      }
      ad.d("Tinker.SyncResponseProcessor", "showUpdateDialog ");
      if (bt.isNullOrNil(this.uIq.dcJ()))
      {
        localObject1 = ((Context)localObject2).getString(2131764588);
        label948:
        localObject3 = new dna();
        ((dna)localObject3).nUh = this.uIq.nUh;
        ((dna)localObject3).title = ((Context)localObject2).getString(2131759571);
        ((dna)localObject3).HBn = ((Context)localObject2).getString(2131764581);
        ((dna)localObject3).utw = ((Context)localObject2).getString(2131764569);
        ((dna)localObject3).uJh = this.uIq.uJh;
        ((dna)localObject3).uJi = this.uIq.uJi;
        ((dna)localObject3).mtM = this.uIq.fileSize;
        ((dna)localObject3).gHx = this.uIq.gHx;
        ((dna)localObject3).patchMd5 = this.uIq.nUg;
        ((dna)localObject3).versionCode = this.uIq.versionCode;
        ((dna)localObject3).HBm = com.tencent.mm.plugin.hp.d.d.anr(this.uIq.uJh);
      }
      try
      {
        ((dna)localObject3).HBo = Integer.parseInt(this.uIq.clientVersion, 16);
        label1112:
        ((dna)localObject3).msg = ((String)localObject1);
        com.tencent.mm.plugin.hp.d.d.a((dna)localObject3);
        continue;
        localObject1 = this.uIq.dcJ();
        break label948;
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(614L, 44L, 1L, false);
        ad.i("Tinker.SyncResponseProcessor", "this patch id :%s show cancel before user, need show again.", new Object[] { this.uIq.nUh });
        break label896;
        if ((!this.uIq.dcG()) || (h.aF((Context)localObject2, this.uIq.nUh))) {
          break label896;
        }
        dco();
      }
      catch (Exception localException)
      {
        break label1112;
      }
    }
  }
  
  public final void sL(long paramLong)
  {
    AppMethodBeat.i(117431);
    ad.i("Tinker.SyncResponseProcessor", "onTaskRemoved taskId:%d", new Object[] { Long.valueOf(paramLong) });
    f.ccl();
    com.tencent.mm.plugin.downloader.model.c.b(this);
    AppMethodBeat.o(117431);
  }
  
  public final void sM(long paramLong)
  {
    AppMethodBeat.i(117432);
    ad.d("Tinker.SyncResponseProcessor", "onTaskPaused taskId:%d", new Object[] { Long.valueOf(paramLong) });
    AppMethodBeat.o(117432);
  }
  
  public final void sN(long paramLong) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.hp.b.e
 * JD-Core Version:    0.7.0.1
 */