package com.tencent.mm.plugin.appbrand.page.capsulebar;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public abstract class j
  extends f
{
  private final LinkedList<j.a> qxB = new LinkedList()
  {
    public final boolean remove(Object paramAnonymousObject)
    {
      AppMethodBeat.i(135289);
      boolean bool = super.remove(paramAnonymousObject);
      j.a(j.this);
      AppMethodBeat.o(135289);
      return bool;
    }
  };
  
  public final i.a cfE()
  {
    j.a locala = new j.a(this);
    this.qxB.addFirst(locala);
    return locala;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.capsulebar.j
 * JD-Core Version:    0.7.0.1
 */