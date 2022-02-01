package com.tencent.mm.plugin.appbrand.page.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public abstract class f
  extends a
{
  public final LinkedList<f.a> lGz = new LinkedList()
  {
    public final boolean remove(Object paramAnonymousObject)
    {
      AppMethodBeat.i(135289);
      boolean bool = super.remove(paramAnonymousObject);
      f.a(f.this);
      AppMethodBeat.o(135289);
      return bool;
    }
  };
  
  public final c.a brA()
  {
    f.a locala = new f.a(this);
    this.lGz.addFirst(locala);
    return locala;
  }
  
  public final void destroy()
  {
    this.lGz.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.a.f
 * JD-Core Version:    0.7.0.1
 */