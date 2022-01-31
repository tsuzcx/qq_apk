package a.j.b.a.c.e.a;

import a.j.b.a.c.e.a.aa;
import a.j.b.a.c.e.a.aa.c;
import a.j.b.a.c.e.a.ag;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public final class h
{
  private final List<a.aa> tfr;
  
  public h(a.ag paramag)
  {
    AppMethodBeat.i(121096);
    Object localObject = paramag.CnA;
    Collection localCollection;
    if (paramag.ekm())
    {
      int j = paramag.CnB;
      paramag = paramag.CnA;
      a.f.b.j.p(paramag, "typeTable.typeList");
      paramag = (Iterable)paramag;
      localCollection = (Collection)new ArrayList(a.a.j.d(paramag));
      int i = 0;
      Iterator localIterator = paramag.iterator();
      while (localIterator.hasNext())
      {
        paramag = localIterator.next();
        if (i < 0) {
          a.a.j.eaS();
        }
        localObject = (a.aa)paramag;
        paramag = (a.ag)localObject;
        if (i >= j) {
          paramag = ((a.aa)localObject).ejJ().su(true).ejR();
        }
        localCollection.add(paramag);
        i += 1;
      }
    }
    for (paramag = (List)localCollection;; paramag = (a.ag)localObject)
    {
      this.tfr = paramag;
      AppMethodBeat.o(121096);
      return;
      a.f.b.j.p(localObject, "originalTypes");
    }
  }
  
  public final a.aa Vs(int paramInt)
  {
    AppMethodBeat.i(121095);
    a.aa localaa = (a.aa)this.tfr.get(paramInt);
    AppMethodBeat.o(121095);
    return localaa;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     a.j.b.a.c.e.a.h
 * JD-Core Version:    0.7.0.1
 */