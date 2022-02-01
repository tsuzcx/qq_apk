package com.tencent.mobileqq.utils;

import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.AppConstants;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import krl;
import krn;
import mqq.app.permission.PermissionItem;
import mqq.app.permission.PermissionManager;

public class FileUtils
{
  public static final long a = 1024L;
  public static Runnable a;
  public static final String a = "FileUtils";
  public static boolean a = false;
  public static final long b = 1048576L;
  public static final String b = "jpg";
  public static final long c = 1073741824L;
  public static final String c = "pjpg";
  public static final String d = "png";
  public static final String e = "bmp";
  public static final String f = "gif";
  public static final String g = "apng";
  public static final String h = "sharpp";
  public static final String i = "webp";
  public static String j = "unknown_";
  
  static
  {
    jdField_a_of_type_Boolean = true;
    jdField_a_of_type_JavaLangRunnable = new krn();
  }
  
  public static float a()
  {
    Object localObject = Environment.getDataDirectory().getPath();
    try
    {
      localObject = new StatFs((String)localObject);
      float f1 = ((StatFs)localObject).getAvailableBlocks();
      int k = ((StatFs)localObject).getBlockSize();
      return k * f1;
    }
    catch (Exception localException) {}
    return -1.0F;
  }
  
  public static int a(String paramString1, String paramString2, boolean paramBoolean)
  {
    int n = 0;
    paramString1 = new File(paramString1);
    int k;
    if (!paramString1.exists()) {
      k = -1;
    }
    File localFile1;
    int m;
    do
    {
      return k;
      paramString1 = paramString1.listFiles();
      localFile1 = new File(paramString2);
      if (!localFile1.exists()) {
        localFile1.mkdirs();
      }
      m = 0;
      k = n;
    } while (m >= paramString1.length);
    if (paramString1[m].isDirectory()) {
      a(paramString1[m].getPath() + "/", paramString2 + paramString1[m].getName() + "/", paramBoolean);
    }
    for (;;)
    {
      m += 1;
      break;
      localFile1 = new File(paramString1[m].getPath());
      File localFile2 = new File(paramString2 + paramString1[m].getName());
      if ((localFile1 == null) || (localFile2 == null) || (!localFile1.exists())) {
        continue;
      }
      if (!localFile2.exists()) {}
      try
      {
        localFile2.createNewFile();
        a(localFile1, localFile2);
        label231:
        if (!paramBoolean) {
          continue;
        }
        localFile1.delete();
      }
      catch (IOException localIOException)
      {
        break label231;
      }
    }
  }
  
  /* Error */
  public static long a(File paramFile1, File paramFile2, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 9
    //   3: aconst_null
    //   4: astore 8
    //   6: new 137	java/io/FileInputStream
    //   9: dup
    //   10: aload_0
    //   11: invokespecial 140	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   14: invokevirtual 144	java/io/FileInputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   17: astore_0
    //   18: aload 9
    //   20: astore 8
    //   22: new 146	java/io/FileOutputStream
    //   25: dup
    //   26: aload_1
    //   27: invokespecial 147	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   30: invokevirtual 148	java/io/FileOutputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   33: astore_1
    //   34: iload_2
    //   35: i2l
    //   36: lstore 4
    //   38: iload_3
    //   39: i2l
    //   40: lstore 6
    //   42: aload_1
    //   43: astore 8
    //   45: aload_1
    //   46: aload_0
    //   47: lload 4
    //   49: lload 6
    //   51: invokevirtual 154	java/nio/channels/FileChannel:transferFrom	(Ljava/nio/channels/ReadableByteChannel;JJ)J
    //   54: lstore 4
    //   56: aload_0
    //   57: ifnull +7 -> 64
    //   60: aload_0
    //   61: invokevirtual 157	java/nio/channels/FileChannel:close	()V
    //   64: aload_1
    //   65: ifnull +89 -> 154
    //   68: aload_1
    //   69: invokevirtual 157	java/nio/channels/FileChannel:close	()V
    //   72: lload 4
    //   74: lreturn
    //   75: astore_0
    //   76: aconst_null
    //   77: astore_0
    //   78: aload_0
    //   79: ifnull +7 -> 86
    //   82: aload_0
    //   83: invokevirtual 157	java/nio/channels/FileChannel:close	()V
    //   86: aload 8
    //   88: ifnull +64 -> 152
    //   91: aload 8
    //   93: invokevirtual 157	java/nio/channels/FileChannel:close	()V
    //   96: lconst_0
    //   97: lreturn
    //   98: astore_0
    //   99: aconst_null
    //   100: astore 8
    //   102: aconst_null
    //   103: astore_1
    //   104: aload 8
    //   106: ifnull +8 -> 114
    //   109: aload 8
    //   111: invokevirtual 157	java/nio/channels/FileChannel:close	()V
    //   114: aload_1
    //   115: ifnull +7 -> 122
    //   118: aload_1
    //   119: invokevirtual 157	java/nio/channels/FileChannel:close	()V
    //   122: aload_0
    //   123: athrow
    //   124: astore 9
    //   126: aload_0
    //   127: astore 8
    //   129: aconst_null
    //   130: astore_1
    //   131: aload 9
    //   133: astore_0
    //   134: goto -30 -> 104
    //   137: astore 9
    //   139: aload_0
    //   140: astore 8
    //   142: aload 9
    //   144: astore_0
    //   145: goto -41 -> 104
    //   148: astore_1
    //   149: goto -71 -> 78
    //   152: lconst_0
    //   153: lreturn
    //   154: lload 4
    //   156: lreturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	157	0	paramFile1	File
    //   0	157	1	paramFile2	File
    //   0	157	2	paramInt1	int
    //   0	157	3	paramInt2	int
    //   36	119	4	l1	long
    //   40	10	6	l2	long
    //   4	137	8	localObject1	Object
    //   1	18	9	localObject2	Object
    //   124	8	9	localObject3	Object
    //   137	6	9	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   6	18	75	java/io/FileNotFoundException
    //   6	18	98	finally
    //   22	34	124	finally
    //   45	56	137	finally
    //   22	34	148	java/io/FileNotFoundException
    //   45	56	148	java/io/FileNotFoundException
  }
  
  /* Error */
  public static long a(String paramString)
  {
    // Byte code:
    //   0: lconst_0
    //   1: lstore_2
    //   2: aconst_null
    //   3: astore 6
    //   5: new 71	java/io/File
    //   8: dup
    //   9: aload_0
    //   10: invokespecial 92	java/io/File:<init>	(Ljava/lang/String;)V
    //   13: astore_0
    //   14: aload_0
    //   15: invokevirtual 96	java/io/File:exists	()Z
    //   18: ifeq +37 -> 55
    //   21: new 137	java/io/FileInputStream
    //   24: dup
    //   25: aload_0
    //   26: invokespecial 140	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   29: astore_0
    //   30: aload_0
    //   31: invokevirtual 161	java/io/FileInputStream:available	()I
    //   34: istore_1
    //   35: iload_1
    //   36: i2l
    //   37: lstore 4
    //   39: lload 4
    //   41: lstore_2
    //   42: aload_0
    //   43: ifnull +10 -> 53
    //   46: aload_0
    //   47: invokevirtual 162	java/io/FileInputStream:close	()V
    //   50: lload 4
    //   52: lstore_2
    //   53: lload_2
    //   54: lreturn
    //   55: iconst_0
    //   56: ifeq -3 -> 53
    //   59: new 164	java/lang/NullPointerException
    //   62: dup
    //   63: invokespecial 165	java/lang/NullPointerException:<init>	()V
    //   66: athrow
    //   67: astore_0
    //   68: lconst_0
    //   69: lreturn
    //   70: astore_0
    //   71: aconst_null
    //   72: astore_0
    //   73: aload_0
    //   74: ifnull -21 -> 53
    //   77: aload_0
    //   78: invokevirtual 162	java/io/FileInputStream:close	()V
    //   81: lconst_0
    //   82: lreturn
    //   83: astore_0
    //   84: lconst_0
    //   85: lreturn
    //   86: astore_0
    //   87: aload 6
    //   89: ifnull +8 -> 97
    //   92: aload 6
    //   94: invokevirtual 162	java/io/FileInputStream:close	()V
    //   97: aload_0
    //   98: athrow
    //   99: astore_0
    //   100: lload 4
    //   102: lreturn
    //   103: astore 6
    //   105: goto -8 -> 97
    //   108: astore 7
    //   110: aload_0
    //   111: astore 6
    //   113: aload 7
    //   115: astore_0
    //   116: goto -29 -> 87
    //   119: astore 6
    //   121: goto -48 -> 73
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	124	0	paramString	String
    //   34	2	1	k	int
    //   1	53	2	l1	long
    //   37	64	4	l2	long
    //   3	90	6	localObject1	Object
    //   103	1	6	localIOException	IOException
    //   111	1	6	str	String
    //   119	1	6	localException	Exception
    //   108	6	7	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   59	67	67	java/io/IOException
    //   5	30	70	java/lang/Exception
    //   77	81	83	java/io/IOException
    //   5	30	86	finally
    //   46	50	99	java/io/IOException
    //   92	97	103	java/io/IOException
    //   30	35	108	finally
    //   30	35	119	java/lang/Exception
  }
  
  public static File a(String paramString)
  {
    paramString = new File(paramString);
    if (!paramString.exists())
    {
      if ((paramString.getParentFile() == null) || (paramString.getParentFile().exists())) {
        break label50;
      }
      if (paramString.getParentFile().mkdirs()) {
        paramString.createNewFile();
      }
    }
    return paramString;
    label50:
    paramString.createNewFile();
    return paramString;
  }
  
  public static String a(int paramInt, long paramLong)
  {
    String str;
    if (paramLong == 0L) {
      if (paramInt == 0) {
        str = "0.0B";
      }
    }
    do
    {
      return str;
      if (paramInt == 1) {
        return "0.0K";
      }
      str = null;
      DecimalFormat localDecimalFormat = new DecimalFormat("0.0");
      float f1;
      if (paramLong / 1073741824L > 0L)
      {
        f1 = (float)paramLong / 1.073742E+009F;
        str = localDecimalFormat.format(f1);
        if (str.endsWith(".0")) {
          return (int)f1 + "G";
        }
        return str + "G";
      }
      if (paramLong / 1048576L > 0L)
      {
        f1 = (float)paramLong / 1048576.0F;
        str = localDecimalFormat.format(f1);
        if (str.endsWith(".0")) {
          return (int)f1 + "M";
        }
        return str + "M";
      }
      if (paramLong / 1024L > 0L)
      {
        paramInt = (int)(paramLong / 1024L);
        return paramInt + "K";
      }
      if (paramInt == 0) {
        return localDecimalFormat.format(paramLong) + "B";
      }
    } while (paramInt != 1);
    paramInt = (int)(paramLong / 1024L);
    return paramInt + "K";
  }
  
  public static String a(long paramLong)
  {
    return FileSizeFormat.a(paramLong);
  }
  
