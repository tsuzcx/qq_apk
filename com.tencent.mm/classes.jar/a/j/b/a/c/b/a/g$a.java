package a.j.b.a.c.b.a;

import a.f.b.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public final class g$a
{
  private static final g BXy;
  
  static
  {
    AppMethodBeat.i(119333);
    BXz = new a();
    BXy = (g)new g.a.a();
    AppMethodBeat.o(119333);
  }
  
  public static g eeH()
  {
    return BXy;
  }
  
  public static g fZ(List<? extends c> paramList)
  {
    AppMethodBeat.i(119332);
    j.q(paramList, "annotations");
    if (paramList.isEmpty())
    {
      paramList = BXy;
      AppMethodBeat.o(119332);
      return paramList;
    }
    paramList = (g)new h(paramList);
    AppMethodBeat.o(119332);
    return paramList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     a.j.b.a.c.b.a.g.a
 * JD-Core Version:    0.7.0.1
 */