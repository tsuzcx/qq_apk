package a.j.b.a.c.i;

import a.j.b.a.c.b.ah;
import a.j.b.a.c.b.au;
import a.j.b.a.c.b.d;
import a.j.b.a.c.b.e;
import a.j.b.a.c.b.l;
import a.j.b.a.c.c.a.a;
import a.j.b.a.c.c.a.c;
import a.j.b.a.c.l.an;
import a.j.b.a.c.l.w;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f
{
  private static boolean D(l paraml)
  {
    AppMethodBeat.i(121982);
    a.f.b.j.q(paraml, "receiver$0");
    if (((paraml instanceof e)) && (((e)paraml).ecI()))
    {
      AppMethodBeat.o(121982);
      return true;
    }
    AppMethodBeat.o(121982);
    return false;
  }
  
  private static au aa(w paramw)
  {
    AppMethodBeat.i(121983);
    a.f.b.j.q(paramw, "receiver$0");
    a.j.b.a.c.b.h localh = paramw.enU().ecR();
    paramw = localh;
    if (!(localh instanceof e)) {
      paramw = null;
    }
    paramw = (e)paramw;
    if (paramw != null)
    {
      a.f.b.j.q(paramw, "receiver$0");
      if (!paramw.ecI())
      {
        AppMethodBeat.o(121983);
        return null;
      }
      paramw = paramw.ecD();
      if (paramw != null)
      {
        paramw = paramw.edu();
        if (paramw != null)
        {
          paramw = (au)a.a.j.fV(paramw);
          AppMethodBeat.o(121983);
          return paramw;
        }
      }
      AppMethodBeat.o(121983);
      return null;
    }
    AppMethodBeat.o(121983);
    return null;
  }
  
  public static final boolean ab(w paramw)
  {
    AppMethodBeat.i(121984);
    a.f.b.j.q(paramw, "receiver$0");
    paramw = paramw.enU().ecR();
    if (paramw != null)
    {
      boolean bool = D((l)paramw);
      AppMethodBeat.o(121984);
      return bool;
    }
    AppMethodBeat.o(121984);
    return false;
  }
  
  public static final w ac(w paramw)
  {
    AppMethodBeat.i(121985);
    a.f.b.j.q(paramw, "receiver$0");
    Object localObject = aa(paramw);
    if (localObject == null)
    {
      AppMethodBeat.o(121985);
      return null;
    }
    paramw = paramw.ecq();
    localObject = ((au)localObject).edF();
    a.f.b.j.p(localObject, "parameter.name");
    paramw = (ah)a.a.j.i((Iterable)paramw.a((a.j.b.a.c.f.f)localObject, (a)c.CbE));
    if (paramw != null)
    {
      paramw = paramw.eer();
      AppMethodBeat.o(121985);
      return paramw;
    }
    AppMethodBeat.o(121985);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     a.j.b.a.c.i.f
 * JD-Core Version:    0.7.0.1
 */