package com.tencent.mm.plugin.downloader_app.a;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.s.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ax;
import com.tencent.mm.plugin.downloader.model.FileDownloadPendingReceive;
import com.tencent.mm.plugin.downloader.model.FileDownloadService;
import com.tencent.mm.plugin.downloader_app.ui.DownloadMainUI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Map;

public final class b
{
  private static Object lock;
  private static Map<String, Long> qKB;
  private static Map<String, Integer> qKC;
  
  static
  {
    AppMethodBeat.i(8839);
    qKB = new HashMap();
    qKC = new HashMap();
    lock = new Object();
    AppMethodBeat.o(8839);
  }
  
  private static PendingIntent alr(String paramString)
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
  
  private static void cancelNotification(String paramString)
  {
    AppMethodBeat.i(8837);
    synchronized (lock)
    {
      Integer localInteger = (Integer)qKC.get(paramString);
      if (localInteger == null)
      {
        Log.i("MicroMsg.DownloadNotificationManager", "No notification id found");
        AppMethodBeat.o(8837);
        return;
      }
      ((com.tencent.mm.plugin.notification.b.a)g.ah(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancel(localInteger.intValue());
      Log.i("MicroMsg.DownloadNotificationManager", "cancelNotification, id = ".concat(String.valueOf(localInteger)));
      qKC.remove(paramString);
      qKB.remove(paramString);
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
      Object localObject3 = com.tencent.mm.bq.a.cd(MMApplicationContext.getContext(), "reminder_channel_id");
      Object localObject2 = (Long)qKB.get(parama.field_downloadUrl);
      ??? = localObject2;
      if (localObject2 == null)
      {
        ??? = Long.valueOf(System.currentTimeMillis());
        qKB.put(parama.field_downloadUrl, ???);
      }
      ((s.c)localObject3).i(((Long)???).longValue());
      if (!Util.isNullOrNil(parama.field_notificationTitle)) {
        ((s.c)localObject3).f(parama.field_notificationTitle);
      }
      for (;;)
      {
        switch (parama.field_status)
        {
        default: 
          cancelNotification(parama.field_downloadUrl);
          AppMethodBeat.o(8836);
          return;
          ((s.c)localObject3).f(parama.field_fileName);
        }
      }
      ((s.c)localObject3).as(com.tencent.mm.bq.a.ezb());
      int j = i;
      if (i == 0) {
        j = 1;
      }
      if (j == 0) {
        bool = true;
      }
      ((s.c)localObject3).b(100, j, bool);
      if (parama.field_reserveInWifi) {
        ((s.c)localObject3).g(MMApplicationContext.getContext().getString(2131759382) + "·" + MMApplicationContext.getContext().getString(2131759380));
      }
      for (;;)
      {
        ((s.c)localObject3).g(2, true);
        ((s.c)localObject3).Hv = alr(parama.field_appId);
        synchronized (lock)
        {
          localObject2 = (Integer)qKC.get(parama.field_downloadUrl);
          if (localObject2 == null)
          {
            i = ((com.tencent.mm.plugin.notification.b.a)g.ah(com.tencent.mm.plugin.notification.b.a.class)).getNotification().c(((s.c)localObject3).build());
            qKC.put(parama.field_downloadUrl, Integer.valueOf(i));
            if (parama.field_status == 4)
            {
              qKC.remove(parama.field_downloadUrl);
              qKB.remove(parama.field_downloadUrl);
            }
            AppMethodBeat.o(8836);
            return;
            ((s.c)localObject3).g(MMApplicationContext.getContext().getString(2131759380));
            continue;
            ((s.c)localObject3).as(com.tencent.mm.bq.a.ezb());
            ((s.c)localObject3).E(true);
            ((s.c)localObject3).Hv = alr(parama.field_appId);
            if ((parama.field_errCode == com.tencent.mm.plugin.downloader.a.a.qFw) || (parama.field_errCode == com.tencent.mm.plugin.downloader.a.a.qFs)) {
              ((s.c)localObject3).g(MMApplicationContext.getContext().getString(2131763646));
            }
            for (;;)
            {
              ((s.c)localObject3).Hv = alr(parama.field_appId);
              break;
              if (com.tencent.mm.plugin.downloader.model.a.Cl(parama.field_downloadId))
              {
                if (com.tinkerboots.sdk.b.a.isWifi(MMApplicationContext.getContext())) {
                  ((s.c)localObject3).g(MMApplicationContext.getContext().getString(2131763644));
                } else {
                  ((s.c)localObject3).g(MMApplicationContext.getContext().getString(2131763645));
                }
              }
              else {
                ((s.c)localObject3).g(MMApplicationContext.getContext().getString(2131763643));
              }
            }
            cancelNotification(parama.field_downloadUrl);
            AppMethodBeat.o(8836);
            return;
            cancelNotification(parama.field_downloadUrl);
            AppMethodBeat.o(8836);
            return;
            cancelNotification(parama.field_downloadUrl);
            ??? = MMApplicationContext.getContext();
            localObject2 = com.tencent.mm.bq.a.cd((Context)???, "reminder_channel_id");
            if (!Util.isNullOrNil(parama.field_notificationTitle))
            {
              ((s.c)localObject2).f(parama.field_notificationTitle);
              ((s.c)localObject2).as(com.tencent.mm.bq.a.ezb());
              ((s.c)localObject2).E(true);
              localObject3 = new Intent();
              Context localContext = MMApplicationContext.getContext();
              ((Intent)localObject3).setClass(localContext, FileDownloadPendingReceive.class);
              ((Intent)localObject3).putExtra(FileDownloadService.qJa, 3);
              ((Intent)localObject3).putExtra(FileDownloadService.qJb, parama.field_filePath);
              ((Intent)localObject3).putExtra(FileDownloadService.qJc, parama.field_md5);
              ((Intent)localObject3).putExtra("downloadId", parama.field_downloadId);
              ((s.c)localObject2).Hv = PendingIntent.getBroadcast(localContext, (int)System.currentTimeMillis(), (Intent)localObject3, 0);
              if (!parama.field_reserveInWifi) {
                break label873;
              }
              ((s.c)localObject2).g(((Context)???).getString(2131758373));
            }
            for (;;)
            {
              ((com.tencent.mm.plugin.notification.b.a)g.ah(com.tencent.mm.plugin.notification.b.a.class)).getNotification().c(((s.c)localObject2).build());
              AppMethodBeat.o(8836);
              return;
              ((s.c)localObject2).f(parama.field_fileName);
              break;
              label873:
              if (parama.field_autoDownload)
              {
                if (!Util.isNullOrNil(parama.field_notificationTitle)) {
                  ((s.c)localObject2).f(parama.field_notificationTitle + " · " + MMApplicationContext.getContext().getString(2131759375));
                }
                for (;;)
                {
                  ((s.c)localObject2).g(MMApplicationContext.getContext().getString(2131759374));
                  break;
                  ((s.c)localObject2).f(parama.field_fileName + " · " + MMApplicationContext.getContext().getString(2131759375));
                }
              }
              ((s.c)localObject2).g(((Context)???).getString(2131759379));
            }
          }
          else
          {
            ((com.tencent.mm.plugin.notification.b.a)g.ah(com.tencent.mm.plugin.notification.b.a.class)).getNotification().notify(((Integer)localObject2).intValue(), ((s.c)localObject3).build());
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.a.b
 * JD-Core Version:    0.7.0.1
 */