package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.ConcurrentLinkedQueue;

public final class af$a
{
  private static ConcurrentLinkedQueue<af.b> iCW;
  
  static
  {
    AppMethodBeat.i(229788);
    iCW = new ConcurrentLinkedQueue();
    AppMethodBeat.o(229788);
  }
  
  public static void a(af.b paramb)
  {
    AppMethodBeat.i(229786);
    iCW.add(paramb);
    AppMethodBeat.o(229786);
  }
  
  public static void b(af.b paramb)
  {
    AppMethodBeat.i(229787);
    iCW.remove(paramb);
    AppMethodBeat.o(229787);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.model.af.a
 * JD-Core Version:    0.7.0.1
 */