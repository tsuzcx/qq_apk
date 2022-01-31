package a.j.b.a.c.n;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Iterator;

public final class b
{
  public static <N> Boolean a(Collection<N> paramCollection, b.b<N> paramb, a.f.a.b<N, Boolean> paramb1)
  {
    AppMethodBeat.i(122925);
    paramCollection = (Boolean)a(paramCollection, paramb, new b.1(paramb1, new boolean[1]));
    AppMethodBeat.o(122925);
    return paramCollection;
  }
  
  public static <N, R> R a(Collection<N> paramCollection, b.b<N> paramb, b.c<N, R> paramc)
  {
    AppMethodBeat.i(122924);
    paramCollection = a(paramCollection, paramb, new b.e(), paramc);
    AppMethodBeat.o(122924);
    return paramCollection;
  }
  
  private static <N, R> R a(Collection<N> paramCollection, b.b<N> paramb, b.d<N> paramd, b.c<N, R> paramc)
  {
    AppMethodBeat.i(122923);
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext()) {
      a(paramCollection.next(), paramb, paramd, paramc);
    }
    paramCollection = paramc.edo();
    AppMethodBeat.o(122923);
    return paramCollection;
  }
  
  private static <N> void a(N paramN, b.b<N> paramb, b.d<N> paramd, b.c<N, ?> paramc)
  {
    AppMethodBeat.i(122926);
    if (!paramd.dQ(paramN))
    {
      AppMethodBeat.o(122926);
      return;
    }
    if (!paramc.dw(paramN))
    {
      AppMethodBeat.o(122926);
      return;
    }
    Iterator localIterator = paramb.dv(paramN).iterator();
    while (localIterator.hasNext()) {
      a(localIterator.next(), paramb, paramd, paramc);
    }
    paramc.dM(paramN);
    AppMethodBeat.o(122926);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     a.j.b.a.c.n.b
 * JD-Core Version:    0.7.0.1
 */