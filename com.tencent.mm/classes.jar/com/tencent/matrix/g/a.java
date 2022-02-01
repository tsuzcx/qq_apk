package com.tencent.matrix.g;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Debug;
import android.os.Debug.MemoryInfo;
import android.os.Process;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

public final class a
{
  private static final FileFilter CPU_FILTER = new FileFilter()
  {
    public final boolean accept(File paramAnonymousFile)
    {
      return Pattern.matches("cpu[0-9]", paramAnonymousFile.getName());
    }
  };
  private static a deJ = null;
  private static long deK = 0L;
  private static long deL = 0L;
  private static int deM = 0;
  
  public static long TK()
  {
    return Runtime.getRuntime().freeMemory() / 1024L;
  }
  
  /* Error */
  public static double TL()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 22
    //   3: aconst_null
    //   4: astore 21
    //   6: invokestatic 56	java/lang/System:currentTimeMillis	()J
    //   9: lstore 6
    //   11: dconst_0
    //   12: dstore_0
    //   13: new 58	java/io/RandomAccessFile
    //   16: dup
    //   17: ldc 60
    //   19: ldc 62
    //   21: invokespecial 65	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   24: astore 19
    //   26: aload 19
    //   28: astore 18
    //   30: aload 19
    //   32: invokevirtual 69	java/io/RandomAccessFile:readLine	()Ljava/lang/String;
    //   35: ldc 71
    //   37: invokevirtual 77	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   40: astore 20
    //   42: aload 19
    //   44: astore 18
    //   46: aload 20
    //   48: iconst_2
    //   49: aaload
    //   50: invokestatic 83	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   53: lstore_2
    //   54: aload 19
    //   56: astore 18
    //   58: aload 20
    //   60: iconst_3
    //   61: aaload
    //   62: invokestatic 83	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   65: lstore 4
    //   67: aload 19
    //   69: astore 18
    //   71: aload 20
    //   73: iconst_4
    //   74: aaload
    //   75: invokestatic 83	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   78: lstore 8
    //   80: aload 19
    //   82: astore 18
    //   84: aload 20
    //   86: iconst_5
    //   87: aaload
    //   88: invokestatic 83	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   91: lstore 10
    //   93: aload 19
    //   95: astore 18
    //   97: aload 20
    //   99: bipush 6
    //   101: aaload
    //   102: invokestatic 83	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   105: lstore 12
    //   107: aload 19
    //   109: astore 18
    //   111: aload 20
    //   113: bipush 7
    //   115: aaload
    //   116: invokestatic 83	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   119: lstore 14
    //   121: aload 19
    //   123: astore 18
    //   125: aload 20
    //   127: bipush 8
    //   129: aaload
    //   130: invokestatic 83	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   133: lstore 16
    //   135: lload_2
    //   136: lload 4
    //   138: ladd
    //   139: lload 8
    //   141: ladd
    //   142: lload 10
    //   144: ladd
    //   145: lload 12
    //   147: ladd
    //   148: lload 14
    //   150: ladd
    //   151: lload 16
    //   153: ladd
    //   154: lstore 4
    //   156: aload 19
    //   158: invokevirtual 86	java/io/RandomAccessFile:close	()V
    //   161: aload 22
    //   163: astore 18
    //   165: new 58	java/io/RandomAccessFile
    //   168: dup
    //   169: new 88	java/lang/StringBuilder
    //   172: dup
    //   173: ldc 90
    //   175: invokespecial 93	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   178: invokestatic 99	android/os/Process:myPid	()I
    //   181: invokevirtual 103	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   184: ldc 105
    //   186: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   189: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   192: ldc 62
    //   194: invokespecial 65	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   197: astore 19
    //   199: aload 19
    //   201: invokevirtual 69	java/io/RandomAccessFile:readLine	()Ljava/lang/String;
    //   204: ldc 71
    //   206: invokevirtual 77	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   209: astore 18
    //   211: aload 18
    //   213: bipush 13
    //   215: aaload
    //   216: invokestatic 83	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   219: lstore_2
    //   220: aload 18
    //   222: bipush 14
    //   224: aaload
    //   225: invokestatic 83	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   228: lstore 8
    //   230: lload_2
    //   231: lload 8
    //   233: ladd
    //   234: lstore_2
    //   235: aload 19
    //   237: invokevirtual 86	java/io/RandomAccessFile:close	()V
    //   240: lconst_0
    //   241: lload 4
    //   243: lcmp
    //   244: ifeq +14 -> 258
    //   247: lload_2
    //   248: l2d
    //   249: lload 4
    //   251: l2d
    //   252: ddiv
    //   253: ldc2_w 112
    //   256: dmul
    //   257: dstore_0
    //   258: ldc 115
    //   260: new 88	java/lang/StringBuilder
    //   263: dup
    //   264: ldc 117
    //   266: invokespecial 93	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   269: invokestatic 56	java/lang/System:currentTimeMillis	()J
    //   272: lload 6
    //   274: lsub
    //   275: invokevirtual 120	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   278: ldc 122
    //   280: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   283: dload_0
    //   284: invokevirtual 125	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   287: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   290: iconst_0
    //   291: anewarray 4	java/lang/Object
    //   294: invokestatic 131	com/tencent/matrix/g/c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   297: dload_0
    //   298: dreturn
    //   299: astore 18
    //   301: ldc 115
    //   303: ldc 133
    //   305: iconst_1
    //   306: anewarray 4	java/lang/Object
    //   309: dup
    //   310: iconst_0
    //   311: aload 18
    //   313: invokevirtual 134	java/lang/Exception:toString	()Ljava/lang/String;
    //   316: aastore
    //   317: invokestatic 131	com/tencent/matrix/g/c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   320: goto -159 -> 161
    //   323: astore 20
    //   325: aconst_null
    //   326: astore 19
    //   328: aload 19
    //   330: astore 18
    //   332: ldc 115
    //   334: ldc 136
    //   336: iconst_1
    //   337: anewarray 4	java/lang/Object
    //   340: dup
    //   341: iconst_0
    //   342: aload 20
    //   344: invokevirtual 134	java/lang/Exception:toString	()Ljava/lang/String;
    //   347: aastore
    //   348: invokestatic 131	com/tencent/matrix/g/c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   351: aload 19
    //   353: ifnull +8 -> 361
    //   356: aload 19
    //   358: invokevirtual 86	java/io/RandomAccessFile:close	()V
    //   361: lconst_0
    //   362: lstore 4
    //   364: goto -203 -> 161
    //   367: astore 18
    //   369: ldc 115
    //   371: ldc 133
    //   373: iconst_1
    //   374: anewarray 4	java/lang/Object
    //   377: dup
    //   378: iconst_0
    //   379: aload 18
    //   381: invokevirtual 134	java/lang/Exception:toString	()Ljava/lang/String;
    //   384: aastore
    //   385: invokestatic 131	com/tencent/matrix/g/c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   388: lconst_0
    //   389: lstore 4
    //   391: goto -230 -> 161
    //   394: astore 19
    //   396: aconst_null
    //   397: astore 18
    //   399: aload 18
    //   401: ifnull +8 -> 409
    //   404: aload 18
    //   406: invokevirtual 86	java/io/RandomAccessFile:close	()V
    //   409: aload 19
    //   411: athrow
    //   412: astore 18
    //   414: ldc 115
    //   416: ldc 133
    //   418: iconst_1
    //   419: anewarray 4	java/lang/Object
    //   422: dup
    //   423: iconst_0
    //   424: aload 18
    //   426: invokevirtual 134	java/lang/Exception:toString	()Ljava/lang/String;
    //   429: aastore
    //   430: invokestatic 131	com/tencent/matrix/g/c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   433: goto -24 -> 409
    //   436: astore 18
    //   438: ldc 115
    //   440: ldc 138
    //   442: iconst_1
    //   443: anewarray 4	java/lang/Object
    //   446: dup
    //   447: iconst_0
    //   448: aload 18
    //   450: invokevirtual 134	java/lang/Exception:toString	()Ljava/lang/String;
    //   453: aastore
    //   454: invokestatic 131	com/tencent/matrix/g/c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   457: goto -217 -> 240
    //   460: astore 20
    //   462: aload 21
    //   464: astore 19
    //   466: aload 19
    //   468: astore 18
    //   470: ldc 115
    //   472: ldc 140
    //   474: iconst_1
    //   475: anewarray 4	java/lang/Object
    //   478: dup
    //   479: iconst_0
    //   480: aload 20
    //   482: invokevirtual 134	java/lang/Exception:toString	()Ljava/lang/String;
    //   485: aastore
    //   486: invokestatic 131	com/tencent/matrix/g/c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   489: aload 19
    //   491: ifnull +8 -> 499
    //   494: aload 19
    //   496: invokevirtual 86	java/io/RandomAccessFile:close	()V
    //   499: lconst_0
    //   500: lstore_2
    //   501: goto -261 -> 240
    //   504: astore 18
    //   506: ldc 115
    //   508: ldc 138
    //   510: iconst_1
    //   511: anewarray 4	java/lang/Object
    //   514: dup
    //   515: iconst_0
    //   516: aload 18
    //   518: invokevirtual 134	java/lang/Exception:toString	()Ljava/lang/String;
    //   521: aastore
    //   522: invokestatic 131	com/tencent/matrix/g/c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   525: lconst_0
    //   526: lstore_2
    //   527: goto -287 -> 240
    //   530: astore 20
    //   532: aload 18
    //   534: astore 19
    //   536: aload 20
    //   538: astore 18
    //   540: aload 19
    //   542: ifnull +8 -> 550
    //   545: aload 19
    //   547: invokevirtual 86	java/io/RandomAccessFile:close	()V
    //   550: aload 18
    //   552: athrow
    //   553: astore 19
    //   555: ldc 115
    //   557: ldc 138
    //   559: iconst_1
    //   560: anewarray 4	java/lang/Object
    //   563: dup
    //   564: iconst_0
    //   565: aload 19
    //   567: invokevirtual 134	java/lang/Exception:toString	()Ljava/lang/String;
    //   570: aastore
    //   571: invokestatic 131	com/tencent/matrix/g/c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   574: goto -24 -> 550
    //   577: astore 18
    //   579: goto -39 -> 540
    //   582: astore 20
    //   584: goto -118 -> 466
    //   587: astore 19
    //   589: goto -190 -> 399
    //   592: astore 20
    //   594: goto -266 -> 328
    // Local variable table:
    //   start	length	slot	name	signature
    //   12	286	0	d	double
    //   53	474	2	l1	long
    //   65	325	4	l2	long
    //   9	264	6	l3	long
    //   78	154	8	l4	long
    //   91	52	10	l5	long
    //   105	41	12	l6	long
    //   119	30	14	l7	long
    //   133	19	16	l8	long
    //   28	193	18	localObject1	Object
    //   299	13	18	localException1	Exception
    //   330	1	18	localRandomAccessFile1	java.io.RandomAccessFile
    //   367	13	18	localException2	Exception
    //   397	8	18	localObject2	Object
    //   412	13	18	localException3	Exception
    //   436	13	18	localException4	Exception
    //   468	1	18	localObject3	Object
    //   504	29	18	localException5	Exception
    //   538	13	18	localObject4	Object
    //   577	1	18	localObject5	Object
    //   24	333	19	localRandomAccessFile2	java.io.RandomAccessFile
    //   394	16	19	localObject6	Object
    //   464	82	19	localObject7	Object
    //   553	13	19	localException6	Exception
    //   587	1	19	localObject8	Object
    //   40	86	20	arrayOfString	String[]
    //   323	20	20	localException7	Exception
    //   460	21	20	localException8	Exception
    //   530	7	20	localObject9	Object
    //   582	1	20	localException9	Exception
    //   592	1	20	localException10	Exception
    //   4	459	21	localObject10	Object
    //   1	161	22	localObject11	Object
    // Exception table:
    //   from	to	target	type
    //   156	161	299	java/lang/Exception
    //   13	26	323	java/lang/Exception
    //   356	361	367	java/lang/Exception
    //   13	26	394	finally
    //   404	409	412	java/lang/Exception
    //   235	240	436	java/lang/Exception
    //   165	199	460	java/lang/Exception
    //   494	499	504	java/lang/Exception
    //   165	199	530	finally
    //   470	489	530	finally
    //   545	550	553	java/lang/Exception
    //   199	230	577	finally
    //   199	230	582	java/lang/Exception
    //   30	42	587	finally
    //   46	54	587	finally
    //   58	67	587	finally
    //   71	80	587	finally
    //   84	93	587	finally
    //   97	107	587	finally
    //   111	121	587	finally
    //   125	135	587	finally
    //   332	351	587	finally
    //   30	42	592	java/lang/Exception
    //   46	54	592	java/lang/Exception
    //   58	67	592	java/lang/Exception
    //   71	80	592	java/lang/Exception
    //   84	93	592	java/lang/Exception
    //   97	107	592	java/lang/Exception
    //   111	121	592	java/lang/Exception
    //   125	135	592	java/lang/Exception
  }
  
  private static int TM()
  {
    int j = 0;
    if (Build.VERSION.SDK_INT <= 10) {
      return 1;
    }
    int i;
    try
    {
      int k = eR("/sys/devices/system/cpu/possible");
      i = k;
      if (k == 0) {
        i = eR("/sys/devices/system/cpu/present");
      }
      if (i == 0)
      {
        File[] arrayOfFile = new File("/sys/devices/system/cpu/").listFiles(CPU_FILTER);
        if (arrayOfFile == null) {
          i = j;
        } else {
          i = arrayOfFile.length;
        }
      }
    }
    catch (Exception localException)
    {
      i = j;
    }
    j = i;
    if (i == 0) {
      j = 1;
    }
    return j;
  }
  
  public static long TN()
  {
    int i = 0;
    Object localObject1 = String.format("/proc/%s/status", new Object[] { Integer.valueOf(Process.myPid()) });
    for (;;)
    {
      try
      {
        localObject1 = getStringFromFile((String)localObject1).trim().split("\n");
        int j = localObject1.length;
        if (i < j)
        {
          Object localObject2 = localObject1[i];
          if (!((String)localObject2).startsWith("VmSize")) {
            break label139;
          }
          localObject2 = Pattern.compile("\\d+").matcher((CharSequence)localObject2);
          if (!((Matcher)localObject2).find()) {
            break label139;
          }
          return Long.parseLong(((Matcher)localObject2).group());
        }
        if (localObject1.length > 12)
        {
          localObject1 = Pattern.compile("\\d+").matcher(localObject1[12]);
          if (((Matcher)localObject1).find())
          {
            long l = Long.parseLong(((Matcher)localObject1).group());
            return l;
          }
        }
      }
      catch (Exception localException) {}
      return -1L;
      label139:
      i += 1;
    }
  }
  
  public static JSONObject a(JSONObject paramJSONObject, Application paramApplication)
  {
    try
    {
      paramJSONObject.put("machine", bj(paramApplication));
      paramJSONObject.put("cpu_app", TL());
      paramJSONObject.put("mem", getTotalMemory(paramApplication));
      paramJSONObject.put("mem_free", bn(paramApplication));
      return paramJSONObject;
    }
    catch (JSONException paramApplication)
    {
      c.e("Matrix.DeviceUtil", "[JSONException for stack, error: %s", new Object[] { paramApplication });
    }
    return paramJSONObject;
  }
  
  public static a bj(Context paramContext)
  {
    if (deJ != null) {
      return deJ;
    }
    long l1 = System.currentTimeMillis();
    long l2 = getTotalMemory(paramContext);
    int i = TM();
    c.i("Matrix.DeviceUtil", "[getLevel] totalMemory:%s coresNum:%s", new Object[] { Long.valueOf(l2), Integer.valueOf(i) });
    if (l2 >= 8589934592L) {
      deJ = a.deN;
    }
    for (;;)
    {
      c.i("Matrix.DeviceUtil", "getLevel, cost:" + (System.currentTimeMillis() - l1) + ", level:" + deJ, new Object[0]);
      return deJ;
      if (l2 >= 6442450944L) {
        deJ = a.deO;
      } else if (l2 >= 4294967296L) {
        deJ = a.deP;
      } else if (l2 >= 2147483648L)
      {
        if (i >= 4) {
          deJ = a.deP;
        } else if (i >= 2) {
          deJ = a.deQ;
        } else if (i > 0) {
          deJ = a.deQ;
        }
      }
      else if ((0L <= l2) && (l2 < 1073741824L)) {
        deJ = a.deR;
      } else {
        deJ = a.deS;
      }
    }
  }
  
  public static long bk(Context paramContext)
  {
    if (0L != deL) {
      return deL;
    }
    getTotalMemory(paramContext);
    return deL;
  }
  
  public static int bl(Context paramContext)
  {
    if (deM != 0) {
      return deM * 1024;
    }
    getTotalMemory(paramContext);
    return deM * 1024;
  }
  
  public static boolean bm(Context paramContext)
  {
    ActivityManager.MemoryInfo localMemoryInfo = new ActivityManager.MemoryInfo();
    ((ActivityManager)paramContext.getSystemService("activity")).getMemoryInfo(localMemoryInfo);
    return localMemoryInfo.lowMemory;
  }
  
  /* Error */
  public static long bn(Context paramContext)
  {
    // Byte code:
    //   0: getstatic 146	android/os/Build$VERSION:SDK_INT	I
    //   3: bipush 16
    //   5: if_icmplt +37 -> 42
    //   8: new 304	android/app/ActivityManager$MemoryInfo
    //   11: dup
    //   12: invokespecial 305	android/app/ActivityManager$MemoryInfo:<init>	()V
    //   15: astore 6
    //   17: aload_0
    //   18: ldc_w 307
    //   21: invokevirtual 313	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   24: checkcast 315	android/app/ActivityManager
    //   27: aload 6
    //   29: invokevirtual 319	android/app/ActivityManager:getMemoryInfo	(Landroid/app/ActivityManager$MemoryInfo;)V
    //   32: aload 6
    //   34: getfield 326	android/app/ActivityManager$MemoryInfo:availMem	J
    //   37: ldc2_w 46
    //   40: ldiv
    //   41: lreturn
    //   42: lconst_0
    //   43: lstore 4
    //   45: new 328	java/io/BufferedReader
    //   48: dup
    //   49: new 330	java/io/InputStreamReader
    //   52: dup
    //   53: new 332	java/io/FileInputStream
    //   56: dup
    //   57: ldc_w 334
    //   60: invokespecial 335	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   63: ldc_w 337
    //   66: invokespecial 340	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   69: invokespecial 343	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   72: astore 6
    //   74: aload 6
    //   76: astore_0
    //   77: aload 6
    //   79: invokevirtual 344	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   82: astore 7
    //   84: lload 4
    //   86: lstore_2
    //   87: aload 7
    //   89: ifnull +50 -> 139
    //   92: aload 6
    //   94: astore_0
    //   95: aload 7
    //   97: ldc_w 346
    //   100: invokevirtual 77	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   103: astore 7
    //   105: aload 6
    //   107: astore_0
    //   108: ldc_w 348
    //   111: aload 7
    //   113: iconst_0
    //   114: aaload
    //   115: invokevirtual 352	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   118: ifeq +32 -> 150
    //   121: aload 6
    //   123: astore_0
    //   124: aload 7
    //   126: iconst_1
    //   127: aaload
    //   128: invokestatic 355	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   131: istore_1
    //   132: iload_1
    //   133: i2l
    //   134: ldc2_w 46
    //   137: lmul
    //   138: lstore_2
    //   139: aload 6
    //   141: invokevirtual 356	java/io/BufferedReader:close	()V
    //   144: lload_2
    //   145: ldc2_w 46
    //   148: ldiv
    //   149: lreturn
    //   150: aload 6
    //   152: astore_0
    //   153: aload 6
    //   155: invokevirtual 344	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   158: astore 7
    //   160: goto -76 -> 84
    //   163: astore_0
    //   164: ldc 115
    //   166: ldc_w 358
    //   169: iconst_1
    //   170: anewarray 4	java/lang/Object
    //   173: dup
    //   174: iconst_0
    //   175: aload_0
    //   176: invokevirtual 134	java/lang/Exception:toString	()Ljava/lang/String;
    //   179: aastore
    //   180: invokestatic 131	com/tencent/matrix/g/c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   183: goto -39 -> 144
    //   186: astore 7
    //   188: aconst_null
    //   189: astore 6
    //   191: aload 6
    //   193: astore_0
    //   194: ldc 115
    //   196: ldc_w 360
    //   199: iconst_1
    //   200: anewarray 4	java/lang/Object
    //   203: dup
    //   204: iconst_0
    //   205: aload 7
    //   207: invokevirtual 134	java/lang/Exception:toString	()Ljava/lang/String;
    //   210: aastore
    //   211: invokestatic 131	com/tencent/matrix/g/c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   214: lload 4
    //   216: lstore_2
    //   217: aload 6
    //   219: ifnull -75 -> 144
    //   222: aload 6
    //   224: invokevirtual 356	java/io/BufferedReader:close	()V
    //   227: lload 4
    //   229: lstore_2
    //   230: goto -86 -> 144
    //   233: astore_0
    //   234: ldc 115
    //   236: ldc_w 358
    //   239: iconst_1
    //   240: anewarray 4	java/lang/Object
    //   243: dup
    //   244: iconst_0
    //   245: aload_0
    //   246: invokevirtual 134	java/lang/Exception:toString	()Ljava/lang/String;
    //   249: aastore
    //   250: invokestatic 131	com/tencent/matrix/g/c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   253: lload 4
    //   255: lstore_2
    //   256: goto -112 -> 144
    //   259: astore 6
    //   261: aconst_null
    //   262: astore_0
    //   263: aload_0
    //   264: ifnull +7 -> 271
    //   267: aload_0
    //   268: invokevirtual 356	java/io/BufferedReader:close	()V
    //   271: aload 6
    //   273: athrow
    //   274: astore_0
    //   275: ldc 115
    //   277: ldc_w 358
    //   280: iconst_1
    //   281: anewarray 4	java/lang/Object
    //   284: dup
    //   285: iconst_0
    //   286: aload_0
    //   287: invokevirtual 134	java/lang/Exception:toString	()Ljava/lang/String;
    //   290: aastore
    //   291: invokestatic 131	com/tencent/matrix/g/c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   294: goto -23 -> 271
    //   297: astore 6
    //   299: goto -36 -> 263
    //   302: astore 7
    //   304: goto -113 -> 191
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	307	0	paramContext	Context
    //   131	2	1	i	int
    //   86	170	2	l1	long
    //   43	211	4	l2	long
    //   15	208	6	localObject1	Object
    //   259	13	6	localObject2	Object
    //   297	1	6	localObject3	Object
    //   82	77	7	localObject4	Object
    //   186	20	7	localException1	Exception
    //   302	1	7	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   139	144	163	java/lang/Exception
    //   45	74	186	java/lang/Exception
    //   222	227	233	java/lang/Exception
    //   45	74	259	finally
    //   267	271	274	java/lang/Exception
    //   77	84	297	finally
    //   95	105	297	finally
    //   108	121	297	finally
    //   124	132	297	finally
    //   153	160	297	finally
    //   194	214	297	finally
    //   77	84	302	java/lang/Exception
    //   95	105	302	java/lang/Exception
    //   108	121	302	java/lang/Exception
    //   124	132	302	java/lang/Exception
    //   153	160	302	java/lang/Exception
  }
  
  public static Debug.MemoryInfo bo(Context paramContext)
  {
    try
    {
      paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getProcessMemoryInfo(new int[] { Process.myPid() });
      if (paramContext.length > 0)
      {
        paramContext = paramContext[0];
        return paramContext;
      }
    }
    catch (Exception paramContext)
    {
      c.i("Matrix.DeviceUtil", "getProcessMemoryInfo fail, error: %s", new Object[] { paramContext.toString() });
    }
    return null;
  }
  
  private static String convertStreamToString(InputStream paramInputStream)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    try
    {
      localBufferedReader = new BufferedReader(new InputStreamReader(paramInputStream, "UTF-8"));
      try
      {
        for (;;)
        {
          paramInputStream = localBufferedReader.readLine();
          if (paramInputStream == null) {
            break;
          }
          localStringBuilder.append(paramInputStream).append('\n');
        }
        if (localBufferedReader == null) {
          break label59;
        }
      }
      finally {}
    }
    finally
    {
      for (;;)
      {
        BufferedReader localBufferedReader = null;
      }
    }
    localBufferedReader.close();
    label59:
    throw paramInputStream;
    localBufferedReader.close();
    return localStringBuilder.toString();
  }
  
  /* Error */
  private static int eR(String paramString)
  {
    // Byte code:
    //   0: new 332	java/io/FileInputStream
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 335	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   8: astore_3
    //   9: aload_3
    //   10: astore_0
    //   11: new 328	java/io/BufferedReader
    //   14: dup
    //   15: new 330	java/io/InputStreamReader
    //   18: dup
    //   19: aload_3
    //   20: ldc_w 337
    //   23: invokespecial 340	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   26: invokespecial 343	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   29: astore 4
    //   31: aload_3
    //   32: astore_0
    //   33: aload 4
    //   35: invokevirtual 344	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   38: astore 5
    //   40: aload_3
    //   41: astore_0
    //   42: aload 4
    //   44: invokevirtual 356	java/io/BufferedReader:close	()V
    //   47: aload 5
    //   49: ifnull +18 -> 67
    //   52: aload_3
    //   53: astore_0
    //   54: aload 5
    //   56: ldc_w 378
    //   59: invokevirtual 381	java/lang/String:matches	(Ljava/lang/String;)Z
    //   62: istore_2
    //   63: iload_2
    //   64: ifne +32 -> 96
    //   67: aload_3
    //   68: invokevirtual 384	java/io/InputStream:close	()V
    //   71: iconst_0
    //   72: ireturn
    //   73: astore_0
    //   74: ldc 115
    //   76: ldc_w 386
    //   79: iconst_1
    //   80: anewarray 4	java/lang/Object
    //   83: dup
    //   84: iconst_0
    //   85: aload_0
    //   86: invokevirtual 387	java/io/IOException:toString	()Ljava/lang/String;
    //   89: aastore
    //   90: invokestatic 131	com/tencent/matrix/g/c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   93: goto -22 -> 71
    //   96: aload_3
    //   97: astore_0
    //   98: aload 5
    //   100: iconst_2
    //   101: invokevirtual 391	java/lang/String:substring	(I)Ljava/lang/String;
    //   104: invokestatic 355	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   107: istore_1
    //   108: iload_1
    //   109: iconst_1
    //   110: iadd
    //   111: istore_1
    //   112: aload_3
    //   113: invokevirtual 384	java/io/InputStream:close	()V
    //   116: iload_1
    //   117: ireturn
    //   118: astore_0
    //   119: ldc 115
    //   121: ldc_w 386
    //   124: iconst_1
    //   125: anewarray 4	java/lang/Object
    //   128: dup
    //   129: iconst_0
    //   130: aload_0
    //   131: invokevirtual 387	java/io/IOException:toString	()Ljava/lang/String;
    //   134: aastore
    //   135: invokestatic 131	com/tencent/matrix/g/c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   138: iload_1
    //   139: ireturn
    //   140: astore 4
    //   142: aconst_null
    //   143: astore_3
    //   144: aload_3
    //   145: astore_0
    //   146: ldc 115
    //   148: ldc_w 386
    //   151: iconst_1
    //   152: anewarray 4	java/lang/Object
    //   155: dup
    //   156: iconst_0
    //   157: aload 4
    //   159: invokevirtual 387	java/io/IOException:toString	()Ljava/lang/String;
    //   162: aastore
    //   163: invokestatic 131	com/tencent/matrix/g/c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   166: aload_3
    //   167: ifnull +7 -> 174
    //   170: aload_3
    //   171: invokevirtual 384	java/io/InputStream:close	()V
    //   174: iconst_0
    //   175: ireturn
    //   176: astore_0
    //   177: ldc 115
    //   179: ldc_w 386
    //   182: iconst_1
    //   183: anewarray 4	java/lang/Object
    //   186: dup
    //   187: iconst_0
    //   188: aload_0
    //   189: invokevirtual 387	java/io/IOException:toString	()Ljava/lang/String;
    //   192: aastore
    //   193: invokestatic 131	com/tencent/matrix/g/c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   196: goto -22 -> 174
    //   199: astore_3
    //   200: aconst_null
    //   201: astore_0
    //   202: aload_0
    //   203: ifnull +7 -> 210
    //   206: aload_0
    //   207: invokevirtual 384	java/io/InputStream:close	()V
    //   210: aload_3
    //   211: athrow
    //   212: astore_0
    //   213: ldc 115
    //   215: ldc_w 386
    //   218: iconst_1
    //   219: anewarray 4	java/lang/Object
    //   222: dup
    //   223: iconst_0
    //   224: aload_0
    //   225: invokevirtual 387	java/io/IOException:toString	()Ljava/lang/String;
    //   228: aastore
    //   229: invokestatic 131	com/tencent/matrix/g/c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   232: goto -22 -> 210
    //   235: astore_3
    //   236: goto -34 -> 202
    //   239: astore 4
    //   241: goto -97 -> 144
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	244	0	paramString	String
    //   107	32	1	i	int
    //   62	2	2	bool	boolean
    //   8	163	3	localFileInputStream	FileInputStream
    //   199	12	3	localObject1	Object
    //   235	1	3	localObject2	Object
    //   29	14	4	localBufferedReader	BufferedReader
    //   140	18	4	localIOException1	java.io.IOException
    //   239	1	4	localIOException2	java.io.IOException
    //   38	61	5	str	String
    // Exception table:
    //   from	to	target	type
    //   67	71	73	java/io/IOException
    //   112	116	118	java/io/IOException
    //   0	9	140	java/io/IOException
    //   170	174	176	java/io/IOException
    //   0	9	199	finally
    //   206	210	212	java/io/IOException
    //   11	31	235	finally
    //   33	40	235	finally
    //   42	47	235	finally
    //   54	63	235	finally
    //   98	108	235	finally
    //   146	166	235	finally
    //   11	31	239	java/io/IOException
    //   33	40	239	java/io/IOException
    //   42	47	239	java/io/IOException
    //   54	63	239	java/io/IOException
    //   98	108	239	java/io/IOException
  }
  
  public static long getDalvikHeap()
  {
    Runtime localRuntime = Runtime.getRuntime();
    return (localRuntime.totalMemory() - localRuntime.freeMemory()) / 1024L;
  }
  
  public static long getNativeHeap()
  {
    return Debug.getNativeHeapAllocatedSize() / 1024L;
  }
  
  public static String getStringFromFile(String paramString)
  {
    paramString = new File(paramString);
    FileInputStream localFileInputStream;
    try
    {
      localFileInputStream = new FileInputStream(paramString);
      if (localFileInputStream == null) {
        break label40;
      }
    }
    finally
    {
      try
      {
        paramString = convertStreamToString(localFileInputStream);
        localFileInputStream.close();
        return paramString;
      }
      finally {}
      paramString = finally;
      localFileInputStream = null;
    }
    localFileInputStream.close();
    label40:
    throw paramString;
  }
  
  public static long getTotalMemory(Context paramContext)
  {
    long l1 = 0L;
    if (0L != deK) {
      l1 = deK;
    }
    long l2;
    do
    {
      return l1;
      l2 = System.currentTimeMillis();
    } while (Build.VERSION.SDK_INT < 16);
    ActivityManager.MemoryInfo localMemoryInfo = new ActivityManager.MemoryInfo();
    paramContext = (ActivityManager)paramContext.getSystemService("activity");
    paramContext.getMemoryInfo(localMemoryInfo);
    deK = localMemoryInfo.totalMem;
    deL = localMemoryInfo.threshold;
    l1 = Runtime.getRuntime().maxMemory();
    if (l1 == 9223372036854775807L) {}
    for (deM = paramContext.getMemoryClass();; deM = (int)(l1 / 1048576L))
    {
      c.i("Matrix.DeviceUtil", "getTotalMemory cost:" + (System.currentTimeMillis() - l2) + ", total_mem:" + deK + ", LowMemoryThresold:" + deL + ", Memory Class:" + deM, new Object[0]);
      return deK;
    }
  }
  
  public static boolean is64BitRuntime()
  {
    String str = Build.CPU_ABI;
    return ("arm64-v8a".equalsIgnoreCase(str)) || ("x86_64".equalsIgnoreCase(str)) || ("mips64".equalsIgnoreCase(str));
  }
  
  public static enum a
  {
    public int value;
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.matrix.g.a
 * JD-Core Version:    0.7.0.1
 */