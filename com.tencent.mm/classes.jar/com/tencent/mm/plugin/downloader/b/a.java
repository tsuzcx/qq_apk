package com.tencent.mm.plugin.downloader.b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.downloader.g.b;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.downloader.model.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public final class a
  implements m
{
  private static Set<a.b> jmL;
  private static a kVG;
  private static BroadcastReceiver kVH;
  private static com.tencent.mm.sdk.b.c kVI;
  
  static
  {
    AppMethodBeat.i(2300);
    kVG = null;
    kVH = null;
    jmL = new CopyOnWriteArraySet();
    kVI = new a.1();
    AppMethodBeat.o(2300);
  }
  
  private static void G(int paramInt, long paramLong)
  {
    AppMethodBeat.i(2298);
    ab.i("MicroMsg.DownloadEventBus", "dispatch event = %d, id = %d", new Object[] { Integer.valueOf(paramInt), Long.valueOf(paramLong) });
    com.tencent.mm.plugin.downloader.g.a locala = d.iJ(paramLong);
    if (locala == null)
    {
      AppMethodBeat.o(2298);
      return;
    }
    Iterator localIterator = jmL.iterator();
    while (localIterator.hasNext()) {
      ((a.b)localIterator.next()).H(paramInt, locala.field_downloadId);
    }
    AppMethodBeat.o(2298);
  }
  
  public static void a(a.b paramb)
  {
    AppMethodBeat.i(2286);
    if (paramb != null) {
      jmL.add(paramb);
    }
    AppMethodBeat.o(2286);
  }
  
  public static void b(a.b paramb)
  {
    AppMethodBeat.i(2287);
    if (paramb != null) {
      jmL.remove(paramb);
    }
    AppMethodBeat.o(2287);
  }
  
  public static void bje()
  {
    AppMethodBeat.i(2288);
    if (kVG == null) {
      kVG = new a();
    }
    if (kVH == null) {
      kVH = new a((byte)0);
    }
    f.bjl();
    com.tencent.mm.plugin.downloader.model.c.a(kVG);
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.intent.action.PACKAGE_ADDED");
    localIntentFilter.addAction("android.intent.action.PACKAGE_REPLACED");
    localIntentFilter.addDataScheme("package");
    ah.getContext().registerReceiver(kVH, localIntentFilter);
    com.tencent.mm.sdk.b.a.ymk.c(kVI);
    AppMethodBeat.o(2288);
  }
  
  public static void bjf()
  {
    AppMethodBeat.i(2289);
    f.bjl();
    com.tencent.mm.plugin.downloader.model.c.b(kVG);
    ah.getContext().unregisterReceiver(kVH);
    kVG = null;
    kVH = null;
    jmL.clear();
    com.tencent.mm.sdk.b.a.ymk.d(kVI);
    AppMethodBeat.o(2289);
  }
  
  public final void b(long paramLong, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(2292);
    G(5, paramLong);
    AppMethodBeat.o(2292);
  }
  
  public final void b(long paramLong, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(2291);
    G(3, paramLong);
    AppMethodBeat.o(2291);
  }
  
  public final void hx(long paramLong)
  {
    AppMethodBeat.i(2295);
    G(6, paramLong);
    AppMethodBeat.o(2295);
  }
  
  public final void hy(long paramLong)
  {
    AppMethodBeat.i(2297);
    G(8, paramLong);
    AppMethodBeat.o(2297);
  }
  
  public final void i(long paramLong, String paramString)
  {
    AppMethodBeat.i(2296);
    G(7, paramLong);
    AppMethodBeat.o(2296);
  }
  
  public final void onTaskPaused(long paramLong)
  {
    AppMethodBeat.i(2294);
    G(2, paramLong);
    AppMethodBeat.o(2294);
  }
  
  public final void onTaskRemoved(long paramLong)
  {
    AppMethodBeat.i(2293);
    G(4, paramLong);
    AppMethodBeat.o(2293);
  }
  
  public final void onTaskStarted(long paramLong, String paramString)
  {
    AppMethodBeat.i(2290);
    G(1, paramLong);
    AppMethodBeat.o(2290);
  }
  
  static final class a
    extends BroadcastReceiver
  {
    public final void onReceive(Context paramContext, Intent paramIntent)
    {
      AppMethodBeat.i(2285);
      if ((paramContext == null) || (paramIntent == null))
      {
        AppMethodBeat.o(2285);
        return;
      }
      paramContext = paramIntent.getAction();
      ab.i("MicroMsg.DownloadEventBus", paramContext);
      if (bo.isNullOrNil(paramContext))
      {
        ab.e("MicroMsg.DownloadEventBus", "action is null or nill, ignore");
        AppMethodBeat.o(2285);
        return;
      }
      if ((!paramContext.equals("android.intent.action.PACKAGE_ADDED")) && (!paramContext.equals("android.intent.action.PACKAGE_REPLACED")))
      {
        AppMethodBeat.o(2285);
        return;
      }
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
          ab.e("MicroMsg.DownloadEventBus", "%s", new Object[] { bo.l(paramIntent) });
        }
        paramIntent = paramContext;
        if (!paramContext.startsWith("package:")) {
          break label164;
        }
        paramIntent = paramContext.substring(8);
        if ((g.RG()) && (!com.tencent.mm.kernel.a.QP())) {
          break label190;
        }
        ab.e("MicroMsg.DownloadEventBus", "no user login");
        AppMethodBeat.o(2285);
        return;
        paramContext = d.YG();
        if (paramContext != null) {
          break label211;
        }
      }
      ab.i("MicroMsg.DownloadEventBus", "get added package name : %s", new Object[] { paramContext });
      if (bo.isNullOrNil(paramContext))
      {
        ab.e("MicroMsg.DownloadEventBus", "get installed broadcast, while the package name is null or nil");
        AppMethodBeat.o(2285);
        return;
      }
      label164:
      label190:
      paramContext = null;
      label211:
      Cursor localCursor;
      while (paramContext == null)
      {
        AppMethodBeat.o(2285);
        return;
        if (bo.isNullOrNil(paramIntent))
        {
          ab.e("MicroMsg.FileDownloadInfoStorage", "Null or nil PakcageName");
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
              break label322;
            }
            paramIntent = new com.tencent.mm.plugin.downloader.g.a();
            paramIntent.convertFrom(localCursor);
          }
        }
      }
      for (;;)
      {
        paramContext = paramIntent;
        if (localCursor == null) {
          break;
        }
        localCursor.close();
        paramContext = paramIntent;
        break;
        a.iw(paramContext.field_downloadId);
        AppMethodBeat.o(2285);
        return;
        label322:
        paramIntent = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.b.a
 * JD-Core Version:    0.7.0.1
 */