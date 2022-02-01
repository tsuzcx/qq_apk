package com.tencent.matrix.jectl;

import com.tencent.matrix.e.c;

public class JeCtl
{
  private static boolean initialized = false;
  
  static
  {
    try
    {
      com.tencent.mm.hellhoundlib.b.a locala = new com.tencent.mm.hellhoundlib.b.a().cG("matrix-jectl");
      Object localObject = new Object();
      com.tencent.mm.hellhoundlib.a.a.b(localObject, locala.aYi(), "com/tencent/matrix/jectl/JeCtl", "<clinit>", "()V", "java/lang/System_EXEC_", "loadLibrary", "(Ljava/lang/String;)V");
      System.loadLibrary((String)locala.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/matrix/jectl/JeCtl", "<clinit>", "()V", "java/lang/System_EXEC_", "loadLibrary", "(Ljava/lang/String;)V");
      initNative();
      initialized = true;
      return;
    }
    finally
    {
      c.printErrStackTrace("Matrix.JeCtl", localThrowable, "", new Object[0]);
    }
  }
  
  private static native int compactNative();
  
  private static native String getVersionNative();
  
  private static native void initNative();
  
  private static native int preAllocRetainNative(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public static native boolean setRetain(boolean paramBoolean);
  
  /* Error */
  public static String version()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 10	com/tencent/matrix/jectl/JeCtl:initialized	Z
    //   6: ifne +22 -> 28
    //   9: ldc 60
    //   11: ldc 80
    //   13: iconst_0
    //   14: anewarray 4	java/lang/Object
    //   17: invokestatic 84	com/tencent/matrix/e/c:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   20: ldc 86
    //   22: astore_0
    //   23: ldc 2
    //   25: monitorexit
    //   26: aload_0
    //   27: areturn
    //   28: invokestatic 88	com/tencent/matrix/jectl/JeCtl:getVersionNative	()Ljava/lang/String;
    //   31: astore_0
    //   32: goto -9 -> 23
    //   35: astore_0
    //   36: ldc 2
    //   38: monitorexit
    //   39: aload_0
    //   40: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   22	10	0	str	String
    //   35	5	0	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	20	35	finally
    //   28	32	35	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.matrix.jectl.JeCtl
 * JD-Core Version:    0.7.0.1
 */