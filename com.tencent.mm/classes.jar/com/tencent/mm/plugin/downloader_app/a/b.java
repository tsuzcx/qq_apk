package com.tencent.mm.plugin.downloader_app.a;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import androidx.core.app.f.d;
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
  private static Map<String, Long> xrZ;
  private static Map<String, Integer> xsa;
  
  static
  {
    AppMethodBeat.i(8839);
    xrZ = new HashMap();
    xsa = new HashMap();
    lock = new Object();
    AppMethodBeat.o(8839);
  }
  
  private static PendingIntent amZ(String paramString)
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
  
  private static void iH(String paramString)
  {
    AppMethodBeat.i(8837);
    synchronized (lock)
    {
      Integer localInteger = (Integer)xsa.get(paramString);
      if (localInteger == null)
      {
        Log.i("MicroMsg.DownloadNotificationManager", "No notification id found");
        AppMethodBeat.o(8837);
        return;
      }
      ((com.tencent.mm.plugin.notification.b.b)h.az(com.tencent.mm.plugin.notification.b.b.class)).getNotification().cancel(localInteger.intValue());
      Log.i("MicroMsg.DownloadNotificationManager", "cancelNotification, id = ".concat(String.valueOf(localInteger)));
      xsa.remove(paramString);
      xrZ.remove(paramString);
      AppMethodBeat.o(8837);
      return;
    }
  }
  
  public static void l(com.tencent.mm.plugin.downloader.f.a parama)
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
      Object localObject3 = com.tencent.mm.bq.a.cA(MMApplicationContext.getContext(), "reminder_channel_id");
      Object localObject2 = (Long)xrZ.get(parama.field_downloadUrl);
      ??? = localObject2;
      if (localObject2 == null)
      {
        ??? = Long.valueOf(System.currentTimeMillis());
        xrZ.put(parama.field_downloadUrl, ???);
      }
      ((f.d)localObject3).bt(((Long)???).longValue());
      if (!Util.isNullOrNil(parama.field_notificationTitle)) {
        ((f.d)localObject3).l(parama.field_notificationTitle);
      }
      for (;;)
      {
        switch (parama.field_status)
        {
        default: 
          iH(parama.field_downloadUrl);
          AppMethodBeat.o(8836);
          return;
          ((f.d)localObject3).l(parama.field_fileName);
        }
      }
      ((f.d)localObject3).eb(com.tencent.mm.bq.a.guX());
      int j = i;
      if (i == 0) {
        j = 1;
      }
      if (j == 0) {
        bool = true;
      }
      ((f.d)localObject3).d(100, j, bool);
      if (parama.field_reserveInWifi) {
        ((f.d)localObject3).m(MMApplicationContext.getContext().getString(e.h.file_downloader_reversed_wifi) + "·" + MMApplicationContext.getContext().getString(e.h.file_downloader_download_running));
      }
      for (;;)
      {
        ((f.d)localObject3).q(2, true);
        ((f.d)localObject3).bor = amZ(parama.field_appId);
        synchronized (lock)
        {
          localObject2 = (Integer)xsa.get(parama.field_downloadUrl);
          if (localObject2 == null)
          {
            i = ((com.tencent.mm.plugin.notification.b.b)h.az(com.tencent.mm.plugin.notification.b.b.class)).getNotification().d(((f.d)localObject3).DA());
            xsa.put(parama.field_downloadUrl, Integer.valueOf(i));
            if (parama.field_status == 4)
            {
              xsa.remove(parama.field_downloadUrl);
              xrZ.remove(parama.field_downloadUrl);
            }
            AppMethodBeat.o(8836);
            return;
            ((f.d)localObject3).m(MMApplicationContext.getContext().getString(e.h.file_downloader_download_running));
            continue;
            ((f.d)localObject3).eb(com.tencent.mm.bq.a.guX());
            ((f.d)localObject3).aC(true);
            ((f.d)localObject3).bor = amZ(parama.field_appId);
            if ((parama.field_errCode == com.tencent.mm.plugin.downloader.a.a.xkA) || (parama.field_errCode == com.tencent.mm.plugin.downloader.a.a.xkw)) {
              ((f.d)localObject3).m(MMApplicationContext.getContext().getString(e.h.xrz));
            }
            for (;;)
            {
              ((f.d)localObject3).bor = amZ(parama.field_appId);
              break;
              if (com.tencent.mm.plugin.downloader.model.a.kP(parama.field_downloadId))
              {
                if (com.tinkerboots.sdk.b.a.isWifi(MMApplicationContext.getContext())) {
                  ((f.d)localObject3).m(MMApplicationContext.getContext().getString(e.h.xrx));
                } else {
                  ((f.d)localObject3).m(MMApplicationContext.getContext().getString(e.h.xry));
                }
              }
              else {
                ((f.d)localObject3).m(MMApplicationContext.getContext().getString(e.h.xrw));
              }
            }
            iH(parama.field_downloadUrl);
            AppMethodBeat.o(8836);
            return;
            iH(parama.field_downloadUrl);
            AppMethodBeat.o(8836);
            return;
            iH(parama.field_downloadUrl);
            ??? = MMApplicationContext.getContext();
            localObject2 = com.tencent.mm.bq.a.cA((Context)???, "reminder_channel_id");
            if (!Util.isNullOrNil(parama.field_notificationTitle))
            {
              ((f.d)localObject2).l(parama.field_notificationTitle);
              ((f.d)localObject2).eb(com.tencent.mm.bq.a.guX());
              ((f.d)localObject2).aC(true);
              localObject3 = new Intent();
              Context localContext = MMApplicationContext.getContext();
              ((Intent)localObject3).setClass(localContext, FileDownloadPendingReceive.class);
              ((Intent)localObject3).putExtra(FileDownloadService.xoh, 3);
              ((Intent)localObject3).putExtra(FileDownloadService.xoj, parama.field_filePath);
              ((Intent)localObject3).putExtra(FileDownloadService.xok, parama.field_md5);
              ((Intent)localObject3).putExtra("downloadId", parama.field_downloadId);
              ((f.d)localObject2).bor = PendingIntent.getBroadcast(localContext, (int)System.currentTimeMillis(), (Intent)localObject3, 0);
              if (!parama.field_reserveInWifi) {
                break label876;
              }
              ((f.d)localObject2).m(((Context)???).getString(e.h.xrc));
            }
            for (;;)
            {
              ((com.tencent.mm.plugin.notification.b.b)h.az(com.tencent.mm.plugin.notification.b.b.class)).getNotification().d(((f.d)localObject2).DA());
              AppMethodBeat.o(8836);
              return;
              ((f.d)localObject2).l(parama.field_fileName);
              break;
              label876:
              if (parama.field_autoDownload)
              {
                if (!Util.isNullOrNil(parama.field_notificationTitle)) {
                  ((f.d)localObject2).l(parama.field_notificationTitle + " · " + MMApplicationContext.getContext().getString(e.h.file_downloader_book_download));
                }
                for (;;)
                {
                  ((f.d)localObject2).m(MMApplicationContext.getContext().getString(e.h.file_download_finished_click_install));
                  break;
                  ((f.d)localObject2).l(parama.field_fileName + " · " + MMApplicationContext.getContext().getString(e.h.file_downloader_book_download));
                }
              }
              ((f.d)localObject2).m(((Context)???).getString(e.h.file_downloader_download_finished));
            }
          }
          else
          {
            ((com.tencent.mm.plugin.notification.b.b)h.az(com.tencent.mm.plugin.notification.b.b.class)).getNotification().c(((Integer)localObject2).intValue(), ((f.d)localObject3).DA());
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