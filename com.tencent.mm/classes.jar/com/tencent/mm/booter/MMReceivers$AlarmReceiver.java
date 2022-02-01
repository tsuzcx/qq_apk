package com.tencent.mm.booter;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.k;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.aq;

@k
public class MMReceivers$AlarmReceiver
  extends BroadcastReceiver
{
  private static void a(long paramLong, Context paramContext)
  {
    AppMethodBeat.i(131885);
    com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.AlarmReceiver", "reset bumper, interval=".concat(String.valueOf(paramLong)));
    com.tencent.mm.a.a.set(paramContext, 109, 0, System.currentTimeMillis() + paramLong, new Intent(paramContext, AlarmReceiver.class).putExtra("MMBoot_Bump", true), 268435456);
    AppMethodBeat.o(131885);
  }
  
  public static void bK(Context paramContext)
  {
    long l1 = 30000L;
    AppMethodBeat.i(131884);
    long l2 = ah.fkx();
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.AlarmReceiver", "bumper comes, next=".concat(String.valueOf(l2)));
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
  
  public static void bL(Context paramContext)
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
  
  public static void bM(Context paramContext)
  {
    AppMethodBeat.i(131887);
    com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.AlarmReceiver", "keep awaker");
    if (com.tencent.mm.network.ad.aPh()) {}
    for (int i = 300000;; i = 900000)
    {
      com.tencent.mm.a.a.a(paramContext, 110, 0, System.currentTimeMillis() + i, i, new Intent(paramContext, AlarmReceiver.class));
      AppMethodBeat.o(131887);
      return;
    }
  }
  
  public static void bN(Context paramContext)
  {
    AppMethodBeat.i(131888);
    com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.AlarmReceiver", "stop awaker");
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
    if (!com.tencent.mm.kernel.a.abC().getBoolean("keepaliveserviceswitch", false))
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AlarmReceiver", "onReceive() MMHandlerThread() publish PushKeepAliveEvent");
      aq.o(new MMReceivers.AlarmReceiver.1(this), 10000L);
    }
    boolean bool = paramIntent.getBooleanExtra("MMBoot_Bump", false);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AlarmReceiver", "[ALARM NOTIFICATION] bump:".concat(String.valueOf(bool)));
    if (bool)
    {
      bK(paramContext);
      AppMethodBeat.o(131883);
      return;
    }
    if (!b.c(paramContext, "alarm", true))
    {
      bN(paramContext);
      com.tencent.mm.sdk.platformtools.ad.fku();
    }
    AppMethodBeat.o(131883);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.booter.MMReceivers.AlarmReceiver
 * JD-Core Version:    0.7.0.1
 */