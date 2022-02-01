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
    AppMethodBeat.i(5217);
    filter = new IntentFilter("android.intent.action.BATTERY_CHANGED");
    zzzx = (0.0F / 0.0F);
    AppMethodBeat.o(5217);
  }
  
  @TargetApi(20)
  public static int getDeviceState(Context paramContext)
  {
    int k = 1;
    AppMethodBeat.i(5210);
    if ((paramContext == null) || (paramContext.getApplicationContext() == null))
    {
      AppMethodBeat.o(5210);
      return -1;
    }
    Intent localIntent = paramContext.getApplicationContext().registerReceiver(null, filter);
    if (localIntent == null)
    {
      i = 0;
      if ((i & 0x7) == 0) {
        break label90;
      }
    }
    label90:
    for (int i = 1;; i = 0)
    {
      paramContext = (PowerManager)paramContext.getSystemService("power");
      if (paramContext != null) {
        break label95;
      }
      AppMethodBeat.o(5210);
      return -1;
      i = localIntent.getIntExtra("plugged", 0);
      break;
    }
    label95:
    int j;
    if (isInteractive(paramContext))
    {
      j = 1;
      if (i == 0) {
        break label127;
      }
    }
    label127:
    for (i = k;; i = 0)
    {
      AppMethodBeat.o(5210);
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
    //   3: sipush 5213
    //   6: invokestatic 18	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: invokestatic 81	android/os/SystemClock:elapsedRealtime	()J
    //   12: getstatic 83	com/google/android/gms/common/util/DeviceStateUtils:zzzw	J
    //   15: lsub
    //   16: ldc2_w 84
    //   19: lcmp
    //   20: ifge +27 -> 47
    //   23: getstatic 31	com/google/android/gms/common/util/DeviceStateUtils:zzzx	F
    //   26: invokestatic 91	java/lang/Float:isNaN	(F)Z
    //   29: ifne +18 -> 47
    //   32: getstatic 31	com/google/android/gms/common/util/DeviceStateUtils:zzzx	F
    //   35: fstore_1
    //   36: sipush 5213
    //   39: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   42: ldc 2
    //   44: monitorexit
    //   45: fload_1
    //   46: freturn
    //   47: aload_0
    //   48: invokevirtual 48	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   51: aconst_null
    //   52: getstatic 28	com/google/android/gms/common/util/DeviceStateUtils:filter	Landroid/content/IntentFilter;
    //   55: invokevirtual 52	android/content/Context:registerReceiver	(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;
    //   58: astore_0
    //   59: aload_0
    //   60: ifnull +27 -> 87
    //   63: aload_0
    //   64: ldc 93
    //   66: iconst_m1
    //   67: invokevirtual 68	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   70: istore_2
    //   71: aload_0
    //   72: ldc 95
    //   74: iconst_m1
    //   75: invokevirtual 68	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   78: istore_3
    //   79: iload_2
    //   80: i2f
    //   81: iload_3
    //   82: i2f
    //   83: fdiv
    //   84: putstatic 31	com/google/android/gms/common/util/DeviceStateUtils:zzzx	F
    //   87: invokestatic 81	android/os/SystemClock:elapsedRealtime	()J
    //   90: putstatic 83	com/google/android/gms/common/util/DeviceStateUtils:zzzw	J
    //   93: getstatic 31	com/google/android/gms/common/util/DeviceStateUtils:zzzx	F
    //   96: fstore_1
    //   97: sipush 5213
    //   100: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   103: goto -61 -> 42
    //   106: astore_0
    //   107: ldc 2
    //   109: monitorexit
    //   110: aload_0
    //   111: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	112	0	paramContext	Context
    //   35	62	1	f	float
    //   70	10	2	i	int
    //   78	4	3	j	int
    // Exception table:
    //   from	to	target	type
    //   3	42	106	finally
    //   47	59	106	finally
    //   63	87	106	finally
    //   87	103	106	finally
  }
  
  public static boolean hasConsentedNlp(Context paramContext)
  {
    AppMethodBeat.i(5216);
    if (zzg.getInt(paramContext.getContentResolver(), "network_location_opt_in", -1) == 1)
    {
      AppMethodBeat.o(5216);
      return true;
    }
    AppMethodBeat.o(5216);
    return false;
  }
  
  public static boolean isCallActive(Context paramContext)
  {
    AppMethodBeat.i(5214);
    if (((AudioManager)paramContext.getSystemService("audio")).getMode() == 2)
    {
      AppMethodBeat.o(5214);
      return true;
    }
    AppMethodBeat.o(5214);
    return false;
  }
  
  public static boolean isInteractive(Context paramContext)
  {
    AppMethodBeat.i(5211);
    boolean bool = isInteractive((PowerManager)paramContext.getSystemService("power"));
    AppMethodBeat.o(5211);
    return bool;
  }
  
  @TargetApi(20)
  public static boolean isInteractive(PowerManager paramPowerManager)
  {
    AppMethodBeat.i(5212);
    if (PlatformVersion.isAtLeastKitKatWatch())
    {
      bool = paramPowerManager.isInteractive();
      AppMethodBeat.o(5212);
      return bool;
    }
    boolean bool = paramPowerManager.isScreenOn();
    AppMethodBeat.o(5212);
    return bool;
  }
  
  public static boolean isUserSetupComplete(Context paramContext)
  {
    AppMethodBeat.i(5215);
    if ((Build.VERSION.SDK_INT < 23) || (Settings.Secure.getInt(paramContext.getContentResolver(), "user_setup_complete", -1) == 1))
    {
      AppMethodBeat.o(5215);
      return true;
    }
    AppMethodBeat.o(5215);
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