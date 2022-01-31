package a.j.b.a.c.l.a;

import a.f.b.j;
import a.j.b.a.c.b.l;
import a.j.b.a.c.l.an;
import a.j.b.a.c.l.ao;
import a.j.b.a.c.l.ao.a;
import a.j.b.a.c.l.ap;
import a.j.b.a.c.l.as;
import a.j.b.a.c.l.au;
import a.j.b.a.c.l.av;
import a.j.b.a.c.l.ba;
import a.j.b.a.c.l.d.a;
import a.j.b.a.c.l.d.b;
import a.j.b.a.c.l.w;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;

public final class t
{
  public static final w a(w paramw1, w paramw2, r paramr)
  {
    AppMethodBeat.i(122811);
    j.q(paramw1, "subtype");
    j.q(paramw2, "supertype");
    j.q(paramr, "typeCheckingProcedureCallbacks");
    Object localObject1 = new ArrayDeque();
    ((ArrayDeque)localObject1).add(new n(paramw1, null));
    an localan = paramw2.enU();
    while (!((ArrayDeque)localObject1).isEmpty())
    {
      paramw2 = (n)((ArrayDeque)localObject1).poll();
      paramw1 = paramw2.BPZ;
      Object localObject2 = paramw1.enU();
      if (paramr.b((an)localObject2, localan))
      {
        boolean bool = paramw1.egH();
        paramw2 = paramw2.CCt;
        if (paramw2 != null)
        {
          localObject1 = paramw2.BPZ;
          localObject2 = (Iterable)((w)localObject1).enR();
          label155:
          int i;
          if ((!(localObject2 instanceof Collection)) || (!((Collection)localObject2).isEmpty()))
          {
            localObject2 = ((Iterable)localObject2).iterator();
            if (((Iterator)localObject2).hasNext()) {
              if (((ap)((Iterator)localObject2).next()).eoO() != ba.CBX)
              {
                i = 1;
                label188:
                if (i == 0) {
                  break label260;
                }
                i = 1;
                label194:
                if (i == 0) {
                  break label267;
                }
                localObject2 = ao.CBF;
                paramw1 = a.j.b.a.c.i.a.a.c.c(ao.a.au((w)localObject1)).eoP().b(paramw1, ba.CBX);
                j.p(paramw1, "TypeConstructorSubstitut…uted, Variance.INVARIANT)");
                paramw1 = aK(paramw1);
                label233:
                if ((!bool) && (!((w)localObject1).egH())) {
                  break label297;
                }
              }
            }
          }
          label260:
          label267:
          label297:
          for (bool = true;; bool = false)
          {
            paramw2 = paramw2.CCt;
            break;
            i = 0;
            break label188;
            break label155;
            i = 0;
            break label194;
            localObject2 = ao.CBF;
            paramw1 = ao.a.au((w)localObject1).eoP().b(paramw1, ba.CBX);
            j.p(paramw1, "TypeConstructorSubstitut…uted, Variance.INVARIANT)");
            break label233;
          }
        }
        paramw2 = paramw1.enU();
        if (!paramr.b(paramw2, localan))
        {
          paramw1 = (Throwable)new AssertionError("Type constructors should be equals!\nsubstitutedSuperType: " + d(paramw2) + ", \n\nsupertype: " + d(localan) + " \n" + paramr.b(paramw2, localan));
          AppMethodBeat.o(122811);
          throw paramw1;
        }
        paramw1 = av.a(paramw1, bool);
        AppMethodBeat.o(122811);
        return paramw1;
      }
      paramw1 = ((an)localObject2).eeO().iterator();
      while (paramw1.hasNext())
      {
        localObject2 = (w)paramw1.next();
        j.p(localObject2, "immediateSupertype");
        ((ArrayDeque)localObject1).add(new n((w)localObject2, paramw2));
      }
    }
    AppMethodBeat.o(122811);
    return null;
  }
  
  private static final w aK(w paramw)
  {
    AppMethodBeat.i(122812);
    paramw = (w)b.aO(paramw).CDd;
    AppMethodBeat.o(122812);
    return paramw;
  }
  
  private static final String d(an paraman)
  {
    AppMethodBeat.i(122813);
    StringBuilder localStringBuilder = new StringBuilder();
    t.a locala = new t.a(localStringBuilder);
    locala.azm("type: ".concat(String.valueOf(paraman)));
    locala.azm("hashCode: " + paraman.hashCode());
    locala.azm("javaClass: " + paraman.getClass().getCanonicalName());
    for (paraman = (l)paraman.ecR(); paraman != null; paraman = paraman.ecv())
    {
      locala.azm("fqName: " + a.j.b.a.c.h.c.Ctz.k(paraman));
      locala.azm("javaClass: " + paraman.getClass().getCanonicalName());
    }
    paraman = localStringBuilder.toString();
    j.p(paraman, "StringBuilder().apply(builderAction).toString()");
    AppMethodBeat.o(122813);
    return paraman;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     a.j.b.a.c.l.a.t
 * JD-Core Version:    0.7.0.1
 */