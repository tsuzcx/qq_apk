package com.tencent.liteav.basic.log;

import android.os.Environment;
import android.text.TextUtils;
import com.tencent.liteav.basic.util.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;

public class TXCLog
{
  public static final int LOG_ASYNC = 0;
  public static final int LOG_DEBUG = 1;
  public static final int LOG_ERROR = 4;
  public static final int LOG_FATAL = 5;
  public static final int LOG_INFO = 2;
  public static final int LOG_NONE = 6;
  public static final int LOG_SYNC = 1;
  public static final int LOG_VERBOSE = 0;
  public static final int LOG_WARNING = 3;
  private static boolean mEnableCallback;
  private static boolean mEnableCompress;
  private static boolean mEnableConsole;
  private static boolean mHasInit;
  private static TXCLog.a mListener;
  public static String mLogDir;
  private static int mLogLevel;
  private static final Object mLogLock;
  
  static
  {
    AppMethodBeat.i(66092);
    mLogDir = "";
    mEnableCompress = true;
    mLogLock = new Object();
    mHasInit = false;
    mListener = null;
    mLogLevel = 0;
    mEnableConsole = true;
    mEnableCallback = false;
    AppMethodBeat.o(66092);
  }
  
  public static void d(String paramString1, String paramString2)
  {
    AppMethodBeat.i(66087);
    log(1, paramString1, paramString2);
    AppMethodBeat.o(66087);
  }
  
  public static void e(String paramString1, String paramString2)
  {
    AppMethodBeat.i(66090);
    log(4, paramString1, paramString2);
    AppMethodBeat.o(66090);
  }
  
  public static String getLogFilePath()
  {
    AppMethodBeat.i(146604);
    String str = nativeGetLogFilePath();
    AppMethodBeat.o(146604);
    return str;
  }
  
  public static void i(String paramString1, String paramString2)
  {
    AppMethodBeat.i(66088);
    log(2, paramString1, paramString2);
    AppMethodBeat.o(66088);
  }
  
  public static boolean init()
  {
    AppMethodBeat.i(146600);
    synchronized (mLogLock)
    {
      if (!mHasInit)
      {
        if (TextUtils.isEmpty(mLogDir)) {
          mLogDir = Environment.getExternalStorageDirectory().getAbsolutePath() + "/log/tencent/liteav";
        }
        if (b.f())
        {
          nativeLogInit();
          nativeLogSetLevel(mLogLevel);
          nativeLogSetConsole(mEnableConsole);
          nativeLogOpen(0, mLogDir, "LiteAV", mEnableCompress);
          nativeEnableCallback(mEnableCallback);
          mHasInit = true;
        }
      }
      boolean bool = mHasInit;
      AppMethodBeat.o(146600);
      return bool;
    }
  }
  
  public static void log(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(66083);
    if (mLogLevel <= paramInt)
    {
      if (init()) {
        nativeLog(paramInt, paramString1, "", 0, "", paramString2);
      }
      log_callback(paramInt, paramString1, paramString2);
    }
    AppMethodBeat.o(66083);
  }
  
  private static void log_callback(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(66091);
    if (mListener != null) {
      mListener.a(paramInt, paramString1, paramString2);
    }
    AppMethodBeat.o(66091);
  }
  
  private static native void nativeEnableCallback(boolean paramBoolean);
  
  private static native String nativeGetLogFilePath();
  
  private static native void nativeLog(int paramInt1, String paramString1, String paramString2, int paramInt2, String paramString3, String paramString4);
  
  private static native void nativeLogClose();
  
  private static native void nativeLogInit();
  
  private static native void nativeLogOpen(int paramInt, String paramString1, String paramString2, boolean paramBoolean);
  
  private static native void nativeLogSetConsole(boolean paramBoolean);
  
  private static native void nativeLogSetLevel(int paramInt);
  
  public static void setConsoleEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(66085);
    mEnableConsole = paramBoolean;
    synchronized (mLogLock)
    {
      if (mHasInit) {
        nativeLogSetConsole(mEnableConsole);
      }
      AppMethodBeat.o(66085);
      return;
    }
  }
  
  public static void setLevel(int paramInt)
  {
    AppMethodBeat.i(66084);
    mLogLevel = paramInt;
    synchronized (mLogLock)
    {
      if (mHasInit) {
        nativeLogSetLevel(mLogLevel);
      }
      AppMethodBeat.o(66084);
      return;
    }
  }
  
  public static void setListener(TXCLog.a arg0)
  {
    AppMethodBeat.i(146603);
    mListener = ???;
    boolean bool;
    if (??? != null) {
      bool = true;
    }
    for (;;)
    {
      mEnableCallback = bool;
      synchronized (mLogLock)
      {
        if (mHasInit) {
          nativeEnableCallback(mEnableCallback);
        }
        AppMethodBeat.o(146603);
        return;
        bool = false;
      }
    }
  }
  
  public static void setLogCompressEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(146602);
    if (mEnableCompress != paramBoolean)
    {
      mEnableCompress = paramBoolean;
      synchronized (mLogLock)
      {
        if (mHasInit)
        {
          nativeLogClose();
          mHasInit = false;
          init();
        }
        AppMethodBeat.o(146602);
        return;
      }
    }
    AppMethodBeat.o(146602);
  }
  
  public static void setLogDirPath(String arg0)
  {
    AppMethodBeat.i(146601);
    if (TextUtils.isEmpty(???))
    {
      AppMethodBeat.o(146601);
      return;
    }
    if (!???.equalsIgnoreCase(mLogDir)) {
      mLogDir = ???;
    }
    synchronized (mLogLock)
    {
      if (mHasInit)
      {
        nativeLogClose();
        mHasInit = false;
        init();
      }
      a.a().b();
      AppMethodBeat.o(146601);
      return;
    }
  }
  
  public static void v(String paramString1, String paramString2)
  {
    AppMethodBeat.i(66086);
    log(0, paramString1, paramString2);
    AppMethodBeat.o(66086);
  }
  
  public static void w(String paramString1, String paramString2)
  {
    AppMethodBeat.i(66089);
    log(3, paramString1, paramString2);
    AppMethodBeat.o(66089);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.liteav.basic.log.TXCLog
 * JD-Core Version:    0.7.0.1
 */