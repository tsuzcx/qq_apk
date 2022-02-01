package com.bumptech.glide.load.b.a;

import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public final class j
  implements b
{
  private final h<a, Object> aIk;
  private final b aIt;
  private final Map<Class<?>, NavigableMap<Integer, Integer>> aIu;
  private final Map<Class<?>, a<?>> aIv;
  private int currentSize;
  private final int maxSize;
  
  public j()
  {
    AppMethodBeat.i(77099);
    this.aIk = new h();
    this.aIt = new b();
    this.aIu = new HashMap();
    this.aIv = new HashMap();
    this.maxSize = 4194304;
    AppMethodBeat.o(77099);
  }
  
  public j(int paramInt)
  {
    AppMethodBeat.i(77100);
    this.aIk = new h();
    this.aIt = new b();
    this.aIu = new HashMap();
    this.aIv = new HashMap();
    this.maxSize = paramInt;
    AppMethodBeat.o(77100);
  }
  
  private <T> a<T> V(T paramT)
  {
    AppMethodBeat.i(77111);
    paramT = q(paramT.getClass());
    AppMethodBeat.o(77111);
    return paramT;
  }
  
  private <T> T a(a parama)
  {
    AppMethodBeat.i(77105);
    parama = this.aIk.b(parama);
    AppMethodBeat.o(77105);
    return parama;
  }
  
  private <T> T a(a parama, Class<T> paramClass)
  {
    AppMethodBeat.i(77104);
    a locala = q(paramClass);
    Object localObject = a(parama);
    if (localObject != null)
    {
      this.currentSize -= locala.U(localObject) * locala.oY();
      b(locala.U(localObject), paramClass);
    }
    paramClass = localObject;
    if (localObject == null)
    {
      if (Log.isLoggable(locala.getTag(), 2))
      {
        locala.getTag();
        new StringBuilder("Allocated ").append(parama.size).append(" bytes");
      }
      paramClass = locala.di(parama.size);
    }
    AppMethodBeat.o(77104);
    return paramClass;
  }
  
  private void b(int paramInt, Class<?> paramClass)
  {
    AppMethodBeat.i(77109);
    paramClass = p(paramClass);
    Integer localInteger = (Integer)paramClass.get(Integer.valueOf(paramInt));
    if (localInteger == null)
    {
      paramClass = new NullPointerException("Tried to decrement empty size, size: " + paramInt + ", this: " + this);
      AppMethodBeat.o(77109);
      throw paramClass;
    }
    if (localInteger.intValue() == 1)
    {
      paramClass.remove(Integer.valueOf(paramInt));
      AppMethodBeat.o(77109);
      return;
    }
    paramClass.put(Integer.valueOf(paramInt), Integer.valueOf(localInteger.intValue() - 1));
    AppMethodBeat.o(77109);
  }
  
  private void dj(int paramInt)
  {
    AppMethodBeat.i(77108);
    while (this.currentSize > paramInt)
    {
      Object localObject = this.aIk.removeLast();
      com.bumptech.glide.g.j.checkNotNull(localObject, "Argument must not be null");
      a locala = V(localObject);
      this.currentSize -= locala.U(localObject) * locala.oY();
      b(locala.U(localObject), localObject.getClass());
      if (Log.isLoggable(locala.getTag(), 2))
      {
        locala.getTag();
        new StringBuilder("evicted: ").append(locala.U(localObject));
      }
    }
    AppMethodBeat.o(77108);
  }
  
  private NavigableMap<Integer, Integer> p(Class<?> paramClass)
  {
    AppMethodBeat.i(77110);
    NavigableMap localNavigableMap = (NavigableMap)this.aIu.get(paramClass);
    Object localObject = localNavigableMap;
    if (localNavigableMap == null)
    {
      localObject = new TreeMap();
      this.aIu.put(paramClass, localObject);
    }
    AppMethodBeat.o(77110);
    return localObject;
  }
  
  private <T> a<T> q(Class<T> paramClass)
  {
    AppMethodBeat.i(77112);
    a locala = (a)this.aIv.get(paramClass);
    Object localObject = locala;
    if (locala == null) {
      if (!paramClass.equals([I.class)) {
        break label61;
      }
    }
    for (localObject = new i();; localObject = new g())
    {
      this.aIv.put(paramClass, localObject);
      AppMethodBeat.o(77112);
      return localObject;
      label61:
      if (!paramClass.equals([B.class)) {
        break;
      }
    }
    paramClass = new IllegalArgumentException("No array pool found for: " + paramClass.getSimpleName());
    AppMethodBeat.o(77112);
    throw paramClass;
  }
  
  public final <T> T a(int paramInt, Class<T> paramClass)
  {
    int k = 1;
    label148:
    for (;;)
    {
      try
      {
        AppMethodBeat.i(77103);
        Object localObject = (Integer)p(paramClass).ceilingKey(Integer.valueOf(paramInt));
        if (localObject != null)
        {
          if (this.currentSize == 0) {
            break label148;
          }
          if (this.maxSize / this.currentSize >= 2)
          {
            break label148;
            j = k;
            if (i == 0)
            {
              if (((Integer)localObject).intValue() <= paramInt * 8) {
                j = k;
              }
            }
            else
            {
              if (j == 0) {
                continue;
              }
              localObject = this.aIt.d(((Integer)localObject).intValue(), paramClass);
              paramClass = a((a)localObject, paramClass);
              AppMethodBeat.o(77103);
              return paramClass;
            }
          }
          else
          {
            i = 0;
            continue;
          }
        }
        int j = 0;
        continue;
        localObject = this.aIt.d(paramInt, paramClass);
        continue;
        int i = 1;
      }
      finally {}
    }
  }
  
  public final <T> T o(Class<T> paramClass)
  {
    try
    {
      AppMethodBeat.i(77102);
      paramClass = a(this.aIt.d(8, paramClass), paramClass);
      AppMethodBeat.o(77102);
      return paramClass;
    }
    finally
    {
      paramClass = finally;
      throw paramClass;
    }
  }
  
  public final void oZ()
  {
    try
    {
      AppMethodBeat.i(77106);
      dj(0);
      AppMethodBeat.o(77106);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final <T> void put(T paramT)
  {
    for (;;)
    {
      int i;
      try
      {
        AppMethodBeat.i(77101);
        Object localObject2 = paramT.getClass();
        Object localObject1 = q((Class)localObject2);
        int k = ((a)localObject1).U(paramT);
        int j = k * ((a)localObject1).oY();
        if (j <= this.maxSize / 2)
        {
          i = 1;
          if (i == 0) {
            AppMethodBeat.o(77101);
          }
        }
        else
        {
          i = 0;
          continue;
        }
        localObject1 = this.aIt.d(k, (Class)localObject2);
        this.aIk.a((m)localObject1, paramT);
        paramT = p((Class)localObject2);
        localObject2 = (Integer)paramT.get(Integer.valueOf(((a)localObject1).size));
        k = ((a)localObject1).size;
        if (localObject2 == null)
        {
          i = 1;
          paramT.put(Integer.valueOf(k), Integer.valueOf(i));
          this.currentSize += j;
          dj(this.maxSize);
          AppMethodBeat.o(77101);
          continue;
        }
        i = ((Integer)localObject2).intValue();
      }
      finally {}
      i += 1;
    }
  }
  
  /* Error */
  public final void trimMemory(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 252
    //   4: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: iload_1
    //   8: bipush 40
    //   10: if_icmplt +15 -> 25
    //   13: aload_0
    //   14: invokevirtual 254	com/bumptech/glide/load/b/a/j:oZ	()V
    //   17: ldc 252
    //   19: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   22: aload_0
    //   23: monitorexit
    //   24: return
    //   25: iload_1
    //   26: bipush 20
    //   28: if_icmpge +9 -> 37
    //   31: iload_1
    //   32: bipush 15
    //   34: if_icmpne +13 -> 47
    //   37: aload_0
    //   38: aload_0
    //   39: getfield 54	com/bumptech/glide/load/b/a/j:maxSize	I
    //   42: iconst_2
    //   43: idiv
    //   44: invokespecial 244	com/bumptech/glide/load/b/a/j:dj	(I)V
    //   47: ldc 252
    //   49: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   52: goto -30 -> 22
    //   55: astore_2
    //   56: aload_0
    //   57: monitorexit
    //   58: aload_2
    //   59: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	60	0	this	j
    //   0	60	1	paramInt	int
    //   55	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	55	finally
    //   13	22	55	finally
    //   37	47	55	finally
    //   47	52	55	finally
  }
  
  static final class a
    implements m
  {
    private final j.b aIw;
    private Class<?> aIx;
    int size;
    
    a(j.b paramb)
    {
      this.aIw = paramb;
    }
    
    final void c(int paramInt, Class<?> paramClass)
    {
      this.size = paramInt;
      this.aIx = paramClass;
    }
    
    public final boolean equals(Object paramObject)
    {
      boolean bool2 = false;
      boolean bool1 = bool2;
      if ((paramObject instanceof a))
      {
        paramObject = (a)paramObject;
        bool1 = bool2;
        if (this.size == paramObject.size)
        {
          bool1 = bool2;
          if (this.aIx == paramObject.aIx) {
            bool1 = true;
          }
        }
      }
      return bool1;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(77096);
      int j = this.size;
      if (this.aIx != null) {}
      for (int i = this.aIx.hashCode();; i = 0)
      {
        AppMethodBeat.o(77096);
        return i + j * 31;
      }
    }
    
    public final void pb()
    {
      AppMethodBeat.i(77095);
      this.aIw.a(this);
      AppMethodBeat.o(77095);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(77094);
      String str = "Key{size=" + this.size + "array=" + this.aIx + '}';
      AppMethodBeat.o(77094);
      return str;
    }
  }
  
  static final class b
    extends d<j.a>
  {
    final j.a d(int paramInt, Class<?> paramClass)
    {
      AppMethodBeat.i(77097);
      j.a locala = (j.a)pd();
      locala.c(paramInt, paramClass);
      AppMethodBeat.o(77097);
      return locala;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.bumptech.glide.load.b.a.j
 * JD-Core Version:    0.7.0.1
 */