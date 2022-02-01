package com.tencent.matrix.jectl;

import androidx.annotation.Keep;
import com.tencent.matrix.e.c;

public class JeCtl
{
  private static boolean initialized = false;
  
  static
  {
    try
    {
      System.loadLibrary("matrix-jectl");
      initNative();
      initialized = true;
      return;
    }
    catch (Throwable localThrowable)
    {
      c.printErrStackTrace("Matrix.JeCtl", localThrowable, "", new Object[0]);
    }
  }
  
  @Keep
  private static native int compactNative();
  
  @Keep
  private static native String getVersionNative();
  
  @Keep
  private static native void initNative();
  
  @Keep
  private static native int preAllocRetainNative(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  @Keep
  public static native boolean setRetain(boolean paramBoolean);
  
  /* Error */
  public static String version()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 12	com/tencent/matrix/jectl/JeCtl:initialized	Z
    //   6: ifne +22 -> 28
    //   9: ldc 25
    //   11: ldc 49
    //   13: iconst_0
    //   14: anewarray 4	java/lang/Object
    //   17: invokestatic 53	com/tencent/matrix/e/c:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   20: ldc 55
    //   22: astore_0
    //   23: ldc 2
    //   25: monitorexit
    //   26: aload_0
    //   27: areturn
    //   28: invokestatic 57	com/tencent/matrix/jectl/JeCtl:getVersionNative	()Ljava/lang/String;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.matrix.jectl.JeCtl
 * JD-Core Version:    0.7.0.1
 */