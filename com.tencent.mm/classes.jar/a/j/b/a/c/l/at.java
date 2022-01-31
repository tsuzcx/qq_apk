package a.j.b.a.c.l;

import a.f.b.j;
import a.j.b.a.c.b.a.g;
import a.m;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public final class at
{
  private static ad a(ad paramad, List<? extends ap> paramList, g paramg)
  {
    AppMethodBeat.i(122657);
    j.q(paramad, "receiver$0");
    j.q(paramList, "newArguments");
    j.q(paramg, "newAnnotations");
    if ((paramList.isEmpty()) && (paramg == paramad.ecM()))
    {
      AppMethodBeat.o(122657);
      return paramad;
    }
    if (paramList.isEmpty())
    {
      paramad = paramad.d(paramg);
      AppMethodBeat.o(122657);
      return paramad;
    }
    paramad = x.c(paramg, paramad.enU(), paramList, paramad.egH());
    AppMethodBeat.o(122657);
    return paramad;
  }
  
  public static final w a(w paramw, List<? extends ap> paramList, g paramg)
  {
    AppMethodBeat.i(122656);
    j.q(paramw, "receiver$0");
    j.q(paramList, "newArguments");
    j.q(paramg, "newAnnotations");
    if (((paramList.isEmpty()) || (paramList == paramw.enR())) && (paramg == paramw.ecM()))
    {
      AppMethodBeat.o(122656);
      return paramw;
    }
    paramw = paramw.eoL();
    if ((paramw instanceof q))
    {
      paramw = (w)x.a(a(((q)paramw).CBm, paramList, paramg), a(((q)paramw).CBn, paramList, paramg));
      AppMethodBeat.o(122656);
      return paramw;
    }
    if ((paramw instanceof ad))
    {
      paramw = (w)a((ad)paramw, paramList, paramg);
      AppMethodBeat.o(122656);
      return paramw;
    }
    paramw = new m();
    AppMethodBeat.o(122656);
    throw paramw;
  }
  
  public static final ad av(w paramw)
  {
    AppMethodBeat.i(122659);
    j.q(paramw, "receiver$0");
    az localaz = paramw.eoL();
    Object localObject = localaz;
    if (!(localaz instanceof ad)) {
      localObject = null;
    }
    localObject = (ad)localObject;
    if (localObject == null)
    {
      paramw = (Throwable)new IllegalStateException("This is should be simple type: ".concat(String.valueOf(paramw)).toString());
      AppMethodBeat.o(122659);
      throw paramw;
    }
    AppMethodBeat.o(122659);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     a.j.b.a.c.l.at
 * JD-Core Version:    0.7.0.1
 */