package a.c;

import a.f.a.m;
import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13})
public final class e$b$a
{
  public static <E extends e.b> E a(e.b paramb, e.c<E> paramc)
  {
    AppMethodBeat.i(56373);
    j.q(paramc, "key");
    if (j.e(paramb.getKey(), paramc))
    {
      AppMethodBeat.o(56373);
      return paramb;
    }
    AppMethodBeat.o(56373);
    return null;
  }
  
  public static e a(e.b paramb, e parame)
  {
    AppMethodBeat.i(56376);
    j.q(parame, "context");
    paramb = e.a.a((e)paramb, parame);
    AppMethodBeat.o(56376);
    return paramb;
  }
  
  public static <R> R a(e.b paramb, R paramR, m<? super R, ? super e.b, ? extends R> paramm)
  {
    AppMethodBeat.i(56374);
    j.q(paramm, "operation");
    paramb = paramm.h(paramR, paramb);
    AppMethodBeat.o(56374);
    return paramb;
  }
  
  public static e b(e.b paramb, e.c<?> paramc)
  {
    AppMethodBeat.i(56375);
    j.q(paramc, "key");
    if (j.e(paramb.getKey(), paramc))
    {
      paramb = (e)f.BMO;
      AppMethodBeat.o(56375);
      return paramb;
    }
    paramb = (e)paramb;
    AppMethodBeat.o(56375);
    return paramb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     a.c.e.b.a
 * JD-Core Version:    0.7.0.1
 */