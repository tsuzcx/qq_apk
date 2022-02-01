package com.tencent.mm.plugin.downloader_app.a;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import androidx.core.app.e.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ay;
import com.tencent.mm.plugin.downloader.model.FileDownloadPendingReceive;
import com.tencent.mm.plugin.downloader.model.FileDownloadService;
import com.tencent.mm.plugin.downloader_app.e.h;
import com.tencent.mm.plugin.downloader_app.ui.DownloadMainUI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Map;

public final class b
{
  private static Object lock;
  private static Map<String, Long> ulN;
  private static Map<String, Integer> ulO;
  
  static
  {
    AppMethodBeat.i(8839);
    ulN = new HashMap();
    ulO = new HashMap();
    lock = new Object();
    AppMethodBeat.o(8839);
  }
  
  private static PendingIntent atk(String paramString)
  {
    AppMethodBeat.i(8838);
    Intent localIntent = new Intent(MMApplicationContext.getContext(), DownloadMainUI.class);
    localIntent.putExtra("appId", paramString);
    localIntent.putExtra("view_task", true);
    localIntent.putExtra("from_scene", 1);
    paramString = PendingIntent.getActivity(MMApplicationContext.getContext(), (int)System.currentTimeMillis(), localIntent, 0);
    AppMethodBeat.o(8838);
    return paramString;
  }
  
