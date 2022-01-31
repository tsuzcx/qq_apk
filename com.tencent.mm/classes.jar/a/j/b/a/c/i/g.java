package a.j.b.a.c.i;

import a.j.b.a.c.b.ah;
import a.j.b.a.c.b.aq;
import a.j.b.a.c.b.e;
import a.j.b.a.c.b.k;
import a.j.b.a.c.b.l;
import a.j.b.a.c.b.t;
import a.j.b.a.c.f.f;
import a.j.b.a.c.h.c;
import a.j.b.a.c.h.c.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Comparator;

public class g
  implements Comparator<l>
{
  public static final g CvX;
  private static final c CvY;
  
  static
  {
    AppMethodBeat.i(121993);
    if (!g.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      CvX = new g();
      c.a locala = c.CtD;
      CvY = c.a.h(new g.1());
      AppMethodBeat.o(121993);
      return;
    }
  }
  
  public static final class a
    implements Comparator<l>
  {
    public static final a CvZ;
    
    static
    {
      AppMethodBeat.i(121991);
      CvZ = new a();
      AppMethodBeat.o(121991);
    }
    
    private static int E(l paraml)
    {
      AppMethodBeat.i(121987);
      if (d.x(paraml))
      {
        AppMethodBeat.o(121987);
        return 8;
      }
      if ((paraml instanceof k))
      {
        AppMethodBeat.o(121987);
        return 7;
      }
      if ((paraml instanceof ah))
      {
        if (((ah)paraml).edp() == null)
        {
          AppMethodBeat.o(121987);
          return 6;
        }
        AppMethodBeat.o(121987);
        return 5;
      }
      if ((paraml instanceof t))
      {
        if (((t)paraml).edp() == null)
        {
          AppMethodBeat.o(121987);
          return 4;
        }
        AppMethodBeat.o(121987);
        return 3;
      }
      if ((paraml instanceof e))
      {
        AppMethodBeat.o(121987);
        return 2;
      }
      if ((paraml instanceof aq))
      {
        AppMethodBeat.o(121987);
        return 1;
      }
      AppMethodBeat.o(121987);
      return 0;
    }
    
    private static Integer f(l paraml1, l paraml2)
    {
      AppMethodBeat.i(121988);
      int i = E(paraml2) - E(paraml1);
      if (i != 0)
      {
        AppMethodBeat.o(121988);
        return Integer.valueOf(i);
      }
      if ((d.x(paraml1)) && (d.x(paraml2)))
      {
        AppMethodBeat.o(121988);
        return Integer.valueOf(0);
      }
      i = paraml1.edF().v(paraml2.edF());
      if (i != 0)
      {
        AppMethodBeat.o(121988);
        return Integer.valueOf(i);
      }
      AppMethodBeat.o(121988);
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     a.j.b.a.c.i.g
 * JD-Core Version:    0.7.0.1
 */