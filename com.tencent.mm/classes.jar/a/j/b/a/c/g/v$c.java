package a.j.b.a.c.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

final class v$c
  implements Iterator<Map.Entry<K, V>>
{
  private boolean Csv;
  private Iterator<Map.Entry<K, V>> Csw;
  private int pos = -1;
  
  private v$c(v paramv) {}
  
  private Iterator<Map.Entry<K, V>> enk()
  {
    AppMethodBeat.i(121635);
    if (this.Csw == null) {
      this.Csw = v.c(this.Csu).entrySet().iterator();
    }
    Iterator localIterator = this.Csw;
    AppMethodBeat.o(121635);
    return localIterator;
  }
  
  public final boolean hasNext()
  {
    AppMethodBeat.i(121633);
    if ((this.pos + 1 < v.b(this.Csu).size()) || (enk().hasNext()))
    {
      AppMethodBeat.o(121633);
      return true;
    }
    AppMethodBeat.o(121633);
    return false;
  }
  
  public final void remove()
  {
    AppMethodBeat.i(121634);
    Object localObject;
    if (!this.Csv)
    {
      localObject = new IllegalStateException("remove() was called before next()");
      AppMethodBeat.o(121634);
      throw ((Throwable)localObject);
    }
    this.Csv = false;
    v.a(this.Csu);
    if (this.pos < v.b(this.Csu).size())
    {
      localObject = this.Csu;
      int i = this.pos;
      this.pos = (i - 1);
      v.a((v)localObject, i);
      AppMethodBeat.o(121634);
      return;
    }
    enk().remove();
    AppMethodBeat.o(121634);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     a.j.b.a.c.g.v.c
 * JD-Core Version:    0.7.0.1
 */