package a.j.b.a.c.d.a.c.a;

import a.a.aj;
import a.a.v;
import a.aa;
import a.f.b.j;
import a.f.b.k;
import a.j.b.a.c.b.am;
import a.j.b.a.c.b.ar;
import a.j.b.a.c.b.ay;
import a.j.b.a.c.b.az;
import a.j.b.a.c.b.e;
import a.j.b.a.c.b.w;
import a.j.b.a.c.b.w.a;
import a.j.b.a.c.d.a.e.x;
import a.j.b.a.c.d.a.n;
import a.j.b.a.c.k.i;
import a.j.b.a.c.l.an;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.List;
import java.util.Set;

public final class f
  extends a.j.b.a.c.b.c.g
  implements a.j.b.a.c.d.a.b.d
{
  private static final Set<String> CfP;
  public static final a CfQ;
  private final boolean BWA;
  private final a.j.b.a.c.b.a.g BXb;
  private final az BZE;
  private final w BZj;
  private final a.j.b.a.c.b.f BZk;
  final f.b CfJ;
  public final g CfK;
  private final a.j.b.a.c.i.e.f CfL;
  private final l CfM;
  private final a.j.b.a.c.k.f<List<ar>> CfN;
  private final e CfO;
  public final a.j.b.a.c.d.a.c.h Cfb;
  public final a.j.b.a.c.d.a.e.g Cfx;
  
  static
  {
    AppMethodBeat.i(119901);
    CfQ = new a((byte)0);
    CfP = aj.setOf(new String[] { "equals", "hashCode", "getClass", "wait", "notify", "notifyAll", "toString" });
    AppMethodBeat.o(119901);
  }
  
  public f(a.j.b.a.c.d.a.c.h paramh, a.j.b.a.c.b.l paraml, a.j.b.a.c.d.a.e.g paramg, e parame)
  {
    super(paramh.Cfj.BRT, paraml, paramg.edF(), (am)paramh.Cfj.CeN.a((a.j.b.a.c.d.a.e.l)paramg));
    AppMethodBeat.i(119900);
    this.Cfx = paramg;
    this.CfO = parame;
    this.Cfb = a.j.b.a.c.d.a.c.a.a(paramh, (a.j.b.a.c.b.g)this, (x)this.Cfx, 4);
    boolean bool1 = aa.BMh;
    if (this.Cfx.egg())
    {
      paramh = a.j.b.a.c.b.f.BWj;
      this.BZk = paramh;
      if (!this.Cfx.egg()) {
        break label360;
      }
      paramh = w.BWp;
      this.BZj = paramh;
      this.BZE = this.Cfx.ecE();
      if ((this.Cfx.egf() == null) || (this.Cfx.isStatic())) {
        break label429;
      }
    }
    label391:
    label423:
    label429:
    for (bool1 = bool3;; bool1 = false)
    {
      this.BWA = bool1;
      this.CfJ = new f.b(this);
      this.CfK = new g(this.Cfb, (e)this, this.Cfx);
      this.CfL = new a.j.b.a.c.i.e.f((a.j.b.a.c.i.e.h)this.CfK);
      this.CfM = new l(this.Cfb, this.Cfx, this);
      this.BXb = a.j.b.a.c.d.a.c.f.a(this.Cfb, (a.j.b.a.c.d.a.e.d)this.Cfx);
      this.CfN = this.Cfb.Cfj.BRT.l((a.f.a.a)new c(this));
      AppMethodBeat.o(119900);
      return;
      if (this.Cfx.isInterface())
      {
        paramh = a.j.b.a.c.b.f.BWg;
        break;
      }
      if (this.Cfx.isEnum())
      {
        paramh = a.j.b.a.c.b.f.BWh;
        break;
      }
      paramh = a.j.b.a.c.b.f.BWf;
      break;
      label360:
      paramh = w.BWu;
      if ((this.Cfx.egw()) || (this.Cfx.isInterface()))
      {
        bool1 = true;
        if (this.Cfx.egx()) {
          break label423;
        }
      }
      for (boolean bool2 = true;; bool2 = false)
      {
        paramh = w.a.ap(bool1, bool2);
        break;
        bool1 = false;
        break label391;
      }
    }
  }
  
  public final a.j.b.a.c.b.f ecB()
  {
    return this.BZk;
  }
  
  public final w ecC()
  {
    return this.BZj;
  }
  
  public final a.j.b.a.c.b.d ecD()
  {
    return null;
  }
  
  public final az ecE()
  {
    AppMethodBeat.i(119895);
    if ((j.e(this.BZE, ay.BWK)) && (this.Cfx.egf() == null)) {}
    for (az localaz = n.CcU;; localaz = this.BZE)
    {
      j.p(localaz, "if (visibility == Visibi…ISIBILITY else visibility");
      AppMethodBeat.o(119895);
      return localaz;
    }
  }
  
  public final boolean ecF()
  {
    return false;
  }
  
  public final boolean ecG()
  {
    return this.BWA;
  }
  
  public final boolean ecH()
  {
    return false;
  }
  
  public final boolean ecI()
  {
    return false;
  }
  
  public final boolean ecJ()
  {
    return false;
  }
  
  public final boolean ecK()
  {
    return false;
  }
  
  public final a.j.b.a.c.b.a.g ecM()
  {
    return this.BXb;
  }
  
  public final Collection<e> ecO()
  {
    return (Collection)v.BMx;
  }
  
  public final List<ar> ecP()
  {
    AppMethodBeat.i(119898);
    List localList = (List)this.CfN.invoke();
    AppMethodBeat.o(119898);
    return localList;
  }
  
  public final a.j.b.a.c.i.e.h ecw()
  {
    return (a.j.b.a.c.i.e.h)this.CfM;
  }
  
  public final an ecx()
  {
    return (an)this.CfJ;
  }
  
  public final e ecz()
  {
    return null;
  }
  
  public final a.j.b.a.c.i.e.h edJ()
  {
    return (a.j.b.a.c.i.e.h)this.CfL;
  }
  
  public final List<a.j.b.a.c.b.d> efQ()
  {
    AppMethodBeat.i(119896);
    List localList = (List)this.CfK.CfU.invoke();
    AppMethodBeat.o(119896);
    return localList;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(119899);
    String str = "Lazy Java class " + a.j.b.a.c.i.c.a.q((a.j.b.a.c.b.l)this);
    AppMethodBeat.o(119899);
    return str;
  }
  
  public static final class a {}
  
  static final class c
    extends k
    implements a.f.a.a<List<? extends ar>>
  {
    c(f paramf)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     a.j.b.a.c.d.a.c.a.f
 * JD-Core Version:    0.7.0.1
 */