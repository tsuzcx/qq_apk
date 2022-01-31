package com.tencent.liteav.basic.datareport;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXCCommonUtil;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.MessageDigest;
import java.util.UUID;

public class TXCDRApi
{
  private static final char[] DIGITS_LOWER;
  static final int NETWORK_TYPE_2G = 4;
  static final int NETWORK_TYPE_3G = 3;
  static final int NETWORK_TYPE_4G = 2;
  static final int NETWORK_TYPE_UNKNOWN = 255;
  static final int NETWORK_TYPE_WIFI = 1;
  static boolean initRpt;
  private static String mAppName;
  private static String mDevId;
  private static String mDevType = "";
  private static String mDevUUID;
  private static String mMacAddr;
  private static String mNetType = "";
  private static String mSysVersion;
  
  static
  {
    mDevId = "";
    mDevUUID = "";
    mAppName = "";
    mSysVersion = "";
    mMacAddr = "";
    DIGITS_LOWER = new char[] { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
    initRpt = false;
    com.tencent.liteav.basic.util.a.d();
    nativeInitDataReport();
  }
  
  public static void InitEvent(Context paramContext, String paramString, int paramInt1, int paramInt2, TXCDRExtInfo paramTXCDRExtInfo)
  {
    setCommonInfo(paramContext);
    if (paramString == null) {
      return;
    }
    nativeInitEventInternal(paramString, paramInt1, paramInt2, paramTXCDRExtInfo);
  }
  
  private static String byteArrayToHexString(byte[] paramArrayOfByte)
  {
    char[] arrayOfChar = new char[paramArrayOfByte.length << 1];
    int j = 0;
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      int k = j + 1;
      arrayOfChar[j] = DIGITS_LOWER[((paramArrayOfByte[i] & 0xF0) >>> 4)];
      j = k + 1;
      arrayOfChar[k] = DIGITS_LOWER[(paramArrayOfByte[i] & 0xF)];
      i += 1;
    }
    return new String(arrayOfChar);
  }
  
