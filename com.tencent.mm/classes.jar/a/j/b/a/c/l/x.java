package a.j.b.a.c.l;

import a.f.b.j;
import a.j.b.a.c.b.a.g;
import a.j.b.a.c.b.aq;
import a.j.b.a.c.b.ar;
import a.j.b.a.c.b.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public final class x
{
  public static final x CBx;
  
  static
  {
    AppMethodBeat.i(122609);
    CBx = new x();
    AppMethodBeat.o(122609);
  }
  
  public static final ad a(g paramg, e parame, List<? extends ap> paramList)
  {
    AppMethodBeat.i(122607);
    j.q(paramg, "annotations");
    j.q(parame, "descriptor");
    j.q(paramList, "arguments");
    parame = parame.ecx();
    j.p(parame, "descriptor.typeConstructor");
    paramg = c(paramg, parame, paramList, false);
    AppMethodBeat.o(122607);
    return paramg;
  }
  
  public static final ad a(g paramg, an paraman, List<? extends ap> paramList, boolean paramBoolean, a.j.b.a.c.i.e.h paramh)
  {
    AppMethodBeat.i(122606);
    j.q(paramg, "annotations");
    j.q(paraman, "constructor");
    j.q(paramList, "arguments");
    j.q(paramh, "memberScope");
    paraman = new ae(paraman, paramList, paramBoolean, paramh);
    if (paramg.isEmpty())
    {
      paramg = (ad)paraman;
      AppMethodBeat.o(122606);
      return paramg;
    }
    paramg = (ad)new d((ad)paraman, paramg);
    AppMethodBeat.o(122606);
    return paramg;
  }
  
  public static final az a(ad paramad1, ad paramad2)
  {
    AppMethodBeat.i(122608);
    j.q(paramad1, "lowerBound");
    j.q(paramad2, "upperBound");
    if (j.e(paramad1, paramad2))
    {
      paramad1 = (az)paramad1;
      AppMethodBeat.o(122608);
      return paramad1;
    }
    paramad1 = (az)new r(paramad1, paramad2);
    AppMethodBeat.o(122608);
    return paramad1;
  }
  
  public static final ad c(g paramg, an paraman, List<? extends ap> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(122605);
    j.q(paramg, "annotations");
    j.q(paraman, "constructor");
    j.q(paramList, "arguments");
    if ((paramg.isEmpty()) && (paramList.isEmpty()) && (!paramBoolean) && (paraman.ecR() != null))
    {
      paramg = paraman.ecR();
      if (paramg == null) {
        j.ebi();
      }
      j.p(paramg, "constructor.declarationDescriptor!!");
      paramg = paramg.edE();
      j.p(paramg, "constructor.declarationDescriptor!!.defaultType");
      AppMethodBeat.o(122605);
      return paramg;
    }
    Object localObject = paraman.ecR();
    if ((localObject instanceof ar)) {
      localObject = ((a.j.b.a.c.b.h)localObject).edE().ecq();
    }
    for (;;)
    {
      paramg = a(paramg, paraman, paramList, paramBoolean, (a.j.b.a.c.i.e.h)localObject);
      AppMethodBeat.o(122605);
      return paramg;
      if ((localObject instanceof e))
      {
        if (paramList.isEmpty())
        {
          localObject = ((e)localObject).edE().ecq();
        }
        else
        {
          localObject = (e)localObject;
          ao.a locala = ao.CBF;
          localObject = ((e)localObject).a(ao.a.a(paraman, paramList));
          j.p(localObject, "descriptor.getMemberScop…(constructor, arguments))");
        }
      }
      else
      {
        if (!(localObject instanceof aq)) {
          break;
        }
        localObject = p.cE("Scope for abbreviation: " + ((aq)localObject).edF(), true);
        j.p(localObject, "ErrorUtils.createErrorSc…{descriptor.name}\", true)");
      }
    }
    paramg = (Throwable)new IllegalStateException("Unsupported classifier: " + localObject + " for constructor: " + paraman);
    AppMethodBeat.o(122605);
    throw paramg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     a.j.b.a.c.l.x
 * JD-Core Version:    0.7.0.1
 */