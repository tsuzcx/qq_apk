package a.j.b.a.c.n;

import a.f.b.a.d;
import a.f.b.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;

final class i$a<T>
  implements d, Iterator<T>
{
  private final Iterator<T> CFm;
  
  public i$a(T[] paramArrayOfT)
  {
    AppMethodBeat.i(122965);
    this.CFm = b.W(paramArrayOfT);
    AppMethodBeat.o(122965);
  }
  
  public final boolean hasNext()
  {
    AppMethodBeat.i(122962);
    boolean bool = this.CFm.hasNext();
    AppMethodBeat.o(122962);
    return bool;
  }
  
  public final T next()
  {
    AppMethodBeat.i(122963);
    Object localObject = this.CFm.next();
    AppMethodBeat.o(122963);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     a.j.b.a.c.n.i.a
 * JD-Core Version:    0.7.0.1
 */