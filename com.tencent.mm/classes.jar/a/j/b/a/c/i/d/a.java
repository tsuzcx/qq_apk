package a.j.b.a.c.i.d;

import a.j.b.a.c.b.e;
import a.j.b.a.c.c.a.c;
import a.j.b.a.c.d.a.e.aa;
import a.j.b.a.c.f.b;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  private final a.j.b.a.c.d.a.a.g CeK;
  public final a.j.b.a.c.d.a.c.g CwS;
  
  public a(a.j.b.a.c.d.a.c.g paramg, a.j.b.a.c.d.a.a.g paramg1)
  {
    AppMethodBeat.i(122155);
    this.CwS = paramg;
    this.CeK = paramg1;
    AppMethodBeat.o(122155);
  }
  
  public final e b(a.j.b.a.c.d.a.e.g paramg)
  {
    AppMethodBeat.i(122154);
    a.f.b.j.q(paramg, "javaClass");
    Object localObject1 = paramg.eee();
    if ((localObject1 != null) && (aa.Chj == null))
    {
      AppMethodBeat.o(122154);
      return null;
    }
    Object localObject2 = paramg.egf();
    if (localObject2 != null)
    {
      localObject1 = b((a.j.b.a.c.d.a.e.g)localObject2);
      if (localObject1 != null)
      {
        localObject1 = ((e)localObject1).edJ();
        if (localObject1 == null) {
          break label114;
        }
      }
      label114:
      for (paramg = ((a.j.b.a.c.i.e.h)localObject1).c(paramg.edF(), (a.j.b.a.c.c.a.a)c.CbL);; paramg = null)
      {
        localObject1 = paramg;
        if (!(paramg instanceof e)) {
          localObject1 = null;
        }
        paramg = (e)localObject1;
        AppMethodBeat.o(122154);
        return paramg;
        localObject1 = null;
        break;
      }
    }
    if (localObject1 == null)
    {
      AppMethodBeat.o(122154);
      return null;
    }
    localObject2 = this.CwS;
    localObject1 = ((b)localObject1).emd();
    a.f.b.j.p(localObject1, "fqName.parent()");
    localObject1 = (a.j.b.a.c.d.a.c.a.h)a.a.j.fR(((a.j.b.a.c.d.a.c.g)localObject2).h((b)localObject1));
    if (localObject1 != null)
    {
      paramg = ((a.j.b.a.c.d.a.c.a.h)localObject1).c(paramg);
      AppMethodBeat.o(122154);
      return paramg;
    }
    AppMethodBeat.o(122154);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     a.j.b.a.c.i.d.a
 * JD-Core Version:    0.7.0.1
 */