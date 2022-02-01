package com.tencent.matrix.fd;

import com.tencent.matrix.e.c;

public class FDDumpBridge
{
  private static boolean initialized;
  
  static
  {
    try
    {
      com.tencent.mm.hellhoundlib.b.a locala = new com.tencent.mm.hellhoundlib.b.a().cG("matrix-fd");
      Object localObject = new Object();
      com.tencent.mm.hellhoundlib.a.a.b(localObject, locala.aYi(), "com/tencent/matrix/fd/FDDumpBridge", "<clinit>", "()V", "java/lang/System_EXEC_", "loadLibrary", "(Ljava/lang/String;)V");
      System.loadLibrary((String)locala.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/matrix/fd/FDDumpBridge", "<clinit>", "()V", "java/lang/System_EXEC_", "loadLibrary", "(Ljava/lang/String;)V");
      initialized = true;
      return;
    }
    finally
    {
      c.printErrStackTrace("FDDumpBridge", localThrowable, "", new Object[0]);
      initialized = false;
    }
  }
  
  public static String gC(String paramString)
  {
    if (!initialized) {
      return paramString;
    }
    return getFdPathNameNative(paramString);
  }
  
  public static native int getFDLimit();
  
  public static native String getFdPathNameNative(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.matrix.fd.FDDumpBridge
 * JD-Core Version:    0.7.0.1
 */