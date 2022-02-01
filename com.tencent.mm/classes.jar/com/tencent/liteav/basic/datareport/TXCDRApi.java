package com.tencent.liteav.basic.datareport;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXCCommonUtil;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.liteav.basic.util.f;
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
  private static final String TAG = "TXCDRApi";
  private static String g_simulate_idfa;
  static boolean initRpt;
  private static String mAppName;
  private static String mDevId;
  private static String mDevType;
  private static String mDevUUID;
  private static String mNetType;
  private static String mSysVersion;
  
  static
  {
    AppMethodBeat.i(14636);
    mDevType = "";
    mNetType = "";
    mDevId = "";
    mDevUUID = "";
    mAppName = "";
    mSysVersion = "";
    g_simulate_idfa = "";
    DIGITS_LOWER = new char[] { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
    initRpt = false;
    f.f();
    nativeInitDataReport();
    AppMethodBeat.o(14636);
  }
  
  public static void InitEvent(Context paramContext, String paramString, int paramInt1, int paramInt2, TXCDRExtInfo paramTXCDRExtInfo)
  {
    AppMethodBeat.i(14613);
    setCommonInfo(paramContext);
    if (paramString == null)
    {
      AppMethodBeat.o(14613);
      return;
    }
    nativeInitEventInternal(paramString, paramInt1, paramInt2, paramTXCDRExtInfo);
    AppMethodBeat.o(14613);
  }
  
  private static String byteArrayToHexString(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(14625);
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
    AppMethodBeat.o(14625);
    return paramArrayOfByte;
  }
  
  public static String getApplicationNameByPackageName(Context paramContext, String paramString)
  {
    AppMethodBeat.i(14634);
    paramContext = paramContext.getPackageManager();
    try
    {
      paramContext = paramContext.getApplicationLabel(paramContext.getApplicationInfo(paramString, 128)).toString();
      AppMethodBeat.o(14634);
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
    AppMethodBeat.i(14631);
    paramContext = getSimulateIDFA(paramContext);
    AppMethodBeat.o(14631);
    return paramContext;
  }
  
  public static int getNetworkType(Context paramContext)
  {
    AppMethodBeat.i(14632);
    if (paramContext == null)
    {
      AppMethodBeat.o(14632);
      return 255;
    }
    Object localObject = (ConnectivityManager)paramContext.getSystemService("connectivity");
    paramContext = (TelephonyManager)paramContext.getSystemService("phone");
    try
    {
      localObject = ((ConnectivityManager)localObject).getActiveNetworkInfo();
      if (localObject == null)
      {
        AppMethodBeat.o(14632);
        return 255;
      }
    }
    catch (Exception paramContext)
    {
      TXCLog.e("TXCDRApi", "getActiveNetworkInfo exception:", paramContext);
      AppMethodBeat.o(14632);
      return 255;
    }
    if (((NetworkInfo)localObject).getType() == 1)
    {
      AppMethodBeat.o(14632);
      return 1;
    }
    if (((NetworkInfo)localObject).getType() == 0)
    {
      try
      {
        int i = paramContext.getNetworkType();
        switch (i)
        {
        default: 
          AppMethodBeat.o(14632);
          return 2;
        }
      }
      catch (Exception paramContext)
      {
        TXCLog.e("TXCDRApi", "TXCDRApi: get network type fail, exception occurred.", paramContext);
        AppMethodBeat.o(14632);
        return 2;
      }
      AppMethodBeat.o(14632);
      return 4;
      AppMethodBeat.o(14632);
      return 3;
      AppMethodBeat.o(14632);
      return 2;
    }
    AppMethodBeat.o(14632);
    return 255;
  }
  
  public static String getOrigAndroidID(Context paramContext)
  {
    AppMethodBeat.i(14628);
    String str = "";
    try
    {
      paramContext = Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
      paramContext = string2Md5(paramContext);
      AppMethodBeat.o(14628);
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
  
  private static String getPackageName(Context paramContext)
  {
    AppMethodBeat.i(14633);
    String str = "";
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).packageName;
      AppMethodBeat.o(14633);
      return paramContext;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        TXCLog.e("TXCDRApi", "get package name failed.", paramContext);
        paramContext = str;
      }
    }
  }
  
  public static String getSimulateIDFA(Context paramContext)
  {
    AppMethodBeat.i(14630);
    if ((g_simulate_idfa != null) && (g_simulate_idfa.length() > 0))
    {
      paramContext = g_simulate_idfa;
      AppMethodBeat.o(14630);
      return paramContext;
    }
    Object localObject1 = null;
    localObject4 = null;
    Object localObject5 = null;
    localFile = paramContext.getExternalFilesDir(null);
    if (localFile == null)
    {
      TXCLog.e("TXCDRApi", "getSimulateIDFA sdcardDir is null");
      paramContext = g_simulate_idfa;
      AppMethodBeat.o(14630);
      return paramContext;
    }
    localSharedPreferences = paramContext.getSharedPreferences("com.tencent.liteav.dev_uuid", 0);
    str = localSharedPreferences.getString("com.tencent.liteav.key_dev_uuid", "");
    localObject3 = localObject4;
    try
    {
      Object localObject6 = new File(localFile.getAbsolutePath() + "/txrtmp/spuid");
      localObject3 = localObject4;
      if (((File)localObject6).exists())
      {
        localObject3 = localObject4;
        localObject6 = new FileInputStream((File)localObject6);
        localObject3 = localObject4;
        i = ((FileInputStream)localObject6).available();
        localObject1 = localObject5;
        if (i > 0)
        {
          localObject3 = localObject4;
          localObject1 = new byte[i];
          localObject3 = localObject4;
          ((FileInputStream)localObject6).read((byte[])localObject1);
          localObject3 = localObject4;
          localObject1 = new String((byte[])localObject1, "UTF-8");
        }
        localObject3 = localObject1;
        ((FileInputStream)localObject6).close();
      }
      localObject3 = localObject1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int i;
        long l1;
        long l2;
        TXCLog.e("TXCDRApi", "read UUID from file failed! reason: " + localException.getMessage());
        continue;
        if ((localObject3 != null) && (localObject3.length() > 0))
        {
          localObject2 = localObject3;
          continue;
          i = 3;
          while (i >= 0)
          {
            paramContext = paramContext + String.format("%02x", new Object[] { Byte.valueOf((byte)(int)(l2 >> i * 8 & 0xFF)) });
            i -= 1;
          }
          localObject4 = paramContext + string2Md5(new StringBuilder().append((String)localObject4).append(UUID.randomUUID().toString()).toString());
          g_simulate_idfa = (String)localObject4;
          TXCLog.i("TXCDRApi", "UUID:" + g_simulate_idfa);
          if ((localObject3 == null) || (!localObject3.equals(localObject4))) {}
          try
          {
            paramContext = new File(localFile.getAbsolutePath() + "/txrtmp");
            if (!paramContext.exists()) {
              paramContext.mkdir();
            }
            paramContext = new File(localFile.getAbsolutePath() + "/txrtmp/spuid");
            if (!paramContext.exists()) {
              paramContext.createNewFile();
            }
            paramContext = new FileOutputStream(paramContext);
            paramContext.write(((String)localObject4).getBytes());
            paramContext.close();
          }
          catch (Exception paramContext)
          {
            for (;;)
            {
              TXCLog.e("TXCDRApi", "write UUID to file failed! reason: " + paramContext.getMessage());
            }
          }
          if ((str == null) || (!str.equals(localObject4)))
          {
            paramContext = localSharedPreferences.edit();
            paramContext.putString("com.tencent.liteav.key_dev_uuid", (String)localObject4);
            paramContext.commit();
          }
          paramContext = g_simulate_idfa;
          AppMethodBeat.o(14630);
          return paramContext;
        }
        Object localObject2 = null;
      }
    }
    if ((str != null) && (str.length() > 0))
    {
      localObject1 = str;
      if (localObject1 != null)
      {
        localObject4 = localObject1;
        if (((String)localObject1).length() != 0) {
          break label500;
        }
      }
      localObject1 = "";
      l1 = System.currentTimeMillis();
      l2 = TXCTimeUtil.getTimeTick();
      localObject4 = f.c(paramContext);
      i = 5;
      paramContext = (Context)localObject1;
      while (i >= 0)
      {
        paramContext = paramContext + String.format("%02x", new Object[] { Byte.valueOf((byte)(int)(l1 >> i * 8 & 0xFF)) });
        i -= 1;
      }
    }
  }
  
  public static int getStatusReportInterval()
  {
    AppMethodBeat.i(14620);
    int i = nativeGetStatusReportInterval();
    AppMethodBeat.o(14620);
    return i;
  }
  
  public static void initCrashReport(Context paramContext)
  {
    AppMethodBeat.i(14635);
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
        AppMethodBeat.o(14635);
      }
      return;
    }
    catch (Exception paramContext)
    {
      TXCLog.e("TXCDRApi", "init crash report failed.", paramContext);
      AppMethodBeat.o(14635);
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
    AppMethodBeat.i(14619);
    nativeReportAVRoomEvent(paramInt1, paramLong, paramString1, paramInt2, paramInt3, paramString2, paramString3);
    AppMethodBeat.o(14619);
  }
  
  public static void reportEvent40003(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3)
  {
    AppMethodBeat.i(14618);
    nativeReportEvent40003(paramString1, paramInt1, paramInt2, paramString2, paramString3);
    AppMethodBeat.o(14618);
  }
  
  public static void setCommonInfo(Context paramContext)
  {
    AppMethodBeat.i(14621);
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
    txSetCommonInfo();
    AppMethodBeat.o(14621);
  }
  
  public static String string2Md5(String paramString)
  {
    AppMethodBeat.i(14626);
    String str = "";
    if (paramString == null)
    {
      AppMethodBeat.o(14626);
      return "";
    }
    try
    {
      paramString = byteArrayToHexString(MessageDigest.getInstance("MD5").digest(paramString.getBytes("UTF-8")));
      str = paramString;
      if (paramString == null) {
        str = "";
      }
      AppMethodBeat.o(14626);
      return str;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        TXCLog.e("TXCDRApi", "string2Md5 failed.", paramString);
        paramString = str;
      }
    }
  }
  
  public static String txCreateToken()
  {
    AppMethodBeat.i(14624);
    String str = UUID.randomUUID().toString();
    AppMethodBeat.o(14624);
    return str;
  }
  
  public static void txReportDAU(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(14616);
    if (paramContext != null) {
      setCommonInfo(paramContext);
    }
    nativeReportDAUInterval(paramInt, 0, "");
    AppMethodBeat.o(14616);
  }
  
  public static void txReportDAU(Context paramContext, int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(14617);
    if (paramContext != null) {
      setCommonInfo(paramContext);
    }
    nativeReportDAUInterval(paramInt1, paramInt2, paramString);
    AppMethodBeat.o(14617);
  }
  
  public static void txSetAppVersion(String paramString)
  {
    AppMethodBeat.i(14623);
    if (paramString != null) {
      nativeSetCommonValue(a.k, paramString);
    }
    AppMethodBeat.o(14623);
  }
  
  public static void txSetCommonInfo()
  {
    AppMethodBeat.i(14622);
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
    AppMethodBeat.o(14622);
  }
  
  public static void txSetEventIntValue(String paramString1, int paramInt, String paramString2, long paramLong)
  {
    AppMethodBeat.i(14615);
    nativeSetEventValueInterval(paramString1, paramInt, paramString2, String.valueOf(paramLong));
    AppMethodBeat.o(14615);
  }
  
  public static void txSetEventValue(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    AppMethodBeat.i(14614);
    nativeSetEventValueInterval(paramString1, paramInt, paramString2, paramString3);
    AppMethodBeat.o(14614);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.liteav.basic.datareport.TXCDRApi
 * JD-Core Version:    0.7.0.1
 */