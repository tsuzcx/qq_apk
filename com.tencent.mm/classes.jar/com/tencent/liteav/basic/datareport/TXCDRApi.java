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
import com.tencent.liteav.basic.util.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
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
  private static String mDevType;
  private static String mDevUUID;
  private static String mMacAddr;
  private static String mNetType;
  private static String mSysVersion;
  
  static
  {
    AppMethodBeat.i(66308);
    mDevType = "";
    mNetType = "";
    mDevId = "";
    mDevUUID = "";
    mAppName = "";
    mSysVersion = "";
    mMacAddr = "";
    DIGITS_LOWER = new char[] { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
    initRpt = false;
    b.f();
    nativeInitDataReport();
    AppMethodBeat.o(66308);
  }
  
  public static void InitEvent(Context paramContext, String paramString, int paramInt1, int paramInt2, TXCDRExtInfo paramTXCDRExtInfo)
  {
    AppMethodBeat.i(66286);
    setCommonInfo(paramContext);
    if (paramString == null)
    {
      AppMethodBeat.o(66286);
      return;
    }
    nativeInitEventInternal(paramString, paramInt1, paramInt2, paramTXCDRExtInfo);
    AppMethodBeat.o(66286);
  }
  
  private static String byteArrayToHexString(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(66297);
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
    paramArrayOfByte = new String(arrayOfChar);
    AppMethodBeat.o(66297);
    return paramArrayOfByte;
  }
  
  public static String doRead(Context paramContext)
  {
    AppMethodBeat.i(66299);
    try
    {
      paramContext = (TelephonyManager)paramContext.getSystemService("phone");
      if (paramContext == null) {
        break label66;
      }
      paramContext = paramContext.getDeviceId();
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        Object localObject = "";
        continue;
        paramContext = "";
      }
    }
    localObject = paramContext;
    if (paramContext == null) {
      localObject = "";
    }
    TXCLog.d("rtmpsdk", "deviceinfo:".concat(String.valueOf(localObject)));
    paramContext = string2Md5((String)localObject);
    AppMethodBeat.o(66299);
    return paramContext;
  }
  
  public static String getApplicationNameByPackageName(Context paramContext, String paramString)
  {
    AppMethodBeat.i(66306);
    paramContext = paramContext.getPackageManager();
    try
    {
      paramContext = paramContext.getApplicationLabel(paramContext.getApplicationInfo(paramString, 128)).toString();
      AppMethodBeat.o(66306);
      return paramContext;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        paramContext = "";
      }
    }
  }
  
  public static String getDevUUID(Context paramContext, String paramString)
  {
    AppMethodBeat.i(66303);
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
    AppMethodBeat.o(66303);
    return localObject1;
  }
  
  public static int getNetworkType(Context paramContext)
  {
    AppMethodBeat.i(66304);
    if (paramContext == null)
    {
      AppMethodBeat.o(66304);
      return 255;
    }
    Object localObject = (ConnectivityManager)paramContext.getSystemService("connectivity");
    paramContext = (TelephonyManager)paramContext.getSystemService("phone");
    localObject = ((ConnectivityManager)localObject).getActiveNetworkInfo();
    if (localObject == null)
    {
      AppMethodBeat.o(66304);
      return 255;
    }
    if (((NetworkInfo)localObject).getType() == 1)
    {
      AppMethodBeat.o(66304);
      return 1;
    }
    if (((NetworkInfo)localObject).getType() == 0)
    {
      switch (paramContext.getNetworkType())
      {
      default: 
        AppMethodBeat.o(66304);
        return 2;
      case 1: 
      case 2: 
      case 4: 
      case 7: 
      case 11: 
        AppMethodBeat.o(66304);
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
        AppMethodBeat.o(66304);
        return 3;
      }
      AppMethodBeat.o(66304);
      return 2;
    }
    AppMethodBeat.o(66304);
    return 255;
  }
  
  public static String getOrigAndroidID(Context paramContext)
  {
    AppMethodBeat.i(66300);
    String str = "";
    try
    {
      paramContext = Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
      paramContext = string2Md5(paramContext);
      AppMethodBeat.o(66300);
      return paramContext;
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
    AppMethodBeat.i(66301);
    try
    {
      paramContext = (WifiManager)paramContext.getSystemService("wifi");
      if (paramContext == null) {
        break label74;
      }
      paramContext = paramContext.getConnectionInfo();
    }
    catch (Exception paramContext)
    {
      try
      {
        label35:
        for (paramContext = string2Md5(((String)localObject).replaceAll(":", "").toUpperCase());; paramContext = "")
        {
          localObject = paramContext;
          if (paramContext == null) {
            localObject = "";
          }
          AppMethodBeat.o(66301);
          return localObject;
          paramContext = null;
          break;
          localObject = null;
          break label35;
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
    AppMethodBeat.i(66305);
    String str = "";
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).packageName;
      AppMethodBeat.o(66305);
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
  
  public static String getSimulateIDFA(Context paramContext)
  {
    AppMethodBeat.i(66302);
    paramContext = doRead(paramContext) + ";" + getOrigMacAddr(paramContext) + ";" + getOrigAndroidID(paramContext);
    AppMethodBeat.o(66302);
    return paramContext;
  }
  
  public static int getStatusReportInterval()
  {
    AppMethodBeat.i(66292);
    int i = nativeGetStatusReportInterval();
    AppMethodBeat.o(66292);
    return i;
  }
  
  public static void initCrashReport(Context paramContext)
  {
    AppMethodBeat.i(66307);
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
      finally
      {
        AppMethodBeat.o(66307);
      }
      return;
    }
    catch (Exception paramContext)
    {
      AppMethodBeat.o(66307);
    }
  }
  
  public static native int nativeGetStatusReportInterval();
  
  private static native void nativeInitDataReport();
  
  private static native void nativeInitEventInternal(String paramString, int paramInt1, int paramInt2, TXCDRExtInfo paramTXCDRExtInfo);
  
  public static native void nativeReportAVRoomEvent(int paramInt1, long paramLong, String paramString1, int paramInt2, int paramInt3, String paramString2, String paramString3);
  
  private static native void nativeReportDAUInterval(int paramInt1, int paramInt2, String paramString);
  
  public static native void nativeReportEvent(String paramString, int paramInt);
  
  public static native void nativeReportEvent40003(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3);
  
  public static native void nativeSetCommonValue(String paramString1, String paramString2);
  
  private static native void nativeSetEventValueInterval(String paramString1, int paramInt, String paramString2, String paramString3);
  
  private static native void nativeUninitDataReport();
  
  public static void reportAVRoomEvent(int paramInt1, long paramLong, String paramString1, int paramInt2, int paramInt3, String paramString2, String paramString3)
  {
    AppMethodBeat.i(146741);
    nativeReportAVRoomEvent(paramInt1, paramLong, paramString1, paramInt2, paramInt3, paramString2, paramString3);
    AppMethodBeat.o(146741);
  }
  
  public static void reportEvent40003(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3)
  {
    AppMethodBeat.i(66291);
    nativeReportEvent40003(paramString1, paramInt1, paramInt2, paramString2, paramString3);
    AppMethodBeat.o(66291);
  }
  
  public static void setCommonInfo(Context paramContext)
  {
    AppMethodBeat.i(66293);
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
    AppMethodBeat.o(66293);
  }
  
  public static String string2Md5(String paramString)
  {
    AppMethodBeat.i(66298);
    String str = "";
    if (paramString == null)
    {
      AppMethodBeat.o(66298);
      return "";
    }
    try
    {
      paramString = byteArrayToHexString(MessageDigest.getInstance("MD5").digest(paramString.getBytes("UTF-8")));
      str = paramString;
      if (paramString == null) {
        str = "";
      }
      AppMethodBeat.o(66298);
      return str;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString = str;
      }
    }
  }
  
  public static String txCreateToken()
  {
    AppMethodBeat.i(66296);
    String str = UUID.randomUUID().toString();
    AppMethodBeat.o(66296);
    return str;
  }
  
  public static void txReportDAU(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(66289);
    if (paramContext != null) {
      setCommonInfo(paramContext);
    }
    nativeReportDAUInterval(paramInt, 0, "");
    AppMethodBeat.o(66289);
  }
  
  public static void txReportDAU(Context paramContext, int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(66290);
    if (paramContext != null) {
      setCommonInfo(paramContext);
    }
    nativeReportDAUInterval(paramInt1, paramInt2, paramString);
    AppMethodBeat.o(66290);
  }
  
  public static void txSetAppVersion(String paramString)
  {
    AppMethodBeat.i(66295);
    if (paramString != null) {
      nativeSetCommonValue(a.k, paramString);
    }
    AppMethodBeat.o(66295);
  }
  
  public static void txSetCommonInfo()
  {
    AppMethodBeat.i(66294);
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
    AppMethodBeat.o(66294);
  }
  
  public static void txSetEventIntValue(String paramString1, int paramInt, String paramString2, long paramLong)
  {
    AppMethodBeat.i(66288);
    nativeSetEventValueInterval(paramString1, paramInt, paramString2, String.valueOf(paramLong));
    AppMethodBeat.o(66288);
  }
  
  public static void txSetEventValue(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    AppMethodBeat.i(66287);
    nativeSetEventValueInterval(paramString1, paramInt, paramString2, paramString3);
    AppMethodBeat.o(66287);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.liteav.basic.datareport.TXCDRApi
 * JD-Core Version:    0.7.0.1
 */