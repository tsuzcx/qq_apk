package com.google.firebase.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicReference;

public final class b
{
  private static final AtomicReference<b> bKh;
  
  static
  {
    AppMethodBeat.i(4103);
    bKh = new AtomicReference();
    AppMethodBeat.o(4103);
  }
  
  public static b yp()
  {
    AppMethodBeat.i(4102);
    bKh.compareAndSet(null, new b());
    b localb = (b)bKh.get();
    AppMethodBeat.o(4102);
    return localb;
  }
  
  public static void yq() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.firebase.b.b
 * JD-Core Version:    0.7.0.1
 */