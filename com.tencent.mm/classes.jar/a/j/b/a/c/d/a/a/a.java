package a.j.b.a.c.d.a.a;

import a.j.b.a.c.b.au;
import a.j.b.a.c.b.b;
import a.j.b.a.c.b.d;
import a.j.b.a.c.b.e;
import a.j.b.a.c.f.f;
import a.j.b.a.c.i.j;
import a.j.b.a.c.j.a.m;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

public final class a
{
  public static <D extends b> Collection<D> a(Collection<D> paramCollection1, Collection<D> paramCollection2, e parame, m paramm)
  {
    AppMethodBeat.i(119747);
    paramCollection1 = a(paramCollection1, paramCollection2, parame, paramm, false);
    AppMethodBeat.o(119747);
    return paramCollection1;
  }
  
  private static <D extends b> Collection<D> a(Collection<D> paramCollection1, Collection<D> paramCollection2, e parame, m paramm, boolean paramBoolean)
  {
    AppMethodBeat.i(119749);
    LinkedHashSet localLinkedHashSet = new LinkedHashSet();
    j.a(paramCollection1, paramCollection2, parame, new a.1(paramm, localLinkedHashSet, paramBoolean));
    AppMethodBeat.o(119749);
    return localLinkedHashSet;
  }
  
  public static au b(f paramf, e parame)
  {
    AppMethodBeat.i(119750);
    parame = parame.ecA();
    if (parame.size() != 1)
    {
      AppMethodBeat.o(119750);
      return null;
    }
    parame = ((d)parame.iterator().next()).edu().iterator();
    while (parame.hasNext())
    {
      au localau = (au)parame.next();
      if (localau.edF().equals(paramf))
      {
        AppMethodBeat.o(119750);
        return localau;
      }
    }
    AppMethodBeat.o(119750);
    return null;
  }
  
  public static <D extends b> Collection<D> b(Collection<D> paramCollection1, Collection<D> paramCollection2, e parame, m paramm)
  {
    AppMethodBeat.i(119748);
    paramCollection1 = a(paramCollection1, paramCollection2, parame, paramm, true);
    AppMethodBeat.o(119748);
    return paramCollection1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     a.j.b.a.c.d.a.a.a
 * JD-Core Version:    0.7.0.1
 */