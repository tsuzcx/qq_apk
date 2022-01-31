package a.j.b.a.c.d.a.b;

import a.j.b.a.c.b.a.a;
import a.j.b.a.c.b.a.g.a;
import a.j.b.a.c.b.ah;
import a.j.b.a.c.b.aj;
import a.j.b.a.c.b.am;
import a.j.b.a.c.b.au;
import a.j.b.a.c.b.az;
import a.j.b.a.c.b.b.a;
import a.j.b.a.c.b.c.aa;
import a.j.b.a.c.b.c.ab;
import a.j.b.a.c.b.c.ak;
import a.j.b.a.c.b.c.y;
import a.j.b.a.c.b.c.z;
import a.j.b.a.c.b.l;
import a.j.b.a.c.d.a.f.s;
import a.j.b.a.c.i.c;
import a.o;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public final class f
  extends z
  implements b
{
  private final boolean Cex;
  private final o<a.a<?>, ?> Cey;
  
  private f(l paraml, a.j.b.a.c.b.a.g paramg, a.j.b.a.c.b.w paramw, az paramaz, boolean paramBoolean1, a.j.b.a.c.f.f paramf, am paramam, ah paramah, b.a parama, boolean paramBoolean2, o<a.a<?>, ?> paramo)
  {
    super(paraml, paramah, paramg, paramw, paramaz, paramBoolean1, paramf, parama, paramam, false, false, false, false, false, false);
    this.Cex = paramBoolean2;
    this.Cey = paramo;
  }
  
  public static f a(l paraml, a.j.b.a.c.b.a.g paramg, a.j.b.a.c.b.w paramw, az paramaz, boolean paramBoolean1, a.j.b.a.c.f.f paramf, am paramam, boolean paramBoolean2)
  {
    AppMethodBeat.i(119806);
    paraml = new f(paraml, paramg, paramw, paramaz, paramBoolean1, paramf, paramam, null, b.a.BVX, paramBoolean2, null);
    AppMethodBeat.o(119806);
    return paraml;
  }
  
  public final z a(l paraml, a.j.b.a.c.b.w paramw, az paramaz, ah paramah, b.a parama, a.j.b.a.c.f.f paramf)
  {
    AppMethodBeat.i(119807);
    paraml = new f(paraml, ecM(), paramw, paramaz, this.Cbq, paramf, am.BWF, paramah, parama, this.Cex, this.Cey);
    AppMethodBeat.o(119807);
    return paraml;
  }
  
  public final b a(a.j.b.a.c.l.w paramw1, List<j> paramList, a.j.b.a.c.l.w paramw2, o<a.a<?>, ?> paramo)
  {
    AppMethodBeat.i(119808);
    Object localObject1 = ecv();
    Object localObject2 = ecM();
    a.j.b.a.c.b.w localw = this.BZj;
    az localaz = this.BZE;
    boolean bool = this.Cbq;
    a.j.b.a.c.f.f localf = this.BYN;
    am localam = ecN();
    if (eek() == this)
    {
      paramList = null;
      localObject1 = new f((l)localObject1, (a.j.b.a.c.b.a.g)localObject2, localw, localaz, bool, localf, localam, paramList, this.BZT, this.Cex, paramo);
      paramo = this.CaP;
      if (paramo == null) {
        break label381;
      }
      paramList = new aa((ah)localObject1, paramo.ecM(), paramo.BZj, paramo.BZE, paramo.isDefault, paramo.BZi, paramo.BZH, this.BZT, paramo, paramo.ecN());
      paramList.BZU = paramo.BZU;
      paramList.K(paramw2);
    }
    for (;;)
    {
      paramo = null;
      localObject2 = this.CaQ;
      if (localObject2 != null)
      {
        paramo = new ab((ah)localObject1, ((aj)localObject2).ecM(), ((aj)localObject2).ecC(), ((aj)localObject2).ecE(), ((aj)localObject2).isDefault(), ((aj)localObject2).ecL(), ((aj)localObject2).ecI(), this.BZT, (aj)localObject2, ((aj)localObject2).ecN());
        paramo.BZU = paramo.BZU;
        paramo.a((au)((aj)localObject2).edu().get(0));
      }
      ((f)localObject1).a(paramList, paramo, this.CaS, this.CaT);
      ((z)localObject1).CaR = this.CaR;
      if (this.Cbr != null) {
        ((f)localObject1).a(this.Cbr);
      }
      ((z)localObject1).CaK = edw();
      if (paramw1 == null) {}
      for (paramw1 = null;; paramw1 = c.a(this, paramw1, g.a.eeH()))
      {
        ((f)localObject1).a(paramw2, this.BWy, this.BZD, paramw1);
        AppMethodBeat.o(119808);
        return localObject1;
        paramList = eek();
        break;
        paramList = a.j.b.a.c.b.a.g.BXx;
      }
      label381:
      paramList = null;
    }
  }
  
  public final <V> V a(a.a<V> parama)
  {
    AppMethodBeat.i(119810);
    if ((this.Cey != null) && (((a.a)this.Cey.first).equals(parama)))
    {
      parama = this.Cey.second;
      AppMethodBeat.o(119810);
      return parama;
    }
    AppMethodBeat.o(119810);
    return null;
  }
  
  public final boolean edv()
  {
    return false;
  }
  
  public final boolean eeA()
  {
    AppMethodBeat.i(119809);
    a.j.b.a.c.l.w localw = eer();
    if ((this.Cex) && (a.j.b.a.c.b.j.H(localw)) && ((!s.U(localw)) || (a.j.b.a.c.a.g.E(localw))))
    {
      AppMethodBeat.o(119809);
      return true;
    }
    AppMethodBeat.o(119809);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     a.j.b.a.c.d.a.b.f
 * JD-Core Version:    0.7.0.1
 */