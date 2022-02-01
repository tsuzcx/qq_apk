package com.tencent.mm.plugin.downloader.model;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.downloader.c.b.q;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.service.MMIntentService;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.io.IOException;

public class FileDownloadService
  extends MMIntentService
{
  public static final String EXTRA_ID;
  public static final String EXTRA_PACKAGE_NAME;
  private static final String qIZ;
  public static final String qJa;
  public static final String qJb;
  public static final String qJc;
  public static final String qJd;
  
  static
  {
    AppMethodBeat.i(89010);
    qIZ = FileDownloadService.class.getSimpleName() + "_extra_";
    EXTRA_ID = qIZ + "id";
    qJa = qIZ + "action_type";
    EXTRA_PACKAGE_NAME = qIZ + "package_name";
    qJb = qIZ + "file_path";
    qJc = qIZ + "md5";
    qJd = qIZ + "change_url";
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
    int i = paramIntent.getIntExtra(qJa, 0);
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
      l2 = paramIntent.getLongExtra(EXTRA_ID, -1L);
      if (l2 < 0L)
      {
        Log.e("MicroMsg.FileDownloadService", "Invalid id");
        AppMethodBeat.o(89008);
        return;
      }
      if (g.aAf().azp())
      {
        g.aAf();
        if (!com.tencent.mm.kernel.a.azj()) {}
      }
      else
      {
        Log.d("MicroMsg.FileDownloadService", "no user login");
        AppMethodBeat.o(89008);
        return;
      }
      localObject2 = d.Cw(l2);
      if (localObject2 != null)
      {
        if ((paramIntent.getBooleanExtra(qJd, false)) || (((com.tencent.mm.plugin.downloader.g.a)localObject2).field_isSecondDownload)) {}
        for (bool1 = true;; bool1 = false)
        {
          Log.i("MicroMsg.FileDownloadService", "filePath = " + ((com.tencent.mm.plugin.downloader.g.a)localObject2).field_filePath);
          if ((!Util.isNullOrNil(((com.tencent.mm.plugin.downloader.g.a)localObject2).field_filePath)) && (s.YS(((com.tencent.mm.plugin.downloader.g.a)localObject2).field_filePath))) {
            break;
          }
          h.CyF.idkeyStat(710L, 5L, 1L, false);
          ((com.tencent.mm.plugin.downloader.g.a)localObject2).field_status = 4;
          ((com.tencent.mm.plugin.downloader.g.a)localObject2).field_errCode = com.tencent.mm.plugin.downloader.a.a.qFw;
          d.e((com.tencent.mm.plugin.downloader.g.a)localObject2);
          paramIntent = f.cBv();
          i = com.tencent.mm.plugin.downloader.a.a.qFw;
          Log.i("MicroMsg.FileDownloadManager", "onDownloadFailed, id = %d, errCode = %d", new Object[] { Long.valueOf(l2), Integer.valueOf(i) });
          if (paramIntent.qIy != null) {
            paramIntent.qIy.c(l2, i, bool1);
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
          f.cBv().o(l2, bool1);
          AppMethodBeat.o(89008);
          return;
        }
        l1 = 0L;
        if (Util.isNullOrNil(((com.tencent.mm.plugin.downloader.g.a)localObject2).field_appId)) {
          break label1635;
        }
        l1 = System.currentTimeMillis();
        try
        {
          localObject3 = new o(((com.tencent.mm.plugin.downloader.g.a)localObject2).field_filePath);
          localObject1 = aa.z(((o)localObject3).her());
          bool2 = com.tencent.mm.plugin.downloader.d.b.akZ((String)localObject1);
          if (!bool2) {
            break label733;
          }
          paramIntent = "v2";
          Log.i("MicroMsg.Channel.GameChannelUtil", "apkPath:%s, this is %s signature", new Object[] { localObject1, paramIntent });
          localObject1 = null;
          if (bool2) {
            localObject1 = com.tencent.mm.plugin.downloader.d.b.J((o)localObject3);
          }
          paramIntent = (Intent)localObject1;
          if (localObject1 == null)
          {
            localObject1 = com.tencent.mm.plugin.downloader.d.b.I((o)localObject3);
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
            com.tencent.mm.plugin.downloader.f.a.aa(((com.tencent.mm.plugin.downloader.g.a)localObject2).field_appId, 22L);
            com.tencent.mm.plugin.downloader.f.a.a(109, (com.tencent.mm.plugin.downloader.f.b)localObject1);
            continue;
            com.tencent.mm.plugin.downloader.f.a.aa(((com.tencent.mm.plugin.downloader.g.a)localObject2).field_appId, 31L);
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
              break label778;
            }
            com.tencent.mm.plugin.downloader.f.a.aa(((com.tencent.mm.plugin.downloader.g.a)localObject2).field_appId, 21L);
            com.tencent.mm.plugin.downloader.f.a.a(108, (com.tencent.mm.plugin.downloader.f.b)localObject1);
          }
          if (!bool2)
          {
            if (!((com.tencent.mm.plugin.downloader.g.a)localObject2).field_downloadUrl.startsWith("https")) {
              break label799;
            }
            com.tencent.mm.plugin.downloader.f.a.aa(((com.tencent.mm.plugin.downloader.g.a)localObject2).field_appId, 32L);
          }
          if (!bool2) {
            break label813;
          }
          ((com.tencent.mm.plugin.downloader.g.a)localObject2).field_status = 3;
          ((com.tencent.mm.plugin.downloader.g.a)localObject2).field_channelId = paramIntent;
          d.e((com.tencent.mm.plugin.downloader.g.a)localObject2);
          d.cW(((com.tencent.mm.plugin.downloader.g.a)localObject2).field_downloadUrl, 3);
          f.cBv().o(l2, bool1);
          AppMethodBeat.o(89008);
          return;
          label733:
          paramIntent = "v1";
          break;
        }
        label778:
        label799:
        label813:
        if (((com.tencent.mm.plugin.downloader.g.a)localObject2).field_downloaderType == 3) {
          if (((com.tencent.mm.plugin.downloader.g.a)localObject2).field_downloadUrl.startsWith("https"))
          {
            h.CyF.idkeyStat(710L, 10L, 1L, false);
            ((com.tencent.mm.plugin.downloader.g.a)localObject2).field_status = 4;
            ((com.tencent.mm.plugin.downloader.g.a)localObject2).field_channelId = paramIntent;
            ((com.tencent.mm.plugin.downloader.g.a)localObject2).field_errCode = com.tencent.mm.plugin.downloader.a.a.qFs;
            ((com.tencent.mm.plugin.downloader.g.a)localObject2).field_downloadedSize = s.boW(((com.tencent.mm.plugin.downloader.g.a)localObject2).field_filePath);
            d.e((com.tencent.mm.plugin.downloader.g.a)localObject2);
            Log.i("MicroMsg.FileDownloadService", "ChannelId = %s, receivedSize = %d, fileSize = %d", new Object[] { paramIntent, Long.valueOf(((com.tencent.mm.plugin.downloader.g.a)localObject2).field_downloadedSize), Long.valueOf(s.boW(((com.tencent.mm.plugin.downloader.g.a)localObject2).field_filePath)) });
            Log.i("MicroMsg.FileDownloadService", "delete file: %s", new Object[] { ((com.tencent.mm.plugin.downloader.g.a)localObject2).field_filePath });
            s.deleteFile(((com.tencent.mm.plugin.downloader.g.a)localObject2).field_filePath);
            boolean bool3 = NetStatusUtil.isWifi(MMApplicationContext.getContext());
            if (Util.isNullOrNil(((com.tencent.mm.plugin.downloader.g.a)localObject2).field_secondaryUrl)) {
              break label1340;
            }
            bool2 = true;
            label981:
            Log.i("MicroMsg.FileDownloadService", "checkMd5, isWifi: %b, hasChangeUrl: %b, hasHttpsUrl: %b", new Object[] { Boolean.valueOf(bool3), Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
            paramIntent = ((com.tencent.mm.plugin.downloader.g.a)localObject2).field_secondaryUrl;
            if ((!NetStatusUtil.isWifi(MMApplicationContext.getContext())) || (bool1) || (Util.isNullOrNil(paramIntent))) {
              break label1346;
            }
            i = 1;
            if (i == 0) {
              break label1379;
            }
            paramIntent = new g.a();
            paramIntent.alj(((com.tencent.mm.plugin.downloader.g.a)localObject2).field_secondaryUrl);
            paramIntent.setFileSize(((com.tencent.mm.plugin.downloader.g.a)localObject2).field_fileSize);
            paramIntent.all(((com.tencent.mm.plugin.downloader.g.a)localObject2).field_fileName);
            paramIntent.alo(((com.tencent.mm.plugin.downloader.g.a)localObject2).field_notificationTitle);
            paramIntent.setAppId(((com.tencent.mm.plugin.downloader.g.a)localObject2).field_appId);
            paramIntent.setFileMD5(((com.tencent.mm.plugin.downloader.g.a)localObject2).field_md5);
            paramIntent.setScene(((com.tencent.mm.plugin.downloader.g.a)localObject2).field_scene);
            paramIntent.Rv(((com.tencent.mm.plugin.downloader.g.a)localObject2).field_extInfo);
            paramIntent.qIY.qIL = true;
            paramIntent.kS(true);
            paramIntent.Fl(1);
            paramIntent.gm(((com.tencent.mm.plugin.downloader.g.a)localObject2).field_packageName);
            paramIntent.qIY.qIN = true;
            if (((com.tencent.mm.plugin.downloader.g.a)localObject2).field_sectionMd5Byte != null) {
              localObject3 = new q();
            }
          }
        }
        try
        {
          label1046:
          ((q)localObject3).parseFrom(((com.tencent.mm.plugin.downloader.g.a)localObject2).field_sectionMd5Byte);
          paramIntent.V(((q)localObject3).qGz);
          label1202:
          if (((com.tencent.mm.plugin.downloader.g.a)localObject2).field_downloaderType != 3)
          {
            l1 = f.cBv().a(paramIntent.qIY);
            h.CyF.idkeyStat(710L, 8L, 1L, false);
          }
          for (;;)
          {
            Log.i("MicroMsg.FileDownloadService", "MD5 check failed, restart download, id = ".concat(String.valueOf(l1)));
            com.tencent.mm.plugin.downloader.f.a.a(110, (com.tencent.mm.plugin.downloader.f.b)localObject1);
            com.tencent.mm.plugin.downloader.f.a.aa(((com.tencent.mm.plugin.downloader.g.a)localObject2).field_appId, 30L);
            AppMethodBeat.o(89008);
            return;
            h.CyF.idkeyStat(710L, 9L, 1L, false);
            break;
            if (((com.tencent.mm.plugin.downloader.g.a)localObject2).field_downloadUrl.startsWith("https"))
            {
              h.CyF.idkeyStat(710L, 7L, 1L, false);
              break;
            }
            h.CyF.idkeyStat(710L, 6L, 1L, false);
            break;
            label1340:
            bool2 = false;
            break label981;
            label1346:
            i = 0;
            break label1046;
            l1 = f.cBv().b(paramIntent.qIY);
            h.CyF.idkeyStat(710L, 11L, 1L, false);
          }
          label1379:
          paramIntent = f.cBv();
          localObject1 = d.Cw(l2);
          if (localObject1 != null)
          {
            localObject2 = MMApplicationContext.getContext();
            if ((!((com.tencent.mm.plugin.downloader.g.a)localObject1).field_showNotification) || (Util.isNullOrNil(((com.tencent.mm.plugin.downloader.g.a)localObject1).field_notificationTitle))) {
              break label1461;
            }
            f.a(((com.tencent.mm.plugin.downloader.g.a)localObject1).field_appId, ((com.tencent.mm.plugin.downloader.g.a)localObject1).field_notificationTitle, ((Context)localObject2).getString(2131759381), null);
          }
          for (;;)
          {
            paramIntent.qIy.c(l2, com.tencent.mm.plugin.downloader.a.a.qFs, bool1);
            AppMethodBeat.o(89008);
            return;
            label1461:
            if ((((com.tencent.mm.plugin.downloader.g.a)localObject1).field_showNotification) && (Util.isNullOrNil(((com.tencent.mm.plugin.downloader.g.a)localObject1).field_fileName))) {
              f.a(((com.tencent.mm.plugin.downloader.g.a)localObject1).field_appId, ((Context)localObject2).getString(2131759381), "", null);
            } else if ((((com.tencent.mm.plugin.downloader.g.a)localObject1).field_showNotification) && (!Util.isNullOrNil(((com.tencent.mm.plugin.downloader.g.a)localObject1).field_fileName))) {
              f.a(((com.tencent.mm.plugin.downloader.g.a)localObject1).field_appId, ((com.tencent.mm.plugin.downloader.g.a)localObject1).field_fileName, ((Context)localObject2).getString(2131759381), null);
            }
          }
          localObject1 = paramIntent.getStringExtra(qJb);
          l1 = paramIntent.getLongExtra("downloadId", -1L);
          if ((Util.isNullOrNil((String)localObject1)) || (!s.YS((String)localObject1)))
          {
            Log.i("MicroMsg.FileDownloadService", "Invalid file path, ignored");
            AppMethodBeat.o(89008);
            return;
          }
          paramIntent = d.Cw(l1);
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
          break label1202;
        }
      }
      label1635:
      paramIntent = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.model.FileDownloadService
 * JD-Core Version:    0.7.0.1
 */