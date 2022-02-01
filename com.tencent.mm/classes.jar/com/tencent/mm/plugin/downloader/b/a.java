package com.tencent.mm.plugin.downloader.b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.iq;
import com.tencent.mm.ipcinvoker.wx_extension.service.ToolsProcessIPCService;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.downloader.model.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public final class a
  implements m
{
  private static a pjt;
  private static BroadcastReceiver pju;
  private static Set<b> pjv;
  private static Set<c> pjw;
  private static com.tencent.mm.sdk.b.c pjx;
  
  static
  {
    AppMethodBeat.i(88848);
    pjt = null;
    pju = null;
    pjv = new CopyOnWriteArraySet();
    pjw = new CopyOnWriteArraySet();
    pjx = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(88848);
  }
  
  private static void L(int paramInt, long paramLong)
  {
    AppMethodBeat.i(88846);
    ad.i("MicroMsg.DownloadEventBus", "dispatch event = %d, id = %d", new Object[] { Integer.valueOf(paramInt), Long.valueOf(paramLong) });
    com.tencent.mm.plugin.downloader.g.a locala = d.ua(paramLong);
    if (locala == null)
    {
      AppMethodBeat.o(88846);
      return;
    }
    Iterator localIterator = pjv.iterator();
    while (localIterator.hasNext()) {
      ((b)localIterator.next()).M(paramInt, locala.field_downloadId);
    }
    a(locala, paramInt);
    AppMethodBeat.o(88846);
  }
  
  public static void a(b paramb)
  {
    AppMethodBeat.i(88834);
    if (paramb != null) {
      pjv.add(paramb);
    }
    AppMethodBeat.o(88834);
  }
  
  public static void a(c paramc)
  {
    AppMethodBeat.i(177453);
    if (paramc != null) {
      pjw.add(paramc);
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
      pjv.remove(paramb);
    }
    AppMethodBeat.o(88835);
  }
  
  public static void b(c paramc)
  {
    AppMethodBeat.i(177454);
    if (paramc != null) {
      pjw.remove(paramc);
    }
    AppMethodBeat.o(177454);
  }
  
  public static void ccd()
  {
    AppMethodBeat.i(88836);
    if (pjt == null) {
      pjt = new a();
    }
    if (pju == null) {
      pju = new a((byte)0);
    }
    f.ccl();
    com.tencent.mm.plugin.downloader.model.c.a(pjt);
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.intent.action.PACKAGE_ADDED");
    localIntentFilter.addAction("android.intent.action.PACKAGE_REPLACED");
    localIntentFilter.addDataScheme("package");
    aj.getContext().registerReceiver(pju, localIntentFilter);
    com.tencent.mm.sdk.b.a.IbL.c(pjx);
    AppMethodBeat.o(88836);
  }
  
  public static void cce()
  {
    AppMethodBeat.i(88837);
    f.ccl();
    com.tencent.mm.plugin.downloader.model.c.b(pjt);
    aj.getContext().unregisterReceiver(pju);
    pjt = null;
    pju = null;
    pjv.clear();
    com.tencent.mm.sdk.b.a.IbL.d(pjx);
    AppMethodBeat.o(88837);
  }
  
  public final void a(long paramLong, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(88840);
    L(5, paramLong);
    AppMethodBeat.o(88840);
  }
  
  public final void a(long paramLong1, String paramString, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(213692);
    L(6, paramLong1);
    AppMethodBeat.o(213692);
  }
  
  public final void b(long paramLong, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(88839);
    L(3, paramLong);
    AppMethodBeat.o(88839);
  }
  
  public final void j(long paramLong, String paramString)
  {
    AppMethodBeat.i(88838);
    L(1, paramLong);
    AppMethodBeat.o(88838);
  }
  
  public final void k(long paramLong, String paramString)
  {
    AppMethodBeat.i(88844);
    L(7, paramLong);
    AppMethodBeat.o(88844);
  }
  
  public final void sL(long paramLong)
  {
    AppMethodBeat.i(88841);
    L(4, paramLong);
    AppMethodBeat.o(88841);
  }
  
  public final void sM(long paramLong)
  {
    AppMethodBeat.i(88842);
    L(2, paramLong);
    AppMethodBeat.o(88842);
  }
  
  public final void sN(long paramLong)
  {
    AppMethodBeat.i(88845);
    L(8, paramLong);
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
      ad.i("MicroMsg.DownloadEventBus", paramContext);
      if (bt.isNullOrNil(paramContext))
      {
        ad.e("MicroMsg.DownloadEventBus", "action is null or nill, ignore");
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
          ad.e("MicroMsg.DownloadEventBus", "%s", new Object[] { bt.n(paramIntent) });
        }
        paramIntent = paramContext;
        if (!paramContext.startsWith("package:")) {
          break label159;
        }
        paramIntent = paramContext.substring(8);
        if ((g.ajx()) && (!com.tencent.mm.kernel.a.aiE())) {
          break label184;
        }
        ad.e("MicroMsg.DownloadEventBus", "no user login");
        AppMethodBeat.o(88833);
        return;
        paramContext = d.azw();
        if (paramContext != null) {
          break label204;
        }
      }
      ad.i("MicroMsg.DownloadEventBus", "get added package name : %s", new Object[] { paramContext });
      if (bt.isNullOrNil(paramContext))
      {
        ad.e("MicroMsg.DownloadEventBus", "get installed broadcast, while the package name is null or nil");
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
        if (bt.isNullOrNil(paramIntent))
        {
          ad.e("MicroMsg.FileDownloadInfoStorage", "Null or nil PakcageName");
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
        a.tO(paramContext.field_downloadId);
        AppMethodBeat.o(88833);
        return;
        label314:
        paramIntent = null;
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract void M(int paramInt, long paramLong);
  }
  
  public static abstract interface c
  {
    public abstract void Z(Bundle paramBundle);
  }
  
  static class d
    implements com.tencent.mm.ipcinvoker.b<Bundle, Bundle>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.b.a
 * JD-Core Version:    0.7.0.1
 */