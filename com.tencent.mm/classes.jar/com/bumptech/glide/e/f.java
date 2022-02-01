package com.bumptech.glide.e;

import com.bumptech.glide.c.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public final class f
{
  private final List<a<?>> aKo;
  
  public f()
  {
    AppMethodBeat.i(77616);
    this.aKo = new ArrayList();
    AppMethodBeat.o(77616);
  }
  
  public final <Z> void b(Class<Z> paramClass, l<Z> paraml)
  {
    try
    {
      AppMethodBeat.i(77617);
      this.aKo.add(new a(paramClass, paraml));
      AppMethodBeat.o(77617);
      return;
    }
    finally
    {
      paramClass = finally;
      throw paramClass;
    }
  }
  
  /* Error */
  public final <Z> l<Z> u(Class<Z> paramClass)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 46
    //   4: invokestatic 21	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 26	com/bumptech/glide/e/f:aKo	Ljava/util/List;
    //   11: invokeinterface 50 1 0
    //   16: istore_3
    //   17: iconst_0
    //   18: istore_2
    //   19: iload_2
    //   20: iload_3
    //   21: if_icmpge +52 -> 73
    //   24: aload_0
    //   25: getfield 26	com/bumptech/glide/e/f:aKo	Ljava/util/List;
    //   28: iload_2
    //   29: invokeinterface 54 2 0
    //   34: checkcast 6	com/bumptech/glide/e/f$a
    //   37: astore 4
    //   39: aload 4
    //   41: getfield 58	com/bumptech/glide/e/f$a:aDx	Ljava/lang/Class;
    //   44: aload_1
    //   45: invokevirtual 64	java/lang/Class:isAssignableFrom	(Ljava/lang/Class;)Z
    //   48: ifeq +18 -> 66
    //   51: aload 4
    //   53: getfield 68	com/bumptech/glide/e/f$a:aEf	Lcom/bumptech/glide/c/l;
    //   56: astore_1
    //   57: ldc 46
    //   59: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   62: aload_0
    //   63: monitorexit
    //   64: aload_1
    //   65: areturn
    //   66: iload_2
    //   67: iconst_1
    //   68: iadd
    //   69: istore_2
    //   70: goto -51 -> 19
    //   73: aconst_null
    //   74: astore_1
    //   75: ldc 46
    //   77: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   80: goto -18 -> 62
    //   83: astore_1
    //   84: aload_0
    //   85: monitorexit
    //   86: aload_1
    //   87: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	88	0	this	f
    //   0	88	1	paramClass	Class<Z>
    //   18	52	2	i	int
    //   16	6	3	j	int
    //   37	15	4	locala	a
    // Exception table:
    //   from	to	target	type
    //   2	17	83	finally
    //   24	62	83	finally
    //   75	80	83	finally
  }
  
  static final class a<T>
  {
    final Class<T> aDx;
    final l<T> aEf;
    
    a(Class<T> paramClass, l<T> paraml)
    {
      this.aDx = paramClass;
      this.aEf = paraml;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.bumptech.glide.e.f
 * JD-Core Version:    0.7.0.1
 */