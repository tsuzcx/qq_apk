package com.pay.tool;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Proxy;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.os.Parcel;
import android.provider.Settings.System;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.text.format.Formatter;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import com.pay.data.report.APDataReportManager;
import com.pay.paychannel.hfpay.APHFChannel;
import com.tencent.midas.comm.APLog;
import com.tencent.midas.plugin.APPluginActivity;
import java.io.ByteArrayInputStream;
import java.io.CharConversionException;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InvalidClassException;
import java.io.InvalidObjectException;
import java.io.NotActiveException;
import java.io.NotSerializableException;
import java.io.OptionalDataException;
import java.io.PrintWriter;
import java.io.StreamCorruptedException;
import java.io.StringWriter;
import java.io.SyncFailedException;
import java.io.UTFDataFormatException;
import java.io.UnsupportedEncodingException;
import java.io.WriteAbortedException;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.net.BindException;
import java.net.ConnectException;
import java.net.HttpRetryException;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.NetworkInterface;
import java.net.NoRouteToHostException;
import java.net.PortUnreachableException;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.net.UnknownServiceException;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.FileLockInterruptionException;
import java.nio.charset.MalformedInputException;
import java.nio.charset.UnmappableCharacterException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.X509Certificate;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.InvalidPropertiesFormatException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLKeyException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLProtocolException;
import javax.security.cert.CertificateExpiredException;
import midas.x.a;
import midas.x.ap;
import midas.x.aq;
import midas.x.d;
import midas.x.e;
import midas.x.el;
import midas.x.em;
import midas.x.et;
import midas.x.eu;
import midas.x.fa;
import midas.x.fy;
import midas.x.fz;
import midas.x.gb;
import midas.x.kz;
import org.apache.http.conn.ConnectTimeoutException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class APTools
{
  public static long a = 0L;
  public static long b = 0L;
  public static long c = 0L;
  public static String d = "";
  public static String e = "SfjUddAdIdxnd4v4";
  public static NumberFormat f = ;
  private static final String g = "APTools";
  private static String h = "";
  private static String i = "";
  private static String j = "";
  private static String k = "";
  private static String l = "";
  private static boolean m = false;
  private static String n = "com.tencent.mm.sdk";
  private static String o = "com.tencent.mm.opensdk";
  private static int p = -1;
  
  public static int a(Exception paramException)
  {
    if (paramException == null) {
      return -10;
    }
    if ((paramException instanceof CharConversionException)) {
      return -20;
    }
    if ((paramException instanceof MalformedInputException)) {
      return -21;
    }
    if ((paramException instanceof UnmappableCharacterException)) {
      return -22;
    }
    if ((paramException instanceof ClosedChannelException)) {
      return -24;
    }
    if ((paramException instanceof EOFException)) {
      return -26;
    }
    if ((paramException instanceof FileLockInterruptionException)) {
      return -27;
    }
    if ((paramException instanceof FileNotFoundException)) {
      return -28;
    }
    if ((paramException instanceof HttpRetryException)) {
      return -29;
    }
    if ((paramException instanceof ConnectTimeoutException)) {
      return -7;
    }
    if ((paramException instanceof SocketTimeoutException)) {
      return -8;
    }
    if ((paramException instanceof InvalidPropertiesFormatException)) {
      return -30;
    }
    if ((paramException instanceof MalformedURLException)) {
      return -3;
    }
    if ((paramException instanceof InvalidClassException)) {
      return -33;
    }
    if ((paramException instanceof InvalidObjectException)) {
      return -34;
    }
    if ((paramException instanceof NotActiveException)) {
      return -35;
    }
    if ((paramException instanceof NotSerializableException)) {
      return -36;
    }
    if ((paramException instanceof OptionalDataException)) {
      return -37;
    }
    if ((paramException instanceof StreamCorruptedException)) {
      return -38;
    }
    if ((paramException instanceof WriteAbortedException)) {
      return -39;
    }
    if ((paramException instanceof ProtocolException)) {
      return -40;
    }
    if ((paramException instanceof SSLHandshakeException))
    {
      while (paramException != null)
      {
        String str = g;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("https exception");
        localStringBuilder.append(paramException.toString());
        APLog.d(str, localStringBuilder.toString());
        if (a(paramException)) {
          return -55;
        }
        if (b(paramException)) {
          return -56;
        }
        if (c(paramException)) {
          return -58;
        }
        paramException = paramException.getCause();
      }
      return -41;
    }
    if ((paramException instanceof SSLKeyException)) {
      return -42;
    }
    if ((paramException instanceof SSLPeerUnverifiedException)) {
      return -43;
    }
    if ((paramException instanceof SSLProtocolException)) {
      return -44;
    }
    if ((paramException instanceof BindException)) {
      return -45;
    }
    if ((paramException instanceof ConnectException)) {
      return -46;
    }
    if ((paramException instanceof NoRouteToHostException)) {
      return -47;
    }
    if ((paramException instanceof PortUnreachableException)) {
      return -48;
    }
    if ((paramException instanceof SyncFailedException)) {
      return -49;
    }
    if ((paramException instanceof UTFDataFormatException)) {
      return -50;
    }
    if ((paramException instanceof UnknownHostException)) {
      return -51;
    }
    if ((paramException instanceof UnknownServiceException)) {
      return -52;
    }
    if ((paramException instanceof UnsupportedEncodingException)) {
      return -53;
    }
    if ((paramException instanceof ZipException)) {
      return -54;
    }
    paramException = paramException.toString();
    if ((paramException != null) && (paramException.contains("Connection reset by peer"))) {
      return -57;
    }
    return -6;
  }
  
  public static int a(kz paramkz)
  {
    if (paramkz.c == null) {
      return paramkz.a;
    }
    paramkz = paramkz.c;
    if ((paramkz instanceof ConnectTimeoutException)) {
      return 20001;
    }
    if ((paramkz instanceof SocketTimeoutException)) {
      return 20002;
    }
    if ((paramkz instanceof IOException)) {
      return 20005;
    }
    return 20000;
  }
  
  public static Bundle a(JSONObject paramJSONObject)
  {
    Bundle localBundle = new Bundle();
    if (paramJSONObject == null) {
      return localBundle;
    }
    Iterator localIterator = paramJSONObject.keys();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Object localObject = paramJSONObject.opt(str);
      if (localObject != null) {
        if ((localObject instanceof Boolean)) {
          localBundle.putBoolean(str, paramJSONObject.optBoolean(str));
        } else if ((localObject instanceof Byte)) {
          localBundle.putByte(str, (byte)paramJSONObject.optInt(str));
        } else if ((localObject instanceof Character)) {
          localBundle.putChar(str, paramJSONObject.optString(str).toCharArray()[0]);
        } else if ((localObject instanceof Double)) {
          localBundle.putDouble(str, paramJSONObject.optDouble(str));
        } else if ((localObject instanceof Float)) {
          localBundle.putFloat(str, (float)paramJSONObject.optDouble(str));
        } else if ((localObject instanceof Integer)) {
          localBundle.putInt(str, paramJSONObject.optInt(str));
        } else if ((localObject instanceof Long)) {
          localBundle.putLong(str, paramJSONObject.optLong(str));
        } else if ((localObject instanceof Short)) {
          localBundle.putShort(str, (short)paramJSONObject.optInt(str));
        } else if ((localObject instanceof String)) {
          localBundle.putString(str, paramJSONObject.optString(str));
        } else if ((localObject instanceof JSONArray)) {
          localBundle.putString(str, ((JSONArray)localObject).toString());
        } else if ((localObject instanceof JSONObject)) {
          localBundle.putString(str, ((JSONObject)localObject).toString());
        }
      }
    }
    return localBundle;
  }
  
  public static Object a(Object paramObject)
  {
    if (paramObject == null) {
      return JSONObject.NULL;
    }
    if (!(paramObject instanceof JSONArray))
    {
      if ((paramObject instanceof JSONObject)) {
        return paramObject;
      }
      if (paramObject.equals(JSONObject.NULL)) {
        return paramObject;
      }
    }
    JSONArray localJSONArray;
    try
    {
      if ((paramObject instanceof Collection)) {
        return new JSONArray((Collection)paramObject);
      }
      if (paramObject.getClass().isArray())
      {
        localJSONArray = new JSONArray();
        int i2 = Array.getLength(paramObject);
        int i1 = 0;
        while (i1 < i2)
        {
          localJSONArray.put(a(Array.get(paramObject, i1)));
          i1 += 1;
        }
      }
      if ((paramObject instanceof Map)) {
        return new JSONObject((Map)paramObject);
      }
      if ((!(paramObject instanceof Boolean)) && (!(paramObject instanceof Byte)) && (!(paramObject instanceof Character)) && (!(paramObject instanceof Double)) && (!(paramObject instanceof Float)) && (!(paramObject instanceof Integer)) && (!(paramObject instanceof Long)) && (!(paramObject instanceof Short)))
      {
        if ((paramObject instanceof String)) {
          return paramObject;
        }
        if (paramObject.getClass().getPackage().getName().startsWith("java."))
        {
          paramObject = paramObject.toString();
          return paramObject;
        }
      }
      else
      {
        return paramObject;
      }
    }
    catch (Exception paramObject)
    {
      label217:
      break label217;
    }
    return null;
    return paramObject;
    return localJSONArray;
  }
  
  public static String a(int paramInt)
  {
    try
    {
      Object localObject1 = new BigDecimal(paramInt).divide(new BigDecimal(100.0D));
      localObject2 = new DecimalFormat();
      ((DecimalFormat)localObject2).applyPattern("0.##");
      localObject1 = ((DecimalFormat)localObject2).format(localObject1);
      return localObject1;
    }
    catch (Exception localException)
    {
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("fen2Yuan error:");
      ((StringBuilder)localObject2).append(localException.toString());
      APLog.e("APTools", ((StringBuilder)localObject2).toString());
    }
    return "0";
  }
  
  public static String a(int paramInt1, int paramInt2)
  {
    try
    {
      Object localObject1 = new BigDecimal(paramInt1).divide(new BigDecimal(100.0D));
      localObject2 = new DecimalFormat();
      if (paramInt2 == 2) {
        ((DecimalFormat)localObject2).applyPattern("0.00");
      } else if (paramInt2 == 1) {
        ((DecimalFormat)localObject2).applyPattern("0.0");
      } else {
        ((DecimalFormat)localObject2).applyPattern("0.##");
      }
      localObject1 = ((DecimalFormat)localObject2).format(localObject1);
      return localObject1;
    }
    catch (Exception localException)
    {
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("fen2Yuan error:");
      ((StringBuilder)localObject2).append(localException.toString());
      APLog.e("APTools", ((StringBuilder)localObject2).toString());
    }
    return "0";
  }
  
  public static String a(int paramInt, String paramString)
  {
    el localel = em.b().n();
    String str2 = localel.b.a();
    String str1;
    if (paramInt == 0)
    {
      str1 = str2;
      if ("hfpay".equals(paramString))
      {
        str1 = str2;
        if (!TextUtils.isEmpty(APHFChannel.o)) {
          str1 = ((eu)localel.b).b(localel.e.g, APHFChannel.o);
        }
      }
    }
    else
    {
      str1 = str2;
      if (paramInt == 4)
      {
        str1 = str2;
        if ("hfpay".equals(paramString))
        {
          str1 = str2;
          if (!TextUtils.isEmpty(APHFChannel.p))
          {
            str1 = str2;
            if (!"0".equals(APHFChannel.p))
            {
              paramInt = g(localel.b.a(localel.e.g));
              int i1 = Integer.parseInt(APHFChannel.p);
              str1 = str2;
              if (paramInt != i1) {
                str1 = a(i1);
              }
            }
          }
        }
      }
    }
    paramString = new StringBuilder();
    paramString.append("amt=");
    paramString.append(String.valueOf(g(str1)));
    return a(paramString.toString(), 1);
  }
  
  public static String a(Activity paramActivity)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    Object localObject1 = e(paramActivity);
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("imei=");
    ((StringBuilder)localObject2).append((String)localObject1);
    localStringBuffer.append(((StringBuilder)localObject2).toString());
    localObject1 = d(paramActivity);
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("androidid=");
    ((StringBuilder)localObject2).append((String)localObject1);
    localStringBuffer.append(((StringBuilder)localObject2).toString());
    localObject2 = c();
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("&mac=");
    ((StringBuilder)localObject2).append((String)localObject1);
    localStringBuffer.append(((StringBuilder)localObject2).toString());
    localObject2 = Build.DEVICE;
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("&device=");
    ((StringBuilder)localObject2).append((String)localObject1);
    localStringBuffer.append(((StringBuilder)localObject2).toString());
    localObject1 = d();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("&manufacturer=");
    ((StringBuilder)localObject2).append((String)localObject1);
    localStringBuffer.append(((StringBuilder)localObject2).toString());
    localObject1 = Build.VERSION.RELEASE;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("&sdkVersion=");
    ((StringBuilder)localObject2).append((String)localObject1);
    localStringBuffer.append(((StringBuilder)localObject2).toString());
    localObject1 = Build.MODEL;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("&showModel=");
    ((StringBuilder)localObject2).append((String)localObject1);
    localStringBuffer.append(((StringBuilder)localObject2).toString());
    localObject1 = f();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("&phoneIp=");
    ((StringBuilder)localObject2).append((String)localObject1);
    localStringBuffer.append(((StringBuilder)localObject2).toString());
    try
    {
      int i1 = b(paramActivity);
      int i2 = c(paramActivity);
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("&Pixel=");
      ((StringBuilder)localObject1).append(i1);
      ((StringBuilder)localObject1).append("x");
      ((StringBuilder)localObject1).append(i2);
      localStringBuffer.append(((StringBuilder)localObject1).toString());
    }
    catch (Exception localException2)
    {
      try
      {
        localObject1 = g(paramActivity);
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("@oper=");
        ((StringBuilder)localObject2).append((String)localObject1);
        localStringBuffer.append(((StringBuilder)localObject2).toString());
      }
      catch (Exception localException2)
      {
        try
        {
          for (;;)
          {
            localObject1 = f(paramActivity);
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("@mnc=");
            ((StringBuilder)localObject2).append((String)localObject1);
            localStringBuffer.append(((StringBuilder)localObject2).toString());
            label493:
            localObject2 = b(paramActivity);
            localObject1 = localObject2;
            if (localObject2 == null) {
              localObject1 = "";
            }
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("&availableMemory=");
            ((StringBuilder)localObject2).append((String)localObject1);
            localStringBuffer.append(((StringBuilder)localObject2).toString());
            localObject1 = c(paramActivity);
            paramActivity = (Activity)localObject1;
            if (localObject1 == null) {
              paramActivity = "";
            }
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("&totalMemory=");
            ((StringBuilder)localObject1).append(paramActivity);
            localStringBuffer.append(((StringBuilder)localObject1).toString());
            paramActivity = g();
            if (paramActivity.length == 2)
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("&cup=");
              ((StringBuilder)localObject1).append(paramActivity[0]);
              localStringBuffer.append(((StringBuilder)localObject1).toString());
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("&cupFrequency=");
              ((StringBuilder)localObject1).append(paramActivity[1]);
              localStringBuffer.append(((StringBuilder)localObject1).toString());
            }
            return localStringBuffer.toString();
            localException1 = localException1;
            continue;
            localException2 = localException2;
          }
        }
        catch (Exception localException3)
        {
          break label493;
        }
      }
    }
  }
  
  public static String a(Context paramContext, String paramString1, String paramString2)
  {
    paramString1 = paramContext.getSharedPreferences(paramString1, 0);
    paramContext = null;
    if (paramString1 != null) {
      paramContext = paramString1.getString(paramString2, null);
    }
    return paramContext;
  }
  
  public static String a(Context paramContext, String paramString, boolean paramBoolean)
  {
    if (paramString == null) {
      return "";
    }
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramString, 0);
      if (paramContext != null)
      {
        paramContext = paramContext.versionName;
        return paramContext;
      }
    }
    catch (Exception paramContext)
    {
      paramString = g;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getInstalledVersionName() e = ");
      localStringBuilder.append(paramContext.toString());
      APLog.d(paramString, localStringBuilder.toString());
    }
    return "";
  }
  
  private static String a(Signature paramSignature)
  {
    ByteArrayInputStream localByteArrayInputStream = new ByteArrayInputStream(paramSignature.toByteArray());
    try
    {
      paramSignature = CertificateFactory.getInstance("X509");
    }
    catch (CertificateException paramSignature)
    {
      paramSignature.printStackTrace();
      paramSignature = null;
    }
    if (paramSignature == null) {
      return "";
    }
    try
    {
      paramSignature = (X509Certificate)paramSignature.generateCertificate(localByteArrayInputStream);
    }
    catch (CertificateException paramSignature)
    {
      paramSignature.printStackTrace();
      paramSignature = null;
    }
    if (paramSignature == null) {
      return "";
    }
    try
    {
      paramSignature = a(MessageDigest.getInstance("MD5").digest(paramSignature.getEncoded()));
      return paramSignature;
    }
    catch (Exception paramSignature)
    {
      paramSignature.printStackTrace();
      return null;
    }
    catch (CertificateEncodingException paramSignature)
    {
      paramSignature.printStackTrace();
      return null;
    }
    catch (NoSuchAlgorithmException paramSignature)
    {
      paramSignature.printStackTrace();
    }
    return null;
  }
  
  public static String a(String paramString)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(paramString);
    return localStringBuffer.reverse().toString();
  }
  
  public static String a(String paramString, int paramInt)
  {
    String str3 = "";
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramInt <= 0) {
        return paramString;
      }
      int i1 = 0;
      String str1 = paramString;
      paramString = str3;
      for (;;)
      {
        str3 = paramString;
        if (i1 >= paramInt) {
          break;
        }
        try
        {
          str1 = URLEncoder.encode(str1, "utf-8");
          paramString = str1;
        }
        catch (Exception localException)
        {
          APLog.i("urlEncode", localException.toString());
        }
        i1 += 1;
        String str2 = paramString;
      }
    }
    APLog.i("urlEncode", "编码内容为空");
    return str3;
  }
  
  public static String a(String paramString1, String paramString2)
  {
    paramString1 = paramString1.split("[?]");
    if ((paramString1.length > 1) && (paramString1[1] != null))
    {
      String[] arrayOfString = paramString1[1].split("[&]");
      int i2 = arrayOfString.length;
      int i1 = 0;
      while (i1 < i2)
      {
        Object localObject = arrayOfString[i1].split("[=]");
        if ((localObject.length > 1) && (localObject[0] != null)) {
          paramString1 = localObject[0];
        } else {
          paramString1 = null;
        }
        if ((localObject.length > 1) && (localObject[1] != null)) {
          localObject = localObject[1];
        } else {
          localObject = null;
        }
        if ((paramString1 != null) && (paramString1.compareToIgnoreCase(paramString2) == 0)) {
          return localObject;
        }
        i1 += 1;
      }
      return null;
    }
    return null;
  }
  
  public static String a(HashMap<String, String> paramHashMap)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    try
    {
      paramHashMap = paramHashMap.entrySet().iterator();
      while (paramHashMap.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramHashMap.next();
        localStringBuffer.append((String)localEntry.getKey());
        localStringBuffer.append("=");
        localStringBuffer.append((String)localEntry.getValue());
        localStringBuffer.append("&");
      }
      if (!TextUtils.isEmpty(localStringBuffer)) {
        localStringBuffer.deleteCharAt(localStringBuffer.length() - 1);
      }
    }
    catch (Exception paramHashMap)
    {
      label102:
      break label102;
    }
    return localStringBuffer.toString();
  }
  
  public static String a(byte[] paramArrayOfByte)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramArrayOfByte.length * 2);
    int i1 = 0;
    while (i1 < paramArrayOfByte.length)
    {
      Object localObject2 = Integer.toHexString(paramArrayOfByte[i1]);
      int i2 = ((String)localObject2).length();
      Object localObject1 = localObject2;
      if (i2 == 1)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("0");
        ((StringBuilder)localObject1).append((String)localObject2);
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      localObject2 = localObject1;
      if (i2 > 2) {
        localObject2 = ((String)localObject1).substring(i2 - 2, i2);
      }
      localStringBuilder.append(((String)localObject2).toUpperCase());
      if (i1 < paramArrayOfByte.length - 1) {
        localStringBuilder.append(':');
      }
      i1 += 1;
    }
    return localStringBuilder.toString();
  }
  
  public static String a(String[] paramArrayOfString, String paramString)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    if (paramArrayOfString.length > 0)
    {
      int i1 = 0;
      while (i1 < paramArrayOfString.length)
      {
        localStringBuffer.append(paramArrayOfString[i1]);
        if (i1 < paramArrayOfString.length - 1) {
          localStringBuffer.append(paramString);
        }
        i1 += 1;
      }
    }
    return localStringBuffer.toString();
  }
  
  public static JSONObject a(Bundle paramBundle)
  {
    JSONObject localJSONObject = new JSONObject();
    if (paramBundle == null) {
      return localJSONObject;
    }
    try
    {
      Iterator localIterator = paramBundle.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        try
        {
          if (Build.VERSION.SDK_INT >= 19) {
            localJSONObject.put(str, JSONObject.wrap(paramBundle.get(str)));
          } else {
            localJSONObject.put(str, a(paramBundle.get(str)));
          }
        }
        catch (JSONException localJSONException)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("bundle2Json error = ");
          localStringBuilder.append(localJSONException.toString());
          APLog.w("APTools", localStringBuilder.toString());
        }
      }
      paramBundle = new StringBuilder();
      paramBundle.append("bundle2Json: json = ");
      paramBundle.append(localJSONObject.toString());
      APLog.i("APTools", paramBundle.toString());
      return localJSONObject;
    }
    catch (Throwable paramBundle)
    {
      paramBundle.printStackTrace();
    }
    return localJSONObject;
  }
  
  public static void a(Context paramContext)
  {
    new Thread(new Runnable()
    {
      public void run()
      {
        long l = System.currentTimeMillis();
        APDataReportManager.getInstance().a("sdk.init.getApkVersion.time", l, "");
        l = System.currentTimeMillis();
        APTools.f();
        APDataReportManager.getInstance().a("sdk.init.getLocalIp.time", l, "");
        l = System.currentTimeMillis();
        APTools.e(this.a);
        APTools.d(this.a);
        APDataReportManager.getInstance().a("sdk.init.getDeviceId.time", l, "");
        l = System.currentTimeMillis();
        APTools.i();
        APDataReportManager.getInstance().a("sdk.init.readSDinfo.time", l, "");
      }
    }).start();
  }
  
  public static boolean a()
  {
    return Environment.getExternalStorageState().equals("mounted");
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    return b(paramContext, paramString);
  }
  
  public static boolean a(Throwable paramThrowable)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("isTimeError https exception");
    ((StringBuilder)localObject).append(paramThrowable.toString());
    APLog.w("APBaseHttpReq", ((StringBuilder)localObject).toString());
    localObject = paramThrowable.toString();
    if (!(paramThrowable instanceof CertificateExpiredException))
    {
      if ((paramThrowable instanceof CertificateNotYetValidException)) {
        return true;
      }
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        return false;
      }
      if ((((String)localObject).contains("validation time")) && (((String)localObject).contains("current time"))) {
        return true;
      }
      if ((((String)localObject).contains("GMT")) && (((String)localObject).contains("compared to"))) {
        return true;
      }
      if (((String)localObject).contains("Could not validate certificate"))
      {
        long l1 = System.currentTimeMillis() / 1000L;
        if ((l1 > 0L) && (1451577600L > l1)) {
          return true;
        }
      }
      return false;
    }
    return true;
  }
  
  private static Certificate[] a(JarFile paramJarFile, JarEntry paramJarEntry, byte[] paramArrayOfByte)
  {
    try
    {
      paramJarFile = paramJarFile.getInputStream(paramJarEntry);
      while (paramJarFile.read(paramArrayOfByte, 0, paramArrayOfByte.length) != -1) {}
      paramJarFile.close();
      if (paramJarEntry != null)
      {
        paramJarFile = paramJarEntry.getCertificates();
        return paramJarFile;
      }
      return null;
    }
    catch (IOException paramJarFile) {}
    return null;
  }
  
  public static int b(Activity paramActivity)
  {
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    paramActivity.getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
    return localDisplayMetrics.heightPixels;
  }
  
  /* Error */
  public static String b()
  {
    // Byte code:
    //   0: ldc 16
    //   2: astore_1
    //   3: invokestatic 818	midas/x/a:a	()Lmidas/x/a;
    //   6: invokevirtual 821	midas/x/a:b	()Landroid/content/Context;
    //   9: astore_0
    //   10: aload_0
    //   11: invokevirtual 545	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   14: aload_0
    //   15: invokevirtual 824	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   18: invokevirtual 827	android/content/Context:getPackageName	()Ljava/lang/String;
    //   21: iconst_0
    //   22: invokevirtual 551	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   25: getfield 556	android/content/pm/PackageInfo:versionName	Ljava/lang/String;
    //   28: astore_2
    //   29: aload_2
    //   30: ifnull +13 -> 43
    //   33: aload_2
    //   34: invokevirtual 681	java/lang/String:length	()I
    //   37: ifgt +16 -> 53
    //   40: goto +3 -> 43
    //   43: ldc 16
    //   45: areturn
    //   46: astore_0
    //   47: aload_0
    //   48: invokevirtual 610	java/lang/Exception:printStackTrace	()V
    //   51: aload_1
    //   52: areturn
    //   53: aload_2
    //   54: areturn
    //   55: astore_0
    //   56: aload_2
    //   57: astore_1
    //   58: goto -11 -> 47
    // Local variable table:
    //   start	length	slot	name	signature
    //   9	6	0	localContext	Context
    //   46	2	0	localException1	Exception
    //   55	1	0	localException2	Exception
    //   2	56	1	localObject	Object
    //   28	29	2	str	String
    // Exception table:
    //   from	to	target	type
    //   3	29	46	java/lang/Exception
    //   33	40	55	java/lang/Exception
  }
  
  public static String b(int paramInt)
  {
    try
    {
      Object localObject1 = new BigDecimal(paramInt).divide(new BigDecimal(10.0D));
      localObject2 = new DecimalFormat();
      ((DecimalFormat)localObject2).applyPattern("0.##");
      localObject1 = ((DecimalFormat)localObject2).format(localObject1);
      return localObject1;
    }
    catch (Exception localException)
    {
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("fen2Jiao error:");
      ((StringBuilder)localObject2).append(localException.toString());
      APLog.e("APTools", ((StringBuilder)localObject2).toString());
    }
    return "0";
  }
  
  public static String b(Context paramContext)
  {
    ActivityManager localActivityManager = (ActivityManager)paramContext.getSystemService("activity");
    if (localActivityManager != null)
    {
      ActivityManager.MemoryInfo localMemoryInfo = new ActivityManager.MemoryInfo();
      localActivityManager.getMemoryInfo(localMemoryInfo);
      return Formatter.formatFileSize(paramContext, localMemoryInfo.availMem);
    }
    return null;
  }
  
  public static String b(Bundle paramBundle)
  {
    try
    {
      Parcel localParcel = Parcel.obtain();
      paramBundle.writeToParcel(localParcel, 0);
      paramBundle = localParcel.marshall();
      localParcel.recycle();
      paramBundle = e.a(paramBundle);
      return paramBundle;
    }
    catch (Exception paramBundle)
    {
      paramBundle.printStackTrace();
    }
    return null;
  }
  
  public static String b(String paramString, int paramInt)
  {
    String str3 = "";
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramInt <= 0) {
        return paramString;
      }
      int i1 = 0;
      String str1 = paramString;
      paramString = str3;
      for (;;)
      {
        str3 = paramString;
        if (i1 >= paramInt) {
          break;
        }
        try
        {
          str1 = URLDecoder.decode(str1, "utf-8");
          paramString = str1;
        }
        catch (Exception localException)
        {
          APLog.i("urlEncode", localException.toString());
        }
        i1 += 1;
        String str2 = paramString;
      }
    }
    APLog.w("", "解码内容为空");
    return str3;
  }
  
  public static String b(byte[] paramArrayOfByte)
  {
    char[] arrayOfChar = new char[16];
    char[] tmp6_5 = arrayOfChar;
    tmp6_5[0] = 48;
    char[] tmp12_6 = tmp6_5;
    tmp12_6[1] = 49;
    char[] tmp18_12 = tmp12_6;
    tmp18_12[2] = 50;
    char[] tmp24_18 = tmp18_12;
    tmp24_18[3] = 51;
    char[] tmp30_24 = tmp24_18;
    tmp30_24[4] = 52;
    char[] tmp36_30 = tmp30_24;
    tmp36_30[5] = 53;
    char[] tmp42_36 = tmp36_30;
    tmp42_36[6] = 54;
    char[] tmp49_42 = tmp42_36;
    tmp49_42[7] = 55;
    char[] tmp56_49 = tmp49_42;
    tmp56_49[8] = 56;
    char[] tmp63_56 = tmp56_49;
    tmp63_56[9] = 57;
    char[] tmp70_63 = tmp63_56;
    tmp70_63[10] = 65;
    char[] tmp77_70 = tmp70_63;
    tmp77_70[11] = 66;
    char[] tmp84_77 = tmp77_70;
    tmp84_77[12] = 67;
    char[] tmp91_84 = tmp84_77;
    tmp91_84[13] = 68;
    char[] tmp98_91 = tmp91_84;
    tmp98_91[14] = 69;
    char[] tmp105_98 = tmp98_91;
    tmp105_98[15] = 70;
    tmp105_98;
    StringBuilder localStringBuilder = new StringBuilder(paramArrayOfByte.length * 2);
    int i1 = 0;
    while (i1 < paramArrayOfByte.length)
    {
      localStringBuilder.append(arrayOfChar[((paramArrayOfByte[i1] & 0xF0) >>> 4)]);
      localStringBuilder.append(arrayOfChar[(paramArrayOfByte[i1] & 0xF)]);
      i1 += 1;
    }
    return localStringBuilder.toString();
  }
  
  public static HashMap<String, String> b(String paramString)
  {
    HashMap localHashMap = new HashMap();
    Object localObject = paramString.split("\\?");
    if (localObject == null) {
      return null;
    }
    if (localObject.length == 1) {
      paramString = localObject[0];
    } else if (localObject.length == 2) {
      paramString = localObject[1];
    }
    int i1;
    label152:
    label164:
    for (;;)
    {
      try
      {
        if (!TextUtils.isEmpty(paramString))
        {
          arrayOfString = paramString.split("\\&");
          paramString = "";
          localObject = "";
          i1 = 0;
          int i2 = arrayOfString.length;
          if (i1 >= i2) {
            break label152;
          }
        }
      }
      catch (Exception paramString)
      {
        String[] arrayOfString;
        String str;
        APLog.w("url2Map", paramString.toString());
      }
      try
      {
        str = arrayOfString[i1].split("\\=")[0];
      }
      catch (Exception localException2)
      {
        continue;
      }
      try
      {
        localObject = arrayOfString[i1].split("\\=")[1];
        paramString = (String)localObject;
      }
      catch (Exception localException1)
      {
        continue;
        i1 += 1;
      }
      localObject = str;
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localHashMap.put(localObject, paramString);
        break label164;
        APLog.i("url2Map", "url后参数为空");
        return localHashMap;
        return localHashMap;
      }
    }
  }
  
  public static void b(String paramString1, String paramString2)
  {
    if (a())
    {
      gb localgb = new gb();
      localgb.d(localgb.b(paramString1, paramString2), "Midas.xml");
      return;
    }
    APLog.i("saveInfoSDCard", "no sdcard");
  }
  
  public static boolean b(Context paramContext, String paramString)
  {
    boolean bool = false;
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramString, 0);
      if (paramContext != null) {
        bool = true;
      }
      return bool;
    }
    catch (Exception paramContext)
    {
      paramString = g;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isAppInstalled() e = ");
      localStringBuilder.append(paramContext.toString());
      APLog.d(paramString, localStringBuilder.toString());
    }
    return false;
  }
  
  public static boolean b(Throwable paramThrowable)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("isTimeError https exception");
    ((StringBuilder)localObject).append(paramThrowable.toString());
    APLog.w("APBaseHttpReq", ((StringBuilder)localObject).toString());
    localObject = Proxy.getDefaultHost();
    return (APAppDataInterface.singleton().i() == 1000) && (!TextUtils.isEmpty((CharSequence)localObject)) && (paramThrowable.toString().contains("Trust anchor for certification path not found"));
  }
  
  public static int c(Activity paramActivity)
  {
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    paramActivity.getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
    return localDisplayMetrics.widthPixels;
  }
  
  public static String c()
  {
    if (TextUtils.isEmpty(l))
    {
      Object localObject1 = "";
      try
      {
        localObject2 = s(a.a().b());
        try
        {
          if (!TextUtils.isEmpty((CharSequence)localObject2))
          {
            l = (String)localObject2;
            return localObject2;
          }
          String str = ((WifiManager)a.a().b().getApplicationContext().getSystemService("wifi")).getConnectionInfo().getMacAddress();
          localObject1 = str;
          localObject2 = str;
          if (TextUtils.isEmpty(str)) {
            break label107;
          }
          localObject1 = str;
          d(a.a().b(), str);
          localObject2 = str;
        }
        catch (Exception localException1)
        {
          localObject1 = localObject2;
        }
        APLog.w("getLocalMacAddress", localException2.toString());
      }
      catch (Exception localException2) {}
      Object localObject2 = localObject1;
      label107:
      l = (String)localObject2;
      return localObject2;
    }
    return l;
  }
  
  /* Error */
  public static String c(Context paramContext)
  {
    // Byte code:
    //   0: lconst_0
    //   1: lstore_3
    //   2: new 973	java/io/FileReader
    //   5: dup
    //   6: ldc_w 975
    //   9: invokespecial 977	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   12: astore 9
    //   14: new 979	java/io/BufferedReader
    //   17: dup
    //   18: aload 9
    //   20: sipush 8192
    //   23: invokespecial 982	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   26: astore 10
    //   28: aload 10
    //   30: invokevirtual 985	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   33: astore 11
    //   35: lload_3
    //   36: lstore 7
    //   38: aload 11
    //   40: ifnull +104 -> 144
    //   43: aload 11
    //   45: ldc_w 987
    //   48: invokevirtual 635	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   51: astore 12
    //   53: aload 12
    //   55: arraylength
    //   56: istore_2
    //   57: iconst_0
    //   58: istore_1
    //   59: iload_1
    //   60: iload_2
    //   61: if_icmpge +53 -> 114
    //   64: aload 12
    //   66: iload_1
    //   67: aaload
    //   68: astore 13
    //   70: new 107	java/lang/StringBuilder
    //   73: dup
    //   74: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   77: astore 14
    //   79: aload 14
    //   81: aload 13
    //   83: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: pop
    //   87: aload 14
    //   89: ldc_w 989
    //   92: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: pop
    //   96: aload 11
    //   98: aload 14
    //   100: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   103: invokestatic 994	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   106: pop
    //   107: iload_1
    //   108: iconst_1
    //   109: iadd
    //   110: istore_1
    //   111: goto -52 -> 59
    //   114: lload_3
    //   115: lstore 7
    //   117: aload 12
    //   119: arraylength
    //   120: iconst_2
    //   121: if_icmplt +23 -> 144
    //   124: aload 12
    //   126: iconst_1
    //   127: aaload
    //   128: invokestatic 997	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   131: invokevirtual 1000	java/lang/Integer:longValue	()J
    //   134: lstore 5
    //   136: lload 5
    //   138: ldc2_w 1001
    //   141: lmul
    //   142: lstore 7
    //   144: lload 7
    //   146: lstore 5
    //   148: aload 10
    //   150: invokevirtual 1003	java/io/BufferedReader:close	()V
    //   153: lload 7
    //   155: lstore_3
    //   156: lload_3
    //   157: lstore 5
    //   159: aload 9
    //   161: invokevirtual 1004	java/io/FileReader:close	()V
    //   164: lload_3
    //   165: lstore 5
    //   167: goto +99 -> 266
    //   170: astore 11
    //   172: aload 10
    //   174: astore_0
    //   175: aload 9
    //   177: astore 10
    //   179: aload 11
    //   181: astore 9
    //   183: goto +31 -> 214
    //   186: astore 11
    //   188: aconst_null
    //   189: astore_0
    //   190: aload 9
    //   192: astore 10
    //   194: aload 11
    //   196: astore 9
    //   198: goto +16 -> 214
    //   201: aconst_null
    //   202: astore 10
    //   204: goto +38 -> 242
    //   207: astore 9
    //   209: aconst_null
    //   210: astore_0
    //   211: aload_0
    //   212: astore 10
    //   214: aload_0
    //   215: ifnull +7 -> 222
    //   218: aload_0
    //   219: invokevirtual 1003	java/io/BufferedReader:close	()V
    //   222: aload 10
    //   224: ifnull +8 -> 232
    //   227: aload 10
    //   229: invokevirtual 1004	java/io/FileReader:close	()V
    //   232: aload 9
    //   234: athrow
    //   235: aconst_null
    //   236: astore 10
    //   238: aload 10
    //   240: astore 9
    //   242: aload 10
    //   244: ifnull +11 -> 255
    //   247: lload_3
    //   248: lstore 5
    //   250: aload 10
    //   252: invokevirtual 1003	java/io/BufferedReader:close	()V
    //   255: lload_3
    //   256: lstore 5
    //   258: aload 9
    //   260: ifnull +6 -> 266
    //   263: goto -107 -> 156
    //   266: aload_0
    //   267: lload 5
    //   269: invokestatic 854	android/text/format/Formatter:formatFileSize	(Landroid/content/Context;J)Ljava/lang/String;
    //   272: areturn
    //   273: astore 9
    //   275: goto -40 -> 235
    //   278: astore 10
    //   280: goto -79 -> 201
    //   283: astore 11
    //   285: goto -43 -> 242
    //   288: astore 9
    //   290: goto -24 -> 266
    //   293: astore_0
    //   294: goto -62 -> 232
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	297	0	paramContext	Context
    //   58	53	1	i1	int
    //   56	6	2	i2	int
    //   1	255	3	l1	long
    //   134	134	5	l2	long
    //   36	118	7	l3	long
    //   12	185	9	localObject1	Object
    //   207	26	9	localObject2	Object
    //   240	19	9	localObject3	Object
    //   273	1	9	localIOException1	IOException
    //   288	1	9	localException	Exception
    //   26	225	10	localObject4	Object
    //   278	1	10	localIOException2	IOException
    //   33	64	11	str1	String
    //   170	10	11	localObject5	Object
    //   186	9	11	localObject6	Object
    //   283	1	11	localIOException3	IOException
    //   51	74	12	arrayOfString	String[]
    //   68	14	13	str2	String
    //   77	22	14	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   28	35	170	finally
    //   43	57	170	finally
    //   70	107	170	finally
    //   117	136	170	finally
    //   14	28	186	finally
    //   2	14	207	finally
    //   2	14	273	java/io/IOException
    //   14	28	278	java/io/IOException
    //   28	35	283	java/io/IOException
    //   43	57	283	java/io/IOException
    //   70	107	283	java/io/IOException
    //   117	136	283	java/io/IOException
    //   148	153	288	java/lang/Exception
    //   159	164	288	java/lang/Exception
    //   250	255	288	java/lang/Exception
    //   218	222	293	java/lang/Exception
    //   227	232	293	java/lang/Exception
  }
  
  public static String c(Context paramContext, String paramString)
  {
    return a(paramContext, paramString, false);
  }
  
  private static String c(byte[] paramArrayOfByte)
  {
    int i3 = paramArrayOfByte.length;
    char[] arrayOfChar = new char[i3 * 2];
    int i1 = 0;
    while (i1 < i3)
    {
      int i5 = paramArrayOfByte[i1];
      int i2 = i5 >> 4 & 0xF;
      int i4 = i1 * 2;
      if (i2 >= 10) {
        i2 = i2 + 97 - 10;
      } else {
        i2 += 48;
      }
      arrayOfChar[i4] = ((char)i2);
      i2 = i5 & 0xF;
      if (i2 >= 10) {
        i2 = i2 + 97 - 10;
      } else {
        i2 += 48;
      }
      arrayOfChar[(i4 + 1)] = ((char)i2);
      i1 += 1;
    }
    return new String(arrayOfChar);
  }
  
  /* Error */
  public static HashMap<String, String> c(String paramString)
  {
    // Byte code:
    //   0: new 645	java/util/HashMap
    //   3: dup
    //   4: invokespecial 899	java/util/HashMap:<init>	()V
    //   7: astore 5
    //   9: aload_0
    //   10: invokestatic 415	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   13: ifne +79 -> 92
    //   16: aload_0
    //   17: ldc_w 903
    //   20: invokevirtual 635	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   23: astore 6
    //   25: ldc 16
    //   27: astore_0
    //   28: ldc 16
    //   30: astore_3
    //   31: iconst_0
    //   32: istore_1
    //   33: aload 6
    //   35: arraylength
    //   36: istore_2
    //   37: iload_1
    //   38: iload_2
    //   39: if_icmpge +76 -> 115
    //   42: aload 6
    //   44: iload_1
    //   45: aaload
    //   46: ldc_w 905
    //   49: invokevirtual 635	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   52: iconst_0
    //   53: aaload
    //   54: astore 4
    //   56: aload 6
    //   58: iload_1
    //   59: aaload
    //   60: ldc_w 905
    //   63: invokevirtual 635	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   66: iconst_1
    //   67: aaload
    //   68: astore_3
    //   69: aload_3
    //   70: astore_0
    //   71: aload 4
    //   73: astore_3
    //   74: aload_3
    //   75: invokestatic 415	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   78: ifne +49 -> 127
    //   81: aload 5
    //   83: aload_3
    //   84: aload_0
    //   85: invokevirtual 908	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   88: pop
    //   89: goto +38 -> 127
    //   92: ldc_w 1012
    //   95: ldc_w 1014
    //   98: invokestatic 627	com/tencent/midas/comm/APLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   101: aload 5
    //   103: areturn
    //   104: astore_0
    //   105: ldc_w 1012
    //   108: aload_0
    //   109: invokevirtual 166	java/lang/Exception:toString	()Ljava/lang/String;
    //   112: invokestatic 715	com/tencent/midas/comm/APLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   115: aload 5
    //   117: areturn
    //   118: astore 4
    //   120: goto -46 -> 74
    //   123: astore_3
    //   124: goto -53 -> 71
    //   127: iload_1
    //   128: iconst_1
    //   129: iadd
    //   130: istore_1
    //   131: goto -98 -> 33
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	134	0	paramString	String
    //   32	99	1	i1	int
    //   36	4	2	i2	int
    //   30	54	3	localObject	Object
    //   123	1	3	localException1	Exception
    //   54	18	4	str	String
    //   118	1	4	localException2	Exception
    //   7	109	5	localHashMap	HashMap
    //   23	34	6	arrayOfString	String[]
    // Exception table:
    //   from	to	target	type
    //   9	25	104	java/lang/Exception
    //   33	37	104	java/lang/Exception
    //   74	89	104	java/lang/Exception
    //   92	101	104	java/lang/Exception
    //   42	56	118	java/lang/Exception
    //   56	69	123	java/lang/Exception
  }
  
  public static void c(String paramString1, String paramString2)
  {
    Object localObject1 = paramString2;
    if (!paramString2.endsWith(File.separator))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(paramString2);
      ((StringBuilder)localObject1).append(File.separator);
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    if (Build.CPU_ABI.startsWith("arm64-v8a")) {
      paramString2 = "arm64-v8a";
    } else if (Build.CPU_ABI.startsWith("arm")) {
      paramString2 = "armeabi";
    } else if (Build.CPU_ABI.startsWith("x86")) {
      paramString2 = "x86";
    } else {
      paramString2 = "armeabi";
    }
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("extractLibs end to dirToExtract:");
    ((StringBuilder)localObject2).append(paramString2);
    APLog.i("APTools", ((StringBuilder)localObject2).toString());
    for (;;)
    {
      try
      {
        ZipFile localZipFile = new ZipFile(paramString1);
        byte[] arrayOfByte = new byte[4096];
        Enumeration localEnumeration = localZipFile.entries();
        if (localEnumeration.hasMoreElements())
        {
          ZipEntry localZipEntry = (ZipEntry)localEnumeration.nextElement();
          Object localObject3 = localZipEntry.getName();
          if ((((String)localObject3).endsWith(File.separator)) || ((!((String)localObject3).contains("lib")) && (!((String)localObject3).endsWith(".so")))) {
            continue;
          }
          paramString1 = new StringBuilder();
          paramString1.append((String)localObject1);
          paramString1.append((String)localObject3);
          localObject2 = new File(paramString1.toString());
          i1 = ((String)localObject3).lastIndexOf(File.separator);
          paramString1 = (String)localObject3;
          if (i1 != -1) {
            paramString1 = ((String)localObject3).substring(i1 + 1);
          }
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append((String)localObject1);
          ((StringBuilder)localObject3).append(paramString1);
          localObject3 = new File(((StringBuilder)localObject3).toString());
          paramString1 = (String)localObject2;
          if (paramString1 != null)
          {
            if (paramString1.getName().equals(paramString2))
            {
              i1 = 1;
            }
            else
            {
              paramString1 = paramString1.getParentFile();
              continue;
            }
            if (i1 == 0) {
              continue;
            }
            ((File)localObject3).getParentFile().mkdirs();
            try
            {
              paramString1 = localZipFile.getInputStream(localZipEntry);
              localObject2 = new FileOutputStream((File)localObject3);
              i1 = paramString1.read(arrayOfByte);
              if (i1 > 0)
              {
                ((FileOutputStream)localObject2).write(arrayOfByte, 0, i1);
                continue;
              }
              paramString1.close();
              ((FileOutputStream)localObject2).flush();
              ((FileOutputStream)localObject2).close();
            }
            catch (IOException paramString1)
            {
              paramString1.printStackTrace();
            }
          }
        }
        else
        {
          return;
        }
      }
      catch (IOException paramString1)
      {
        paramString1.printStackTrace();
      }
      int i1 = 0;
    }
  }
  
  public static boolean c(Throwable paramThrowable)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("isTimeError https exception");
    localStringBuilder.append(paramThrowable.toString());
    APLog.w("APBaseHttpReq", localStringBuilder.toString());
    paramThrowable = paramThrowable.toString();
    return ((paramThrowable.contains("SSL handshake aborted")) && (paramThrowable.contains("usually a protocol error"))) || (paramThrowable.contains("GET_SERVER_HELLO"));
  }
  
  public static native void checkParam(Object paramObject);
  
  public static String d()
  {
    return Build.MANUFACTURER;
  }
  
  public static String d(Context paramContext)
  {
    if (!TextUtils.isEmpty(i)) {
      return i;
    }
    if (paramContext != null) {
      try
      {
        i = Settings.System.getString(paramContext.getContentResolver(), "android_id");
      }
      catch (Exception paramContext)
      {
        i = "";
        String str = g;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getAndroidID() e=");
        localStringBuilder.append(paramContext.toString());
        APLog.w(str, localStringBuilder.toString());
      }
    }
    return i;
  }
  
  public static String d(String paramString1, String paramString2)
  {
    Object localObject = c(paramString1);
    if ((localObject != null) && (!TextUtils.isEmpty((String)((HashMap)localObject).get(paramString2)))) {
      ((HashMap)localObject).remove(paramString2);
    }
    paramString2 = new StringBuilder();
    paramString1 = paramString2;
    if (!((HashMap)localObject).isEmpty())
    {
      paramString1 = ((HashMap)localObject).entrySet().iterator();
      while (paramString1.hasNext())
      {
        localObject = (Map.Entry)paramString1.next();
        paramString2.append((String)((Map.Entry)localObject).getKey());
        paramString2.append("=");
        paramString2.append((String)((Map.Entry)localObject).getValue());
        paramString2.append("&");
      }
      paramString1 = paramString2;
      if (paramString2.length() > 0) {
        paramString1 = paramString2.deleteCharAt(paramString2.length() - 1);
      }
    }
    return paramString1.toString();
  }
  
  public static String d(Throwable paramThrowable)
  {
    StringWriter localStringWriter = new StringWriter();
    paramThrowable.printStackTrace(new PrintWriter(localStringWriter, true));
    return localStringWriter.getBuffer().toString();
  }
  
  private static void d(Context paramContext, String paramString)
  {
    try
    {
      new fz().a(paramContext, "TencentUnipay", "macAddressLocal", paramString);
      return;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public static boolean d(String paramString)
  {
    if (paramString.length() == 11) {
      return paramString.startsWith("1");
    }
    if (paramString.length() > 11) {
      return a(paramString).substring(0, 11).endsWith("1");
    }
    return false;
  }
  
  public static String e()
  {
    return Build.VERSION.RELEASE;
  }
  
  public static String e(Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 29) {
      return "";
    }
    if ((!m) && (TextUtils.isEmpty(h)))
    {
      if (paramContext != null) {
        try
        {
          h = t(paramContext);
          if (!TextUtils.isEmpty(h)) {
            return h;
          }
          localObject = (TelephonyManager)paramContext.getSystemService("phone");
          if (localObject != null)
          {
            m = true;
            h = ((TelephonyManager)localObject).getDeviceId();
          }
          if (!TextUtils.isEmpty(h)) {
            e(paramContext, h);
          }
        }
        catch (Exception paramContext)
        {
          Object localObject = g;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("getDeviceId() e=");
          localStringBuilder.append(paramContext.toString());
          APLog.w((String)localObject, localStringBuilder.toString());
        }
      }
      return h;
    }
    return h;
  }
  
  public static String e(String paramString)
  {
    if (!TextUtils.isEmpty(k)) {
      return k;
    }
    k = new gb().c("Midas.xml", paramString);
    return k;
  }
  
  private static void e(Context paramContext, String paramString)
  {
    try
    {
      new fz().a(paramContext, "TencentUnipay", "deviceIdLocal", paramString);
      return;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public static String f()
  {
    if (!TextUtils.isEmpty(j)) {
      return j;
    }
    try
    {
      InetAddress localInetAddress;
      do
      {
        localObject = NetworkInterface.getNetworkInterfaces();
        Enumeration localEnumeration;
        while (!localEnumeration.hasMoreElements())
        {
          if ((localObject == null) || (!((Enumeration)localObject).hasMoreElements())) {
            break;
          }
          localEnumeration = ((NetworkInterface)((Enumeration)localObject).nextElement()).getInetAddresses();
        }
        localInetAddress = (InetAddress)localEnumeration.nextElement();
      } while ((localInetAddress.isLoopbackAddress()) || (localInetAddress.isLinkLocalAddress()));
      j = localInetAddress.getHostAddress();
      Object localObject = j;
      return localObject;
    }
    catch (Exception localException)
    {
      Log.e("WifiPreferenceIpAddress", localException.toString());
    }
    return null;
  }
  
  public static String f(Context paramContext)
  {
    if (paramContext == null) {
      return "";
    }
    paramContext = (TelephonyManager)paramContext.getSystemService("phone");
    if (paramContext == null) {
      return "";
    }
    paramContext = paramContext.getSimOperator();
    StringBuilder localStringBuilder = new StringBuilder();
    for (;;)
    {
      try
      {
        i2 = paramContext.length();
        i1 = i2;
        if (i2 <= 6) {
          break label150;
        }
        i1 = 6;
      }
      catch (Exception paramContext)
      {
        int i1;
        paramContext.printStackTrace();
        APLog.d("APTools", "getMobileMccMnc() = Null");
        return "";
      }
      if (i2 < i1) {
        if (!Character.isDigit(paramContext.charAt(i2)))
        {
          if (localStringBuilder.length() <= 0) {
            break label155;
          }
        }
        else
        {
          localStringBuilder.append(paramContext.charAt(i2));
          break label155;
        }
      }
      paramContext = localStringBuilder.toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("getMobileMccMnc() = ");
      localStringBuilder.append(paramContext);
      APLog.d("APTools", localStringBuilder.toString());
      return paramContext;
      label150:
      int i2 = 0;
      continue;
      label155:
      i2 += 1;
    }
  }
  
  public static Signature[] f(String paramString)
  {
    paramString = new File(paramString);
    if (!paramString.exists()) {
      return null;
    }
    try
    {
      paramString = new JarFile(paramString);
      Object localObject = paramString.getJarEntry("AndroidManifest.xml");
      if (localObject == null) {
        return null;
      }
      Certificate[] arrayOfCertificate = a(paramString, (JarEntry)localObject, new byte[8192]);
      if (arrayOfCertificate != null) {
        localObject = new Signature[arrayOfCertificate.length];
      }
      int i3;
      int i1;
      int i2;
      return localObject;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        try
        {
          i3 = arrayOfCertificate.length;
          i1 = 0;
          i2 = 0;
          paramString = (String)localObject;
          if (i1 < i3)
          {
            localObject[i2] = new Signature(c(arrayOfCertificate[i1].getEncoded()));
            i2 += 1;
            i1 += 1;
            continue;
            paramString = null;
          }
          return paramString;
        }
        catch (Exception paramString) {}
        paramString = paramString;
      }
    }
  }
  
  public static int g(String paramString)
  {
    try
    {
      int i1 = new BigDecimal(f.parse(paramString).toString()).multiply(new BigDecimal(100)).intValue();
      return i1;
    }
    catch (Exception paramString)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("yuanToFen error:");
      localStringBuilder.append(paramString.toString());
      APLog.e("APTools", localStringBuilder.toString());
    }
    return 0;
  }
  
  public static String g(Context paramContext)
  {
    String str1 = "";
    if (paramContext == null) {
      return "";
    }
    String str2 = f(paramContext);
    boolean bool = TextUtils.isEmpty(str2);
    int i2 = -1;
    int i1;
    if ((!bool) && (str2.length() >= 5)) {
      try
      {
        i1 = Integer.valueOf(str2.substring(0, 3)).intValue();
        try
        {
          int i3 = Integer.valueOf(str2.substring(3, 5)).intValue();
          i2 = i3;
        }
        catch (Exception paramContext) {}
        paramContext.printStackTrace();
      }
      catch (Exception paramContext)
      {
        i1 = -1;
      }
    } else {
      i1 = -1;
    }
    paramContext = new StringBuilder();
    paramContext.append("getOperator() = ");
    paramContext.append(str2);
    APLog.d("APTools", paramContext.toString());
    paramContext = str1;
    if (i1 == 460)
    {
      switch (i2)
      {
      case 4: 
      case 10: 
      default: 
        return "";
      case 3: 
      case 5: 
      case 11: 
        return "vnet";
      case 1: 
      case 6: 
      case 9: 
        return "unicom";
      }
      paramContext = "gmcc";
    }
    return paramContext;
  }
  
  /* Error */
  public static String[] g()
  {
    // Byte code:
    //   0: iconst_2
    //   1: anewarray 170	java/lang/String
    //   4: astore_3
    //   5: aload_3
    //   6: iconst_0
    //   7: ldc 16
    //   9: aastore
    //   10: aload_3
    //   11: iconst_1
    //   12: ldc 16
    //   14: aastore
    //   15: new 973	java/io/FileReader
    //   18: dup
    //   19: ldc_w 1262
    //   22: invokespecial 977	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   25: astore_1
    //   26: new 979	java/io/BufferedReader
    //   29: dup
    //   30: aload_1
    //   31: sipush 8192
    //   34: invokespecial 982	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   37: astore_2
    //   38: aload_2
    //   39: invokevirtual 985	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   42: astore 4
    //   44: aload 4
    //   46: ifnull +74 -> 120
    //   49: aload 4
    //   51: ldc_w 987
    //   54: invokevirtual 635	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   57: astore 4
    //   59: iconst_2
    //   60: istore_0
    //   61: iload_0
    //   62: aload 4
    //   64: arraylength
    //   65: if_icmpge +89 -> 154
    //   68: new 107	java/lang/StringBuilder
    //   71: dup
    //   72: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   75: astore 5
    //   77: aload 5
    //   79: aload_3
    //   80: iconst_0
    //   81: aaload
    //   82: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: pop
    //   86: aload 5
    //   88: aload 4
    //   90: iload_0
    //   91: aaload
    //   92: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: pop
    //   96: aload 5
    //   98: ldc_w 1264
    //   101: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: pop
    //   105: aload_3
    //   106: iconst_0
    //   107: aload 5
    //   109: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   112: aastore
    //   113: iload_0
    //   114: iconst_1
    //   115: iadd
    //   116: istore_0
    //   117: goto -56 -> 61
    //   120: new 107	java/lang/StringBuilder
    //   123: dup
    //   124: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   127: astore 4
    //   129: aload 4
    //   131: aload_3
    //   132: iconst_0
    //   133: aaload
    //   134: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: pop
    //   138: aload 4
    //   140: ldc 16
    //   142: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: pop
    //   146: aload_3
    //   147: iconst_0
    //   148: aload 4
    //   150: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   153: aastore
    //   154: aload_2
    //   155: invokevirtual 985	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   158: astore 4
    //   160: aload 4
    //   162: ifnull +101 -> 263
    //   165: aload 4
    //   167: ldc_w 987
    //   170: invokevirtual 635	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   173: astore 4
    //   175: aload 4
    //   177: ifnull +49 -> 226
    //   180: aload 4
    //   182: arraylength
    //   183: iconst_3
    //   184: if_icmplt +42 -> 226
    //   187: new 107	java/lang/StringBuilder
    //   190: dup
    //   191: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   194: astore 5
    //   196: aload 5
    //   198: aload_3
    //   199: iconst_1
    //   200: aaload
    //   201: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: pop
    //   205: aload 5
    //   207: aload 4
    //   209: iconst_2
    //   210: aaload
    //   211: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: pop
    //   215: aload_3
    //   216: iconst_1
    //   217: aload 5
    //   219: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   222: aastore
    //   223: goto +74 -> 297
    //   226: new 107	java/lang/StringBuilder
    //   229: dup
    //   230: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   233: astore 4
    //   235: aload 4
    //   237: aload_3
    //   238: iconst_1
    //   239: aaload
    //   240: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   243: pop
    //   244: aload 4
    //   246: ldc 16
    //   248: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   251: pop
    //   252: aload_3
    //   253: iconst_1
    //   254: aload 4
    //   256: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   259: aastore
    //   260: goto +37 -> 297
    //   263: new 107	java/lang/StringBuilder
    //   266: dup
    //   267: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   270: astore 4
    //   272: aload 4
    //   274: aload_3
    //   275: iconst_1
    //   276: aaload
    //   277: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   280: pop
    //   281: aload 4
    //   283: ldc 16
    //   285: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   288: pop
    //   289: aload_3
    //   290: iconst_1
    //   291: aload 4
    //   293: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   296: aastore
    //   297: aload_2
    //   298: invokevirtual 1003	java/io/BufferedReader:close	()V
    //   301: aload_1
    //   302: invokevirtual 1004	java/io/FileReader:close	()V
    //   305: goto +60 -> 365
    //   308: astore_3
    //   309: goto +19 -> 328
    //   312: astore_3
    //   313: aconst_null
    //   314: astore_2
    //   315: goto +13 -> 328
    //   318: aconst_null
    //   319: astore_2
    //   320: goto +30 -> 350
    //   323: astore_3
    //   324: aconst_null
    //   325: astore_2
    //   326: aload_2
    //   327: astore_1
    //   328: aload_2
    //   329: ifnull +7 -> 336
    //   332: aload_2
    //   333: invokevirtual 1003	java/io/BufferedReader:close	()V
    //   336: aload_1
    //   337: ifnull +7 -> 344
    //   340: aload_1
    //   341: invokevirtual 1004	java/io/FileReader:close	()V
    //   344: aload_3
    //   345: athrow
    //   346: aconst_null
    //   347: astore_2
    //   348: aload_2
    //   349: astore_1
    //   350: aload_2
    //   351: ifnull +7 -> 358
    //   354: aload_2
    //   355: invokevirtual 1003	java/io/BufferedReader:close	()V
    //   358: aload_1
    //   359: ifnull +6 -> 365
    //   362: goto -61 -> 301
    //   365: getstatic 1268	java/lang/System:out	Ljava/io/PrintStream;
    //   368: astore_1
    //   369: new 107	java/lang/StringBuilder
    //   372: dup
    //   373: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   376: astore_2
    //   377: aload_2
    //   378: ldc_w 1270
    //   381: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   384: pop
    //   385: aload_2
    //   386: aload_3
    //   387: iconst_0
    //   388: aaload
    //   389: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   392: pop
    //   393: aload_2
    //   394: ldc_w 1272
    //   397: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   400: pop
    //   401: aload_2
    //   402: aload_3
    //   403: iconst_1
    //   404: aaload
    //   405: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   408: pop
    //   409: aload_1
    //   410: aload_2
    //   411: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   414: invokevirtual 1277	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   417: aload_3
    //   418: areturn
    //   419: astore_1
    //   420: goto -74 -> 346
    //   423: astore_2
    //   424: goto -106 -> 318
    //   427: astore 4
    //   429: goto -79 -> 350
    //   432: astore_1
    //   433: goto -68 -> 365
    //   436: astore_1
    //   437: goto -93 -> 344
    // Local variable table:
    //   start	length	slot	name	signature
    //   60	57	0	i1	int
    //   25	385	1	localObject1	Object
    //   419	1	1	localIOException1	IOException
    //   432	1	1	localException1	Exception
    //   436	1	1	localException2	Exception
    //   37	374	2	localObject2	Object
    //   423	1	2	localIOException2	IOException
    //   4	286	3	arrayOfString1	String[]
    //   308	1	3	localObject3	Object
    //   312	1	3	localObject4	Object
    //   323	95	3	arrayOfString2	String[]
    //   42	250	4	localObject5	Object
    //   427	1	4	localIOException3	IOException
    //   75	143	5	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   38	44	308	finally
    //   49	59	308	finally
    //   61	113	308	finally
    //   120	154	308	finally
    //   154	160	308	finally
    //   165	175	308	finally
    //   180	223	308	finally
    //   226	260	308	finally
    //   263	297	308	finally
    //   26	38	312	finally
    //   15	26	323	finally
    //   15	26	419	java/io/IOException
    //   26	38	423	java/io/IOException
    //   38	44	427	java/io/IOException
    //   49	59	427	java/io/IOException
    //   61	113	427	java/io/IOException
    //   120	154	427	java/io/IOException
    //   154	160	427	java/io/IOException
    //   165	175	427	java/io/IOException
    //   180	223	427	java/io/IOException
    //   226	260	427	java/io/IOException
    //   263	297	427	java/io/IOException
    //   297	301	432	java/lang/Exception
    //   301	305	432	java/lang/Exception
    //   354	358	432	java/lang/Exception
    //   332	336	436	java/lang/Exception
    //   340	344	436	java/lang/Exception
  }
  
  public static native String getBaseKey();
  
  public static String getSign()
  {
    if (Build.VERSION.SDK_INT >= 23)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("version:");
      ((StringBuilder)localObject).append(Build.VERSION.SDK_INT);
      Log.i("TencentPay", ((StringBuilder)localObject).toString());
      return "F4:D1:13:D3:FF:E5:33:57:39:F8:CA:1D:AB:07:04:06";
    }
    Object localObject = v(a.a().b());
    if ((localObject != null) && (localObject.length != 0)) {
      return a(localObject[0]);
    }
    return "";
  }
  
  public static int h(String paramString)
  {
    try
    {
      int i1 = new BigDecimal(f.parse(paramString).toString()).multiply(new BigDecimal(10)).intValue();
      return i1;
    }
    catch (Exception paramString)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("jiaoToFen error:");
      localStringBuilder.append(paramString.toString());
      APLog.e("APTools", localStringBuilder.toString());
    }
    return 0;
  }
  
  public static String h()
  {
    try
    {
      String str = UUID.randomUUID().toString();
      return str;
    }
    catch (Exception localException) {}
    return "";
  }
  
  public static String h(Context paramContext)
  {
    paramContext = (TelephonyManager)paramContext.getSystemService("phone");
    try
    {
      paramContext = paramContext.getLine1Number();
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
      paramContext = "";
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getPhoneNum() = ");
    ((StringBuilder)localObject).append(paramContext);
    APLog.d("APTools", ((StringBuilder)localObject).toString());
    if ((!TextUtils.isEmpty(paramContext)) && (paramContext.length() > 11))
    {
      localObject = a(a(paramContext).substring(0, 11));
      paramContext = (Context)localObject;
      if (!d((String)localObject)) {
        return "";
      }
    }
    else
    {
      paramContext = "";
    }
    return paramContext;
  }
  
  public static String i()
  {
    return e("MidasDeviceId");
  }
  
  public static String i(Context paramContext)
  {
    paramContext = a(paramContext, "TencentUnipay", "succHFNum");
    if (!TextUtils.isEmpty(paramContext)) {
      return new String(e.a(paramContext));
    }
    return null;
  }
  
  public static String i(String paramString)
  {
    try
    {
      String str = f.parse(paramString).toString();
      return str;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("jiaoToFen error:");
      localStringBuilder.append(localException.toString());
      APLog.e("APTools", localStringBuilder.toString());
    }
    return paramString;
  }
  
  public static String j(Context paramContext)
  {
    Object localObject1 = new HashMap();
    ((HashMap)localObject1).put("android.permission.ACCESS_NETWORK_STATE", Boolean.valueOf(false));
    ((HashMap)localObject1).put("android.permission.ACCESS_WIFI_STATE", Boolean.valueOf(false));
    try
    {
      localObject2 = paramContext.getApplicationContext().getPackageManager();
      paramContext = ((PackageManager)localObject2).getPackageInfo(((PackageManager)localObject2).getPackageInfo(paramContext.getApplicationContext().getPackageName(), 0).packageName, 4096).requestedPermissions;
      localObject2 = ((HashMap)localObject1).entrySet().iterator();
      label147:
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (Map.Entry)((Iterator)localObject2).next();
        String str = (String)((Map.Entry)localObject3).getKey();
        int i1 = 0;
        for (;;)
        {
          if (i1 >= paramContext.length) {
            break label147;
          }
          if (paramContext[i1].equals(str))
          {
            ((Map.Entry)localObject3).setValue(Boolean.valueOf(true));
            break;
          }
          i1 += 1;
        }
      }
    }
    catch (Exception paramContext)
    {
      Object localObject2;
      Object localObject3;
      label149:
      break label149;
    }
    paramContext = new StringBuffer();
    localObject1 = ((HashMap)localObject1).entrySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Map.Entry)((Iterator)localObject1).next();
      localObject3 = (String)((Map.Entry)localObject2).getKey();
      if (!((Boolean)((Map.Entry)localObject2).getValue()).booleanValue())
      {
        paramContext.append((String)localObject3);
        paramContext.append("\n");
      }
    }
    return paramContext.toString();
  }
  
  public static BigDecimal j(String paramString)
  {
    try
    {
      paramString = new BigDecimal(f.parse(paramString).toString()).multiply(new BigDecimal(10));
      return paramString;
    }
    catch (Exception paramString)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("yuanTojiao error:");
      localStringBuilder.append(paramString.toString());
      APLog.e("APTools", localStringBuilder.toString());
    }
    return new BigDecimal(0);
  }
  
  public static boolean j()
  {
    long l1 = System.currentTimeMillis();
    if (l1 - c < 1000L) {
      return true;
    }
    c = l1;
    return false;
  }
  
  public static String k(Context paramContext)
  {
    String str = m(paramContext);
    paramContext = l(paramContext);
    if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty(paramContext)))
    {
      if (!TextUtils.isEmpty(str)) {
        return str;
      }
      if (!TextUtils.isEmpty(paramContext)) {
        return paramContext;
      }
    }
    return null;
  }
  
  public static boolean k()
  {
    return a.a().b().getPackageName().equals("com.tencent.unipay");
  }
  
  public static boolean k(String paramString)
  {
    return Pattern.compile("^\\+?[1-9][0-9]{0,6}$").matcher(paramString).matches();
  }
  
  public static String l(Context paramContext)
  {
    Object localObject1 = new HashMap();
    Object localObject2 = new ActivityInfo();
    ((ActivityInfo)localObject2).name = "com.wsj.pay.proxyactivity.APWSJPayProxyActivity";
    ((ActivityInfo)localObject2).exported = false;
    ((HashMap)localObject1).put(localObject2, Boolean.valueOf(false));
    localObject2 = new ActivityInfo();
    ((ActivityInfo)localObject2).name = "com.wsj.pay.wx.APWSJWXPayActivity";
    ((ActivityInfo)localObject2).exported = true;
    ((HashMap)localObject1).put(localObject2, Boolean.valueOf(false));
    try
    {
      localObject2 = paramContext.getApplicationContext().getPackageManager();
      paramContext = ((PackageManager)localObject2).getPackageInfo(((PackageManager)localObject2).getPackageInfo(paramContext.getApplicationContext().getPackageName(), 0).packageName, 1).activities;
      localObject2 = ((HashMap)localObject1).entrySet().iterator();
      label275:
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (Map.Entry)((Iterator)localObject2).next();
        ActivityInfo localActivityInfo = (ActivityInfo)((Map.Entry)localObject3).getKey();
        int i1 = 0;
        for (;;)
        {
          if (i1 >= paramContext.length) {
            break label275;
          }
          Object localObject4 = paramContext[i1];
          String str = localObject4.name;
          if (((str.equals("com.wsj.pay.proxyactivity.APWSJPayProxyActivity")) && (localObject4.screenOrientation != 0) && (localObject4.screenOrientation != 1)) || ((str.equals("com.wsj.pay.proxyactivity.APWSJPayProxyActivity")) && (localObject4.configChanges != 1184) && (localObject4.configChanges != 160))) {
            break;
          }
          if ((localActivityInfo.name.equals(str)) && (localActivityInfo.exported == localObject4.exported))
          {
            ((Map.Entry)localObject3).setValue(Boolean.valueOf(true));
            break;
          }
          i1 += 1;
        }
      }
    }
    catch (Exception paramContext)
    {
      Object localObject3;
      label277:
      break label277;
    }
    paramContext = new StringBuffer();
    localObject1 = ((HashMap)localObject1).entrySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Map.Entry)((Iterator)localObject1).next();
      localObject3 = (ActivityInfo)((Map.Entry)localObject2).getKey();
      if (!((Boolean)((Map.Entry)localObject2).getValue()).booleanValue())
      {
        paramContext.append(((ActivityInfo)localObject3).name);
        paramContext.append("\n");
      }
    }
    return paramContext.toString();
  }
  
  /* Error */
  public static String l(String paramString)
  {
    // Byte code:
    //   0: sipush 1024
    //   3: newarray byte
    //   5: astore 6
    //   7: aconst_null
    //   8: astore_3
    //   9: aconst_null
    //   10: astore 5
    //   12: new 1394	java/io/FileInputStream
    //   15: dup
    //   16: aload_0
    //   17: invokespecial 1395	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   20: astore_0
    //   21: aload_0
    //   22: astore_2
    //   23: new 1397	java/io/BufferedInputStream
    //   26: dup
    //   27: aload_0
    //   28: invokespecial 1400	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   31: astore 4
    //   33: ldc_w 594
    //   36: invokestatic 599	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   39: astore_2
    //   40: aload 4
    //   42: aload 6
    //   44: invokevirtual 1401	java/io/BufferedInputStream:read	([B)I
    //   47: istore_1
    //   48: iload_1
    //   49: iconst_m1
    //   50: if_icmpeq +14 -> 64
    //   53: aload_2
    //   54: aload 6
    //   56: iconst_0
    //   57: iload_1
    //   58: invokevirtual 1404	java/security/MessageDigest:update	([BII)V
    //   61: goto -21 -> 40
    //   64: aload_2
    //   65: invokevirtual 1406	java/security/MessageDigest:digest	()[B
    //   68: invokestatic 1408	com/pay/tool/APTools:b	([B)Ljava/lang/String;
    //   71: astore_2
    //   72: aload 4
    //   74: invokevirtual 1409	java/io/BufferedInputStream:close	()V
    //   77: aload_0
    //   78: invokevirtual 783	java/io/InputStream:close	()V
    //   81: aload_2
    //   82: areturn
    //   83: astore_0
    //   84: aload_0
    //   85: invokevirtual 1089	java/io/IOException:printStackTrace	()V
    //   88: aload_2
    //   89: areturn
    //   90: astore_2
    //   91: aload 4
    //   93: astore_3
    //   94: goto +79 -> 173
    //   97: astore_2
    //   98: aload 4
    //   100: astore 5
    //   102: aload_2
    //   103: astore 4
    //   105: goto +20 -> 125
    //   108: astore 4
    //   110: goto +15 -> 125
    //   113: astore_2
    //   114: aconst_null
    //   115: astore_3
    //   116: aload_3
    //   117: astore_0
    //   118: goto +55 -> 173
    //   121: astore 4
    //   123: aconst_null
    //   124: astore_0
    //   125: aload 5
    //   127: astore_3
    //   128: aload_0
    //   129: astore_2
    //   130: aload 4
    //   132: invokevirtual 610	java/lang/Exception:printStackTrace	()V
    //   135: aload 5
    //   137: ifnull +11 -> 148
    //   140: aload 5
    //   142: invokevirtual 1409	java/io/BufferedInputStream:close	()V
    //   145: goto +3 -> 148
    //   148: aload_0
    //   149: ifnull +14 -> 163
    //   152: aload_0
    //   153: invokevirtual 783	java/io/InputStream:close	()V
    //   156: goto +7 -> 163
    //   159: aload_0
    //   160: invokevirtual 1089	java/io/IOException:printStackTrace	()V
    //   163: ldc 16
    //   165: areturn
    //   166: astore 4
    //   168: aload_2
    //   169: astore_0
    //   170: aload 4
    //   172: astore_2
    //   173: aload_3
    //   174: ifnull +10 -> 184
    //   177: aload_3
    //   178: invokevirtual 1409	java/io/BufferedInputStream:close	()V
    //   181: goto +3 -> 184
    //   184: aload_0
    //   185: ifnull +14 -> 199
    //   188: aload_0
    //   189: invokevirtual 783	java/io/InputStream:close	()V
    //   192: goto +7 -> 199
    //   195: aload_0
    //   196: invokevirtual 1089	java/io/IOException:printStackTrace	()V
    //   199: aload_2
    //   200: athrow
    //   201: astore_0
    //   202: goto -43 -> 159
    //   205: astore_0
    //   206: goto -11 -> 195
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	209	0	paramString	String
    //   47	11	1	i1	int
    //   22	67	2	localObject1	Object
    //   90	1	2	localObject2	Object
    //   97	6	2	localException1	Exception
    //   113	1	2	localObject3	Object
    //   129	71	2	localObject4	Object
    //   8	170	3	localObject5	Object
    //   31	73	4	localObject6	Object
    //   108	1	4	localException2	Exception
    //   121	10	4	localException3	Exception
    //   166	5	4	localObject7	Object
    //   10	131	5	localObject8	Object
    //   5	50	6	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   72	81	83	java/io/IOException
    //   33	40	90	finally
    //   40	48	90	finally
    //   53	61	90	finally
    //   64	72	90	finally
    //   33	40	97	java/lang/Exception
    //   40	48	97	java/lang/Exception
    //   53	61	97	java/lang/Exception
    //   64	72	97	java/lang/Exception
    //   23	33	108	java/lang/Exception
    //   12	21	113	finally
    //   12	21	121	java/lang/Exception
    //   23	33	166	finally
    //   130	135	166	finally
    //   140	145	201	java/io/IOException
    //   152	156	201	java/io/IOException
    //   177	181	205	java/io/IOException
    //   188	192	205	java/io/IOException
  }
  
  public static void l()
  {
    checkParam(a.a().b().getApplicationInfo());
  }
  
  public static String m(Context paramContext)
  {
    Object localObject1 = new HashMap();
    Object localObject2 = new ActivityInfo();
    ((ActivityInfo)localObject2).name = "com.tencent.midas.proxyactivity.APMidasPayProxyActivity";
    ((ActivityInfo)localObject2).exported = false;
    ((HashMap)localObject1).put(localObject2, Boolean.valueOf(false));
    localObject2 = new ActivityInfo();
    ((ActivityInfo)localObject2).name = "com.tencent.midas.wx.APMidasWXPayActivity";
    ((ActivityInfo)localObject2).exported = true;
    ((HashMap)localObject1).put(localObject2, Boolean.valueOf(false));
    localObject2 = new ActivityInfo();
    ((ActivityInfo)localObject2).name = "com.tencent.midas.qq.APMidasQQWalletActivity";
    ((ActivityInfo)localObject2).exported = true;
    ((HashMap)localObject1).put(localObject2, Boolean.valueOf(false));
    try
    {
      localObject2 = paramContext.getApplicationContext().getPackageManager();
      paramContext = ((PackageManager)localObject2).getPackageInfo(((PackageManager)localObject2).getPackageInfo(paramContext.getApplicationContext().getPackageName(), 0).packageName, 1).activities;
      localObject2 = ((HashMap)localObject1).entrySet().iterator();
      label282:
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (Map.Entry)((Iterator)localObject2).next();
        ActivityInfo localActivityInfo = (ActivityInfo)((Map.Entry)localObject3).getKey();
        int i1 = 0;
        for (;;)
        {
          if (i1 >= paramContext.length) {
            break label282;
          }
          Object localObject4 = paramContext[i1];
          String str = localObject4.name;
          if ((str.equals("com.tencent.midas.proxyactivity.APMidasPayProxyActivity")) && (localObject4.configChanges != 1184) && (localObject4.configChanges != 160) && (Build.VERSION.SDK_INT < 26)) {
            break;
          }
          if ((localActivityInfo.name.equals(str)) && (localActivityInfo.exported == localObject4.exported))
          {
            ((Map.Entry)localObject3).setValue(Boolean.valueOf(true));
            break;
          }
          i1 += 1;
        }
      }
    }
    catch (Exception paramContext)
    {
      Object localObject3;
      label284:
      break label284;
    }
    paramContext = new StringBuffer();
    localObject1 = ((HashMap)localObject1).entrySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Map.Entry)((Iterator)localObject1).next();
      localObject3 = (ActivityInfo)((Map.Entry)localObject2).getKey();
      if (!((Boolean)((Map.Entry)localObject2).getValue()).booleanValue())
      {
        paramContext.append(((ActivityInfo)localObject3).name);
        paramContext.append("\n");
      }
    }
    return paramContext.toString();
  }
  
  public static boolean m()
  {
    String str = fy.a().r();
    if (TextUtils.isEmpty(str)) {
      return false;
    }
    return str.startsWith("66666");
  }
  
  public static boolean m(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("checkValid() pluginName = ");
    ((StringBuilder)localObject).append(paramString);
    APLog.i("APTools", ((StringBuilder)localObject).toString());
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    localObject = a.a().d.getDir("midasplugins", 0).listFiles();
    ArrayList localArrayList = aq.a().c();
    if (localArrayList != null)
    {
      if (localArrayList.size() <= 0) {
        return true;
      }
      int i1 = 0;
      while (i1 < localObject.length)
      {
        if (localObject[i1].getName().startsWith(paramString))
        {
          bool = true;
          break label122;
        }
        i1 += 1;
      }
      boolean bool = false;
      label122:
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkValid() isHasPlugin = ");
      localStringBuilder.append(bool);
      APLog.i("APTools", localStringBuilder.toString());
      if (!bool) {
        return false;
      }
      if ((localArrayList != null) && (localArrayList.size() > 0))
      {
        i1 = 0;
        while (i1 < localObject.length)
        {
          if (localObject[i1].getName().startsWith(paramString))
          {
            paramString = l(localObject[i1].getAbsolutePath());
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("resultData=校验buypage来的checlistmd5值时本地md5是");
            localStringBuilder.append(paramString);
            APLog.i("APHFChannel", localStringBuilder.toString());
            int i2 = 0;
            while (i2 < localArrayList.size())
            {
              if (((ap)localArrayList.get(i2)).h.compareToIgnoreCase(paramString) == 0)
              {
                paramString = new StringBuilder();
                paramString.append("resultData=校验buypage来的");
                paramString.append(((ap)localArrayList.get(i2)).h);
                APLog.i("APHFChannel", paramString.toString());
                i2 = 1;
                break label333;
              }
              i2 += 1;
            }
            i2 = 0;
            label333:
            if (i2 == 0) {
              try
              {
                localObject[i1].delete();
                APLog.i("APHFChannel", "resultData=data区里的文件与cgi的升级表里的文件Md5值不匹配，本地md5值文件被篡改，删掉文件");
                return false;
              }
              catch (Exception paramString)
              {
                paramString.printStackTrace();
                return false;
              }
            }
            return true;
          }
          i1 += 1;
        }
      }
      return false;
    }
    return true;
  }
  
  public static String n(Context paramContext)
  {
    try
    {
      Object localObject = ((APPluginActivity)paramContext).mProxyActivity;
      paramContext = ((Activity)localObject).getPackageManager();
      localObject = paramContext.getApplicationInfo(((Activity)localObject).getPackageName(), 0);
      paramContext = (String)paramContext.getApplicationLabel((ApplicationInfo)localObject);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("applicationName:");
      ((StringBuilder)localObject).append(paramContext);
      APLog.i("APTools", ((StringBuilder)localObject).toString());
      return paramContext;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return "";
  }
  
  public static String n(String paramString)
  {
    if (p < 0) {}
    try
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(o);
      localStringBuilder.append(".openapi.IWXAPI");
      Class.forName(localStringBuilder.toString());
      p = 1;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder;
      label45:
      break label45;
    }
    p = 0;
    if (p > 0)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(o);
      localStringBuilder.append(".");
      localStringBuilder.append(paramString);
      return localStringBuilder.toString();
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(n);
    localStringBuilder.append(".");
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  public static Bitmap o(Context paramContext)
  {
    try
    {
      PackageManager localPackageManager = paramContext.getPackageManager();
      paramContext = (BitmapDrawable)localPackageManager.getApplicationInfo(paramContext.getPackageName(), 0).loadIcon(localPackageManager);
      if (paramContext == null) {
        return null;
      }
      paramContext = paramContext.getBitmap();
      return paramContext;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return null;
  }
  
  public static boolean o(String paramString)
  {
    if (a.a().j())
    {
      if (("wechat".equals(paramString)) || ("qqwallet".equals(paramString))) {
        return true;
      }
    }
    else if ((!d.a()) && (!d.b()))
    {
      if (("wechat".equals(paramString)) || ("qqwallet".equals(paramString)) || ("qdqb".equals(paramString))) {
        break label93;
      }
      if ("qbqd".equals(paramString)) {
        return true;
      }
    }
    return false;
    label93:
    return true;
  }
  
  public static String p(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    if (paramString.startsWith("http://")) {
      return paramString.substring("http://".length());
    }
    String str = paramString;
    if (paramString.startsWith("https://")) {
      str = paramString.substring("https://".length());
    }
    return str;
  }
  
  public static void p(Context paramContext)
  {
    try
    {
      Object localObject = paramContext.getApplicationContext().getPackageManager();
      paramContext = paramContext.getApplicationContext().getPackageName();
      int i1 = 0;
      paramContext = ((PackageManager)localObject).getPackageInfo(((PackageManager)localObject).getPackageInfo(paramContext, 0).packageName, 1).activities;
      while (i1 < paramContext.length)
      {
        localObject = paramContext[i1];
        if (((ActivityInfo)localObject).name.equals("com.tencent.midas.proxyactivity.APMidasPayProxyActivity"))
        {
          localObject = ((ActivityInfo)localObject).processName;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("processName:");
          localStringBuilder.append((String)localObject);
          APLog.d("APTools", localStringBuilder.toString());
          if ((!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).contains("midasPay"))) {
            APAppDataInterface.singleton().e(true);
          }
        }
        i1 += 1;
      }
      return;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public static Bundle q(String paramString)
  {
    try
    {
      Object localObject = e.a(paramString);
      paramString = Parcel.obtain();
      paramString.unmarshall((byte[])localObject, 0, localObject.length);
      paramString.setDataPosition(0);
      localObject = new Bundle();
      ((Bundle)localObject).readFromParcel(paramString);
      return localObject;
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public static boolean q(Context paramContext)
  {
    try
    {
      Object localObject = paramContext.getApplicationContext().getPackageManager();
      paramContext = ((PackageManager)localObject).getPackageInfo(((PackageManager)localObject).getPackageInfo(paramContext.getApplicationContext().getPackageName(), 0).packageName, 1).activities;
      int i1 = 0;
      while (i1 < paramContext.length)
      {
        localObject = paramContext[i1];
        if (((ActivityInfo)localObject).name.equals("com.tencent.midas.proxyactivity.APMidasPayProxyActivity"))
        {
          localObject = ((ActivityInfo)localObject).processName;
          if (!TextUtils.isEmpty((CharSequence)localObject))
          {
            boolean bool = ((String)localObject).contains("midasPay");
            if (bool) {
              return true;
            }
          }
        }
        i1 += 1;
      }
      return false;
    }
    catch (Exception paramContext) {}
    return false;
  }
  
  public static String r(Context paramContext)
  {
    Object localObject = paramContext;
    try
    {
      if ((paramContext instanceof APPluginActivity)) {
        localObject = ((APPluginActivity)paramContext).mProxyActivity;
      }
      paramContext = ((Context)localObject).getPackageManager();
      try
      {
        paramContext = paramContext.getPackageInfo(((Context)localObject).getPackageName(), 0).versionName;
        return paramContext;
      }
      catch (PackageManager.NameNotFoundException paramContext)
      {
        paramContext.printStackTrace();
        return "";
      }
      return "";
    }
    catch (Throwable paramContext)
    {
      paramContext.printStackTrace();
      APLog.w("getAppVersion", paramContext.toString());
    }
  }
  
  private static String s(Context paramContext)
  {
    try
    {
      paramContext = new fz().a(paramContext, "TencentUnipay", "macAddressLocal");
      return paramContext;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return null;
  }
  
  public static void setKey(String paramString)
  {
    d = paramString;
  }
  
  private static String t(Context paramContext)
  {
    try
    {
      paramContext = new fz().a(paramContext, "TencentUnipay", "deviceIdLocal");
      return paramContext;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return null;
  }
  
  private static String u(Context paramContext)
  {
    int i1 = 0;
    paramContext = paramContext.getDir("midasplugins", 0);
    if (paramContext != null)
    {
      paramContext = paramContext.listFiles();
      while (i1 < paramContext.length)
      {
        Object localObject = paramContext[i1];
        if (localObject.getName().startsWith("MidasPay")) {
          try
          {
            paramContext = localObject.getCanonicalPath();
            return paramContext;
          }
          catch (IOException paramContext)
          {
            paramContext.printStackTrace();
          }
        }
        i1 += 1;
      }
    }
    return "";
  }
  
  private static Signature[] v(Context paramContext)
  {
    if (!k())
    {
      paramContext = u(paramContext);
      if (!TextUtils.isEmpty(paramContext)) {
        return f(paramContext);
      }
      return null;
    }
    return w(paramContext);
  }
  
  private static Signature[] w(Context paramContext)
  {
    Iterator localIterator = paramContext.getPackageManager().getInstalledPackages(64).iterator();
    while (localIterator.hasNext())
    {
      PackageInfo localPackageInfo = (PackageInfo)localIterator.next();
      if (localPackageInfo.packageName.equals(paramContext.getPackageName())) {
        return localPackageInfo.signatures;
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     com.pay.tool.APTools
 * JD-Core Version:    0.7.0.1
 */