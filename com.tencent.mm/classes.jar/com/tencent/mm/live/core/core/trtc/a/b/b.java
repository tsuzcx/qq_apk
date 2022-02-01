package com.tencent.mm.live.core.core.trtc.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class b
{
  List<a> hBJ;
  
  private b()
  {
    AppMethodBeat.i(196281);
    this.hBJ = new ArrayList();
    AppMethodBeat.o(196281);
  }
  
  public final a Gr(String paramString)
  {
    AppMethodBeat.i(196283);
    Iterator localIterator = this.hBJ.iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (paramString.equals(locala.goe))
      {
        AppMethodBeat.o(196283);
        return locala;
      }
    }
    AppMethodBeat.o(196283);
    return null;
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(196282);
    this.hBJ.add(parama);
    AppMethodBeat.o(196282);
  }
  
  static final class a
  {
    private static b hBK;
    
    static
    {
      AppMethodBeat.i(196280);
      hBK = new b((byte)0);
      AppMethodBeat.o(196280);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.core.core.trtc.a.b.b
 * JD-Core Version:    0.7.0.1
 */