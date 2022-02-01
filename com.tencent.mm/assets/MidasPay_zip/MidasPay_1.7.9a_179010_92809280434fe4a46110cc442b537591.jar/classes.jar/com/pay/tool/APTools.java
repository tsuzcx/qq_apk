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
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.os.Parcel;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.text.format.Formatter;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
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
import midas.x.c6;
import midas.x.d;
import midas.x.d5;
import midas.x.d6;
import midas.x.e;
import midas.x.f6;
import midas.x.gb;
import midas.x.o4;
import midas.x.p4;
import midas.x.q0;
import midas.x.r0;
import midas.x.w4;
import midas.x.x4;
import org.apache.http.conn.ConnectTimeoutException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class APTools
{
  public static final String a = "APTools";
  public static long b = 0L;
  public static String c = "";
  public static String d = "SfjUddAdIdxnd4v4";
  public static String e = "";
  public static String f = "";
  public static String g = "";
  public static String h = "";
  public static boolean i = false;
  public static boolean j = false;
  public static NumberFormat k = ;
  public static String l = "com.tencent.mm.sdk";
  public static String m = "com.tencent.mm.opensdk";
  public static int n = -1;
  
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
        String str = a;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("https exception");
        localStringBuilder.append(paramException.toString());
        APLog.d(str, localStringBuilder.toString());
        if (b(paramException)) {
          return -55;
        }
        if (c(paramException)) {
          return -56;
        }
        if (a(paramException)) {
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
  
  public static int a(gb paramgb)
  {
    Exception localException = paramgb.c;
    if (localException == null) {
      return paramgb.a;
    }
    if ((localException instanceof ConnectTimeoutException)) {
      return 20001;
    }
    if ((localException instanceof SocketTimeoutException)) {
      return 20002;
    }
    if ((localException instanceof IOException)) {
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
    Object localObject = paramObject;
    if (!(paramObject instanceof JSONArray))
    {
      if ((paramObject instanceof JSONObject)) {
        return paramObject;
      }
      if (paramObject.equals(JSONObject.NULL)) {
        return paramObject;
      }
    }
    try
    {
      if ((paramObject instanceof Collection)) {
        return new JSONArray((Collection)paramObject);
      }
      if (paramObject.getClass().isArray())
      {
        localObject = new JSONArray();
        int i2 = Array.getLength(paramObject);
        int i1 = 0;
        while (i1 < i2)
        {
          ((JSONArray)localObject).put(a(Array.get(paramObject, i1)));
          i1 += 1;
        }
      }
      if ((paramObject instanceof Map)) {
        return new JSONObject((Map)paramObject);
      }
      localObject = paramObject;
      if (!(paramObject instanceof Boolean))
      {
        localObject = paramObject;
        if (!(paramObject instanceof Byte))
        {
          localObject = paramObject;
          if (!(paramObject instanceof Character))
          {
            localObject = paramObject;
            if (!(paramObject instanceof Double))
            {
              localObject = paramObject;
              if (!(paramObject instanceof Float))
              {
                localObject = paramObject;
                if (!(paramObject instanceof Integer))
                {
                  localObject = paramObject;
                  if (!(paramObject instanceof Long))
                  {
                    localObject = paramObject;
                    if (!(paramObject instanceof Short))
                    {
                      if ((paramObject instanceof String)) {
                        return paramObject;
                      }
                      if (!paramObject.getClass().getPackage().getName().startsWith("java.")) {
                        break label233;
                      }
                      localObject = paramObject.toString();
                    }
                  }
                }
              }
            }
          }
        }
      }
      return localObject;
    }
    catch (Exception paramObject)
    {
      label233:
      break label233;
    }
    localObject = null;
    return localObject;
    return localObject;
  }
  
  public static String a(int paramInt)
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
    o4 localo4 = p4.p().e();
    String str2 = localo4.c.a();
    String str1;
    if (paramInt == 0)
    {
      str1 = str2;
      if ("hfpay".equals(paramString))
      {
        str1 = str2;
        if (!TextUtils.isEmpty(APHFChannel.v)) {
          str1 = ((x4)localo4.c).b(localo4.f.f, APHFChannel.v);
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
          if (!TextUtils.isEmpty(APHFChannel.w))
          {
            str1 = str2;
            if (!"0".equals(APHFChannel.w))
            {
              paramInt = p(localo4.c.a(localo4.f.f));
              int i1 = Integer.parseInt(APHFChannel.w);
              str1 = str2;
              if (paramInt != i1) {
                str1 = b(i1);
              }
            }
          }
        }
      }
    }
    paramString = new StringBuilder();
    paramString.append("amt=");
    paramString.append(String.valueOf(p(str1)));
    return b(paramString.toString(), 1);
  }
  
  public static String a(Activity paramActivity)
  {
    boolean bool = c();
    Object localObject2 = "";
    if (bool) {
      return "";
    }
    StringBuffer localStringBuffer;
    Object localObject1;
    Object localObject3;
    if ((!j) && (TextUtils.isEmpty(h)))
    {
      j = true;
      h = m(paramActivity);
      if (!TextUtils.isEmpty(h)) {
        return h;
      }
      localStringBuffer = new StringBuffer();
      localObject1 = l(paramActivity);
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("imei=");
      ((StringBuilder)localObject3).append((String)localObject1);
      localStringBuffer.append(((StringBuilder)localObject3).toString());
      localObject1 = f(paramActivity);
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("&androidid=");
      ((StringBuilder)localObject3).append((String)localObject1);
      localStringBuffer.append(((StringBuilder)localObject3).toString());
      localObject3 = g();
      localObject1 = localObject3;
      if (localObject3 == null) {
        localObject1 = "";
      }
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("&mac=");
      ((StringBuilder)localObject3).append((String)localObject1);
      localStringBuffer.append(((StringBuilder)localObject3).toString());
      localObject3 = Build.DEVICE;
      localObject1 = localObject3;
      if (localObject3 == null) {
        localObject1 = "";
      }
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("&device=");
      ((StringBuilder)localObject3).append((String)localObject1);
      localStringBuffer.append(((StringBuilder)localObject3).toString());
      localObject1 = h();
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("&manufacturer=");
      ((StringBuilder)localObject3).append((String)localObject1);
      localStringBuffer.append(((StringBuilder)localObject3).toString());
      localObject1 = Build.VERSION.RELEASE;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("&sdkVersion=");
      ((StringBuilder)localObject3).append((String)localObject1);
      localStringBuffer.append(((StringBuilder)localObject3).toString());
      localObject1 = Build.MODEL;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("&showModel=");
      ((StringBuilder)localObject3).append((String)localObject1);
      localStringBuffer.append(((StringBuilder)localObject3).toString());
      localObject1 = f();
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("&phoneIp=");
      ((StringBuilder)localObject3).append((String)localObject1);
      localStringBuffer.append(((StringBuilder)localObject3).toString());
    }
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
    catch (Exception localException1)
    {
      try
      {
        for (;;)
        {
          localObject1 = o(paramActivity);
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("@oper=");
          ((StringBuilder)localObject3).append((String)localObject1);
          localStringBuffer.append(((StringBuilder)localObject3).toString());
          try
          {
            label535:
            localObject1 = n(paramActivity);
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("@mnc=");
            ((StringBuilder)localObject3).append((String)localObject1);
            localStringBuffer.append(((StringBuilder)localObject3).toString());
          }
          catch (Exception localException3)
          {
            label581:
            break label581;
          }
          localObject3 = k(paramActivity);
          localObject1 = localObject3;
          if (localObject3 == null) {
            localObject1 = "";
          }
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("&availableMemory=");
          ((StringBuilder)localObject3).append((String)localObject1);
          localStringBuffer.append(((StringBuilder)localObject3).toString());
          localObject1 = t(paramActivity);
          if (localObject1 == null) {
            localObject1 = localObject2;
          }
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("&totalMemory=");
          ((StringBuilder)localObject2).append((String)localObject1);
          localStringBuffer.append(((StringBuilder)localObject2).toString());
          localObject1 = e();
          if (localObject1.length == 2)
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("&cup=");
            ((StringBuilder)localObject2).append(localObject1[0]);
            localStringBuffer.append(((StringBuilder)localObject2).toString());
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("&cupFrequency=");
            ((StringBuilder)localObject2).append(localObject1[1]);
            localStringBuffer.append(((StringBuilder)localObject2).toString());
          }
          h = localStringBuffer.toString();
          d(paramActivity, h);
          return h;
          return h;
          localException1 = localException1;
        }
      }
      catch (Exception localException2)
      {
        break label535;
      }
    }
  }
  
  public static String a(Context paramContext)
  {
    String str = b(paramContext);
    paramContext = e(paramContext);
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
  
  public static String a(Context paramContext, String paramString)
  {
    return a(paramContext, paramString, false);
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
      paramString = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getInstalledVersionName() e = ");
      localStringBuilder.append(paramContext.toString());
      APLog.d(paramString, localStringBuilder.toString());
    }
    return "";
  }
  
  public static String a(Signature paramSignature)
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
  
  public static String a(String paramString, int paramInt)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    String str3 = "";
    if (!bool)
    {
      if (paramInt <= 0) {
        return paramString;
      }
      int i1 = 0;
      String str1 = paramString;
      String str2;
      for (paramString = str3;; paramString = str2)
      {
        str3 = paramString;
        if (i1 >= paramInt) {
          break;
        }
        try
        {
          str1 = URLDecoder.decode(str1, "utf-8");
        }
        catch (Exception localException)
        {
          APLog.i("urlEncode", localException.toString());
          str2 = paramString;
        }
        i1 += 1;
      }
    }
    APLog.w("", "解码内容为空");
    return str3;
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
      for (;;)
      {
        boolean bool = localIterator.hasNext();
        if (!bool) {
          break;
        }
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
    finally
    {
      paramBundle.printStackTrace();
    }
    return localJSONObject;
  }
  
  public static void a()
  {
    checkParam(a.r().a().getApplicationInfo());
  }
  
  public static void a(String paramString1, String paramString2)
  {
    Object localObject1 = paramString2;
    if (!paramString2.endsWith(File.separator))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(paramString2);
      ((StringBuilder)localObject1).append(File.separator);
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    boolean bool = Build.CPU_ABI.startsWith("arm64-v8a");
    paramString2 = "armeabi";
    if (bool) {
      paramString2 = "arm64-v8a";
    } else if ((!Build.CPU_ABI.startsWith("arm")) && (Build.CPU_ABI.startsWith("x86"))) {
      paramString2 = "x86";
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
  
  public static boolean a(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("checkValid() pluginName = ");
    ((StringBuilder)localObject).append(paramString);
    APLog.i("APTools", ((StringBuilder)localObject).toString());
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    localObject = a.r().d.getDir("midasplugins", 0).listFiles();
    ArrayList localArrayList = r0.p().a();
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
            paramString = b(localObject[i1].getAbsolutePath());
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("resultData=校验buypage来的checlistmd5值时本地md5是");
            localStringBuilder.append(paramString);
            APLog.i("APHFChannel", localStringBuilder.toString());
            int i2 = 0;
            while (i2 < localArrayList.size())
            {
              if (((q0)localArrayList.get(i2)).g.compareToIgnoreCase(paramString) == 0)
              {
                paramString = new StringBuilder();
                paramString.append("resultData=校验buypage来的");
                paramString.append(((q0)localArrayList.get(i2)).g);
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
  
  public static boolean a(Throwable paramThrowable)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("isTimeError https exception");
    localStringBuilder.append(paramThrowable.toString());
    APLog.w("APBaseHttpReq", localStringBuilder.toString());
    paramThrowable = paramThrowable.toString();
    return ((paramThrowable.contains("SSL handshake aborted")) && (paramThrowable.contains("usually a protocol error"))) || (paramThrowable.contains("GET_SERVER_HELLO"));
  }
  
  public static Certificate[] a(JarFile paramJarFile, JarEntry paramJarEntry, byte[] paramArrayOfByte)
  {
    Object localObject = null;
    try
    {
      paramJarFile = paramJarFile.getInputStream(paramJarEntry);
      while (paramJarFile.read(paramArrayOfByte, 0, paramArrayOfByte.length) != -1) {}
      paramJarFile.close();
      paramJarFile = localObject;
      if (paramJarEntry != null) {
        paramJarFile = paramJarEntry.getCertificates();
      }
      return paramJarFile;
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
  
  public static String b(int paramInt)
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
  
  public static String b(Context paramContext)
  {
    Object localObject1 = new HashMap();
    Object localObject3 = new ActivityInfo();
    ((ActivityInfo)localObject3).name = "com.tencent.midas.proxyactivity.APMidasPayProxyActivity";
    Object localObject2 = Boolean.valueOf(false);
    ((ActivityInfo)localObject3).exported = false;
    ((HashMap)localObject1).put(localObject3, localObject2);
    localObject3 = new ActivityInfo();
    ((ActivityInfo)localObject3).name = "com.tencent.midas.wx.APMidasWXPayActivity";
    ((ActivityInfo)localObject3).exported = true;
    ((HashMap)localObject1).put(localObject3, localObject2);
    localObject3 = new ActivityInfo();
    ((ActivityInfo)localObject3).name = "com.tencent.midas.qq.APMidasQQWalletActivity";
    ((ActivityInfo)localObject3).exported = true;
    ((HashMap)localObject1).put(localObject3, localObject2);
    try
    {
      localObject2 = paramContext.getApplicationContext().getPackageManager();
      paramContext = ((PackageManager)localObject2).getPackageInfo(((PackageManager)localObject2).getPackageInfo(paramContext.getApplicationContext().getPackageName(), 0).packageName, 1).activities;
      localObject2 = ((HashMap)localObject1).entrySet().iterator();
      label290:
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (Map.Entry)((Iterator)localObject2).next();
        ActivityInfo localActivityInfo = (ActivityInfo)((Map.Entry)localObject3).getKey();
        int i1 = 0;
        for (;;)
        {
          if (i1 >= paramContext.length) {
            break label290;
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
      label292:
      break label292;
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
  
  /* Error */
  public static String b(String paramString)
  {
    // Byte code:
    //   0: sipush 1024
    //   3: newarray byte
    //   5: astore 6
    //   7: aconst_null
    //   8: astore_3
    //   9: aconst_null
    //   10: astore 5
    //   12: new 1003	java/io/FileInputStream
    //   15: dup
    //   16: aload_0
    //   17: invokespecial 1004	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   20: astore_0
    //   21: aload_0
    //   22: astore_2
    //   23: new 1006	java/io/BufferedInputStream
    //   26: dup
    //   27: aload_0
    //   28: invokespecial 1009	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   31: astore 4
    //   33: ldc_w 621
    //   36: invokestatic 626	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   39: astore_2
    //   40: aload 4
    //   42: aload 6
    //   44: invokevirtual 1010	java/io/BufferedInputStream:read	([B)I
    //   47: istore_1
    //   48: iload_1
    //   49: iconst_m1
    //   50: if_icmpeq +14 -> 64
    //   53: aload_2
    //   54: aload 6
    //   56: iconst_0
    //   57: iload_1
    //   58: invokevirtual 1013	java/security/MessageDigest:update	([BII)V
    //   61: goto -21 -> 40
    //   64: aload_2
    //   65: invokevirtual 1015	java/security/MessageDigest:digest	()[B
    //   68: invokestatic 1017	com/pay/tool/APTools:c	([B)Ljava/lang/String;
    //   71: astore_2
    //   72: aload 4
    //   74: invokevirtual 1018	java/io/BufferedInputStream:close	()V
    //   77: aload_0
    //   78: invokevirtual 824	java/io/InputStream:close	()V
    //   81: aload_2
    //   82: areturn
    //   83: astore_0
    //   84: aload_0
    //   85: invokevirtual 829	java/io/IOException:printStackTrace	()V
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
    //   132: invokevirtual 637	java/lang/Exception:printStackTrace	()V
    //   135: aload 5
    //   137: ifnull +11 -> 148
    //   140: aload 5
    //   142: invokevirtual 1018	java/io/BufferedInputStream:close	()V
    //   145: goto +3 -> 148
    //   148: aload_0
    //   149: ifnull +14 -> 163
    //   152: aload_0
    //   153: invokevirtual 824	java/io/InputStream:close	()V
    //   156: goto +7 -> 163
    //   159: aload_0
    //   160: invokevirtual 829	java/io/IOException:printStackTrace	()V
    //   163: ldc 17
    //   165: areturn
    //   166: astore 4
    //   168: aload_2
    //   169: astore_0
    //   170: aload 4
    //   172: astore_2
    //   173: aload_3
    //   174: ifnull +10 -> 184
    //   177: aload_3
    //   178: invokevirtual 1018	java/io/BufferedInputStream:close	()V
    //   181: goto +3 -> 184
    //   184: aload_0
    //   185: ifnull +14 -> 199
    //   188: aload_0
    //   189: invokevirtual 824	java/io/InputStream:close	()V
    //   192: goto +7 -> 199
    //   195: aload_0
    //   196: invokevirtual 829	java/io/IOException:printStackTrace	()V
    //   199: goto +5 -> 204
    //   202: aload_2
    //   203: athrow
    //   204: goto -2 -> 202
    //   207: astore_0
    //   208: goto -49 -> 159
    //   211: astore_0
    //   212: goto -17 -> 195
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	215	0	paramString	String
    //   47	11	1	i1	int
    //   22	67	2	localObject1	Object
    //   90	1	2	localObject2	Object
    //   97	6	2	localException1	Exception
    //   113	1	2	localObject3	Object
    //   129	74	2	localObject4	Object
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
    //   140	145	207	java/io/IOException
    //   152	156	207	java/io/IOException
    //   177	181	211	java/io/IOException
    //   188	192	211	java/io/IOException
  }
  
  public static String b(String paramString, int paramInt)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    String str3 = "";
    if (!bool)
    {
      if (paramInt <= 0) {
        return paramString;
      }
      int i1 = 0;
      String str1 = paramString;
      String str2;
      for (paramString = str3;; paramString = str2)
      {
        str3 = paramString;
        if (i1 >= paramInt) {
          break;
        }
        try
        {
          str1 = URLEncoder.encode(str1, "utf-8");
        }
        catch (Exception localException)
        {
          APLog.i("urlEncode", localException.toString());
          str2 = paramString;
        }
        i1 += 1;
      }
    }
    APLog.i("urlEncode", "编码内容为空");
    return str3;
  }
  
  public static String b(String paramString1, String paramString2)
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
    }
    return null;
  }
  
  public static String b(byte[] paramArrayOfByte)
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
  
  public static boolean b()
  {
    return c6.s0().H() >= 1;
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
      paramString = a;
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
  
  public static int c(Activity paramActivity)
  {
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    paramActivity.getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
    return localDisplayMetrics.widthPixels;
  }
  
  public static String c(String paramString1, String paramString2)
  {
    Object localObject = i(paramString1);
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
  
  public static String c(byte[] paramArrayOfByte)
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
  
  public static void c(Context paramContext)
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
            APAppDataInterface.singleton().d(true);
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
  
  public static boolean c()
  {
    return c6.s0().H() >= 2;
  }
  
  public static boolean c(Context paramContext, String paramString)
  {
    return b(paramContext, paramString);
  }
  
  public static boolean c(Throwable paramThrowable)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("isTimeError https exception");
    ((StringBuilder)localObject).append(paramThrowable.toString());
    APLog.w("APBaseHttpReq", ((StringBuilder)localObject).toString());
    localObject = Proxy.getDefaultHost();
    return (APAppDataInterface.singleton().s() == 1000) && (!TextUtils.isEmpty((CharSequence)localObject)) && (paramThrowable.toString().contains("Trust anchor for certification path not found"));
  }
  
  public static Signature[] c(String paramString)
  {
    Object localObject2 = new File(paramString);
    boolean bool = ((File)localObject2).exists();
    Signature[] arrayOfSignature = null;
    Object localObject1 = null;
    if (!bool) {
      return null;
    }
    paramString = arrayOfSignature;
    try
    {
      localObject2 = new JarFile((File)localObject2);
      paramString = arrayOfSignature;
      JarEntry localJarEntry = ((JarFile)localObject2).getJarEntry("AndroidManifest.xml");
      if (localJarEntry == null) {
        return null;
      }
      paramString = arrayOfSignature;
      localObject2 = a((JarFile)localObject2, localJarEntry, new byte[8192]);
      paramString = localObject1;
      if (localObject2 != null)
      {
        paramString = arrayOfSignature;
        arrayOfSignature = new Signature[localObject2.length];
        paramString = arrayOfSignature;
        int i3 = localObject2.length;
        int i1 = 0;
        int i2 = 0;
        for (;;)
        {
          paramString = arrayOfSignature;
          if (i1 >= i3) {
            break;
          }
          paramString = arrayOfSignature;
          arrayOfSignature[i2] = new Signature(b(localObject2[i1].getEncoded()));
          i2 += 1;
          i1 += 1;
        }
      }
      return paramString;
    }
    catch (Exception localException) {}
    return paramString;
  }
  
  public static native void checkParam(Object paramObject);
  
  public static String d()
  {
    Object localObject = "";
    try
    {
      Context localContext = a.r().a();
      String str = localContext.getPackageManager().getPackageInfo(localContext.getApplicationContext().getPackageName(), 0).versionName;
      if (str != null) {
        try
        {
          int i1 = str.length();
          if (i1 <= 0) {
            return "";
          }
          return str;
        }
        catch (Exception localException1)
        {
          localObject = str;
        }
      } else {
        return "";
      }
    }
    catch (Exception localException2)
    {
      localException2.printStackTrace();
    }
    return localObject;
  }
  
  public static String d(Context paramContext)
  {
    Object localObject1 = new HashMap();
    Object localObject2 = Boolean.valueOf(false);
    ((HashMap)localObject1).put("android.permission.ACCESS_NETWORK_STATE", localObject2);
    ((HashMap)localObject1).put("android.permission.ACCESS_WIFI_STATE", localObject2);
    try
    {
      localObject2 = paramContext.getApplicationContext().getPackageManager();
      paramContext = ((PackageManager)localObject2).getPackageInfo(((PackageManager)localObject2).getPackageInfo(paramContext.getApplicationContext().getPackageName(), 0).packageName, 4096).requestedPermissions;
      localObject2 = ((HashMap)localObject1).entrySet().iterator();
      label146:
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (Map.Entry)((Iterator)localObject2).next();
        String str = (String)((Map.Entry)localObject3).getKey();
        int i1 = 0;
        for (;;)
        {
          if (i1 >= paramContext.length) {
            break label146;
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
      Object localObject3;
      label148:
      break label148;
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
  
  public static String d(String paramString)
  {
    if (n < 0) {}
    try
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(m);
      localStringBuilder.append(".openapi.IWXAPI");
      Class.forName(localStringBuilder.toString());
      n = 1;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder;
      label45:
      break label45;
    }
    n = 0;
    if (n > 0)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(m);
      localStringBuilder.append(".");
      localStringBuilder.append(paramString);
      return localStringBuilder.toString();
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(l);
    localStringBuilder.append(".");
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  public static String d(Throwable paramThrowable)
  {
    StringWriter localStringWriter = new StringWriter();
    paramThrowable.printStackTrace(new PrintWriter(localStringWriter, true));
    return localStringWriter.getBuffer().toString();
  }
  
  public static void d(Context paramContext, String paramString)
  {
    try
    {
      new d6().a(paramContext, "TencentUnipay", "DeviceInfo", paramString);
      return;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public static void d(String paramString1, String paramString2)
  {
    if (k())
    {
      f6 localf6 = new f6();
      localf6.c(localf6.b(paramString1, paramString2), "Midas.xml");
      return;
    }
    APLog.i("saveInfoSDCard", "no sdcard");
  }
  
  public static String e(Context paramContext)
  {
    Object localObject1 = new HashMap();
    Object localObject3 = new ActivityInfo();
    ((ActivityInfo)localObject3).name = "com.wsj.pay.proxyactivity.APWSJPayProxyActivity";
    Object localObject2 = Boolean.valueOf(false);
    ((ActivityInfo)localObject3).exported = false;
    ((HashMap)localObject1).put(localObject3, localObject2);
    localObject3 = new ActivityInfo();
    ((ActivityInfo)localObject3).name = "com.wsj.pay.wx.APWSJWXPayActivity";
    ((ActivityInfo)localObject3).exported = true;
    ((HashMap)localObject1).put(localObject3, localObject2);
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
  
  public static void e(Context paramContext, String paramString)
  {
    try
    {
      new d6().a(paramContext, "TencentUnipay", "PhoneNumLocal", paramString);
      return;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public static boolean e(String paramString)
  {
    if (a.r().e())
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
  
  /* Error */
  public static String[] e()
  {
    // Byte code:
    //   0: iconst_2
    //   1: anewarray 168	java/lang/String
    //   4: astore_3
    //   5: aload_3
    //   6: iconst_0
    //   7: ldc 17
    //   9: aastore
    //   10: aload_3
    //   11: iconst_1
    //   12: ldc 17
    //   14: aastore
    //   15: new 1238	java/io/FileReader
    //   18: dup
    //   19: ldc_w 1240
    //   22: invokespecial 1241	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   25: astore_1
    //   26: new 1243	java/io/BufferedReader
    //   29: dup
    //   30: aload_1
    //   31: sipush 8192
    //   34: invokespecial 1246	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   37: astore_2
    //   38: aload_2
    //   39: invokevirtual 1249	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   42: astore 4
    //   44: aload 4
    //   46: ifnull +74 -> 120
    //   49: aload 4
    //   51: ldc_w 1251
    //   54: invokevirtual 1031	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   57: astore 4
    //   59: iconst_2
    //   60: istore_0
    //   61: iload_0
    //   62: aload 4
    //   64: arraylength
    //   65: if_icmpge +89 -> 154
    //   68: new 105	java/lang/StringBuilder
    //   71: dup
    //   72: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   75: astore 5
    //   77: aload 5
    //   79: aload_3
    //   80: iconst_0
    //   81: aaload
    //   82: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: pop
    //   86: aload 5
    //   88: aload 4
    //   90: iload_0
    //   91: aaload
    //   92: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: pop
    //   96: aload 5
    //   98: ldc_w 1253
    //   101: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: pop
    //   105: aload_3
    //   106: iconst_0
    //   107: aload 5
    //   109: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   112: aastore
    //   113: iload_0
    //   114: iconst_1
    //   115: iadd
    //   116: istore_0
    //   117: goto -56 -> 61
    //   120: new 105	java/lang/StringBuilder
    //   123: dup
    //   124: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   127: astore 4
    //   129: aload 4
    //   131: aload_3
    //   132: iconst_0
    //   133: aaload
    //   134: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: pop
    //   138: aload 4
    //   140: ldc 17
    //   142: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: pop
    //   146: aload_3
    //   147: iconst_0
    //   148: aload 4
    //   150: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   153: aastore
    //   154: aload_2
    //   155: invokevirtual 1249	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   158: astore 4
    //   160: aload 4
    //   162: ifnull +101 -> 263
    //   165: aload 4
    //   167: ldc_w 1251
    //   170: invokevirtual 1031	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   173: astore 4
    //   175: aload 4
    //   177: ifnull +49 -> 226
    //   180: aload 4
    //   182: arraylength
    //   183: iconst_3
    //   184: if_icmplt +42 -> 226
    //   187: new 105	java/lang/StringBuilder
    //   190: dup
    //   191: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   194: astore 5
    //   196: aload 5
    //   198: aload_3
    //   199: iconst_1
    //   200: aaload
    //   201: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: pop
    //   205: aload 5
    //   207: aload 4
    //   209: iconst_2
    //   210: aaload
    //   211: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: pop
    //   215: aload_3
    //   216: iconst_1
    //   217: aload 5
    //   219: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   222: aastore
    //   223: goto +74 -> 297
    //   226: new 105	java/lang/StringBuilder
    //   229: dup
    //   230: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   233: astore 4
    //   235: aload 4
    //   237: aload_3
    //   238: iconst_1
    //   239: aaload
    //   240: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   243: pop
    //   244: aload 4
    //   246: ldc 17
    //   248: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   251: pop
    //   252: aload_3
    //   253: iconst_1
    //   254: aload 4
    //   256: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   259: aastore
    //   260: goto +37 -> 297
    //   263: new 105	java/lang/StringBuilder
    //   266: dup
    //   267: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   270: astore 4
    //   272: aload 4
    //   274: aload_3
    //   275: iconst_1
    //   276: aaload
    //   277: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   280: pop
    //   281: aload 4
    //   283: ldc 17
    //   285: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   288: pop
    //   289: aload_3
    //   290: iconst_1
    //   291: aload 4
    //   293: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   296: aastore
    //   297: aload_2
    //   298: invokevirtual 1254	java/io/BufferedReader:close	()V
    //   301: aload_1
    //   302: invokevirtual 1255	java/io/FileReader:close	()V
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
    //   333: invokevirtual 1254	java/io/BufferedReader:close	()V
    //   336: aload_1
    //   337: ifnull +7 -> 344
    //   340: aload_1
    //   341: invokevirtual 1255	java/io/FileReader:close	()V
    //   344: aload_3
    //   345: athrow
    //   346: aconst_null
    //   347: astore_2
    //   348: aload_2
    //   349: astore_1
    //   350: aload_2
    //   351: ifnull +7 -> 358
    //   354: aload_2
    //   355: invokevirtual 1254	java/io/BufferedReader:close	()V
    //   358: aload_1
    //   359: ifnull +6 -> 365
    //   362: goto -61 -> 301
    //   365: getstatic 1259	java/lang/System:out	Ljava/io/PrintStream;
    //   368: astore_1
    //   369: new 105	java/lang/StringBuilder
    //   372: dup
    //   373: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   376: astore_2
    //   377: aload_2
    //   378: ldc_w 1261
    //   381: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   384: pop
    //   385: aload_2
    //   386: aload_3
    //   387: iconst_0
    //   388: aaload
    //   389: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   392: pop
    //   393: aload_2
    //   394: ldc_w 1263
    //   397: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   400: pop
    //   401: aload_2
    //   402: aload_3
    //   403: iconst_1
    //   404: aaload
    //   405: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   408: pop
    //   409: aload_1
    //   410: aload_2
    //   411: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   414: invokevirtual 1268	java/io/PrintStream:println	(Ljava/lang/String;)V
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
  
  public static String f()
  {
    if (!TextUtils.isEmpty(e)) {
      return e;
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
      e = localInetAddress.getHostAddress();
      Object localObject = e;
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
    if (b()) {}
    return "";
  }
  
  public static boolean f(String paramString)
  {
    return Pattern.compile("^\\+?[1-9][0-9]{0,6}$").matcher(paramString).matches();
  }
  
  public static String g()
  {
    if (b()) {}
    return "";
  }
  
  public static String g(Context paramContext)
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
  
  public static boolean g(String paramString)
  {
    if (paramString.length() == 11) {
      return paramString.startsWith("1");
    }
    if (paramString.length() > 11) {
      return l(paramString).substring(0, 11).endsWith("1");
    }
    return false;
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
    Object localObject = r(a.r().a());
    if ((localObject != null) && (localObject.length != 0)) {
      return a(localObject[0]);
    }
    return "";
  }
  
  public static int h(String paramString)
  {
    try
    {
      int i1 = new BigDecimal(k.parse(paramString).toString()).multiply(new BigDecimal(10)).intValue();
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
    return "";
  }
  
  public static String h(Context paramContext)
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
    finally
    {
      paramContext.printStackTrace();
      APLog.w("getAppVersion", paramContext.toString());
    }
  }
  
  public static Bitmap i(Context paramContext)
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
  
  public static String i()
  {
    return Build.VERSION.RELEASE;
  }
  
  /* Error */
  public static HashMap<String, String> i(String paramString)
  {
    // Byte code:
    //   0: new 657	java/util/HashMap
    //   3: dup
    //   4: invokespecial 936	java/util/HashMap:<init>	()V
    //   7: astore 6
    //   9: aload_0
    //   10: invokestatic 420	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   13: ifne +83 -> 96
    //   16: aload_0
    //   17: ldc_w 1380
    //   20: invokevirtual 1031	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   23: astore 7
    //   25: ldc 17
    //   27: astore_0
    //   28: aload_0
    //   29: astore_3
    //   30: iconst_0
    //   31: istore_1
    //   32: aload 7
    //   34: arraylength
    //   35: istore_2
    //   36: iload_1
    //   37: iload_2
    //   38: if_icmpge +81 -> 119
    //   41: aload 7
    //   43: iload_1
    //   44: aaload
    //   45: ldc_w 1382
    //   48: invokevirtual 1031	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   51: iconst_0
    //   52: aaload
    //   53: astore 4
    //   55: aload 4
    //   57: astore_0
    //   58: aload 7
    //   60: iload_1
    //   61: aaload
    //   62: ldc_w 1382
    //   65: invokevirtual 1031	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   68: iconst_1
    //   69: aaload
    //   70: astore 5
    //   72: aload 5
    //   74: astore_3
    //   75: aload 4
    //   77: astore_0
    //   78: aload_0
    //   79: invokestatic 420	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   82: ifne +45 -> 127
    //   85: aload 6
    //   87: aload_0
    //   88: aload_3
    //   89: invokevirtual 953	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   92: pop
    //   93: goto +34 -> 127
    //   96: ldc_w 1384
    //   99: ldc_w 1386
    //   102: invokestatic 650	com/tencent/midas/comm/APLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   105: aload 6
    //   107: areturn
    //   108: astore_0
    //   109: ldc_w 1384
    //   112: aload_0
    //   113: invokevirtual 164	java/lang/Exception:toString	()Ljava/lang/String;
    //   116: invokestatic 654	com/tencent/midas/comm/APLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   119: aload 6
    //   121: areturn
    //   122: astore 4
    //   124: goto -46 -> 78
    //   127: iload_1
    //   128: iconst_1
    //   129: iadd
    //   130: istore_1
    //   131: goto -99 -> 32
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	134	0	paramString	String
    //   31	100	1	i1	int
    //   35	4	2	i2	int
    //   29	60	3	localObject	Object
    //   53	23	4	str1	String
    //   122	1	4	localException	Exception
    //   70	3	5	str2	String
    //   7	113	6	localHashMap	HashMap
    //   23	36	7	arrayOfString	String[]
    // Exception table:
    //   from	to	target	type
    //   9	25	108	java/lang/Exception
    //   32	36	108	java/lang/Exception
    //   78	93	108	java/lang/Exception
    //   96	105	108	java/lang/Exception
    //   41	55	122	java/lang/Exception
    //   58	72	122	java/lang/Exception
  }
  
  public static String j()
  {
    try
    {
      String str = UUID.randomUUID().toString();
      return str;
    }
    catch (Exception localException)
    {
      label9:
      break label9;
    }
    return "";
  }
  
  public static String j(Context paramContext)
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
  
  public static String j(String paramString)
  {
    try
    {
      String str = k.parse(paramString).toString();
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
  
  public static String k(Context paramContext)
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
  
  public static String k(String paramString)
  {
    if (!TextUtils.isEmpty(f)) {
      return f;
    }
    f = new f6().a("Midas.xml", paramString);
    return f;
  }
  
  public static boolean k()
  {
    return Environment.getExternalStorageState().equals("mounted");
  }
  
  public static String l(Context paramContext)
  {
    if (b()) {}
    return "";
  }
  
  public static String l(String paramString)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(paramString);
    return localStringBuffer.reverse().toString();
  }
  
  public static boolean l()
  {
    return a.r().a().getPackageName().equals("com.tencent.unipay");
  }
  
  public static Bundle m(String paramString)
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
    finally
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public static String m(Context paramContext)
  {
    try
    {
      paramContext = new d6().a(paramContext, "TencentUnipay", "DeviceInfo");
      return paramContext;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return null;
  }
  
  public static boolean m()
  {
    long l1 = System.currentTimeMillis();
    if (l1 - b < 1000L) {
      return true;
    }
    b = l1;
    return false;
  }
  
  public static String n(Context paramContext)
  {
    if (c()) {
      return "";
    }
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
          break label159;
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
            break label164;
          }
        }
        else
        {
          localStringBuilder.append(paramContext.charAt(i2));
          break label164;
        }
      }
      paramContext = localStringBuilder.toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("getMobileMccMnc() = ");
      localStringBuilder.append(paramContext);
      APLog.d("APTools", localStringBuilder.toString());
      return paramContext;
      label159:
      int i2 = 0;
      continue;
      label164:
      i2 += 1;
    }
  }
  
  public static HashMap<String, String> n(String paramString)
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
    label156:
    label164:
    for (;;)
    {
      try
      {
        if (!TextUtils.isEmpty(paramString))
        {
          arrayOfString = paramString.split("\\&");
          paramString = "";
          localObject = paramString;
          i1 = 0;
          int i2 = arrayOfString.length;
          if (i1 >= i2) {
            break label156;
          }
        }
      }
      catch (Exception paramString)
      {
        String[] arrayOfString;
        String str1;
        String str2;
        APLog.w("url2Map", paramString.toString());
      }
      try
      {
        str1 = arrayOfString[i1].split("\\=")[0];
        paramString = str1;
        str2 = arrayOfString[i1].split("\\=")[1];
        localObject = str2;
        paramString = str1;
      }
      catch (Exception localException)
      {
        continue;
        i1 += 1;
      }
      if (!TextUtils.isEmpty(paramString))
      {
        localHashMap.put(paramString, localObject);
        break label164;
        APLog.i("url2Map", "url后参数为空");
        return localHashMap;
        return localHashMap;
      }
    }
  }
  
  public static boolean n()
  {
    String str = c6.s0().W();
    if (TextUtils.isEmpty(str)) {
      return false;
    }
    return str.startsWith("66666");
  }
  
  public static String o()
  {
    return k("MidasDeviceId");
  }
  
  public static String o(Context paramContext)
  {
    boolean bool = c();
    String str1 = "";
    if (bool) {
      return "";
    }
    if (paramContext == null) {
      return "";
    }
    String str2 = n(paramContext);
    bool = TextUtils.isEmpty(str2);
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
  
  public static String o(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    if (paramString.startsWith("http://")) {
      return paramString.substring(7);
    }
    String str = paramString;
    if (paramString.startsWith("https://")) {
      str = paramString.substring(8);
    }
    return str;
  }
  
  public static int p(String paramString)
  {
    try
    {
      int i1 = new BigDecimal(k.parse(paramString).toString()).multiply(new BigDecimal(100)).intValue();
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
  
  public static String p(Context paramContext)
  {
    if (b()) {
      return "";
    }
    if ((!i) && (TextUtils.isEmpty(g)))
    {
      if (paramContext == null) {
        return g;
      }
      g = q(paramContext);
      if (!TextUtils.isEmpty(g)) {
        return g;
      }
      TelephonyManager localTelephonyManager = (TelephonyManager)paramContext.getSystemService("phone");
      try
      {
        i = true;
        g = localTelephonyManager.getLine1Number();
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getPhoneNum() = ");
      localStringBuilder.append(g);
      APLog.d("APTools", localStringBuilder.toString());
      if ((!TextUtils.isEmpty(g)) && (g.length() > 11))
      {
        g = l(l(g).substring(0, 11));
        if (!g(g)) {
          g = "";
        } else {
          e(paramContext, g);
        }
      }
      else
      {
        g = "";
      }
      return g;
    }
    return g;
  }
  
  public static String q(Context paramContext)
  {
    try
    {
      paramContext = new d6().a(paramContext, "TencentUnipay", "PhoneNumLocal");
      return paramContext;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return null;
  }
  
  public static BigDecimal q(String paramString)
  {
    try
    {
      paramString = new BigDecimal(k.parse(paramString).toString()).multiply(new BigDecimal(10));
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
  
  public static Signature[] r(Context paramContext)
  {
    if (!l())
    {
      paramContext = g(paramContext);
      if (!TextUtils.isEmpty(paramContext)) {
        return c(paramContext);
      }
      return null;
    }
    return s(paramContext);
  }
  
  public static Signature[] s(Context paramContext)
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
  
  public static void setKey(String paramString)
  {
    c = paramString;
  }
  
  /* Error */
  public static String t(Context paramContext)
  {
    // Byte code:
    //   0: lconst_0
    //   1: lstore_3
    //   2: new 1238	java/io/FileReader
    //   5: dup
    //   6: ldc_w 1552
    //   9: invokespecial 1241	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   12: astore 9
    //   14: new 1243	java/io/BufferedReader
    //   17: dup
    //   18: aload 9
    //   20: sipush 8192
    //   23: invokespecial 1246	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   26: astore 10
    //   28: aload 10
    //   30: invokevirtual 1249	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   33: astore 11
    //   35: lload_3
    //   36: lstore 7
    //   38: aload 11
    //   40: ifnull +104 -> 144
    //   43: aload 11
    //   45: ldc_w 1251
    //   48: invokevirtual 1031	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
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
    //   70: new 105	java/lang/StringBuilder
    //   73: dup
    //   74: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   77: astore 14
    //   79: aload 14
    //   81: aload 13
    //   83: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: pop
    //   87: aload 14
    //   89: ldc_w 1554
    //   92: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: pop
    //   96: aload 11
    //   98: aload 14
    //   100: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   103: invokestatic 1331	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
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
    //   128: invokestatic 1495	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   131: invokevirtual 1557	java/lang/Integer:longValue	()J
    //   134: lstore 5
    //   136: lload 5
    //   138: ldc2_w 1558
    //   141: lmul
    //   142: lstore 7
    //   144: lload 7
    //   146: lstore 5
    //   148: aload 10
    //   150: invokevirtual 1254	java/io/BufferedReader:close	()V
    //   153: lload 7
    //   155: lstore_3
    //   156: lload_3
    //   157: lstore 5
    //   159: aload 9
    //   161: invokevirtual 1255	java/io/FileReader:close	()V
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
    //   219: invokevirtual 1254	java/io/BufferedReader:close	()V
    //   222: aload 10
    //   224: ifnull +8 -> 232
    //   227: aload 10
    //   229: invokevirtual 1255	java/io/FileReader:close	()V
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
    //   252: invokevirtual 1254	java/io/BufferedReader:close	()V
    //   255: lload_3
    //   256: lstore 5
    //   258: aload 9
    //   260: ifnull +6 -> 266
    //   263: goto -107 -> 156
    //   266: aload_0
    //   267: lload 5
    //   269: invokestatic 1425	android/text/format/Formatter:formatFileSize	(Landroid/content/Context;J)Ljava/lang/String;
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
  
  public static boolean u(Context paramContext)
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
  
  public static String v(Context paramContext)
  {
    paramContext = a(paramContext, "TencentUnipay", "succHFNum");
    if (!TextUtils.isEmpty(paramContext)) {
      return new String(e.a(paramContext));
    }
    return null;
  }
  
  public static void w(Context paramContext)
  {
    new Thread(new a(paramContext)).start();
  }
  
  public static final class a
    implements Runnable
  {
    public a(Context paramContext) {}
    
    public void run()
    {
      APTools.f();
      APTools.l(this.a);
      APTools.f(this.a);
      APTools.o();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     com.pay.tool.APTools
 * JD-Core Version:    0.7.0.1
 */