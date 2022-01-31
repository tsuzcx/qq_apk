package a.j.b.a.c.l.a;

import a.aa;
import a.j.b.a.c.b.ar;
import a.j.b.a.c.l.ad;
import a.j.b.a.c.l.ag;
import a.j.b.a.c.l.aj;
import a.j.b.a.c.l.an;
import a.j.b.a.c.l.ao;
import a.j.b.a.c.l.ao.a;
import a.j.b.a.c.l.ap;
import a.j.b.a.c.l.as;
import a.j.b.a.c.l.av;
import a.j.b.a.c.l.ax;
import a.j.b.a.c.l.az;
import a.j.b.a.c.l.ba;
import a.j.b.a.c.l.q;
import a.j.b.a.c.l.t;
import a.j.b.a.c.l.w;
import a.j.b.a.c.l.y;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class h
  implements c
{
  public static final h CCq;
  
  static
  {
    AppMethodBeat.i(122750);
    CCq = new h();
    AppMethodBeat.o(122750);
  }
  
  private static boolean B(a.j.b.a.c.b.e parame)
  {
    AppMethodBeat.i(122748);
    if ((a.j.b.a.c.b.x.p(parame)) && (parame.ecB() != a.j.b.a.c.b.f.BWi) && (parame.ecB() != a.j.b.a.c.b.f.BWj))
    {
      AppMethodBeat.o(122748);
      return true;
    }
    AppMethodBeat.o(122748);
    return false;
  }
  
  private final Boolean a(o paramo, ad paramad1, ad paramad2)
  {
    boolean bool = false;
    AppMethodBeat.i(122742);
    if ((y.an((w)paramad1)) || (y.an((w)paramad2)))
    {
      if (paramo.CCy)
      {
        paramo = Boolean.TRUE;
        AppMethodBeat.o(122742);
        return paramo;
      }
      if ((paramad1.egH()) && (!paramad2.egH()))
      {
        paramo = Boolean.FALSE;
        AppMethodBeat.o(122742);
        return paramo;
      }
      bool = m.CCs.c(paramad1.ss(false), paramad2.ss(false));
      AppMethodBeat.o(122742);
      return Boolean.valueOf(bool);
    }
    if (((paramad1 instanceof aj)) || ((paramad2 instanceof aj)))
    {
      paramo = Boolean.TRUE;
      AppMethodBeat.o(122742);
      return paramo;
    }
    Object localObject;
    if (((paramad2 instanceof e)) && (((e)paramad2).CCn != null)) {
      localObject = o.a(paramad1, (e)paramad2);
    }
    switch (i.bLo[localObject.ordinal()])
    {
    default: 
      an localan = paramad2.enU();
      localObject = localan;
      if (!(localan instanceof a.j.b.a.c.l.v)) {
        localObject = null;
      }
      localObject = (a.j.b.a.c.l.v)localObject;
      if (localObject == null) {
        break label429;
      }
      if (paramad2.egH()) {
        break;
      }
    }
    for (int i = 1;; i = 0)
    {
      if ((!aa.BMh) || (i != 0)) {
        break label330;
      }
      paramo = (Throwable)new AssertionError("Intersection type should not be marked nullable!: ".concat(String.valueOf(paramad2)));
      AppMethodBeat.o(122742);
      throw paramo;
      bool = b(paramo, (az)paramad1, ((e)paramad2).CCn);
      AppMethodBeat.o(122742);
      return Boolean.valueOf(bool);
      if (!b(paramo, (az)paramad1, ((e)paramad2).CCn)) {
        break;
      }
      paramo = Boolean.TRUE;
      AppMethodBeat.o(122742);
      return paramo;
    }
    label330:
    paramad2 = ((a.j.b.a.c.l.v)localObject).CBw;
    a.f.b.j.p(paramad2, "it.supertypes");
    paramad2 = (Iterable)paramad2;
    if ((!(paramad2 instanceof Collection)) || (!((Collection)paramad2).isEmpty()))
    {
      paramad2 = paramad2.iterator();
      do
      {
        if (!paramad2.hasNext()) {
          break;
        }
        localObject = (w)paramad2.next();
      } while (CCq.b(paramo, (az)paramad1, ((w)localObject).eoL()));
    }
    for (;;)
    {
      AppMethodBeat.o(122742);
      return Boolean.valueOf(bool);
      bool = true;
    }
    label429:
    AppMethodBeat.o(122742);
    return null;
  }
  
  private static List<ad> a(o paramo, ad paramad, an paraman)
  {
    AppMethodBeat.i(122745);
    paramo = c(paramo, paramad, paraman);
    if (paramo.size() >= 2)
    {
      paraman = (Iterable)paramo;
      paramad = (Collection)new ArrayList();
      paraman = paraman.iterator();
      label149:
      label174:
      label179:
      while (paraman.hasNext())
      {
        Object localObject1 = paraman.next();
        Object localObject2 = (Iterable)((ad)localObject1).enR();
        if ((!(localObject2 instanceof Collection)) || (!((Collection)localObject2).isEmpty()))
        {
          localObject2 = ((Iterable)localObject2).iterator();
          label105:
          if (((Iterator)localObject2).hasNext())
          {
            w localw = ((ap)((Iterator)localObject2).next()).eer();
            a.f.b.j.p(localw, "it.type");
            if (!t.ai(localw))
            {
              i = 1;
              if (i != 0) {
                break label174;
              }
            }
          }
        }
        for (i = 0;; i = 1)
        {
          if (i == 0) {
            break label179;
          }
          paramad.add(localObject1);
          break;
          i = 0;
          break label149;
          break label105;
        }
      }
      paramad = (List)paramad;
      if (!((Collection)paramad).isEmpty()) {}
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(122745);
        return paramad;
      }
    }
    AppMethodBeat.o(122745);
    return paramo;
  }
  
  private static boolean a(o paramo, ad paramad)
  {
    AppMethodBeat.i(122743);
    if (a.j.b.a.c.a.g.z((w)paramad))
    {
      AppMethodBeat.o(122743);
      return true;
    }
    paramo.initialize();
    ArrayDeque localArrayDeque = paramo.CCw;
    if (localArrayDeque == null) {
      a.f.b.j.ebi();
    }
    Set localSet = paramo.CCx;
    if (localSet == null) {
      a.f.b.j.ebi();
    }
    localArrayDeque.push(paramad);
    label308:
    label311:
    label322:
    for (;;)
    {
      if (!((Collection)localArrayDeque).isEmpty()) {}
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label324;
        }
        if (localSet.size() <= 1000) {
          break;
        }
        paramo = (Throwable)new IllegalStateException(("Too many supertypes for type: " + paramad + ". Supertypes = " + a.a.j.a((Iterable)localSet, null, null, null, 0, null, null, 63)).toString());
        AppMethodBeat.o(122743);
        throw paramo;
      }
      Object localObject1 = (ad)localArrayDeque.pop();
      a.f.b.j.p(localObject1, "current");
      if (localSet.add(localObject1))
      {
        o.c localc;
        if (j.c((ad)localObject1))
        {
          localc = (o.c)o.c.c.CCK;
          label205:
          if (!(a.f.b.j.e(localc, o.c.c.CCK) ^ true)) {
            break label308;
          }
          label217:
          if (localc == null) {
            break label311;
          }
          localObject1 = ((ad)localObject1).enU().eeO().iterator();
        }
        for (;;)
        {
          if (!((Iterator)localObject1).hasNext()) {
            break label322;
          }
          Object localObject2 = (w)((Iterator)localObject1).next();
          a.f.b.j.p(localObject2, "supertype");
          localObject2 = localc.aJ((w)localObject2);
          if (a.j.b.a.c.a.g.z((w)localObject2))
          {
            paramo.clear();
            AppMethodBeat.o(122743);
            return true;
            localc = (o.c)o.c.a.CCJ;
            break label205;
            localc = null;
            break label217;
            break;
          }
          localArrayDeque.add(localObject2);
        }
      }
    }
    label324:
    paramo.clear();
    AppMethodBeat.o(122743);
    return false;
  }
  
  private boolean a(o paramo, az paramaz1, az paramaz2)
  {
    AppMethodBeat.i(122736);
    a.f.b.j.q(paramo, "receiver$0");
    a.f.b.j.q(paramaz1, "a");
    a.f.b.j.q(paramaz2, "b");
    if (paramaz1 == paramaz2)
    {
      AppMethodBeat.o(122736);
      return true;
    }
    if ((aI((w)paramaz1)) && (aI((w)paramaz2)))
    {
      if (!o.c(paramaz1.enU(), paramaz2.enU()))
      {
        AppMethodBeat.o(122736);
        return false;
      }
      if (paramaz1.enR().isEmpty())
      {
        if ((aH((w)paramaz1)) || (aH((w)paramaz2)))
        {
          AppMethodBeat.o(122736);
          return true;
        }
        if (paramaz1.egH() == paramaz2.egH())
        {
          AppMethodBeat.o(122736);
          return true;
        }
        AppMethodBeat.o(122736);
        return false;
      }
    }
    if ((b(paramo, paramaz1, paramaz2)) && (b(paramo, paramaz2, paramaz1)))
    {
      AppMethodBeat.o(122736);
      return true;
    }
    AppMethodBeat.o(122736);
    return false;
  }
  
  private static boolean a(o paramo, List<? extends ap> paramList, ad paramad)
  {
    AppMethodBeat.i(122749);
    if (paramList == paramad.enR())
    {
      AppMethodBeat.o(122749);
      return true;
    }
    List localList = paramad.enU().getParameters();
    a.f.b.j.p(localList, "superType.constructor.parameters");
    int k = ((Collection)localList).size();
    int i = 0;
    while (i < k)
    {
      Object localObject2 = (ap)paramad.enR().get(i);
      if (!((ap)localObject2).eoN())
      {
        az localaz1 = ((ap)localObject2).eer().eoL();
        Object localObject1 = (ap)paramList.get(i);
        if (((ap)localObject1).eoO() == ba.CBX) {}
        for (int j = 1; (aa.BMh) && (j == 0); j = 0)
        {
          paramo = (Throwable)new AssertionError("Incorrect sub argument: ".concat(String.valueOf(localObject1)));
          AppMethodBeat.o(122749);
          throw paramo;
        }
        az localaz2 = ((ap)localObject1).eer().eoL();
        localObject1 = localList.get(i);
        a.f.b.j.p(localObject1, "parameters[index]");
        localObject1 = ((ar)localObject1).edG();
        a.f.b.j.p(localObject1, "parameters[index].variance");
        localObject2 = ((ap)localObject2).eoO();
        a.f.b.j.p(localObject2, "superProjection.projectionKind");
        a.f.b.j.q(localObject1, "declared");
        a.f.b.j.q(localObject2, "useSite");
        if (localObject1 == ba.CBX) {}
        label268:
        boolean bool;
        for (localObject1 = localObject2; localObject1 == null; localObject1 = null)
        {
          bool = paramo.CCy;
          AppMethodBeat.o(122749);
          return bool;
          if ((localObject2 == ba.CBX) || (localObject1 == localObject2)) {
            break label268;
          }
        }
        if (paramo.CCu > 100)
        {
          paramo = (Throwable)new IllegalStateException("Arguments depth is too high. Some related argument: ".concat(String.valueOf(localaz2)).toString());
          AppMethodBeat.o(122749);
          throw paramo;
        }
        paramo.CCu += 1;
        switch (i.pTs[localObject1.ordinal()])
        {
        default: 
          paramo = new a.m();
          AppMethodBeat.o(122749);
          throw paramo;
        case 1: 
          bool = CCq.a(paramo, localaz2, localaz1);
        }
        for (;;)
        {
          paramo.CCu -= 1;
          if (bool) {
            break;
          }
          AppMethodBeat.o(122749);
          return false;
          bool = CCq.b(paramo, localaz2, localaz1);
          continue;
          bool = CCq.b(paramo, localaz1, localaz2);
        }
      }
      i += 1;
    }
    AppMethodBeat.o(122749);
    return true;
  }
  
  private static boolean aH(w paramw)
  {
    AppMethodBeat.i(122737);
    if (t.ak(paramw).egH() != t.al(paramw).egH())
    {
      AppMethodBeat.o(122737);
      return true;
    }
    AppMethodBeat.o(122737);
    return false;
  }
  
  private static boolean aI(w paramw)
  {
    AppMethodBeat.i(122738);
    if ((paramw.enU().ecT()) && (!a.j.b.a.c.l.n.ag(paramw)) && (!ag.ap(paramw)) && (a.f.b.j.e(t.ak(paramw).enU(), t.al(paramw).enU())))
    {
      AppMethodBeat.o(122738);
      return true;
    }
    AppMethodBeat.o(122738);
    return false;
  }
  
  private static ad b(ad paramad)
  {
    Object localObject3 = null;
    AppMethodBeat.i(122740);
    a.f.b.j.q(paramad, "type");
    an localan = paramad.enU();
    Object localObject2;
    Object localObject1;
    if ((localan instanceof a.j.b.a.c.i.a.a.b))
    {
      localObject2 = ((a.j.b.a.c.i.a.a.b)localan).Cwv;
      int i;
      if (((ap)localObject2).eoO() == ba.CBY)
      {
        i = 1;
        if (i == 0) {
          break label188;
        }
      }
      Collection localCollection;
      for (;;)
      {
        localObject1 = localObject3;
        if (localObject2 != null)
        {
          localObject2 = ((ap)localObject2).eer();
          localObject1 = localObject3;
          if (localObject2 != null) {
            localObject1 = ((w)localObject2).eoL();
          }
        }
        if (((a.j.b.a.c.i.a.a.b)localan).Cwy != null) {
          break label211;
        }
        localObject2 = (a.j.b.a.c.i.a.a.b)localan;
        localObject3 = ((a.j.b.a.c.i.a.a.b)localan).Cwv;
        Object localObject4 = (Iterable)((a.j.b.a.c.i.a.a.b)localan).eeO();
        localCollection = (Collection)new ArrayList(a.a.j.d((Iterable)localObject4));
        localObject4 = ((Iterable)localObject4).iterator();
        while (((Iterator)localObject4).hasNext()) {
          localCollection.add(((w)((Iterator)localObject4).next()).eoL());
        }
        i = 0;
        break;
        label188:
        localObject2 = null;
      }
      ((a.j.b.a.c.i.a.a.b)localObject2).Cwy = new f((ap)localObject3, (List)localCollection);
      label211:
      localObject2 = a.CCe;
      localObject3 = ((a.j.b.a.c.i.a.a.b)localan).Cwy;
      if (localObject3 == null) {
        a.f.b.j.ebi();
      }
      paramad = (ad)new e((a)localObject2, (f)localObject3, (az)localObject1, paramad.ecM(), paramad.egH());
      AppMethodBeat.o(122740);
      return paramad;
    }
    if ((localan instanceof a.j.b.a.c.i.b.n))
    {
      localObject2 = (Iterable)((a.j.b.a.c.i.b.n)localan).CwJ;
      localObject1 = (Collection)new ArrayList(a.a.j.d((Iterable)localObject2));
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((Collection)localObject1).add(av.a((w)((Iterator)localObject2).next(), paramad.egH()));
      }
      localObject1 = new a.j.b.a.c.l.v((Collection)localObject1);
      paramad = a.j.b.a.c.l.x.a(paramad.ecM(), (an)localObject1, (List)a.a.v.BMx, false, paramad.ecq());
      AppMethodBeat.o(122740);
      return paramad;
    }
    if (((localan instanceof a.j.b.a.c.l.v)) && (paramad.egH()))
    {
      localObject1 = ((a.j.b.a.c.l.v)localan).CBw;
      a.f.b.j.p(localObject1, "constructor.supertypes");
      localObject2 = (Iterable)localObject1;
      localObject1 = (Collection)new ArrayList(a.a.j.d((Iterable)localObject2));
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (w)((Iterator)localObject2).next();
        a.f.b.j.p(localObject3, "it");
        ((Collection)localObject1).add(a.j.b.a.c.l.c.a.az((w)localObject3));
      }
      localObject1 = new a.j.b.a.c.l.v((Collection)localObject1);
      paramad = paramad.ecM();
      localObject2 = (an)localObject1;
      localObject3 = (List)a.a.v.BMx;
      localObject1 = ((a.j.b.a.c.l.v)localObject1).eoK();
      a.f.b.j.p(localObject1, "newConstructor.createScopeForKotlinType()");
      paramad = a.j.b.a.c.l.x.a(paramad, (an)localObject2, (List)localObject3, false, (a.j.b.a.c.i.e.h)localObject1);
      AppMethodBeat.o(122740);
      return paramad;
    }
    AppMethodBeat.o(122740);
    return paramad;
  }
  
  private static List<ad> b(o paramo, ad paramad, an paraman)
  {
    AppMethodBeat.i(122746);
    a.f.b.j.q(paramo, "receiver$0");
    a.f.b.j.q(paramad, "baseType");
    a.f.b.j.q(paraman, "constructor");
    if (j.c(paramad))
    {
      paramo = a(paramo, paramad, paraman);
      AppMethodBeat.o(122746);
      return paramo;
    }
    if (!(paraman.ecR() instanceof a.j.b.a.c.b.e))
    {
      paramo = c(paramo, paramad, paraman);
      AppMethodBeat.o(122746);
      return paramo;
    }
    Object localObject2 = new a.j.b.a.c.n.h();
    paramo.initialize();
    ArrayDeque localArrayDeque = paramo.CCw;
    if (localArrayDeque == null) {
      a.f.b.j.ebi();
    }
    Set localSet = paramo.CCx;
    if (localSet == null) {
      a.f.b.j.ebi();
    }
    localArrayDeque.push(paramad);
    label278:
    label370:
    label374:
    for (;;)
    {
      if (!((Collection)localArrayDeque).isEmpty()) {}
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label376;
        }
        if (localSet.size() <= 1000) {
          break;
        }
        paramo = (Throwable)new IllegalStateException(("Too many supertypes for type: " + paramad + ". Supertypes = " + a.a.j.a((Iterable)localSet, null, null, null, 0, null, null, 63)).toString());
        AppMethodBeat.o(122746);
        throw paramo;
      }
      Object localObject3 = (ad)localArrayDeque.pop();
      a.f.b.j.p(localObject3, "current");
      if (localSet.add(localObject3))
      {
        if (j.c((ad)localObject3))
        {
          ((a.j.b.a.c.n.h)localObject2).add(localObject3);
          localObject1 = (o.c)o.c.c.CCK;
          if (!(a.f.b.j.e(localObject1, o.c.c.CCK) ^ true)) {
            break label370;
          }
        }
        for (;;)
        {
          if (localObject1 == null) {
            break label374;
          }
          localObject3 = ((ad)localObject3).enU().eeO().iterator();
          while (((Iterator)localObject3).hasNext())
          {
            w localw = (w)((Iterator)localObject3).next();
            a.f.b.j.p(localw, "supertype");
            localArrayDeque.add(((o.c)localObject1).aJ(localw));
          }
          break;
          localObject1 = (o.c)o.c.a.CCJ;
          break label278;
          localObject1 = null;
        }
      }
    }
    label376:
    paramo.clear();
    Object localObject1 = (Iterable)localObject2;
    paramad = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (ad)((Iterator)localObject1).next();
      a.f.b.j.p(localObject2, "it");
      a.a.j.a(paramad, (Iterable)a(paramo, (ad)localObject2, paraman));
    }
    paramo = (List)paramad;
    AppMethodBeat.o(122746);
    return paramo;
  }
  
  private static boolean b(o paramo, ad paramad1, ad paramad2)
  {
    AppMethodBeat.i(122744);
    if ((j.d(paramad1)) || (j.e(paramad1)) || (paramo.e((az)paramad1))) {}
    for (int i = 1; (aa.BMh) && (i == 0); i = 0)
    {
      paramo = (Throwable)new AssertionError("Not singleClassifierType and not intersection subType: ".concat(String.valueOf(paramad1)));
      AppMethodBeat.o(122744);
      throw paramo;
    }
    if ((j.d(paramad2)) || (paramo.e((az)paramad2))) {}
    for (i = 1; (aa.BMh) && (i == 0); i = 0)
    {
      paramo = (Throwable)new AssertionError("Not singleClassifierType superType: ".concat(String.valueOf(paramad2)));
      AppMethodBeat.o(122744);
      throw paramo;
    }
    Object localObject1 = l.CCr;
    if (!l.c(paramo, paramad1, paramad2))
    {
      AppMethodBeat.o(122744);
      return false;
    }
    localObject1 = paramad2.enU();
    if ((a.f.b.j.e(paramad1.enU(), localObject1)) && (((an)localObject1).getParameters().isEmpty()))
    {
      AppMethodBeat.o(122744);
      return true;
    }
    if (a.j.b.a.c.l.c.a.A((w)paramad2))
    {
      AppMethodBeat.o(122744);
      return true;
    }
    List localList = b(paramo, paramad1, (an)localObject1);
    Object localObject2;
    Iterator localIterator1;
    switch (localList.size())
    {
    default: 
      localObject2 = o.b.CCH;
      switch (i.pRV[localObject2.ordinal()])
      {
      default: 
        localObject2 = o.b.CCH;
        localObject1 = ((an)localObject1).getParameters();
        a.f.b.j.p(localObject1, "superConstructor.parameters");
        localObject1 = (Iterable)localObject1;
        localObject2 = (Collection)new ArrayList(a.a.j.d((Iterable)localObject1));
        localIterator1 = ((Iterable)localObject1).iterator();
        i = 0;
      }
      break;
    }
    for (;;)
    {
      if (!localIterator1.hasNext()) {
        break label791;
      }
      localIterator1.next();
      if (i < 0) {
        a.a.j.eaS();
      }
      localObject1 = (Iterable)localList;
      Collection localCollection = (Collection)new ArrayList(a.a.j.d((Iterable)localObject1));
      Iterator localIterator2 = ((Iterable)localObject1).iterator();
      for (;;)
      {
        if (!localIterator2.hasNext()) {
          break label762;
        }
        ad localad = (ad)localIterator2.next();
        localObject1 = (ap)a.a.j.w(localad.enR(), i);
        int j;
        if (localObject1 != null)
        {
          if (((ap)localObject1).eoO() != ba.CBX) {
            break label737;
          }
          j = 1;
          label476:
          if (j == 0) {
            break label743;
          }
        }
        for (;;)
        {
          if (localObject1 != null)
          {
            localObject1 = ((ap)localObject1).eer();
            if (localObject1 != null)
            {
              localObject1 = ((w)localObject1).eoL();
              if (localObject1 != null) {
                break label749;
              }
            }
          }
          paramo = (Throwable)new IllegalStateException(("Incorrect type: " + localad + ", subType: " + paramad1 + ", superType: " + paramad2).toString());
          AppMethodBeat.o(122744);
          throw paramo;
          bool = a(paramo, paramad1);
          AppMethodBeat.o(122744);
          return bool;
          bool = a(paramo, ((ad)a.a.j.fQ(localList)).enR(), paramad2);
          AppMethodBeat.o(122744);
          return bool;
          AppMethodBeat.o(122744);
          return false;
          bool = a(paramo, ((ad)a.a.j.fQ(localList)).enR(), paramad2);
          AppMethodBeat.o(122744);
          return bool;
          localObject2 = (Iterable)localList;
          if ((!(localObject2 instanceof Collection)) || (!((Collection)localObject2).isEmpty()))
          {
            localObject2 = ((Iterable)localObject2).iterator();
            do
            {
              if (!((Iterator)localObject2).hasNext()) {
                break;
              }
            } while (!a(paramo, ((ad)((Iterator)localObject2).next()).enR(), paramad2));
          }
          for (i = 1; i != 0; i = 0)
          {
            AppMethodBeat.o(122744);
            return true;
          }
          break;
          label737:
          j = 0;
          break label476;
          label743:
          localObject1 = null;
        }
        label749:
        localCollection.add(localObject1);
      }
      label762:
      ((Collection)localObject2).add(a.j.b.a.c.l.c.a.aM((w)b.gi((List)localCollection)));
      i += 1;
    }
    label791:
    boolean bool = a(paramo, (List)localObject2, paramad2);
    AppMethodBeat.o(122744);
    return bool;
  }
  
  private boolean b(o paramo, az paramaz1, az paramaz2)
  {
    AppMethodBeat.i(122739);
    a.f.b.j.q(paramo, "receiver$0");
    a.f.b.j.q(paramaz1, "subType");
    a.f.b.j.q(paramaz2, "superType");
    if (paramaz1 == paramaz2)
    {
      AppMethodBeat.o(122739);
      return true;
    }
    paramaz1 = c(paramaz1);
    paramaz2 = c(paramaz2);
    Boolean localBoolean = a(paramo, t.ak((w)paramaz1), t.al((w)paramaz2));
    if (localBoolean != null)
    {
      bool = localBoolean.booleanValue();
      o.b(paramaz1, paramaz2);
      AppMethodBeat.o(122739);
      return bool;
    }
    o.b(paramaz1, paramaz2);
    boolean bool = b(paramo, t.ak((w)paramaz1), t.al((w)paramaz2));
    AppMethodBeat.o(122739);
    return bool;
  }
  
  public static az c(az paramaz)
  {
    AppMethodBeat.i(122741);
    a.f.b.j.q(paramaz, "type");
    Object localObject;
    if ((paramaz instanceof ad)) {
      localObject = (az)b((ad)paramaz);
    }
    for (;;)
    {
      paramaz = ax.a((az)localObject, (w)paramaz);
      AppMethodBeat.o(122741);
      return paramaz;
      if (!(paramaz instanceof q)) {
        break;
      }
      localObject = b(((q)paramaz).CBm);
      ad localad = b(((q)paramaz).CBn);
      if ((localObject != ((q)paramaz).CBm) || (localad != ((q)paramaz).CBn)) {
        localObject = a.j.b.a.c.l.x.a((ad)localObject, localad);
      } else {
        localObject = paramaz;
      }
    }
    paramaz = new a.m();
    AppMethodBeat.o(122741);
    throw paramaz;
  }
  
  private static List<ad> c(o paramo, ad paramad, an paraman)
  {
    AppMethodBeat.i(122747);
    Object localObject2 = paraman.ecR();
    Object localObject1 = localObject2;
    if (!(localObject2 instanceof a.j.b.a.c.b.e)) {
      localObject1 = null;
    }
    localObject1 = (a.j.b.a.c.b.e)localObject1;
    if ((localObject1 != null) && (B((a.j.b.a.c.b.e)localObject1) == true)) {
      if (o.c(paramad.enU(), paraman))
      {
        paramo = g.a(paramad, a.CCe);
        if (paramo != null) {
          break label490;
        }
      }
    }
    for (;;)
    {
      paramo = a.a.j.listOf(paramad);
      AppMethodBeat.o(122747);
      return paramo;
      paramo = (List)a.a.v.BMx;
      AppMethodBeat.o(122747);
      return paramo;
      List localList = (List)new a.j.b.a.c.n.h();
      paramo.initialize();
      ArrayDeque localArrayDeque = paramo.CCw;
      if (localArrayDeque == null) {
        a.f.b.j.ebi();
      }
      Set localSet = paramo.CCx;
      if (localSet == null) {
        a.f.b.j.ebi();
      }
      localArrayDeque.push(paramad);
      label335:
      label471:
      label475:
      for (;;)
      {
        if (!((Collection)localArrayDeque).isEmpty()) {}
        for (int i = 1;; i = 0)
        {
          if (i == 0) {
            break label477;
          }
          if (localSet.size() <= 1000) {
            break;
          }
          paramo = (Throwable)new IllegalStateException(("Too many supertypes for type: " + paramad + ". Supertypes = " + a.a.j.a((Iterable)localSet, null, null, null, 0, null, null, 63)).toString());
          AppMethodBeat.o(122747);
          throw paramo;
        }
        localObject2 = (ad)localArrayDeque.pop();
        a.f.b.j.p(localObject2, "current");
        if (localSet.add(localObject2))
        {
          Object localObject3 = g.a((ad)localObject2, a.CCe);
          localObject1 = localObject3;
          if (localObject3 == null) {
            localObject1 = localObject2;
          }
          if (o.c(((ad)localObject1).enU(), paraman))
          {
            localList.add(localObject1);
            localObject1 = (o.c)o.c.c.CCK;
            if (!(a.f.b.j.e(localObject1, o.c.c.CCK) ^ true)) {
              break label471;
            }
          }
          for (;;)
          {
            if (localObject1 == null) {
              break label475;
            }
            localObject2 = ((ad)localObject2).enU().eeO().iterator();
            while (((Iterator)localObject2).hasNext())
            {
              localObject3 = (w)((Iterator)localObject2).next();
              a.f.b.j.p(localObject3, "supertype");
              localArrayDeque.add(((o.c)localObject1).aJ((w)localObject3));
            }
            break;
            if (((ad)localObject1).enR().isEmpty())
            {
              localObject1 = (o.c)o.c.a.CCJ;
              break label335;
            }
            localObject3 = ao.CBF;
            localObject1 = (o.c)new o.c.b(ao.a.au((w)localObject1).eoP());
            break label335;
            localObject1 = null;
          }
        }
      }
      label477:
      paramo.clear();
      AppMethodBeat.o(122747);
      return localList;
      label490:
      paramad = paramo;
    }
  }
  
  public final boolean c(w paramw1, w paramw2)
  {
    AppMethodBeat.i(122734);
    a.f.b.j.q(paramw1, "subtype");
    a.f.b.j.q(paramw2, "supertype");
    boolean bool = b(new o(true, (byte)0), paramw1.eoL(), paramw2.eoL());
    AppMethodBeat.o(122734);
    return bool;
  }
  
  public final boolean d(w paramw1, w paramw2)
  {
    AppMethodBeat.i(122735);
    a.f.b.j.q(paramw1, "a");
    a.f.b.j.q(paramw2, "b");
    boolean bool = a(new o(false, (byte)0), paramw1.eoL(), paramw2.eoL());
    AppMethodBeat.o(122735);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     a.j.b.a.c.l.a.h
 * JD-Core Version:    0.7.0.1
 */