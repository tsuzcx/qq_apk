package c.t.m.g;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.location.Location;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.os.Environment;
import android.telephony.NeighboringCellInfo;
import android.util.Log;
import com.tencent.map.geolocation.TencentLocationManagerOptions;
import com.tencent.map.geolocation.internal.TencentExtraKeys;
import com.tencent.map.geolocation.internal.TencentLog;
import com.tencent.tencentmap.lbssdk.service.e;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.GZIPOutputStream;
import java.util.zip.InflaterInputStream;
import javax.net.ssl.SSLException;
import org.eclipse.jdt.annotation.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

public final class j
  implements f
{
  private an a;
  
  public j(an paraman)
  {
    this.a = paraman;
  }
  
  private static double a(double paramDouble)
  {
    return 3.141592653589793D * paramDouble / 180.0D;
  }
  
  public static double a(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4)
  {
    paramDouble1 = a(paramDouble1);
    paramDouble3 = a(paramDouble3);
    paramDouble2 = a(paramDouble2);
    paramDouble4 = a(paramDouble4);
    double d = Math.pow(Math.sin((paramDouble1 - paramDouble3) / 2.0D), 2.0D);
    return Math.round(Math.asin(Math.sqrt(Math.cos(paramDouble1) * Math.cos(paramDouble3) * Math.pow(Math.sin((paramDouble2 - paramDouble4) / 2.0D), 2.0D) + d)) * 2.0D * 6378.1369999999997D * 10000.0D) / 10000.0D * 1000.0D;
  }
  
  public static double a(double paramDouble, int paramInt)
  {
    try
    {
      if (Double.isNaN(paramDouble)) {
        return 0.0D;
      }
      paramDouble = BigDecimal.valueOf(paramDouble).setScale(paramInt, RoundingMode.HALF_DOWN).doubleValue();
      return paramDouble;
    }
    catch (Exception localException) {}
    return 0.0D;
  }
  
  private static int a(char paramChar)
  {
    int j = 256;
    int i = j;
    if (paramChar >= 'A')
    {
      i = j;
      if (paramChar <= 'Z') {
        i = paramChar - 'A';
      }
    }
    j = i;
    if (paramChar >= 'a')
    {
      j = i;
      if (paramChar <= 'z') {
        j = paramChar - 'a' + 64;
      }
    }
    i = j;
    if (paramChar >= '0')
    {
      i = j;
      if (paramChar <= '9') {
        i = paramChar + '' - 48;
      }
    }
    return i;
  }
  
  @SuppressLint({"MissingPermission"})
  private static int a(WifiManager paramWifiManager)
  {
    if (paramWifiManager == null) {
      return 4;
    }
    try
    {
      int i = paramWifiManager.getWifiState();
      return i;
    }
    catch (Throwable paramWifiManager) {}
    return 4;
  }
  
  @SuppressLint({"MissingPermission"})
  public static cy a(Context paramContext)
  {
    try
    {
      ConnectivityManager localConnectivityManager = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (localConnectivityManager == null) {}
      for (paramContext = null; (paramContext == null) || (!paramContext.isConnected()); paramContext = localConnectivityManager.getActiveNetworkInfo()) {
        return cy.a;
      }
      if (Build.VERSION.SDK_INT >= 16)
      {
        if (localConnectivityManager.isActiveNetworkMetered()) {
          return cy.b;
        }
        return cy.c;
      }
      if (1 == paramContext.getType()) {
        return cy.c;
      }
      paramContext = cy.b;
      return paramContext;
    }
    catch (Throwable paramContext) {}
    return cy.a;
  }
  
  public static String a(ea paramea, boolean paramBoolean)
  {
    if (paramea == null) {
      return "[]";
    }
    int j = paramea.b;
    int k = paramea.c;
    int m = paramea.a.ordinal();
    Object localObject1 = new ArrayList();
    Object localObject2 = paramea.a();
    int i;
    int n;
    int i1;
    if (en.a(m, j, k, paramea.d, paramea.e))
    {
      i = paramea.d;
      int i2 = paramea.e;
      int i3 = paramea.f;
      n = paramea.g;
      i1 = paramea.h;
      paramea = new StringBuilder();
      paramea.append("{");
      paramea.append("\"mcc\":");
      paramea.append(j);
      paramea.append(",\"mnc\":");
      paramea.append(k);
      paramea.append(",\"lac\":");
      paramea.append(i);
      paramea.append(",\"cellid\":");
      paramea.append(i2);
      paramea.append(",\"rss\":");
      paramea.append(i3);
      paramea.append(",\"seed\":");
      if (paramBoolean)
      {
        i = 1;
        paramea.append(i);
        paramea.append(",\"networktype\":");
        paramea.append(m);
        if ((n != 2147483647) && (i1 != 2147483647))
        {
          paramea.append(",\"stationLat\":");
          paramea.append(String.format("%.6f", new Object[] { Float.valueOf(n / 14400.0F) }));
          paramea.append(",\"stationLng\":");
          paramea.append(String.format("%.6f", new Object[] { Float.valueOf(i1 / 14400.0F) }));
        }
        paramea.append("}");
        ((ArrayList)localObject1).add(paramea.toString());
      }
    }
    for (;;)
    {
      try
      {
        paramea = ((List)localObject2).iterator();
        if (paramea.hasNext())
        {
          localObject2 = (NeighboringCellInfo)paramea.next();
          i = ((NeighboringCellInfo)localObject2).getLac();
          n = ((NeighboringCellInfo)localObject2).getCid();
          if (!en.a(m, j, k, i, n)) {
            break label582;
          }
          i1 = ((NeighboringCellInfo)localObject2).getRssi();
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("{");
          ((StringBuilder)localObject2).append("\"mcc\":");
          ((StringBuilder)localObject2).append(j);
          ((StringBuilder)localObject2).append(",\"mnc\":");
          ((StringBuilder)localObject2).append(k);
          ((StringBuilder)localObject2).append(",\"lac\":");
          ((StringBuilder)localObject2).append(i);
          ((StringBuilder)localObject2).append(",\"cellid\":");
          ((StringBuilder)localObject2).append(n);
          ((StringBuilder)localObject2).append(",\"rss\":");
          ((StringBuilder)localObject2).append((i1 << 1) - 113);
          ((StringBuilder)localObject2).append("}");
          ((ArrayList)localObject1).add(((StringBuilder)localObject2).toString());
          continue;
        }
        i = 0;
      }
      catch (Exception paramea)
      {
        paramea = new StringBuilder("[");
        localObject2 = new ep(",");
        localObject1 = ((Iterable)localObject1).iterator();
        paramea.append(((ep)localObject2).a(new StringBuilder(), (Iterator)localObject1).toString());
        paramea.append("]");
        return paramea.toString();
      }
      break;
      a("illeagal main cell! ", j, k, m, paramea.d, paramea.e);
      continue;
      label582:
      a("illeagal neighboringCell! ", j, k, m, i, n);
    }
  }
  
  public static void a(Closeable paramCloseable)
  {
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      return;
    }
    catch (IOException paramCloseable) {}
  }
  
  private static void a(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    boolean bool = true;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getCellInfoWithJsonFormat: ");
    localStringBuilder.append(paramString);
    paramString = localStringBuilder.append("isGsm=");
    if (paramInt3 == 1) {}
    for (;;)
    {
      paramString.append(bool);
      localStringBuilder.append(", mcc,mnc=").append(paramInt1).append(",").append(paramInt2);
      localStringBuilder.append(", lac,cid=").append(paramInt4).append(",").append(paramInt5);
      return;
      bool = false;
    }
  }
  
  public static void a(String paramString1, int paramInt, String paramString2)
  {
    TencentLog localTencentLog = TencentExtraKeys.getTencentLog();
    if ((paramString2 != null) && (localTencentLog != null)) {
      localTencentLog.println(paramString1, paramInt, paramString2);
    }
  }
  
  public static void a(String paramString1, String paramString2, Throwable paramThrowable)
  {
    a(paramString1, 6, paramString2 + " exception: " + Log.getStackTraceString(paramThrowable));
  }
  
  public static void a(String paramString, byte[] paramArrayOfByte, cx paramcx, int paramInt)
  {
    for (;;)
    {
      try
      {
        HttpURLConnection localHttpURLConnection = (HttpURLConnection)new URL(paramString).openConnection();
        localHttpURLConnection.setRequestProperty("User-Agent", "Dalvik/1.6.0 (Linux; U; Android 4.4; Nexus 5 Build/KRT16M)");
        localHttpURLConnection.setRequestMethod("POST");
        localHttpURLConnection.setConnectTimeout(10000);
        localHttpURLConnection.setDoOutput(true);
        localHttpURLConnection.setFixedLengthStreamingMode(paramArrayOfByte.length);
        Object localObject = localHttpURLConnection.getOutputStream();
        ((OutputStream)localObject).write(paramArrayOfByte);
        ((OutputStream)localObject).flush();
        ((OutputStream)localObject).close();
        int i = localHttpURLConnection.getResponseCode();
        switch (i)
        {
        case 200: 
          paramcx.a("net sdk error: " + i);
          localHttpURLConnection.disconnect();
          return;
          localObject = g(localHttpURLConnection.getHeaderField("content-type"));
          new String(a(localHttpURLConnection.getInputStream()), (String)localObject);
          paramcx.a();
        }
      }
      catch (Throwable localThrowable)
      {
        if ((paramInt <= 0) && (((localThrowable instanceof GeneralSecurityException)) || ((localThrowable instanceof SSLException))))
        {
          paramString = paramString.replaceAll("https:", "http:");
          paramInt += 1;
        }
        else
        {
          paramcx.a(paramInt + "," + paramString + "," + Log.getStackTraceString(localThrowable));
          return;
        }
      }
    }
  }
  
  public static boolean a(Location paramLocation, double[] paramArrayOfDouble)
  {
    int k = (int)(paramLocation.getLatitude() * 1000000.0D);
    int m = (int)(paramLocation.getLongitude() * 1000000.0D);
    paramLocation = e("tencent_loc_lib");
    int i = 0;
    int j = 0;
    while (i < paramLocation.length())
    {
      j += a(paramLocation.charAt(i));
      i += 1;
    }
    paramLocation = new double[2];
    try
    {
      e.b(k ^ j, j ^ m, paramLocation);
      label76:
      paramArrayOfDouble[0] = paramLocation[0];
      paramArrayOfDouble[1] = paramLocation[1];
      return true;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      break label76;
    }
  }
  
  public static boolean a(List paramList)
  {
    return (paramList == null) || (paramList.size() == 0);
  }
  
  public static boolean a(byte[] paramArrayOfByte)
  {
    return (paramArrayOfByte == null) || (paramArrayOfByte.length == 0);
  }
  
  public static boolean a(double[] paramArrayOfDouble1, double[] paramArrayOfDouble2)
  {
    if (TencentLocationManagerOptions.isLoadLibraryEnabled()) {}
    int k;
    int m;
    int j;
    try
    {
      System.loadLibrary("tencentloc");
      k = (int)(paramArrayOfDouble1[0] * 1000000.0D);
      m = (int)(paramArrayOfDouble1[1] * 1000000.0D);
      paramArrayOfDouble1 = e("tencent_loc_lib");
      int i = 0;
      j = 0;
      while (i < paramArrayOfDouble1.length())
      {
        j += a(paramArrayOfDouble1.charAt(i));
        i += 1;
      }
      paramArrayOfDouble1 = new double[2];
    }
    catch (Throwable paramArrayOfDouble1)
    {
      new StringBuilder("LOAD:").append(paramArrayOfDouble1.toString());
      return false;
    }
    try
    {
      e.b(k ^ j, j ^ m, paramArrayOfDouble1);
      paramArrayOfDouble2[0] = paramArrayOfDouble1[0];
      paramArrayOfDouble2[1] = paramArrayOfDouble1[1];
      return true;
    }
    catch (Throwable paramArrayOfDouble1)
    {
      new StringBuilder("E.B:").append(paramArrayOfDouble1.toString());
    }
    return false;
  }
  
  /* Error */
  public static byte[] a(File paramFile)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 484	java/io/File:exists	()Z
    //   4: ifeq +12 -> 16
    //   7: aload_0
    //   8: invokevirtual 487	java/io/File:length	()J
    //   11: lconst_0
    //   12: lcmp
    //   13: ifne +7 -> 20
    //   16: iconst_0
    //   17: newarray byte
    //   19: areturn
    //   20: new 489	java/io/ByteArrayOutputStream
    //   23: dup
    //   24: invokespecial 490	java/io/ByteArrayOutputStream:<init>	()V
    //   27: astore 4
    //   29: sipush 4096
    //   32: newarray byte
    //   34: astore_3
    //   35: new 492	java/io/BufferedInputStream
    //   38: dup
    //   39: new 494	java/io/FileInputStream
    //   42: dup
    //   43: aload_0
    //   44: invokespecial 497	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   47: invokespecial 500	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   50: astore_2
    //   51: aload_2
    //   52: astore_0
    //   53: aload_2
    //   54: aload_3
    //   55: invokevirtual 504	java/io/BufferedInputStream:read	([B)I
    //   58: istore_1
    //   59: iload_1
    //   60: iconst_m1
    //   61: if_icmpeq +39 -> 100
    //   64: aload_2
    //   65: astore_0
    //   66: aload 4
    //   68: aload_3
    //   69: iconst_0
    //   70: iload_1
    //   71: invokevirtual 507	java/io/ByteArrayOutputStream:write	([BII)V
    //   74: goto -23 -> 51
    //   77: astore_3
    //   78: aload_2
    //   79: astore_0
    //   80: aload_3
    //   81: astore_2
    //   82: aload_2
    //   83: athrow
    //   84: astore_3
    //   85: aload_0
    //   86: astore_2
    //   87: aload_3
    //   88: astore_0
    //   89: aload_2
    //   90: invokestatic 509	c/t/m/g/j:a	(Ljava/io/Closeable;)V
    //   93: aload 4
    //   95: invokestatic 509	c/t/m/g/j:a	(Ljava/io/Closeable;)V
    //   98: aload_0
    //   99: athrow
    //   100: aload_2
    //   101: astore_0
    //   102: aload 4
    //   104: invokevirtual 513	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   107: astore_3
    //   108: aload_2
    //   109: invokestatic 509	c/t/m/g/j:a	(Ljava/io/Closeable;)V
    //   112: aload 4
    //   114: invokestatic 509	c/t/m/g/j:a	(Ljava/io/Closeable;)V
    //   117: aload_3
    //   118: areturn
    //   119: astore_0
    //   120: aconst_null
    //   121: astore_2
    //   122: goto -33 -> 89
    //   125: astore_2
    //   126: aconst_null
    //   127: astore_0
    //   128: goto -46 -> 82
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	131	0	paramFile	File
    //   58	13	1	i	int
    //   50	72	2	localObject1	Object
    //   125	1	2	localIOException1	IOException
    //   34	35	3	arrayOfByte1	byte[]
    //   77	4	3	localIOException2	IOException
    //   84	4	3	localObject2	Object
    //   107	11	3	arrayOfByte2	byte[]
    //   27	86	4	localByteArrayOutputStream	ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   53	59	77	java/io/IOException
    //   66	74	77	java/io/IOException
    //   102	108	77	java/io/IOException
    //   53	59	84	finally
    //   66	74	84	finally
    //   82	84	84	finally
    //   102	108	84	finally
    //   35	51	119	finally
    //   35	51	125	java/io/IOException
  }
  
  private static byte[] a(InputStream paramInputStream)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream(256);
    byte[] arrayOfByte = new byte[256];
    for (;;)
    {
      int i = paramInputStream.read(arrayOfByte);
      if (i == -1) {
        break;
      }
      localByteArrayOutputStream.write(arrayOfByte, 0, i);
    }
    paramInputStream.close();
    return localByteArrayOutputStream.toByteArray();
  }
  
  public static int b(Context paramContext)
  {
    try
    {
      int i = a((WifiManager)paramContext.getSystemService("wifi"));
      return i;
    }
    catch (Throwable paramContext) {}
    return 4;
  }
  
  public static void b(String paramString)
  {
    a("#", 4, paramString);
  }
  
  public static byte[] b(byte[] paramArrayOfByte)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    try
    {
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream(paramArrayOfByte.length);
      localObject1 = localObject2;
      GZIPOutputStream localGZIPOutputStream = new GZIPOutputStream(localByteArrayOutputStream);
      localObject1 = localObject2;
      localGZIPOutputStream.write(paramArrayOfByte);
      localObject1 = localObject2;
      localGZIPOutputStream.close();
      localObject1 = localObject2;
      paramArrayOfByte = localByteArrayOutputStream.toByteArray();
      localObject1 = paramArrayOfByte;
      localByteArrayOutputStream.close();
      return paramArrayOfByte;
    }
    catch (Throwable paramArrayOfByte) {}
    return localObject1;
  }
  
  @SuppressLint({"MissingPermission"})
  public static String c(Context paramContext)
  {
    if (paramContext == null) {
      return "{}";
    }
    try
    {
      Object localObject1 = (WifiManager)paramContext.getSystemService("wifi");
      Object localObject2 = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if ((localObject1 != null) && (localObject2 != null))
      {
        paramContext = ((WifiManager)localObject1).getConnectionInfo();
        localObject1 = ((ConnectivityManager)localObject2).getNetworkInfo(1);
        if ((paramContext != null) && (localObject1 != null) && (((NetworkInfo)localObject1).isConnected()))
        {
          localObject1 = paramContext.getBSSID();
          if ((localObject1 == null) || (((String)localObject1).equals("000000000000")) || (((String)localObject1).equals("00-00-00-00-00-00")) || (((String)localObject1).equals("00:00:00:00:00:00"))) {
            break label236;
          }
          int i = paramContext.getRssi();
          if ((i < -100) || (i > -20)) {
            break label240;
          }
          paramContext = paramContext.getSSID().replace("\"", "").replace("|", "");
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("{");
          ((StringBuilder)localObject2).append("\"mac\":\"");
          ((StringBuilder)localObject2).append((String)localObject1);
          ((StringBuilder)localObject2).append("\",\"rssi\":");
          ((StringBuilder)localObject2).append(i);
          ((StringBuilder)localObject2).append(",\"ssid\":\"");
          ((StringBuilder)localObject2).append(paramContext);
          ((StringBuilder)localObject2).append("\"}");
          paramContext = ((StringBuilder)localObject2).toString();
          return paramContext;
        }
        return "{}";
      }
    }
    catch (Throwable paramContext)
    {
      return "{}";
    }
    return "{}";
    label236:
    return "{}";
    label240:
    return "{}";
  }
  
  public static String c(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    return str;
  }
  
  public static byte[] c(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    DeflaterOutputStream localDeflaterOutputStream = new DeflaterOutputStream(localByteArrayOutputStream);
    try
    {
      localDeflaterOutputStream.write(paramArrayOfByte, 0, paramArrayOfByte.length);
      localDeflaterOutputStream.finish();
      localDeflaterOutputStream.flush();
      localDeflaterOutputStream.close();
      return localByteArrayOutputStream.toByteArray();
    }
    catch (Exception paramArrayOfByte) {}
    return null;
  }
  
  public static int d(Context paramContext)
  {
    paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (paramContext == null) {}
    for (int i = 1; i != 0; i = 0) {
      return -1;
    }
    try
    {
      paramContext = paramContext.getActiveNetworkInfo();
      if (paramContext != null)
      {
        i = paramContext.getType();
        return i;
      }
    }
    catch (Exception paramContext) {}
    return -1;
  }
  
  public static boolean d(String paramString)
  {
    do
    {
      JSONObject localJSONObject;
      do
      {
        try
        {
          localJSONObject = new JSONObject(paramString);
          if (paramString.contains("latitude")) {
            return true;
          }
        }
        catch (Exception paramString)
        {
          return false;
        }
        paramString = localJSONObject.optJSONArray("cells");
      } while ((paramString != null) && (paramString.length() > 0));
      paramString = localJSONObject.optJSONArray("wifis");
    } while ((paramString != null) && (paramString.length() > 0));
    return false;
  }
  
  @Nullable
  public static byte[] d(byte[] paramArrayOfByte)
  {
    int i = 0;
    if (paramArrayOfByte == null) {
      return null;
    }
    ByteArrayInputStream localByteArrayInputStream = new ByteArrayInputStream(paramArrayOfByte);
    InflaterInputStream localInflaterInputStream = new InflaterInputStream(localByteArrayInputStream);
    paramArrayOfByte = new byte[0];
    byte[] arrayOfByte2 = new byte[1024];
    for (;;)
    {
      try
      {
        int j = localInflaterInputStream.read(arrayOfByte2);
        if (j > 0)
        {
          i += j;
          byte[] arrayOfByte1 = new byte[i];
          System.arraycopy(paramArrayOfByte, 0, arrayOfByte1, 0, paramArrayOfByte.length);
          System.arraycopy(arrayOfByte2, 0, arrayOfByte1, paramArrayOfByte.length, j);
          paramArrayOfByte = arrayOfByte1;
          if (j <= 0) {
            try
            {
              localByteArrayInputStream.close();
              localInflaterInputStream.close();
              return paramArrayOfByte;
            }
            catch (IOException paramArrayOfByte)
            {
              return null;
            }
          }
        }
      }
      catch (Exception paramArrayOfByte)
      {
        return null;
      }
    }
  }
  
  public static String e(String paramString)
  {
    try
    {
      Object localObject = MessageDigest.getInstance("MD5");
      ((MessageDigest)localObject).update(paramString.getBytes());
      localObject = ((MessageDigest)localObject).digest();
      StringBuilder localStringBuilder = new StringBuilder();
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        localStringBuilder.append(Integer.toHexString(localObject[i] & 0xFF)).append("");
        i += 1;
      }
      localObject = localStringBuilder.toString();
      return localObject;
    }
    catch (Exception localException) {}
    return paramString;
  }
  
  public static boolean e(Context paramContext)
  {
    int i = 1;
    Object localObject = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (localObject == null) {}
    while (i != 0)
    {
      return false;
      i = 0;
    }
    for (;;)
    {
      try
      {
        paramContext = ((ConnectivityManager)localObject).getNetworkInfo(0);
        localObject = ((ConnectivityManager)localObject).getNetworkInfo(1);
        if (localObject != null)
        {
          boolean bool2 = ((NetworkInfo)localObject).isConnected();
          bool1 = bool2;
          if (!bool2)
          {
            bool1 = bool2;
            if (paramContext != null) {
              bool1 = paramContext.isConnected();
            }
          }
          return bool1;
        }
      }
      catch (Exception paramContext)
      {
        return false;
      }
      boolean bool1 = false;
    }
  }
  
  public static int f(Context paramContext)
  {
    try
    {
      Object localObject2 = paramContext.getPackageManager().getInstalledPackages(8192);
      Object localObject1 = "B2E6AD38C9EA55FC,8B51908CDE852ABE,6F350C90F0B8C2F7,18A9EF1D9AFDB74D,B0F7B644A29E1C82,2E0111E09CC76BBD,8FFA91856B5C9ED1,569EA369CE0CE6BE,490A7AD1901C1407,15A805FD6A78BF07,92DFF18D49ED5200,D80FF7253FEDC748,2044A6443164DDC8,488324C2DC64A6D5,E0EC01B2D80C2E57".split(",");
      localObject2 = ((List)localObject2).iterator();
      PackageInfo localPackageInfo;
      int j;
      int i;
      boolean bool;
      while (((Iterator)localObject2).hasNext())
      {
        localPackageInfo = (PackageInfo)((Iterator)localObject2).next();
        j = localObject1.length;
        i = 0;
        while (i < j)
        {
          String str = localObject1[i];
          bool = h(localPackageInfo.packageName).equalsIgnoreCase(str);
          if (bool) {
            return 1;
          }
          i += 1;
        }
      }
      try
      {
        paramContext.getPackageManager();
        paramContext = "B2E6AD38C9EA55FC,8B51908CDE852ABE,6F350C90F0B8C2F7,18A9EF1D9AFDB74D,B0F7B644A29E1C82,2E0111E09CC76BBD,8FFA91856B5C9ED1,569EA369CE0CE6BE,490A7AD1901C1407,15A805FD6A78BF07,92DFF18D49ED5200,D80FF7253FEDC748,2044A6443164DDC8,488324C2DC64A6D5,E0EC01B2D80C2E57".split(",");
        localObject1 = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + File.separatorChar + "Android" + File.separatorChar + "data").listFiles();
        int k = localObject1.length;
        i = 0;
        while (i < k)
        {
          localObject2 = localObject1[i];
          int m = paramContext.length;
          j = 0;
          while (j < m)
          {
            localPackageInfo = paramContext[j];
            bool = h(((File)localObject2).getName()).equalsIgnoreCase(localPackageInfo);
            if (bool) {
              return 1;
            }
            j += 1;
          }
          i += 1;
        }
        return 2;
      }
      catch (Throwable paramContext)
      {
        return 3;
      }
    }
    catch (Throwable paramContext)
    {
      return 3;
    }
  }
  
  public static int f(String paramString)
  {
    if ((paramString.startsWith("fc4")) || (paramString.startsWith("dc4"))) {
      return 4;
    }
    if ((paramString.startsWith("fc3")) || (paramString.startsWith("dc3"))) {
      return 3;
    }
    if ((paramString.startsWith("fc2")) || (paramString.startsWith("dc2"))) {
      return 2;
    }
    if ((paramString.startsWith("fc1")) || (paramString.startsWith("fc")) || (paramString.startsWith("dc"))) {
      return 1;
    }
    return -1;
  }
  
  private static String g(String paramString)
  {
    String str2 = "GBK";
    String str1 = str2;
    int j;
    int i;
    if (paramString != null)
    {
      paramString = paramString.split(";");
      j = paramString.length;
      i = 0;
    }
    for (;;)
    {
      str1 = str2;
      if (i < j)
      {
        str1 = paramString[i].trim();
        int k = str1.indexOf("charset=");
        if (-1 != k) {
          str1 = str1.substring(k + 8, str1.length());
        }
      }
      else
      {
        return str1;
      }
      i += 1;
    }
  }
  
  private static String h(String paramString)
  {
    try
    {
      Object localObject = MessageDigest.getInstance("MD5");
      ((MessageDigest)localObject).update(paramString.getBytes());
      byte[] arrayOfByte = ((MessageDigest)localObject).digest();
      StringBuilder localStringBuilder = new StringBuilder();
      int j = arrayOfByte.length;
      int i = 0;
      while (i < j)
      {
        String str = Integer.toHexString(arrayOfByte[i] & 0xFF);
        localObject = str;
        if (str.length() != 2) {
          localObject = "0" + str;
        }
        localStringBuilder.append((String)localObject).append("");
        i += 1;
      }
      localObject = localStringBuilder.toString().substring(8, 24);
      return localObject;
    }
    catch (Exception localException) {}
    return paramString;
  }
  
  public final int a()
  {
    return this.a.a;
  }
  
  public final String a(String paramString)
  {
    return this.a.a(paramString);
  }
  
  public final String b()
  {
    return this.a.b;
  }
  
  public final int c()
  {
    return this.a.c;
  }
  
  public final byte[] d()
  {
    return this.a.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     c.t.m.g.j
 * JD-Core Version:    0.7.0.1
 */