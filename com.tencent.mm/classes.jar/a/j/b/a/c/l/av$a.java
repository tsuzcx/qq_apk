package a.j.b.a.c.l;

import a.j.b.a.c.b.a.g;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class av$a
  extends i
{
  private final String name;
  
  public av$a(String paramString)
  {
    this.name = paramString;
  }
  
  public final ad d(g paramg)
  {
    AppMethodBeat.i(122682);
    paramg = new IllegalStateException(this.name);
    AppMethodBeat.o(122682);
    throw paramg;
  }
  
  protected final ad efX()
  {
    AppMethodBeat.i(122681);
    IllegalStateException localIllegalStateException = new IllegalStateException(this.name);
    AppMethodBeat.o(122681);
    throw localIllegalStateException;
  }
  
  public final ad ss(boolean paramBoolean)
  {
    AppMethodBeat.i(122683);
    IllegalStateException localIllegalStateException = new IllegalStateException(this.name);
    AppMethodBeat.o(122683);
    throw localIllegalStateException;
  }
  
  public final String toString()
  {
    return this.name;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     a.j.b.a.c.l.av.a
 * JD-Core Version:    0.7.0.1
 */