package com.google.firebase.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicReference;

public final class b
{
  private static final AtomicReference<b> bIc;
  
  static
  {
    AppMethodBeat.i(4103);
    bIc = new AtomicReference();
    AppMethodBeat.o(4103);
  }
  
  public static b yR()
  {
    AppMethodBeat.i(4102);
    bIc.compareAndSet(null, new b());
    b localb = (b)bIc.get();
    AppMethodBeat.o(4102);
    return localb;
  }
  
  public static void yS() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.firebase.b.b
 * JD-Core Version:    0.7.0.1
 */