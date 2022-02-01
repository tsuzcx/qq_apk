package com.tencent.mm.ipcinvoker.extension;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.g.b;
import junit.framework.Assert;

public final class e<T>
{
  private volatile T mzk;
  private Class<T> mzl;
  
  public e(Class<T> paramClass)
  {
    AppMethodBeat.i(158799);
    Assert.assertNotNull(paramClass);
    this.mzl = paramClass;
    AppMethodBeat.o(158799);
  }
  
  public final T get()
  {
    AppMethodBeat.i(158800);
    if (this.mzk == null) {}
    try
    {
      if (this.mzk == null) {
        this.mzk = b.G(this.mzl);
      }
      Object localObject1 = this.mzk;
      AppMethodBeat.o(158800);
      return localObject1;
    }
    finally
    {
      AppMethodBeat.o(158800);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.extension.e
 * JD-Core Version:    0.7.0.1
 */