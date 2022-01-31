package a.j.b.a.c.j.a.a;

import a.a.x;
import a.f.b.j;
import a.j.b.a.c.b.ab;
import a.j.b.a.c.b.l;
import a.j.b.a.c.e.a.s;
import a.j.b.a.c.e.a.c;
import a.j.b.a.c.f.f;
import a.j.b.a.c.j.a.i;
import a.j.b.a.c.j.a.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public final class h
  extends g
{
  private final a.j.b.a.c.f.b BUK;
  private final ab CAl;
  
  public h(ab paramab, a.s params, c paramc, a.j.b.a.c.e.a.a parama, e parame, i parami, a.f.a.a<? extends Collection<f>> parama1)
  {
    super(paramc, parama, parame, (Collection)params, parama1);
    AppMethodBeat.i(122411);
    this.CAl = paramab;
    this.BUK = this.CAl.eee();
    AppMethodBeat.o(122411);
  }
  
  protected final a.j.b.a.c.f.a A(f paramf)
  {
    AppMethodBeat.i(122407);
    j.q(paramf, "name");
    paramf = new a.j.b.a.c.f.a(this.BUK, paramf);
    AppMethodBeat.o(122407);
    return paramf;
  }
  
  protected final boolean D(f paramf)
  {
    AppMethodBeat.i(122406);
    j.q(paramf, "name");
    if (!super.D(paramf))
    {
      Object localObject = this.CyY.CiZ.CyK;
      if (((localObject instanceof Collection)) && (((Collection)localObject).isEmpty())) {
        break label100;
      }
      localObject = ((Iterable)localObject).iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
      } while (!((a.j.b.a.c.b.b.b)((Iterator)localObject).next()).a(this.BUK, paramf));
    }
    label100:
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(122406);
      return true;
    }
    AppMethodBeat.o(122406);
    return false;
  }
  
  public final a.j.b.a.c.b.h c(f paramf, a.j.b.a.c.c.a.a parama)
  {
    AppMethodBeat.i(122408);
    j.q(paramf, "name");
    j.q(parama, "location");
    d(paramf, parama);
    paramf = super.c(paramf, parama);
    AppMethodBeat.o(122408);
    return paramf;
  }
  
  protected final void c(Collection<l> paramCollection, a.f.a.b<? super f, Boolean> paramb)
  {
    AppMethodBeat.i(122410);
    j.q(paramCollection, "result");
    j.q(paramb, "nameFilter");
    AppMethodBeat.o(122410);
  }
  
  public final void d(f paramf, a.j.b.a.c.c.a.a parama)
  {
    AppMethodBeat.i(122409);
    j.q(paramf, "name");
    j.q(parama, "location");
    a.j.b.a.c.c.a.a(this.CyY.CiZ.CeQ, parama, this.CAl, paramf);
    AppMethodBeat.o(122409);
  }
  
  protected final Set<f> eow()
  {
    return (Set)x.BMz;
  }
  
  protected final Set<f> eox()
  {
    return (Set)x.BMz;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     a.j.b.a.c.j.a.a.h
 * JD-Core Version:    0.7.0.1
 */