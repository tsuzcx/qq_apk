package a.j.b.a.c.l;

import a.aa;
import a.f.b.j;
import a.j.b.a.c.b.ar;
import a.j.b.a.c.l.a.k;
import a.j.b.a.c.l.a.l;
import a.j.b.a.c.l.c.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class g
  extends i
  implements f
{
  public static final a CAX;
  final ad CAW;
  
  static
  {
    AppMethodBeat.i(122509);
    CAX = new a((byte)0);
    AppMethodBeat.o(122509);
  }
  
  private g(ad paramad)
  {
    this.CAW = paramad;
  }
  
  private g g(a.j.b.a.c.b.a.g paramg)
  {
    AppMethodBeat.i(122503);
    j.q(paramg, "newAnnotations");
    paramg = new g(this.CAW.d(paramg));
    AppMethodBeat.o(122503);
    return paramg;
  }
  
  public final w R(w paramw)
  {
    AppMethodBeat.i(122502);
    j.q(paramw, "replacement");
    paramw = paramw.eoL();
    j.q(paramw, "receiver$0");
    g localg = a.a(paramw);
    if (localg != null) {}
    for (paramw = (az)localg;; paramw = paramw.sr(false))
    {
      paramw = (w)paramw;
      AppMethodBeat.o(122502);
      return paramw;
    }
  }
  
  protected final ad efX()
  {
    return this.CAW;
  }
  
  public final boolean egG()
  {
    AppMethodBeat.i(122501);
    if (((this.CAW.enU() instanceof k)) || ((this.CAW.enU().ecR() instanceof ar)))
    {
      AppMethodBeat.o(122501);
      return true;
    }
    AppMethodBeat.o(122501);
    return false;
  }
  
  public final boolean egH()
  {
    return false;
  }
  
  public final ad ss(boolean paramBoolean)
  {
    AppMethodBeat.i(122506);
    if (paramBoolean)
    {
      localad = this.CAW.ss(paramBoolean);
      AppMethodBeat.o(122506);
      return localad;
    }
    ad localad = (ad)this;
    AppMethodBeat.o(122506);
    return localad;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(122508);
    String str = this.CAW + "!!";
    AppMethodBeat.o(122508);
    return str;
  }
  
  public static final class a
  {
    public static g a(az paramaz)
    {
      AppMethodBeat.i(122499);
      j.q(paramaz, "type");
      if ((paramaz instanceof g))
      {
        paramaz = (g)paramaz;
        AppMethodBeat.o(122499);
        return paramaz;
      }
      if (b(paramaz))
      {
        if ((paramaz instanceof q))
        {
          boolean bool = j.e(((q)paramaz).CBm.enU(), ((q)paramaz).CBn.enU());
          if ((aa.BMh) && (!bool))
          {
            paramaz = (Throwable)new AssertionError("DefinitelyNotNullType for flexible type (" + paramaz + ") can be created only from type variable with the same constructor for bounds");
            AppMethodBeat.o(122499);
            throw paramaz;
          }
        }
        paramaz = new g(t.ak((w)paramaz), (byte)0);
        AppMethodBeat.o(122499);
        return paramaz;
      }
      AppMethodBeat.o(122499);
      return null;
    }
    
    private static boolean b(az paramaz)
    {
      AppMethodBeat.i(122500);
      j.q(paramaz, "type");
      if (a.h(paramaz))
      {
        l locall = l.CCr;
        if (!l.d(paramaz))
        {
          AppMethodBeat.o(122500);
          return true;
        }
      }
      AppMethodBeat.o(122500);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     a.j.b.a.c.l.g
 * JD-Core Version:    0.7.0.1
 */