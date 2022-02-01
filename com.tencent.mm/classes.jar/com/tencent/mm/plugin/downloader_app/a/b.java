package com.tencent.mm.plugin.downloader_app.a;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.s.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aq;
import com.tencent.mm.plugin.downloader.model.FileDownloadPendingReceive;
import com.tencent.mm.plugin.downloader.model.FileDownloadService;
import com.tencent.mm.plugin.downloader_app.ui.DownloadMainUI;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import java.util.HashMap;
import java.util.Map;

public final class b
{
  private static Object lock;
  private static Map<String, Long> oKX;
  private static Map<String, Integer> oKY;
  
  static
  {
    AppMethodBeat.i(8839);
    oKX = new HashMap();
    oKY = new HashMap();
    lock = new Object();
    AppMethodBeat.o(8839);
  }
  
  private static PendingIntent WN(String paramString)
  {
    AppMethodBeat.i(8838);
    Intent localIntent = new Intent(ai.getContext(), DownloadMainUI.class);
    localIntent.putExtra("appId", paramString);
    localIntent.putExtra("view_task", true);
    localIntent.putExtra("from_scene", 1);
    paramString = PendingIntent.getActivity(ai.getContext(), (int)System.currentTimeMillis(), localIntent, 0);
    AppMethodBeat.o(8838);
    return paramString;
  }
  
  private static void cancelNotification(String paramString)
  {
    AppMethodBeat.i(8837);
    synchronized (lock)
    {
      Integer localInteger = (Integer)oKY.get(paramString);
      if (localInteger == null)
      {
        ac.i("MicroMsg.DownloadNotificationManager", "No notification id found");
        AppMethodBeat.o(8837);
        return;
      }
      ((com.tencent.mm.plugin.notification.b.a)g.ad(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancel(localInteger.intValue());
      ac.i("MicroMsg.DownloadNotificationManager", "cancelNotification, id = ".concat(String.valueOf(localInteger)));
      oKY.remove(paramString);
      oKX.remove(paramString);
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
      ac.e("MicroMsg.DownloadNotificationManager", "updateNotification failed: null task info");
      AppMethodBeat.o(8836);
      return;
    }
    if (!parama.field_fromDownloadApp)
    {
      ac.i("MicroMsg.DownloadNotificationManager", "updateNotification not from download app");
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
      Object localObject3 = com.tencent.mm.bq.a.bE(ai.getContext(), "reminder_channel_id");
      Object localObject2 = (Long)oKX.get(parama.field_downloadUrl);
      ??? = localObject2;
      if (localObject2 == null)
      {
        ??? = Long.valueOf(System.currentTimeMillis());
        oKX.put(parama.field_downloadUrl, ???);
      }
      ((s.c)localObject3).i(((Long)???).longValue());
      ((s.c)localObject3).f(parama.field_fileName);
      switch (parama.field_status)
      {
      default: 
        cancelNotification(parama.field_downloadUrl);
        AppMethodBeat.o(8836);
        return;
      case 1: 
        ((s.c)localObject3).as(com.tencent.mm.bq.a.dlN());
        int j = i;
        if (i == 0) {
          j = 1;
        }
        if (j == 0) {
          bool = true;
        }
        ((s.c)localObject3).b(100, j, bool);
        if (parama.field_reserveInWifi) {
          ((s.c)localObject3).g(ai.getContext().getString(2131759054) + "·" + ai.getContext().getString(2131759052));
        }
        break;
      }
      for (;;)
      {
        ((s.c)localObject3).f(2, true);
        ((s.c)localObject3).Fu = WN(parama.field_appId);
        synchronized (lock)
        {
          localObject2 = (Integer)oKY.get(parama.field_downloadUrl);
          if (localObject2 == null)
          {
            i = ((com.tencent.mm.plugin.notification.b.a)g.ad(com.tencent.mm.plugin.notification.b.a.class)).getNotification().c(((s.c)localObject3).build());
            oKY.put(parama.field_downloadUrl, Integer.valueOf(i));
            if (parama.field_status == 4)
            {
              oKY.remove(parama.field_downloadUrl);
              oKX.remove(parama.field_downloadUrl);
            }
            AppMethodBeat.o(8836);
            return;
            ((s.c)localObject3).g(ai.getContext().getString(2131759052));
            continue;
            ((s.c)localObject3).as(com.tencent.mm.bq.a.dlN());
            ((s.c)localObject3).F(true);
            ((s.c)localObject3).Fu = WN(parama.field_appId);
            if ((parama.field_errCode == com.tencent.mm.plugin.downloader.a.a.oFI) || (parama.field_errCode == com.tencent.mm.plugin.downloader.a.a.oFE)) {
              ((s.c)localObject3).g(ai.getContext().getString(2131761678));
            }
            for (;;)
            {
              ((s.c)localObject3).Fu = WN(parama.field_appId);
              break;
              if (com.tencent.mm.plugin.downloader.model.a.rQ(parama.field_downloadId))
              {
                if (com.tinkerboots.sdk.b.a.isWifi(ai.getContext())) {
                  ((s.c)localObject3).g(ai.getContext().getString(2131761676));
                } else {
                  ((s.c)localObject3).g(ai.getContext().getString(2131761677));
                }
              }
              else {
                ((s.c)localObject3).g(ai.getContext().getString(2131761675));
              }
            }
            cancelNotification(parama.field_downloadUrl);
            AppMethodBeat.o(8836);
            return;
            cancelNotification(parama.field_downloadUrl);
            AppMethodBeat.o(8836);
            return;
            cancelNotification(parama.field_downloadUrl);
            ??? = ai.getContext();
            localObject2 = com.tencent.mm.bq.a.bE((Context)???, "reminder_channel_id");
            ((s.c)localObject2).f(parama.field_fileName);
            ((s.c)localObject2).as(com.tencent.mm.bq.a.dlN());
            ((s.c)localObject2).F(true);
            localObject3 = new Intent();
            Context localContext = ai.getContext();
            ((Intent)localObject3).setClass(localContext, FileDownloadPendingReceive.class);
            ((Intent)localObject3).putExtra(FileDownloadService.oJi, 3);
            ((Intent)localObject3).putExtra(FileDownloadService.oJj, parama.field_filePath);
            ((Intent)localObject3).putExtra(FileDownloadService.oJk, parama.field_md5);
            ((Intent)localObject3).putExtra("downloadId", parama.field_downloadId);
            ((s.c)localObject2).Fu = PendingIntent.getBroadcast(localContext, (int)System.currentTimeMillis(), (Intent)localObject3, 0);
            if (parama.field_reserveInWifi) {
              ((s.c)localObject2).g(((Context)???).getString(2131758107));
            }
            for (;;)
            {
              ((com.tencent.mm.plugin.notification.b.a)g.ad(com.tencent.mm.plugin.notification.b.a.class)).getNotification().c(((s.c)localObject2).build());
              AppMethodBeat.o(8836);
              return;
              if (parama.field_autoDownload)
              {
                ((s.c)localObject2).f(parama.field_fileName + " · " + ai.getContext().getString(2131759047));
                ((s.c)localObject2).g(ai.getContext().getString(2131759046));
              }
              else
              {
                ((s.c)localObject2).g(((Context)???).getString(2131759051));
              }
            }
          }
          else
          {
            ((com.tencent.mm.plugin.notification.b.a)g.ad(com.tencent.mm.plugin.notification.b.a.class)).getNotification().notify(((Integer)localObject2).intValue(), ((s.c)localObject3).build());
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