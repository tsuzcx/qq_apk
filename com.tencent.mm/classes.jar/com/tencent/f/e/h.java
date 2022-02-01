package com.tencent.f.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public final class h
{
  private static ConcurrentHashMap<String, g> cCB;
  
  static
  {
    AppMethodBeat.i(183313);
    cCB = new ConcurrentHashMap();
    AppMethodBeat.o(183313);
  }
  
  public static void release()
  {
    AppMethodBeat.i(183312);
    Iterator localIterator = cCB.values().iterator();
    while (localIterator.hasNext()) {
      ((g)localIterator.next()).onShutdown();
    }
    AppMethodBeat.o(183312);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.f.e.h
 * JD-Core Version:    0.7.0.1
 */