package a.j.b.a.c.b;

import a.f.b.j;
import a.j.b.a.c.c.a.a;
import a.j.b.a.c.f.b;
import a.j.b.a.c.f.c;
import a.j.b.a.c.f.f;
import a.j.b.a.c.i.e.h;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class q
{
  public static final e a(y paramy, b paramb, a parama)
  {
    AppMethodBeat.i(119267);
    j.q(paramy, "receiver$0");
    j.q(paramb, "fqName");
    j.q(parama, "lookupLocation");
    if (paramb.CqE.CqJ.isEmpty())
    {
      AppMethodBeat.o(119267);
      return null;
    }
    Object localObject1 = paramb.emd();
    j.p(localObject1, "fqName.parent()");
    localObject1 = paramy.g((b)localObject1).ecq();
    Object localObject2 = paramb.CqE.emh();
    j.p(localObject2, "fqName.shortName()");
    localObject2 = ((h)localObject1).c((f)localObject2, parama);
    localObject1 = localObject2;
    if (!(localObject2 instanceof e)) {
      localObject1 = null;
    }
    localObject1 = (e)localObject1;
    if (localObject1 != null)
    {
      AppMethodBeat.o(119267);
      return localObject1;
    }
    localObject1 = paramb.emd();
    j.p(localObject1, "fqName.parent()");
    paramy = a(paramy, (b)localObject1, parama);
    if (paramy != null)
    {
      paramy = paramy.edJ();
      if (paramy != null)
      {
        paramb = paramb.CqE.emh();
        j.p(paramb, "fqName.shortName()");
      }
    }
    for (paramy = paramy.c(paramb, parama);; paramy = null)
    {
      paramb = paramy;
      if (!(paramy instanceof e)) {
        paramb = null;
      }
      paramy = (e)paramb;
      AppMethodBeat.o(119267);
      return paramy;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     a.j.b.a.c.b.q
 * JD-Core Version:    0.7.0.1
 */