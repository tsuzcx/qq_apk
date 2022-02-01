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
import com.tencent.mm.app.ag;
import com.tencent.mm.app.ag.a;
import com.tencent.mm.modelmulti.m.a;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.downloader.model.g.a;
import com.tencent.mm.plugin.hp.a.a.1;
import com.tencent.mm.protocal.protobuf.dhl;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.SharePatchInfo;
import com.tencent.tinker.loader.shareutil.ShareSecurityCheck;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import com.tencent.tinker.loader.shareutil.ShareTinkerLog;
import java.io.File;
import java.util.Map;

public final class e
  implements com.tencent.mm.plugin.downloader.model.m
{
  final com.tencent.mm.plugin.hp.c.b tFH;
  private long tFI;
  
  public e(com.tencent.mm.plugin.hp.c.b paramb)
  {
    AppMethodBeat.i(117424);
    this.tFH = paramb;
    f.bXJ();
    com.tencent.mm.plugin.downloader.model.c.a(this);
    AppMethodBeat.o(117424);
  }
  
  private void cTi()
  {
    AppMethodBeat.i(117427);
    ai.getContext();
    com.tencent.mm.plugin.hp.c.d.cTC();
    com.tencent.mm.plugin.hp.c.d.cTD();
    g.a locala = new g.a();
    locala.WD(this.tFH.gnO);
    locala.WF(this.tFH.ntl);
    locala.WG(this.tFH.ntk);
    locala.jF(false);
    locala.jH(true);
    locala.AG(2);
    locala.jG(false);
    this.tFI = f.bXJ().a(locala.oJg);
    ac.i("Tinker.SyncResponseProcessor", "Download task id is :%d", new Object[] { Long.valueOf(this.tFI) });
    com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(614L, 2L, 1L, false);
    if (ax.isWifi(ai.getContext())) {
      com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(614L, 7L, 1L, false);
    }
    for (;;)
    {
      if ((this.tFH.nti.intValue() == 2) && (!bs.isNullOrNil(this.tFH.clientVersion))) {
        com.tencent.mm.plugin.hp.tinker.b.hh(com.tencent.mm.loader.j.a.gMJ, this.tFH.clientVersion).cTo();
      }
      if (this.tFH.nti.intValue() == 3)
      {
        com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(614L, 56L, 1L, false);
        ac.d("Tinker.SyncResponseProcessor", "boots download start silent.");
      }
      AppMethodBeat.o(117427);
      return;
      com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(614L, 8L, 1L, false);
    }
  }
  
  public final void a(long paramLong, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(117430);
    ac.w("Tinker.SyncResponseProcessor", "onTaskFailed");
    if (this.tFI != paramLong)
    {
      ac.i("Tinker.SyncResponseProcessor", "onTaskFailed ignore. id is no equal. download id :%s callback id:%s", new Object[] { Long.valueOf(this.tFI), Long.valueOf(paramLong) });
      AppMethodBeat.o(117430);
      return;
    }
    b.GT(2);
    if (this.tFH.nti.intValue() == 3) {
      com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(614L, 51L, 1L, false);
    }
    f.bXJ();
    com.tencent.mm.plugin.downloader.model.c.b(this);
    AppMethodBeat.o(117430);
  }
  
  public final void b(long paramLong, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(117429);
    ac.i("Tinker.SyncResponseProcessor", "onTaskFinished id:%d path:%s hasChangeUrl:%s", new Object[] { Long.valueOf(paramLong), paramString, Boolean.valueOf(paramBoolean) });
    if (this.tFI != paramLong)
    {
      ac.i("Tinker.SyncResponseProcessor", "onTaskFinished ignore. id is no equal. download id :%s callback id:%s", new Object[] { Long.valueOf(this.tFI), Long.valueOf(paramLong) });
      AppMethodBeat.o(117429);
      return;
    }
    b.GS(2);
    Context localContext = ai.getContext();
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
        ac.printErrStackTrace("Tinker.SyncResponseProcessor", paramString, "verify patch signature failed.", new Object[0]);
        com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(614L, 39L, 1L, false);
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
      switch (this.tFH.nti.intValue())
      {
      }
    }
    if ((this.tFH.nti.intValue() == 2) && (!paramBoolean))
    {
      ShareTinkerLog.v("Tinker.SyncResponseProcessor", "verify patch signature failed.", new Object[0]);
      b.GT(2);
      com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(614L, 31L, 1L, false);
      if (this.tFH.nti.intValue() == 3)
      {
        com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(614L, 54L, 1L, false);
        ac.d("Tinker.SyncResponseProcessor", "boots download patch md5 no equal.");
      }
      f.bXJ();
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
      com.tencent.mm.plugin.hp.tinker.h.aF(localContext, this.tFH.clientVersion);
      com.tencent.mm.plugin.hp.tinker.h.aE(localContext, com.tencent.mm.plugin.hp.c.b.a(this.tFH.tGt, 2));
      break;
      ShareTinkerLog.v("Tinker.SyncResponseProcessor", "onReceiveUpgradePatch. try to start apply", new Object[0]);
      if (!ai.eVc()) {
        if (com.tencent.mm.sdk.a.b.eUn())
        {
          ShareTinkerLog.v("Tinker.SyncResponseProcessor", "[tomys] patch applying is blocked by assist.", new Object[0]);
        }
        else if (!ag.a.cJV.KW())
        {
          ShareTinkerLog.v("Tinker.SyncResponseProcessor", "patch applying is blocked by TinkerEnsuranceOnFault, update basepack with different clientver to recover.", new Object[0]);
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
            paramString = com.tencent.mm.plugin.hp.tinker.b.hh(com.tencent.mm.loader.j.a.gMJ, paramString);
            localObject1 = com.tencent.mm.plugin.hp.tinker.b.cTn();
            localObject3 = paramString.GZ(1);
            if (((SharedPreferences)localObject1).contains((String)localObject3))
            {
              paramLong = ((SharedPreferences)localObject1).getLong((String)localObject3, 0L);
              paramString.ag(1, System.currentTimeMillis() - paramLong);
              ((SharedPreferences)localObject1).edit().remove((String)localObject3).commit();
            }
            com.tencent.mm.plugin.hp.tinker.b.aiA(paramString.GZ(2));
          }
          for (;;)
          {
            com.tencent.tinker.lib.e.c.cz(localContext, ((File)localObject2).getAbsolutePath());
            break;
            label626:
            ac.e("Tinker.SyncResponseProcessor", "[-] Fail to get patch clientversion.");
          }
          paramString = ((File)localObject2).getAbsolutePath();
          localObject1 = this.tFH;
          ac.i("MicroMsg.Tinker.CTinkerInstaller", "onReceiveUpgradeBsDiff bsDiffPath:%s , new apk md5：%s", new Object[] { paramString, ((com.tencent.mm.plugin.hp.c.b)localObject1).tGu });
          localObject2 = com.tencent.mm.plugin.hp.c.d.aiE(((com.tencent.mm.plugin.hp.c.b)localObject1).tGu);
          com.tencent.mm.kernel.g.agU().az(new a.1((String)localObject2, localContext, paramString, (com.tencent.mm.plugin.hp.c.b)localObject1));
          continue;
          ac.i("Tinker.SyncResponseProcessor", "coming soon! now can not support full apk update.");
        }
      }
    }
  }
  
  final void cTh()
  {
    AppMethodBeat.i(117426);
    if (!com.tencent.mm.compatible.util.g.getExternalStorageState().equals("mounted"))
    {
      ac.e("Tinker.SyncResponseProcessor", "no sdcard.");
      com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(614L, 50L, 1L, false);
      AppMethodBeat.o(117426);
      return;
    }
    if (!com.tencent.mm.compatible.util.e.oR(this.tFH.fileSize))
    {
      ac.e("Tinker.SyncResponseProcessor", "sdcard is full.");
      com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(614L, 51L, 1L, false);
      if (this.tFH.nti.intValue() == 3) {
        com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(614L, 55L, 1L, false);
      }
      AppMethodBeat.o(117426);
      return;
    }
    if ((this.tFH.nti.intValue() == 3) && (!bs.isNullOrNil(this.tFH.tGu)) && (com.tencent.mm.vfs.i.eA(com.tencent.mm.plugin.hp.c.d.aiE(this.tFH.tGu))) && (com.tencent.mm.d.a.eb(com.tencent.mm.plugin.hp.c.d.aiE(this.tFH.tGu))))
    {
      Context localContext = ai.getContext();
      if (bs.isNullOrNil(this.tFH.cTz())) {}
      for (String str = localContext.getString(2131764588);; str = this.tFH.cTz())
      {
        dhl localdhl = new dhl();
        localdhl.ntl = this.tFH.ntl;
        localdhl.title = localContext.getString(2131759571);
        localdhl.FQI = localContext.getString(2131760343);
        localdhl.tuX = localContext.getString(2131764569);
        localdhl.tGu = this.tFH.tGu;
        localdhl.tGv = this.tFH.tGv;
        localdhl.lTX = this.tFH.fileSize;
        localdhl.gnO = this.tFH.gnO;
        localdhl.patchMd5 = this.tFH.ntk;
        localdhl.versionCode = this.tFH.versionCode;
        localdhl.FQH = com.tencent.mm.plugin.hp.c.d.aiE(this.tFH.tGu);
        localdhl.bIO = str;
        com.tencent.mm.plugin.hp.c.d.a(localdhl);
        ac.i("Tinker.SyncResponseProcessor", "file is exist. need no to download. newApkMd5:%s", new Object[] { this.tFH.tGu });
        AppMethodBeat.o(117426);
        return;
      }
    }
    this.tFH.nti.intValue();
    cTi();
    AppMethodBeat.o(117426);
  }
  
  public final void j(long paramLong, String paramString)
  {
    AppMethodBeat.i(117434);
    ac.d("Tinker.SyncResponseProcessor", "onTaskResumed taskId:%d filePath:%s", new Object[] { Long.valueOf(paramLong), paramString });
    AppMethodBeat.o(117434);
  }
  
  public final boolean nd(boolean paramBoolean)
  {
    AppMethodBeat.i(117425);
    ShareTinkerLog.v("Tinker.SyncResponseProcessor", "process tinker response: %s", new Object[] { this.tFH.toString() });
    Object localObject1 = this.tFH;
    int i;
    if ((((com.tencent.mm.plugin.hp.c.b)localObject1).nth.intValue() > 4) || (((com.tencent.mm.plugin.hp.c.b)localObject1).nth.intValue() <= 0))
    {
      ac.e("Tinker.TinkerSyncResponse", "responseState: %d must between %d and %d", new Object[] { ((com.tencent.mm.plugin.hp.c.b)localObject1).nth, Integer.valueOf(1), Integer.valueOf(4) });
      com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(614L, 24L, 1L, false);
      i = 0;
    }
    while (i == 0)
    {
      ShareTinkerLog.v("Tinker.SyncResponseProcessor", "process check response fail, just return", new Object[0]);
      AppMethodBeat.o(117425);
      return false;
      if (((com.tencent.mm.plugin.hp.c.b)localObject1).cTx())
      {
        if (TextUtils.isEmpty(((com.tencent.mm.plugin.hp.c.b)localObject1).ntl))
        {
          ac.e("Tinker.TinkerSyncResponse", "sync response patchId should not be null");
          com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(614L, 25L, 1L, false);
          i = 0;
          continue;
        }
        if (TextUtils.isEmpty(((com.tencent.mm.plugin.hp.c.b)localObject1).gnO))
        {
          ac.e("Tinker.TinkerSyncResponse", "sync response cdnUrl should not be null");
          com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(614L, 26L, 1L, false);
          i = 0;
          continue;
        }
        if (TextUtils.isEmpty(((com.tencent.mm.plugin.hp.c.b)localObject1).ntk))
        {
          ac.e("Tinker.TinkerSyncResponse", "sync response fileMd5 should not be null");
          com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(614L, 27L, 1L, false);
          i = 0;
          continue;
        }
      }
      i = 1;
    }
    if (this.tFH.nth.intValue() == 3)
    {
      i = 1;
      if (i == 0) {
        break label395;
      }
      localObject2 = ai.getContext();
      localObject1 = com.tencent.tinker.lib.e.a.kX((Context)localObject2);
      if (((com.tencent.tinker.lib.e.a)localObject1).Kra) {
        break label317;
      }
      ShareTinkerLog.v("Tinker.SyncResponseProcessor", "SyncResponseProcessor: onPatchRollback, tinker is not loaded, just return", new Object[0]);
    }
    for (;;)
    {
      AppMethodBeat.o(117425);
      return true;
      i = 0;
      break;
      label317:
      ShareTinkerLog.v("Tinker.SyncResponseProcessor", "tinker wait screen to clean patch and kill all process", new Object[0]);
      new com.tencent.mm.modelmulti.m(ai.getContext(), new m.a()
      {
        public final void cg(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(117423);
          if (!paramAnonymousBoolean)
          {
            ShareTinkerLog.v("Tinker.SyncResponseProcessor", "app is background now, i can kill quietly", new Object[0]);
            ShareTinkerInternals.killAllOtherProcess(this.val$context);
            this.tFK.cTr();
            Process.killProcess(Process.myPid());
          }
          AppMethodBeat.o(117423);
        }
      });
      localObject2 = new SharePatchInfo(((com.tencent.tinker.lib.e.a)localObject1).KqZ.Kre, "00000000000000000000000000000000", false, true, Build.FINGERPRINT, "odex");
      SharePatchInfo.rewritePatchInfoFileWithLock(((com.tencent.tinker.lib.e.a)localObject1).KqW, (SharePatchInfo)localObject2, ((com.tencent.tinker.lib.e.a)localObject1).KqX);
    }
    label395:
    if (!this.tFH.cTx())
    {
      AppMethodBeat.o(117425);
      return true;
    }
    if (this.tFH.cTA())
    {
      ShareTinkerLog.v("Tinker.SyncResponseProcessor", "is lower version skip.", new Object[0]);
      com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(614L, 78L, 1L, false);
      AppMethodBeat.o(117425);
      return true;
    }
    if (com.tencent.mm.sdk.a.b.eUn())
    {
      ShareTinkerLog.v("Tinker.SyncResponseProcessor", "[tomys] patch downloading is blocked by assist.", new Object[0]);
      AppMethodBeat.o(117425);
      return true;
    }
    Object localObject3;
    if ((this.tFH.nti.intValue() == 3) && (!bs.isNullOrNil(this.tFH.clientVersion)) && (com.tencent.mm.plugin.hp.c.c.aiC(this.tFH.clientVersion)))
    {
      com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(614L, 77L, 1L, false);
      localObject3 = this.tFH;
      Context localContext = ai.getContext();
      if (bs.isNullOrNil(((com.tencent.mm.plugin.hp.c.b)localObject3).tGw))
      {
        localObject1 = localContext.getString(2131755871);
        if (!bs.isNullOrNil(((com.tencent.mm.plugin.hp.c.b)localObject3).tGx)) {
          break label793;
        }
        localObject2 = "";
        label584:
        if (!bs.isNullOrNil(((com.tencent.mm.plugin.hp.c.b)localObject3).tGy)) {
          break label803;
        }
        localObject3 = "http://support.weixin.qq.com/cgi-bin/mmsupport-bin/readtemplate?t=page/android_exp__index";
        label600:
        Intent localIntent = new Intent("android.intent.action.VIEW");
        localIntent.setClassName(ai.getPackageName(), ai.getPackageName() + ".plugin.webview.ui.tools.WebViewUI");
        localIntent.putExtra("rawUrl", (String)localObject3);
        localIntent.putExtra("useJs", true);
        localIntent.putExtra("vertical_scroll", true);
        localIntent.setFlags(872415232);
        localObject3 = PendingIntent.getActivity(localContext, 0, localIntent, 268435456);
        localObject1 = com.tencent.mm.bq.a.bE(localContext, "reminder_channel_id").i(null).i(System.currentTimeMillis()).f((CharSequence)localObject1).g((CharSequence)localObject2);
        ((s.c)localObject1).Fu = ((PendingIntent)localObject3);
        ((s.c)localObject1).as(com.tencent.mm.bq.a.dlN());
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
        localObject1 = ((com.tencent.mm.plugin.hp.c.b)localObject3).tGw;
        break;
        label793:
        localObject2 = ((com.tencent.mm.plugin.hp.c.b)localObject3).tGx;
        break label584;
        label803:
        localObject3 = ((com.tencent.mm.plugin.hp.c.b)localObject3).tGy;
        break label600;
        label813:
        ac.i("Tinker.SyncResponseProcessor", "ignore action when load from cache,when response is alpha version");
      }
    }
    ShareTinkerLog.v("Tinker.SyncResponseProcessor", "check need show before download. network type:%d msg:%s", new Object[] { this.tFH.ntj, this.tFH.cTz() });
    Object localObject2 = ai.getContext();
    if ((this.tFH.ntj.intValue() == 2) && (ax.isMobile(ai.getContext())) && (this.tFH.cTy())) {
      if (!com.tencent.mm.plugin.hp.tinker.h.aC((Context)localObject2, this.tFH.ntl)) {
        if (this.tFH.nti.intValue() == 2)
        {
          localObject1 = ai.getContext().getString(2131759573, new Object[] { this.tFH.cTz(), ai.getContext().getString(2131764577), bs.qz(this.tFH.fileSize) });
          i.a(ai.getContext().getString(2131759571), (String)localObject1, ai.getContext().getString(2131764581), new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(117421);
              if (e.this.tFH.cTw()) {
                e.this.cTh();
              }
              AppMethodBeat.o(117421);
            }
          }, ai.getContext().getString(2131764569), new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(117422);
              com.tencent.mm.plugin.hp.tinker.h.aD(this.val$context, e.this.tFH.ntl);
              AppMethodBeat.o(117422);
            }
          });
          a.GR(4);
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(117425);
      return true;
      if (this.tFH.nti.intValue() != 3) {
        break;
      }
      ac.d("Tinker.SyncResponseProcessor", "showUpdateDialog ");
      if (bs.isNullOrNil(this.tFH.cTz())) {}
      for (localObject1 = ((Context)localObject2).getString(2131764588);; localObject1 = this.tFH.cTz())
      {
        localObject3 = new dhl();
        ((dhl)localObject3).ntl = this.tFH.ntl;
        ((dhl)localObject3).title = ((Context)localObject2).getString(2131759571);
        ((dhl)localObject3).FQI = ((Context)localObject2).getString(2131764581);
        ((dhl)localObject3).tuX = ((Context)localObject2).getString(2131764569);
        ((dhl)localObject3).tGu = this.tFH.tGu;
        ((dhl)localObject3).tGv = this.tFH.tGv;
        ((dhl)localObject3).lTX = this.tFH.fileSize;
        ((dhl)localObject3).gnO = this.tFH.gnO;
        ((dhl)localObject3).patchMd5 = this.tFH.ntk;
        ((dhl)localObject3).versionCode = this.tFH.versionCode;
        ((dhl)localObject3).FQH = com.tencent.mm.plugin.hp.c.d.aiE(this.tFH.tGu);
        ((dhl)localObject3).bIO = ((String)localObject1);
        com.tencent.mm.plugin.hp.c.d.a((dhl)localObject3);
        break;
      }
      com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(614L, 44L, 1L, false);
      ac.i("Tinker.SyncResponseProcessor", "this patch id :%s show cancel before user, need show again.", new Object[] { this.tFH.ntl });
      continue;
      if ((this.tFH.cTw()) && (!com.tencent.mm.plugin.hp.tinker.h.aC((Context)localObject2, this.tFH.ntl))) {
        cTh();
      }
    }
  }
  
  public final void onTaskPaused(long paramLong)
  {
    AppMethodBeat.i(117432);
    ac.d("Tinker.SyncResponseProcessor", "onTaskPaused taskId:%d", new Object[] { Long.valueOf(paramLong) });
    AppMethodBeat.o(117432);
  }
  
  public final void onTaskRemoved(long paramLong)
  {
    AppMethodBeat.i(117431);
    ac.i("Tinker.SyncResponseProcessor", "onTaskRemoved taskId:%d", new Object[] { Long.valueOf(paramLong) });
    f.bXJ();
    com.tencent.mm.plugin.downloader.model.c.b(this);
    AppMethodBeat.o(117431);
  }
  
  public final void onTaskStarted(long paramLong, String paramString)
  {
    AppMethodBeat.i(117428);
    ac.d("Tinker.SyncResponseProcessor", "onTaskStarted taskId %d", new Object[] { Long.valueOf(paramLong) });
    AppMethodBeat.o(117428);
  }
  
  public final void qN(long paramLong)
  {
    AppMethodBeat.i(117433);
    ac.d("Tinker.SyncResponseProcessor", "onTaskProgressChanged taskId:%d", new Object[] { Long.valueOf(paramLong) });
    AppMethodBeat.o(117433);
  }
  
  public final void qO(long paramLong) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.hp.b.e
 * JD-Core Version:    0.7.0.1
 */