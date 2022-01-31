package a.j.b.a.c.l;

import a.j.b.a.c.a.g.a;
import a.j.b.a.c.b.a.k;
import a.j.b.a.c.l.c.a;
import a.j.b.a.c.l.d.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public class au
{
  public static final au CBL;
  public final as BZY;
  
  static
  {
    AppMethodBeat.i(122680);
    if (!au.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      CBL = d(as.CBJ);
      AppMethodBeat.o(122680);
      return;
    }
  }
  
  private au(as paramas)
  {
    this.BZY = paramas;
  }
  
  private ap a(ap paramap, int paramInt)
  {
    AppMethodBeat.i(122672);
    a(paramInt, paramap, this.BZY);
    if (paramap.eoN())
    {
      AppMethodBeat.o(122672);
      return paramap;
    }
    Object localObject3 = paramap.eer();
    Object localObject1;
    if ((localObject3 instanceof aw))
    {
      localObject1 = ((aw)localObject3).eoI();
      localObject2 = ((aw)localObject3).eoJ();
      localObject1 = a(new ar(paramap.eoO(), (w)localObject1), paramInt + 1);
      paramap = c((w)localObject2, paramap.eoO());
      paramap = ax.b(((ap)localObject1).eer().eoL(), paramap);
      paramap = new ar(((ap)localObject1).eoO(), paramap);
      AppMethodBeat.o(122672);
      return paramap;
    }
    if ((n.ag((w)localObject3)) || ((((w)localObject3).eoL() instanceof ac)))
    {
      AppMethodBeat.o(122672);
      return paramap;
    }
    ap localap = this.BZY.O((w)localObject3);
    Object localObject2 = paramap.eoO();
    Object localObject4;
    if ((localap == null) && (t.ai((w)localObject3)) && (!am.aq((w)localObject3)))
    {
      localObject1 = t.aj((w)localObject3);
      localap = a(new ar((ba)localObject2, ((q)localObject1).CBm), paramInt + 1);
      localObject3 = a(new ar((ba)localObject2, ((q)localObject1).CBn), paramInt + 1);
      localObject4 = localap.eoO();
      if ((!$assertionsDisabled) && ((localObject4 != ((ap)localObject3).eoO()) || (localObject2 != ba.CBX)) && (localObject2 != localObject4))
      {
        paramap = new AssertionError("Unexpected substituted projection kind: " + localObject4 + "; original: " + localObject2);
        AppMethodBeat.o(122672);
        throw paramap;
      }
      if ((localap.eer() == ((q)localObject1).CBm) && (((ap)localObject3).eer() == ((q)localObject1).CBn))
      {
        AppMethodBeat.o(122672);
        return paramap;
      }
      paramap = new ar((ba)localObject4, x.a(at.av(localap.eer()), at.av(((ap)localObject3).eer())));
      AppMethodBeat.o(122672);
      return paramap;
    }
    if ((a.j.b.a.c.a.g.y((w)localObject3)) || (y.an((w)localObject3)))
    {
      AppMethodBeat.o(122672);
      return paramap;
    }
    if (localap != null)
    {
      localObject4 = b((ba)localObject2, localap.eoO());
      if (!a.j.b.a.c.i.a.a.c.ae((w)localObject3)) {}
      switch (au.2.CBM[localObject4.ordinal()])
      {
      default: 
        paramap = am.ar((w)localObject3);
        if (localap.eoN())
        {
          AppMethodBeat.o(122672);
          return localap;
        }
        break;
      case 1: 
        paramap = new au.a("Out-projection in in-position");
        AppMethodBeat.o(122672);
        throw paramap;
      case 2: 
        paramap = new ar(ba.CBZ, ((w)localObject3).enU().eec().ecm());
        AppMethodBeat.o(122672);
        return paramap;
      }
      if (paramap != null)
      {
        paramap = paramap.R(localap.eer());
        localObject1 = paramap;
        if (!((w)localObject3).ecM().isEmpty())
        {
          localObject1 = j(this.BZY.h(((w)localObject3).ecM()));
          localObject1 = a.a(paramap, new k(new a.j.b.a.c.b.a.g[] { paramap.ecM(), localObject1 }));
        }
        if (localObject4 != au.b.CBN) {
          break label701;
        }
      }
      label701:
      for (paramap = a((ba)localObject2, localap.eoO());; paramap = (ap)localObject2)
      {
        paramap = new ar(paramap, (w)localObject1);
        AppMethodBeat.o(122672);
        return paramap;
        paramap = av.b(localap.eer(), ((w)localObject3).egH());
        break;
      }
    }
    paramap = b(paramap, paramInt);
    AppMethodBeat.o(122672);
    return paramap;
  }
  
  public static ba a(ba paramba, ap paramap)
  {
    AppMethodBeat.i(122676);
    if (paramap.eoN())
    {
      paramba = ba.CBZ;
      AppMethodBeat.o(122676);
      return paramba;
    }
    paramba = a(paramba, paramap.eoO());
    AppMethodBeat.o(122676);
    return paramba;
  }
  
  private static ba a(ba paramba1, ba paramba2)
  {
    AppMethodBeat.i(122677);
    if (paramba1 == ba.CBX)
    {
      AppMethodBeat.o(122677);
      return paramba2;
    }
    if (paramba2 == ba.CBX)
    {
      AppMethodBeat.o(122677);
      return paramba1;
    }
    if (paramba1 == paramba2)
    {
      AppMethodBeat.o(122677);
      return paramba2;
    }
    paramba1 = new AssertionError("Variance conflict: type parameter variance '" + paramba1 + "' and projection kind '" + paramba2 + "' cannot be combined");
    AppMethodBeat.o(122677);
    throw paramba1;
  }
  
  private static void a(int paramInt, ap paramap, as paramas)
  {
    AppMethodBeat.i(122678);
    if (paramInt > 100)
    {
      paramap = new IllegalStateException("Recursion too deep. Most likely infinite loop while substituting " + dP(paramap) + "; substitution: " + dP(paramas));
      AppMethodBeat.o(122678);
      throw paramap;
    }
    AppMethodBeat.o(122678);
  }
  
  public static au aw(w paramw)
  {
    AppMethodBeat.i(122667);
    paramw = d(ao.a(paramw.enU(), paramw.enR()));
    AppMethodBeat.o(122667);
    return paramw;
  }
  
  private ap b(ap paramap, int paramInt)
  {
    AppMethodBeat.i(122674);
    Object localObject1 = paramap.eer();
    ba localba = paramap.eoO();
    if ((((w)localObject1).enU().ecR() instanceof a.j.b.a.c.b.ar))
    {
      AppMethodBeat.o(122674);
      return paramap;
    }
    paramap = null;
    Object localObject2 = ag.ao((w)localObject1);
    if (localObject2 != null) {
      paramap = c((w)localObject2, ba.CBX);
    }
    localObject2 = at.a((w)localObject1, b(((w)localObject1).enU().getParameters(), ((w)localObject1).enR(), paramInt), this.BZY.h(((w)localObject1).ecM()));
    localObject1 = localObject2;
    if ((localObject2 instanceof ad))
    {
      localObject1 = localObject2;
      if ((paramap instanceof ad)) {
        localObject1 = ag.b((ad)localObject2, (ad)paramap);
      }
    }
    paramap = new ar(localba, (w)localObject1);
    AppMethodBeat.o(122674);
    return paramap;
  }
  
  private static au.b b(ba paramba1, ba paramba2)
  {
    if ((paramba1 == ba.CBY) && (paramba2 == ba.CBZ)) {
      return au.b.CBP;
    }
    if ((paramba1 == ba.CBZ) && (paramba2 == ba.CBY)) {
      return au.b.CBO;
    }
    return au.b.CBN;
  }
  
  public static au b(as paramas1, as paramas2)
  {
    AppMethodBeat.i(122666);
    paramas1 = d(l.a(paramas1, paramas2));
    AppMethodBeat.o(122666);
    return paramas1;
  }
  
  private List<ap> b(List<a.j.b.a.c.b.ar> paramList, List<ap> paramList1, int paramInt)
  {
    AppMethodBeat.i(122675);
    ArrayList localArrayList = new ArrayList(paramList.size());
    int j = 0;
    int i = 0;
    a.j.b.a.c.b.ar localar;
    Object localObject;
    if (j < paramList.size())
    {
      localar = (a.j.b.a.c.b.ar)paramList.get(j);
      ap localap = (ap)paramList1.get(j);
      localObject = a(localap, paramInt + 1);
      switch (au.2.CBM[b(localar.edG(), localObject.eoO()).ordinal()])
      {
      default: 
        label124:
        if (localObject != localap) {
          i = 1;
        }
        break;
      }
    }
    for (;;)
    {
      localArrayList.add(localObject);
      j += 1;
      break;
      if ((localar.edG() == ba.CBX) || (((ap)localObject).eoN())) {
        break label124;
      }
      localObject = new ar(ba.CBX, ((ap)localObject).eer());
      break label124;
      localObject = av.e(localar);
      break label124;
      if (i == 0)
      {
        AppMethodBeat.o(122675);
        return paramList1;
      }
      AppMethodBeat.o(122675);
      return localArrayList;
    }
  }
  
  private ap c(ap paramap)
  {
    AppMethodBeat.i(122670);
    paramap = d(paramap);
    if ((!this.BZY.eoG()) && (!this.BZY.enV()))
    {
      AppMethodBeat.o(122670);
      return paramap;
    }
    paramap = b.a(paramap, this.BZY.enV());
    AppMethodBeat.o(122670);
    return paramap;
  }
  
  public static au d(as paramas)
  {
    AppMethodBeat.i(122665);
    paramas = new au(paramas);
    AppMethodBeat.o(122665);
    return paramas;
  }
  
  private static String dP(Object paramObject)
  {
    AppMethodBeat.i(122679);
    try
    {
      paramObject = paramObject.toString();
      AppMethodBeat.o(122679);
      return paramObject;
    }
    catch (Throwable paramObject)
    {
      if (a.j.b.a.c.n.c.r(paramObject))
      {
        paramObject = (RuntimeException)paramObject;
        AppMethodBeat.o(122679);
        throw paramObject;
      }
      paramObject = "[Exception while computing toString(): " + paramObject + "]";
      AppMethodBeat.o(122679);
    }
    return paramObject;
  }
  
  private static a.j.b.a.c.b.a.g j(a.j.b.a.c.b.a.g paramg)
  {
    AppMethodBeat.i(122673);
    if (!paramg.j(a.j.b.a.c.a.g.BRU.BSK))
    {
      AppMethodBeat.o(122673);
      return paramg;
    }
    paramg = new a.j.b.a.c.b.a.l(paramg, new au.1());
    AppMethodBeat.o(122673);
    return paramg;
  }
  
  public final w b(w paramw, ba paramba)
  {
    AppMethodBeat.i(122668);
    if (this.BZY.isEmpty())
    {
      AppMethodBeat.o(122668);
      return paramw;
    }
    try
    {
      paramw = a(new ar(paramba, paramw), 0).eer();
      AppMethodBeat.o(122668);
      return paramw;
    }
    catch (au.a paramw)
    {
      paramw = p.azj(paramw.getMessage());
      AppMethodBeat.o(122668);
    }
    return paramw;
  }
  
  public final w c(w paramw, ba paramba)
  {
    AppMethodBeat.i(122669);
    paramw = c(new ar(paramba, this.BZY.a(paramw, paramba)));
    if (paramw == null)
    {
      AppMethodBeat.o(122669);
      return null;
    }
    paramw = paramw.eer();
    AppMethodBeat.o(122669);
    return paramw;
  }
  
  public final ap d(ap paramap)
  {
    AppMethodBeat.i(122671);
    if (this.BZY.isEmpty())
    {
      AppMethodBeat.o(122671);
      return paramap;
    }
    try
    {
      paramap = a(paramap, 0);
      AppMethodBeat.o(122671);
      return paramap;
    }
    catch (au.a paramap)
    {
      AppMethodBeat.o(122671);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     a.j.b.a.c.l.au
 * JD-Core Version:    0.7.0.1
 */