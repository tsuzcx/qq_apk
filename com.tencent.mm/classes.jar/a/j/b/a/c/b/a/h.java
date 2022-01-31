package a.j.b.a.c.b.a;

import a.f.b.j;
import a.j.b.a.c.f.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.List;

public final class h
  implements g
{
  private final List<c> BXA;
  
  public h(List<? extends c> paramList)
  {
    AppMethodBeat.i(119339);
    this.BXA = paramList;
    AppMethodBeat.o(119339);
  }
  
  public final c i(b paramb)
  {
    AppMethodBeat.i(119340);
    j.q(paramb, "fqName");
    paramb = g.b.a(this, paramb);
    AppMethodBeat.o(119340);
    return paramb;
  }
  
  public final boolean isEmpty()
  {
    AppMethodBeat.i(119336);
    boolean bool = this.BXA.isEmpty();
    AppMethodBeat.o(119336);
    return bool;
  }
  
  public final Iterator<c> iterator()
  {
    AppMethodBeat.i(119337);
    Iterator localIterator = this.BXA.iterator();
    AppMethodBeat.o(119337);
    return localIterator;
  }
  
  public final boolean j(b paramb)
  {
    AppMethodBeat.i(119341);
    j.q(paramb, "fqName");
    boolean bool = g.b.b(this, paramb);
    AppMethodBeat.o(119341);
    return bool;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(119338);
    String str = this.BXA.toString();
    AppMethodBeat.o(119338);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     a.j.b.a.c.b.a.h
 * JD-Core Version:    0.7.0.1
 */