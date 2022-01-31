package a.j.b.a.c.d.b;

import a.j.b.a.c.b.e;
import a.j.b.a.c.l.w;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;

public final class v
  implements u<j>
{
  public static final v Cjz;
  
  static
  {
    AppMethodBeat.i(120325);
    Cjz = new v();
    AppMethodBeat.o(120325);
  }
  
  public final void a(w paramw, e parame)
  {
    AppMethodBeat.i(120324);
    a.f.b.j.q(paramw, "kotlinType");
    a.f.b.j.q(parame, "descriptor");
    AppMethodBeat.o(120324);
  }
  
  public final w k(Collection<? extends w> paramCollection)
  {
    AppMethodBeat.i(120321);
    a.f.b.j.q(paramCollection, "types");
    paramCollection = (Throwable)new AssertionError("There should be no intersection type in existing descriptors, but found: " + a.a.j.a((Iterable)paramCollection, null, null, null, 0, null, null, 63));
    AppMethodBeat.o(120321);
    throw paramCollection;
  }
  
  public final String u(e parame)
  {
    AppMethodBeat.i(120323);
    a.f.b.j.q(parame, "classDescriptor");
    AppMethodBeat.o(120323);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     a.j.b.a.c.d.b.v
 * JD-Core Version:    0.7.0.1
 */