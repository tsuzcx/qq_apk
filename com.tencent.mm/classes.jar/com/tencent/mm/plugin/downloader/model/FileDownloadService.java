package com.tencent.mm.plugin.downloader.model;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.c.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.service.MMIntentService;
import com.tencent.mm.vfs.u;
import java.io.IOException;

public class FileDownloadService
  extends MMIntentService
{
  private static final String uhZ;
  public static final String uia;
  public static final String uib;
  public static final String uic;
  public static final String uie;
  public static final String uif;
  public static final String uig;
  
  static
  {
    AppMethodBeat.i(89010);
    uhZ = FileDownloadService.class.getSimpleName() + "_extra_";
    uia = uhZ + "id";
    uib = uhZ + "action_type";
    uic = uhZ + "package_name";
    uie = uhZ + "file_path";
    uif = uhZ + "md5";
    uig = uhZ + "change_url";
    AppMethodBeat.o(89010);
  }
  
  public FileDownloadService()
  {
    super("FileDownloadService");
  }
  
  public final String getTag()
  {
    return "MicroMsg.FileDownloadService";
  }
  
  public final void onHandleIntent(Intent paramIntent)
  {
    AppMethodBeat.i(89008);
    if (paramIntent == null)
    {
      AppMethodBeat.o(89008);
      return;
    }
    int i = paramIntent.getIntExtra(uib, 0);
    Log.i("MicroMsg.FileDownloadService", "handle intent type : %d", new Object[] { Integer.valueOf(i) });
    long l2;
    Object localObject2;
    boolean bool1;
    long l1;
    Object localObject3;
    Object localObject1;
    boolean bool2;
    switch (i)
    {
    case 2: 
    default: 
      AppMethodBeat.o(89008);
      return;
    case 1: 
      l2 = paramIntent.getLongExtra(uia, -1L);
      if (l2 < 0L)
      {
        Log.e("MicroMsg.FileDownloadService", "Invalid id");
        AppMethodBeat.o(89008);
        return;
      }
      if (com.tencent.mm.kernel.h.aHE().aGM())
      {
        com.tencent.mm.kernel.h.aHE();
        if (!com.tencent.mm.kernel.b.aGE()) {}
      }
      else
      {
        Log.d("MicroMsg.FileDownloadService", "no user login");
        AppMethodBeat.o(89008);
        return;
      }
      localObject2 = d.IF(l2);
      if (localObject2 != null)
      {
        if ((paramIntent.getBooleanExtra(uig, false)) || (((com.tencent.mm.plugin.downloader.g.a)localObject2).field_isSecondDownload)) {}
        for (bool1 = true;; bool1 = false)
        {
          Log.i("MicroMsg.FileDownloadService", "filePath = " + ((com.tencent.mm.plugin.downloader.g.a)localObject2).field_filePath);
          if ((!Util.isNullOrNil(((com.tencent.mm.plugin.downloader.g.a)localObject2).field_filePath)) && (u.agG(((com.tencent.mm.plugin.downloader.g.a)localObject2).field_filePath))) {
            break;
          }
          com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(710L, 5L, 1L, false);
          ((com.tencent.mm.plugin.downloader.g.a)localObject2).field_status = 4;
          ((com.tencent.mm.plugin.downloader.g.a)localObject2).field_errCode = com.tencent.mm.plugin.downloader.a.a.uey;
          d.e((com.tencent.mm.plugin.downloader.g.a)localObject2);
          paramIntent = f.cPZ();
          i = com.tencent.mm.plugin.downloader.a.a.uey;
          Log.i("MicroMsg.FileDownloadManager", "onDownloadFailed, id = %d, errCode = %d", new Object[] { Long.valueOf(l2), Integer.valueOf(i) });
          if (paramIntent.uhy != null) {
            paramIntent.uhy.c(l2, i, bool1);
          }
          Log.i("MicroMsg.FileDownloadService", "file not exists, appid = " + ((com.tencent.mm.plugin.downloader.g.a)localObject2).field_appId);
          AppMethodBeat.o(89008);
          return;
        }
        if (Util.isNullOrNil(((com.tencent.mm.plugin.downloader.g.a)localObject2).field_md5))
        {
          Log.i("MicroMsg.FileDownloadService", "Invalid original md5, abort checking");
          ((com.tencent.mm.plugin.downloader.g.a)localObject2).field_status = 3;
          d.e((com.tencent.mm.plugin.downloader.g.a)localObject2);
          f.cPZ().o(l2, bool1);
          AppMethodBeat.o(89008);
          return;
        }
        l1 = 0L;
        if (Util.isNullOrNil(((com.tencent.mm.plugin.downloader.g.a)localObject2).field_appId)) {
          break label1632;
        }
        l1 = System.currentTimeMillis();
        try
        {
          localObject3 = new com.tencent.mm.vfs.q(((com.tencent.mm.plugin.downloader.g.a)localObject2).field_filePath);
          localObject1 = ((com.tencent.mm.vfs.q)localObject3).bOF();
          bool2 = com.tencent.mm.plugin.downloader.d.b.asS((String)localObject1);
          if (!bool2) {
            break label730;
          }
          paramIntent = "v2";
          Log.i("MicroMsg.Channel.GameChannelUtil", "apkPath:%s, this is %s signature", new Object[] { localObject1, paramIntent });
          localObject1 = null;
          if (bool2) {
            localObject1 = com.tencent.mm.plugin.downloader.d.b.I((com.tencent.mm.vfs.q)localObject3);
          }
          paramIntent = (Intent)localObject1;
          if (localObject1 == null)
          {
            localObject1 = com.tencent.mm.plugin.downloader.d.b.H((com.tencent.mm.vfs.q)localObject3);
            paramIntent = (Intent)localObject1;
            if (bool2)
            {
              paramIntent = (Intent)localObject1;
              if (localObject1 != null)
              {
                Log.i("MicroMsg.Channel.GameChannelUtil", "you are use v2 signature but use v1 channel modle, this apk will can't install in 7.0system");
                paramIntent = (Intent)localObject1;
              }
            }
          }
          Log.i("MicroMsg.Channel.GameChannelUtil", "readChannel, channelId = %s", new Object[] { paramIntent });
        }
        catch (Exception paramIntent)
        {
          for (;;)
          {
            long l3;
            Log.e("MicroMsg.FileDownloadService", "readChannelId exception : " + paramIntent.getMessage());
            paramIntent = "";
            continue;
            i = 0;
            continue;
            com.tencent.mm.plugin.downloader.f.a.ab(((com.tencent.mm.plugin.downloader.g.a)localObject2).field_appId, 22L);
            com.tencent.mm.plugin.downloader.f.a.a(109, (com.tencent.mm.plugin.downloader.f.b)localObject1);
            continue;
            com.tencent.mm.plugin.downloader.f.a.ab(((com.tencent.mm.plugin.downloader.g.a)localObject2).field_appId, 31L);
          }
        }
        l3 = System.currentTimeMillis() - l1;
        l1 = 0L + l3;
        Log.i("MicroMsg.FileDownloadService", "readChannelId, channelId:%s, cost time: %d", new Object[] { paramIntent, Long.valueOf(l3) });
      }
      break;
    }
    for (;;)
    {
      for (;;)
      {
        localObject1 = ((com.tencent.mm.plugin.downloader.g.a)localObject2).field_appId;
        l3 = ((com.tencent.mm.plugin.downloader.g.a)localObject2).field_downloadId;
        if (((com.tencent.mm.plugin.downloader.g.a)localObject2).field_reserveInWifi)
        {
          i = 1;
          localObject1 = new com.tencent.mm.plugin.downloader.f.b((String)localObject1, l3, paramIntent, l1, i);
          bool2 = e.f((com.tencent.mm.plugin.downloader.g.a)localObject2);
          if (bool1)
          {
            if (!bool2) {
              break label775;
            }
            com.tencent.mm.plugin.downloader.f.a.ab(((com.tencent.mm.plugin.downloader.g.a)localObject2).field_appId, 21L);
            com.tencent.mm.plugin.downloader.f.a.a(108, (com.tencent.mm.plugin.downloader.f.b)localObject1);
          }
          if (!bool2)
          {
            if (!((com.tencent.mm.plugin.downloader.g.a)localObject2).field_downloadUrl.startsWith("https")) {
              break label796;
            }
            com.tencent.mm.plugin.downloader.f.a.ab(((com.tencent.mm.plugin.downloader.g.a)localObject2).field_appId, 32L);
          }
          if (!bool2) {
            break label810;
          }
          ((com.tencent.mm.plugin.downloader.g.a)localObject2).field_status = 3;
          ((com.tencent.mm.plugin.downloader.g.a)localObject2).field_channelId = paramIntent;
          d.e((com.tencent.mm.plugin.downloader.g.a)localObject2);
          d.dq(((com.tencent.mm.plugin.downloader.g.a)localObject2).field_downloadUrl, 3);
          f.cPZ().o(l2, bool1);
          AppMethodBeat.o(89008);
          return;
          label730:
          paramIntent = "v1";
          break;
        }
        label775:
        label796:
        label810:
        if (((com.tencent.mm.plugin.downloader.g.a)localObject2).field_downloaderType == 3) {
          if (((com.tencent.mm.plugin.downloader.g.a)localObject2).field_downloadUrl.startsWith("https"))
          {
            com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(710L, 10L, 1L, false);
            ((com.tencent.mm.plugin.downloader.g.a)localObject2).field_status = 4;
            ((com.tencent.mm.plugin.downloader.g.a)localObject2).field_channelId = paramIntent;
            ((com.tencent.mm.plugin.downloader.g.a)localObject2).field_errCode = com.tencent.mm.plugin.downloader.a.a.ueu;
            ((com.tencent.mm.plugin.downloader.g.a)localObject2).field_downloadedSize = u.bBQ(((com.tencent.mm.plugin.downloader.g.a)localObject2).field_filePath);
            d.e((com.tencent.mm.plugin.downloader.g.a)localObject2);
            Log.i("MicroMsg.FileDownloadService", "ChannelId = %s, receivedSize = %d, fileSize = %d", new Object[] { paramIntent, Long.valueOf(((com.tencent.mm.plugin.downloader.g.a)localObject2).field_downloadedSize), Long.valueOf(u.bBQ(((com.tencent.mm.plugin.downloader.g.a)localObject2).field_filePath)) });
            Log.i("MicroMsg.FileDownloadService", "delete file: %s", new Object[] { ((com.tencent.mm.plugin.downloader.g.a)localObject2).field_filePath });
            u.deleteFile(((com.tencent.mm.plugin.downloader.g.a)localObject2).field_filePath);
            boolean bool3 = NetStatusUtil.isWifi(MMApplicationContext.getContext());
            if (Util.isNullOrNil(((com.tencent.mm.plugin.downloader.g.a)localObject2).field_secondaryUrl)) {
              break label1337;
            }
            bool2 = true;
            label978:
            Log.i("MicroMsg.FileDownloadService", "checkMd5, isWifi: %b, hasChangeUrl: %b, hasHttpsUrl: %b", new Object[] { Boolean.valueOf(bool3), Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
            paramIntent = ((com.tencent.mm.plugin.downloader.g.a)localObject2).field_secondaryUrl;
            if ((!NetStatusUtil.isWifi(MMApplicationContext.getContext())) || (bool1) || (Util.isNullOrNil(paramIntent))) {
              break label1343;
            }
            i = 1;
            if (i == 0) {
              break label1376;
            }
            paramIntent = new g.a();
            paramIntent.atc(((com.tencent.mm.plugin.downloader.g.a)localObject2).field_secondaryUrl);
            paramIntent.setFileSize(((com.tencent.mm.plugin.downloader.g.a)localObject2).field_fileSize);
            paramIntent.ate(((com.tencent.mm.plugin.downloader.g.a)localObject2).field_fileName);
            paramIntent.ath(((com.tencent.mm.plugin.downloader.g.a)localObject2).field_notificationTitle);
            paramIntent.setAppId(((com.tencent.mm.plugin.downloader.g.a)localObject2).field_appId);
            paramIntent.setFileMD5(((com.tencent.mm.plugin.downloader.g.a)localObject2).field_md5);
            paramIntent.setScene(((com.tencent.mm.plugin.downloader.g.a)localObject2).field_scene);
            paramIntent.YS(((com.tencent.mm.plugin.downloader.g.a)localObject2).field_extInfo);
            paramIntent.uhY.uhL = true;
            paramIntent.me(true);
            paramIntent.IS(1);
            paramIntent.setPackageName(((com.tencent.mm.plugin.downloader.g.a)localObject2).field_packageName);
            paramIntent.uhY.uhN = true;
            if (((com.tencent.mm.plugin.downloader.g.a)localObject2).field_sectionMd5Byte != null) {
              localObject3 = new com.tencent.mm.plugin.downloader.c.b.q();
            }
          }
        }
        try
        {
          label1043:
          ((com.tencent.mm.plugin.downloader.c.b.q)localObject3).parseFrom(((com.tencent.mm.plugin.downloader.g.a)localObject2).field_sectionMd5Byte);
          paramIntent.T(((com.tencent.mm.plugin.downloader.c.b.q)localObject3).ufA);
          label1199:
          if (((com.tencent.mm.plugin.downloader.g.a)localObject2).field_downloaderType != 3)
          {
            l1 = f.cPZ().a(paramIntent.uhY);
            com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(710L, 8L, 1L, false);
          }
          for (;;)
          {
            Log.i("MicroMsg.FileDownloadService", "MD5 check failed, restart download, id = ".concat(String.valueOf(l1)));
            com.tencent.mm.plugin.downloader.f.a.a(110, (com.tencent.mm.plugin.downloader.f.b)localObject1);
            com.tencent.mm.plugin.downloader.f.a.ab(((com.tencent.mm.plugin.downloader.g.a)localObject2).field_appId, 30L);
            AppMethodBeat.o(89008);
            return;
            com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(710L, 9L, 1L, false);
            break;
            if (((com.tencent.mm.plugin.downloader.g.a)localObject2).field_downloadUrl.startsWith("https"))
            {
              com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(710L, 7L, 1L, false);
              break;
            }
            com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(710L, 6L, 1L, false);
            break;
            label1337:
            bool2 = false;
            break label978;
            label1343:
            i = 0;
            break label1043;
            l1 = f.cPZ().b(paramIntent.uhY);
            com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(710L, 11L, 1L, false);
          }
          label1376:
          paramIntent = f.cPZ();
          localObject1 = d.IF(l2);
          if (localObject1 != null)
          {
            localObject2 = MMApplicationContext.getContext();
            if ((!((com.tencent.mm.plugin.downloader.g.a)localObject1).field_showNotification) || (Util.isNullOrNil(((com.tencent.mm.plugin.downloader.g.a)localObject1).field_notificationTitle))) {
              break label1458;
            }
            f.a(((com.tencent.mm.plugin.downloader.g.a)localObject1).field_appId, ((com.tencent.mm.plugin.downloader.g.a)localObject1).field_notificationTitle, ((Context)localObject2).getString(c.d.file_downloader_md5check_failed), null);
          }
          for (;;)
          {
            paramIntent.uhy.c(l2, com.tencent.mm.plugin.downloader.a.a.ueu, bool1);
            AppMethodBeat.o(89008);
            return;
            label1458:
            if ((((com.tencent.mm.plugin.downloader.g.a)localObject1).field_showNotification) && (Util.isNullOrNil(((com.tencent.mm.plugin.downloader.g.a)localObject1).field_fileName))) {
              f.a(((com.tencent.mm.plugin.downloader.g.a)localObject1).field_appId, ((Context)localObject2).getString(c.d.file_downloader_md5check_failed), "", null);
            } else if ((((com.tencent.mm.plugin.downloader.g.a)localObject1).field_showNotification) && (!Util.isNullOrNil(((com.tencent.mm.plugin.downloader.g.a)localObject1).field_fileName))) {
              f.a(((com.tencent.mm.plugin.downloader.g.a)localObject1).field_appId, ((com.tencent.mm.plugin.downloader.g.a)localObject1).field_fileName, ((Context)localObject2).getString(c.d.file_downloader_md5check_failed), null);
            }
          }
          localObject1 = paramIntent.getStringExtra(uie);
          l1 = paramIntent.getLongExtra("downloadId", -1L);
          if ((Util.isNullOrNil((String)localObject1)) || (!u.agG((String)localObject1)))
          {
            Log.i("MicroMsg.FileDownloadService", "Invalid file path, ignored");
            AppMethodBeat.o(89008);
            return;
          }
          paramIntent = d.IF(l1);
          if (paramIntent != null)
          {
            com.tencent.mm.plugin.downloader.i.a.a(paramIntent.field_downloadId, false, null);
            AppMethodBeat.o(89008);
            return;
          }
          com.tencent.mm.plugin.downloader.i.a.a((String)localObject1, null);
        }
        catch (IOException localIOException)
        {
          break label1199;
        }
      }
      label1632:
      paramIntent = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.model.FileDownloadService
 * JD-Core Version:    0.7.0.1
 */