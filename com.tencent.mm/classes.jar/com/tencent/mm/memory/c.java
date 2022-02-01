package com.tencent.mm.memory;

import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class c
  extends a<Bitmap>
{
  private static int nNj;
  public static final c nNk;
  
  static
  {
    AppMethodBeat.i(156415);
    nNj = 20971520;
    nNk = new c();
    AppMethodBeat.o(156415);
  }
  
  private c()
  {
    AppMethodBeat.i(156401);
    int i = ((ActivityManager)MMApplicationContext.getContext().getSystemService("activity")).getLargeMemoryClass();
    Log.i("MicroMsg.BitmapPool", "BitmapPool %dMB", new Object[] { Integer.valueOf(i) });
    if (i > 256) {
      nNj = 20971520;
    }
    for (;;)
    {
      aFB();
      AppMethodBeat.o(156401);
      return;
      if (i > 128) {
        nNj = 10485760;
      } else {
        nNj = 5242880;
      }
    }
  }
  
  private static Integer L(Bitmap paramBitmap)
  {
    AppMethodBeat.i(156404);
    if (paramBitmap == null)
    {
      AppMethodBeat.o(156404);
      return Integer.valueOf(0);
    }
    if (d.rc(19)) {}
    for (int i = paramBitmap.getByteCount();; i = paramBitmap.getAllocationByteCount())
    {
      AppMethodBeat.o(156404);
      return Integer.valueOf(i);
    }
  }
  
  protected static Integer i(Integer paramInteger)
  {
    AppMethodBeat.i(156402);
    int i = paramInteger.intValue();
    AppMethodBeat.o(156402);
    return Integer.valueOf(i * 4);
  }
  
  public final void M(Bitmap paramBitmap)
  {
    try
    {
      AppMethodBeat.i(156405);
      if ((paramBitmap != null) && (paramBitmap.isMutable()) && (!paramBitmap.isRecycled()))
      {
        Log.i("MicroMsg.BitmapPool", "release: %s", new Object[] { paramBitmap });
        super.dn(paramBitmap);
      }
      AppMethodBeat.o(156405);
      return;
    }
    finally {}
  }
  
  protected final long bvE()
  {
    return nNj;
  }
  
  protected final long bvF()
  {
    return 1048576L;
  }
  
  public final void bvG()
  {
    AppMethodBeat.i(156406);
    super.bvG();
    AppMethodBeat.o(156406);
  }
  
  /* Error */
  public final Bitmap j(Integer paramInteger)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 167
    //   4: invokestatic 18	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: aload_1
    //   9: invokespecial 169	com/tencent/mm/memory/a:g	(Ljava/lang/Integer;)Ljava/lang/Object;
    //   12: checkcast 85	android/graphics/Bitmap
    //   15: astore_2
    //   16: aload_2
    //   17: ifnull +17 -> 34
    //   20: aload_2
    //   21: invokevirtual 106	android/graphics/Bitmap:isRecycled	()Z
    //   24: ifne +10 -> 34
    //   27: aload_2
    //   28: invokevirtual 103	android/graphics/Bitmap:isMutable	()Z
    //   31: ifne +14 -> 45
    //   34: aconst_null
    //   35: astore_1
    //   36: ldc 167
    //   38: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   41: aload_0
    //   42: monitorexit
    //   43: aload_1
    //   44: areturn
    //   45: ldc 54
    //   47: ldc 171
    //   49: iconst_5
    //   50: anewarray 58	java/lang/Object
    //   53: dup
    //   54: iconst_0
    //   55: aload_2
    //   56: aastore
    //   57: dup
    //   58: iconst_1
    //   59: aload_2
    //   60: invokevirtual 174	android/graphics/Bitmap:getWidth	()I
    //   63: invokestatic 64	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   66: aastore
    //   67: dup
    //   68: iconst_2
    //   69: aload_2
    //   70: invokevirtual 177	android/graphics/Bitmap:getHeight	()I
    //   73: invokestatic 64	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   76: aastore
    //   77: dup
    //   78: iconst_3
    //   79: aload_2
    //   80: invokestatic 151	com/tencent/mm/memory/c:L	(Landroid/graphics/Bitmap;)Ljava/lang/Integer;
    //   83: aastore
    //   84: dup
    //   85: iconst_4
    //   86: aload_1
    //   87: aastore
    //   88: invokestatic 179	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   91: ldc 167
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.memory.c
 * JD-Core Version:    0.7.0.1
 */