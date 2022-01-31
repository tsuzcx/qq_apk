package com.tencent.mm.plugin.downloader_app.b;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.s.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.an;
import com.tencent.mm.plugin.downloader.model.FileDownloadPendingReceive;
import com.tencent.mm.plugin.downloader.model.FileDownloadService;
import com.tencent.mm.plugin.downloader_app.ui.DownloadMainUI;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.HashMap;
import java.util.Map;

public final class b
{
  private static Map<String, Long> laE;
  private static Map<String, Integer> laF;
  private static Object lock;
  
  static
  {
    AppMethodBeat.i(136084);
    laE = new HashMap();
    laF = new HashMap();
    lock = new Object();
    AppMethodBeat.o(136084);
  }
  
  private static PendingIntent JT(String paramString)
  {
    AppMethodBeat.i(136083);
    Intent localIntent = new Intent(ah.getContext(), DownloadMainUI.class);
    localIntent.putExtra("appId", paramString);
    localIntent.putExtra("view_task", true);
    paramString = PendingIntent.getActivity(ah.getContext(), (int)System.currentTimeMillis(), localIntent, 0);
    AppMethodBeat.o(136083);
    return paramString;
  }
  
  private static void cancelNotification(String paramString)
  {
    AppMethodBeat.i(136082);
    synchronized (lock)
    {
      Integer localInteger = (Integer)laF.get(paramString);
      if (localInteger == null)
      {
        ab.i("MicroMsg.DownloadNotificationManager", "No notification id found");
        AppMethodBeat.o(136082);
        return;
      }
      ((com.tencent.mm.plugin.notification.b.a)g.G(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancel(localInteger.intValue());
      ab.i("MicroMsg.DownloadNotificationManager", "cancelNotification, id = ".concat(String.valueOf(localInteger)));
      laF.remove(paramString);
      laE.remove(paramString);
      AppMethodBeat.o(136082);
      return;
    }
  }
  
  public static void j(com.tencent.mm.plugin.downloader.g.a parama)
  {
    boolean bool = false;
    AppMethodBeat.i(136081);
    if (parama == null)
    {
      ab.e("MicroMsg.DownloadNotificationManager", "updateNotification failed: null task info");
      AppMethodBeat.o(136081);
      return;
    }
    if (!parama.field_fromDownloadApp)
    {
      ab.i("MicroMsg.DownloadNotificationManager", "updateNotification not from download app");
      AppMethodBeat.o(136081);
      return;
    }
    if (parama.field_totalSize > 0L) {}
    for (int i = (int)(parama.field_downloadedSize * 100L / parama.field_totalSize);; i = 0)
    {
      Object localObject3 = com.tencent.mm.bp.a.br(ah.getContext(), "reminder_channel_id");
      Object localObject2 = (Long)laE.get(parama.field_downloadUrl);
      ??? = localObject2;
      if (localObject2 == null)
      {
        ??? = Long.valueOf(System.currentTimeMillis());
        laE.put(parama.field_downloadUrl, ???);
      }
      ((s.c)localObject3).g(((Long)???).longValue());
      ((s.c)localObject3).e(parama.field_fileName);
      switch (parama.field_status)
      {
      default: 
        cancelNotification(parama.field_downloadUrl);
        AppMethodBeat.o(136081);
        return;
      case 1: 
        ((s.c)localObject3).Y(com.tencent.mm.bp.a.bYt());
        int j = i;
        if (i == 0) {
          j = 1;
        }
        if (j == 0) {
          bool = true;
        }
        ((s.c)localObject3).b(100, j, bool);
        if (parama.field_reserveInWifi) {
          ((s.c)localObject3).f(ah.getContext().getString(2131299873) + "·" + ah.getContext().getString(2131299871));
        }
        break;
      }
      for (;;)
      {
        ((s.c)localObject3).g(2, true);
        ((s.c)localObject3).ya = JT(parama.field_appId);
        synchronized (lock)
        {
          localObject2 = (Integer)laF.get(parama.field_downloadUrl);
          if (localObject2 == null)
          {
            i = ((com.tencent.mm.plugin.notification.b.a)g.G(com.tencent.mm.plugin.notification.b.a.class)).getNotification().c(((s.c)localObject3).build());
            laF.put(parama.field_downloadUrl, Integer.valueOf(i));
            if (parama.field_status == 4)
            {
              laF.remove(parama.field_downloadUrl);
              laE.remove(parama.field_downloadUrl);
            }
            AppMethodBeat.o(136081);
            return;
            ((s.c)localObject3).f(ah.getContext().getString(2131299871));
            continue;
            ((s.c)localObject3).Y(com.tencent.mm.bp.a.bYt());
            ((s.c)localObject3).z(true);
            ((s.c)localObject3).ya = JT(parama.field_appId);
            if ((parama.field_errCode == com.tencent.mm.plugin.downloader.a.a.kVz) || (parama.field_errCode == com.tencent.mm.plugin.downloader.a.a.kVv)) {
              ((s.c)localObject3).f(ah.getContext().getString(2131301916));
            }
            for (;;)
            {
              ((s.c)localObject3).ya = JT(parama.field_appId);
              break;
              if (com.tencent.mm.plugin.downloader.model.a.ix(parama.field_downloadId))
              {
                if (com.tinkerboots.sdk.b.a.isWifi(ah.getContext())) {
                  ((s.c)localObject3).f(ah.getContext().getString(2131301914));
                } else {
                  ((s.c)localObject3).f(ah.getContext().getString(2131301915));
                }
              }
              else {
                ((s.c)localObject3).f(ah.getContext().getString(2131301913));
              }
            }
            cancelNotification(parama.field_downloadUrl);
            AppMethodBeat.o(136081);
            return;
            cancelNotification(parama.field_downloadUrl);
            AppMethodBeat.o(136081);
            return;
            cancelNotification(parama.field_downloadUrl);
            ??? = ah.getContext();
            localObject2 = com.tencent.mm.bp.a.br((Context)???, "reminder_channel_id");
            ((s.c)localObject2).e(parama.field_fileName);
            ((s.c)localObject2).Y(com.tencent.mm.bp.a.bYt());
            ((s.c)localObject2).z(true);
            localObject3 = new Intent();
            Context localContext = ah.getContext();
            ((Intent)localObject3).setClass(localContext, FileDownloadPendingReceive.class);
            ((Intent)localObject3).putExtra(FileDownloadService.kYT, 3);
            ((Intent)localObject3).putExtra(FileDownloadService.kYU, parama.field_filePath);
            ((Intent)localObject3).putExtra(FileDownloadService.kYV, parama.field_md5);
            ((Intent)localObject3).putExtra("downloadId", parama.field_downloadId);
            ((s.c)localObject2).ya = PendingIntent.getBroadcast(localContext, (int)System.currentTimeMillis(), (Intent)localObject3, 0);
            if (parama.field_reserveInWifi) {
              ((s.c)localObject2).f(((Context)???).getString(2131299006));
            }
            for (;;)
            {
              ((com.tencent.mm.plugin.notification.b.a)g.G(com.tencent.mm.plugin.notification.b.a.class)).getNotification().c(((s.c)localObject2).build());
              AppMethodBeat.o(136081);
              return;
              ((s.c)localObject2).f(((Context)???).getString(2131299870));
            }
          }
          else
          {
            ((com.tencent.mm.plugin.notification.b.a)g.G(com.tencent.mm.plugin.notification.b.a.class)).getNotification().notify(((Integer)localObject2).intValue(), ((s.c)localObject3).build());
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.b.b
 * JD-Core Version:    0.7.0.1
 */