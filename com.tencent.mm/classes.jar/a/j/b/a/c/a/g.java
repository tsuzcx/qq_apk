package a.j.b.a.c.a;

import a.a.aj;
import a.j.b.a.c.a.a.b.b;
import a.j.b.a.c.b.ab;
import a.j.b.a.c.b.ah;
import a.j.b.a.c.b.ai;
import a.j.b.a.c.b.b.a.a;
import a.j.b.a.c.b.b.c.b;
import a.j.b.a.c.b.c.v;
import a.j.b.a.c.b.e;
import a.j.b.a.c.b.l;
import a.j.b.a.c.b.q;
import a.j.b.a.c.b.s;
import a.j.b.a.c.b.y;
import a.j.b.a.c.i.d;
import a.j.b.a.c.k.i;
import a.j.b.a.c.l.ad;
import a.j.b.a.c.l.an;
import a.j.b.a.c.l.ap;
import a.j.b.a.c.l.ar;
import a.j.b.a.c.l.av;
import a.j.b.a.c.l.ba;
import a.j.b.a.c.l.w;
import a.j.b.a.c.l.x;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class g
{
  public static final a.j.b.a.c.f.f BRI;
  public static final a.j.b.a.c.f.b BRJ;
  private static final a.j.b.a.c.f.b BRK;
  public static final a.j.b.a.c.f.b BRL;
  public static final a.j.b.a.c.f.b BRM;
  public static final a.j.b.a.c.f.b BRN;
  public static final Set<a.j.b.a.c.f.b> BRO;
  public static final g.a BRU;
  public static final a.j.b.a.c.f.f BRV;
  public v BRP;
  private final a.j.b.a.c.k.f<c> BRQ;
  public final a.j.b.a.c.k.f<g.b> BRR;
  private final a.j.b.a.c.k.c<a.j.b.a.c.f.f, e> BRS;
  protected final i BRT;
  
  static
  {
    if (!g.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      Object localObject = a.j.b.a.c.f.f.ayT("kotlin");
      BRI = (a.j.b.a.c.f.f)localObject;
      localObject = a.j.b.a.c.f.b.s((a.j.b.a.c.f.f)localObject);
      BRJ = (a.j.b.a.c.f.b)localObject;
      BRK = ((a.j.b.a.c.f.b)localObject).q(a.j.b.a.c.f.f.ayT("annotation"));
      BRL = BRJ.q(a.j.b.a.c.f.f.ayT("collections"));
      BRM = BRJ.q(a.j.b.a.c.f.f.ayT("ranges"));
      BRN = BRJ.q(a.j.b.a.c.f.f.ayT("text"));
      BRO = aj.setOf(new a.j.b.a.c.f.b[] { BRJ, BRL, BRM, BRK, j.ecs(), BRJ.q(a.j.b.a.c.f.f.ayT("internal")), d.CvH });
      BRU = new g.a();
      BRV = a.j.b.a.c.f.f.ayV("<built-ins module>");
      return;
    }
  }
  
  protected g(i parami)
  {
    this.BRT = parami;
    this.BRR = parami.l(new g.1(this));
    this.BRQ = parami.l(new g.2(this));
    this.BRS = parami.i(new g.3(this));
  }
  
  public static boolean A(w paramw)
  {
    return a(paramw, BRU.BSa);
  }
  
  public static boolean B(w paramw)
  {
    return (A(paramw)) && (paramw.egH());
  }
  
  public static boolean C(w paramw)
  {
    return B(paramw);
  }
  
  public static boolean D(w paramw)
  {
    return b(paramw, BRU.BSe);
  }
  
  public static boolean E(w paramw)
  {
    return (paramw != null) && (b(paramw, BRU.BSg));
  }
  
  public static String TS(int paramInt)
  {
    return "Function".concat(String.valueOf(paramInt));
  }
  
  public static a.j.b.a.c.f.a TT(int paramInt)
  {
    return new a.j.b.a.c.f.a(BRJ, a.j.b.a.c.f.f.ayT(TS(paramInt)));
  }
  
  public static e a(a.j.b.a.c.f.f paramf, ab paramab)
  {
    Object localObject = paramab.ecq().c(paramf, a.j.b.a.c.c.a.c.Cbw);
    assert ((localObject == null) || ((localObject instanceof e))) : ("Must be a class descriptor " + paramf + ", but was " + localObject);
    localObject = (e)localObject;
    if (localObject == null) {
      throw new AssertionError("Built-in class " + paramab.eee().q(paramf).CqE.CqJ + " is not found");
    }
    return localObject;
  }
  
  private static boolean a(a.j.b.a.c.b.h paramh, a.j.b.a.c.f.c paramc)
  {
    return (paramh.edF().equals(paramc.emh())) && (paramc.equals(d.n(paramh)));
  }
  
  private static boolean a(w paramw, a.j.b.a.c.f.c paramc)
  {
    paramw = paramw.enU().ecR();
    return ((paramw instanceof e)) && (a(paramw, paramc));
  }
  
  public static boolean b(l paraml)
  {
    boolean bool = false;
    if (d.a(paraml, c.class, false) != null) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean b(a.j.b.a.c.f.c paramc)
  {
    return BRU.BTw.get(paramc) != null;
  }
  
  private static boolean b(w paramw, a.j.b.a.c.f.c paramc)
  {
    return (!paramw.egH()) && (a(paramw, paramc));
  }
  
  private e c(a.j.b.a.c.f.f paramf)
  {
    return (e)this.BRS.S(paramf);
  }
  
  public static a.j.b.a.c.f.b c(h paramh)
  {
    return BRJ.q(paramh.BTN);
  }
  
  public static boolean c(e parame)
  {
    return (a(parame, BRU.BSh)) || (e(parame) != null);
  }
  
  public static boolean c(l paraml)
  {
    while (paraml != null)
    {
      if ((paraml instanceof ab)) {
        return ((ab)paraml).eee().r(BRI);
      }
      paraml = paraml.ecv();
    }
    return false;
  }
  
  private static boolean c(w paramw, a.j.b.a.c.f.c paramc)
  {
    return (a(paramw, paramc)) && (!paramw.egH());
  }
  
  public static h d(l paraml)
  {
    if (BRU.BTt.contains(paraml.edF())) {
      return (h)BRU.BTv.get(d.n(paraml));
    }
    return null;
  }
  
  public static boolean d(e parame)
  {
    return d(parame) != null;
  }
  
  public static h e(l paraml)
  {
    if (BRU.BTu.contains(paraml.edF())) {
      return (h)BRU.BTw.get(d.n(paraml));
    }
    return null;
  }
  
  public static boolean e(e parame)
  {
    return (a(parame, BRU.BSa)) || (a(parame, BRU.BSb));
  }
  
  public static boolean f(e parame)
  {
    return a(parame, BRU.BSa);
  }
  
  public static boolean f(l paraml)
  {
    if (paraml.edC().ecM().j(BRU.BSy)) {
      return true;
    }
    if ((paraml instanceof ah))
    {
      boolean bool = ((ah)paraml).eey();
      ai localai = ((ah)paraml).eeh();
      paraml = ((ah)paraml).eei();
      return (localai != null) && (f(localai)) && ((!bool) || ((paraml != null) && (f(paraml))));
    }
    return false;
  }
  
  public static boolean g(e parame)
  {
    return a(parame, BRU.BTc);
  }
  
  public static boolean n(w paramw)
  {
    return a(paramw, BRU.BSh);
  }
  
  public static boolean o(w paramw)
  {
    paramw = paramw.enU().ecR();
    return (paramw != null) && (e(paramw) != null);
  }
  
  public static boolean p(w paramw)
  {
    if (!paramw.egH())
    {
      paramw = paramw.enU().ecR();
      if (((paramw instanceof e)) && (d((e)paramw))) {}
      for (int i = 1; i != 0; i = 0) {
        return true;
      }
    }
    return false;
  }
  
  public static boolean q(w paramw)
  {
    return c(paramw, BRU.BSi);
  }
  
  public static boolean r(w paramw)
  {
    return c(paramw, BRU.BSj);
  }
  
  public static boolean s(w paramw)
  {
    return c(paramw, BRU.BSm);
  }
  
  public static boolean t(w paramw)
  {
    return c(paramw, BRU.BSk);
  }
  
  public static boolean u(w paramw)
  {
    return c(paramw, BRU.BSn);
  }
  
  public static boolean v(w paramw)
  {
    return c(paramw, BRU.BSl);
  }
  
  public static boolean w(w paramw)
  {
    return (a(paramw, BRU.BSo)) && (!paramw.egH());
  }
  
  public static boolean x(w paramw)
  {
    return (a(paramw, BRU.BSp)) && (!paramw.egH());
  }
  
  public static boolean y(w paramw)
  {
    return (z(paramw)) && (!av.aB(paramw));
  }
  
  public static boolean z(w paramw)
  {
    return a(paramw, BRU.BSb);
  }
  
  public final e TU(int paramInt)
  {
    a.j.b.a.c.f.f localf = a.j.b.a.c.f.f.ayT(b.b.BUG.BUL + paramInt);
    return c(d.CvH.q(localf));
  }
  
  public final ad a(h paramh)
  {
    return ayx(paramh.BTN.name).edE();
  }
  
  public final ad a(ba paramba, w paramw)
  {
    paramba = Collections.singletonList(new ar(paramba, paramw));
    paramw = a.j.b.a.c.b.a.g.BXx;
    return x.a(a.j.b.a.c.b.a.g.a.eeH(), ayx("Array"), paramba);
  }
  
  public final e ayx(String paramString)
  {
    return c(a.j.b.a.c.f.f.ayT(paramString));
  }
  
  public final ad b(h paramh)
  {
    return (ad)((c)this.BRQ.invoke()).BTB.get(paramh);
  }
  
  public final e c(a.j.b.a.c.f.b paramb)
  {
    e locale = q.a(this.BRP, paramb, a.j.b.a.c.c.a.c.Cbw);
    assert (locale != null) : "Can't find built-in class ".concat(String.valueOf(paramb));
    return locale;
  }
  
  protected final void ecg()
  {
    this.BRP = new v(BRV, this.BRT, this);
    v localv = this.BRP;
    Object localObject = b.BRz;
    localObject = (b)b.a.BRA.getValue();
    ecj();
    eci();
    ech();
    localv.a(((b)localObject).ecd());
    this.BRP.a(new v[] { this.BRP });
  }
  
  protected a.j.b.a.c.b.b.a ech()
  {
    return a.a.BYJ;
  }
  
  protected a.j.b.a.c.b.b.c eci()
  {
    return c.b.BYL;
  }
  
  protected Iterable<a.j.b.a.c.b.b.b> ecj()
  {
    return Collections.singletonList(new a.j.b.a.c.a.a.a(this.BRT, this.BRP));
  }
  
  public final ad eck()
  {
    return ayx("Nothing").edE();
  }
  
  public final ad ecl()
  {
    return ayx("Any").edE();
  }
  
  public final ad ecm()
  {
    return ecl().ss(true);
  }
  
  public final ad ecn()
  {
    return ayx("Unit").edE();
  }
  
  public final ad eco()
  {
    return ayx("String").edE();
  }
  
  public final w l(w paramw)
  {
    Object localObject2;
    if (n(paramw))
    {
      if (paramw.enR().size() != 1) {
        throw new IllegalStateException();
      }
      localObject2 = ((ap)paramw.enR().get(0)).eer();
    }
    Object localObject3;
    do
    {
      return localObject2;
      localObject3 = av.aA(paramw);
      localObject1 = (w)((c)this.BRQ.invoke()).BTD.get(localObject3);
      localObject2 = localObject1;
    } while (localObject1 != null);
    Object localObject1 = d.Y((w)localObject3);
    if (localObject1 != null)
    {
      localObject2 = ((w)localObject3).enU().ecR();
      if (localObject2 != null) {
        break label138;
      }
      localObject1 = null;
    }
    for (;;)
    {
      localObject2 = localObject1;
      if (localObject1 != null) {
        break;
      }
      throw new IllegalStateException("not array: ".concat(String.valueOf(paramw)));
      label138:
      localObject3 = m.BUu;
      if (!m.d(((a.j.b.a.c.b.h)localObject2).edF()))
      {
        localObject1 = null;
      }
      else
      {
        localObject2 = a.j.b.a.c.i.c.a.c((a.j.b.a.c.b.h)localObject2);
        if (localObject2 == null)
        {
          localObject1 = null;
        }
        else
        {
          localObject3 = m.BUu;
          localObject2 = m.c((a.j.b.a.c.f.a)localObject2);
          if (localObject2 == null)
          {
            localObject1 = null;
          }
          else
          {
            localObject1 = s.a((y)localObject1, (a.j.b.a.c.f.a)localObject2);
            if (localObject1 == null) {
              localObject1 = null;
            } else {
              localObject1 = ((e)localObject1).edE();
            }
          }
        }
      }
    }
  }
  
  public final ad m(w paramw)
  {
    Object localObject = (ad)((c)this.BRQ.invoke()).BTC.get(paramw);
    if (localObject != null) {
      return localObject;
    }
    localObject = m.BUu;
    if (m.G(paramw))
    {
      if (av.aB(paramw)) {
        return null;
      }
      localObject = d.Y(paramw);
      if (localObject == null) {
        return null;
      }
      a.j.b.a.c.f.a locala = a.j.b.a.c.i.c.a.c(paramw.enU().ecR());
      assert (locala != null) : "unsignedClassId should not be null for unsigned type ".concat(String.valueOf(paramw));
      paramw = m.BUu;
      paramw = m.d(locala);
      assert (paramw != null) : "arrayClassId should not be null for unsigned type ".concat(String.valueOf(locala));
      paramw = s.a((y)localObject, paramw);
      if (paramw == null) {
        return null;
      }
      return paramw.edE();
    }
    return null;
  }
  
  static final class c
  {
    public final Map<h, ad> BTB;
    public final Map<w, ad> BTC;
    public final Map<ad, ad> BTD;
    
    private c(Map<h, ad> paramMap, Map<w, ad> paramMap1, Map<ad, ad> paramMap2)
    {
      this.BTB = paramMap;
      this.BTC = paramMap1;
      this.BTD = paramMap2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     a.j.b.a.c.a.g
 * JD-Core Version:    0.7.0.1
 */