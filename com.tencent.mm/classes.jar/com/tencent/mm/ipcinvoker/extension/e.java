package com.tencent.mm.ipcinvoker.extension;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.g.b;
import junit.framework.Assert;

public final class e<T>
{
  private volatile T fZL;
  private Class<T> targetClass;
  
  public e(Class<T> paramClass)
  {
    AppMethodBeat.i(158799);
    Assert.assertNotNull(paramClass);
    this.targetClass = paramClass;
    AppMethodBeat.o(158799);
  }
  
  public final T get()
  {
    AppMethodBeat.i(158800);
    if (this.fZL == null) {}
    try
    {
      if (this.fZL == null) {
        this.fZL = b.H(this.targetClass);
      }
      Object localObject1 = this.fZL;
      AppMethodBeat.o(158800);
      return localObject1;
    }
    finally
    {
      AppMethodBeat.o(158800);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.extension.e
 * JD-Core Version:    0.7.0.1
 */