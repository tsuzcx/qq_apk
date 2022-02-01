package com.tencent.g.c;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.PowerManager;
import android.os.Process;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;

public final class c
{
  private static String ahVW;
  private static final String zxT;
  
  static
  {
    AppMethodBeat.i(212165);
    Object localObject = MMApplicationContext.getContext().getContentResolver();
    localObject = new com.tencent.mm.hellhoundlib.b.a().cG("android_id").cG(localObject);
    zxT = (String)com.tencent.mm.hellhoundlib.a.a.a(new Object(), ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/turingshield/utils/DeviceUtil", "<clinit>", "()V", "android/provider/Settings$Secure", "getString", "(Landroid/content/ContentResolver;Ljava/lang/String;)Ljava/lang/String;");
    AppMethodBeat.o(212165);
  }
  
  public static String bFv(String paramString)
  {
    AppMethodBeat.i(212066);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(212066);
      return "";
    }
    AppMethodBeat.o(212066);
    return paramString;
  }
  
  /* Error */
  private static String bGx(String paramString)
  {
    // Byte code:
    //   0: ldc 83
    //   2: invokestatic 16	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: ldc 85
    //   7: invokestatic 91	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   10: astore_1
    //   11: aload_1
    //   12: ldc 93
    //   14: iconst_1
    //   15: anewarray 87	java/lang/Class
    //   18: dup
    //   19: iconst_0
    //   20: ldc 62
    //   22: aastore
    //   23: invokevirtual 97	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   26: aload_1
    //   27: iconst_1
    //   28: anewarray 4	java/lang/Object
    //   31: dup
    //   32: iconst_0
    //   33: aload_0
    //   34: aastore
    //   35: invokevirtual 103	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   38: checkcast 62	java/lang/String
    //   41: astore_0
    //   42: ldc 83
    //   44: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   47: aload_0
    //   48: areturn
    //   49: astore_0
    //   50: ldc 83
    //   52: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   55: ldc 79
    //   57: areturn
    //   58: astore_0
    //   59: ldc 83
    //   61: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   64: ldc 79
    //   66: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	67	0	paramString	String
    //   10	17	1	localClass	Class
    // Exception table:
    //   from	to	target	type
    //   5	42	49	java/lang/Exception
    //   5	42	58	finally
  }
  
