package a.j.b.a.c.i.a.a;

import a.a.v;
import a.f.b.j;
import a.j.b.a.c.i.e.h;
import a.j.b.a.c.l.ad;
import a.j.b.a.c.l.ak;
import a.j.b.a.c.l.ap;
import a.j.b.a.c.l.ba;
import a.j.b.a.c.l.p;
import a.j.b.a.c.l.w;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public final class a
  extends ad
  implements ak
{
  private final a.j.b.a.c.b.a.g BXb;
  private final ap Cwv;
  private final b Cww;
  private final boolean Cwx;
  
  private a(ap paramap, b paramb, boolean paramBoolean, a.j.b.a.c.b.a.g paramg)
  {
    AppMethodBeat.i(122054);
    this.Cwv = paramap;
    this.Cww = paramb;
    this.Cwx = paramBoolean;
    this.BXb = paramg;
    AppMethodBeat.o(122054);
  }
  
  private final w b(ba paramba, w paramw)
  {
    AppMethodBeat.i(122045);
    if (this.Cwv.eoO() == paramba) {
      paramw = this.Cwv.eer();
    }
    j.p(paramw, "if (typeProjection.proje…jection.type else default");
    AppMethodBeat.o(122045);
    return paramw;
  }
  
  private a e(a.j.b.a.c.b.a.g paramg)
  {
    AppMethodBeat.i(122051);
    j.q(paramg, "newAnnotations");
    paramg = new a(this.Cwv, this.Cww, this.Cwx, paramg);
    AppMethodBeat.o(122051);
    return paramg;
  }
  
  private a sF(boolean paramBoolean)
  {
    AppMethodBeat.i(122048);
    if (paramBoolean == this.Cwx)
    {
      AppMethodBeat.o(122048);
      return this;
    }
    a locala = new a(this.Cwv, this.Cww, paramBoolean, this.BXb);
    AppMethodBeat.o(122048);
    return locala;
  }
  
  public final boolean ad(w paramw)
  {
    AppMethodBeat.i(122046);
    j.q(paramw, "type");
    if (this.Cww == paramw.enU())
    {
      AppMethodBeat.o(122046);
      return true;
    }
    AppMethodBeat.o(122046);
    return false;
  }
  
  public final a.j.b.a.c.b.a.g ecM()
  {
    return this.BXb;
  }
  
  public final h ecq()
  {
    AppMethodBeat.i(122042);
    h localh = p.cE("No member resolution should be done on captured type, it used only during constraint system resolution", true);
    j.p(localh, "ErrorUtils.createErrorSc…system resolution\", true)");
    AppMethodBeat.o(122042);
    return localh;
  }
  
  public final boolean egH()
  {
    return this.Cwx;
  }
  
  public final List<ap> enR()
  {
    return (List)v.BMx;
  }
  
  public final w enS()
  {
    AppMethodBeat.i(122043);
    Object localObject = ba.CBZ;
    ad localad = a.j.b.a.c.l.c.a.aL(this).ecm();
    j.p(localad, "builtIns.nullableAnyType");
    localObject = b((ba)localObject, (w)localad);
    AppMethodBeat.o(122043);
    return localObject;
  }
  
  public final w enT()
  {
    AppMethodBeat.i(122044);
    Object localObject = ba.CBY;
    ad localad = a.j.b.a.c.l.c.a.aL(this).eck();
    j.p(localad, "builtIns.nothingType");
    localObject = b((ba)localObject, (w)localad);
    AppMethodBeat.o(122044);
    return localObject;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(122047);
    StringBuilder localStringBuilder = new StringBuilder("Captured(").append(this.Cwv).append(')');
    if (this.Cwx) {}
    for (String str = "?";; str = "")
    {
      str = str;
      AppMethodBeat.o(122047);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     a.j.b.a.c.i.a.a.a
 * JD-Core Version:    0.7.0.1
 */