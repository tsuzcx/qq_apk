package coil.memory;

import androidx.b.e;
import coil.b.d;
import coil.util.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcoil/memory/RealStrongMemoryCache;", "Lcoil/memory/StrongMemoryCache;", "weakMemoryCache", "Lcoil/memory/WeakMemoryCache;", "referenceCounter", "Lcoil/bitmap/BitmapReferenceCounter;", "maxSize", "", "logger", "Lcoil/util/Logger;", "(Lcoil/memory/WeakMemoryCache;Lcoil/bitmap/BitmapReferenceCounter;ILcoil/util/Logger;)V", "cache", "coil/memory/RealStrongMemoryCache$cache$1", "Lcoil/memory/RealStrongMemoryCache$cache$1;", "getMaxSize", "()I", "size", "getSize", "clearMemory", "", "get", "Lcoil/memory/RealMemoryCache$Value;", "key", "Lcoil/memory/MemoryCache$Key;", "remove", "", "set", "bitmap", "Landroid/graphics/Bitmap;", "isSampled", "trimMemory", "level", "Companion", "InternalValue", "coil-base_release"}, k=1, mv={1, 5, 1}, xi=48)
final class o
  implements r
{
  public static final o.a cox;
  private final u clU;
  private final k cli;
  private final d cnQ;
  private final c coy;
  
  static
  {
    AppMethodBeat.i(188322);
    cox = new o.a((byte)0);
    AppMethodBeat.o(188322);
  }
  
  public o(u paramu, d paramd, final int paramInt, k paramk)
  {
    AppMethodBeat.i(188288);
    this.clU = paramu;
    this.cnQ = paramd;
    this.cli = paramk;
    this.coy = new c(this, paramInt);
    AppMethodBeat.o(188288);
  }
  
  private void MV()
  {
    try
    {
      AppMethodBeat.i(188299);
      this.coy.trimToSize(-1);
      AppMethodBeat.o(188299);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final n.a a(MemoryCache.Key paramKey)
  {
    try
    {
      AppMethodBeat.i(188330);
      s.u(paramKey, "key");
      paramKey = (n.a)this.coy.get(paramKey);
      AppMethodBeat.o(188330);
      return paramKey;
    }
    finally
    {
      paramKey = finally;
      throw paramKey;
    }
  }
  
  /* Error */
  public final void a(MemoryCache.Key paramKey, android.graphics.Bitmap paramBitmap, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 126
    //   4: invokestatic 74	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_1
    //   8: ldc 119
    //   10: invokestatic 92	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   13: aload_2
    //   14: ldc 127
    //   16: invokestatic 92	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   19: aload_2
    //   20: invokestatic 133	coil/util/a:t	(Landroid/graphics/Bitmap;)I
    //   23: istore 4
    //   25: iload 4
    //   27: aload_0
    //   28: getfield 107	coil/memory/o:coy	Lcoil/memory/o$c;
    //   31: invokevirtual 135	coil/memory/o$c:maxSize	()I
    //   34: if_icmple +39 -> 73
    //   37: aload_0
    //   38: getfield 107	coil/memory/o:coy	Lcoil/memory/o$c;
    //   41: aload_1
    //   42: invokevirtual 137	coil/memory/o$c:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   45: checkcast 10	coil/memory/o$b
    //   48: ifnonnull +17 -> 65
    //   51: aload_0
    //   52: getfield 98	coil/memory/o:clU	Lcoil/memory/u;
    //   55: aload_1
    //   56: aload_2
    //   57: iload_3
    //   58: iload 4
    //   60: invokeinterface 142 5 0
    //   65: ldc 126
    //   67: invokestatic 83	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   70: aload_0
    //   71: monitorexit
    //   72: return
    //   73: aload_0
    //   74: getfield 100	coil/memory/o:cnQ	Lcoil/b/d;
    //   77: aload_2
    //   78: invokeinterface 148 2 0
    //   83: aload_0
    //   84: getfield 107	coil/memory/o:coy	Lcoil/memory/o$c;
    //   87: aload_1
    //   88: new 10	coil/memory/o$b
    //   91: dup
    //   92: aload_2
    //   93: iload_3
    //   94: iload 4
    //   96: invokespecial 151	coil/memory/o$b:<init>	(Landroid/graphics/Bitmap;ZI)V
    //   99: invokevirtual 155	coil/memory/o$c:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   102: pop
    //   103: ldc 126
    //   105: invokestatic 83	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   108: goto -38 -> 70
    //   111: astore_1
    //   112: aload_0
    //   113: monitorexit
    //   114: aload_1
    //   115: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	116	0	this	o
    //   0	116	1	paramKey	MemoryCache.Key
    //   0	116	2	paramBitmap	android.graphics.Bitmap
    //   0	116	3	paramBoolean	boolean
    //   23	72	4	i	int
    // Exception table:
    //   from	to	target	type
    //   2	65	111	finally
    //   65	70	111	finally
    //   73	108	111	finally
  }
  
  /* Error */
  public final void trimMemory(int paramInt)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aload_0
    //   3: monitorenter
    //   4: ldc 156
    //   6: invokestatic 74	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_0
    //   10: getfield 102	coil/memory/o:cli	Lcoil/util/k;
    //   13: astore 4
    //   15: aload 4
    //   17: ifnull +24 -> 41
    //   20: aload 4
    //   22: invokeinterface 161 1 0
    //   27: iconst_2
    //   28: if_icmpgt +13 -> 41
    //   31: ldc 163
    //   33: iload_1
    //   34: invokestatic 169	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   37: invokestatic 173	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   40: pop
    //   41: iload_1
    //   42: bipush 40
    //   44: if_icmplt +15 -> 59
    //   47: aload_0
    //   48: invokespecial 175	coil/memory/o:MV	()V
    //   51: ldc 156
    //   53: invokestatic 83	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   56: aload_0
    //   57: monitorexit
    //   58: return
    //   59: iload_3
    //   60: istore_2
    //   61: bipush 10
    //   63: iload_1
    //   64: if_icmpgt +13 -> 77
    //   67: iload_3
    //   68: istore_2
    //   69: iload_1
    //   70: bipush 20
    //   72: if_icmpge +5 -> 77
    //   75: iconst_1
    //   76: istore_2
    //   77: iload_2
    //   78: ifeq +19 -> 97
    //   81: aload_0
    //   82: getfield 107	coil/memory/o:coy	Lcoil/memory/o$c;
    //   85: aload_0
    //   86: getfield 107	coil/memory/o:coy	Lcoil/memory/o$c;
    //   89: invokevirtual 177	coil/memory/o$c:size	()I
    //   92: iconst_2
    //   93: idiv
    //   94: invokevirtual 112	coil/memory/o$c:trimToSize	(I)V
    //   97: ldc 156
    //   99: invokestatic 83	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   102: goto -46 -> 56
    //   105: astore 4
    //   107: aload_0
    //   108: monitorexit
    //   109: aload 4
    //   111: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	112	0	this	o
    //   0	112	1	paramInt	int
    //   60	18	2	i	int
    //   1	67	3	j	int
    //   13	8	4	localk	k
    //   105	5	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   4	15	105	finally
    //   20	41	105	finally
    //   47	56	105	finally
    //   81	97	105	finally
    //   97	102	105	finally
  }
  
  @Metadata(d1={""}, d2={"coil/memory/RealStrongMemoryCache$cache$1", "Landroidx/collection/LruCache;", "Lcoil/memory/MemoryCache$Key;", "Lcoil/memory/RealStrongMemoryCache$InternalValue;", "entryRemoved", "", "evicted", "", "key", "oldValue", "newValue", "sizeOf", "", "value", "coil-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    extends e<MemoryCache.Key, o.b>
  {
    c(o paramo, int paramInt)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     coil.memory.o
 * JD-Core Version:    0.7.0.1
 */