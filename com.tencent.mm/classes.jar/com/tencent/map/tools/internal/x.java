package com.tencent.map.tools.internal;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.os.Process;
import android.os.StatFs;
import android.provider.Settings.System;
import android.telephony.TelephonyManager;
import com.tencent.map.tools.EncryptAesUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class x
{
  public static String a;
  public static String b;
  public static String c;
  public static final String d;
  public static final String e;
  public static String f;
  public static String g;
  private static String h;
  private static HashMap<String, w> i;
  
  static
  {
    AppMethodBeat.i(209850);
    h = x.class.getSimpleName();
    a = t.e;
    b = t.f;
    c = t.g;
    d = t.i;
    e = t.j;
    f = "complist_loading";
    g = "default";
    i = new HashMap();
    AppMethodBeat.o(209850);
  }
  
  public static p a(int paramInt, List<p> paramList)
  {
    AppMethodBeat.i(209830);
    if ((paramList == null) || (paramList.isEmpty()))
    {
      AppMethodBeat.o(209830);
      return null;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      p localp = (p)paramList.next();
      if (paramInt == localp.a)
      {
        AppMethodBeat.o(209830);
        return localp;
      }
    }
    AppMethodBeat.o(209830);
    return null;
  }
  
  public static File a(Context paramContext, String paramString)
  {
    AppMethodBeat.i(209814);
    paramContext = new File(paramContext.getFilesDir(), paramString);
    if (!paramContext.exists()) {
      paramContext.mkdirs();
    }
    AppMethodBeat.o(209814);
    return paramContext;
  }
  
  public static Object a(Object paramObject, String paramString, Class[] paramArrayOfClass, Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(209848);
    if (paramObject == null)
    {
      AppMethodBeat.o(209848);
      return null;
    }
    try
    {
      paramString = a(paramObject.getClass(), paramString, paramArrayOfClass);
      if (paramString != null)
      {
        paramString.setAccessible(true);
        paramObject = paramString.invoke(paramObject, paramArrayOfObject);
        AppMethodBeat.o(209848);
        return paramObject;
      }
    }
    catch (InvocationTargetException paramObject)
    {
      AppMethodBeat.o(209848);
      return null;
    }
    catch (IllegalAccessException paramObject)
    {
      label50:
      break label50;
    }
  }
  
  public static String a()
  {
    AppMethodBeat.i(209825);
    try
    {
      String str = Build.MODEL.replaceAll("[_]", "");
      AppMethodBeat.o(209825);
      return str;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(209825);
    }
    return "";
  }
  
  public static String a(Context paramContext)
  {
    AppMethodBeat.i(209821);
    try
    {
      paramContext = paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 128).metaData;
      if (paramContext != null)
      {
        if (paramContext.containsKey("TencentMapSDK"))
        {
          paramContext = paramContext.getString("TencentMapSDK");
          AppMethodBeat.o(209821);
          return paramContext;
        }
        AppMethodBeat.o(209821);
        return "";
      }
    }
    catch (Exception paramContext)
    {
      AppMethodBeat.o(209821);
    }
    return "";
  }
  
  public static String a(File paramFile)
  {
    AppMethodBeat.i(209827);
    if (!paramFile.isFile())
    {
      AppMethodBeat.o(209827);
      return null;
    }
    byte[] arrayOfByte = new byte[1024];
    MessageDigest localMessageDigest;
    try
    {
      localMessageDigest = MessageDigest.getInstance("MD5");
      paramFile = new FileInputStream(paramFile);
      for (;;)
      {
        int j = paramFile.read(arrayOfByte, 0, 1024);
        if (j == -1) {
          break;
        }
        localMessageDigest.update(arrayOfByte, 0, j);
      }
      paramFile.close();
    }
    catch (Exception paramFile)
    {
      AppMethodBeat.o(209827);
      return null;
    }
    paramFile = b(localMessageDigest.digest());
    AppMethodBeat.o(209827);
    return paramFile;
  }
  
  public static String a(List<p> paramList)
  {
    AppMethodBeat.i(209836);
    String str = "";
    int j = 0;
    if (j < paramList.size())
    {
      p localp = (p)paramList.get(j);
      if ((a(localp.a)) && (!localp.c.endsWith(".so"))) {}
      for (localp.c += ".so";; localp.c += ".dex") {
        do
        {
          str = str + localp.toString() + ";";
          j += 1;
          break;
        } while ((a(localp.a)) || (localp.c.endsWith(".dex")));
      }
    }
    AppMethodBeat.o(209836);
    return str;
  }
  
  private static Method a(Class paramClass, String paramString, Class[] paramArrayOfClass)
  {
    AppMethodBeat.i(209849);
    localObject = null;
    try
    {
      Method localMethod = paramClass.getDeclaredMethod(paramString, paramArrayOfClass);
      localObject = localMethod;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      for (;;)
      {
        if (paramClass.getSuperclass() != Object.class) {
          localObject = a(paramClass.getSuperclass(), paramString, paramArrayOfClass);
        }
      }
    }
    AppMethodBeat.o(209849);
    return localObject;
  }
  
  /* Error */
  public static List<p> a(String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: ldc_w 278
    //   5: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: new 280	java/util/ArrayList
    //   11: dup
    //   12: invokespecial 281	java/util/ArrayList:<init>	()V
    //   15: astore 4
    //   17: aload_0
    //   18: ldc_w 263
    //   21: invokevirtual 285	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   24: astore_0
    //   25: aload_0
    //   26: arraylength
    //   27: istore_2
    //   28: iload_1
    //   29: iload_2
    //   30: if_icmpge +233 -> 263
    //   33: aload_0
    //   34: iload_1
    //   35: aaload
    //   36: ldc_w 287
    //   39: invokevirtual 285	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   42: astore 5
    //   44: aload 5
    //   46: arraylength
    //   47: istore_3
    //   48: iload_3
    //   49: iconst_5
    //   50: if_icmplt +222 -> 272
    //   53: new 95	com/tencent/map/tools/internal/p
    //   56: dup
    //   57: invokespecial 288	com/tencent/map/tools/internal/p:<init>	()V
    //   60: astore 6
    //   62: aload 6
    //   64: aload 5
    //   66: iconst_0
    //   67: aaload
    //   68: invokestatic 294	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   71: invokevirtual 297	java/lang/Integer:intValue	()I
    //   74: putfield 98	com/tencent/map/tools/internal/p:a	I
    //   77: aload 6
    //   79: aload 5
    //   81: iconst_1
    //   82: aaload
    //   83: putfield 298	com/tencent/map/tools/internal/p:b	Ljava/lang/String;
    //   86: aload 6
    //   88: aload 5
    //   90: iconst_2
    //   91: aaload
    //   92: putfield 299	com/tencent/map/tools/internal/p:f	Ljava/lang/String;
    //   95: aload 6
    //   97: aload 5
    //   99: iconst_2
    //   100: aaload
    //   101: putfield 245	com/tencent/map/tools/internal/p:c	Ljava/lang/String;
    //   104: aload 6
    //   106: getfield 98	com/tencent/map/tools/internal/p:a	I
    //   109: invokestatic 244	com/tencent/map/tools/internal/x:a	(I)Z
    //   112: ifeq +81 -> 193
    //   115: aload 6
    //   117: getfield 245	com/tencent/map/tools/internal/p:c	Ljava/lang/String;
    //   120: ldc 247
    //   122: invokevirtual 250	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   125: ifne +68 -> 193
    //   128: aload 6
    //   130: new 252	java/lang/StringBuilder
    //   133: dup
    //   134: invokespecial 253	java/lang/StringBuilder:<init>	()V
    //   137: aload 6
    //   139: getfield 245	com/tencent/map/tools/internal/p:c	Ljava/lang/String;
    //   142: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: ldc 247
    //   147: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   153: putfield 245	com/tencent/map/tools/internal/p:c	Ljava/lang/String;
    //   156: aload 6
    //   158: aload 5
    //   160: iconst_3
    //   161: aaload
    //   162: invokestatic 304	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   165: invokevirtual 308	java/lang/Long:longValue	()J
    //   168: putfield 311	com/tencent/map/tools/internal/p:d	J
    //   171: aload 6
    //   173: aload 5
    //   175: iconst_4
    //   176: aaload
    //   177: putfield 312	com/tencent/map/tools/internal/p:e	Ljava/lang/String;
    //   180: aload 4
    //   182: aload 6
    //   184: invokeinterface 316 2 0
    //   189: pop
    //   190: goto +82 -> 272
    //   193: aload 6
    //   195: getfield 98	com/tencent/map/tools/internal/p:a	I
    //   198: invokestatic 244	com/tencent/map/tools/internal/x:a	(I)Z
    //   201: ifne -45 -> 156
    //   204: aload 6
    //   206: getfield 245	com/tencent/map/tools/internal/p:c	Ljava/lang/String;
    //   209: ldc_w 265
    //   212: invokevirtual 250	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   215: ifne -59 -> 156
    //   218: aload 6
    //   220: new 252	java/lang/StringBuilder
    //   223: dup
    //   224: invokespecial 253	java/lang/StringBuilder:<init>	()V
    //   227: aload 6
    //   229: getfield 245	com/tencent/map/tools/internal/p:c	Ljava/lang/String;
    //   232: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   235: ldc_w 265
    //   238: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   241: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   244: putfield 245	com/tencent/map/tools/internal/p:c	Ljava/lang/String;
    //   247: goto -91 -> 156
    //   250: astore 5
    //   252: goto +20 -> 272
    //   255: astore_0
    //   256: aload 4
    //   258: invokeinterface 319 1 0
    //   263: ldc_w 278
    //   266: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   269: aload 4
    //   271: areturn
    //   272: iload_1
    //   273: iconst_1
    //   274: iadd
    //   275: istore_1
    //   276: goto -248 -> 28
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	279	0	paramString	String
    //   1	275	1	j	int
    //   27	4	2	k	int
    //   47	4	3	m	int
    //   15	255	4	localArrayList	ArrayList
    //   42	132	5	arrayOfString	String[]
    //   250	1	5	localException	Exception
    //   60	168	6	localp	p
    // Exception table:
    //   from	to	target	type
    //   53	156	250	java/lang/Exception
    //   156	190	250	java/lang/Exception
    //   193	247	250	java/lang/Exception
    //   17	28	255	java/lang/Exception
    //   33	48	255	java/lang/Exception
  }
  
  public static boolean a(int paramInt)
  {
    return (paramInt >= 2) && (paramInt <= t.F.length - 1);
  }
  
  private static boolean a(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(209833);
    try
    {
      paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses().iterator();
      while (paramContext.hasNext())
      {
        int j = ((ActivityManager.RunningAppProcessInfo)paramContext.next()).pid;
        if (j == paramInt)
        {
          AppMethodBeat.o(209833);
          return true;
        }
      }
    }
    catch (Exception paramContext)
    {
      AppMethodBeat.o(209833);
    }
    return false;
  }
  
  public static boolean a(Context paramContext, String paramString, Long paramLong)
  {
    AppMethodBeat.i(209818);
    boolean bool = d(paramContext, paramString).a(String.valueOf(paramLong).getBytes());
    AppMethodBeat.o(209818);
    return bool;
  }
  
  public static boolean a(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(209817);
    boolean bool = d(paramContext, paramString1).a(paramString2.getBytes());
    AppMethodBeat.o(209817);
    return bool;
  }
  
  public static boolean a(Context paramContext, String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(209842);
    if (paramBoolean1) {}
    try
    {
      for (paramContext = e(paramContext, paramString1); paramContext == null; paramContext = b(paramString1))
      {
        AppMethodBeat.o(209842);
        return false;
      }
      paramString1 = paramContext;
      if (paramBoolean2) {
        paramString1 = a(EncryptAesUtils.decryptAes256(paramContext, "dwMmNhTC43xDnMGp", t.G));
      }
      if (paramString1 != null)
      {
        new w(paramString2).a(paramString1);
        AppMethodBeat.o(209842);
        return true;
      }
      AppMethodBeat.o(209842);
      return false;
    }
    catch (Exception paramContext)
    {
      AppMethodBeat.o(209842);
    }
    return false;
  }
  
  public static boolean a(List<p> paramList1, List<p> paramList2)
  {
    AppMethodBeat.i(209829);
    paramList1 = paramList1.iterator();
    boolean bool = true;
    if (paramList1.hasNext())
    {
      p localp1 = (p)paramList1.next();
      Iterator localIterator = paramList2.iterator();
      p localp2;
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localp2 = (p)localIterator.next();
      } while ((localp1.a != localp2.a) || (localp1.d != localp2.d) || (!localp1.e.equals(localp2.e)));
    }
    for (int j = 1;; j = 0)
    {
      if (j == 0) {
        bool = false;
      }
      for (;;)
      {
        break;
        AppMethodBeat.o(209829);
        return bool;
      }
    }
  }
  
  /* Error */
  public static byte[] a(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: ldc_w 396
    //   6: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_0
    //   10: ifnull +8 -> 18
    //   13: aload_0
    //   14: arraylength
    //   15: ifne +11 -> 26
    //   18: ldc_w 396
    //   21: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   24: aconst_null
    //   25: areturn
    //   26: new 398	java/io/ByteArrayOutputStream
    //   29: dup
    //   30: invokespecial 399	java/io/ByteArrayOutputStream:<init>	()V
    //   33: astore_2
    //   34: new 401	java/io/ByteArrayInputStream
    //   37: dup
    //   38: aload_0
    //   39: invokespecial 404	java/io/ByteArrayInputStream:<init>	([B)V
    //   42: astore_3
    //   43: new 406	java/util/zip/GZIPInputStream
    //   46: dup
    //   47: aload_3
    //   48: invokespecial 409	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;)V
    //   51: astore_0
    //   52: ldc_w 410
    //   55: newarray byte
    //   57: astore 4
    //   59: aload_0
    //   60: aload 4
    //   62: invokevirtual 413	java/util/zip/GZIPInputStream:read	([B)I
    //   65: istore_1
    //   66: iload_1
    //   67: iflt +57 -> 124
    //   70: aload_2
    //   71: aload 4
    //   73: iconst_0
    //   74: iload_1
    //   75: invokevirtual 416	java/io/ByteArrayOutputStream:write	([BII)V
    //   78: goto -19 -> 59
    //   81: astore 4
    //   83: aload_0
    //   84: ifnull +7 -> 91
    //   87: aload_0
    //   88: invokevirtual 417	java/util/zip/GZIPInputStream:close	()V
    //   91: aload_3
    //   92: ifnull +7 -> 99
    //   95: aload_3
    //   96: invokevirtual 418	java/io/ByteArrayInputStream:close	()V
    //   99: aload 5
    //   101: astore 4
    //   103: aload_2
    //   104: ifnull +11 -> 115
    //   107: aload_2
    //   108: invokevirtual 419	java/io/ByteArrayOutputStream:close	()V
    //   111: aload 5
    //   113: astore 4
    //   115: ldc_w 396
    //   118: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   121: aload 4
    //   123: areturn
    //   124: aload_2
    //   125: invokevirtual 422	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   128: astore 4
    //   130: aload_0
    //   131: invokevirtual 417	java/util/zip/GZIPInputStream:close	()V
    //   134: aload_3
    //   135: invokevirtual 418	java/io/ByteArrayInputStream:close	()V
    //   138: aload_2
    //   139: invokevirtual 419	java/io/ByteArrayOutputStream:close	()V
    //   142: goto -27 -> 115
    //   145: astore_0
    //   146: goto -31 -> 115
    //   149: astore_0
    //   150: aconst_null
    //   151: astore_0
    //   152: aconst_null
    //   153: astore_3
    //   154: aconst_null
    //   155: astore_2
    //   156: aload_0
    //   157: ifnull +7 -> 164
    //   160: aload_0
    //   161: invokevirtual 417	java/util/zip/GZIPInputStream:close	()V
    //   164: aload_3
    //   165: ifnull +7 -> 172
    //   168: aload_3
    //   169: invokevirtual 418	java/io/ByteArrayInputStream:close	()V
    //   172: aload 5
    //   174: astore 4
    //   176: aload_2
    //   177: ifnull -62 -> 115
    //   180: aload_2
    //   181: invokevirtual 419	java/io/ByteArrayOutputStream:close	()V
    //   184: aload 5
    //   186: astore 4
    //   188: goto -73 -> 115
    //   191: astore_0
    //   192: aload 5
    //   194: astore 4
    //   196: goto -81 -> 115
    //   199: astore_0
    //   200: aconst_null
    //   201: astore_2
    //   202: aconst_null
    //   203: astore_3
    //   204: aconst_null
    //   205: astore 4
    //   207: aload_2
    //   208: ifnull +7 -> 215
    //   211: aload_2
    //   212: invokevirtual 417	java/util/zip/GZIPInputStream:close	()V
    //   215: aload_3
    //   216: ifnull +7 -> 223
    //   219: aload_3
    //   220: invokevirtual 418	java/io/ByteArrayInputStream:close	()V
    //   223: aload 4
    //   225: ifnull +8 -> 233
    //   228: aload 4
    //   230: invokevirtual 419	java/io/ByteArrayOutputStream:close	()V
    //   233: ldc_w 396
    //   236: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   239: aload_0
    //   240: athrow
    //   241: astore_2
    //   242: goto -9 -> 233
    //   245: astore_0
    //   246: aconst_null
    //   247: astore 5
    //   249: aconst_null
    //   250: astore_3
    //   251: aload_2
    //   252: astore 4
    //   254: aload 5
    //   256: astore_2
    //   257: goto -50 -> 207
    //   260: astore_0
    //   261: aconst_null
    //   262: astore 5
    //   264: aload_2
    //   265: astore 4
    //   267: aload 5
    //   269: astore_2
    //   270: goto -63 -> 207
    //   273: astore 5
    //   275: aload_0
    //   276: astore 6
    //   278: aload_2
    //   279: astore 4
    //   281: aload 5
    //   283: astore_0
    //   284: aload 6
    //   286: astore_2
    //   287: goto -80 -> 207
    //   290: astore_0
    //   291: aconst_null
    //   292: astore_0
    //   293: aconst_null
    //   294: astore_3
    //   295: goto -139 -> 156
    //   298: astore_0
    //   299: aconst_null
    //   300: astore_0
    //   301: goto -145 -> 156
    //   304: astore 4
    //   306: goto -150 -> 156
    //   309: astore_0
    //   310: aload 5
    //   312: astore 4
    //   314: goto -199 -> 115
    //   317: astore_0
    //   318: aconst_null
    //   319: astore_0
    //   320: aconst_null
    //   321: astore_3
    //   322: aconst_null
    //   323: astore_2
    //   324: goto -241 -> 83
    //   327: astore_0
    //   328: aconst_null
    //   329: astore_0
    //   330: aconst_null
    //   331: astore_3
    //   332: goto -249 -> 83
    //   335: astore_0
    //   336: aconst_null
    //   337: astore_0
    //   338: goto -255 -> 83
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	341	0	paramArrayOfByte	byte[]
    //   65	10	1	j	int
    //   33	179	2	localByteArrayOutputStream	ByteArrayOutputStream
    //   241	11	2	localException1	Exception
    //   256	68	2	localObject1	Object
    //   42	290	3	localByteArrayInputStream	java.io.ByteArrayInputStream
    //   57	15	4	arrayOfByte1	byte[]
    //   81	1	4	localException2	Exception
    //   101	179	4	localObject2	Object
    //   304	1	4	localError	java.lang.Error
    //   312	1	4	localObject3	Object
    //   1	267	5	localObject4	Object
    //   273	38	5	localObject5	Object
    //   276	9	6	arrayOfByte2	byte[]
    // Exception table:
    //   from	to	target	type
    //   52	59	81	java/lang/Exception
    //   59	66	81	java/lang/Exception
    //   70	78	81	java/lang/Exception
    //   124	130	81	java/lang/Exception
    //   130	142	145	java/lang/Exception
    //   26	34	149	java/lang/Error
    //   160	164	191	java/lang/Exception
    //   168	172	191	java/lang/Exception
    //   180	184	191	java/lang/Exception
    //   26	34	199	finally
    //   211	215	241	java/lang/Exception
    //   219	223	241	java/lang/Exception
    //   228	233	241	java/lang/Exception
    //   34	43	245	finally
    //   43	52	260	finally
    //   52	59	273	finally
    //   59	66	273	finally
    //   70	78	273	finally
    //   124	130	273	finally
    //   34	43	290	java/lang/Error
    //   43	52	298	java/lang/Error
    //   52	59	304	java/lang/Error
    //   59	66	304	java/lang/Error
    //   70	78	304	java/lang/Error
    //   124	130	304	java/lang/Error
    //   87	91	309	java/lang/Exception
    //   95	99	309	java/lang/Exception
    //   107	111	309	java/lang/Exception
    //   26	34	317	java/lang/Exception
    //   34	43	327	java/lang/Exception
    //   43	52	335	java/lang/Exception
  }
  
  public static int b(List<p> paramList)
  {
    AppMethodBeat.i(209838);
    if ((paramList == null) || (paramList.isEmpty()))
    {
      AppMethodBeat.o(209838);
      return -2;
    }
    paramList = paramList.iterator();
    do
    {
      if (!paramList.hasNext()) {
        break;
      }
    } while (!a(((p)paramList.next()).a));
    for (int j = 1;; j = 0)
    {
      if (j != 0)
      {
        AppMethodBeat.o(209838);
        return 1;
      }
      AppMethodBeat.o(209838);
      return 0;
    }
  }
  
  public static Long b(Context paramContext, String paramString, Long paramLong)
  {
    AppMethodBeat.i(209820);
    paramContext = d(paramContext, paramString).a(String.valueOf(paramLong));
    try
    {
      long l = Long.parseLong(paramContext);
      paramLong = Long.valueOf(l);
    }
    catch (Exception paramContext)
    {
      label29:
      break label29;
    }
    AppMethodBeat.o(209820);
    return paramLong;
  }
  
  public static String b()
  {
    AppMethodBeat.i(209826);
    try
    {
      String str = Build.MANUFACTURER.replaceAll("[_]", "");
      AppMethodBeat.o(209826);
      return str;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(209826);
    }
    return "";
  }
  
  public static String b(Context paramContext)
  {
    AppMethodBeat.i(209822);
    try
    {
      String str = paramContext.getPackageName();
      paramContext = paramContext.getPackageManager().getPackageInfo(str, 0);
      str = paramContext.versionName;
      int j = paramContext.versionCode;
      if (str != null)
      {
        paramContext = str;
        if (str.trim().length() > 0) {}
      }
      else
      {
        AppMethodBeat.o(209822);
        return String.valueOf(j);
      }
    }
    catch (Exception paramContext)
    {
      paramContext = "";
      AppMethodBeat.o(209822);
    }
    return paramContext;
  }
  
  public static String b(Context paramContext, String paramString)
  {
    AppMethodBeat.i(209815);
    paramContext = paramContext.getFilesDir().getAbsolutePath() + File.separator + paramString;
    AppMethodBeat.o(209815);
    return paramContext;
  }
  
  public static String b(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(209819);
    paramContext = d(paramContext, paramString1).a(paramString2);
    AppMethodBeat.o(209819);
    return paramContext;
  }
  
  private static String b(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(209828);
    if (paramArrayOfByte == null)
    {
      AppMethodBeat.o(209828);
      return "";
    }
    StringBuffer localStringBuffer = new StringBuffer();
    int j = 0;
    while (j < paramArrayOfByte.length)
    {
      String str = Integer.toHexString(paramArrayOfByte[j] & 0xFF);
      if (str.length() == 1) {
        localStringBuffer.append("0");
      }
      localStringBuffer.append(str);
      j += 1;
    }
    paramArrayOfByte = localStringBuffer.toString().toLowerCase();
    AppMethodBeat.o(209828);
    return paramArrayOfByte;
  }
  
  public static ArrayList<String> b(File paramFile)
  {
    AppMethodBeat.i(209835);
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramFile != null)
    {
      localObject1 = localObject2;
      if (paramFile.exists())
      {
        localObject1 = localObject2;
        if (paramFile.isDirectory())
        {
          File[] arrayOfFile = paramFile.listFiles();
          localObject1 = localObject2;
          if (arrayOfFile != null)
          {
            localObject1 = localObject2;
            if (arrayOfFile.length > 0)
            {
              paramFile = new ArrayList();
              int k = arrayOfFile.length;
              int j = 0;
              for (;;)
              {
                localObject1 = paramFile;
                if (j >= k) {
                  break;
                }
                localObject1 = arrayOfFile[j];
                paramFile.add(((File)localObject1).getName() + "," + ((File)localObject1).length() + "," + a((File)localObject1));
                j += 1;
              }
            }
          }
        }
      }
    }
    AppMethodBeat.o(209835);
    return localObject1;
  }
  
  /* Error */
  private static byte[] b(String paramString)
  {
    // Byte code:
    //   0: ldc_w 510
    //   3: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 398	java/io/ByteArrayOutputStream
    //   9: dup
    //   10: invokespecial 399	java/io/ByteArrayOutputStream:<init>	()V
    //   13: astore 4
    //   15: new 210	java/io/FileInputStream
    //   18: dup
    //   19: aload_0
    //   20: invokespecial 511	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   23: astore_2
    //   24: aload_2
    //   25: astore_0
    //   26: sipush 10240
    //   29: newarray byte
    //   31: astore_3
    //   32: aload_2
    //   33: astore_0
    //   34: aload_2
    //   35: aload_3
    //   36: invokevirtual 512	java/io/FileInputStream:read	([B)I
    //   39: istore_1
    //   40: iload_1
    //   41: iconst_m1
    //   42: if_icmpeq +47 -> 89
    //   45: aload_2
    //   46: astore_0
    //   47: aload 4
    //   49: aload_3
    //   50: iconst_0
    //   51: iload_1
    //   52: invokevirtual 416	java/io/ByteArrayOutputStream:write	([BII)V
    //   55: goto -23 -> 32
    //   58: astore_0
    //   59: aload_2
    //   60: astore_0
    //   61: aload_2
    //   62: invokevirtual 224	java/io/FileInputStream:close	()V
    //   65: aload_2
    //   66: astore_0
    //   67: aload 4
    //   69: invokevirtual 419	java/io/ByteArrayOutputStream:close	()V
    //   72: aload_2
    //   73: invokevirtual 224	java/io/FileInputStream:close	()V
    //   76: aload 4
    //   78: invokevirtual 419	java/io/ByteArrayOutputStream:close	()V
    //   81: ldc_w 510
    //   84: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   87: aconst_null
    //   88: areturn
    //   89: aload_2
    //   90: astore_0
    //   91: aload 4
    //   93: invokevirtual 419	java/io/ByteArrayOutputStream:close	()V
    //   96: aload_2
    //   97: astore_0
    //   98: aload_2
    //   99: invokevirtual 224	java/io/FileInputStream:close	()V
    //   102: aload_2
    //   103: astore_0
    //   104: aload 4
    //   106: invokevirtual 422	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   109: astore_3
    //   110: aload_2
    //   111: invokevirtual 224	java/io/FileInputStream:close	()V
    //   114: aload 4
    //   116: invokevirtual 419	java/io/ByteArrayOutputStream:close	()V
    //   119: ldc_w 510
    //   122: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   125: aload_3
    //   126: areturn
    //   127: astore_0
    //   128: aconst_null
    //   129: astore_2
    //   130: aload_2
    //   131: invokevirtual 224	java/io/FileInputStream:close	()V
    //   134: aload 4
    //   136: invokevirtual 419	java/io/ByteArrayOutputStream:close	()V
    //   139: ldc_w 510
    //   142: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   145: aload_0
    //   146: athrow
    //   147: astore_0
    //   148: goto -34 -> 114
    //   151: astore_0
    //   152: goto -33 -> 119
    //   155: astore_0
    //   156: goto -91 -> 65
    //   159: astore_0
    //   160: goto -88 -> 72
    //   163: astore_0
    //   164: goto -88 -> 76
    //   167: astore_0
    //   168: goto -87 -> 81
    //   171: astore_2
    //   172: goto -38 -> 134
    //   175: astore_2
    //   176: goto -37 -> 139
    //   179: astore_2
    //   180: aload_0
    //   181: astore_3
    //   182: aload_2
    //   183: astore_0
    //   184: aload_3
    //   185: astore_2
    //   186: goto -56 -> 130
    //   189: astore_0
    //   190: aconst_null
    //   191: astore_2
    //   192: goto -133 -> 59
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	195	0	paramString	String
    //   39	13	1	j	int
    //   23	108	2	localFileInputStream	FileInputStream
    //   171	1	2	localException1	Exception
    //   175	1	2	localException2	Exception
    //   179	4	2	localObject1	Object
    //   185	7	2	localObject2	Object
    //   31	154	3	localObject3	Object
    //   13	122	4	localByteArrayOutputStream	ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   26	32	58	java/lang/Exception
    //   34	40	58	java/lang/Exception
    //   47	55	58	java/lang/Exception
    //   91	96	58	java/lang/Exception
    //   98	102	58	java/lang/Exception
    //   104	110	58	java/lang/Exception
    //   15	24	127	finally
    //   110	114	147	java/lang/Exception
    //   114	119	151	java/lang/Exception
    //   61	65	155	java/lang/Exception
    //   67	72	159	java/lang/Exception
    //   72	76	163	java/lang/Exception
    //   76	81	167	java/lang/Exception
    //   130	134	171	java/lang/Exception
    //   134	139	175	java/lang/Exception
    //   26	32	179	finally
    //   34	40	179	finally
    //   47	55	179	finally
    //   61	65	179	finally
    //   67	72	179	finally
    //   91	96	179	finally
    //   98	102	179	finally
    //   104	110	179	finally
    //   15	24	189	java/lang/Exception
  }
  
  public static int c()
  {
    return Build.VERSION.SDK_INT;
  }
  
  public static String c(Context paramContext)
  {
    AppMethodBeat.i(209823);
    try
    {
      localTelephonyManager = (TelephonyManager)paramContext.getSystemService("phone");
      if (Build.VERSION.SDK_INT > 28)
      {
        y.d = g(paramContext);
        if (y.c.equals("01234567890ABCDEF")) {}
      }
      for (y.d = y.c;; y.d = localTelephonyManager.getImei())
      {
        paramContext = y.d;
        AppMethodBeat.o(209823);
        return paramContext;
        if (Build.VERSION.SDK_INT < 26) {
          break;
        }
      }
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        TelephonyManager localTelephonyManager;
        y.d = "01234567890ABCDEF";
        continue;
        y.d = localTelephonyManager.getDeviceId();
      }
    }
  }
  
  public static String c(Context paramContext, String paramString)
  {
    AppMethodBeat.i(209843);
    try
    {
      paramContext = e(paramContext, paramString);
      if (paramContext == null)
      {
        AppMethodBeat.o(209843);
        return "";
      }
      paramContext = new String(paramContext);
      AppMethodBeat.o(209843);
      return paramContext;
    }
    catch (Exception paramContext)
    {
      AppMethodBeat.o(209843);
    }
    return "";
  }
  
  public static boolean c(File paramFile)
  {
    AppMethodBeat.i(209845);
    if (!paramFile.exists())
    {
      paramFile.mkdirs();
      AppMethodBeat.o(209845);
      return true;
    }
    paramFile = paramFile.listFiles();
    if ((paramFile == null) || (paramFile.length == 0))
    {
      AppMethodBeat.o(209845);
      return true;
    }
    int k = paramFile.length;
    int j = 0;
    if (j < k)
    {
      Object localObject = paramFile[j];
      if (localObject.isDirectory())
      {
        c(localObject.getAbsolutePath());
        localObject.delete();
      }
      for (;;)
      {
        j += 1;
        break;
        localObject.delete();
      }
    }
    AppMethodBeat.o(209845);
    return true;
  }
  
  private static boolean c(String paramString)
  {
    int j = 0;
    AppMethodBeat.i(209846);
    Object localObject = new File(paramString);
    if (!((File)localObject).exists())
    {
      AppMethodBeat.o(209846);
      return false;
    }
    localObject = ((File)localObject).list();
    if ((localObject == null) || (localObject.length == 0))
    {
      AppMethodBeat.o(209846);
      return false;
    }
    int k = localObject.length;
    if (j < k)
    {
      File localFile = new File(paramString, localObject[j]);
      if (localFile.isDirectory())
      {
        c(localFile.getAbsolutePath());
        localFile.delete();
      }
      for (;;)
      {
        j += 1;
        break;
        localFile.delete();
      }
    }
    AppMethodBeat.o(209846);
    return true;
  }
  
  public static int d(Context paramContext)
  {
    int k = 1;
    int j = 1;
    AppMethodBeat.i(209832);
    Object localObject = b(paramContext, t.A, "default");
    if (((String)localObject).equals("default"))
    {
      AppMethodBeat.o(209832);
      return 1;
    }
    try
    {
      localObject = ((String)localObject).split("#");
      int m = k;
      if (localObject != null)
      {
        m = k;
        if (localObject.length > 0)
        {
          k = 0;
          for (;;)
          {
            m = j;
            if (k >= localObject.length) {
              break;
            }
            String[] arrayOfString = localObject[k].split("&");
            m = j;
            if (arrayOfString != null)
            {
              m = j;
              if (arrayOfString.length == 2)
              {
                boolean bool = a(paramContext, Integer.parseInt(arrayOfString[0]));
                m = j;
                if (bool) {
                  m = 0;
                }
              }
            }
            k += 1;
            j = m;
          }
        }
      }
      if (m != 0)
      {
        AppMethodBeat.o(209832);
        return 3;
      }
    }
    catch (Exception paramContext)
    {
      AppMethodBeat.o(209832);
    }
    return 4;
  }
  
  public static long d()
  {
    AppMethodBeat.i(209840);
    long l1 = 0L;
    try
    {
      StatFs localStatFs = new StatFs(Environment.getDataDirectory().getPath());
      long l2 = localStatFs.getBlockSize();
      int j = localStatFs.getAvailableBlocks();
      l1 = j * l2;
    }
    catch (Exception localException)
    {
      label41:
      break label41;
    }
    AppMethodBeat.o(209840);
    return l1;
  }
  
  private static w d(Context paramContext, String paramString)
  {
    AppMethodBeat.i(209816);
    if (i.containsKey(paramString))
    {
      paramContext = (w)i.get(paramString);
      AppMethodBeat.o(209816);
      return paramContext;
    }
    paramContext = new w(paramContext.getFilesDir().getAbsolutePath() + "/" + t.D + "/" + paramString);
    i.put(paramString, paramContext);
    AppMethodBeat.o(209816);
    return paramContext;
  }
  
  public static void e(Context paramContext)
  {
    int n = 0;
    AppMethodBeat.i(209834);
    String str = h(paramContext);
    if (str == null)
    {
      AppMethodBeat.o(209834);
      return;
    }
    int i1 = Process.myPid();
    Object localObject1 = b(paramContext, t.A, "default");
    if (((String)localObject1).equals("default"))
    {
      localObject1 = i1 + "&" + str + "#";
      a(paramContext, t.A, (String)localObject1);
      AppMethodBeat.o(209834);
      return;
    }
    for (;;)
    {
      int m;
      try
      {
        String[] arrayOfString = ((String)localObject1).split("#");
        if ((arrayOfString != null) && (arrayOfString.length > 0))
        {
          k = 0;
          j = 0;
          if (k >= arrayOfString.length) {
            break label349;
          }
          localObject1 = arrayOfString[k].split("&");
          m = j;
          if (localObject1 == null) {
            break label340;
          }
          m = j;
          if (localObject1.length != 2) {
            break label340;
          }
          Object localObject2 = localObject1[1];
          Integer.parseInt(localObject1[0]);
          m = j;
          if (!str.equals(localObject2)) {
            break label340;
          }
          arrayOfString[k] = (i1 + "&" + str);
          m = 1;
          break label340;
          if (k < arrayOfString.length)
          {
            localObject1 = (String)localObject1 + arrayOfString[k] + "#";
            k += 1;
            continue;
          }
          if (j == 0)
          {
            localObject1 = (String)localObject1 + i1 + "&" + str + "#";
            a(paramContext, t.A, (String)localObject1);
          }
        }
        else
        {
          AppMethodBeat.o(209834);
          return;
        }
      }
      catch (Exception paramContext)
      {
        AppMethodBeat.o(209834);
        return;
      }
      continue;
      label340:
      k += 1;
      int j = m;
      continue;
      label349:
      localObject1 = "";
      int k = n;
    }
  }
  
  private static byte[] e(Context paramContext, String paramString)
  {
    AppMethodBeat.i(209841);
    try
    {
      paramContext = paramContext.getResources().getAssets().open(paramString);
      paramString = new ByteArrayOutputStream();
      byte[] arrayOfByte = new byte[2048];
      for (;;)
      {
        int j = paramContext.read(arrayOfByte);
        if (j <= 0) {
          break;
        }
        paramString.write(arrayOfByte, 0, j);
      }
      paramString.close();
    }
    catch (Exception paramContext)
    {
      AppMethodBeat.o(209841);
      return null;
    }
    paramString = paramString.toByteArray();
    paramContext.close();
    AppMethodBeat.o(209841);
    return paramString;
  }
  
  public static boolean f(Context paramContext)
  {
    AppMethodBeat.i(209839);
    paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (paramContext == null)
    {
      AppMethodBeat.o(209839);
      return false;
    }
    try
    {
      NetworkInfo localNetworkInfo = paramContext.getNetworkInfo(1);
      if ((localNetworkInfo != null) && (localNetworkInfo.isConnected()))
      {
        if (Build.VERSION.SDK_INT >= 16)
        {
          boolean bool = paramContext.isActiveNetworkMetered();
          if (!bool)
          {
            AppMethodBeat.o(209839);
            return true;
          }
        }
        AppMethodBeat.o(209839);
        return true;
      }
      AppMethodBeat.o(209839);
      return false;
    }
    catch (Throwable paramContext)
    {
      AppMethodBeat.o(209839);
    }
    return false;
  }
  
  private static String g(Context paramContext)
  {
    AppMethodBeat.i(209824);
    try
    {
      paramContext = Settings.System.getString(paramContext.getContentResolver(), "android_id");
      AppMethodBeat.o(209824);
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      AppMethodBeat.o(209824);
    }
    return "01234567890ABCDEF";
  }
  
  private static String h(Context paramContext)
  {
    AppMethodBeat.i(209831);
    try
    {
      int j = Process.myPid();
      paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses().iterator();
      while (paramContext.hasNext())
      {
        localObject = (ActivityManager.RunningAppProcessInfo)paramContext.next();
        if (((ActivityManager.RunningAppProcessInfo)localObject).pid == j)
        {
          paramContext = ((ActivityManager.RunningAppProcessInfo)localObject).processName;
          AppMethodBeat.o(209831);
          return paramContext;
        }
      }
      paramContext = new BufferedReader(new FileReader(new File("/proc/" + Process.myPid() + "/cmdline")));
      Object localObject = paramContext.readLine().trim();
      paramContext.close();
      AppMethodBeat.o(209831);
      return localObject;
    }
    catch (Exception paramContext)
    {
      AppMethodBeat.o(209831);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.map.tools.internal.x
 * JD-Core Version:    0.7.0.1
 */