package com.tencent.mars.ilink.comm;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import com.tencent.mars.ilink.xlog.Log;
import com.tencent.mm.hellhoundlib.b.c;

public class AlarmHelper
{
  private static final String TAG = "MicroMsg.AlarmHelper";
  private byte _hellAccFlag_;
  
  public static void cancel(Context paramContext, int paramInt, PendingIntent paramPendingIntent)
  {
    if (paramPendingIntent != null) {}
    for (String str = paramPendingIntent.toString();; str = "null")
    {
      Log.d("MicroMsg.AlarmHelper", "cancel(requestCode:%s operation:%s)", new Object[] { Integer.valueOf(paramInt), str });
      if (paramContext != null) {
        break;
      }
      Log.e("MicroMsg.AlarmHelper", "cancel(requestCode:%s): context == null", new Object[] { Integer.valueOf(paramInt) });
      return;
    }
    paramContext = (AlarmManager)paramContext.getSystemService("alarm");
    if (paramContext == null)
    {
      Log.e("MicroMsg.AlarmHelper", "cancel(requestCode:%s): am == null", new Object[] { Integer.valueOf(paramInt) });
      return;
    }
    paramPendingIntent = new com.tencent.mm.hellhoundlib.b.a().cG(paramPendingIntent);
    com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramPendingIntent.aYi(), "com/tencent/mars/ilink/comm/AlarmHelper", "cancel", "(Landroid/content/Context;ILandroid/app/PendingIntent;)V", "android/app/AlarmManager_EXEC_", "cancel", "(Landroid/app/PendingIntent;)V");
    paramContext.cancel((PendingIntent)paramPendingIntent.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mars/ilink/comm/AlarmHelper", "cancel", "(Landroid/content/Context;ILandroid/app/PendingIntent;)V", "android/app/AlarmManager_EXEC_", "cancel", "(Landroid/app/PendingIntent;)V");
  }
  
