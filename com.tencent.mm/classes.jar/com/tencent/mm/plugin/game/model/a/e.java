package com.tencent.mm.plugin.game.model.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.o.a;
import com.tencent.mm.g.a.ja;
import com.tencent.mm.g.a.jb;
import com.tencent.mm.g.a.jb.a;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;

public class e
{
  private static o.a appForegroundListener;
  private static int qJw;
  private static b xIl;
  private static a xIm;
  private static c xIn;
  private static IListener xIo;
  private static IListener xIp;
  
  static
  {
    AppMethodBeat.i(41682);
    qJw = -1;
    appForegroundListener = new e.1();
    xIo = new IListener()
    {
      private static boolean a(jb paramAnonymousjb)
      {
        AppMethodBeat.i(41675);
        switch (paramAnonymousjb.dNJ.dDe)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(41675);
          return false;
          if (Util.secondsToNow(Util.nullAsNil((Long)com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.OcU, Long.valueOf(0L)))) > 600L)
          {
            com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.OcU, Long.valueOf(Util.nowSecond()));
            h.a.dWd().pP(false);
            continue;
            paramAnonymousjb = paramAnonymousjb.dNJ.dNI;
            if (Util.isNullOrNil(paramAnonymousjb))
            {
              Log.i("MicroMsg.GameSilentDownloadStorage", "deleteAllItem ret:%b", new Object[] { Boolean.valueOf(((com.tencent.mm.plugin.game.api.f)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.game.api.f.class)).dSM().execSQL("GameSilentDownload", String.format("delete from %s", new Object[] { "GameSilentDownload" }))) });
            }
            else
            {
              Object localObject = new d();
              ((d)localObject).field_appId = paramAnonymousjb;
              ((com.tencent.mm.plugin.game.api.f)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.game.api.f.class)).dSM().delete((IAutoDBItem)localObject, new String[0]);
              Log.i("MicroMsg.GameSilentDownloadListener", "delete silent download, appid:%s", new Object[] { paramAnonymousjb });
              continue;
              paramAnonymousjb = paramAnonymousjb.dNJ.dNI;
              if (!Util.isNullOrNil(paramAnonymousjb))
              {
                localObject = com.tencent.mm.plugin.downloader.model.d.alb(paramAnonymousjb);
                if (localObject != null)
                {
                  long l = ((com.tencent.mm.plugin.downloader.g.a)localObject).field_downloadId;
                  com.tencent.mm.plugin.downloader.model.f.cBv().Cn(l);
                  com.tencent.mm.plugin.downloader.model.d.Cx(((com.tencent.mm.plugin.downloader.g.a)localObject).field_downloadId);
                  Log.i("MicroMsg.GameSilentDownload.GameDownloadHelper", "delete downloadInfo in DB. appId:%s", new Object[] { paramAnonymousjb });
                }
              }
            }
          }
        }
      }
    };
    xIp = new IListener() {};
    AppMethodBeat.o(41682);
  }
  
  public static void cBn()
  {
    AppMethodBeat.i(41680);
    try
    {
      if (xIl == null) {
        xIl = new b((byte)0);
      }
      localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.net.wifi.STATE_CHANGE");
      localIntentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
      localIntentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
      MMApplicationContext.getContext().registerReceiver(xIl, localIntentFilter);
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        IntentFilter localIntentFilter;
        label107:
        Log.i("MicroMsg.GameSilentDownloadListener", "registerNetChange err:%s", new Object[] { localException1.getMessage() });
      }
    }
    try
    {
      if (xIm == null) {
        xIm = new a((byte)0);
      }
      localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.intent.action.BATTERY_OKAY");
      localIntentFilter.addAction("android.intent.action.BATTERY_LOW");
      MMApplicationContext.getContext().registerReceiver(xIm, localIntentFilter);
    }
    catch (Exception localException2)
    {
      Log.i("MicroMsg.GameSilentDownloadListener", "registerBatteryChange err:%s", new Object[] { localException2.getMessage() });
      break label107;
    }
    appForegroundListener.alive();
    EventCenter.instance.addListener(xIo);
    EventCenter.instance.addListener(xIp);
    if (xIn == null) {
      xIn = new c();
    }
    com.tencent.mm.plugin.downloader.model.f.cBv();
    com.tencent.mm.plugin.downloader.model.c.a(xIn);
    AppMethodBeat.o(41680);
  }
  
  public static void cBo()
  {
    AppMethodBeat.i(41681);
    appForegroundListener.dead();
    if (xIl != null) {}
    try
    {
      MMApplicationContext.getContext().unregisterReceiver(xIl);
      xIl = null;
      if (xIm == null) {}
    }
    catch (Exception localException1)
    {
      try
      {
        MMApplicationContext.getContext().unregisterReceiver(xIm);
        xIm = null;
        EventCenter.instance.removeListener(xIo);
        EventCenter.instance.removeListener(xIp);
        if (xIn != null)
        {
          com.tencent.mm.plugin.downloader.model.f.cBv();
          com.tencent.mm.plugin.downloader.model.c.b(xIn);
          xIn = null;
        }
        AppMethodBeat.o(41681);
        return;
        localException1 = localException1;
        Log.i("MicroMsg.GameSilentDownloadListener", "unregisterNetChange err:%s", new Object[] { localException1.getMessage() });
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          Log.i("MicroMsg.GameSilentDownloadListener", "unregisterBatteryChange err:%s", new Object[] { localException2.getMessage() });
        }
      }
    }
  }
  
  static final class a
    extends BroadcastReceiver
  {
    public final void onReceive(Context paramContext, Intent paramIntent)
    {
      AppMethodBeat.i(41678);
      if ((!com.tencent.mm.kernel.g.aAc()) || (com.tencent.mm.kernel.a.azj()))
      {
        Log.e("MicroMsg.GameSilentDownloadListener", "acc has not ready");
        AppMethodBeat.o(41678);
        return;
      }
      if (paramIntent == null)
      {
        AppMethodBeat.o(41678);
        return;
      }
      if ("android.intent.action.BATTERY_OKAY".equals(paramIntent.getAction()))
      {
        Log.i("MicroMsg.GameSilentDownloadListener", "batteryChange: ACTION_BATTERY_OKAY, checkDownload");
        h.a.dWd().pP(true);
        AppMethodBeat.o(41678);
        return;
      }
      if ("android.intent.action.BATTERY_LOW".equals(paramIntent.getAction()))
      {
        Log.i("MicroMsg.GameSilentDownloadListener", "batteryChange: ACTION_BATTERY_LOW, pauseDownload");
        h.a.dWd();
        h.pauseDownload();
      }
      AppMethodBeat.o(41678);
    }
  }
  
  static final class b
    extends BroadcastReceiver
  {
    public final void onReceive(Context paramContext, Intent paramIntent)
    {
      AppMethodBeat.i(41679);
      com.tencent.f.h.RTc.aX(new Runnable()
      {
        /* Error */
        public final void run()
        {
          // Byte code:
          //   0: ldc 26
          //   2: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
          //   5: ldc 13
          //   7: monitorenter
          //   8: invokestatic 38	com/tencent/mm/kernel/g:aAc	()Z
          //   11: ifeq +9 -> 20
          //   14: invokestatic 43	com/tencent/mm/kernel/a:azj	()Z
          //   17: ifeq +19 -> 36
          //   20: ldc 45
          //   22: ldc 47
          //   24: invokestatic 53	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
          //   27: ldc 13
          //   29: monitorexit
          //   30: ldc 26
          //   32: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   35: return
          //   36: invokestatic 62	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
          //   39: invokestatic 68	com/tencent/mm/sdk/platformtools/NetStatusUtil:getNetType	(Landroid/content/Context;)I
          //   42: istore_1
          //   43: iload_1
          //   44: invokestatic 72	com/tencent/mm/plugin/game/model/a/e:Tp	()I
          //   47: if_icmpne +12 -> 59
          //   50: ldc 13
          //   52: monitorexit
          //   53: ldc 26
          //   55: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   58: return
          //   59: iload_1
          //   60: invokestatic 76	com/tencent/mm/plugin/game/model/a/e:iz	(I)I
          //   63: pop
          //   64: iload_1
          //   65: ifne +37 -> 102
          //   68: ldc 45
          //   70: ldc 78
          //   72: iconst_1
          //   73: anewarray 4	java/lang/Object
          //   76: dup
          //   77: iconst_0
          //   78: iload_1
          //   79: invokestatic 84	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   82: aastore
          //   83: invokestatic 87	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
          //   86: invokestatic 93	com/tencent/mm/plugin/game/model/a/h$a:dWd	()Lcom/tencent/mm/plugin/game/model/a/h;
          //   89: iconst_0
          //   90: invokevirtual 99	com/tencent/mm/plugin/game/model/a/h:pP	(Z)V
          //   93: ldc 13
          //   95: monitorexit
          //   96: ldc 26
          //   98: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   101: return
          //   102: ldc 45
          //   104: ldc 101
          //   106: iconst_1
          //   107: anewarray 4	java/lang/Object
          //   110: dup
          //   111: iconst_0
          //   112: iload_1
          //   113: invokestatic 84	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   116: aastore
          //   117: invokestatic 87	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
          //   120: invokestatic 93	com/tencent/mm/plugin/game/model/a/h$a:dWd	()Lcom/tencent/mm/plugin/game/model/a/h;
          //   123: pop
          //   124: invokestatic 104	com/tencent/mm/plugin/game/model/a/h:pauseDownload	()V
          //   127: goto -34 -> 93
          //   130: astore_2
          //   131: ldc 13
          //   133: monitorexit
          //   134: ldc 26
          //   136: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   139: aload_2
          //   140: athrow
          // Local variable table:
          //   start	length	slot	name	signature
          //   0	141	0	this	1
          //   42	71	1	i	int
          //   130	10	2	localObject	Object
          // Exception table:
          //   from	to	target	type
          //   8	20	130	finally
          //   20	30	130	finally
          //   36	53	130	finally
          //   59	64	130	finally
          //   68	93	130	finally
          //   93	96	130	finally
          //   102	127	130	finally
          //   131	134	130	finally
        }
      });
      AppMethodBeat.o(41679);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.a.e
 * JD-Core Version:    0.7.0.1
 */