package com.tencent.mm.plugin.hp.b;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.Process;
import android.support.v4.app.s.c;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.y;
import com.tencent.mm.app.y.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelmulti.l;
import com.tencent.mm.modelmulti.l.a;
import com.tencent.mm.plugin.downloader.model.g.a;
import com.tencent.mm.plugin.downloader.model.m;
import com.tencent.mm.plugin.hp.a.a.1;
import com.tencent.mm.protocal.protobuf.ckf;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.SharePatchInfo;
import com.tencent.tinker.loader.shareutil.ShareSecurityCheck;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import java.io.File;
import java.util.Map;

public final class e
  implements m
{
  final com.tencent.mm.plugin.hp.d.b nKl;
  private long nKm;
  
  public e(com.tencent.mm.plugin.hp.d.b paramb)
  {
    AppMethodBeat.i(90596);
    this.nKl = paramb;
    com.tencent.mm.plugin.downloader.model.f.bjl();
    com.tencent.mm.plugin.downloader.model.c.a(this);
    AppMethodBeat.o(90596);
  }
  
  private void bIh()
  {
    AppMethodBeat.i(90599);
    ah.getContext();
    com.tencent.mm.plugin.hp.d.d.bIx();
    com.tencent.mm.plugin.hp.d.d.bIy();
    g.a locala = new g.a();
    locala.JJ(this.nKl.nKP);
    locala.JL(this.nKl.nKR);
    locala.JM(this.nKl.nKQ);
    locala.gr(false);
    locala.bjt();
    locala.tV(2);
    locala.gs(false);
    this.nKm = com.tencent.mm.plugin.downloader.model.f.bjl().a(locala.kYR);
    ab.i("Tinker.SyncResponseProcessor", "Download task id is :%d", new Object[] { Long.valueOf(this.nKm) });
    com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(614L, 2L, 1L, false);
    if (at.isWifi(ah.getContext())) {
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(614L, 7L, 1L, false);
    }
    for (;;)
    {
      if ((this.nKl.nKN.intValue() == 2) && (!bo.isNullOrNil(this.nKl.clientVersion))) {
        com.tencent.mm.plugin.hp.tinker.b.eP(com.tencent.mm.loader.j.a.CLIENT_VERSION, this.nKl.clientVersion).dbX();
      }
      if (this.nKl.nKN.intValue() == 3)
      {
        com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(614L, 56L, 1L, false);
        ab.d("Tinker.SyncResponseProcessor", "boots download start silent.");
      }
      AppMethodBeat.o(90599);
      return;
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(614L, 8L, 1L, false);
    }
  }
  
  public final void b(long paramLong, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(90602);
    ab.w("Tinker.SyncResponseProcessor", "onTaskFailed");
    if (this.nKm != paramLong)
    {
      ab.i("Tinker.SyncResponseProcessor", "onTaskFailed ignore. id is no equal. download id :%s callback id:%s", new Object[] { Long.valueOf(this.nKm), Long.valueOf(paramLong) });
      AppMethodBeat.o(90602);
      return;
    }
    b.xw(2);
    if (this.nKl.nKN.intValue() == 3) {
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(614L, 51L, 1L, false);
    }
    com.tencent.mm.plugin.downloader.model.f.bjl();
    com.tencent.mm.plugin.downloader.model.c.b(this);
    AppMethodBeat.o(90602);
  }
  
  public final void b(long paramLong, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(90601);
    ab.i("Tinker.SyncResponseProcessor", "onTaskFinished id:%d path:%s hasChangeUrl:%s", new Object[] { Long.valueOf(paramLong), paramString, Boolean.valueOf(paramBoolean) });
    if (this.nKm != paramLong)
    {
      ab.i("Tinker.SyncResponseProcessor", "onTaskFinished ignore. id is no equal. download id :%s callback id:%s", new Object[] { Long.valueOf(this.nKm), Long.valueOf(paramLong) });
      AppMethodBeat.o(90601);
      return;
    }
    b.xv(2);
    Context localContext = ah.getContext();
    Object localObject2 = new File(paramString);
    Object localObject3 = new ShareSecurityCheck(localContext);
    paramBoolean = false;
    try
    {
      boolean bool = ((ShareSecurityCheck)localObject3).at((File)localObject2);
      paramBoolean = bool;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        ab.printErrStackTrace("Tinker.SyncResponseProcessor", paramString, "verify patch signature failed.", new Object[0]);
        com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(614L, 39L, 1L, false);
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
        int j = paramString.length;
        int i = 0;
        while (i < j)
        {
          File localFile = paramString[i];
          if (!localFile.getName().equals(localObject1)) {
            SharePatchFileUtil.aq(localFile);
          }
          i += 1;
        }
        localObject1 = new File(paramString.dataDir, "tinker_server");
        paramString = (String)localObject1;
        if (!((File)localObject1).exists())
        {
          ((File)localObject1).mkdirs();
          paramString = (String)localObject1;
        }
      }
      switch (this.nKl.nKN.intValue())
      {
      }
    }
    if ((this.nKl.nKN.intValue() == 2) && (!paramBoolean))
    {
      com.tencent.tinker.lib.f.a.i("Tinker.SyncResponseProcessor", "verify patch signature failed.", new Object[0]);
      b.xw(2);
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(614L, 31L, 1L, false);
      if (this.nKl.nKN.intValue() == 3)
      {
        com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(614L, 54L, 1L, false);
        ab.d("Tinker.SyncResponseProcessor", "boots download patch md5 no equal.");
      }
      com.tencent.mm.plugin.downloader.model.f.bjl();
      com.tencent.mm.plugin.downloader.model.c.b(this);
      AppMethodBeat.o(90601);
      return;
    }
    Object localObject1;
    label331:
    paramString = this.nKl;
    label408:
    if (paramString.bIt()) {}
    for (paramString = com.tencent.mm.plugin.hp.d.b.a(paramString.nKM, 2);; paramString = "")
    {
      localContext.getSharedPreferences("tinker_patch_share_config", 4).edit().putString("tinker_patch_msg_key", paramString).apply();
      break;
      com.tencent.tinker.lib.f.a.i("Tinker.SyncResponseProcessor", "onReceiveUpgradePatch. try to start apply", new Object[0]);
      if (ah.dsV()) {
        break label408;
      }
      if (com.tencent.mm.sdk.a.b.dsi())
      {
        com.tencent.tinker.lib.f.a.w("Tinker.SyncResponseProcessor", "[tomys] patch applying is blocked by assist.", new Object[0]);
        break label408;
      }
      if (!y.a.bZh.BB())
      {
        com.tencent.tinker.lib.f.a.w("Tinker.SyncResponseProcessor", "patch applying is blocked by TinkerEnsuranceOnFault, update basepack with different clientver to recover.", new Object[0]);
        break label408;
      }
      paramString = ((ShareSecurityCheck)localObject3).dWD();
      if (paramString != null)
      {
        paramString = (String)paramString.get("patch.client.ver");
        if (TextUtils.isEmpty(paramString)) {
          break label647;
        }
        paramString = com.tencent.mm.plugin.hp.tinker.b.eP(com.tencent.mm.loader.j.a.CLIENT_VERSION, paramString);
        localObject1 = com.tencent.mm.plugin.hp.tinker.b.bIl();
        localObject3 = paramString.xC(1);
        if (((SharedPreferences)localObject1).contains((String)localObject3))
        {
          paramLong = ((SharedPreferences)localObject1).getLong((String)localObject3, 0L);
          paramString.T(1, System.currentTimeMillis() - paramLong);
          ((SharedPreferences)localObject1).edit().remove((String)localObject3).commit();
        }
        com.tencent.mm.plugin.hp.tinker.b.ahe(paramString.xC(2));
      }
      for (;;)
      {
        com.tencent.tinker.lib.e.c.ce(localContext, ((File)localObject2).getAbsolutePath());
        break;
        label647:
        ab.e("Tinker.SyncResponseProcessor", "[-] Fail to get patch clientversion.");
      }
      paramString = ((File)localObject2).getAbsolutePath();
      localObject1 = this.nKl;
      ab.i("MicroMsg.Tinker.CTinkerInstaller", "onReceiveUpgradeBsDiff bsDiffPath:%s , new apk md5：%s", new Object[] { paramString, ((com.tencent.mm.plugin.hp.d.b)localObject1).nKS });
      localObject2 = com.tencent.mm.plugin.hp.d.d.QT(((com.tencent.mm.plugin.hp.d.b)localObject1).nKS);
      g.RO().ac(new a.1((String)localObject2, localContext, paramString, (com.tencent.mm.plugin.hp.d.b)localObject1));
      break label408;
      ab.i("Tinker.SyncResponseProcessor", "coming soon! now can not support full apk update.");
      break label408;
    }
  }
  
  final void bIg()
  {
    AppMethodBeat.i(90598);
    if (!com.tencent.mm.compatible.util.h.getExternalStorageState().equals("mounted"))
    {
      ab.e("Tinker.SyncResponseProcessor", "no sdcard.");
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(614L, 50L, 1L, false);
      AppMethodBeat.o(90598);
      return;
    }
    if (!com.tencent.mm.compatible.util.f.gc(this.nKl.fileSize))
    {
      ab.e("Tinker.SyncResponseProcessor", "sdcard is full.");
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(614L, 51L, 1L, false);
      if (this.nKl.nKN.intValue() == 3) {
        com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(614L, 55L, 1L, false);
      }
      AppMethodBeat.o(90598);
      return;
    }
    if ((this.nKl.nKN.intValue() == 3) && (!bo.isNullOrNil(this.nKl.nKS)) && (com.tencent.mm.a.e.cN(com.tencent.mm.plugin.hp.d.d.QT(this.nKl.nKS))) && (com.tencent.mm.c.a.jdMethod_do(com.tencent.mm.plugin.hp.d.d.QT(this.nKl.nKS))))
    {
      Context localContext = ah.getContext();
      if (bo.isNullOrNil(this.nKl.bIu())) {}
      for (String str = localContext.getString(2131304442);; str = this.nKl.bIu())
      {
        ckf localckf = new ckf();
        localckf.nKR = this.nKl.nKR;
        localckf.title = localContext.getString(2131300104);
        localckf.xUl = localContext.getString(2131300742);
        localckf.nDF = localContext.getString(2131304423);
        localckf.nKS = this.nKl.nKS;
        localckf.nKT = this.nKl.nKT;
        localckf.iHT = this.nKl.fileSize;
        localckf.nKP = this.nKl.nKP;
        localckf.bWN = this.nKl.nKQ;
        localckf.versionCode = this.nKl.versionCode;
        localckf.xUk = com.tencent.mm.plugin.hp.d.d.QT(this.nKl.nKS);
        localckf.bjm = str;
        com.tencent.mm.plugin.hp.d.d.a(localckf);
        ab.i("Tinker.SyncResponseProcessor", "file is exist. need no to download. newApkMd5:%s", new Object[] { this.nKl.nKS });
        AppMethodBeat.o(90598);
        return;
      }
    }
    this.nKl.nKN.intValue();
    bIh();
    AppMethodBeat.o(90598);
  }
  
  public final void hx(long paramLong)
  {
    AppMethodBeat.i(90605);
    ab.d("Tinker.SyncResponseProcessor", "onTaskProgressChanged taskId:%d", new Object[] { Long.valueOf(paramLong) });
    AppMethodBeat.o(90605);
  }
  
  public final void hy(long paramLong) {}
  
  public final void i(long paramLong, String paramString)
  {
    AppMethodBeat.i(90606);
    ab.d("Tinker.SyncResponseProcessor", "onTaskResumed taskId:%d filePath:%s", new Object[] { Long.valueOf(paramLong), paramString });
    AppMethodBeat.o(90606);
  }
  
  public final boolean iv(boolean paramBoolean)
  {
    AppMethodBeat.i(90597);
    com.tencent.tinker.lib.f.a.i("Tinker.SyncResponseProcessor", "process tinker response: %s", new Object[] { this.nKl.toString() });
    Object localObject1 = this.nKl;
    int i;
    if ((((com.tencent.mm.plugin.hp.d.b)localObject1).nKL.intValue() > 4) || (((com.tencent.mm.plugin.hp.d.b)localObject1).nKL.intValue() <= 0))
    {
      ab.e("Tinker.TinkerSyncResponse", "responseState: %d must between %d and %d", new Object[] { ((com.tencent.mm.plugin.hp.d.b)localObject1).nKL, Integer.valueOf(1), Integer.valueOf(4) });
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(614L, 24L, 1L, false);
      i = 0;
    }
    while (i == 0)
    {
      com.tencent.tinker.lib.f.a.i("Tinker.SyncResponseProcessor", "process check response fail, just return", new Object[0]);
      AppMethodBeat.o(90597);
      return false;
      if (((com.tencent.mm.plugin.hp.d.b)localObject1).bIs())
      {
        if (TextUtils.isEmpty(((com.tencent.mm.plugin.hp.d.b)localObject1).nKR))
        {
          ab.e("Tinker.TinkerSyncResponse", "sync response patchId should not be null");
          com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(614L, 25L, 1L, false);
          i = 0;
          continue;
        }
        if (TextUtils.isEmpty(((com.tencent.mm.plugin.hp.d.b)localObject1).nKP))
        {
          ab.e("Tinker.TinkerSyncResponse", "sync response cdnUrl should not be null");
          com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(614L, 26L, 1L, false);
          i = 0;
          continue;
        }
        if (TextUtils.isEmpty(((com.tencent.mm.plugin.hp.d.b)localObject1).nKQ))
        {
          ab.e("Tinker.TinkerSyncResponse", "sync response fileMd5 should not be null");
          com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(614L, 27L, 1L, false);
          i = 0;
          continue;
        }
      }
      i = 1;
    }
    if (this.nKl.nKL.intValue() == 3)
    {
      i = 1;
      if (i == 0) {
        break label395;
      }
      localObject2 = ah.getContext();
      localObject1 = com.tencent.tinker.lib.e.a.jo((Context)localObject2);
      if (((com.tencent.tinker.lib.e.a)localObject1).BsU) {
        break label317;
      }
      com.tencent.tinker.lib.f.a.w("Tinker.SyncResponseProcessor", "SyncResponseProcessor: onPatchRollback, tinker is not loaded, just return", new Object[0]);
    }
    for (;;)
    {
      AppMethodBeat.o(90597);
      return true;
      i = 0;
      break;
      label317:
      com.tencent.tinker.lib.f.a.i("Tinker.SyncResponseProcessor", "tinker wait screen to clean patch and kill all process", new Object[0]);
      new l(ah.getContext(), new l.a()
      {
        public final void da(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(90595);
          if (!paramAnonymousBoolean)
          {
            com.tencent.tinker.lib.f.a.i("Tinker.SyncResponseProcessor", "app is background now, i can kill quietly", new Object[0]);
            ShareTinkerInternals.jJ(this.val$context);
            this.nKo.bIo();
            Process.killProcess(Process.myPid());
          }
          AppMethodBeat.o(90595);
        }
      });
      localObject2 = new SharePatchInfo(((com.tencent.tinker.lib.e.a)localObject1).BsT.BsY, "00000000000000000000000000000000", false, true, Build.FINGERPRINT, "odex");
      SharePatchInfo.a(((com.tencent.tinker.lib.e.a)localObject1).BsQ, (SharePatchInfo)localObject2, ((com.tencent.tinker.lib.e.a)localObject1).BsR);
    }
    label395:
    if (!this.nKl.bIs())
    {
      AppMethodBeat.o(90597);
      return true;
    }
    if (this.nKl.bIv())
    {
      com.tencent.tinker.lib.f.a.w("Tinker.SyncResponseProcessor", "is lower version skip.", new Object[0]);
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(614L, 78L, 1L, false);
      AppMethodBeat.o(90597);
      return true;
    }
    if (com.tencent.mm.sdk.a.b.dsi())
    {
      com.tencent.tinker.lib.f.a.w("Tinker.SyncResponseProcessor", "[tomys] patch downloading is blocked by assist.", new Object[0]);
      AppMethodBeat.o(90597);
      return true;
    }
    Object localObject3;
    if ((this.nKl.nKN.intValue() == 3) && (!bo.isNullOrNil(this.nKl.clientVersion)) && (com.tencent.mm.plugin.hp.d.c.QR(this.nKl.clientVersion)))
    {
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(614L, 77L, 1L, false);
      localObject3 = this.nKl;
      Context localContext = ah.getContext();
      if (bo.isNullOrNil(((com.tencent.mm.plugin.hp.d.b)localObject3).nKU))
      {
        localObject1 = localContext.getString(2131297054);
        if (!bo.isNullOrNil(((com.tencent.mm.plugin.hp.d.b)localObject3).nKV)) {
          break label793;
        }
        localObject2 = "";
        label584:
        if (!bo.isNullOrNil(((com.tencent.mm.plugin.hp.d.b)localObject3).nKW)) {
          break label803;
        }
        localObject3 = "http://support.weixin.qq.com/cgi-bin/mmsupport-bin/readtemplate?t=page/android_exp__index";
        label600:
        Intent localIntent = new Intent("android.intent.action.VIEW");
        localIntent.setClassName(ah.getPackageName(), ah.getPackageName() + ".plugin.webview.ui.tools.WebViewUI");
        localIntent.putExtra("rawUrl", (String)localObject3);
        localIntent.putExtra("useJs", true);
        localIntent.putExtra("vertical_scroll", true);
        localIntent.setFlags(872415232);
        localObject3 = PendingIntent.getActivity(localContext, 0, localIntent, 268435456);
        localObject1 = com.tencent.mm.bp.a.br(localContext, "reminder_channel_id").h(null).g(System.currentTimeMillis()).e((CharSequence)localObject1).f((CharSequence)localObject2);
        ((s.c)localObject1).ya = ((PendingIntent)localObject3);
        ((s.c)localObject1).Y(com.tencent.mm.bp.a.bYt());
        localObject1 = ((s.c)localObject1).build();
        ((Notification)localObject1).flags |= 0x10;
        if (!paramBoolean) {
          break label813;
        }
        ((NotificationManager)localContext.getSystemService("notification")).notify(19841110, (Notification)localObject1);
      }
      for (;;)
      {
        AppMethodBeat.o(90597);
        return true;
        localObject1 = ((com.tencent.mm.plugin.hp.d.b)localObject3).nKU;
        break;
        label793:
        localObject2 = ((com.tencent.mm.plugin.hp.d.b)localObject3).nKV;
        break label584;
        label803:
        localObject3 = ((com.tencent.mm.plugin.hp.d.b)localObject3).nKW;
        break label600;
        label813:
        ab.i("Tinker.SyncResponseProcessor", "ignore action when load from cache,when response is alpha version");
      }
    }
    com.tencent.tinker.lib.f.a.i("Tinker.SyncResponseProcessor", "check need show before download. network type:%d msg:%s", new Object[] { this.nKl.nKO, this.nKl.bIu() });
    Object localObject2 = ah.getContext();
    if ((this.nKl.nKO.intValue() == 2) && (at.isMobile(ah.getContext())) && (this.nKl.bIt())) {
      if (!com.tencent.mm.plugin.hp.tinker.h.az((Context)localObject2, this.nKl.nKR)) {
        if (this.nKl.nKN.intValue() == 2)
        {
          localObject1 = ah.getContext().getString(2131300106, new Object[] { this.nKl.bIu(), ah.getContext().getString(2131304431), bo.hk(this.nKl.fileSize) });
          i.a(ah.getContext().getString(2131300104), (String)localObject1, ah.getContext().getString(2131304435), new e.1(this), ah.getContext().getString(2131304423), new e.2(this, (Context)localObject2));
          a.xt(4);
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(90597);
      return true;
      if (this.nKl.nKN.intValue() != 3) {
        break;
      }
      ab.d("Tinker.SyncResponseProcessor", "showUpdateDialog ");
      if (bo.isNullOrNil(this.nKl.bIu())) {}
      for (localObject1 = ((Context)localObject2).getString(2131304442);; localObject1 = this.nKl.bIu())
      {
        localObject3 = new ckf();
        ((ckf)localObject3).nKR = this.nKl.nKR;
        ((ckf)localObject3).title = ((Context)localObject2).getString(2131300104);
        ((ckf)localObject3).xUl = ((Context)localObject2).getString(2131304435);
        ((ckf)localObject3).nDF = ((Context)localObject2).getString(2131304423);
        ((ckf)localObject3).nKS = this.nKl.nKS;
        ((ckf)localObject3).nKT = this.nKl.nKT;
        ((ckf)localObject3).iHT = this.nKl.fileSize;
        ((ckf)localObject3).nKP = this.nKl.nKP;
        ((ckf)localObject3).bWN = this.nKl.nKQ;
        ((ckf)localObject3).versionCode = this.nKl.versionCode;
        ((ckf)localObject3).xUk = com.tencent.mm.plugin.hp.d.d.QT(this.nKl.nKS);
        ((ckf)localObject3).bjm = ((String)localObject1);
        com.tencent.mm.plugin.hp.d.d.a((ckf)localObject3);
        break;
      }
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(614L, 44L, 1L, false);
      ab.i("Tinker.SyncResponseProcessor", "this patch id :%s show cancel before user, need show again.", new Object[] { this.nKl.nKR });
      continue;
      if ((this.nKl.bIr()) && (!com.tencent.mm.plugin.hp.tinker.h.az((Context)localObject2, this.nKl.nKR))) {
        bIg();
      }
    }
  }
  
  public final void onTaskPaused(long paramLong)
  {
    AppMethodBeat.i(90604);
    ab.d("Tinker.SyncResponseProcessor", "onTaskPaused taskId:%d", new Object[] { Long.valueOf(paramLong) });
    AppMethodBeat.o(90604);
  }
  
  public final void onTaskRemoved(long paramLong)
  {
    AppMethodBeat.i(90603);
    ab.i("Tinker.SyncResponseProcessor", "onTaskRemoved taskId:%d", new Object[] { Long.valueOf(paramLong) });
    com.tencent.mm.plugin.downloader.model.f.bjl();
    com.tencent.mm.plugin.downloader.model.c.b(this);
    AppMethodBeat.o(90603);
  }
  
  public final void onTaskStarted(long paramLong, String paramString)
  {
    AppMethodBeat.i(90600);
    ab.d("Tinker.SyncResponseProcessor", "onTaskStarted taskId %d", new Object[] { Long.valueOf(paramLong) });
    AppMethodBeat.o(90600);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.hp.b.e
 * JD-Core Version:    0.7.0.1
 */