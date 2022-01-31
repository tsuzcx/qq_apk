package a.j.b.a.c.b.a;

import a.aa;
import a.f.b.j;
import a.j.b.a.c.b.ar;
import a.j.b.a.c.b.au;
import a.j.b.a.c.b.ay;
import a.j.b.a.c.b.t;
import a.j.b.a.c.b.v;
import a.j.b.a.c.i.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Iterator;

public final class f
{
  private static final a.j.b.a.c.f.f BXq;
  private static final a.j.b.a.c.f.f BXr;
  private static final a.j.b.a.c.f.f BXs;
  private static final a.j.b.a.c.f.f BXt;
  private static final a.j.b.a.c.f.f BXu;
  private static final a.j.b.a.c.f.b BXv;
  
  static
  {
    AppMethodBeat.i(119328);
    a.j.b.a.c.f.f localf = a.j.b.a.c.f.f.ayT("message");
    j.p(localf, "Name.identifier(\"message\")");
    BXq = localf;
    localf = a.j.b.a.c.f.f.ayT("replaceWith");
    j.p(localf, "Name.identifier(\"replaceWith\")");
    BXr = localf;
    localf = a.j.b.a.c.f.f.ayT("level");
    j.p(localf, "Name.identifier(\"level\")");
    BXs = localf;
    localf = a.j.b.a.c.f.f.ayT("expression");
    j.p(localf, "Name.identifier(\"expression\")");
    BXt = localf;
    localf = a.j.b.a.c.f.f.ayT("imports");
    j.p(localf, "Name.identifier(\"imports\")");
    BXu = localf;
    BXv = new a.j.b.a.c.f.b("kotlin.internal.InlineOnly");
    AppMethodBeat.o(119328);
  }
  
  public static final boolean a(v paramv)
  {
    AppMethodBeat.i(119325);
    j.q(paramv, "receiver$0");
    j.q(paramv, "receiver$0");
    if ((paramv instanceof a.j.b.a.c.b.b))
    {
      Object localObject;
      if (!e((a.j.b.a.c.b.b)paramv))
      {
        localObject = d.v((a.j.b.a.c.b.b)paramv);
        j.p(localObject, "DescriptorUtils.getDirectMember(this)");
        if (!e((a.j.b.a.c.b.b)localObject))
        {
          j.q(paramv, "receiver$0");
          if ((paramv instanceof t))
          {
            if (f((a.j.b.a.c.b.b)paramv)) {
              break label246;
            }
            localObject = d.v((a.j.b.a.c.b.b)paramv);
            j.p(localObject, "DescriptorUtils.getDirectMember(this)");
            if (f((a.j.b.a.c.b.b)localObject)) {
              break label246;
            }
          }
          i = 0;
          if (i == 0) {
            break label298;
          }
        }
      }
      i = 1;
      label107:
      if (i == 0)
      {
        if ((!(paramv instanceof t)) || (!((t)paramv).edU()) || (!((t)paramv).ecI())) {
          break label308;
        }
        localObject = ((t)paramv).edu();
        j.p(localObject, "valueParameters");
        localObject = (Iterable)localObject;
        if (((localObject instanceof Collection)) && (((Collection)localObject).isEmpty())) {
          break label303;
        }
        localObject = ((Iterable)localObject).iterator();
        do
        {
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
        } while (!((au)((Iterator)localObject).next()).eew());
      }
    }
    label298:
    label303:
    for (int i = 1;; i = 0)
    {
      if ((i == 0) && (!j.e(((t)paramv).ecE(), ay.BWK))) {
        break label308;
      }
      AppMethodBeat.o(119325);
      return true;
      label246:
      boolean bool = ((t)paramv).ecI();
      if ((aa.BMh) && (!bool))
      {
        paramv = (Throwable)new AssertionError("Function is not inline: ".concat(String.valueOf(paramv)));
        AppMethodBeat.o(119325);
        throw paramv;
      }
      i = 1;
      break;
      i = 0;
      break label107;
    }
    label308:
    AppMethodBeat.o(119325);
    return false;
  }
  
  private static final boolean e(a.j.b.a.c.b.b paramb)
  {
    AppMethodBeat.i(119326);
    paramb = paramb.edr();
    j.p(paramb, "typeParameters");
    paramb = (Iterable)paramb;
    if ((!(paramb instanceof Collection)) || (!((Collection)paramb).isEmpty()))
    {
      paramb = paramb.iterator();
      while (paramb.hasNext())
      {
        ar localar = (ar)paramb.next();
        j.p(localar, "it");
        if (localar.edH())
        {
          AppMethodBeat.o(119326);
          return true;
        }
      }
    }
    AppMethodBeat.o(119326);
    return false;
  }
  
  private static final boolean f(a.j.b.a.c.b.b paramb)
  {
    AppMethodBeat.i(119327);
    boolean bool = paramb.ecM().j(BXv);
    AppMethodBeat.o(119327);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     a.j.b.a.c.b.a.f
 * JD-Core Version:    0.7.0.1
 */