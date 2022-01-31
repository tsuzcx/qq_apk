package a.j.b.a.c.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

final class u$b
  implements Iterator<p>
{
  private final Stack<u> Csc;
  private p Csd;
  
  private u$b(d paramd)
  {
    AppMethodBeat.i(121586);
    this.Csc = new Stack();
    this.Csd = g(paramd);
    AppMethodBeat.o(121586);
  }
  
  private p emZ()
  {
    AppMethodBeat.i(121588);
    for (;;)
    {
      if (this.Csc.isEmpty())
      {
        AppMethodBeat.o(121588);
        return null;
      }
      p localp = g(u.b((u)this.Csc.pop()));
      if (localp.size() == 0) {}
      for (int i = 1; i == 0; i = 0)
      {
        AppMethodBeat.o(121588);
        return localp;
      }
    }
  }
  
  private p g(d paramd)
  {
    AppMethodBeat.i(121587);
    while ((paramd instanceof u))
    {
      paramd = (u)paramd;
      this.Csc.push(paramd);
      paramd = u.a(paramd);
    }
    paramd = (p)paramd;
    AppMethodBeat.o(121587);
    return paramd;
  }
  
  public final p ena()
  {
    AppMethodBeat.i(121589);
    if (this.Csd == null)
    {
      localObject = new NoSuchElementException();
      AppMethodBeat.o(121589);
      throw ((Throwable)localObject);
    }
    Object localObject = this.Csd;
    this.Csd = emZ();
    AppMethodBeat.o(121589);
    return localObject;
  }
  
  public final boolean hasNext()
  {
    return this.Csd != null;
  }
  
  public final void remove()
  {
    AppMethodBeat.i(121590);
    UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException();
    AppMethodBeat.o(121590);
    throw localUnsupportedOperationException;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     a.j.b.a.c.g.u.b
 * JD-Core Version:    0.7.0.1
 */