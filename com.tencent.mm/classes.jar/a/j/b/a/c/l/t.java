package a.j.b.a.c.l;

import a.f.b.j;
import a.m;
import a.v;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class t
{
  public static final boolean ai(w paramw)
  {
    AppMethodBeat.i(122591);
    j.q(paramw, "receiver$0");
    boolean bool = paramw.eoL() instanceof q;
    AppMethodBeat.o(122591);
    return bool;
  }
  
  public static final q aj(w paramw)
  {
    AppMethodBeat.i(122592);
    j.q(paramw, "receiver$0");
    paramw = paramw.eoL();
    if (paramw == null)
    {
      paramw = new v("null cannot be cast to non-null type org.jetbrains.kotlin.types.FlexibleType");
      AppMethodBeat.o(122592);
      throw paramw;
    }
    paramw = (q)paramw;
    AppMethodBeat.o(122592);
    return paramw;
  }
  
  public static final ad ak(w paramw)
  {
    AppMethodBeat.i(122593);
    j.q(paramw, "receiver$0");
    paramw = paramw.eoL();
    if ((paramw instanceof q))
    {
      paramw = ((q)paramw).CBm;
      AppMethodBeat.o(122593);
      return paramw;
    }
    if ((paramw instanceof ad))
    {
      paramw = (ad)paramw;
      AppMethodBeat.o(122593);
      return paramw;
    }
    paramw = new m();
    AppMethodBeat.o(122593);
    throw paramw;
  }
  
  public static final ad al(w paramw)
  {
    AppMethodBeat.i(122594);
    j.q(paramw, "receiver$0");
    paramw = paramw.eoL();
    if ((paramw instanceof q))
    {
      paramw = ((q)paramw).CBn;
      AppMethodBeat.o(122594);
      return paramw;
    }
    if ((paramw instanceof ad))
    {
      paramw = (ad)paramw;
      AppMethodBeat.o(122594);
      return paramw;
    }
    paramw = new m();
    AppMethodBeat.o(122594);
    throw paramw;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     a.j.b.a.c.l.t
 * JD-Core Version:    0.7.0.1
 */