package a.j.b.a.c.d.b.a;

import a.j.b.a.c.d.b.n.a;
import a.j.b.a.c.d.b.n.b;
import a.j.b.a.c.d.b.n.d;
import a.j.b.a.c.e.b.a.d;
import a.j.b.a.c.f.a;
import a.j.b.a.c.f.f;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class b$b
  implements n.a
{
  private b$b(b paramb) {}
  
  public final n.a a(f paramf, a parama)
  {
    return null;
  }
  
  public final void a(f paramf, n.d paramd) {}
  
  public final void a(f paramf1, a parama, f paramf2) {}
  
  public final void a(f paramf, Object paramObject)
  {
    AppMethodBeat.i(120345);
    if (paramf == null)
    {
      AppMethodBeat.o(120345);
      return;
    }
    paramf = paramf.name;
    if ("k".equals(paramf))
    {
      if ((paramObject instanceof Integer))
      {
        b.a(this.Ckl, a.a.TW(((Integer)paramObject).intValue()));
        AppMethodBeat.o(120345);
      }
    }
    else if ("mv".equals(paramf))
    {
      if ((paramObject instanceof int[]))
      {
        b.a(this.Ckl, (int[])paramObject);
        AppMethodBeat.o(120345);
      }
    }
    else if ("bv".equals(paramf))
    {
      if ((paramObject instanceof int[]))
      {
        b.a(this.Ckl, new d((int[])paramObject));
        AppMethodBeat.o(120345);
      }
    }
    else if ("xs".equals(paramf))
    {
      if ((paramObject instanceof String))
      {
        b.a(this.Ckl, (String)paramObject);
        AppMethodBeat.o(120345);
      }
    }
    else if ("xi".equals(paramf))
    {
      if ((paramObject instanceof Integer))
      {
        b.a(this.Ckl, ((Integer)paramObject).intValue());
        AppMethodBeat.o(120345);
      }
    }
    else if (("pn".equals(paramf)) && ((paramObject instanceof String))) {
      b.b(this.Ckl, (String)paramObject);
    }
    AppMethodBeat.o(120345);
  }
  
  public final n.b o(f paramf)
  {
    AppMethodBeat.i(120346);
    paramf = paramf.name;
    if ("d1".equals(paramf))
    {
      paramf = new b.b.1(this);
      AppMethodBeat.o(120346);
      return paramf;
    }
    if ("d2".equals(paramf))
    {
      paramf = new b.b.2(this);
      AppMethodBeat.o(120346);
      return paramf;
    }
    AppMethodBeat.o(120346);
    return null;
  }
  
  public final void zi() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     a.j.b.a.c.d.b.a.b.b
 * JD-Core Version:    0.7.0.1
 */