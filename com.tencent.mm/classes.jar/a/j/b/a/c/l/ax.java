package a.j.b.a.c.l;

import a.f.b.j;
import a.m;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ax
{
  public static final az a(az paramaz, w paramw)
  {
    AppMethodBeat.i(122702);
    j.q(paramaz, "receiver$0");
    j.q(paramw, "origin");
    paramaz = b(paramaz, aG(paramw));
    AppMethodBeat.o(122702);
    return paramaz;
  }
  
  public static final w aG(w paramw)
  {
    AppMethodBeat.i(122701);
    j.q(paramw, "receiver$0");
    if ((paramw instanceof aw))
    {
      paramw = ((aw)paramw).eoJ();
      AppMethodBeat.o(122701);
      return paramw;
    }
    AppMethodBeat.o(122701);
    return null;
  }
  
  public static final az b(az paramaz, w paramw)
  {
    AppMethodBeat.i(122703);
    j.q(paramaz, "receiver$0");
    if (paramw == null)
    {
      AppMethodBeat.o(122703);
      return paramaz;
    }
    if ((paramaz instanceof ad))
    {
      paramaz = (az)new af((ad)paramaz, paramw);
      AppMethodBeat.o(122703);
      return paramaz;
    }
    if ((paramaz instanceof q))
    {
      paramaz = (az)new s((q)paramaz, paramw);
      AppMethodBeat.o(122703);
      return paramaz;
    }
    paramaz = new m();
    AppMethodBeat.o(122703);
    throw paramaz;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     a.j.b.a.c.l.ax
 * JD-Core Version:    0.7.0.1
 */