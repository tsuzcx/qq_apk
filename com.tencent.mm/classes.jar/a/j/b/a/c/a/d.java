package a.j.b.a.c.a;

import a.j.b.a.c.b.e;
import a.j.b.a.c.b.l;
import a.j.b.a.c.f.b;
import a.j.b.a.c.f.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public final class d
{
  private static final LinkedHashSet<a.j.b.a.c.f.a> BRD;
  public static final d BRE;
  
  static
  {
    AppMethodBeat.i(119074);
    BRE = new d();
    Object localObject1 = h.BTM;
    a.f.b.j.p(localObject1, "PrimitiveType.NUMBER_TYPES");
    Object localObject2 = (Iterable)localObject1;
    localObject1 = (Collection)new ArrayList(a.a.j.d((Iterable)localObject2));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((Collection)localObject1).add(g.c((h)((Iterator)localObject2).next()));
    }
    localObject2 = (Iterable)a.a.j.a((Collection)a.a.j.a((Collection)a.a.j.a((Collection)localObject1, g.BRU.BSg.emf()), g.BRU.BSi.emf()), g.BRU.BSr.emf());
    localObject1 = (Collection)new LinkedHashSet();
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((Collection)localObject1).add(a.j.b.a.c.f.a.n((b)((Iterator)localObject2).next()));
    }
    BRD = (LinkedHashSet)localObject1;
    AppMethodBeat.o(119074);
  }
  
  public static boolean b(e parame)
  {
    AppMethodBeat.i(119073);
    a.f.b.j.q(parame, "classDescriptor");
    if (a.j.b.a.c.i.d.u((l)parame))
    {
      Iterable localIterable = (Iterable)BRD;
      parame = a.j.b.a.c.i.c.a.c((a.j.b.a.c.b.h)parame);
      if (parame != null) {}
      for (parame = parame.ema(); a.a.j.a(localIterable, parame); parame = null)
      {
        AppMethodBeat.o(119073);
        return true;
      }
    }
    AppMethodBeat.o(119073);
    return false;
  }
  
  public static Set<a.j.b.a.c.f.a> ece()
  {
    AppMethodBeat.i(119072);
    Set localSet = Collections.unmodifiableSet((Set)BRD);
    a.f.b.j.p(localSet, "Collections.unmodifiableSet(classIds)");
    AppMethodBeat.o(119072);
    return localSet;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     a.j.b.a.c.a.d
 * JD-Core Version:    0.7.0.1
 */