package com.tencent.mm.plugin.downloader.b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.downloader.model.c;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.plugin.downloader.model.k;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public final class a
  implements k
{
  private static Set<a.b> iOA = new CopyOnWriteArraySet();
  private static a iOy = null;
  private static BroadcastReceiver iOz = null;
  
  public static void a(a.b paramb)
  {
    if (paramb != null) {
      iOA.add(paramb);
    }
  }
  
  public static void aFI()
  {
    if (iOy == null) {
      iOy = new a();
    }
    if (iOz == null) {
      iOz = new a((byte)0);
    }
    d.aFP();
    com.tencent.mm.plugin.downloader.model.b.a(iOy);
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.intent.action.PACKAGE_ADDED");
    localIntentFilter.addAction("android.intent.action.PACKAGE_REPLACED");
    localIntentFilter.addDataScheme("package");
    ae.getContext().registerReceiver(iOz, localIntentFilter);
  }
  
  public static void aFJ()
  {
    d.aFP();
    com.tencent.mm.plugin.downloader.model.b.b(iOy);
    ae.getContext().unregisterReceiver(iOz);
    iOy = null;
    iOz = null;
    iOA.clear();
  }
  
  public static void b(a.b paramb)
  {
    if (paramb != null) {
      iOA.remove(paramb);
    }
  }
  
  private static void s(int paramInt, long paramLong)
  {
    y.i("MicroMsg.DownloadEventBus", "dispatch event = %d, id = %d", new Object[] { Integer.valueOf(paramInt), Long.valueOf(paramLong) });
    com.tencent.mm.plugin.downloader.f.a locala = c.dk(paramLong);
    if (locala == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = iOA.iterator();
      while (localIterator.hasNext()) {
        ((a.b)localIterator.next()).X(paramInt, locala.field_appId);
      }
    }
  }
  
  public final void b(long paramLong, int paramInt, boolean paramBoolean)
  {
    s(5, paramLong);
  }
  
  public final void b(long paramLong, String paramString, boolean paramBoolean)
  {
    s(3, paramLong);
  }
  
  public final void cy(long paramLong)
  {
    s(6, paramLong);
  }
  
  public final void cz(long paramLong)
  {
    s(8, paramLong);
  }
  
  public final void k(long paramLong, String paramString)
  {
    s(7, paramLong);
  }
  
  public final void onTaskPaused(long paramLong)
  {
    s(2, paramLong);
  }
  
  public final void onTaskRemoved(long paramLong)
  {
    s(4, paramLong);
  }
  
  public final void onTaskStarted(long paramLong, String paramString)
  {
    s(1, paramLong);
  }
  
  private static final class a
    extends BroadcastReceiver
  {
    public final void onReceive(Context paramContext, Intent paramIntent)
    {
      if ((paramContext == null) || (paramIntent == null)) {}
      do
      {
        return;
        paramContext = paramIntent.getAction();
        y.i("MicroMsg.DownloadEventBus", paramContext);
        if (bk.bl(paramContext))
        {
          y.e("MicroMsg.DownloadEventBus", "action is null or nill, ignore");
          return;
        }
      } while ((!paramContext.equals("android.intent.action.PACKAGE_ADDED")) && (!paramContext.equals("android.intent.action.PACKAGE_REPLACED")));
      paramContext = "";
      try
      {
        paramIntent = paramIntent.getDataString();
        paramContext = paramIntent;
      }
      catch (Exception paramIntent)
      {
        for (;;)
        {
          y.e("MicroMsg.DownloadEventBus", "%s", new Object[] { bk.j(paramIntent) });
        }
        paramIntent = paramContext;
        if (!paramContext.startsWith("package:")) {
          break label133;
        }
        paramIntent = paramContext.substring(8);
        if ((g.DK()) && (!com.tencent.mm.kernel.a.CW())) {
          break label153;
        }
        y.e("MicroMsg.DownloadEventBus", "no user login");
        return;
        paramContext = c.FC();
        if (paramContext != null) {
          break label175;
        }
      }
      y.i("MicroMsg.DownloadEventBus", "get added package name : %s", new Object[] { paramContext });
      if (bk.bl(paramContext))
      {
        y.e("MicroMsg.DownloadEventBus", "get installed broadcast, while the package name is null or nil");
        return;
      }
      label133:
      label153:
      paramContext = null;
      label163:
      label175:
      Cursor localCursor;
      while (paramContext != null)
      {
        a.db(paramContext.field_downloadId);
        return;
        if (bk.bl(paramIntent))
        {
          y.e("MicroMsg.FileDownloadInfoStorage", "Null or nil PakcageName");
          paramContext = null;
        }
        else
        {
          localCursor = paramContext.rawQuery("select * from FileDownloadInfo where packageName='" + paramIntent + "' order by downloadId desc limit 1", new String[0]);
          if (localCursor == null)
          {
            paramContext = null;
          }
          else
          {
            if (!localCursor.moveToFirst()) {
              break label272;
            }
            paramIntent = new com.tencent.mm.plugin.downloader.f.a();
            paramIntent.d(localCursor);
          }
        }
      }
      for (;;)
      {
        paramContext = paramIntent;
        if (localCursor == null) {
          break label163;
        }
        localCursor.close();
        paramContext = paramIntent;
        break label163;
        break;
        label272:
        paramIntent = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.b.a
 * JD-Core Version:    0.7.0.1
 */