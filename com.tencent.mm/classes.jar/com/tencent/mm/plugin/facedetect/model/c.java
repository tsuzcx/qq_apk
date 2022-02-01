package com.tencent.mm.plugin.facedetect.model;

import android.app.ActivityManager;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.memory.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;

public final class c
  extends a<byte[]>
{
  private static int miK;
  public static final c wwx;
  
  static
  {
    AppMethodBeat.i(103696);
    wwx = new c();
    miK = 0;
    AppMethodBeat.o(103696);
  }
  
  public static void dE(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(103686);
    Log.i("MicroMsg.FaceByteArrayPool", "preloadCameraData, width: %s, height: %s, count: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(5) });
    long l = Util.currentTicks();
    int i = 0;
    while (i < 5)
    {
      wwx.as(new byte[paramInt1 * paramInt2 * 3 / 2]);
      i += 1;
    }
    Log.i("MicroMsg.FaceByteArrayPool", "preloadCameraData used %sms", new Object[] { Long.valueOf(Util.ticksToNow(l)) });
    AppMethodBeat.o(103686);
  }
  
  public final void as(byte[] paramArrayOfByte)
  {
    try
    {
      AppMethodBeat.i(103687);
      super.bU(paramArrayOfByte);
      AppMethodBeat.o(103687);
      return;
    }
    finally
    {
      paramArrayOfByte = finally;
      throw paramArrayOfByte;
    }
  }
  
  public final long baJ()
  {
    AppMethodBeat.i(103689);
    if (miK <= 0) {
      miK = ((ActivityManager)MMApplicationContext.getContext().getSystemService("activity")).getLargeMemoryClass();
    }
    if (miK >= 512)
    {
      AppMethodBeat.o(103689);
      return 20971520L;
    }
    AppMethodBeat.o(103689);
    return 10485760L;
  }
  
  public final long baK()
  {
    return 20971520L;
  }
  
  public final void baL()
  {
    AppMethodBeat.i(103690);
    super.baL();
    AppMethodBeat.o(103690);
  }
  
  /* Error */
  public final byte[] k(Integer paramInteger)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 138
    //   4: invokestatic 18	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: aload_1
    //   9: invokespecial 140	com/tencent/mm/memory/a:h	(Ljava/lang/Integer;)Ljava/lang/Object;
    //   12: checkcast 79	[B
    //   15: astore_2
    //   16: aload_2
    //   17: ifnonnull +26 -> 43
    //   20: ldc 35
    //   22: ldc 142
    //   24: invokestatic 146	com/tencent/mm/sdk/platformtools/Log:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   27: aload_1
    //   28: invokevirtual 125	java/lang/Integer:intValue	()I
    //   31: newarray byte
    //   33: astore_1
    //   34: ldc 138
    //   36: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   39: aload_0
    //   40: monitorexit
    //   41: aload_1
    //   42: areturn
    //   43: ldc 35
    //   45: ldc 148
    //   47: invokestatic 146	com/tencent/mm/sdk/platformtools/Log:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   50: aload_2
    //   51: astore_1
    //   52: goto -18 -> 34
    //   55: astore_1
    //   56: aload_0
    //   57: monitorexit
    //   58: aload_1
    //   59: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	60	0	this	c
    //   0	60	1	paramInteger	Integer
    //   15	36	2	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   2	16	55	finally
    //   20	34	55	finally
    //   34	39	55	finally
    //   43	50	55	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.model.c
 * JD-Core Version:    0.7.0.1
 */