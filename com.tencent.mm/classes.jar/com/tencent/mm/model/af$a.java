package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.ConcurrentLinkedQueue;

public final class af$a
{
  private static ConcurrentLinkedQueue<af.b> lsW;
  
  static
  {
    AppMethodBeat.i(243988);
    lsW = new ConcurrentLinkedQueue();
    AppMethodBeat.o(243988);
  }
  
  public static void a(af.b paramb)
  {
    AppMethodBeat.i(243986);
    lsW.add(paramb);
    AppMethodBeat.o(243986);
  }
  
  public static void b(af.b paramb)
  {
    AppMethodBeat.i(243987);
    lsW.remove(paramb);
    AppMethodBeat.o(243987);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.model.af.a
 * JD-Core Version:    0.7.0.1
 */