package com.tencent.mapsdk.internal;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.mapsdk.core.utils.cache.MemoryCache;
import com.tencent.mapsdk.core.utils.cache.MemoryCache.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.util.concurrent.atomic.AtomicInteger;

public final class gv$a
{
  private static final AtomicInteger b;
  private final MemoryCache<jp> a;
  
  static
  {
    AppMethodBeat.i(224773);
    b = new AtomicInteger();
    AppMethodBeat.o(224773);
  }
  
  public gv$a(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(224703);
    paramContext = mf.a(paramContext, null).c();
    if (js.a("4.4.7", "4.4.6")) {
      ka.a(new File(paramContext, "BitmapDescriptorCache"), new File(paramContext, "bitmaps"));
    }
    paramContext = new MemoryCache.a();
    paramContext.b = paramInt;
    paramContext.c = new jg.b()
    {
      private boolean a(jp paramAnonymousjp)
      {
        AppMethodBeat.i(221883);
        if (paramAnonymousjp != null)
        {
          String str = paramAnonymousjp.f;
          if ((paramAnonymousjp.f()) && (str != null)) {
            gv.a.a(gv.a.this).a(str);
          }
        }
        AppMethodBeat.o(221883);
        return true;
      }
    };
    this.a = ((MemoryCache)jk.a(jp.class, new jg.a[] { paramContext }));
    a();
    AppMethodBeat.o(224703);
  }
  
  public static void a()
  {
    AppMethodBeat.i(224716);
    if (b.get() < 0) {
      b.set(0);
    }
    b.incrementAndGet();
    AppMethodBeat.o(224716);
  }
  
