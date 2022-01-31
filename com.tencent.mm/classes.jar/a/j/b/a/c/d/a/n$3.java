package a.j.b.a.c.d.a;

import a.j.b.a.c.b.ay;
import a.j.b.a.c.b.az;
import a.j.b.a.c.b.l;
import a.j.b.a.c.b.p;
import a.j.b.a.c.i.e.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class n$3
  extends az
{
  n$3(String paramString)
  {
    super(paramString, true);
  }
  
  public final boolean b(e parame, p paramp, l paraml)
  {
    AppMethodBeat.i(119704);
    boolean bool = n.c(parame, paramp, paraml);
    AppMethodBeat.o(119704);
    return bool;
  }
  
  public final Integer c(az paramaz)
  {
    AppMethodBeat.i(119705);
    if (this == paramaz)
    {
      AppMethodBeat.o(119705);
      return Integer.valueOf(0);
    }
    if (paramaz == ay.BWN)
    {
      AppMethodBeat.o(119705);
      return null;
    }
    if (ay.b(paramaz))
    {
      AppMethodBeat.o(119705);
      return Integer.valueOf(1);
    }
    AppMethodBeat.o(119705);
    return Integer.valueOf(-1);
  }
  
  public final az eeF()
  {
    return ay.BWM;
  }
  
  public final String getDisplayName()
  {
    return "protected/*protected and package*/";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     a.j.b.a.c.d.a.n.3
 * JD-Core Version:    0.7.0.1
 */