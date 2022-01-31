package com.tencent.mm.booter;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.k;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.al;

@k
public class MMReceivers$AlarmReceiver
  extends BroadcastReceiver
{
  private static void a(long paramLong, Context paramContext)
  {
    AppMethodBeat.i(57769);
    com.tencent.mm.sdk.platformtools.ab.w("MicroMsg.AlarmReceiver", "reset bumper, interval=".concat(String.valueOf(paramLong)));
    AlarmManager localAlarmManager = (AlarmManager)paramContext.getSystemService("alarm");
    if (localAlarmManager == null)
    {
      com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.AlarmReceiver", "keep bumper failed, null am");
      AppMethodBeat.o(57769);
      return;
    }
    paramContext = PendingIntent.getBroadcast(paramContext, 1, new Intent(paramContext, AlarmReceiver.class).putExtra("MMBoot_Bump", true), 268435456);
    localAlarmManager.set(0, System.currentTimeMillis() + paramLong, paramContext);
    AppMethodBeat.o(57769);
  }
  
  public static void bu(Context paramContext)
  {
    long l1 = 30000L;
    AppMethodBeat.i(57768);
    long l2 = af.dsK();
    com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.AlarmReceiver", "bumper comes, next=".concat(String.valueOf(l2)));
    if (l2 > 1860000L)
    {
      AppMethodBeat.o(57768);
      return;
    }
    if (l2 < 30000L) {}
    for (;;)
    {
      a(l1, paramContext);
      AppMethodBeat.o(57768);
      return;
      l1 = l2;
    }
  }
  
  public static void bv(Context paramContext)
  {
    AppMethodBeat.i(57770);
    AlarmManager localAlarmManager = (AlarmManager)paramContext.getSystemService("alarm");
    if (localAlarmManager == null)
    {
      com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.AlarmReceiver", "stop bumper failed, null am");
      AppMethodBeat.o(57770);
      return;
    }
    paramContext = PendingIntent.getBroadcast(paramContext, 1, new Intent(paramContext, AlarmReceiver.class).putExtra("MMBoot_Bump", true), 536870912);
    if (paramContext != null)
    {
      localAlarmManager.cancel(paramContext);
      paramContext.cancel();
    }
    AppMethodBeat.o(57770);
  }
  
  public static void bw(Context paramContext)
  {
    AppMethodBeat.i(57771);
    com.tencent.mm.sdk.platformtools.ab.w("MicroMsg.AlarmReceiver", "keep awaker");
    AlarmManager localAlarmManager = (AlarmManager)paramContext.getSystemService("alarm");
    if (localAlarmManager == null)
    {
      com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.AlarmReceiver", "keep awaker failed, null am");
      AppMethodBeat.o(57771);
      return;
    }
    if (com.tencent.mm.network.ab.anA()) {}
    for (int i = 300000;; i = 900000)
    {
      paramContext = PendingIntent.getBroadcast(paramContext, 0, new Intent(paramContext, AlarmReceiver.class), 268435456);
      localAlarmManager.setRepeating(0, System.currentTimeMillis() + i, i, paramContext);
      AppMethodBeat.o(57771);
      return;
    }
  }
  
  public static void bx(Context paramContext)
  {
    AppMethodBeat.i(57772);
    com.tencent.mm.sdk.platformtools.ab.w("MicroMsg.AlarmReceiver", "stop awaker");
    AlarmManager localAlarmManager = (AlarmManager)paramContext.getSystemService("alarm");
    if (localAlarmManager == null)
    {
      com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.AlarmReceiver", "keep awaker failed, null am");
      AppMethodBeat.o(57772);
      return;
    }
    paramContext = PendingIntent.getBroadcast(paramContext, 0, new Intent(paramContext, AlarmReceiver.class), 536870912);
    if (paramContext != null)
    {
      localAlarmManager.cancel(paramContext);
      paramContext.cancel();
    }
    AppMethodBeat.o(57772);
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(57767);
    if ((paramContext == null) || (paramIntent == null))
    {
      AppMethodBeat.o(57767);
      return;
    }
    if (!a.Mu().getBoolean("keepaliveserviceswitch", false))
    {
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.AlarmReceiver", "onReceive() MMHandlerThread() publish PushKeepAliveEvent");
      al.p(new MMReceivers.AlarmReceiver.1(this), 10000L);
    }
    boolean bool = paramIntent.getBooleanExtra("MMBoot_Bump", false);
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.AlarmReceiver", "[ALARM NOTIFICATION] bump:".concat(String.valueOf(bool)));
    if (bool)
    {
      bu(paramContext);
      AppMethodBeat.o(57767);
      return;
    }
    if (!b.c(paramContext, "alarm", true))
    {
      bx(paramContext);
      com.tencent.mm.sdk.platformtools.ab.dsI();
    }
    AppMethodBeat.o(57767);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.booter.MMReceivers.AlarmReceiver
 * JD-Core Version:    0.7.0.1
 */