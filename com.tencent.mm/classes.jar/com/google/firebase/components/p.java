package com.google.firebase.components;

import com.google.firebase.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class p<T>
  implements a<T>
{
  private static final Object bIC;
  private volatile Object bID;
  private volatile a<T> bIE;
  
  static
  {
    AppMethodBeat.i(4095);
    bIC = new Object();
    AppMethodBeat.o(4095);
  }
  
  p(d<T> paramd, b paramb)
  {
    AppMethodBeat.i(4092);
    this.bID = bIC;
    this.bIE = new q(paramd, paramb);
    AppMethodBeat.o(4092);
  }
  
  public final T get()
  {
    AppMethodBeat.i(4093);
    Object localObject3 = this.bID;
    Object localObject1 = localObject3;
    if (localObject3 == bIC) {}
    try
    {
      localObject3 = this.bID;
      localObject1 = localObject3;
      if (localObject3 == bIC)
      {
        localObject1 = this.bIE.get();
        this.bID = localObject1;
        this.bIE = null;
      }
      return localObject1;
    }
    finally
    {
      AppMethodBeat.o(4093);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.firebase.components.p
 * JD-Core Version:    0.7.0.1
 */