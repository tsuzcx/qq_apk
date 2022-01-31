package com.google.android.gms.common.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.Build.VERSION;
import android.os.PowerManager;
import android.provider.Settings.Secure;
import com.google.android.gms.internal.stable.zzg;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class DeviceStateUtils
{
  private static final IntentFilter filter;
  private static long zzzw;
  private static float zzzx;
  
  static
  {
    AppMethodBeat.i(90195);
    filter = new IntentFilter("android.intent.action.BATTERY_CHANGED");
    zzzx = (0.0F / 0.0F);
    AppMethodBeat.o(90195);
  }
  
  @TargetApi(20)
  public static int getDeviceState(Context paramContext)
  {
    int k = 1;
    AppMethodBeat.i(90188);
    if ((paramContext == null) || (paramContext.getApplicationContext() == null))
    {
      AppMethodBeat.o(90188);
      return -1;
    }
    Intent localIntent = paramContext.getApplicationContext().registerReceiver(null, filter);
    if (localIntent == null)
    {
      i = 0;
      if ((i & 0x7) == 0) {
        break label87;
      }
    }
    label87:
    for (int i = 1;; i = 0)
    {
      paramContext = (PowerManager)paramContext.getSystemService("power");
      if (paramContext != null) {
        break label92;
      }
      AppMethodBeat.o(90188);
      return -1;
      i = localIntent.getIntExtra("plugged", 0);
      break;
    }
    label92:
    int j;
    if (isInteractive(paramContext))
    {
      j = 1;
      if (i == 0) {
        break label123;
      }
    }
    label123:
    for (i = k;; i = 0)
    {
      AppMethodBeat.o(90188);
      return j << 1 | i;
      j = 0;
      break;
    }
  }
  
  /* Error */
  public static float getPowerPercentage(Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 78
    //   5: invokestatic 19	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: invokestatic 84	android/os/SystemClock:elapsedRealtime	()J
    //   11: getstatic 86	com/google/android/gms/common/util/DeviceStateUtils:zzzw	J
    //   14: lsub
    //   15: ldc2_w 87
    //   18: lcmp
    //   19: ifge +26 -> 45
    //   22: getstatic 32	com/google/android/gms/common/util/DeviceStateUtils:zzzx	F
    //   25: invokestatic 94	java/lang/Float:isNaN	(F)Z
    //   28: ifne +17 -> 45
    //   31: getstatic 32	com/google/android/gms/common/util/DeviceStateUtils:zzzx	F
    //   34: fstore_1
    //   35: ldc 78
    //   37: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   40: ldc 2
    //   42: monitorexit
    //   43: fload_1
    //   44: freturn
    //   45: aload_0
    //   46: invokevirtual 50	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   49: aconst_null
    //   50: getstatic 29	com/google/android/gms/common/util/DeviceStateUtils:filter	Landroid/content/IntentFilter;
    //   53: invokevirtual 54	android/content/Context:registerReceiver	(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;
    //   56: astore_0
    //   57: aload_0
    //   58: ifnull +27 -> 85
    //   61: aload_0
    //   62: ldc 96
    //   64: iconst_m1
    //   65: invokevirtual 70	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   68: istore_2
    //   69: aload_0
    //   70: ldc 98
    //   72: iconst_m1
    //   73: invokevirtual 70	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   76: istore_3
    //   77: iload_2
    //   78: i2f
    //   79: iload_3
    //   80: i2f
    //   81: fdiv
    //   82: putstatic 32	com/google/android/gms/common/util/DeviceStateUtils:zzzx	F
    //   85: invokestatic 84	android/os/SystemClock:elapsedRealtime	()J
    //   88: putstatic 86	com/google/android/gms/common/util/DeviceStateUtils:zzzw	J
    //   91: getstatic 32	com/google/android/gms/common/util/DeviceStateUtils:zzzx	F
    //   94: fstore_1
    //   95: ldc 78
    //   97: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   100: goto -60 -> 40
    //   103: astore_0
    //   104: ldc 2
    //   106: monitorexit
    //   107: aload_0
    //   108: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	109	0	paramContext	Context
    //   34	61	1	f	float
    //   68	10	2	i	int
    //   76	4	3	j	int
    // Exception table:
    //   from	to	target	type
    //   3	40	103	finally
    //   45	57	103	finally
    //   61	85	103	finally
    //   85	100	103	finally
  }
  
  public static boolean hasConsentedNlp(Context paramContext)
  {
    AppMethodBeat.i(90194);
    if (zzg.getInt(paramContext.getContentResolver(), "network_location_opt_in", -1) == 1)
    {
      AppMethodBeat.o(90194);
      return true;
    }
    AppMethodBeat.o(90194);
    return false;
  }
  
  public static boolean isCallActive(Context paramContext)
  {
    AppMethodBeat.i(90192);
    if (((AudioManager)paramContext.getSystemService("audio")).getMode() == 2)
    {
      AppMethodBeat.o(90192);
      return true;
    }
    AppMethodBeat.o(90192);
    return false;
  }
  
  public static boolean isInteractive(Context paramContext)
  {
    AppMethodBeat.i(90189);
    boolean bool = isInteractive((PowerManager)paramContext.getSystemService("power"));
    AppMethodBeat.o(90189);
    return bool;
  }
  
  @TargetApi(20)
  public static boolean isInteractive(PowerManager paramPowerManager)
  {
    AppMethodBeat.i(90190);
    if (PlatformVersion.isAtLeastKitKatWatch())
    {
      bool = paramPowerManager.isInteractive();
      AppMethodBeat.o(90190);
      return bool;
    }
    boolean bool = paramPowerManager.isScreenOn();
    AppMethodBeat.o(90190);
    return bool;
  }
  
  public static boolean isUserSetupComplete(Context paramContext)
  {
    AppMethodBeat.i(90193);
    if ((Build.VERSION.SDK_INT < 23) || (Settings.Secure.getInt(paramContext.getContentResolver(), "user_setup_complete", -1) == 1))
    {
      AppMethodBeat.o(90193);
      return true;
    }
    AppMethodBeat.o(90193);
    return false;
  }
  
  @VisibleForTesting
  public static void resetForTest()
  {
    try
    {
      zzzw = 0L;
      zzzx = (0.0F / 0.0F);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.common.util.DeviceStateUtils
 * JD-Core Version:    0.7.0.1
 */