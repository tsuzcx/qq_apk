package com.tencent.mm.plugin.hp.b;

import android.app.Notification;
import android.app.Notification.Builder;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.mm.R.g;
import com.tencent.mm.R.l;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.model.au;
import com.tencent.mm.modelmulti.l;
import com.tencent.mm.plugin.downloader.model.e.a;
import com.tencent.mm.plugin.downloader.model.k;
import com.tencent.mm.plugin.hp.a.a.1;
import com.tencent.mm.plugin.hp.tinker.g;
import com.tencent.mm.protocal.c.bxs;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.SharePatchInfo;
import com.tencent.tinker.loader.shareutil.ShareSecurityCheck;
import java.io.File;

public final class e
  implements k
{
  final com.tencent.mm.plugin.hp.d.b lmT;
  private long lmU;
  
  public e(com.tencent.mm.plugin.hp.d.b paramb)
  {
    this.lmT = paramb;
    com.tencent.mm.plugin.downloader.model.d.aFP();
    com.tencent.mm.plugin.downloader.model.b.a(this);
  }
  
  public final void b(long paramLong, int paramInt, boolean paramBoolean)
  {
    y.w("Tinker.SyncResponseProcessor", "onTaskFailed");
    if (this.lmU != paramLong)
    {
      y.i("Tinker.SyncResponseProcessor", "onTaskFailed ignore. id is no equal. download id :%s callback id:%s", new Object[] { Long.valueOf(this.lmU), Long.valueOf(paramLong) });
      return;
    }
    b.sx(2);
    if (this.lmT.lnu.intValue() == 3) {
      com.tencent.mm.plugin.report.service.h.nFQ.a(614L, 51L, 1L, false);
    }
    com.tencent.mm.plugin.downloader.model.d.aFP();
    com.tencent.mm.plugin.downloader.model.b.b(this);
  }
  
  public final void b(long paramLong, String paramString, boolean paramBoolean)
  {
    y.i("Tinker.SyncResponseProcessor", "onTaskFinished id:%d path:%s hasChangeUrl:%s", new Object[] { Long.valueOf(paramLong), paramString, Boolean.valueOf(paramBoolean) });
    if (this.lmU != paramLong)
    {
      y.i("Tinker.SyncResponseProcessor", "onTaskFinished ignore. id is no equal. download id :%s callback id:%s", new Object[] { Long.valueOf(this.lmU), Long.valueOf(paramLong) });
      return;
    }
    b.sw(2);
    Context localContext = ae.getContext();
    Object localObject2 = new File(paramString);
    paramString = new ShareSecurityCheck(localContext);
    if ((this.lmT.lnu.intValue() == 2) && (!paramString.al((File)localObject2)))
    {
      com.tencent.tinker.lib.f.a.i("Tinker.SyncResponseProcessor", "verify patch signature failed.", new Object[0]);
      b.sx(2);
      com.tencent.mm.plugin.report.service.h.nFQ.a(614L, 31L, 1L, false);
      if (this.lmT.lnu.intValue() == 3)
      {
        com.tencent.mm.plugin.report.service.h.nFQ.a(614L, 54L, 1L, false);
        y.d("Tinker.SyncResponseProcessor", "boots download patch md5 no equal.");
      }
      com.tencent.mm.plugin.downloader.model.d.aFP();
      com.tencent.mm.plugin.downloader.model.b.b(this);
      return;
    }
    paramString = localContext.getApplicationInfo();
    if (paramString == null) {
      paramString = null;
    }
    Object localObject1;
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
          SharePatchFileUtil.ah(localFile);
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
    switch (this.lmT.lnu.intValue())
    {
    default: 
      label348:
      paramString = this.lmT;
      if (!paramString.bbo()) {
        break;
      }
    }
    for (paramString = com.tencent.mm.plugin.hp.d.b.a(paramString.lnt, 2);; paramString = "")
    {
      localContext.getSharedPreferences("tinker_patch_share_config", 4).edit().putString("tinker_patch_msg_key", paramString).apply();
      break;
      com.tencent.tinker.lib.f.a.i("Tinker.SyncResponseProcessor", "onReceiveUpgradePatch. try to start apply", new Object[0]);
      com.tencent.tinker.lib.e.c.bR(localContext, ((File)localObject2).getAbsolutePath());
      break label348;
      paramString = ((File)localObject2).getAbsolutePath();
      localObject1 = this.lmT;
      y.i("MicroMsg.Tinker.CTinkerInstaller", "onReceiveUpgradeBsDiff bsDiffPath:%s , new apk md5：%s", new Object[] { paramString, ((com.tencent.mm.plugin.hp.d.b)localObject1).lnz });
      localObject2 = com.tencent.mm.pluginsdk.f.i.We(((com.tencent.mm.plugin.hp.d.b)localObject1).lnz);
      au.DS().O(new a.1((String)localObject2, localContext, paramString, (com.tencent.mm.plugin.hp.d.b)localObject1));
      break label348;
      y.i("Tinker.SyncResponseProcessor", "coming soon! now can not support full apk update.");
      break label348;
    }
  }
  
  final void bbf()
  {
    if (!com.tencent.mm.compatible.util.h.getExternalStorageState().equals("mounted"))
    {
      y.e("Tinker.SyncResponseProcessor", "no sdcard.");
      com.tencent.mm.plugin.report.service.h.nFQ.a(614L, 50L, 1L, false);
    }
    for (;;)
    {
      return;
      if (!f.bs(this.lmT.fileSize))
      {
        y.e("Tinker.SyncResponseProcessor", "sdcard is full.");
        com.tencent.mm.plugin.report.service.h.nFQ.a(614L, 51L, 1L, false);
        if (this.lmT.lnu.intValue() == 3) {
          com.tencent.mm.plugin.report.service.h.nFQ.a(614L, 55L, 1L, false);
        }
      }
      else
      {
        if ((this.lmT.lnu.intValue() == 3) && (!bk.bl(this.lmT.lnz)) && (com.tencent.mm.a.e.bK(com.tencent.mm.pluginsdk.f.i.We(this.lmT.lnz))) && (com.tencent.mm.c.a.cd(com.tencent.mm.pluginsdk.f.i.We(this.lmT.lnz))))
        {
          Context localContext = ae.getContext();
          if (bk.bl(this.lmT.bbp())) {}
          for (localObject = localContext.getString(R.l.update_tip_recommended_down);; localObject = this.lmT.bbp())
          {
            bxs localbxs = new bxs();
            localbxs.lny = this.lmT.lny;
            localbxs.title = localContext.getString(R.l.fmt_update);
            localbxs.tNL = localContext.getString(R.l.install_now);
            localbxs.lfK = localContext.getString(R.l.update_cancel);
            localbxs.lnz = this.lmT.lnz;
            localbxs.lnA = this.lmT.lnA;
            localbxs.gZD = this.lmT.fileSize;
            localbxs.lnw = this.lmT.lnw;
            localbxs.bvC = this.lmT.lnx;
            localbxs.versionCode = this.lmT.versionCode;
            localbxs.tNK = com.tencent.mm.pluginsdk.f.i.We(this.lmT.lnz);
            localbxs.bHk = ((String)localObject);
            com.tencent.mm.pluginsdk.f.i.a(localbxs);
            y.i("Tinker.SyncResponseProcessor", "file is exist. need no to download. newApkMd5:%s", new Object[] { this.lmT.lnz });
            return;
          }
        }
        this.lmT.lnu.intValue();
        com.tencent.mm.pluginsdk.f.i.clp();
        com.tencent.mm.pluginsdk.f.i.clq();
        Object localObject = new e.a();
        ((e.a)localObject).zN(this.lmT.lnw);
        ((e.a)localObject).zP(this.lmT.lny);
        ((e.a)localObject).zQ(this.lmT.lnx);
        ((e.a)localObject).eO(false);
        ((e.a)localObject).aFW();
        ((e.a)localObject).pE(2);
        ((e.a)localObject).eP(false);
        this.lmU = com.tencent.mm.plugin.downloader.model.d.aFP().a(((e.a)localObject).iPG);
        y.i("Tinker.SyncResponseProcessor", "Download task id is :%d", new Object[] { Long.valueOf(this.lmU) });
        com.tencent.mm.plugin.report.service.h.nFQ.a(614L, 2L, 1L, false);
        if (aq.isWifi(ae.getContext())) {
          com.tencent.mm.plugin.report.service.h.nFQ.a(614L, 7L, 1L, false);
        }
        while (this.lmT.lnu.intValue() == 3)
        {
          com.tencent.mm.plugin.report.service.h.nFQ.a(614L, 56L, 1L, false);
          y.d("Tinker.SyncResponseProcessor", "boots download start silent.");
          return;
          com.tencent.mm.plugin.report.service.h.nFQ.a(614L, 8L, 1L, false);
        }
      }
    }
  }
  
  public final void cy(long paramLong)
  {
    y.d("Tinker.SyncResponseProcessor", "onTaskProgressChanged");
  }
  
  public final void cz(long paramLong) {}
  
  public final boolean gN(boolean paramBoolean)
  {
    com.tencent.tinker.lib.f.a.i("Tinker.SyncResponseProcessor", "process tinker response: %s", new Object[] { this.lmT.toString() });
    Object localObject1 = this.lmT;
    int i;
    if ((((com.tencent.mm.plugin.hp.d.b)localObject1).lns.intValue() > 4) || (((com.tencent.mm.plugin.hp.d.b)localObject1).lns.intValue() <= 0))
    {
      y.e("Tinker.TinkerSyncResponse", "responseState: %d must between %d and %d", new Object[] { ((com.tencent.mm.plugin.hp.d.b)localObject1).lns, Integer.valueOf(1), Integer.valueOf(4) });
      com.tencent.mm.plugin.report.service.h.nFQ.a(614L, 24L, 1L, false);
      i = 0;
    }
    while (i == 0)
    {
      com.tencent.tinker.lib.f.a.i("Tinker.SyncResponseProcessor", "process check response fail, just return", new Object[0]);
      return false;
      if (((com.tencent.mm.plugin.hp.d.b)localObject1).bbn())
      {
        if (TextUtils.isEmpty(((com.tencent.mm.plugin.hp.d.b)localObject1).lny))
        {
          y.e("Tinker.TinkerSyncResponse", "sync response patchId should not be null");
          com.tencent.mm.plugin.report.service.h.nFQ.a(614L, 25L, 1L, false);
          i = 0;
          continue;
        }
        if (TextUtils.isEmpty(((com.tencent.mm.plugin.hp.d.b)localObject1).lnw))
        {
          y.e("Tinker.TinkerSyncResponse", "sync response cdnUrl should not be null");
          com.tencent.mm.plugin.report.service.h.nFQ.a(614L, 26L, 1L, false);
          i = 0;
          continue;
        }
        if (TextUtils.isEmpty(((com.tencent.mm.plugin.hp.d.b)localObject1).lnx))
        {
          y.e("Tinker.TinkerSyncResponse", "sync response fileMd5 should not be null");
          com.tencent.mm.plugin.report.service.h.nFQ.a(614L, 27L, 1L, false);
          i = 0;
          continue;
        }
      }
      i = 1;
    }
    if (this.lmT.lns.intValue() == 3)
    {
      i = 1;
      if (i == 0) {
        break label376;
      }
      localObject2 = ae.getContext();
      localObject1 = com.tencent.tinker.lib.e.a.hN((Context)localObject2);
      if (((com.tencent.tinker.lib.e.a)localObject1).wWr) {
        break label299;
      }
      com.tencent.tinker.lib.f.a.w("Tinker.SyncResponseProcessor", "SyncResponseProcessor: onPatchRollback, tinker is not loaded, just return", new Object[0]);
    }
    for (;;)
    {
      return true;
      i = 0;
      break;
      label299:
      com.tencent.tinker.lib.f.a.i("Tinker.SyncResponseProcessor", "tinker wait screen to clean patch and kill all process", new Object[0]);
      new l(ae.getContext(), new e.3(this, (Context)localObject2, (com.tencent.tinker.lib.e.a)localObject1), false);
      localObject2 = new SharePatchInfo(((com.tencent.tinker.lib.e.a)localObject1).wWq.wWv, "00000000000000000000000000000000", Build.FINGERPRINT, "odex");
      SharePatchInfo.a(((com.tencent.tinker.lib.e.a)localObject1).wWn, (SharePatchInfo)localObject2, ((com.tencent.tinker.lib.e.a)localObject1).wWo);
    }
    label376:
    if (!this.lmT.bbn()) {
      return true;
    }
    if (this.lmT.bbq())
    {
      com.tencent.tinker.lib.f.a.w("Tinker.SyncResponseProcessor", "is lower version skip.", new Object[0]);
      com.tencent.mm.plugin.report.service.h.nFQ.a(614L, 78L, 1L, false);
      return true;
    }
    Object localObject3;
    if ((this.lmT.lnu.intValue() == 3) && (!bk.bl(this.lmT.clientVersion)) && (com.tencent.mm.plugin.hp.d.c.Ft(this.lmT.clientVersion)))
    {
      com.tencent.mm.plugin.report.service.h.nFQ.a(614L, 77L, 1L, false);
      localObject3 = this.lmT;
      Context localContext = ae.getContext();
      if (bk.bl(((com.tencent.mm.plugin.hp.d.b)localObject3).lnB))
      {
        localObject1 = localContext.getString(R.l.app_recommend_update_alpha);
        if (!bk.bl(((com.tencent.mm.plugin.hp.d.b)localObject3).lnC)) {
          break label737;
        }
        localObject2 = "";
        label527:
        if (!bk.bl(((com.tencent.mm.plugin.hp.d.b)localObject3).lnD)) {
          break label747;
        }
        localObject3 = "http://support.weixin.qq.com/cgi-bin/mmsupport-bin/readtemplate?t=page/android_exp__index";
        label543:
        Intent localIntent = new Intent("android.intent.action.VIEW");
        localIntent.setClassName(ae.getPackageName(), ae.getPackageName() + ".plugin.webview.ui.tools.WebViewUI");
        localIntent.putExtra("rawUrl", (String)localObject3);
        localIntent.putExtra("useJs", true);
        localIntent.putExtra("vertical_scroll", true);
        localIntent.setFlags(872415232);
        localObject3 = PendingIntent.getActivity(localContext, 0, localIntent, 268435456);
        localObject1 = new Notification.Builder(localContext).setTicker(null).setWhen(System.currentTimeMillis()).setContentTitle((CharSequence)localObject1).setContentText((CharSequence)localObject2).setContentIntent((PendingIntent)localObject3);
        ((Notification.Builder)localObject1).setSmallIcon(com.tencent.mm.bq.a.bSL());
        localObject1 = ((Notification.Builder)localObject1).getNotification();
        ((Notification)localObject1).icon = R.g.update_package_download_anim0;
        ((Notification)localObject1).flags |= 0x10;
        if (!paramBoolean) {
          break label757;
        }
        ((NotificationManager)localContext.getSystemService("notification")).notify(19841110, (Notification)localObject1);
      }
      for (;;)
      {
        return true;
        localObject1 = ((com.tencent.mm.plugin.hp.d.b)localObject3).lnB;
        break;
        label737:
        localObject2 = ((com.tencent.mm.plugin.hp.d.b)localObject3).lnC;
        break label527;
        label747:
        localObject3 = ((com.tencent.mm.plugin.hp.d.b)localObject3).lnD;
        break label543;
        label757:
        y.i("Tinker.SyncResponseProcessor", "ignore action when load from cache,when response is alpha version");
      }
    }
    com.tencent.tinker.lib.f.a.i("Tinker.SyncResponseProcessor", "check need show before download. network type:%d msg:%s", new Object[] { this.lmT.lnv, this.lmT.bbp() });
    Object localObject2 = ae.getContext();
    if ((this.lmT.lnv.intValue() == 2) && (aq.isMobile(ae.getContext())) && (this.lmT.bbo())) {
      if (!g.ar((Context)localObject2, this.lmT.lny)) {
        if (this.lmT.lnu.intValue() == 2)
        {
          localObject1 = ae.getContext().getString(R.l.fmt_update_info, new Object[] { this.lmT.bbp(), ae.getContext().getString(R.l.update_increment_tips), bk.cm(this.lmT.fileSize) });
          i.a(ae.getContext().getString(R.l.fmt_update), (String)localObject1, ae.getContext().getString(R.l.update_now), new e.1(this), ae.getContext().getString(R.l.update_cancel), new e.2(this, (Context)localObject2));
          a.su(4);
        }
      }
    }
    for (;;)
    {
      return true;
      if (this.lmT.lnu.intValue() != 3) {
        break;
      }
      y.d("Tinker.SyncResponseProcessor", "showUpdateDialog ");
      if (bk.bl(this.lmT.bbp())) {}
      for (localObject1 = ((Context)localObject2).getString(R.l.update_tip_recommended_down);; localObject1 = this.lmT.bbp())
      {
        localObject3 = new bxs();
        ((bxs)localObject3).lny = this.lmT.lny;
        ((bxs)localObject3).title = ((Context)localObject2).getString(R.l.fmt_update);
        ((bxs)localObject3).tNL = ((Context)localObject2).getString(R.l.update_now);
        ((bxs)localObject3).lfK = ((Context)localObject2).getString(R.l.update_cancel);
        ((bxs)localObject3).lnz = this.lmT.lnz;
        ((bxs)localObject3).lnA = this.lmT.lnA;
        ((bxs)localObject3).gZD = this.lmT.fileSize;
        ((bxs)localObject3).lnw = this.lmT.lnw;
        ((bxs)localObject3).bvC = this.lmT.lnx;
        ((bxs)localObject3).versionCode = this.lmT.versionCode;
        ((bxs)localObject3).tNK = com.tencent.mm.pluginsdk.f.i.We(this.lmT.lnz);
        ((bxs)localObject3).bHk = ((String)localObject1);
        com.tencent.mm.pluginsdk.f.i.a((bxs)localObject3);
        break;
      }
      com.tencent.mm.plugin.report.service.h.nFQ.a(614L, 44L, 1L, false);
      y.i("Tinker.SyncResponseProcessor", "this patch id :%s show cancel before user, need show again.", new Object[] { this.lmT.lny });
      continue;
      if ((this.lmT.bbm()) && (!g.ar((Context)localObject2, this.lmT.lny))) {
        bbf();
      }
    }
  }
  
  public final void k(long paramLong, String paramString)
  {
    y.d("Tinker.SyncResponseProcessor", "onTaskResumed");
  }
  
  public final void onTaskPaused(long paramLong)
  {
    y.d("Tinker.SyncResponseProcessor", "onTaskPaused");
  }
  
  public final void onTaskRemoved(long paramLong)
  {
    y.i("Tinker.SyncResponseProcessor", "onTaskRemoved");
    com.tencent.mm.plugin.downloader.model.d.aFP();
    com.tencent.mm.plugin.downloader.model.b.b(this);
  }
  
  public final void onTaskStarted(long paramLong, String paramString)
  {
    y.d("Tinker.SyncResponseProcessor", "onTaskStarted");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.hp.b.e
 * JD-Core Version:    0.7.0.1
 */