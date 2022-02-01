package com.tencent.matrix.a.c;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningServiceInfo;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Build.VERSION;
import android.os.PowerManager;
import android.text.TextUtils;
import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.regex.Pattern;

public final class c
{
  public static String K(String paramString1, String paramString2)
  {
    ArrayList localArrayList = new ArrayList();
    paramString1 = paramString1.split("\n\t");
    boolean bool1 = TextUtils.isEmpty(paramString2);
    int j = paramString1.length;
    int i = 0;
    while (i < j)
    {
      CharSequence localCharSequence = paramString1[i];
      boolean bool3 = bool1;
      if (!TextUtils.isEmpty(localCharSequence))
      {
        boolean bool2 = bool1;
        if (!bool1)
        {
          bool2 = bool1;
          if (localCharSequence.startsWith(paramString2)) {
            bool2 = true;
          }
        }
        bool3 = bool2;
        if (bool2)
        {
          localArrayList.add(localCharSequence.trim());
          bool3 = bool2;
        }
      }
      i += 1;
      bool1 = bool3;
    }
    return TextUtils.join(";", localArrayList.subList(0, Math.min(5, localArrayList.size())));
  }
  
  public static int[] Sq()
  {
    int[] arrayOfInt = new int[getNumCores()];
    int i = 0;
    for (;;)
    {
      String str;
      if (i < getNumCores())
      {
        arrayOfInt[i] = 0;
        str = eu("/sys/devices/system/cpu/cpu" + i + "/cpufreq/scaling_cur_freq");
        if (TextUtils.isEmpty(str)) {}
      }
      try
      {
        arrayOfInt[i] = (Integer.parseInt(str) / 1000);
        label62:
        i += 1;
        continue;
        return arrayOfInt;
      }
      catch (Exception localException)
      {
        break label62;
      }
    }
  }
  
  public static int ba(Context paramContext)
  {
    try
    {
      paramContext = paramContext.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
      if (paramContext == null) {
        return 0;
      }
      int i = paramContext.getIntExtra("temperature", 0);
      return i;
    }
    catch (Throwable paramContext) {}
    return 0;
  }
  
  public static int bb(Context paramContext)
  {
    if (bc(paramContext)) {
      return 1;
    }
    if (!bd(paramContext)) {
      return 3;
    }
    if (be(paramContext)) {
      return 4;
    }
    return 2;
  }
  
