package com.google.firebase.components;

import com.google.firebase.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class p<T>
  implements a<T>
{
  private static final Object bAt;
  private volatile Object bAu;
  private volatile a<T> bAv;
  
  static
  {
    AppMethodBeat.i(4095);
    bAt = new Object();
    AppMethodBeat.o(4095);
  }
  
  p(d<T> paramd, b paramb)
  {
    AppMethodBeat.i(4092);
    this.bAu = bAt;
    this.bAv = new q(paramd, paramb);
    AppMethodBeat.o(4092);
  }
  
  public final T get()
  {
    AppMethodBeat.i(4093);
    Object localObject3 = this.bAu;
    Object localObject1 = localObject3;
    if (localObject3 == bAt) {}
    try
    {
      localObject3 = this.bAu;
      localObject1 = localObject3;
      if (localObject3 == bAt)
      {
        localObject1 = this.bAv.get();
        this.bAu = localObject1;
        this.bAv = null;
      }
      return localObject1;
    }
    finally
    {
      AppMethodBeat.o(4093);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.firebase.components.p
 * JD-Core Version:    0.7.0.1
 */