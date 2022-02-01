package com.google.firebase.components;

import com.google.firebase.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class p<T>
  implements a<T>
{
  private static final Object bKX;
  private volatile Object bKY;
  private volatile a<T> bKZ;
  
  static
  {
    AppMethodBeat.i(4095);
    bKX = new Object();
    AppMethodBeat.o(4095);
  }
  
  p(d<T> paramd, b paramb)
  {
    AppMethodBeat.i(4092);
    this.bKY = bKX;
    this.bKZ = new q(paramd, paramb);
    AppMethodBeat.o(4092);
  }
  
  public final T get()
  {
    AppMethodBeat.i(4093);
    Object localObject3 = this.bKY;
    Object localObject1 = localObject3;
    if (localObject3 == bKX) {}
    try
    {
      localObject3 = this.bKY;
      localObject1 = localObject3;
      if (localObject3 == bKX)
      {
        localObject1 = this.bKZ.get();
        this.bKY = localObject1;
        this.bKZ = null;
      }
      return localObject1;
    }
    finally
    {
      AppMethodBeat.o(4093);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.firebase.components.p
 * JD-Core Version:    0.7.0.1
 */