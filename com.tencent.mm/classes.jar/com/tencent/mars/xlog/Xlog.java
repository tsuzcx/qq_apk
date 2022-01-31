package com.tencent.mars.xlog;

import com.tencent.mm.a.e;
import com.tencent.mm.sdk.platformtools.ab.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bl;
import java.io.File;
import java.io.FileFilter;

public class Xlog
  implements ab.a
{
  public static final int AppednerModeAsync = 0;
  public static final int AppednerModeSync = 1;
  public static final int LEVEL_ALL = 0;
  public static final int LEVEL_DEBUG = 1;
  public static final int LEVEL_ERROR = 4;
  public static final int LEVEL_FATAL = 5;
  public static final int LEVEL_INFO = 2;
  public static final int LEVEL_NONE = 6;
  public static final int LEVEL_VERBOSE = 0;
  public static final int LEVEL_WARNING = 3;
  public static ac logDecryptor;
  private static String mCacheDir = null;
  private static String mLogDir = null;
  
  public static void AppenderOpen(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, int paramInt3)
  {
    mCacheDir = paramString1;
    mLogDir = paramString2;
    appenderOpen(paramInt1, paramInt2, paramString1, paramString2, paramString3, paramInt3, "1dac3876bd566b60c7dcbffd219ca6af2d2c07f045711bf2a6d111a2b1fc27c4df31c1f568879708c5159e370ab141e6627ea028b47f8a5cf4d39ca30d501f81");
  }
  
  private static native void appenderOpen(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, int paramInt3, String paramString4);
  
  private static String decryptTag(String paramString)
  {
    ac localac;
    if (logDecryptor != null)
    {
      localac = logDecryptor;
      if ((paramString != null) && (paramString.length() != 0)) {}
    }
    else
    {
      return paramString;
    }
    switch (paramString.charAt(0) ^ 0xDCBA)
    {
    default: 
      return paramString;
    case '⍆': 
      return localac.et(paramString, paramString.length());
    }
    return localac.ynA.decryptTag(paramString);
  }
  
  public static native void logWrite(XLoggerInfo paramXLoggerInfo, String paramString);
  
  public static native void logWrite2(int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2, int paramInt3, long paramLong1, long paramLong2, String paramString4);
  
  public static void open(boolean paramBoolean, int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, int paramInt3)
  {
    if (paramBoolean) {
      System.loadLibrary("tencentxlog");
    }
    AppenderOpen(paramInt1, paramInt2, paramString1, paramString2, paramString3, paramInt3);
  }
  
  public static native void setAppenderMode(int paramInt);
  
  public static native void setConsoleLogOpen(boolean paramBoolean);
  
  public static native void setMaxAliveTime(long paramLong);
  
  public static native void setMaxFileSize(long paramLong);
  
  public native void appenderClose();
  
  public native void appenderFlush(boolean paramBoolean);
  
  public native int getLogLevel();
  
  public void logD(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, long paramLong1, long paramLong2, String paramString4)
  {
    logWrite2(1, decryptTag(paramString1), paramString2, paramString3, paramInt1, paramInt2, paramLong1, paramLong2, LogLogic.appendMemLog(paramString4));
  }
  
  public void logE(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, long paramLong1, long paramLong2, String paramString4)
  {
    logWrite2(4, decryptTag(paramString1), paramString2, paramString3, paramInt1, paramInt2, paramLong1, paramLong2, LogLogic.appendMemLog(paramString4));
  }
  
  public void logF(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, long paramLong1, long paramLong2, String paramString4)
  {
    logWrite2(5, decryptTag(paramString1), paramString2, paramString3, paramInt1, paramInt2, paramLong1, paramLong2, paramString4);
  }
  
  public void logI(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, long paramLong1, long paramLong2, String paramString4)
  {
    logWrite2(2, decryptTag(paramString1), paramString2, paramString3, paramInt1, paramInt2, paramLong1, paramLong2, LogLogic.appendMemLog(paramString4));
  }
  
  public void logV(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, long paramLong1, long paramLong2, String paramString4)
  {
    logWrite2(0, decryptTag(paramString1), paramString2, paramString3, paramInt1, paramInt2, paramLong1, paramLong2, paramString4);
  }
  
  public void logW(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, long paramLong1, long paramLong2, String paramString4)
  {
    logWrite2(3, decryptTag(paramString1), paramString2, paramString3, paramInt1, paramInt2, paramLong1, paramLong2, LogLogic.appendMemLog(paramString4));
  }
  
  public void moveLogsFromCacheDirToLogDir()
  {
    if ((mCacheDir == null) || (mLogDir == null) || (mCacheDir.length() == 0) || (mLogDir.length() == 0)) {}
    for (;;)
    {
      return;
      Object localObject = new File(mCacheDir);
      if (((File)localObject).exists())
      {
        localObject = ((File)localObject).listFiles(new FileFilter()
        {
          public boolean accept(File paramAnonymousFile)
          {
            if (paramAnonymousFile.isDirectory()) {
              return false;
            }
            return paramAnonymousFile.getName().toLowerCase().endsWith(".xlog");
          }
        });
        if (localObject.length != 0)
        {
          int j = localObject.length;
          int i = 0;
          while (i < j)
          {
            File localFile = localObject[i];
            e.d(localFile, new File(mLogDir + "/" + localFile.getName()));
            i += 1;
          }
        }
      }
    }
  }
  
  static class XLoggerInfo
  {
    public String filename;
    public String funcname;
    public int level;
    public int line;
    public long maintid;
    public long pid;
    public String tag;
    public long tid;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mars.xlog.Xlog
 * JD-Core Version:    0.7.0.1
 */