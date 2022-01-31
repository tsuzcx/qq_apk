package a.j.b.a.c.i.a.a;

import a.a.v;
import a.aa;
import a.j.b.a.c.a.g;
import a.j.b.a.c.b.ar;
import a.j.b.a.c.l.a.f;
import a.j.b.a.c.l.an;
import a.j.b.a.c.l.ap;
import a.j.b.a.c.l.ba;
import a.j.b.a.c.l.w;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.List;

public final class b
  implements an
{
  public final ap Cwv;
  public f Cwy;
  
  public b(ap paramap)
  {
    AppMethodBeat.i(122059);
    this.Cwv = paramap;
    if (this.Cwv.eoO() != ba.CBX) {}
    for (int i = 1; (aa.BMh) && (i == 0); i = 0)
    {
      paramap = (Throwable)new AssertionError("Only nontrivial projections can be captured, not: " + this.Cwv);
      AppMethodBeat.o(122059);
      throw paramap;
    }
    AppMethodBeat.o(122059);
  }
  
  public final boolean ecT()
  {
    return false;
  }
  
  public final Collection<w> eeO()
  {
    AppMethodBeat.i(122056);
    if (this.Cwv.eoO() == ba.CBZ) {}
    for (Object localObject = this.Cwv.eer();; localObject = (w)eec().ecm())
    {
      a.f.b.j.p(localObject, "if (typeProjection.proje… builtIns.nullableAnyType");
      localObject = (Collection)a.a.j.listOf(localObject);
      AppMethodBeat.o(122056);
      return localObject;
    }
  }
  
  public final g eec()
  {
    AppMethodBeat.i(122058);
    g localg = this.Cwv.eer().enU().eec();
    a.f.b.j.p(localg, "typeProjection.type.constructor.builtIns");
    AppMethodBeat.o(122058);
    return localg;
  }
  
  public final List<ar> getParameters()
  {
    return (List)v.BMx;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(122057);
    String str = "CapturedTypeConstructor(" + this.Cwv + ')';
    AppMethodBeat.o(122057);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     a.j.b.a.c.i.a.a.b
 * JD-Core Version:    0.7.0.1
 */