package com.tencent.mm.plugin.facedetect.model;

import android.app.ActivityManager;
import android.content.Context;
import com.tencent.mm.memory.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class c
  extends a<byte[]>
{
  private static int eIy = 0;
  public static final c jNB = new c();
  
  public static void cM(int paramInt1, int paramInt2)
  {
    y.i("MicroMsg.FaceByteArrayPool", "preloadCameraData, width: %s, height: %s, count: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(5) });
    long l = bk.UZ();
    int i = 0;
    while (i < 5)
    {
      jNB.z(new byte[paramInt1 * paramInt2 * 3 / 2]);
      i += 1;
    }
    y.i("MicroMsg.FaceByteArrayPool", "preloadCameraData used %sms", new Object[] { Long.valueOf(bk.cp(l)) });
  }
  
  protected final long ER()
  {
    if (eIy <= 0) {
      eIy = ((ActivityManager)ae.getContext().getSystemService("activity")).getLargeMemoryClass();
    }
    if (eIy >= 512) {
      return 20971520L;
    }
    return 10485760L;
  }
  
  protected final long ES()
  {
    return 20971520L;
  }
  
  public final void ET()
  {
    super.ET();
  }
  
  /* Error */
  public final byte[] f(Integer paramInteger)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_1
    //   4: invokespecial 119	com/tencent/mm/memory/a:c	(Ljava/lang/Integer;)Ljava/lang/Object;
    //   7: checkcast 94	[B
    //   10: astore_2
    //   11: aload_2
    //   12: ifnonnull +21 -> 33
    //   15: ldc 24
    //   17: ldc 121
    //   19: invokestatic 125	com/tencent/mm/sdk/platformtools/y:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   22: aload_1
    //   23: invokevirtual 107	java/lang/Integer:intValue	()I
    //   26: newarray byte
    //   28: astore_1
    //   29: aload_0
    //   30: monitorexit
    //   31: aload_1
    //   32: areturn
    //   33: ldc 24
    //   35: ldc 127
    //   37: invokestatic 125	com/tencent/mm/sdk/platformtools/y:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   40: aload_2
    //   41: astore_1
    //   42: goto -13 -> 29
    //   45: astore_1
    //   46: aload_0
    //   47: monitorexit
    //   48: aload_1
    //   49: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	50	0	this	c
    //   0	50	1	paramInteger	Integer
    //   10	31	2	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   2	11	45	finally
    //   15	29	45	finally
    //   33	40	45	finally
  }
  
  public final void z(byte[] paramArrayOfByte)
  {
    try
    {
      super.ar(paramArrayOfByte);
      return;
    }
    finally
    {
      paramArrayOfByte = finally;
      throw paramArrayOfByte;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.model.c
 * JD-Core Version:    0.7.0.1
 */