package com.tencent.mars.xlog;

import android.os.Debug;
import android.os.Process;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

public class LogLogic
{
  private static ICallBack callBack = null;
  
  public static native void addLogRule(int paramInt, String paramString1, String paramString2);
  
  public static String appendMemLog(String paramString)
  {
    return paramString;
  }
  
  public static String convertStreamToString(InputStream paramInputStream)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    try
    {
      localBufferedReader = new BufferedReader(new InputStreamReader(paramInputStream));
      try
      {
        for (;;)
        {
          paramInputStream = localBufferedReader.readLine();
          if (paramInputStream == null) {
            break;
          }
          localStringBuilder.append(paramInputStream).append('\n');
        }
        if (localBufferedReader == null) {
          break label56;
        }
      }
      finally {}
    }
    finally
    {
      for (;;)
      {
        BufferedReader localBufferedReader = null;
      }
    }
    localBufferedReader.close();
    label56:
    throw paramInputStream;
    localBufferedReader.close();
    return localStringBuilder.toString();
  }
  
  public static native int getAppenderModeFromCfg();
  
  public static long getDalvikHeap()
  {
    Runtime localRuntime = Runtime.getRuntime();
    return (localRuntime.totalMemory() - localRuntime.freeMemory()) / 1024L;
  }
  
  public static native int getIPxxLogLevel();
  
  public static native int getLogLevelFromCfg();
  
  public static long getNativeHeap()
  {
    return Debug.getNativeHeapAllocatedSize() / 1024L;
  }
  
  public static String getStringFromFile(String paramString)
  {
    paramString = new File(paramString);
    BufferedInputStream localBufferedInputStream;
    try
    {
      localBufferedInputStream = new BufferedInputStream(new FileInputStream(paramString));
      if (localBufferedInputStream == null) {
        break label47;
      }
    }
    finally
    {
      try
      {
        paramString = convertStreamToString(localBufferedInputStream);
        localBufferedInputStream.close();
        return paramString;
      }
      finally {}
      paramString = finally;
      localBufferedInputStream = null;
    }
    localBufferedInputStream.close();
    label47:
    throw paramString;
  }
  
  public static String getVmSize()
  {
    Object localObject = String.format("/proc/%s/status", new Object[] { Integer.valueOf(Process.myPid()) });
    for (;;)
    {
      int i;
      try
      {
        localObject = getStringFromFile((String)localObject).trim().split("\n");
        int j = localObject.length;
        i = 0;
        if (i < j)
        {
          String str = localObject[i];
          if (str.startsWith("VmSize")) {
            return str;
          }
        }
        else
        {
          localObject = localObject[12];
          return localObject;
        }
      }
      catch (Exception localException)
      {
        return "";
      }
      i += 1;
    }
  }
  
  public static String getVmStatus()
  {
    String str = String.format("/proc/%s/status", new Object[] { Integer.valueOf(Process.myPid()) });
    StringBuilder localStringBuilder = new StringBuilder();
    try
    {
      localStringBuilder.append(getStringFromFile(str).trim());
      return localStringBuilder.toString();
    }
    catch (Exception localException) {}
    return localStringBuilder.toString();
  }
  
  public static void hitLogRuleCallback(String paramString1, String paramString2, String paramString3, int paramInt, String paramString4)
  {
    if (callBack == null) {
      return;
    }
    callBack.hitLogRuleCallback(paramString1, paramString2, paramString3, paramInt, paramString4);
  }
  
  public static native void initIPxxLogInfo();
  
  public static native void removeLogRule(String paramString);
  
  public static void setCallBack(ICallBack paramICallBack)
  {
    callBack = paramICallBack;
  }
  
  public static native void setIPxxLogML(int paramInt1, int paramInt2);
  
  public static abstract interface ICallBack
  {
    public abstract void hitLogRuleCallback(String paramString1, String paramString2, String paramString3, int paramInt, String paramString4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mars.xlog.LogLogic
 * JD-Core Version:    0.7.0.1
 */