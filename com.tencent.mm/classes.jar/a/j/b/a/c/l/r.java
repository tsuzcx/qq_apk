package a.j.b.a.c.l;

import a.aa;
import a.f.b.j;
import a.j.b.a.c.b.a.g;
import a.j.b.a.c.b.ar;
import a.j.b.a.c.h.i;
import a.j.b.a.c.l.c.a;
import a.m;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class r
  extends q
  implements f
{
  public static boolean CBp;
  public static final r.a CBq;
  private boolean CBo;
  
  static
  {
    AppMethodBeat.i(122585);
    CBq = new r.a((byte)0);
    AppMethodBeat.o(122585);
  }
  
  public r(ad paramad1, ad paramad2)
  {
    super(paramad1, paramad2);
    AppMethodBeat.i(122584);
    AppMethodBeat.o(122584);
  }
  
  public final w R(w paramw)
  {
    AppMethodBeat.i(122580);
    j.q(paramw, "replacement");
    az localaz = paramw.eoL();
    if ((localaz instanceof q)) {}
    for (paramw = localaz;; paramw = x.a((ad)localaz, ((ad)localaz).ss(true)))
    {
      paramw = (w)ax.a(paramw, (w)localaz);
      AppMethodBeat.o(122580);
      return paramw;
      if (!(localaz instanceof ad)) {
        break;
      }
    }
    paramw = new m();
    AppMethodBeat.o(122580);
    throw paramw;
  }
  
  public final String a(a.j.b.a.c.h.c paramc, i parami)
  {
    AppMethodBeat.i(122582);
    j.q(paramc, "renderer");
    j.q(parami, "options");
    if (parami.enq())
    {
      paramc = "(" + paramc.b((w)this.CBm) + ".." + paramc.b((w)this.CBn) + ')';
      AppMethodBeat.o(122582);
      return paramc;
    }
    paramc = paramc.a(paramc.b((w)this.CBm), paramc.b((w)this.CBn), a.aL(this));
    AppMethodBeat.o(122582);
    return paramc;
  }
  
  public final az b(g paramg)
  {
    AppMethodBeat.i(122581);
    j.q(paramg, "newAnnotations");
    paramg = x.a(this.CBm.d(paramg), this.CBn.d(paramg));
    AppMethodBeat.o(122581);
    return paramg;
  }
  
  public final ad efX()
  {
    int j = 1;
    AppMethodBeat.i(122578);
    if ((!CBp) || (this.CBo)) {}
    boolean bool;
    do
    {
      localObject = this.CBm;
      AppMethodBeat.o(122578);
      return localObject;
      this.CBo = true;
      if (!t.ai((w)this.CBm)) {}
      for (int i = 1; (aa.BMh) && (i == 0); i = 0)
      {
        localObject = (Throwable)new AssertionError("Lower bound of a flexible type can not be flexible: " + this.CBm);
        AppMethodBeat.o(122578);
        throw ((Throwable)localObject);
      }
      if (!t.ai((w)this.CBn)) {}
      for (i = j; (aa.BMh) && (i == 0); i = 0)
      {
        localObject = (Throwable)new AssertionError("Upper bound of a flexible type can not be flexible: " + this.CBn);
        AppMethodBeat.o(122578);
        throw ((Throwable)localObject);
      }
      bool = j.e(this.CBm, this.CBn);
      if ((aa.BMh) && (!(bool ^ true)))
      {
        localObject = (Throwable)new AssertionError("Lower and upper bounds are equal: " + this.CBm + " == " + this.CBn);
        AppMethodBeat.o(122578);
        throw ((Throwable)localObject);
      }
      bool = a.j.b.a.c.l.a.c.CCi.c((w)this.CBm, (w)this.CBn);
    } while ((!aa.BMh) || (bool));
    Object localObject = (Throwable)new AssertionError("Lower bound " + this.CBm + " of a flexible type must be a subtype of the upper bound " + this.CBn);
    AppMethodBeat.o(122578);
    throw ((Throwable)localObject);
  }
  
  public final boolean egG()
  {
    AppMethodBeat.i(122579);
    if (((this.CBm.enU().ecR() instanceof ar)) && (j.e(this.CBm.enU(), this.CBn.enU())))
    {
      AppMethodBeat.o(122579);
      return true;
    }
    AppMethodBeat.o(122579);
    return false;
  }
  
  public final az sr(boolean paramBoolean)
  {
    AppMethodBeat.i(122583);
    az localaz = x.a(this.CBm.ss(paramBoolean), this.CBn.ss(paramBoolean));
    AppMethodBeat.o(122583);
    return localaz;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     a.j.b.a.c.l.r
 * JD-Core Version:    0.7.0.1
 */