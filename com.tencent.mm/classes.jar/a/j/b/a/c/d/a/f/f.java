package a.j.b.a.c.d.a.f;

import a.f.b.j;
import a.j.b.a.c.b.a.g;
import a.j.b.a.c.l.ad;
import a.j.b.a.c.l.av;
import a.j.b.a.c.l.ax;
import a.j.b.a.c.l.c.a;
import a.j.b.a.c.l.i;
import a.j.b.a.c.l.q;
import a.j.b.a.c.l.w;
import a.j.b.a.c.l.x;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f
  extends i
  implements a.j.b.a.c.l.f
{
  private final ad Chy;
  
  public f(ad paramad)
  {
    AppMethodBeat.i(120105);
    this.Chy = paramad;
    AppMethodBeat.o(120105);
  }
  
  private static ad a(ad paramad)
  {
    AppMethodBeat.i(120099);
    ad localad = paramad.ss(false);
    if (!a.aE((w)paramad))
    {
      AppMethodBeat.o(120099);
      return localad;
    }
    paramad = (ad)new f(localad);
    AppMethodBeat.o(120099);
    return paramad;
  }
  
  private f c(g paramg)
  {
    AppMethodBeat.i(120100);
    j.q(paramg, "newAnnotations");
    paramg = new f(this.Chy.d(paramg));
    AppMethodBeat.o(120100);
    return paramg;
  }
  
  public final w R(w paramw)
  {
    AppMethodBeat.i(120098);
    j.q(paramw, "replacement");
    paramw = paramw.eoL();
    if ((!av.aB((w)paramw)) && (!a.aE((w)paramw)))
    {
      paramw = (w)paramw;
      AppMethodBeat.o(120098);
      return paramw;
    }
    if ((paramw instanceof ad))
    {
      paramw = (w)a((ad)paramw);
      AppMethodBeat.o(120098);
      return paramw;
    }
    if ((paramw instanceof q))
    {
      paramw = (w)ax.b(x.a(a(((q)paramw).CBm), a(((q)paramw).CBn)), ax.aG((w)paramw));
      AppMethodBeat.o(120098);
      return paramw;
    }
    paramw = (Throwable)new IllegalStateException("Incorrect type: ".concat(String.valueOf(paramw)).toString());
    AppMethodBeat.o(120098);
    throw paramw;
  }
  
  public final ad efX()
  {
    return this.Chy;
  }
  
  public final boolean egG()
  {
    return true;
  }
  
  public final boolean egH()
  {
    return false;
  }
  
  public final ad ss(boolean paramBoolean)
  {
    AppMethodBeat.i(120103);
    if (paramBoolean)
    {
      localad = this.Chy.ss(true);
      AppMethodBeat.o(120103);
      return localad;
    }
    ad localad = (ad)this;
    AppMethodBeat.o(120103);
    return localad;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     a.j.b.a.c.d.a.f.f
 * JD-Core Version:    0.7.0.1
 */