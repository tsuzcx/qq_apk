package a.j.b.a.c.i;

import a.aa;
import a.f.b.j;
import a.j.b.a.c.b.ay;
import a.j.b.a.c.b.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Iterator;

public final class l
{
  public static final b l(Collection<? extends b> paramCollection)
  {
    AppMethodBeat.i(122041);
    j.q(paramCollection, "descriptors");
    if (!paramCollection.isEmpty()) {}
    for (int i = 1; (aa.BMh) && (i == 0); i = 0)
    {
      paramCollection = (Throwable)new AssertionError("Assertion failed");
      AppMethodBeat.o(122041);
      throw paramCollection;
    }
    Iterator localIterator = paramCollection.iterator();
    paramCollection = null;
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if (paramCollection == null)
      {
        paramCollection = localb;
      }
      else
      {
        Integer localInteger = ay.b(paramCollection.ecE(), localb.ecE());
        if ((localInteger == null) || (localInteger.intValue() >= 0)) {
          break label143;
        }
        paramCollection = localb;
      }
    }
    label143:
    for (;;)
    {
      break;
      if (paramCollection == null) {
        j.ebi();
      }
      AppMethodBeat.o(122041);
      return paramCollection;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     a.j.b.a.c.i.l
 * JD-Core Version:    0.7.0.1
 */