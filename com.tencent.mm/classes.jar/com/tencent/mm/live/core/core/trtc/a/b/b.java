package com.tencent.mm.live.core.core.trtc.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class b
{
  List<a> gMj;
  
  private b()
  {
    AppMethodBeat.i(197092);
    this.gMj = new ArrayList();
    AppMethodBeat.o(197092);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(197093);
    this.gMj.add(parama);
    AppMethodBeat.o(197093);
  }
  
  public final a xX(String paramString)
  {
    AppMethodBeat.i(197094);
    Iterator localIterator = this.gMj.iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (paramString.equals(locala.fIQ))
      {
        AppMethodBeat.o(197094);
        return locala;
      }
    }
    AppMethodBeat.o(197094);
    return null;
  }
  
  static final class a
  {
    private static b gMk;
    
    static
    {
      AppMethodBeat.i(197091);
      gMk = new b((byte)0);
      AppMethodBeat.o(197091);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.live.core.core.trtc.a.b.b
 * JD-Core Version:    0.7.0.1
 */