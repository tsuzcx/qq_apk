package com.tencent.mm.live.core.core.trtc.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class b
{
  List<a> gJA;
  
  private b()
  {
    AppMethodBeat.i(216693);
    this.gJA = new ArrayList();
    AppMethodBeat.o(216693);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(216694);
    this.gJA.add(parama);
    AppMethodBeat.o(216694);
  }
  
  public final a xo(String paramString)
  {
    AppMethodBeat.i(216695);
    Iterator localIterator = this.gJA.iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (paramString.equals(locala.fGM))
      {
        AppMethodBeat.o(216695);
        return locala;
      }
    }
    AppMethodBeat.o(216695);
    return null;
  }
  
  static final class a
  {
    private static b gJB;
    
    static
    {
      AppMethodBeat.i(216692);
      gJB = new b((byte)0);
      AppMethodBeat.o(216692);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.core.core.trtc.a.b.b
 * JD-Core Version:    0.7.0.1
 */