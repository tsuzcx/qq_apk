package a.j.b.a.c.l;

import a.a.v;
import a.f.a.a;
import a.f.a.b;
import a.f.b.j;
import a.f.b.k;
import a.j.b.a.c.b.ap;
import a.j.b.a.c.k.f;
import a.j.b.a.c.k.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.List;

public abstract class c
  implements an
{
  private final f<c.a> CAP;
  
  public c(i parami)
  {
    this.CAP = parami.a((a)new c.b(this), (b)c.CAU, (b)new c.d(this));
  }
  
  protected void J(w paramw)
  {
    j.q(paramw, "type");
  }
  
  protected abstract Collection<w> ecQ();
  
  protected abstract ap ecU();
  
  protected w eeQ()
  {
    return null;
  }
  
  public final List<w> eoF()
  {
    return ((c.a)this.CAP.invoke()).CAQ;
  }
  
  protected Collection<w> sI(boolean paramBoolean)
  {
    return (Collection)v.BMx;
  }
  
  static final class c
    extends k
    implements b<Boolean, c.a>
  {
    public static final c CAU;
    
    static
    {
      AppMethodBeat.i(122490);
      CAU = new c();
      AppMethodBeat.o(122490);
    }
    
    c()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     a.j.b.a.c.l.c
 * JD-Core Version:    0.7.0.1
 */