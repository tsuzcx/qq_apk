package a.j.b.a.c.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map.Entry;

final class v$d
  extends AbstractSet<Map.Entry<K, V>>
{
  private v$d(v paramv) {}
  
  public final void clear()
  {
    AppMethodBeat.i(121641);
    this.Csu.clear();
    AppMethodBeat.o(121641);
  }
  
  public final boolean contains(Object paramObject)
  {
    AppMethodBeat.i(121639);
    Object localObject = (Map.Entry)paramObject;
    paramObject = this.Csu.get(((Map.Entry)localObject).getKey());
    localObject = ((Map.Entry)localObject).getValue();
    if ((paramObject == localObject) || ((paramObject != null) && (paramObject.equals(localObject))))
    {
      AppMethodBeat.o(121639);
      return true;
    }
    AppMethodBeat.o(121639);
    return false;
  }
  
  public final Iterator<Map.Entry<K, V>> iterator()
  {
    AppMethodBeat.i(121637);
    v.c localc = new v.c(this.Csu, (byte)0);
    AppMethodBeat.o(121637);
    return localc;
  }
  
  public final boolean remove(Object paramObject)
  {
    AppMethodBeat.i(121640);
    paramObject = (Map.Entry)paramObject;
    if (contains(paramObject))
    {
      this.Csu.remove(paramObject.getKey());
      AppMethodBeat.o(121640);
      return true;
    }
    AppMethodBeat.o(121640);
    return false;
  }
  
  public final int size()
  {
    AppMethodBeat.i(121638);
    int i = this.Csu.size();
    AppMethodBeat.o(121638);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     a.j.b.a.c.g.v.d
 * JD-Core Version:    0.7.0.1
 */