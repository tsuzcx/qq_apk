package com.tencent.mars.smc;

import com.tencent.mars.Mars;
import java.util.ArrayList;

public class SmcLogic
{
  private static final String TAG = "mars.SmcLogic";
  private static ICallBack callBack;
  
  static
  {
    try
    {
      ArrayList localArrayList = getLoadLibraries();
      Mars.checkLoadedModules(localArrayList, "mars.SmcLogic");
      callBack = null;
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      for (;;)
      {
        Object localObject = null;
        Mars.loadDefaultMarsLibrary();
      }
    }
  }
  
  public static native void OnPluginMsg(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6);
  
  public static native void OnReportResp(int paramInt1, int paramInt2, byte[] paramArrayOfByte, int paramInt3);
  
  private static boolean OnSelfMonitorOpLogReady(byte[] paramArrayOfByte)
  {
    if (callBack == null) {
      return false;
    }
    return callBack.OnSelfMonitorOpLogReady(paramArrayOfByte);
  }
  
  public static native void OnStrategyResp(int paramInt1, int paramInt2, byte[] paramArrayOfByte, int paramInt3);
  
  public static native void SetDebugFlag(boolean paramBoolean);
  
  public static native void SetMonitorId(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6);
  
  public static native void flushAllReportData();
  
  private static String getKVCommPath()
  {
    if (callBack == null) {
      return "";
    }
    return callBack.getKVCommPath();
  }
  
  private static BaseInfo getKVCommReqBaseInfo()
  {
    if (callBack == null) {
      return new BaseInfo();
    }
    return callBack.getKVCommReqBaseInfo();
  }
  
  private static native ArrayList<String> getLoadLibraries();
  
  private static int getSingleReportBufSizeB()
  {
    if (callBack == null) {
      return 0;
    }
    return callBack.getSingleReportBufSizeB();
  }
  
  public static native ArrayList<Integer> getStrategyVersions();
  
  public static native void onCreate();
  
  private static void onReportDataReady(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt, String paramString)
  {
    if (callBack == null) {
      return;
    }
    callBack.onReportDataReady(paramArrayOfByte1, paramArrayOfByte2, paramInt, paramString);
  }
  
  private static boolean onRequestGetStrategy(byte[] paramArrayOfByte, int paramInt)
  {
    if (callBack == null) {
      return false;
    }
    return callBack.onRequestGetStrategy(paramArrayOfByte, paramInt);
  }
  
  public static native void reportIDKey(long paramLong1, long paramLong2, long paramLong3, boolean paramBoolean);
  
  public static native void reportListIDKey(IDKey[] paramArrayOfIDKey, boolean paramBoolean);
  
  public static void setCallBack(ICallBack paramICallBack)
  {
    callBack = paramICallBack;
  }
  
  public static native void setTimeZone(int paramInt);
  
  public static native void setUin(long paramLong);
  
  public static native void writeImportKvData(long paramLong, String paramString, boolean paramBoolean1, boolean paramBoolean2);
  
  public static native void writeImportKvDataWithType(long paramLong1, long paramLong2, String paramString, boolean paramBoolean1, boolean paramBoolean2);
  
  public static native void writeImportKvPbData(long paramLong, byte[] paramArrayOfByte, boolean paramBoolean);
  
  public static native void writeImportKvPbDataWithType(long paramLong1, long paramLong2, byte[] paramArrayOfByte, boolean paramBoolean);
  
  public static native void writeKvData(long paramLong, String paramString, boolean paramBoolean1, boolean paramBoolean2);
  
  public static native void writeKvDataWithIsolate(long paramLong, String paramString1, boolean paramBoolean1, boolean paramBoolean2, String paramString2);
  
  public static native void writeKvDataWithType(long paramLong1, long paramLong2, String paramString, boolean paramBoolean1, boolean paramBoolean2);
  
  public static native void writeKvPbData(long paramLong, byte[] paramArrayOfByte, boolean paramBoolean);
  
  public static native void writeKvPbDataWithType(long paramLong1, long paramLong2, byte[] paramArrayOfByte, boolean paramBoolean);
  
  public static class BaseInfo
  {
    public String deviceBrand;
    public String deviceModel;
    public String languageVer;
    public String osName;
    public String osVersion;
  }
  
  public static abstract interface ICallBack
  {
    public abstract boolean OnSelfMonitorOpLogReady(byte[] paramArrayOfByte);
    
    public abstract String getKVCommPath();
    
    public abstract SmcLogic.BaseInfo getKVCommReqBaseInfo();
    
    public abstract int getSingleReportBufSizeB();
    
    public abstract void onReportDataReady(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt, String paramString);
    
    public abstract boolean onRequestGetStrategy(byte[] paramArrayOfByte, int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mars.smc.SmcLogic
 * JD-Core Version:    0.7.0.1
 */