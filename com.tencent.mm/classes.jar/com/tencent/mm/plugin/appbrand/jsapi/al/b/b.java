package com.tencent.mm.plugin.appbrand.jsapi.al.b;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.skia_canvas.SkiaCanvasView;
import java.lang.ref.WeakReference;

public final class b
{
  private static SparseArray<WeakReference<SkiaCanvasView>> sPb;
  
  static
  {
    AppMethodBeat.i(327044);
    sPb = new SparseArray();
    AppMethodBeat.o(327044);
  }
  
  /* Error */
  public static SkiaCanvasView BF(int paramInt)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 30
    //   5: invokestatic 16	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: getstatic 23	com/tencent/mm/plugin/appbrand/jsapi/al/b/b:sPb	Landroid/util/SparseArray;
    //   11: iload_0
    //   12: invokevirtual 34	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   15: ifnonnull +15 -> 30
    //   18: aconst_null
    //   19: astore_1
    //   20: ldc 30
    //   22: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   25: ldc 2
    //   27: monitorexit
    //   28: aload_1
    //   29: areturn
    //   30: getstatic 23	com/tencent/mm/plugin/appbrand/jsapi/al/b/b:sPb	Landroid/util/SparseArray;
    //   33: iload_0
    //   34: invokevirtual 34	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   37: checkcast 36	java/lang/ref/WeakReference
    //   40: invokevirtual 39	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   43: checkcast 41	com/tencent/xweb/skia_canvas/SkiaCanvasView
    //   46: astore_1
    //   47: ldc 30
    //   49: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   52: goto -27 -> 25
    //   55: astore_1
    //   56: ldc 2
    //   58: monitorexit
    //   59: aload_1
    //   60: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	61	0	paramInt	int
    //   19	28	1	localSkiaCanvasView	SkiaCanvasView
    //   55	5	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	18	55	finally
    //   20	25	55	finally
    //   30	52	55	finally
  }
  
  public static void a(int paramInt, SkiaCanvasView paramSkiaCanvasView)
  {
    try
    {
      AppMethodBeat.i(327029);
      com.tencent.mm.audio.mix.h.b.i("Luggage.SkiaCanvasViewManager", "put viewId:%d skiaCanvasView:%s", new Object[] { Integer.valueOf(paramInt), paramSkiaCanvasView });
      sPb.put(paramInt, new WeakReference(paramSkiaCanvasView));
      AppMethodBeat.o(327029);
      return;
    }
    finally
    {
      paramSkiaCanvasView = finally;
      throw paramSkiaCanvasView;
    }
  }
  
  /* Error */
  public static void remove(int paramInt)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 68
    //   5: invokestatic 16	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: iload_0
    //   9: invokestatic 70	com/tencent/mm/plugin/appbrand/jsapi/al/b/b:BF	(I)Lcom/tencent/xweb/skia_canvas/SkiaCanvasView;
    //   12: astore_1
    //   13: aload_1
    //   14: ifnull +41 -> 55
    //   17: getstatic 23	com/tencent/mm/plugin/appbrand/jsapi/al/b/b:sPb	Landroid/util/SparseArray;
    //   20: iload_0
    //   21: invokevirtual 72	android/util/SparseArray:remove	(I)V
    //   24: ldc 46
    //   26: ldc 74
    //   28: iconst_2
    //   29: anewarray 4	java/lang/Object
    //   32: dup
    //   33: iconst_0
    //   34: iload_0
    //   35: invokestatic 54	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   38: aastore
    //   39: dup
    //   40: iconst_1
    //   41: aload_1
    //   42: aastore
    //   43: invokestatic 59	com/tencent/mm/audio/mix/h/b:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   46: ldc 68
    //   48: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   51: ldc 2
    //   53: monitorexit
    //   54: return
    //   55: ldc 46
    //   57: ldc 76
    //   59: iconst_1
    //   60: anewarray 4	java/lang/Object
    //   63: dup
    //   64: iconst_0
    //   65: iload_0
    //   66: invokestatic 54	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   69: aastore
    //   70: invokestatic 59	com/tencent/mm/audio/mix/h/b:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   73: ldc 68
    //   75: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   78: goto -27 -> 51
    //   81: astore_1
    //   82: ldc 2
    //   84: monitorexit
    //   85: aload_1
    //   86: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	87	0	paramInt	int
    //   12	30	1	localSkiaCanvasView	SkiaCanvasView
    //   81	5	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	13	81	finally
    //   17	51	81	finally
    //   55	78	81	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.al.b.b
 * JD-Core Version:    0.7.0.1
 */