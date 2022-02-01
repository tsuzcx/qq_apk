package c.t.m.sapp.c;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.os.Process;
import android.os.StatFs;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONObject;

public class r
{
  public static final Object a;
  public static String b;
  public static String c;
  public static String d;
  public static long e;
  public static String f;
  public static String g;
  public static String h;
  public static String i;
  public static HashMap<String, s> j;
  
  static
  {
    AppMethodBeat.i(186438);
    a = new Object();
    b = "TencentLocation_sapp/comp";
    c = "TencentLocation_sapp/odex";
    d = "complist_loading_sapp";
    e = 0L;
    f = "01234567890ABCDEF";
    g = "key-locselfid";
    h = "key-locoutid";
    i = "01234567890ABCDEF";
    j = new HashMap();
    AppMethodBeat.o(186438);
  }
  
  public static double a(double paramDouble)
  {
    return 3.141592653589793D * paramDouble / 180.0D;
  }
  
  public static double a(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4)
  {
    AppMethodBeat.i(186415);
    paramDouble1 = a(paramDouble1);
    paramDouble3 = a(paramDouble3);
    paramDouble2 = a(paramDouble2);
    paramDouble4 = a(paramDouble4);
    double d1 = Math.pow(Math.sin((paramDouble1 - paramDouble3) / 2.0D), 2.0D);
    paramDouble1 = Math.round(Math.asin(Math.sqrt(Math.cos(paramDouble1) * Math.cos(paramDouble3) * Math.pow(Math.sin((paramDouble2 - paramDouble4) / 2.0D), 2.0D) + d1)) * 2.0D * 6378.1369999999997D * 10000.0D) / 10000.0D;
    AppMethodBeat.o(186415);
    return paramDouble1 * 1000.0D;
  }
  
  public static Long a(Context paramContext, String paramString, Long paramLong)
  {
    AppMethodBeat.i(186165);
    paramContext = b(paramContext, paramString).a(String.valueOf(paramLong));
    try
    {
      long l = Long.parseLong(paramContext);
      paramLong = Long.valueOf(l);
    }
    catch (Exception paramContext)
    {
      label28:
      break label28;
    }
    AppMethodBeat.o(186165);
    return paramLong;
  }
  
  public static String a(Context paramContext, String paramString)
  {
    AppMethodBeat.i(186219);
    try
    {
      if (q.b == null) {
        q.b = paramContext;
      }
      paramContext = (String)q.a("TLocationSDK", paramString, "01234567890ABCDEF");
      return paramContext;
    }
    finally
    {
      AppMethodBeat.o(186219);
    }
    return "01234567890ABCDEF";
  }
  
