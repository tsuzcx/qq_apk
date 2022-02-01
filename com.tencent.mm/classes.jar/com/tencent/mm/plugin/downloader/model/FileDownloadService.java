package com.tencent.mm.plugin.downloader.model;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.c.b.q;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.service.MMIntentService;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.w;
import java.io.IOException;

public class FileDownloadService
  extends MMIntentService
{
  public static final String EXTRA_ID;
  public static final String EXTRA_PACKAGE_NAME;
  private static final String ptv;
  public static final String ptw;
  public static final String ptx;
  public static final String pty;
  public static final String ptz;
  
  static
  {
    AppMethodBeat.i(89010);
    ptv = FileDownloadService.class.getSimpleName() + "_extra_";
    EXTRA_ID = ptv + "id";
    ptw = ptv + "action_type";
    EXTRA_PACKAGE_NAME = ptv + "package_name";
    ptx = ptv + "file_path";
    pty = ptv + "md5";
    ptz = ptv + "change_url";
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
    int i = paramIntent.getIntExtra(ptw, 0);
    ae.i("MicroMsg.FileDownloadService", "handle intent type : %d", new Object[] { Integer.valueOf(i) });
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
        ae.e("MicroMsg.FileDownloadService", "Invalid id");
        AppMethodBeat.o(89008);
        return;
      }
      if (com.tencent.mm.kernel.g.ajP().aiZ())
      {
        com.tencent.mm.kernel.g.ajP();
        if (!com.tencent.mm.kernel.a.aiT()) {}
      }
      else
      {
        ae.d("MicroMsg.FileDownloadService", "no user login");
        AppMethodBeat.o(89008);
        return;
      }
      localObject2 = d.ur(l2);
      if (localObject2 != null)
      {
        if ((paramIntent.getBooleanExtra(ptz, false)) || (((com.tencent.mm.plugin.downloader.g.a)localObject2).field_isSecondDownload)) {}
        for (bool1 = true;; bool1 = false)
        {
          ae.i("MicroMsg.FileDownloadService", "filePath = " + ((com.tencent.mm.plugin.downloader.g.a)localObject2).field_filePath);
          if ((!bu.isNullOrNil(((com.tencent.mm.plugin.downloader.g.a)localObject2).field_filePath)) && (o.fB(((com.tencent.mm.plugin.downloader.g.a)localObject2).field_filePath))) {
            break;
          }
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(710L, 5L, 1L, false);
          ((com.tencent.mm.plugin.downloader.g.a)localObject2).field_status = 4;
          ((com.tencent.mm.plugin.downloader.g.a)localObject2).field_errCode = com.tencent.mm.plugin.downloader.a.a.ppR;
          d.e((com.tencent.mm.plugin.downloader.g.a)localObject2);
          paramIntent = f.cdA();
          i = com.tencent.mm.plugin.downloader.a.a.ppR;
          ae.i("MicroMsg.FileDownloadManager", "onDownloadFailed, id = %d, errCode = %d", new Object[] { Long.valueOf(l2), Integer.valueOf(i) });
          if (paramIntent.psU != null) {
            paramIntent.psU.c(l2, i, bool1);
          }
          ae.i("MicroMsg.FileDownloadService", "file not exists, appid = " + ((com.tencent.mm.plugin.downloader.g.a)localObject2).field_appId);
          AppMethodBeat.o(89008);
          return;
        }
        if (bu.isNullOrNil(((com.tencent.mm.plugin.downloader.g.a)localObject2).field_md5))
        {
          ae.i("MicroMsg.FileDownloadService", "Invalid original md5, abort checking");
          ((com.tencent.mm.plugin.downloader.g.a)localObject2).field_status = 3;
          d.e((com.tencent.mm.plugin.downloader.g.a)localObject2);
          f.cdA().o(l2, bool1);
          AppMethodBeat.o(89008);
          return;
        }
        l1 = 0L;
        if (bu.isNullOrNil(((com.tencent.mm.plugin.downloader.g.a)localObject2).field_appId)) {
          break label1582;
        }
        l1 = System.currentTimeMillis();
        try
        {
          localObject3 = new k(((com.tencent.mm.plugin.downloader.g.a)localObject2).field_filePath);
          localObject1 = w.B(((k)localObject3).fTh());
          bool2 = com.tencent.mm.plugin.downloader.d.b.aaS((String)localObject1);
          if (!bool2) {
            break label733;
          }
          paramIntent = "v2";
          ae.i("MicroMsg.Channel.GameChannelUtil", "apkPath:%s, this is %s signature", new Object[] { localObject1, paramIntent });
          localObject1 = null;
          if (bool2) {
            localObject1 = com.tencent.mm.plugin.downloader.d.b.F((k)localObject3);
          }
          paramIntent = (Intent)localObject1;
          if (localObject1 == null)
          {
            localObject1 = com.tencent.mm.plugin.downloader.d.b.E((k)localObject3);
            paramIntent = (Intent)localObject1;
            if (bool2)
            {
              paramIntent = (Intent)localObject1;
              if (localObject1 != null)
              {
                ae.i("MicroMsg.Channel.GameChannelUtil", "you are use v2 signature but use v1 channel modle, this apk will can't install in 7.0system");
                paramIntent = (Intent)localObject1;
              }
            }
          }
          ae.i("MicroMsg.Channel.GameChannelUtil", "readChannel, channelId = %s", new Object[] { paramIntent });
        }
        catch (Exception paramIntent)
        {
          for (;;)
          {
            long l3;
            ae.e("MicroMsg.FileDownloadService", "readChannelId exception : " + paramIntent.getMessage());
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
        ae.i("MicroMsg.FileDownloadService", "readChannelId, channelId:%s, cost time: %d", new Object[] { paramIntent, Long.valueOf(l3) });
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
            com.tencent.mm.plugin.downloader.f.a.ab(((com.tencent.mm.plugin.downloader.g.a)localObject2).field_appId, 21L);
            com.tencent.mm.plugin.downloader.f.a.a(108, (com.tencent.mm.plugin.downloader.f.b)localObject1);
          }
          if (!bool2)
          {
            if (!((com.tencent.mm.plugin.downloader.g.a)localObject2).field_downloadUrl.startsWith("https")) {
              break label799;
            }
            com.tencent.mm.plugin.downloader.f.a.ab(((com.tencent.mm.plugin.downloader.g.a)localObject2).field_appId, 32L);
          }
          if (!bool2) {
            break label813;
          }
          ((com.tencent.mm.plugin.downloader.g.a)localObject2).field_status = 3;
          ((com.tencent.mm.plugin.downloader.g.a)localObject2).field_channelId = paramIntent;
          d.e((com.tencent.mm.plugin.downloader.g.a)localObject2);
          d.cR(((com.tencent.mm.plugin.downloader.g.a)localObject2).field_downloadUrl, 3);
          f.cdA().o(l2, bool1);
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
            com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(710L, 10L, 1L, false);
            ((com.tencent.mm.plugin.downloader.g.a)localObject2).field_status = 4;
            ((com.tencent.mm.plugin.downloader.g.a)localObject2).field_channelId = paramIntent;
            ((com.tencent.mm.plugin.downloader.g.a)localObject2).field_errCode = com.tencent.mm.plugin.downloader.a.a.ppN;
            ((com.tencent.mm.plugin.downloader.g.a)localObject2).field_downloadedSize = o.aZR(((com.tencent.mm.plugin.downloader.g.a)localObject2).field_filePath);
            d.e((com.tencent.mm.plugin.downloader.g.a)localObject2);
            ae.i("MicroMsg.FileDownloadService", "ChannelId = %s, receivedSize = %d, fileSize = %d", new Object[] { paramIntent, Long.valueOf(((com.tencent.mm.plugin.downloader.g.a)localObject2).field_downloadedSize), Long.valueOf(o.aZR(((com.tencent.mm.plugin.downloader.g.a)localObject2).field_filePath)) });
            ae.i("MicroMsg.FileDownloadService", "delete file: %s", new Object[] { ((com.tencent.mm.plugin.downloader.g.a)localObject2).field_filePath });
            o.deleteFile(((com.tencent.mm.plugin.downloader.g.a)localObject2).field_filePath);
            boolean bool3 = az.isWifi(ak.getContext());
            if (bu.isNullOrNil(((com.tencent.mm.plugin.downloader.g.a)localObject2).field_secondaryUrl)) {
              break label1331;
            }
            bool2 = true;
            label981:
            ae.i("MicroMsg.FileDownloadService", "checkMd5, isWifi: %b, hasChangeUrl: %b, hasHttpsUrl: %b", new Object[] { Boolean.valueOf(bool3), Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
            paramIntent = ((com.tencent.mm.plugin.downloader.g.a)localObject2).field_secondaryUrl;
            if ((!az.isWifi(ak.getContext())) || (bool1) || (bu.isNullOrNil(paramIntent))) {
              break label1337;
            }
            i = 1;
            if (i == 0) {
              break label1370;
            }
            paramIntent = new g.a();
            paramIntent.abb(((com.tencent.mm.plugin.downloader.g.a)localObject2).field_secondaryUrl);
            paramIntent.uz(((com.tencent.mm.plugin.downloader.g.a)localObject2).field_fileSize);
            paramIntent.abd(((com.tencent.mm.plugin.downloader.g.a)localObject2).field_fileName);
            paramIntent.setAppId(((com.tencent.mm.plugin.downloader.g.a)localObject2).field_appId);
            paramIntent.abe(((com.tencent.mm.plugin.downloader.g.a)localObject2).field_md5);
            paramIntent.setScene(((com.tencent.mm.plugin.downloader.g.a)localObject2).field_scene);
            paramIntent.abf(((com.tencent.mm.plugin.downloader.g.a)localObject2).field_extInfo);
            paramIntent.ptu.pth = true;
            paramIntent.jP(true);
            paramIntent.BB(1);
            paramIntent.fz(((com.tencent.mm.plugin.downloader.g.a)localObject2).field_packageName);
            paramIntent.ptu.ptj = true;
            if (((com.tencent.mm.plugin.downloader.g.a)localObject2).field_sectionMd5Byte != null) {
              localObject3 = new q();
            }
          }
        }
        try
        {
          label1046:
          ((q)localObject3).parseFrom(((com.tencent.mm.plugin.downloader.g.a)localObject2).field_sectionMd5Byte);
          paramIntent.T(((q)localObject3).pqU);
          label1193:
          if (((com.tencent.mm.plugin.downloader.g.a)localObject2).field_downloaderType != 3)
          {
            l1 = f.cdA().a(paramIntent.ptu);
            com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(710L, 8L, 1L, false);
          }
          for (;;)
          {
            ae.i("MicroMsg.FileDownloadService", "MD5 check failed, restart download, id = ".concat(String.valueOf(l1)));
            com.tencent.mm.plugin.downloader.f.a.a(110, (com.tencent.mm.plugin.downloader.f.b)localObject1);
            com.tencent.mm.plugin.downloader.f.a.ab(((com.tencent.mm.plugin.downloader.g.a)localObject2).field_appId, 30L);
            AppMethodBeat.o(89008);
            return;
            com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(710L, 9L, 1L, false);
            break;
            if (((com.tencent.mm.plugin.downloader.g.a)localObject2).field_downloadUrl.startsWith("https"))
            {
              com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(710L, 7L, 1L, false);
              break;
            }
            com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(710L, 6L, 1L, false);
            break;
            label1331:
            bool2 = false;
            break label981;
            label1337:
            i = 0;
            break label1046;
            l1 = f.cdA().b(paramIntent.ptu);
            com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(710L, 11L, 1L, false);
          }
          label1370:
          paramIntent = f.cdA();
          localObject1 = d.ur(l2);
          if (localObject1 != null)
          {
            localObject2 = ak.getContext();
            if ((!((com.tencent.mm.plugin.downloader.g.a)localObject1).field_showNotification) || (!bu.isNullOrNil(((com.tencent.mm.plugin.downloader.g.a)localObject1).field_fileName))) {
              break label1450;
            }
            f.a(((com.tencent.mm.plugin.downloader.g.a)localObject1).field_appId, ((Context)localObject2).getString(2131759053), "", null);
          }
          for (;;)
          {
            paramIntent.psU.c(l2, com.tencent.mm.plugin.downloader.a.a.ppN, bool1);
            AppMethodBeat.o(89008);
            return;
            label1450:
            if ((((com.tencent.mm.plugin.downloader.g.a)localObject1).field_showNotification) && (!bu.isNullOrNil(((com.tencent.mm.plugin.downloader.g.a)localObject1).field_fileName))) {
              f.a(((com.tencent.mm.plugin.downloader.g.a)localObject1).field_appId, ((com.tencent.mm.plugin.downloader.g.a)localObject1).field_fileName, ((Context)localObject2).getString(2131759053), null);
            }
          }
          localObject1 = paramIntent.getStringExtra(ptx);
          l1 = paramIntent.getLongExtra("downloadId", -1L);
          if ((bu.isNullOrNil((String)localObject1)) || (!o.fB((String)localObject1)))
          {
            ae.i("MicroMsg.FileDownloadService", "Invalid file path, ignored");
            AppMethodBeat.o(89008);
            return;
          }
          paramIntent = d.ur(l1);
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
          break label1193;
        }
      }
      label1582:
      paramIntent = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.model.FileDownloadService
 * JD-Core Version:    0.7.0.1
 */