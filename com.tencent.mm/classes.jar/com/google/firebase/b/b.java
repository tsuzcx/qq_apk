package com.google.firebase.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicReference;

public final class b
{
  private static final AtomicReference<b> dBK;
  
  static
  {
    AppMethodBeat.i(4103);
    dBK = new AtomicReference();
    AppMethodBeat.o(4103);
  }
  
  public static b YC()
  {
    AppMethodBeat.i(4102);
    dBK.compareAndSet(null, new b());
    b localb = (b)dBK.get();
    AppMethodBeat.o(4102);
    return localb;
  }
  
  public static void YD() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.firebase.b.b
 * JD-Core Version:    0.7.0.1
 */