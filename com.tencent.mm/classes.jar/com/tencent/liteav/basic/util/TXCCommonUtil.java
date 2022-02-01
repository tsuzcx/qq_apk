package com.tencent.liteav.basic.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.DhcpInfo;
import android.net.wifi.WifiManager;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.security.MessageDigest;

public class TXCCommonUtil
{
  private static final String TAG = "TXCCommonUtil";
  private static String mAppID;
  private static String mStrAppVersion;
  private static String mUserId;
  public static String pituLicencePath;
  private static Context sApplicationContext;
  
  static
  {
    AppMethodBeat.i(14697);
    mAppID = "";
    mStrAppVersion = "";
    pituLicencePath = "YTFaceSDK.licence";
    sApplicationContext = null;
    mUserId = "";
    f.f();
    AppMethodBeat.o(14697);
  }
  
  public static boolean equals(Object paramObject1, Object paramObject2)
  {
    AppMethodBeat.i(222086);
    if ((paramObject1 == paramObject2) || ((paramObject1 != null) && (paramObject1.equals(paramObject2))))
    {
      AppMethodBeat.o(222086);
      return true;
    }
    AppMethodBeat.o(222086);
    return false;
  }
  
  public static Context getAppContext()
  {
    return sApplicationContext;
  }
  
  public static String getAppFilePath()
  {
    AppMethodBeat.i(222087);
    String str = "/sdcard/liteav";
    if (sApplicationContext != null) {
      str = sApplicationContext.getFilesDir().getAbsolutePath();
    }
    File localFile = new File(str);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    AppMethodBeat.o(222087);
    return str;
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
  
  public static int getGateway()
  {
    AppMethodBeat.i(222085);
    if (sApplicationContext == null)
    {
      AppMethodBeat.o(222085);
      return 0;
    }
    try
    {
      i = ((WifiManager)sApplicationContext.getSystemService("wifi")).getDhcpInfo().gateway;
      AppMethodBeat.o(222085);
      return i;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        TXCLog.e("TXCCommonUtil", "getGateway error ", localException);
        int i = 0;
      }
    }
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
            TXCLog.e("TXCCommonUtil", "parse version failed.", localNumberFormatException);
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
  
  public static String getUserId()
  {
    return mUserId;
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
    catch (Exception localException)
    {
      for (;;)
      {
        paramString = "";
        TXCLog.e("TXCCommonUtil", "load string failed.", localException);
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
      for (;;)
      {
        TXCLog.e("TXCCommonUtil", "load uint64 failed.", paramString);
      }
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
      TXCLog.e("TXCCommonUtil", "save string failed", paramString1);
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
      TXCLog.e("TXCCommonUtil", "save uint64 failed.", paramString);
      AppMethodBeat.o(14692);
    }
  }
  
  public static void setAppContext(Context paramContext)
  {
    AppMethodBeat.i(222084);
    if (paramContext == null)
    {
      AppMethodBeat.o(222084);
      return;
    }
    sApplicationContext = paramContext.getApplicationContext();
    AppMethodBeat.o(222084);
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
  
  public static void setUserId(String paramString)
  {
    mUserId = paramString;
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
    //   1: astore 5
    //   3: sipush 14694
    //   6: invokestatic 22	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: new 70	java/io/File
    //   12: dup
    //   13: aload_1
    //   14: invokespecial 76	java/io/File:<init>	(Ljava/lang/String;)V
    //   17: astore_1
    //   18: new 305	java/util/zip/ZipOutputStream
    //   21: dup
    //   22: new 307	java/io/FileOutputStream
    //   25: dup
    //   26: aload_1
    //   27: invokespecial 310	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   30: invokespecial 313	java/util/zip/ZipOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   33: astore 6
    //   35: aload 6
    //   37: ldc_w 315
    //   40: invokevirtual 318	java/util/zip/ZipOutputStream:setComment	(Ljava/lang/String;)V
    //   43: aload_0
    //   44: invokevirtual 324	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   47: astore 7
    //   49: aconst_null
    //   50: astore_0
    //   51: aload 7
    //   53: invokeinterface 329 1 0
    //   58: ifeq +206 -> 264
    //   61: new 70	java/io/File
    //   64: dup
    //   65: aload 7
    //   67: invokeinterface 333 1 0
    //   72: checkcast 87	java/lang/String
    //   75: invokespecial 76	java/io/File:<init>	(Ljava/lang/String;)V
    //   78: astore 8
    //   80: aload 8
    //   82: invokevirtual 336	java/io/File:length	()J
    //   85: lconst_0
    //   86: lcmp
    //   87: ifeq +17 -> 104
    //   90: aload 8
    //   92: invokevirtual 336	java/io/File:length	()J
    //   95: lstore_3
    //   96: lload_3
    //   97: ldc2_w 337
    //   100: lcmp
    //   101: ifle +14 -> 115
    //   104: aload_0
    //   105: invokevirtual 343	java/io/InputStream:close	()V
    //   108: goto -57 -> 51
    //   111: astore_1
    //   112: goto -61 -> 51
    //   115: new 345	java/io/FileInputStream
    //   118: dup
    //   119: aload 8
    //   121: invokespecial 346	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   124: astore_1
    //   125: aload_1
    //   126: astore 5
    //   128: aload 6
    //   130: new 348	java/util/zip/ZipEntry
    //   133: dup
    //   134: aload 8
    //   136: invokevirtual 351	java/io/File:getName	()Ljava/lang/String;
    //   139: invokespecial 352	java/util/zip/ZipEntry:<init>	(Ljava/lang/String;)V
    //   142: invokevirtual 356	java/util/zip/ZipOutputStream:putNextEntry	(Ljava/util/zip/ZipEntry;)V
    //   145: aload_1
    //   146: astore 5
    //   148: sipush 8192
    //   151: newarray byte
    //   153: astore_0
    //   154: aload_1
    //   155: astore 5
    //   157: aload_1
    //   158: aload_0
    //   159: invokevirtual 360	java/io/InputStream:read	([B)I
    //   162: istore_2
    //   163: iload_2
    //   164: iconst_m1
    //   165: if_icmpeq +43 -> 208
    //   168: aload_1
    //   169: astore 5
    //   171: aload 6
    //   173: aload_0
    //   174: iconst_0
    //   175: iload_2
    //   176: invokevirtual 364	java/util/zip/ZipOutputStream:write	([BII)V
    //   179: goto -25 -> 154
    //   182: astore 5
    //   184: aload_1
    //   185: astore_0
    //   186: aload 5
    //   188: astore_1
    //   189: aload_0
    //   190: astore 5
    //   192: ldc 8
    //   194: ldc_w 366
    //   197: aload_1
    //   198: invokestatic 154	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   201: aload_0
    //   202: invokevirtual 343	java/io/InputStream:close	()V
    //   205: goto -154 -> 51
    //   208: aload_1
    //   209: invokevirtual 343	java/io/InputStream:close	()V
    //   212: aload_1
    //   213: astore_0
    //   214: goto -163 -> 51
    //   217: astore_0
    //   218: aload_1
    //   219: astore_0
    //   220: goto -169 -> 51
    //   223: astore_1
    //   224: goto -173 -> 51
    //   227: astore_0
    //   228: aload 5
    //   230: invokevirtual 343	java/io/InputStream:close	()V
    //   233: sipush 14694
    //   236: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   239: aload_0
    //   240: athrow
    //   241: astore_0
    //   242: aload 6
    //   244: astore_0
    //   245: ldc 8
    //   247: ldc_w 368
    //   250: invokestatic 371	com/tencent/liteav/basic/log/TXCLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   253: aload_0
    //   254: invokevirtual 372	java/util/zip/ZipOutputStream:close	()V
    //   257: sipush 14694
    //   260: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   263: return
    //   264: aload 6
    //   266: invokevirtual 372	java/util/zip/ZipOutputStream:close	()V
    //   269: sipush 14694
    //   272: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   275: return
    //   276: astore_0
    //   277: sipush 14694
    //   280: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   283: return
    //   284: astore_0
    //   285: sipush 14694
    //   288: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   291: return
    //   292: astore_0
    //   293: aconst_null
    //   294: astore_1
    //   295: aload_1
    //   296: invokevirtual 372	java/util/zip/ZipOutputStream:close	()V
    //   299: sipush 14694
    //   302: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   305: aload_0
    //   306: athrow
    //   307: astore_1
    //   308: goto -75 -> 233
    //   311: astore_1
    //   312: goto -13 -> 299
    //   315: astore_0
    //   316: aload 6
    //   318: astore_1
    //   319: goto -24 -> 295
    //   322: astore 5
    //   324: aload_0
    //   325: astore_1
    //   326: aload 5
    //   328: astore_0
    //   329: goto -34 -> 295
    //   332: astore_0
    //   333: aload 5
    //   335: astore_0
    //   336: goto -91 -> 245
    //   339: astore_1
    //   340: aload_0
    //   341: astore 5
    //   343: aload_1
    //   344: astore_0
    //   345: goto -117 -> 228
    //   348: astore_1
    //   349: goto -160 -> 189
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	352	0	paramArrayList	java.util.ArrayList<String>
    //   0	352	1	paramString	String
    //   162	14	2	i	int
    //   95	2	3	l	long
    //   1	169	5	str	String
    //   182	5	5	localException	Exception
    //   190	39	5	localArrayList1	java.util.ArrayList<String>
    //   322	12	5	localObject	Object
    //   341	1	5	localArrayList2	java.util.ArrayList<String>
    //   33	284	6	localZipOutputStream	java.util.zip.ZipOutputStream
    //   47	19	7	localIterator	java.util.Iterator
    //   78	57	8	localFile	File
    // Exception table:
    //   from	to	target	type
    //   104	108	111	java/lang/Exception
    //   128	145	182	java/lang/Exception
    //   148	154	182	java/lang/Exception
    //   157	163	182	java/lang/Exception
    //   171	179	182	java/lang/Exception
    //   208	212	217	java/lang/Exception
    //   201	205	223	java/lang/Exception
    //   128	145	227	finally
    //   148	154	227	finally
    //   157	163	227	finally
    //   171	179	227	finally
    //   192	201	227	finally
    //   35	49	241	java/io/FileNotFoundException
    //   51	80	241	java/io/FileNotFoundException
    //   104	108	241	java/io/FileNotFoundException
    //   201	205	241	java/io/FileNotFoundException
    //   208	212	241	java/io/FileNotFoundException
    //   228	233	241	java/io/FileNotFoundException
    //   233	241	241	java/io/FileNotFoundException
    //   264	269	276	java/lang/Exception
    //   253	257	284	java/lang/Exception
    //   18	35	292	finally
    //   228	233	307	java/lang/Exception
    //   295	299	311	java/lang/Exception
    //   35	49	315	finally
    //   51	80	315	finally
    //   104	108	315	finally
    //   201	205	315	finally
    //   208	212	315	finally
    //   228	233	315	finally
    //   233	241	315	finally
    //   245	253	322	finally
    //   18	35	332	java/io/FileNotFoundException
    //   80	96	339	finally
    //   115	125	339	finally
    //   80	96	348	java/lang/Exception
    //   115	125	348	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.liteav.basic.util.TXCCommonUtil
 * JD-Core Version:    0.7.0.1
 */