  /* Error */
  public static String a(File paramFile)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: new 216	java/io/ByteArrayOutputStream
    //   5: dup
    //   6: invokespecial 217	java/io/ByteArrayOutputStream:<init>	()V
    //   9: astore 5
    //   11: new 137	java/io/FileInputStream
    //   14: dup
    //   15: aload_0
    //   16: invokespecial 140	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   19: astore 6
    //   21: aload 5
    //   23: astore 8
    //   25: aload 6
    //   27: astore 7
    //   29: aload_0
    //   30: invokevirtual 221	java/io/File:length	()J
    //   33: lstore_3
    //   34: aload 5
    //   36: astore 8
    //   38: aload 6
    //   40: astore 7
    //   42: sipush 12288
    //   45: newarray byte
    //   47: astore_0
    //   48: iload_1
    //   49: i2l
    //   50: lload_3
    //   51: lcmp
    //   52: ifge +59 -> 111
    //   55: aload 5
    //   57: astore 8
    //   59: aload 6
    //   61: astore 7
    //   63: aload 6
    //   65: aload_0
    //   66: invokevirtual 225	java/io/FileInputStream:read	([B)I
    //   69: istore_2
    //   70: aload 5
    //   72: astore 8
    //   74: aload 6
    //   76: astore 7
    //   78: aload 5
    //   80: aload_0
    //   81: iconst_0
    //   82: iload_2
    //   83: invokevirtual 229	java/io/ByteArrayOutputStream:write	([BII)V
    //   86: iload_1
    //   87: iload_2
    //   88: iadd
    //   89: istore_1
    //   90: goto -42 -> 48
    //   93: astore_0
    //   94: aload 5
    //   96: astore 8
    //   98: aload 6
    //   100: astore 7
    //   102: sipush 4096
    //   105: newarray byte
    //   107: astore_0
    //   108: goto -60 -> 48
    //   111: aload 5
    //   113: astore 8
    //   115: aload 6
    //   117: astore 7
    //   119: new 188	java/lang/String
    //   122: dup
    //   123: aload 5
    //   125: invokevirtual 233	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   128: ldc 235
    //   130: invokespecial 238	java/lang/String:<init>	([BLjava/lang/String;)V
    //   133: astore_0
    //   134: aload 5
    //   136: ifnull +8 -> 144
    //   139: aload 5
    //   141: invokevirtual 239	java/io/ByteArrayOutputStream:close	()V
    //   144: aload 6
    //   146: ifnull +8 -> 154
    //   149: aload 6
    //   151: invokevirtual 162	java/io/FileInputStream:close	()V
    //   154: aload_0
    //   155: areturn
    //   156: astore 5
    //   158: invokestatic 244	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   161: ifeq -7 -> 154
    //   164: ldc 12
    //   166: iconst_2
    //   167: ldc 246
    //   169: aload 5
    //   171: invokestatic 249	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   174: aload_0
    //   175: areturn
    //   176: astore 9
    //   178: aconst_null
    //   179: astore 5
    //   181: aconst_null
    //   182: astore_0
    //   183: aload 5
    //   185: astore 8
    //   187: aload_0
    //   188: astore 7
    //   190: invokestatic 244	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   193: ifeq +20 -> 213
    //   196: aload 5
    //   198: astore 8
    //   200: aload_0
    //   201: astore 7
    //   203: ldc 12
    //   205: iconst_2
    //   206: ldc 246
    //   208: aload 9
    //   210: invokestatic 249	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   213: aload 5
    //   215: ifnull +8 -> 223
    //   218: aload 5
    //   220: invokevirtual 239	java/io/ByteArrayOutputStream:close	()V
    //   223: aload_0
    //   224: ifnull +7 -> 231
    //   227: aload_0
    //   228: invokevirtual 162	java/io/FileInputStream:close	()V
    //   231: aconst_null
    //   232: areturn
    //   233: astore_0
    //   234: invokestatic 244	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   237: ifeq +12 -> 249
    //   240: ldc 12
    //   242: iconst_2
    //   243: ldc 246
    //   245: aload_0
    //   246: invokestatic 249	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   249: aconst_null
    //   250: areturn
    //   251: astore_0
    //   252: aconst_null
    //   253: astore 5
    //   255: aconst_null
    //   256: astore 6
    //   258: aload 5
    //   260: ifnull +8 -> 268
    //   263: aload 5
    //   265: invokevirtual 239	java/io/ByteArrayOutputStream:close	()V
    //   268: aload 6
    //   270: ifnull +8 -> 278
    //   273: aload 6
    //   275: invokevirtual 162	java/io/FileInputStream:close	()V
    //   278: aconst_null
    //   279: areturn
    //   280: astore_0
    //   281: invokestatic 244	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   284: ifeq +12 -> 296
    //   287: ldc 12
    //   289: iconst_2
    //   290: ldc 246
    //   292: aload_0
    //   293: invokestatic 249	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   296: aconst_null
    //   297: areturn
    //   298: astore_0
    //   299: aconst_null
    //   300: astore 5
    //   302: aconst_null
    //   303: astore 7
    //   305: aload 5
    //   307: ifnull +8 -> 315
    //   310: aload 5
    //   312: invokevirtual 239	java/io/ByteArrayOutputStream:close	()V
    //   315: aload 7
    //   317: ifnull +8 -> 325
    //   320: aload 7
    //   322: invokevirtual 162	java/io/FileInputStream:close	()V
    //   325: aload_0
    //   326: athrow
    //   327: astore 5
    //   329: invokestatic 244	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   332: ifeq -7 -> 325
    //   335: ldc 12
    //   337: iconst_2
    //   338: ldc 246
    //   340: aload 5
    //   342: invokestatic 249	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   345: goto -20 -> 325
    //   348: astore_0
    //   349: aconst_null
    //   350: astore 7
    //   352: goto -47 -> 305
    //   355: astore_0
    //   356: aload 8
    //   358: astore 5
    //   360: goto -55 -> 305
    //   363: astore_0
    //   364: aconst_null
    //   365: astore 6
    //   367: goto -109 -> 258
    //   370: astore_0
    //   371: goto -113 -> 258
    //   374: astore 9
    //   376: aconst_null
    //   377: astore_0
    //   378: goto -195 -> 183
    //   381: astore 9
    //   383: aload 6
    //   385: astore_0
    //   386: goto -203 -> 183
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	389	0	paramFile	File
    //   1	89	1	k	int
    //   69	20	2	m	int
    //   33	18	3	l	long
    //   9	131	5	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   156	14	5	localIOException1	IOException
    //   179	132	5	localObject1	Object
    //   327	14	5	localIOException2	IOException
    //   358	1	5	localObject2	Object
    //   19	365	6	localFileInputStream	java.io.FileInputStream
    //   27	324	7	localObject3	Object
    //   23	334	8	localObject4	Object
    //   176	33	9	localIOException3	IOException
    //   374	1	9	localIOException4	IOException
    //   381	1	9	localIOException5	IOException
    // Exception table:
    //   from	to	target	type
    //   42	48	93	java/lang/OutOfMemoryError
    //   139	144	156	java/io/IOException
    //   149	154	156	java/io/IOException
    //   2	11	176	java/io/IOException
    //   218	223	233	java/io/IOException
    //   227	231	233	java/io/IOException
    //   2	11	251	java/lang/OutOfMemoryError
    //   263	268	280	java/io/IOException
    //   273	278	280	java/io/IOException
    //   2	11	298	finally
    //   310	315	327	java/io/IOException
    //   320	325	327	java/io/IOException
    //   11	21	348	finally
    //   29	34	355	finally
    //   42	48	355	finally
    //   63	70	355	finally
    //   78	86	355	finally
    //   102	108	355	finally
    //   119	134	355	finally
    //   190	196	355	finally
    //   203	213	355	finally
    //   11	21	363	java/lang/OutOfMemoryError
    //   29	34	370	java/lang/OutOfMemoryError
    //   63	70	370	java/lang/OutOfMemoryError
    //   78	86	370	java/lang/OutOfMemoryError
    //   102	108	370	java/lang/OutOfMemoryError
    //   119	134	370	java/lang/OutOfMemoryError
    //   11	21	374	java/io/IOException
    //   29	34	381	java/io/IOException
    //   42	48	381	java/io/IOException
    //   63	70	381	java/io/IOException
    //   78	86	381	java/io/IOException
    //   102	108	381	java/io/IOException
    //   119	134	381	java/io/IOException
  }
  
  /* Error */
  public static String a(String paramString)
  {
    // Byte code:
    //   0: new 137	java/io/FileInputStream
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 251	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   8: astore_2
    //   9: aload_2
    //   10: astore_1
    //   11: iconst_2
    //   12: newarray byte
    //   14: astore_0
    //   15: aload_2
    //   16: astore_1
    //   17: aload_2
    //   18: aload_0
    //   19: invokevirtual 225	java/io/FileInputStream:read	([B)I
    //   22: iconst_m1
    //   23: if_icmpeq +134 -> 157
    //   26: aload_2
    //   27: astore_1
    //   28: aload_0
    //   29: invokestatic 254	com/tencent/mobileqq/utils/FileUtils:a	([B)Ljava/lang/String;
    //   32: astore_0
    //   33: aload_2
    //   34: astore_1
    //   35: aload_2
    //   36: invokevirtual 162	java/io/FileInputStream:close	()V
    //   39: aload_0
    //   40: astore_1
    //   41: aload_2
    //   42: ifnull +9 -> 51
    //   45: aload_2
    //   46: invokevirtual 162	java/io/FileInputStream:close	()V
    //   49: aload_0
    //   50: astore_1
    //   51: aload_1
    //   52: areturn
    //   53: astore_3
    //   54: aconst_null
    //   55: astore_2
    //   56: ldc_w 256
    //   59: astore_0
    //   60: aload_2
    //   61: astore_1
    //   62: aload_3
    //   63: invokevirtual 259	java/io/FileNotFoundException:printStackTrace	()V
    //   66: aload_0
    //   67: astore_1
    //   68: aload_2
    //   69: ifnull -18 -> 51
    //   72: aload_2
    //   73: invokevirtual 162	java/io/FileInputStream:close	()V
    //   76: aload_0
    //   77: areturn
    //   78: astore_1
    //   79: aload_0
    //   80: areturn
    //   81: astore_3
    //   82: aconst_null
    //   83: astore_2
    //   84: ldc_w 256
    //   87: astore_0
    //   88: aload_2
    //   89: astore_1
    //   90: aload_3
    //   91: invokevirtual 260	java/io/IOException:printStackTrace	()V
    //   94: aload_0
    //   95: astore_1
    //   96: aload_2
    //   97: ifnull -46 -> 51
    //   100: aload_2
    //   101: invokevirtual 162	java/io/FileInputStream:close	()V
    //   104: aload_0
    //   105: areturn
    //   106: astore_1
    //   107: aload_0
    //   108: areturn
    //   109: astore_0
    //   110: aconst_null
    //   111: astore_1
    //   112: aload_1
    //   113: ifnull +7 -> 120
    //   116: aload_1
    //   117: invokevirtual 162	java/io/FileInputStream:close	()V
    //   120: aload_0
    //   121: athrow
    //   122: astore_1
    //   123: aload_0
    //   124: areturn
    //   125: astore_1
    //   126: goto -6 -> 120
    //   129: astore_0
    //   130: goto -18 -> 112
    //   133: astore_3
    //   134: ldc_w 256
    //   137: astore_0
    //   138: goto -50 -> 88
    //   141: astore_3
    //   142: goto -54 -> 88
    //   145: astore_3
    //   146: ldc_w 256
    //   149: astore_0
    //   150: goto -90 -> 60
    //   153: astore_3
    //   154: goto -94 -> 60
    //   157: ldc_w 256
    //   160: astore_0
    //   161: goto -128 -> 33
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	164	0	paramString	String
    //   10	58	1	localObject1	Object
    //   78	1	1	localIOException1	IOException
    //   89	7	1	localObject2	Object
    //   106	1	1	localIOException2	IOException
    //   111	6	1	localObject3	Object
    //   122	1	1	localIOException3	IOException
    //   125	1	1	localIOException4	IOException
    //   8	93	2	localFileInputStream	java.io.FileInputStream
    //   53	10	3	localFileNotFoundException1	FileNotFoundException
    //   81	10	3	localIOException5	IOException
    //   133	1	3	localIOException6	IOException
    //   141	1	3	localIOException7	IOException
    //   145	1	3	localFileNotFoundException2	FileNotFoundException
    //   153	1	3	localFileNotFoundException3	FileNotFoundException
    // Exception table:
    //   from	to	target	type
    //   0	9	53	java/io/FileNotFoundException
    //   72	76	78	java/io/IOException
    //   0	9	81	java/io/IOException
    //   100	104	106	java/io/IOException
    //   0	9	109	finally
    //   45	49	122	java/io/IOException
    //   116	120	125	java/io/IOException
    //   11	15	129	finally
    //   17	26	129	finally
    //   28	33	129	finally
    //   35	39	129	finally
    //   62	66	129	finally
    //   90	94	129	finally
    //   11	15	133	java/io/IOException
    //   17	26	133	java/io/IOException
    //   28	33	133	java/io/IOException
    //   35	39	141	java/io/IOException
    //   11	15	145	java/io/FileNotFoundException
    //   17	26	145	java/io/FileNotFoundException
    //   28	33	145	java/io/FileNotFoundException
    //   35	39	153	java/io/FileNotFoundException
  }
  
  /* Error */
  public static String a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: new 71	java/io/File
    //   5: dup
    //   6: aload_0
    //   7: invokespecial 92	java/io/File:<init>	(Ljava/lang/String;)V
    //   10: astore_0
    //   11: aload_0
    //   12: ifnull +17 -> 29
    //   15: aload_0
    //   16: invokevirtual 96	java/io/File:exists	()Z
    //   19: ifeq +10 -> 29
    //   22: aload_0
    //   23: invokevirtual 266	java/io/File:isFile	()Z
    //   26: ifne +5 -> 31
    //   29: aconst_null
    //   30: areturn
    //   31: aload_1
    //   32: invokestatic 272	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   35: astore 4
    //   37: new 137	java/io/FileInputStream
    //   40: dup
    //   41: aload_0
    //   42: invokespecial 140	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   45: astore_1
    //   46: sipush 1024
    //   49: newarray byte
    //   51: astore 5
    //   53: bipush 16
    //   55: newarray char
    //   57: astore_0
    //   58: aload_0
    //   59: dup
    //   60: iconst_0
    //   61: ldc_w 273
    //   64: castore
    //   65: dup
    //   66: iconst_1
    //   67: ldc_w 274
    //   70: castore
    //   71: dup
    //   72: iconst_2
    //   73: ldc_w 275
    //   76: castore
    //   77: dup
    //   78: iconst_3
    //   79: ldc_w 276
    //   82: castore
    //   83: dup
    //   84: iconst_4
    //   85: ldc_w 277
    //   88: castore
    //   89: dup
    //   90: iconst_5
    //   91: ldc_w 278
    //   94: castore
    //   95: dup
    //   96: bipush 6
    //   98: ldc_w 279
    //   101: castore
    //   102: dup
    //   103: bipush 7
    //   105: ldc_w 280
    //   108: castore
    //   109: dup
    //   110: bipush 8
    //   112: ldc_w 281
    //   115: castore
    //   116: dup
    //   117: bipush 9
    //   119: ldc_w 282
    //   122: castore
    //   123: dup
    //   124: bipush 10
    //   126: ldc_w 283
    //   129: castore
    //   130: dup
    //   131: bipush 11
    //   133: ldc_w 284
    //   136: castore
    //   137: dup
    //   138: bipush 12
    //   140: ldc_w 285
    //   143: castore
    //   144: dup
    //   145: bipush 13
    //   147: ldc_w 286
    //   150: castore
    //   151: dup
    //   152: bipush 14
    //   154: ldc_w 287
    //   157: castore
    //   158: dup
    //   159: bipush 15
    //   161: ldc_w 288
    //   164: castore
    //   165: pop
    //   166: aload_1
    //   167: aload 5
    //   169: invokevirtual 225	java/io/FileInputStream:read	([B)I
    //   172: istore_3
    //   173: iload_3
    //   174: ifle +28 -> 202
    //   177: aload 4
    //   179: aload 5
    //   181: iconst_0
    //   182: iload_3
    //   183: invokevirtual 291	java/security/MessageDigest:update	([BII)V
    //   186: goto -20 -> 166
    //   189: astore_0
    //   190: aload_1
    //   191: ifnull +195 -> 386
    //   194: aload_1
    //   195: invokevirtual 162	java/io/FileInputStream:close	()V
    //   198: aconst_null
    //   199: astore_0
    //   200: aload_0
    //   201: areturn
    //   202: aload 4
    //   204: invokevirtual 294	java/security/MessageDigest:digest	()[B
    //   207: astore 4
    //   209: aload 4
    //   211: ifnull +11 -> 222
    //   214: aload 4
    //   216: arraylength
    //   217: istore_3
    //   218: iload_3
    //   219: ifne +16 -> 235
    //   222: aload_1
    //   223: ifnull -194 -> 29
    //   226: aload_1
    //   227: invokevirtual 162	java/io/FileInputStream:close	()V
    //   230: aconst_null
    //   231: areturn
    //   232: astore_0
    //   233: aconst_null
    //   234: areturn
    //   235: aload 4
    //   237: arraylength
    //   238: iconst_2
    //   239: imul
    //   240: newarray char
    //   242: astore 5
    //   244: iload_2
    //   245: aload 4
    //   247: arraylength
    //   248: if_icmpge +44 -> 292
    //   251: aload 4
    //   253: iload_2
    //   254: baload
    //   255: istore_3
    //   256: aload 5
    //   258: iload_2
    //   259: iconst_2
    //   260: imul
    //   261: iconst_1
    //   262: iadd
    //   263: aload_0
    //   264: iload_3
    //   265: bipush 15
    //   267: iand
    //   268: caload
    //   269: castore
    //   270: aload 5
    //   272: iload_2
    //   273: iconst_2
    //   274: imul
    //   275: aload_0
    //   276: iload_3
    //   277: iconst_4
    //   278: iushr
    //   279: i2b
    //   280: bipush 15
    //   282: iand
    //   283: caload
    //   284: castore
    //   285: iload_2
    //   286: iconst_1
    //   287: iadd
    //   288: istore_2
    //   289: goto -45 -> 244
    //   292: new 188	java/lang/String
    //   295: dup
    //   296: aload 5
    //   298: invokespecial 297	java/lang/String:<init>	([C)V
    //   301: astore 4
    //   303: aload 4
    //   305: astore_0
    //   306: aload_1
    //   307: ifnull -107 -> 200
    //   310: aload_1
    //   311: invokevirtual 162	java/io/FileInputStream:close	()V
    //   314: aload 4
    //   316: astore_0
    //   317: goto -117 -> 200
    //   320: astore_0
    //   321: aload 4
    //   323: astore_0
    //   324: goto -124 -> 200
    //   327: astore_0
    //   328: aconst_null
    //   329: astore_0
    //   330: goto -130 -> 200
    //   333: astore_0
    //   334: aconst_null
    //   335: astore_1
    //   336: aload_1
    //   337: ifnull +49 -> 386
    //   340: aload_1
    //   341: invokevirtual 162	java/io/FileInputStream:close	()V
    //   344: aconst_null
    //   345: astore_0
    //   346: goto -146 -> 200
    //   349: astore_0
    //   350: aconst_null
    //   351: astore_0
    //   352: goto -152 -> 200
    //   355: astore_0
    //   356: aconst_null
    //   357: astore_1
    //   358: aload_1
    //   359: ifnull +7 -> 366
    //   362: aload_1
    //   363: invokevirtual 162	java/io/FileInputStream:close	()V
    //   366: aload_0
    //   367: athrow
    //   368: astore_1
    //   369: goto -3 -> 366
    //   372: astore_0
    //   373: goto -15 -> 358
    //   376: astore_0
    //   377: goto -41 -> 336
    //   380: astore_0
    //   381: aconst_null
    //   382: astore_1
    //   383: goto -193 -> 190
    //   386: aconst_null
    //   387: astore_0
    //   388: goto -188 -> 200
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	391	0	paramString1	String
    //   0	391	1	paramString2	String
    //   1	288	2	k	int
    //   172	107	3	m	int
    //   35	287	4	localObject1	Object
    //   51	246	5	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   46	166	189	java/io/IOException
    //   166	173	189	java/io/IOException
    //   177	186	189	java/io/IOException
    //   202	209	189	java/io/IOException
    //   214	218	189	java/io/IOException
    //   235	244	189	java/io/IOException
    //   244	251	189	java/io/IOException
    //   292	303	189	java/io/IOException
    //   226	230	232	java/io/IOException
    //   310	314	320	java/io/IOException
    //   194	198	327	java/io/IOException
    //   31	46	333	java/security/NoSuchAlgorithmException
    //   340	344	349	java/io/IOException
    //   31	46	355	finally
    //   362	366	368	java/io/IOException
    //   46	166	372	finally
    //   166	173	372	finally
    //   177	186	372	finally
    //   202	209	372	finally
    //   214	218	372	finally
    //   235	244	372	finally
    //   244	251	372	finally
    //   292	303	372	finally
    //   46	166	376	java/security/NoSuchAlgorithmException
    //   166	173	376	java/security/NoSuchAlgorithmException
    //   177	186	376	java/security/NoSuchAlgorithmException
    //   202	209	376	java/security/NoSuchAlgorithmException
    //   214	218	376	java/security/NoSuchAlgorithmException
    //   235	244	376	java/security/NoSuchAlgorithmException
    //   244	251	376	java/security/NoSuchAlgorithmException
    //   292	303	376	java/security/NoSuchAlgorithmException
    //   31	46	380	java/io/IOException
  }
  
  public static String a(byte[] paramArrayOfByte)
  {
    String str = "";
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length >= 2))
    {
      int k = 0;
      while (k < paramArrayOfByte.length)
      {
        str = str + Integer.toString(paramArrayOfByte[k] & 0xFF);
        k += 1;
      }
      switch (Integer.parseInt(str))
      {
      default: 
        return j + str;
      case 7790: 
        return "exe";
      case 7784: 
        return "midi";
      case 8297: 
        return "rar";
      case 8075: 
        return "zip";
      case 255216: 
        return "jpg";
      case 7173: 
        return "gif";
      case 6677: 
        return "bmp";
      case 13780: 
        return "png";
      }
      return "webp";
    }
    return j + "";
  }
  
  public static ArrayList a(String paramString)
  {
    Object localObject = new File(paramString);
    paramString = new ArrayList();
    localObject = ((File)localObject).listFiles();
    int k = 0;
    for (;;)
    {
      try
      {
        int m = localObject.length;
        if (k < m) {
          if (localObject[k].isDirectory()) {
            paramString.addAll(a(localObject[k].getCanonicalPath()));
          } else {
            paramString.add(localObject[k].getCanonicalPath());
          }
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      return paramString;
      k += 1;
    }
  }
  
  /* Error */
  public static void a(File paramFile1, File paramFile2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore_3
    //   5: aload_1
    //   6: invokevirtual 96	java/io/File:exists	()Z
    //   9: ifeq +8 -> 17
    //   12: aload_1
    //   13: invokevirtual 132	java/io/File:delete	()Z
    //   16: pop
    //   17: new 146	java/io/FileOutputStream
    //   20: dup
    //   21: aload_1
    //   22: invokespecial 147	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   25: astore_1
    //   26: new 137	java/io/FileInputStream
    //   29: dup
    //   30: aload_0
    //   31: invokespecial 140	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   34: astore_0
    //   35: sipush 4096
    //   38: newarray byte
    //   40: astore_3
    //   41: aload_0
    //   42: aload_3
    //   43: invokevirtual 225	java/io/FileInputStream:read	([B)I
    //   46: istore_2
    //   47: iload_2
    //   48: iconst_m1
    //   49: if_icmpeq +41 -> 90
    //   52: aload_1
    //   53: aload_3
    //   54: iconst_0
    //   55: iload_2
    //   56: invokevirtual 333	java/io/FileOutputStream:write	([BII)V
    //   59: aload_1
    //   60: invokevirtual 336	java/io/FileOutputStream:flush	()V
    //   63: goto -22 -> 41
    //   66: astore_3
    //   67: aload_0
    //   68: astore_3
    //   69: aload_1
    //   70: astore_0
    //   71: aload_3
    //   72: astore_1
    //   73: aload_0
    //   74: ifnull +7 -> 81
    //   77: aload_0
    //   78: invokevirtual 337	java/io/FileOutputStream:close	()V
    //   81: aload_1
    //   82: ifnull +7 -> 89
    //   85: aload_1
    //   86: invokevirtual 162	java/io/FileInputStream:close	()V
    //   89: return
    //   90: aload_1
    //   91: ifnull +7 -> 98
    //   94: aload_1
    //   95: invokevirtual 337	java/io/FileOutputStream:close	()V
    //   98: aload_0
    //   99: ifnull -10 -> 89
    //   102: aload_0
    //   103: invokevirtual 162	java/io/FileInputStream:close	()V
    //   106: return
    //   107: astore_0
    //   108: return
    //   109: astore_0
    //   110: aconst_null
    //   111: astore_1
    //   112: aload 4
    //   114: astore_0
    //   115: aload_1
    //   116: ifnull +7 -> 123
    //   119: aload_1
    //   120: invokevirtual 337	java/io/FileOutputStream:close	()V
    //   123: aload_0
    //   124: ifnull -35 -> 89
    //   127: aload_0
    //   128: invokevirtual 162	java/io/FileInputStream:close	()V
    //   131: return
    //   132: astore_0
    //   133: return
    //   134: astore_3
    //   135: aconst_null
    //   136: astore_1
    //   137: aconst_null
    //   138: astore_0
    //   139: aload_1
    //   140: ifnull +7 -> 147
    //   143: aload_1
    //   144: invokevirtual 337	java/io/FileOutputStream:close	()V
    //   147: aload_0
    //   148: ifnull +7 -> 155
    //   151: aload_0
    //   152: invokevirtual 162	java/io/FileInputStream:close	()V
    //   155: aload_3
    //   156: athrow
    //   157: astore_1
    //   158: goto -60 -> 98
    //   161: astore_0
    //   162: goto -81 -> 81
    //   165: astore_0
    //   166: return
    //   167: astore_1
    //   168: goto -45 -> 123
    //   171: astore_1
    //   172: goto -25 -> 147
    //   175: astore_0
    //   176: goto -21 -> 155
    //   179: astore_3
    //   180: aconst_null
    //   181: astore_0
    //   182: goto -43 -> 139
    //   185: astore_3
    //   186: goto -47 -> 139
    //   189: astore_0
    //   190: aload 4
    //   192: astore_0
    //   193: goto -78 -> 115
    //   196: astore_3
    //   197: goto -82 -> 115
    //   200: astore_0
    //   201: aconst_null
    //   202: astore_0
    //   203: aload_3
    //   204: astore_1
    //   205: goto -132 -> 73
    //   208: astore_0
    //   209: aload_1
    //   210: astore_0
    //   211: aload_3
    //   212: astore_1
    //   213: goto -140 -> 73
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	216	0	paramFile1	File
    //   0	216	1	paramFile2	File
    //   46	10	2	k	int
    //   4	50	3	arrayOfByte	byte[]
    //   66	1	3	localIOException	IOException
    //   68	4	3	localFile	File
    //   134	22	3	localObject1	Object
    //   179	1	3	localObject2	Object
    //   185	1	3	localObject3	Object
    //   196	16	3	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   1	190	4	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   35	41	66	java/io/IOException
    //   41	47	66	java/io/IOException
    //   52	63	66	java/io/IOException
    //   102	106	107	java/io/IOException
    //   5	17	109	java/lang/OutOfMemoryError
    //   17	26	109	java/lang/OutOfMemoryError
    //   127	131	132	java/io/IOException
    //   5	17	134	finally
    //   17	26	134	finally
    //   94	98	157	java/io/IOException
    //   77	81	161	java/io/IOException
    //   85	89	165	java/io/IOException
    //   119	123	167	java/io/IOException
    //   143	147	171	java/io/IOException
    //   151	155	175	java/io/IOException
    //   26	35	179	finally
    //   35	41	185	finally
    //   41	47	185	finally
    //   52	63	185	finally
    //   26	35	189	java/lang/OutOfMemoryError
    //   35	41	196	java/lang/OutOfMemoryError
    //   41	47	196	java/lang/OutOfMemoryError
    //   52	63	196	java/lang/OutOfMemoryError
    //   5	17	200	java/io/IOException
    //   17	26	200	java/io/IOException
    //   26	35	208	java/io/IOException
  }
  
  public static void a(String paramString)
  {
    if ((paramString == null) || (paramString.trim().length() == 0)) {
      return;
    }
    paramString = new File(paramString);
    File[] arrayOfFile = paramString.listFiles();
    if ((arrayOfFile != null) && (arrayOfFile.length > 0))
    {
      int k = 0;
      if (k < arrayOfFile.length)
      {
        if (arrayOfFile[k].isDirectory()) {
          a(arrayOfFile[k].getAbsolutePath());
        }
        for (;;)
        {
          k += 1;
          break;
          arrayOfFile[k].delete();
        }
      }
    }
    paramString.delete();
  }
  
  /* Error */
  public static void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 6
    //   6: invokestatic 244	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   9: ifeq +39 -> 48
    //   12: ldc 12
    //   14: iconst_2
    //   15: new 108	java/lang/StringBuilder
    //   18: dup
    //   19: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   22: ldc_w 350
    //   25: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: aload_0
    //   29: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: ldc_w 352
    //   35: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: aload_1
    //   39: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   45: invokestatic 355	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   48: new 137	java/io/FileInputStream
    //   51: dup
    //   52: aload_0
    //   53: invokespecial 251	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   56: astore_0
    //   57: new 357	java/io/BufferedInputStream
    //   60: dup
    //   61: aload_0
    //   62: invokespecial 360	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   65: astore 4
    //   67: new 362	java/util/zip/ZipInputStream
    //   70: dup
    //   71: aload 4
    //   73: invokespecial 363	java/util/zip/ZipInputStream:<init>	(Ljava/io/InputStream;)V
    //   76: astore 5
    //   78: new 71	java/io/File
    //   81: dup
    //   82: aload_1
    //   83: invokespecial 92	java/io/File:<init>	(Ljava/lang/String;)V
    //   86: invokevirtual 103	java/io/File:mkdirs	()Z
    //   89: pop
    //   90: sipush 8192
    //   93: newarray byte
    //   95: astore 11
    //   97: aconst_null
    //   98: astore 8
    //   100: aload 6
    //   102: astore 7
    //   104: aload 5
    //   106: invokevirtual 367	java/util/zip/ZipInputStream:getNextEntry	()Ljava/util/zip/ZipEntry;
    //   109: astore 6
    //   111: aload 6
    //   113: ifnonnull +52 -> 165
    //   116: aload 5
    //   118: ifnull +8 -> 126
    //   121: aload 5
    //   123: invokevirtual 368	java/util/zip/ZipInputStream:close	()V
    //   126: aload 4
    //   128: ifnull +8 -> 136
    //   131: aload 4
    //   133: invokevirtual 369	java/io/BufferedInputStream:close	()V
    //   136: aload_0
    //   137: ifnull +7 -> 144
    //   140: aload_0
    //   141: invokevirtual 162	java/io/FileInputStream:close	()V
    //   144: aload 8
    //   146: ifnull +8 -> 154
    //   149: aload 8
    //   151: invokevirtual 337	java/io/FileOutputStream:close	()V
    //   154: aload 7
    //   156: ifnull +8 -> 164
    //   159: aload 7
    //   161: invokevirtual 372	java/io/BufferedOutputStream:close	()V
    //   164: return
    //   165: aload 6
    //   167: invokevirtual 375	java/util/zip/ZipEntry:isDirectory	()Z
    //   170: ifne -66 -> 104
    //   173: aload 6
    //   175: invokevirtual 376	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   178: astore 6
    //   180: invokestatic 244	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   183: ifeq +30 -> 213
    //   186: ldc 12
    //   188: iconst_2
    //   189: new 108	java/lang/StringBuilder
    //   192: dup
    //   193: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   196: ldc_w 378
    //   199: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: aload 6
    //   204: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   210: invokestatic 355	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   213: aload 6
    //   215: ifnull -111 -> 104
    //   218: aload 6
    //   220: ldc_w 380
    //   223: invokevirtual 384	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   226: ifne -122 -> 104
    //   229: aload 6
    //   231: getstatic 388	java/io/File:separatorChar	C
    //   234: invokevirtual 392	java/lang/String:lastIndexOf	(I)I
    //   237: istore_3
    //   238: iload_3
    //   239: aload 6
    //   241: invokevirtual 342	java/lang/String:length	()I
    //   244: iconst_1
    //   245: isub
    //   246: if_icmpne +103 -> 349
    //   249: new 394	java/lang/IllegalArgumentException
    //   252: dup
    //   253: new 108	java/lang/StringBuilder
    //   256: dup
    //   257: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   260: ldc_w 396
    //   263: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   266: aload 6
    //   268: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   271: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   274: invokespecial 397	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   277: athrow
    //   278: astore 9
    //   280: aload 5
    //   282: astore_1
    //   283: aload_0
    //   284: astore 6
    //   286: aload 4
    //   288: astore 5
    //   290: aload_1
    //   291: astore 4
    //   293: aload 8
    //   295: astore_1
    //   296: aload 9
    //   298: astore_0
    //   299: aload 4
    //   301: ifnull +8 -> 309
    //   304: aload 4
    //   306: invokevirtual 368	java/util/zip/ZipInputStream:close	()V
    //   309: aload 5
    //   311: ifnull +8 -> 319
    //   314: aload 5
    //   316: invokevirtual 369	java/io/BufferedInputStream:close	()V
    //   319: aload 6
    //   321: ifnull +8 -> 329
    //   324: aload 6
    //   326: invokevirtual 162	java/io/FileInputStream:close	()V
    //   329: aload_1
    //   330: ifnull +7 -> 337
    //   333: aload_1
    //   334: invokevirtual 337	java/io/FileOutputStream:close	()V
    //   337: aload 7
    //   339: ifnull +8 -> 347
    //   342: aload 7
    //   344: invokevirtual 372	java/io/BufferedOutputStream:close	()V
    //   347: aload_0
    //   348: athrow
    //   349: iload_3
    //   350: ifgt +199 -> 549
    //   353: iload_3
    //   354: ifge +181 -> 535
    //   357: aload_1
    //   358: astore 9
    //   360: aload 6
    //   362: astore 10
    //   364: iload_2
    //   365: ifeq +29 -> 394
    //   368: aload 6
    //   370: ldc_w 399
    //   373: invokevirtual 401	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   376: istore_3
    //   377: aload 6
    //   379: astore 10
    //   381: iload_3
    //   382: ifle +12 -> 394
    //   385: aload 6
    //   387: iconst_0
    //   388: iload_3
    //   389: invokevirtual 405	java/lang/String:substring	(II)Ljava/lang/String;
    //   392: astore 10
    //   394: new 71	java/io/File
    //   397: dup
    //   398: aload 9
    //   400: aload 10
    //   402: invokespecial 408	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   405: astore 6
    //   407: aload 6
    //   409: invokevirtual 169	java/io/File:getParentFile	()Ljava/io/File;
    //   412: invokevirtual 96	java/io/File:exists	()Z
    //   415: ifne +12 -> 427
    //   418: aload 6
    //   420: invokevirtual 169	java/io/File:getParentFile	()Ljava/io/File;
    //   423: invokevirtual 103	java/io/File:mkdirs	()Z
    //   426: pop
    //   427: aload 6
    //   429: invokevirtual 96	java/io/File:exists	()Z
    //   432: ifeq +9 -> 441
    //   435: aload 6
    //   437: invokevirtual 132	java/io/File:delete	()Z
    //   440: pop
    //   441: aload 6
    //   443: invokevirtual 126	java/io/File:createNewFile	()Z
    //   446: pop
    //   447: new 146	java/io/FileOutputStream
    //   450: dup
    //   451: aload 6
    //   453: invokespecial 147	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   456: astore 6
    //   458: new 371	java/io/BufferedOutputStream
    //   461: dup
    //   462: aload 6
    //   464: aload 11
    //   466: arraylength
    //   467: invokespecial 411	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;I)V
    //   470: astore 8
    //   472: aload 5
    //   474: aload 11
    //   476: iconst_0
    //   477: aload 11
    //   479: arraylength
    //   480: invokevirtual 414	java/util/zip/ZipInputStream:read	([BII)I
    //   483: istore_3
    //   484: iload_3
    //   485: iconst_m1
    //   486: if_icmpeq +148 -> 634
    //   489: aload 8
    //   491: aload 11
    //   493: iconst_0
    //   494: iload_3
    //   495: invokevirtual 415	java/io/BufferedOutputStream:write	([BII)V
    //   498: goto -26 -> 472
    //   501: astore 9
    //   503: aload 8
    //   505: astore 7
    //   507: aload 6
    //   509: astore_1
    //   510: aload 4
    //   512: astore 6
    //   514: aload_0
    //   515: astore 8
    //   517: aload 9
    //   519: astore_0
    //   520: aload 5
    //   522: astore 4
    //   524: aload 6
    //   526: astore 5
    //   528: aload 8
    //   530: astore 6
    //   532: goto -233 -> 299
    //   535: aload 6
    //   537: iconst_1
    //   538: invokevirtual 417	java/lang/String:substring	(I)Ljava/lang/String;
    //   541: astore 6
    //   543: aload_1
    //   544: astore 9
    //   546: goto -186 -> 360
    //   549: aload 6
    //   551: iconst_0
    //   552: iload_3
    //   553: invokevirtual 405	java/lang/String:substring	(II)Ljava/lang/String;
    //   556: astore 9
    //   558: aload 9
    //   560: iconst_0
    //   561: invokevirtual 421	java/lang/String:charAt	(I)C
    //   564: getstatic 388	java/io/File:separatorChar	C
    //   567: if_icmpne +37 -> 604
    //   570: new 108	java/lang/StringBuilder
    //   573: dup
    //   574: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   577: aload_1
    //   578: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   581: aload 9
    //   583: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   586: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   589: astore 9
    //   591: aload 6
    //   593: iload_3
    //   594: iconst_1
    //   595: iadd
    //   596: invokevirtual 417	java/lang/String:substring	(I)Ljava/lang/String;
    //   599: astore 6
    //   601: goto -241 -> 360
    //   604: new 108	java/lang/StringBuilder
    //   607: dup
    //   608: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   611: aload_1
    //   612: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   615: getstatic 388	java/io/File:separatorChar	C
    //   618: invokevirtual 424	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   621: aload 9
    //   623: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   626: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   629: astore 9
    //   631: goto -40 -> 591
    //   634: aload 8
    //   636: invokevirtual 425	java/io/BufferedOutputStream:flush	()V
    //   639: aload 8
    //   641: invokevirtual 372	java/io/BufferedOutputStream:close	()V
    //   644: aload 6
    //   646: invokevirtual 337	java/io/FileOutputStream:close	()V
    //   649: aload 8
    //   651: astore 7
    //   653: aload 6
    //   655: astore 8
    //   657: goto -553 -> 104
    //   660: astore_1
    //   661: goto -535 -> 126
    //   664: astore_1
    //   665: goto -529 -> 136
    //   668: astore_0
    //   669: goto -525 -> 144
    //   672: astore_0
    //   673: goto -519 -> 154
    //   676: astore_0
    //   677: return
    //   678: astore 4
    //   680: goto -371 -> 309
    //   683: astore 4
    //   685: goto -366 -> 319
    //   688: astore 4
    //   690: goto -361 -> 329
    //   693: astore_1
    //   694: goto -357 -> 337
    //   697: astore_1
    //   698: goto -351 -> 347
    //   701: astore_0
    //   702: aconst_null
    //   703: astore_1
    //   704: aconst_null
    //   705: astore 4
    //   707: aconst_null
    //   708: astore 5
    //   710: aconst_null
    //   711: astore 6
    //   713: goto -414 -> 299
    //   716: astore 8
    //   718: aconst_null
    //   719: astore_1
    //   720: aconst_null
    //   721: astore 4
    //   723: aconst_null
    //   724: astore 5
    //   726: aload_0
    //   727: astore 6
    //   729: aload 8
    //   731: astore_0
    //   732: goto -433 -> 299
    //   735: astore 9
    //   737: aconst_null
    //   738: astore_1
    //   739: aconst_null
    //   740: astore 8
    //   742: aload 4
    //   744: astore 5
    //   746: aload_0
    //   747: astore 6
    //   749: aload 9
    //   751: astore_0
    //   752: aload 8
    //   754: astore 4
    //   756: goto -457 -> 299
    //   759: astore 9
    //   761: aconst_null
    //   762: astore_1
    //   763: aload 4
    //   765: astore 6
    //   767: aload_0
    //   768: astore 8
    //   770: aload 9
    //   772: astore_0
    //   773: aload 5
    //   775: astore 4
    //   777: aload 6
    //   779: astore 5
    //   781: aload 8
    //   783: astore 6
    //   785: goto -486 -> 299
    //   788: astore 9
    //   790: aload 6
    //   792: astore_1
    //   793: aload 4
    //   795: astore 6
    //   797: aload_0
    //   798: astore 8
    //   800: aload 9
    //   802: astore_0
    //   803: aload 5
    //   805: astore 4
    //   807: aload 6
    //   809: astore 5
    //   811: aload 8
    //   813: astore 6
    //   815: goto -516 -> 299
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	818	0	paramString1	String
    //   0	818	1	paramString2	String
    //   0	818	2	paramBoolean	boolean
    //   237	359	3	k	int
    //   65	458	4	localObject1	Object
    //   678	1	4	localIOException1	IOException
    //   683	1	4	localIOException2	IOException
    //   688	1	4	localIOException3	IOException
    //   705	101	4	localObject2	Object
    //   76	734	5	localObject3	Object
    //   4	810	6	localObject4	Object
    //   1	651	7	localObject5	Object
    //   98	558	8	localObject6	Object
    //   716	14	8	localObject7	Object
    //   740	72	8	str1	String
    //   278	19	9	localObject8	Object
    //   358	41	9	str2	String
    //   501	17	9	localObject9	Object
    //   544	86	9	str3	String
    //   735	15	9	localObject10	Object
    //   759	12	9	localObject11	Object
    //   788	13	9	localObject12	Object
    //   362	39	10	localObject13	Object
    //   95	397	11	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   104	111	278	finally
    //   165	213	278	finally
    //   218	278	278	finally
    //   368	377	278	finally
    //   385	394	278	finally
    //   394	427	278	finally
    //   427	441	278	finally
    //   441	458	278	finally
    //   535	543	278	finally
    //   549	591	278	finally
    //   591	601	278	finally
    //   604	631	278	finally
    //   472	484	501	finally
    //   489	498	501	finally
    //   634	649	501	finally
    //   121	126	660	java/io/IOException
    //   131	136	664	java/io/IOException
    //   140	144	668	java/io/IOException
    //   149	154	672	java/io/IOException
    //   159	164	676	java/io/IOException
    //   304	309	678	java/io/IOException
    //   314	319	683	java/io/IOException
    //   324	329	688	java/io/IOException
    //   333	337	693	java/io/IOException
    //   342	347	697	java/io/IOException
    //   6	48	701	finally
    //   48	57	701	finally
    //   57	67	716	finally
    //   67	78	735	finally
    //   78	97	759	finally
    //   458	472	788	finally
  }
  
  public static void a(String paramString, boolean paramBoolean)
  {
    if (paramString == null) {}
    do
    {
      File[] arrayOfFile;
      do
      {
        do
        {
          return;
          paramString = new File(paramString);
        } while ((paramString == null) || (!paramString.exists()));
        if (paramString.isFile())
        {
          paramString.delete();
          return;
        }
        arrayOfFile = paramString.listFiles();
      } while (arrayOfFile == null);
      int m = arrayOfFile.length;
      int k = 0;
      while (k < m)
      {
        a(arrayOfFile[k].getAbsolutePath(), paramBoolean);
        k += 1;
      }
    } while (paramBoolean);
    paramString.delete();
  }
  
  public static boolean a()
  {
    Object localObject = (SplashActivity)SplashActivity.a();
    if (((SplashActivity)localObject).checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") != 0) {
      ((SplashActivity)localObject).permissionManager.permissions(new PermissionItem[] { PermissionItem.init("android.permission.WRITE_EXTERNAL_STORAGE", 300) }).request(new krl((SplashActivity)localObject));
    }
    localObject = Environment.getExternalStorageDirectory();
    if ((((File)localObject).exists()) && (((File)localObject).canWrite())) {}
    for (int k = 1; (Environment.getExternalStorageState().equals("mounted")) && (k != 0); k = 0) {
      return true;
    }
    return false;
  }
  
  public static boolean a(Context paramContext)
  {
    return a(paramContext, true);
  }
  
  /* Error */
  public static boolean a(Context paramContext, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc_w 474
    //   3: invokestatic 472	android/os/Environment:getExternalStorageState	()Ljava/lang/String;
    //   6: invokevirtual 477	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   9: ifeq +41 -> 50
    //   12: new 71	java/io/File
    //   15: dup
    //   16: getstatic 486	com/tencent/mobileqq/app/AppConstants:aG	Ljava/lang/String;
    //   19: invokespecial 92	java/io/File:<init>	(Ljava/lang/String;)V
    //   22: astore 4
    //   24: new 71	java/io/File
    //   27: dup
    //   28: aload 4
    //   30: ldc_w 488
    //   33: invokespecial 491	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   36: astore 4
    //   38: aload 4
    //   40: invokevirtual 96	java/io/File:exists	()Z
    //   43: ifeq +18 -> 61
    //   46: iconst_1
    //   47: istore_3
    //   48: iload_3
    //   49: ireturn
    //   50: getstatic 496	com/tencent/common/app/BaseApplicationImpl:a	Lcom/tencent/common/app/BaseApplicationImpl;
    //   53: invokevirtual 499	com/tencent/common/app/BaseApplicationImpl:getCacheDir	()Ljava/io/File;
    //   56: astore 4
    //   58: goto -34 -> 24
    //   61: aload 4
    //   63: invokevirtual 103	java/io/File:mkdirs	()Z
    //   66: istore_2
    //   67: getstatic 47	com/tencent/mobileqq/utils/FileUtils:jdField_a_of_type_Boolean	Z
    //   70: ifne +7 -> 77
    //   73: iconst_1
    //   74: putstatic 47	com/tencent/mobileqq/utils/FileUtils:jdField_a_of_type_Boolean	Z
    //   77: iload_2
    //   78: ifne +21 -> 99
    //   81: invokestatic 501	com/tencent/mobileqq/utils/FileUtils:b	()Z
    //   84: ifne +49 -> 133
    //   87: aload_0
    //   88: ldc_w 502
    //   91: iconst_1
    //   92: invokestatic 507	com/tencent/mobileqq/widget/QQToast:a	(Landroid/content/Context;II)Lcom/tencent/mobileqq/widget/QQToast;
    //   95: invokevirtual 510	com/tencent/mobileqq/widget/QQToast:a	()Landroid/widget/Toast;
    //   98: pop
    //   99: iload_2
    //   100: istore_3
    //   101: iload_1
    //   102: ifeq -54 -> 48
    //   105: iload_2
    //   106: ifne +11 -> 117
    //   109: iload_2
    //   110: istore_3
    //   111: getstatic 47	com/tencent/mobileqq/utils/FileUtils:jdField_a_of_type_Boolean	Z
    //   114: ifeq -66 -> 48
    //   117: iload_2
    //   118: invokestatic 515	com/tencent/mobileqq/pic/PicReporter:a	(Z)V
    //   121: iload_2
    //   122: istore_3
    //   123: iload_2
    //   124: ifne -76 -> 48
    //   127: iconst_0
    //   128: putstatic 47	com/tencent/mobileqq/utils/FileUtils:jdField_a_of_type_Boolean	Z
    //   131: iload_2
    //   132: ireturn
    //   133: invokestatic 517	com/tencent/mobileqq/utils/FileUtils:c	()Z
    //   136: ifeq +9 -> 145
    //   139: invokestatic 519	com/tencent/mobileqq/utils/FileUtils:d	()Z
    //   142: ifne -43 -> 99
    //   145: aload_0
    //   146: ldc_w 520
    //   149: iconst_1
    //   150: invokestatic 507	com/tencent/mobileqq/widget/QQToast:a	(Landroid/content/Context;II)Lcom/tencent/mobileqq/widget/QQToast;
    //   153: invokevirtual 510	com/tencent/mobileqq/widget/QQToast:a	()Landroid/widget/Toast;
    //   156: pop
    //   157: goto -58 -> 99
    //   160: astore 4
    //   162: invokestatic 501	com/tencent/mobileqq/utils/FileUtils:b	()Z
    //   165: ifne +35 -> 200
    //   168: aload_0
    //   169: ldc_w 502
    //   172: iconst_1
    //   173: invokestatic 507	com/tencent/mobileqq/widget/QQToast:a	(Landroid/content/Context;II)Lcom/tencent/mobileqq/widget/QQToast;
    //   176: invokevirtual 510	com/tencent/mobileqq/widget/QQToast:a	()Landroid/widget/Toast;
    //   179: pop
    //   180: iload_1
    //   181: ifeq +133 -> 314
    //   184: getstatic 47	com/tencent/mobileqq/utils/FileUtils:jdField_a_of_type_Boolean	Z
    //   187: ifeq +127 -> 314
    //   190: iconst_0
    //   191: invokestatic 515	com/tencent/mobileqq/pic/PicReporter:a	(Z)V
    //   194: iconst_0
    //   195: putstatic 47	com/tencent/mobileqq/utils/FileUtils:jdField_a_of_type_Boolean	Z
    //   198: iconst_0
    //   199: ireturn
    //   200: invokestatic 517	com/tencent/mobileqq/utils/FileUtils:c	()Z
    //   203: ifeq +9 -> 212
    //   206: invokestatic 519	com/tencent/mobileqq/utils/FileUtils:d	()Z
    //   209: ifne -29 -> 180
    //   212: aload_0
    //   213: ldc_w 520
    //   216: iconst_1
    //   217: invokestatic 507	com/tencent/mobileqq/widget/QQToast:a	(Landroid/content/Context;II)Lcom/tencent/mobileqq/widget/QQToast;
    //   220: invokevirtual 510	com/tencent/mobileqq/widget/QQToast:a	()Landroid/widget/Toast;
    //   223: pop
    //   224: goto -44 -> 180
    //   227: astore 4
    //   229: iconst_0
    //   230: istore_2
    //   231: iload_2
    //   232: ifne +21 -> 253
    //   235: invokestatic 501	com/tencent/mobileqq/utils/FileUtils:b	()Z
    //   238: ifne +44 -> 282
    //   241: aload_0
    //   242: ldc_w 502
    //   245: iconst_1
    //   246: invokestatic 507	com/tencent/mobileqq/widget/QQToast:a	(Landroid/content/Context;II)Lcom/tencent/mobileqq/widget/QQToast;
    //   249: invokevirtual 510	com/tencent/mobileqq/widget/QQToast:a	()Landroid/widget/Toast;
    //   252: pop
    //   253: iload_1
    //   254: ifeq +25 -> 279
    //   257: iload_2
    //   258: ifne +9 -> 267
    //   261: getstatic 47	com/tencent/mobileqq/utils/FileUtils:jdField_a_of_type_Boolean	Z
    //   264: ifeq +15 -> 279
    //   267: iload_2
    //   268: invokestatic 515	com/tencent/mobileqq/pic/PicReporter:a	(Z)V
    //   271: iload_2
    //   272: ifne +7 -> 279
    //   275: iconst_0
    //   276: putstatic 47	com/tencent/mobileqq/utils/FileUtils:jdField_a_of_type_Boolean	Z
    //   279: aload 4
    //   281: athrow
    //   282: invokestatic 517	com/tencent/mobileqq/utils/FileUtils:c	()Z
    //   285: ifeq +9 -> 294
    //   288: invokestatic 519	com/tencent/mobileqq/utils/FileUtils:d	()Z
    //   291: ifne -38 -> 253
    //   294: aload_0
    //   295: ldc_w 520
    //   298: iconst_1
    //   299: invokestatic 507	com/tencent/mobileqq/widget/QQToast:a	(Landroid/content/Context;II)Lcom/tencent/mobileqq/widget/QQToast;
    //   302: invokevirtual 510	com/tencent/mobileqq/widget/QQToast:a	()Landroid/widget/Toast;
    //   305: pop
    //   306: goto -53 -> 253
    //   309: astore 4
    //   311: goto -80 -> 231
    //   314: iconst_0
    //   315: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	316	0	paramContext	Context
    //   0	316	1	paramBoolean	boolean
    //   66	206	2	bool1	boolean
    //   47	76	3	bool2	boolean
    //   22	40	4	localFile	File
    //   160	1	4	localException	Exception
    //   227	53	4	localObject1	Object
    //   309	1	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   61	67	160	java/lang/Exception
    //   67	77	160	java/lang/Exception
    //   61	67	227	finally
    //   67	77	309	finally
  }
  
  public static boolean a(File paramFile1, File paramFile2)
  {
    boolean bool1 = true;
    if (paramFile2.exists()) {
      bool1 = paramFile2.delete();
    }
    boolean bool2 = bool1;
    if (bool1) {
      bool2 = paramFile1.renameTo(paramFile2);
    }
    return bool2;
  }
  
  public static boolean a(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return false;
      paramString = new File(paramString);
    } while ((paramString == null) || (!paramString.exists()));
    return true;
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    boolean bool = false;
    paramString1 = new File(paramString1);
    if (paramString1.exists()) {}
    try
    {
      a(paramString1, a(paramString2));
      paramString1.delete();
      bool = true;
      return bool;
    }
    catch (IOException paramString1) {}
    return false;
  }
  
  public static boolean a(String paramString1, String paramString2, String paramString3)
  {
    File localFile = new File(paramString1);
    String str = paramString2;
    if (paramString2 != null) {
      str = paramString2.replaceAll("[\\\\/*?<>:\"|]", "");
    }
    paramString1 = new File(paramString1 + str);
    bool1 = true;
    if (!localFile.exists()) {
      bool1 = localFile.mkdirs();
    }
    boolean bool3 = bool1;
    if (localFile.exists())
    {
      bool2 = bool1;
      if (paramString1.exists()) {}
    }
    try
    {
      paramString1.createNewFile();
      bool2 = bool1;
      return false;
    }
    catch (IOException paramString2)
    {
      try
      {
        for (;;)
        {
          paramString1 = new FileOutputStream(paramString1, false);
          try
          {
            paramString2 = paramString3 + "\r\n";
            bool1 = bool2;
            if (paramString1 != null)
            {
              paramString1.write(paramString2.getBytes());
              bool1 = bool2;
            }
          }
          catch (IOException paramString2)
          {
            for (;;)
            {
              bool1 = false;
            }
          }
          bool2 = bool1;
          if (paramString1 != null) {}
          try
          {
            paramString1.flush();
            bool2 = bool1;
          }
          catch (IOException paramString2)
          {
            for (;;)
            {
              bool2 = false;
            }
          }
          bool3 = bool2;
          if (paramString1 != null) {}
          try
          {
            paramString1.close();
            bool3 = bool2;
            return bool3;
          }
          catch (IOException paramString1) {}
          paramString2 = paramString2;
          bool2 = false;
        }
      }
      catch (FileNotFoundException paramString1)
      {
        for (;;)
        {
          bool2 = false;
          paramString1 = null;
        }
      }
    }
  }
  
  /* Error */
  public static boolean a(String paramString, StringBuffer paramStringBuffer, java.io.InputStream paramInputStream)
  {
    // Byte code:
    //   0: new 71	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 92	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore 9
    //   10: aload_1
    //   11: invokevirtual 549	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   14: astore 7
    //   16: sipush 1024
    //   19: newarray byte
    //   21: astore 8
    //   23: aload_1
    //   24: ifnull +18 -> 42
    //   27: aload_1
    //   28: invokevirtual 549	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   31: ldc_w 531
    //   34: ldc_w 256
    //   37: invokevirtual 534	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   40: astore 7
    //   42: new 71	java/io/File
    //   45: dup
    //   46: new 108	java/lang/StringBuilder
    //   49: dup
    //   50: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   53: aload_0
    //   54: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: aload 7
    //   59: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   65: invokespecial 92	java/io/File:<init>	(Ljava/lang/String;)V
    //   68: astore_0
    //   69: iconst_1
    //   70: istore 4
    //   72: aload 9
    //   74: invokevirtual 96	java/io/File:exists	()Z
    //   77: ifne +25 -> 102
    //   80: aload 9
    //   82: invokevirtual 103	java/io/File:mkdirs	()Z
    //   85: istore 5
    //   87: iload 5
    //   89: istore 4
    //   91: iload 5
    //   93: ifne +9 -> 102
    //   96: iconst_0
    //   97: istore 5
    //   99: iload 5
    //   101: ireturn
    //   102: iload 4
    //   104: istore 5
    //   106: aload 9
    //   108: invokevirtual 96	java/io/File:exists	()Z
    //   111: ifeq -12 -> 99
    //   114: aload_0
    //   115: invokevirtual 96	java/io/File:exists	()Z
    //   118: ifne +8 -> 126
    //   121: aload_0
    //   122: invokevirtual 126	java/io/File:createNewFile	()Z
    //   125: pop
    //   126: new 146	java/io/FileOutputStream
    //   129: dup
    //   130: aload_0
    //   131: iconst_0
    //   132: invokespecial 537	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   135: astore_0
    //   136: aload_2
    //   137: aload 8
    //   139: invokevirtual 552	java/io/InputStream:read	([B)I
    //   142: istore_3
    //   143: iload_3
    //   144: iconst_m1
    //   145: if_icmpeq +23 -> 168
    //   148: aload_0
    //   149: aload 8
    //   151: iconst_0
    //   152: iload_3
    //   153: invokevirtual 333	java/io/FileOutputStream:write	([BII)V
    //   156: goto -20 -> 136
    //   159: astore_0
    //   160: iconst_0
    //   161: ireturn
    //   162: astore_0
    //   163: iconst_0
    //   164: ireturn
    //   165: astore_0
    //   166: iconst_0
    //   167: ireturn
    //   168: iload 4
    //   170: istore 6
    //   172: aload_0
    //   173: ifnull +11 -> 184
    //   176: aload_0
    //   177: invokevirtual 336	java/io/FileOutputStream:flush	()V
    //   180: iload 4
    //   182: istore 6
    //   184: iload 6
    //   186: istore 5
    //   188: aload_0
    //   189: ifnull -90 -> 99
    //   192: aload_0
    //   193: invokevirtual 337	java/io/FileOutputStream:close	()V
    //   196: iload 6
    //   198: ireturn
    //   199: astore_0
    //   200: iconst_0
    //   201: ireturn
    //   202: astore_1
    //   203: iconst_0
    //   204: istore 6
    //   206: goto -22 -> 184
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	209	0	paramString	String
    //   0	209	1	paramStringBuffer	StringBuffer
    //   0	209	2	paramInputStream	java.io.InputStream
    //   142	11	3	k	int
    //   70	111	4	bool1	boolean
    //   85	102	5	bool2	boolean
    //   170	35	6	bool3	boolean
    //   14	44	7	str	String
    //   21	129	8	arrayOfByte	byte[]
    //   8	99	9	localFile	File
    // Exception table:
    //   from	to	target	type
    //   136	143	159	java/io/IOException
    //   148	156	159	java/io/IOException
    //   121	126	162	java/io/IOException
    //   126	136	165	java/io/FileNotFoundException
    //   192	196	199	java/io/IOException
    //   176	180	202	java/io/IOException
  }
  
  public static boolean a(String paramString1, StringBuffer paramStringBuffer, String paramString2)
  {
    File localFile2 = new File(paramString1);
    File localFile1 = new File(paramString1 + paramStringBuffer.toString());
    boolean bool = true;
    if (!localFile2.exists()) {
      bool = localFile2.mkdirs();
    }
    if ((localFile2.exists()) && (localFile1.exists()))
    {
      paramStringBuffer.insert(paramStringBuffer.indexOf(paramString2), "(0)");
      for (paramString2 = localFile1; paramString2.exists(); paramString2 = new File(paramString1 + paramStringBuffer))
      {
        int k = paramStringBuffer.lastIndexOf("(") + 1;
        int m = paramStringBuffer.lastIndexOf(")");
        paramStringBuffer.replace(k, m, String.valueOf(Integer.parseInt(paramStringBuffer.substring(k, m)) + 1));
      }
    }
    return bool;
  }
  
  /* Error */
  public static boolean a(String paramString, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: iload 4
    //   5: istore_3
    //   6: aload_0
    //   7: ifnull +28 -> 35
    //   10: iload 4
    //   12: istore_3
    //   13: aload_0
    //   14: invokevirtual 342	java/lang/String:length	()I
    //   17: ifeq +18 -> 35
    //   20: iload 4
    //   22: istore_3
    //   23: aload_1
    //   24: ifnull +11 -> 35
    //   27: aload_1
    //   28: arraylength
    //   29: ifne +8 -> 37
    //   32: iload 4
    //   34: istore_3
    //   35: iload_3
    //   36: ireturn
    //   37: aload_0
    //   38: astore 5
    //   40: iload_2
    //   41: ifeq +58 -> 99
    //   44: new 581	java/text/SimpleDateFormat
    //   47: dup
    //   48: ldc_w 583
    //   51: getstatic 589	java/util/Locale:CHINA	Ljava/util/Locale;
    //   54: invokespecial 592	java/text/SimpleDateFormat:<init>	(Ljava/lang/String;Ljava/util/Locale;)V
    //   57: new 594	java/util/Date
    //   60: dup
    //   61: invokestatic 599	java/lang/System:currentTimeMillis	()J
    //   64: invokespecial 602	java/util/Date:<init>	(J)V
    //   67: invokevirtual 605	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   70: astore 5
    //   72: new 108	java/lang/StringBuilder
    //   75: dup
    //   76: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   79: aload_0
    //   80: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: ldc_w 399
    //   86: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: aload 5
    //   91: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   97: astore 5
    //   99: new 71	java/io/File
    //   102: dup
    //   103: aload 5
    //   105: invokespecial 92	java/io/File:<init>	(Ljava/lang/String;)V
    //   108: astore 8
    //   110: aconst_null
    //   111: astore 7
    //   113: aconst_null
    //   114: astore 5
    //   116: aconst_null
    //   117: astore 6
    //   119: aload 5
    //   121: astore_0
    //   122: aload 8
    //   124: invokevirtual 169	java/io/File:getParentFile	()Ljava/io/File;
    //   127: astore 9
    //   129: aload 5
    //   131: astore_0
    //   132: aload 9
    //   134: invokevirtual 96	java/io/File:exists	()Z
    //   137: ifne +12 -> 149
    //   140: aload 5
    //   142: astore_0
    //   143: aload 9
    //   145: invokevirtual 103	java/io/File:mkdirs	()Z
    //   148: pop
    //   149: aload 5
    //   151: astore_0
    //   152: aload 8
    //   154: invokevirtual 96	java/io/File:exists	()Z
    //   157: ifeq +12 -> 169
    //   160: aload 5
    //   162: astore_0
    //   163: aload 8
    //   165: invokevirtual 132	java/io/File:delete	()Z
    //   168: pop
    //   169: aload 5
    //   171: astore_0
    //   172: aload 8
    //   174: invokevirtual 126	java/io/File:createNewFile	()Z
    //   177: pop
    //   178: aload 5
    //   180: astore_0
    //   181: new 146	java/io/FileOutputStream
    //   184: dup
    //   185: aload 8
    //   187: invokespecial 147	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   190: astore 5
    //   192: aload 5
    //   194: aload_1
    //   195: invokevirtual 545	java/io/FileOutputStream:write	([B)V
    //   198: aload 5
    //   200: invokevirtual 336	java/io/FileOutputStream:flush	()V
    //   203: iconst_1
    //   204: istore_3
    //   205: aload 5
    //   207: ifnull -172 -> 35
    //   210: aload 5
    //   212: invokevirtual 337	java/io/FileOutputStream:close	()V
    //   215: iconst_1
    //   216: ireturn
    //   217: astore_0
    //   218: aload_0
    //   219: invokevirtual 332	java/lang/Exception:printStackTrace	()V
    //   222: iconst_1
    //   223: ireturn
    //   224: astore 5
    //   226: aload 6
    //   228: astore_1
    //   229: aload_1
    //   230: astore_0
    //   231: aload 5
    //   233: invokevirtual 259	java/io/FileNotFoundException:printStackTrace	()V
    //   236: iload 4
    //   238: istore_3
    //   239: aload_1
    //   240: ifnull -205 -> 35
    //   243: aload_1
    //   244: invokevirtual 337	java/io/FileOutputStream:close	()V
    //   247: iconst_0
    //   248: ireturn
    //   249: astore_0
    //   250: aload_0
    //   251: invokevirtual 332	java/lang/Exception:printStackTrace	()V
    //   254: iconst_0
    //   255: ireturn
    //   256: astore 5
    //   258: aload 7
    //   260: astore_1
    //   261: aload_1
    //   262: astore_0
    //   263: aload 5
    //   265: invokevirtual 260	java/io/IOException:printStackTrace	()V
    //   268: iload 4
    //   270: istore_3
    //   271: aload_1
    //   272: ifnull -237 -> 35
    //   275: aload_1
    //   276: invokevirtual 337	java/io/FileOutputStream:close	()V
    //   279: iconst_0
    //   280: ireturn
    //   281: astore_0
    //   282: aload_0
    //   283: invokevirtual 332	java/lang/Exception:printStackTrace	()V
    //   286: iconst_0
    //   287: ireturn
    //   288: astore 5
    //   290: aload_0
    //   291: astore_1
    //   292: aload 5
    //   294: astore_0
    //   295: aload_1
    //   296: ifnull +7 -> 303
    //   299: aload_1
    //   300: invokevirtual 337	java/io/FileOutputStream:close	()V
    //   303: aload_0
    //   304: athrow
    //   305: astore_1
    //   306: aload_1
    //   307: invokevirtual 332	java/lang/Exception:printStackTrace	()V
    //   310: goto -7 -> 303
    //   313: astore_0
    //   314: aload 5
    //   316: astore_1
    //   317: goto -22 -> 295
    //   320: astore_0
    //   321: aload 5
    //   323: astore_1
    //   324: aload_0
    //   325: astore 5
    //   327: goto -66 -> 261
    //   330: astore_0
    //   331: aload 5
    //   333: astore_1
    //   334: aload_0
    //   335: astore 5
    //   337: goto -108 -> 229
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	340	0	paramString	String
    //   0	340	1	paramArrayOfByte	byte[]
    //   0	340	2	paramBoolean	boolean
    //   5	266	3	bool1	boolean
    //   1	268	4	bool2	boolean
    //   38	173	5	localObject1	Object
    //   224	8	5	localFileNotFoundException	FileNotFoundException
    //   256	8	5	localIOException	IOException
    //   288	34	5	localObject2	Object
    //   325	11	5	str	String
    //   117	110	6	localObject3	Object
    //   111	148	7	localObject4	Object
    //   108	78	8	localFile1	File
    //   127	17	9	localFile2	File
    // Exception table:
    //   from	to	target	type
    //   210	215	217	java/lang/Exception
    //   122	129	224	java/io/FileNotFoundException
    //   132	140	224	java/io/FileNotFoundException
    //   143	149	224	java/io/FileNotFoundException
    //   152	160	224	java/io/FileNotFoundException
    //   163	169	224	java/io/FileNotFoundException
    //   172	178	224	java/io/FileNotFoundException
    //   181	192	224	java/io/FileNotFoundException
    //   243	247	249	java/lang/Exception
    //   122	129	256	java/io/IOException
    //   132	140	256	java/io/IOException
    //   143	149	256	java/io/IOException
    //   152	160	256	java/io/IOException
    //   163	169	256	java/io/IOException
    //   172	178	256	java/io/IOException
    //   181	192	256	java/io/IOException
    //   275	279	281	java/lang/Exception
    //   122	129	288	finally
    //   132	140	288	finally
    //   143	149	288	finally
    //   152	160	288	finally
    //   163	169	288	finally
    //   172	178	288	finally
    //   181	192	288	finally
    //   231	236	288	finally
    //   263	268	288	finally
    //   299	303	305	java/lang/Exception
    //   192	203	313	finally
    //   192	203	320	java/io/IOException
    //   192	203	330	java/io/FileNotFoundException
  }
  
  /* Error */
  public static byte[] a(File paramFile)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 96	java/io/File:exists	()Z
    //   4: ifne +5 -> 9
    //   7: aconst_null
    //   8: areturn
    //   9: new 137	java/io/FileInputStream
    //   12: dup
    //   13: aload_0
    //   14: invokespecial 140	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   17: astore 5
    //   19: aload_0
    //   20: invokevirtual 221	java/io/File:length	()J
    //   23: lstore_3
    //   24: lload_3
    //   25: ldc2_w 607
    //   28: lcmp
    //   29: ifle +37 -> 66
    //   32: invokestatic 244	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   35: ifeq +12 -> 47
    //   38: ldc 12
    //   40: iconst_2
    //   41: ldc_w 610
    //   44: invokestatic 355	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   47: aload 5
    //   49: ifnull -42 -> 7
    //   52: aload 5
    //   54: invokevirtual 611	java/io/InputStream:close	()V
    //   57: aconst_null
    //   58: areturn
    //   59: astore_0
    //   60: aload_0
    //   61: invokevirtual 332	java/lang/Exception:printStackTrace	()V
    //   64: aconst_null
    //   65: areturn
    //   66: lload_3
    //   67: l2i
    //   68: istore_1
    //   69: iload_1
    //   70: newarray byte
    //   72: astore 6
    //   74: iconst_0
    //   75: istore_1
    //   76: iload_1
    //   77: aload 6
    //   79: arraylength
    //   80: if_icmpge +28 -> 108
    //   83: aload 5
    //   85: aload 6
    //   87: iload_1
    //   88: aload 6
    //   90: arraylength
    //   91: iload_1
    //   92: isub
    //   93: invokevirtual 612	java/io/InputStream:read	([BII)I
    //   96: istore_2
    //   97: iload_2
    //   98: iflt +10 -> 108
    //   101: iload_1
    //   102: iload_2
    //   103: iadd
    //   104: istore_1
    //   105: goto -29 -> 76
    //   108: iload_1
    //   109: aload 6
    //   111: arraylength
    //   112: if_icmpge +35 -> 147
    //   115: invokestatic 244	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   118: ifeq +29 -> 147
    //   121: ldc 12
    //   123: iconst_2
    //   124: new 108	java/lang/StringBuilder
    //   127: dup
    //   128: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   131: ldc_w 614
    //   134: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: aload_0
    //   138: invokevirtual 578	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   141: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   144: invokestatic 355	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   147: aload 5
    //   149: ifnull +8 -> 157
    //   152: aload 5
    //   154: invokevirtual 611	java/io/InputStream:close	()V
    //   157: aload 6
    //   159: areturn
    //   160: astore_0
    //   161: aload_0
    //   162: invokevirtual 332	java/lang/Exception:printStackTrace	()V
    //   165: goto -8 -> 157
    //   168: astore 5
    //   170: aconst_null
    //   171: astore 5
    //   173: invokestatic 244	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   176: ifeq +29 -> 205
    //   179: ldc 12
    //   181: iconst_2
    //   182: new 108	java/lang/StringBuilder
    //   185: dup
    //   186: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   189: ldc_w 616
    //   192: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   195: aload_0
    //   196: invokevirtual 578	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   199: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   202: invokestatic 355	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   205: aload 5
    //   207: ifnull -200 -> 7
    //   210: aload 5
    //   212: invokevirtual 611	java/io/InputStream:close	()V
    //   215: aconst_null
    //   216: areturn
    //   217: astore_0
    //   218: aload_0
    //   219: invokevirtual 332	java/lang/Exception:printStackTrace	()V
    //   222: aconst_null
    //   223: areturn
    //   224: astore_0
    //   225: aconst_null
    //   226: astore 5
    //   228: aload 5
    //   230: ifnull +8 -> 238
    //   233: aload 5
    //   235: invokevirtual 611	java/io/InputStream:close	()V
    //   238: aload_0
    //   239: athrow
    //   240: astore 5
    //   242: aload 5
    //   244: invokevirtual 332	java/lang/Exception:printStackTrace	()V
    //   247: goto -9 -> 238
    //   250: astore_0
    //   251: goto -23 -> 228
    //   254: astore_0
    //   255: goto -27 -> 228
    //   258: astore 6
    //   260: goto -87 -> 173
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	263	0	paramFile	File
    //   68	45	1	k	int
    //   96	8	2	m	int
    //   23	44	3	l	long
    //   17	136	5	localFileInputStream	java.io.FileInputStream
    //   168	1	5	localIOException1	IOException
    //   171	63	5	localObject	Object
    //   240	3	5	localException	Exception
    //   72	86	6	arrayOfByte	byte[]
    //   258	1	6	localIOException2	IOException
    // Exception table:
    //   from	to	target	type
    //   52	57	59	java/lang/Exception
    //   152	157	160	java/lang/Exception
    //   9	19	168	java/io/IOException
    //   210	215	217	java/lang/Exception
    //   9	19	224	finally
    //   233	238	240	java/lang/Exception
    //   19	24	250	finally
    //   32	47	250	finally
    //   69	74	250	finally
    //   76	97	250	finally
    //   108	147	250	finally
    //   173	205	254	finally
    //   19	24	258	java/io/IOException
    //   32	47	258	java/io/IOException
    //   69	74	258	java/io/IOException
    //   76	97	258	java/io/IOException
    //   108	147	258	java/io/IOException
  }
  
  public static float b()
  {
    Object localObject = Environment.getExternalStorageDirectory().getAbsolutePath();
    try
    {
      localObject = new StatFs((String)localObject);
      float f1 = ((StatFs)localObject).getAvailableBlocks();
      int k = ((StatFs)localObject).getBlockSize();
      return k * f1;
    }
    catch (Exception localException) {}
    return -1.0F;
  }
  
  /* Error */
  public static String b(File paramFile)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +5 -> 6
    //   4: aconst_null
    //   5: areturn
    //   6: aload_0
    //   7: invokevirtual 96	java/io/File:exists	()Z
    //   10: ifeq +85 -> 95
    //   13: aload_0
    //   14: invokevirtual 106	java/io/File:isDirectory	()Z
    //   17: ifeq +37 -> 54
    //   20: new 91	java/io/IOException
    //   23: dup
    //   24: new 108	java/lang/StringBuilder
    //   27: dup
    //   28: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   31: ldc_w 618
    //   34: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: aload_0
    //   38: invokevirtual 578	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   41: ldc_w 620
    //   44: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   50: invokespecial 621	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   53: athrow
    //   54: aload_0
    //   55: invokevirtual 624	java/io/File:canRead	()Z
    //   58: ifne +71 -> 129
    //   61: new 91	java/io/IOException
    //   64: dup
    //   65: new 108	java/lang/StringBuilder
    //   68: dup
    //   69: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   72: ldc_w 618
    //   75: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: aload_0
    //   79: invokevirtual 578	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   82: ldc_w 626
    //   85: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   91: invokespecial 621	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   94: athrow
    //   95: new 135	java/io/FileNotFoundException
    //   98: dup
    //   99: new 108	java/lang/StringBuilder
    //   102: dup
    //   103: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   106: ldc_w 618
    //   109: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: aload_0
    //   113: invokevirtual 578	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   116: ldc_w 628
    //   119: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   125: invokespecial 629	java/io/FileNotFoundException:<init>	(Ljava/lang/String;)V
    //   128: athrow
    //   129: new 137	java/io/FileInputStream
    //   132: dup
    //   133: aload_0
    //   134: invokespecial 140	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   137: astore_3
    //   138: new 631	java/io/InputStreamReader
    //   141: dup
    //   142: aload_3
    //   143: ldc_w 633
    //   146: invokespecial 636	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   149: astore_2
    //   150: sipush 4096
    //   153: newarray char
    //   155: astore 4
    //   157: new 108	java/lang/StringBuilder
    //   160: dup
    //   161: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   164: astore_0
    //   165: aload_2
    //   166: aload 4
    //   168: invokevirtual 639	java/io/InputStreamReader:read	([C)I
    //   171: istore_1
    //   172: iconst_m1
    //   173: iload_1
    //   174: if_icmpeq +46 -> 220
    //   177: aload_0
    //   178: aload 4
    //   180: iconst_0
    //   181: iload_1
    //   182: invokevirtual 642	java/lang/StringBuilder:append	([CII)Ljava/lang/StringBuilder;
    //   185: pop
    //   186: goto -21 -> 165
    //   189: astore 4
    //   191: aload_3
    //   192: ifnull +7 -> 199
    //   195: aload_3
    //   196: invokevirtual 611	java/io/InputStream:close	()V
    //   199: aload_0
    //   200: astore_3
    //   201: aload_2
    //   202: ifnull +9 -> 211
    //   205: aload_2
    //   206: invokevirtual 643	java/io/InputStreamReader:close	()V
    //   209: aload_0
    //   210: astore_3
    //   211: aload_3
    //   212: ifnull -208 -> 4
    //   215: aload_3
    //   216: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   219: areturn
    //   220: aload_3
    //   221: ifnull +7 -> 228
    //   224: aload_3
    //   225: invokevirtual 611	java/io/InputStream:close	()V
    //   228: aload_0
    //   229: astore_3
    //   230: aload_2
    //   231: ifnull -20 -> 211
    //   234: aload_2
    //   235: invokevirtual 643	java/io/InputStreamReader:close	()V
    //   238: aload_0
    //   239: astore_3
    //   240: goto -29 -> 211
    //   243: astore_2
    //   244: aload_0
    //   245: astore_3
    //   246: goto -35 -> 211
    //   249: astore_0
    //   250: aconst_null
    //   251: astore_2
    //   252: aconst_null
    //   253: astore_3
    //   254: aload_3
    //   255: ifnull +7 -> 262
    //   258: aload_3
    //   259: invokevirtual 611	java/io/InputStream:close	()V
    //   262: aload_2
    //   263: ifnull +7 -> 270
    //   266: aload_2
    //   267: invokevirtual 643	java/io/InputStreamReader:close	()V
    //   270: aload_0
    //   271: athrow
    //   272: astore_3
    //   273: goto -45 -> 228
    //   276: astore_3
    //   277: goto -78 -> 199
    //   280: astore_2
    //   281: aload_0
    //   282: astore_3
    //   283: goto -72 -> 211
    //   286: astore_3
    //   287: goto -25 -> 262
    //   290: astore_2
    //   291: goto -21 -> 270
    //   294: astore_0
    //   295: aconst_null
    //   296: astore_2
    //   297: goto -43 -> 254
    //   300: astore_0
    //   301: goto -47 -> 254
    //   304: astore_0
    //   305: aconst_null
    //   306: astore_0
    //   307: aconst_null
    //   308: astore_2
    //   309: aconst_null
    //   310: astore_3
    //   311: goto -120 -> 191
    //   314: astore_0
    //   315: aconst_null
    //   316: astore_0
    //   317: aconst_null
    //   318: astore_2
    //   319: goto -128 -> 191
    //   322: astore_0
    //   323: aconst_null
    //   324: astore_0
    //   325: goto -134 -> 191
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	328	0	paramFile	File
    //   171	11	1	k	int
    //   149	86	2	localInputStreamReader	java.io.InputStreamReader
    //   243	1	2	localException1	Exception
    //   251	16	2	localObject1	Object
    //   280	1	2	localException2	Exception
    //   290	1	2	localException3	Exception
    //   296	23	2	localObject2	Object
    //   137	122	3	localObject3	Object
    //   272	1	3	localException4	Exception
    //   276	1	3	localException5	Exception
    //   282	1	3	localFile	File
    //   286	1	3	localException6	Exception
    //   310	1	3	localObject4	Object
    //   155	24	4	arrayOfChar	char[]
    //   189	1	4	localException7	Exception
    // Exception table:
    //   from	to	target	type
    //   165	172	189	java/lang/Exception
    //   177	186	189	java/lang/Exception
    //   234	238	243	java/lang/Exception
    //   129	138	249	finally
    //   224	228	272	java/lang/Exception
    //   195	199	276	java/lang/Exception
    //   205	209	280	java/lang/Exception
    //   258	262	286	java/lang/Exception
    //   266	270	290	java/lang/Exception
    //   138	150	294	finally
    //   150	165	300	finally
    //   165	172	300	finally
    //   177	186	300	finally
    //   129	138	304	java/lang/Exception
    //   138	150	314	java/lang/Exception
    //   150	165	322	java/lang/Exception
  }
  
  public static String b(String paramString1, String paramString2)
  {
    File localFile = new File(paramString1);
    if (!new File(localFile, paramString2).exists()) {
      return paramString2;
    }
    if (paramString2.lastIndexOf('.') < 0) {}
    String str;
    for (paramString1 = "";; paramString1 = str)
    {
      int k = 1;
      for (;;)
      {
        str = paramString2 + "(" + k + ")" + paramString1;
        if (!new File(localFile, str).exists()) {
          break;
        }
        k += 1;
      }
      paramString1 = paramString2.substring(0, paramString2.lastIndexOf('.'));
      str = paramString2.substring(paramString1.length(), paramString2.length());
      paramString2 = paramString1;
    }
    return str;
  }
  
  public static void b(String paramString)
  {
    if (!a(paramString)) {}
    try
    {
      a(paramString);
      return;
    }
    catch (IOException paramString) {}
  }
  
  public static boolean b()
  {
    return a(AppConstants.aE + "/Tencent/");
  }
  
  public static boolean b(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return false;
      paramString = new File(paramString);
    } while ((!paramString.exists()) || (paramString.length() <= 0L));
    return true;
  }
  
  public static boolean b(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString2 == null)) {}
    do
    {
      return false;
      paramString1 = new File(paramString1);
    } while (!paramString1.exists());
    return paramString1.renameTo(new File(paramString2));
  }
  
  public static boolean c()
  {
    return a(AppConstants.aG);
  }
  
  public static boolean c(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramString != null) {
      if ((!paramString.startsWith(AppConstants.aE)) && (!paramString.startsWith("/data/media/")))
      {
        bool1 = bool2;
        if (!new File(paramString).exists()) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static boolean c(String paramString1, String paramString2)
  {
    boolean bool = false;
    paramString1 = new File(paramString1);
    if (paramString1.exists()) {}
    try
    {
      a(paramString1, a(paramString2));
      bool = true;
      return bool;
    }
    catch (IOException paramString1) {}
    return false;
  }
  
  public static boolean d()
  {
    return a(AppConstants.aG + "/" + "diskcache");
  }
  
  public static boolean d(String paramString)
  {
    boolean bool = true;
    paramString = new File(paramString);
    if (paramString.exists()) {
      bool = paramString.delete();
    }
    return bool;
  }
  
  /* Error */
  public static boolean d(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 4
    //   6: new 71	java/io/File
    //   9: dup
    //   10: aload_1
    //   11: invokespecial 92	java/io/File:<init>	(Ljava/lang/String;)V
    //   14: astore 6
    //   16: aload 6
    //   18: invokevirtual 169	java/io/File:getParentFile	()Ljava/io/File;
    //   21: invokevirtual 96	java/io/File:exists	()Z
    //   24: ifne +12 -> 36
    //   27: aload 6
    //   29: invokevirtual 169	java/io/File:getParentFile	()Ljava/io/File;
    //   32: invokevirtual 103	java/io/File:mkdirs	()Z
    //   35: pop
    //   36: new 657	java/util/zip/ZipFile
    //   39: dup
    //   40: aload_0
    //   41: invokespecial 658	java/util/zip/ZipFile:<init>	(Ljava/lang/String;)V
    //   44: astore 8
    //   46: new 71	java/io/File
    //   49: dup
    //   50: new 108	java/lang/StringBuilder
    //   53: dup
    //   54: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   57: aload_1
    //   58: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: ldc_w 660
    //   64: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   70: invokespecial 92	java/io/File:<init>	(Ljava/lang/String;)V
    //   73: astore 9
    //   75: sipush 8192
    //   78: newarray byte
    //   80: astore 10
    //   82: new 146	java/io/FileOutputStream
    //   85: dup
    //   86: aload 9
    //   88: invokespecial 147	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   91: astore_0
    //   92: new 371	java/io/BufferedOutputStream
    //   95: dup
    //   96: aload_0
    //   97: aload 10
    //   99: arraylength
    //   100: invokespecial 411	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;I)V
    //   103: astore 6
    //   105: aload 8
    //   107: invokevirtual 664	java/util/zip/ZipFile:entries	()Ljava/util/Enumeration;
    //   110: astore 11
    //   112: aload 4
    //   114: astore 5
    //   116: aload 11
    //   118: invokeinterface 669 1 0
    //   123: ifeq +153 -> 276
    //   126: aload 4
    //   128: astore 5
    //   130: aload 11
    //   132: invokeinterface 673 1 0
    //   137: checkcast 374	java/util/zip/ZipEntry
    //   140: astore 7
    //   142: aload 4
    //   144: astore 5
    //   146: aload 7
    //   148: invokevirtual 376	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   151: ifnull -39 -> 112
    //   154: aload 4
    //   156: astore 5
    //   158: aload 7
    //   160: invokevirtual 376	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   163: ldc_w 380
    //   166: invokevirtual 384	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   169: ifne -57 -> 112
    //   172: aload 4
    //   174: astore 5
    //   176: aload 8
    //   178: aload 7
    //   180: invokevirtual 677	java/util/zip/ZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   183: astore 7
    //   185: aload 7
    //   187: astore 5
    //   189: aload 7
    //   191: aload 10
    //   193: iconst_0
    //   194: aload 10
    //   196: arraylength
    //   197: invokevirtual 612	java/io/InputStream:read	([BII)I
    //   200: istore_2
    //   201: aload 7
    //   203: astore 4
    //   205: iload_2
    //   206: iconst_m1
    //   207: if_icmpeq -95 -> 112
    //   210: aload 7
    //   212: astore 5
    //   214: aload 6
    //   216: aload 10
    //   218: iconst_0
    //   219: iload_2
    //   220: invokevirtual 415	java/io/BufferedOutputStream:write	([BII)V
    //   223: goto -38 -> 185
    //   226: astore 7
    //   228: aload 5
    //   230: astore 4
    //   232: aload 6
    //   234: astore 5
    //   236: aload_0
    //   237: astore_1
    //   238: aload 7
    //   240: astore_0
    //   241: aload_1
    //   242: ifnull +7 -> 249
    //   245: aload_1
    //   246: invokevirtual 337	java/io/FileOutputStream:close	()V
    //   249: aload 5
    //   251: ifnull +13 -> 264
    //   254: aload 5
    //   256: invokevirtual 425	java/io/BufferedOutputStream:flush	()V
    //   259: aload 5
    //   261: invokevirtual 372	java/io/BufferedOutputStream:close	()V
    //   264: aload 4
    //   266: ifnull +8 -> 274
    //   269: aload 4
    //   271: invokevirtual 611	java/io/InputStream:close	()V
    //   274: aload_0
    //   275: athrow
    //   276: aload 4
    //   278: astore 5
    //   280: aload 9
    //   282: new 71	java/io/File
    //   285: dup
    //   286: aload_1
    //   287: invokespecial 92	java/io/File:<init>	(Ljava/lang/String;)V
    //   290: invokevirtual 525	java/io/File:renameTo	(Ljava/io/File;)Z
    //   293: istore_3
    //   294: aload_0
    //   295: ifnull +7 -> 302
    //   298: aload_0
    //   299: invokevirtual 337	java/io/FileOutputStream:close	()V
    //   302: aload 6
    //   304: ifnull +13 -> 317
    //   307: aload 6
    //   309: invokevirtual 425	java/io/BufferedOutputStream:flush	()V
    //   312: aload 6
    //   314: invokevirtual 372	java/io/BufferedOutputStream:close	()V
    //   317: aload 4
    //   319: ifnull +8 -> 327
    //   322: aload 4
    //   324: invokevirtual 611	java/io/InputStream:close	()V
    //   327: iload_3
    //   328: ireturn
    //   329: astore_0
    //   330: goto -28 -> 302
    //   333: astore_0
    //   334: iload_3
    //   335: ireturn
    //   336: astore_1
    //   337: goto -88 -> 249
    //   340: astore_1
    //   341: goto -67 -> 274
    //   344: astore_1
    //   345: goto -81 -> 264
    //   348: astore_0
    //   349: aconst_null
    //   350: astore_1
    //   351: aconst_null
    //   352: astore 4
    //   354: goto -113 -> 241
    //   357: astore 6
    //   359: aload_0
    //   360: astore_1
    //   361: aconst_null
    //   362: astore 4
    //   364: aload 6
    //   366: astore_0
    //   367: goto -126 -> 241
    //   370: astore 7
    //   372: aload_0
    //   373: astore_1
    //   374: aconst_null
    //   375: astore 4
    //   377: aload 6
    //   379: astore 5
    //   381: aload 7
    //   383: astore_0
    //   384: goto -143 -> 241
    //   387: astore_0
    //   388: goto -71 -> 317
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	391	0	paramString1	String
    //   0	391	1	paramString2	String
    //   200	20	2	k	int
    //   293	42	3	bool	boolean
    //   4	372	4	localObject1	Object
    //   1	379	5	localObject2	Object
    //   14	299	6	localObject3	Object
    //   357	21	6	localObject4	Object
    //   140	71	7	localObject5	Object
    //   226	13	7	localObject6	Object
    //   370	12	7	localObject7	Object
    //   44	133	8	localZipFile	java.util.zip.ZipFile
    //   73	208	9	localFile	File
    //   80	137	10	arrayOfByte	byte[]
    //   110	21	11	localEnumeration	java.util.Enumeration
    // Exception table:
    //   from	to	target	type
    //   116	126	226	finally
    //   130	142	226	finally
    //   146	154	226	finally
    //   158	172	226	finally
    //   176	185	226	finally
    //   189	201	226	finally
    //   214	223	226	finally
    //   280	294	226	finally
    //   298	302	329	java/io/IOException
    //   322	327	333	java/io/IOException
    //   245	249	336	java/io/IOException
    //   269	274	340	java/io/IOException
    //   254	264	344	java/io/IOException
    //   6	36	348	finally
    //   36	92	348	finally
    //   92	105	357	finally
    //   105	112	370	finally
    //   307	317	387	java/io/IOException
  }
  
  public static boolean e(String paramString)
  {
    boolean bool = false;
    paramString = a(paramString);
    if ((paramString.equals("jpg")) || (paramString.equals("gif")) || (paramString.equals("bmp")) || (paramString.equals("png"))) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean f(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while ((!paramString.equals("jpg")) && (!paramString.equals("gif")) && (!paramString.equals("bmp")) && (!paramString.equals("png"))) {
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.FileUtils
 * JD-Core Version:    0.7.0.1
 */