package com.tencent.mm.plugin.game.model.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.o.a;
import com.tencent.mm.g.a.il;
import com.tencent.mm.g.a.im;
import com.tencent.mm.g.a.im.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;

public class e
{
  private static o.a appForegroundListener;
  private static int ptR;
  private static b upS;
  private static a upT;
  private static c upU;
  private static com.tencent.mm.sdk.b.c upV;
  private static com.tencent.mm.sdk.b.c upW;
  
  static
  {
    AppMethodBeat.i(41682);
    ptR = -1;
    appForegroundListener = new o.a()
    {
      public final void onAppBackground(String paramAnonymousString)
      {
        AppMethodBeat.i(41674);
        if ((com.tencent.mm.kernel.g.ajM()) && (com.tencent.mm.kernel.g.ajP().gDk))
        {
          com.tencent.mm.kernel.g.ajP();
          if (!com.tencent.mm.kernel.a.aiT())
          {
            paramAnonymousString = new im();
            paramAnonymousString.dwc.dlO = 1;
            com.tencent.mm.sdk.b.a.IvT.l(paramAnonymousString);
          }
        }
        AppMethodBeat.o(41674);
      }
      
      public final void onAppForeground(String paramAnonymousString)
      {
        AppMethodBeat.i(41673);
        if ((com.tencent.mm.kernel.g.ajM()) && (com.tencent.mm.kernel.g.ajP().gDk))
        {
          com.tencent.mm.kernel.g.ajP();
          if (!com.tencent.mm.kernel.a.aiT())
          {
            paramAnonymousString = new im();
            paramAnonymousString.dwc.dlO = 2;
            com.tencent.mm.sdk.b.a.IvT.l(paramAnonymousString);
          }
        }
        AppMethodBeat.o(41673);
      }
    };
    upV = new com.tencent.mm.sdk.b.c()
    {
      private static boolean a(im paramAnonymousim)
      {
        AppMethodBeat.i(41675);
        switch (paramAnonymousim.dwc.dlO)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(41675);
          return false;
          if (bu.rZ(bu.i((Long)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IUG, Long.valueOf(0L)))) > 600L)
          {
            com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IUG, Long.valueOf(bu.aRi()));
            h.a.dcw().nj(false);
            continue;
            paramAnonymousim = paramAnonymousim.dwc.dwb;
            if (bu.isNullOrNil(paramAnonymousim))
            {
              ae.i("MicroMsg.GameSilentDownloadStorage", "deleteAllItem ret:%b", new Object[] { Boolean.valueOf(((com.tencent.mm.plugin.game.api.f)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.f.class)).cZn().execSQL("GameSilentDownload", String.format("delete from %s", new Object[] { "GameSilentDownload" }))) });
            }
            else
            {
              Object localObject = new d();
              ((d)localObject).field_appId = paramAnonymousim;
              ((com.tencent.mm.plugin.game.api.f)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.f.class)).cZn().delete((com.tencent.mm.sdk.e.c)localObject, new String[0]);
              ae.i("MicroMsg.GameSilentDownloadListener", "delete silent download, appid:%s", new Object[] { paramAnonymousim });
              continue;
              paramAnonymousim = paramAnonymousim.dwc.dwb;
              if (!bu.isNullOrNil(paramAnonymousim))
              {
                localObject = com.tencent.mm.plugin.downloader.model.d.aaU(paramAnonymousim);
                if (localObject != null)
                {
                  long l = ((com.tencent.mm.plugin.downloader.g.a)localObject).field_downloadId;
                  com.tencent.mm.plugin.downloader.model.f.cdA().ui(l);
                  com.tencent.mm.plugin.downloader.model.d.us(((com.tencent.mm.plugin.downloader.g.a)localObject).field_downloadId);
                  ae.i("MicroMsg.GameSilentDownload.GameDownloadHelper", "delete downloadInfo in DB. appId:%s", new Object[] { paramAnonymousim });
                }
              }
            }
          }
        }
      }
    };
    upW = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(41682);
  }
  
  public static void cds()
  {
    AppMethodBeat.i(41680);
    try
    {
      if (upS == null) {
        upS = new b((byte)0);
      }
      localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.net.wifi.STATE_CHANGE");
      localIntentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
      localIntentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
      ak.getContext().registerReceiver(upS, localIntentFilter);
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        IntentFilter localIntentFilter;
        label107:
        ae.i("MicroMsg.GameSilentDownloadListener", "registerNetChange err:%s", new Object[] { localException1.getMessage() });
      }
    }
    try
    {
      if (upT == null) {
        upT = new a((byte)0);
      }
      localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.intent.action.BATTERY_OKAY");
      localIntentFilter.addAction("android.intent.action.BATTERY_LOW");
      ak.getContext().registerReceiver(upT, localIntentFilter);
    }
    catch (Exception localException2)
    {
      ae.i("MicroMsg.GameSilentDownloadListener", "registerBatteryChange err:%s", new Object[] { localException2.getMessage() });
      break label107;
    }
    appForegroundListener.alive();
    com.tencent.mm.sdk.b.a.IvT.c(upV);
    com.tencent.mm.sdk.b.a.IvT.c(upW);
    if (upU == null) {
      upU = new c();
    }
    com.tencent.mm.plugin.downloader.model.f.cdA();
    com.tencent.mm.plugin.downloader.model.c.a(upU);
    AppMethodBeat.o(41680);
  }
  
  public static void cdt()
  {
    AppMethodBeat.i(41681);
    appForegroundListener.dead();
    if (upS != null) {}
    try
    {
      ak.getContext().unregisterReceiver(upS);
      upS = null;
      if (upT == null) {}
    }
    catch (Exception localException1)
    {
      try
      {
        ak.getContext().unregisterReceiver(upT);
        upT = null;
        com.tencent.mm.sdk.b.a.IvT.d(upV);
        com.tencent.mm.sdk.b.a.IvT.d(upW);
        if (upU != null)
        {
          com.tencent.mm.plugin.downloader.model.f.cdA();
          com.tencent.mm.plugin.downloader.model.c.b(upU);
          upU = null;
        }
        AppMethodBeat.o(41681);
        return;
        localException1 = localException1;
        ae.i("MicroMsg.GameSilentDownloadListener", "unregisterNetChange err:%s", new Object[] { localException1.getMessage() });
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          ae.i("MicroMsg.GameSilentDownloadListener", "unregisterBatteryChange err:%s", new Object[] { localException2.getMessage() });
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
      if ((!com.tencent.mm.kernel.g.ajM()) || (com.tencent.mm.kernel.a.aiT()))
      {
        ae.e("MicroMsg.GameSilentDownloadListener", "acc has not ready");
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
        ae.i("MicroMsg.GameSilentDownloadListener", "batteryChange: ACTION_BATTERY_OKAY, checkDownload");
        h.a.dcw().nj(true);
        AppMethodBeat.o(41678);
        return;
      }
      if ("android.intent.action.BATTERY_LOW".equals(paramIntent.getAction()))
      {
        ae.i("MicroMsg.GameSilentDownloadListener", "batteryChange: ACTION_BATTERY_LOW, pauseDownload");
        h.a.dcw();
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
      com.tencent.e.h.MqF.aO(new Runnable()
      {
        /* Error */
        public final void run()
        {
          // Byte code:
          //   0: ldc 26
          //   2: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
          //   5: ldc 13
          //   7: monitorenter
          //   8: invokestatic 38	com/tencent/mm/kernel/g:ajM	()Z
          //   11: ifeq +9 -> 20
          //   14: invokestatic 43	com/tencent/mm/kernel/a:aiT	()Z
          //   17: ifeq +19 -> 36
          //   20: ldc 45
          //   22: ldc 47
          //   24: invokestatic 53	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;)V
          //   27: ldc 13
          //   29: monitorexit
          //   30: ldc 26
          //   32: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   35: return
          //   36: invokestatic 62	com/tencent/mm/sdk/platformtools/ak:getContext	()Landroid/content/Context;
          //   39: invokestatic 68	com/tencent/mm/sdk/platformtools/az:getNetType	(Landroid/content/Context;)I
          //   42: istore_1
          //   43: iload_1
          //   44: invokestatic 72	com/tencent/mm/plugin/game/model/a/e:access$200	()I
          //   47: if_icmpne +12 -> 59
          //   50: ldc 13
          //   52: monitorexit
          //   53: ldc 26
          //   55: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   58: return
          //   59: iload_1
          //   60: invokestatic 76	com/tencent/mm/plugin/game/model/a/e:hf	(I)I
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
          //   83: invokestatic 87	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
          //   86: invokestatic 93	com/tencent/mm/plugin/game/model/a/h$a:dcw	()Lcom/tencent/mm/plugin/game/model/a/h;
          //   89: iconst_0
          //   90: invokevirtual 99	com/tencent/mm/plugin/game/model/a/h:nj	(Z)V
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
          //   117: invokestatic 87	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
          //   120: invokestatic 93	com/tencent/mm/plugin/game/model/a/h$a:dcw	()Lcom/tencent/mm/plugin/game/model/a/h;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.a.e
 * JD-Core Version:    0.7.0.1
 */