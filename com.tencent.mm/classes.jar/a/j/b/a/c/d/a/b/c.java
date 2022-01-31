package a.j.b.a.c.d.a.b;

import a.j.b.a.c.b.a.g;
import a.j.b.a.c.b.am;
import a.j.b.a.c.b.b.a;
import a.j.b.a.c.b.e;
import a.j.b.a.c.b.l;
import a.j.b.a.c.b.t;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class c
  extends a.j.b.a.c.b.c.f
  implements b
{
  private Boolean Cem = null;
  private Boolean Cen = null;
  
  static
  {
    AppMethodBeat.i(119794);
    if (!c.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      AppMethodBeat.o(119794);
      return;
    }
  }
  
  private c(e parame, c paramc, g paramg, boolean paramBoolean, b.a parama, am paramam)
  {
    super(parame, paramc, paramg, paramBoolean, parama, paramam);
  }
  
  public static c a(e parame, g paramg, boolean paramBoolean, am paramam)
  {
    AppMethodBeat.i(119785);
    parame = new c(parame, null, paramg, paramBoolean, b.a.BVX, paramam);
    AppMethodBeat.o(119785);
    return parame;
  }
  
  private c c(l paraml, t paramt, b.a parama, a.j.b.a.c.f.f paramf, g paramg, am paramam)
  {
    AppMethodBeat.i(119790);
    if ((parama != b.a.BVX) && (parama != b.a.BWa))
    {
      paraml = new IllegalStateException("Attempt at creating a constructor that is not a declaration: \ncopy from: " + this + "\nnewOwner: " + paraml + "\nkind: " + parama);
      AppMethodBeat.o(119790);
      throw paraml;
    }
    if ((!$assertionsDisabled) && (paramf != null))
    {
      paraml = new AssertionError("Attempt to rename constructor: ".concat(String.valueOf(this)));
      AppMethodBeat.o(119790);
      throw paraml;
    }
    paraml = new c((e)paraml, (c)paramt, paramg, this.hGM, parama, paramam);
    paraml.so(eeV());
    paraml.sp(edv());
    AppMethodBeat.o(119790);
    return paraml;
  }
  
  public final boolean edv()
  {
    AppMethodBeat.i(119788);
    if ((!$assertionsDisabled) && (this.Cen == null))
    {
      AssertionError localAssertionError = new AssertionError("hasSynthesizedParameterNames was not set: ".concat(String.valueOf(this)));
      AppMethodBeat.o(119788);
      throw localAssertionError;
    }
    boolean bool = this.Cen.booleanValue();
    AppMethodBeat.o(119788);
    return bool;
  }
  
  public final boolean eeV()
  {
    AppMethodBeat.i(119786);
    if ((!$assertionsDisabled) && (this.Cem == null))
    {
      AssertionError localAssertionError = new AssertionError("hasStableParameterNames was not set: ".concat(String.valueOf(this)));
      AppMethodBeat.o(119786);
      throw localAssertionError;
    }
    boolean bool = this.Cem.booleanValue();
    AppMethodBeat.o(119786);
    return bool;
  }
  
  public final void so(boolean paramBoolean)
  {
    AppMethodBeat.i(119787);
    this.Cem = Boolean.valueOf(paramBoolean);
    AppMethodBeat.o(119787);
  }
  
  public final void sp(boolean paramBoolean)
  {
    AppMethodBeat.i(119789);
    this.Cen = Boolean.valueOf(paramBoolean);
    AppMethodBeat.o(119789);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     a.j.b.a.c.d.a.b.c
 * JD-Core Version:    0.7.0.1
 */