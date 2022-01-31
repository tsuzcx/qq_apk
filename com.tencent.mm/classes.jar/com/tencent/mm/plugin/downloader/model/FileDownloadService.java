package com.tencent.mm.plugin.downloader.model;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.downloader.c.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.vfs.j;
import java.io.File;

public class FileDownloadService
  extends IntentService
{
  public static final String EXTRA_ID;
  public static final String EXTRA_PACKAGE_NAME = iPH + "package_name";
  private static final String iPH = FileDownloadService.class.getSimpleName() + "_extra_";
  public static final String iPI;
  public static final String iPJ = iPH + "file_path";
  public static final String iPK = iPH + "md5";
  public static final String iPL = iPH + "change_url";
  
  static
  {
    EXTRA_ID = iPH + "id";
    iPI = iPH + "action_type";
  }
  
  public FileDownloadService()
  {
    super("FileDownloadService");
  }
  
  private static boolean H(String paramString1, String paramString2, String paramString3)
  {
    com.tencent.mm.vfs.b localb = new com.tencent.mm.vfs.b(paramString1);
    y.i("MicroMsg.FileDownloadService", "MD5 Check: %s, File Exists: %b", new Object[] { paramString1, Boolean.valueOf(localb.exists()) });
    long l = System.currentTimeMillis();
    paramString1 = com.tencent.mm.vfs.e.aeY(j.n(localb.mUri));
    l = System.currentTimeMillis() - l;
    y.i("MicroMsg.FileDownloadService", "MD5 Check Time: %d", new Object[] { Long.valueOf(l) });
    y.i("MicroMsg.FileDownloadService", "Original MD5: %s, Calculated MD5: %s", new Object[] { paramString2, paramString1 });
    if (!bk.bl(paramString3))
    {
      com.tencent.mm.plugin.downloader.f.a locala = c.zH(paramString3);
      if (locala != null) {
        com.tencent.mm.game.report.api.b.dCw.a(paramString3, 111, locala.field_downloadId, "", l);
      }
    }
    if (bk.bl(paramString2)) {
      return localb.exists();
    }
    if (bk.bl(paramString1))
    {
      y.i("MicroMsg.FileDownloadService", "check from file failed, may caused by low memory while checking md5");
      return localb.exists();
    }
    return paramString2.trim().equalsIgnoreCase(paramString1.trim());
  }
  
  private boolean h(boolean paramBoolean, String paramString)
  {
    return (aq.isWifi(this)) && (!paramBoolean) && (!bk.bl(paramString));
  }
  
  protected void onHandleIntent(Intent paramIntent)
  {
    if (paramIntent == null) {}
    int i;
    long l2;
    Object localObject3;
    do
    {
      return;
      i = paramIntent.getIntExtra(iPI, 0);
      y.i("MicroMsg.FileDownloadService", "handle intent type : %d", new Object[] { Integer.valueOf(i) });
      switch (i)
      {
      case 2: 
      default: 
        return;
      case 1: 
        l2 = paramIntent.getLongExtra(EXTRA_ID, -1L);
        if (l2 < 0L)
        {
          y.e("MicroMsg.FileDownloadService", "Invalid id");
          return;
        }
        if (g.DN().Dc())
        {
          g.DN();
          if (!com.tencent.mm.kernel.a.CW()) {}
        }
        else
        {
          y.d("MicroMsg.FileDownloadService", "no user login");
          return;
        }
        localObject3 = c.dk(l2);
      }
    } while (localObject3 == null);
    if ((paramIntent.getBooleanExtra(iPL, false)) || (((com.tencent.mm.plugin.downloader.f.a)localObject3).field_isSecondDownload)) {}
    for (boolean bool2 = true;; bool2 = false)
    {
      y.i("MicroMsg.FileDownloadService", "filePath = " + ((com.tencent.mm.plugin.downloader.f.a)localObject3).field_filePath);
      if ((!bk.bl(((com.tencent.mm.plugin.downloader.f.a)localObject3).field_filePath)) && (com.tencent.mm.vfs.e.bK(((com.tencent.mm.plugin.downloader.f.a)localObject3).field_filePath))) {
        break;
      }
      h.nFQ.a(710L, 5L, 1L, false);
      ((com.tencent.mm.plugin.downloader.f.a)localObject3).field_status = 4;
      ((com.tencent.mm.plugin.downloader.f.a)localObject3).field_errCode = com.tencent.mm.plugin.downloader.a.a.iOt;
      c.d((com.tencent.mm.plugin.downloader.f.a)localObject3);
      paramIntent = d.aFP();
      i = com.tencent.mm.plugin.downloader.a.a.iOt;
      y.i("MicroMsg.FileDownloadManager", "onDownloadFailed, id = %d, errCode = %d", new Object[] { Long.valueOf(l2), Integer.valueOf(i) });
      if (paramIntent.iPn != null) {
        paramIntent.iPn.c(l2, i, bool2);
      }
      y.i("MicroMsg.FileDownloadService", "file not exists, appid = " + ((com.tencent.mm.plugin.downloader.f.a)localObject3).field_appId);
      return;
    }
    if (bk.bl(((com.tencent.mm.plugin.downloader.f.a)localObject3).field_md5))
    {
      y.i("MicroMsg.FileDownloadService", "Invalid original md5, abort checking");
      ((com.tencent.mm.plugin.downloader.f.a)localObject3).field_status = 3;
      c.d((com.tencent.mm.plugin.downloader.f.a)localObject3);
      d.aFP().l(l2, bool2);
      return;
    }
    long l1;
    boolean bool1;
    if (!bk.bl(((com.tencent.mm.plugin.downloader.f.a)localObject3).field_appId))
    {
      l1 = System.currentTimeMillis();
      try
      {
        File localFile = new File(((com.tencent.mm.plugin.downloader.f.a)localObject3).field_filePath);
        localObject1 = localFile.getAbsolutePath();
        bool1 = com.tencent.mm.plugin.downloader.c.c.zF((String)localObject1);
        if (!bool1) {
          break label1014;
        }
        paramIntent = "v2";
        y.i("MicroMsg.Channel.GameChannelUtil", "apkPath:%s, this is %s signature", new Object[] { localObject1, paramIntent });
        localObject1 = null;
        if (bool1) {
          localObject1 = com.tencent.mm.plugin.downloader.c.c.D(localFile);
        }
        paramIntent = (Intent)localObject1;
        if (localObject1 == null)
        {
          localObject1 = com.tencent.mm.plugin.downloader.c.c.C(localFile);
          paramIntent = (Intent)localObject1;
          if (bool1)
          {
            paramIntent = (Intent)localObject1;
            if (localObject1 != null)
            {
              y.i("MicroMsg.Channel.GameChannelUtil", "you are use v2 signature but use v1 channel modle, this apk will can't install in 7.0system");
              paramIntent = (Intent)localObject1;
            }
          }
        }
        y.i("MicroMsg.Channel.GameChannelUtil", "readChannel, channelId = %s", new Object[] { paramIntent });
      }
      catch (Exception paramIntent)
      {
        for (;;)
        {
          Object localObject1;
          y.e("MicroMsg.FileDownloadService", "readChannelId exception : " + paramIntent.getMessage());
          paramIntent = "";
          continue;
          com.tencent.mm.game.report.api.b.dCw.i(((com.tencent.mm.plugin.downloader.f.a)localObject3).field_appId, 22L);
          com.tencent.mm.game.report.api.b.dCw.a(((com.tencent.mm.plugin.downloader.f.a)localObject3).field_appId, 109, ((com.tencent.mm.plugin.downloader.f.a)localObject3).field_downloadId, paramIntent, 0L);
          continue;
          com.tencent.mm.game.report.api.b.dCw.i(((com.tencent.mm.plugin.downloader.f.a)localObject3).field_appId, 31L);
        }
      }
      l1 = System.currentTimeMillis() - l1;
      y.i("MicroMsg.FileDownloadService", "readChannelId, channelId:%s, cost time: %d", new Object[] { paramIntent, Long.valueOf(l1) });
      l1 = 0L + l1;
    }
    for (;;)
    {
      bool1 = H(((com.tencent.mm.plugin.downloader.f.a)localObject3).field_filePath, ((com.tencent.mm.plugin.downloader.f.a)localObject3).field_md5, ((com.tencent.mm.plugin.downloader.f.a)localObject3).field_appId);
      boolean bool3;
      if (bool2)
      {
        if (bool1)
        {
          com.tencent.mm.game.report.api.b.dCw.i(((com.tencent.mm.plugin.downloader.f.a)localObject3).field_appId, 21L);
          com.tencent.mm.game.report.api.b.dCw.a(((com.tencent.mm.plugin.downloader.f.a)localObject3).field_appId, 108, ((com.tencent.mm.plugin.downloader.f.a)localObject3).field_downloadId, paramIntent, 0L);
        }
      }
      else
      {
        if (!bool1)
        {
          if (!((com.tencent.mm.plugin.downloader.f.a)localObject3).field_downloadUrl.startsWith("https")) {
            break label1090;
          }
          com.tencent.mm.game.report.api.b.dCw.i(((com.tencent.mm.plugin.downloader.f.a)localObject3).field_appId, 32L);
        }
        localObject1 = paramIntent;
        bool3 = bool1;
        if (!bool1)
        {
          localObject1 = paramIntent;
          bool3 = bool1;
          if (!bk.bl(((com.tencent.mm.plugin.downloader.f.a)localObject3).field_appId))
          {
            bool3 = false;
            l3 = System.currentTimeMillis();
          }
        }
      }
      try
      {
        boolean bool4 = com.tencent.mm.plugin.downloader.c.e.e(new File(((com.tencent.mm.plugin.downloader.f.a)localObject3).field_filePath), "10000145");
        bool3 = bool4;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          y.e("MicroMsg.FileDownloadService", "writeChannelId exception : " + localException.getMessage());
          continue;
          i = 103;
          com.tencent.mm.game.report.api.b.dCw.i(((com.tencent.mm.plugin.downloader.f.a)localObject3).field_appId, 25L);
          continue;
          i = 101;
          com.tencent.mm.game.report.api.b.dCw.i(((com.tencent.mm.plugin.downloader.f.a)localObject3).field_appId, 23L);
          continue;
          i = 105;
          com.tencent.mm.game.report.api.b.dCw.i(((com.tencent.mm.plugin.downloader.f.a)localObject3).field_appId, 27L);
          continue;
          i = 106;
          com.tencent.mm.game.report.api.b.dCw.i(((com.tencent.mm.plugin.downloader.f.a)localObject3).field_appId, 28L);
          continue;
          i = 104;
          com.tencent.mm.game.report.api.b.dCw.i(((com.tencent.mm.plugin.downloader.f.a)localObject3).field_appId, 26L);
        }
        if (((com.tencent.mm.plugin.downloader.f.a)localObject3).field_downloaderType != 3) {
          break label1671;
        }
        if (!((com.tencent.mm.plugin.downloader.f.a)localObject3).field_downloadUrl.startsWith("https")) {
          break label1654;
        }
        h.nFQ.a(710L, 10L, 1L, false);
        ((com.tencent.mm.plugin.downloader.f.a)localObject3).field_status = 4;
        ((com.tencent.mm.plugin.downloader.f.a)localObject3).field_channelId = localException;
        ((com.tencent.mm.plugin.downloader.f.a)localObject3).field_errCode = com.tencent.mm.plugin.downloader.a.a.iOp;
        ((com.tencent.mm.plugin.downloader.f.a)localObject3).field_downloadedSize = com.tencent.mm.vfs.e.aeQ(((com.tencent.mm.plugin.downloader.f.a)localObject3).field_filePath);
        c.d((com.tencent.mm.plugin.downloader.f.a)localObject3);
        y.i("MicroMsg.FileDownloadService", "ChannelId = %s, receivedSize = %d, fileSize = %d", new Object[] { localException, Long.valueOf(((com.tencent.mm.plugin.downloader.f.a)localObject3).field_downloadedSize), Long.valueOf(com.tencent.mm.vfs.e.aeQ(((com.tencent.mm.plugin.downloader.f.a)localObject3).field_filePath)) });
        y.i("MicroMsg.FileDownloadService", "delete file: %s", new Object[] { ((com.tencent.mm.plugin.downloader.f.a)localObject3).field_filePath });
        com.tencent.mm.vfs.e.deleteFile(((com.tencent.mm.plugin.downloader.f.a)localObject3).field_filePath);
        bool3 = aq.isWifi(this);
        if (bk.bl(((com.tencent.mm.plugin.downloader.f.a)localObject3).field_secondaryUrl)) {
          break label1719;
        }
        bool1 = true;
        y.i("MicroMsg.FileDownloadService", "checkMd5, isWifi: %b, hasChangeUrl: %b, hasHttpsUrl: %b", new Object[] { Boolean.valueOf(bool3), Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
        if (!h(bool2, ((com.tencent.mm.plugin.downloader.f.a)localObject3).field_secondaryUrl)) {
          break label1753;
        }
        paramIntent = new e.a();
        paramIntent.zN(((com.tencent.mm.plugin.downloader.f.a)localObject3).field_secondaryUrl);
        paramIntent.dp(((com.tencent.mm.plugin.downloader.f.a)localObject3).field_fileSize);
        paramIntent.zP(((com.tencent.mm.plugin.downloader.f.a)localObject3).field_fileName);
        paramIntent.setAppId(((com.tencent.mm.plugin.downloader.f.a)localObject3).field_appId);
        paramIntent.zQ(((com.tencent.mm.plugin.downloader.f.a)localObject3).field_md5);
        paramIntent.setScene(((com.tencent.mm.plugin.downloader.f.a)localObject3).field_scene);
        paramIntent.zR(((com.tencent.mm.plugin.downloader.f.a)localObject3).field_extInfo);
        paramIntent.iPG.iPC = true;
        paramIntent.eO(true);
        paramIntent.pE(1);
        paramIntent.cq(((com.tencent.mm.plugin.downloader.f.a)localObject3).field_packageName);
        paramIntent.iPG.iPE = true;
        if (((com.tencent.mm.plugin.downloader.f.a)localObject3).field_downloaderType == 3) {
          break label1725;
        }
        l1 = d.aFP().a(paramIntent.iPG);
        h.nFQ.a(710L, 8L, 1L, false);
        for (;;)
        {
          y.i("MicroMsg.FileDownloadService", "MD5 check failed, restart download, id = " + l1);
          com.tencent.mm.game.report.api.b.dCw.a(((com.tencent.mm.plugin.downloader.f.a)localObject3).field_appId, 110, ((com.tencent.mm.plugin.downloader.f.a)localObject3).field_downloadId, localException, 0L);
          com.tencent.mm.game.report.api.b.dCw.i(((com.tencent.mm.plugin.downloader.f.a)localObject3).field_appId, 30L);
          return;
          h.nFQ.a(710L, 9L, 1L, false);
          break;
          if (((com.tencent.mm.plugin.downloader.f.a)localObject3).field_downloadUrl.startsWith("https"))
          {
            h.nFQ.a(710L, 7L, 1L, false);
            break;
          }
          h.nFQ.a(710L, 6L, 1L, false);
          break;
          bool1 = false;
          break label1406;
          l1 = d.aFP().b(paramIntent.iPG);
          h.nFQ.a(710L, 11L, 1L, false);
        }
        paramIntent = d.aFP();
        localObject2 = c.dk(l2);
      }
      long l3 = System.currentTimeMillis() - l3;
      l1 += l3;
      y.i("MicroMsg.FileDownloadService", "writeChannelId result:%b, cost time: %d", new Object[] { Boolean.valueOf(bool3), Long.valueOf(l3) });
      y.i("MicroMsg.FileDownloadService", "channel opration cost time: %d", new Object[] { Long.valueOf(l1) });
      if (bool3)
      {
        bool1 = H(((com.tencent.mm.plugin.downloader.f.a)localObject3).field_filePath, ((com.tencent.mm.plugin.downloader.f.a)localObject3).field_md5, ((com.tencent.mm.plugin.downloader.f.a)localObject3).field_appId);
        y.i("MicroMsg.FileDownloadService", "after modify channel, ret:%b", new Object[] { Boolean.valueOf(bool1) });
        if (bool1)
        {
          paramIntent = "10000145";
          i = 102;
          com.tencent.mm.game.report.api.b.dCw.i(((com.tencent.mm.plugin.downloader.f.a)localObject3).field_appId, 24L);
          com.tencent.mm.game.report.api.b.dCw.a(((com.tencent.mm.plugin.downloader.f.a)localObject3).field_appId, i, ((com.tencent.mm.plugin.downloader.f.a)localObject3).field_downloadId, paramIntent, l1);
          if (!bool2) {}
          switch (i)
          {
          default: 
            i = 0;
            com.tencent.mm.game.report.api.b.dCw.a(((com.tencent.mm.plugin.downloader.f.a)localObject3).field_appId, i, ((com.tencent.mm.plugin.downloader.f.a)localObject3).field_downloadId, paramIntent, 0L);
            localObject1 = paramIntent;
            bool3 = bool1;
            if (bool1)
            {
              localObject1 = paramIntent;
              bool3 = bool1;
              if (!h(bool2, ((com.tencent.mm.plugin.downloader.f.a)localObject3).field_secondaryUrl))
              {
                com.tencent.mm.game.report.api.b.dCw.a(((com.tencent.mm.plugin.downloader.f.a)localObject3).field_appId, 107, ((com.tencent.mm.plugin.downloader.f.a)localObject3).field_downloadId, paramIntent, 0L);
                com.tencent.mm.game.report.api.b.dCw.i(((com.tencent.mm.plugin.downloader.f.a)localObject3).field_appId, 29L);
                bool3 = bool1;
                localObject1 = paramIntent;
              }
            }
            if (bool3)
            {
              ((com.tencent.mm.plugin.downloader.f.a)localObject3).field_status = 3;
              ((com.tencent.mm.plugin.downloader.f.a)localObject3).field_channelId = ((String)localObject1);
              c.d((com.tencent.mm.plugin.downloader.f.a)localObject3);
              d.aFP().l(l2, bool2);
              return;
              label1014:
              paramIntent = "v1";
            }
            break;
          }
        }
      }
      label1090:
      label1406:
      if (localObject2 == null) {
        break;
      }
      label1654:
      localObject3 = ae.getContext();
      label1671:
      label1719:
      label1725:
      label1753:
      if ((((com.tencent.mm.plugin.downloader.f.a)localObject2).field_showNotification) && (bk.bl(((com.tencent.mm.plugin.downloader.f.a)localObject2).field_fileName))) {
        d.a(((com.tencent.mm.plugin.downloader.f.a)localObject2).field_appId, ((Context)localObject3).getString(c.c.file_downloader_md5check_failed), "", null);
      }
      for (;;)
      {
        paramIntent.iPn.c(l2, com.tencent.mm.plugin.downloader.a.a.iOp, bool2);
        return;
        if ((((com.tencent.mm.plugin.downloader.f.a)localObject2).field_showNotification) && (!bk.bl(((com.tencent.mm.plugin.downloader.f.a)localObject2).field_fileName))) {
          d.a(((com.tencent.mm.plugin.downloader.f.a)localObject2).field_appId, ((com.tencent.mm.plugin.downloader.f.a)localObject2).field_fileName, ((Context)localObject3).getString(c.c.file_downloader_md5check_failed), null);
        }
      }
      Object localObject2 = paramIntent.getStringExtra(iPJ);
      localObject3 = paramIntent.getStringExtra(iPK);
      paramIntent = paramIntent.getStringExtra("appId");
      if ((bk.bl((String)localObject2)) || (!com.tencent.mm.vfs.e.bK((String)localObject2)))
      {
        y.i("MicroMsg.FileDownloadService", "Invalid file path, ignored");
        return;
      }
      if ((!bk.bl((String)localObject3)) && (!H((String)localObject2, (String)localObject3, paramIntent))) {
        break;
      }
      paramIntent = c.zH(paramIntent);
      if (paramIntent != null)
      {
        com.tencent.mm.plugin.downloader.h.a.m(paramIntent.field_downloadId, false);
        return;
      }
      com.tencent.mm.plugin.downloader.h.a.zT((String)localObject2);
      return;
      l1 = 0L;
      paramIntent = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.model.FileDownloadService
 * JD-Core Version:    0.7.0.1
 */