  /* Error */
  private void a(String paramString, jp paramjp)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 109
    //   4: invokestatic 22	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: ldc 111
    //   9: new 113	java/lang/StringBuilder
    //   12: dup
    //   13: ldc 115
    //   15: invokespecial 118	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   18: aload_1
    //   19: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: ldc 124
    //   24: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: aload_2
    //   28: getfield 128	com/tencent/mapsdk/internal/jp:f	Ljava/lang/String;
    //   31: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: ldc 130
    //   36: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: aload_2
    //   40: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   43: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   46: invokestatic 142	com/tencent/mapsdk/internal/kh:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   49: aload_0
    //   50: getfield 93	com/tencent/mapsdk/internal/gv$a:a	Lcom/tencent/mapsdk/core/utils/cache/MemoryCache;
    //   53: aload_1
    //   54: ldc 82
    //   56: invokevirtual 145	com/tencent/mapsdk/core/utils/cache/MemoryCache:a	(Ljava/lang/String;Ljava/lang/Class;)Lcom/tencent/mapsdk/internal/jh;
    //   59: checkcast 82	com/tencent/mapsdk/internal/jp
    //   62: astore_3
    //   63: aload_3
    //   64: ifnull +57 -> 121
    //   67: ldc 111
    //   69: new 113	java/lang/StringBuilder
    //   72: dup
    //   73: ldc 147
    //   75: invokespecial 118	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   78: aload_1
    //   79: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: ldc 124
    //   84: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: aload_3
    //   88: getfield 128	com/tencent/mapsdk/internal/jp:f	Ljava/lang/String;
    //   91: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: ldc 149
    //   96: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: aload_3
    //   100: invokevirtual 153	com/tencent/mapsdk/internal/jp:g	()Z
    //   103: invokevirtual 156	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   106: ldc 130
    //   108: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: aload_3
    //   112: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   115: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   118: invokestatic 142	com/tencent/mapsdk/internal/kh:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   121: aload_3
    //   122: ifnull +60 -> 182
    //   125: aload_3
    //   126: invokevirtual 153	com/tencent/mapsdk/internal/jp:g	()Z
    //   129: ifne +53 -> 182
    //   132: aload_3
    //   133: getfield 128	com/tencent/mapsdk/internal/jp:f	Ljava/lang/String;
    //   136: invokestatic 162	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   139: ifne +43 -> 182
    //   142: aload_3
    //   143: getfield 128	com/tencent/mapsdk/internal/jp:f	Ljava/lang/String;
    //   146: aload_2
    //   147: getfield 128	com/tencent/mapsdk/internal/jp:f	Ljava/lang/String;
    //   150: invokevirtual 168	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   153: ifeq +29 -> 182
    //   156: ldc 111
    //   158: ldc 170
    //   160: aload_1
    //   161: invokestatic 174	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   164: invokevirtual 178	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   167: invokestatic 142	com/tencent/mapsdk/internal/kh:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   170: aload_3
    //   171: invokevirtual 181	com/tencent/mapsdk/internal/jp:e	()V
    //   174: ldc 109
    //   176: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   179: aload_0
    //   180: monitorexit
    //   181: return
    //   182: aload_0
    //   183: getfield 93	com/tencent/mapsdk/internal/gv$a:a	Lcom/tencent/mapsdk/core/utils/cache/MemoryCache;
    //   186: aload_1
    //   187: aload_2
    //   188: invokeinterface 186 3 0
    //   193: ldc 109
    //   195: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   198: goto -19 -> 179
    //   201: astore_1
    //   202: aload_0
    //   203: monitorexit
    //   204: aload_1
    //   205: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	206	0	this	a
    //   0	206	1	paramString	String
    //   0	206	2	paramjp	jp
    //   62	109	3	localjp	jp
    // Exception table:
    //   from	to	target	type
    //   2	63	201	finally
    //   67	121	201	finally
    //   125	179	201	finally
    //   182	198	201	finally
  }
  
  public static int b()
  {
    AppMethodBeat.i(224724);
    int i = b.get();
    AppMethodBeat.o(224724);
    return i;
  }
  
  /* Error */
  public final Bitmap a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 189
    //   4: invokestatic 22	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 93	com/tencent/mapsdk/internal/gv$a:a	Lcom/tencent/mapsdk/core/utils/cache/MemoryCache;
    //   11: aload_1
    //   12: ldc 82
    //   14: invokeinterface 191 3 0
    //   19: checkcast 82	com/tencent/mapsdk/internal/jp
    //   22: astore_1
    //   23: aload_1
    //   24: ifnull +17 -> 41
    //   27: aload_1
    //   28: invokevirtual 194	com/tencent/mapsdk/internal/jp:c	()Landroid/graphics/Bitmap;
    //   31: astore_1
    //   32: ldc 189
    //   34: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   37: aload_0
    //   38: monitorexit
    //   39: aload_1
    //   40: areturn
    //   41: aconst_null
    //   42: astore_1
    //   43: ldc 189
    //   45: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   48: goto -11 -> 37
    //   51: astore_1
    //   52: aload_0
    //   53: monitorexit
    //   54: aload_1
    //   55: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	56	0	this	a
    //   0	56	1	paramString	String
    // Exception table:
    //   from	to	target	type
    //   2	23	51	finally
    //   27	37	51	finally
    //   43	48	51	finally
  }
  
  public final void a(String paramString, Bitmap paramBitmap)
  {
    try
    {
      AppMethodBeat.i(224799);
      a(paramString, new jp(paramBitmap));
      AppMethodBeat.o(224799);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  /* Error */
  public final boolean b(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 203
    //   4: invokestatic 22	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 93	com/tencent/mapsdk/internal/gv$a:a	Lcom/tencent/mapsdk/core/utils/cache/MemoryCache;
    //   11: aload_1
    //   12: ldc 82
    //   14: invokevirtual 145	com/tencent/mapsdk/core/utils/cache/MemoryCache:a	(Ljava/lang/String;Ljava/lang/Class;)Lcom/tencent/mapsdk/internal/jh;
    //   17: checkcast 82	com/tencent/mapsdk/internal/jp
    //   20: astore_3
    //   21: aload_3
    //   22: ifnull +60 -> 82
    //   25: aload_3
    //   26: invokevirtual 205	com/tencent/mapsdk/internal/jp:f	()Z
    //   29: ifeq +53 -> 82
    //   32: ldc 111
    //   34: new 113	java/lang/StringBuilder
    //   37: dup
    //   38: ldc 207
    //   40: invokespecial 118	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   43: aload_1
    //   44: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: ldc 130
    //   49: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: aload_3
    //   53: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   56: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   59: invokestatic 142	com/tencent/mapsdk/internal/kh:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   62: aload_0
    //   63: getfield 93	com/tencent/mapsdk/internal/gv$a:a	Lcom/tencent/mapsdk/core/utils/cache/MemoryCache;
    //   66: aload_1
    //   67: invokevirtual 209	com/tencent/mapsdk/core/utils/cache/MemoryCache:a	(Ljava/lang/String;)Z
    //   70: pop
    //   71: iconst_1
    //   72: istore_2
    //   73: ldc 203
    //   75: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   78: aload_0
    //   79: monitorexit
    //   80: iload_2
    //   81: ireturn
    //   82: iconst_0
    //   83: istore_2
    //   84: ldc 203
    //   86: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   89: goto -11 -> 78
    //   92: astore_1
    //   93: aload_0
    //   94: monitorexit
    //   95: aload_1
    //   96: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	97	0	this	a
    //   0	97	1	paramString	String
    //   72	12	2	bool	boolean
    //   20	33	3	localjp	jp
    // Exception table:
    //   from	to	target	type
    //   2	21	92	finally
    //   25	71	92	finally
    //   73	78	92	finally
    //   84	89	92	finally
  }
  
  public final void c()
  {
    try
    {
      AppMethodBeat.i(224785);
      if ((b.get() <= 0) || (b.decrementAndGet() == 0)) {
        this.a.j();
      }
      AppMethodBeat.o(224785);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.gv.a
 * JD-Core Version:    0.7.0.1
 */