  public static void cancel(Context paramContext, int paramInt1, Intent paramIntent, int paramInt2)
  {
    if (paramIntent != null) {}
    for (Object localObject = paramIntent;; localObject = "null")
    {
      Log.d("MicroMsg.AlarmHelper", "cancel(requestCode:%s intent:%s flags:%s)", new Object[] { Integer.valueOf(paramInt1), localObject, Integer.valueOf(paramInt2) });
      if (paramContext != null) {
        break;
      }
      Log.e("MicroMsg.AlarmHelper", "cancel(requestCode:%s): context == null", new Object[] { Integer.valueOf(paramInt1) });
      return;
    }
    localObject = (AlarmManager)paramContext.getSystemService("alarm");
    if (localObject == null)
    {
      Log.e("MicroMsg.AlarmHelper", "cancel(requestCode:%s): am == null", new Object[] { Integer.valueOf(paramInt1) });
      return;
    }
    paramContext = getPendingIntent(paramContext, paramInt1, paramIntent, paramInt2);
    paramContext = new com.tencent.mm.hellhoundlib.b.a().cG(paramContext);
    com.tencent.mm.hellhoundlib.a.a.b(localObject, paramContext.aYi(), "com/tencent/mars/ilink/comm/AlarmHelper", "cancel", "(Landroid/content/Context;ILandroid/content/Intent;I)V", "android/app/AlarmManager_EXEC_", "cancel", "(Landroid/app/PendingIntent;)V");
    ((AlarmManager)localObject).cancel((PendingIntent)paramContext.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mars/ilink/comm/AlarmHelper", "cancel", "(Landroid/content/Context;ILandroid/content/Intent;I)V", "android/app/AlarmManager_EXEC_", "cancel", "(Landroid/app/PendingIntent;)V");
  }
  
  public static void cancel(Context paramContext, PendingIntent paramPendingIntent)
  {
    if (paramPendingIntent != null) {}
    for (String str = paramPendingIntent.toString();; str = "null")
    {
      Log.d("MicroMsg.AlarmHelper", "cancel(operation:%s)", new Object[] { str });
      if (paramContext != null) {
        break;
      }
      Log.e("MicroMsg.AlarmHelper", "cancel: context == null");
      return;
    }
    paramContext = (AlarmManager)paramContext.getSystemService("alarm");
    if (paramContext == null)
    {
      Log.e("MicroMsg.AlarmHelper", "cancel: am == null");
      return;
    }
    paramPendingIntent = new com.tencent.mm.hellhoundlib.b.a().cG(paramPendingIntent);
    com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramPendingIntent.aYi(), "com/tencent/mars/ilink/comm/AlarmHelper", "cancel", "(Landroid/content/Context;Landroid/app/PendingIntent;)V", "android/app/AlarmManager_EXEC_", "cancel", "(Landroid/app/PendingIntent;)V");
    paramContext.cancel((PendingIntent)paramPendingIntent.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mars/ilink/comm/AlarmHelper", "cancel", "(Landroid/content/Context;Landroid/app/PendingIntent;)V", "android/app/AlarmManager_EXEC_", "cancel", "(Landroid/app/PendingIntent;)V");
  }
  
  public static PendingIntent getPendingIntent(Context paramContext, int paramInt1, Intent paramIntent, int paramInt2)
  {
    if (paramIntent != null) {}
    for (Object localObject = paramIntent;; localObject = "null")
    {
      Log.d("MicroMsg.AlarmHelper", "getPendingIntent(requestCode:%s intent:%s flags:%s)", new Object[] { Integer.valueOf(paramInt1), localObject, Integer.valueOf(paramInt2) });
      if (paramContext != null) {
        break;
      }
      Log.e("MicroMsg.AlarmHelper", "getPendingIntent(requestCode:%s): context == null", new Object[] { Integer.valueOf(paramInt1) });
      return null;
    }
    if (!isRequestCodeValid(paramInt1))
    {
      Log.e("MicroMsg.AlarmHelper", "getPendingIntent(requestCode:%s): requestCode invalid", new Object[] { Integer.valueOf(paramInt1) });
      return null;
    }
    return PendingIntent.getBroadcast(paramContext, paramInt1, paramIntent, paramInt2);
  }
  
  private static boolean isRequestCodeValid(int paramInt)
  {
    return (paramInt >= 100) && (paramInt <= 119);
  }
  
  public static PendingIntent set(Context paramContext, int paramInt1, int paramInt2, long paramLong, Intent paramIntent, int paramInt3)
  {
    if (paramIntent != null) {}
    for (Object localObject = paramIntent;; localObject = "null")
    {
      Log.d("MicroMsg.AlarmHelper", "set(type:%s requestCode:%s triggerAtMillis:%s intent:%s flags:%s)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), Long.valueOf(paramLong), localObject, Integer.valueOf(paramInt3) });
      if (paramContext != null) {
        break;
      }
      Log.e("MicroMsg.AlarmHelper", "set(requestCode:%s): context == null", new Object[] { Integer.valueOf(paramInt1) });
      return null;
    }
    localObject = (AlarmManager)paramContext.getSystemService("alarm");
    if (localObject == null)
    {
      Log.e("MicroMsg.AlarmHelper", "set(requestCode:%s): am == null", new Object[] { Integer.valueOf(paramInt1) });
      return null;
    }
    if (!isRequestCodeValid(paramInt1))
    {
      Log.e("MicroMsg.AlarmHelper", "set(requestCode:%s): requestCode invalid", new Object[] { Integer.valueOf(paramInt1) });
      return null;
    }
    paramContext = PendingIntent.getBroadcast(paramContext, paramInt1, paramIntent, paramInt3);
    paramIntent = c.a(paramInt2, c.a(paramLong, new com.tencent.mm.hellhoundlib.b.a().cG(paramContext)));
    com.tencent.mm.hellhoundlib.a.a.b(localObject, paramIntent.aYi(), "com/tencent/mars/ilink/comm/AlarmHelper", "set", "(Landroid/content/Context;IIJLandroid/content/Intent;I)Landroid/app/PendingIntent;", "android/app/AlarmManager_EXEC_", "set", "(IJLandroid/app/PendingIntent;)V");
    ((AlarmManager)localObject).set(((Integer)paramIntent.sb(0)).intValue(), ((Long)c.a(paramIntent).sb(1)).longValue(), (PendingIntent)c.aYk().sb(2));
    com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mars/ilink/comm/AlarmHelper", "set", "(Landroid/content/Context;IIJLandroid/content/Intent;I)Landroid/app/PendingIntent;", "android/app/AlarmManager_EXEC_", "set", "(IJLandroid/app/PendingIntent;)V");
    return paramContext;
  }
  
  public static PendingIntent setExact(Context paramContext, int paramInt1, int paramInt2, long paramLong, Intent paramIntent, int paramInt3)
  {
    if (paramIntent != null) {}
    for (Object localObject = paramIntent;; localObject = "null")
    {
      Log.d("MicroMsg.AlarmHelper", "setExact(type:%s requestCode:%s triggerAtMillis:%s intent:%s flags:%s)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), Long.valueOf(paramLong), localObject, Integer.valueOf(paramInt3) });
      if (paramContext != null) {
        break;
      }
      Log.e("MicroMsg.AlarmHelper", "setExact(requestCode:%s): context == null", new Object[] { Integer.valueOf(paramInt1) });
      return null;
    }
    localObject = (AlarmManager)paramContext.getSystemService("alarm");
    if (localObject == null)
    {
      Log.e("MicroMsg.AlarmHelper", "setExact(requestCode:%s): am == null", new Object[] { Integer.valueOf(paramInt1) });
      return null;
    }
    if (!isRequestCodeValid(paramInt1))
    {
      Log.e("MicroMsg.AlarmHelper", "setExact(requestCode:%s): requestCode invalid", new Object[] { Integer.valueOf(paramInt1) });
      return null;
    }
    paramContext = PendingIntent.getBroadcast(paramContext, paramInt1, paramIntent, paramInt3);
    paramIntent = c.a(paramInt2, c.a(paramLong, new com.tencent.mm.hellhoundlib.b.a().cG(paramContext)));
    com.tencent.mm.hellhoundlib.a.a.b(localObject, paramIntent.aYi(), "com/tencent/mars/ilink/comm/AlarmHelper", "setExact", "(Landroid/content/Context;IIJLandroid/content/Intent;I)Landroid/app/PendingIntent;", "android/app/AlarmManager_EXEC_", "set", "(IJLandroid/app/PendingIntent;)V");
    ((AlarmManager)localObject).set(((Integer)paramIntent.sb(0)).intValue(), ((Long)c.a(paramIntent).sb(1)).longValue(), (PendingIntent)c.aYk().sb(2));
    com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mars/ilink/comm/AlarmHelper", "setExact", "(Landroid/content/Context;IIJLandroid/content/Intent;I)Landroid/app/PendingIntent;", "android/app/AlarmManager_EXEC_", "set", "(IJLandroid/app/PendingIntent;)V");
    return paramContext;
  }
  
  public static PendingIntent setRepeating(Context paramContext, int paramInt1, int paramInt2, long paramLong1, long paramLong2, Intent paramIntent, int paramInt3)
  {
    if (paramIntent != null) {}
    for (Object localObject = paramIntent;; localObject = "null")
    {
      Log.d("MicroMsg.AlarmHelper", "setRepeating(type:%s requestCode:%s triggerAtMillis:%s intervalMillis:%s intent:%s flags:%s)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), Long.valueOf(paramLong1), Long.valueOf(paramLong2), localObject, Integer.valueOf(paramInt3) });
      if (paramContext != null) {
        break;
      }
      Log.e("MicroMsg.AlarmHelper", "setRepeating(requestCode:%s): context == null", new Object[] { Integer.valueOf(paramInt1) });
      return null;
    }
    localObject = (AlarmManager)paramContext.getSystemService("alarm");
    if (localObject == null)
    {
      Log.e("MicroMsg.AlarmHelper", "setRepeating(requestCode:%s): am == null", new Object[] { Integer.valueOf(paramInt1) });
      return null;
    }
    if (!isRequestCodeValid(paramInt1))
    {
      Log.e("MicroMsg.AlarmHelper", "setRepeating(requestCode:%s): requestCode invalid", new Object[] { Integer.valueOf(paramInt1) });
      return null;
    }
    paramContext = PendingIntent.getBroadcast(paramContext, paramInt1, paramIntent, paramInt3);
    paramIntent = c.a(paramInt2, c.a(paramLong1, new com.tencent.mm.hellhoundlib.b.a().cG(paramContext)));
    com.tencent.mm.hellhoundlib.a.a.b(localObject, paramIntent.aYi(), "com/tencent/mars/ilink/comm/AlarmHelper", "setRepeating", "(Landroid/content/Context;IIJJLandroid/content/Intent;I)Landroid/app/PendingIntent;", "android/app/AlarmManager_EXEC_", "set", "(IJLandroid/app/PendingIntent;)V");
    ((AlarmManager)localObject).set(((Integer)paramIntent.sb(0)).intValue(), ((Long)c.a(paramIntent).sb(1)).longValue(), (PendingIntent)c.aYk().sb(2));
    com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mars/ilink/comm/AlarmHelper", "setRepeating", "(Landroid/content/Context;IIJJLandroid/content/Intent;I)Landroid/app/PendingIntent;", "android/app/AlarmManager_EXEC_", "set", "(IJLandroid/app/PendingIntent;)V");
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mars.ilink.comm.AlarmHelper
 * JD-Core Version:    0.7.0.1
 */