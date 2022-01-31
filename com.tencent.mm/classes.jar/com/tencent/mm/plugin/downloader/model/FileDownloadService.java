package com.tencent.mm.plugin.downloader.model;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.downloader.f.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.service.MMIntentService;
import java.io.File;

public class FileDownloadService
  extends MMIntentService
{
  public static final String EXTRA_ID;
  public static final String EXTRA_PACKAGE_NAME;
  private static final String kYS;
  public static final String kYT;
  public static final String kYU;
  public static final String kYV;
  public static final String kYW;
  
  static
  {
    AppMethodBeat.i(2445);
    kYS = FileDownloadService.class.getSimpleName() + "_extra_";
    EXTRA_ID = kYS + "id";
    kYT = kYS + "action_type";
    EXTRA_PACKAGE_NAME = kYS + "package_name";
    kYU = kYS + "file_path";
    kYV = kYS + "md5";
    kYW = kYS + "change_url";
    AppMethodBeat.o(2445);
  }
  
  public FileDownloadService()
  {
    super("FileDownloadService");
  }
  
  private static boolean l(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(2443);
    if ((at.isWifi(ah.getContext())) && (!paramBoolean) && (!bo.isNullOrNil(paramString)))
    {
      AppMethodBeat.o(2443);
      return true;
    }
    AppMethodBeat.o(2443);
    return false;
  }
  
  public final String getTag()
  {
    return "MicroMsg.FileDownloadService";
  }
  
  public final void onHandleIntent(Intent paramIntent)
  {
    AppMethodBeat.i(2442);
    if (paramIntent == null)
    {
      AppMethodBeat.o(2442);
      return;
    }
    int i = paramIntent.getIntExtra(kYT, 0);
    ab.i("MicroMsg.FileDownloadService", "handle intent type : %d", new Object[] { Integer.valueOf(i) });
    long l2;
    Object localObject2;
    boolean bool2;
    long l1;
    Object localObject1;
    boolean bool1;
    switch (i)
    {
    case 2: 
    default: 
      AppMethodBeat.o(2442);
      return;
    case 1: 
      l2 = paramIntent.getLongExtra(EXTRA_ID, -1L);
      if (l2 < 0L)
      {
        ab.e("MicroMsg.FileDownloadService", "Invalid id");
        AppMethodBeat.o(2442);
        return;
      }
      if (g.RJ().QU())
      {
        g.RJ();
        if (!com.tencent.mm.kernel.a.QP()) {}
      }
      else
      {
        ab.d("MicroMsg.FileDownloadService", "no user login");
        AppMethodBeat.o(2442);
        return;
      }
      localObject2 = d.iJ(l2);
      if (localObject2 != null)
      {
        if ((paramIntent.getBooleanExtra(kYW, false)) || (((com.tencent.mm.plugin.downloader.g.a)localObject2).field_isSecondDownload)) {}
        for (bool2 = true;; bool2 = false)
        {
          ab.i("MicroMsg.FileDownloadService", "filePath = " + ((com.tencent.mm.plugin.downloader.g.a)localObject2).field_filePath);
          if ((!bo.isNullOrNil(((com.tencent.mm.plugin.downloader.g.a)localObject2).field_filePath)) && (com.tencent.mm.vfs.e.cN(((com.tencent.mm.plugin.downloader.g.a)localObject2).field_filePath))) {
            break;
          }
          h.qsU.idkeyStat(710L, 5L, 1L, false);
          ((com.tencent.mm.plugin.downloader.g.a)localObject2).field_status = 4;
          ((com.tencent.mm.plugin.downloader.g.a)localObject2).field_errCode = com.tencent.mm.plugin.downloader.a.a.kVz;
          d.e((com.tencent.mm.plugin.downloader.g.a)localObject2);
          paramIntent = f.bjl();
          i = com.tencent.mm.plugin.downloader.a.a.kVz;
          ab.i("MicroMsg.FileDownloadManager", "onDownloadFailed, id = %d, errCode = %d", new Object[] { Long.valueOf(l2), Integer.valueOf(i) });
          if (paramIntent.kYw != null) {
            paramIntent.kYw.d(l2, i, bool2);
          }
          ab.i("MicroMsg.FileDownloadService", "file not exists, appid = " + ((com.tencent.mm.plugin.downloader.g.a)localObject2).field_appId);
          AppMethodBeat.o(2442);
          return;
        }
        if (bo.isNullOrNil(((com.tencent.mm.plugin.downloader.g.a)localObject2).field_md5))
        {
          ab.i("MicroMsg.FileDownloadService", "Invalid original md5, abort checking");
          ((com.tencent.mm.plugin.downloader.g.a)localObject2).field_status = 3;
          d.e((com.tencent.mm.plugin.downloader.g.a)localObject2);
          f.bjl().p(l2, bool2);
          AppMethodBeat.o(2442);
          return;
        }
        l1 = 0L;
        if (bo.isNullOrNil(((com.tencent.mm.plugin.downloader.g.a)localObject2).field_appId)) {
          break label1924;
        }
        l1 = System.currentTimeMillis();
        try
        {
          File localFile = new File(((com.tencent.mm.plugin.downloader.g.a)localObject2).field_filePath);
          localObject1 = localFile.getAbsolutePath();
          bool1 = com.tencent.mm.plugin.downloader.d.c.JB((String)localObject1);
          if (!bool1) {
            break label1014;
          }
          paramIntent = "v2";
          label454:
          ab.i("MicroMsg.Channel.GameChannelUtil", "apkPath:%s, this is %s signature", new Object[] { localObject1, paramIntent });
          localObject1 = null;
          if (bool1) {
            localObject1 = com.tencent.mm.plugin.downloader.d.c.L(localFile);
          }
          paramIntent = (Intent)localObject1;
          if (localObject1 == null)
          {
            localObject1 = com.tencent.mm.plugin.downloader.d.c.K(localFile);
            paramIntent = (Intent)localObject1;
            if (bool1)
            {
              paramIntent = (Intent)localObject1;
              if (localObject1 != null)
              {
                ab.i("MicroMsg.Channel.GameChannelUtil", "you are use v2 signature but use v1 channel modle, this apk will can't install in 7.0system");
                paramIntent = (Intent)localObject1;
              }
            }
          }
          ab.i("MicroMsg.Channel.GameChannelUtil", "readChannel, channelId = %s", new Object[] { paramIntent });
        }
        catch (Exception paramIntent)
        {
          for (;;)
          {
            long l3;
            ab.e("MicroMsg.FileDownloadService", "readChannelId exception : " + paramIntent.getMessage());
            paramIntent = "";
            continue;
            i = 0;
            continue;
            com.tencent.mm.plugin.downloader.f.a.I(((com.tencent.mm.plugin.downloader.g.a)localObject2).field_appId, 22L);
            com.tencent.mm.plugin.downloader.f.a.a(109, (b)localObject1);
            continue;
            com.tencent.mm.plugin.downloader.f.a.I(((com.tencent.mm.plugin.downloader.g.a)localObject2).field_appId, 31L);
          }
        }
        l3 = System.currentTimeMillis() - l1;
        l1 = 0L + l3;
        ab.i("MicroMsg.FileDownloadService", "readChannelId, channelId:%s, cost time: %d", new Object[] { paramIntent, Long.valueOf(l3) });
      }
      break;
    }
    for (;;)
    {
      localObject1 = ((com.tencent.mm.plugin.downloader.g.a)localObject2).field_appId;
      l3 = ((com.tencent.mm.plugin.downloader.g.a)localObject2).field_downloadId;
      boolean bool3;
      if (((com.tencent.mm.plugin.downloader.g.a)localObject2).field_reserveInWifi)
      {
        i = 1;
        localObject1 = new b((String)localObject1, l3, paramIntent, l1, i);
        bool1 = e.K(((com.tencent.mm.plugin.downloader.g.a)localObject2).field_filePath, ((com.tencent.mm.plugin.downloader.g.a)localObject2).field_md5, ((com.tencent.mm.plugin.downloader.g.a)localObject2).field_appId);
        if (bool2)
        {
          if (!bool1) {
            break label1059;
          }
          com.tencent.mm.plugin.downloader.f.a.I(((com.tencent.mm.plugin.downloader.g.a)localObject2).field_appId, 21L);
          com.tencent.mm.plugin.downloader.f.a.a(108, (b)localObject1);
        }
        if (!bool1)
        {
          if (!((com.tencent.mm.plugin.downloader.g.a)localObject2).field_downloadUrl.startsWith("https")) {
            break label1080;
          }
          com.tencent.mm.plugin.downloader.f.a.I(((com.tencent.mm.plugin.downloader.g.a)localObject2).field_appId, 32L);
        }
        if ((bool1) || (bo.isNullOrNil(((com.tencent.mm.plugin.downloader.g.a)localObject2).field_appId))) {
          break label1921;
        }
        bool3 = false;
        l3 = System.currentTimeMillis();
      }
      try
      {
        boolean bool4 = com.tencent.mm.plugin.downloader.d.e.f(new File(((com.tencent.mm.plugin.downloader.g.a)localObject2).field_filePath), "10000145");
        bool3 = bool4;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          int j;
          ab.e("MicroMsg.FileDownloadService", "writeChannelId exception : " + localException.getMessage());
          continue;
          com.tencent.mm.plugin.downloader.f.a.I(((com.tencent.mm.plugin.downloader.g.a)localObject2).field_appId, 25L);
          i = 103;
          continue;
          i = 101;
          com.tencent.mm.plugin.downloader.f.a.I(((com.tencent.mm.plugin.downloader.g.a)localObject2).field_appId, 23L);
          continue;
          i = 105;
          com.tencent.mm.plugin.downloader.f.a.I(((com.tencent.mm.plugin.downloader.g.a)localObject2).field_appId, 27L);
          continue;
          i = 106;
          com.tencent.mm.plugin.downloader.f.a.I(((com.tencent.mm.plugin.downloader.g.a)localObject2).field_appId, 28L);
          continue;
          i = 104;
          com.tencent.mm.plugin.downloader.f.a.I(((com.tencent.mm.plugin.downloader.g.a)localObject2).field_appId, 26L);
        }
        if (((com.tencent.mm.plugin.downloader.g.a)localObject2).field_downloaderType != 3) {
          break label1626;
        }
        if (!((com.tencent.mm.plugin.downloader.g.a)localObject2).field_downloadUrl.startsWith("https")) {
          break label1609;
        }
        h.qsU.idkeyStat(710L, 10L, 1L, false);
        ((com.tencent.mm.plugin.downloader.g.a)localObject2).field_status = 4;
        ((com.tencent.mm.plugin.downloader.g.a)localObject2).field_channelId = paramIntent;
        ((com.tencent.mm.plugin.downloader.g.a)localObject2).field_errCode = com.tencent.mm.plugin.downloader.a.a.kVv;
        ((com.tencent.mm.plugin.downloader.g.a)localObject2).field_downloadedSize = com.tencent.mm.vfs.e.avI(((com.tencent.mm.plugin.downloader.g.a)localObject2).field_filePath);
        d.e((com.tencent.mm.plugin.downloader.g.a)localObject2);
        ab.i("MicroMsg.FileDownloadService", "ChannelId = %s, receivedSize = %d, fileSize = %d", new Object[] { paramIntent, Long.valueOf(((com.tencent.mm.plugin.downloader.g.a)localObject2).field_downloadedSize), Long.valueOf(com.tencent.mm.vfs.e.avI(((com.tencent.mm.plugin.downloader.g.a)localObject2).field_filePath)) });
        ab.i("MicroMsg.FileDownloadService", "delete file: %s", new Object[] { ((com.tencent.mm.plugin.downloader.g.a)localObject2).field_filePath });
        com.tencent.mm.vfs.e.deleteFile(((com.tencent.mm.plugin.downloader.g.a)localObject2).field_filePath);
        bool3 = at.isWifi(ah.getContext());
        if (bo.isNullOrNil(((com.tencent.mm.plugin.downloader.g.a)localObject2).field_secondaryUrl)) {
          break label1674;
        }
        bool1 = true;
        ab.i("MicroMsg.FileDownloadService", "checkMd5, isWifi: %b, hasChangeUrl: %b, hasHttpsUrl: %b", new Object[] { Boolean.valueOf(bool3), Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
        if (!l(bool2, ((com.tencent.mm.plugin.downloader.g.a)localObject2).field_secondaryUrl)) {
          break label1709;
        }
        paramIntent = new g.a();
        paramIntent.JJ(((com.tencent.mm.plugin.downloader.g.a)localObject2).field_secondaryUrl);
        paramIntent.iR(((com.tencent.mm.plugin.downloader.g.a)localObject2).field_fileSize);
        paramIntent.JL(((com.tencent.mm.plugin.downloader.g.a)localObject2).field_fileName);
        paramIntent.setAppId(((com.tencent.mm.plugin.downloader.g.a)localObject2).field_appId);
        paramIntent.JM(((com.tencent.mm.plugin.downloader.g.a)localObject2).field_md5);
        paramIntent.setScene(((com.tencent.mm.plugin.downloader.g.a)localObject2).field_scene);
        paramIntent.JN(((com.tencent.mm.plugin.downloader.g.a)localObject2).field_extInfo);
        paramIntent.kYR.kYJ = true;
        paramIntent.gr(true);
        paramIntent.tV(1);
        paramIntent.dC(((com.tencent.mm.plugin.downloader.g.a)localObject2).field_packageName);
        paramIntent.kYR.kYL = true;
        if (((com.tencent.mm.plugin.downloader.g.a)localObject2).field_downloaderType == 3) {
          break label1680;
        }
        l1 = f.bjl().a(paramIntent.kYR);
        h.qsU.idkeyStat(710L, 8L, 1L, false);
        for (;;)
        {
          ab.i("MicroMsg.FileDownloadService", "MD5 check failed, restart download, id = ".concat(String.valueOf(l1)));
          com.tencent.mm.plugin.downloader.f.a.a(110, (b)localObject1);
          com.tencent.mm.plugin.downloader.f.a.I(((com.tencent.mm.plugin.downloader.g.a)localObject2).field_appId, 30L);
          AppMethodBeat.o(2442);
          return;
          h.qsU.idkeyStat(710L, 9L, 1L, false);
          break;
          if (((com.tencent.mm.plugin.downloader.g.a)localObject2).field_downloadUrl.startsWith("https"))
          {
            h.qsU.idkeyStat(710L, 7L, 1L, false);
            break;
          }
          h.qsU.idkeyStat(710L, 6L, 1L, false);
          break;
          bool1 = false;
          break label1378;
          l1 = f.bjl().b(paramIntent.kYR);
          h.qsU.idkeyStat(710L, 11L, 1L, false);
        }
        paramIntent = f.bjl();
        localObject1 = d.iJ(l2);
        if (localObject1 == null) {
          break label1783;
        }
      }
      l3 = System.currentTimeMillis() - l3;
      ab.i("MicroMsg.FileDownloadService", "writeChannelId result:%b, cost time: %d", new Object[] { Boolean.valueOf(bool3), Long.valueOf(l3) });
      ab.i("MicroMsg.FileDownloadService", "channel opration cost time: %d", new Object[] { Long.valueOf(l1 + l3) });
      if (bool3)
      {
        bool1 = e.K(((com.tencent.mm.plugin.downloader.g.a)localObject2).field_filePath, ((com.tencent.mm.plugin.downloader.g.a)localObject2).field_md5, ((com.tencent.mm.plugin.downloader.g.a)localObject2).field_appId);
        ab.i("MicroMsg.FileDownloadService", "after modify channel, ret:%b", new Object[] { Boolean.valueOf(bool1) });
        if (bool1)
        {
          paramIntent = "10000145";
          com.tencent.mm.plugin.downloader.f.a.I(((com.tencent.mm.plugin.downloader.g.a)localObject2).field_appId, 24L);
          i = 102;
          com.tencent.mm.plugin.downloader.f.a.a(i, (b)localObject1);
          if (!bool2) {
            j = 0;
          }
          switch (i)
          {
          default: 
            i = j;
            ((b)localObject1).iHc = 0L;
            com.tencent.mm.plugin.downloader.f.a.a(i, (b)localObject1);
            if ((bool1) && (!l(bool2, ((com.tencent.mm.plugin.downloader.g.a)localObject2).field_secondaryUrl)))
            {
              com.tencent.mm.plugin.downloader.f.a.a(107, (b)localObject1);
              com.tencent.mm.plugin.downloader.f.a.I(((com.tencent.mm.plugin.downloader.g.a)localObject2).field_appId, 29L);
            }
            break;
          }
        }
      }
      label1921:
      for (;;)
      {
        if (bool1)
        {
          ((com.tencent.mm.plugin.downloader.g.a)localObject2).field_status = 3;
          ((com.tencent.mm.plugin.downloader.g.a)localObject2).field_channelId = paramIntent;
          d.e((com.tencent.mm.plugin.downloader.g.a)localObject2);
          f.bjl().p(l2, bool2);
          AppMethodBeat.o(2442);
          return;
          label1014:
          paramIntent = "v1";
          break label454;
        }
        label1059:
        label1080:
        label1378:
        localObject2 = ah.getContext();
        label1609:
        label1626:
        if ((((com.tencent.mm.plugin.downloader.g.a)localObject1).field_showNotification) && (bo.isNullOrNil(((com.tencent.mm.plugin.downloader.g.a)localObject1).field_fileName))) {
          f.a(((com.tencent.mm.plugin.downloader.g.a)localObject1).field_appId, ((Context)localObject2).getString(2131299872), "", null);
        }
        for (;;)
        {
          label1674:
          label1680:
          label1709:
          paramIntent.kYw.d(l2, com.tencent.mm.plugin.downloader.a.a.kVv, bool2);
          label1783:
          AppMethodBeat.o(2442);
          return;
          if ((((com.tencent.mm.plugin.downloader.g.a)localObject1).field_showNotification) && (!bo.isNullOrNil(((com.tencent.mm.plugin.downloader.g.a)localObject1).field_fileName))) {
            f.a(((com.tencent.mm.plugin.downloader.g.a)localObject1).field_appId, ((com.tencent.mm.plugin.downloader.g.a)localObject1).field_fileName, ((Context)localObject2).getString(2131299872), null);
          }
        }
        localObject1 = paramIntent.getStringExtra(kYU);
        l1 = paramIntent.getLongExtra("downloadId", -1L);
        if ((bo.isNullOrNil((String)localObject1)) || (!com.tencent.mm.vfs.e.cN((String)localObject1)))
        {
          ab.i("MicroMsg.FileDownloadService", "Invalid file path, ignored");
          AppMethodBeat.o(2442);
          return;
        }
        paramIntent = d.iJ(l1);
        if (paramIntent != null)
        {
          com.tencent.mm.plugin.downloader.i.a.a(paramIntent.field_downloadId, false, null);
          AppMethodBeat.o(2442);
          return;
        }
        com.tencent.mm.plugin.downloader.i.a.a((String)localObject1, null);
        break;
      }
      label1924:
      paramIntent = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.model.FileDownloadService
 * JD-Core Version:    0.7.0.1
 */