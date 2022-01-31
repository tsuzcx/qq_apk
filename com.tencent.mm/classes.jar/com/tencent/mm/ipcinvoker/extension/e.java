package com.tencent.mm.ipcinvoker.extension;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.g.b;
import junit.framework.Assert;

public final class e<T>
{
  private volatile T eEI;
  private Class<T> targetClass;
  
  public e(Class<T> paramClass)
  {
    AppMethodBeat.i(114088);
    Assert.assertNotNull(paramClass);
    this.targetClass = paramClass;
    AppMethodBeat.o(114088);
  }
  
  public final T get()
  {
    AppMethodBeat.i(114089);
    if (this.eEI == null) {}
    try
    {
      if (this.eEI == null) {
        this.eEI = b.B(this.targetClass);
      }
      Object localObject1 = this.eEI;
      AppMethodBeat.o(114089);
      return localObject1;
    }
    finally
    {
      AppMethodBeat.o(114089);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.extension.e
 * JD-Core Version:    0.7.0.1
 */