  public static String getAppPackageName(Context paramContext)
  {
    AppMethodBeat.i(212091);
    String str = "";
    if (paramContext == null)
    {
      AppMethodBeat.o(212091);
      return "";
    }
    try
    {
      paramContext = paramContext.getPackageName();
      AppMethodBeat.o(212091);
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
    AppMethodBeat.i(212072);
    if (paramContext == null)
    {
      AppMethodBeat.o(212072);
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
    AppMethodBeat.o(212072);
    return i;
  }
  
  public static String getAppVersionName(Context paramContext)
  {
    AppMethodBeat.i(212083);
    String str = "";
    if (paramContext == null)
    {
      AppMethodBeat.o(212083);
      return "";
    }
    PackageManager localPackageManager = paramContext.getPackageManager();
    try
    {
      paramContext = localPackageManager.getPackageInfo(paramContext.getPackageName(), 0).versionName;
      AppMethodBeat.o(212083);
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
  
  public static String getModelName()
  {
    if (ahVW == null) {
      ahVW = Build.MODEL;
    }
    return ahVW;
  }
  
  public static String getProcessName(Context paramContext)
  {
    AppMethodBeat.i(212112);
    if (paramContext == null)
    {
      AppMethodBeat.o(212112);
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
          return paramContext;
        }
      }
    }
    finally
    {
      AppMethodBeat.o(212112);
    }
    return "";
  }
  
  public static int getScreenHeight(Context paramContext)
  {
    AppMethodBeat.i(212134);
    try
    {
      paramContext = (WindowManager)paramContext.getSystemService("window");
      DisplayMetrics localDisplayMetrics = new DisplayMetrics();
      paramContext.getDefaultDisplay().getMetrics(localDisplayMetrics);
      int i = localDisplayMetrics.heightPixels;
      return i;
    }
    finally
    {
      AppMethodBeat.o(212134);
    }
    return -1;
  }
  
  public static int getScreenOrientation(Context paramContext)
  {
    AppMethodBeat.i(212141);
    try
    {
      paramContext = (WindowManager)paramContext.getSystemService("window");
      DisplayMetrics localDisplayMetrics = new DisplayMetrics();
      paramContext.getDefaultDisplay().getMetrics(localDisplayMetrics);
      int i = localDisplayMetrics.heightPixels;
      int j = localDisplayMetrics.widthPixels;
      if (i > j) {
        return 0;
      }
      return 1;
    }
    finally
    {
      AppMethodBeat.o(212141);
    }
    return -1;
  }
  
  public static int getScreenWidth(Context paramContext)
  {
    AppMethodBeat.i(212126);
    try
    {
      paramContext = (WindowManager)paramContext.getSystemService("window");
      DisplayMetrics localDisplayMetrics = new DisplayMetrics();
      paramContext.getDefaultDisplay().getMetrics(localDisplayMetrics);
      int i = localDisplayMetrics.widthPixels;
      return i;
    }
    finally
    {
      AppMethodBeat.o(212126);
    }
    return -1;
  }
  
  public static float j(Context paramContext, float paramFloat)
  {
    AppMethodBeat.i(212121);
    paramFloat /= paramContext.getResources().getDisplayMetrics().density;
    AppMethodBeat.o(212121);
    return paramFloat;
  }
  
  public static String jXA()
  {
    AppMethodBeat.i(212048);
    try
    {
      String str = MD5Util.getMD5String("[TuringSMI]".concat(String.valueOf(zxT)));
      return str;
    }
    finally
    {
      AppMethodBeat.o(212048);
    }
    return "";
  }
  
  /* Error */
  public static String jXB()
  {
    // Byte code:
    //   0: ldc 250
    //   2: invokestatic 16	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 252	java/io/FileInputStream
    //   8: dup
    //   9: ldc 254
    //   11: invokespecial 257	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   14: astore_1
    //   15: new 259	java/io/BufferedReader
    //   18: dup
    //   19: new 261	java/io/InputStreamReader
    //   22: dup
    //   23: aload_1
    //   24: invokespecial 264	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   27: sipush 8192
    //   30: invokespecial 267	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   33: astore_2
    //   34: new 269	java/lang/StringBuilder
    //   37: dup
    //   38: ldc 79
    //   40: invokespecial 270	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   43: astore_0
    //   44: aload_2
    //   45: invokevirtual 273	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   48: astore_3
    //   49: aload_3
    //   50: ifnull +42 -> 92
    //   53: aload_0
    //   54: aload_3
    //   55: invokevirtual 277	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: pop
    //   59: goto -15 -> 44
    //   62: astore_3
    //   63: aload_2
    //   64: invokevirtual 280	java/io/BufferedReader:close	()V
    //   67: aload_1
    //   68: invokevirtual 283	java/io/InputStream:close	()V
    //   71: aload_0
    //   72: invokevirtual 286	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   75: astore_0
    //   76: ldc 250
    //   78: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   81: aload_0
    //   82: areturn
    //   83: astore_0
    //   84: ldc 250
    //   86: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   89: ldc 79
    //   91: areturn
    //   92: aload_2
    //   93: invokevirtual 280	java/io/BufferedReader:close	()V
    //   96: aload_1
    //   97: invokevirtual 283	java/io/InputStream:close	()V
    //   100: aload_0
    //   101: invokevirtual 286	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   104: astore_0
    //   105: goto -29 -> 76
    //   108: astore_2
    //   109: goto -13 -> 96
    //   112: astore_1
    //   113: goto -13 -> 100
    //   116: astore_2
    //   117: goto -50 -> 67
    //   120: astore_1
    //   121: goto -50 -> 71
    // Local variable table:
    //   start	length	slot	name	signature
    //   43	39	0	localObject1	Object
    //   83	18	0	localObject2	Object
    //   104	1	0	str1	String
    //   14	83	1	localFileInputStream	java.io.FileInputStream
    //   112	1	1	localObject3	Object
    //   120	1	1	localObject4	Object
    //   33	60	2	localBufferedReader	java.io.BufferedReader
    //   108	1	2	localObject5	Object
    //   116	1	2	localObject6	Object
    //   48	7	3	str2	String
    //   62	1	3	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   44	49	62	finally
    //   53	59	62	finally
    //   5	15	83	finally
    //   92	96	108	finally
    //   96	100	112	finally
    //   63	67	116	finally
    //   67	71	120	finally
  }
  
  public static String kcQ()
  {
    return "1234567890ABCDEF";
  }
  
  public static String kcR()
  {
    return "";
  }
  
  public static String kcS()
  {
    return "";
  }
  
  public static String kcT()
  {
    int i = 0;
    AppMethodBeat.i(212145);
    String str1 = null;
    String str2 = d.W(d.ahVY);
    String str3 = d.W(d.ahVZ);
    for (;;)
    {
      if (i < 2)
      {
        str1 = bGx(new String[] { str2, str3 }[i]);
        if (!TextUtils.isEmpty(str1)) {
          str1 = MD5Util.getMD5String("[TuringSMI]".concat(String.valueOf(str1)));
        }
      }
      else
      {
        AppMethodBeat.o(212145);
        return str1;
      }
      i += 1;
    }
  }
  
  /* Error */
  public static int oF(Context paramContext)
  {
    // Byte code:
    //   0: ldc_w 310
    //   3: invokestatic 16	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: ldc_w 312
    //   10: invokevirtual 156	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   13: checkcast 314	android/app/KeyguardManager
    //   16: invokevirtual 317	android/app/KeyguardManager:inKeyguardRestrictedInputMode	()Z
    //   19: istore_2
    //   20: iload_2
    //   21: ifeq +13 -> 34
    //   24: iconst_0
    //   25: istore_1
    //   26: ldc_w 310
    //   29: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   32: iload_1
    //   33: ireturn
    //   34: iconst_1
    //   35: istore_1
    //   36: goto -10 -> 26
    //   39: astore_0
    //   40: ldc_w 319
    //   43: aload_0
    //   44: invokestatic 325	com/tencent/g/c/i:h	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   47: iconst_0
    //   48: istore_1
    //   49: goto -23 -> 26
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	52	0	paramContext	Context
    //   25	24	1	i	int
    //   19	2	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   6	20	39	finally
  }
  
  public static int oG(Context paramContext)
  {
    m = 1;
    AppMethodBeat.i(212108);
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
      finally
      {
        Object localObject1;
        Field localField;
        int n;
        int k;
        Object localObject2;
        boolean bool;
        i.h("DeviceUtil", paramContext);
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
      AppMethodBeat.o(212108);
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
          AppMethodBeat.o(212108);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.g.c.c
 * JD-Core Version:    0.7.0.1
 */