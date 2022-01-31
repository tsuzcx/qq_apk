package a.j.b.a.c.b.c;

import a.j.b.a.c.b.ah;
import a.j.b.a.c.b.aj;
import a.j.b.a.c.b.am;
import a.j.b.a.c.b.au;
import a.j.b.a.c.b.az;
import a.j.b.a.c.b.b.a;
import a.j.b.a.c.b.n;
import a.j.b.a.c.f.f;
import a.j.b.a.c.i.c.a;
import a.j.b.a.c.l.ad;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ab
  extends y
  implements aj
{
  private au CaY;
  private final aj CaZ;
  
  static
  {
    AppMethodBeat.i(119572);
    if (!ab.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      AppMethodBeat.o(119572);
      return;
    }
  }
  
  public ab(ah paramah, a.j.b.a.c.b.a.g paramg, a.j.b.a.c.b.w paramw, az paramaz, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, b.a parama, aj paramaj, am paramam)
  {
    super(paramw, paramaz, paramah, paramg, f.ayV("<set-" + paramah.edF() + ">"), paramBoolean1, paramBoolean2, paramBoolean3, parama, paramam);
    AppMethodBeat.i(119565);
    if (paramaj != null) {}
    for (;;)
    {
      this.CaZ = paramaj;
      AppMethodBeat.o(119565);
      return;
      paramaj = this;
    }
  }
  
  public static ai a(aj paramaj, a.j.b.a.c.l.w paramw, a.j.b.a.c.b.a.g paramg)
  {
    AppMethodBeat.i(119567);
    paramaj = new ai(paramaj, null, 0, paramg, f.ayV("<set-?>"), paramw, false, false, false, null, am.BWF);
    AppMethodBeat.o(119567);
    return paramaj;
  }
  
  public final <R, D> R a(n<R, D> paramn, D paramD)
  {
    AppMethodBeat.i(119571);
    paramn = paramn.a(this, paramD);
    AppMethodBeat.o(119571);
    return paramn;
  }
  
  public final void a(au paramau)
  {
    AppMethodBeat.i(119566);
    if ((!$assertionsDisabled) && (this.CaY != null))
    {
      paramau = new AssertionError();
      AppMethodBeat.o(119566);
      throw paramau;
    }
    this.CaY = paramau;
    AppMethodBeat.o(119566);
  }
  
  public final a.j.b.a.c.l.w eds()
  {
    AppMethodBeat.i(119570);
    ad localad = a.G(this).ecn();
    AppMethodBeat.o(119570);
    return localad;
  }
  
  public final List<au> edu()
  {
    AppMethodBeat.i(119569);
    if (this.CaY == null)
    {
      localObject = new IllegalStateException();
      AppMethodBeat.o(119569);
      throw ((Throwable)localObject);
    }
    Object localObject = Collections.singletonList(this.CaY);
    AppMethodBeat.o(119569);
    return localObject;
  }
  
  public final Collection<? extends aj> edw()
  {
    AppMethodBeat.i(119568);
    Collection localCollection = super.sq(false);
    AppMethodBeat.o(119568);
    return localCollection;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     a.j.b.a.c.b.c.ab
 * JD-Core Version:    0.7.0.1
 */