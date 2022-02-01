package com.tencent.h.c;

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
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;

public final class c
{
  /* Error */
  public static String DO(boolean paramBoolean)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: ldc 11
    //   5: invokestatic 17	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: iload_0
    //   9: ifeq +137 -> 146
    //   12: ldc 19
    //   14: astore_3
    //   15: ldc 21
    //   17: astore_2
    //   18: new 23	java/io/BufferedReader
    //   21: dup
    //   22: new 25	java/io/FileReader
    //   25: dup
    //   26: new 27	java/lang/StringBuilder
    //   29: dup
    //   30: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   33: aload_3
    //   34: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: ldc 37
    //   39: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   45: invokespecial 44	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   48: invokespecial 47	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   51: astore_1
    //   52: aload_1
    //   53: invokevirtual 50	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   56: astore 6
    //   58: aload 5
    //   60: astore 4
    //   62: aload 6
    //   64: ifnull +94 -> 158
    //   67: aload 5
    //   69: astore 4
    //   71: aload 6
    //   73: invokevirtual 55	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   76: aload_2
    //   77: invokevirtual 59	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   80: ifeq +78 -> 158
    //   83: new 23	java/io/BufferedReader
    //   86: dup
    //   87: new 25	java/io/FileReader
    //   90: dup
    //   91: new 27	java/lang/StringBuilder
    //   94: dup
    //   95: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   98: aload_3
    //   99: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: ldc 61
    //   104: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   110: invokespecial 44	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   113: invokespecial 47	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   116: astore_2
    //   117: aload_2
    //   118: invokevirtual 50	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   121: astore_3
    //   122: aload_3
    //   123: ifnull +32 -> 155
    //   126: aload_3
    //   127: invokevirtual 64	java/lang/String:trim	()Ljava/lang/String;
    //   130: astore_3
    //   131: aload_1
    //   132: invokevirtual 67	java/io/BufferedReader:close	()V
    //   135: aload_2
    //   136: invokevirtual 67	java/io/BufferedReader:close	()V
    //   139: ldc 11
    //   141: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   144: aload_3
    //   145: areturn
    //   146: ldc 72
    //   148: astore_3
    //   149: ldc 74
    //   151: astore_2
    //   152: goto -134 -> 18
    //   155: aload_2
    //   156: astore 4
    //   158: aload_1
    //   159: invokevirtual 67	java/io/BufferedReader:close	()V
    //   162: aload 4
    //   164: ifnull +8 -> 172
    //   167: aload 4
    //   169: invokevirtual 67	java/io/BufferedReader:close	()V
    //   172: ldc 11
    //   174: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   177: ldc 76
    //   179: areturn
    //   180: astore_1
    //   181: aconst_null
    //   182: astore_1
    //   183: aconst_null
    //   184: astore_2
    //   185: aload_2
    //   186: ifnull +7 -> 193
    //   189: aload_2
    //   190: invokevirtual 67	java/io/BufferedReader:close	()V
    //   193: aload_1
    //   194: ifnull -22 -> 172
    //   197: aload_1
    //   198: invokevirtual 67	java/io/BufferedReader:close	()V
    //   201: goto -29 -> 172
    //   204: astore_1
    //   205: goto -33 -> 172
    //   208: astore_3
    //   209: aconst_null
    //   210: astore_2
    //   211: aconst_null
    //   212: astore_1
    //   213: aload_1
    //   214: ifnull +7 -> 221
    //   217: aload_1
    //   218: invokevirtual 67	java/io/BufferedReader:close	()V
    //   221: aload_2
    //   222: ifnull +7 -> 229
    //   225: aload_2
    //   226: invokevirtual 67	java/io/BufferedReader:close	()V
    //   229: ldc 11
    //   231: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   234: aload_3
    //   235: athrow
    //   236: astore_1
    //   237: goto -102 -> 135
    //   240: astore_1
    //   241: goto -102 -> 139
    //   244: astore_1
    //   245: goto -83 -> 162
    //   248: astore_1
    //   249: goto -77 -> 172
    //   252: astore_2
    //   253: goto -60 -> 193
    //   256: astore_1
    //   257: goto -36 -> 221
    //   260: astore_1
    //   261: goto -32 -> 229
    //   264: astore_3
    //   265: aconst_null
    //   266: astore_2
    //   267: goto -54 -> 213
    //   270: astore_3
    //   271: goto -58 -> 213
    //   274: astore_2
    //   275: aconst_null
    //   276: astore_3
    //   277: aload_1
    //   278: astore_2
    //   279: aload_3
    //   280: astore_1
    //   281: goto -96 -> 185
    //   284: astore_3
    //   285: aload_1
    //   286: astore_3
    //   287: aload_2
    //   288: astore_1
    //   289: aload_3
    //   290: astore_2
    //   291: goto -106 -> 185
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	294	0	paramBoolean	boolean
    //   51	108	1	localBufferedReader	java.io.BufferedReader
    //   180	1	1	localThrowable1	Throwable
    //   182	16	1	localObject1	Object
    //   204	1	1	localIOException1	java.io.IOException
    //   212	6	1	localObject2	Object
    //   236	1	1	localIOException2	java.io.IOException
    //   240	1	1	localIOException3	java.io.IOException
    //   244	1	1	localIOException4	java.io.IOException
    //   248	1	1	localIOException5	java.io.IOException
    //   256	1	1	localIOException6	java.io.IOException
    //   260	18	1	localIOException7	java.io.IOException
    //   280	9	1	localObject3	Object
    //   17	209	2	localObject4	Object
    //   252	1	2	localIOException8	java.io.IOException
    //   266	1	2	localObject5	Object
    //   274	1	2	localThrowable2	Throwable
    //   278	13	2	localObject6	Object
    //   14	135	3	str1	String
    //   208	27	3	localObject7	Object
    //   264	1	3	localObject8	Object
    //   270	1	3	localObject9	Object
    //   276	4	3	localObject10	Object
    //   284	1	3	localThrowable3	Throwable
    //   286	4	3	localObject11	Object
    //   60	108	4	localObject12	Object
    //   1	67	5	localObject13	Object
    //   56	16	6	str2	String
    // Exception table:
    //   from	to	target	type
    //   18	52	180	java/lang/Throwable
    //   197	201	204	java/io/IOException
    //   18	52	208	finally
    //   131	135	236	java/io/IOException
    //   135	139	240	java/io/IOException
    //   158	162	244	java/io/IOException
    //   167	172	248	java/io/IOException
    //   189	193	252	java/io/IOException
    //   217	221	256	java/io/IOException
    //   225	229	260	java/io/IOException
    //   52	58	264	finally
    //   71	117	264	finally
    //   117	122	270	finally
    //   126	131	270	finally
    //   52	58	274	java/lang/Throwable
    //   71	117	274	java/lang/Throwable
    //   117	122	284	java/lang/Throwable
    //   126	131	284	java/lang/Throwable
  }
  
  public static String bpY(String paramString)
  {
    AppMethodBeat.i(214625);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(214625);
      return "";
    }
    AppMethodBeat.o(214625);
    return paramString;
  }
  
  /* Error */
  private static String bqZ(String paramString)
  {
    // Byte code:
    //   0: ldc 90
    //   2: invokestatic 17	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: ldc 92
    //   7: invokestatic 98	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   10: astore_1
    //   11: aload_1
    //   12: ldc 100
    //   14: iconst_1
    //   15: anewarray 94	java/lang/Class
    //   18: dup
    //   19: iconst_0
    //   20: ldc 52
    //   22: aastore
    //   23: invokevirtual 104	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   26: aload_1
    //   27: iconst_1
    //   28: anewarray 4	java/lang/Object
    //   31: dup
    //   32: iconst_0
    //   33: aload_0
    //   34: aastore
    //   35: invokevirtual 110	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   38: checkcast 52	java/lang/String
    //   41: checkcast 52	java/lang/String
    //   44: astore_0
    //   45: ldc 90
    //   47: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   50: aload_0
    //   51: areturn
    //   52: astore_0
    //   53: ldc 90
    //   55: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   58: ldc 76
    //   60: areturn
    //   61: astore_0
    //   62: ldc 90
    //   64: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   67: ldc 76
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
    AppMethodBeat.i(214628);
    String str = "";
    if (paramContext == null)
    {
      AppMethodBeat.o(214628);
      return "";
    }
    try
    {
      paramContext = paramContext.getPackageName();
      AppMethodBeat.o(214628);
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
    AppMethodBeat.i(214626);
    if (paramContext == null)
    {
      AppMethodBeat.o(214626);
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
    AppMethodBeat.o(214626);
    return i;
  }
  
  public static String getAppVersionName(Context paramContext)
  {
    AppMethodBeat.i(214627);
    String str = "";
    if (paramContext == null)
    {
      AppMethodBeat.o(214627);
      return "";
    }
    PackageManager localPackageManager = paramContext.getPackageManager();
    try
    {
      paramContext = localPackageManager.getPackageInfo(paramContext.getPackageName(), 0).versionName;
      AppMethodBeat.o(214627);
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
  
  public static String getIMEI(Context paramContext)
  {
    AppMethodBeat.i(214620);
    try
    {
      paramContext = ((TelephonyManager)paramContext.getSystemService("phone")).getDeviceId();
      AppMethodBeat.o(214620);
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        paramContext = "";
      }
    }
  }
  
  public static String getProcessName(Context paramContext)
  {
    AppMethodBeat.i(214631);
    if (paramContext == null)
    {
      AppMethodBeat.o(214631);
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
          AppMethodBeat.o(214631);
          return paramContext;
        }
      }
    }
    catch (Throwable paramContext)
    {
      AppMethodBeat.o(214631);
    }
    return "";
  }
  
  public static int getScreenHeight(Context paramContext)
  {
    AppMethodBeat.i(214634);
    try
    {
      paramContext = (WindowManager)paramContext.getSystemService("window");
      DisplayMetrics localDisplayMetrics = new DisplayMetrics();
      paramContext.getDefaultDisplay().getMetrics(localDisplayMetrics);
      int i = localDisplayMetrics.heightPixels;
      AppMethodBeat.o(214634);
      return i;
    }
    catch (Throwable paramContext)
    {
      AppMethodBeat.o(214634);
    }
    return -1;
  }
  
  public static int getScreenOrientation(Context paramContext)
  {
    AppMethodBeat.i(214635);
    try
    {
      paramContext = (WindowManager)paramContext.getSystemService("window");
      DisplayMetrics localDisplayMetrics = new DisplayMetrics();
      paramContext.getDefaultDisplay().getMetrics(localDisplayMetrics);
      int i = localDisplayMetrics.heightPixels;
      int j = localDisplayMetrics.widthPixels;
      if (i > j)
      {
        AppMethodBeat.o(214635);
        return 0;
      }
      AppMethodBeat.o(214635);
      return 1;
    }
    catch (Throwable paramContext)
    {
      AppMethodBeat.o(214635);
    }
    return -1;
  }
  
  public static int getScreenWidth(Context paramContext)
  {
    AppMethodBeat.i(214633);
    try
    {
      paramContext = (WindowManager)paramContext.getSystemService("window");
      DisplayMetrics localDisplayMetrics = new DisplayMetrics();
      paramContext.getDefaultDisplay().getMetrics(localDisplayMetrics);
      int i = localDisplayMetrics.widthPixels;
      AppMethodBeat.o(214633);
      return i;
    }
    catch (Throwable paramContext)
    {
      AppMethodBeat.o(214633);
    }
    return -1;
  }
  
  /* Error */
  public static String hkQ()
  {
    // Byte code:
    //   0: ldc 227
    //   2: invokestatic 17	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 229	java/io/FileInputStream
    //   8: dup
    //   9: ldc 231
    //   11: invokespecial 232	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   14: astore_0
    //   15: new 23	java/io/BufferedReader
    //   18: dup
    //   19: new 234	java/io/InputStreamReader
    //   22: dup
    //   23: aload_0
    //   24: invokespecial 237	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   27: sipush 8192
    //   30: invokespecial 240	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   33: astore_2
    //   34: new 27	java/lang/StringBuilder
    //   37: dup
    //   38: ldc 76
    //   40: invokespecial 241	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   43: astore_1
    //   44: aload_2
    //   45: invokevirtual 50	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   48: astore_3
    //   49: aload_3
    //   50: ifnull +42 -> 92
    //   53: aload_1
    //   54: aload_3
    //   55: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: pop
    //   59: goto -15 -> 44
    //   62: astore_3
    //   63: aload_2
    //   64: invokevirtual 67	java/io/BufferedReader:close	()V
    //   67: aload_0
    //   68: invokevirtual 244	java/io/InputStream:close	()V
    //   71: aload_1
    //   72: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   75: astore_0
    //   76: ldc 227
    //   78: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   81: aload_0
    //   82: areturn
    //   83: astore_0
    //   84: ldc 227
    //   86: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   89: ldc 76
    //   91: areturn
    //   92: aload_2
    //   93: invokevirtual 67	java/io/BufferedReader:close	()V
    //   96: aload_0
    //   97: invokevirtual 244	java/io/InputStream:close	()V
    //   100: aload_1
    //   101: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   104: astore_0
    //   105: goto -29 -> 76
    //   108: astore_1
    //   109: aload_2
    //   110: invokevirtual 67	java/io/BufferedReader:close	()V
    //   113: aload_0
    //   114: invokevirtual 244	java/io/InputStream:close	()V
    //   117: ldc 227
    //   119: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  public static String hpT()
  {
    int i = 0;
    AppMethodBeat.i(214636);
    String str1 = null;
    String str3 = d.V(d.SpW);
    String str4 = d.V(d.SpX);
    String str2;
    for (;;)
    {
      str2 = str1;
      if (i >= 2) {
        break;
      }
      str1 = bqZ(new String[] { str3, str4 }[i]);
      str2 = str1;
      if (!TextUtils.isEmpty(str1)) {
        break;
      }
      i += 1;
    }
    AppMethodBeat.o(214636);
    return str2;
  }
  
  public static float i(Context paramContext, float paramFloat)
  {
    AppMethodBeat.i(214632);
    paramFloat /= paramContext.getResources().getDisplayMetrics().density;
    AppMethodBeat.o(214632);
    return paramFloat;
  }
  
  public static String kY(Context paramContext)
  {
    AppMethodBeat.i(214621);
    try
    {
      String str = ((TelephonyManager)paramContext.getSystemService("phone")).getSubscriberId();
      paramContext = str;
      if (str == null) {
        paramContext = "";
      }
      AppMethodBeat.o(214621);
      return paramContext;
    }
    catch (Exception paramContext)
    {
      AppMethodBeat.o(214621);
    }
    return "";
  }
  
  public static String kZ(Context paramContext)
  {
    AppMethodBeat.i(214622);
    try
    {
      paramContext = Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
      AppMethodBeat.o(214622);
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      AppMethodBeat.o(214622);
    }
    return "";
  }
  
  public static int lr(Context paramContext)
  {
    AppMethodBeat.i(214629);
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
        h.b("DeviceUtil", paramContext);
        int i = 0;
        continue;
      }
      AppMethodBeat.o(214629);
      return i;
      i = 1;
    }
  }
  
  public static int ls(Context paramContext)
  {
    m = 1;
    AppMethodBeat.i(214630);
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
        h.b("DeviceUtil", paramContext);
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
      AppMethodBeat.o(214630);
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
          AppMethodBeat.o(214630);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.h.c.c
 * JD-Core Version:    0.7.0.1
 */