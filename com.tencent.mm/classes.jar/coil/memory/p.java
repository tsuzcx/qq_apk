package coil.memory;

import android.graphics.Bitmap;
import coil.util.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcoil/memory/RealWeakMemoryCache;", "Lcoil/memory/WeakMemoryCache;", "logger", "Lcoil/util/Logger;", "(Lcoil/util/Logger;)V", "cache", "Ljava/util/HashMap;", "Lcoil/memory/MemoryCache$Key;", "Ljava/util/ArrayList;", "Lcoil/memory/RealWeakMemoryCache$WeakValue;", "Lkotlin/collections/ArrayList;", "Lkotlin/collections/HashMap;", "getCache$coil_base_release$annotations", "()V", "getCache$coil_base_release", "()Ljava/util/HashMap;", "operationsSinceCleanUp", "", "getOperationsSinceCleanUp$coil_base_release$annotations", "getOperationsSinceCleanUp$coil_base_release", "()I", "setOperationsSinceCleanUp$coil_base_release", "(I)V", "cleanUp", "", "cleanUp$coil_base_release", "cleanUpIfNecessary", "clearMemory", "get", "Lcoil/memory/RealMemoryCache$Value;", "key", "remove", "", "bitmap", "Landroid/graphics/Bitmap;", "set", "isSampled", "size", "trimMemory", "level", "Companion", "StrongValue", "WeakValue", "coil-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class p
  implements u
{
  public static final p.a coB;
  private final HashMap<MemoryCache.Key, ArrayList<c>> cache;
  private int clW;
  private final k cli;
  
  static
  {
    AppMethodBeat.i(188327);
    coB = new p.a((byte)0);
    AppMethodBeat.o(188327);
  }
  
  public p(k paramk)
  {
    AppMethodBeat.i(188295);
    this.cli = paramk;
    this.cache = new HashMap();
    AppMethodBeat.o(188295);
  }
  
  private final void MH()
  {
    AppMethodBeat.i(188305);
    int i = this.clW;
    this.clW = (i + 1);
    if (i >= 10) {
      MI();
    }
    AppMethodBeat.o(188305);
  }
  
  private void MI()
  {
    AppMethodBeat.i(188318);
    this.clW = 0;
    Iterator localIterator = this.cache.values().iterator();
    Object localObject;
    label121:
    List localList;
    int n;
    int k;
    for (;;)
    {
      if (localIterator.hasNext())
      {
        localObject = localIterator.next();
        s.s(localObject, "iterator.next()");
        localObject = (ArrayList)localObject;
        if (((Collection)localObject).size() <= 1)
        {
          localObject = (c)kotlin.a.p.oL((List)localObject);
          if (localObject == null) {}
          for (localObject = null;; localObject = (Bitmap)((c)localObject).clY.get())
          {
            if (localObject != null) {
              break label121;
            }
            localIterator.remove();
            break;
          }
        }
        else
        {
          localList = (List)localObject;
          n = localList.size() - 1;
          if (n >= 0) {
            k = 0;
          }
        }
      }
    }
    int j;
    for (int i = 0;; i = j)
    {
      int m = k + 1;
      int i1 = k - i;
      if (((c)localList.get(i1)).clY.get() == null) {}
      for (k = 1;; k = 0)
      {
        j = i;
        if (k != 0)
        {
          localList.remove(i1);
          j = i + 1;
        }
        if (m <= n) {
          break label239;
        }
        if (!((ArrayList)localObject).isEmpty()) {
          break;
        }
        localIterator.remove();
        break;
      }
      AppMethodBeat.o(188318);
      return;
      label239:
      k = m;
    }
  }
  
  public final n.a a(MemoryCache.Key paramKey)
  {
    for (;;)
    {
      int i;
      int k;
      int j;
      Bitmap localBitmap;
      label102:
      try
      {
        AppMethodBeat.i(188339);
        s.u(paramKey, "key");
        paramKey = (ArrayList)this.cache.get(paramKey);
        if (paramKey == null)
        {
          AppMethodBeat.o(188339);
          paramKey = null;
          return paramKey;
        }
        List localList = (List)paramKey;
        i = 0;
        k = localList.size() - 1;
        if (k < 0) {
          break label147;
        }
        j = i + 1;
        paramKey = (c)localList.get(i);
        localBitmap = (Bitmap)paramKey.clY.get();
        if (localBitmap != null) {
          break label124;
        }
        paramKey = null;
      }
      finally {}
      MH();
      paramKey = (n.a)paramKey;
      AppMethodBeat.o(188339);
      continue;
      label124:
      paramKey = new p.b(localBitmap, paramKey.cmZ);
      label147:
      while (paramKey == null)
      {
        if (j > k)
        {
          paramKey = null;
          break label102;
        }
        i = j;
        break;
      }
    }
  }
  
  public final void a(MemoryCache.Key paramKey, Bitmap paramBitmap, boolean paramBoolean, int paramInt)
  {
    for (;;)
    {
      Object localObject1;
      int j;
      try
      {
        AppMethodBeat.i(188354);
        s.u(paramKey, "key");
        s.u(paramBitmap, "bitmap");
        Object localObject2 = (Map)this.cache;
        localObject1 = ((Map)localObject2).get(paramKey);
        if (localObject1 != null) {
          break label241;
        }
        localObject1 = new ArrayList();
        ((Map)localObject2).put(paramKey, localObject1);
        paramKey = (MemoryCache.Key)localObject1;
        paramKey = (ArrayList)paramKey;
        int k = System.identityHashCode(paramBitmap);
        localObject1 = new c(k, new WeakReference(paramBitmap), paramBoolean, paramInt);
        int m = paramKey.size() - 1;
        if (m >= 0)
        {
          i = 0;
          j = i + 1;
          localObject2 = paramKey.get(i);
          s.s(localObject2, "values[index]");
          localObject2 = (c)localObject2;
          if (paramInt >= ((c)localObject2).size)
          {
            if ((((c)localObject2).coC == k) && (((c)localObject2).clY.get() == paramBitmap))
            {
              paramKey.set(i, localObject1);
              MH();
              AppMethodBeat.o(188354);
              return;
            }
            paramKey.add(i, localObject1);
            continue;
          }
          if (j <= m) {
            break label234;
          }
        }
      }
      finally {}
      ((Collection)paramKey).add(localObject1);
      continue;
      label234:
      int i = j;
      continue;
      label241:
      paramKey = (MemoryCache.Key)localObject1;
    }
  }
  
  /* Error */
  public final boolean r(Bitmap paramBitmap)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 235
    //   4: invokestatic 79	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_1
    //   8: ldc 193
    //   10: invokestatic 176	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   13: aload_1
    //   14: invokestatic 207	java/lang/System:identityHashCode	(Ljava/lang/Object;)I
    //   17: istore 4
    //   19: aload_0
    //   20: checkcast 2	coil/memory/p
    //   23: getfield 100	coil/memory/p:cache	Ljava/util/HashMap;
    //   26: invokevirtual 112	java/util/HashMap:values	()Ljava/util/Collection;
    //   29: astore_1
    //   30: aload_1
    //   31: ldc 237
    //   33: invokestatic 136	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
    //   36: aload_1
    //   37: checkcast 239	java/lang/Iterable
    //   40: invokeinterface 240 1 0
    //   45: astore_1
    //   46: aload_1
    //   47: invokeinterface 124 1 0
    //   52: ifeq +86 -> 138
    //   55: aload_1
    //   56: invokeinterface 128 1 0
    //   61: checkcast 138	java/util/ArrayList
    //   64: astore 7
    //   66: aload 7
    //   68: invokevirtual 214	java/util/ArrayList:size	()I
    //   71: iconst_1
    //   72: isub
    //   73: istore 5
    //   75: iload 5
    //   77: iflt -31 -> 46
    //   80: iconst_0
    //   81: istore_2
    //   82: iload_2
    //   83: iconst_1
    //   84: iadd
    //   85: istore_3
    //   86: aload 7
    //   88: iload_2
    //   89: invokevirtual 215	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   92: checkcast 12	coil/memory/p$c
    //   95: getfield 222	coil/memory/p$c:coC	I
    //   98: iload 4
    //   100: if_icmpne +27 -> 127
    //   103: aload 7
    //   105: iload_2
    //   106: invokevirtual 241	java/util/ArrayList:remove	(I)Ljava/lang/Object;
    //   109: pop
    //   110: iconst_1
    //   111: istore 6
    //   113: aload_0
    //   114: invokespecial 181	coil/memory/p:MH	()V
    //   117: ldc 235
    //   119: invokestatic 88	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   122: aload_0
    //   123: monitorexit
    //   124: iload 6
    //   126: ireturn
    //   127: iload_3
    //   128: iload 5
    //   130: if_icmpgt -84 -> 46
    //   133: iload_3
    //   134: istore_2
    //   135: goto -53 -> 82
    //   138: iconst_0
    //   139: istore 6
    //   141: goto -28 -> 113
    //   144: astore_1
    //   145: aload_0
    //   146: monitorexit
    //   147: aload_1
    //   148: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	149	0	this	p
    //   0	149	1	paramBitmap	Bitmap
    //   81	54	2	i	int
    //   85	49	3	j	int
    //   17	84	4	k	int
    //   73	58	5	m	int
    //   111	29	6	bool	boolean
    //   64	40	7	localArrayList	ArrayList
    // Exception table:
    //   from	to	target	type
    //   2	46	144	finally
    //   46	75	144	finally
    //   86	110	144	finally
    //   113	122	144	finally
  }
  
  public final void trimMemory(int paramInt)
  {
    try
    {
      AppMethodBeat.i(188381);
      k localk = this.cli;
      if ((localk != null) && (localk.getLevel() <= 2)) {
        s.X("trimMemory, level=", Integer.valueOf(paramInt));
      }
      if ((paramInt >= 10) && (paramInt != 20)) {
        MI();
      }
      AppMethodBeat.o(188381);
      return;
    }
    finally {}
  }
  
  @Metadata(d1={""}, d2={"Lcoil/memory/RealWeakMemoryCache$WeakValue;", "", "identityHashCode", "", "bitmap", "Ljava/lang/ref/WeakReference;", "Landroid/graphics/Bitmap;", "isSampled", "", "size", "(ILjava/lang/ref/WeakReference;ZI)V", "getBitmap", "()Ljava/lang/ref/WeakReference;", "getIdentityHashCode", "()I", "()Z", "getSize", "coil-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
  {
    final WeakReference<Bitmap> clY;
    final boolean cmZ;
    final int coC;
    final int size;
    
    public c(int paramInt1, WeakReference<Bitmap> paramWeakReference, boolean paramBoolean, int paramInt2)
    {
      AppMethodBeat.i(188252);
      this.coC = paramInt1;
      this.clY = paramWeakReference;
      this.cmZ = paramBoolean;
      this.size = paramInt2;
      AppMethodBeat.o(188252);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     coil.memory.p
 * JD-Core Version:    0.7.0.1
 */