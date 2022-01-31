package a.j.b.a.c.b.c;

import a.a.j;
import a.j.b.a.c.b.a.g;
import a.j.b.a.c.b.ak;
import a.j.b.a.c.b.am;
import a.j.b.a.c.b.ar;
import a.j.b.a.c.b.az;
import a.j.b.a.c.b.d;
import a.j.b.a.c.b.n;
import a.j.b.a.c.i.e.h;
import a.j.b.a.c.l.ad;
import a.j.b.a.c.l.an;
import a.j.b.a.c.l.as;
import a.j.b.a.c.l.au;
import a.j.b.a.c.l.av;
import a.j.b.a.c.l.ba;
import a.j.b.a.c.l.k;
import a.j.b.a.c.l.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public final class s
  implements a.j.b.a.c.b.e
{
  private an BZl;
  private final a.j.b.a.c.b.e Cat;
  private final au Cau;
  private au Cav;
  private List<ar> Caw;
  private List<ar> Cax;
  
  public s(a.j.b.a.c.b.e parame, au paramau)
  {
    this.Cat = parame;
    this.Cau = paramau;
  }
  
  private au eeX()
  {
    AppMethodBeat.i(119475);
    if (this.Cav == null)
    {
      if (!this.Cau.BZY.isEmpty()) {
        break label45;
      }
      this.Cav = this.Cau;
    }
    for (;;)
    {
      Object localObject = this.Cav;
      AppMethodBeat.o(119475);
      return localObject;
      label45:
      localObject = this.Cat.ecx().getParameters();
      this.Caw = new ArrayList(((List)localObject).size());
      this.Cav = k.a((List)localObject, this.Cau.BZY, this, this.Caw);
      this.Cax = j.b(this.Caw, new a.f.a.b() {});
    }
  }
  
  public final h a(as paramas)
  {
    AppMethodBeat.i(119477);
    paramas = this.Cat.a(paramas);
    if (this.Cau.BZY.isEmpty())
    {
      AppMethodBeat.o(119477);
      return paramas;
    }
    paramas = new a.j.b.a.c.i.e.l(paramas, eeX());
    AppMethodBeat.o(119477);
    return paramas;
  }
  
  public final <R, D> R a(n<R, D> paramn, D paramD)
  {
    AppMethodBeat.i(119498);
    paramn = paramn.a(this, paramD);
    AppMethodBeat.o(119498);
    return paramn;
  }
  
  public final Collection<d> ecA()
  {
    AppMethodBeat.i(119482);
    Object localObject = this.Cat.ecA();
    ArrayList localArrayList = new ArrayList(((Collection)localObject).size());
    localObject = ((Collection)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      d locald = (d)((Iterator)localObject).next();
      localArrayList.add(locald.a(this, locald.ecC(), locald.ecE(), locald.edy(), false).a(eeX()));
    }
    AppMethodBeat.o(119482);
    return localArrayList;
  }
  
  public final a.j.b.a.c.b.f ecB()
  {
    AppMethodBeat.i(119488);
    a.j.b.a.c.b.f localf = this.Cat.ecB();
    AppMethodBeat.o(119488);
    return localf;
  }
  
  public final a.j.b.a.c.b.w ecC()
  {
    AppMethodBeat.i(119489);
    a.j.b.a.c.b.w localw = this.Cat.ecC();
    AppMethodBeat.o(119489);
    return localw;
  }
  
  public final d ecD()
  {
    AppMethodBeat.i(119500);
    d locald = this.Cat.ecD();
    AppMethodBeat.o(119500);
    return locald;
  }
  
  public final az ecE()
  {
    AppMethodBeat.i(119490);
    az localaz = this.Cat.ecE();
    AppMethodBeat.o(119490);
    return localaz;
  }
  
  public final boolean ecF()
  {
    AppMethodBeat.i(119495);
    boolean bool = this.Cat.ecF();
    AppMethodBeat.o(119495);
    return bool;
  }
  
  public final boolean ecG()
  {
    AppMethodBeat.i(119491);
    boolean bool = this.Cat.ecG();
    AppMethodBeat.o(119491);
    return bool;
  }
  
  public final boolean ecH()
  {
    AppMethodBeat.i(119492);
    boolean bool = this.Cat.ecH();
    AppMethodBeat.o(119492);
    return bool;
  }
  
  public final boolean ecI()
  {
    AppMethodBeat.i(119493);
    boolean bool = this.Cat.ecI();
    AppMethodBeat.o(119493);
    return bool;
  }
  
  public final boolean ecJ()
  {
    AppMethodBeat.i(119496);
    boolean bool = this.Cat.ecJ();
    AppMethodBeat.o(119496);
    return bool;
  }
  
  public final boolean ecK()
  {
    AppMethodBeat.i(119497);
    boolean bool = this.Cat.ecK();
    AppMethodBeat.o(119497);
    return bool;
  }
  
  public final boolean ecL()
  {
    AppMethodBeat.i(119494);
    boolean bool = this.Cat.ecL();
    AppMethodBeat.o(119494);
    return bool;
  }
  
  public final g ecM()
  {
    AppMethodBeat.i(119483);
    g localg = this.Cat.ecM();
    AppMethodBeat.o(119483);
    return localg;
  }
  
  public final am ecN()
  {
    return am.BWF;
  }
  
  public final Collection<a.j.b.a.c.b.e> ecO()
  {
    AppMethodBeat.i(119502);
    Collection localCollection = this.Cat.ecO();
    AppMethodBeat.o(119502);
    return localCollection;
  }
  
  public final List<ar> ecP()
  {
    AppMethodBeat.i(119501);
    eeX();
    List localList = this.Cax;
    AppMethodBeat.o(119501);
    return localList;
  }
  
  public final a.j.b.a.c.b.l ecv()
  {
    AppMethodBeat.i(119486);
    a.j.b.a.c.b.l locall = this.Cat.ecv();
    AppMethodBeat.o(119486);
    return locall;
  }
  
  public final h ecw()
  {
    AppMethodBeat.i(119479);
    h localh = this.Cat.ecw();
    AppMethodBeat.o(119479);
    return localh;
  }
  
  public final an ecx()
  {
    AppMethodBeat.i(119476);
    Object localObject2 = this.Cat.ecx();
    if (this.Cau.BZY.isEmpty())
    {
      AppMethodBeat.o(119476);
      return localObject2;
    }
    if (this.BZl == null)
    {
      localObject1 = eeX();
      Object localObject3 = ((an)localObject2).eeO();
      localObject2 = new ArrayList(((Collection)localObject3).size());
      localObject3 = ((Collection)localObject3).iterator();
      while (((Iterator)localObject3).hasNext()) {
        ((Collection)localObject2).add(((au)localObject1).c((a.j.b.a.c.l.w)((Iterator)localObject3).next(), ba.CBX));
      }
      this.BZl = new a.j.b.a.c.l.e(this, this.Caw, (Collection)localObject2, a.j.b.a.c.k.b.CAv);
    }
    Object localObject1 = this.BZl;
    AppMethodBeat.o(119476);
    return localObject1;
  }
  
  public final h ecy()
  {
    AppMethodBeat.i(119478);
    Object localObject = this.Cat.ecy();
    if (this.Cau.BZY.isEmpty())
    {
      AppMethodBeat.o(119478);
      return localObject;
    }
    localObject = new a.j.b.a.c.i.e.l((h)localObject, eeX());
    AppMethodBeat.o(119478);
    return localObject;
  }
  
  public final a.j.b.a.c.b.e ecz()
  {
    AppMethodBeat.i(119487);
    a.j.b.a.c.b.e locale = this.Cat.ecz();
    AppMethodBeat.o(119487);
    return locale;
  }
  
  public final ad edE()
  {
    AppMethodBeat.i(119480);
    Object localObject = av.gh(ecx().getParameters());
    localObject = x.a(ecM(), this, (List)localObject);
    AppMethodBeat.o(119480);
    return localObject;
  }
  
  public final a.j.b.a.c.f.f edF()
  {
    AppMethodBeat.i(119484);
    a.j.b.a.c.f.f localf = this.Cat.edF();
    AppMethodBeat.o(119484);
    return localf;
  }
  
  public final h edJ()
  {
    AppMethodBeat.i(119499);
    h localh = this.Cat.edJ();
    AppMethodBeat.o(119499);
    return localh;
  }
  
  public final ak edK()
  {
    AppMethodBeat.i(119481);
    UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException();
    AppMethodBeat.o(119481);
    throw localUnsupportedOperationException;
  }
  
  public final a.j.b.a.c.b.e edL()
  {
    AppMethodBeat.i(119485);
    a.j.b.a.c.b.e locale = this.Cat.edL();
    AppMethodBeat.o(119485);
    return locale;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     a.j.b.a.c.b.c.s
 * JD-Core Version:    0.7.0.1
 */