package a.j.b.a.c.l.a;

import a.f.b.j;
import a.j.b.a.c.l.ad;
import a.j.b.a.c.l.ag;
import a.j.b.a.c.l.ap;
import a.j.b.a.c.l.az;
import a.j.b.a.c.l.q;
import a.j.b.a.c.l.w;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.List;

public final class m
{
  public static final m CCs;
  
  static
  {
    AppMethodBeat.i(122761);
    CCs = new m();
    AppMethodBeat.o(122761);
  }
  
  public final boolean a(az paramaz1, az paramaz2)
  {
    AppMethodBeat.i(122759);
    j.q(paramaz1, "a");
    j.q(paramaz2, "b");
    if (paramaz1 == paramaz2)
    {
      AppMethodBeat.o(122759);
      return true;
    }
    if (((paramaz1 instanceof ad)) && ((paramaz2 instanceof ad)))
    {
      boolean bool = c((ad)paramaz1, (ad)paramaz2);
      AppMethodBeat.o(122759);
      return bool;
    }
    if (((paramaz1 instanceof q)) && ((paramaz2 instanceof q)))
    {
      if ((c(((q)paramaz1).CBm, ((q)paramaz2).CBm)) && (c(((q)paramaz1).CBn, ((q)paramaz2).CBn)))
      {
        AppMethodBeat.o(122759);
        return true;
      }
      AppMethodBeat.o(122759);
      return false;
    }
    AppMethodBeat.o(122759);
    return false;
  }
  
  public final boolean c(ad paramad1, ad paramad2)
  {
    AppMethodBeat.i(122760);
    j.q(paramad1, "a");
    j.q(paramad2, "b");
    if ((paramad1.egH() != paramad2.egH()) || (ag.ap((w)paramad1) != ag.ap((w)paramad2)) || ((j.e(paramad1.enU(), paramad2.enU()) ^ true)) || (paramad1.enR().size() != paramad2.enR().size()))
    {
      AppMethodBeat.o(122760);
      return false;
    }
    if (paramad1.enR() == paramad2.enR())
    {
      AppMethodBeat.o(122760);
      return true;
    }
    int j = ((Collection)paramad1.enR()).size();
    int i = 0;
    while (i < j)
    {
      ap localap1 = (ap)paramad1.enR().get(i);
      ap localap2 = (ap)paramad2.enR().get(i);
      if (localap1.eoN() != localap2.eoN())
      {
        AppMethodBeat.o(122760);
        return false;
      }
      if (!localap1.eoN())
      {
        if (localap1.eoO() != localap2.eoO())
        {
          AppMethodBeat.o(122760);
          return false;
        }
        if (!a(localap1.eer().eoL(), localap2.eer().eoL()))
        {
          AppMethodBeat.o(122760);
          return false;
        }
      }
      i += 1;
    }
    AppMethodBeat.o(122760);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     a.j.b.a.c.l.a.m
 * JD-Core Version:    0.7.0.1
 */