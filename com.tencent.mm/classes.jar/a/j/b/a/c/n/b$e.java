package a.j.b.a.c.n;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;
import java.util.Set;

public final class b$e<N>
  implements b.d<N>
{
  private final Set<N> CEB;
  
  public b$e()
  {
    this(new HashSet());
    AppMethodBeat.i(122921);
    AppMethodBeat.o(122921);
  }
  
  private b$e(Set<N> paramSet)
  {
    this.CEB = paramSet;
  }
  
  public final boolean dQ(N paramN)
  {
    AppMethodBeat.i(122922);
    boolean bool = this.CEB.add(paramN);
    AppMethodBeat.o(122922);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     a.j.b.a.c.n.b.e
 * JD-Core Version:    0.7.0.1
 */