package com.tencent.mm.plugin.hp.b;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.Process;
import android.support.v4.app.s.c;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.af;
import com.tencent.mm.app.af.a;
import com.tencent.mm.modelmulti.m.a;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.downloader.model.g.a;
import com.tencent.mm.plugin.hp.a.a.1;
import com.tencent.mm.protocal.protobuf.dbz;
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
  final com.tencent.mm.plugin.hp.c.b sxS;
  private long sxT;
  
  public e(com.tencent.mm.plugin.hp.c.b paramb)
  {
    AppMethodBeat.i(117424);
    this.sxS = paramb;
    f.bQt();
    com.tencent.mm.plugin.downloader.model.c.a(this);
    AppMethodBeat.o(117424);
  }
  
  private void cFY()
  {
    AppMethodBeat.i(117427);
    aj.getContext();
    com.tencent.mm.plugin.hp.c.d.cGs();
    com.tencent.mm.plugin.hp.c.d.cGt();
    g.a locala = new g.a();
    locala.Sr(this.sxS.syH);
    locala.St(this.sxS.syJ);
    locala.Su(this.sxS.syI);
    locala.jc(false);
    locala.je(true);
    locala.zO(2);
    locala.jd(false);
    this.sxT = f.bQt().a(locala.ofF);
    ad.i("Tinker.SyncResponseProcessor", "Download task id is :%d", new Object[] { Long.valueOf(this.sxT) });
    com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(614L, 2L, 1L, false);
    if (ay.isWifi(aj.getContext())) {
      com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(614L, 7L, 1L, false);
    }
    for (;;)
    {
      if ((this.sxS.syF.intValue() == 2) && (!bt.isNullOrNil(this.sxS.clientVersion))) {
        com.tencent.mm.plugin.hp.tinker.b.gQ(com.tencent.mm.loader.j.a.glW, this.sxS.clientVersion).cGe();
      }
      if (this.sxS.syF.intValue() == 3)
      {
        com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(614L, 56L, 1L, false);
        ad.d("Tinker.SyncResponseProcessor", "boots download start silent.");
      }
      AppMethodBeat.o(117427);
      return;
      com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(614L, 8L, 1L, false);
    }
  }
  
  public final void a(long paramLong, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(117430);
    ad.w("Tinker.SyncResponseProcessor", "onTaskFailed");
    if (this.sxT != paramLong)
    {
      ad.i("Tinker.SyncResponseProcessor", "onTaskFailed ignore. id is no equal. download id :%s callback id:%s", new Object[] { Long.valueOf(this.sxT), Long.valueOf(paramLong) });
      AppMethodBeat.o(117430);
      return;
    }
    b.EY(2);
    if (this.sxS.syF.intValue() == 3) {
      com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(614L, 51L, 1L, false);
    }
    f.bQt();
    com.tencent.mm.plugin.downloader.model.c.b(this);
    AppMethodBeat.o(117430);
  }
  
  public final void b(long paramLong, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(117429);
    ad.i("Tinker.SyncResponseProcessor", "onTaskFinished id:%d path:%s hasChangeUrl:%s", new Object[] { Long.valueOf(paramLong), paramString, Boolean.valueOf(paramBoolean) });
    if (this.sxT != paramLong)
    {
      ad.i("Tinker.SyncResponseProcessor", "onTaskFinished ignore. id is no equal. download id :%s callback id:%s", new Object[] { Long.valueOf(this.sxT), Long.valueOf(paramLong) });
      AppMethodBeat.o(117429);
      return;
    }
    b.EX(2);
    Context localContext = aj.getContext();
    Object localObject2 = new File(paramString);
    Object localObject3 = new ShareSecurityCheck(localContext);
    paramBoolean = false;
    try
    {
      boolean bool = ((ShareSecurityCheck)localObject3).verifyPatchMetaSignature((File)localObject2);
      paramBoolean = bool;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        ad.printErrStackTrace("Tinker.SyncResponseProcessor", paramString, "verify patch signature failed.", new Object[0]);
        com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(614L, 39L, 1L, false);
      }
      paramString = localContext.getApplicationInfo();
      if (paramString != null) {
        break label331;
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
        label331:
        localObject1 = new File(paramString.dataDir, "tinker_server");
        paramString = (String)localObject1;
        if (!((File)localObject1).exists())
        {
          ((File)localObject1).mkdirs();
          paramString = (String)localObject1;
        }
      }
      switch (this.sxS.syF.intValue())
      {
      }
    }
    if ((this.sxS.syF.intValue() == 2) && (!paramBoolean))
    {
      com.tencent.tinker.lib.f.a.i("Tinker.SyncResponseProcessor", "verify patch signature failed.", new Object[0]);
      b.EY(2);
      com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(614L, 31L, 1L, false);
      if (this.sxS.syF.intValue() == 3)
      {
        com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(614L, 54L, 1L, false);
        ad.d("Tinker.SyncResponseProcessor", "boots download patch md5 no equal.");
      }
      f.bQt();
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
      com.tencent.mm.plugin.hp.tinker.h.aE(localContext, this.sxS.clientVersion);
      com.tencent.mm.plugin.hp.tinker.h.aD(localContext, com.tencent.mm.plugin.hp.c.b.a(this.sxS.syE, 2));
      break;
      com.tencent.tinker.lib.f.a.i("Tinker.SyncResponseProcessor", "onReceiveUpgradePatch. try to start apply", new Object[0]);
      if (!aj.eFI()) {
        if (com.tencent.mm.sdk.a.b.eET())
        {
          com.tencent.tinker.lib.f.a.w("Tinker.SyncResponseProcessor", "[tomys] patch applying is blocked by assist.", new Object[0]);
        }
        else if (!af.a.cMK.KY())
        {
          com.tencent.tinker.lib.f.a.w("Tinker.SyncResponseProcessor", "patch applying is blocked by TinkerEnsuranceOnFault, update basepack with different clientver to recover.", new Object[0]);
        }
        else
        {
          paramString = ((ShareSecurityCheck)localObject3).getPackagePropertiesIfPresent();
          if (paramString != null)
          {
            paramString = (String)paramString.get("patch.client.ver");
            if (TextUtils.isEmpty(paramString)) {
              break label626;
            }
            paramString = com.tencent.mm.plugin.hp.tinker.b.gQ(com.tencent.mm.loader.j.a.glW, paramString);
            localObject1 = com.tencent.mm.plugin.hp.tinker.b.cGd();
            localObject3 = paramString.Fe(1);
            if (((SharedPreferences)localObject1).contains((String)localObject3))
            {
              paramLong = ((SharedPreferences)localObject1).getLong((String)localObject3, 0L);
              paramString.ai(1, System.currentTimeMillis() - paramLong);
              ((SharedPreferences)localObject1).edit().remove((String)localObject3).commit();
            }
            com.tencent.mm.plugin.hp.tinker.b.adI(paramString.Fe(2));
          }
          for (;;)
          {
            com.tencent.tinker.lib.e.c.cx(localContext, ((File)localObject2).getAbsolutePath());
            break;
            label626:
            ad.e("Tinker.SyncResponseProcessor", "[-] Fail to get patch clientversion.");
          }
          paramString = ((File)localObject2).getAbsolutePath();
          localObject1 = this.sxS;
          ad.i("MicroMsg.Tinker.CTinkerInstaller", "onReceiveUpgradeBsDiff bsDiffPath:%s , new apk md5：%s", new Object[] { paramString, ((com.tencent.mm.plugin.hp.c.b)localObject1).syK });
          localObject2 = com.tencent.mm.plugin.hp.c.d.adM(((com.tencent.mm.plugin.hp.c.b)localObject1).syK);
          com.tencent.mm.kernel.g.afE().ax(new a.1((String)localObject2, localContext, paramString, (com.tencent.mm.plugin.hp.c.b)localObject1));
          continue;
          ad.i("Tinker.SyncResponseProcessor", "coming soon! now can not support full apk update.");
        }
      }
    }
  }
  
  final void cFX()
  {
    AppMethodBeat.i(117426);
    if (!com.tencent.mm.compatible.util.g.getExternalStorageState().equals("mounted"))
    {
      ad.e("Tinker.SyncResponseProcessor", "no sdcard.");
      com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(614L, 50L, 1L, false);
      AppMethodBeat.o(117426);
      return;
    }
    if (!com.tencent.mm.compatible.util.e.lo(this.sxS.fileSize))
    {
      ad.e("Tinker.SyncResponseProcessor", "sdcard is full.");
      com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(614L, 51L, 1L, false);
      if (this.sxS.syF.intValue() == 3) {
        com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(614L, 55L, 1L, false);
      }
      AppMethodBeat.o(117426);
      return;
    }
    if ((this.sxS.syF.intValue() == 3) && (!bt.isNullOrNil(this.sxS.syK)) && (com.tencent.mm.vfs.i.eK(com.tencent.mm.plugin.hp.c.d.adM(this.sxS.syK))) && (com.tencent.mm.d.a.em(com.tencent.mm.plugin.hp.c.d.adM(this.sxS.syK))))
    {
      Context localContext = aj.getContext();
      if (bt.isNullOrNil(this.sxS.cGp())) {}
      for (String str = localContext.getString(2131764588);; str = this.sxS.cGp())
      {
        dbz localdbz = new dbz();
        localdbz.syJ = this.sxS.syJ;
        localdbz.title = localContext.getString(2131759571);
        localdbz.EtG = localContext.getString(2131760343);
        localdbz.sne = localContext.getString(2131764569);
        localdbz.syK = this.sxS.syK;
        localdbz.syL = this.sxS.syL;
        localdbz.lsc = this.sxS.fileSize;
        localdbz.syH = this.sxS.syH;
        localdbz.patchMd5 = this.sxS.syI;
        localdbz.versionCode = this.sxS.versionCode;
        localdbz.EtF = com.tencent.mm.plugin.hp.c.d.adM(this.sxS.syK);
        localdbz.bLg = str;
        com.tencent.mm.plugin.hp.c.d.a(localdbz);
        ad.i("Tinker.SyncResponseProcessor", "file is exist. need no to download. newApkMd5:%s", new Object[] { this.sxS.syK });
        AppMethodBeat.o(117426);
        return;
      }
    }
    this.sxS.syF.intValue();
    cFY();
    AppMethodBeat.o(117426);
  }
  
  public final void j(long paramLong, String paramString)
  {
    AppMethodBeat.i(117434);
    ad.d("Tinker.SyncResponseProcessor", "onTaskResumed taskId:%d filePath:%s", new Object[] { Long.valueOf(paramLong), paramString });
    AppMethodBeat.o(117434);
  }
  
  public final void mZ(long paramLong)
  {
    AppMethodBeat.i(117433);
    ad.d("Tinker.SyncResponseProcessor", "onTaskProgressChanged taskId:%d", new Object[] { Long.valueOf(paramLong) });
    AppMethodBeat.o(117433);
  }
  
  public final boolean mk(boolean paramBoolean)
  {
    AppMethodBeat.i(117425);
    com.tencent.tinker.lib.f.a.i("Tinker.SyncResponseProcessor", "process tinker response: %s", new Object[] { this.sxS.toString() });
    Object localObject1 = this.sxS;
    int i;
    if ((((com.tencent.mm.plugin.hp.c.b)localObject1).syD.intValue() > 4) || (((com.tencent.mm.plugin.hp.c.b)localObject1).syD.intValue() <= 0))
    {
      ad.e("Tinker.TinkerSyncResponse", "responseState: %d must between %d and %d", new Object[] { ((com.tencent.mm.plugin.hp.c.b)localObject1).syD, Integer.valueOf(1), Integer.valueOf(4) });
      com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(614L, 24L, 1L, false);
      i = 0;
    }
    while (i == 0)
    {
      com.tencent.tinker.lib.f.a.i("Tinker.SyncResponseProcessor", "process check response fail, just return", new Object[0]);
      AppMethodBeat.o(117425);
      return false;
      if (((com.tencent.mm.plugin.hp.c.b)localObject1).cGn())
      {
        if (TextUtils.isEmpty(((com.tencent.mm.plugin.hp.c.b)localObject1).syJ))
        {
          ad.e("Tinker.TinkerSyncResponse", "sync response patchId should not be null");
          com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(614L, 25L, 1L, false);
          i = 0;
          continue;
        }
        if (TextUtils.isEmpty(((com.tencent.mm.plugin.hp.c.b)localObject1).syH))
        {
          ad.e("Tinker.TinkerSyncResponse", "sync response cdnUrl should not be null");
          com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(614L, 26L, 1L, false);
          i = 0;
          continue;
        }
        if (TextUtils.isEmpty(((com.tencent.mm.plugin.hp.c.b)localObject1).syI))
        {
          ad.e("Tinker.TinkerSyncResponse", "sync response fileMd5 should not be null");
          com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(614L, 27L, 1L, false);
          i = 0;
          continue;
        }
      }
      i = 1;
    }
    if (this.sxS.syD.intValue() == 3)
    {
      i = 1;
      if (i == 0) {
        break label395;
      }
      localObject2 = aj.getContext();
      localObject1 = com.tencent.tinker.lib.e.a.kI((Context)localObject2);
      if (((com.tencent.tinker.lib.e.a)localObject1).IER) {
        break label317;
      }
      com.tencent.tinker.lib.f.a.w("Tinker.SyncResponseProcessor", "SyncResponseProcessor: onPatchRollback, tinker is not loaded, just return", new Object[0]);
    }
    for (;;)
    {
      AppMethodBeat.o(117425);
      return true;
      i = 0;
      break;
      label317:
      com.tencent.tinker.lib.f.a.i("Tinker.SyncResponseProcessor", "tinker wait screen to clean patch and kill all process", new Object[0]);
      new com.tencent.mm.modelmulti.m(aj.getContext(), new m.a()
      {
        public final void es(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(117423);
          if (!paramAnonymousBoolean)
          {
            com.tencent.tinker.lib.f.a.i("Tinker.SyncResponseProcessor", "app is background now, i can kill quietly", new Object[0]);
            ShareTinkerInternals.killAllOtherProcess(this.val$context);
            this.sxV.cGh();
            Process.killProcess(Process.myPid());
          }
          AppMethodBeat.o(117423);
        }
      });
      localObject2 = new SharePatchInfo(((com.tencent.tinker.lib.e.a)localObject1).IEQ.IEV, "00000000000000000000000000000000", false, true, Build.FINGERPRINT, "odex");
      SharePatchInfo.rewritePatchInfoFileWithLock(((com.tencent.tinker.lib.e.a)localObject1).IEN, (SharePatchInfo)localObject2, ((com.tencent.tinker.lib.e.a)localObject1).IEO);
    }
    label395:
    if (!this.sxS.cGn())
    {
      AppMethodBeat.o(117425);
      return true;
    }
    if (this.sxS.cGq())
    {
      com.tencent.tinker.lib.f.a.w("Tinker.SyncResponseProcessor", "is lower version skip.", new Object[0]);
      com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(614L, 78L, 1L, false);
      AppMethodBeat.o(117425);
      return true;
    }
    if (com.tencent.mm.sdk.a.b.eET())
    {
      com.tencent.tinker.lib.f.a.w("Tinker.SyncResponseProcessor", "[tomys] patch downloading is blocked by assist.", new Object[0]);
      AppMethodBeat.o(117425);
      return true;
    }
    Object localObject3;
    if ((this.sxS.syF.intValue() == 3) && (!bt.isNullOrNil(this.sxS.clientVersion)) && (com.tencent.mm.plugin.hp.c.c.adK(this.sxS.clientVersion)))
    {
      com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(614L, 77L, 1L, false);
      localObject3 = this.sxS;
      Context localContext = aj.getContext();
      if (bt.isNullOrNil(((com.tencent.mm.plugin.hp.c.b)localObject3).syM))
      {
        localObject1 = localContext.getString(2131755871);
        if (!bt.isNullOrNil(((com.tencent.mm.plugin.hp.c.b)localObject3).syN)) {
          break label793;
        }
        localObject2 = "";
        label584:
        if (!bt.isNullOrNil(((com.tencent.mm.plugin.hp.c.b)localObject3).syO)) {
          break label803;
        }
        localObject3 = "http://support.weixin.qq.com/cgi-bin/mmsupport-bin/readtemplate?t=page/android_exp__index";
        label600:
        Intent localIntent = new Intent("android.intent.action.VIEW");
        localIntent.setClassName(aj.getPackageName(), aj.getPackageName() + ".plugin.webview.ui.tools.WebViewUI");
        localIntent.putExtra("rawUrl", (String)localObject3);
        localIntent.putExtra("useJs", true);
        localIntent.putExtra("vertical_scroll", true);
        localIntent.setFlags(872415232);
        localObject3 = PendingIntent.getActivity(localContext, 0, localIntent, 268435456);
        localObject1 = com.tencent.mm.br.a.bD(localContext, "reminder_channel_id").i(null).g(System.currentTimeMillis()).f((CharSequence)localObject1).g((CharSequence)localObject2);
        ((s.c)localObject1).Ew = ((PendingIntent)localObject3);
        ((s.c)localObject1).as(com.tencent.mm.br.a.cYf());
        localObject1 = ((s.c)localObject1).build();
        ((Notification)localObject1).flags |= 0x10;
        if (!paramBoolean) {
          break label813;
        }
        ((NotificationManager)localContext.getSystemService("notification")).notify(19841110, (Notification)localObject1);
      }
      for (;;)
      {
        AppMethodBeat.o(117425);
        return true;
        localObject1 = ((com.tencent.mm.plugin.hp.c.b)localObject3).syM;
        break;
        label793:
        localObject2 = ((com.tencent.mm.plugin.hp.c.b)localObject3).syN;
        break label584;
        label803:
        localObject3 = ((com.tencent.mm.plugin.hp.c.b)localObject3).syO;
        break label600;
        label813:
        ad.i("Tinker.SyncResponseProcessor", "ignore action when load from cache,when response is alpha version");
      }
    }
    com.tencent.tinker.lib.f.a.i("Tinker.SyncResponseProcessor", "check need show before download. network type:%d msg:%s", new Object[] { this.sxS.syG, this.sxS.cGp() });
    Object localObject2 = aj.getContext();
    if ((this.sxS.syG.intValue() == 2) && (ay.isMobile(aj.getContext())) && (this.sxS.cGo())) {
      if (!com.tencent.mm.plugin.hp.tinker.h.aB((Context)localObject2, this.sxS.syJ)) {
        if (this.sxS.syF.intValue() == 2)
        {
          localObject1 = aj.getContext().getString(2131759573, new Object[] { this.sxS.cGp(), aj.getContext().getString(2131764577), bt.mK(this.sxS.fileSize) });
          i.a(aj.getContext().getString(2131759571), (String)localObject1, aj.getContext().getString(2131764581), new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(117421);
              if (e.this.sxS.cGm()) {
                e.this.cFX();
              }
              AppMethodBeat.o(117421);
            }
          }, aj.getContext().getString(2131764569), new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(117422);
              com.tencent.mm.plugin.hp.tinker.h.aC(this.val$context, e.this.sxS.syJ);
              AppMethodBeat.o(117422);
            }
          });
          a.EV(4);
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(117425);
      return true;
      if (this.sxS.syF.intValue() != 3) {
        break;
      }
      ad.d("Tinker.SyncResponseProcessor", "showUpdateDialog ");
      if (bt.isNullOrNil(this.sxS.cGp())) {}
      for (localObject1 = ((Context)localObject2).getString(2131764588);; localObject1 = this.sxS.cGp())
      {
        localObject3 = new dbz();
        ((dbz)localObject3).syJ = this.sxS.syJ;
        ((dbz)localObject3).title = ((Context)localObject2).getString(2131759571);
        ((dbz)localObject3).EtG = ((Context)localObject2).getString(2131764581);
        ((dbz)localObject3).sne = ((Context)localObject2).getString(2131764569);
        ((dbz)localObject3).syK = this.sxS.syK;
        ((dbz)localObject3).syL = this.sxS.syL;
        ((dbz)localObject3).lsc = this.sxS.fileSize;
        ((dbz)localObject3).syH = this.sxS.syH;
        ((dbz)localObject3).patchMd5 = this.sxS.syI;
        ((dbz)localObject3).versionCode = this.sxS.versionCode;
        ((dbz)localObject3).EtF = com.tencent.mm.plugin.hp.c.d.adM(this.sxS.syK);
        ((dbz)localObject3).bLg = ((String)localObject1);
        com.tencent.mm.plugin.hp.c.d.a((dbz)localObject3);
        break;
      }
      com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(614L, 44L, 1L, false);
      ad.i("Tinker.SyncResponseProcessor", "this patch id :%s show cancel before user, need show again.", new Object[] { this.sxS.syJ });
      continue;
      if ((this.sxS.cGm()) && (!com.tencent.mm.plugin.hp.tinker.h.aB((Context)localObject2, this.sxS.syJ))) {
        cFX();
      }
    }
  }
  
  public final void na(long paramLong) {}
  
  public final void onTaskPaused(long paramLong)
  {
    AppMethodBeat.i(117432);
    ad.d("Tinker.SyncResponseProcessor", "onTaskPaused taskId:%d", new Object[] { Long.valueOf(paramLong) });
    AppMethodBeat.o(117432);
  }
  
  public final void onTaskRemoved(long paramLong)
  {
    AppMethodBeat.i(117431);
    ad.i("Tinker.SyncResponseProcessor", "onTaskRemoved taskId:%d", new Object[] { Long.valueOf(paramLong) });
    f.bQt();
    com.tencent.mm.plugin.downloader.model.c.b(this);
    AppMethodBeat.o(117431);
  }
  
  public final void onTaskStarted(long paramLong, String paramString)
  {
    AppMethodBeat.i(117428);
    ad.d("Tinker.SyncResponseProcessor", "onTaskStarted taskId %d", new Object[] { Long.valueOf(paramLong) });
    AppMethodBeat.o(117428);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.hp.b.e
 * JD-Core Version:    0.7.0.1
 */