package com.tencent.mm.a;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMStack;
import com.tencent.mm.sdk.platformtools.Util;

public final class a
{
  public static a hbJ = null;
  public static int hbK = 0;
  
  public static PendingIntent a(Context paramContext, int paramInt1, int paramInt2, long paramLong1, long paramLong2, Intent paramIntent)
  {
    AppMethodBeat.i(182034);
    paramContext = b(paramContext, paramInt1, paramInt2, paramLong1, paramLong2, paramIntent);
    AppMethodBeat.o(182034);
    return paramContext;
  }
  
  public static PendingIntent a(Context paramContext, int paramInt1, int paramInt2, long paramLong, Intent paramIntent, int paramInt3, boolean paramBoolean)
  {
    AppMethodBeat.i(185210);
    if (paramIntent != null) {}
    for (Object localObject = paramIntent;; localObject = "null")
    {
      Log.i("MicroMsg.AlarmHelper", "set(type:%s requestCode:%s triggerAtMillis:%s intent:%s flags:%s stack:%s)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), Long.valueOf(paramLong), localObject, Integer.valueOf(paramInt3), aAC() });
      if (paramContext != null) {
        break;
      }
      Log.e("MicroMsg.AlarmHelper", "set(requestCode:%s): context == null", new Object[] { Integer.valueOf(paramInt1) });
      AppMethodBeat.o(185210);
      return null;
    }
    localObject = (AlarmManager)paramContext.getSystemService("alarm");
    if (localObject == null)
    {
      Log.e("MicroMsg.AlarmHelper", "set(requestCode:%s): am == null", new Object[] { Integer.valueOf(paramInt1) });
      AppMethodBeat.o(185210);
      return null;
    }
    if (!isRequestCodeValid(paramInt1))
    {
      Log.e("MicroMsg.AlarmHelper", "set(requestCode:%s): requestCode invalid", new Object[] { Integer.valueOf(paramInt1) });
      AppMethodBeat.o(185210);
      return null;
    }
    if (paramBoolean) {
      paramContext = PendingIntent.getBroadcast(paramContext, paramInt1, paramIntent, paramInt3);
    }
    try
    {
      for (;;)
      {
        paramIntent = c.a(paramInt2, c.a(paramLong, new com.tencent.mm.hellhoundlib.b.a().cG(paramContext)));
        com.tencent.mm.hellhoundlib.a.a.b(localObject, paramIntent.aYi(), "com/tencent/mm/alarm/AlarmHelper", "set", "(Landroid/content/Context;IIJLandroid/content/Intent;IZ)Landroid/app/PendingIntent;", "android/app/AlarmManager_EXEC_", "set", "(IJLandroid/app/PendingIntent;)V");
        ((AlarmManager)localObject).set(((Integer)paramIntent.sb(0)).intValue(), ((Long)c.a(paramIntent).sb(1)).longValue(), (PendingIntent)c.aYk().sb(2));
        com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/alarm/AlarmHelper", "set", "(Landroid/content/Context;IIJLandroid/content/Intent;IZ)Landroid/app/PendingIntent;", "android/app/AlarmManager_EXEC_", "set", "(IJLandroid/app/PendingIntent;)V");
        AppMethodBeat.o(185210);
        return paramContext;
        paramContext = PendingIntent.getActivity(paramContext, paramInt1, paramIntent, paramInt3);
      }
    }
    catch (Exception paramIntent)
    {
      for (;;)
      {
        Log.e("MicroMsg.AlarmHelper", "set Exception:%s %s", new Object[] { paramIntent.getClass().getSimpleName(), paramIntent.getMessage() });
        if (hbJ != null)
        {
          paramIntent = hbJ;
          aAC();
          paramIntent.dn(paramInt1, 1);
        }
      }
    }
  }
  
  public static PendingIntent a(Context paramContext, int paramInt, long paramLong, Intent paramIntent)
  {
    AppMethodBeat.i(186105);
    paramContext = b(paramContext, paramInt, paramLong, paramIntent);
    AppMethodBeat.o(186105);
    return paramContext;
  }
  
  private static PendingIntent a(Context paramContext, int paramInt1, Intent paramIntent, int paramInt2)
  {
    AppMethodBeat.i(182037);
    if (paramIntent != null) {}
    for (Object localObject = paramIntent;; localObject = "null")
    {
      Log.i("MicroMsg.AlarmHelper", "getPendingIntent(requestCode:%s intent:%s flags:%s)", new Object[] { Integer.valueOf(paramInt1), localObject, Integer.valueOf(paramInt2) });
      if (paramContext != null) {
        break;
      }
      Log.e("MicroMsg.AlarmHelper", "getPendingIntent(requestCode:%s): context == null", new Object[] { Integer.valueOf(paramInt1) });
      AppMethodBeat.o(182037);
      return null;
    }
    if (!isRequestCodeValid(paramInt1))
    {
      Log.e("MicroMsg.AlarmHelper", "getPendingIntent(requestCode:%s): requestCode invalid", new Object[] { Integer.valueOf(paramInt1) });
      AppMethodBeat.o(182037);
      return null;
    }
    paramContext = PendingIntent.getBroadcast(paramContext, paramInt1, paramIntent, paramInt2);
    AppMethodBeat.o(182037);
    return paramContext;
  }
  
  private static String aAC()
  {
    AppMethodBeat.i(231115);
    if (hbJ != null)
    {
      str = hbJ.getStack();
      AppMethodBeat.o(231115);
      return str;
    }
    String str = Util.getStack().toString();
    AppMethodBeat.o(231115);
    return str;
  }
  
  private static PendingIntent b(Context paramContext, int paramInt1, int paramInt2, long paramLong1, long paramLong2, Intent paramIntent)
  {
    AppMethodBeat.i(186107);
    if (paramIntent != null) {}
    for (Object localObject = paramIntent;; localObject = "null")
    {
      Log.i("MicroMsg.AlarmHelper", "setRepeating(type:%s requestCode:%s triggerAtMillis:%s intervalMillis:%s intent:%s flags:%s stack:%s)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), Long.valueOf(paramLong1), Long.valueOf(paramLong2), localObject, Integer.valueOf(268435456), aAC() });
      if (paramContext != null) {
        break;
      }
      Log.e("MicroMsg.AlarmHelper", "setRepeating(requestCode:%s): context == null", new Object[] { Integer.valueOf(paramInt1) });
      AppMethodBeat.o(186107);
      return null;
    }
    localObject = (AlarmManager)paramContext.getSystemService("alarm");
    if (localObject == null)
    {
      Log.e("MicroMsg.AlarmHelper", "setRepeating(requestCode:%s): am == null", new Object[] { Integer.valueOf(paramInt1) });
      AppMethodBeat.o(186107);
      return null;
    }
    if (!isRequestCodeValid(paramInt1))
    {
      Log.e("MicroMsg.AlarmHelper", "setRepeating(requestCode:%s): requestCode invalid", new Object[] { Integer.valueOf(paramInt1) });
      AppMethodBeat.o(186107);
      return null;
    }
    paramContext = PendingIntent.getBroadcast(paramContext, paramInt1, paramIntent, 268435456);
    try
    {
      paramIntent = c.a(paramInt2, c.a(paramLong1, c.a(paramLong2, new com.tencent.mm.hellhoundlib.b.a().cG(paramContext))));
      com.tencent.mm.hellhoundlib.a.a.b(localObject, paramIntent.aYi(), "com/tencent/mm/alarm/AlarmHelper", "setRepeating", "(Landroid/content/Context;IIJJLandroid/content/Intent;IZ)Landroid/app/PendingIntent;", "android/app/AlarmManager_EXEC_", "setRepeating", "(IJJLandroid/app/PendingIntent;)V");
      ((AlarmManager)localObject).setRepeating(((Integer)paramIntent.sb(0)).intValue(), ((Long)c.a(paramIntent).sb(1)).longValue(), ((Long)c.a(c.aYk()).sb(2)).longValue(), (PendingIntent)c.aYk().sb(3));
      com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/alarm/AlarmHelper", "setRepeating", "(Landroid/content/Context;IIJJLandroid/content/Intent;IZ)Landroid/app/PendingIntent;", "android/app/AlarmManager_EXEC_", "setRepeating", "(IJJLandroid/app/PendingIntent;)V");
      AppMethodBeat.o(186107);
      return paramContext;
    }
    catch (Exception paramIntent)
    {
      for (;;)
      {
        Log.e("MicroMsg.AlarmHelper", "setRepeating Exception:%s %s", new Object[] { paramIntent.getClass().getSimpleName(), paramIntent.getMessage() });
        if (hbJ != null)
        {
          paramIntent = hbJ;
          aAC();
          paramIntent.dn(paramInt1, 1);
        }
      }
    }
  }
  
  private static PendingIntent b(Context paramContext, int paramInt, long paramLong, Intent paramIntent)
  {
    AppMethodBeat.i(186106);
    if (paramIntent != null) {}
    for (Object localObject = paramIntent;; localObject = "null")
    {
      Log.i("MicroMsg.AlarmHelper", "setExact(type:%s requestCode:%s triggerAtMillis:%s intent:%s flags:%s stack:%s)", new Object[] { Integer.valueOf(2), Integer.valueOf(paramInt), Long.valueOf(paramLong), localObject, Integer.valueOf(268435456), aAC() });
      hbK += 1;
      if (paramContext != null) {
        break;
      }
      Log.e("MicroMsg.AlarmHelper", "setExact(requestCode:%s): context == null", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(186106);
      return null;
    }
    localObject = (AlarmManager)paramContext.getSystemService("alarm");
    if (localObject == null)
    {
      Log.e("MicroMsg.AlarmHelper", "setExact(requestCode:%s): am == null", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(186106);
      return null;
    }
    if (!isRequestCodeValid(paramInt))
    {
      Log.e("MicroMsg.AlarmHelper", "setExact(requestCode:%s): requestCode invalid", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(186106);
      return null;
    }
    paramContext = PendingIntent.getBroadcast(paramContext, paramInt, paramIntent, 268435456);
    try
    {
      ((AlarmManager)localObject).setExact(2, paramLong, paramContext);
      AppMethodBeat.o(186106);
      return paramContext;
    }
    catch (Exception paramIntent)
    {
      for (;;)
      {
        Log.e("MicroMsg.AlarmHelper", "setExact Exception:%s %s", new Object[] { paramIntent.getClass().getSimpleName(), paramIntent.getMessage() });
        if (hbJ != null)
        {
          paramIntent = hbJ;
          aAC();
          paramIntent.dn(paramInt, 1);
        }
      }
    }
  }
  
  public static PendingIntent b(Context paramContext, int paramInt, Intent paramIntent)
  {
    AppMethodBeat.i(182036);
    paramContext = a(paramContext, paramInt, paramIntent, 536870912);
    AppMethodBeat.o(182036);
    return paramContext;
  }
  
  public static void c(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(186108);
    Log.i("MicroMsg.AlarmHelper", "cancel(requestCode:%s intent:%s flags:%s)", new Object[] { Integer.valueOf(111), paramIntent, Integer.valueOf(268435456) });
    if (paramContext == null)
    {
      Log.e("MicroMsg.AlarmHelper", "cancel(requestCode:%s): context == null", new Object[] { Integer.valueOf(111) });
      AppMethodBeat.o(186108);
      return;
    }
    AlarmManager localAlarmManager = (AlarmManager)paramContext.getSystemService("alarm");
    if (localAlarmManager == null)
    {
      Log.e("MicroMsg.AlarmHelper", "cancel(requestCode:%s): am == null", new Object[] { Integer.valueOf(111) });
      AppMethodBeat.o(186108);
      return;
    }
    paramContext = a(paramContext, 111, paramIntent, 268435456);
    try
    {
      paramContext = new com.tencent.mm.hellhoundlib.b.a().cG(paramContext);
      com.tencent.mm.hellhoundlib.a.a.b(localAlarmManager, paramContext.aYi(), "com/tencent/mm/alarm/AlarmHelper", "cancel", "(Landroid/content/Context;ILandroid/content/Intent;IZ)V", "android/app/AlarmManager_EXEC_", "cancel", "(Landroid/app/PendingIntent;)V");
      localAlarmManager.cancel((PendingIntent)paramContext.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(localAlarmManager, "com/tencent/mm/alarm/AlarmHelper", "cancel", "(Landroid/content/Context;ILandroid/content/Intent;IZ)V", "android/app/AlarmManager_EXEC_", "cancel", "(Landroid/app/PendingIntent;)V");
      AppMethodBeat.o(186108);
      return;
    }
    catch (Exception paramContext)
    {
      Log.e("MicroMsg.AlarmHelper", "cancel Exception:%s %s", new Object[] { paramContext.getClass().getSimpleName(), paramContext.getMessage() });
      if (hbJ != null)
      {
        paramContext = hbJ;
        aAC();
        paramContext.dn(111, 2);
      }
      AppMethodBeat.o(186108);
    }
  }
  
  public static void cancel(Context paramContext, int paramInt, PendingIntent paramPendingIntent)
  {
    AppMethodBeat.i(182035);
    if (paramPendingIntent != null) {}
    for (String str = "no null";; str = "null")
    {
      Log.i("MicroMsg.AlarmHelper", "cancel(requestCode:%s operation:%s)", new Object[] { Integer.valueOf(paramInt), str });
      if (paramContext != null) {
        break;
      }
      Log.e("MicroMsg.AlarmHelper", "cancel(requestCode:%s): context == null", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(182035);
      return;
    }
    paramContext = (AlarmManager)paramContext.getSystemService("alarm");
    if (paramContext == null)
    {
      Log.e("MicroMsg.AlarmHelper", "cancel(requestCode:%s): am == null", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(182035);
      return;
    }
    try
    {
      paramPendingIntent = new com.tencent.mm.hellhoundlib.b.a().cG(paramPendingIntent);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramPendingIntent.aYi(), "com/tencent/mm/alarm/AlarmHelper", "cancel", "(Landroid/content/Context;ILandroid/app/PendingIntent;)V", "android/app/AlarmManager_EXEC_", "cancel", "(Landroid/app/PendingIntent;)V");
      paramContext.cancel((PendingIntent)paramPendingIntent.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/alarm/AlarmHelper", "cancel", "(Landroid/content/Context;ILandroid/app/PendingIntent;)V", "android/app/AlarmManager_EXEC_", "cancel", "(Landroid/app/PendingIntent;)V");
      AppMethodBeat.o(182035);
      return;
    }
    catch (Exception paramContext)
    {
      Log.e("MicroMsg.AlarmHelper", "cancel Exception:%s %s", new Object[] { paramContext.getClass().getSimpleName(), paramContext.getMessage() });
      if (hbJ != null)
      {
        paramContext = hbJ;
        aAC();
        paramContext.dn(paramInt, 2);
      }
      AppMethodBeat.o(182035);
    }
  }
  
  private static boolean isRequestCodeValid(int paramInt)
  {
    return (paramInt >= 100) && (paramInt <= 119);
  }
  
  public static PendingIntent set(Context paramContext, int paramInt1, int paramInt2, long paramLong, Intent paramIntent, int paramInt3)
  {
    AppMethodBeat.i(182032);
    paramContext = a(paramContext, paramInt1, paramInt2, paramLong, paramIntent, paramInt3, true);
    AppMethodBeat.o(182032);
    return paramContext;
  }
  
  public static abstract interface a
  {
    public abstract void dn(int paramInt1, int paramInt2);
    
    public abstract String getStack();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.a.a
 * JD-Core Version:    0.7.0.1
 */