  public static boolean bc(Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 23)
    {
      BatteryManager localBatteryManager = (BatteryManager)paramContext.getSystemService("batterymanager");
      if (localBatteryManager != null) {
        return localBatteryManager.isCharging();
      }
    }
    try
    {
      paramContext = paramContext.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
      if (paramContext == null) {
        return false;
      }
      int i = paramContext.getIntExtra("plugged", -1);
      return (i == 1) || (i == 2) || (i == 4);
    }
    catch (Throwable paramContext) {}
    return false;
  }
  
  public static boolean bd(Context paramContext)
  {
    try
    {
      paramContext = (PowerManager)paramContext.getSystemService("power");
      if (paramContext != null)
      {
        if (Build.VERSION.SDK_INT >= 20) {
          return paramContext.isInteractive();
        }
        boolean bool = paramContext.isScreenOn();
        return bool;
      }
    }
    catch (Exception paramContext) {}
    return false;
  }
  
  public static boolean be(Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      try
      {
        paramContext = (PowerManager)paramContext.getSystemService("power");
        if (paramContext != null)
        {
          boolean bool = paramContext.isPowerSaveMode();
          return bool;
        }
      }
      catch (Exception paramContext) {}
    }
    return false;
  }
  
  public static boolean bf(Context paramContext)
  {
    try
    {
      Object localObject = (ActivityManager)paramContext.getSystemService("activity");
      if (localObject != null)
      {
        localObject = ((ActivityManager)localObject).getRunningServices(2147483647);
        if (localObject != null)
        {
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            ActivityManager.RunningServiceInfo localRunningServiceInfo = (ActivityManager.RunningServiceInfo)((Iterator)localObject).next();
            if ((!TextUtils.isEmpty(localRunningServiceInfo.process)) && (localRunningServiceInfo.process.startsWith(paramContext.getPackageName())))
            {
              boolean bool = localRunningServiceInfo.foreground;
              if (bool) {
                return true;
              }
            }
          }
        }
      }
    }
    catch (Throwable paramContext) {}
    return false;
  }
  
  /* Error */
  public static String eu(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 28	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +5 -> 9
    //   7: aconst_null
    //   8: areturn
    //   9: new 204	java/io/RandomAccessFile
    //   12: dup
    //   13: aload_0
    //   14: ldc 206
    //   16: invokespecial 209	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   19: astore_2
    //   20: aload_2
    //   21: invokevirtual 212	java/io/RandomAccessFile:readLine	()Ljava/lang/String;
    //   24: astore_0
    //   25: aload_2
    //   26: invokevirtual 215	java/io/RandomAccessFile:close	()V
    //   29: aload_0
    //   30: areturn
    //   31: astore_1
    //   32: aload_1
    //   33: athrow
    //   34: astore_0
    //   35: aload_1
    //   36: ifnull +33 -> 69
    //   39: aload_2
    //   40: invokevirtual 215	java/io/RandomAccessFile:close	()V
    //   43: aload_0
    //   44: athrow
    //   45: astore_0
    //   46: ldc 217
    //   48: aload_0
    //   49: ldc 219
    //   51: iconst_0
    //   52: anewarray 4	java/lang/Object
    //   55: invokestatic 225	com/tencent/matrix/g/c:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   58: aconst_null
    //   59: areturn
    //   60: astore_2
    //   61: aload_1
    //   62: aload_2
    //   63: invokevirtual 229	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   66: goto -23 -> 43
    //   69: aload_2
    //   70: invokevirtual 215	java/io/RandomAccessFile:close	()V
    //   73: goto -30 -> 43
    //   76: astore_0
    //   77: aconst_null
    //   78: astore_1
    //   79: goto -44 -> 35
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	82	0	paramString	String
    //   31	31	1	localThrowable1	Throwable
    //   78	1	1	localObject	Object
    //   19	21	2	localRandomAccessFile	java.io.RandomAccessFile
    //   60	10	2	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   20	25	31	java/lang/Throwable
    //   32	34	34	finally
    //   9	20	45	java/lang/Throwable
    //   25	29	45	java/lang/Throwable
    //   43	45	45	java/lang/Throwable
    //   61	66	45	java/lang/Throwable
    //   69	73	45	java/lang/Throwable
    //   39	43	60	java/lang/Throwable
    //   20	25	76	finally
  }
  
  private static int getNumCores()
  {
    try
    {
      int i = new File("/sys/devices/system/cpu/").listFiles(new FileFilter()
      {
        public final boolean accept(File paramAnonymousFile)
        {
          return Pattern.matches("cpu[0-9]+", paramAnonymousFile.getName());
        }
      }).length;
      return i;
    }
    catch (Exception localException) {}
    return 1;
  }
  
  public static String getPackageName()
  {
    com.tencent.matrix.a.b localb = (com.tencent.matrix.a.b)com.tencent.matrix.b.RG().Y(com.tencent.matrix.a.b.class);
    if (localb == null) {
      throw new IllegalStateException("BatteryMonitorPlugin is not yet installed!");
    }
    return localb.getPackageName();
  }
  
  public static String getThrowableStack(Throwable paramThrowable)
  {
    return stackTraceToString(paramThrowable.getStackTrace());
  }
  
  public static int k(Context paramContext, boolean paramBoolean)
  {
    if (paramBoolean) {
      return 1;
    }
    if (bf(paramContext)) {
      return 3;
    }
    return 2;
  }
  
  public static String stackTraceToString(StackTraceElement[] paramArrayOfStackTraceElement)
  {
    if (paramArrayOfStackTraceElement == null) {
      return "";
    }
    Object localObject1 = new ArrayList(paramArrayOfStackTraceElement.length);
    int j = paramArrayOfStackTraceElement.length;
    int i = 0;
    Object localObject2;
    while (i < j)
    {
      localObject2 = paramArrayOfStackTraceElement[i];
      String str = ((StackTraceElement)localObject2).getClassName();
      if ((!str.contains("com.tencent.matrix")) && (!str.contains("java.lang.reflect")) && (!str.contains("$Proxy2")) && (!str.contains("android.os"))) {
        ((ArrayList)localObject1).add(localObject2);
      }
      i += 1;
    }
    paramArrayOfStackTraceElement = getPackageName();
    if ((((ArrayList)localObject1).size() > 10) && (!TextUtils.isEmpty(paramArrayOfStackTraceElement)))
    {
      localObject2 = ((ArrayList)localObject1).listIterator(((ArrayList)localObject1).size());
      do
      {
        if (!((ListIterator)localObject2).hasPrevious()) {
          break;
        }
        if (!((StackTraceElement)((ListIterator)localObject2).previous()).getClassName().contains(paramArrayOfStackTraceElement)) {
          ((ListIterator)localObject2).remove();
        }
      } while (((ArrayList)localObject1).size() > 10);
    }
    paramArrayOfStackTraceElement = new StringBuilder(((ArrayList)localObject1).size());
    localObject1 = ((ArrayList)localObject1).iterator();
    while (((Iterator)localObject1).hasNext()) {
      paramArrayOfStackTraceElement.append((StackTraceElement)((Iterator)localObject1).next()).append('\n');
    }
    return paramArrayOfStackTraceElement.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.matrix.a.c.c
 * JD-Core Version:    0.7.0.1
 */