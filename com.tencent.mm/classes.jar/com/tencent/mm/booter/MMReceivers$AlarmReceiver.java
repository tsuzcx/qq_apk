package com.tencent.mm.booter;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.network.aa;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.y;

public class MMReceivers$AlarmReceiver
  extends BroadcastReceiver
{
  public static void aT(Context paramContext)
  {
    long l2 = ac.cqN();
    y.d("MicroMsg.AlarmReceiver", "bumper comes, next=" + l2);
    if (l2 > 1860000L) {
      return;
    }
    long l1 = l2;
    if (l2 < 30000L) {
      l1 = 30000L;
    }
    y.w("MicroMsg.AlarmReceiver", "reset bumper, interval=" + l1);
    AlarmManager localAlarmManager = (AlarmManager)paramContext.getSystemService("alarm");
    if (localAlarmManager == null)
    {
      y.e("MicroMsg.AlarmReceiver", "keep bumper failed, null am");
      return;
    }
    paramContext = PendingIntent.getBroadcast(paramContext, 1, new Intent(paramContext, AlarmReceiver.class).putExtra("MMBoot_Bump", true), 268435456);
    localAlarmManager.set(0, l1 + System.currentTimeMillis(), paramContext);
  }
  
  public static void aU(Context paramContext)
  {
    AlarmManager localAlarmManager = (AlarmManager)paramContext.getSystemService("alarm");
    if (localAlarmManager == null) {
      y.e("MicroMsg.AlarmReceiver", "stop bumper failed, null am");
    }
    do
    {
      return;
      paramContext = PendingIntent.getBroadcast(paramContext, 1, new Intent(paramContext, AlarmReceiver.class).putExtra("MMBoot_Bump", true), 536870912);
    } while (paramContext == null);
    localAlarmManager.cancel(paramContext);
    paramContext.cancel();
  }
  
  public static void aV(Context paramContext)
  {
    y.w("MicroMsg.AlarmReceiver", "keep awaker");
    AlarmManager localAlarmManager = (AlarmManager)paramContext.getSystemService("alarm");
    if (localAlarmManager == null)
    {
      y.e("MicroMsg.AlarmReceiver", "keep awaker failed, null am");
      return;
    }
    if (aa.Up()) {}
    for (int i = 300000;; i = 900000)
    {
      paramContext = PendingIntent.getBroadcast(paramContext, 0, new Intent(paramContext, AlarmReceiver.class), 268435456);
      localAlarmManager.setRepeating(0, System.currentTimeMillis() + i, i, paramContext);
      return;
    }
  }
  
  public static void aW(Context paramContext)
  {
    y.w("MicroMsg.AlarmReceiver", "stop awaker");
    AlarmManager localAlarmManager = (AlarmManager)paramContext.getSystemService("alarm");
    if (localAlarmManager == null) {
      y.e("MicroMsg.AlarmReceiver", "keep awaker failed, null am");
    }
    do
    {
      return;
      paramContext = PendingIntent.getBroadcast(paramContext, 0, new Intent(paramContext, AlarmReceiver.class), 536870912);
    } while (paramContext == null);
    localAlarmManager.cancel(paramContext);
    paramContext.cancel();
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((paramContext == null) || (paramIntent == null)) {}
    do
    {
      return;
      boolean bool = paramIntent.getBooleanExtra("MMBoot_Bump", false);
      y.i("MicroMsg.AlarmReceiver", "[ALARM NOTIFICATION] bump:" + bool);
      if (bool)
      {
        aT(paramContext);
        return;
      }
    } while (b.s(paramContext, "alarm"));
    aW(paramContext);
    y.cqL();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.booter.MMReceivers.AlarmReceiver
 * JD-Core Version:    0.7.0.1
 */