package a.j.b.a.c.b.c;

import a.j.b.a.c.b.a.a;
import a.j.b.a.c.b.ag;
import a.j.b.a.c.b.ah;
import a.j.b.a.c.b.ai;
import a.j.b.a.c.b.aj;
import a.j.b.a.c.b.am;
import a.j.b.a.c.b.ar;
import a.j.b.a.c.b.ay;
import a.j.b.a.c.b.az;
import a.j.b.a.c.b.b.a;
import a.j.b.a.c.b.l;
import a.j.b.a.c.b.n;
import a.j.b.a.c.b.r;
import a.j.b.a.c.b.t;
import a.j.b.a.c.f.f;
import a.j.b.a.c.i.c.a;
import a.j.b.a.c.l.as;
import a.j.b.a.c.l.ba;
import a.j.b.a.c.l.k;
import a.j.b.a.c.n.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class z
  extends ak
  implements ah
{
  protected List<ar> BWy;
  private a.j.b.a.c.b.ak BZC;
  protected a.j.b.a.c.b.ak BZD;
  public az BZE;
  protected final boolean BZJ;
  private final boolean BZK;
  public final b.a BZT;
  private final boolean BZi;
  protected final a.j.b.a.c.b.w BZj;
  protected Collection<? extends ah> CaK;
  private final ah CaL;
  protected final boolean CaM;
  private final boolean CaN;
  protected final boolean CaO;
  public aa CaP;
  protected aj CaQ;
  protected boolean CaR;
  protected r CaS;
  protected r CaT;
  
  protected z(l paraml, ah paramah, a.j.b.a.c.b.a.g paramg, a.j.b.a.c.b.w paramw, az paramaz, boolean paramBoolean1, f paramf, b.a parama, am paramam, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7)
  {
    super(paraml, paramg, paramf, paramBoolean1, paramam);
    AppMethodBeat.i(119538);
    this.CaK = null;
    this.BZj = paramw;
    this.BZE = paramaz;
    paraml = paramah;
    if (paramah == null) {
      paraml = this;
    }
    this.CaL = paraml;
    this.BZT = parama;
    this.CaM = paramBoolean2;
    this.CaN = paramBoolean3;
    this.BZJ = paramBoolean4;
    this.BZK = paramBoolean5;
    this.BZi = paramBoolean6;
    this.CaO = paramBoolean7;
    AppMethodBeat.o(119538);
  }
  
  private static az a(az paramaz, b.a parama)
  {
    AppMethodBeat.i(119547);
    if ((parama == b.a.BVY) && (ay.b(paramaz.eeF())))
    {
      paramaz = ay.BWR;
      AppMethodBeat.o(119547);
      return paramaz;
    }
    AppMethodBeat.o(119547);
    return paramaz;
  }
  
  public static z a(l paraml, a.j.b.a.c.b.a.g paramg, a.j.b.a.c.b.w paramw, az paramaz, f paramf, b.a parama, am paramam)
  {
    AppMethodBeat.i(119539);
    paraml = new z(paraml, null, paramg, paramw, paramaz, true, paramf, parama, paramam, false, false, false, false, false, false);
    AppMethodBeat.o(119539);
    return paraml;
  }
  
  private static t a(a.j.b.a.c.l.au paramau, ag paramag)
  {
    AppMethodBeat.i(119548);
    if (paramag.edP() != null)
    {
      paramau = paramag.edP().c(paramau);
      AppMethodBeat.o(119548);
      return paramau;
    }
    AppMethodBeat.o(119548);
    return null;
  }
  
  private z.a efg()
  {
    AppMethodBeat.i(119545);
    z.a locala = new z.a(this);
    AppMethodBeat.o(119545);
    return locala;
  }
  
  protected final ah a(z.a parama)
  {
    AppMethodBeat.i(119546);
    z localz = a(parama.CaU, parama.BZj, parama.BZE, parama.CaL, parama.BZT, parama.BYN);
    if (parama.Caj == null) {}
    a.j.b.a.c.l.au localau;
    for (Object localObject1 = this.BWy;; localObject1 = parama.Caj)
    {
      localObject3 = new ArrayList(((List)localObject1).size());
      localau = k.a((List)localObject1, parama.BZY, localz, (List)localObject3);
      localObject4 = localau.c(eer(), ba.CBZ);
      if (localObject4 != null) {
        break;
      }
      AppMethodBeat.o(119546);
      return null;
    }
    localObject1 = parama.BZD;
    if (localObject1 != null)
    {
      localObject2 = ((a.j.b.a.c.b.ak)localObject1).e(localau);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        AppMethodBeat.o(119546);
        return null;
      }
    }
    else
    {
      localObject1 = null;
    }
    if (this.BZC != null)
    {
      localObject2 = localau.c(this.BZC.eer(), ba.CBY);
      if (localObject2 == null)
      {
        AppMethodBeat.o(119546);
        return null;
      }
      localObject2 = new ac(localz, new a.j.b.a.c.i.e.a.b(localz, (a.j.b.a.c.l.w)localObject2, this.BZC.een()), this.BZC.ecM());
      localz.a((a.j.b.a.c.l.w)localObject4, (List)localObject3, (a.j.b.a.c.b.ak)localObject1, (a.j.b.a.c.b.ak)localObject2);
      if (this.CaP != null) {
        break label434;
      }
      localObject1 = null;
      if (localObject1 != null)
      {
        localObject2 = this.CaP.eds();
        ((y)localObject1).BZU = a(localau, this.CaP);
        if (localObject2 == null) {
          break label551;
        }
      }
    }
    label551:
    for (Object localObject2 = localau.c((a.j.b.a.c.l.w)localObject2, ba.CBZ);; localObject2 = null)
    {
      ((aa)localObject1).K((a.j.b.a.c.l.w)localObject2);
      if (this.CaQ != null) {
        break label557;
      }
      localObject2 = null;
      if (localObject2 == null) {
        break label714;
      }
      localObject4 = p.a((t)localObject2, this.CaQ.edu(), localau, false, false, null);
      localObject3 = localObject4;
      if (localObject4 == null)
      {
        localz.CaR = true;
        localObject3 = Collections.singletonList(ab.a((aj)localObject2, a.G(parama.CaU).eck(), ((a.j.b.a.c.b.au)this.CaQ.edu().get(0)).ecM()));
      }
      if (((List)localObject3).size() == 1) {
        break label684;
      }
      parama = new IllegalStateException();
      AppMethodBeat.o(119546);
      throw parama;
      localObject2 = null;
      break;
      label434:
      localObject2 = this.CaP.ecM();
      localObject3 = parama.BZj;
      localObject4 = a(this.CaP.BZE, parama.BZT);
      bool1 = this.CaP.isDefault;
      bool2 = this.CaP.BZi;
      bool3 = this.CaP.BZH;
      localObject5 = parama.BZT;
      if (parama.CaL == null) {}
      for (localObject1 = null;; localObject1 = parama.CaL.eeh())
      {
        localObject1 = new aa(localz, (a.j.b.a.c.b.a.g)localObject2, (a.j.b.a.c.b.w)localObject3, (az)localObject4, bool1, bool2, bool3, (b.a)localObject5, (ai)localObject1, am.BWF);
        break;
      }
    }
    label557:
    Object localObject3 = this.CaQ.ecM();
    Object localObject4 = parama.BZj;
    Object localObject5 = a(this.CaQ.ecE(), parama.BZT);
    boolean bool1 = this.CaQ.isDefault();
    boolean bool2 = this.CaQ.ecL();
    boolean bool3 = this.CaQ.ecI();
    b.a locala = parama.BZT;
    if (parama.CaL == null) {}
    for (localObject2 = null;; localObject2 = parama.CaL.eei())
    {
      localObject2 = new ab(localz, (a.j.b.a.c.b.a.g)localObject3, (a.j.b.a.c.b.w)localObject4, (az)localObject5, bool1, bool2, bool3, locala, (aj)localObject2, am.BWF);
      break;
    }
    label684:
    ((y)localObject2).BZU = a(localau, this.CaQ);
    ((ab)localObject2).a((a.j.b.a.c.b.au)((List)localObject3).get(0));
    label714:
    if (this.CaS == null)
    {
      localObject3 = null;
      if (this.CaT != null) {
        break label829;
      }
    }
    label829:
    for (localObject4 = null;; localObject4 = new o(this.CaT.ecM(), localz))
    {
      localz.a((aa)localObject1, (aj)localObject2, (r)localObject3, (r)localObject4);
      if (!parama.Caf) {
        break label858;
      }
      parama = i.epb();
      localObject1 = edw().iterator();
      while (((Iterator)localObject1).hasNext()) {
        parama.add(((ah)((Iterator)localObject1).next()).d(localau));
      }
      localObject3 = new o(this.CaS.ecM(), localz);
      break;
    }
    localz.i(parama);
    label858:
    if ((eeA()) && (this.Cbr != null)) {
      localz.a(this.Cbr);
    }
    AppMethodBeat.o(119546);
    return localz;
  }
  
  protected z a(l paraml, a.j.b.a.c.b.w paramw, az paramaz, ah paramah, b.a parama, f paramf)
  {
    AppMethodBeat.i(119549);
    paraml = new z(paraml, paramah, ecM(), paramw, paramaz, this.Cbq, paramf, parama, am.BWF, this.CaM, eeA(), this.BZJ, this.BZK, ecL(), this.CaO);
    AppMethodBeat.o(119549);
    return paraml;
  }
  
  public <V> V a(a.a<V> parama)
  {
    return null;
  }
  
  public final <R, D> R a(n<R, D> paramn, D paramD)
  {
    AppMethodBeat.i(119550);
    paramn = paramn.a(this, paramD);
    AppMethodBeat.o(119550);
    return paramn;
  }
  
  public final void a(aa paramaa, aj paramaj)
  {
    AppMethodBeat.i(119541);
    a(paramaa, paramaj, null, null);
    AppMethodBeat.o(119541);
  }
  
  public final void a(aa paramaa, aj paramaj, r paramr1, r paramr2)
  {
    this.CaP = paramaa;
    this.CaQ = paramaj;
    this.CaS = paramr1;
    this.CaT = paramr2;
  }
  
  public final void a(a.j.b.a.c.l.w paramw, List<? extends ar> paramList, a.j.b.a.c.b.ak paramak1, a.j.b.a.c.b.ak paramak2)
  {
    AppMethodBeat.i(119540);
    N(paramw);
    this.BWy = new ArrayList(paramList);
    this.BZC = paramak2;
    this.BZD = paramak1;
    AppMethodBeat.o(119540);
  }
  
  public final ah d(a.j.b.a.c.l.au paramau)
  {
    AppMethodBeat.i(119544);
    if (paramau.BZY.isEmpty())
    {
      AppMethodBeat.o(119544);
      return this;
    }
    z.a locala = efg();
    locala.BZY = paramau.BZY;
    paramau = locala.i(eek()).efi();
    AppMethodBeat.o(119544);
    return paramau;
  }
  
  public final a.j.b.a.c.b.w ecC()
  {
    return this.BZj;
  }
  
  public final az ecE()
  {
    return this.BZE;
  }
  
  public final boolean ecJ()
  {
    return this.BZJ;
  }
  
  public final boolean ecK()
  {
    return this.BZK;
  }
  
  public boolean ecL()
  {
    return this.BZi;
  }
  
  public final a.j.b.a.c.b.ak edp()
  {
    return this.BZC;
  }
  
  public final a.j.b.a.c.b.ak edq()
  {
    return this.BZD;
  }
  
  public final List<ar> edr()
  {
    return this.BWy;
  }
  
  public final a.j.b.a.c.l.w eds()
  {
    AppMethodBeat.i(119542);
    a.j.b.a.c.l.w localw = eer();
    AppMethodBeat.o(119542);
    return localw;
  }
  
  public final Collection<? extends ah> edw()
  {
    AppMethodBeat.i(119552);
    if (this.CaK != null)
    {
      localObject = this.CaK;
      AppMethodBeat.o(119552);
      return localObject;
    }
    Object localObject = Collections.emptyList();
    AppMethodBeat.o(119552);
    return localObject;
  }
  
  public final b.a edy()
  {
    return this.BZT;
  }
  
  public boolean eeA()
  {
    return this.CaN;
  }
  
  public final boolean eeB()
  {
    return this.CaM;
  }
  
  public final boolean eeC()
  {
    return this.CaO;
  }
  
  public final aj eei()
  {
    return this.CaQ;
  }
  
  public final List<ag> eej()
  {
    AppMethodBeat.i(119543);
    ArrayList localArrayList = new ArrayList(2);
    if (this.CaP != null) {
      localArrayList.add(this.CaP);
    }
    if (this.CaQ != null) {
      localArrayList.add(this.CaQ);
    }
    AppMethodBeat.o(119543);
    return localArrayList;
  }
  
  public final ah eek()
  {
    AppMethodBeat.i(119551);
    if (this.CaL == this)
    {
      AppMethodBeat.o(119551);
      return this;
    }
    ah localah = this.CaL.eek();
    AppMethodBeat.o(119551);
    return localah;
  }
  
  public final r eel()
  {
    return this.CaS;
  }
  
  public final r eem()
  {
    return this.CaT;
  }
  
  public final void i(Collection<? extends a.j.b.a.c.b.b> paramCollection)
  {
    this.CaK = paramCollection;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     a.j.b.a.c.b.c.z
 * JD-Core Version:    0.7.0.1
 */