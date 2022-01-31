package a.j.b.a.c.m.b;

import a.f.b.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.LinkedHashSet;

public final class a
{
  public static final <T> Collection<T> b(Collection<? extends T> paramCollection1, Collection<? extends T> paramCollection2)
  {
    AppMethodBeat.i(122913);
    j.q(paramCollection2, "collection");
    if (paramCollection2.isEmpty())
    {
      AppMethodBeat.o(122913);
      return paramCollection1;
    }
    if (paramCollection1 == null)
    {
      AppMethodBeat.o(122913);
      return paramCollection2;
    }
    if ((paramCollection1 instanceof LinkedHashSet))
    {
      ((LinkedHashSet)paramCollection1).addAll(paramCollection2);
      AppMethodBeat.o(122913);
      return paramCollection1;
    }
    paramCollection1 = new LinkedHashSet(paramCollection1);
    paramCollection1.addAll(paramCollection2);
    paramCollection1 = (Collection)paramCollection1;
    AppMethodBeat.o(122913);
    return paramCollection1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     a.j.b.a.c.m.b.a
 * JD-Core Version:    0.7.0.1
 */