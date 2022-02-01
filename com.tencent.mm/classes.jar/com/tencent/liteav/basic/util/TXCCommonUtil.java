package com.tencent.liteav.basic.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.security.MessageDigest;

public class TXCCommonUtil
{
  private static String mAppID;
  private static String mStrAppVersion;
  public static String pituLicencePath;
  private static Context sApplicationContext;
  
  static
  {
    AppMethodBeat.i(14697);
    mAppID = "";
    mStrAppVersion = "";
    pituLicencePath = "YTFaceSDK.licence";
    sApplicationContext = null;
    f.f();
    AppMethodBeat.o(14697);
  }
  
  public static Context getAppContext()
  {
    return sApplicationContext;
  }
  
  public static String getAppID()
  {
    return mAppID;
  }
  
  public static String getAppNameByStreamUrl(String paramString)
  {
    AppMethodBeat.i(14687);
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(14687);
      return null;
    }
    int i = paramString.indexOf("?");
    if (i != -1) {}
    for (String str = paramString.substring(0, i);; str = paramString)
    {
      if ((str == null) || (str.length() == 0))
      {
        AppMethodBeat.o(14687);
        return null;
      }
      i = str.lastIndexOf("/");
      paramString = str;
      if (i != -1) {
        paramString = str.substring(0, i);
      }
      if ((paramString == null) || (paramString.length() == 0))
      {
        AppMethodBeat.o(14687);
        return null;
      }
      i = paramString.lastIndexOf("/");
      str = paramString;
      if (i != -1) {
        str = paramString.substring(i + 1);
      }
      if ((str == null) || (str.length() == 0))
      {
        AppMethodBeat.o(14687);
        return null;
      }
      AppMethodBeat.o(14687);
      return str;
    }
  }
  
  public static String getAppPackageName()
  {
    AppMethodBeat.i(14696);
    String str = f.c(sApplicationContext);
    AppMethodBeat.o(14696);
    return str;
  }
  
  public static String getAppVersion()
  {
    return mStrAppVersion;
  }
  
  public static String getConfigCenterKey()
  {
    AppMethodBeat.i(182420);
    String str = nativeGetConfigCenterKey();
    AppMethodBeat.o(182420);
    return str;
  }
  
  public static String getFileExtension(String paramString)
  {
    AppMethodBeat.i(14684);
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramString != null)
    {
      localObject1 = localObject2;
      if (paramString.length() > 0)
      {
        int i = paramString.lastIndexOf('.');
        localObject1 = localObject2;
        if (i >= 0)
        {
          localObject1 = localObject2;
          if (i < paramString.length() - 1) {
            localObject1 = paramString.substring(i + 1);
          }
        }
      }
    }
    AppMethodBeat.o(14684);
    return localObject1;
  }
  
  public static String getLogUploadPath()
  {
    AppMethodBeat.i(14695);
    if (sApplicationContext == null)
    {
      AppMethodBeat.o(14695);
      return "";
    }
    Object localObject = sApplicationContext.getExternalFilesDir(null);
    if (localObject == null)
    {
      AppMethodBeat.o(14695);
      return "";
    }
    localObject = ((File)localObject).getAbsolutePath() + "/log/tencent/liteav";
    AppMethodBeat.o(14695);
    return localObject;
  }
  
  public static String getMD5(String paramString)
  {
    AppMethodBeat.i(14688);
    try
    {
      Object localObject = MessageDigest.getInstance("MD5");
      ((MessageDigest)localObject).update(paramString.getBytes());
      localObject = ((MessageDigest)localObject).digest();
      StringBuffer localStringBuffer = new StringBuffer("");
      int i = 0;
      while (i < localObject.length)
      {
        int k = localObject[i];
        int j = k;
        if (k < 0) {
          j = k + 256;
        }
        if (j < 16) {
          localStringBuffer.append("0");
        }
        localStringBuffer.append(Integer.toHexString(j));
        i += 1;
      }
      localObject = localStringBuffer.toString();
      AppMethodBeat.o(14688);
      return localObject;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(14688);
    }
    return paramString;
  }
  
  public static byte[] getMD5(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(14689);
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      localMessageDigest.update(paramArrayOfByte);
      paramArrayOfByte = localMessageDigest.digest();
      AppMethodBeat.o(14689);
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte)
    {
      AppMethodBeat.o(14689);
    }
    return null;
  }
  
  public static int getSDKID()
  {
    AppMethodBeat.i(14683);
    int i = nativeGetSDKID();
    AppMethodBeat.o(14683);
    return i;
  }
  
  public static int[] getSDKVersion()
  {
    AppMethodBeat.i(14681);
    String[] arrayOfString = nativeGetSDKVersion().split("\\.");
    int[] arrayOfInt = new int[arrayOfString.length];
    int i = 0;
    for (;;)
    {
      if (i < arrayOfString.length) {
        try
        {
          arrayOfInt[i] = Integer.parseInt(arrayOfString[i]);
          i += 1;
        }
        catch (NumberFormatException localNumberFormatException)
        {
          for (;;)
          {
            arrayOfInt[i] = 0;
          }
        }
      }
    }
    AppMethodBeat.o(14681);
    return arrayOfInt;
  }
  
  public static String getSDKVersionStr()
  {
    AppMethodBeat.i(14682);
    String str = nativeGetSDKVersion();
    AppMethodBeat.o(14682);
    return str;
  }
  
  public static String getStreamIDByStreamUrl(String paramString)
  {
    AppMethodBeat.i(14686);
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(14686);
      return null;
    }
    int i = paramString.indexOf("?");
    if (i != -1) {}
    for (String str = paramString.substring(0, i);; str = paramString)
    {
      if ((str == null) || (str.length() == 0))
      {
        AppMethodBeat.o(14686);
        return null;
      }
      i = str.lastIndexOf("/");
      paramString = str;
      if (i != -1) {
        paramString = str.substring(i + 1);
      }
      if ((paramString == null) || (paramString.length() == 0))
      {
        AppMethodBeat.o(14686);
        return null;
      }
      i = paramString.indexOf(".");
      str = paramString;
      if (i != -1) {
        str = paramString.substring(0, i);
      }
      if ((str == null) || (str.length() == 0))
      {
        AppMethodBeat.o(14686);
        return null;
      }
      AppMethodBeat.o(14686);
      return str;
    }
  }
  
  public static String loadString(String paramString)
  {
    AppMethodBeat.i(14691);
    Context localContext = sApplicationContext;
    if (localContext == null)
    {
      AppMethodBeat.o(14691);
      return "";
    }
    try
    {
      paramString = localContext.getSharedPreferences("TXCCommonConfig", 0).getString(paramString, "");
      AppMethodBeat.o(14691);
      return paramString;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString = "";
      }
    }
  }
  
  public static long loadUInt64(String paramString)
  {
    long l1 = 0L;
    AppMethodBeat.i(14693);
    Context localContext = sApplicationContext;
    if (localContext == null)
    {
      AppMethodBeat.o(14693);
      return 0L;
    }
    try
    {
      long l2 = localContext.getSharedPreferences("TXCCommonConfig", 0).getLong(paramString, 0L);
      l1 = l2;
    }
    catch (Exception paramString)
    {
      label44:
      break label44;
    }
    AppMethodBeat.o(14693);
    return l1;
  }
  
  private static native String nativeGetConfigCenterKey();
  
  private static native int nativeGetSDKID();
  
  private static native String nativeGetSDKVersion();
  
  public static void saveString(String paramString1, String paramString2)
  {
    AppMethodBeat.i(14690);
    Object localObject = sApplicationContext;
    if (localObject == null)
    {
      AppMethodBeat.o(14690);
      return;
    }
    try
    {
      localObject = ((Context)localObject).getSharedPreferences("TXCCommonConfig", 0).edit();
      ((SharedPreferences.Editor)localObject).putString(paramString1, paramString2);
      ((SharedPreferences.Editor)localObject).commit();
      AppMethodBeat.o(14690);
      return;
    }
    catch (Exception paramString1)
    {
      AppMethodBeat.o(14690);
    }
  }
  
  public static void saveUInt64(String paramString, long paramLong)
  {
    AppMethodBeat.i(14692);
    Object localObject = sApplicationContext;
    if (localObject == null)
    {
      AppMethodBeat.o(14692);
      return;
    }
    try
    {
      localObject = ((Context)localObject).getSharedPreferences("TXCCommonConfig", 0).edit();
      ((SharedPreferences.Editor)localObject).putLong(paramString, paramLong);
      ((SharedPreferences.Editor)localObject).commit();
      AppMethodBeat.o(14692);
      return;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(14692);
    }
  }
  
  public static void setAppContext(Context paramContext)
  {
    sApplicationContext = paramContext;
  }
  
  public static void setAppID(String paramString)
  {
    mAppID = paramString;
  }
  
  public static void setAppVersion(String paramString)
  {
    mStrAppVersion = paramString;
  }
  
  public static void setPituLicencePath(String paramString)
  {
    pituLicencePath = paramString;
  }
  
  public static void sleep(int paramInt)
  {
    AppMethodBeat.i(14685);
    long l = paramInt;
    try
    {
      Thread.sleep(l);
      AppMethodBeat.o(14685);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      AppMethodBeat.o(14685);
    }
  }
  
  /* Error */
  public static void zip(java.util.ArrayList<String> paramArrayList, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: sipush 14694
    //   6: invokestatic 18	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: new 100	java/io/File
    //   12: dup
    //   13: aload_1
    //   14: invokespecial 233	java/io/File:<init>	(Ljava/lang/String;)V
    //   17: astore_1
    //   18: new 235	java/util/zip/ZipOutputStream
    //   21: dup
    //   22: new 237	java/io/FileOutputStream
    //   25: dup
    //   26: aload_1
    //   27: invokespecial 240	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   30: invokespecial 243	java/util/zip/ZipOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   33: astore 5
    //   35: aload 5
    //   37: ldc 245
    //   39: invokevirtual 248	java/util/zip/ZipOutputStream:setComment	(Ljava/lang/String;)V
    //   42: aload_0
    //   43: invokevirtual 254	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   46: astore 6
    //   48: aconst_null
    //   49: astore_0
    //   50: aload 6
    //   52: invokeinterface 259 1 0
    //   57: ifeq +180 -> 237
    //   60: new 100	java/io/File
    //   63: dup
    //   64: aload 6
    //   66: invokeinterface 263 1 0
    //   71: checkcast 51	java/lang/String
    //   74: invokespecial 233	java/io/File:<init>	(Ljava/lang/String;)V
    //   77: astore 7
    //   79: aload 7
    //   81: invokevirtual 266	java/io/File:length	()J
    //   84: lconst_0
    //   85: lcmp
    //   86: ifeq +17 -> 103
    //   89: aload 7
    //   91: invokevirtual 266	java/io/File:length	()J
    //   94: lstore_3
    //   95: lload_3
    //   96: ldc2_w 267
    //   99: lcmp
    //   100: ifle +14 -> 114
    //   103: aload_0
    //   104: invokevirtual 273	java/io/InputStream:close	()V
    //   107: goto -57 -> 50
    //   110: astore_1
    //   111: goto -61 -> 50
    //   114: new 275	java/io/FileInputStream
    //   117: dup
    //   118: aload 7
    //   120: invokespecial 276	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   123: astore_1
    //   124: aload 5
    //   126: new 278	java/util/zip/ZipEntry
    //   129: dup
    //   130: aload 7
    //   132: invokevirtual 281	java/io/File:getName	()Ljava/lang/String;
    //   135: invokespecial 282	java/util/zip/ZipEntry:<init>	(Ljava/lang/String;)V
    //   138: invokevirtual 286	java/util/zip/ZipOutputStream:putNextEntry	(Ljava/util/zip/ZipEntry;)V
    //   141: sipush 8192
    //   144: newarray byte
    //   146: astore_0
    //   147: aload_1
    //   148: aload_0
    //   149: invokevirtual 290	java/io/InputStream:read	([B)I
    //   152: istore_2
    //   153: iload_2
    //   154: iconst_m1
    //   155: if_icmpeq +24 -> 179
    //   158: aload 5
    //   160: aload_0
    //   161: iconst_0
    //   162: iload_2
    //   163: invokevirtual 294	java/util/zip/ZipOutputStream:write	([BII)V
    //   166: goto -19 -> 147
    //   169: astore_0
    //   170: aload_1
    //   171: invokevirtual 273	java/io/InputStream:close	()V
    //   174: aload_1
    //   175: astore_0
    //   176: goto -126 -> 50
    //   179: aload_1
    //   180: invokevirtual 273	java/io/InputStream:close	()V
    //   183: aload_1
    //   184: astore_0
    //   185: goto -135 -> 50
    //   188: astore_0
    //   189: aload_1
    //   190: astore_0
    //   191: goto -141 -> 50
    //   194: astore_0
    //   195: aload_1
    //   196: astore_0
    //   197: goto -147 -> 50
    //   200: astore_0
    //   201: aload_1
    //   202: invokevirtual 273	java/io/InputStream:close	()V
    //   205: sipush 14694
    //   208: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   211: aload_0
    //   212: athrow
    //   213: astore_0
    //   214: aload 5
    //   216: astore_0
    //   217: ldc_w 296
    //   220: ldc_w 298
    //   223: invokestatic 303	com/tencent/liteav/basic/log/TXCLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   226: aload_0
    //   227: invokevirtual 304	java/util/zip/ZipOutputStream:close	()V
    //   230: sipush 14694
    //   233: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   236: return
    //   237: aload 5
    //   239: invokevirtual 304	java/util/zip/ZipOutputStream:close	()V
    //   242: sipush 14694
    //   245: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   248: return
    //   249: astore_0
    //   250: sipush 14694
    //   253: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   256: return
    //   257: astore_0
    //   258: sipush 14694
    //   261: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   264: return
    //   265: astore_0
    //   266: aconst_null
    //   267: astore_1
    //   268: aload_1
    //   269: invokevirtual 304	java/util/zip/ZipOutputStream:close	()V
    //   272: sipush 14694
    //   275: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   278: aload_0
    //   279: athrow
    //   280: astore_1
    //   281: goto -76 -> 205
    //   284: astore_1
    //   285: goto -13 -> 272
    //   288: astore_0
    //   289: aload 5
    //   291: astore_1
    //   292: goto -24 -> 268
    //   295: astore 5
    //   297: aload_0
    //   298: astore_1
    //   299: aload 5
    //   301: astore_0
    //   302: goto -34 -> 268
    //   305: astore_0
    //   306: aload 6
    //   308: astore_0
    //   309: goto -92 -> 217
    //   312: astore_1
    //   313: aload_0
    //   314: astore 6
    //   316: aload_1
    //   317: astore_0
    //   318: aload 6
    //   320: astore_1
    //   321: goto -120 -> 201
    //   324: astore_1
    //   325: aload_0
    //   326: astore_1
    //   327: goto -157 -> 170
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	330	0	paramArrayList	java.util.ArrayList<String>
    //   0	330	1	paramString	String
    //   152	11	2	i	int
    //   94	2	3	l	long
    //   33	257	5	localZipOutputStream	java.util.zip.ZipOutputStream
    //   295	5	5	localObject1	Object
    //   1	318	6	localObject2	Object
    //   77	54	7	localFile	File
    // Exception table:
    //   from	to	target	type
    //   103	107	110	java/lang/Exception
    //   124	147	169	java/lang/Exception
    //   147	153	169	java/lang/Exception
    //   158	166	169	java/lang/Exception
    //   179	183	188	java/lang/Exception
    //   170	174	194	java/lang/Exception
    //   124	147	200	finally
    //   147	153	200	finally
    //   158	166	200	finally
    //   35	48	213	java/io/FileNotFoundException
    //   50	79	213	java/io/FileNotFoundException
    //   103	107	213	java/io/FileNotFoundException
    //   170	174	213	java/io/FileNotFoundException
    //   179	183	213	java/io/FileNotFoundException
    //   201	205	213	java/io/FileNotFoundException
    //   205	213	213	java/io/FileNotFoundException
    //   237	242	249	java/lang/Exception
    //   226	230	257	java/lang/Exception
    //   18	35	265	finally
    //   201	205	280	java/lang/Exception
    //   268	272	284	java/lang/Exception
    //   35	48	288	finally
    //   50	79	288	finally
    //   103	107	288	finally
    //   170	174	288	finally
    //   179	183	288	finally
    //   201	205	288	finally
    //   205	213	288	finally
    //   217	226	295	finally
    //   18	35	305	java/io/FileNotFoundException
    //   79	95	312	finally
    //   114	124	312	finally
    //   79	95	324	java/lang/Exception
    //   114	124	324	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.liteav.basic.util.TXCCommonUtil
 * JD-Core Version:    0.7.0.1
 */