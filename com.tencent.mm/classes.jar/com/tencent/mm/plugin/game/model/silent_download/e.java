package com.tencent.mm.plugin.game.model.silent_download;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.q.a;
import com.tencent.mm.autogen.a.kt;
import com.tencent.mm.kernel.b;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.threadpool.i;

public class e
{
  private static b IGu;
  private static a IGv;
  private static c IGw;
  private static IListener IGx;
  private static IListener IGy;
  private static q.a appForegroundListener;
  private static int xoE;
  
  static
  {
    AppMethodBeat.i(41682);
    xoE = -1;
    appForegroundListener = new q.a()
    {
      public final void onAppBackground(String paramAnonymousString)
      {
        AppMethodBeat.i(41674);
        if ((com.tencent.mm.kernel.h.baz()) && (com.tencent.mm.kernel.h.baC().mBZ))
        {
          com.tencent.mm.kernel.h.baC();
          if (!b.aZG())
          {
            paramAnonymousString = new kt();
            paramAnonymousString.hMr.hAf = 1;
            paramAnonymousString.publish();
          }
        }
        AppMethodBeat.o(41674);
      }
      
      public final void onAppForeground(String paramAnonymousString)
      {
        AppMethodBeat.i(41673);
        if ((com.tencent.mm.kernel.h.baz()) && (com.tencent.mm.kernel.h.baC().mBZ))
        {
          com.tencent.mm.kernel.h.baC();
          if (!b.aZG())
          {
            paramAnonymousString = new kt();
            paramAnonymousString.hMr.hAf = 2;
            paramAnonymousString.publish();
          }
        }
        AppMethodBeat.o(41673);
      }
    };
    IGx = new GameSilentDownloadListener.2(com.tencent.mm.app.f.hfK);
    IGy = new GameSilentDownloadListener.3(com.tencent.mm.app.f.hfK);
    AppMethodBeat.o(41682);
  }
  
  public static void cuD()
  {
    AppMethodBeat.i(41681);
    appForegroundListener.dead();
    if (IGu != null) {}
    try
    {
      MMApplicationContext.getContext().unregisterReceiver(IGu);
      IGu = null;
      if (IGv == null) {}
    }
    catch (Exception localException1)
    {
      try
      {
        MMApplicationContext.getContext().unregisterReceiver(IGv);
        IGv = null;
        IGx.dead();
        IGy.dead();
        if (IGw != null)
        {
          com.tencent.mm.plugin.downloader.model.f.duv();
          com.tencent.mm.plugin.downloader.model.c.b(IGw);
          IGw = null;
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
  
  public static void duo()
  {
    AppMethodBeat.i(41680);
    try
    {
      if (IGu == null) {
        IGu = new b((byte)0);
      }
      localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.net.wifi.STATE_CHANGE");
      localIntentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
      localIntentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
      MMApplicationContext.getContext().registerReceiver(IGu, localIntentFilter);
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
      if (IGv == null) {
        IGv = new a((byte)0);
      }
      localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.intent.action.BATTERY_OKAY");
      localIntentFilter.addAction("android.intent.action.BATTERY_LOW");
      MMApplicationContext.getContext().registerReceiver(IGv, localIntentFilter);
    }
    catch (Exception localException2)
    {
      Log.i("MicroMsg.GameSilentDownloadListener", "registerBatteryChange err:%s", new Object[] { localException2.getMessage() });
      break label107;
    }
    appForegroundListener.alive();
    IGx.alive();
    IGy.alive();
    if (IGw == null) {
      IGw = new c();
    }
    com.tencent.mm.plugin.downloader.model.f.duv();
    com.tencent.mm.plugin.downloader.model.c.a(IGw);
    AppMethodBeat.o(41680);
  }
  
  static final class a
    extends BroadcastReceiver
  {
    public final void onReceive(Context paramContext, Intent paramIntent)
    {
      AppMethodBeat.i(41678);
      if ((!com.tencent.mm.kernel.h.baz()) || (b.aZG()))
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
        h.a.fHh().ws(true);
        AppMethodBeat.o(41678);
        return;
      }
      if ("android.intent.action.BATTERY_LOW".equals(paramIntent.getAction()))
      {
        Log.i("MicroMsg.GameSilentDownloadListener", "batteryChange: ACTION_BATTERY_LOW, pauseDownload");
        h.a.fHh();
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
      com.tencent.threadpool.h.ahAA.bm(new Runnable()
      {
        /* Error */
        public final void run()
        {
          // Byte code:
          //   0: ldc 26
          //   2: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
          //   5: ldc 13
          //   7: monitorenter
          //   8: invokestatic 38	com/tencent/mm/kernel/h:baz	()Z
          //   11: ifeq +9 -> 20
          //   14: invokestatic 43	com/tencent/mm/kernel/b:aZG	()Z
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
          //   44: invokestatic 72	com/tencent/mm/plugin/game/model/silent_download/e:access$200	()I
          //   47: if_icmpne +12 -> 59
          //   50: ldc 13
          //   52: monitorexit
          //   53: ldc 26
          //   55: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   58: return
          //   59: iload_1
          //   60: invokestatic 76	com/tencent/mm/plugin/game/model/silent_download/e:nB	(I)I
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
          //   86: invokestatic 93	com/tencent/mm/plugin/game/model/silent_download/h$a:fHh	()Lcom/tencent/mm/plugin/game/model/silent_download/h;
          //   89: iconst_0
          //   90: invokevirtual 99	com/tencent/mm/plugin/game/model/silent_download/h:ws	(Z)V
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
          //   120: invokestatic 93	com/tencent/mm/plugin/game/model/silent_download/h$a:fHh	()Lcom/tencent/mm/plugin/game/model/silent_download/h;
          //   123: pop
          //   124: invokestatic 104	com/tencent/mm/plugin/game/model/silent_download/h:pauseDownload	()V
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
        }
      });
      AppMethodBeat.o(41679);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.silent_download.e
 * JD-Core Version:    0.7.0.1
 */