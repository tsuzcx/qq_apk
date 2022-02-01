package com.tencent.beacon.a;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.Context;
import android.hardware.SensorManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Debug.MemoryInfo;
import android.os.Environment;
import android.os.Process;
import android.os.StatFs;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.beacon.a.a.d;
import com.tencent.beacon.a.a.e;
import com.tencent.beacon.event.i;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class g
{
  private static g a;
  private Context b;
  
  private g(Context paramContext)
  {
    this.b = paramContext;
  }
  
  public static int a(Context paramContext, d[] paramArrayOfd)
  {
    int j = 0;
    int i;
    if ((paramContext == null) || (paramArrayOfd == null) || (paramArrayOfd.length <= 0)) {
      i = -1;
    }
    ArrayList localArrayList;
    do
    {
      return i;
      localArrayList = new ArrayList(paramArrayOfd.length);
      int k = paramArrayOfd.length;
      i = 0;
      while (i < k)
      {
        d locald = paramArrayOfd[i];
        Object localObject = com.tencent.beacon.b.a.a(locald);
        if (localObject != null)
        {
          localObject = new com.tencent.beacon.a.a.a(6, 0, 0L, (byte[])localObject);
          ((com.tencent.beacon.a.a.a)localObject).a(locald.a());
          localArrayList.add(localObject);
        }
        i += 1;
      }
      i = j;
    } while (localArrayList.size() <= 0);
    if (com.tencent.beacon.a.a.a.b(paramContext, localArrayList)) {
      return localArrayList.size();
    }
    return -1;
  }
  
  public static int a(Context paramContext, Long[] paramArrayOfLong)
  {
    com.tencent.beacon.d.a.a(" RecordDAO.deleteRecordList() start", new Object[0]);
    if (paramContext == null)
    {
      com.tencent.beacon.d.a.d(" deleteRecordList() have null args!", new Object[0]);
      return -1;
    }
    com.tencent.beacon.d.a.a(" RecordDAO.deleteRecordList() end", new Object[0]);
    return com.tencent.beacon.a.a.a.a(paramContext, paramArrayOfLong);
  }
  
  public static long a(String paramString)
  {
    if (paramString == null) {
      return 0L;
    }
    try
    {
      long l = Long.parseLong(paramString);
      return l;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return 0L;
  }
  
  /* Error */
  public static com.tencent.beacon.a.b.h a(Context paramContext, int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 5
    //   6: aconst_null
    //   7: astore 7
    //   9: aload_0
    //   10: ifnonnull +16 -> 26
    //   13: ldc 84
    //   15: iconst_0
    //   16: anewarray 4	java/lang/Object
    //   19: invokestatic 87	com/tencent/beacon/d/a:c	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   22: aconst_null
    //   23: astore_3
    //   24: aload_3
    //   25: areturn
    //   26: aload_0
    //   27: invokestatic 92	com/tencent/beacon/a/a/c:a	(Landroid/content/Context;)Lcom/tencent/beacon/a/a/c;
    //   30: astore_0
    //   31: aload_0
    //   32: invokevirtual 96	com/tencent/beacon/a/a/c:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   35: astore_3
    //   36: aload_3
    //   37: ifnonnull +37 -> 74
    //   40: ldc 98
    //   42: iconst_0
    //   43: anewarray 4	java/lang/Object
    //   46: invokestatic 87	com/tencent/beacon/d/a:c	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   49: aload_3
    //   50: ifnull +14 -> 64
    //   53: aload_3
    //   54: invokevirtual 104	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   57: ifeq +7 -> 64
    //   60: aload_3
    //   61: invokevirtual 107	android/database/sqlite/SQLiteDatabase:close	()V
    //   64: aload_0
    //   65: ifnull +7 -> 72
    //   68: aload_0
    //   69: invokevirtual 108	com/tencent/beacon/a/a/c:close	()V
    //   72: aconst_null
    //   73: areturn
    //   74: aload_3
    //   75: ldc 110
    //   77: aconst_null
    //   78: getstatic 116	java/util/Locale:US	Ljava/util/Locale;
    //   81: ldc 118
    //   83: iconst_2
    //   84: anewarray 4	java/lang/Object
    //   87: dup
    //   88: iconst_0
    //   89: ldc 120
    //   91: aastore
    //   92: dup
    //   93: iconst_1
    //   94: bipush 101
    //   96: invokestatic 126	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   99: aastore
    //   100: invokestatic 132	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   103: aconst_null
    //   104: aconst_null
    //   105: aconst_null
    //   106: aconst_null
    //   107: invokevirtual 136	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   110: astore 4
    //   112: aload 4
    //   114: ifnull +454 -> 568
    //   117: aload 4
    //   119: invokeinterface 141 1 0
    //   124: ifeq +444 -> 568
    //   127: aload 7
    //   129: astore 5
    //   131: aload 4
    //   133: ifnull +33 -> 166
    //   136: aload 7
    //   138: astore 5
    //   140: aload 4
    //   142: invokeinterface 144 1 0
    //   147: ifne +19 -> 166
    //   150: aload 4
    //   152: invokeinterface 147 1 0
    //   157: istore_2
    //   158: iload_2
    //   159: ifeq +80 -> 239
    //   162: aload 7
    //   164: astore 5
    //   166: aload 5
    //   168: ifnull +23 -> 191
    //   171: ldc 149
    //   173: iconst_1
    //   174: anewarray 4	java/lang/Object
    //   177: dup
    //   178: iconst_0
    //   179: aload 5
    //   181: invokevirtual 153	com/tencent/beacon/a/b/h:b	()I
    //   184: invokestatic 126	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   187: aastore
    //   188: invokestatic 156	com/tencent/beacon/d/a:g	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   191: aload 4
    //   193: ifnull +20 -> 213
    //   196: aload 4
    //   198: invokeinterface 159 1 0
    //   203: ifne +10 -> 213
    //   206: aload 4
    //   208: invokeinterface 160 1 0
    //   213: aload_3
    //   214: ifnull +14 -> 228
    //   217: aload_3
    //   218: invokevirtual 104	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   221: ifeq +7 -> 228
    //   224: aload_3
    //   225: invokevirtual 107	android/database/sqlite/SQLiteDatabase:close	()V
    //   228: aload_0
    //   229: ifnull +336 -> 565
    //   232: aload_0
    //   233: invokevirtual 108	com/tencent/beacon/a/a/c:close	()V
    //   236: aload 5
    //   238: areturn
    //   239: ldc 162
    //   241: iconst_0
    //   242: anewarray 4	java/lang/Object
    //   245: invokestatic 164	com/tencent/beacon/d/a:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   248: new 151	com/tencent/beacon/a/b/h
    //   251: dup
    //   252: invokespecial 165	com/tencent/beacon/a/b/h:<init>	()V
    //   255: astore 5
    //   257: aload 5
    //   259: aload 4
    //   261: aload 4
    //   263: ldc 167
    //   265: invokeinterface 171 2 0
    //   270: invokeinterface 175 2 0
    //   275: invokevirtual 178	com/tencent/beacon/a/b/h:a	(J)V
    //   278: aload 5
    //   280: aload 4
    //   282: aload 4
    //   284: ldc 120
    //   286: invokeinterface 171 2 0
    //   291: invokeinterface 182 2 0
    //   296: invokevirtual 184	com/tencent/beacon/a/b/h:a	(I)V
    //   299: aload 5
    //   301: aload 4
    //   303: aload 4
    //   305: ldc 186
    //   307: invokeinterface 171 2 0
    //   312: invokeinterface 190 2 0
    //   317: invokevirtual 193	com/tencent/beacon/a/b/h:a	([B)V
    //   320: goto -154 -> 166
    //   323: astore 5
    //   325: aconst_null
    //   326: astore_3
    //   327: aconst_null
    //   328: astore 4
    //   330: aconst_null
    //   331: astore_0
    //   332: aload 5
    //   334: invokevirtual 194	java/lang/Throwable:printStackTrace	()V
    //   337: aload 6
    //   339: ifnull +20 -> 359
    //   342: aload 6
    //   344: invokeinterface 159 1 0
    //   349: ifne +10 -> 359
    //   352: aload 6
    //   354: invokeinterface 160 1 0
    //   359: aload_3
    //   360: ifnull +14 -> 374
    //   363: aload_3
    //   364: invokevirtual 104	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   367: ifeq +7 -> 374
    //   370: aload_3
    //   371: invokevirtual 107	android/database/sqlite/SQLiteDatabase:close	()V
    //   374: aload_0
    //   375: astore_3
    //   376: aload 4
    //   378: ifnull -354 -> 24
    //   381: aload 4
    //   383: invokevirtual 108	com/tencent/beacon/a/a/c:close	()V
    //   386: aload_0
    //   387: areturn
    //   388: astore_3
    //   389: aconst_null
    //   390: astore 4
    //   392: aconst_null
    //   393: astore_0
    //   394: aload 4
    //   396: ifnull +20 -> 416
    //   399: aload 4
    //   401: invokeinterface 159 1 0
    //   406: ifne +10 -> 416
    //   409: aload 4
    //   411: invokeinterface 160 1 0
    //   416: aload 5
    //   418: ifnull +16 -> 434
    //   421: aload 5
    //   423: invokevirtual 104	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   426: ifeq +8 -> 434
    //   429: aload 5
    //   431: invokevirtual 107	android/database/sqlite/SQLiteDatabase:close	()V
    //   434: aload_0
    //   435: ifnull +7 -> 442
    //   438: aload_0
    //   439: invokevirtual 108	com/tencent/beacon/a/a/c:close	()V
    //   442: aload_3
    //   443: athrow
    //   444: astore_3
    //   445: aconst_null
    //   446: astore 4
    //   448: goto -54 -> 394
    //   451: astore 6
    //   453: aconst_null
    //   454: astore 4
    //   456: aload_3
    //   457: astore 5
    //   459: aload 6
    //   461: astore_3
    //   462: goto -68 -> 394
    //   465: astore 6
    //   467: aload_3
    //   468: astore 5
    //   470: aload 6
    //   472: astore_3
    //   473: goto -79 -> 394
    //   476: astore 7
    //   478: aload 4
    //   480: astore_0
    //   481: aload 6
    //   483: astore 4
    //   485: aload_3
    //   486: astore 5
    //   488: aload 7
    //   490: astore_3
    //   491: goto -97 -> 394
    //   494: astore 5
    //   496: aconst_null
    //   497: astore_3
    //   498: aload_0
    //   499: astore 4
    //   501: aconst_null
    //   502: astore_0
    //   503: goto -171 -> 332
    //   506: astore 5
    //   508: aload_0
    //   509: astore 4
    //   511: aconst_null
    //   512: astore_0
    //   513: goto -181 -> 332
    //   516: astore 5
    //   518: aload_0
    //   519: astore 6
    //   521: aconst_null
    //   522: astore_0
    //   523: aload 4
    //   525: astore 7
    //   527: aload 6
    //   529: astore 4
    //   531: aload 7
    //   533: astore 6
    //   535: goto -203 -> 332
    //   538: astore 8
    //   540: aload_0
    //   541: astore 6
    //   543: aload 5
    //   545: astore_0
    //   546: aload 4
    //   548: astore 7
    //   550: aload 8
    //   552: astore 5
    //   554: aload 6
    //   556: astore 4
    //   558: aload 7
    //   560: astore 6
    //   562: goto -230 -> 332
    //   565: aload 5
    //   567: areturn
    //   568: aconst_null
    //   569: astore 5
    //   571: goto -380 -> 191
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	574	0	paramContext	Context
    //   0	574	1	paramInt	int
    //   157	2	2	bool	boolean
    //   23	353	3	localObject1	Object
    //   388	55	3	localObject2	Object
    //   444	13	3	localObject3	Object
    //   461	37	3	localObject4	Object
    //   110	447	4	localObject5	Object
    //   4	296	5	localObject6	Object
    //   323	107	5	localThrowable1	Throwable
    //   457	30	5	localObject7	Object
    //   494	1	5	localThrowable2	Throwable
    //   506	1	5	localThrowable3	Throwable
    //   516	28	5	localThrowable4	Throwable
    //   552	18	5	localObject8	Object
    //   1	352	6	localObject9	Object
    //   451	9	6	localObject10	Object
    //   465	17	6	localObject11	Object
    //   519	42	6	localObject12	Object
    //   7	156	7	localObject13	Object
    //   476	13	7	localObject14	Object
    //   525	34	7	localObject15	Object
    //   538	13	8	localThrowable5	Throwable
    // Exception table:
    //   from	to	target	type
    //   26	31	323	java/lang/Throwable
    //   26	31	388	finally
    //   31	36	444	finally
    //   40	49	451	finally
    //   74	112	451	finally
    //   117	127	465	finally
    //   140	158	465	finally
    //   171	191	465	finally
    //   239	320	465	finally
    //   332	337	476	finally
    //   31	36	494	java/lang/Throwable
    //   40	49	506	java/lang/Throwable
    //   74	112	506	java/lang/Throwable
    //   117	127	516	java/lang/Throwable
    //   140	158	516	java/lang/Throwable
    //   239	320	516	java/lang/Throwable
    //   171	191	538	java/lang/Throwable
  }
  
  public static g a(Context paramContext)
  {
    try
    {
      if ((a == null) && (paramContext != null)) {
        a = new g(paramContext);
      }
      paramContext = a;
      return paramContext;
    }
    finally {}
  }
  
  public static String a()
  {
    try
    {
      String str = Build.MODEL;
      return str;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.beacon.d.a.d("getDeviceName error", new Object[0]);
      localThrowable.printStackTrace();
    }
    return "";
  }
  
  public static String a(Map<String, String> paramMap)
  {
    com.tencent.beacon.d.a.b("map 2 str", new Object[0]);
    if (paramMap == null) {
      return "";
    }
    Object localObject = paramMap.keySet();
    if (localObject == null) {
      return "";
    }
    if (((Set)localObject).size() > 50) {
      com.tencent.beacon.d.a.c("The Map<String, String> params size is more than 50, effective size is <= 50!", new Object[0]);
    }
    StringBuffer localStringBuffer = new StringBuffer();
    Iterator localIterator = ((Set)localObject).iterator();
    while (localIterator.hasNext())
    {
      String str2 = (String)localIterator.next();
      int i = str2.trim().length();
      String str1;
      if ((i > 0) && (e(str2)))
      {
        str1 = str2.trim();
        localObject = str1;
        if (i > 64) {
          localObject = str1.substring(0, 64);
        }
        localStringBuffer.append("&");
        localStringBuffer.append(((String)localObject).replace("|", "%7C").replace("&", "%26").replace("=", "%3D"));
        localStringBuffer.append("=");
        localObject = (String)paramMap.get(str2);
        if (localObject == null) {
          continue;
        }
        str1 = ((String)localObject).trim();
        if (!str1.contains(";")) {
          break label328;
        }
        localObject = str1;
        if (str1.length() > 10240)
        {
          localObject = str1.substring(0, 10240);
          localObject = ((String)localObject).substring(0, ((String)localObject).lastIndexOf(";"));
        }
      }
      for (;;)
      {
        localStringBuffer.append(((String)localObject).replace('\n', ' ').replace('\r', ' ').replace("|", "%7C").replace("&", "%26").replace("=", "%3D"));
        break;
        com.tencent.beacon.d.a.c("The Map<String, String> params key is invalid!! key should be ASCII code in 32-126! key:" + str2, new Object[0]);
        break;
        label328:
        localObject = str1;
        if (str1.length() > 1024) {
          localObject = str1.substring(0, 1024);
        }
      }
    }
    paramMap = localStringBuffer.substring(1);
    localStringBuffer.setLength(0);
    return paramMap;
  }
  
  public static List<i> a(Context paramContext, String[] paramArrayOfString, int paramInt)
  {
    com.tencent.beacon.d.a.a(" RecordDAO.queryRecentRecord() start", new Object[0]);
    if (paramContext == null)
    {
      com.tencent.beacon.d.a.d(" queryRecentRecord() have null args!", new Object[0]);
      return null;
    }
    paramArrayOfString = com.tencent.beacon.a.a.a.a(paramContext, new int[] { 1, 2, 3, 4 }, 1, 2, paramInt, -1, -1, -1, -1, -1L, -1L);
    if ((paramArrayOfString == null) || (paramArrayOfString.size() <= 0)) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = paramArrayOfString.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      com.tencent.beacon.a.a.a locala = (com.tencent.beacon.a.a.a)((Iterator)localObject1).next();
      try
      {
        Object localObject2 = com.tencent.beacon.b.a.a(locala.b());
        if ((localObject2 != null) && (i.class.isInstance(localObject2)))
        {
          localObject2 = (i)i.class.cast(localObject2);
          ((i)localObject2).a(locala.a());
          localArrayList.add(localObject2);
          ((Iterator)localObject1).remove();
        }
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
        com.tencent.beacon.d.a.d(" query have error!", new Object[0]);
      }
    }
    if (paramArrayOfString.size() > 0)
    {
      com.tencent.beacon.d.a.a(" there are error datas ,should be remove " + paramArrayOfString.size(), new Object[0]);
      localObject1 = new Long[paramArrayOfString.size()];
      paramInt = 0;
      while (paramInt < paramArrayOfString.size())
      {
        localObject1[paramInt] = Long.valueOf(((com.tencent.beacon.a.a.a)paramArrayOfString.get(paramInt)).a());
        paramInt += 1;
      }
      com.tencent.beacon.a.a.a.a(paramContext, (Long[])localObject1);
    }
    com.tencent.beacon.d.a.a(" RecordDAO.queryRecentRecord() end", new Object[0]);
    return localArrayList;
  }
  
  public static void a(Map<String, String> paramMap, String paramString, long paramLong)
  {
    if ((paramMap == null) || (paramString == null))
    {
      com.tencent.beacon.d.a.c(" err addVMap, pls check!}", new Object[0]);
      return;
    }
    paramMap.put(paramString, Long.toString(a((String)paramMap.get(paramString)) + paramLong));
  }
  
  /* Error */
  public static boolean a(Context paramContext, com.tencent.beacon.a.b.h paramh)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: iconst_0
    //   4: istore_3
    //   5: iconst_0
    //   6: istore 4
    //   8: aload_0
    //   9: ifnull +7 -> 16
    //   12: aload_1
    //   13: ifnonnull +18 -> 31
    //   16: ldc_w 379
    //   19: iconst_0
    //   20: anewarray 4	java/lang/Object
    //   23: invokestatic 87	com/tencent/beacon/d/a:c	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   26: iload 4
    //   28: istore_3
    //   29: iload_3
    //   30: ireturn
    //   31: aload_0
    //   32: invokestatic 92	com/tencent/beacon/a/a/c:a	(Landroid/content/Context;)Lcom/tencent/beacon/a/a/c;
    //   35: invokevirtual 96	com/tencent/beacon/a/a/c:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   38: astore 7
    //   40: aload 7
    //   42: ifnonnull +42 -> 84
    //   45: aload 7
    //   47: astore_0
    //   48: ldc_w 381
    //   51: iconst_0
    //   52: anewarray 4	java/lang/Object
    //   55: invokestatic 64	com/tencent/beacon/d/a:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   58: iload 4
    //   60: istore_3
    //   61: aload 7
    //   63: ifnull -34 -> 29
    //   66: iload 4
    //   68: istore_3
    //   69: aload 7
    //   71: invokevirtual 104	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   74: ifeq -45 -> 29
    //   77: aload 7
    //   79: invokevirtual 107	android/database/sqlite/SQLiteDatabase:close	()V
    //   82: iconst_0
    //   83: ireturn
    //   84: aload_1
    //   85: ifnonnull +72 -> 157
    //   88: iload_3
    //   89: istore_2
    //   90: aload 8
    //   92: ifnull +41 -> 133
    //   95: aload 7
    //   97: astore_0
    //   98: aload 7
    //   100: ldc 110
    //   102: ldc 167
    //   104: aload 8
    //   106: invokevirtual 384	android/database/sqlite/SQLiteDatabase:replace	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   109: lstore 5
    //   111: lload 5
    //   113: lconst_0
    //   114: lcmp
    //   115: ifge +164 -> 279
    //   118: aload 7
    //   120: astore_0
    //   121: ldc_w 386
    //   124: iconst_0
    //   125: anewarray 4	java/lang/Object
    //   128: invokestatic 87	com/tencent/beacon/d/a:c	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   131: iload_3
    //   132: istore_2
    //   133: iload_2
    //   134: istore_3
    //   135: aload 7
    //   137: ifnull -108 -> 29
    //   140: iload_2
    //   141: istore_3
    //   142: aload 7
    //   144: invokevirtual 104	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   147: ifeq -118 -> 29
    //   150: aload 7
    //   152: invokevirtual 107	android/database/sqlite/SQLiteDatabase:close	()V
    //   155: iload_2
    //   156: ireturn
    //   157: aload 7
    //   159: astore_0
    //   160: new 388	android/content/ContentValues
    //   163: dup
    //   164: invokespecial 389	android/content/ContentValues:<init>	()V
    //   167: astore 8
    //   169: aload 7
    //   171: astore_0
    //   172: aload_1
    //   173: invokevirtual 390	com/tencent/beacon/a/b/h:a	()J
    //   176: lconst_0
    //   177: lcmp
    //   178: iflt +20 -> 198
    //   181: aload 7
    //   183: astore_0
    //   184: aload 8
    //   186: ldc 167
    //   188: aload_1
    //   189: invokevirtual 390	com/tencent/beacon/a/b/h:a	()J
    //   192: invokestatic 360	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   195: invokevirtual 393	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   198: aload 7
    //   200: astore_0
    //   201: aload 8
    //   203: ldc 120
    //   205: aload_1
    //   206: invokevirtual 153	com/tencent/beacon/a/b/h:b	()I
    //   209: invokestatic 126	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   212: invokevirtual 396	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   215: aload 7
    //   217: astore_0
    //   218: aload 8
    //   220: ldc 186
    //   222: aload_1
    //   223: invokevirtual 398	com/tencent/beacon/a/b/h:c	()[B
    //   226: invokevirtual 401	android/content/ContentValues:put	(Ljava/lang/String;[B)V
    //   229: goto -141 -> 88
    //   232: astore_1
    //   233: aload 7
    //   235: astore_0
    //   236: ldc_w 403
    //   239: iconst_1
    //   240: anewarray 4	java/lang/Object
    //   243: dup
    //   244: iconst_0
    //   245: aload_1
    //   246: invokevirtual 404	java/lang/Throwable:toString	()Ljava/lang/String;
    //   249: aastore
    //   250: invokestatic 64	com/tencent/beacon/d/a:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   253: iload 4
    //   255: istore_3
    //   256: aload 7
    //   258: ifnull -229 -> 29
    //   261: iload 4
    //   263: istore_3
    //   264: aload 7
    //   266: invokevirtual 104	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   269: ifeq -240 -> 29
    //   272: aload 7
    //   274: invokevirtual 107	android/database/sqlite/SQLiteDatabase:close	()V
    //   277: iconst_0
    //   278: ireturn
    //   279: aload 7
    //   281: astore_0
    //   282: aload_1
    //   283: lload 5
    //   285: invokevirtual 178	com/tencent/beacon/a/b/h:a	(J)V
    //   288: aload 7
    //   290: astore_0
    //   291: ldc_w 406
    //   294: iconst_1
    //   295: anewarray 4	java/lang/Object
    //   298: dup
    //   299: iconst_0
    //   300: aload_1
    //   301: invokevirtual 153	com/tencent/beacon/a/b/h:b	()I
    //   304: invokestatic 126	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   307: aastore
    //   308: invokestatic 408	com/tencent/beacon/d/a:e	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   311: iconst_1
    //   312: istore_2
    //   313: goto -180 -> 133
    //   316: astore_1
    //   317: aconst_null
    //   318: astore_0
    //   319: aload_0
    //   320: ifnull +14 -> 334
    //   323: aload_0
    //   324: invokevirtual 104	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   327: ifeq +7 -> 334
    //   330: aload_0
    //   331: invokevirtual 107	android/database/sqlite/SQLiteDatabase:close	()V
    //   334: aload_1
    //   335: athrow
    //   336: astore_1
    //   337: goto -18 -> 319
    //   340: astore_1
    //   341: aconst_null
    //   342: astore 7
    //   344: goto -111 -> 233
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	347	0	paramContext	Context
    //   0	347	1	paramh	com.tencent.beacon.a.b.h
    //   89	224	2	bool1	boolean
    //   4	260	3	bool2	boolean
    //   6	256	4	bool3	boolean
    //   109	175	5	l	long
    //   38	305	7	localSQLiteDatabase	android.database.sqlite.SQLiteDatabase
    //   1	218	8	localContentValues	android.content.ContentValues
    // Exception table:
    //   from	to	target	type
    //   48	58	232	java/lang/Throwable
    //   98	111	232	java/lang/Throwable
    //   121	131	232	java/lang/Throwable
    //   160	169	232	java/lang/Throwable
    //   172	181	232	java/lang/Throwable
    //   184	198	232	java/lang/Throwable
    //   201	215	232	java/lang/Throwable
    //   218	229	232	java/lang/Throwable
    //   282	288	232	java/lang/Throwable
    //   291	311	232	java/lang/Throwable
    //   31	40	316	finally
    //   48	58	336	finally
    //   98	111	336	finally
    //   121	131	336	finally
    //   160	169	336	finally
    //   172	181	336	finally
    //   184	198	336	finally
    //   201	215	336	finally
    //   218	229	336	finally
    //   236	253	336	finally
    //   282	288	336	finally
    //   291	311	336	finally
    //   31	40	340	java/lang/Throwable
  }
  
  /* Error */
  public static boolean a(Context paramContext, i parami)
  {
    // Byte code:
    //   0: iconst_3
    //   1: istore_3
    //   2: ldc_w 411
    //   5: iconst_0
    //   6: anewarray 4	java/lang/Object
    //   9: invokestatic 59	com/tencent/beacon/d/a:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   12: aload_0
    //   13: ifnull +14 -> 27
    //   16: aload_1
    //   17: ifnull +10 -> 27
    //   20: aload_1
    //   21: invokevirtual 413	com/tencent/beacon/event/i:b	()Ljava/lang/String;
    //   24: ifnonnull +15 -> 39
    //   27: ldc_w 415
    //   30: iconst_0
    //   31: anewarray 4	java/lang/Object
    //   34: invokestatic 64	com/tencent/beacon/d/a:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   37: iconst_0
    //   38: ireturn
    //   39: aload_1
    //   40: invokevirtual 413	com/tencent/beacon/event/i:b	()Ljava/lang/String;
    //   43: ldc_w 417
    //   46: invokevirtual 420	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   49: ifeq +73 -> 122
    //   52: iconst_1
    //   53: istore_2
    //   54: new 29	com/tencent/beacon/a/a/a
    //   57: dup
    //   58: iload_2
    //   59: iload_3
    //   60: aload_1
    //   61: invokevirtual 422	com/tencent/beacon/event/i:c	()J
    //   64: aload_1
    //   65: invokestatic 27	com/tencent/beacon/b/a:a	(Ljava/lang/Object;)[B
    //   68: invokespecial 32	com/tencent/beacon/a/a/a:<init>	(IIJ[B)V
    //   71: astore 5
    //   73: aload_0
    //   74: ifnull +8 -> 82
    //   77: aload 5
    //   79: ifnonnull +115 -> 194
    //   82: ldc_w 424
    //   85: iconst_0
    //   86: anewarray 4	java/lang/Object
    //   89: invokestatic 59	com/tencent/beacon/d/a:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   92: iconst_0
    //   93: istore 4
    //   95: iload 4
    //   97: ifeq +12 -> 109
    //   100: aload_1
    //   101: aload 5
    //   103: invokevirtual 343	com/tencent/beacon/a/a/a:a	()J
    //   106: invokevirtual 344	com/tencent/beacon/event/i:a	(J)V
    //   109: ldc_w 426
    //   112: iconst_0
    //   113: anewarray 4	java/lang/Object
    //   116: invokestatic 59	com/tencent/beacon/d/a:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   119: iload 4
    //   121: ireturn
    //   122: aload_1
    //   123: invokevirtual 413	com/tencent/beacon/event/i:b	()Ljava/lang/String;
    //   126: ldc_w 428
    //   129: invokevirtual 420	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   132: ifeq +10 -> 142
    //   135: iconst_2
    //   136: istore_2
    //   137: iconst_0
    //   138: istore_3
    //   139: goto -85 -> 54
    //   142: aload_1
    //   143: invokevirtual 413	com/tencent/beacon/event/i:b	()Ljava/lang/String;
    //   146: ldc_w 430
    //   149: invokevirtual 420	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   152: ifeq +10 -> 162
    //   155: iconst_3
    //   156: istore_2
    //   157: iconst_0
    //   158: istore_3
    //   159: goto -105 -> 54
    //   162: aload_1
    //   163: invokevirtual 413	com/tencent/beacon/event/i:b	()Ljava/lang/String;
    //   166: ldc_w 432
    //   169: invokevirtual 420	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   172: ifeq +10 -> 182
    //   175: iconst_4
    //   176: istore_2
    //   177: iconst_0
    //   178: istore_3
    //   179: goto -125 -> 54
    //   182: ldc_w 434
    //   185: iconst_0
    //   186: anewarray 4	java/lang/Object
    //   189: invokestatic 64	com/tencent/beacon/d/a:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   192: iconst_0
    //   193: ireturn
    //   194: new 19	java/util/ArrayList
    //   197: dup
    //   198: invokespecial 325	java/util/ArrayList:<init>	()V
    //   201: astore 6
    //   203: aload 6
    //   205: aload 5
    //   207: invokevirtual 44	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   210: pop
    //   211: aload_0
    //   212: aload 6
    //   214: invokestatic 436	com/tencent/beacon/a/a/a:a	(Landroid/content/Context;Ljava/util/List;)Z
    //   217: istore 4
    //   219: goto -124 -> 95
    //   222: astore_0
    //   223: aload_0
    //   224: invokevirtual 194	java/lang/Throwable:printStackTrace	()V
    //   227: ldc_w 438
    //   230: iconst_0
    //   231: anewarray 4	java/lang/Object
    //   234: invokestatic 64	com/tencent/beacon/d/a:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   237: ldc_w 426
    //   240: iconst_0
    //   241: anewarray 4	java/lang/Object
    //   244: invokestatic 59	com/tencent/beacon/d/a:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   247: iconst_0
    //   248: ireturn
    //   249: astore_0
    //   250: ldc_w 426
    //   253: iconst_0
    //   254: anewarray 4	java/lang/Object
    //   257: invokestatic 59	com/tencent/beacon/d/a:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   260: aload_0
    //   261: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	262	0	paramContext	Context
    //   0	262	1	parami	i
    //   53	124	2	i	int
    //   1	178	3	j	int
    //   93	125	4	bool	boolean
    //   71	135	5	locala	com.tencent.beacon.a.a.a
    //   201	12	6	localArrayList	ArrayList
    // Exception table:
    //   from	to	target	type
    //   54	73	222	java/lang/Throwable
    //   82	92	222	java/lang/Throwable
    //   100	109	222	java/lang/Throwable
    //   194	219	222	java/lang/Throwable
    //   54	73	249	finally
    //   82	92	249	finally
    //   100	109	249	finally
    //   194	219	249	finally
    //   223	237	249	finally
  }
  
  public static byte[] a(int paramInt, String paramString, byte[] paramArrayOfByte)
    throws Exception
  {
    if (paramInt == 1) {
      if ((paramString != null) && (paramArrayOfByte != null)) {}
    }
    while (paramInt != 3)
    {
      return null;
      Cipher localCipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
      DESKeySpec localDESKeySpec = new DESKeySpec(paramString.getBytes("UTF-8"));
      localCipher.init(2, SecretKeyFactory.getInstance("DES").generateSecret(localDESKeySpec), new IvParameterSpec(paramString.getBytes("UTF-8")));
      return localCipher.doFinal(paramArrayOfByte);
    }
    return a(paramString, paramArrayOfByte);
  }
  
  public static byte[] a(int paramInt, byte[] paramArrayOfByte)
    throws Exception
  {
    ByteArrayOutputStream localByteArrayOutputStream;
    Object localObject;
    if (paramInt == 1)
    {
      localByteArrayOutputStream = new ByteArrayOutputStream();
      localObject = new ZipOutputStream(localByteArrayOutputStream);
      ZipEntry localZipEntry = new ZipEntry("zip");
      localZipEntry.setSize(paramArrayOfByte.length);
      ((ZipOutputStream)localObject).putNextEntry(localZipEntry);
      ((ZipOutputStream)localObject).write(paramArrayOfByte);
      ((ZipOutputStream)localObject).closeEntry();
      ((ZipOutputStream)localObject).close();
      paramArrayOfByte = localByteArrayOutputStream.toByteArray();
      localByteArrayOutputStream.close();
      return paramArrayOfByte;
    }
    if (paramInt == 2)
    {
      localByteArrayOutputStream = new ByteArrayOutputStream();
      localObject = new GZIPOutputStream(localByteArrayOutputStream);
      ((GZIPOutputStream)localObject).write(paramArrayOfByte);
      ((GZIPOutputStream)localObject).finish();
      ((GZIPOutputStream)localObject).close();
      paramArrayOfByte = localByteArrayOutputStream.toByteArray();
      localByteArrayOutputStream.close();
      return paramArrayOfByte;
    }
    return null;
  }
  
  private static byte[] a(String paramString, byte[] paramArrayOfByte)
    throws Exception
  {
    int j = 0;
    if ((paramString == null) || (paramArrayOfByte == null))
    {
      paramString = null;
      return paramString;
    }
    int i = paramString.length();
    label19:
    Object localObject;
    int k;
    if (i >= 16)
    {
      paramString = paramString.substring(0, 16);
      localObject = new StringBuffer();
      k = paramArrayOfByte.length;
      i = 0;
    }
    for (;;)
    {
      if (i >= k)
      {
        localObject = new SecretKeySpec(paramString.getBytes(), "AES");
        Cipher localCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        localCipher.init(2, (Key)localObject, new IvParameterSpec(paramString.getBytes()));
        paramArrayOfByte = localCipher.doFinal(paramArrayOfByte);
        localObject = new StringBuffer();
        k = paramArrayOfByte.length;
        i = j;
        for (;;)
        {
          paramString = paramArrayOfByte;
          if (i >= k) {
            break;
          }
          ((StringBuffer)localObject).append(paramArrayOfByte[i] + " ");
          i += 1;
        }
        paramString = paramString + "0";
        i += 1;
        break label19;
      }
      ((StringBuffer)localObject).append(paramArrayOfByte[i] + " ");
      i += 1;
    }
  }
  
  private static byte[] a(byte[] paramArrayOfByte)
    throws Exception
  {
    paramArrayOfByte = new ByteArrayInputStream(paramArrayOfByte);
    GZIPInputStream localGZIPInputStream = new GZIPInputStream(paramArrayOfByte);
    byte[] arrayOfByte = new byte[1024];
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    for (;;)
    {
      int i = localGZIPInputStream.read(arrayOfByte, 0, arrayOfByte.length);
      if (i == -1)
      {
        arrayOfByte = localByteArrayOutputStream.toByteArray();
        localByteArrayOutputStream.flush();
        localByteArrayOutputStream.close();
        localGZIPInputStream.close();
        paramArrayOfByte.close();
        return arrayOfByte;
      }
      localByteArrayOutputStream.write(arrayOfByte, 0, i);
    }
  }
  
  public static Long[] a(Context paramContext, List<i> paramList)
  {
    com.tencent.beacon.d.a.a(" RecordDAO.insertList() start", new Object[0]);
    if ((paramContext == null) || (paramList == null))
    {
      com.tencent.beacon.d.a.d(" insertList() have null args!", new Object[0]);
      return null;
    }
    int m = paramList.size();
    if (m == 0)
    {
      com.tencent.beacon.d.a.b(" list siez == 0 , return true!", new Object[0]);
      return null;
    }
    Long[] arrayOfLong = new Long[m];
    ArrayList localArrayList = new ArrayList();
    int k = 0;
    for (;;)
    {
      if (k < m)
      {
        i locali = (i)paramList.get(k);
        int j;
        if (locali.b().equals("UA"))
        {
          i = 1;
          j = 3;
        }
        try
        {
          label112:
          localArrayList.add(new com.tencent.beacon.a.a.a(i, j, locali.c(), com.tencent.beacon.b.a.a(locali)));
          for (;;)
          {
            k += 1;
            break;
            if (locali.b().equals("IP"))
            {
              i = 2;
              j = 0;
              break label112;
            }
            if (locali.b().equals("DN"))
            {
              j = 0;
              i = 3;
              break label112;
            }
            if (locali.b().equals("HO"))
            {
              i = 4;
              j = 0;
              break label112;
            }
            com.tencent.beacon.d.a.d(" bean's type is error!", new Object[0]);
          }
        }
        catch (Throwable localThrowable)
        {
          for (;;)
          {
            localThrowable.printStackTrace();
          }
        }
      }
    }
    if (!com.tencent.beacon.a.a.a.a(paramContext, localArrayList)) {
      return null;
    }
    paramContext = localArrayList.iterator();
    int i = 0;
    while (paramContext.hasNext())
    {
      paramList = (com.tencent.beacon.a.a.a)paramContext.next();
      if (i < m) {
        arrayOfLong[i] = Long.valueOf(paramList.a());
      }
      i += 1;
    }
    return arrayOfLong;
  }
  
  /* Error */
  public static int b(Context paramContext, int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 4
    //   6: aconst_null
    //   7: astore 7
    //   9: aconst_null
    //   10: astore 6
    //   12: iconst_0
    //   13: istore_1
    //   14: iconst_0
    //   15: istore_3
    //   16: iconst_0
    //   17: istore_2
    //   18: aload_0
    //   19: ifnonnull +17 -> 36
    //   22: ldc_w 575
    //   25: iconst_0
    //   26: anewarray 4	java/lang/Object
    //   29: invokestatic 87	com/tencent/beacon/d/a:c	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   32: iload_2
    //   33: istore_1
    //   34: iload_1
    //   35: ireturn
    //   36: aload_0
    //   37: invokestatic 92	com/tencent/beacon/a/a/c:a	(Landroid/content/Context;)Lcom/tencent/beacon/a/a/c;
    //   40: astore_0
    //   41: aload_0
    //   42: astore 5
    //   44: aload 4
    //   46: astore_0
    //   47: aload 5
    //   49: astore 4
    //   51: iload_3
    //   52: istore_1
    //   53: aload 7
    //   55: astore 6
    //   57: aload 5
    //   59: invokevirtual 96	com/tencent/beacon/a/a/c:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   62: astore 7
    //   64: aload 7
    //   66: ifnonnull +58 -> 124
    //   69: aload 7
    //   71: astore_0
    //   72: aload 5
    //   74: astore 4
    //   76: iload_3
    //   77: istore_1
    //   78: aload 7
    //   80: astore 6
    //   82: ldc_w 577
    //   85: iconst_0
    //   86: anewarray 4	java/lang/Object
    //   89: invokestatic 64	com/tencent/beacon/d/a:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   92: aload 7
    //   94: ifnull +16 -> 110
    //   97: aload 7
    //   99: invokevirtual 104	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   102: ifeq +8 -> 110
    //   105: aload 7
    //   107: invokevirtual 107	android/database/sqlite/SQLiteDatabase:close	()V
    //   110: iload_2
    //   111: istore_1
    //   112: aload 5
    //   114: ifnull -80 -> 34
    //   117: aload 5
    //   119: invokevirtual 108	com/tencent/beacon/a/a/c:close	()V
    //   122: iconst_0
    //   123: ireturn
    //   124: aload 7
    //   126: astore_0
    //   127: aload 5
    //   129: astore 4
    //   131: iload_3
    //   132: istore_1
    //   133: aload 7
    //   135: astore 6
    //   137: aload 7
    //   139: ldc 110
    //   141: ldc_w 579
    //   144: iconst_2
    //   145: anewarray 4	java/lang/Object
    //   148: dup
    //   149: iconst_0
    //   150: ldc 120
    //   152: aastore
    //   153: dup
    //   154: iconst_1
    //   155: bipush 101
    //   157: invokestatic 126	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   160: aastore
    //   161: invokestatic 582	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   164: aconst_null
    //   165: invokevirtual 586	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   168: istore_2
    //   169: aload 7
    //   171: astore_0
    //   172: aload 5
    //   174: astore 4
    //   176: iload_2
    //   177: istore_1
    //   178: aload 7
    //   180: astore 6
    //   182: ldc_w 588
    //   185: iconst_2
    //   186: anewarray 4	java/lang/Object
    //   189: dup
    //   190: iconst_0
    //   191: bipush 101
    //   193: invokestatic 126	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   196: aastore
    //   197: dup
    //   198: iconst_1
    //   199: iload_2
    //   200: invokestatic 126	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   203: aastore
    //   204: invokestatic 156	com/tencent/beacon/d/a:g	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   207: aload 7
    //   209: ifnull +16 -> 225
    //   212: aload 7
    //   214: invokevirtual 104	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   217: ifeq +8 -> 225
    //   220: aload 7
    //   222: invokevirtual 107	android/database/sqlite/SQLiteDatabase:close	()V
    //   225: iload_2
    //   226: istore_1
    //   227: aload 5
    //   229: ifnull -195 -> 34
    //   232: aload 5
    //   234: invokevirtual 108	com/tencent/beacon/a/a/c:close	()V
    //   237: iload_2
    //   238: ireturn
    //   239: astore 7
    //   241: aconst_null
    //   242: astore 5
    //   244: iload_1
    //   245: istore_2
    //   246: aload 6
    //   248: astore_0
    //   249: aload 5
    //   251: astore 4
    //   253: aload 7
    //   255: invokevirtual 194	java/lang/Throwable:printStackTrace	()V
    //   258: aload 6
    //   260: ifnull +16 -> 276
    //   263: aload 6
    //   265: invokevirtual 104	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   268: ifeq +8 -> 276
    //   271: aload 6
    //   273: invokevirtual 107	android/database/sqlite/SQLiteDatabase:close	()V
    //   276: iload_2
    //   277: istore_1
    //   278: aload 5
    //   280: ifnull -246 -> 34
    //   283: aload 5
    //   285: invokevirtual 108	com/tencent/beacon/a/a/c:close	()V
    //   288: iload_2
    //   289: ireturn
    //   290: astore 6
    //   292: aconst_null
    //   293: astore 4
    //   295: aload 5
    //   297: astore_0
    //   298: aload 6
    //   300: astore 5
    //   302: aload_0
    //   303: ifnull +14 -> 317
    //   306: aload_0
    //   307: invokevirtual 104	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   310: ifeq +7 -> 317
    //   313: aload_0
    //   314: invokevirtual 107	android/database/sqlite/SQLiteDatabase:close	()V
    //   317: aload 4
    //   319: ifnull +8 -> 327
    //   322: aload 4
    //   324: invokevirtual 108	com/tencent/beacon/a/a/c:close	()V
    //   327: aload 5
    //   329: athrow
    //   330: astore 5
    //   332: goto -30 -> 302
    //   335: astore 7
    //   337: iload_1
    //   338: istore_2
    //   339: goto -93 -> 246
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	342	0	paramContext	Context
    //   0	342	1	paramInt	int
    //   17	322	2	i	int
    //   15	117	3	j	int
    //   4	319	4	localObject1	Object
    //   1	327	5	localObject2	Object
    //   330	1	5	localObject3	Object
    //   10	262	6	localSQLiteDatabase1	android.database.sqlite.SQLiteDatabase
    //   290	9	6	localObject4	Object
    //   7	214	7	localSQLiteDatabase2	android.database.sqlite.SQLiteDatabase
    //   239	15	7	localThrowable1	Throwable
    //   335	1	7	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   36	41	239	java/lang/Throwable
    //   36	41	290	finally
    //   57	64	330	finally
    //   82	92	330	finally
    //   137	169	330	finally
    //   182	207	330	finally
    //   253	258	330	finally
    //   57	64	335	java/lang/Throwable
    //   82	92	335	java/lang/Throwable
    //   137	169	335	java/lang/Throwable
    //   182	207	335	java/lang/Throwable
  }
  
  public static int b(Context paramContext, d[] paramArrayOfd)
  {
    int j = 0;
    int i;
    if (paramContext == null) {
      i = -1;
    }
    ArrayList localArrayList;
    do
    {
      return i;
      if (paramArrayOfd == null) {
        return com.tencent.beacon.a.a.a.a(paramContext, new int[] { 6 }, -1L, 9223372036854775807L);
      }
      localArrayList = new ArrayList();
      int k = paramArrayOfd.length;
      i = 0;
      while (i < k)
      {
        d locald = paramArrayOfd[i];
        if (locald.a() >= 0L) {
          localArrayList.add(Long.valueOf(locald.a()));
        }
        i += 1;
      }
      i = j;
    } while (localArrayList.size() <= 0);
    return com.tencent.beacon.a.a.a.a(paramContext, (Long[])localArrayList.toArray(new Long[0]));
  }
  
  public static String b()
  {
    try
    {
      String str = Build.VERSION.RELEASE;
      return str;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.beacon.d.a.d("getVersion error", new Object[0]);
      localThrowable.printStackTrace();
    }
    return "";
  }
  
  public static String b(Context paramContext)
  {
    String str = "";
    if (paramContext == null)
    {
      com.tencent.beacon.d.a.d("getImei but context == null!", new Object[0]);
      return "";
    }
    for (;;)
    {
      try
      {
        paramContext = ((TelephonyManager)paramContext.getSystemService("phone")).getDeviceId();
        if (paramContext != null) {
          continue;
        }
        paramContext = "";
        try
        {
          com.tencent.beacon.d.a.a("IMEI:" + paramContext, new Object[0]);
          return paramContext;
        }
        catch (Throwable localThrowable1) {}
      }
      catch (Throwable localThrowable2)
      {
        paramContext = (Context)localObject;
        Object localObject = localThrowable2;
        continue;
      }
      com.tencent.beacon.d.a.d("getImei error!", new Object[0]);
      localThrowable1.printStackTrace();
      return paramContext;
      localObject = paramContext;
      paramContext = paramContext.toLowerCase();
    }
  }
  
  public static String b(String paramString)
  {
    String str2 = paramString.replace('|', '_').trim();
    String str1;
    if (str2.length() == 0)
    {
      com.tencent.beacon.d.a.c("eventName is invalid!! eventName length == 0!", new Object[0]);
      str1 = null;
    }
    do
    {
      return str1;
      if (!e(str2)) {
        break;
      }
      str1 = str2;
    } while (str2.length() <= 128);
    com.tencent.beacon.d.a.c("eventName is invalid!! eventName length should be less than 128! eventName:" + paramString, new Object[0]);
    return str2.substring(0, 128);
    com.tencent.beacon.d.a.c("eventName is invalid!! eventName should be ASCII code in 32-126! eventName:" + paramString, new Object[0]);
    return null;
  }
  
  public static byte[] b(int paramInt, String paramString, byte[] paramArrayOfByte)
    throws Exception, NoSuchAlgorithmException
  {
    if (paramInt == 1) {
      if ((paramString != null) && (paramArrayOfByte != null)) {}
    }
    while (paramInt != 3)
    {
      return null;
      Cipher localCipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
      DESKeySpec localDESKeySpec = new DESKeySpec(paramString.getBytes("UTF-8"));
      localCipher.init(1, SecretKeyFactory.getInstance("DES").generateSecret(localDESKeySpec), new IvParameterSpec(paramString.getBytes("UTF-8")));
      return localCipher.doFinal(paramArrayOfByte);
    }
    return b(paramString, paramArrayOfByte);
  }
  
  public static byte[] b(int paramInt, byte[] paramArrayOfByte)
    throws Exception
  {
    ByteArrayInputStream localByteArrayInputStream = null;
    Object localObject = null;
    ZipInputStream localZipInputStream;
    if (paramInt == 1)
    {
      localByteArrayInputStream = new ByteArrayInputStream(paramArrayOfByte);
      localZipInputStream = new ZipInputStream(localByteArrayInputStream);
      paramArrayOfByte = (byte[])localObject;
      if (localZipInputStream.getNextEntry() == null)
      {
        localZipInputStream.close();
        localByteArrayInputStream.close();
        localObject = paramArrayOfByte;
      }
    }
    do
    {
      return localObject;
      paramArrayOfByte = new byte[1024];
      localObject = new ByteArrayOutputStream();
      for (;;)
      {
        paramInt = localZipInputStream.read(paramArrayOfByte, 0, paramArrayOfByte.length);
        if (paramInt == -1)
        {
          paramArrayOfByte = ((ByteArrayOutputStream)localObject).toByteArray();
          ((ByteArrayOutputStream)localObject).flush();
          ((ByteArrayOutputStream)localObject).close();
          break;
        }
        ((ByteArrayOutputStream)localObject).write(paramArrayOfByte, 0, paramInt);
      }
      localObject = localByteArrayInputStream;
    } while (paramInt != 2);
    return a(paramArrayOfByte);
  }
  
  private static byte[] b(String paramString, byte[] paramArrayOfByte)
    throws Exception, NoSuchAlgorithmException
  {
    int j = 0;
    if ((paramString == null) || (paramArrayOfByte == null))
    {
      paramString = null;
      return paramString;
    }
    int i = paramString.length();
    label19:
    Object localObject;
    int k;
    if (i >= 16)
    {
      paramString = paramString.substring(0, 16);
      localObject = new StringBuffer();
      k = paramArrayOfByte.length;
      i = 0;
    }
    for (;;)
    {
      if (i >= k)
      {
        localObject = new SecretKeySpec(paramString.getBytes(), "AES");
        Cipher localCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        localCipher.init(1, (Key)localObject, new IvParameterSpec(paramString.getBytes()));
        paramArrayOfByte = localCipher.doFinal(paramArrayOfByte);
        localObject = new StringBuffer();
        k = paramArrayOfByte.length;
        i = j;
        for (;;)
        {
          paramString = paramArrayOfByte;
          if (i >= k) {
            break;
          }
          ((StringBuffer)localObject).append(paramArrayOfByte[i] + " ");
          i += 1;
        }
        paramString = paramString + "0";
        i += 1;
        break label19;
      }
      ((StringBuffer)localObject).append(paramArrayOfByte[i] + " ");
      i += 1;
    }
  }
  
  public static int c(Context paramContext, d[] paramArrayOfd)
  {
    int j = 0;
    int i;
    if ((paramContext == null) || (paramArrayOfd == null) || (paramArrayOfd.length <= 0)) {
      i = -1;
    }
    ArrayList localArrayList;
    do
    {
      return i;
      localArrayList = new ArrayList(paramArrayOfd.length);
      int k = paramArrayOfd.length;
      i = 0;
      while (i < k)
      {
        d locald = paramArrayOfd[i];
        Object localObject = com.tencent.beacon.b.a.a(locald);
        if (localObject != null)
        {
          localObject = new com.tencent.beacon.a.a.a(7, 0, 0L, (byte[])localObject);
          ((com.tencent.beacon.a.a.a)localObject).a(locald.a());
          localArrayList.add(localObject);
        }
        i += 1;
      }
      i = j;
    } while (localArrayList.size() <= 0);
    if (com.tencent.beacon.a.a.a.b(paramContext, localArrayList)) {
      return localArrayList.size();
    }
    return -1;
  }
  
  public static String c()
  {
    try
    {
      String str = Build.VERSION.SDK;
      return str;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.beacon.d.a.d("getApiLevel error", new Object[0]);
      localThrowable.printStackTrace();
    }
    return "";
  }
  
  public static String c(Context paramContext)
  {
    Object localObject = "";
    if (paramContext == null)
    {
      com.tencent.beacon.d.a.d("getImsi but context == null!", new Object[0]);
      return "";
    }
    try
    {
      paramContext = ((TelephonyManager)paramContext.getSystemService("phone")).getSubscriberId();
      if (paramContext == null) {
        return "";
      }
      localObject = paramContext;
      paramContext = paramContext.toLowerCase();
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      com.tencent.beacon.d.a.d("getImsi error!", new Object[0]);
      paramContext.printStackTrace();
    }
    return localObject;
  }
  
  public static String c(String paramString)
  {
    String str = paramString.replace('|', '_').trim();
    if (e(str))
    {
      if (str.length() < 5) {
        com.tencent.beacon.d.a.c(" userID is invalid!! userID is too short, length < 5!", new Object[0]);
      }
      paramString = str;
      if (str.length() > 128) {
        paramString = str.substring(0, 128);
      }
      return paramString;
    }
    com.tencent.beacon.d.a.c("userID is invalid!! userID should be ASCII code in 32-126! userID:" + paramString, new Object[0]);
    return "10000";
  }
  
  public static String d()
  {
    String str = null;
    try
    {
      Object localObject = Build.class.getField("HARDWARE").get(null);
      if (localObject != null) {
        str = localObject.toString();
      }
      return str;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.beacon.d.a.c("getCpuProductorName error!", new Object[0]);
    }
    return null;
  }
  
  public static String d(Context paramContext)
  {
    String str2 = "";
    if (paramContext == null)
    {
      com.tencent.beacon.d.a.d("getAndroidId but context == null!", new Object[0]);
      return "";
    }
    try
    {
      paramContext = Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
      if (paramContext == null) {
        return "";
      }
      String str1;
      com.tencent.beacon.d.a.d("getAndroidId error!", new Object[0]);
    }
    catch (Throwable localThrowable1)
    {
      try
      {
        str1 = paramContext.toLowerCase();
        return str1;
      }
      catch (Throwable localThrowable2)
      {
        break label48;
      }
      localThrowable1 = localThrowable1;
      paramContext = str2;
    }
    label48:
    localThrowable1.printStackTrace();
    return paramContext;
  }
  
  public static String d(String paramString)
  {
    String str2 = "unknown";
    String str1 = str2;
    if (paramString != null)
    {
      if (paramString.trim().length() == 0) {
        str1 = str2;
      }
    }
    else {
      return str1;
    }
    str1 = paramString.trim();
    int i = str1.length();
    int j;
    do
    {
      i -= 1;
      if (i < 0) {
        break;
      }
      j = str1.charAt(i);
    } while ((j >= 48) && (j <= 57));
    for (i = 0;; i = 1)
    {
      if (i == 0) {
        break label98;
      }
      paramString = paramString.trim();
      str1 = paramString;
      if (paramString.length() <= 16) {
        break;
      }
      return paramString.substring(0, 16);
    }
    label98:
    com.tencent.beacon.d.a.c("channelID is invalid!! channelID should be Numeric! channelID:" + paramString, new Object[0]);
    return "unknown";
  }
  
  public static String e()
  {
    try
    {
      Object localObject = new StatFs(Environment.getDataDirectory().getPath());
      long l1 = ((StatFs)localObject).getBlockSize();
      long l2 = ((StatFs)localObject).getBlockCount();
      localObject = l2 * l1 / 1024L / 1024L;
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.beacon.d.a.d("getDisplayMetrics error!", new Object[0]);
      localThrowable.printStackTrace();
    }
    return null;
  }
  
  public static String e(Context paramContext)
  {
    Object localObject = "";
    if (paramContext == null)
    {
      com.tencent.beacon.d.a.d("getMacAddress but context == null!", new Object[0]);
      return "";
    }
    try
    {
      paramContext = ((WifiManager)paramContext.getSystemService("wifi")).getConnectionInfo().getMacAddress();
      if (paramContext == null) {
        return "";
      }
      localObject = paramContext;
      paramContext = paramContext.toLowerCase();
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      paramContext.printStackTrace();
      com.tencent.beacon.d.a.d("getMacAddress error!", new Object[0]);
    }
    return localObject;
  }
  
  public static boolean e(String paramString)
  {
    int i = paramString.length();
    boolean bool = true;
    for (;;)
    {
      int j = i - 1;
      if (j < 0) {
        break;
      }
      int k = paramString.charAt(j);
      if (k >= 32)
      {
        i = j;
        if (k < 127) {}
      }
      else
      {
        bool = false;
        i = j;
      }
    }
    return bool;
  }
  
  public static String f(Context paramContext)
  {
    if (paramContext == null)
    {
      com.tencent.beacon.d.a.d("getMacAddress but context == null!", new Object[0]);
      return "";
    }
    try
    {
      paramContext = ((WifiManager)paramContext.getSystemService("wifi")).getConnectionInfo().getBSSID();
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
        com.tencent.beacon.d.a.d("getMacAddress error!", new Object[0]);
        paramContext = "";
      }
    }
  }
  
  public static String g()
  {
    long l5 = 0L;
    for (;;)
    {
      try
      {
        Object localObject1 = "/proc/" + a.a + "/stat";
        Object localObject2 = com.tencent.beacon.b.a.b("/proc/stat");
        if (localObject2 == null) {
          break label707;
        }
        localObject2 = ((String)localObject2).split(" ");
        if (localObject2.length < 11) {
          break label707;
        }
        int i = Integer.valueOf(localObject2[2]).intValue();
        int j = Integer.valueOf(localObject2[3]).intValue();
        int k = Integer.valueOf(localObject2[4]).intValue();
        int m = Integer.valueOf(localObject2[5]).intValue();
        int n = Integer.valueOf(localObject2[6]).intValue();
        int i1 = Integer.valueOf(localObject2[7]).intValue();
        int i2 = Integer.valueOf(localObject2[8]).intValue();
        int i3 = Integer.valueOf(localObject2[9]).intValue();
        l1 = Integer.valueOf(localObject2[10]).intValue() + (i + j + k + m + n + i1 + i2 + i3);
        com.tencent.beacon.d.a.b("totalCpuTime1:" + l1, new Object[0]);
        localObject2 = com.tencent.beacon.b.a.b((String)localObject1);
        if (localObject2 == null) {
          break label701;
        }
        localObject2 = ((String)localObject2).split(" ");
        if (localObject2.length < 18) {
          break label701;
        }
        i = Integer.valueOf(localObject2[13]).intValue();
        j = Integer.valueOf(localObject2[14]).intValue();
        k = Integer.valueOf(localObject2[15]).intValue();
        l2 = Integer.valueOf(localObject2[16]).intValue() + (i + j + k);
        com.tencent.beacon.d.a.b("proCpuTime1:" + l2, new Object[0]);
        try
        {
          Thread.sleep(500L);
          localObject2 = com.tencent.beacon.b.a.b("/proc/stat");
          if (localObject2 == null) {
            break label695;
          }
          localObject2 = ((String)localObject2).split(" ");
          if (localObject2.length < 10) {
            break label695;
          }
          i = Integer.valueOf(localObject2[2]).intValue();
          j = Integer.valueOf(localObject2[3]).intValue();
          k = Integer.valueOf(localObject2[4]).intValue();
          m = Integer.valueOf(localObject2[5]).intValue();
          n = Integer.valueOf(localObject2[6]).intValue();
          i1 = Integer.valueOf(localObject2[7]).intValue();
          i2 = Integer.valueOf(localObject2[8]).intValue();
          i3 = Integer.valueOf(localObject2[9]).intValue();
          l3 = Integer.valueOf(localObject2[10]).intValue() + (i + j + k + m + n + i1 + i2 + i3);
          com.tencent.beacon.d.a.b("totalCpuTime2:" + l3, new Object[0]);
          localObject1 = com.tencent.beacon.b.a.b((String)localObject1);
          long l4 = l5;
          if (localObject1 != null)
          {
            localObject1 = ((String)localObject1).split(" ");
            l4 = l5;
            if (localObject1.length >= 18)
            {
              l4 = Integer.valueOf(localObject1[13]).intValue() + Integer.valueOf(localObject1[14]).intValue() + Integer.valueOf(localObject1[15]).intValue() + Integer.valueOf(localObject1[16]).intValue();
              com.tencent.beacon.d.a.b("proCpuTime2:" + l4, new Object[0]);
            }
          }
          float f = (float)(l3 - l1);
          if (f > 0.0F) {
            return String.format("%.2f", new Object[] { Double.valueOf((float)(l4 - l2) / f) });
          }
        }
        catch (InterruptedException localInterruptedException)
        {
          localInterruptedException.printStackTrace();
          continue;
        }
        return "0";
      }
      catch (Exception localException)
      {
        return "0";
      }
      label695:
      long l3 = 0L;
      continue;
      label701:
      long l2 = 0L;
      continue;
      label707:
      long l1 = 0L;
    }
  }
  
  public static String g(Context paramContext)
  {
    if (paramContext == null)
    {
      com.tencent.beacon.d.a.d("getWifiSSID but context == null!", new Object[0]);
      return "";
    }
    try
    {
      paramContext = ((WifiManager)paramContext.getSystemService("wifi")).getConnectionInfo();
      if (paramContext.getBSSID() != null)
      {
        paramContext = paramContext.getSSID();
        return paramContext;
      }
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
        com.tencent.beacon.d.a.d("getWifiSSID error!", new Object[0]);
        paramContext = "";
      }
    }
  }
  
  public static DisplayMetrics h(Context paramContext)
  {
    if (paramContext == null)
    {
      com.tencent.beacon.d.a.d("getDisplayMetrics but context == null!", new Object[0]);
      return null;
    }
    try
    {
      DisplayMetrics localDisplayMetrics = new DisplayMetrics();
      ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getMetrics(localDisplayMetrics);
      return localDisplayMetrics;
    }
    catch (Throwable paramContext)
    {
      com.tencent.beacon.d.a.d("getDisplayMetrics error!", new Object[0]);
      paramContext.printStackTrace();
    }
    return null;
  }
  
  /* Error */
  public static String h()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: new 832	java/io/FileReader
    //   6: dup
    //   7: ldc_w 834
    //   10: invokespecial 835	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   13: astore_3
    //   14: new 837	java/io/BufferedReader
    //   17: dup
    //   18: aload_3
    //   19: sipush 8192
    //   22: invokespecial 840	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   25: astore_2
    //   26: aload_2
    //   27: astore 5
    //   29: aload_3
    //   30: astore 4
    //   32: aload_2
    //   33: invokevirtual 843	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   36: ldc_w 845
    //   39: iconst_2
    //   40: invokevirtual 848	java/lang/String:split	(Ljava/lang/String;I)[Ljava/lang/String;
    //   43: iconst_1
    //   44: aaload
    //   45: invokevirtual 629	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   48: ldc_w 850
    //   51: ldc 210
    //   53: invokevirtual 268	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   56: invokevirtual 243	java/lang/String:trim	()Ljava/lang/String;
    //   59: invokestatic 76	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   62: ldc2_w 727
    //   65: ldiv
    //   66: lstore_0
    //   67: aload_2
    //   68: astore 5
    //   70: aload_3
    //   71: astore 4
    //   73: new 292	java/lang/StringBuilder
    //   76: dup
    //   77: invokespecial 726	java/lang/StringBuilder:<init>	()V
    //   80: lload_0
    //   81: invokevirtual 731	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   84: invokevirtual 303	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   87: astore 6
    //   89: aload 6
    //   91: astore 4
    //   93: aload_2
    //   94: invokevirtual 851	java/io/BufferedReader:close	()V
    //   97: aload_3
    //   98: invokevirtual 852	java/io/FileReader:close	()V
    //   101: aload 4
    //   103: areturn
    //   104: astore_2
    //   105: ldc_w 854
    //   108: iconst_0
    //   109: anewarray 4	java/lang/Object
    //   112: invokestatic 64	com/tencent/beacon/d/a:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   115: aload_2
    //   116: invokevirtual 194	java/lang/Throwable:printStackTrace	()V
    //   119: aload 4
    //   121: areturn
    //   122: astore 6
    //   124: aconst_null
    //   125: astore_2
    //   126: aconst_null
    //   127: astore_3
    //   128: aload_2
    //   129: astore 5
    //   131: aload_3
    //   132: astore 4
    //   134: ldc_w 854
    //   137: iconst_0
    //   138: anewarray 4	java/lang/Object
    //   141: invokestatic 64	com/tencent/beacon/d/a:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   144: aload_2
    //   145: astore 5
    //   147: aload_3
    //   148: astore 4
    //   150: aload 6
    //   152: invokevirtual 194	java/lang/Throwable:printStackTrace	()V
    //   155: aload_2
    //   156: ifnull +7 -> 163
    //   159: aload_2
    //   160: invokevirtual 851	java/io/BufferedReader:close	()V
    //   163: aload 7
    //   165: astore 4
    //   167: aload_3
    //   168: ifnull -67 -> 101
    //   171: aload_3
    //   172: invokevirtual 852	java/io/FileReader:close	()V
    //   175: aconst_null
    //   176: areturn
    //   177: astore_2
    //   178: ldc_w 854
    //   181: iconst_0
    //   182: anewarray 4	java/lang/Object
    //   185: invokestatic 64	com/tencent/beacon/d/a:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   188: aload_2
    //   189: invokevirtual 194	java/lang/Throwable:printStackTrace	()V
    //   192: aconst_null
    //   193: areturn
    //   194: astore_2
    //   195: aconst_null
    //   196: astore 5
    //   198: aconst_null
    //   199: astore_3
    //   200: aload 5
    //   202: ifnull +8 -> 210
    //   205: aload 5
    //   207: invokevirtual 851	java/io/BufferedReader:close	()V
    //   210: aload_3
    //   211: ifnull +7 -> 218
    //   214: aload_3
    //   215: invokevirtual 852	java/io/FileReader:close	()V
    //   218: aload_2
    //   219: athrow
    //   220: astore_3
    //   221: ldc_w 854
    //   224: iconst_0
    //   225: anewarray 4	java/lang/Object
    //   228: invokestatic 64	com/tencent/beacon/d/a:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   231: aload_3
    //   232: invokevirtual 194	java/lang/Throwable:printStackTrace	()V
    //   235: goto -17 -> 218
    //   238: astore_2
    //   239: aconst_null
    //   240: astore 5
    //   242: goto -42 -> 200
    //   245: astore_2
    //   246: aload 4
    //   248: astore_3
    //   249: goto -49 -> 200
    //   252: astore 6
    //   254: aconst_null
    //   255: astore_2
    //   256: goto -128 -> 128
    //   259: astore 6
    //   261: goto -133 -> 128
    // Local variable table:
    //   start	length	slot	name	signature
    //   66	15	0	l	long
    //   25	69	2	localBufferedReader	java.io.BufferedReader
    //   104	12	2	localThrowable1	Throwable
    //   125	35	2	localObject1	Object
    //   177	12	2	localThrowable2	Throwable
    //   194	25	2	localObject2	Object
    //   238	1	2	localObject3	Object
    //   245	1	2	localObject4	Object
    //   255	1	2	localObject5	Object
    //   13	202	3	localFileReader	java.io.FileReader
    //   220	12	3	localThrowable3	Throwable
    //   248	1	3	localObject6	Object
    //   30	217	4	localObject7	Object
    //   27	214	5	localObject8	Object
    //   87	3	6	str	String
    //   122	29	6	localThrowable4	Throwable
    //   252	1	6	localThrowable5	Throwable
    //   259	1	6	localThrowable6	Throwable
    //   1	163	7	localObject9	Object
    // Exception table:
    //   from	to	target	type
    //   93	101	104	java/lang/Throwable
    //   3	14	122	java/lang/Throwable
    //   159	163	177	java/lang/Throwable
    //   171	175	177	java/lang/Throwable
    //   3	14	194	finally
    //   205	210	220	java/lang/Throwable
    //   214	218	220	java/lang/Throwable
    //   14	26	238	finally
    //   32	67	245	finally
    //   73	89	245	finally
    //   134	144	245	finally
    //   150	155	245	finally
    //   14	26	252	java/lang/Throwable
    //   32	67	259	java/lang/Throwable
    //   73	89	259	java/lang/Throwable
  }
  
  public static long i(Context paramContext)
  {
    if (paramContext == null)
    {
      com.tencent.beacon.d.a.d("getFreeMem but context == null!", new Object[0]);
      return -1L;
    }
    try
    {
      paramContext = (ActivityManager)paramContext.getSystemService("activity");
      ActivityManager.MemoryInfo localMemoryInfo = new ActivityManager.MemoryInfo();
      paramContext.getMemoryInfo(localMemoryInfo);
      long l = localMemoryInfo.availMem;
      return l;
    }
    catch (Throwable paramContext)
    {
      com.tencent.beacon.d.a.d("getFreeMem error!", new Object[0]);
      paramContext.printStackTrace();
    }
    return -1L;
  }
  
  public static String j()
  {
    try
    {
      String str = Locale.getDefault().getCountry();
      return str;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.beacon.d.a.d("getCountry error!", new Object[0]);
      localThrowable.printStackTrace();
    }
    return null;
  }
  
  public static String j(Context paramContext)
  {
    if (paramContext == null)
    {
      com.tencent.beacon.d.a.d("getSensor but context == null!", new Object[0]);
      return null;
    }
    com.tencent.beacon.d.a.a("getSensor start", new Object[0]);
    Object localObject2 = "X";
    StringBuffer localStringBuffer = new StringBuffer();
    if (Integer.parseInt(Build.VERSION.SDK) >= 10) {}
    for (;;)
    {
      int i;
      try
      {
        localClass = Class.forName("android.hardware.Camera");
        j = ((Integer)localClass.getMethod("getNumberOfCameras", new Class[0]).invoke(localClass, new Object[0])).intValue();
        if (j == 0)
        {
          localObject1 = "N";
          localObject2 = "N";
        }
      }
      catch (Throwable localThrowable1)
      {
        Class localClass;
        int j;
        Object localObject3;
        Object localObject6;
        Object localObject7;
        int k;
        Field localField1;
        Field localField2;
        Field localField3;
        int m;
        int n;
        localObject1 = "X";
        paramContext = "X";
        com.tencent.beacon.d.a.d("getSensor error!", new Object[0]);
        localThrowable1.printStackTrace();
        Object localObject5 = localObject1;
        localObject1 = "X";
        Context localContext = paramContext;
        continue;
        continue;
        localObject1 = "X";
        localObject2 = "X";
        continue;
      }
      try
      {
        localObject3 = (SensorManager)paramContext.getSystemService("sensor");
        if (((SensorManager)localObject3).getDefaultSensor(9) != null) {
          paramContext = "Y";
        }
      }
      catch (Throwable localThrowable3)
      {
        localObject5 = "X";
        paramContext = (Context)localObject1;
        localObject1 = localObject5;
        continue;
      }
      try
      {
        if (((SensorManager)localObject3).getDefaultSensor(4) != null)
        {
          localObject6 = "Y";
          localObject3 = localObject1;
          localObject5 = paramContext;
          localObject1 = localObject6;
          localStringBuffer.append((String)localObject3).append((String)localObject2).append((String)localObject5).append((String)localObject1);
          return localStringBuffer.toString();
          localObject3 = Class.forName("android.hardware.Camera$CameraInfo");
          localObject7 = ((Class)localObject3).newInstance();
          localObject6 = localClass.getMethods();
          localObject1 = null;
          k = localObject6.length;
          i = 0;
          localObject5 = localObject1;
          if (i < k)
          {
            localObject5 = localObject6[i];
            if (!((Method)localObject5).getName().equals("getCameraInfo")) {
              break label581;
            }
          }
          localField1 = ((Class)localObject3).getField("facing");
          localField2 = ((Class)localObject3).getField("CAMERA_FACING_BACK");
          localField3 = ((Class)localObject3).getField("CAMERA_FACING_FRONT");
          if (localObject5 == null) {
            continue;
          }
          localObject2 = "X";
          localObject1 = "X";
          i = 0;
          if (i >= j) {
            continue;
          }
        }
      }
      catch (Throwable localThrowable4)
      {
        localObject4 = localObject1;
        localObject1 = paramContext;
        paramContext = (Context)localObject4;
        localObject4 = localThrowable4;
        continue;
      }
      try
      {
        ((Method)localObject5).invoke(localClass, new Object[] { Integer.valueOf(i), localObject7 });
        k = localField1.getInt(localObject7);
        m = localField2.getInt(localObject7);
        n = localField3.getInt(localObject7);
        if (k == m)
        {
          localObject1 = "Y";
          localObject3 = localObject1;
          if (j == 1)
          {
            localObject2 = "N";
            localObject3 = localObject1;
          }
        }
        else
        {
          localObject3 = localObject1;
          if (k == n)
          {
            localObject6 = "Y";
            localObject2 = localObject6;
            localObject3 = localObject1;
            if (j == 1)
            {
              localObject3 = "N";
              localObject2 = localObject6;
            }
          }
        }
      }
      catch (Throwable localThrowable2)
      {
        paramContext = (Context)localObject1;
        localObject1 = "X";
        continue;
      }
      paramContext = "N";
      continue;
      localObject5 = "N";
      localObject3 = localObject1;
      Object localObject1 = localObject5;
      localObject5 = paramContext;
      continue;
      localObject1 = "X";
      localObject2 = "X";
      String str = "X";
      Object localObject4 = "X";
      continue;
      i += 1;
      localObject1 = localObject4;
      continue;
      label581:
      i += 1;
    }
  }
  
  public static String k()
  {
    try
    {
      String str = Locale.getDefault().getLanguage();
      return str;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.beacon.d.a.d("getLanguage error!", new Object[0]);
      localThrowable.printStackTrace();
    }
    return null;
  }
  
  public static String k(Context paramContext)
  {
    try
    {
      NetworkInfo localNetworkInfo = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      if (localNetworkInfo == null) {
        return "unknown";
      }
      if (localNetworkInfo.getType() == 1)
      {
        paramContext = "wifi";
      }
      else if (localNetworkInfo.getType() == 0)
      {
        paramContext = (TelephonyManager)paramContext.getSystemService("phone");
        if (paramContext != null) {
          switch (paramContext.getNetworkType())
          {
          case 15: 
            paramContext = "HSPA+";
          }
        }
      }
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
      paramContext = "unknown";
    }
    for (;;)
    {
      return paramContext;
      paramContext = "unknown";
      continue;
      paramContext = "GPRS";
      continue;
      paramContext = "EDGE";
      continue;
      paramContext = "UMTS";
      continue;
      paramContext = "HSDPA";
      continue;
      paramContext = "HSUPA";
      continue;
      paramContext = "HSPA";
      continue;
      paramContext = "CDMA";
      continue;
      paramContext = "EVDO_0";
      continue;
      paramContext = "EVDO_A";
      continue;
      paramContext = "1xRTT";
      continue;
      paramContext = "iDen";
      continue;
      paramContext = "EVDO_B";
      continue;
      paramContext = "LTE";
      continue;
      paramContext = "eHRPD";
    }
  }
  
  public static int l(Context paramContext)
  {
    if (paramContext == null)
    {
      com.tencent.beacon.d.a.d("getWifiSignalLevel but context == null!", new Object[0]);
      return 0;
    }
    try
    {
      paramContext = ((WifiManager)paramContext.getSystemService("wifi")).getConnectionInfo();
      if (paramContext.getBSSID() != null)
      {
        i = WifiManager.calculateSignalLevel(paramContext.getRssi(), 5);
        return i;
      }
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
        int i = 0;
      }
    }
  }
  
  public static String l()
  {
    try
    {
      String str = Build.BRAND;
      return str;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.beacon.d.a.d("getBrand error!", new Object[0]);
      localThrowable.printStackTrace();
    }
    return null;
  }
  
  public static String m()
  {
    try
    {
      String str = new SimpleDateFormat("yyyy-MM-dd", Locale.US).format(new Date());
      return str;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return "";
  }
  
  public static List<d> m(Context paramContext)
  {
    if (paramContext == null) {
      return null;
    }
    Object localObject = com.tencent.beacon.a.a.a.a(paramContext, new int[] { 6 }, -1, -1, 5, -1, -1, -1, -1, -1L, 0L);
    if ((localObject == null) || (((List)localObject).size() <= 0)) {
      return null;
    }
    paramContext = new ArrayList(((List)localObject).size());
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      com.tencent.beacon.a.a.a locala = (com.tencent.beacon.a.a.a)((Iterator)localObject).next();
      try
      {
        d locald = (d)d.class.cast(com.tencent.beacon.b.a.a(locala.b()));
        if (locald != null)
        {
          locald.a(locala.a());
          paramContext.add(locald);
        }
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
        com.tencent.beacon.d.a.d("netconsume error %s", new Object[] { localThrowable.toString() });
      }
    }
    return paramContext;
  }
  
  public static List<d> n(Context paramContext)
  {
    if (paramContext == null) {
      return null;
    }
    Object localObject = com.tencent.beacon.a.a.a.a(paramContext, new int[] { 7 }, -1, -1, 5, -1, -1, -1, -1, -1L, 0L);
    if ((localObject == null) || (((List)localObject).size() <= 0)) {
      return null;
    }
    paramContext = new ArrayList(((List)localObject).size());
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      com.tencent.beacon.a.a.a locala = (com.tencent.beacon.a.a.a)((Iterator)localObject).next();
      try
      {
        d locald = (d)d.class.cast(com.tencent.beacon.b.a.a(locala.b()));
        locald.a(locala.a());
        paramContext.add(locald);
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
        com.tencent.beacon.d.a.d(" netconsume error:%s", new Object[] { localThrowable.toString() });
      }
    }
    return paramContext;
  }
  
  public static e o(Context paramContext)
  {
    if (paramContext == null) {
      paramContext = null;
    }
    com.tencent.beacon.a.a.a locala;
    e locale;
    do
    {
      return paramContext;
      paramContext = com.tencent.beacon.a.a.a.a(paramContext, new int[] { 8 }, -1, -1, 1, -1, -1, -1, -1, -1L, -1L);
      if ((paramContext == null) || (paramContext.size() <= 0)) {
        return null;
      }
      locala = (com.tencent.beacon.a.a.a)paramContext.get(0);
      if (locala == null) {
        break;
      }
      paramContext = com.tencent.beacon.b.a.a(locala.b());
      if ((paramContext == null) || (!e.class.isInstance(paramContext))) {
        break;
      }
      locale = (e)e.class.cast(paramContext);
      paramContext = locale;
    } while (locale == null);
    locale.e(locala.a());
    return locale;
    return null;
  }
  
  public static int p(Context paramContext)
  {
    com.tencent.beacon.d.a.a(" RecordDAO.countRecordNum() start", new Object[0]);
    if (paramContext == null)
    {
      com.tencent.beacon.d.a.d(" countRecordNum() have null args!", new Object[0]);
      return -1;
    }
    return com.tencent.beacon.a.a.a.b(paramContext, new int[] { 1, 2, 3, 4 }, -1L, 9223372036854775807L);
  }
  
  public final String f()
  {
    if (this.b == null)
    {
      com.tencent.beacon.d.a.d("getFreeMem but context == null!", new Object[0]);
      return "";
    }
    try
    {
      localObject = (ActivityManager)this.b.getSystemService("activity");
      if (a.a == 0) {
        a.a = Process.myPid();
      }
      localObject = ((ActivityManager)localObject).getProcessMemoryInfo(new int[] { a.a });
      if ((localObject == null) || (localObject.length != 1)) {
        break label216;
      }
      StringBuffer localStringBuffer = new StringBuffer();
      localStringBuffer.append(localObject[0].getTotalPrivateDirty()).append(",").append(localObject[0].dalvikPrivateDirty).append(",").append(localObject[0].nativePrivateDirty).append(",").append(localObject[0].otherPrivateDirty).append(",").append(localObject[0].getTotalPss()).append(",").append(localObject[0].dalvikPss).append(",").append(localObject[0].nativePss).append(",").append(localObject[0].otherPss);
      localObject = localStringBuffer.toString();
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        Object localObject;
        com.tencent.beacon.d.a.d("getFreeMem error!", new Object[0]);
        localThrowable.printStackTrace();
        String str = "";
      }
    }
    return localObject;
  }
  
  public final long i()
  {
    if (Environment.getExternalStorageState().equals("mounted")) {}
    for (int i = 1; i == 0; i = 0) {
      return 0L;
    }
    try
    {
      StatFs localStatFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
      i = localStatFs.getBlockSize();
      long l = localStatFs.getBlockCount();
      l = i * l / 1024L / 1024L;
      return l;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.beacon.a.g
 * JD-Core Version:    0.7.0.1
 */