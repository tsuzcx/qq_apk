package a.j.b.a.c.d.a.c.a;

import a.j.b.a.c.b.a.g.a;
import a.j.b.a.c.b.am;
import a.j.b.a.c.b.c.x;
import a.j.b.a.c.b.e;
import a.j.b.a.c.d.b.n;
import a.j.b.a.c.d.b.o;
import a.j.b.a.c.k.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import java.util.Map;

public final class h
  extends x
{
  private final a.j.b.a.c.b.a.g BXb;
  private final a.j.b.a.c.d.a.c.h Cfb;
  private final a.j.b.a.c.k.f Cgd;
  private final d Cge;
  public final a.j.b.a.c.k.f<List<a.j.b.a.c.f.b>> Cgf;
  private final a.j.b.a.c.k.f Cgg;
  private final a.j.b.a.c.d.a.e.t Cgh;
  
  static
  {
    AppMethodBeat.i(119961);
    eOJ = new a.j.k[] { (a.j.k)a.f.b.v.a(new a.f.b.t(a.f.b.v.aG(h.class), "binaryClasses", "getBinaryClasses$descriptors_jvm()Ljava/util/Map;")), (a.j.k)a.f.b.v.a(new a.f.b.t(a.f.b.v.aG(h.class), "partToFacade", "getPartToFacade()Ljava/util/HashMap;")) };
    AppMethodBeat.o(119961);
  }
  
  public h(a.j.b.a.c.d.a.c.h paramh, a.j.b.a.c.d.a.e.t paramt)
  {
    super(paramh.Cfj.BUv, paramt.eee());
    AppMethodBeat.i(119966);
    this.Cgh = paramt;
    this.Cfb = a.j.b.a.c.d.a.c.a.a(paramh, (a.j.b.a.c.b.g)this, null, 6);
    this.Cgd = this.Cfb.Cfj.BRT.l((a.f.a.a)new a(this));
    this.Cge = new d(this.Cfb, this.Cgh, this);
    this.Cgf = this.Cfb.Cfj.BRT.a((a.f.a.a)new h.c(this), (List)a.a.v.BMx);
    if (this.Cfb.Cfj.CeS.tXR) {
      paramh = a.j.b.a.c.b.a.g.BXx;
    }
    for (paramh = g.a.eeH();; paramh = a.j.b.a.c.d.a.c.f.a(this.Cfb, (a.j.b.a.c.d.a.e.d)this.Cgh))
    {
      this.BXb = paramh;
      this.Cgg = this.Cfb.Cfj.BRT.l((a.f.a.a)new h.b(this));
      AppMethodBeat.o(119966);
      return;
    }
  }
  
  public final e c(a.j.b.a.c.d.a.e.g paramg)
  {
    AppMethodBeat.i(119963);
    a.f.b.j.q(paramg, "jClass");
    j localj = this.Cge.CfB;
    a.f.b.j.q(paramg, "javaClass");
    paramg = localj.a(paramg.edF(), paramg);
    AppMethodBeat.o(119963);
    return paramg;
  }
  
  public final a.j.b.a.c.b.a.g ecM()
  {
    return this.BXb;
  }
  
  public final am ecN()
  {
    AppMethodBeat.i(119965);
    am localam = (am)new o(this);
    AppMethodBeat.o(119965);
    return localam;
  }
  
  public final Map<String, n> efU()
  {
    AppMethodBeat.i(119962);
    Map localMap = (Map)a.j.b.a.c.k.h.a(this.Cgd, eOJ[0]);
    AppMethodBeat.o(119962);
    return localMap;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(119964);
    String str = "Lazy Java package fragment: " + this.BXD;
    AppMethodBeat.o(119964);
    return str;
  }
  
  static final class a
    extends a.f.b.k
    implements a.f.a.a<Map<String, ? extends n>>
  {
    a(h paramh)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     a.j.b.a.c.d.a.c.a.h
 * JD-Core Version:    0.7.0.1
 */