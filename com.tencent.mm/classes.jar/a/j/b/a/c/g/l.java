package a.j.b.a.c.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.Map.Entry;

public final class l
  extends m
{
  private final q CrN;
  
  public final q emV()
  {
    AppMethodBeat.i(121545);
    q localq = d(this.CrN);
    AppMethodBeat.o(121545);
    return localq;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(121547);
    boolean bool = emV().equals(paramObject);
    AppMethodBeat.o(121547);
    return bool;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(121546);
    int i = emV().hashCode();
    AppMethodBeat.o(121546);
    return i;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(121548);
    String str = emV().toString();
    AppMethodBeat.o(121548);
    return str;
  }
  
  static final class a<K>
    implements Map.Entry<K, Object>
  {
    private Map.Entry<K, l> CrO;
    
    private a(Map.Entry<K, l> paramEntry)
    {
      this.CrO = paramEntry;
    }
    
    public final K getKey()
    {
      AppMethodBeat.i(121539);
      Object localObject = this.CrO.getKey();
      AppMethodBeat.o(121539);
      return localObject;
    }
    
    public final Object getValue()
    {
      AppMethodBeat.i(121540);
      Object localObject = (l)this.CrO.getValue();
      if (localObject == null)
      {
        AppMethodBeat.o(121540);
        return null;
      }
      localObject = ((l)localObject).emV();
      AppMethodBeat.o(121540);
      return localObject;
    }
    
    public final Object setValue(Object paramObject)
    {
      AppMethodBeat.i(121541);
      if (!(paramObject instanceof q))
      {
        paramObject = new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
        AppMethodBeat.o(121541);
        throw paramObject;
      }
      paramObject = ((l)this.CrO.getValue()).e((q)paramObject);
      AppMethodBeat.o(121541);
      return paramObject;
    }
  }
  
  static final class b<K>
    implements Iterator<Map.Entry<K, Object>>
  {
    private Iterator<Map.Entry<K, Object>> BMB;
    
    public b(Iterator<Map.Entry<K, Object>> paramIterator)
    {
      this.BMB = paramIterator;
    }
    
    public final boolean hasNext()
    {
      AppMethodBeat.i(121542);
      boolean bool = this.BMB.hasNext();
      AppMethodBeat.o(121542);
      return bool;
    }
    
    public final void remove()
    {
      AppMethodBeat.i(121543);
      this.BMB.remove();
      AppMethodBeat.o(121543);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     a.j.b.a.c.g.l
 * JD-Core Version:    0.7.0.1
 */