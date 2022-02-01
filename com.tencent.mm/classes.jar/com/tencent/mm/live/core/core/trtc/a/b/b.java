package com.tencent.mm.live.core.core.trtc.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class b
{
  List<a> gpQ;
  
  private b()
  {
    AppMethodBeat.i(209039);
    this.gpQ = new ArrayList();
    AppMethodBeat.o(209039);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(209040);
    this.gpQ.add(parama);
    AppMethodBeat.o(209040);
  }
  
  public final a ux(String paramString)
  {
    AppMethodBeat.i(209041);
    Iterator localIterator = this.gpQ.iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (paramString.equals(locala.foE))
      {
        AppMethodBeat.o(209041);
        return locala;
      }
    }
    AppMethodBeat.o(209041);
    return null;
  }
  
  static final class a
  {
    private static b gpR;
    
    static
    {
      AppMethodBeat.i(209038);
      gpR = new b((byte)0);
      AppMethodBeat.o(209038);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.live.core.core.trtc.a.b.b
 * JD-Core Version:    0.7.0.1
 */