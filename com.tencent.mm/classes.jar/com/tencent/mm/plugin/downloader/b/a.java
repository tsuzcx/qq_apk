package com.tencent.mm.plugin.downloader.b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.jw;
import com.tencent.mm.ipcinvoker.wx_extension.service.ToolsProcessIPCService;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.downloader.model.c;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.downloader.model.m;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public final class a
  implements m
{
  private static a ueF;
  private static BroadcastReceiver ueG;
  private static Set<b> ueH;
  private static Set<c> ueI;
  private static IListener ueJ;
  
  static
  {
    AppMethodBeat.i(88848);
    ueF = null;
    ueG = null;
    ueH = new CopyOnWriteArraySet();
    ueI = new CopyOnWriteArraySet();
    ueJ = new IListener() {};
    AppMethodBeat.o(88848);
  }
  
  private static void N(int paramInt, long paramLong)
  {
    AppMethodBeat.i(88846);
    Log.i("MicroMsg.DownloadEventBus", "dispatch event = %d, id = %d", new Object[] { Integer.valueOf(paramInt), Long.valueOf(paramLong) });
    com.tencent.mm.plugin.downloader.g.a locala = com.tencent.mm.plugin.downloader.model.d.IF(paramLong);
    if (locala == null)
    {
      AppMethodBeat.o(88846);
      return;
    }
    Iterator localIterator = ueH.iterator();
    while (localIterator.hasNext()) {
      ((b)localIterator.next()).O(paramInt, locala.field_downloadId);
    }
    a(locala, paramInt);
    AppMethodBeat.o(88846);
  }
  
  public static void a(b paramb)
  {
    AppMethodBeat.i(88834);
    if (paramb != null) {
      ueH.add(paramb);
    }
    AppMethodBeat.o(88834);
  }
  
  public static void a(c paramc)
  {
    AppMethodBeat.i(177453);
    if (paramc != null) {
      ueI.add(paramc);
    }
    AppMethodBeat.o(177453);
  }
  
  private static void a(com.tencent.mm.plugin.downloader.g.a parama, int paramInt)
  {
    AppMethodBeat.i(177455);
    Bundle localBundle = new Bundle();
    localBundle.putString("appId", parama.field_appId);
    localBundle.putInt("state", parama.field_status);
    if (parama.field_totalSize > 0L) {
      localBundle.putInt("progress", (int)(parama.field_downloadedSize * 100L / parama.field_totalSize));
    }
    localBundle.putBoolean("downloadInWidget", parama.field_fromDownloadApp);
    localBundle.putInt("event", paramInt);
    ToolsProcessIPCService.a(localBundle, d.class, null);
    AppMethodBeat.o(177455);
  }
  
  public static void b(b paramb)
  {
    AppMethodBeat.i(88835);
    if (paramb != null) {
      ueH.remove(paramb);
    }
    AppMethodBeat.o(88835);
  }
  
  public static void b(c paramc)
  {
    AppMethodBeat.i(177454);
    if (paramc != null) {
      ueI.remove(paramc);
    }
    AppMethodBeat.o(177454);
  }
  
  public static void cPR()
  {
    AppMethodBeat.i(88836);
    if (ueF == null) {
      ueF = new a();
    }
    if (ueG == null) {
      ueG = new a((byte)0);
    }
    f.cPZ();
    c.a(ueF);
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.intent.action.PACKAGE_ADDED");
    localIntentFilter.addAction("android.intent.action.PACKAGE_REPLACED");
    localIntentFilter.addDataScheme("package");
    MMApplicationContext.getContext().registerReceiver(ueG, localIntentFilter);
    EventCenter.instance.addListener(ueJ);
    AppMethodBeat.o(88836);
  }
  
  public static void cPS()
  {
    AppMethodBeat.i(88837);
    f.cPZ();
    c.b(ueF);
    MMApplicationContext.getContext().unregisterReceiver(ueG);
    ueF = null;
    ueG = null;
    ueH.clear();
    EventCenter.instance.removeListener(ueJ);
    AppMethodBeat.o(88837);
  }
  
  public final void Hp(long paramLong)
  {
    AppMethodBeat.i(88841);
    N(4, paramLong);
    AppMethodBeat.o(88841);
  }
  
  public final void Hq(long paramLong)
  {
    AppMethodBeat.i(88842);
    N(2, paramLong);
    AppMethodBeat.o(88842);
  }
  
  public final void Hr(long paramLong)
  {
    AppMethodBeat.i(88845);
    N(8, paramLong);
    AppMethodBeat.o(88845);
  }
  
  public final void a(long paramLong1, String paramString, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(219049);
    N(6, paramLong1);
    AppMethodBeat.o(219049);
  }
  
  public final void b(long paramLong, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(88840);
    N(5, paramLong);
    AppMethodBeat.o(88840);
  }
  
  public final void b(long paramLong, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(88839);
    N(3, paramLong);
    AppMethodBeat.o(88839);
  }
  
  public final void m(long paramLong, String paramString)
  {
    AppMethodBeat.i(88838);
    N(1, paramLong);
    AppMethodBeat.o(88838);
  }
  
  public final void n(long paramLong, String paramString)
  {
    AppMethodBeat.i(88844);
    N(7, paramLong);
    AppMethodBeat.o(88844);
  }
  
  static final class a
    extends BroadcastReceiver
  {
    public final void onReceive(Context paramContext, Intent paramIntent)
    {
      AppMethodBeat.i(88833);
      if ((paramContext == null) || (paramIntent == null))
      {
        AppMethodBeat.o(88833);
        return;
      }
      paramContext = paramIntent.getAction();
      Log.i("MicroMsg.DownloadEventBus", paramContext);
      if (Util.isNullOrNil(paramContext))
      {
        Log.e("MicroMsg.DownloadEventBus", "action is null or nill, ignore");
        AppMethodBeat.o(88833);
        return;
      }
      if ((!paramContext.equals("android.intent.action.PACKAGE_ADDED")) && (!paramContext.equals("android.intent.action.PACKAGE_REPLACED")))
      {
        AppMethodBeat.o(88833);
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
          Log.e("MicroMsg.DownloadEventBus", "%s", new Object[] { Util.stackTraceToString(paramIntent) });
        }
        paramIntent = paramContext;
        if (!paramContext.startsWith("package:")) {
          break label159;
        }
        paramIntent = paramContext.substring(8);
        if ((h.aHB()) && (!com.tencent.mm.kernel.b.aGE())) {
          break label184;
        }
        Log.e("MicroMsg.DownloadEventBus", "no user login");
        AppMethodBeat.o(88833);
        return;
        paramContext = com.tencent.mm.plugin.downloader.model.d.bbS();
        if (paramContext != null) {
          break label207;
        }
        paramContext = null;
        while (Util.isNullOrNil(paramContext))
        {
          AppMethodBeat.o(88833);
          return;
          if (Util.isNullOrNil(paramIntent))
          {
            Log.e("MicroMsg.FileDownloadInfoStorage", "Null or nil PakcageName");
            paramContext = null;
          }
          else
          {
            localCursor = paramContext.rawQuery("select * from FileDownloadInfo where packageName='" + paramIntent + "' order by downloadId desc", new String[0]);
            paramIntent = new LinkedList();
            paramContext = paramIntent;
            if (localCursor != null)
            {
              if (localCursor.moveToFirst()) {
                do
                {
                  paramContext = new com.tencent.mm.plugin.downloader.g.a();
                  paramContext.convertFrom(localCursor);
                  paramIntent.add(paramContext);
                } while (localCursor.moveToNext());
              }
              localCursor.close();
              paramContext = paramIntent;
            }
          }
        }
        paramIntent = paramContext.iterator();
      }
      Log.i("MicroMsg.DownloadEventBus", "get added package name : %s", new Object[] { paramContext });
      if (Util.isNullOrNil(paramContext))
      {
        Log.e("MicroMsg.DownloadEventBus", "get installed broadcast, while the package name is null or nil");
        AppMethodBeat.o(88833);
        return;
      }
      label159:
      label184:
      label207:
      do
      {
        Cursor localCursor;
        if (!paramIntent.hasNext()) {
          break;
        }
        paramContext = (com.tencent.mm.plugin.downloader.g.a)paramIntent.next();
      } while (paramContext.field_fileType != 1);
      for (;;)
      {
        if (paramContext != null) {
          a.It(paramContext.field_downloadId);
        }
        AppMethodBeat.o(88833);
        return;
        paramContext = null;
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract void O(int paramInt, long paramLong);
  }
  
  public static abstract interface c
  {
    public abstract void Z(Bundle paramBundle);
  }
  
  static class d
    implements com.tencent.mm.ipcinvoker.d<Bundle, Bundle>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.b.a
 * JD-Core Version:    0.7.0.1
 */