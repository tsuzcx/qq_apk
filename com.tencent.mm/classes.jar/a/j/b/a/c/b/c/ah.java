package a.j.b.a.c.b.c;

import a.j.b.a.c.b.am;
import a.j.b.a.c.b.ap;
import a.j.b.a.c.b.ap.a;
import a.j.b.a.c.b.ar;
import a.j.b.a.c.b.l;
import a.j.b.a.c.f.f;
import a.j.b.a.c.i.c.a;
import a.j.b.a.c.i.d;
import a.j.b.a.c.l.ba;
import a.j.b.a.c.l.w;
import a.j.b.a.c.l.y;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public final class ah
  extends e
{
  private final a.f.a.b<w, Void> Cbh;
  private final List<w> Cbi;
  private boolean initialized;
  
  private ah(l paraml, a.j.b.a.c.b.a.g paramg, boolean paramBoolean, ba paramba, f paramf, int paramInt, am paramam, ap paramap)
  {
    super(a.j.b.a.c.k.b.CAv, paraml, paramg, paramf, paramba, paramBoolean, paramInt, paramam, paramap);
    AppMethodBeat.i(119612);
    this.Cbi = new ArrayList(1);
    this.initialized = false;
    this.Cbh = null;
    AppMethodBeat.o(119612);
  }
  
  private void M(w paramw)
  {
    AppMethodBeat.i(119617);
    if (y.an(paramw))
    {
      AppMethodBeat.o(119617);
      return;
    }
    this.Cbi.add(paramw);
    AppMethodBeat.o(119617);
  }
  
  public static ar a(l paraml, a.j.b.a.c.b.a.g paramg, ba paramba, f paramf, int paramInt)
  {
    AppMethodBeat.i(119609);
    paramg = a(paraml, paramg, false, paramba, paramf, paramInt, am.BWF);
    paramg.L(a.G(paraml).ecm());
    paramg.setInitialized();
    AppMethodBeat.o(119609);
    return paramg;
  }
  
  public static ah a(l paraml, a.j.b.a.c.b.a.g paramg, boolean paramBoolean, ba paramba, f paramf, int paramInt, am paramam)
  {
    AppMethodBeat.i(119610);
    paraml = a(paraml, paramg, paramBoolean, paramba, paramf, paramInt, paramam, ap.a.BWH);
    AppMethodBeat.o(119610);
    return paraml;
  }
  
  private static ah a(l paraml, a.j.b.a.c.b.a.g paramg, boolean paramBoolean, ba paramba, f paramf, int paramInt, am paramam, ap paramap)
  {
    AppMethodBeat.i(119611);
    paraml = new ah(paraml, paramg, paramBoolean, paramba, paramf, paramInt, paramam, paramap);
    AppMethodBeat.o(119611);
    return paraml;
  }
  
  private void efm()
  {
    AppMethodBeat.i(119613);
    if (this.initialized)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("Type parameter descriptor is already initialized: " + efn());
      AppMethodBeat.o(119613);
      throw localIllegalStateException;
    }
    AppMethodBeat.o(119613);
  }
  
  private String efn()
  {
    AppMethodBeat.i(119614);
    String str = this.BYN + " declared in " + d.n(ecv());
    AppMethodBeat.o(119614);
    return str;
  }
  
  protected final void J(w paramw)
  {
    AppMethodBeat.i(119618);
    if (this.Cbh == null)
    {
      AppMethodBeat.o(119618);
      return;
    }
    this.Cbh.S(paramw);
    AppMethodBeat.o(119618);
  }
  
  public final void L(w paramw)
  {
    AppMethodBeat.i(119616);
    efm();
    M(paramw);
    AppMethodBeat.o(119616);
  }
  
  protected final List<w> eeP()
  {
    AppMethodBeat.i(119619);
    if (!this.initialized)
    {
      localObject = new IllegalStateException("Type parameter descriptor is not initialized: " + efn());
      AppMethodBeat.o(119619);
      throw ((Throwable)localObject);
    }
    Object localObject = this.Cbi;
    AppMethodBeat.o(119619);
    return localObject;
  }
  
  public final void setInitialized()
  {
    AppMethodBeat.i(119615);
    efm();
    this.initialized = true;
    AppMethodBeat.o(119615);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     a.j.b.a.c.b.c.ah
 * JD-Core Version:    0.7.0.1
 */