  private static void hg(String paramString)
  {
    AppMethodBeat.i(8837);
    synchronized (lock)
    {
      Integer localInteger = (Integer)ulO.get(paramString);
      if (localInteger == null)
      {
        Log.i("MicroMsg.DownloadNotificationManager", "No notification id found");
        AppMethodBeat.o(8837);
        return;
      }
      ((com.tencent.mm.plugin.notification.b.a)h.ag(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancel(localInteger.intValue());
      Log.i("MicroMsg.DownloadNotificationManager", "cancelNotification, id = ".concat(String.valueOf(localInteger)));
      ulO.remove(paramString);
      ulN.remove(paramString);
      AppMethodBeat.o(8837);
      return;
    }
  }
  
  public static void l(com.tencent.mm.plugin.downloader.g.a parama)
  {
    boolean bool = false;
    AppMethodBeat.i(8836);
    if (parama == null)
    {
      Log.e("MicroMsg.DownloadNotificationManager", "updateNotification failed: null task info");
      AppMethodBeat.o(8836);
      return;
    }
    if (!parama.field_fromDownloadApp)
    {
      Log.i("MicroMsg.DownloadNotificationManager", "updateNotification not from download app");
      AppMethodBeat.o(8836);
      return;
    }
    if ((parama.field_autoDownload) && (parama.field_status != 3))
    {
      AppMethodBeat.o(8836);
      return;
    }
    if (parama.field_totalSize > 0L) {}
    for (int i = (int)(parama.field_downloadedSize * 100L / parama.field_totalSize);; i = 0)
    {
      Object localObject3 = com.tencent.mm.bx.a.cp(MMApplicationContext.getContext(), "reminder_channel_id");
      Object localObject2 = (Long)ulN.get(parama.field_downloadUrl);
      ??? = localObject2;
      if (localObject2 == null)
      {
        ??? = Long.valueOf(System.currentTimeMillis());
        ulN.put(parama.field_downloadUrl, ???);
      }
      ((e.d)localObject3).e(((Long)???).longValue());
      if (!Util.isNullOrNil(parama.field_notificationTitle)) {
        ((e.d)localObject3).k(parama.field_notificationTitle);
      }
      for (;;)
      {
        switch (parama.field_status)
        {
        default: 
          hg(parama.field_downloadUrl);
          AppMethodBeat.o(8836);
          return;
          ((e.d)localObject3).k(parama.field_fileName);
        }
      }
      ((e.d)localObject3).bn(com.tencent.mm.bx.a.fkG());
      int j = i;
      if (i == 0) {
        j = 1;
      }
      if (j == 0) {
        bool = true;
      }
      ((e.d)localObject3).b(100, j, bool);
      if (parama.field_reserveInWifi) {
        ((e.d)localObject3).l(MMApplicationContext.getContext().getString(e.h.file_downloader_reversed_wifi) + "·" + MMApplicationContext.getContext().getString(e.h.file_downloader_download_running));
      }
      for (;;)
      {
        ((e.d)localObject3).e(2, true);
        ((e.d)localObject3).Ip = atk(parama.field_appId);
        synchronized (lock)
        {
          localObject2 = (Integer)ulO.get(parama.field_downloadUrl);
          if (localObject2 == null)
          {
            i = ((com.tencent.mm.plugin.notification.b.a)h.ag(com.tencent.mm.plugin.notification.b.a.class)).getNotification().c(((e.d)localObject3).gr());
            ulO.put(parama.field_downloadUrl, Integer.valueOf(i));
            if (parama.field_status == 4)
            {
              ulO.remove(parama.field_downloadUrl);
              ulN.remove(parama.field_downloadUrl);
            }
            AppMethodBeat.o(8836);
            return;
            ((e.d)localObject3).l(MMApplicationContext.getContext().getString(e.h.file_downloader_download_running));
            continue;
            ((e.d)localObject3).bn(com.tencent.mm.bx.a.fkG());
            ((e.d)localObject3).W(true);
            ((e.d)localObject3).Ip = atk(parama.field_appId);
            if ((parama.field_errCode == com.tencent.mm.plugin.downloader.a.a.uey) || (parama.field_errCode == com.tencent.mm.plugin.downloader.a.a.ueu)) {
              ((e.d)localObject3).l(MMApplicationContext.getContext().getString(e.h.uln));
            }
            for (;;)
            {
              ((e.d)localObject3).Ip = atk(parama.field_appId);
              break;
              if (com.tencent.mm.plugin.downloader.model.a.Iu(parama.field_downloadId))
              {
                if (com.tinkerboots.sdk.b.a.isWifi(MMApplicationContext.getContext())) {
                  ((e.d)localObject3).l(MMApplicationContext.getContext().getString(e.h.ull));
                } else {
                  ((e.d)localObject3).l(MMApplicationContext.getContext().getString(e.h.ulm));
                }
              }
              else {
                ((e.d)localObject3).l(MMApplicationContext.getContext().getString(e.h.ulk));
              }
            }
            hg(parama.field_downloadUrl);
            AppMethodBeat.o(8836);
            return;
            hg(parama.field_downloadUrl);
            AppMethodBeat.o(8836);
            return;
            hg(parama.field_downloadUrl);
            ??? = MMApplicationContext.getContext();
            localObject2 = com.tencent.mm.bx.a.cp((Context)???, "reminder_channel_id");
            if (!Util.isNullOrNil(parama.field_notificationTitle))
            {
              ((e.d)localObject2).k(parama.field_notificationTitle);
              ((e.d)localObject2).bn(com.tencent.mm.bx.a.fkG());
              ((e.d)localObject2).W(true);
              localObject3 = new Intent();
              Context localContext = MMApplicationContext.getContext();
              ((Intent)localObject3).setClass(localContext, FileDownloadPendingReceive.class);
              ((Intent)localObject3).putExtra(FileDownloadService.uib, 3);
              ((Intent)localObject3).putExtra(FileDownloadService.uie, parama.field_filePath);
              ((Intent)localObject3).putExtra(FileDownloadService.uif, parama.field_md5);
              ((Intent)localObject3).putExtra("downloadId", parama.field_downloadId);
              ((e.d)localObject2).Ip = PendingIntent.getBroadcast(localContext, (int)System.currentTimeMillis(), (Intent)localObject3, 0);
              if (!parama.field_reserveInWifi) {
                break label876;
              }
              ((e.d)localObject2).l(((Context)???).getString(e.h.ukQ));
            }
            for (;;)
            {
              ((com.tencent.mm.plugin.notification.b.a)h.ag(com.tencent.mm.plugin.notification.b.a.class)).getNotification().c(((e.d)localObject2).gr());
              AppMethodBeat.o(8836);
              return;
              ((e.d)localObject2).k(parama.field_fileName);
              break;
              label876:
              if (parama.field_autoDownload)
              {
                if (!Util.isNullOrNil(parama.field_notificationTitle)) {
                  ((e.d)localObject2).k(parama.field_notificationTitle + " · " + MMApplicationContext.getContext().getString(e.h.file_downloader_book_download));
                }
                for (;;)
                {
                  ((e.d)localObject2).l(MMApplicationContext.getContext().getString(e.h.file_download_finished_click_install));
                  break;
                  ((e.d)localObject2).k(parama.field_fileName + " · " + MMApplicationContext.getContext().getString(e.h.file_downloader_book_download));
                }
              }
              ((e.d)localObject2).l(((Context)???).getString(e.h.file_downloader_download_finished));
            }
          }
          else
          {
            ((com.tencent.mm.plugin.notification.b.a)h.ag(com.tencent.mm.plugin.notification.b.a.class)).getNotification().c(((Integer)localObject2).intValue(), ((e.d)localObject3).gr());
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.a.b
 * JD-Core Version:    0.7.0.1
 */