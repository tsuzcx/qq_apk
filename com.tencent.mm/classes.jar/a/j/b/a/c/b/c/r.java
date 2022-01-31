package a.j.b.a.c.b.c;

import a.f.a.a;
import a.f.b.t;
import a.j.b.a.c.b.a.g.a;
import a.j.b.a.c.b.ab;
import a.j.b.a.c.b.ad;
import a.j.b.a.c.b.n;
import a.j.b.a.c.f.b;
import a.j.b.a.c.f.c;
import a.j.b.a.c.i.e.g;
import a.j.b.a.c.k.f;
import a.j.b.a.c.k.i;
import a.j.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public final class r
  extends j
  implements ad
{
  final b BXD;
  private final f Cap;
  private final a.j.b.a.c.i.e.h Caq;
  final v Car;
  
  static
  {
    AppMethodBeat.i(119466);
    eOJ = new k[] { (k)a.f.b.v.a(new t(a.f.b.v.aG(r.class), "fragments", "getFragments()Ljava/util/List;")) };
    AppMethodBeat.o(119466);
  }
  
  public r(v paramv, b paramb, i parami)
  {
    super(g.a.eeH(), paramb.CqE.emi());
    AppMethodBeat.i(119472);
    this.Car = paramv;
    this.BXD = paramb;
    this.Cap = parami.l((a)new r.a(this));
    this.Caq = ((a.j.b.a.c.i.e.h)new g(parami.l((a)new r.b(this))));
    AppMethodBeat.o(119472);
  }
  
  public final <R, D> R a(n<R, D> paramn, D paramD)
  {
    AppMethodBeat.i(119471);
    a.f.b.j.q(paramn, "visitor");
    paramn = paramn.a((ad)this, paramD);
    AppMethodBeat.o(119471);
    return paramn;
  }
  
  public final a.j.b.a.c.i.e.h ecq()
  {
    return this.Caq;
  }
  
  public final b eee()
  {
    return this.BXD;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(119469);
    if (!(paramObject instanceof ad)) {
      paramObject = null;
    }
    for (;;)
    {
      paramObject = (ad)paramObject;
      if (paramObject == null)
      {
        AppMethodBeat.o(119469);
        return false;
      }
      if ((a.f.b.j.e(this.BXD, paramObject.eee())) && (a.f.b.j.e(this.Car, paramObject.eef())))
      {
        AppMethodBeat.o(119469);
        return true;
      }
      AppMethodBeat.o(119469);
      return false;
    }
  }
  
  public final List<ab> getFragments()
  {
    AppMethodBeat.i(119467);
    List localList = (List)a.j.b.a.c.k.h.a(this.Cap, eOJ[0]);
    AppMethodBeat.o(119467);
    return localList;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(119470);
    int i = this.Car.hashCode();
    int j = this.BXD.hashCode();
    AppMethodBeat.o(119470);
    return i * 31 + j;
  }
  
  public final boolean isEmpty()
  {
    AppMethodBeat.i(119473);
    boolean bool = getFragments().isEmpty();
    AppMethodBeat.o(119473);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     a.j.b.a.c.b.c.r
 * JD-Core Version:    0.7.0.1
 */