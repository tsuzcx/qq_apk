package a.j.b.a.c.l;

import a.j.b.a.c.a.g;
import a.j.b.a.c.b.ar;
import a.j.b.a.c.i.e.m;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class v
  implements an
{
  public final Set<w> CBw;
  private final int axc;
  
  static
  {
    AppMethodBeat.i(122604);
    if (!v.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      AppMethodBeat.o(122604);
      return;
    }
  }
  
  public v(Collection<w> paramCollection)
  {
    AppMethodBeat.i(122598);
    if ((!$assertionsDisabled) && (paramCollection.isEmpty()))
    {
      paramCollection = new AssertionError("Attempt to create an empty intersection");
      AppMethodBeat.o(122598);
      throw paramCollection;
    }
    this.CBw = new LinkedHashSet(paramCollection);
    this.axc = this.CBw.hashCode();
    AppMethodBeat.o(122598);
  }
  
  public final a.j.b.a.c.b.h ecR()
  {
    return null;
  }
  
  public final boolean ecT()
  {
    return false;
  }
  
  public final Collection<w> eeO()
  {
    return this.CBw;
  }
  
  public final g eec()
  {
    AppMethodBeat.i(122601);
    g localg = ((w)this.CBw.iterator().next()).enU().eec();
    AppMethodBeat.o(122601);
    return localg;
  }
  
  public final a.j.b.a.c.i.e.h eoK()
  {
    AppMethodBeat.i(122600);
    a.j.b.a.c.i.e.h localh = m.a("member scope for intersection type ".concat(String.valueOf(this)), this.CBw);
    AppMethodBeat.o(122600);
    return localh;
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(122603);
    if (this == paramObject)
    {
      AppMethodBeat.o(122603);
      return true;
    }
    if ((paramObject == null) || (getClass() != paramObject.getClass()))
    {
      AppMethodBeat.o(122603);
      return false;
    }
    paramObject = (v)paramObject;
    if (this.CBw != null)
    {
      if (this.CBw.equals(paramObject.CBw)) {}
    }
    else {
      while (paramObject.CBw != null)
      {
        AppMethodBeat.o(122603);
        return false;
      }
    }
    AppMethodBeat.o(122603);
    return true;
  }
  
  public final List<ar> getParameters()
  {
    AppMethodBeat.i(122599);
    List localList = Collections.emptyList();
    AppMethodBeat.o(122599);
    return localList;
  }
  
  public int hashCode()
  {
    return this.axc;
  }
  
  public String toString()
  {
    AppMethodBeat.i(122602);
    Object localObject2 = this.CBw;
    Object localObject1 = new StringBuilder("{");
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      ((StringBuilder)localObject1).append(((w)((Iterator)localObject2).next()).toString());
      if (((Iterator)localObject2).hasNext()) {
        ((StringBuilder)localObject1).append(" & ");
      }
    }
    ((StringBuilder)localObject1).append("}");
    localObject1 = ((StringBuilder)localObject1).toString();
    AppMethodBeat.o(122602);
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     a.j.b.a.c.l.v
 * JD-Core Version:    0.7.0.1
 */