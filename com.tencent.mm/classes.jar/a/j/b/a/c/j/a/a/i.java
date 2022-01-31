package a.j.b.a.c.j.a.a;

import a.f.b.j;
import a.j.b.a.c.b.a.g;
import a.j.b.a.c.b.ah;
import a.j.b.a.c.b.aj;
import a.j.b.a.c.b.am;
import a.j.b.a.c.b.az;
import a.j.b.a.c.b.c.aa;
import a.j.b.a.c.b.c.ak;
import a.j.b.a.c.b.c.z;
import a.j.b.a.c.b.l;
import a.j.b.a.c.b.r;
import a.j.b.a.c.b.w;
import a.j.b.a.c.e.a.u;
import a.j.b.a.c.e.a.c;
import a.j.b.a.c.e.a.h;
import a.j.b.a.c.f.f;
import a.y;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class i
  extends z
  implements b
{
  public final a.u BOa;
  public final c BOc;
  public final h BOd;
  private final a.j.b.a.c.e.a.i CyS;
  public final e CyT;
  private f.a CzD;
  
  public i(l paraml, ah paramah, g paramg, w paramw, az paramaz, boolean paramBoolean1, f paramf, a.j.b.a.c.b.b.a parama, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, a.u paramu, c paramc, h paramh, a.j.b.a.c.e.a.i parami, e parame)
  {
    super(paraml, paramah, paramg, paramw, paramaz, paramBoolean1, paramf, parama, am.BWF, paramBoolean2, paramBoolean3, paramBoolean6, false, paramBoolean4, paramBoolean5);
    AppMethodBeat.i(122415);
    this.BOa = paramu;
    this.BOc = paramc;
    this.BOd = paramh;
    this.CyS = parami;
    this.CyT = parame;
    this.CzD = f.a.CzX;
    AppMethodBeat.o(122415);
  }
  
  public final z a(l paraml, w paramw, az paramaz, ah paramah, a.j.b.a.c.b.b.a parama, f paramf)
  {
    AppMethodBeat.i(122413);
    j.q(paraml, "newOwner");
    j.q(paramw, "newModality");
    j.q(paramaz, "newVisibility");
    j.q(parama, "kind");
    j.q(paramf, "newName");
    paraml = (z)new i(paraml, paramah, ecM(), paramw, paramaz, this.Cbq, paramf, parama, this.CaM, eeA(), ecL(), this.CaO, this.BZJ, this.BOa, this.BOc, this.BOd, this.CyS, this.CyT);
    AppMethodBeat.o(122413);
    return paraml;
  }
  
  public final void a(aa paramaa, aj paramaj, r paramr1, r paramr2, f.a parama)
  {
    AppMethodBeat.i(122412);
    j.q(parama, "isExperimentalCoroutineInReleaseEnvironment");
    super.a(paramaa, paramaj, paramr1, paramr2);
    paramaa = y.BMg;
    this.CzD = parama;
    AppMethodBeat.o(122412);
  }
  
  public final boolean ecL()
  {
    AppMethodBeat.i(122414);
    Boolean localBoolean = a.j.b.a.c.e.a.b.CoG.Vo(this.BOa.CkK);
    j.p(localBoolean, "Flags.IS_EXTERNAL_PROPERTY.get(proto.flags)");
    boolean bool = localBoolean.booleanValue();
    AppMethodBeat.o(122414);
    return bool;
  }
  
  public final c eot()
  {
    return this.BOc;
  }
  
  public final h eou()
  {
    return this.BOd;
  }
  
  public final e eov()
  {
    return this.CyT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     a.j.b.a.c.j.a.a.i
 * JD-Core Version:    0.7.0.1
 */