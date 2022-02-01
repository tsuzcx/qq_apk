package com.bumptech.glide.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class f<T, Y>
{
  private final long aGb;
  private long aGd;
  private final Map<T, Y> aLt;
  private long maxSize;
  
  public f(long paramLong)
  {
    AppMethodBeat.i(77749);
    this.aLt = new LinkedHashMap(100, 0.75F, true);
    this.aGb = paramLong;
    this.maxSize = paramLong;
    AppMethodBeat.o(77749);
  }
  
  protected int T(Y paramY)
  {
    return 1;
  }
  
  protected void d(T paramT, Y paramY) {}
  
  public final Y get(T paramT)
  {
    try
    {
      AppMethodBeat.i(77750);
      paramT = this.aLt.get(paramT);
      AppMethodBeat.o(77750);
      return paramT;
    }
    finally
    {
      paramT = finally;
      throw paramT;
    }
  }
  
  protected final void m(long paramLong)
  {
    try
    {
      AppMethodBeat.i(77754);
      while (this.aGd > paramLong)
      {
        Iterator localIterator = this.aLt.entrySet().iterator();
        Object localObject3 = (Map.Entry)localIterator.next();
        Object localObject2 = ((Map.Entry)localObject3).getValue();
        this.aGd -= T(localObject2);
        localObject3 = ((Map.Entry)localObject3).getKey();
        localIterator.remove();
        d(localObject3, localObject2);
      }
      AppMethodBeat.o(77754);
    }
    finally {}
  }
  
  public final void os()
  {
    AppMethodBeat.i(77753);
    m(0L);
    AppMethodBeat.o(77753);
  }
  
  public final long pP()
  {
    try
    {
      long l = this.maxSize;
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public final Y put(T paramT, Y paramY)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 99
    //   4: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: aload_2
    //   9: invokevirtual 82	com/bumptech/glide/h/f:T	(Ljava/lang/Object;)I
    //   12: istore_3
    //   13: iload_3
    //   14: i2l
    //   15: aload_0
    //   16: getfield 36	com/bumptech/glide/h/f:maxSize	J
    //   19: lcmp
    //   20: iflt +20 -> 40
    //   23: aload_0
    //   24: aload_1
    //   25: aload_2
    //   26: invokevirtual 90	com/bumptech/glide/h/f:d	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   29: aconst_null
    //   30: astore_1
    //   31: ldc 99
    //   33: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   36: aload_0
    //   37: monitorexit
    //   38: aload_1
    //   39: areturn
    //   40: aload_2
    //   41: ifnull +18 -> 59
    //   44: aload_0
    //   45: getfield 59	com/bumptech/glide/h/f:aGd	J
    //   48: lstore 4
    //   50: aload_0
    //   51: iload_3
    //   52: i2l
    //   53: lload 4
    //   55: ladd
    //   56: putfield 59	com/bumptech/glide/h/f:aGd	J
    //   59: aload_0
    //   60: getfield 32	com/bumptech/glide/h/f:aLt	Ljava/util/Map;
    //   63: aload_1
    //   64: aload_2
    //   65: invokeinterface 101 3 0
    //   70: astore 6
    //   72: aload 6
    //   74: ifnull +35 -> 109
    //   77: aload_0
    //   78: aload_0
    //   79: getfield 59	com/bumptech/glide/h/f:aGd	J
    //   82: aload_0
    //   83: aload 6
    //   85: invokevirtual 82	com/bumptech/glide/h/f:T	(Ljava/lang/Object;)I
    //   88: i2l
    //   89: lsub
    //   90: putfield 59	com/bumptech/glide/h/f:aGd	J
    //   93: aload 6
    //   95: aload_2
    //   96: invokevirtual 105	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   99: ifne +10 -> 109
    //   102: aload_0
    //   103: aload_1
    //   104: aload 6
    //   106: invokevirtual 90	com/bumptech/glide/h/f:d	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   109: aload_0
    //   110: aload_0
    //   111: getfield 36	com/bumptech/glide/h/f:maxSize	J
    //   114: invokevirtual 94	com/bumptech/glide/h/f:m	(J)V
    //   117: ldc 99
    //   119: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   122: aload 6
    //   124: astore_1
    //   125: goto -89 -> 36
    //   128: astore_1
    //   129: aload_0
    //   130: monitorexit
    //   131: aload_1
    //   132: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	133	0	this	f
    //   0	133	1	paramT	T
    //   0	133	2	paramY	Y
    //   12	40	3	i	int
    //   48	6	4	l	long
    //   70	53	6	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	29	128	finally
    //   31	36	128	finally
    //   44	59	128	finally
    //   59	72	128	finally
    //   77	109	128	finally
    //   109	122	128	finally
  }
  
  public final Y remove(T paramT)
  {
    try
    {
      AppMethodBeat.i(77752);
      paramT = this.aLt.remove(paramT);
      if (paramT != null) {
        this.aGd -= T(paramT);
      }
      AppMethodBeat.o(77752);
      return paramT;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.bumptech.glide.h.f
 * JD-Core Version:    0.7.0.1
 */