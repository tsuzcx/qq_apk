package com.tencent.matrix.g;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.app.Application;
import android.content.Context;
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
  private static a bTN = null;
  private static long bTO = 0L;
  private static long bTP = 0L;
  private static int bTQ = 0;
  
  public static JSONObject a(JSONObject paramJSONObject, Application paramApplication)
  {
    try
    {
      paramJSONObject.put("machine", aC(paramApplication));
      paramJSONObject.put("cpu_app", zE());
      paramJSONObject.put("mem", getTotalMemory(paramApplication));
      paramJSONObject.put("mem_free", aG(paramApplication));
      return paramJSONObject;
    }
    catch (JSONException paramApplication)
    {
      c.e("Matrix.DeviceUtil", "[JSONException for stack, error: %s", new Object[] { paramApplication });
    }
    return paramJSONObject;
  }
  
  public static a aC(Context paramContext)
  {
    if (bTN != null) {
      return bTN;
    }
    long l1 = System.currentTimeMillis();
    long l2 = getTotalMemory(paramContext);
    int i = zF();
    c.i("Matrix.DeviceUtil", "[getLevel] totalMemory:%s coresNum:%s", new Object[] { Long.valueOf(l2), Integer.valueOf(i) });
    if (l2 >= 4294967296L) {
      bTN = a.bTR;
    }
    for (;;)
    {
      c.i("Matrix.DeviceUtil", "getLevel, cost:" + (System.currentTimeMillis() - l1) + ", level:" + bTN, new Object[0]);
      return bTN;
      if (l2 >= 3221225472L) {
        bTN = a.bTS;
      } else if (l2 >= 2147483648L)
      {
        if (i >= 4) {
          bTN = a.bTS;
        } else if (i >= 2) {
          bTN = a.bTT;
        } else if (i > 0) {
          bTN = a.bTU;
        }
      }
      else if (l2 >= 1073741824L)
      {
        if (i >= 4) {
          bTN = a.bTT;
        } else if (i >= 2) {
          bTN = a.bTU;
        } else if (i > 0) {
          bTN = a.bTU;
        }
      }
      else if ((0L <= l2) && (l2 < 1073741824L)) {
        bTN = a.bTV;
      } else {
        bTN = a.bTW;
      }
    }
  }
  
  public static long aD(Context paramContext)
  {
    if (0L != bTP) {
      return bTP;
    }
    getTotalMemory(paramContext);
    return bTP;
  }
  
  public static int aE(Context paramContext)
  {
    if (bTQ != 0) {
      return bTQ * 1024;
    }
    getTotalMemory(paramContext);
    return bTQ * 1024;
  }
  
  public static boolean aF(Context paramContext)
  {
    ActivityManager.MemoryInfo localMemoryInfo = new ActivityManager.MemoryInfo();
    ((ActivityManager)paramContext.getSystemService("activity")).getMemoryInfo(localMemoryInfo);
    return localMemoryInfo.lowMemory;
  }
  
  /* Error */
  public static long aG(Context paramContext)
  {
    // Byte code:
    //   0: getstatic 190	android/os/Build$VERSION:SDK_INT	I
    //   3: bipush 16
    //   5: if_icmplt +36 -> 41
    //   8: new 164	android/app/ActivityManager$MemoryInfo
    //   11: dup
    //   12: invokespecial 165	android/app/ActivityManager$MemoryInfo:<init>	()V
    //   15: astore 6
    //   17: aload_0
    //   18: ldc 167
    //   20: invokevirtual 173	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   23: checkcast 175	android/app/ActivityManager
    //   26: aload 6
    //   28: invokevirtual 179	android/app/ActivityManager:getMemoryInfo	(Landroid/app/ActivityManager$MemoryInfo;)V
    //   31: aload 6
    //   33: getfield 193	android/app/ActivityManager$MemoryInfo:availMem	J
    //   36: ldc2_w 194
    //   39: ldiv
    //   40: lreturn
    //   41: lconst_0
    //   42: lstore 4
    //   44: new 197	java/io/BufferedReader
    //   47: dup
    //   48: new 199	java/io/InputStreamReader
    //   51: dup
    //   52: new 201	java/io/FileInputStream
    //   55: dup
    //   56: ldc 203
    //   58: invokespecial 204	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   61: ldc 206
    //   63: invokespecial 209	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   66: invokespecial 212	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   69: astore 6
    //   71: aload 6
    //   73: astore_0
    //   74: aload 6
    //   76: invokevirtual 215	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   79: astore 7
    //   81: lload 4
    //   83: lstore_2
    //   84: aload 7
    //   86: ifnull +48 -> 134
    //   89: aload 6
    //   91: astore_0
    //   92: aload 7
    //   94: ldc 217
    //   96: invokevirtual 223	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   99: astore 7
    //   101: aload 6
    //   103: astore_0
    //   104: ldc 225
    //   106: aload 7
    //   108: iconst_0
    //   109: aaload
    //   110: invokevirtual 229	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   113: ifeq +32 -> 145
    //   116: aload 6
    //   118: astore_0
    //   119: aload 7
    //   121: iconst_1
    //   122: aaload
    //   123: invokestatic 233	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   126: istore_1
    //   127: iload_1
    //   128: i2l
    //   129: ldc2_w 194
    //   132: lmul
    //   133: lstore_2
    //   134: aload 6
    //   136: invokevirtual 236	java/io/BufferedReader:close	()V
    //   139: lload_2
    //   140: ldc2_w 194
    //   143: ldiv
    //   144: lreturn
    //   145: aload 6
    //   147: astore_0
    //   148: aload 6
    //   150: invokevirtual 215	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   153: astore 7
    //   155: goto -74 -> 81
    //   158: astore_0
    //   159: ldc 74
    //   161: ldc 238
    //   163: iconst_1
    //   164: anewarray 4	java/lang/Object
    //   167: dup
    //   168: iconst_0
    //   169: aload_0
    //   170: invokevirtual 239	java/lang/Exception:toString	()Ljava/lang/String;
    //   173: aastore
    //   174: invokestatic 108	com/tencent/matrix/g/c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   177: goto -38 -> 139
    //   180: astore 7
    //   182: aconst_null
    //   183: astore 6
    //   185: aload 6
    //   187: astore_0
    //   188: ldc 74
    //   190: ldc 241
    //   192: iconst_1
    //   193: anewarray 4	java/lang/Object
    //   196: dup
    //   197: iconst_0
    //   198: aload 7
    //   200: invokevirtual 239	java/lang/Exception:toString	()Ljava/lang/String;
    //   203: aastore
    //   204: invokestatic 108	com/tencent/matrix/g/c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   207: lload 4
    //   209: lstore_2
    //   210: aload 6
    //   212: ifnull -73 -> 139
    //   215: aload 6
    //   217: invokevirtual 236	java/io/BufferedReader:close	()V
    //   220: lload 4
    //   222: lstore_2
    //   223: goto -84 -> 139
    //   226: astore_0
    //   227: ldc 74
    //   229: ldc 238
    //   231: iconst_1
    //   232: anewarray 4	java/lang/Object
    //   235: dup
    //   236: iconst_0
    //   237: aload_0
    //   238: invokevirtual 239	java/lang/Exception:toString	()Ljava/lang/String;
    //   241: aastore
    //   242: invokestatic 108	com/tencent/matrix/g/c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   245: lload 4
    //   247: lstore_2
    //   248: goto -109 -> 139
    //   251: astore 6
    //   253: aconst_null
    //   254: astore_0
    //   255: aload_0
    //   256: ifnull +7 -> 263
    //   259: aload_0
    //   260: invokevirtual 236	java/io/BufferedReader:close	()V
    //   263: aload 6
    //   265: athrow
    //   266: astore_0
    //   267: ldc 74
    //   269: ldc 238
    //   271: iconst_1
    //   272: anewarray 4	java/lang/Object
    //   275: dup
    //   276: iconst_0
    //   277: aload_0
    //   278: invokevirtual 239	java/lang/Exception:toString	()Ljava/lang/String;
    //   281: aastore
    //   282: invokestatic 108	com/tencent/matrix/g/c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   285: goto -22 -> 263
    //   288: astore 6
    //   290: goto -35 -> 255
    //   293: astore 7
    //   295: goto -110 -> 185
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	298	0	paramContext	Context
    //   126	2	1	i	int
    //   83	165	2	l1	long
    //   42	204	4	l2	long
    //   15	201	6	localObject1	Object
    //   251	13	6	localObject2	Object
    //   288	1	6	localObject3	Object
    //   79	75	7	localObject4	Object
    //   180	19	7	localException1	Exception
    //   293	1	7	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   134	139	158	java/lang/Exception
    //   44	71	180	java/lang/Exception
    //   215	220	226	java/lang/Exception
    //   44	71	251	finally
    //   259	263	266	java/lang/Exception
    //   74	81	288	finally
    //   92	101	288	finally
    //   104	116	288	finally
    //   119	127	288	finally
    //   148	155	288	finally
    //   188	207	288	finally
    //   74	81	293	java/lang/Exception
    //   92	101	293	java/lang/Exception
    //   104	116	293	java/lang/Exception
    //   119	127	293	java/lang/Exception
    //   148	155	293	java/lang/Exception
  }
  
  public static Debug.MemoryInfo aH(Context paramContext)
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
  
  /* Error */
  private static int cC(String paramString)
  {
    // Byte code:
    //   0: new 201	java/io/FileInputStream
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 204	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   8: astore_3
    //   9: aload_3
    //   10: astore_0
    //   11: new 197	java/io/BufferedReader
    //   14: dup
    //   15: new 199	java/io/InputStreamReader
    //   18: dup
    //   19: aload_3
    //   20: ldc 206
    //   22: invokespecial 209	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   25: invokespecial 212	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   28: astore 4
    //   30: aload_3
    //   31: astore_0
    //   32: aload 4
    //   34: invokevirtual 215	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   37: astore 5
    //   39: aload_3
    //   40: astore_0
    //   41: aload 4
    //   43: invokevirtual 236	java/io/BufferedReader:close	()V
    //   46: aload 5
    //   48: ifnull +18 -> 66
    //   51: aload_3
    //   52: astore_0
    //   53: aload 5
    //   55: ldc_w 259
    //   58: invokevirtual 263	java/lang/String:matches	(Ljava/lang/String;)Z
    //   61: istore_2
    //   62: iload_2
    //   63: ifne +32 -> 95
    //   66: aload_3
    //   67: invokevirtual 266	java/io/InputStream:close	()V
    //   70: iconst_0
    //   71: ireturn
    //   72: astore_0
    //   73: ldc 74
    //   75: ldc_w 268
    //   78: iconst_1
    //   79: anewarray 4	java/lang/Object
    //   82: dup
    //   83: iconst_0
    //   84: aload_0
    //   85: invokevirtual 269	java/io/IOException:toString	()Ljava/lang/String;
    //   88: aastore
    //   89: invokestatic 108	com/tencent/matrix/g/c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   92: goto -22 -> 70
    //   95: aload_3
    //   96: astore_0
    //   97: aload 5
    //   99: iconst_2
    //   100: invokevirtual 273	java/lang/String:substring	(I)Ljava/lang/String;
    //   103: invokestatic 233	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   106: istore_1
    //   107: iload_1
    //   108: iconst_1
    //   109: iadd
    //   110: istore_1
    //   111: aload_3
    //   112: invokevirtual 266	java/io/InputStream:close	()V
    //   115: iload_1
    //   116: ireturn
    //   117: astore_0
    //   118: ldc 74
    //   120: ldc_w 268
    //   123: iconst_1
    //   124: anewarray 4	java/lang/Object
    //   127: dup
    //   128: iconst_0
    //   129: aload_0
    //   130: invokevirtual 269	java/io/IOException:toString	()Ljava/lang/String;
    //   133: aastore
    //   134: invokestatic 108	com/tencent/matrix/g/c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   137: iload_1
    //   138: ireturn
    //   139: astore 4
    //   141: aconst_null
    //   142: astore_3
    //   143: aload_3
    //   144: astore_0
    //   145: ldc 74
    //   147: ldc_w 268
    //   150: iconst_1
    //   151: anewarray 4	java/lang/Object
    //   154: dup
    //   155: iconst_0
    //   156: aload 4
    //   158: invokevirtual 269	java/io/IOException:toString	()Ljava/lang/String;
    //   161: aastore
    //   162: invokestatic 108	com/tencent/matrix/g/c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   165: aload_3
    //   166: ifnull +7 -> 173
    //   169: aload_3
    //   170: invokevirtual 266	java/io/InputStream:close	()V
    //   173: iconst_0
    //   174: ireturn
    //   175: astore_0
    //   176: ldc 74
    //   178: ldc_w 268
    //   181: iconst_1
    //   182: anewarray 4	java/lang/Object
    //   185: dup
    //   186: iconst_0
    //   187: aload_0
    //   188: invokevirtual 269	java/io/IOException:toString	()Ljava/lang/String;
    //   191: aastore
    //   192: invokestatic 108	com/tencent/matrix/g/c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   195: goto -22 -> 173
    //   198: astore_3
    //   199: aconst_null
    //   200: astore_0
    //   201: aload_0
    //   202: ifnull +7 -> 209
    //   205: aload_0
    //   206: invokevirtual 266	java/io/InputStream:close	()V
    //   209: aload_3
    //   210: athrow
    //   211: astore_0
    //   212: ldc 74
    //   214: ldc_w 268
    //   217: iconst_1
    //   218: anewarray 4	java/lang/Object
    //   221: dup
    //   222: iconst_0
    //   223: aload_0
    //   224: invokevirtual 269	java/io/IOException:toString	()Ljava/lang/String;
    //   227: aastore
    //   228: invokestatic 108	com/tencent/matrix/g/c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   231: goto -22 -> 209
    //   234: astore_3
    //   235: goto -34 -> 201
    //   238: astore 4
    //   240: goto -97 -> 143
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	243	0	paramString	String
    //   106	32	1	i	int
    //   61	2	2	bool	boolean
    //   8	162	3	localFileInputStream	FileInputStream
    //   198	12	3	localObject1	Object
    //   234	1	3	localObject2	Object
    //   28	14	4	localBufferedReader	BufferedReader
    //   139	18	4	localIOException1	java.io.IOException
    //   238	1	4	localIOException2	java.io.IOException
    //   37	61	5	str	String
    // Exception table:
    //   from	to	target	type
    //   66	70	72	java/io/IOException
    //   111	115	117	java/io/IOException
    //   0	9	139	java/io/IOException
    //   169	173	175	java/io/IOException
    //   0	9	198	finally
    //   205	209	211	java/io/IOException
    //   11	30	234	finally
    //   32	39	234	finally
    //   41	46	234	finally
    //   53	62	234	finally
    //   97	107	234	finally
    //   145	165	234	finally
    //   11	30	238	java/io/IOException
    //   32	39	238	java/io/IOException
    //   41	46	238	java/io/IOException
    //   53	62	238	java/io/IOException
    //   97	107	238	java/io/IOException
  }
  
  private static String convertStreamToString(InputStream paramInputStream)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    try
    {
      localBufferedReader = new BufferedReader(new InputStreamReader(paramInputStream));
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
          break label56;
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
    label56:
    throw paramInputStream;
    localBufferedReader.close();
    return localStringBuilder.toString();
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
    if (0L != bTO) {
      l1 = bTO;
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
    bTO = localMemoryInfo.totalMem;
    bTP = localMemoryInfo.threshold;
    l1 = Runtime.getRuntime().maxMemory();
    if (l1 == 9223372036854775807L) {}
    for (bTQ = paramContext.getMemoryClass();; bTQ = (int)(l1 / 1048576L))
    {
      c.i("Matrix.DeviceUtil", "getTotalMemory cost:" + (System.currentTimeMillis() - l2) + ", total_mem:" + bTO + ", LowMemoryThresold:" + bTP + ", Memory Class:" + bTQ, new Object[0]);
      return bTO;
    }
  }
  
  public static long zD()
  {
    return Runtime.getRuntime().freeMemory() / 1024L;
  }
  
  /* Error */
  private static double zE()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 22
    //   3: aconst_null
    //   4: astore 21
    //   6: invokestatic 88	java/lang/System:currentTimeMillis	()J
    //   9: lstore 6
    //   11: dconst_0
    //   12: dstore_0
    //   13: new 342	java/io/RandomAccessFile
    //   16: dup
    //   17: ldc_w 344
    //   20: ldc_w 346
    //   23: invokespecial 349	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   26: astore 19
    //   28: aload 19
    //   30: astore 18
    //   32: aload 19
    //   34: invokevirtual 350	java/io/RandomAccessFile:readLine	()Ljava/lang/String;
    //   37: ldc_w 352
    //   40: invokevirtual 223	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   43: astore 20
    //   45: aload 19
    //   47: astore 18
    //   49: aload 20
    //   51: iconst_2
    //   52: aaload
    //   53: invokestatic 356	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   56: lstore_2
    //   57: aload 19
    //   59: astore 18
    //   61: aload 20
    //   63: iconst_3
    //   64: aaload
    //   65: invokestatic 356	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   68: lstore 4
    //   70: aload 19
    //   72: astore 18
    //   74: aload 20
    //   76: iconst_4
    //   77: aaload
    //   78: invokestatic 356	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   81: lstore 8
    //   83: aload 19
    //   85: astore 18
    //   87: aload 20
    //   89: iconst_5
    //   90: aaload
    //   91: invokestatic 356	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   94: lstore 10
    //   96: aload 19
    //   98: astore 18
    //   100: aload 20
    //   102: bipush 6
    //   104: aaload
    //   105: invokestatic 356	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   108: lstore 12
    //   110: aload 19
    //   112: astore 18
    //   114: aload 20
    //   116: bipush 7
    //   118: aaload
    //   119: invokestatic 356	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   122: lstore 14
    //   124: aload 19
    //   126: astore 18
    //   128: aload 20
    //   130: bipush 8
    //   132: aaload
    //   133: invokestatic 356	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   136: lstore 16
    //   138: lload_2
    //   139: lload 4
    //   141: ladd
    //   142: lload 8
    //   144: ladd
    //   145: lload 10
    //   147: ladd
    //   148: lload 12
    //   150: ladd
    //   151: lload 14
    //   153: ladd
    //   154: lload 16
    //   156: ladd
    //   157: lstore 4
    //   159: aload 19
    //   161: invokevirtual 357	java/io/RandomAccessFile:close	()V
    //   164: aload 22
    //   166: astore 18
    //   168: new 342	java/io/RandomAccessFile
    //   171: dup
    //   172: new 115	java/lang/StringBuilder
    //   175: dup
    //   176: ldc_w 359
    //   179: invokespecial 120	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   182: invokestatic 248	android/os/Process:myPid	()I
    //   185: invokevirtual 337	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   188: ldc_w 361
    //   191: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   194: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   197: ldc_w 346
    //   200: invokespecial 349	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   203: astore 19
    //   205: aload 19
    //   207: invokevirtual 350	java/io/RandomAccessFile:readLine	()Ljava/lang/String;
    //   210: ldc_w 352
    //   213: invokevirtual 223	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   216: astore 18
    //   218: aload 18
    //   220: bipush 13
    //   222: aaload
    //   223: invokestatic 356	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   226: lstore_2
    //   227: aload 18
    //   229: bipush 14
    //   231: aaload
    //   232: invokestatic 356	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   235: lstore 8
    //   237: lload_2
    //   238: lload 8
    //   240: ladd
    //   241: lstore_2
    //   242: aload 19
    //   244: invokevirtual 357	java/io/RandomAccessFile:close	()V
    //   247: lconst_0
    //   248: lload 4
    //   250: lcmp
    //   251: ifeq +14 -> 265
    //   254: lload_2
    //   255: l2d
    //   256: lload 4
    //   258: l2d
    //   259: ddiv
    //   260: ldc2_w 362
    //   263: dmul
    //   264: dstore_0
    //   265: ldc 74
    //   267: new 115	java/lang/StringBuilder
    //   270: dup
    //   271: ldc_w 365
    //   274: invokespecial 120	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   277: invokestatic 88	java/lang/System:currentTimeMillis	()J
    //   280: lload 6
    //   282: lsub
    //   283: invokevirtual 124	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   286: ldc_w 367
    //   289: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   292: dload_0
    //   293: invokevirtual 370	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   296: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   299: iconst_0
    //   300: anewarray 4	java/lang/Object
    //   303: invokestatic 108	com/tencent/matrix/g/c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   306: dload_0
    //   307: dreturn
    //   308: astore 18
    //   310: ldc 74
    //   312: ldc_w 372
    //   315: iconst_1
    //   316: anewarray 4	java/lang/Object
    //   319: dup
    //   320: iconst_0
    //   321: aload 18
    //   323: invokevirtual 239	java/lang/Exception:toString	()Ljava/lang/String;
    //   326: aastore
    //   327: invokestatic 108	com/tencent/matrix/g/c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   330: goto -166 -> 164
    //   333: astore 20
    //   335: aconst_null
    //   336: astore 19
    //   338: aload 19
    //   340: astore 18
    //   342: ldc 74
    //   344: ldc_w 374
    //   347: iconst_1
    //   348: anewarray 4	java/lang/Object
    //   351: dup
    //   352: iconst_0
    //   353: aload 20
    //   355: invokevirtual 239	java/lang/Exception:toString	()Ljava/lang/String;
    //   358: aastore
    //   359: invokestatic 108	com/tencent/matrix/g/c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   362: aload 19
    //   364: ifnull +8 -> 372
    //   367: aload 19
    //   369: invokevirtual 357	java/io/RandomAccessFile:close	()V
    //   372: lconst_0
    //   373: lstore 4
    //   375: goto -211 -> 164
    //   378: astore 18
    //   380: ldc 74
    //   382: ldc_w 372
    //   385: iconst_1
    //   386: anewarray 4	java/lang/Object
    //   389: dup
    //   390: iconst_0
    //   391: aload 18
    //   393: invokevirtual 239	java/lang/Exception:toString	()Ljava/lang/String;
    //   396: aastore
    //   397: invokestatic 108	com/tencent/matrix/g/c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   400: lconst_0
    //   401: lstore 4
    //   403: goto -239 -> 164
    //   406: astore 19
    //   408: aconst_null
    //   409: astore 18
    //   411: aload 18
    //   413: ifnull +8 -> 421
    //   416: aload 18
    //   418: invokevirtual 357	java/io/RandomAccessFile:close	()V
    //   421: aload 19
    //   423: athrow
    //   424: astore 18
    //   426: ldc 74
    //   428: ldc_w 372
    //   431: iconst_1
    //   432: anewarray 4	java/lang/Object
    //   435: dup
    //   436: iconst_0
    //   437: aload 18
    //   439: invokevirtual 239	java/lang/Exception:toString	()Ljava/lang/String;
    //   442: aastore
    //   443: invokestatic 108	com/tencent/matrix/g/c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   446: goto -25 -> 421
    //   449: astore 18
    //   451: ldc 74
    //   453: ldc_w 376
    //   456: iconst_1
    //   457: anewarray 4	java/lang/Object
    //   460: dup
    //   461: iconst_0
    //   462: aload 18
    //   464: invokevirtual 239	java/lang/Exception:toString	()Ljava/lang/String;
    //   467: aastore
    //   468: invokestatic 108	com/tencent/matrix/g/c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   471: goto -224 -> 247
    //   474: astore 20
    //   476: aload 21
    //   478: astore 19
    //   480: aload 19
    //   482: astore 18
    //   484: ldc 74
    //   486: ldc_w 378
    //   489: iconst_1
    //   490: anewarray 4	java/lang/Object
    //   493: dup
    //   494: iconst_0
    //   495: aload 20
    //   497: invokevirtual 239	java/lang/Exception:toString	()Ljava/lang/String;
    //   500: aastore
    //   501: invokestatic 108	com/tencent/matrix/g/c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   504: aload 19
    //   506: ifnull +8 -> 514
    //   509: aload 19
    //   511: invokevirtual 357	java/io/RandomAccessFile:close	()V
    //   514: lconst_0
    //   515: lstore_2
    //   516: goto -269 -> 247
    //   519: astore 18
    //   521: ldc 74
    //   523: ldc_w 376
    //   526: iconst_1
    //   527: anewarray 4	java/lang/Object
    //   530: dup
    //   531: iconst_0
    //   532: aload 18
    //   534: invokevirtual 239	java/lang/Exception:toString	()Ljava/lang/String;
    //   537: aastore
    //   538: invokestatic 108	com/tencent/matrix/g/c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   541: lconst_0
    //   542: lstore_2
    //   543: goto -296 -> 247
    //   546: astore 20
    //   548: aload 18
    //   550: astore 19
    //   552: aload 20
    //   554: astore 18
    //   556: aload 19
    //   558: ifnull +8 -> 566
    //   561: aload 19
    //   563: invokevirtual 357	java/io/RandomAccessFile:close	()V
    //   566: aload 18
    //   568: athrow
    //   569: astore 19
    //   571: ldc 74
    //   573: ldc_w 376
    //   576: iconst_1
    //   577: anewarray 4	java/lang/Object
    //   580: dup
    //   581: iconst_0
    //   582: aload 19
    //   584: invokevirtual 239	java/lang/Exception:toString	()Ljava/lang/String;
    //   587: aastore
    //   588: invokestatic 108	com/tencent/matrix/g/c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   591: goto -25 -> 566
    //   594: astore 18
    //   596: goto -40 -> 556
    //   599: astore 20
    //   601: goto -121 -> 480
    //   604: astore 19
    //   606: goto -195 -> 411
    //   609: astore 20
    //   611: goto -273 -> 338
    // Local variable table:
    //   start	length	slot	name	signature
    //   12	295	0	d	double
    //   56	487	2	l1	long
    //   68	334	4	l2	long
    //   9	272	6	l3	long
    //   81	158	8	l4	long
    //   94	52	10	l5	long
    //   108	41	12	l6	long
    //   122	30	14	l7	long
    //   136	19	16	l8	long
    //   30	198	18	localObject1	Object
    //   308	14	18	localException1	Exception
    //   340	1	18	localRandomAccessFile1	java.io.RandomAccessFile
    //   378	14	18	localException2	Exception
    //   409	8	18	localObject2	Object
    //   424	14	18	localException3	Exception
    //   449	14	18	localException4	Exception
    //   482	1	18	localObject3	Object
    //   519	30	18	localException5	Exception
    //   554	13	18	localObject4	Object
    //   594	1	18	localObject5	Object
    //   26	342	19	localRandomAccessFile2	java.io.RandomAccessFile
    //   406	16	19	localObject6	Object
    //   478	84	19	localObject7	Object
    //   569	14	19	localException6	Exception
    //   604	1	19	localObject8	Object
    //   43	86	20	arrayOfString	String[]
    //   333	21	20	localException7	Exception
    //   474	22	20	localException8	Exception
    //   546	7	20	localObject9	Object
    //   599	1	20	localException9	Exception
    //   609	1	20	localException10	Exception
    //   4	473	21	localObject10	Object
    //   1	164	22	localObject11	Object
    // Exception table:
    //   from	to	target	type
    //   159	164	308	java/lang/Exception
    //   13	28	333	java/lang/Exception
    //   367	372	378	java/lang/Exception
    //   13	28	406	finally
    //   416	421	424	java/lang/Exception
    //   242	247	449	java/lang/Exception
    //   168	205	474	java/lang/Exception
    //   509	514	519	java/lang/Exception
    //   168	205	546	finally
    //   484	504	546	finally
    //   561	566	569	java/lang/Exception
    //   205	237	594	finally
    //   205	237	599	java/lang/Exception
    //   32	45	604	finally
    //   49	57	604	finally
    //   61	70	604	finally
    //   74	83	604	finally
    //   87	96	604	finally
    //   100	110	604	finally
    //   114	124	604	finally
    //   128	138	604	finally
    //   342	362	604	finally
    //   32	45	609	java/lang/Exception
    //   49	57	609	java/lang/Exception
    //   61	70	609	java/lang/Exception
    //   74	83	609	java/lang/Exception
    //   87	96	609	java/lang/Exception
    //   100	110	609	java/lang/Exception
    //   114	124	609	java/lang/Exception
    //   128	138	609	java/lang/Exception
  }
  
  private static int zF()
  {
    int j = 0;
    if (Build.VERSION.SDK_INT <= 10) {
      return 1;
    }
    int i;
    try
    {
      int k = cC("/sys/devices/system/cpu/possible");
      i = k;
      if (k == 0) {
        i = cC("/sys/devices/system/cpu/present");
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
  
  public static long zG()
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
            break label144;
          }
          localObject2 = Pattern.compile("\\d+").matcher((CharSequence)localObject2);
          if (!((Matcher)localObject2).find()) {
            break label144;
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
      label144:
      i += 1;
    }
  }
  
  public static enum a
  {
    int value;
    
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