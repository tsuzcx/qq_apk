package com.tencent.liteav.basic.log;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.liteav.basic.util.TXCCommonUtil;
import com.tencent.liteav.basic.util.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;

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
  private static String mLogCacheDir;
  public static String mLogDir;
  private static int mLogLevel;
  private static final Object mLogLock;
  
  static
  {
    AppMethodBeat.i(14780);
    mLogDir = "";
    mLogCacheDir = "";
    mEnableCompress = true;
    mLogLock = new Object();
    mHasInit = false;
    mListener = null;
    mLogLevel = 0;
    mEnableConsole = true;
    mEnableCallback = false;
    AppMethodBeat.o(14780);
  }
  
  public static void d(String paramString1, String paramString2)
  {
    AppMethodBeat.i(14775);
    log(1, paramString1, paramString2);
    AppMethodBeat.o(14775);
  }
  
  public static void d(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(222129);
    log(1, paramString1, String.format(paramString2, paramVarArgs));
    AppMethodBeat.o(222129);
  }
  
  public static void e(String paramString1, String paramString2)
  {
    AppMethodBeat.i(14778);
    log(4, paramString1, paramString2);
    AppMethodBeat.o(14778);
  }
  
  public static void e(String paramString1, String paramString2, Throwable paramThrowable)
  {
    AppMethodBeat.i(222133);
    StringWriter localStringWriter = new StringWriter();
    PrintWriter localPrintWriter = new PrintWriter(localStringWriter);
    paramThrowable.printStackTrace(localPrintWriter);
    for (paramThrowable = paramThrowable.getCause(); paramThrowable != null; paramThrowable = paramThrowable.getCause()) {
      paramThrowable.printStackTrace(localPrintWriter);
    }
    localPrintWriter.close();
    e(paramString1, paramString2 + "\n" + localStringWriter.toString());
    AppMethodBeat.o(222133);
  }
  
  public static void e(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(222132);
    log(4, paramString1, String.format(paramString2, paramVarArgs));
    AppMethodBeat.o(222132);
  }
  
  public static void i(String paramString1, String paramString2)
  {
    AppMethodBeat.i(14776);
    log(2, paramString1, paramString2);
    AppMethodBeat.o(14776);
  }
  
  public static void i(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(222130);
    log(2, paramString1, String.format(paramString2, paramVarArgs));
    AppMethodBeat.o(222130);
  }
  
  public static boolean init()
  {
    AppMethodBeat.i(14766);
    if (mHasInit)
    {
      AppMethodBeat.o(14766);
      return true;
    }
    synchronized (mLogLock)
    {
      if (mHasInit)
      {
        AppMethodBeat.o(14766);
        return true;
      }
      boolean bool = f.f();
      Context localContext = TXCCommonUtil.getAppContext();
      if ((bool) && (localContext != null))
      {
        if (TextUtils.isEmpty(mLogDir))
        {
          File localFile = localContext.getExternalFilesDir(null);
          if (localFile != null) {
            mLogDir = localFile.getAbsolutePath() + "/log/tencent/liteav";
          }
        }
        mLogCacheDir = localContext.getFilesDir().getAbsolutePath() + "/log/tencent/liteav";
        new StringBuilder("TXCLog init log file path : ").append(mLogDir).append(", cache : ").append(mLogCacheDir);
        nativeLogInit();
        nativeLogSetLevel(mLogLevel);
        nativeLogSetConsole(mEnableConsole);
        nativeLogOpen(0, mLogDir, mLogCacheDir, "LiteAV", mEnableCompress);
        nativeEnableCallback(mEnableCallback);
        mHasInit = true;
      }
      bool = mHasInit;
      AppMethodBeat.o(14766);
      return bool;
    }
  }
  
  public static void log(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(14767);
    if (init()) {
      nativeLog(paramInt, paramString1, "", 0, "", paramString2);
    }
    log_callback(paramInt, paramString1, paramString2);
    AppMethodBeat.o(14767);
  }
  
  private static void log_callback(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(14779);
    if (mListener != null) {
      mListener.a(paramInt, paramString1, paramString2);
    }
    AppMethodBeat.o(14779);
  }
  
  private static native void nativeEnableCallback(boolean paramBoolean);
  
  private static native void nativeLog(int paramInt1, String paramString1, String paramString2, int paramInt2, String paramString3, String paramString4);
  
  private static native void nativeLogClose();
  
  private static native void nativeLogInit();
  
  private static native void nativeLogOpen(int paramInt, String paramString1, String paramString2, String paramString3, boolean paramBoolean);
  
  private static native void nativeLogSetConsole(boolean paramBoolean);
  
  private static native void nativeLogSetLevel(int paramInt);
  
  public static void setConsoleEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(14772);
    mEnableConsole = paramBoolean;
    if (mHasInit) {
      nativeLogSetConsole(mEnableConsole);
    }
    AppMethodBeat.o(14772);
  }
  
  public static void setLevel(int paramInt)
  {
    AppMethodBeat.i(14768);
    mLogLevel = paramInt;
    if (mHasInit) {
      nativeLogSetLevel(mLogLevel);
    }
    AppMethodBeat.o(14768);
  }
  
  public static void setListener(TXCLog.a parama)
  {
    AppMethodBeat.i(14773);
    mListener = parama;
    if (parama != null) {}
    for (boolean bool = true;; bool = false)
    {
      mEnableCallback = bool;
      if (mHasInit) {
        nativeEnableCallback(mEnableCallback);
      }
      AppMethodBeat.o(14773);
      return;
    }
  }
  
  public static void setLogCompressEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(14771);
    if (mEnableCompress != paramBoolean)
    {
      mEnableCompress = paramBoolean;
      if (mHasInit)
      {
        nativeLogClose();
        nativeLogOpen(0, mLogDir, mLogCacheDir, "LiteAV", mEnableCompress);
      }
    }
    AppMethodBeat.o(14771);
  }
  
  public static void setLogDirPath(String paramString)
  {
    AppMethodBeat.i(14769);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(14769);
      return;
    }
    if (!paramString.equalsIgnoreCase(mLogDir))
    {
      mLogDir = paramString;
      if (mHasInit)
      {
        nativeLogClose();
        nativeLogOpen(0, mLogDir, mLogCacheDir, "LiteAV", mEnableCompress);
      }
    }
    AppMethodBeat.o(14769);
  }
  
  public static void sliceLogFile()
  {
    AppMethodBeat.i(14770);
    if (mHasInit) {
      nativeLogOpen(0, mLogDir, mLogCacheDir, "LiteAV", mEnableCompress);
    }
    AppMethodBeat.o(14770);
  }
  
  public static void v(String paramString1, String paramString2)
  {
    AppMethodBeat.i(14774);
    log(0, paramString1, paramString2);
    AppMethodBeat.o(14774);
  }
  
  public static void v(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(222128);
    log(0, paramString1, String.format(paramString2, paramVarArgs));
    AppMethodBeat.o(222128);
  }
  
  public static void w(String paramString1, String paramString2)
  {
    AppMethodBeat.i(14777);
    log(3, paramString1, paramString2);
    AppMethodBeat.o(14777);
  }
  
  public static void w(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(222131);
    log(3, paramString1, String.format(paramString2, paramVarArgs));
    AppMethodBeat.o(222131);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.liteav.basic.log.TXCLog
 * JD-Core Version:    0.7.0.1
 */