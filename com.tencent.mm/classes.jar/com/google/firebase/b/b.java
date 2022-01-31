package com.google.firebase.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicReference;

public final class b
{
  private static final AtomicReference<b> bel;
  
  static
  {
    AppMethodBeat.i(10636);
    bel = new AtomicReference();
    AppMethodBeat.o(10636);
  }
  
  public static b sg()
  {
    AppMethodBeat.i(10635);
    bel.compareAndSet(null, new b());
    b localb = (b)bel.get();
    AppMethodBeat.o(10635);
    return localb;
  }
  
  public static void sh() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.firebase.b.b
 * JD-Core Version:    0.7.0.1
 */