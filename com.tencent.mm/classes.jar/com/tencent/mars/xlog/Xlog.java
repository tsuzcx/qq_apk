package com.tencent.mars.xlog;

import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ad.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bq;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.g;
import com.tencent.mm.vfs.i;
import com.tencent.mm.vfs.q;

public class Xlog
  implements ad.a
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
  public static final int ZLIB_MODE = 0;
  public static final int ZSTD_COMPRESS_LEVEL1 = 1;
  public static final int ZSTD_COMPRESS_LEVEL2 = 2;
  public static final int ZSTD_COMPRESS_LEVEL3 = 3;
  public static final int ZSTD_COMPRESS_LEVEL4 = 4;
  public static final int ZSTD_COMPRESS_LEVEL5 = 5;
  public static final int ZSTD_COMPRESS_LEVEL6 = 6;
  public static final int ZSTD_COMPRESS_LEVEL7 = 7;
  public static final int ZSTD_COMPRESS_LEVEL8 = 8;
  public static final int ZSTD_COMPRESS_LEVEL9 = 9;
  public static final int ZSTD_MODE = 1;
  public static ae logDecryptor;
  private static String mCacheDir = null;
  private static String mLogDir = null;
  private static String xlog_pubkey = "1dac3876bd566b60c7dcbffd219ca6af2d2c07f045711bf2a6d111a2b1fc27c4df31c1f568879708c5159e370ab141e6627ea028b47f8a5cf4d39ca30d501f81";
  
  private static native void appenderOpen(XLogConfig paramXLogConfig);
  
  private static String decryptTag(String paramString)
  {
    ae localae;
    if (logDecryptor != null)
    {
      localae = logDecryptor;
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
      return localae.gg(paramString, paramString.length());
    }
    return localae.Ids.decryptTag(paramString);
  }
  
  public static native void logWrite(XLoggerInfo paramXLoggerInfo, String paramString);
  
  public static void logWrite2(int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2, int paramInt3, long paramLong1, long paramLong2, String paramString4)
  {
    logWrite2(0L, paramInt1, paramString1, paramString2, paramString3, paramInt2, paramInt3, paramLong1, paramLong2, paramString4);
  }
  
  public static native void logWrite2(long paramLong1, int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2, int paramInt3, long paramLong2, long paramLong3, String paramString4);
  
  public static void open(boolean paramBoolean, int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, int paramInt3)
  {
    if (paramBoolean) {
      System.loadLibrary("tencentxlog");
    }
    ad.appenderOpen(paramInt1, paramInt2, paramString1, paramString2, paramString3, paramInt3);
  }
  
  public native void appenderClose();
  
  public native void appenderFlush(long paramLong, boolean paramBoolean);
  
  public void appenderOpen(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, int paramInt3)
  {
    mCacheDir = paramString1;
    mLogDir = paramString2;
    XLogConfig localXLogConfig = new XLogConfig();
    localXLogConfig.level = paramInt1;
    localXLogConfig.mode = paramInt2;
    localXLogConfig.logdir = paramString2;
    localXLogConfig.nameprefix = paramString3;
    localXLogConfig.compressmode = 1;
    localXLogConfig.pubkey = xlog_pubkey;
    localXLogConfig.cachedir = paramString1;
    localXLogConfig.cachedays = paramInt3;
    appenderOpen(localXLogConfig);
  }
  
  public native int getLogLevel(long paramLong);
  
  public native long getXlogInstance(String paramString);
  
  public void logD(long paramLong1, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, long paramLong2, long paramLong3, String paramString4)
  {
    logWrite2(paramLong1, 1, decryptTag(paramString1), paramString2, paramString3, paramInt1, paramInt2, paramLong2, paramLong3, LogLogic.appendMemLog(paramString4));
  }
  
  public void logE(long paramLong1, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, long paramLong2, long paramLong3, String paramString4)
  {
    logWrite2(paramLong1, 4, decryptTag(paramString1), paramString2, paramString3, paramInt1, paramInt2, paramLong2, paramLong3, LogLogic.appendMemLog(paramString4));
  }
  
  public void logF(long paramLong1, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, long paramLong2, long paramLong3, String paramString4)
  {
    logWrite2(paramLong1, 5, decryptTag(paramString1), paramString2, paramString3, paramInt1, paramInt2, paramLong2, paramLong3, paramString4);
  }
  
  public void logI(long paramLong1, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, long paramLong2, long paramLong3, String paramString4)
  {
    logWrite2(paramLong1, 2, decryptTag(paramString1), paramString2, paramString3, paramInt1, paramInt2, paramLong2, paramLong3, LogLogic.appendMemLog(paramString4));
  }
  
  public void logV(long paramLong1, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, long paramLong2, long paramLong3, String paramString4)
  {
    logWrite2(paramLong1, 0, decryptTag(paramString1), paramString2, paramString3, paramInt1, paramInt2, paramLong2, paramLong3, paramString4);
  }
  
  public void logW(long paramLong1, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, long paramLong2, long paramLong3, String paramString4)
  {
    logWrite2(paramLong1, 3, decryptTag(paramString1), paramString2, paramString3, paramInt1, paramInt2, paramLong2, paramLong3, LogLogic.appendMemLog(paramString4));
  }
  
  public void moveLogsFromCacheDirToLogDir()
  {
    if ((mCacheDir == null) || (mLogDir == null) || (mCacheDir.length() == 0) || (mLogDir.length() == 0)) {}
    for (;;)
    {
      return;
      Object localObject1 = new e(mCacheDir);
      if (((e)localObject1).exists())
      {
        localObject1 = ((e)localObject1).a(new g()
        {
          public boolean accept(e paramAnonymouse)
          {
            if (paramAnonymouse.isDirectory()) {
              return false;
            }
            return paramAnonymouse.getName().toLowerCase().endsWith(".xlog");
          }
        });
        if (localObject1.length != 0)
        {
          int j = localObject1.length;
          int i = 0;
          while (i < j)
          {
            Object localObject2 = localObject1[i];
            i.mA(q.B(localObject2.mUri), mLogDir + "/" + localObject2.getName());
            i += 1;
          }
        }
      }
    }
  }
  
  public native long newXlogInstance(XLogConfig paramXLogConfig);
  
  public long openLogInstance(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, int paramInt3)
  {
    XLogConfig localXLogConfig = new XLogConfig();
    localXLogConfig.level = paramInt1;
    localXLogConfig.mode = paramInt2;
    localXLogConfig.logdir = paramString2;
    localXLogConfig.nameprefix = paramString3;
    localXLogConfig.compressmode = 1;
    localXLogConfig.pubkey = xlog_pubkey;
    localXLogConfig.cachedir = paramString1;
    localXLogConfig.cachedays = paramInt3;
    return newXlogInstance(localXLogConfig);
  }
  
  public native void releaseXlogInstance(String paramString);
  
  public native void setAppenderMode(long paramLong, int paramInt);
  
  public native void setConsoleLogOpen(long paramLong, boolean paramBoolean);
  
  public native void setMaxAliveTime(long paramLong1, long paramLong2);
  
  public native void setMaxFileSize(long paramLong1, long paramLong2);
  
  static class XLogConfig
  {
    public int cachedays = 0;
    public String cachedir;
    public int compresslevel = 6;
    public int compressmode = 1;
    public int level = 2;
    public String logdir;
    public int mode = 0;
    public String nameprefix;
    public String pubkey = "";
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