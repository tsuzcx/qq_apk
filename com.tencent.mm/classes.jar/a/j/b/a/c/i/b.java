package a.j.b.a.c.i;

import a.f.a.m;
import a.j.b.a.c.b.a;
import a.j.b.a.c.b.ab;
import a.j.b.a.c.b.ar;
import a.j.b.a.c.b.e;
import a.j.b.a.c.b.l;
import a.j.b.a.c.l.a.c.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
{
  public static final b Cvz;
  
  static
  {
    AppMethodBeat.i(121926);
    Cvz = new b();
    AppMethodBeat.o(121926);
  }
  
  private final boolean a(ar paramar1, ar paramar2, m<? super l, ? super l, Boolean> paramm)
  {
    AppMethodBeat.i(121924);
    if (a.f.b.j.e(paramar1, paramar2))
    {
      AppMethodBeat.o(121924);
      return true;
    }
    if (a.f.b.j.e(paramar1.ecv(), paramar2.ecv()))
    {
      AppMethodBeat.o(121924);
      return false;
    }
    if (!a((l)paramar1, (l)paramar2, paramm))
    {
      AppMethodBeat.o(121924);
      return false;
    }
    if (paramar1.getIndex() == paramar2.getIndex())
    {
      AppMethodBeat.o(121924);
      return true;
    }
    AppMethodBeat.o(121924);
    return false;
  }
  
  private final boolean a(l paraml1, l paraml2, m<? super l, ? super l, Boolean> paramm)
  {
    AppMethodBeat.i(121925);
    paraml1 = paraml1.ecv();
    paraml2 = paraml2.ecv();
    if (((paraml1 instanceof a.j.b.a.c.b.b)) || ((paraml2 instanceof a.j.b.a.c.b.b)))
    {
      bool = ((Boolean)paramm.h(paraml1, paraml2)).booleanValue();
      AppMethodBeat.o(121925);
      return bool;
    }
    boolean bool = d(paraml1, paraml2);
    AppMethodBeat.o(121925);
    return bool;
  }
  
  public final boolean d(l paraml1, l paraml2)
  {
    AppMethodBeat.i(121923);
    if (((paraml1 instanceof e)) && ((paraml2 instanceof e)))
    {
      paraml1 = (e)paraml1;
      paraml2 = (e)paraml2;
      bool = a.f.b.j.e(paraml1.ecx(), paraml2.ecx());
      AppMethodBeat.o(121923);
      return bool;
    }
    if (((paraml1 instanceof ar)) && ((paraml2 instanceof ar)))
    {
      bool = a((ar)paraml1, (ar)paraml2, (m)b.c.CvE);
      AppMethodBeat.o(121923);
      return bool;
    }
    if (((paraml1 instanceof a)) && ((paraml2 instanceof a)))
    {
      paraml1 = (a)paraml1;
      paraml2 = (a)paraml2;
      a.f.b.j.q(paraml1, "a");
      a.f.b.j.q(paraml2, "b");
      if (a.f.b.j.e(paraml1, paraml2))
      {
        AppMethodBeat.o(121923);
        return true;
      }
      if ((!(a.f.b.j.e(paraml1.edF(), paraml2.edF()) ^ true)) && (!a.f.b.j.e(paraml1.ecv(), paraml2.ecv())))
      {
        if ((d.m((l)paraml1)) || (d.m((l)paraml2)))
        {
          AppMethodBeat.o(121923);
          return false;
        }
        if (a((l)paraml1, (l)paraml2, (m)b.a.CvA))
        {
          j localj = j.a((c.a)new b.b(paraml1, paraml2));
          a.f.b.j.p(localj, "OverridingUtil.createWit…= a && y == b})\n        }");
          j.a locala = localj.a(paraml1, paraml2, null, true);
          a.f.b.j.p(locala, "overridingUtil.isOverrid… null, !ignoreReturnType)");
          if (locala.Cwn == j.a.a.Cwp)
          {
            paraml1 = localj.a(paraml2, paraml1, null, true);
            a.f.b.j.p(paraml1, "overridingUtil.isOverrid… null, !ignoreReturnType)");
            if (paraml1.Cwn == j.a.a.Cwp)
            {
              AppMethodBeat.o(121923);
              return true;
            }
          }
        }
      }
      AppMethodBeat.o(121923);
      return false;
    }
    if (((paraml1 instanceof ab)) && ((paraml2 instanceof ab)))
    {
      bool = a.f.b.j.e(((ab)paraml1).eee(), ((ab)paraml2).eee());
      AppMethodBeat.o(121923);
      return bool;
    }
    boolean bool = a.f.b.j.e(paraml1, paraml2);
    AppMethodBeat.o(121923);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     a.j.b.a.c.i.b
 * JD-Core Version:    0.7.0.1
 */