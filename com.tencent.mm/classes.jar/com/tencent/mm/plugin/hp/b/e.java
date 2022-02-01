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
import com.tencent.mm.protocal.protobuf.dnx;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.o;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.SharePatchInfo;
import com.tencent.tinker.loader.shareutil.ShareSecurityCheck;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import java.io.File;
import java.util.Map;

public final class e
  implements com.tencent.mm.plugin.downloader.model.m
{
  final com.tencent.mm.plugin.hp.d.b uUd;
  private long uUe;
  
  public e(com.tencent.mm.plugin.hp.d.b paramb)
  {
    AppMethodBeat.i(117424);
    this.uUd = paramb;
    f.cdA();
    com.tencent.mm.plugin.downloader.model.c.a(this);
    AppMethodBeat.o(117424);
  }
  
  private void dfh()
  {
    AppMethodBeat.i(117427);
    ak.getContext();
    com.tencent.mm.plugin.hp.d.d.dfG();
    com.tencent.mm.plugin.hp.d.d.dfH();
    g.a locala = new g.a();
    locala.abb(this.uUd.gKg);
    locala.abd(this.uUd.nZN);
    locala.abe(this.uUd.nZM);
    locala.jP(false);
    locala.jR(true);
    locala.BB(2);
    locala.jQ(false);
    this.uUe = f.cdA().a(locala.ptu);
    ae.i("Tinker.SyncResponseProcessor", "Download task id is :%d", new Object[] { Long.valueOf(this.uUe) });
    com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(614L, 2L, 1L, false);
    if (az.isWifi(ak.getContext())) {
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(614L, 7L, 1L, false);
    }
    for (;;)
    {
      if ((this.uUd.nZK.intValue() == 2) && (!bu.isNullOrNil(this.uUd.clientVersion))) {
        com.tencent.mm.plugin.hp.tinker.b.hA(com.tencent.mm.loader.j.a.hju, this.uUd.clientVersion).dfo();
      }
      if (this.uUd.nZK.intValue() == 3)
      {
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(614L, 56L, 1L, false);
        ae.d("Tinker.SyncResponseProcessor", "boots download start silent.");
      }
      AppMethodBeat.o(117427);
      return;
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(614L, 8L, 1L, false);
    }
  }
  
  public final void a(long paramLong, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(117430);
    ae.w("Tinker.SyncResponseProcessor", "onTaskFailed");
    if (this.uUe != paramLong)
    {
      ae.i("Tinker.SyncResponseProcessor", "onTaskFailed ignore. id is no equal. download id :%s callback id:%s", new Object[] { Long.valueOf(this.uUe), Long.valueOf(paramLong) });
      AppMethodBeat.o(117430);
      return;
    }
    b.IN(2);
    if (this.uUd.nZK.intValue() == 3) {
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(614L, 51L, 1L, false);
    }
    f.cdA();
    com.tencent.mm.plugin.downloader.model.c.b(this);
    AppMethodBeat.o(117430);
  }
  
  public final void a(long paramLong1, String paramString, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(196763);
    ae.d("Tinker.SyncResponseProcessor", "onTaskProgressChanged taskId:%d", new Object[] { Long.valueOf(paramLong1) });
    AppMethodBeat.o(196763);
  }
  
  public final void b(long paramLong, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(117429);
    ae.i("Tinker.SyncResponseProcessor", "onTaskFinished id:%d path:%s hasChangeUrl:%s", new Object[] { Long.valueOf(paramLong), paramString, Boolean.valueOf(paramBoolean) });
    if (this.uUe != paramLong)
    {
      ae.i("Tinker.SyncResponseProcessor", "onTaskFinished ignore. id is no equal. download id :%s callback id:%s", new Object[] { Long.valueOf(this.uUe), Long.valueOf(paramLong) });
      AppMethodBeat.o(117429);
      return;
    }
    b.IM(2);
    Context localContext = ak.getContext();
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
        ae.printErrStackTrace("Tinker.SyncResponseProcessor", paramString, "verify patch signature failed.", new Object[0]);
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(614L, 39L, 1L, false);
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
      switch (this.uUd.nZK.intValue())
      {
      }
    }
    if ((this.uUd.nZK.intValue() == 2) && (!paramBoolean))
    {
      ae.i("Tinker.SyncResponseProcessor", "verify patch signature failed.");
      b.IN(2);
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(614L, 31L, 1L, false);
      if (this.uUd.nZK.intValue() == 3)
      {
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(614L, 54L, 1L, false);
        ae.d("Tinker.SyncResponseProcessor", "boots download patch md5 no equal.");
      }
      f.cdA();
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
      h.aK(localContext, this.uUd.clientVersion);
      h.aJ(localContext, com.tencent.mm.plugin.hp.d.b.a(this.uUd.uUT, 2));
      break;
      ae.i("Tinker.SyncResponseProcessor", "onReceiveUpgradePatch. try to start apply");
      if (!ak.foB()) {
        if (com.tencent.mm.sdk.a.b.fnI())
        {
          ae.w("Tinker.SyncResponseProcessor", "[tomys] patch applying is blocked by assist.");
        }
        else if (!ag.a.cWf.Mz())
        {
          ae.w("Tinker.SyncResponseProcessor", "patch applying is blocked by TinkerEnsuranceOnFault, update basepack with different clientver to recover.");
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
            paramString = com.tencent.mm.plugin.hp.tinker.b.hA(com.tencent.mm.loader.j.a.hju, paramString);
            paramString.dfq();
            paramString.dfp();
          }
          for (;;)
          {
            com.tencent.tinker.lib.e.c.cE(localContext, ((File)localObject2).getAbsolutePath());
            break;
            label545:
            ae.e("Tinker.SyncResponseProcessor", "[-] Fail to get patch clientversion.");
          }
          paramString = ((File)localObject2).getAbsolutePath();
          localObject1 = this.uUd;
          ae.i("MicroMsg.Tinker.CTinkerInstaller", "onReceiveUpgradeBsDiff bsDiffPath:%s , new apk md5：%s", new Object[] { paramString, ((com.tencent.mm.plugin.hp.d.b)localObject1).uUU });
          localObject2 = com.tencent.mm.plugin.hp.d.d.aot(((com.tencent.mm.plugin.hp.d.b)localObject1).uUU);
          com.tencent.mm.kernel.g.ajU().aw(new a.1((String)localObject2, localContext, paramString, (com.tencent.mm.plugin.hp.d.b)localObject1));
          continue;
          ae.i("Tinker.SyncResponseProcessor", "coming soon! now can not support full apk update.");
        }
      }
    }
  }
  
  final void dfg()
  {
    AppMethodBeat.i(117426);
    if (!com.tencent.mm.compatible.util.g.getExternalStorageState().equals("mounted"))
    {
      ae.e("Tinker.SyncResponseProcessor", "no sdcard.");
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(614L, 50L, 1L, false);
      AppMethodBeat.o(117426);
      return;
    }
    if (!com.tencent.mm.compatible.util.e.re(this.uUd.fileSize))
    {
      ae.e("Tinker.SyncResponseProcessor", "sdcard is full.");
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(614L, 51L, 1L, false);
      if (this.uUd.nZK.intValue() == 3) {
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(614L, 55L, 1L, false);
      }
      AppMethodBeat.o(117426);
      return;
    }
    Context localContext;
    String str;
    if ((this.uUd.nZK.intValue() == 3) && (!bu.isNullOrNil(this.uUd.uUU)) && (o.fB(com.tencent.mm.plugin.hp.d.d.aot(this.uUd.uUU))) && (com.tencent.mm.d.a.fb(com.tencent.mm.plugin.hp.d.d.aot(this.uUd.uUU))))
    {
      localContext = ak.getContext();
      if (bu.isNullOrNil(this.uUd.dfB())) {
        str = localContext.getString(2131764588);
      }
    }
    for (;;)
    {
      dnx localdnx = new dnx();
      localdnx.nZN = this.uUd.nZN;
      localdnx.title = localContext.getString(2131759571);
      localdnx.HVa = localContext.getString(2131760343);
      localdnx.uEP = localContext.getString(2131764569);
      localdnx.uUU = this.uUd.uUU;
      localdnx.uUV = this.uUd.uUV;
      localdnx.myJ = this.uUd.fileSize;
      localdnx.gKg = this.uUd.gKg;
      localdnx.patchMd5 = this.uUd.nZM;
      localdnx.versionCode = this.uUd.versionCode;
      localdnx.HUZ = com.tencent.mm.plugin.hp.d.d.aot(this.uUd.uUU);
      try
      {
        localdnx.HVb = Integer.parseInt(this.uUd.clientVersion, 16);
        label350:
        localdnx.msg = str;
        com.tencent.mm.plugin.hp.d.d.a(localdnx);
        ae.i("Tinker.SyncResponseProcessor", "file is exist. need no to download. newApkMd5:%s", new Object[] { this.uUd.uUU });
        AppMethodBeat.o(117426);
        return;
        str = this.uUd.dfB();
        continue;
        this.uUd.nZK.intValue();
        dfh();
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
    ae.d("Tinker.SyncResponseProcessor", "onTaskStarted taskId %d", new Object[] { Long.valueOf(paramLong) });
    AppMethodBeat.o(117428);
  }
  
  public final void k(long paramLong, String paramString)
  {
    AppMethodBeat.i(117434);
    ae.d("Tinker.SyncResponseProcessor", "onTaskResumed taskId:%d filePath:%s", new Object[] { Long.valueOf(paramLong), paramString });
    AppMethodBeat.o(117434);
  }
  
  public final boolean nB(boolean paramBoolean)
  {
    AppMethodBeat.i(117425);
    ae.i("Tinker.SyncResponseProcessor", "process tinker response: %s", new Object[] { this.uUd.toString() });
    if (!this.uUd.dfC())
    {
      ae.i("Tinker.SyncResponseProcessor", "process check response fail, just return");
      AppMethodBeat.o(117425);
      return false;
    }
    if (this.uUd.dfD())
    {
      localObject2 = ak.getContext();
      final com.tencent.tinker.lib.e.a locala = com.tencent.tinker.lib.e.a.lq((Context)localObject2);
      if (!locala.MDY) {
        ae.w("Tinker.SyncResponseProcessor", "SyncResponseProcessor: onPatchRollback, tinker is not loaded, just return");
      }
      for (;;)
      {
        AppMethodBeat.o(117425);
        return true;
        ae.i("Tinker.SyncResponseProcessor", "tinker wait screen to clean patch and kill all process");
        new com.tencent.mm.modelmulti.m(ak.getContext(), new m.a()
        {
          public final void eR(boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(117423);
            if (!paramAnonymousBoolean)
            {
              ae.i("Tinker.SyncResponseProcessor", "app is background now, i can kill quietly");
              ShareTinkerInternals.killAllOtherProcess(this.val$context);
              locala.dft();
              com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(Process.myPid(), new com.tencent.mm.hellhoundlib.b.a());
              Object localObject = new Object();
              com.tencent.mm.hellhoundlib.a.a.a(localObject, locala.ahE(), "com/tencent/mm/plugin/hp/model/SyncResponseProcessor$3", "onScreenStateChange", "(Z)V", "android/os/Process_EXEC_", "killProcess", "(I)V");
              Process.killProcess(((Integer)locala.mt(0)).intValue());
              com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/hp/model/SyncResponseProcessor$3", "onScreenStateChange", "(Z)V", "android/os/Process_EXEC_", "killProcess", "(I)V");
            }
            AppMethodBeat.o(117423);
          }
        });
        localObject2 = new SharePatchInfo(locala.MDX.MEc, "00000000000000000000000000000000", false, true, Build.FINGERPRINT, "odex", false);
        SharePatchInfo.rewritePatchInfoFileWithLock(locala.MDU, (SharePatchInfo)localObject2, locala.MDV);
      }
    }
    if (!this.uUd.dfz())
    {
      AppMethodBeat.o(117425);
      return true;
    }
    if (this.uUd.dfE())
    {
      ae.w("Tinker.SyncResponseProcessor", "is lower version skip.");
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(614L, 78L, 1L, false);
      AppMethodBeat.o(117425);
      return true;
    }
    if (ak.coh()) {
      try
      {
        int i = Integer.decode(com.tencent.mm.loader.j.a.hju).intValue();
        if ((i >= 654316032) && (i <= 654316287) && ("vivo".equalsIgnoreCase(Build.MANUFACTURER)) && (Build.VERSION.SDK_INT == 29) && (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qPW, 0) == 0))
        {
          ae.w("Tinker.SyncResponseProcessor", "[!] [tomys] Patch was blocked due to some compatibility issues.");
          AppMethodBeat.o(117425);
          return true;
        }
      }
      catch (Throwable localThrowable)
      {
        ae.printErrStackTrace("Tinker.SyncResponseProcessor", localThrowable, "[-] [tomys] Error happened in tmp ctrl code.", new Object[0]);
      }
    }
    if (com.tencent.mm.sdk.a.b.fnI())
    {
      ae.w("Tinker.SyncResponseProcessor", "[tomys] patch downloading is blocked by assist.");
      AppMethodBeat.o(117425);
      return true;
    }
    Object localObject3;
    Object localObject1;
    if ((this.uUd.nZK.intValue() == 3) && (!bu.isNullOrNil(this.uUd.clientVersion)) && (com.tencent.mm.plugin.hp.d.c.aor(this.uUd.clientVersion)))
    {
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(614L, 77L, 1L, false);
      localObject3 = this.uUd;
      Context localContext = ak.getContext();
      if (bu.isNullOrNil(((com.tencent.mm.plugin.hp.d.b)localObject3).uUW))
      {
        localObject1 = localContext.getString(2131755871);
        if (!bu.isNullOrNil(((com.tencent.mm.plugin.hp.d.b)localObject3).uUX)) {
          break label664;
        }
        localObject2 = "";
        label455:
        if (!bu.isNullOrNil(((com.tencent.mm.plugin.hp.d.b)localObject3).uUY)) {
          break label674;
        }
        localObject3 = "http://support.weixin.qq.com/cgi-bin/mmsupport-bin/readtemplate?t=page/android_exp__index";
        label471:
        Intent localIntent = new Intent("android.intent.action.VIEW");
        localIntent.setClassName(ak.getPackageName(), ak.getPackageName() + ".plugin.webview.ui.tools.WebViewUI");
        localIntent.putExtra("rawUrl", (String)localObject3);
        localIntent.putExtra("useJs", true);
        localIntent.putExtra("vertical_scroll", true);
        localIntent.setFlags(872415232);
        localObject3 = PendingIntent.getActivity(localContext, 0, localIntent, 268435456);
        localObject1 = com.tencent.mm.bq.a.bJ(localContext, "reminder_channel_id").i(null).i(System.currentTimeMillis()).f((CharSequence)localObject1).g((CharSequence)localObject2);
        ((s.c)localObject1).Hl = ((PendingIntent)localObject3);
        ((s.c)localObject1).as(com.tencent.mm.bq.a.dzu());
        localObject1 = ((s.c)localObject1).build();
        ((Notification)localObject1).flags |= 0x10;
        if (!paramBoolean) {
          break label684;
        }
        ((NotificationManager)localContext.getSystemService("notification")).notify(19841110, (Notification)localObject1);
      }
      for (;;)
      {
        AppMethodBeat.o(117425);
        return true;
        localObject1 = ((com.tencent.mm.plugin.hp.d.b)localObject3).uUW;
        break;
        label664:
        localObject2 = ((com.tencent.mm.plugin.hp.d.b)localObject3).uUX;
        break label455;
        label674:
        localObject3 = ((com.tencent.mm.plugin.hp.d.b)localObject3).uUY;
        break label471;
        label684:
        ae.i("Tinker.SyncResponseProcessor", "ignore action when load from cache,when response is alpha version");
      }
    }
    ae.i("Tinker.SyncResponseProcessor", "check need show before download. network type:%d msg:%s clientversion:%s", new Object[] { this.uUd.nZL, this.uUd.dfB(), this.uUd.clientVersion });
    Object localObject2 = ak.getContext();
    if ((this.uUd.nZL.intValue() == 2) && (az.isMobile(ak.getContext())) && (this.uUd.dfA())) {
      if (!h.aH((Context)localObject2, this.uUd.nZN)) {
        if (this.uUd.nZK.intValue() == 2)
        {
          localObject1 = ak.getContext().getString(2131759573, new Object[] { this.uUd.dfB(), ak.getContext().getString(2131764577), bu.sL(this.uUd.fileSize) });
          i.a(ak.getContext().getString(2131759571), (String)localObject1, ak.getContext().getString(2131764581), new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(117421);
              if (e.this.uUd.dfy()) {
                e.this.dfg();
              }
              AppMethodBeat.o(117421);
            }
          }, ak.getContext().getString(2131764569), new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(117422);
              h.aI(this.val$context, e.this.uUd.nZN);
              AppMethodBeat.o(117422);
            }
          });
        }
      }
    }
    for (;;)
    {
      a.IL(4);
      label907:
      AppMethodBeat.o(117425);
      return true;
      if (this.uUd.nZK.intValue() != 3) {
        continue;
      }
      ae.i("Tinker.SyncResponseProcessor", "showUpdateDialog ");
      if (bu.isNullOrNil(this.uUd.dfB()))
      {
        localObject1 = ((Context)localObject2).getString(2131764588);
        label959:
        localObject3 = new dnx();
        ((dnx)localObject3).nZN = this.uUd.nZN;
        ((dnx)localObject3).title = ((Context)localObject2).getString(2131759571);
        ((dnx)localObject3).HVa = ((Context)localObject2).getString(2131764581);
        ((dnx)localObject3).uEP = ((Context)localObject2).getString(2131764569);
        ((dnx)localObject3).uUU = this.uUd.uUU;
        ((dnx)localObject3).uUV = this.uUd.uUV;
        ((dnx)localObject3).myJ = this.uUd.fileSize;
        ((dnx)localObject3).gKg = this.uUd.gKg;
        ((dnx)localObject3).patchMd5 = this.uUd.nZM;
        ((dnx)localObject3).versionCode = this.uUd.versionCode;
        ((dnx)localObject3).HUZ = com.tencent.mm.plugin.hp.d.d.aot(this.uUd.uUU);
      }
      try
      {
        ((dnx)localObject3).HVb = Integer.parseInt(this.uUd.clientVersion, 16);
        label1123:
        ((dnx)localObject3).msg = ((String)localObject1);
        com.tencent.mm.plugin.hp.d.d.a((dnx)localObject3);
        continue;
        localObject1 = this.uUd.dfB();
        break label959;
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(614L, 44L, 1L, false);
        ae.i("Tinker.SyncResponseProcessor", "this patch id :%s show cancel before user, need show again.", new Object[] { this.uUd.nZN });
        break label907;
        if ((!this.uUd.dfy()) || (h.aH((Context)localObject2, this.uUd.nZN))) {
          break label907;
        }
        dfg();
      }
      catch (Exception localException)
      {
        break label1123;
      }
    }
  }
  
  public final void sY(long paramLong)
  {
    AppMethodBeat.i(117431);
    ae.i("Tinker.SyncResponseProcessor", "onTaskRemoved taskId:%d", new Object[] { Long.valueOf(paramLong) });
    f.cdA();
    com.tencent.mm.plugin.downloader.model.c.b(this);
    AppMethodBeat.o(117431);
  }
  
  public final void sZ(long paramLong)
  {
    AppMethodBeat.i(117432);
    ae.d("Tinker.SyncResponseProcessor", "onTaskPaused taskId:%d", new Object[] { Long.valueOf(paramLong) });
    AppMethodBeat.o(117432);
  }
  
  public final void ta(long paramLong) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hp.b.e
 * JD-Core Version:    0.7.0.1
 */