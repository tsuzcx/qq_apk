package c.t.m.sapp.c;

import android.annotation.SuppressLint;
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
import android.provider.Settings.System;
import android.telephony.TelephonyManager;
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
import org.json.JSONArray;
import org.json.JSONObject;

public class q
{
  public static final Object a;
  public static String b;
  public static String c;
  public static String d;
  public static long e;
  public static String f;
  public static HashMap<String, r> g;
  
  static
  {
    AppMethodBeat.i(210813);
    a = new Object();
    b = "TencentLocation_sapp/comp";
    c = "TencentLocation_sapp/odex";
    d = "complist_loading_sapp";
    e = 0L;
    f = "01234567890ABCDEF";
    g = new HashMap();
    AppMethodBeat.o(210813);
  }
  
  public static double a(double paramDouble)
  {
    return 3.141592653589793D * paramDouble / 180.0D;
  }
  
  public static double a(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4)
  {
    AppMethodBeat.i(210810);
    paramDouble1 = a(paramDouble1);
    paramDouble3 = a(paramDouble3);
    paramDouble2 = a(paramDouble2);
    paramDouble4 = a(paramDouble4);
    double d1 = Math.pow(Math.sin((paramDouble1 - paramDouble3) / 2.0D), 2.0D);
    paramDouble1 = Math.round(Math.asin(Math.sqrt(Math.cos(paramDouble1) * Math.cos(paramDouble3) * Math.pow(Math.sin((paramDouble2 - paramDouble4) / 2.0D), 2.0D) + d1)) * 2.0D * 6378.1369999999997D * 10000.0D) / 10000.0D;
    AppMethodBeat.o(210810);
    return paramDouble1 * 1000.0D;
  }
  
  public static r a(Context paramContext, String paramString)
  {
    AppMethodBeat.i(210772);
    if (g.containsKey(paramString))
    {
      paramContext = (r)g.get(paramString);
      AppMethodBeat.o(210772);
      return paramContext;
    }
    paramContext = new r(paramContext.getFilesDir().getAbsolutePath() + "/TencentLocation_sapp/conf/" + paramString);
    g.put(paramString, paramContext);
    AppMethodBeat.o(210772);
    return paramContext;
  }
  
  public static Long a(Context paramContext, String paramString, Long paramLong)
  {
    AppMethodBeat.i(210776);
    paramContext = a(paramContext, paramString).a(String.valueOf(paramLong));
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
    AppMethodBeat.o(210776);
    return paramLong;
  }
  
  public static String a(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(210775);
    paramContext = a(paramContext, paramString1).a(paramString2);
    AppMethodBeat.o(210775);
    return paramContext;
  }
  
