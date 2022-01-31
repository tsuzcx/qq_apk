package com.tencent.mm.plugin.downloader_app.b;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.x.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.al;
import com.tencent.mm.plugin.downloader.model.c;
import com.tencent.mm.plugin.downloader_app.b.h;
import com.tencent.mm.plugin.downloader_app.ui.DownloadMainUI;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.Map;

public final class b
{
  private static Map<String, Long> iRU = new HashMap();
  private static Map<String, Integer> iRV = new HashMap();
  private static Object lock = new Object();
  
  public static void zW(String paramString)
  {
    boolean bool = false;
    com.tencent.mm.plugin.downloader.f.a locala = c.zH(paramString);
    if (locala == null)
    {
      y.e("MicroMsg.DownloadNotificationManager", "updateNotification failed: null task info");
      return;
    }
    if (!locala.field_fromDownloadApp)
    {
      y.i("MicroMsg.DownloadNotificationManager", "updateNotification not from download app");
      return;
    }
    if (locala.field_totalSize > 0L) {}
    for (int i = (int)(locala.field_downloadedSize * 100L / locala.field_totalSize);; i = 0)
    {
      x.c localc = new x.c(ae.getContext(), (byte)0);
      Object localObject2 = (Long)iRU.get(paramString);
      ??? = localObject2;
      if (localObject2 == null)
      {
        ??? = Long.valueOf(System.currentTimeMillis());
        iRU.put(paramString, ???);
      }
      localc.j(((Long)???).longValue());
      localc.c(locala.field_fileName);
      switch (locala.field_status)
      {
      default: 
        return;
      case 1: 
        localc.ah(com.tencent.mm.bq.a.bSL());
        if (i == 0) {
          bool = true;
        }
        localc.b(100, i, bool);
        localc.d(ae.getContext().getString(b.h.notification_downloading));
        localc.l(2, true);
        localc.xz = zX(locala.field_appId);
      }
      for (;;)
      {
        synchronized (lock)
        {
          localObject2 = (Integer)iRV.get(paramString);
          if (localObject2 != null) {
            break label532;
          }
          i = ((com.tencent.mm.plugin.notification.b.a)g.t(com.tencent.mm.plugin.notification.b.a.class)).getNotification().c(localc.build());
          iRV.put(paramString, Integer.valueOf(i));
          if (locala.field_status == 4)
          {
            iRV.remove(paramString);
            iRU.remove(paramString);
          }
          return;
        }
        localc.ah(com.tencent.mm.bq.a.bSL());
        localc.z(true);
        localc.xz = zX(locala.field_appId);
        if ((locala.field_errCode == com.tencent.mm.plugin.downloader.a.a.iOt) || (locala.field_errCode == com.tencent.mm.plugin.downloader.a.a.iOp))
        {
          localc.d(ae.getContext().getString(b.h.notification_download_md5_check_failed));
        }
        else
        {
          localc.d(ae.getContext().getString(b.h.notification_download_fail));
          continue;
          synchronized (lock)
          {
            localObject2 = (Integer)iRV.get(paramString);
            if (localObject2 == null)
            {
              y.i("MicroMsg.DownloadNotificationManager", "No notification id found");
              return;
            }
          }
          ((com.tencent.mm.plugin.notification.b.a)g.t(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancel(((Integer)localObject2).intValue());
          y.i("MicroMsg.DownloadNotificationManager", "cancelNotification, id = " + localObject2);
          iRV.remove(paramString);
          iRU.remove(paramString);
          return;
          label532:
          ((com.tencent.mm.plugin.notification.b.a)g.t(com.tencent.mm.plugin.notification.b.a.class)).getNotification().notify(((Integer)localObject2).intValue(), localc.build());
        }
      }
    }
  }
  
  private static PendingIntent zX(String paramString)
  {
    Intent localIntent = new Intent(ae.getContext(), DownloadMainUI.class);
    localIntent.putExtra("appId", paramString);
    localIntent.putExtra("view_task", true);
    return PendingIntent.getActivity(ae.getContext(), (int)System.currentTimeMillis(), localIntent, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.b.b
 * JD-Core Version:    0.7.0.1
 */