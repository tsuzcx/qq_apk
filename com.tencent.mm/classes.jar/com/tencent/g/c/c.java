package com.tencent.g.c;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.KeyguardManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.PowerManager;
import android.os.Process;
import android.provider.Settings.Secure;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MD5Util;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;

public final class c
{
  public static String bCQ(String paramString)
  {
    AppMethodBeat.i(208235);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(208235);
      return "";
    }
    AppMethodBeat.o(208235);
    return paramString;
  }
  
  /* Error */
  private static String bDY(String paramString)
  {
    // Byte code:
    //   0: ldc 29
    //   2: invokestatic 13	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: ldc 31
    //   7: invokestatic 37	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   10: astore_1
    //   11: aload_1
    //   12: ldc 39
    //   14: iconst_1
    //   15: anewarray 33	java/lang/Class
    //   18: dup
    //   19: iconst_0
    //   20: ldc 41
    //   22: aastore
    //   23: invokevirtual 45	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   26: aload_1
    //   27: iconst_1
    //   28: anewarray 4	java/lang/Object
    //   31: dup
    //   32: iconst_0
    //   33: aload_0
    //   34: aastore
    //   35: invokevirtual 51	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   38: checkcast 41	java/lang/String
    //   41: checkcast 41	java/lang/String
    //   44: astore_0
    //   45: ldc 29
    //   47: invokestatic 22	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   50: aload_0
    //   51: areturn
    //   52: astore_0
    //   53: ldc 29
    //   55: invokestatic 22	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   58: ldc 24
    //   60: areturn
    //   61: astore_0
    //   62: ldc 29
    //   64: invokestatic 22	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   67: ldc 24
    //   69: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	70	0	paramString	String
    //   10	17	1	localClass	Class
    // Exception table:
    //   from	to	target	type
    //   5	45	52	java/lang/Exception
    //   5	45	61	finally
  }
  
  public static String getAppPackageName(Context paramContext)
  {
    AppMethodBeat.i(208246);
    String str = "";
    if (paramContext == null)
    {
      AppMethodBeat.o(208246);
      return "";
    }
    try
    {
      paramContext = paramContext.getPackageName();
      AppMethodBeat.o(208246);
      return paramContext;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        paramContext = str;
      }
    }
  }
  
  public static int getAppVersionCode(Context paramContext)
  {
    int i = -1;
    AppMethodBeat.i(208239);
    if (paramContext == null)
    {
      AppMethodBeat.o(208239);
      return -1;
    }
    PackageManager localPackageManager = paramContext.getPackageManager();
    try
    {
      int j = localPackageManager.getPackageInfo(paramContext.getPackageName(), 0).versionCode;
      i = j;
    }
    catch (Exception paramContext)
    {
      label38:
      break label38;
    }
    AppMethodBeat.o(208239);
    return i;
  }
  
  public static String getAppVersionName(Context paramContext)
  {
    AppMethodBeat.i(208244);
    String str = "";
    if (paramContext == null)
    {
      AppMethodBeat.o(208244);
      return "";
    }
    PackageManager localPackageManager = paramContext.getPackageManager();
    try
    {
      paramContext = localPackageManager.getPackageInfo(paramContext.getPackageName(), 0).versionName;
      AppMethodBeat.o(208244);
      return paramContext;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        paramContext = str;
      }
    }
  }
  
  public static String getProcessName(Context paramContext)
  {
    AppMethodBeat.i(208253);
    if (paramContext == null)
    {
      AppMethodBeat.o(208253);
      return "";
    }
    try
    {
      int i = Process.myPid();
      paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses().iterator();
      while (paramContext.hasNext())
      {
        ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)paramContext.next();
        if (localRunningAppProcessInfo.pid == i)
        {
          paramContext = localRunningAppProcessInfo.processName;
          AppMethodBeat.o(208253);
          return paramContext;
        }
      }
    }
    catch (Throwable paramContext)
    {
      AppMethodBeat.o(208253);
    }
    return "";
  }
  
  public static int getScreenHeight(Context paramContext)
  {
    AppMethodBeat.i(208260);
    try
    {
      paramContext = (WindowManager)paramContext.getSystemService("window");
      DisplayMetrics localDisplayMetrics = new DisplayMetrics();
      paramContext.getDefaultDisplay().getMetrics(localDisplayMetrics);
      int i = localDisplayMetrics.heightPixels;
      AppMethodBeat.o(208260);
      return i;
    }
    catch (Throwable paramContext)
    {
      AppMethodBeat.o(208260);
    }
    return -1;
  }
  
  public static int getScreenOrientation(Context paramContext)
  {
    AppMethodBeat.i(208263);
    try
    {
      paramContext = (WindowManager)paramContext.getSystemService("window");
      DisplayMetrics localDisplayMetrics = new DisplayMetrics();
      paramContext.getDefaultDisplay().getMetrics(localDisplayMetrics);
      int i = localDisplayMetrics.heightPixels;
      int j = localDisplayMetrics.widthPixels;
      if (i > j)
      {
        AppMethodBeat.o(208263);
        return 0;
      }
      AppMethodBeat.o(208263);
      return 1;
    }
    catch (Throwable paramContext)
    {
      AppMethodBeat.o(208263);
    }
    return -1;
  }
  
  public static int getScreenWidth(Context paramContext)
  {
    AppMethodBeat.i(208257);
    try
    {
      paramContext = (WindowManager)paramContext.getSystemService("window");
      DisplayMetrics localDisplayMetrics = new DisplayMetrics();
      paramContext.getDefaultDisplay().getMetrics(localDisplayMetrics);
      int i = localDisplayMetrics.widthPixels;
      AppMethodBeat.o(208257);
      return i;
    }
    catch (Throwable paramContext)
    {
      AppMethodBeat.o(208257);
    }
    return -1;
  }
  
  public static float i(Context paramContext, float paramFloat)
  {
    AppMethodBeat.i(208255);
    paramFloat /= paramContext.getResources().getDisplayMetrics().density;
    AppMethodBeat.o(208255);
    return paramFloat;
  }
  
  /* Error */
  public static String ioo()
  {
    // Byte code:
    //   0: ldc 181
    //   2: invokestatic 13	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 183	java/io/FileInputStream
    //   8: dup
    //   9: ldc 185
    //   11: invokespecial 188	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   14: astore_0
    //   15: new 190	java/io/BufferedReader
    //   18: dup
    //   19: new 192	java/io/InputStreamReader
    //   22: dup
    //   23: aload_0
    //   24: invokespecial 195	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   27: sipush 8192
    //   30: invokespecial 198	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   33: astore_2
    //   34: new 200	java/lang/StringBuilder
    //   37: dup
    //   38: ldc 24
    //   40: invokespecial 201	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   43: astore_1
    //   44: aload_2
    //   45: invokevirtual 204	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   48: astore_3
    //   49: aload_3
    //   50: ifnull +42 -> 92
    //   53: aload_1
    //   54: aload_3
    //   55: invokevirtual 208	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: pop
    //   59: goto -15 -> 44
    //   62: astore_3
    //   63: aload_2
    //   64: invokevirtual 211	java/io/BufferedReader:close	()V
    //   67: aload_0
    //   68: invokevirtual 214	java/io/InputStream:close	()V
    //   71: aload_1
    //   72: invokevirtual 217	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   75: astore_0
    //   76: ldc 181
    //   78: invokestatic 22	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   81: aload_0
    //   82: areturn
    //   83: astore_0
    //   84: ldc 181
    //   86: invokestatic 22	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   89: ldc 24
    //   91: areturn
    //   92: aload_2
    //   93: invokevirtual 211	java/io/BufferedReader:close	()V
    //   96: aload_0
    //   97: invokevirtual 214	java/io/InputStream:close	()V
    //   100: aload_1
    //   101: invokevirtual 217	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   104: astore_0
    //   105: goto -29 -> 76
    //   108: astore_1
    //   109: aload_2
    //   110: invokevirtual 211	java/io/BufferedReader:close	()V
    //   113: aload_0
    //   114: invokevirtual 214	java/io/InputStream:close	()V
    //   117: ldc 181
    //   119: invokestatic 22	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   122: aload_1
    //   123: athrow
    //   124: astore_2
    //   125: goto -29 -> 96
    //   128: astore_0
    //   129: goto -29 -> 100
    //   132: astore_2
    //   133: goto -66 -> 67
    //   136: astore_0
    //   137: goto -66 -> 71
    //   140: astore_2
    //   141: goto -28 -> 113
    //   144: astore_0
    //   145: goto -28 -> 117
    // Local variable table:
    //   start	length	slot	name	signature
    //   14	68	0	localObject1	Object
    //   83	14	0	localThrowable1	Throwable
    //   104	10	0	str1	String
    //   128	1	0	localThrowable2	Throwable
    //   136	1	0	localThrowable3	Throwable
    //   144	1	0	localThrowable4	Throwable
    //   43	58	1	localStringBuilder	java.lang.StringBuilder
    //   108	15	1	localObject2	Object
    //   33	77	2	localBufferedReader	java.io.BufferedReader
    //   124	1	2	localThrowable5	Throwable
    //   132	1	2	localThrowable6	Throwable
    //   140	1	2	localThrowable7	Throwable
    //   48	7	3	str2	String
    //   62	1	3	localThrowable8	Throwable
    // Exception table:
    //   from	to	target	type
    //   44	49	62	java/lang/Throwable
    //   53	59	62	java/lang/Throwable
    //   5	15	83	java/lang/Throwable
    //   44	49	108	finally
    //   53	59	108	finally
    //   92	96	124	java/lang/Throwable
    //   96	100	128	java/lang/Throwable
    //   63	67	132	java/lang/Throwable
    //   67	71	136	java/lang/Throwable
    //   109	113	140	java/lang/Throwable
    //   113	117	144	java/lang/Throwable
  }
  
  public static String ity()
  {
    int i = 0;
    AppMethodBeat.i(208266);
    String str1 = null;
    String str2 = d.U(d.ZRB);
    String str3 = d.U(d.ZRC);
    for (;;)
    {
      if (i < 2)
      {
        str1 = bDY(new String[] { str2, str3 }[i]);
        if (!TextUtils.isEmpty(str1)) {
          str1 = MD5Util.getMD5String("[TuringSMI]".concat(String.valueOf(str1)));
        }
      }
      else
      {
        AppMethodBeat.o(208266);
        return str1;
      }
      i += 1;
    }
  }
  
  public static String lX(Context paramContext)
  {
    AppMethodBeat.i(208224);
    try
    {
      paramContext = MD5Util.getMD5String("[TuringSMI]".concat(String.valueOf(Settings.Secure.getString(paramContext.getContentResolver(), "android_id"))));
      AppMethodBeat.o(208224);
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      AppMethodBeat.o(208224);
    }
    return "";
  }
  
  public static int mp(Context paramContext)
  {
    AppMethodBeat.i(208248);
    for (;;)
    {
      try
      {
        boolean bool = ((KeyguardManager)paramContext.getSystemService("keyguard")).inKeyguardRestrictedInputMode();
        if (!bool) {
          continue;
        }
        i = 0;
      }
      catch (Throwable paramContext)
      {
        i.b("DeviceUtil", paramContext);
        int i = 0;
        continue;
      }
      AppMethodBeat.o(208248);
      return i;
      i = 1;
    }
  }
  
  public static int mq(Context paramContext)
  {
    m = 1;
    AppMethodBeat.i(208251);
    for (;;)
    {
      try
      {
        if (Build.VERSION.SDK_INT <= 19) {
          continue;
        }
        localObject1 = Class.forName("android.hardware.display.DisplayManager");
        localField = paramContext.getClass().getField("DISPLAY_SERVICE");
        localField.setAccessible(true);
        paramContext = paramContext.getSystemService((String)localField.get(paramContext));
        if (paramContext != null) {
          continue;
        }
        i = -1;
      }
      catch (Throwable paramContext)
      {
        Object localObject1;
        Field localField;
        int n;
        int k;
        Object localObject2;
        boolean bool;
        i.b("DeviceUtil", paramContext);
        int i = -1;
        continue;
        i = j;
        k += 1;
        int j = i;
        continue;
        i = m;
        if (j != 0) {
          continue;
        }
        i = 0;
        continue;
      }
      AppMethodBeat.o(208251);
      return i;
      localObject1 = ((Class)localObject1).getMethod("getDisplays", new Class[0]);
      if (localObject1 == null)
      {
        i = -1;
      }
      else
      {
        ((Method)localObject1).setAccessible(true);
        paramContext = (Display[])((Method)localObject1).invoke(paramContext, new Object[0]);
        localObject1 = Display.class.getMethod("getState", new Class[0]);
        ((Method)localObject1).setAccessible(true);
        localField = Display.class.getField("STATE_OFF");
        localField.setAccessible(true);
        n = paramContext.length;
        k = 0;
        j = 0;
        if (k >= n) {
          continue;
        }
        localObject2 = paramContext[k];
        i = localField.getInt(localObject2);
        if (((Integer)((Method)localObject1).invoke(localObject2, new Object[0])).intValue() == i) {
          continue;
        }
        i = 1;
        continue;
        paramContext = (PowerManager)paramContext.getSystemService("power");
        if (paramContext == null)
        {
          AppMethodBeat.o(208251);
          return -1;
        }
        bool = paramContext.isScreenOn();
        i = m;
        if (!bool) {
          i = 0;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.g.c.c
 * JD-Core Version:    0.7.0.1
 */