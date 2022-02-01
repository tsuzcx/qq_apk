package com.google.firebase.components;

import com.google.firebase.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class p<T>
  implements a<T>
{
  private static final Object bCL;
  private volatile Object bCM;
  private volatile a<T> bCN;
  
  static
  {
    AppMethodBeat.i(4095);
    bCL = new Object();
    AppMethodBeat.o(4095);
  }
  
  p(d<T> paramd, b paramb)
  {
    AppMethodBeat.i(4092);
    this.bCM = bCL;
    this.bCN = new q(paramd, paramb);
    AppMethodBeat.o(4092);
  }
  
  public final T get()
  {
    AppMethodBeat.i(4093);
    Object localObject3 = this.bCM;
    Object localObject1 = localObject3;
    if (localObject3 == bCL) {}
    try
    {
      localObject3 = this.bCM;
      localObject1 = localObject3;
      if (localObject3 == bCL)
      {
        localObject1 = this.bCN.get();
        this.bCM = localObject1;
        this.bCN = null;
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