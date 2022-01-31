package a.j.b.a.c.l;

import a.j.b.a.c.a.g;
import a.j.b.a.c.b.ar;
import a.j.b.a.c.b.i;
import a.j.b.a.c.b.l;
import a.j.b.a.c.i.c.a;
import a.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public final class ai
{
  public static final w d(ar paramar)
  {
    AppMethodBeat.i(122636);
    a.f.b.j.q(paramar, "receiver$0");
    Object localObject1 = paramar.ecv();
    if (localObject1 == null)
    {
      paramar = new v("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassifierDescriptorWithTypeParameters");
      AppMethodBeat.o(122636);
      throw paramar;
    }
    localObject1 = ((i)localObject1).ecx();
    a.f.b.j.p(localObject1, "classDescriptor.typeConstructor");
    localObject1 = ((an)localObject1).getParameters();
    a.f.b.j.p(localObject1, "classDescriptor.typeConstructor.parameters");
    Object localObject2 = (Iterable)localObject1;
    localObject1 = (Collection)new ArrayList(a.a.j.d((Iterable)localObject2));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      ar localar = (ar)((Iterator)localObject2).next();
      a.f.b.j.p(localar, "it");
      ((Collection)localObject1).add(localar.ecx());
    }
    localObject1 = au.d((as)new ai.a((List)localObject1));
    localObject2 = paramar.ebo();
    a.f.b.j.p(localObject2, "this.upperBounds");
    localObject2 = ((au)localObject1).c((w)a.a.j.fQ((List)localObject2), ba.CBZ);
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      paramar = a.G((l)paramar).ecm();
      a.f.b.j.p(paramar, "builtIns.defaultBound");
      localObject1 = (w)paramar;
    }
    AppMethodBeat.o(122636);
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     a.j.b.a.c.l.ai
 * JD-Core Version:    0.7.0.1
 */