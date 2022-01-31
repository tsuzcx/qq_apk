package a.j.b.a.c.d.b.a;

import a.j.b.a.c.d.b.n.a;
import a.j.b.a.c.d.b.n.b;
import a.j.b.a.c.d.b.n.d;
import a.j.b.a.c.e.b.a.d;
import a.j.b.a.c.f.a;
import a.j.b.a.c.f.f;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class b$c
  implements n.a
{
  private b$c(b paramb) {}
  
  public final n.a a(f paramf, a parama)
  {
    return null;
  }
  
  public final void a(f paramf, n.d paramd) {}
  
  public final void a(f paramf1, a parama, f paramf2) {}
  
  public final void a(f paramf, Object paramObject)
  {
    AppMethodBeat.i(120349);
    if (paramf == null)
    {
      AppMethodBeat.o(120349);
      return;
    }
    paramf = paramf.name;
    b localb;
    if ("version".equals(paramf))
    {
      if ((paramObject instanceof int[]))
      {
        b.a(this.Ckl, (int[])paramObject);
        if (b.a(this.Ckl) == null)
        {
          b.a(this.Ckl, new d((int[])paramObject));
          AppMethodBeat.o(120349);
        }
      }
    }
    else if ("multifileClassName".equals(paramf))
    {
      localb = this.Ckl;
      if (!(paramObject instanceof String)) {
        break label127;
      }
    }
    label127:
    for (paramf = (String)paramObject;; paramf = null)
    {
      b.a(localb, paramf);
      AppMethodBeat.o(120349);
      return;
    }
  }
  
  public final n.b o(f paramf)
  {
    AppMethodBeat.i(120350);
    paramf = paramf.name;
    if (("data".equals(paramf)) || ("filePartClassNames".equals(paramf)))
    {
      paramf = new b.c.1(this);
      AppMethodBeat.o(120350);
      return paramf;
    }
    if ("strings".equals(paramf))
    {
      paramf = new b.c.2(this);
      AppMethodBeat.o(120350);
      return paramf;
    }
    AppMethodBeat.o(120350);
    return null;
  }
  
  public final void zi() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     a.j.b.a.c.d.b.a.b.c
 * JD-Core Version:    0.7.0.1
 */