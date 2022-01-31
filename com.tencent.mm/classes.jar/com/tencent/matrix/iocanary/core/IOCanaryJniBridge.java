package com.tencent.matrix.iocanary.core;

import java.util.ArrayList;

public class IOCanaryJniBridge
{
  private static b bot;
  private static boolean bou;
  private static boolean bov;
  
  public static void a(com.tencent.matrix.iocanary.a.a parama, b paramb)
  {
    com.tencent.matrix.d.b.v("Matrix.IOCanaryJniBridge", "install sIsTryInstall:%b", new Object[] { Boolean.valueOf(bou) });
    if (bou) {
      return;
    }
    if (!rb())
    {
      com.tencent.matrix.d.b.e("Matrix.IOCanaryJniBridge", "install loadJni failed", new Object[0]);
      return;
    }
    bot = paramb;
    if (parama != null) {}
    try
    {
      if (parama.ed(1))
      {
        enableDetector(0);
        setConfig(0, parama.boj * 1000L);
      }
      if (parama.ed(4))
      {
        enableDetector(1);
        setConfig(1, parama.bok);
      }
      if (parama.ed(2))
      {
        enableDetector(2);
        setConfig(2, parama.bom);
      }
      doHook();
      bou = true;
      return;
    }
    catch (Error parama)
    {
      com.tencent.matrix.d.b.printErrStackTrace("Matrix.IOCanaryJniBridge", parama, "call jni method error", new Object[0]);
    }
  }
  
  private static native boolean doHook();
  
  private static native boolean doUnHook();
  
  private static native void enableDetector(int paramInt);
  
  private static JavaContext getJavaContext()
  {
    try
    {
      JavaContext localJavaContext = new JavaContext(null);
      return localJavaContext;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.matrix.d.b.printErrStackTrace("Matrix.IOCanaryJniBridge", localThrowable, "get javacontext exception", new Object[0]);
    }
    return null;
  }
  
  public static void onIssuePublish(ArrayList<IOIssue> paramArrayList)
  {
    if (bot == null) {
      return;
    }
    bot.z(paramArrayList);
  }
  
  public static void ra()
  {
    if (!bou) {
      return;
    }
    doUnHook();
    bou = false;
  }
  
  private static boolean rb()
  {
    if (bov) {
      return true;
    }
    try
    {
      System.loadLibrary("io-canary");
      bov = true;
      return true;
    }
    catch (Exception localException)
    {
      com.tencent.matrix.d.b.e("Matrix.IOCanaryJniBridge", "hook: e: %s", new Object[] { localException.getLocalizedMessage() });
      bov = false;
    }
    return false;
  }
  
  private static native void setConfig(int paramInt, long paramLong);
  
  private static final class ConfigKey
  {
    static final int MAIN_THREAD_THRESHOLD = 0;
    static final int REPEAT_READ_THRESHOLD = 2;
    static final int SMALL_BUFFER_THRESHOLD = 1;
  }
  
  private static final class DetectorType
  {
    static final int MAIN_THREAD_IO = 0;
    static final int REPEAT_READ = 2;
    static final int SMALL_BUFFER = 1;
  }
  
  private static final class JavaContext
  {
    private final String stack = com.tencent.matrix.iocanary.c.a.getThrowableStack(new Throwable());
    private final String threadName = Thread.currentThread().getName();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.matrix.iocanary.core.IOCanaryJniBridge
 * JD-Core Version:    0.7.0.1
 */