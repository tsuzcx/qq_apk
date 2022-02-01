package com.tencent.matrix.iocanary.core;

import com.tencent.b.a.a.a;
import com.tencent.matrix.e.c;
import java.util.ArrayList;

public class IOCanaryJniBridge
{
  private static final String TAG = "Matrix.IOCanaryJniBridge";
  private static boolean sIsLoadJniLib;
  private static boolean sIsTryInstall;
  private static OnJniIssuePublishListener sOnIssuePublishListener;
  private byte _hellAccFlag_;
  
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
    finally
    {
      c.printErrStackTrace("Matrix.IOCanaryJniBridge", localThrowable, "get javacontext exception", new Object[0]);
    }
    return null;
  }
  
  public static void install(com.tencent.matrix.iocanary.a.a parama, OnJniIssuePublishListener paramOnJniIssuePublishListener)
  {
    c.v("Matrix.IOCanaryJniBridge", "install sIsTryInstall:%b", new Object[] { Boolean.valueOf(sIsTryInstall) });
    if (sIsTryInstall) {
      return;
    }
    if (!loadJni())
    {
      c.e("Matrix.IOCanaryJniBridge", "install loadJni failed", new Object[0]);
      return;
    }
    sOnIssuePublishListener = paramOnJniIssuePublishListener;
    if (parama != null) {}
    try
    {
      if (parama.axO())
      {
        enableDetector(0);
        setConfig(0, parama.eVt.L(a.a.ahal.name(), 500) * 1000L);
      }
      if (parama.axQ())
      {
        enableDetector(1);
        setConfig(1, parama.eVt.L(a.a.ahan.name(), 4096));
      }
      if (parama.axP())
      {
        enableDetector(2);
        setConfig(2, parama.eVt.L(a.a.ahaq.name(), 5));
      }
      doHook();
      sIsTryInstall = true;
      return;
    }
    catch (Error parama)
    {
      c.printErrStackTrace("Matrix.IOCanaryJniBridge", parama, "call jni method error", new Object[0]);
    }
  }
  
  private static boolean loadJni()
  {
    if (sIsLoadJniLib) {
      return true;
    }
    try
    {
      com.tencent.mm.hellhoundlib.b.a locala = new com.tencent.mm.hellhoundlib.b.a().cG("io-canary");
      Object localObject = new Object();
      com.tencent.mm.hellhoundlib.a.a.b(localObject, locala.aYi(), "com/tencent/matrix/iocanary/core/IOCanaryJniBridge", "loadJni", "()Z", "java/lang/System_EXEC_", "loadLibrary", "(Ljava/lang/String;)V");
      System.loadLibrary((String)locala.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/matrix/iocanary/core/IOCanaryJniBridge", "loadJni", "()Z", "java/lang/System_EXEC_", "loadLibrary", "(Ljava/lang/String;)V");
      sIsLoadJniLib = true;
      return true;
    }
    catch (Exception localException)
    {
      c.e("Matrix.IOCanaryJniBridge", "hook: e: %s", new Object[] { localException.getLocalizedMessage() });
      sIsLoadJniLib = false;
    }
    return false;
  }
  
  public static void onIssuePublish(ArrayList<IOIssue> paramArrayList)
  {
    if (sOnIssuePublishListener == null) {
      return;
    }
    sOnIssuePublishListener.onIssuePublish(paramArrayList);
  }
  
  private static native void setConfig(int paramInt, long paramLong);
  
  public static void uninstall()
  {
    if (!sIsTryInstall) {
      return;
    }
    doUnHook();
    sIsTryInstall = false;
  }
  
  static final class JavaContext
  {
    private final String stack = com.tencent.matrix.iocanary.c.a.getThrowableStack(new Throwable());
    private String threadName;
    
    private JavaContext()
    {
      if (Thread.currentThread() != null) {
        this.threadName = Thread.currentThread().getName();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.matrix.iocanary.core.IOCanaryJniBridge
 * JD-Core Version:    0.7.0.1
 */