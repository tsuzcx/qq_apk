package a.j.b.a.c.h;

import a.f.b.j;
import a.j.b.a.c.b.ab;
import a.j.b.a.c.b.ar;
import a.j.b.a.c.b.e;
import a.j.b.a.c.b.h;
import a.j.b.a.c.b.l;
import a.j.b.a.c.f.f;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b$c
  implements b
{
  public static final c Ctt;
  
  static
  {
    AppMethodBeat.i(121706);
    Ctt = new c();
    AppMethodBeat.o(121706);
  }
  
  private final String a(h paramh)
  {
    AppMethodBeat.i(121704);
    Object localObject = paramh.edF();
    j.p(localObject, "descriptor.name");
    localObject = q.y((f)localObject);
    if ((paramh instanceof ar))
    {
      AppMethodBeat.o(121704);
      return localObject;
    }
    paramh = paramh.ecv();
    j.p(paramh, "descriptor.containingDeclaration");
    paramh = j(paramh);
    if ((paramh != null) && ((j.e(paramh, "") ^ true)))
    {
      paramh = paramh + "." + (String)localObject;
      AppMethodBeat.o(121704);
      return paramh;
    }
    AppMethodBeat.o(121704);
    return localObject;
  }
  
  private final String j(l paraml)
  {
    AppMethodBeat.i(121705);
    if ((paraml instanceof e))
    {
      paraml = a((h)paraml);
      AppMethodBeat.o(121705);
      return paraml;
    }
    if ((paraml instanceof ab))
    {
      paraml = ((ab)paraml).eee().CqE;
      j.p(paraml, "descriptor.fqName.toUnsafe()");
      paraml = q.g(paraml);
      AppMethodBeat.o(121705);
      return paraml;
    }
    AppMethodBeat.o(121705);
    return null;
  }
  
  public final String a(h paramh, c paramc)
  {
    AppMethodBeat.i(121703);
    j.q(paramh, "classifier");
    j.q(paramc, "renderer");
    paramh = a(paramh);
    AppMethodBeat.o(121703);
    return paramh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     a.j.b.a.c.h.b.c
 * JD-Core Version:    0.7.0.1
 */