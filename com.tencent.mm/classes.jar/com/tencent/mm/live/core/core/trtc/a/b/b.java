package com.tencent.mm.live.core.core.trtc.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class b
{
  private List<a> qJx;
  
  private b()
  {
    AppMethodBeat.i(205509);
    this.qJx = new ArrayList();
    AppMethodBeat.o(205509);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(205510);
    this.qJx.add(parama);
    AppMethodBeat.o(205510);
  }
  
  public final a aTW(String paramString)
  {
    AppMethodBeat.i(205511);
    Iterator localIterator = this.qJx.iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (paramString.equals(locala.flk))
      {
        AppMethodBeat.o(205511);
        return locala;
      }
    }
    AppMethodBeat.o(205511);
    return null;
  }
  
  static final class a
  {
    private static b qJW;
    
    static
    {
      AppMethodBeat.i(205508);
      qJW = new b((byte)0);
      AppMethodBeat.o(205508);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.live.core.core.trtc.a.b.b
 * JD-Core Version:    0.7.0.1
 */