package com.tencent.map.lib.util;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedHashMap;

public class b
{
  private static LinkedHashMap<String, b.a> a;
  
  static
  {
    AppMethodBeat.i(98245);
    a = new LinkedHashMap();
    AppMethodBeat.o(98245);
  }
  
  public static Bitmap a(String paramString)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(98242);
        if (a == null)
        {
          AppMethodBeat.o(98242);
          paramString = null;
          return paramString;
        }
        paramString = (b.a)a.get(paramString);
        if (paramString != null)
        {
          paramString = paramString.b;
          AppMethodBeat.o(98242);
          continue;
        }
        AppMethodBeat.o(98242);
      }
      finally {}
      paramString = null;
    }
  }
  
  public static void a()
  {
    try
    {
      AppMethodBeat.i(98244);
      if (a != null) {
        a.clear();
      }
      AppMethodBeat.o(98244);
      return;
    }
    finally {}
  }
  
  /* Error */
  public static void a(String paramString, Bitmap paramBitmap)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 45
    //   5: invokestatic 18	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: getstatic 25	com/tencent/map/lib/util/b:a	Ljava/util/LinkedHashMap;
    //   11: ifnonnull +13 -> 24
    //   14: new 20	java/util/LinkedHashMap
    //   17: dup
    //   18: invokespecial 23	java/util/LinkedHashMap:<init>	()V
    //   21: putstatic 25	com/tencent/map/lib/util/b:a	Ljava/util/LinkedHashMap;
    //   24: getstatic 25	com/tencent/map/lib/util/b:a	Ljava/util/LinkedHashMap;
    //   27: aload_0
    //   28: invokevirtual 49	java/util/LinkedHashMap:containsKey	(Ljava/lang/Object;)Z
    //   31: ifeq +33 -> 64
    //   34: getstatic 25	com/tencent/map/lib/util/b:a	Ljava/util/LinkedHashMap;
    //   37: aload_0
    //   38: invokevirtual 35	java/util/LinkedHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   41: checkcast 6	com/tencent/map/lib/util/b$a
    //   44: astore_0
    //   45: aload_0
    //   46: aload_0
    //   47: getfield 52	com/tencent/map/lib/util/b$a:a	I
    //   50: iconst_1
    //   51: iadd
    //   52: putfield 52	com/tencent/map/lib/util/b$a:a	I
    //   55: ldc 45
    //   57: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   60: ldc 2
    //   62: monitorexit
    //   63: return
    //   64: new 6	com/tencent/map/lib/util/b$a
    //   67: dup
    //   68: invokespecial 53	com/tencent/map/lib/util/b$a:<init>	()V
    //   71: astore_2
    //   72: aload_2
    //   73: aload_1
    //   74: putfield 39	com/tencent/map/lib/util/b$a:b	Landroid/graphics/Bitmap;
    //   77: aload_2
    //   78: iconst_1
    //   79: putfield 52	com/tencent/map/lib/util/b$a:a	I
    //   82: getstatic 25	com/tencent/map/lib/util/b:a	Ljava/util/LinkedHashMap;
    //   85: aload_0
    //   86: aload_2
    //   87: invokevirtual 57	java/util/LinkedHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   90: pop
    //   91: ldc 45
    //   93: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   96: goto -36 -> 60
    //   99: astore_0
    //   100: ldc 2
    //   102: monitorexit
    //   103: aload_0
    //   104: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	105	0	paramString	String
    //   0	105	1	paramBitmap	Bitmap
    //   71	16	2	locala	b.a
    // Exception table:
    //   from	to	target	type
    //   3	24	99	finally
    //   24	60	99	finally
    //   64	96	99	finally
  }
  
  /* Error */
  public static void b(String paramString)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 59
    //   5: invokestatic 18	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: getstatic 25	com/tencent/map/lib/util/b:a	Ljava/util/LinkedHashMap;
    //   11: ifnonnull +12 -> 23
    //   14: ldc 59
    //   16: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   19: ldc 2
    //   21: monitorexit
    //   22: return
    //   23: getstatic 25	com/tencent/map/lib/util/b:a	Ljava/util/LinkedHashMap;
    //   26: aload_0
    //   27: invokevirtual 35	java/util/LinkedHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   30: checkcast 6	com/tencent/map/lib/util/b$a
    //   33: astore_1
    //   34: aload_1
    //   35: ifnull +56 -> 91
    //   38: aload_1
    //   39: aload_1
    //   40: getfield 52	com/tencent/map/lib/util/b$a:a	I
    //   43: iconst_1
    //   44: isub
    //   45: putfield 52	com/tencent/map/lib/util/b$a:a	I
    //   48: aload_1
    //   49: getfield 52	com/tencent/map/lib/util/b$a:a	I
    //   52: ifgt +39 -> 91
    //   55: getstatic 25	com/tencent/map/lib/util/b:a	Ljava/util/LinkedHashMap;
    //   58: aload_0
    //   59: invokevirtual 62	java/util/LinkedHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   62: pop
    //   63: getstatic 67	android/os/Build$VERSION:SDK_INT	I
    //   66: bipush 10
    //   68: if_icmpgt +23 -> 91
    //   71: aload_1
    //   72: getfield 39	com/tencent/map/lib/util/b$a:b	Landroid/graphics/Bitmap;
    //   75: astore_0
    //   76: aload_0
    //   77: ifnull +14 -> 91
    //   80: aload_0
    //   81: invokevirtual 73	android/graphics/Bitmap:isRecycled	()Z
    //   84: ifne +7 -> 91
    //   87: aload_0
    //   88: invokevirtual 76	android/graphics/Bitmap:recycle	()V
    //   91: ldc 59
    //   93: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   96: goto -77 -> 19
    //   99: astore_0
    //   100: ldc 2
    //   102: monitorexit
    //   103: aload_0
    //   104: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	105	0	paramString	String
    //   33	39	1	locala	b.a
    // Exception table:
    //   from	to	target	type
    //   3	19	99	finally
    //   23	34	99	finally
    //   38	76	99	finally
    //   80	91	99	finally
    //   91	96	99	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.map.lib.util.b
 * JD-Core Version:    0.7.0.1
 */