package a.j.b.a.c.d.a;

import a.f.b.j;
import a.j.b.a.c.a.g;
import a.j.b.a.c.b.a;
import a.j.b.a.c.b.b;
import a.j.b.a.c.b.l;
import a.j.b.a.c.d.b.r;
import a.j.b.a.c.f.f;
import a.j.b.a.c.i.e.a;
import a.j.b.a.c.i.e.b;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class m
  implements a.j.b.a.c.i.e
{
  public static final m.a CcT;
  
  static
  {
    AppMethodBeat.i(119700);
    CcT = new m.a((byte)0);
    AppMethodBeat.o(119700);
  }
  
  public final e.b a(a parama1, a parama2, a.j.b.a.c.b.e parame)
  {
    AppMethodBeat.i(119699);
    j.q(parama1, "superDescriptor");
    j.q(parama2, "subDescriptor");
    int i;
    if ((!(parama1 instanceof b)) || (!(parama2 instanceof a.j.b.a.c.b.t)) || (g.b((l)parama2))) {
      i = 0;
    }
    b localb;
    boolean bool;
    while (i != 0)
    {
      parama1 = e.b.CvU;
      AppMethodBeat.o(119699);
      return parama1;
      localObject = d.Ccu;
      localObject = ((a.j.b.a.c.b.t)parama2).edF();
      j.p(localObject, "subDescriptor.name");
      if (!d.h((f)localObject))
      {
        localObject = c.Ccl;
        localObject = ((a.j.b.a.c.b.t)parama2).edF();
        j.p(localObject, "subDescriptor.name");
        if (!c.f((f)localObject))
        {
          i = 0;
          continue;
        }
      }
      localb = t.p((b)parama1);
      bool = ((a.j.b.a.c.b.t)parama2).edQ();
      if ((parama1 instanceof a.j.b.a.c.b.t)) {
        break label379;
      }
    }
    label219:
    label379:
    for (Object localObject = null;; localObject = parama1)
    {
      localObject = (a.j.b.a.c.b.t)localObject;
      if ((localObject == null) || (bool != ((a.j.b.a.c.b.t)localObject).edQ())) {}
      for (i = 1;; i = 0)
      {
        if ((i == 0) || ((localb != null) && (((a.j.b.a.c.b.t)parama2).edQ()))) {
          break label219;
        }
        i = 1;
        break;
      }
      if ((!(parame instanceof a.j.b.a.c.d.a.b.d)) || (((a.j.b.a.c.b.t)parama2).edP() != null))
      {
        i = 0;
        break;
      }
      if ((localb == null) || (t.a(parame, (a)localb)))
      {
        i = 0;
        break;
      }
      if (((localb instanceof a.j.b.a.c.b.t)) && ((parama1 instanceof a.j.b.a.c.b.t)) && (d.e((a.j.b.a.c.b.t)localb) != null))
      {
        parame = r.a((a.j.b.a.c.b.t)parama2, false, false, 2);
        localObject = ((a.j.b.a.c.b.t)parama1).edO();
        j.p(localObject, "superDescriptor.original");
        if (j.e(parame, r.a((a.j.b.a.c.b.t)localObject, false, false, 2)))
        {
          i = 0;
          break;
        }
      }
      i = 1;
      break;
      if (m.a.a(parama1, parama2))
      {
        parama1 = e.b.CvU;
        AppMethodBeat.o(119699);
        return parama1;
      }
      parama1 = e.b.CvV;
      AppMethodBeat.o(119699);
      return parama1;
    }
  }
  
  public final e.a efw()
  {
    return e.a.CvO;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     a.j.b.a.c.d.a.m
 * JD-Core Version:    0.7.0.1
 */