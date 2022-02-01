package com.bumptech.glide.d;

import com.bumptech.glide.load.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public final class a
{
  private final List<a<?>> aMM;
  
  public a()
  {
    AppMethodBeat.i(77598);
    this.aMM = new ArrayList();
    AppMethodBeat.o(77598);
  }
  
  public final <T> void b(Class<T> paramClass, d<T> paramd)
  {
    try
    {
      AppMethodBeat.i(77600);
      this.aMM.add(new a(paramClass, paramd));
      AppMethodBeat.o(77600);
      return;
    }
    finally
    {
      paramClass = finally;
      throw paramClass;
    }
  }
  
  /* Error */
  public final <T> d<T> v(Class<T> paramClass)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 46
    //   4: invokestatic 21	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 26	com/bumptech/glide/d/a:aMM	Ljava/util/List;
    //   11: invokeinterface 50 1 0
    //   16: astore_2
    //   17: aload_2
    //   18: invokeinterface 56 1 0
    //   23: ifeq +38 -> 61
    //   26: aload_2
    //   27: invokeinterface 60 1 0
    //   32: checkcast 6	com/bumptech/glide/d/a$a
    //   35: astore_3
    //   36: aload_3
    //   37: getfield 64	com/bumptech/glide/d/a$a:aGU	Ljava/lang/Class;
    //   40: aload_1
    //   41: invokevirtual 70	java/lang/Class:isAssignableFrom	(Ljava/lang/Class;)Z
    //   44: ifeq -27 -> 17
    //   47: aload_3
    //   48: getfield 74	com/bumptech/glide/d/a$a:aFU	Lcom/bumptech/glide/load/d;
    //   51: astore_1
    //   52: ldc 46
    //   54: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   57: aload_0
    //   58: monitorexit
    //   59: aload_1
    //   60: areturn
    //   61: aconst_null
    //   62: astore_1
    //   63: ldc 46
    //   65: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   68: goto -11 -> 57
    //   71: astore_1
    //   72: aload_0
    //   73: monitorexit
    //   74: aload_1
    //   75: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	76	0	this	a
    //   0	76	1	paramClass	Class<T>
    //   16	11	2	localIterator	java.util.Iterator
    //   35	13	3	locala	a
    // Exception table:
    //   from	to	target	type
    //   2	17	71	finally
    //   17	57	71	finally
    //   63	68	71	finally
  }
  
  static final class a<T>
  {
    final d<T> aFU;
    final Class<T> aGU;
    
    a(Class<T> paramClass, d<T> paramd)
    {
      this.aGU = paramClass;
      this.aFU = paramd;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.bumptech.glide.d.a
 * JD-Core Version:    0.7.0.1
 */