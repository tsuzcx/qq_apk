package com.tencent.e.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public final class h
{
  private static ConcurrentHashMap<String, g> cpF;
  
  static
  {
    AppMethodBeat.i(183313);
    cpF = new ConcurrentHashMap();
    AppMethodBeat.o(183313);
  }
  
  public static void release()
  {
    AppMethodBeat.i(183312);
    Iterator localIterator = cpF.values().iterator();
    while (localIterator.hasNext()) {
      ((g)localIterator.next()).onShutdown();
    }
    AppMethodBeat.o(183312);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.e.e.h
 * JD-Core Version:    0.7.0.1
 */