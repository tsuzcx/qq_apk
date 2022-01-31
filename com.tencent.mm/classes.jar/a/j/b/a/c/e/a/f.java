package a.j.b.a.c.e.a;

import a.f.b.j;
import a.j.b.a.c.g.i.c;
import a.j.b.a.c.g.i.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public final class f
{
  public static final <M extends i.c<M>, T> T a(i.c<M> paramc, i.f<M, T> paramf)
  {
    AppMethodBeat.i(121081);
    j.q(paramc, "receiver$0");
    j.q(paramf, "extension");
    if (paramc.c(paramf))
    {
      paramc = paramc.e(paramf);
      AppMethodBeat.o(121081);
      return paramc;
    }
    AppMethodBeat.o(121081);
    return null;
  }
  
  public static final <M extends i.c<M>, T> T a(i.c<M> paramc, i.f<M, List<T>> paramf, int paramInt)
  {
    AppMethodBeat.i(121082);
    j.q(paramc, "receiver$0");
    j.q(paramf, "extension");
    if (paramInt < paramc.d(paramf))
    {
      paramc = paramc.a(paramf, paramInt);
      AppMethodBeat.o(121082);
      return paramc;
    }
    AppMethodBeat.o(121082);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     a.j.b.a.c.e.a.f
 * JD-Core Version:    0.7.0.1
 */