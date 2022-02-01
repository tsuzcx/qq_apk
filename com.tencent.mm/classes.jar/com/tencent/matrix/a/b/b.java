package com.tencent.matrix.a.b;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningServiceInfo;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build.VERSION;
import android.os.PowerManager;
import android.os.SystemClock;
import android.text.TextUtils;
import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.regex.Pattern;

public final class b
{
  static a eTy = new a()
  {
    private b.a.a eTA;
    private b.a.a eTB;
    private b.a.a eTz;
    private String mPackageName;
    
    public final int bU(Context paramAnonymousContext)
    {
      if ((this.eTz != null) && (!this.eTz.isExpired())) {
        return this.eTz.value;
      }
      this.eTz = new b.a.a(b.bV(paramAnonymousContext));
      return this.eTz.value;
    }
    
    public final int cd(Context paramAnonymousContext)
    {
      if ((this.eTB != null) && (!this.eTB.isExpired())) {
        return this.eTB.value;
      }
      this.eTB = new b.a.a(b.bX(paramAnonymousContext));
      return this.eTB.value;
    }
    
    public final String getPackageName()
    {
      if (!TextUtils.isEmpty(this.mPackageName)) {
        return this.mPackageName;
      }
      com.tencent.matrix.a.c localc = (com.tencent.matrix.a.c)com.tencent.matrix.c.avW().ai(com.tencent.matrix.a.c.class);
      if (localc == null) {
        throw new IllegalStateException("BatteryMonitorPlugin is not yet installed!");
      }
      this.mPackageName = localc.getPackageName();
      return this.mPackageName;
    }
    
    public final int k(Context paramAnonymousContext, boolean paramAnonymousBoolean)
    {
      if (paramAnonymousBoolean) {
        return 1;
      }
      if ((this.eTA != null) && (!this.eTA.isExpired())) {
        return this.eTA.value;
      }
      this.eTA = new b.a.a(b.l(paramAnonymousContext, false));
      return this.eTA.value;
    }
    
    public final void na(int paramAnonymousInt)
    {
      try
      {
        this.eTA = new b.a.a(paramAnonymousInt);
        return;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
    
    public final void nb(int paramAnonymousInt)
    {
      try
      {
        this.eTB = new b.a.a(paramAnonymousInt);
        return;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
  };
  
  public static long L(long paramLong1, long paramLong2)
  {
    if (paramLong2 < 60000L) {
      return paramLong1 / Math.max(1L, paramLong2 * 100L / 60000L) * 100L;
    }
    return paramLong1 / Math.max(1L, paramLong2 / 60000L);
  }
  
  public static String R(String paramString1, String paramString2)
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
  
  public static a axp()
  {
    return eTy;
  }
  
  public static int[] axq()
  {
    int[] arrayOfInt = new int[axr()];
    int i = 0;
    for (;;)
    {
      String str;
      if (i < axr())
      {
        arrayOfInt[i] = 0;
        str = gy("/sys/devices/system/cpu/cpu" + i + "/cpufreq/scaling_cur_freq");
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
  
  public static int axr()
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
  
  public static int bU(Context paramContext)
  {
    return eTy.bU(paramContext);
  }
  
  public static int bV(Context paramContext)
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
    finally {}
    return 0;
  }
  
  public static int bW(Context paramContext)
  {
    return eTy.cd(paramContext);
  }
  
  public static int bX(Context paramContext)
  {
    if (bY(paramContext)) {
      return 1;
    }
    if (!ca(paramContext)) {
      return 3;
    }
    if (cb(paramContext)) {
      return 4;
    }
    return 2;
  }
  
  private static boolean bY(Context paramContext)
  {
    try
    {
      paramContext = paramContext.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
      if (paramContext == null) {
        return false;
      }
      int i = paramContext.getIntExtra("status", -1);
      if ((i == 2) || (i == 5)) {
        return true;
      }
    }
    finally {}
    return false;
  }
  
  public static boolean bZ(Context paramContext)
  {
    return bY(paramContext);
  }
  
  public static boolean ca(Context paramContext)
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
  
  public static boolean cb(Context paramContext)
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
  
  public static boolean cc(Context paramContext)
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
    finally {}
    return false;
  }
  
  public static String getThrowableStack(Throwable paramThrowable)
  {
    return stackTraceToString(paramThrowable.getStackTrace());
  }
  
  /* Error */
  public static String gy(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 53	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +5 -> 9
    //   7: aconst_null
    //   8: areturn
    //   9: new 249	java/io/RandomAccessFile
    //   12: dup
    //   13: aload_0
    //   14: ldc 251
    //   16: invokespecial 254	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   19: astore_0
    //   20: aload_0
    //   21: invokevirtual 257	java/io/RandomAccessFile:readLine	()Ljava/lang/String;
    //   24: astore_1
    //   25: aload_0
    //   26: invokevirtual 260	java/io/RandomAccessFile:close	()V
    //   29: aload_1
    //   30: areturn
    //   31: astore_1
    //   32: aload_1
    //   33: athrow
    //   34: astore_2
    //   35: aload_1
    //   36: ifnull +35 -> 71
    //   39: aload_0
    //   40: invokevirtual 260	java/io/RandomAccessFile:close	()V
    //   43: aload_2
    //   44: athrow
    //   45: astore_0
    //   46: ldc_w 262
    //   49: aload_0
    //   50: ldc_w 264
    //   53: iconst_0
    //   54: anewarray 4	java/lang/Object
    //   57: invokestatic 270	com/tencent/matrix/e/c:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   60: aconst_null
    //   61: areturn
    //   62: astore_0
    //   63: aload_1
    //   64: aload_0
    //   65: invokevirtual 274	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   68: goto -25 -> 43
    //   71: aload_0
    //   72: invokevirtual 260	java/io/RandomAccessFile:close	()V
    //   75: goto -32 -> 43
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	78	0	paramString	String
    //   24	6	1	str	String
    //   31	33	1	localObject1	Object
    //   34	10	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   20	25	31	finally
    //   32	34	34	finally
    //   9	20	45	finally
    //   25	29	45	finally
    //   43	45	45	finally
    //   63	68	45	finally
    //   71	75	45	finally
    //   39	43	62	finally
  }
  
  public static int k(Context paramContext, boolean paramBoolean)
  {
    return eTy.k(paramContext, paramBoolean);
  }
  
  public static int l(Context paramContext, boolean paramBoolean)
  {
    if (paramBoolean) {
      return 1;
    }
    if (cc(paramContext)) {
      return 3;
    }
    return 2;
  }
  
  public static String mY(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "unknown";
    case 1: 
      return "fg";
    case 2: 
      return "bg";
    }
    return "fgSrv";
  }
  
  public static String mZ(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "unknown";
    case 1: 
      return "charging";
    case 2: 
      return "non_charge";
    case 3: 
      return "screen_off";
    }
    return "doze";
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
    paramArrayOfStackTraceElement = eTy.getPackageName();
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
    paramArrayOfStackTraceElement = new StringBuilder();
    localObject1 = ((ArrayList)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (StackTraceElement)((Iterator)localObject1).next();
      paramArrayOfStackTraceElement.append("\nat ").append(localObject2);
    }
    if (paramArrayOfStackTraceElement.length() > 0) {
      return "Matrix" + paramArrayOfStackTraceElement.toString();
    }
    return "";
  }
  
  public static abstract interface a
  {
    public abstract int bU(Context paramContext);
    
    public abstract int cd(Context paramContext);
    
    public abstract String getPackageName();
    
    public abstract int k(Context paramContext, boolean paramBoolean);
    
    public abstract void na(int paramInt);
    
    public abstract void nb(int paramInt);
    
    public static final class a
    {
      final long eTC;
      final long eTD;
      final int value;
      
      a(int paramInt)
      {
        this.value = paramInt;
        this.eTC = 5000L;
        this.eTD = SystemClock.uptimeMillis();
      }
      
      final boolean isExpired()
      {
        return SystemClock.uptimeMillis() - this.eTD >= this.eTC;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.matrix.a.b.b
 * JD-Core Version:    0.7.0.1
 */