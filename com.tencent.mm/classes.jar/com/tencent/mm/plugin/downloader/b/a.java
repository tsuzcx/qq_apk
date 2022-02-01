package com.tencent.mm.plugin.downloader.b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ir;
import com.tencent.mm.ipcinvoker.wx_extension.service.ToolsProcessIPCService;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.downloader.model.m;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public final class a
  implements m
{
  private static a ppY;
  private static BroadcastReceiver ppZ;
  private static Set<b> pqa;
  private static Set<c> pqb;
  private static com.tencent.mm.sdk.b.c pqc;
  
  static
  {
    AppMethodBeat.i(88848);
    ppY = null;
    ppZ = null;
    pqa = new CopyOnWriteArraySet();
    pqb = new CopyOnWriteArraySet();
    pqc = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(88848);
  }
  
  private static void K(int paramInt, long paramLong)
  {
    AppMethodBeat.i(88846);
    ae.i("MicroMsg.DownloadEventBus", "dispatch event = %d, id = %d", new Object[] { Integer.valueOf(paramInt), Long.valueOf(paramLong) });
    com.tencent.mm.plugin.downloader.g.a locala = d.ur(paramLong);
    if (locala == null)
    {
      AppMethodBeat.o(88846);
      return;
    }
    Iterator localIterator = pqa.iterator();
    while (localIterator.hasNext()) {
      ((b)localIterator.next()).L(paramInt, locala.field_downloadId);
    }
    a(locala, paramInt);
    AppMethodBeat.o(88846);
  }
  
  public static void a(b paramb)
  {
    AppMethodBeat.i(88834);
    if (paramb != null) {
      pqa.add(paramb);
    }
    AppMethodBeat.o(88834);
  }
  
  public static void a(c paramc)
  {
    AppMethodBeat.i(177453);
    if (paramc != null) {
      pqb.add(paramc);
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
      pqa.remove(paramb);
    }
    AppMethodBeat.o(88835);
  }
  
  public static void b(c paramc)
  {
    AppMethodBeat.i(177454);
    if (paramc != null) {
      pqb.remove(paramc);
    }
    AppMethodBeat.o(177454);
  }
  
  public static void cds()
  {
    AppMethodBeat.i(88836);
    if (ppY == null) {
      ppY = new a();
    }
    if (ppZ == null) {
      ppZ = new a((byte)0);
    }
    f.cdA();
    com.tencent.mm.plugin.downloader.model.c.a(ppY);
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.intent.action.PACKAGE_ADDED");
    localIntentFilter.addAction("android.intent.action.PACKAGE_REPLACED");
    localIntentFilter.addDataScheme("package");
    ak.getContext().registerReceiver(ppZ, localIntentFilter);
    com.tencent.mm.sdk.b.a.IvT.c(pqc);
    AppMethodBeat.o(88836);
  }
  
  public static void cdt()
  {
    AppMethodBeat.i(88837);
    f.cdA();
    com.tencent.mm.plugin.downloader.model.c.b(ppY);
    ak.getContext().unregisterReceiver(ppZ);
    ppY = null;
    ppZ = null;
    pqa.clear();
    com.tencent.mm.sdk.b.a.IvT.d(pqc);
    AppMethodBeat.o(88837);
  }
  
  public final void a(long paramLong, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(88840);
    K(5, paramLong);
    AppMethodBeat.o(88840);
  }
  
  public final void a(long paramLong1, String paramString, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(207155);
    K(6, paramLong1);
    AppMethodBeat.o(207155);
  }
  
  public final void b(long paramLong, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(88839);
    K(3, paramLong);
    AppMethodBeat.o(88839);
  }
  
  public final void j(long paramLong, String paramString)
  {
    AppMethodBeat.i(88838);
    K(1, paramLong);
    AppMethodBeat.o(88838);
  }
  
  public final void k(long paramLong, String paramString)
  {
    AppMethodBeat.i(88844);
    K(7, paramLong);
    AppMethodBeat.o(88844);
  }
  
  public final void sY(long paramLong)
  {
    AppMethodBeat.i(88841);
    K(4, paramLong);
    AppMethodBeat.o(88841);
  }
  
  public final void sZ(long paramLong)
  {
    AppMethodBeat.i(88842);
    K(2, paramLong);
    AppMethodBeat.o(88842);
  }
  
  public final void ta(long paramLong)
  {
    AppMethodBeat.i(88845);
    K(8, paramLong);
    AppMethodBeat.o(88845);
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
      ae.i("MicroMsg.DownloadEventBus", paramContext);
      if (bu.isNullOrNil(paramContext))
      {
        ae.e("MicroMsg.DownloadEventBus", "action is null or nill, ignore");
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
          ae.e("MicroMsg.DownloadEventBus", "%s", new Object[] { bu.o(paramIntent) });
        }
        paramIntent = paramContext;
        if (!paramContext.startsWith("package:")) {
          break label159;
        }
        paramIntent = paramContext.substring(8);
        if ((g.ajM()) && (!com.tencent.mm.kernel.a.aiT())) {
          break label184;
        }
        ae.e("MicroMsg.DownloadEventBus", "no user login");
        AppMethodBeat.o(88833);
        return;
        paramContext = d.azM();
        if (paramContext != null) {
          break label204;
        }
      }
      ae.i("MicroMsg.DownloadEventBus", "get added package name : %s", new Object[] { paramContext });
      if (bu.isNullOrNil(paramContext))
      {
        ae.e("MicroMsg.DownloadEventBus", "get installed broadcast, while the package name is null or nil");
        AppMethodBeat.o(88833);
        return;
      }
      label159:
      label184:
      paramContext = null;
      label204:
      Cursor localCursor;
      while (paramContext == null)
      {
        AppMethodBeat.o(88833);
        return;
        if (bu.isNullOrNil(paramIntent))
        {
          ae.e("MicroMsg.FileDownloadInfoStorage", "Null or nil PakcageName");
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
              break label314;
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
        a.uf(paramContext.field_downloadId);
        AppMethodBeat.o(88833);
        return;
        label314:
        paramIntent = null;
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract void L(int paramInt, long paramLong);
  }
  
  public static abstract interface c
  {
    public abstract void aa(Bundle paramBundle);
  }
  
  static class d
    implements com.tencent.mm.ipcinvoker.b<Bundle, Bundle>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.b.a
 * JD-Core Version:    0.7.0.1
 */