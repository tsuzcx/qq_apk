package com.tencent.mm.plugin.game.model.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.n.a;
import com.tencent.mm.g.a.ik;
import com.tencent.mm.g.a.il;
import com.tencent.mm.g.a.il.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;

public class e
{
  private static n.a appForegroundListener;
  private static int pnk;
  private static b ueL;
  private static a ueM;
  private static c ueN;
  private static com.tencent.mm.sdk.b.c ueO;
  private static com.tencent.mm.sdk.b.c ueP;
  
  static
  {
    AppMethodBeat.i(41682);
    pnk = -1;
    appForegroundListener = new n.a()
    {
      public final void onAppBackground(String paramAnonymousString)
      {
        AppMethodBeat.i(41674);
        if ((com.tencent.mm.kernel.g.ajx()) && (com.tencent.mm.kernel.g.ajA().gAD))
        {
          com.tencent.mm.kernel.g.ajA();
          if (!com.tencent.mm.kernel.a.aiE())
          {
            paramAnonymousString = new il();
            paramAnonymousString.duX.dkM = 1;
            com.tencent.mm.sdk.b.a.IbL.l(paramAnonymousString);
          }
        }
        AppMethodBeat.o(41674);
      }
      
      public final void onAppForeground(String paramAnonymousString)
      {
        AppMethodBeat.i(41673);
        if ((com.tencent.mm.kernel.g.ajx()) && (com.tencent.mm.kernel.g.ajA().gAD))
        {
          com.tencent.mm.kernel.g.ajA();
          if (!com.tencent.mm.kernel.a.aiE())
          {
            paramAnonymousString = new il();
            paramAnonymousString.duX.dkM = 2;
            com.tencent.mm.sdk.b.a.IbL.l(paramAnonymousString);
          }
        }
        AppMethodBeat.o(41673);
      }
    };
    ueO = new com.tencent.mm.sdk.b.c()
    {
      private static boolean a(il paramAnonymousil)
      {
        AppMethodBeat.i(41675);
        switch (paramAnonymousil.duX.dkM)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(41675);
          return false;
          if (bt.rM(bt.g((Long)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.IAh, Long.valueOf(0L)))) > 600L)
          {
            com.tencent.mm.kernel.g.ajC().ajl().set(al.a.IAh, Long.valueOf(bt.aQJ()));
            h.a.cZL().nf(false);
            continue;
            paramAnonymousil = paramAnonymousil.duX.duW;
            if (bt.isNullOrNil(paramAnonymousil))
            {
              ad.i("MicroMsg.GameSilentDownloadStorage", "deleteAllItem ret:%b", new Object[] { Boolean.valueOf(((com.tencent.mm.plugin.game.api.f)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.f.class)).cWJ().execSQL("GameSilentDownload", String.format("delete from %s", new Object[] { "GameSilentDownload" }))) });
            }
            else
            {
              Object localObject = new d();
              ((d)localObject).field_appId = paramAnonymousil;
              ((com.tencent.mm.plugin.game.api.f)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.f.class)).cWJ().delete((com.tencent.mm.sdk.e.c)localObject, new String[0]);
              ad.i("MicroMsg.GameSilentDownloadListener", "delete silent download, appid:%s", new Object[] { paramAnonymousil });
              continue;
              paramAnonymousil = paramAnonymousil.duX.duW;
              if (!bt.isNullOrNil(paramAnonymousil))
              {
                localObject = com.tencent.mm.plugin.downloader.model.d.aad(paramAnonymousil);
                if (localObject != null)
                {
                  long l = ((com.tencent.mm.plugin.downloader.g.a)localObject).field_downloadId;
                  com.tencent.mm.plugin.downloader.model.f.ccl().tR(l);
                  com.tencent.mm.plugin.downloader.model.d.ub(((com.tencent.mm.plugin.downloader.g.a)localObject).field_downloadId);
                  ad.i("MicroMsg.GameSilentDownload.GameDownloadHelper", "delete downloadInfo in DB. appId:%s", new Object[] { paramAnonymousil });
                }
              }
            }
          }
        }
      }
    };
    ueP = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(41682);
  }
  
  public static void ccd()
  {
    AppMethodBeat.i(41680);
    try
    {
      if (ueL == null) {
        ueL = new b((byte)0);
      }
      localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.net.wifi.STATE_CHANGE");
      localIntentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
      localIntentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
      aj.getContext().registerReceiver(ueL, localIntentFilter);
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        IntentFilter localIntentFilter;
        label107:
        ad.i("MicroMsg.GameSilentDownloadListener", "registerNetChange err:%s", new Object[] { localException1.getMessage() });
      }
    }
    try
    {
      if (ueM == null) {
        ueM = new a((byte)0);
      }
      localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.intent.action.BATTERY_OKAY");
      localIntentFilter.addAction("android.intent.action.BATTERY_LOW");
      aj.getContext().registerReceiver(ueM, localIntentFilter);
    }
    catch (Exception localException2)
    {
      ad.i("MicroMsg.GameSilentDownloadListener", "registerBatteryChange err:%s", new Object[] { localException2.getMessage() });
      break label107;
    }
    appForegroundListener.alive();
    com.tencent.mm.sdk.b.a.IbL.c(ueO);
    com.tencent.mm.sdk.b.a.IbL.c(ueP);
    if (ueN == null) {
      ueN = new c();
    }
    com.tencent.mm.plugin.downloader.model.f.ccl();
    com.tencent.mm.plugin.downloader.model.c.a(ueN);
    AppMethodBeat.o(41680);
  }
  
  public static void cce()
  {
    AppMethodBeat.i(41681);
    appForegroundListener.dead();
    if (ueL != null) {}
    try
    {
      aj.getContext().unregisterReceiver(ueL);
      ueL = null;
      if (ueM == null) {}
    }
    catch (Exception localException1)
    {
      try
      {
        aj.getContext().unregisterReceiver(ueM);
        ueM = null;
        com.tencent.mm.sdk.b.a.IbL.d(ueO);
        com.tencent.mm.sdk.b.a.IbL.d(ueP);
        if (ueN != null)
        {
          com.tencent.mm.plugin.downloader.model.f.ccl();
          com.tencent.mm.plugin.downloader.model.c.b(ueN);
          ueN = null;
        }
        AppMethodBeat.o(41681);
        return;
        localException1 = localException1;
        ad.i("MicroMsg.GameSilentDownloadListener", "unregisterNetChange err:%s", new Object[] { localException1.getMessage() });
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          ad.i("MicroMsg.GameSilentDownloadListener", "unregisterBatteryChange err:%s", new Object[] { localException2.getMessage() });
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
      if ((!com.tencent.mm.kernel.g.ajx()) || (com.tencent.mm.kernel.a.aiE()))
      {
        ad.e("MicroMsg.GameSilentDownloadListener", "acc has not ready");
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
        ad.i("MicroMsg.GameSilentDownloadListener", "batteryChange: ACTION_BATTERY_OKAY, checkDownload");
        h.a.cZL().nf(true);
        AppMethodBeat.o(41678);
        return;
      }
      if ("android.intent.action.BATTERY_LOW".equals(paramIntent.getAction()))
      {
        ad.i("MicroMsg.GameSilentDownloadListener", "batteryChange: ACTION_BATTERY_LOW, pauseDownload");
        h.a.cZL();
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
      com.tencent.e.h.LTJ.aR(new Runnable()
      {
        /* Error */
        public final void run()
        {
          // Byte code:
          //   0: ldc 26
          //   2: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
          //   5: ldc 13
          //   7: monitorenter
          //   8: invokestatic 38	com/tencent/mm/kernel/g:ajx	()Z
          //   11: ifeq +9 -> 20
          //   14: invokestatic 43	com/tencent/mm/kernel/a:aiE	()Z
          //   17: ifeq +19 -> 36
          //   20: ldc 45
          //   22: ldc 47
          //   24: invokestatic 53	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
          //   27: ldc 13
          //   29: monitorexit
          //   30: ldc 26
          //   32: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   35: return
          //   36: invokestatic 62	com/tencent/mm/sdk/platformtools/aj:getContext	()Landroid/content/Context;
          //   39: invokestatic 68	com/tencent/mm/sdk/platformtools/ay:getNetType	(Landroid/content/Context;)I
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
          //   60: invokestatic 76	com/tencent/mm/plugin/game/model/a/e:he	(I)I
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
          //   83: invokestatic 87	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
          //   86: invokestatic 93	com/tencent/mm/plugin/game/model/a/h$a:cZL	()Lcom/tencent/mm/plugin/game/model/a/h;
          //   89: iconst_0
          //   90: invokevirtual 99	com/tencent/mm/plugin/game/model/a/h:nf	(Z)V
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
          //   117: invokestatic 87	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
          //   120: invokestatic 93	com/tencent/mm/plugin/game/model/a/h$a:cZL	()Lcom/tencent/mm/plugin/game/model/a/h;
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