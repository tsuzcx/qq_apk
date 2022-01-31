package a.j.b.a.c.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public final class x
  extends AbstractList<String>
  implements o, RandomAccess
{
  private final o Csy;
  
  public x(o paramo)
  {
    this.Csy = paramo;
  }
  
  public final d VK(int paramInt)
  {
    AppMethodBeat.i(121679);
    d locald = this.Csy.VK(paramInt);
    AppMethodBeat.o(121679);
    return locald;
  }
  
  public final void e(d paramd)
  {
    AppMethodBeat.i(121680);
    paramd = new UnsupportedOperationException();
    AppMethodBeat.o(121680);
    throw paramd;
  }
  
  public final List<?> emW()
  {
    AppMethodBeat.i(121683);
    List localList = this.Csy.emW();
    AppMethodBeat.o(121683);
    return localList;
  }
  
  public final o emX()
  {
    return this;
  }
  
  public final Iterator<String> iterator()
  {
    AppMethodBeat.i(121682);
    x.2 local2 = new x.2(this);
    AppMethodBeat.o(121682);
    return local2;
  }
  
  public final ListIterator<String> listIterator(int paramInt)
  {
    AppMethodBeat.i(121681);
    x.1 local1 = new x.1(this, paramInt);
    AppMethodBeat.o(121681);
    return local1;
  }
  
  public final int size()
  {
    AppMethodBeat.i(121678);
    int i = this.Csy.size();
    AppMethodBeat.o(121678);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     a.j.b.a.c.g.x
 * JD-Core Version:    0.7.0.1
 */