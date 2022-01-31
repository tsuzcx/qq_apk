package com.tencent.matrix.mrs.core;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.matrix.g.c;
import java.util.TimeZone;

public final class MrsLogic
{
  private static final String TAG = "MrsLogic";
  private static MrsCallback mrsCallback = null;
  private static PhoneInfo phoneInfo;
  
  static native void collectData(String paramString, byte[] paramArrayOfByte);
  
  static String getCryptKey(MatrixUploadDataSlice paramMatrixUploadDataSlice)
  {
    if (mrsCallback == null) {
      return "";
    }
    return mrsCallback.getCryptKey(paramMatrixUploadDataSlice);
  }
  
  static String getHost(MatrixUploadDataSlice paramMatrixUploadDataSlice)
  {
    if (mrsCallback == null)
    {
      c.w("MrsLogic", "callback is null", new Object[0]);
      return "";
    }
    return mrsCallback.getHost(paramMatrixUploadDataSlice);
  }
  
  static PhoneInfo getPhoneInfo()
  {
    if (phoneInfo == null) {
      phoneInfo = getPhoneInfoInternal();
    }
    return phoneInfo;
  }
  
  private static PhoneInfo getPhoneInfoInternal()
  {
    PhoneInfo localPhoneInfo = new PhoneInfo();
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
      if (mrsCallback == null) {
        throw new RuntimeException("getPublicSharePath, but mrsCallback is null");
      }
    }
    catch (Exception localException)
    {
      c.printErrStackTrace("MrsLogic", localException, "jni callback exception", new Object[0]);
      return null;
    }
    String str = mrsCallback.getPublicSharePath();
    return str;
  }
  
  static String getUrl(MatrixUploadDataSlice paramMatrixUploadDataSlice)
  {
    if (mrsCallback == null)
    {
      c.w("MrsLogic", "callback is null", new Object[0]);
      return "";
    }
    return mrsCallback.getUrl(paramMatrixUploadDataSlice);
  }
  
  static void init(long paramLong1, String paramString, boolean paramBoolean, long paramLong2)
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
  
  static native boolean isNeed2Report(String paramString);
  
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
  
  static native void onForeground(boolean paramBoolean);
  
  static boolean onRequestGetMrsStrategy(byte[] paramArrayOfByte)
  {
    try
    {
      if (mrsCallback == null) {
        throw new RuntimeException("onRequestGetMrsStrategy, but mrsCallback is null");
      }
    }
    catch (Exception paramArrayOfByte)
    {
      c.printErrStackTrace("MrsLogic", paramArrayOfByte, "jni callback exception", new Object[0]);
      return false;
    }
    boolean bool = mrsCallback.onRequestGetMrsStrategy(paramArrayOfByte);
    return bool;
  }
  
  static void onStrategyNotify(String paramString)
  {
    try
    {
      if (mrsCallback == null) {
        throw new RuntimeException("onRequestGetMrsStrategy, but mrsCallback is null");
      }
    }
    catch (Exception paramString)
    {
      c.printErrStackTrace("MrsLogic", paramString, "jni callback exception", new Object[0]);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("strategyNotify");
    localIntent.putExtra("strategy", paramString);
    MatrixReport.with().getContext().sendBroadcast(localIntent, "com.tencent.mm.matrix.strategynotify");
    mrsCallback.onStrategyNotify(paramString, true);
  }
  
  static native void onStrategyResp(int paramInt1, int paramInt2, byte[] paramArrayOfByte);
  
  private static String replayUnderlineWithDoc(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    return paramString.replace("_", "-");
  }
  
  static void setCallBack(MrsCallback paramMrsCallback)
  {
    mrsCallback = paramMrsCallback;
  }
  
  static native void setClientVersion(long paramLong);
  
  static native void setDebugFlag(boolean paramBoolean);
  
  static native void setPhoneInfo(PhoneInfo paramPhoneInfo);
  
  static native void setPublishType(long paramLong);
  
  static native void setRevision(String paramString);
  
  public static native void setTimeZone(int paramInt);
  
  static native void setUin(long paramLong);
  
  public static native void uploadMatrixIssue(MatrixUploadIssue paramMatrixUploadIssue);
  
  public static class PhoneInfo
  {
    public String deviceBrand;
    public String deviceModel;
    public String languageVer;
    public String osName;
    public String osVersion;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.matrix.mrs.core.MrsLogic
 * JD-Core Version:    0.7.0.1
 */