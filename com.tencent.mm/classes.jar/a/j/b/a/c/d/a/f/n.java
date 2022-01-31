package a.j.b.a.c.d.a.f;

import a.a.aj;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Set;

public final class n
{
  static final d a(g paramg, e parame, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(120187);
    if ((!paramBoolean2) || (paramg != g.ChA))
    {
      paramg = new d(paramg, parame, false, paramBoolean1);
      AppMethodBeat.o(120187);
      return paramg;
    }
    paramg = new d(paramg, parame, true, paramBoolean1);
    AppMethodBeat.o(120187);
    return paramg;
  }
  
  static final g a(Set<? extends g> paramSet, g paramg, boolean paramBoolean)
  {
    AppMethodBeat.i(120189);
    if (paramg == g.ChB)
    {
      paramSet = g.ChB;
      AppMethodBeat.o(120189);
      return paramSet;
    }
    paramSet = (g)a(paramSet, g.ChA, g.Chz, paramg, paramBoolean);
    AppMethodBeat.o(120189);
    return paramSet;
  }
  
  static final <T> T a(Set<? extends T> paramSet, T paramT1, T paramT2, T paramT3, boolean paramBoolean)
  {
    AppMethodBeat.i(120188);
    if (paramBoolean)
    {
      if (paramSet.contains(paramT1)) {
        paramSet = paramT1;
      }
      while ((a.f.b.j.e(paramSet, paramT1)) && (a.f.b.j.e(paramT3, paramT2)))
      {
        AppMethodBeat.o(120188);
        return null;
        if (paramSet.contains(paramT2)) {
          paramSet = paramT2;
        } else {
          paramSet = null;
        }
      }
      if (paramT3 != null) {
        break label115;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(120188);
      return paramSet;
      if (paramT3 != null)
      {
        paramT2 = a.a.j.o((Iterable)aj.b(paramSet, paramT3));
        paramT1 = paramT2;
        if (paramT2 != null) {}
      }
      else
      {
        paramT1 = paramSet;
      }
      paramSet = a.a.j.i((Iterable)paramT1);
      AppMethodBeat.o(120188);
      return paramSet;
      label115:
      paramSet = paramT3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     a.j.b.a.c.d.a.f.n
 * JD-Core Version:    0.7.0.1
 */