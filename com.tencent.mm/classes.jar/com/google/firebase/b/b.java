package com.google.firebase.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicReference;

public final class b
{
  private static final AtomicReference<b> bKx;
  
  static
  {
    AppMethodBeat.i(4103);
    bKx = new AtomicReference();
    AppMethodBeat.o(4103);
  }
  
  public static b yx()
  {
    AppMethodBeat.i(4102);
    bKx.compareAndSet(null, new b());
    b localb = (b)bKx.get();
    AppMethodBeat.o(4102);
    return localb;
  }
  
  public static void yy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.firebase.b.b
 * JD-Core Version:    0.7.0.1
 */