package com.tencent.smtt.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Build.VERSION;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.TbsDownloadConfig;
import com.tencent.smtt.sdk.c;
import com.tencent.smtt.sdk.c.a;
import java.io.File;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.security.cert.Certificate;
import java.util.Enumeration;
import java.util.Map;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class b
{
  public static String a = "";
  public static String b = "";
  public static String c = "";
  public static String d = "";
  public static String e = "";
  public static String f = "";
  private static String g = "";
  private static boolean h = false;
  private static boolean i = false;
  private static boolean j = false;
  private static boolean k = false;
  private static boolean l = false;
  
  /* Error */
  public static String a()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore_3
    //   5: getstatic 52	com/tencent/smtt/utils/b:j	Z
    //   8: ifne +100 -> 108
    //   11: new 64	java/io/InputStreamReader
    //   14: dup
    //   15: invokestatic 70	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   18: ldc 72
    //   20: invokevirtual 76	java/lang/Runtime:exec	(Ljava/lang/String;)Ljava/lang/Process;
    //   23: invokevirtual 82	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   26: invokespecial 86	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   29: astore_1
    //   30: new 88	java/io/BufferedReader
    //   33: dup
    //   34: aload_1
    //   35: invokespecial 91	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   38: astore_0
    //   39: aload_0
    //   40: astore 4
    //   42: aload 6
    //   44: astore_3
    //   45: aload_1
    //   46: astore_2
    //   47: aload_0
    //   48: invokevirtual 94	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   51: ldc 96
    //   53: invokevirtual 102	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   56: ifeq +56 -> 112
    //   59: aload_0
    //   60: astore 4
    //   62: aload 6
    //   64: astore_3
    //   65: aload_1
    //   66: astore_2
    //   67: ldc 104
    //   69: invokestatic 107	com/tencent/smtt/utils/b:a	(Ljava/lang/String;)Ljava/lang/String;
    //   72: astore 5
    //   74: aload 5
    //   76: astore_2
    //   77: aload_2
    //   78: invokestatic 112	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   81: ifeq +7 -> 88
    //   84: aload_2
    //   85: putstatic 40	com/tencent/smtt/utils/b:c	Ljava/lang/String;
    //   88: aload_0
    //   89: ifnull +7 -> 96
    //   92: aload_0
    //   93: invokevirtual 115	java/io/BufferedReader:close	()V
    //   96: aload_1
    //   97: ifnull +7 -> 104
    //   100: aload_1
    //   101: invokevirtual 116	java/io/InputStreamReader:close	()V
    //   104: iconst_1
    //   105: putstatic 52	com/tencent/smtt/utils/b:j	Z
    //   108: getstatic 40	com/tencent/smtt/utils/b:c	Ljava/lang/String;
    //   111: areturn
    //   112: aload_0
    //   113: astore 4
    //   115: aload 6
    //   117: astore_3
    //   118: aload_1
    //   119: astore_2
    //   120: ldc 118
    //   122: invokestatic 123	java/lang/System:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   125: invokestatic 107	com/tencent/smtt/utils/b:a	(Ljava/lang/String;)Ljava/lang/String;
    //   128: astore 5
    //   130: aload 5
    //   132: astore_2
    //   133: goto -56 -> 77
    //   136: astore 5
    //   138: aconst_null
    //   139: astore_0
    //   140: aconst_null
    //   141: astore_1
    //   142: aload_0
    //   143: astore 4
    //   145: aload 6
    //   147: astore_3
    //   148: aload_1
    //   149: astore_2
    //   150: ldc 118
    //   152: invokestatic 123	java/lang/System:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   155: invokestatic 107	com/tencent/smtt/utils/b:a	(Ljava/lang/String;)Ljava/lang/String;
    //   158: astore 6
    //   160: aload_0
    //   161: astore 4
    //   163: aload 6
    //   165: astore_3
    //   166: aload_1
    //   167: astore_2
    //   168: aload 5
    //   170: invokevirtual 126	java/lang/Throwable:printStackTrace	()V
    //   173: aload 6
    //   175: invokestatic 112	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   178: ifeq +8 -> 186
    //   181: aload 6
    //   183: putstatic 40	com/tencent/smtt/utils/b:c	Ljava/lang/String;
    //   186: aload_0
    //   187: ifnull +7 -> 194
    //   190: aload_0
    //   191: invokevirtual 115	java/io/BufferedReader:close	()V
    //   194: aload_1
    //   195: ifnull -91 -> 104
    //   198: aload_1
    //   199: invokevirtual 116	java/io/InputStreamReader:close	()V
    //   202: goto -98 -> 104
    //   205: astore_0
    //   206: goto -102 -> 104
    //   209: astore_0
    //   210: aconst_null
    //   211: astore 4
    //   213: aconst_null
    //   214: astore_1
    //   215: aload_3
    //   216: invokestatic 112	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   219: ifeq +7 -> 226
    //   222: aload_3
    //   223: putstatic 40	com/tencent/smtt/utils/b:c	Ljava/lang/String;
    //   226: aload 4
    //   228: ifnull +8 -> 236
    //   231: aload 4
    //   233: invokevirtual 115	java/io/BufferedReader:close	()V
    //   236: aload_1
    //   237: ifnull +7 -> 244
    //   240: aload_1
    //   241: invokevirtual 116	java/io/InputStreamReader:close	()V
    //   244: aload_0
    //   245: athrow
    //   246: astore_0
    //   247: goto -151 -> 96
    //   250: astore_0
    //   251: goto -147 -> 104
    //   254: astore_0
    //   255: goto -61 -> 194
    //   258: astore_2
    //   259: goto -23 -> 236
    //   262: astore_1
    //   263: goto -19 -> 244
    //   266: astore_0
    //   267: aconst_null
    //   268: astore 4
    //   270: goto -55 -> 215
    //   273: astore_0
    //   274: aload_2
    //   275: astore_1
    //   276: goto -61 -> 215
    //   279: astore 5
    //   281: aconst_null
    //   282: astore_0
    //   283: goto -141 -> 142
    //   286: astore 5
    //   288: goto -146 -> 142
    // Local variable table:
    //   start	length	slot	name	signature
    //   38	153	0	localBufferedReader1	java.io.BufferedReader
    //   205	1	0	localIOException1	java.io.IOException
    //   209	36	0	localObject1	Object
    //   246	1	0	localIOException2	java.io.IOException
    //   250	1	0	localIOException3	java.io.IOException
    //   254	1	0	localIOException4	java.io.IOException
    //   266	1	0	localObject2	Object
    //   273	1	0	localObject3	Object
    //   282	1	0	localObject4	Object
    //   29	212	1	localInputStreamReader	java.io.InputStreamReader
    //   262	1	1	localIOException5	java.io.IOException
    //   275	1	1	localObject5	Object
    //   46	122	2	localObject6	Object
    //   258	17	2	localIOException6	java.io.IOException
    //   4	219	3	str1	String
    //   40	229	4	localBufferedReader2	java.io.BufferedReader
    //   72	59	5	str2	String
    //   136	33	5	localThrowable1	Throwable
    //   279	1	5	localThrowable2	Throwable
    //   286	1	5	localThrowable3	Throwable
    //   1	181	6	str3	String
    // Exception table:
    //   from	to	target	type
    //   11	30	136	java/lang/Throwable
    //   198	202	205	java/io/IOException
    //   11	30	209	finally
    //   92	96	246	java/io/IOException
    //   100	104	250	java/io/IOException
    //   190	194	254	java/io/IOException
    //   231	236	258	java/io/IOException
    //   240	244	262	java/io/IOException
    //   30	39	266	finally
    //   47	59	273	finally
    //   67	74	273	finally
    //   120	130	273	finally
    //   150	160	273	finally
    //   168	173	273	finally
    //   30	39	279	java/lang/Throwable
    //   47	59	286	java/lang/Throwable
    //   67	74	286	java/lang/Throwable
    //   120	130	286	java/lang/Throwable
  }
  
  public static String a(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getPackageName();
      return paramContext;
    }
    catch (Exception paramContext) {}
    return null;
  }
  
  private static String a(Context paramContext, File paramFile)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getPackageArchiveInfo(paramFile.getAbsolutePath(), 65);
      if (paramContext != null) {
        if ((paramContext.signatures == null) || (paramContext.signatures.length <= 0)) {}
      }
      for (paramContext = paramContext.signatures[0]; paramContext != null; paramContext = null)
      {
        return paramContext.toCharsString();
        TbsLog.w("AppUtil", "[getSignatureFromApk] pkgInfo is not null BUT signatures is null!");
      }
      return null;
    }
    catch (Exception paramContext)
    {
      TbsLog.i("AppUtil", "getSign " + paramFile + "failed");
    }
  }
  
  /* Error */
  public static String a(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 134	android/content/Context:getPackageName	()Ljava/lang/String;
    //   4: astore_2
    //   5: aload_0
    //   6: invokevirtual 139	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   9: aload_2
    //   10: sipush 128
    //   13: invokevirtual 196	android/content/pm/PackageManager:getApplicationInfo	(Ljava/lang/String;I)Landroid/content/pm/ApplicationInfo;
    //   16: getfield 202	android/content/pm/ApplicationInfo:metaData	Landroid/os/Bundle;
    //   19: aload_1
    //   20: invokevirtual 208	android/os/Bundle:get	(Ljava/lang/String;)Ljava/lang/Object;
    //   23: invokestatic 212	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   26: astore_0
    //   27: aload_0
    //   28: invokestatic 218	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   31: invokestatic 222	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   34: invokestatic 212	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   37: astore_1
    //   38: aload_1
    //   39: areturn
    //   40: astore_0
    //   41: aconst_null
    //   42: areturn
    //   43: astore_1
    //   44: aload_0
    //   45: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	46	0	paramContext	Context
    //   0	46	1	paramString	String
    //   4	6	2	str	String
    // Exception table:
    //   from	to	target	type
    //   0	27	40	java/lang/Exception
    //   27	38	43	java/lang/Exception
  }
  
  /* Error */
  public static String a(Context paramContext, boolean paramBoolean, File paramFile)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnull +10 -> 11
    //   4: aload_2
    //   5: invokevirtual 227	java/io/File:exists	()Z
    //   8: ifne +8 -> 16
    //   11: ldc 32
    //   13: astore_0
    //   14: aload_0
    //   15: areturn
    //   16: iload_1
    //   17: ifeq +72 -> 89
    //   20: iconst_2
    //   21: newarray byte
    //   23: astore 5
    //   25: new 229	java/io/RandomAccessFile
    //   28: dup
    //   29: aload_2
    //   30: ldc 231
    //   32: invokespecial 234	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   35: astore 4
    //   37: aload 4
    //   39: astore_3
    //   40: aload 4
    //   42: aload 5
    //   44: invokevirtual 238	java/io/RandomAccessFile:read	([B)I
    //   47: pop
    //   48: aload 4
    //   50: astore_3
    //   51: new 98	java/lang/String
    //   54: dup
    //   55: aload 5
    //   57: invokespecial 241	java/lang/String:<init>	([B)V
    //   60: ldc 243
    //   62: invokevirtual 247	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   65: ifne +19 -> 84
    //   68: aload 4
    //   70: invokevirtual 248	java/io/RandomAccessFile:close	()V
    //   73: ldc 32
    //   75: areturn
    //   76: astore_0
    //   77: aload_0
    //   78: invokevirtual 249	java/io/IOException:printStackTrace	()V
    //   81: ldc 32
    //   83: areturn
    //   84: aload 4
    //   86: invokevirtual 248	java/io/RandomAccessFile:close	()V
    //   89: aload_0
    //   90: invokevirtual 253	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   93: invokevirtual 134	android/content/Context:getPackageName	()Ljava/lang/String;
    //   96: ldc 255
    //   98: invokevirtual 102	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   101: ifeq +39 -> 140
    //   104: ldc 163
    //   106: ldc_w 257
    //   109: invokestatic 191	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   112: aload_2
    //   113: invokestatic 260	com/tencent/smtt/utils/b:a	(Ljava/io/File;)Ljava/lang/String;
    //   116: astore_3
    //   117: aload_3
    //   118: ifnull +22 -> 140
    //   121: ldc 163
    //   123: ldc_w 262
    //   126: invokestatic 191	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   129: aload_3
    //   130: areturn
    //   131: astore_3
    //   132: ldc 163
    //   134: ldc_w 264
    //   137: invokestatic 191	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   140: ldc 163
    //   142: ldc_w 266
    //   145: invokestatic 191	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   148: aload_0
    //   149: aload_2
    //   150: invokestatic 268	com/tencent/smtt/utils/b:a	(Landroid/content/Context;Ljava/io/File;)Ljava/lang/String;
    //   153: astore_3
    //   154: ldc 163
    //   156: new 173	java/lang/StringBuilder
    //   159: dup
    //   160: invokespecial 175	java/lang/StringBuilder:<init>	()V
    //   163: ldc_w 270
    //   166: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: aload_3
    //   170: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: invokevirtual 189	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   176: invokestatic 191	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   179: aload_3
    //   180: astore_0
    //   181: aload_3
    //   182: ifnonnull -168 -> 14
    //   185: aload_2
    //   186: invokestatic 260	com/tencent/smtt/utils/b:a	(Ljava/io/File;)Ljava/lang/String;
    //   189: astore_0
    //   190: ldc 163
    //   192: new 173	java/lang/StringBuilder
    //   195: dup
    //   196: invokespecial 175	java/lang/StringBuilder:<init>	()V
    //   199: ldc_w 272
    //   202: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   205: aload_0
    //   206: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   209: invokevirtual 189	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   212: invokestatic 191	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   215: aload_0
    //   216: areturn
    //   217: astore_3
    //   218: aload_3
    //   219: invokevirtual 249	java/io/IOException:printStackTrace	()V
    //   222: goto -133 -> 89
    //   225: astore 5
    //   227: aconst_null
    //   228: astore 4
    //   230: aload 4
    //   232: astore_3
    //   233: aload 5
    //   235: invokevirtual 273	java/lang/Exception:printStackTrace	()V
    //   238: aload 4
    //   240: invokevirtual 248	java/io/RandomAccessFile:close	()V
    //   243: goto -154 -> 89
    //   246: astore_3
    //   247: aload_3
    //   248: invokevirtual 249	java/io/IOException:printStackTrace	()V
    //   251: goto -162 -> 89
    //   254: astore_0
    //   255: aconst_null
    //   256: astore_3
    //   257: aload_3
    //   258: invokevirtual 248	java/io/RandomAccessFile:close	()V
    //   261: aload_0
    //   262: athrow
    //   263: astore_2
    //   264: aload_2
    //   265: invokevirtual 249	java/io/IOException:printStackTrace	()V
    //   268: goto -7 -> 261
    //   271: astore_0
    //   272: goto -15 -> 257
    //   275: astore 5
    //   277: goto -47 -> 230
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	280	0	paramContext	Context
    //   0	280	1	paramBoolean	boolean
    //   0	280	2	paramFile	File
    //   39	91	3	localObject1	Object
    //   131	1	3	localThrowable	Throwable
    //   153	29	3	str	String
    //   217	2	3	localIOException1	java.io.IOException
    //   232	1	3	localRandomAccessFile1	java.io.RandomAccessFile
    //   246	2	3	localIOException2	java.io.IOException
    //   256	2	3	localObject2	Object
    //   35	204	4	localRandomAccessFile2	java.io.RandomAccessFile
    //   23	33	5	arrayOfByte	byte[]
    //   225	9	5	localException1	Exception
    //   275	1	5	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   68	73	76	java/io/IOException
    //   89	117	131	java/lang/Throwable
    //   121	129	131	java/lang/Throwable
    //   84	89	217	java/io/IOException
    //   20	37	225	java/lang/Exception
    //   238	243	246	java/io/IOException
    //   20	37	254	finally
    //   257	261	263	java/io/IOException
    //   40	48	271	finally
    //   51	68	271	finally
    //   233	238	271	finally
    //   40	48	275	java/lang/Exception
    //   51	68	275	java/lang/Exception
  }
  
  private static String a(File paramFile)
  {
    String str1;
    for (;;)
    {
      try
      {
        JarFile localJarFile = new JarFile(paramFile);
        paramFile = localJarFile.getJarEntry("AndroidManifest.xml");
        byte[] arrayOfByte = new byte[8192];
        str1 = a(a(localJarFile, paramFile, arrayOfByte)[0].getEncoded());
        Enumeration localEnumeration = localJarFile.entries();
        if (!localEnumeration.hasMoreElements()) {
          break;
        }
        paramFile = (JarEntry)localEnumeration.nextElement();
        String str2 = paramFile.getName();
        if (str2 == null) {
          continue;
        }
        paramFile = a(localJarFile, paramFile, arrayOfByte);
        if (paramFile != null)
        {
          paramFile = a(paramFile[0].getEncoded());
          if (paramFile == null)
          {
            if (str2.startsWith("META-INF/")) {
              continue;
            }
            return null;
          }
          boolean bool = paramFile.equals(str1);
          if (bool) {
            continue;
          }
          return null;
        }
      }
      catch (Exception paramFile)
      {
        paramFile.printStackTrace();
        return null;
      }
      paramFile = null;
    }
    return str1;
  }
  
  private static String a(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    return str;
  }
  
  private static String a(byte[] paramArrayOfByte)
  {
    int i1 = paramArrayOfByte.length;
    char[] arrayOfChar = new char[i1 * 2];
    int m = 0;
    if (m < i1)
    {
      int i2 = paramArrayOfByte[m];
      int n = i2 >> 4 & 0xF;
      if (n >= 10)
      {
        n = n + 97 - 10;
        label44:
        arrayOfChar[(m * 2)] = ((char)n);
        n = i2 & 0xF;
        if (n < 10) {
          break label97;
        }
        n = n + 97 - 10;
      }
      for (;;)
      {
        arrayOfChar[(m * 2 + 1)] = ((char)n);
        m += 1;
        break;
        n += 48;
        break label44;
        label97:
        n += 48;
      }
    }
    return new String(arrayOfChar);
  }
  
  private static Certificate[] a(JarFile paramJarFile, JarEntry paramJarEntry, byte[] paramArrayOfByte)
    throws Exception
  {
    paramJarFile = paramJarFile.getInputStream(paramJarEntry);
    while (paramJarFile.read(paramArrayOfByte, 0, paramArrayOfByte.length) != -1) {}
    paramJarFile.close();
    if (paramJarEntry != null) {
      return paramJarEntry.getCertificates();
    }
    return null;
  }
  
  public static int b(Context paramContext)
  {
    return Build.VERSION.SDK_INT;
  }
  
  public static void b(Context paramContext, String paramString)
  {
    Log.d("0816", "saveGuid guid is " + paramString);
    try
    {
      paramContext = TbsDownloadConfig.getInstance(paramContext);
      paramContext.mSyncMap.put("tbs_guid", paramString);
      paramContext.commit();
      return;
    }
    catch (Exception paramContext) {}
  }
  
  public static boolean b()
  {
    try
    {
      if (Build.VERSION.SDK_INT < 21) {
        return false;
      }
      Object localObject1 = Class.forName("dalvik.system.VMRuntime");
      if (localObject1 == null) {
        return false;
      }
      Object localObject2 = ((Class)localObject1).getDeclaredMethod("getRuntime", new Class[0]);
      if (localObject2 == null) {
        return false;
      }
      localObject2 = ((Method)localObject2).invoke(null, new Object[0]);
      if (localObject2 == null) {
        return false;
      }
      localObject1 = ((Class)localObject1).getDeclaredMethod("is64Bit", new Class[0]);
      if (localObject1 == null) {
        return false;
      }
      localObject1 = ((Method)localObject1).invoke(localObject2, new Object[0]);
      if ((localObject1 instanceof Boolean))
      {
        boolean bool = ((Boolean)localObject1).booleanValue();
        return bool;
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return false;
  }
  
  public static String c(Context paramContext)
  {
    if (!l) {
      paramContext = q.d(paramContext);
    }
    try
    {
      f = new String(paramContext.getBytes("UTF-8"), "ISO8859-1");
      l = true;
      return f;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        f = paramContext;
      }
    }
  }
  
  public static String d(Context paramContext)
  {
    try
    {
      String str = paramContext.getPackageName();
      paramContext = paramContext.getPackageManager().getPackageInfo(str, 0).versionName;
      return paramContext;
    }
    catch (Exception paramContext) {}
    return null;
  }
  
  public static int e(Context paramContext)
  {
    try
    {
      String str = paramContext.getPackageName();
      int m = paramContext.getPackageManager().getPackageInfo(str, 0).versionCode;
      return m;
    }
    catch (Exception paramContext) {}
    return 0;
  }
  
  public static String f(Context paramContext)
  {
    String str = "";
    try
    {
      paramContext = TbsDownloadConfig.getInstance(paramContext).mPreferences.getString("tbs_guid", "");
      Log.d("0816", "getGuid guid is " + paramContext);
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
  
  public static boolean g(Context paramContext)
  {
    try
    {
      bool = paramContext.getSharedPreferences("sai", 0).getBoolean("gi", false);
      TbsLog.i("AppUtil", "stack is " + Log.getStackTraceString(paramContext));
    }
    catch (Throwable paramContext)
    {
      try
      {
        Log.d("AppUtil", "getImeiEnable is " + bool);
        TbsLog.i("AppUtil", "getImeiEnable is " + bool);
        c.a().a(paramContext, Integer.valueOf(1001), new c.a()
        {
          public void a(String paramAnonymousString)
          {
            SharedPreferences.Editor localEditor = this.a.getSharedPreferences("sai", 0).edit();
            localEditor.putBoolean("gi", true);
            localEditor.commit();
            TbsLog.e("TBSEmergency", "Execute command [1001](" + paramAnonymousString + ")");
          }
        });
        return bool;
      }
      catch (Throwable paramContext)
      {
        boolean bool;
        break label95;
      }
      paramContext = paramContext;
      bool = false;
    }
    label95:
    return bool;
  }
  
  public static String h(Context paramContext)
  {
    if (!QbSdk.isEnableSensitiveApi())
    {
      TbsLog.i("AppUtil", "getImei isEnableSensitiveApi = false");
      return "";
    }
    if (!h) {}
    try
    {
      a = l(paramContext);
      Log.d("AppUtil", " getDeviceID is " + a);
      if (TextUtils.isEmpty(a))
      {
        a = j.a(paramContext);
        Log.d("AppUtil", " getSDKUID is " + a);
      }
      h = true;
      return a;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        TbsLog.i(paramContext);
      }
    }
  }
  
  public static String i(Context paramContext)
  {
    if (!QbSdk.isEnableSensitiveApi())
    {
      TbsLog.i("AppUtil", "getImsi isEnableSensitiveApi = false");
      return "";
    }
    if (!QbSdk.isEnableCanGetSubscriberId())
    {
      TbsLog.i("AppUtil", "getImsi isEnableCanGetSubscriberId is false");
      return "";
    }
    if (!i) {}
    try
    {
      b = ((TelephonyManager)paramContext.getSystemService("phone")).getSubscriberId();
      i = true;
      return b;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        TbsLog.i(paramContext);
      }
    }
  }
  
  public static String j(Context paramContext)
  {
    return "02:00:00:00:00:00";
  }
  
  public static String k(Context paramContext)
  {
    if (!QbSdk.isEnableSensitiveApi())
    {
      TbsLog.i("AppUtil", "getAndroidID isEnableSensitiveApi = false");
      return "";
    }
    if (!QbSdk.isEnableGetAndroidID())
    {
      TbsLog.i("AppUtil", "getAndroidID isEnableGetAndroidID is false");
      return "";
    }
    if (!n(paramContext))
    {
      TbsLog.i("AppUtil", "getAndroidID isAndroidIDEnable is false");
      return "";
    }
    if (!k) {}
    try
    {
      e = Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
      k = true;
      TbsLog.i("AppUtil", "getAndroidID mAndroidID is " + e);
      return e;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
      }
    }
  }
  
  private static String l(Context paramContext)
  {
    try
    {
      if (!QbSdk.isEnableGetDeviceID())
      {
        TbsLog.i("AppUtil", "getDeviceID isEnableGetDeviceID is false");
        return "";
      }
      if (!m(paramContext))
      {
        TbsLog.i("AppUtil", "getDeviceID isDeviceIDEnable is false");
        return "";
      }
      g = ((TelephonyManager)paramContext.getSystemService("phone")).getDeviceId();
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        TbsLog.i(paramContext);
      }
    }
    TbsLog.i("AppUtil", "getDeviceID mDeviceID is " + g);
    return g;
  }
  
  private static boolean m(Context paramContext)
  {
    try
    {
      bool = paramContext.getSharedPreferences("sai", 0).getBoolean("pdi", false);
      c localc;
      TbsLog.i("AppUtil", "stack is " + Log.getStackTraceString(paramContext));
    }
    catch (Throwable paramContext)
    {
      try
      {
        Log.d("AppUtil", "isDeviceIDEnable is " + bool);
        TbsLog.i("AppUtil", "isDeviceIDEnable is " + bool);
        localc = c.a();
        localc.a(paramContext, Integer.valueOf(1004), new c.a()
        {
          public void a(String paramAnonymousString)
          {
            SharedPreferences.Editor localEditor = this.a.getSharedPreferences("sai", 0).edit();
            localEditor.putBoolean("pdi", false);
            localEditor.commit();
            TbsLog.e("TBSEmergency", "Execute command [1004](" + paramAnonymousString + ")");
          }
        });
        localc.a(paramContext, Integer.valueOf(1010), new c.a()
        {
          public void a(String paramAnonymousString)
          {
            paramAnonymousString = this.a.getSharedPreferences("sai", 0).edit();
            paramAnonymousString.putBoolean("pdi", true);
            paramAnonymousString.commit();
            TbsLog.e("TBSEmergency", "Execute command [1010](+extra+)");
          }
        });
        return bool;
      }
      catch (Throwable paramContext)
      {
        boolean bool;
        break label116;
      }
      paramContext = paramContext;
      bool = false;
    }
    label116:
    return bool;
  }
  
  private static boolean n(Context paramContext)
  {
    try
    {
      bool = paramContext.getSharedPreferences("sai", 0).getBoolean("gpai", false);
      c localc;
      TbsLog.i("AppUtil", "stack is " + Log.getStackTraceString(paramContext));
    }
    catch (Throwable paramContext)
    {
      try
      {
        Log.d("AppUtil", "isAndroidIDEnable is " + bool);
        TbsLog.i("AppUtil", "isAndroidIDEnable is " + bool);
        localc = c.a();
        localc.a(paramContext, Integer.valueOf(1012), new c.a()
        {
          public void a(String paramAnonymousString)
          {
            paramAnonymousString = this.a.getSharedPreferences("sai", 0).edit();
            paramAnonymousString.putBoolean("gpai", false);
            paramAnonymousString.commit();
            TbsLog.e("TBSEmergency", "Execute command [1012](+extra+)");
          }
        });
        localc.a(paramContext, Integer.valueOf(1011), new c.a()
        {
          public void a(String paramAnonymousString)
          {
            paramAnonymousString = this.a.getSharedPreferences("sai", 0).edit();
            paramAnonymousString.putBoolean("gpai", true);
            paramAnonymousString.commit();
            TbsLog.e("TBSEmergency", "Execute command [1011](+extra+)");
          }
        });
        return bool;
      }
      catch (Throwable paramContext)
      {
        boolean bool;
        break label116;
      }
      paramContext = paramContext;
      bool = false;
    }
    label116:
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.smtt.utils.b
 * JD-Core Version:    0.7.0.1
 */