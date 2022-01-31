package a.j.b.a.c.i.e;

import a.f.b.j;
import a.j.b.a.c.b.aq;
import a.j.b.a.c.b.e;
import a.j.b.a.c.c.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Set;

public final class f
  extends i
{
  private final h CxQ;
  
  public f(h paramh)
  {
    AppMethodBeat.i(122192);
    this.CxQ = paramh;
    AppMethodBeat.o(122192);
  }
  
  public final a.j.b.a.c.b.h c(a.j.b.a.c.f.f paramf, a parama)
  {
    AppMethodBeat.i(122187);
    j.q(paramf, "name");
    j.q(parama, "location");
    paramf = this.CxQ.c(paramf, parama);
    if (paramf != null) {
      if ((paramf instanceof e)) {
        break label97;
      }
    }
    label97:
    for (parama = null;; parama = paramf)
    {
      parama = (e)parama;
      if (parama != null)
      {
        paramf = (a.j.b.a.c.b.h)parama;
        AppMethodBeat.o(122187);
        return paramf;
      }
      if (!(paramf instanceof aq)) {
        paramf = null;
      }
      for (;;)
      {
        paramf = (a.j.b.a.c.b.h)paramf;
        AppMethodBeat.o(122187);
        return paramf;
        AppMethodBeat.o(122187);
        return null;
      }
    }
  }
  
  public final Set<a.j.b.a.c.f.f> eeT()
  {
    AppMethodBeat.i(122189);
    Set localSet = this.CxQ.eeT();
    AppMethodBeat.o(122189);
    return localSet;
  }
  
  public final Set<a.j.b.a.c.f.f> eeU()
  {
    AppMethodBeat.i(122190);
    Set localSet = this.CxQ.eeU();
    AppMethodBeat.o(122190);
    return localSet;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(122191);
    String str = "Classes from " + this.CxQ;
    AppMethodBeat.o(122191);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     a.j.b.a.c.i.e.f
 * JD-Core Version:    0.7.0.1
 */