  public static String doRead(Context paramContext)
  {
    try
    {
      paramContext = (TelephonyManager)paramContext.getSystemService("phone");
      if (paramContext == null) {
        break label61;
      }
      paramContext = paramContext.getDeviceId();
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        Object localObject = "";
        continue;
        label61:
        paramContext = "";
      }
    }
    localObject = paramContext;
    if (paramContext == null) {
      localObject = "";
    }
    TXCLog.d("rtmpsdk", "deviceinfo:" + (String)localObject);
    return string2Md5((String)localObject);
  }
  
  public static String getApplicationNameByPackageName(Context paramContext, String paramString)
  {
    paramContext = paramContext.getPackageManager();
    try
    {
      paramContext = paramContext.getApplicationLabel(paramContext.getApplicationInfo(paramString, 128)).toString();
      return paramContext;
    }
    catch (Exception paramContext) {}
    return "";
  }
  
  public static String getDevUUID(Context paramContext, String paramString)
  {
    SharedPreferences localSharedPreferences = paramContext.getSharedPreferences("com.tencent.liteav.dev_uuid", 0);
    String str = localSharedPreferences.getString("com.tencent.liteav.key_dev_uuid", "");
    Object localObject2 = "";
    localObject1 = localObject2;
    try
    {
      Object localObject3 = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/txrtmp/spuid");
      paramContext = (Context)localObject2;
      localObject1 = localObject2;
      if (((File)localObject3).exists())
      {
        localObject1 = localObject2;
        localObject3 = new FileInputStream((File)localObject3);
        localObject1 = localObject2;
        int i = ((FileInputStream)localObject3).available();
        paramContext = (Context)localObject2;
        if (i > 0)
        {
          localObject1 = localObject2;
          paramContext = new byte[i];
          localObject1 = localObject2;
          ((FileInputStream)localObject3).read(paramContext);
          localObject1 = localObject2;
          paramContext = new String(paramContext, "UTF-8");
        }
        localObject1 = paramContext;
        ((FileInputStream)localObject3).close();
      }
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        paramContext = (Context)localObject1;
      }
    }
    localObject2 = "";
    if (!str.isEmpty()) {
      localObject2 = str;
    }
    if (!paramContext.isEmpty()) {
      localObject2 = paramContext;
    }
    localObject1 = localObject2;
    if (((String)localObject2).isEmpty()) {
      localObject1 = string2Md5(paramString + UUID.randomUUID().toString());
    }
    paramString = paramContext;
    if (paramContext.isEmpty()) {}
    try
    {
      paramContext = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/txrtmp");
      if (!paramContext.exists()) {
        paramContext.mkdir();
      }
      paramContext = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/txrtmp/spuid");
      if (!paramContext.exists()) {
        paramContext.createNewFile();
      }
      paramContext = new FileOutputStream(paramContext);
      paramContext.write(((String)localObject1).getBytes());
      paramContext.close();
      paramString = (String)localObject1;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        paramString = (String)localObject1;
      }
    }
    if (!str.equals(paramString))
    {
      paramContext = localSharedPreferences.edit();
      paramContext.putString("key_user_id", (String)localObject1);
      paramContext.commit();
    }
    return localObject1;
  }
  
  public static int getNetworkType(Context paramContext)
  {
    if (paramContext == null) {
      return 255;
    }
    Object localObject = (ConnectivityManager)paramContext.getSystemService("connectivity");
    paramContext = (TelephonyManager)paramContext.getSystemService("phone");
    localObject = ((ConnectivityManager)localObject).getActiveNetworkInfo();
    if (localObject == null) {
      return 255;
    }
    if (((NetworkInfo)localObject).getType() == 1) {
      return 1;
    }
    if (((NetworkInfo)localObject).getType() == 0)
    {
      switch (paramContext.getNetworkType())
      {
      default: 
        return 2;
      case 1: 
      case 2: 
      case 4: 
      case 7: 
      case 11: 
        return 4;
      case 3: 
      case 5: 
      case 6: 
      case 8: 
      case 9: 
      case 10: 
      case 12: 
      case 14: 
      case 15: 
        return 3;
      }
      return 2;
    }
    return 255;
  }
  
  public static String getOrigAndroidID(Context paramContext)
  {
    String str = "";
    try
    {
      paramContext = Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
      return string2Md5(paramContext);
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        paramContext = str;
      }
    }
  }
  
  public static String getOrigMacAddr(Context paramContext)
  {
    try
    {
      paramContext = (WifiManager)paramContext.getSystemService("wifi");
      if (paramContext == null) {
        break label62;
      }
      paramContext = paramContext.getConnectionInfo();
    }
    catch (Exception paramContext)
    {
      try
      {
        label29:
        for (paramContext = string2Md5(((String)localObject).replaceAll(":", "").toUpperCase());; paramContext = "")
        {
          localObject = paramContext;
          if (paramContext == null) {
            localObject = "";
          }
          return localObject;
          label62:
          paramContext = null;
          break;
          localObject = null;
          break label29;
          paramContext = paramContext;
        }
      }
      catch (Exception paramContext)
      {
        for (;;)
        {
          Object localObject;
          paramContext = (Context)localObject;
        }
      }
    }
    if (paramContext != null)
    {
      localObject = paramContext.getMacAddress();
      paramContext = (Context)localObject;
      if (localObject == null) {}
    }
  }
  
  private static String getPackageName(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).packageName;
      return paramContext;
    }
    catch (Exception paramContext) {}
    return "";
  }
  
  public static String getSimulateIDFA(Context paramContext)
  {
    return doRead(paramContext) + ";" + getOrigMacAddr(paramContext) + ";" + getOrigAndroidID(paramContext);
  }
  
  public static int getStatusReportInterval()
  {
    return nativeGetStatusReportInterval();
  }
  
  public static void initCrashReport(Context paramContext)
  {
    try
    {
      try
      {
        if ((!initRpt) && (paramContext != null))
        {
          String str = TXCCommonUtil.getSDKVersionStr();
          if (str != null)
          {
            paramContext = paramContext.getSharedPreferences("BuglySdkInfos", 0).edit();
            paramContext.putString("8e50744bf0", str);
            paramContext.commit();
            initRpt = true;
          }
        }
        return;
      }
      finally {}
      return;
    }
    catch (Exception paramContext) {}
  }
  
  public static native int nativeGetStatusReportInterval();
  
  private static native void nativeInitDataReport();
  
  private static native void nativeInitEventInternal(String paramString, int paramInt1, int paramInt2, TXCDRExtInfo paramTXCDRExtInfo);
  
  private static native void nativeReportDAUInterval(int paramInt1, int paramInt2, String paramString);
  
  public static native void nativeReportEvent(String paramString, int paramInt);
  
  public static native void nativeReportEvent40003(String paramString1, int paramInt, String paramString2, String paramString3);
  
  public static native void nativeSetCommonValue(String paramString1, String paramString2);
  
  private static native void nativeSetEventValueInterval(String paramString1, int paramInt, String paramString2, String paramString3);
  
  private static native void nativeUninitDataReport();
  
  public static void reportEvent40003(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    nativeReportEvent40003(paramString1, paramInt, paramString2, paramString3);
  }
  
  public static void setCommonInfo(Context paramContext)
  {
    mDevType = Build.MODEL;
    mNetType = Integer.toString(getNetworkType(paramContext));
    if (mDevId.isEmpty()) {
      mDevId = getSimulateIDFA(paramContext);
    }
    if (mDevUUID.isEmpty()) {
      mDevUUID = getDevUUID(paramContext, mDevId);
    }
    String str = getPackageName(paramContext);
    mAppName = getApplicationNameByPackageName(paramContext, str) + ":" + str;
    mSysVersion = String.valueOf(Build.VERSION.SDK_INT);
    mMacAddr = getOrigMacAddr(paramContext);
    txSetCommonInfo();
  }
  
  public static String string2Md5(String paramString)
  {
    String str = "";
    if (paramString == null) {}
    for (;;)
    {
      return str;
      try
      {
        paramString = byteArrayToHexString(MessageDigest.getInstance("MD5").digest(paramString.getBytes("UTF-8")));
        str = paramString;
        if (paramString != null) {
          continue;
        }
        return "";
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          paramString = str;
        }
      }
    }
  }
  
  public static String txCreateToken()
  {
    return UUID.randomUUID().toString();
  }
  
  public static void txReportDAU(Context paramContext, int paramInt)
  {
    if (paramContext != null) {
      setCommonInfo(paramContext);
    }
    nativeReportDAUInterval(paramInt, 0, "");
  }
  
  public static void txReportDAU(Context paramContext, int paramInt1, int paramInt2, String paramString)
  {
    if (paramContext != null) {
      setCommonInfo(paramContext);
    }
    nativeReportDAUInterval(paramInt1, paramInt2, paramString);
  }
  
  public static void txSetAppVersion(String paramString)
  {
    if (paramString != null) {
      nativeSetCommonValue(a.k, paramString);
    }
  }
  
  public static void txSetCommonInfo()
  {
    if (mDevType != null) {
      nativeSetCommonValue(a.f, mDevType);
    }
    if (mNetType != null) {
      nativeSetCommonValue(a.g, mNetType);
    }
    if (mDevId != null) {
      nativeSetCommonValue(a.h, mDevId);
    }
    if (mDevUUID != null) {
      nativeSetCommonValue(a.i, mDevUUID);
    }
    if (mAppName != null) {
      nativeSetCommonValue(a.j, mAppName);
    }
    if (mSysVersion != null) {
      nativeSetCommonValue(a.l, mSysVersion);
    }
    if (mMacAddr != null) {
      nativeSetCommonValue(a.m, mMacAddr);
    }
  }
  
  public static void txSetEventIntValue(String paramString1, int paramInt, String paramString2, long paramLong)
  {
    nativeSetEventValueInterval(paramString1, paramInt, paramString2, String.valueOf(paramLong));
  }
  
  public static void txSetEventValue(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    nativeSetEventValueInterval(paramString1, paramInt, paramString2, paramString3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.liteav.basic.datareport.TXCDRApi
 * JD-Core Version:    0.7.0.1
 */