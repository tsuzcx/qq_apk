package a.j.b.a.c.i;

import a.f.a.b;
import a.j.b.a.c.b.a;
import a.j.b.a.c.n.i;
import a.j.b.a.c.n.i.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class k
{
  public static final <H> Collection<H> b(Collection<? extends H> paramCollection, b<? super H, ? extends a> paramb)
  {
    AppMethodBeat.i(122040);
    a.f.b.j.q(paramCollection, "receiver$0");
    a.f.b.j.q(paramb, "descriptorByHandle");
    if (paramCollection.size() <= 1)
    {
      AppMethodBeat.o(122040);
      return paramCollection;
    }
    paramCollection = new LinkedList(paramCollection);
    Object localObject1 = i.CFl;
    localObject1 = i.b.epb();
    int i;
    if (!((Collection)paramCollection).isEmpty()) {
      i = 1;
    }
    for (;;)
    {
      if (i != 0)
      {
        Object localObject3 = a.a.j.fQ((List)paramCollection);
        Object localObject2 = i.CFl;
        localObject2 = i.b.epb();
        Object localObject4 = j.a(localObject3, (Collection)paramCollection, paramb, (b)new k.b((i)localObject2));
        a.f.b.j.p(localObject4, "OverridingUtil.extractMe…nflictedHandles.add(it) }");
        if ((((Collection)localObject4).size() == 1) && (((i)localObject2).isEmpty()))
        {
          localObject2 = a.a.j.h((Iterable)localObject4);
          a.f.b.j.p(localObject2, "overridableGroup.single()");
          ((i)localObject1).add(localObject2);
          break;
          i = 0;
          continue;
        }
        localObject3 = j.a((Collection)localObject4, paramb);
        a.f.b.j.p(localObject3, "OverridingUtil.selectMos…roup, descriptorByHandle)");
        a locala = (a)paramb.S(localObject3);
        localObject4 = ((Iterable)localObject4).iterator();
        while (((Iterator)localObject4).hasNext())
        {
          Object localObject5 = ((Iterator)localObject4).next();
          a.f.b.j.p(localObject5, "it");
          if (!j.f(locala, (a)paramb.S(localObject5))) {
            ((Collection)localObject2).add(localObject5);
          }
        }
        if (!((Collection)localObject2).isEmpty()) {}
        for (i = 1;; i = 0)
        {
          if (i != 0) {
            ((i)localObject1).addAll((Collection)localObject2);
          }
          ((i)localObject1).add(localObject3);
          break;
        }
      }
    }
    paramCollection = (Collection)localObject1;
    AppMethodBeat.o(122040);
    return paramCollection;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     a.j.b.a.c.i.k
 * JD-Core Version:    0.7.0.1
 */