  public static String a(File paramFile)
  {
    AppMethodBeat.i(210792);
    if (!paramFile.isFile())
    {
      AppMethodBeat.o(210792);
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
        int i = paramFile.read(arrayOfByte, 0, 1024);
        if (i == -1) {
          break;
        }
        localMessageDigest.update(arrayOfByte, 0, i);
      }
      paramFile.close();
    }
    catch (Exception paramFile)
    {
      AppMethodBeat.o(210792);
      return null;
    }
    paramFile = a(localMessageDigest.digest());
    AppMethodBeat.o(210792);
    return paramFile;
  }
  
  public static String a(List<a> paramList)
  {
    AppMethodBeat.i(210803);
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
    AppMethodBeat.o(210803);
    return paramList;
  }
  
  public static String a(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(210794);
    if (paramArrayOfByte == null)
    {
      AppMethodBeat.o(210794);
      return "";
    }
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      String str = Integer.toHexString(paramArrayOfByte[i] & 0xFF);
      if (str.length() == 1) {
        localStringBuffer.append("0");
      }
      localStringBuffer.append(str);
      i += 1;
    }
    paramArrayOfByte = localStringBuffer.toString().toLowerCase();
    AppMethodBeat.o(210794);
    return paramArrayOfByte;
  }
  
  public static List<String> a(Context paramContext, File paramFile)
  {
    AppMethodBeat.i(210782);
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
            int j = arrayOfFile.length;
            int i = 0;
            for (;;)
            {
              localContext = paramContext;
              localObject1 = paramFile;
              if (i >= j) {
                break;
              }
              localContext = arrayOfFile[i];
              paramFile.add(localContext.getName() + "," + localContext.length() + "," + a(localContext));
              paramContext = paramContext + localContext.getName() + "," + localContext.length() + "," + a(localContext) + ";";
              i += 1;
            }
          }
        }
      }
    }
    j.a("before check ,private dir files:".concat(String.valueOf(localContext)));
    AppMethodBeat.o(210782);
    return localObject1;
  }
  
  public static void a()
  {
    AppMethodBeat.i(210777);
    long l = System.currentTimeMillis();
    b = "TencentLocation/comp";
    c = "TencentLocation/odex";
    b = b + "_atuo_" + l;
    c = c + "_atuo_" + l;
    AppMethodBeat.o(210777);
  }
  
  public static void a(long paramLong)
  {
    AppMethodBeat.i(210797);
    try
    {
      Thread.sleep(paramLong);
      AppMethodBeat.o(210797);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      AppMethodBeat.o(210797);
    }
  }
  
  public static void a(Context paramContext)
  {
    AppMethodBeat.i(210778);
    if (paramContext == null)
    {
      AppMethodBeat.o(210778);
      return;
    }
    paramContext = new File(paramContext.getFilesDir().getAbsolutePath() + "/TencentLocation").listFiles();
    if ((paramContext != null) && (paramContext.length > 0))
    {
      int i = 0;
      while (i < paramContext.length)
      {
        Object localObject = paramContext[i];
        String str = localObject.getName();
        if ((localObject.isDirectory()) && (str.contains("_atuo_")) && (!b.contains(str)))
        {
          b(localObject.getAbsolutePath());
          localObject.delete();
        }
        i += 1;
      }
    }
    AppMethodBeat.o(210778);
  }
  
  public static boolean a(Context paramContext, String paramString1, String paramString2, String paramString3, long paramLong, byte[] paramArrayOfByte)
  {
    boolean bool1 = false;
    boolean bool2 = false;
    AppMethodBeat.i(210805);
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
        int i = paramContext.read(paramArrayOfByte);
        if (i <= 0) {
          break;
        }
        paramString2.write(paramArrayOfByte, 0, i);
      }
      j.a("copy base to private dir", paramContext);
    }
    catch (Exception paramContext)
    {
      bool1 = bool2;
    }
    for (;;)
    {
      AppMethodBeat.o(210805);
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
    AppMethodBeat.i(210804);
    List localList = e(a(paramContext, "__SP_UPDATE_TencentLoc_COMP_INFO__sapp_", ""));
    if (paramList.size() == 0)
    {
      AppMethodBeat.o(210804);
      return false;
    }
    if (localList.size() == 0)
    {
      bool = b(paramContext, "__SP_UPDATE_TencentLoc_COMP_INFO__sapp_", a(paramList));
      AppMethodBeat.o(210804);
      return bool;
    }
    int i = 0;
    if (i < localList.size())
    {
      a locala1 = (a)localList.get(i);
      int j = 0;
      for (;;)
      {
        if (j < paramList.size())
        {
          a locala2 = (a)paramList.get(j);
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
          i += 1;
          break;
        }
        j += 1;
      }
    }
    boolean bool = b(paramContext, "__SP_UPDATE_TencentLoc_COMP_INFO__sapp_", a(localList));
    AppMethodBeat.o(210804);
    return bool;
  }
  
  public static boolean a(String paramString)
  {
    AppMethodBeat.i(210808);
    Object localObject = new File(paramString);
    if (!((File)localObject).exists())
    {
      ((File)localObject).mkdirs();
      AppMethodBeat.o(210808);
      return true;
    }
    localObject = ((File)localObject).list();
    if ((localObject != null) && (localObject.length != 0))
    {
      int j = localObject.length;
      int i = 0;
      if (i < j)
      {
        File localFile = new File(paramString, localObject[i]);
        if (localFile.isDirectory())
        {
          b(localFile.getAbsolutePath());
          localFile.delete();
        }
        for (;;)
        {
          i += 1;
          break;
          localFile.delete();
        }
      }
      AppMethodBeat.o(210808);
      return true;
    }
    AppMethodBeat.o(210808);
    return true;
  }
  
  public static byte[] a(int paramInt)
  {
    AppMethodBeat.i(210800);
    byte[] arrayOfByte = new byte[2];
    int j = 0;
    int i = paramInt;
    paramInt = j;
    while (paramInt < 2)
    {
      arrayOfByte[paramInt] = Integer.valueOf(i & 0xFF).byteValue();
      i >>= 8;
      paramInt += 1;
    }
    AppMethodBeat.o(210800);
    return arrayOfByte;
  }
  
  public static int b()
  {
    return Build.VERSION.SDK_INT;
  }
  
  public static String b(Context paramContext)
  {
    AppMethodBeat.i(210786);
    try
    {
      paramContext = paramContext.getContentResolver();
      paramContext = Settings.System.getString(paramContext, "android_id");
      AppMethodBeat.o(210786);
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      AppMethodBeat.o(210786);
    }
    return "01234567890ABCDEF";
  }
  
  /* Error */
  public static String b(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: ldc_w 482
    //   3: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 110	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 111	java/lang/StringBuilder:<init>	()V
    //   13: astore_2
    //   14: aload_0
    //   15: invokevirtual 483	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   18: aload_1
    //   19: invokevirtual 366	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   22: astore_0
    //   23: new 485	java/io/BufferedReader
    //   26: dup
    //   27: new 487	java/io/InputStreamReader
    //   30: dup
    //   31: aload_0
    //   32: ldc_w 489
    //   35: invokespecial 492	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   38: invokespecial 495	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   41: astore_1
    //   42: aload_1
    //   43: invokevirtual 498	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   46: astore_3
    //   47: aload_3
    //   48: ifnull +26 -> 74
    //   51: aload_2
    //   52: aload_3
    //   53: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: pop
    //   57: goto -15 -> 42
    //   60: astore_0
    //   61: aload_2
    //   62: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   65: astore_0
    //   66: ldc_w 482
    //   69: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   72: aload_0
    //   73: areturn
    //   74: aload_1
    //   75: invokevirtual 499	java/io/BufferedReader:close	()V
    //   78: aload_0
    //   79: invokevirtual 414	java/io/InputStream:close	()V
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
  
  public static boolean b(Context paramContext, String paramString, Long paramLong)
  {
    AppMethodBeat.i(210774);
    boolean bool = a(paramContext, paramString).a(String.valueOf(paramLong).getBytes(), false);
    AppMethodBeat.o(210774);
    return bool;
  }
  
  public static boolean b(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(210773);
    boolean bool = a(paramContext, paramString1).a(paramString2.getBytes(), false);
    AppMethodBeat.o(210773);
    return bool;
  }
  
  public static boolean b(Context paramContext, String paramString1, String paramString2, String paramString3, long paramLong, byte[] paramArrayOfByte)
  {
    boolean bool2 = false;
    AppMethodBeat.i(210807);
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
        int i = paramString1.read(paramArrayOfByte);
        if (i <= 0) {
          break;
        }
        bool1 = bool2;
        paramContext.write(paramArrayOfByte, 0, i);
      }
      AppMethodBeat.o(210807);
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
    int i = 0;
    AppMethodBeat.i(210806);
    Object localObject = new File(paramString);
    if (!((File)localObject).exists())
    {
      AppMethodBeat.o(210806);
      return false;
    }
    localObject = ((File)localObject).list();
    if ((localObject != null) && (localObject.length != 0))
    {
      int j = localObject.length;
      if (i < j)
      {
        File localFile = new File(paramString, localObject[i]);
        if (localFile.isDirectory())
        {
          b(localFile.getAbsolutePath());
          localFile.delete();
        }
        for (;;)
        {
          i += 1;
          break;
          localFile.delete();
        }
      }
      AppMethodBeat.o(210806);
      return true;
    }
    AppMethodBeat.o(210806);
    return true;
  }
  
  /* Error */
  public static byte[] b(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: ldc_w 516
    //   3: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 368	java/io/ByteArrayOutputStream
    //   9: dup
    //   10: aload_0
    //   11: arraylength
    //   12: invokespecial 518	java/io/ByteArrayOutputStream:<init>	(I)V
    //   15: astore_1
    //   16: new 520	java/util/zip/GZIPOutputStream
    //   19: dup
    //   20: aload_1
    //   21: invokespecial 523	java/util/zip/GZIPOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   24: astore_2
    //   25: aload_2
    //   26: aload_0
    //   27: invokevirtual 524	java/util/zip/GZIPOutputStream:write	([B)V
    //   30: aload_2
    //   31: invokevirtual 525	java/util/zip/GZIPOutputStream:close	()V
    //   34: aload_1
    //   35: invokevirtual 399	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   38: astore_0
    //   39: aload_1
    //   40: invokevirtual 396	java/io/ByteArrayOutputStream:close	()V
    //   43: ldc_w 516
    //   46: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   57	1	1	localThrowable	Throwable
    //   24	7	2	localGZIPOutputStream	java.util.zip.GZIPOutputStream
    // Exception table:
    //   from	to	target	type
    //   6	39	51	java/lang/Throwable
    //   39	43	57	java/lang/Throwable
  }
  
  public static String c()
  {
    AppMethodBeat.i(210789);
    try
    {
      Object localObject = new StringBuilder();
      localObject = ((StringBuilder)localObject).append("/proc/").append(Process.myPid());
      localObject = new BufferedReader(new FileReader(new File("/cmdline")));
      String str2 = ((BufferedReader)localObject).readLine().trim();
      ((BufferedReader)localObject).close();
      AppMethodBeat.o(210789);
      return str2;
    }
    catch (Exception localException)
    {
      String str1 = j.a;
      AppMethodBeat.o(210789);
    }
    return null;
  }
  
  public static String c(Context paramContext)
  {
    AppMethodBeat.i(210779);
    try
    {
      String str = paramContext.getPackageName();
      paramContext = paramContext.getPackageManager().getPackageInfo(str, 0);
      str = paramContext.versionName;
      int i = paramContext.versionCode;
      if (str != null)
      {
        paramContext = str;
        if (str.trim().length() > 0) {}
      }
      else
      {
        paramContext = new StringBuilder();
        paramContext = "" + i;
        AppMethodBeat.o(210779);
        return paramContext;
      }
    }
    catch (Exception paramContext)
    {
      paramContext = "";
      AppMethodBeat.o(210779);
    }
    return paramContext;
  }
  
  public static String c(String paramString)
  {
    AppMethodBeat.i(210793);
    try
    {
      String str = a(MessageDigest.getInstance("MD5").digest(paramString.getBytes()));
      AppMethodBeat.o(210793);
      return str;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(210793);
    }
    return paramString;
  }
  
  /* Error */
  public static byte[] c(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: ldc_w 571
    //   6: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_0
    //   10: ifnull +273 -> 283
    //   13: aload_0
    //   14: arraylength
    //   15: ifeq +268 -> 283
    //   18: new 368	java/io/ByteArrayOutputStream
    //   21: dup
    //   22: invokespecial 369	java/io/ByteArrayOutputStream:<init>	()V
    //   25: astore 4
    //   27: new 573	java/io/ByteArrayInputStream
    //   30: dup
    //   31: aload_0
    //   32: invokespecial 575	java/io/ByteArrayInputStream:<init>	([B)V
    //   35: astore_0
    //   36: new 577	java/util/zip/GZIPInputStream
    //   39: dup
    //   40: aload_0
    //   41: invokespecial 580	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;)V
    //   44: astore_2
    //   45: ldc_w 581
    //   48: newarray byte
    //   50: astore_3
    //   51: aload_2
    //   52: aload_3
    //   53: invokevirtual 582	java/util/zip/GZIPInputStream:read	([B)I
    //   56: istore_1
    //   57: iload_1
    //   58: iflt +50 -> 108
    //   61: aload 4
    //   63: aload_3
    //   64: iconst_0
    //   65: iload_1
    //   66: invokevirtual 390	java/io/ByteArrayOutputStream:write	([BII)V
    //   69: goto -18 -> 51
    //   72: astore_3
    //   73: aload_2
    //   74: ifnull +7 -> 81
    //   77: aload_2
    //   78: invokevirtual 583	java/util/zip/GZIPInputStream:close	()V
    //   81: aload_0
    //   82: ifnull +7 -> 89
    //   85: aload_0
    //   86: invokevirtual 584	java/io/ByteArrayInputStream:close	()V
    //   89: aload 4
    //   91: astore_0
    //   92: aload 4
    //   94: ifnonnull +109 -> 203
    //   97: aload 5
    //   99: astore_3
    //   100: ldc_w 571
    //   103: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   106: aload_3
    //   107: areturn
    //   108: aload 4
    //   110: invokevirtual 399	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   113: astore_3
    //   114: aload_2
    //   115: invokevirtual 583	java/util/zip/GZIPInputStream:close	()V
    //   118: aload_0
    //   119: invokevirtual 584	java/io/ByteArrayInputStream:close	()V
    //   122: aload 4
    //   124: invokevirtual 396	java/io/ByteArrayOutputStream:close	()V
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
    //   146: invokevirtual 583	java/util/zip/GZIPInputStream:close	()V
    //   149: aload_0
    //   150: ifnull +7 -> 157
    //   153: aload_0
    //   154: invokevirtual 584	java/io/ByteArrayInputStream:close	()V
    //   157: aload 4
    //   159: ifnull +8 -> 167
    //   162: aload 4
    //   164: invokevirtual 396	java/io/ByteArrayOutputStream:close	()V
    //   167: ldc_w 571
    //   170: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   189: invokevirtual 583	java/util/zip/GZIPInputStream:close	()V
    //   192: aload_0
    //   193: ifnull +106 -> 299
    //   196: aload_0
    //   197: invokevirtual 584	java/io/ByteArrayInputStream:close	()V
    //   200: goto +99 -> 299
    //   203: aload_0
    //   204: invokevirtual 396	java/io/ByteArrayOutputStream:close	()V
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
    //   283: ldc_w 571
    //   286: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   56	10	1	i	int
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
    AppMethodBeat.i(210795);
    long l1 = 0L;
    try
    {
      StatFs localStatFs = new StatFs(Environment.getDataDirectory().getPath());
      long l2 = localStatFs.getBlockSize();
      int i = localStatFs.getAvailableBlocks();
      l1 = i * l2;
    }
    catch (Exception localException)
    {
      label41:
      break label41;
    }
    AppMethodBeat.o(210795);
    return l1;
  }
  
  public static String d(Context paramContext)
  {
    AppMethodBeat.i(210780);
    paramContext = paramContext.getFilesDir().getAbsolutePath() + File.separator + b;
    AppMethodBeat.o(210780);
    return paramContext;
  }
  
  public static String d(String paramString)
  {
    AppMethodBeat.i(210802);
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
        AppMethodBeat.o(210802);
        return null;
      }
      bool = paramString.equals("0");
      if (bool)
      {
        paramString = "";
        localObject1 = ((JSONObject)localObject1).getJSONArray("compList");
        int i = 0;
        while (i < ((JSONArray)localObject1).length())
        {
          Object localObject4 = ((JSONArray)localObject1).getJSONObject(i);
          int j = ((JSONObject)localObject4).getInt("compId");
          localObject3 = ((JSONObject)localObject4).getString("compVer");
          localObject2 = ((JSONObject)localObject4).getString("md5");
          int k = ((JSONObject)localObject4).getInt("size");
          localObject4 = ((JSONObject)localObject4).getString("compName");
          paramString = new StringBuilder().append(paramString).append(j);
          paramString = paramString.append(",").append((String)localObject3);
          paramString = paramString.append(",").append((String)localObject4);
          paramString = paramString.append(",").append(k);
          paramString = paramString.append(",").append((String)localObject2);
          paramString = ",;";
          i += 1;
        }
        AppMethodBeat.o(210802);
        return paramString;
      }
      bool = paramString.equals("-1");
      if (bool)
      {
        AppMethodBeat.o(210802);
        return null;
      }
      bool = paramString.equals("-2");
      if (bool)
      {
        AppMethodBeat.o(210802);
        return null;
      }
      bool = paramString.equals("-4");
      if (bool)
      {
        AppMethodBeat.o(210802);
        return null;
      }
      bool = paramString.equals("-5");
      if (bool)
      {
        AppMethodBeat.o(210802);
        return null;
      }
    }
    catch (Exception paramString)
    {
      e.b().a("DRG", "statucode:" + paramString.toString());
      AppMethodBeat.o(210802);
    }
    return null;
  }
  
  public static String e()
  {
    AppMethodBeat.i(210785);
    try
    {
      String str = Build.MANUFACTURER;
      str = str.replaceAll("[_]", "");
      AppMethodBeat.o(210785);
      return str;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(210785);
    }
    return "";
  }
  
  public static String e(Context paramContext)
  {
    AppMethodBeat.i(210787);
    String str = f(paramContext);
    paramContext = str;
    if (str == null) {
      paramContext = c();
    }
    AppMethodBeat.o(210787);
    return paramContext;
  }
  
  public static List<a> e(String paramString)
  {
    int i = 0;
    AppMethodBeat.i(210801);
    localArrayList = new ArrayList();
    for (;;)
    {
      try
      {
        paramString = paramString.split(";");
        int j = paramString.length;
        if (i < j)
        {
          arrayOfString = paramString[i];
          arrayOfString = arrayOfString.split(",");
          int k = arrayOfString.length;
          if (k < 5) {}
        }
      }
      catch (Exception paramString)
      {
        String[] arrayOfString;
        a locala;
        AppMethodBeat.o(210801);
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
      i += 1;
    }
  }
  
  public static String f()
  {
    AppMethodBeat.i(210784);
    try
    {
      String str = Build.MODEL;
      str = str.replaceAll("[_]", "");
      AppMethodBeat.o(210784);
      return str;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(210784);
    }
    return "";
  }
  
  public static String f(Context paramContext)
  {
    AppMethodBeat.i(210788);
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
          AppMethodBeat.o(210788);
          return paramContext;
        }
      }
    }
    catch (Exception paramContext)
    {
      paramContext = j.a;
      AppMethodBeat.o(210788);
    }
    return null;
  }
  
  public static int g()
  {
    AppMethodBeat.i(210790);
    int i = Process.myPid();
    AppMethodBeat.o(210790);
    return i;
  }
  
  public static int g(Context paramContext)
  {
    AppMethodBeat.i(210811);
    if (paramContext == null)
    {
      AppMethodBeat.o(210811);
      return -1;
    }
    boolean bool5 = k(paramContext);
    for (;;)
    {
      try
      {
        localObject = (WifiManager)paramContext.getSystemService("wifi");
        if (localObject == null) {
          continue;
        }
        bool1 = ((WifiManager)localObject).isWifiEnabled();
      }
      catch (Throwable localThrowable2)
      {
        Object localObject;
        boolean bool2;
        int k;
        boolean bool4;
        boolean bool3;
        int n;
        int m;
        boolean bool1 = false;
        continue;
        int j = 1;
        int i = 0;
        continue;
      }
      try
      {
        if (Build.VERSION.SDK_INT < 18) {
          continue;
        }
        bool2 = ((WifiManager)localObject).isScanAlwaysAvailable();
        if (!bool2) {
          continue;
        }
        j = 1;
        i = 1;
      }
      catch (Throwable localThrowable1) {}
      try
      {
        localObject = (LocationManager)paramContext.getSystemService("location");
        if (localObject == null) {
          continue;
        }
      }
      catch (Exception paramContext)
      {
        k = 0;
        bool2 = false;
        bool3 = false;
        n = k;
        continue;
        i = k + 512;
        continue;
        i = k + 256;
        continue;
        i = k + 128;
        continue;
        i = k + 64;
        continue;
      }
      try
      {
        paramContext = paramContext.getContentResolver();
        k = Settings.Secure.getInt(paramContext, "location_mode");
      }
      catch (Throwable paramContext)
      {
        k = 0;
        continue;
        bool2 = paramContext.contains("gps");
        continue;
      }
      try
      {
        bool4 = ((LocationManager)localObject).isProviderEnabled("gps");
        paramContext = ((LocationManager)localObject).getAllProviders();
        if (paramContext != null) {
          continue;
        }
        bool2 = false;
        bool3 = bool2;
        bool2 = bool4;
        n = k;
        if (bool5) {
          continue;
        }
        m = 1;
      }
      catch (Exception paramContext)
      {
        continue;
        m = 0;
        continue;
      }
      k = m;
      if (!bool1) {
        k = m + 2;
      }
      m = k;
      if (!bool2) {
        m = k + 4;
      }
      k = m;
      if (j == 0) {
        k = m + 8;
      }
      j = k;
      if (!bool3) {
        j = k + 16;
      }
      k = j;
      if (i == 0) {
        k = j + 32;
      }
      switch (n)
      {
      default: 
        i = k;
        AppMethodBeat.o(210811);
        return i;
        j = 0;
        i = 0;
        continue;
        bool1 = false;
        j = 0;
        i = 0;
      }
    }
  }
  
  @SuppressLint({"MissingPermission"})
  public static String h(Context paramContext)
  {
    AppMethodBeat.i(210791);
    Object localObject = f;
    if ((localObject != null) && (((String)localObject).length() != 0) && (!"01234567890ABCDEF".equals(f)))
    {
      paramContext = f;
      AppMethodBeat.o(210791);
      return paramContext;
    }
    try
    {
      localObject = (TelephonyManager)paramContext.getSystemService("phone");
      if (Build.VERSION.SDK_INT > 28) {}
      for (f = b(paramContext);; f = ((TelephonyManager)localObject).getImei())
      {
        paramContext = f;
        AppMethodBeat.o(210791);
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
        f = "01234567890ABCDEF";
        continue;
        f = ((TelephonyManager)localObject).getDeviceId();
      }
    }
  }
  
  public static String i(Context paramContext)
  {
    AppMethodBeat.i(210781);
    paramContext = paramContext.getFilesDir().getAbsolutePath() + File.separator + c;
    AppMethodBeat.o(210781);
    return paramContext;
  }
  
  public static boolean j(Context paramContext)
  {
    AppMethodBeat.i(210796);
    try
    {
      paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (paramContext != null)
      {
        paramContext = paramContext.getActiveNetworkInfo();
        if (paramContext != null)
        {
          int i = paramContext.getType();
          if (i == 1)
          {
            AppMethodBeat.o(210796);
            return true;
          }
        }
      }
    }
    catch (Exception paramContext)
    {
      AppMethodBeat.o(210796);
    }
    return false;
  }
  
  public static boolean k(Context paramContext)
  {
    AppMethodBeat.i(210812);
    try
    {
      paramContext = (TelephonyManager)paramContext.getSystemService("phone");
      if (paramContext == null)
      {
        AppMethodBeat.o(210812);
        return false;
      }
      int i = paramContext.getSimState();
      if (i == 5)
      {
        AppMethodBeat.o(210812);
        return true;
      }
      AppMethodBeat.o(210812);
      return false;
    }
    catch (Exception paramContext)
    {
      AppMethodBeat.o(210812);
    }
    return false;
  }
  
  public static String l(Context paramContext)
  {
    AppMethodBeat.i(210783);
    try
    {
      paramContext = paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 128).metaData;
      if (paramContext != null)
      {
        boolean bool = paramContext.containsKey("TencentGeoLocationSDK");
        if (bool)
        {
          paramContext = paramContext.getString("TencentGeoLocationSDK");
          AppMethodBeat.o(210783);
          return paramContext;
        }
        bool = paramContext.containsKey("TencentMapSDK");
        if (bool)
        {
          paramContext = paramContext.getString("TencentMapSDK");
          AppMethodBeat.o(210783);
          return paramContext;
        }
        AppMethodBeat.o(210783);
        return "";
      }
    }
    catch (Exception paramContext)
    {
      AppMethodBeat.o(210783);
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     c.t.m.sapp.c.q
 * JD-Core Version:    0.7.0.1
 */