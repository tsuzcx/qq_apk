package com.tencent.mm.plugin.facedetect.model;

import android.app.ActivityManager;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.memory.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;

public final class c
  extends a<byte[]>
{
  private static int fYn;
  public static final c mhN;
  
  static
  {
    AppMethodBeat.i(171);
    mhN = new c();
    fYn = 0;
    AppMethodBeat.o(171);
  }
  
  public static void ek(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(161);
    ab.i("MicroMsg.FaceByteArrayPool", "preloadCameraData, width: %s, height: %s, count: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(5) });
    long l = bo.yB();
    int i = 0;
    while (i < 5)
    {
      mhN.O(new byte[paramInt1 * paramInt2 * 3 / 2]);
      i += 1;
    }
    ab.i("MicroMsg.FaceByteArrayPool", "preloadCameraData used %sms", new Object[] { Long.valueOf(bo.av(l)) });
    AppMethodBeat.o(161);
  }
  
  public final void O(byte[] paramArrayOfByte)
  {
    try
    {
      AppMethodBeat.i(162);
      super.aG(paramArrayOfByte);
      AppMethodBeat.o(162);
      return;
    }
    finally
    {
      paramArrayOfByte = finally;
      throw paramArrayOfByte;
    }
  }
  
  public final long XH()
  {
    AppMethodBeat.i(164);
    if (fYn <= 0) {
      fYn = ((ActivityManager)ah.getContext().getSystemService("activity")).getLargeMemoryClass();
    }
    if (fYn >= 512)
    {
      AppMethodBeat.o(164);
      return 20971520L;
    }
    AppMethodBeat.o(164);
    return 10485760L;
  }
  
  public final long XI()
  {
    return 20971520L;
  }
  
  public final void XJ()
  {
    AppMethodBeat.i(165);
    super.XJ();
    AppMethodBeat.o(165);
  }
  
  /* Error */
  public final byte[] f(Integer paramInteger)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: sipush 163
    //   5: invokestatic 17	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: aload_1
    //   10: invokespecial 126	com/tencent/mm/memory/a:c	(Ljava/lang/Integer;)Ljava/lang/Object;
    //   13: checkcast 104	[B
    //   16: astore_2
    //   17: aload_2
    //   18: ifnonnull +27 -> 45
    //   21: ldc 33
    //   23: ldc 128
    //   25: invokestatic 132	com/tencent/mm/sdk/platformtools/ab:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   28: aload_1
    //   29: invokevirtual 122	java/lang/Integer:intValue	()I
    //   32: newarray byte
    //   34: astore_1
    //   35: sipush 163
    //   38: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   41: aload_0
    //   42: monitorexit
    //   43: aload_1
    //   44: areturn
    //   45: ldc 33
    //   47: ldc 134
    //   49: invokestatic 132	com/tencent/mm/sdk/platformtools/ab:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   52: aload_2
    //   53: astore_1
    //   54: goto -19 -> 35
    //   57: astore_1
    //   58: aload_0
    //   59: monitorexit
    //   60: aload_1
    //   61: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	62	0	this	c
    //   0	62	1	paramInteger	Integer
    //   16	37	2	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   2	17	57	finally
    //   21	35	57	finally
    //   35	41	57	finally
    //   45	52	57	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.model.c
 * JD-Core Version:    0.7.0.1
 */