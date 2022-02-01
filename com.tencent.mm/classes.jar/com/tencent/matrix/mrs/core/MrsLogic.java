package com.tencent.matrix.mrs.core;

import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.matrix.g.c;
import java.util.TimeZone;

public final class MrsLogic
{
  private static final String TAG = "MrsLogic";
  private static MrsLogic.PhoneInfo phoneInfo;
  private static MrsCallback strategyCaller = null;
  
  public static native void collectData(String paramString, byte[] paramArrayOfByte);
  
  static String getCryptKey(MatrixUploadDataSlice paramMatrixUploadDataSlice)
  {
    if (strategyCaller == null) {
      return "";
    }
    return strategyCaller.getCryptKey(paramMatrixUploadDataSlice);
  }
  
  static String getHost(MatrixUploadDataSlice paramMatrixUploadDataSlice)
  {
    if (strategyCaller == null)
    {
      c.w("MrsLogic", "callback is null", new Object[0]);
      return "";
    }
    return strategyCaller.getHost(paramMatrixUploadDataSlice);
  }
  
  public static MrsLogic.PhoneInfo getPhoneInfo()
  {
    if (phoneInfo == null) {
      phoneInfo = getPhoneInfoInternal();
    }
    return phoneInfo;
  }
  
  private static MrsLogic.PhoneInfo getPhoneInfoInternal()
  {
    MrsLogic.PhoneInfo localPhoneInfo = new MrsLogic.PhoneInfo();
    localPhoneInfo.deviceModel = replayUnderlineWithDoc(Build.MODEL);
    localPhoneInfo.deviceBrand = replayUnderlineWithDoc(Build.BRAND);
    String str2 = Build.MANUFACTURER;
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = Build.BRAND;
    }
    localPhoneInfo.osName = replayUnderlineWithDoc(str1);
    localPhoneInfo.osVersion = Build.VERSION.SDK_INT;
    localPhoneInfo.languageVer = "";
    return localPhoneInfo;
  }
  
  static String getPublicSharePath()
  {
    try
    {
      if (strategyCaller == null) {
        throw new RuntimeException("getPublicSharePath, but strategyCaller is null");
      }
    }
    catch (Exception localException)
    {
      c.printErrStackTrace("MrsLogic", localException, "jni callback exception", new Object[0]);
      return null;
    }
    String str = strategyCaller.getPublicSharePath();
    return str;
  }
  
  static String getUrl(MatrixUploadDataSlice paramMatrixUploadDataSlice)
  {
    if (strategyCaller == null)
    {
      c.w("MrsLogic", "callback is null", new Object[0]);
      return "";
    }
    return strategyCaller.getUrl(paramMatrixUploadDataSlice);
  }
  
  public static void init(long paramLong1, String paramString, boolean paramBoolean, long paramLong2)
  {
    onCreate();
    onForeground(true);
    setTimeZone(TimeZone.getDefault().getRawOffset() / 3600000);
    setClientVersion(paramLong1);
    setRevision(paramString);
    setDebugFlag(paramBoolean);
    setPhoneInfo(getPhoneInfo());
    setPublishType(paramLong2);
  }
  
  public static native boolean isNeed2Report(String paramString);
  
  private static String limitRevision(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while (paramString.length() <= 7) {
      return paramString;
    }
    return paramString.substring(0, 7);
  }
  
  static native void onCrash();
  
  static native void onCreate();
  
  static native void onDestroy();
  
  public static native void onForeground(boolean paramBoolean);
  
  static boolean onRequestGetMrsStrategy(byte[] paramArrayOfByte)
  {
    try
    {
      if (strategyCaller == null) {
        throw new RuntimeException("onRequestGetMrsStrategy, but strategyCaller is null");
      }
    }
    catch (Exception paramArrayOfByte)
    {
      c.printErrStackTrace("MrsLogic", paramArrayOfByte, "jni callback exception", new Object[0]);
      return false;
    }
    boolean bool = strategyCaller.onRequestGetMrsStrategy(paramArrayOfByte);
    return bool;
  }
  
  static void onStrategyNotify(String paramString) {}
  
  public static native void onStrategyResp(int paramInt1, int paramInt2, byte[] paramArrayOfByte);
  
  private static String replayUnderlineWithDoc(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    return paramString.replace("_", "-");
  }
  
  private static native void setClientVersion(long paramLong);
  
  private static native void setDebugFlag(boolean paramBoolean);
  
  static native void setPhoneInfo(MrsLogic.PhoneInfo paramPhoneInfo);
  
  private static native void setPublishType(long paramLong);
  
  private static native void setRevision(String paramString);
  
  public static void setStrategyCaller(MatrixStrategyCaller paramMatrixStrategyCaller)
  {
    strategyCaller = paramMatrixStrategyCaller;
  }
  
  public static native void setTimeZone(int paramInt);
  
  public static native void setUin(long paramLong);
  
  public static native void uploadMatrixIssue(MatrixUploadIssue paramMatrixUploadIssue);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.matrix.mrs.core.MrsLogic
 * JD-Core Version:    0.7.0.1
 */