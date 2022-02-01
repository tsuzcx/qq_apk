package com.tencent.mm.booter;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.a;
import com.tencent.mm.autogen.a.so;
import com.tencent.mm.kernel.m;
import com.tencent.mm.network.ag;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MAlarmHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;

@m
public class MMReceivers$AlarmReceiver
  extends BroadcastReceiver
{
  private static void a(long paramLong, Context paramContext)
  {
    AppMethodBeat.i(131885);
    Log.w("MicroMsg.AlarmReceiver", "reset bumper, interval=".concat(String.valueOf(paramLong)));
    a.set(paramContext, 109, 0, System.currentTimeMillis() + paramLong, new Intent(paramContext, AlarmReceiver.class).putExtra("MMBoot_Bump", true), 268435456);
    AppMethodBeat.o(131885);
  }
  
  public static void cP(Context paramContext)
  {
    long l1 = 30000L;
    AppMethodBeat.i(131884);
    long l2 = MAlarmHandler.fire();
    Log.d("MicroMsg.AlarmReceiver", "bumper comes, next=".concat(String.valueOf(l2)));
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
  
  public static void cQ(Context paramContext)
  {
    AppMethodBeat.i(131886);
    PendingIntent localPendingIntent = a.b(paramContext, 109, new Intent(paramContext, AlarmReceiver.class).putExtra("MMBoot_Bump", true));
    if (localPendingIntent != null)
    {
      a.cancel(paramContext, 109, localPendingIntent);
      localPendingIntent.cancel();
    }
    AppMethodBeat.o(131886);
  }
  
  public static void cR(Context paramContext)
  {
    AppMethodBeat.i(131887);
    Log.w("MicroMsg.AlarmReceiver", "keep awaker");
    if (ag.bRt()) {}
    for (int i = 300000;; i = 900000)
    {
      a.a(paramContext, 110, 0, System.currentTimeMillis() + i, i, new Intent(paramContext, AlarmReceiver.class));
      AppMethodBeat.o(131887);
      return;
    }
  }
  
  public static void cS(Context paramContext)
  {
    AppMethodBeat.i(131888);
    Log.w("MicroMsg.AlarmReceiver", "stop awaker");
    PendingIntent localPendingIntent = a.b(paramContext, 110, new Intent(paramContext, AlarmReceiver.class));
    if (localPendingIntent != null)
    {
      a.cancel(paramContext, 110, localPendingIntent);
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
    if (!com.tencent.mm.kernel.b.aQC().getBoolean("keepaliveserviceswitch", false))
    {
      Log.i("MicroMsg.AlarmReceiver", "onReceive() MMHandlerThread() publish PushKeepAliveEvent");
      MMHandlerThread.postToMainThreadDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(131882);
          new so().asyncPublish(Looper.getMainLooper());
          Log.i("MicroMsg.AlarmReceiver", "onReceive() publish PushKeepAliveEvent");
          AppMethodBeat.o(131882);
        }
      }, 10000L);
    }
    boolean bool = paramIntent.getBooleanExtra("MMBoot_Bump", false);
    Log.i("MicroMsg.AlarmReceiver", "[ALARM NOTIFICATION] bump:".concat(String.valueOf(bool)));
    if (bool)
    {
      cP(paramContext);
      AppMethodBeat.o(131883);
      return;
    }
    if (!b.c(paramContext, "alarm", true))
    {
      cS(paramContext);
      Log.appenderFlush();
    }
    AppMethodBeat.o(131883);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.booter.MMReceivers.AlarmReceiver
 * JD-Core Version:    0.7.0.1
 */