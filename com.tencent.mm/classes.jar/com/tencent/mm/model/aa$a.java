package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.ConcurrentLinkedQueue;

public final class aa$a
{
  private static ConcurrentLinkedQueue<aa.b> hFu;
  
  static
  {
    AppMethodBeat.i(197009);
    hFu = new ConcurrentLinkedQueue();
    AppMethodBeat.o(197009);
  }
  
  public static void a(aa.b paramb)
  {
    AppMethodBeat.i(197007);
    hFu.add(paramb);
    AppMethodBeat.o(197007);
  }
  
  public static void b(aa.b paramb)
  {
    AppMethodBeat.i(197008);
    hFu.remove(paramb);
    AppMethodBeat.o(197008);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.model.aa.a
 * JD-Core Version:    0.7.0.1
 */