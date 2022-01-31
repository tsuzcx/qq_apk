package com.tencent.mm.memory;

import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;

public final class c
  extends a<Bitmap>
{
  private static int fdA;
  public static final c fdB;
  
  static
  {
    AppMethodBeat.i(115369);
    fdA = 20971520;
    fdB = new c();
    AppMethodBeat.o(115369);
  }
  
  private c()
  {
    AppMethodBeat.i(115355);
    int i = ((ActivityManager)ah.getContext().getSystemService("activity")).getLargeMemoryClass();
    ab.i("MicroMsg.BitmapPool", "BitmapPool %dMB", new Object[] { Integer.valueOf(i) });
    if (i > 256) {
      fdA = 20971520;
    }
    for (;;)
    {
      Do();
      AppMethodBeat.o(115355);
      return;
      if (i > 128) {
        fdA = 10485760;
      } else {
        fdA = 5242880;
      }
    }
  }
  
  protected static Integer d(Integer paramInteger)
  {
    AppMethodBeat.i(115356);
    int i = paramInteger.intValue();
    AppMethodBeat.o(115356);
    return Integer.valueOf(i * 4);
  }
  
  private static Integer s(Bitmap paramBitmap)
  {
    AppMethodBeat.i(115358);
    if (paramBitmap == null)
    {
      AppMethodBeat.o(115358);
      return Integer.valueOf(0);
    }
    if (d.fw(19)) {}
    for (int i = paramBitmap.getByteCount();; i = paramBitmap.getAllocationByteCount())
    {
      AppMethodBeat.o(115358);
      return Integer.valueOf(i);
    }
  }
  
  protected final long XH()
  {
    return fdA;
  }
  
  protected final long XI()
  {
    return 1048576L;
  }
  
  public final void XJ()
  {
    AppMethodBeat.i(115360);
    super.XJ();
    AppMethodBeat.o(115360);
  }
  
  /* Error */
  public final Bitmap e(Integer paramInteger)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 135
    //   4: invokestatic 18	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: aload_1
    //   9: invokespecial 137	com/tencent/mm/memory/a:b	(Ljava/lang/Integer;)Ljava/lang/Object;
    //   12: checkcast 91	android/graphics/Bitmap
    //   15: astore_2
    //   16: aload_2
    //   17: ifnull +17 -> 34
    //   20: aload_2
    //   21: invokevirtual 141	android/graphics/Bitmap:isRecycled	()Z
    //   24: ifne +10 -> 34
    //   27: aload_2
    //   28: invokevirtual 144	android/graphics/Bitmap:isMutable	()Z
    //   31: ifne +14 -> 45
    //   34: aconst_null
    //   35: astore_1
    //   36: ldc 135
    //   38: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   41: aload_0
    //   42: monitorexit
    //   43: aload_1
    //   44: areturn
    //   45: ldc 54
    //   47: ldc 146
    //   49: iconst_5
    //   50: anewarray 58	java/lang/Object
    //   53: dup
    //   54: iconst_0
    //   55: aload_2
    //   56: aastore
    //   57: dup
    //   58: iconst_1
    //   59: aload_2
    //   60: invokevirtual 149	android/graphics/Bitmap:getWidth	()I
    //   63: invokestatic 64	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   66: aastore
    //   67: dup
    //   68: iconst_2
    //   69: aload_2
    //   70: invokevirtual 152	android/graphics/Bitmap:getHeight	()I
    //   73: invokestatic 64	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   76: aastore
    //   77: dup
    //   78: iconst_3
    //   79: aload_2
    //   80: invokestatic 125	com/tencent/mm/memory/c:s	(Landroid/graphics/Bitmap;)Ljava/lang/Integer;
    //   83: aastore
    //   84: dup
    //   85: iconst_4
    //   86: aload_1
    //   87: aastore
    //   88: invokestatic 154	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   91: ldc 135
    //   93: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   96: aload_2
    //   97: astore_1
    //   98: goto -57 -> 41
    //   101: astore_1
    //   102: aload_0
    //   103: monitorexit
    //   104: aload_1
    //   105: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	106	0	this	c
    //   0	106	1	paramInteger	Integer
    //   15	82	2	localBitmap	Bitmap
    // Exception table:
    //   from	to	target	type
    //   2	16	101	finally
    //   20	34	101	finally
    //   36	41	101	finally
    //   45	96	101	finally
  }
  
  public final void t(Bitmap paramBitmap)
  {
    try
    {
      AppMethodBeat.i(115359);
      if ((paramBitmap != null) && (paramBitmap.isMutable()) && (!paramBitmap.isRecycled()))
      {
        ab.i("MicroMsg.BitmapPool", "release: %s", new Object[] { paramBitmap });
        super.aG(paramBitmap);
      }
      AppMethodBeat.o(115359);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.memory.c
 * JD-Core Version:    0.7.0.1
 */