  public static String a(File paramFile)
  {
    AppMethodBeat.i(186222);
    if (!paramFile.isFile())
    {
      AppMethodBeat.o(186222);
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
        int k = paramFile.read(arrayOfByte, 0, 1024);
        if (k == -1) {
          break;
        }
        localMessageDigest.update(arrayOfByte, 0, k);
      }
      paramFile.close();
    }
    catch (Exception paramFile)
    {
      AppMethodBeat.o(186222);
      return null;
    }
    paramFile = a(localMessageDigest.digest());
    AppMethodBeat.o(186222);
    return paramFile;
  }
  
  public static String a(List<a> paramList)
  {
    AppMethodBeat.i(186376);
    StringBuilder localStringBuilder = new StringBuilder();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      a locala = (a)paramList.next();
      localStringBuilder.append(locala.a).append(",");
      localStringBuilder.append(locala.b).append(",");
      if (!locala.c.contains(".dex")) {
        locala.c += ".dex";
      }
      localStringBuilder.append(locala.c).append(",");
      localStringBuilder.append(locala.d).append(",");
      localStringBuilder.append(locala.e).append(",");
      localStringBuilder.append(locala.f).append(";");
    }
    paramList = localStringBuilder.toString();
    AppMethodBeat.o(186376);
    return paramList;
  }
  
  public static String a(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(186224);
    if (paramArrayOfByte == null)
    {
      AppMethodBeat.o(186224);
      return "";
    }
    StringBuffer localStringBuffer = new StringBuffer();
    int k = 0;
    while (k < paramArrayOfByte.length)
    {
      String str = Integer.toHexString(paramArrayOfByte[k] & 0xFF);
      if (str.length() == 1) {
        localStringBuffer.append("0");
      }
      localStringBuffer.append(str);
      k += 1;
    }
    paramArrayOfByte = localStringBuffer.toString().toLowerCase();
    AppMethodBeat.o(186224);
    return paramArrayOfByte;
  }
  
  public static List<String> a(Context paramContext, File paramFile)
  {
    AppMethodBeat.i(186188);
    Object localObject2 = null;
    paramContext = "";
    Context localContext = paramContext;
    Object localObject1 = localObject2;
    if (paramFile.exists())
    {
      localContext = paramContext;
      localObject1 = localObject2;
      if (paramFile.isDirectory())
      {
        File[] arrayOfFile = paramFile.listFiles();
        localContext = paramContext;
        localObject1 = localObject2;
        if (arrayOfFile != null)
        {
          localContext = paramContext;
          localObject1 = localObject2;
          if (arrayOfFile.length > 0)
          {
            paramFile = new ArrayList();
            int m = arrayOfFile.length;
            int k = 0;
            for (;;)
            {
              localContext = paramContext;
              localObject1 = paramFile;
              if (k >= m) {
                break;
              }
              localContext = arrayOfFile[k];
              paramFile.add(localContext.getName() + "," + localContext.length() + "," + a(localContext));
              paramContext = paramContext + localContext.getName() + "," + localContext.length() + "," + a(localContext) + ";";
              k += 1;
            }
          }
        }
      }
    }
    j.a("before check ,private dir files:".concat(String.valueOf(localContext)));
    AppMethodBeat.o(186188);
    return localObject1;
  }
  
  public static void a()
  {
    AppMethodBeat.i(186168);
    long l = System.currentTimeMillis();
    b = "TencentLocation/comp";
    c = "TencentLocation/odex";
    b = b + "_atuo_" + l;
    c = c + "_atuo_" + l;
    AppMethodBeat.o(186168);
  }
  
  public static void a(long paramLong)
  {
    AppMethodBeat.i(186227);
    try
    {
      Thread.sleep(paramLong);
      AppMethodBeat.o(186227);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      AppMethodBeat.o(186227);
    }
  }
  
  public static void a(Context paramContext)
  {
    AppMethodBeat.i(186176);
    if (paramContext == null)
    {
      AppMethodBeat.o(186176);
      return;
    }
    paramContext = new File(paramContext.getFilesDir().getAbsolutePath() + "/TencentLocation").listFiles();
    if ((paramContext != null) && (paramContext.length > 0))
    {
      int k = 0;
      while (k < paramContext.length)
      {
        Object localObject = paramContext[k];
        String str = localObject.getName();
        if ((localObject.isDirectory()) && (str.contains("_atuo_")) && (!b.contains(str)))
        {
          b(localObject.getAbsolutePath());
          localObject.delete();
        }
        k += 1;
      }
    }
    AppMethodBeat.o(186176);
  }
  
  public static void a(Context paramContext, Pair<String, String> paramPair)
  {
    AppMethodBeat.i(186214);
    try
    {
      if (("oaId".equals(paramPair.first)) && (paramPair.second != null) && (((String)paramPair.second).length() > 0))
      {
        i = (String)paramPair.second;
        a(paramContext, h, (String)paramPair.second);
        return;
      }
    }
    finally
    {
      AppMethodBeat.o(186214);
    }
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(186216);
    try
    {
      if (q.b == null) {
        q.b = paramContext;
      }
      q.b("TLocationSDK", paramString1, paramString2);
      return;
    }
    finally
    {
      AppMethodBeat.o(186216);
    }
  }
  
  public static boolean a(Context paramContext, String paramString1, String paramString2, String paramString3, long paramLong, byte[] paramArrayOfByte)
  {
    boolean bool1 = false;
    boolean bool2 = false;
    AppMethodBeat.i(186389);
    paramString3 = paramString2 + File.separator + paramString3;
    paramString2 = new File(paramString2);
    if (!paramString2.exists()) {
      paramString2.mkdir();
    }
    try
    {
      paramContext = paramContext.getResources().getAssets().open(paramString1);
      paramString2 = new ByteArrayOutputStream();
      paramContext.available();
      paramString1 = new BufferedOutputStream(new FileOutputStream(paramString3, true), 1024);
      for (;;)
      {
        int k = paramContext.read(paramArrayOfByte);
        if (k <= 0) {
          break;
        }
        paramString2.write(paramArrayOfByte, 0, k);
      }
      j.a("copy base to private dir", paramContext);
    }
    catch (Exception paramContext)
    {
      bool1 = bool2;
    }
    for (;;)
    {
      AppMethodBeat.o(186389);
      return bool1;
      paramString2.close();
      paramString2 = paramString2.toByteArray();
      paramString2 = c(m.a(paramString2, "sE0zy%DVqLnXA$hmNZ8NBwcg7FDrvi!q"));
      if (paramString2 != null)
      {
        paramString1.write(paramString2);
        paramString1.close();
        bool1 = true;
      }
      try
      {
        paramContext.close();
      }
      catch (Exception paramContext) {}
    }
  }
  
  public static boolean a(Context paramContext, List<a> paramList)
  {
    AppMethodBeat.i(186380);
    List localList = e(b(paramContext, "__SP_UPDATE_TencentLoc_COMP_INFO__sapp_", ""));
    if (paramList.size() == 0)
    {
      AppMethodBeat.o(186380);
      return false;
    }
    if (localList.size() == 0)
    {
      bool = c(paramContext, "__SP_UPDATE_TencentLoc_COMP_INFO__sapp_", a(paramList));
      AppMethodBeat.o(186380);
      return bool;
    }
    int k = 0;
    if (k < localList.size())
    {
      a locala1 = (a)localList.get(k);
      int m = 0;
      for (;;)
      {
        if (m < paramList.size())
        {
          a locala2 = (a)paramList.get(m);
          if (locala2.a == locala1.a)
          {
            locala1.c = locala2.c;
            locala1.b = locala2.b;
            locala1.d = locala2.d;
            locala1.e = locala2.e;
          }
        }
        else
        {
          k += 1;
          break;
        }
        m += 1;
      }
    }
    boolean bool = c(paramContext, "__SP_UPDATE_TencentLoc_COMP_INFO__sapp_", a(localList));
    AppMethodBeat.o(186380);
    return bool;
  }
  
  public static boolean a(String paramString)
  {
    AppMethodBeat.i(186404);
    Object localObject = new File(paramString);
    if (!((File)localObject).exists())
    {
      ((File)localObject).mkdirs();
      AppMethodBeat.o(186404);
      return true;
    }
    localObject = ((File)localObject).list();
    if ((localObject != null) && (localObject.length != 0))
    {
      int m = localObject.length;
      int k = 0;
      if (k < m)
      {
        File localFile = new File(paramString, localObject[k]);
        if (localFile.isDirectory())
        {
          b(localFile.getAbsolutePath());
          localFile.delete();
        }
        for (;;)
        {
          k += 1;
          break;
          localFile.delete();
        }
      }
      AppMethodBeat.o(186404);
      return true;
    }
    AppMethodBeat.o(186404);
    return true;
  }
  
  public static byte[] a(int paramInt)
  {
    AppMethodBeat.i(186230);
    byte[] arrayOfByte = new byte[2];
    int m = 0;
    int k = paramInt;
    paramInt = m;
    while (paramInt < 2)
    {
      arrayOfByte[paramInt] = Integer.valueOf(k & 0xFF).byteValue();
      k >>= 8;
      paramInt += 1;
    }
    AppMethodBeat.o(186230);
    return arrayOfByte;
  }
  
  public static int b()
  {
    return Build.VERSION.SDK_INT;
  }
  
  public static s b(Context paramContext, String paramString)
  {
    AppMethodBeat.i(186145);
    if (j.containsKey(paramString))
    {
      paramContext = (s)j.get(paramString);
      AppMethodBeat.o(186145);
      return paramContext;
    }
    paramContext = new s(paramContext.getFilesDir().getAbsolutePath() + "/TencentLocation_sapp/conf/" + paramString);
    j.put(paramString, paramContext);
    AppMethodBeat.o(186145);
    return paramContext;
  }
  
  public static String b(Context paramContext)
  {
    AppMethodBeat.i(186180);
    try
    {
      String str = paramContext.getPackageName();
      paramContext = paramContext.getPackageManager().getPackageInfo(str, 0);
      str = paramContext.versionName;
      int k = paramContext.versionCode;
      if (str != null)
      {
        paramContext = str;
        if (str.trim().length() > 0) {}
      }
      else
      {
        paramContext = new StringBuilder();
        paramContext = "" + k;
        AppMethodBeat.o(186180);
        return paramContext;
      }
    }
    catch (Exception paramContext)
    {
      paramContext = "";
      AppMethodBeat.o(186180);
    }
    return paramContext;
  }
  
  public static String b(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(186160);
    paramContext = b(paramContext, paramString1).a(paramString2);
    AppMethodBeat.o(186160);
    return paramContext;
  }
  
  public static boolean b(Context paramContext, String paramString, Long paramLong)
  {
    AppMethodBeat.i(186155);
    boolean bool = b(paramContext, paramString).a(String.valueOf(paramLong).getBytes(), false);
    AppMethodBeat.o(186155);
    return bool;
  }
  
  public static boolean b(Context paramContext, String paramString1, String paramString2, String paramString3, long paramLong, byte[] paramArrayOfByte)
  {
    boolean bool2 = false;
    AppMethodBeat.i(186401);
    paramContext = paramString2 + File.separator + paramString3;
    paramString2 = new File(paramString2);
    if (!paramString2.exists()) {
      paramString2.mkdir();
    }
    boolean bool1 = bool2;
    try
    {
      paramString1 = new FileInputStream(paramString1);
      bool1 = bool2;
      paramContext = new FileOutputStream(paramContext);
      for (;;)
      {
        bool1 = bool2;
        int k = paramString1.read(paramArrayOfByte);
        if (k <= 0) {
          break;
        }
        bool1 = bool2;
        paramContext.write(paramArrayOfByte, 0, k);
      }
      AppMethodBeat.o(186401);
    }
    catch (Exception paramContext) {}
    for (;;)
    {
      return bool1;
      bool1 = bool2;
      paramContext.close();
      bool2 = true;
      bool1 = true;
      paramString1.close();
      bool1 = bool2;
    }
  }
  
  public static boolean b(String paramString)
  {
    int k = 0;
    AppMethodBeat.i(186394);
    Object localObject = new File(paramString);
    if (!((File)localObject).exists())
    {
      AppMethodBeat.o(186394);
      return false;
    }
    localObject = ((File)localObject).list();
    if ((localObject != null) && (localObject.length != 0))
    {
      int m = localObject.length;
      if (k < m)
      {
        File localFile = new File(paramString, localObject[k]);
        if (localFile.isDirectory())
        {
          b(localFile.getAbsolutePath());
          localFile.delete();
        }
        for (;;)
        {
          k += 1;
          break;
          localFile.delete();
        }
      }
      AppMethodBeat.o(186394);
      return true;
    }
    AppMethodBeat.o(186394);
    return true;
  }
  
  /* Error */
  public static byte[] b(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: ldc_w 549
    //   3: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 398	java/io/ByteArrayOutputStream
    //   9: dup
    //   10: aload_0
    //   11: arraylength
    //   12: invokespecial 551	java/io/ByteArrayOutputStream:<init>	(I)V
    //   15: astore_1
    //   16: new 553	java/util/zip/GZIPOutputStream
    //   19: dup
    //   20: aload_1
    //   21: invokespecial 556	java/util/zip/GZIPOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   24: astore_2
    //   25: aload_2
    //   26: aload_0
    //   27: invokevirtual 557	java/util/zip/GZIPOutputStream:write	([B)V
    //   30: aload_2
    //   31: invokevirtual 558	java/util/zip/GZIPOutputStream:close	()V
    //   34: aload_1
    //   35: invokevirtual 429	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   38: astore_0
    //   39: aload_1
    //   40: invokevirtual 426	java/io/ByteArrayOutputStream:close	()V
    //   43: ldc_w 549
    //   46: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   49: aload_0
    //   50: areturn
    //   51: astore_0
    //   52: aconst_null
    //   53: astore_0
    //   54: goto -11 -> 43
    //   57: astore_1
    //   58: goto -15 -> 43
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	61	0	paramArrayOfByte	byte[]
    //   15	25	1	localByteArrayOutputStream	ByteArrayOutputStream
    //   57	1	1	localObject	Object
    //   24	7	2	localGZIPOutputStream	java.util.zip.GZIPOutputStream
    // Exception table:
    //   from	to	target	type
    //   6	39	51	finally
    //   39	43	57	finally
  }
  
  public static String c()
  {
    AppMethodBeat.i(186203);
    try
    {
      Object localObject = new StringBuilder();
      localObject = ((StringBuilder)localObject).append("/proc/").append(Process.myPid());
      localObject = new BufferedReader(new FileReader(new File("/cmdline")));
      String str2 = ((BufferedReader)localObject).readLine().trim();
      ((BufferedReader)localObject).close();
      AppMethodBeat.o(186203);
      return str2;
    }
    catch (Exception localException)
    {
      String str1 = j.a;
      AppMethodBeat.o(186203);
    }
    return null;
  }
  
  public static String c(Context paramContext)
  {
    AppMethodBeat.i(186182);
    paramContext = paramContext.getFilesDir().getAbsolutePath() + File.separator + b;
    AppMethodBeat.o(186182);
    return paramContext;
  }
  
  /* Error */
  public static String c(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: ldc_w 588
    //   3: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 190	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 191	java/lang/StringBuilder:<init>	()V
    //   13: astore_2
    //   14: aload_0
    //   15: invokevirtual 589	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   18: aload_1
    //   19: invokevirtual 396	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   22: astore_0
    //   23: new 568	java/io/BufferedReader
    //   26: dup
    //   27: new 591	java/io/InputStreamReader
    //   30: dup
    //   31: aload_0
    //   32: ldc_w 593
    //   35: invokespecial 596	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   38: invokespecial 576	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   41: astore_1
    //   42: aload_1
    //   43: invokevirtual 579	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   46: astore_3
    //   47: aload_3
    //   48: ifnull +26 -> 74
    //   51: aload_2
    //   52: aload_3
    //   53: invokevirtual 220	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: pop
    //   57: goto -15 -> 42
    //   60: astore_0
    //   61: aload_2
    //   62: invokevirtual 232	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   65: astore_0
    //   66: ldc_w 588
    //   69: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   72: aload_0
    //   73: areturn
    //   74: aload_1
    //   75: invokevirtual 580	java/io/BufferedReader:close	()V
    //   78: aload_0
    //   79: invokevirtual 444	java/io/InputStream:close	()V
    //   82: goto -21 -> 61
    //   85: astore_0
    //   86: goto -25 -> 61
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	89	0	paramContext	Context
    //   0	89	1	paramString	String
    //   13	49	2	localStringBuilder	StringBuilder
    //   46	7	3	str	String
    // Exception table:
    //   from	to	target	type
    //   14	23	60	java/io/UnsupportedEncodingException
    //   23	42	60	java/io/UnsupportedEncodingException
    //   42	47	60	java/io/UnsupportedEncodingException
    //   51	57	60	java/io/UnsupportedEncodingException
    //   74	82	60	java/io/UnsupportedEncodingException
    //   14	23	85	java/io/IOException
    //   23	42	85	java/io/IOException
    //   42	47	85	java/io/IOException
    //   51	57	85	java/io/IOException
    //   74	82	85	java/io/IOException
  }
  
  public static String c(String paramString)
  {
    AppMethodBeat.i(186223);
    try
    {
      String str = a(MessageDigest.getInstance("MD5").digest(paramString.getBytes()));
      AppMethodBeat.o(186223);
      return str;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(186223);
    }
    return paramString;
  }
  
  public static boolean c(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(186152);
    boolean bool = b(paramContext, paramString1).a(paramString2.getBytes(), false);
    AppMethodBeat.o(186152);
    return bool;
  }
  
  /* Error */
  public static byte[] c(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: ldc_w 603
    //   6: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_0
    //   10: ifnull +273 -> 283
    //   13: aload_0
    //   14: arraylength
    //   15: ifeq +268 -> 283
    //   18: new 398	java/io/ByteArrayOutputStream
    //   21: dup
    //   22: invokespecial 399	java/io/ByteArrayOutputStream:<init>	()V
    //   25: astore 4
    //   27: new 605	java/io/ByteArrayInputStream
    //   30: dup
    //   31: aload_0
    //   32: invokespecial 607	java/io/ByteArrayInputStream:<init>	([B)V
    //   35: astore_0
    //   36: new 609	java/util/zip/GZIPInputStream
    //   39: dup
    //   40: aload_0
    //   41: invokespecial 612	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;)V
    //   44: astore_2
    //   45: ldc_w 613
    //   48: newarray byte
    //   50: astore_3
    //   51: aload_2
    //   52: aload_3
    //   53: invokevirtual 614	java/util/zip/GZIPInputStream:read	([B)I
    //   56: istore_1
    //   57: iload_1
    //   58: iflt +50 -> 108
    //   61: aload 4
    //   63: aload_3
    //   64: iconst_0
    //   65: iload_1
    //   66: invokevirtual 420	java/io/ByteArrayOutputStream:write	([BII)V
    //   69: goto -18 -> 51
    //   72: astore_3
    //   73: aload_2
    //   74: ifnull +7 -> 81
    //   77: aload_2
    //   78: invokevirtual 615	java/util/zip/GZIPInputStream:close	()V
    //   81: aload_0
    //   82: ifnull +7 -> 89
    //   85: aload_0
    //   86: invokevirtual 616	java/io/ByteArrayInputStream:close	()V
    //   89: aload 4
    //   91: astore_0
    //   92: aload 4
    //   94: ifnonnull +109 -> 203
    //   97: aload 5
    //   99: astore_3
    //   100: ldc_w 603
    //   103: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   106: aload_3
    //   107: areturn
    //   108: aload 4
    //   110: invokevirtual 429	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   113: astore_3
    //   114: aload_2
    //   115: invokevirtual 615	java/util/zip/GZIPInputStream:close	()V
    //   118: aload_0
    //   119: invokevirtual 616	java/io/ByteArrayInputStream:close	()V
    //   122: aload 4
    //   124: invokevirtual 426	java/io/ByteArrayOutputStream:close	()V
    //   127: goto -27 -> 100
    //   130: astore_0
    //   131: goto -31 -> 100
    //   134: astore 5
    //   136: aload_2
    //   137: astore_3
    //   138: aload 5
    //   140: astore_2
    //   141: aload_3
    //   142: ifnull +7 -> 149
    //   145: aload_3
    //   146: invokevirtual 615	java/util/zip/GZIPInputStream:close	()V
    //   149: aload_0
    //   150: ifnull +7 -> 157
    //   153: aload_0
    //   154: invokevirtual 616	java/io/ByteArrayInputStream:close	()V
    //   157: aload 4
    //   159: ifnull +8 -> 167
    //   162: aload 4
    //   164: invokevirtual 426	java/io/ByteArrayOutputStream:close	()V
    //   167: ldc_w 603
    //   170: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   173: aload_2
    //   174: athrow
    //   175: astore_2
    //   176: aconst_null
    //   177: astore_3
    //   178: goto -37 -> 141
    //   181: astore_2
    //   182: aconst_null
    //   183: astore_2
    //   184: aload_2
    //   185: ifnull +7 -> 192
    //   188: aload_2
    //   189: invokevirtual 615	java/util/zip/GZIPInputStream:close	()V
    //   192: aload_0
    //   193: ifnull +106 -> 299
    //   196: aload_0
    //   197: invokevirtual 616	java/io/ByteArrayInputStream:close	()V
    //   200: goto +99 -> 299
    //   203: aload_0
    //   204: invokevirtual 426	java/io/ByteArrayOutputStream:close	()V
    //   207: aload 5
    //   209: astore_3
    //   210: goto -110 -> 100
    //   213: astore_0
    //   214: aload 5
    //   216: astore_3
    //   217: goto -117 -> 100
    //   220: astore_2
    //   221: aconst_null
    //   222: astore_2
    //   223: goto -150 -> 73
    //   226: astore_2
    //   227: aconst_null
    //   228: astore_0
    //   229: aconst_null
    //   230: astore_3
    //   231: goto -90 -> 141
    //   234: astore_0
    //   235: aconst_null
    //   236: astore_0
    //   237: aconst_null
    //   238: astore_2
    //   239: goto -55 -> 184
    //   242: astore_0
    //   243: aconst_null
    //   244: astore_0
    //   245: aconst_null
    //   246: astore_2
    //   247: goto -174 -> 73
    //   250: astore_2
    //   251: aconst_null
    //   252: astore_0
    //   253: aconst_null
    //   254: astore 4
    //   256: aconst_null
    //   257: astore_3
    //   258: goto -117 -> 141
    //   261: astore_0
    //   262: aconst_null
    //   263: astore_0
    //   264: aconst_null
    //   265: astore 4
    //   267: aconst_null
    //   268: astore_2
    //   269: goto -85 -> 184
    //   272: astore_0
    //   273: aconst_null
    //   274: astore_0
    //   275: aconst_null
    //   276: astore 4
    //   278: aconst_null
    //   279: astore_2
    //   280: goto -207 -> 73
    //   283: ldc_w 603
    //   286: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   289: aconst_null
    //   290: areturn
    //   291: astore_0
    //   292: goto -125 -> 167
    //   295: astore_3
    //   296: goto -112 -> 184
    //   299: aload 5
    //   301: astore_3
    //   302: aload 4
    //   304: ifnull -204 -> 100
    //   307: aload 4
    //   309: astore_0
    //   310: goto -107 -> 203
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	313	0	paramArrayOfByte	byte[]
    //   56	10	1	k	int
    //   44	130	2	localObject1	Object
    //   175	1	2	localObject2	Object
    //   181	1	2	localError1	java.lang.Error
    //   183	6	2	localObject3	Object
    //   220	1	2	localException1	Exception
    //   222	1	2	localObject4	Object
    //   226	1	2	localObject5	Object
    //   238	9	2	localObject6	Object
    //   250	1	2	localObject7	Object
    //   268	12	2	localObject8	Object
    //   50	14	3	arrayOfByte	byte[]
    //   72	1	3	localException2	Exception
    //   99	159	3	localObject9	Object
    //   295	1	3	localError2	java.lang.Error
    //   301	1	3	localObject10	Object
    //   25	283	4	localByteArrayOutputStream	ByteArrayOutputStream
    //   1	97	5	localObject11	Object
    //   134	166	5	localObject12	Object
    // Exception table:
    //   from	to	target	type
    //   45	51	72	java/lang/Exception
    //   51	57	72	java/lang/Exception
    //   61	69	72	java/lang/Exception
    //   108	114	72	java/lang/Exception
    //   114	127	130	java/lang/Exception
    //   45	51	134	finally
    //   51	57	134	finally
    //   61	69	134	finally
    //   108	114	134	finally
    //   36	45	175	finally
    //   36	45	181	java/lang/Error
    //   77	81	213	java/lang/Exception
    //   85	89	213	java/lang/Exception
    //   188	192	213	java/lang/Exception
    //   196	200	213	java/lang/Exception
    //   203	207	213	java/lang/Exception
    //   36	45	220	java/lang/Exception
    //   27	36	226	finally
    //   27	36	234	java/lang/Error
    //   27	36	242	java/lang/Exception
    //   18	27	250	finally
    //   18	27	261	java/lang/Error
    //   18	27	272	java/lang/Exception
    //   145	149	291	java/lang/Exception
    //   153	157	291	java/lang/Exception
    //   162	167	291	java/lang/Exception
    //   45	51	295	java/lang/Error
    //   51	57	295	java/lang/Error
    //   61	69	295	java/lang/Error
    //   108	114	295	java/lang/Error
  }
  
  public static long d()
  {
    AppMethodBeat.i(186225);
    long l1 = 0L;
    try
    {
      StatFs localStatFs = new StatFs(Environment.getDataDirectory().getPath());
      long l2 = localStatFs.getBlockSize();
      int k = localStatFs.getAvailableBlocks();
      l1 = k * l2;
    }
    catch (Exception localException)
    {
      label41:
      break label41;
    }
    AppMethodBeat.o(186225);
    return l1;
  }
  
  public static String d(Context paramContext)
  {
    AppMethodBeat.i(186196);
    String str = e(paramContext);
    paramContext = str;
    if (str == null) {
      paramContext = c();
    }
    AppMethodBeat.o(186196);
    return paramContext;
  }
  
  public static String d(String paramString)
  {
    AppMethodBeat.i(186369);
    try
    {
      Object localObject1 = new JSONObject(paramString);
      paramString = ((JSONObject)localObject1).getString("status");
      Object localObject2 = e.b();
      Object localObject3 = new StringBuilder();
      ((e)localObject2).a("DRG", "statucode:" + paramString);
      boolean bool = paramString.equals("-3");
      if (bool)
      {
        AppMethodBeat.o(186369);
        return null;
      }
      bool = paramString.equals("0");
      if (bool)
      {
        paramString = "";
        localObject1 = ((JSONObject)localObject1).getJSONArray("compList");
        int k = 0;
        while (k < ((JSONArray)localObject1).length())
        {
          Object localObject4 = ((JSONArray)localObject1).getJSONObject(k);
          int m = ((JSONObject)localObject4).getInt("compId");
          localObject3 = ((JSONObject)localObject4).getString("compVer");
          localObject2 = ((JSONObject)localObject4).getString("md5");
          int n = ((JSONObject)localObject4).getInt("size");
          localObject4 = ((JSONObject)localObject4).getString("compName");
          paramString = new StringBuilder().append(paramString).append(m);
          paramString = paramString.append(",").append((String)localObject3);
          paramString = paramString.append(",").append((String)localObject4);
          paramString = paramString.append(",").append(n);
          paramString = paramString.append(",").append((String)localObject2);
          paramString = ",;";
          k += 1;
        }
        AppMethodBeat.o(186369);
        return paramString;
      }
      bool = paramString.equals("-1");
      if (bool)
      {
        AppMethodBeat.o(186369);
        return null;
      }
      bool = paramString.equals("-2");
      if (bool)
      {
        AppMethodBeat.o(186369);
        return null;
      }
      bool = paramString.equals("-4");
      if (bool)
      {
        AppMethodBeat.o(186369);
        return null;
      }
      bool = paramString.equals("-5");
      if (bool)
      {
        AppMethodBeat.o(186369);
        return null;
      }
    }
    catch (Exception paramString)
    {
      e.b().a("DRG", "statucode:" + paramString.toString());
      AppMethodBeat.o(186369);
    }
    return null;
  }
  
  public static String e()
  {
    AppMethodBeat.i(186194);
    try
    {
      String str = Build.MANUFACTURER;
      str = str.replaceAll("[_]", "");
      return str;
    }
    finally
    {
      AppMethodBeat.o(186194);
    }
    return "";
  }
  
  public static String e(Context paramContext)
  {
    AppMethodBeat.i(186200);
    try
    {
      int k = Process.myPid();
      paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses().iterator();
      while (paramContext.hasNext())
      {
        ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)paramContext.next();
        if (localRunningAppProcessInfo.pid == k)
        {
          paramContext = localRunningAppProcessInfo.processName;
          AppMethodBeat.o(186200);
          return paramContext;
        }
      }
    }
    catch (Exception paramContext)
    {
      paramContext = j.a;
      AppMethodBeat.o(186200);
    }
    return null;
  }
  
  public static List<a> e(String paramString)
  {
    int k = 0;
    AppMethodBeat.i(186360);
    localArrayList = new ArrayList();
    for (;;)
    {
      try
      {
        paramString = paramString.split(";");
        int m = paramString.length;
        if (k < m)
        {
          arrayOfString = paramString[k];
          arrayOfString = arrayOfString.split(",");
          int n = arrayOfString.length;
          if (n < 5) {}
        }
      }
      catch (Exception paramString)
      {
        String[] arrayOfString;
        a locala;
        AppMethodBeat.o(186360);
        return localArrayList;
      }
      try
      {
        locala = new a();
        locala.a = Integer.valueOf(arrayOfString[0]).intValue();
        locala.b = arrayOfString[1];
        locala.c = arrayOfString[2];
        locala.d = Integer.valueOf(arrayOfString[3]).intValue();
        locala.e = arrayOfString[4];
        if (arrayOfString.length > 5) {
          locala.f = arrayOfString[5];
        }
        localArrayList.add(locala);
      }
      catch (Exception localException)
      {
        continue;
      }
      k += 1;
    }
  }
  
  public static int f(Context paramContext)
  {
    AppMethodBeat.i(186425);
    if (paramContext == null)
    {
      AppMethodBeat.o(186425);
      return -1;
    }
    boolean bool5 = j(paramContext);
    for (;;)
    {
      try
      {
        localObject1 = (WifiManager)paramContext.getSystemService("wifi");
        if (localObject1 == null) {
          continue;
        }
        bool1 = ((WifiManager)localObject1).isWifiEnabled();
      }
      finally
      {
        Object localObject1;
        boolean bool2;
        int n;
        boolean bool4;
        boolean bool3;
        int i2;
        int i1;
        boolean bool1 = false;
        continue;
        int m = 1;
        int k = 0;
        continue;
      }
      try
      {
        if (Build.VERSION.SDK_INT < 18) {
          continue;
        }
        bool2 = ((WifiManager)localObject1).isScanAlwaysAvailable();
        if (!bool2) {
          continue;
        }
        m = 1;
        k = 1;
      }
      finally {}
      try
      {
        localObject1 = (LocationManager)paramContext.getSystemService("location");
        if (localObject1 == null) {
          continue;
        }
      }
      catch (Exception paramContext)
      {
        n = 0;
        bool2 = false;
        bool3 = false;
        i2 = n;
        continue;
        k = n + 512;
        continue;
        k = n + 256;
        continue;
        k = n + 128;
        continue;
        k = n + 64;
        continue;
      }
      try
      {
        paramContext = paramContext.getContentResolver();
        n = Settings.Secure.getInt(paramContext, "location_mode");
      }
      finally
      {
        n = 0;
        continue;
        bool2 = paramContext.contains("gps");
        continue;
      }
      try
      {
        bool4 = ((LocationManager)localObject1).isProviderEnabled("gps");
        paramContext = ((LocationManager)localObject1).getAllProviders();
        if (paramContext != null) {
          continue;
        }
        bool2 = false;
        bool3 = bool2;
        bool2 = bool4;
        i2 = n;
        if (bool5) {
          continue;
        }
        i1 = 1;
      }
      catch (Exception paramContext)
      {
        continue;
        i1 = 0;
        continue;
      }
      n = i1;
      if (!bool1) {
        n = i1 + 2;
      }
      i1 = n;
      if (!bool2) {
        i1 = n + 4;
      }
      n = i1;
      if (m == 0) {
        n = i1 + 8;
      }
      m = n;
      if (!bool3) {
        m = n + 16;
      }
      n = m;
      if (k == 0) {
        n = m + 32;
      }
      switch (i2)
      {
      default: 
        k = n;
        AppMethodBeat.o(186425);
        return k;
        m = 0;
        k = 0;
        continue;
        bool1 = false;
        m = 0;
        k = 0;
      }
    }
  }
  
  public static String f()
  {
    return "";
  }
  
  public static int g()
  {
    AppMethodBeat.i(186205);
    int k = Process.myPid();
    AppMethodBeat.o(186205);
    return k;
  }
  
  public static String g(Context paramContext)
  {
    AppMethodBeat.i(186209);
    try
    {
      if (f != null)
      {
        int k = f.length();
        if ((k != 0) && (!"01234567890ABCDEF".equals(f)))
        {
          paramContext = f;
          AppMethodBeat.o(186209);
          return paramContext;
        }
      }
      String str = a(paramContext, h);
      if (!"01234567890ABCDEF".equals(str)) {
        return str;
      }
      str = a(paramContext, g);
      if (!"01234567890ABCDEF".equals(str)) {
        return str;
      }
      str = h();
      a(paramContext, g, str);
      return str;
    }
    finally
    {
      f = "01234567890ABCDEF";
      AppMethodBeat.o(186209);
    }
    return "01234567890ABCDEF";
  }
  
  public static String h()
  {
    AppMethodBeat.i(186211);
    try
    {
      String str = UUID.randomUUID().toString();
      return str;
    }
    finally
    {
      AppMethodBeat.o(186211);
    }
    return "01234567890ABCDEF";
  }
  
  public static String h(Context paramContext)
  {
    AppMethodBeat.i(186184);
    paramContext = paramContext.getFilesDir().getAbsolutePath() + File.separator + c;
    AppMethodBeat.o(186184);
    return paramContext;
  }
  
  public static boolean i(Context paramContext)
  {
    AppMethodBeat.i(186226);
    try
    {
      paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (paramContext != null)
      {
        paramContext = paramContext.getActiveNetworkInfo();
        if (paramContext != null)
        {
          int k = paramContext.getType();
          if (k == 1)
          {
            AppMethodBeat.o(186226);
            return true;
          }
        }
      }
    }
    catch (Exception paramContext)
    {
      AppMethodBeat.o(186226);
    }
    return false;
  }
  
  public static boolean j(Context paramContext)
  {
    AppMethodBeat.i(186430);
    try
    {
      paramContext = (TelephonyManager)paramContext.getSystemService("phone");
      if (paramContext == null)
      {
        AppMethodBeat.o(186430);
        return false;
      }
      int k = paramContext.getSimState();
      if (k == 5)
      {
        AppMethodBeat.o(186430);
        return true;
      }
      AppMethodBeat.o(186430);
      return false;
    }
    catch (Exception paramContext)
    {
      AppMethodBeat.o(186430);
    }
    return false;
  }
  
  public static String k(Context paramContext)
  {
    AppMethodBeat.i(186192);
    try
    {
      paramContext = paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 128).metaData;
      if (paramContext != null)
      {
        boolean bool = paramContext.containsKey("TencentGeoLocationSDK");
        if (bool)
        {
          paramContext = paramContext.getString("TencentGeoLocationSDK");
          AppMethodBeat.o(186192);
          return paramContext;
        }
        bool = paramContext.containsKey("TencentMapSDK");
        if (bool)
        {
          paramContext = paramContext.getString("TencentMapSDK");
          AppMethodBeat.o(186192);
          return paramContext;
        }
        AppMethodBeat.o(186192);
        return "";
      }
    }
    catch (Exception paramContext)
    {
      AppMethodBeat.o(186192);
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     c.t.m.sapp.c.r
 * JD-Core Version:    0.7.0.1
 */