package com.tencent.mm.a;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.bu;

public final class a
{
  public static a cQg = null;
  public static int cQh = 0;
  
  private static String Kh()
  {
    AppMethodBeat.i(196709);
    if (cQg != null)
    {
      str = cQg.getStack();
      AppMethodBeat.o(196709);
      return str;
    }
    String str = bu.fpN().toString();
    AppMethodBeat.o(196709);
    return str;
  }
  
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
      ae.i("MicroMsg.AlarmHelper", "set(type:%s requestCode:%s triggerAtMillis:%s intent:%s flags:%s stack:%s)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), Long.valueOf(paramLong), localObject, Integer.valueOf(paramInt3), Kh() });
      if (paramContext != null) {
        break;
      }
      ae.e("MicroMsg.AlarmHelper", "set(requestCode:%s): context == null", new Object[] { Integer.valueOf(paramInt1) });
      AppMethodBeat.o(185210);
      return null;
    }
    localObject = (AlarmManager)paramContext.getSystemService("alarm");
    if (localObject == null)
    {
      ae.e("MicroMsg.AlarmHelper", "set(requestCode:%s): am == null", new Object[] { Integer.valueOf(paramInt1) });
      AppMethodBeat.o(185210);
      return null;
    }
    if (!isRequestCodeValid(paramInt1))
    {
      ae.e("MicroMsg.AlarmHelper", "set(requestCode:%s): requestCode invalid", new Object[] { Integer.valueOf(paramInt1) });
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
        ((AlarmManager)localObject).set(paramInt2, paramLong, paramContext);
        AppMethodBeat.o(185210);
        return paramContext;
        paramContext = PendingIntent.getActivity(paramContext, paramInt1, paramIntent, paramInt3);
      }
    }
    catch (Exception paramIntent)
    {
      for (;;)
      {
        ae.e("MicroMsg.AlarmHelper", "set Exception:%s %s", new Object[] { paramIntent.getClass().getSimpleName(), paramIntent.getMessage() });
        if (cQg != null)
        {
          paramIntent = cQg;
          Kh();
          paramIntent.ce(paramInt1, 1);
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
      ae.i("MicroMsg.AlarmHelper", "getPendingIntent(requestCode:%s intent:%s flags:%s)", new Object[] { Integer.valueOf(paramInt1), localObject, Integer.valueOf(paramInt2) });
      if (paramContext != null) {
        break;
      }
      ae.e("MicroMsg.AlarmHelper", "getPendingIntent(requestCode:%s): context == null", new Object[] { Integer.valueOf(paramInt1) });
      AppMethodBeat.o(182037);
      return null;
    }
    if (!isRequestCodeValid(paramInt1))
    {
      ae.e("MicroMsg.AlarmHelper", "getPendingIntent(requestCode:%s): requestCode invalid", new Object[] { Integer.valueOf(paramInt1) });
      AppMethodBeat.o(182037);
      return null;
    }
    paramContext = PendingIntent.getBroadcast(paramContext, paramInt1, paramIntent, paramInt2);
    AppMethodBeat.o(182037);
    return paramContext;
  }
  
  private static PendingIntent b(Context paramContext, int paramInt1, int paramInt2, long paramLong1, long paramLong2, Intent paramIntent)
  {
    AppMethodBeat.i(186107);
    if (paramIntent != null) {}
    for (Object localObject = paramIntent;; localObject = "null")
    {
      ae.i("MicroMsg.AlarmHelper", "setRepeating(type:%s requestCode:%s triggerAtMillis:%s intervalMillis:%s intent:%s flags:%s stack:%s)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), Long.valueOf(paramLong1), Long.valueOf(paramLong2), localObject, Integer.valueOf(268435456), Kh() });
      if (paramContext != null) {
        break;
      }
      ae.e("MicroMsg.AlarmHelper", "setRepeating(requestCode:%s): context == null", new Object[] { Integer.valueOf(paramInt1) });
      AppMethodBeat.o(186107);
      return null;
    }
    localObject = (AlarmManager)paramContext.getSystemService("alarm");
    if (localObject == null)
    {
      ae.e("MicroMsg.AlarmHelper", "setRepeating(requestCode:%s): am == null", new Object[] { Integer.valueOf(paramInt1) });
      AppMethodBeat.o(186107);
      return null;
    }
    if (!isRequestCodeValid(paramInt1))
    {
      ae.e("MicroMsg.AlarmHelper", "setRepeating(requestCode:%s): requestCode invalid", new Object[] { Integer.valueOf(paramInt1) });
      AppMethodBeat.o(186107);
      return null;
    }
    paramContext = PendingIntent.getBroadcast(paramContext, paramInt1, paramIntent, 268435456);
    try
    {
      ((AlarmManager)localObject).setRepeating(paramInt2, paramLong1, paramLong2, paramContext);
      AppMethodBeat.o(186107);
      return paramContext;
    }
    catch (Exception paramIntent)
    {
      for (;;)
      {
        ae.e("MicroMsg.AlarmHelper", "setRepeating Exception:%s %s", new Object[] { paramIntent.getClass().getSimpleName(), paramIntent.getMessage() });
        if (cQg != null)
        {
          paramIntent = cQg;
          Kh();
          paramIntent.ce(paramInt1, 1);
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
      ae.i("MicroMsg.AlarmHelper", "setExact(type:%s requestCode:%s triggerAtMillis:%s intent:%s flags:%s stack:%s)", new Object[] { Integer.valueOf(2), Integer.valueOf(paramInt), Long.valueOf(paramLong), localObject, Integer.valueOf(268435456), Kh() });
      cQh += 1;
      if (paramContext != null) {
        break;
      }
      ae.e("MicroMsg.AlarmHelper", "setExact(requestCode:%s): context == null", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(186106);
      return null;
    }
    localObject = (AlarmManager)paramContext.getSystemService("alarm");
    if (localObject == null)
    {
      ae.e("MicroMsg.AlarmHelper", "setExact(requestCode:%s): am == null", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(186106);
      return null;
    }
    if (!isRequestCodeValid(paramInt))
    {
      ae.e("MicroMsg.AlarmHelper", "setExact(requestCode:%s): requestCode invalid", new Object[] { Integer.valueOf(paramInt) });
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
        ae.e("MicroMsg.AlarmHelper", "setExact Exception:%s %s", new Object[] { paramIntent.getClass().getSimpleName(), paramIntent.getMessage() });
        if (cQg != null)
        {
          paramIntent = cQg;
          Kh();
          paramIntent.ce(paramInt, 1);
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
    ae.i("MicroMsg.AlarmHelper", "cancel(requestCode:%s intent:%s flags:%s)", new Object[] { Integer.valueOf(111), paramIntent, Integer.valueOf(268435456) });
    if (paramContext == null)
    {
      ae.e("MicroMsg.AlarmHelper", "cancel(requestCode:%s): context == null", new Object[] { Integer.valueOf(111) });
      AppMethodBeat.o(186108);
      return;
    }
    AlarmManager localAlarmManager = (AlarmManager)paramContext.getSystemService("alarm");
    if (localAlarmManager == null)
    {
      ae.e("MicroMsg.AlarmHelper", "cancel(requestCode:%s): am == null", new Object[] { Integer.valueOf(111) });
      AppMethodBeat.o(186108);
      return;
    }
    paramContext = a(paramContext, 111, paramIntent, 268435456);
    try
    {
      localAlarmManager.cancel(paramContext);
      AppMethodBeat.o(186108);
      return;
    }
    catch (Exception paramContext)
    {
      ae.e("MicroMsg.AlarmHelper", "cancel Exception:%s %s", new Object[] { paramContext.getClass().getSimpleName(), paramContext.getMessage() });
      if (cQg != null)
      {
        paramContext = cQg;
        Kh();
        paramContext.ce(111, 2);
      }
      AppMethodBeat.o(186108);
    }
  }
  
  public static void cancel(Context paramContext, int paramInt, PendingIntent paramPendingIntent)
  {
    AppMethodBeat.i(182035);
    if (paramPendingIntent != null) {}
    for (String str = paramPendingIntent.toString();; str = "null")
    {
      ae.i("MicroMsg.AlarmHelper", "cancel(requestCode:%s operation:%s)", new Object[] { Integer.valueOf(paramInt), str });
      if (paramContext != null) {
        break;
      }
      ae.e("MicroMsg.AlarmHelper", "cancel(requestCode:%s): context == null", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(182035);
      return;
    }
    paramContext = (AlarmManager)paramContext.getSystemService("alarm");
    if (paramContext == null)
    {
      ae.e("MicroMsg.AlarmHelper", "cancel(requestCode:%s): am == null", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(182035);
      return;
    }
    try
    {
      paramContext.cancel(paramPendingIntent);
      AppMethodBeat.o(182035);
      return;
    }
    catch (Exception paramContext)
    {
      ae.e("MicroMsg.AlarmHelper", "cancel Exception:%s %s", new Object[] { paramContext.getClass().getSimpleName(), paramContext.getMessage() });
      if (cQg != null)
      {
        paramContext = cQg;
        Kh();
        paramContext.ce(paramInt, 2);
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
    public abstract void ce(int paramInt1, int paramInt2);
    
    public abstract String getStack();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.a.a
 * JD-Core Version:    0.7.0.1
 */