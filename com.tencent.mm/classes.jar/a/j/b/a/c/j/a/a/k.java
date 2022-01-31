package a.j.b.a.c.j.a.a;

import a.f.b.j;
import a.j.b.a.c.b.a.g;
import a.j.b.a.c.b.am;
import a.j.b.a.c.b.ar;
import a.j.b.a.c.b.as;
import a.j.b.a.c.b.az;
import a.j.b.a.c.b.c.af;
import a.j.b.a.c.b.c.d;
import a.j.b.a.c.b.l;
import a.j.b.a.c.e.a.ab;
import a.j.b.a.c.e.a.c;
import a.j.b.a.c.i.e.h.b;
import a.j.b.a.c.l.ad;
import a.j.b.a.c.l.an;
import a.j.b.a.c.l.av;
import a.j.b.a.c.l.w;
import a.j.b.a.c.l.y;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.List;

public final class k
  extends d
  implements f
{
  private final c BOc;
  private final a.j.b.a.c.e.a.h BOd;
  private final a.j.b.a.c.k.i BRT;
  private Collection<? extends af> CAn;
  private ad CAo;
  private ad CAp;
  private ad CAq;
  private final a.ab CAr;
  private List<? extends ar> Caw;
  private final a.j.b.a.c.e.a.i CyS;
  private final e CyT;
  private f.a CzD;
  
  public k(a.j.b.a.c.k.i parami, l paraml, g paramg, a.j.b.a.c.f.f paramf, az paramaz, a.ab paramab, c paramc, a.j.b.a.c.e.a.h paramh, a.j.b.a.c.e.a.i parami1, e parame)
  {
    super(paraml, paramg, paramf, localam, paramaz);
    AppMethodBeat.i(122426);
    this.BRT = parami;
    this.CAr = paramab;
    this.BOc = paramc;
    this.BOd = paramh;
    this.CyS = parami1;
    this.CyT = parame;
    this.CzD = f.a.CzX;
    AppMethodBeat.o(122426);
  }
  
  public final void a(List<? extends ar> paramList, ad paramad1, ad paramad2, f.a parama)
  {
    AppMethodBeat.i(122421);
    j.q(paramList, "declaredTypeParameters");
    j.q(paramad1, "underlyingType");
    j.q(paramad2, "expandedType");
    j.q(parama, "isExperimentalCoroutineInReleaseEnvironment");
    j.q(paramList, "declaredTypeParameters");
    this.BYT = paramList;
    this.CAo = paramad1;
    this.CAp = paramad2;
    this.Caw = as.a(this);
    paramad2 = (a.j.b.a.c.b.h)this;
    paramList = eeq();
    if (paramList != null)
    {
      paramad1 = paramList.ecy();
      paramList = paramad1;
      if (paramad1 != null) {}
    }
    else
    {
      paramList = (a.j.b.a.c.i.e.h)h.b.CxW;
    }
    paramList = av.a(paramad2, paramList);
    j.p(paramList, "TypeUtils.makeUnsubstitu…ope ?: MemberScope.Empty)");
    this.CAq = paramList;
    this.CAn = eeK();
    this.CzD = parama;
    AppMethodBeat.o(122421);
  }
  
  public final ad edE()
  {
    AppMethodBeat.i(122423);
    ad localad = this.CAq;
    if (localad == null) {
      j.ays("defaultTypeImpl");
    }
    AppMethodBeat.o(122423);
    return localad;
  }
  
  public final a.j.b.a.c.k.i eeJ()
  {
    return this.BRT;
  }
  
  public final List<ar> eeN()
  {
    AppMethodBeat.i(122425);
    List localList = this.Caw;
    if (localList == null) {
      j.ays("typeConstructorParameters");
    }
    AppMethodBeat.o(122425);
    return localList;
  }
  
  public final ad eeo()
  {
    AppMethodBeat.i(122419);
    ad localad = this.CAo;
    if (localad == null) {
      j.ays("underlyingType");
    }
    AppMethodBeat.o(122419);
    return localad;
  }
  
  public final ad eep()
  {
    AppMethodBeat.i(122420);
    ad localad = this.CAp;
    if (localad == null) {
      j.ays("expandedType");
    }
    AppMethodBeat.o(122420);
    return localad;
  }
  
  public final a.j.b.a.c.b.e eeq()
  {
    AppMethodBeat.i(122422);
    if (y.an((w)eep()))
    {
      AppMethodBeat.o(122422);
      return null;
    }
    a.j.b.a.c.b.h localh = eep().enU().ecR();
    Object localObject = localh;
    if (!(localh instanceof a.j.b.a.c.b.e)) {
      localObject = null;
    }
    localObject = (a.j.b.a.c.b.e)localObject;
    AppMethodBeat.o(122422);
    return localObject;
  }
  
  public final c eot()
  {
    return this.BOc;
  }
  
  public final a.j.b.a.c.e.a.h eou()
  {
    return this.BOd;
  }
  
  public final e eov()
  {
    return this.CyT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     a.j.b.a.c.j.a.a.k
 * JD-Core Version:    0.7.0.1
 */