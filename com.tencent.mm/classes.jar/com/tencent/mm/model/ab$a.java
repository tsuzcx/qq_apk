package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.ConcurrentLinkedQueue;

public final class ab$a
{
  private static ConcurrentLinkedQueue<ab.b> hIm;
  
  static
  {
    AppMethodBeat.i(221718);
    hIm = new ConcurrentLinkedQueue();
    AppMethodBeat.o(221718);
  }
  
  public static void a(ab.b paramb)
  {
    AppMethodBeat.i(221716);
    hIm.add(paramb);
    AppMethodBeat.o(221716);
  }
  
  public static void b(ab.b paramb)
  {
    AppMethodBeat.i(221717);
    hIm.remove(paramb);
    AppMethodBeat.o(221717);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.model.ab.a
 * JD-Core Version:    0.7.0.1
 */