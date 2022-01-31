package a.j.b.a.c.b;

import a.f.b.k;
import a.j.b.a.c.f.f;
import a.j.b.a.c.i.e.h;
import a.k.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.List;

public final class s
{
  public static final e a(y paramy, a.j.b.a.c.f.a parama)
  {
    AppMethodBeat.i(119273);
    a.f.b.j.q(paramy, "receiver$0");
    a.f.b.j.q(parama, "classId");
    Object localObject = parama.BUK;
    a.f.b.j.p(localObject, "classId.packageFqName");
    paramy = paramy.g((a.j.b.a.c.f.b)localObject);
    localObject = parama.CqB.CqE.emj();
    a.f.b.j.p(localObject, "classId.relativeClassName.pathSegments()");
    paramy = paramy.ecq();
    parama = a.a.j.fQ((List)localObject);
    a.f.b.j.p(parama, "segments.first()");
    parama = paramy.c((f)parama, (a.j.b.a.c.c.a.a)a.j.b.a.c.c.a.c.CbK);
    paramy = parama;
    if (!(parama instanceof e)) {
      paramy = null;
    }
    paramy = (e)paramy;
    if (paramy == null)
    {
      AppMethodBeat.o(119273);
      return null;
    }
    localObject = ((List)localObject).subList(1, ((List)localObject).size()).iterator();
    while (((Iterator)localObject).hasNext())
    {
      parama = (f)((Iterator)localObject).next();
      paramy = paramy.edJ();
      a.f.b.j.p(parama, "name");
      parama = paramy.c(parama, (a.j.b.a.c.c.a.a)a.j.b.a.c.c.a.c.CbK);
      paramy = parama;
      if (!(parama instanceof e)) {
        paramy = null;
      }
      paramy = (e)paramy;
      if (paramy == null)
      {
        AppMethodBeat.o(119273);
        return null;
      }
    }
    AppMethodBeat.o(119273);
    return paramy;
  }
  
  public static final e a(y paramy, a.j.b.a.c.f.a parama, aa paramaa)
  {
    AppMethodBeat.i(119274);
    a.f.b.j.q(paramy, "receiver$0");
    a.f.b.j.q(parama, "classId");
    a.f.b.j.q(paramaa, "notFoundClasses");
    paramy = a(paramy, parama);
    if (paramy != null)
    {
      AppMethodBeat.o(119274);
      return paramy;
    }
    paramy = paramaa.a(parama, i.c(i.d(i.a(parama, (a.f.a.b)s.a.BWn), (a.f.a.b)b.BWo)));
    AppMethodBeat.o(119274);
    return paramy;
  }
  
  static final class b
    extends k
    implements a.f.a.b<a.j.b.a.c.f.a, Integer>
  {
    public static final b BWo;
    
    static
    {
      AppMethodBeat.i(119272);
      BWo = new b();
      AppMethodBeat.o(119272);
    }
    
    b()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     a.j.b.a.c.b.s
 * JD-Core Version:    0.7.0.1
 */