package com.tencent.magicbrush.handler;

import android.support.annotation.Keep;
import com.tencent.magicbrush.a.d.a;
import java.lang.ref.WeakReference;

@Keep
public class MBJavaHandler
{
  private static WeakReference<c> mCallbackProxy;
  
  @Keep
  public static String decodeString(byte[] paramArrayOfByte, String paramString)
  {
    return d.decodeString(paramArrayOfByte, paramString);
  }
  
  @Keep
  public static byte[] encodeString(String paramString1, String paramString2)
  {
    return d.encodeString(paramString1, paramString2);
  }
  
  /* Error */
  @Keep
  public static void onScreenCanvasContextTypeSet(boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 28	com/tencent/magicbrush/handler/MBJavaHandler:mCallbackProxy	Ljava/lang/ref/WeakReference;
    //   6: ifnull +14 -> 20
    //   9: getstatic 28	com/tencent/magicbrush/handler/MBJavaHandler:mCallbackProxy	Ljava/lang/ref/WeakReference;
    //   12: invokevirtual 34	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   15: astore_1
    //   16: aload_1
    //   17: ifnonnull +7 -> 24
    //   20: ldc 2
    //   22: monitorexit
    //   23: return
    //   24: getstatic 28	com/tencent/magicbrush/handler/MBJavaHandler:mCallbackProxy	Ljava/lang/ref/WeakReference;
    //   27: invokevirtual 34	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   30: checkcast 36	com/tencent/magicbrush/handler/c
    //   33: iload_0
    //   34: invokeinterface 38 2 0
    //   39: goto -19 -> 20
    //   42: astore_1
    //   43: ldc 2
    //   45: monitorexit
    //   46: aload_1
    //   47: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	48	0	paramBoolean	boolean
    //   15	2	1	localObject1	Object
    //   42	5	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   3	16	42	finally
    //   24	39	42	finally
  }
  
  /* Error */
  @Keep
  public static void onShaderCompileError(String paramString)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 28	com/tencent/magicbrush/handler/MBJavaHandler:mCallbackProxy	Ljava/lang/ref/WeakReference;
    //   6: ifnull +14 -> 20
    //   9: getstatic 28	com/tencent/magicbrush/handler/MBJavaHandler:mCallbackProxy	Ljava/lang/ref/WeakReference;
    //   12: invokevirtual 34	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   15: astore_1
    //   16: aload_1
    //   17: ifnonnull +7 -> 24
    //   20: ldc 2
    //   22: monitorexit
    //   23: return
    //   24: getstatic 28	com/tencent/magicbrush/handler/MBJavaHandler:mCallbackProxy	Ljava/lang/ref/WeakReference;
    //   27: invokevirtual 34	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   30: checkcast 36	com/tencent/magicbrush/handler/c
    //   33: aload_0
    //   34: invokeinterface 42 2 0
    //   39: goto -19 -> 20
    //   42: astore_0
    //   43: ldc 2
    //   45: monitorexit
    //   46: aload_0
    //   47: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	48	0	paramString	String
    //   15	2	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	16	42	finally
    //   24	39	42	finally
  }
  
  @Keep
  public static void printConsole(int paramInt, String paramString)
  {
    d.a.f(paramInt, paramString);
  }
  
  public static void setCallbackProxy(c paramc)
  {
    mCallbackProxy = new WeakReference(paramc);
  }
  
  /* Error */
  @Keep
  public static void v8_exception(String paramString1, String paramString2, long paramLong)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 28	com/tencent/magicbrush/handler/MBJavaHandler:mCallbackProxy	Ljava/lang/ref/WeakReference;
    //   6: ifnull +16 -> 22
    //   9: getstatic 28	com/tencent/magicbrush/handler/MBJavaHandler:mCallbackProxy	Ljava/lang/ref/WeakReference;
    //   12: invokevirtual 34	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   15: astore 4
    //   17: aload 4
    //   19: ifnonnull +7 -> 26
    //   22: ldc 2
    //   24: monitorexit
    //   25: return
    //   26: getstatic 28	com/tencent/magicbrush/handler/MBJavaHandler:mCallbackProxy	Ljava/lang/ref/WeakReference;
    //   29: invokevirtual 34	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   32: checkcast 36	com/tencent/magicbrush/handler/c
    //   35: aload_0
    //   36: aload_1
    //   37: lload_2
    //   38: l2i
    //   39: invokeinterface 60 4 0
    //   44: goto -22 -> 22
    //   47: astore_0
    //   48: ldc 2
    //   50: monitorexit
    //   51: aload_0
    //   52: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	53	0	paramString1	String
    //   0	53	1	paramString2	String
    //   0	53	2	paramLong	long
    //   15	3	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	17	47	finally
    //   26	44	47	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.magicbrush.handler.MBJavaHandler
 * JD-Core Version:    0.7.0.1
 */