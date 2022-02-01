package com.tencent.mm.booter;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.oz;
import com.tencent.mm.kernel.k;
import com.tencent.mm.network.ad;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ap;

@k
public class MMReceivers$AlarmReceiver
  extends BroadcastReceiver
{
  private static void a(long paramLong, Context paramContext)
  {
    AppMethodBeat.i(131885);
    ac.w("MicroMsg.AlarmReceiver", "reset bumper, interval=".concat(String.valueOf(paramLong)));
    com.tencent.mm.a.a.set(paramContext, 109, 0, System.currentTimeMillis() + paramLong, new Intent(paramContext, AlarmReceiver.class).putExtra("MMBoot_Bump", true), 268435456);
    AppMethodBeat.o(131885);
  }
  
  public static void bL(Context paramContext)
  {
    long l1 = 30000L;
    AppMethodBeat.i(131884);
    long l2 = ag.eUS();
    ac.d("MicroMsg.AlarmReceiver", "bumper comes, next=".concat(String.valueOf(l2)));
    if (l2 > 1860000L)
    {
      AppMethodBeat.o(131884);
      return;
    }
    if (l2 < 30000L) {}
    for (;;)
    {
      a(l1, paramContext);
      AppMethodBeat.o(131884);
      return;
      l1 = l2;
    }
  }
  
  public static void bM(Context paramContext)
  {
    AppMethodBeat.i(131886);
    PendingIntent localPendingIntent = com.tencent.mm.a.a.b(paramContext, 109, new Intent(paramContext, AlarmReceiver.class).putExtra("MMBoot_Bump", true));
    if (localPendingIntent != null)
    {
      com.tencent.mm.a.a.cancel(paramContext, 109, localPendingIntent);
      localPendingIntent.cancel();
    }
    AppMethodBeat.o(131886);
  }
  
  public static void bN(Context paramContext)
  {
    AppMethodBeat.i(131887);
    ac.w("MicroMsg.AlarmReceiver", "keep awaker");
    if (ad.aMa()) {}
    for (int i = 300000;; i = 900000)
    {
      com.tencent.mm.a.a.a(paramContext, 110, 0, System.currentTimeMillis() + i, i, new Intent(paramContext, AlarmReceiver.class));
      AppMethodBeat.o(131887);
      return;
    }
  }
  
  public static void bO(Context paramContext)
  {
    AppMethodBeat.i(131888);
    ac.w("MicroMsg.AlarmReceiver", "stop awaker");
    PendingIntent localPendingIntent = com.tencent.mm.a.a.b(paramContext, 110, new Intent(paramContext, AlarmReceiver.class));
    if (localPendingIntent != null)
    {
      com.tencent.mm.a.a.cancel(paramContext, 110, localPendingIntent);
      localPendingIntent.cancel();
    }
    AppMethodBeat.o(131888);
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(131883);
    if ((paramContext == null) || (paramIntent == null))
    {
      AppMethodBeat.o(131883);
      return;
    }
    if (!com.tencent.mm.kernel.a.Zc().getBoolean("keepaliveserviceswitch", false))
    {
      ac.i("MicroMsg.AlarmReceiver", "onReceive() MMHandlerThread() publish PushKeepAliveEvent");
      ap.n(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(131882);
          oz localoz = new oz();
          com.tencent.mm.sdk.b.a.GpY.a(localoz, Looper.getMainLooper());
          ac.i("MicroMsg.AlarmReceiver", "onReceive() publish PushKeepAliveEvent");
          AppMethodBeat.o(131882);
        }
      }, 10000L);
    }
    boolean bool = paramIntent.getBooleanExtra("MMBoot_Bump", false);
    ac.i("MicroMsg.AlarmReceiver", "[ALARM NOTIFICATION] bump:".concat(String.valueOf(bool)));
    if (bool)
    {
      bL(paramContext);
      AppMethodBeat.o(131883);
      return;
    }
    if (!b.c(paramContext, "alarm", true))
    {
      bO(paramContext);
      ac.eUQ();
    }
    AppMethodBeat.o(131883);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.booter.MMReceivers.AlarmReceiver
 * JD-Core Version:    0.7.0.1
 */