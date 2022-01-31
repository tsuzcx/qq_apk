package com.tencent.liteav.basic.log;

import android.os.Environment;
import com.tencent.liteav.basic.util.a;
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
  private static boolean mHasInit;
  private static TXCLog.a mListener;
  private static final Object mLogLock = new Object();
  
  static
  {
    mHasInit = false;
    mListener = null;
    a.d();
  }
  
  public static void d(String paramString1, String paramString2)
  {
    log(1, paramString1, paramString2);
  }
  
  public static void e(String paramString1, String paramString2)
  {
    log(4, paramString1, paramString2);
  }
  
  public static void i(String paramString1, String paramString2)
  {
    log(2, paramString1, paramString2);
  }
  
  public static void init()
  {
    synchronized (mLogLock)
    {
      if (!mHasInit)
      {
        String str = Environment.getExternalStorageDirectory().getAbsolutePath() + "/log/tencent/liteav";
        nativeLogInit();
        nativeLogSetLevel(0);
        nativeLogSetConsole(true);
        nativeLogOpen(0, str, "LiteAV");
        mHasInit = true;
      }
      return;
    }
  }
  
  public static void log(int paramInt, String paramString1, String paramString2)
  {
    init();
    nativeLog(paramInt, paramString1, "", 0, "", paramString2);
    log_callback(paramInt, paramString1, paramString2);
  }
  
  private static void log_callback(int paramInt, String paramString1, String paramString2)
  {
    if (mListener != null) {
      mListener.a(paramInt, paramString1, paramString2);
    }
  }
  
  private static native void nativeLog(int paramInt1, String paramString1, String paramString2, int paramInt2, String paramString3, String paramString4);
  
  private static native void nativeLogClose();
  
  private static native void nativeLogInit();
  
  private static native void nativeLogOpen(int paramInt, String paramString1, String paramString2);
  
  private static native void nativeLogSetConsole(boolean paramBoolean);
  
  private static native void nativeLogSetLevel(int paramInt);
  
  public static void setConsoleEnabled(boolean paramBoolean)
  {
    init();
    nativeLogSetConsole(paramBoolean);
  }
  
  public static void setLevel(int paramInt)
  {
    init();
    nativeLogSetLevel(paramInt);
  }
  
  public static void setListener(TXCLog.a parama)
  {
    mListener = parama;
  }
  
  public static void v(String paramString1, String paramString2)
  {
    log(0, paramString1, paramString2);
  }
  
  public static void w(String paramString1, String paramString2)
  {
    log(3, paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.liteav.basic.log.TXCLog
 * JD-Core Version:    0.7.0.1
 */