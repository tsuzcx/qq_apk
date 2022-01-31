package a.j.b.a.c.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

public final class n
  extends AbstractList<String>
  implements o, RandomAccess
{
  public static final o CrT;
  private final List<Object> list;
  
  static
  {
    AppMethodBeat.i(121566);
    CrT = new n().emX();
    AppMethodBeat.o(121566);
  }
  
  public n()
  {
    AppMethodBeat.i(121551);
    this.list = new ArrayList();
    AppMethodBeat.o(121551);
  }
  
  public n(o paramo)
  {
    AppMethodBeat.i(121552);
    this.list = new ArrayList(paramo.size());
    addAll(paramo);
    AppMethodBeat.o(121552);
  }
  
  private static String dJ(Object paramObject)
  {
    AppMethodBeat.i(121559);
    if ((paramObject instanceof String))
    {
      paramObject = (String)paramObject;
      AppMethodBeat.o(121559);
      return paramObject;
    }
    if ((paramObject instanceof d))
    {
      paramObject = ((d)paramObject).dqj();
      AppMethodBeat.o(121559);
      return paramObject;
    }
    paramObject = j.cF((byte[])paramObject);
    AppMethodBeat.o(121559);
    return paramObject;
  }
  
  public final d VK(int paramInt)
  {
    AppMethodBeat.i(121558);
    Object localObject = this.list.get(paramInt);
    d locald;
    if ((localObject instanceof d)) {
      locald = (d)localObject;
    }
    for (;;)
    {
      if (locald != localObject) {
        this.list.set(paramInt, locald);
      }
      AppMethodBeat.o(121558);
      return locald;
      if ((localObject instanceof String)) {
        locald = d.ayY((String)localObject);
      } else {
        locald = d.cB((byte[])localObject);
      }
    }
  }
  
  public final boolean addAll(int paramInt, Collection<? extends String> paramCollection)
  {
    AppMethodBeat.i(121555);
    Object localObject = paramCollection;
    if ((paramCollection instanceof o)) {
      localObject = ((o)paramCollection).emW();
    }
    boolean bool = this.list.addAll(paramInt, (Collection)localObject);
    this.modCount += 1;
    AppMethodBeat.o(121555);
    return bool;
  }
  
  public final boolean addAll(Collection<? extends String> paramCollection)
  {
    AppMethodBeat.i(121554);
    boolean bool = addAll(size(), paramCollection);
    AppMethodBeat.o(121554);
    return bool;
  }
  
  public final void clear()
  {
    AppMethodBeat.i(121556);
    this.list.clear();
    this.modCount += 1;
    AppMethodBeat.o(121556);
  }
  
  public final void e(d paramd)
  {
    AppMethodBeat.i(121557);
    this.list.add(paramd);
    this.modCount += 1;
    AppMethodBeat.o(121557);
  }
  
  public final List<?> emW()
  {
    AppMethodBeat.i(121560);
    List localList = Collections.unmodifiableList(this.list);
    AppMethodBeat.o(121560);
    return localList;
  }
  
  public final o emX()
  {
    AppMethodBeat.i(121561);
    x localx = new x(this);
    AppMethodBeat.o(121561);
    return localx;
  }
  
  public final int size()
  {
    AppMethodBeat.i(121553);
    int i = this.list.size();
    AppMethodBeat.o(121553);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     a.j.b.a.c.g.n
 * JD-Core Version:    0.7.0.1
 */