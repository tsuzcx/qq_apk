package com.google.firebase.components;

import com.google.firebase.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class p<T>
  implements a<T>
{
  private static final Object beL;
  private volatile Object beM;
  private volatile a<T> beN;
  
  static
  {
    AppMethodBeat.i(10628);
    beL = new Object();
    AppMethodBeat.o(10628);
  }
  
  p(d<T> paramd, b paramb)
  {
    AppMethodBeat.i(10625);
    this.beM = beL;
    this.beN = new q(paramd, paramb);
    AppMethodBeat.o(10625);
  }
  
  public final T get()
  {
    AppMethodBeat.i(10626);
    Object localObject3 = this.beM;
    Object localObject1 = localObject3;
    if (localObject3 == beL) {}
    try
    {
      localObject3 = this.beM;
      localObject1 = localObject3;
      if (localObject3 == beL)
      {
        localObject1 = this.beN.get();
        this.beM = localObject1;
        this.beN = null;
      }
      return localObject1;
    }
    finally
    {
      AppMethodBeat.o(10626);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.firebase.components.p
 * JD-Core Version:    0.7.0.1
 */