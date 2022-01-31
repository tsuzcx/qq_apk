package a.j.b.a.c.i;

import a.f.a.m;
import a.j.b.a.c.b.a;
import a.j.b.a.c.b.ag;
import a.j.b.a.c.b.ah;
import a.j.b.a.c.b.aj;
import a.j.b.a.c.b.ak;
import a.j.b.a.c.b.ar;
import a.j.b.a.c.b.au;
import a.j.b.a.c.b.ay;
import a.j.b.a.c.b.az;
import a.j.b.a.c.b.b.a;
import a.j.b.a.c.b.c.z;
import a.j.b.a.c.b.v;
import a.j.b.a.c.f.f;
import a.j.b.a.c.l.a.c;
import a.j.b.a.c.l.a.c.a;
import a.o;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collection<La.j.b.a.c.b.b;>;
import java.util.Collection<TH;>;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Queue;
import java.util.ServiceLoader;
import java.util.Set;

public class j
{
  private static final List<e> Cwa;
  public static final j Cwb;
  private final c.a Cwc;
  
  static
  {
    AppMethodBeat.i(122036);
    if (!j.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      Cwa = a.a.j.m(ServiceLoader.load(e.class, e.class.getClassLoader()));
      Cwb = new j(new j.1());
      AppMethodBeat.o(122036);
      return;
    }
  }
  
  private j(c.a parama)
  {
    this.Cwc = parama;
  }
  
  private static a.j.b.a.c.b.w a(Collection<a.j.b.a.c.b.b> paramCollection, a.j.b.a.c.b.e parame)
  {
    boolean bool = true;
    AppMethodBeat.i(122030);
    Object localObject = paramCollection.iterator();
    int i = 0;
    int j = 0;
    if (((Iterator)localObject).hasNext())
    {
      a.j.b.a.c.b.b localb = (a.j.b.a.c.b.b)((Iterator)localObject).next();
      switch (j.9.Cwl[localb.ecC().ordinal()])
      {
      }
      for (;;)
      {
        break;
        paramCollection = a.j.b.a.c.b.w.BWp;
        AppMethodBeat.o(122030);
        return paramCollection;
        paramCollection = new IllegalStateException("Member cannot have SEALED modality: ".concat(String.valueOf(localb)));
        AppMethodBeat.o(122030);
        throw paramCollection;
        j = 1;
        break;
        i = 1;
      }
    }
    if ((parame.ecJ()) && (parame.ecC() != a.j.b.a.c.b.w.BWs) && (parame.ecC() != a.j.b.a.c.b.w.BWq)) {}
    while ((j != 0) && (i == 0))
    {
      paramCollection = a.j.b.a.c.b.w.BWr;
      AppMethodBeat.o(122030);
      return paramCollection;
      bool = false;
    }
    if ((j == 0) && (i != 0))
    {
      if (bool)
      {
        paramCollection = parame.ecC();
        AppMethodBeat.o(122030);
        return paramCollection;
      }
      paramCollection = a.j.b.a.c.b.w.BWs;
      AppMethodBeat.o(122030);
      return paramCollection;
    }
    localObject = new HashSet();
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext()) {
      ((Set)localObject).addAll(w((a.j.b.a.c.b.b)paramCollection.next()));
    }
    paramCollection = a(n((Set)localObject), bool, parame.ecC());
    AppMethodBeat.o(122030);
    return paramCollection;
  }
  
  private static a.j.b.a.c.b.w a(Collection<a.j.b.a.c.b.b> paramCollection, boolean paramBoolean, a.j.b.a.c.b.w paramw)
  {
    AppMethodBeat.i(122031);
    Object localObject = a.j.b.a.c.b.w.BWs;
    Iterator localIterator = paramCollection.iterator();
    paramCollection = (Collection<a.j.b.a.c.b.b>)localObject;
    if (localIterator.hasNext())
    {
      localObject = (a.j.b.a.c.b.b)localIterator.next();
      if ((paramBoolean) && (((a.j.b.a.c.b.b)localObject).ecC() == a.j.b.a.c.b.w.BWs))
      {
        localObject = paramw;
        label58:
        if (((a.j.b.a.c.b.w)localObject).compareTo(paramCollection) >= 0) {
          break label88;
        }
      }
    }
    for (;;)
    {
      paramCollection = (Collection<a.j.b.a.c.b.b>)localObject;
      break;
      localObject = ((a.j.b.a.c.b.b)localObject).ecC();
      break label58;
      AppMethodBeat.o(122031);
      return paramCollection;
      label88:
      localObject = paramCollection;
    }
  }
  
  public static j a(c.a parama)
  {
    AppMethodBeat.i(122007);
    parama = new j(parama);
    AppMethodBeat.o(122007);
    return parama;
  }
  
  public static <H> H a(Collection<H> paramCollection, a.f.a.b<H, a> paramb)
  {
    AppMethodBeat.i(122028);
    if ((!$assertionsDisabled) && (paramCollection.isEmpty()))
    {
      paramCollection = new AssertionError("Should have at least one overridable descriptor");
      AppMethodBeat.o(122028);
      throw paramCollection;
    }
    if (paramCollection.size() == 1)
    {
      paramCollection = a.a.j.e(paramCollection);
      AppMethodBeat.o(122028);
      return paramCollection;
    }
    ArrayList localArrayList = new ArrayList(2);
    List localList = a.a.j.c(paramCollection, paramb);
    Object localObject = a.a.j.e(paramCollection);
    a locala1 = (a)paramb.S(localObject);
    Iterator localIterator = paramCollection.iterator();
    paramCollection = (Collection<H>)localObject;
    if (localIterator.hasNext())
    {
      localObject = localIterator.next();
      a locala2 = (a)paramb.S(localObject);
      if (a(locala2, localList)) {
        localArrayList.add(localObject);
      }
      if ((!f(locala2, locala1)) || (f(locala1, locala2))) {
        break label285;
      }
      paramCollection = (Collection<H>)localObject;
    }
    label285:
    for (;;)
    {
      break;
      if (localArrayList.isEmpty())
      {
        AppMethodBeat.o(122028);
        return paramCollection;
      }
      if (localArrayList.size() == 1)
      {
        paramCollection = a.a.j.e(localArrayList);
        AppMethodBeat.o(122028);
        return paramCollection;
      }
      localObject = localArrayList.iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        paramCollection = ((Iterator)localObject).next();
      } while (a.j.b.a.c.l.t.ai(((a)paramb.S(paramCollection)).eds()));
      for (;;)
      {
        if (paramCollection != null)
        {
          AppMethodBeat.o(122028);
          return paramCollection;
        }
        paramCollection = a.a.j.e(localArrayList);
        AppMethodBeat.o(122028);
        return paramCollection;
        paramCollection = null;
      }
    }
  }
  
  private static Collection<a.j.b.a.c.b.b> a(a.j.b.a.c.b.b paramb, Collection<? extends a.j.b.a.c.b.b> paramCollection, a.j.b.a.c.b.e parame, i parami)
  {
    AppMethodBeat.i(122022);
    ArrayList localArrayList = new ArrayList(paramCollection.size());
    a.j.b.a.c.n.i locali = a.j.b.a.c.n.i.epb();
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
    {
      a.j.b.a.c.b.b localb = (a.j.b.a.c.b.b)paramCollection.next();
      j.a.a locala = Cwb.b(localb, paramb, parame).Cwn;
      if ((!ay.b(localb.ecE())) && (ay.a(localb, paramb))) {}
      for (int i = 1;; i = 0) {
        switch (j.9.Cwk[locala.ordinal()])
        {
        default: 
          break;
        case 1: 
          if (i != 0) {
            locali.add(localb);
          }
          localArrayList.add(localb);
          break;
        }
      }
      if (i != 0) {
        parami.b(localb, paramb);
      }
      localArrayList.add(localb);
    }
    parami.a(paramb, locali);
    AppMethodBeat.o(122022);
    return localArrayList;
  }
  
  private static Collection<a.j.b.a.c.b.b> a(a.j.b.a.c.b.e parame, Collection<a.j.b.a.c.b.b> paramCollection)
  {
    AppMethodBeat.i(122032);
    parame = a.a.j.b(paramCollection, new j.6(parame));
    AppMethodBeat.o(122032);
    return parame;
  }
  
  public static <H> Collection<H> a(H paramH, Collection<H> paramCollection, a.f.a.b<H, a> paramb, a.f.a.b<H, a.y> paramb1)
  {
    AppMethodBeat.i(122033);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramH);
    a locala = (a)paramb.S(paramH);
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
    {
      Object localObject1 = paramCollection.next();
      Object localObject2 = (a)paramb.S(localObject1);
      if (paramH == localObject1)
      {
        paramCollection.remove();
      }
      else
      {
        localObject2 = g(locala, (a)localObject2);
        if (localObject2 == j.a.a.Cwp)
        {
          localArrayList.add(localObject1);
          paramCollection.remove();
        }
        else if (localObject2 == j.a.a.Cwr)
        {
          paramb1.S(localObject1);
          paramCollection.remove();
        }
      }
    }
    AppMethodBeat.o(122033);
    return localArrayList;
  }
  
  public static void a(a.j.b.a.c.b.b paramb, a.f.a.b<a.j.b.a.c.b.b, a.y> paramb1)
  {
    AppMethodBeat.i(122035);
    Object localObject1 = paramb.edw().iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (a.j.b.a.c.b.b)((Iterator)localObject1).next();
      if (((a.j.b.a.c.b.b)localObject2).ecE() == ay.BWQ) {
        a((a.j.b.a.c.b.b)localObject2, paramb1);
      }
    }
    if (paramb.ecE() != ay.BWQ)
    {
      AppMethodBeat.o(122035);
      return;
    }
    Object localObject3 = paramb.edw();
    label104:
    label124:
    Object localObject4;
    if (((Collection)localObject3).isEmpty())
    {
      localObject2 = ay.BWV;
      if (localObject2 == null)
      {
        localObject1 = null;
        if (localObject1 != null) {
          break label460;
        }
        if (paramb1 != null) {
          paramb1.S(paramb);
        }
        localObject2 = ay.BWO;
        if (!(paramb instanceof z)) {
          break label477;
        }
        ((z)paramb).BZE = ((az)localObject2);
        localObject2 = ((ah)paramb).eej().iterator();
        for (;;)
        {
          if (!((Iterator)localObject2).hasNext()) {
            break label470;
          }
          localObject3 = (ag)((Iterator)localObject2).next();
          if (localObject1 != null) {
            break;
          }
          paramb = null;
          label180:
          a((a.j.b.a.c.b.b)localObject3, paramb);
        }
      }
    }
    else
    {
      localObject4 = ((Collection)localObject3).iterator();
      localObject1 = null;
      label200:
      while (((Iterator)localObject4).hasNext())
      {
        Object localObject5 = (a.j.b.a.c.b.b)((Iterator)localObject4).next();
        localObject2 = ((a.j.b.a.c.b.b)localObject5).ecE();
        if ((!$assertionsDisabled) && (localObject2 == ay.BWQ))
        {
          paramb = new AssertionError("Visibility should have been computed for ".concat(String.valueOf(localObject5)));
          AppMethodBeat.o(122035);
          throw paramb;
        }
        if (localObject1 == null)
        {
          localObject1 = localObject2;
        }
        else
        {
          localObject5 = ay.b((az)localObject2, (az)localObject1);
          if (localObject5 == null)
          {
            localObject1 = null;
          }
          else
          {
            if (((Integer)localObject5).intValue() <= 0) {
              break label563;
            }
            localObject1 = localObject2;
          }
        }
      }
    }
    label563:
    for (;;)
    {
      break label200;
      if (localObject1 == null)
      {
        localObject2 = null;
        break;
      }
      localObject2 = ((Collection)localObject3).iterator();
      for (;;)
      {
        if (((Iterator)localObject2).hasNext())
        {
          localObject4 = ay.b((az)localObject1, ((a.j.b.a.c.b.b)((Iterator)localObject2).next()).ecE());
          if ((localObject4 == null) || (((Integer)localObject4).intValue() < 0))
          {
            localObject2 = null;
            break;
          }
        }
      }
      localObject2 = localObject1;
      break;
      if (paramb.edy() == b.a.BVY)
      {
        localObject3 = ((Collection)localObject3).iterator();
        do
        {
          localObject1 = localObject2;
          if (!((Iterator)localObject3).hasNext()) {
            break;
          }
          localObject1 = (a.j.b.a.c.b.b)((Iterator)localObject3).next();
        } while ((((a.j.b.a.c.b.b)localObject1).ecC() == a.j.b.a.c.b.w.BWs) || (((a.j.b.a.c.b.b)localObject1).ecE().equals(localObject2)));
        localObject1 = null;
        break label104;
      }
      localObject1 = ((az)localObject2).eeF();
      break label104;
      label460:
      localObject2 = localObject1;
      break label124;
      paramb = paramb1;
      break label180;
      label470:
      AppMethodBeat.o(122035);
      return;
      label477:
      if ((paramb instanceof a.j.b.a.c.b.c.p))
      {
        ((a.j.b.a.c.b.c.p)paramb).BZE = ((az)localObject2);
        AppMethodBeat.o(122035);
        return;
      }
      if ((!$assertionsDisabled) && (!(paramb instanceof a.j.b.a.c.b.c.y)))
      {
        paramb = new AssertionError();
        AppMethodBeat.o(122035);
        throw paramb;
      }
      paramb = (a.j.b.a.c.b.c.y)paramb;
      paramb.BZE = ((az)localObject2);
      if (localObject2 != paramb.BZz.ecE()) {
        paramb.isDefault = false;
      }
      AppMethodBeat.o(122035);
      return;
    }
  }
  
  private static void a(a.j.b.a.c.b.b paramb, Set<a.j.b.a.c.b.b> paramSet)
  {
    AppMethodBeat.i(122011);
    if (paramb.edy().edz())
    {
      paramSet.add(paramb);
      AppMethodBeat.o(122011);
      return;
    }
    if (paramb.edw().isEmpty())
    {
      paramb = new IllegalStateException("No overridden descriptors found for (fake override) ".concat(String.valueOf(paramb)));
      AppMethodBeat.o(122011);
      throw paramb;
    }
    paramb = paramb.edw().iterator();
    while (paramb.hasNext()) {
      a((a.j.b.a.c.b.b)paramb.next(), paramSet);
    }
    AppMethodBeat.o(122011);
  }
  
  private static void a(a.j.b.a.c.b.e parame, Collection<a.j.b.a.c.b.b> paramCollection, i parami)
  {
    AppMethodBeat.i(122023);
    Object localObject;
    int i;
    if (paramCollection.size() >= 2)
    {
      localObject = new j.4(((a.j.b.a.c.b.b)paramCollection.iterator().next()).ecv());
      a.f.b.j.q(paramCollection, "receiver$0");
      a.f.b.j.q(localObject, "predicate");
      if (!((Collection)paramCollection).isEmpty())
      {
        Iterator localIterator = paramCollection.iterator();
        while (localIterator.hasNext()) {
          if (!((Boolean)((a.f.a.b)localObject).S(localIterator.next())).booleanValue()) {
            i = 0;
          }
        }
      }
    }
    while (i != 0)
    {
      paramCollection = paramCollection.iterator();
      for (;;)
      {
        if (paramCollection.hasNext())
        {
          a(Collections.singleton((a.j.b.a.c.b.b)paramCollection.next()), parame, parami);
          continue;
          i = 1;
          break;
        }
      }
      AppMethodBeat.o(122023);
      return;
    }
    paramCollection = new LinkedList(paramCollection);
    while (!paramCollection.isEmpty())
    {
      localObject = l.l(paramCollection);
      a(a(localObject, paramCollection, new a.f.a.b()new j.8 {}, new j.8(parami, (a.j.b.a.c.b.b)localObject)), parame, parami);
    }
    AppMethodBeat.o(122023);
  }
  
  private static void a(Collection<a.j.b.a.c.b.b> paramCollection, a.j.b.a.c.b.e parame, i parami)
  {
    AppMethodBeat.i(122029);
    Object localObject = a(parame, paramCollection);
    boolean bool = ((Collection)localObject).isEmpty();
    a.j.b.a.c.b.w localw;
    if (bool)
    {
      localw = a(paramCollection, parame);
      if (!bool) {
        break label136;
      }
    }
    label136:
    for (localObject = ay.BWR;; localObject = ay.BWQ)
    {
      parame = ((a.j.b.a.c.b.b)a(paramCollection, new j.5())).a(parame, localw, (az)localObject, b.a.BVY);
      parami.a(parame, paramCollection);
      if (($assertionsDisabled) || (!parame.edw().isEmpty())) {
        break label144;
      }
      paramCollection = new AssertionError("Overridden descriptors should be set for " + b.a.BVY);
      AppMethodBeat.o(122029);
      throw paramCollection;
      paramCollection = (Collection<a.j.b.a.c.b.b>)localObject;
      break;
    }
    label144:
    parami.g(parame);
    AppMethodBeat.o(122029);
  }
  
  public static void a(Collection<? extends a.j.b.a.c.b.b> paramCollection1, Collection<? extends a.j.b.a.c.b.b> paramCollection2, a.j.b.a.c.b.e parame, i parami)
  {
    AppMethodBeat.i(122021);
    LinkedHashSet localLinkedHashSet = new LinkedHashSet(paramCollection1);
    paramCollection2 = paramCollection2.iterator();
    while (paramCollection2.hasNext()) {
      localLinkedHashSet.removeAll(a((a.j.b.a.c.b.b)paramCollection2.next(), paramCollection1, parame, parami));
    }
    a(parame, localLinkedHashSet, parami);
    AppMethodBeat.o(122021);
  }
  
  private static boolean a(a parama1, a.j.b.a.c.l.w paramw1, a parama2, a.j.b.a.c.l.w paramw2)
  {
    AppMethodBeat.i(122027);
    boolean bool = Cwb.y(parama1.edr(), parama2.edr()).c(paramw1, paramw2);
    AppMethodBeat.o(122027);
    return bool;
  }
  
  private static boolean a(a parama, Collection<a> paramCollection)
  {
    AppMethodBeat.i(122026);
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext()) {
      if (!f(parama, (a)paramCollection.next()))
      {
        AppMethodBeat.o(122026);
        return false;
      }
    }
    AppMethodBeat.o(122026);
    return true;
  }
  
  private static boolean a(ar paramar1, ar paramar2, c paramc)
  {
    AppMethodBeat.i(122019);
    Object localObject = paramar1.ebo();
    paramar1 = new ArrayList(paramar2.ebo());
    if (((List)localObject).size() != paramar1.size())
    {
      AppMethodBeat.o(122019);
      return false;
    }
    paramar2 = ((List)localObject).iterator();
    while (paramar2.hasNext())
    {
      localObject = (a.j.b.a.c.l.w)paramar2.next();
      ListIterator localListIterator = paramar1.listIterator();
      for (;;)
      {
        if (localListIterator.hasNext()) {
          if (a((a.j.b.a.c.l.w)localObject, (a.j.b.a.c.l.w)localListIterator.next(), paramc))
          {
            localListIterator.remove();
            break;
          }
        }
      }
      AppMethodBeat.o(122019);
      return false;
    }
    AppMethodBeat.o(122019);
    return true;
  }
  
  private static boolean a(a.j.b.a.c.b.p paramp1, a.j.b.a.c.b.p paramp2)
  {
    AppMethodBeat.i(122025);
    paramp1 = ay.b(paramp1.ecE(), paramp2.ecE());
    if ((paramp1 == null) || (paramp1.intValue() >= 0))
    {
      AppMethodBeat.o(122025);
      return true;
    }
    AppMethodBeat.o(122025);
    return false;
  }
  
  private static boolean a(a.j.b.a.c.l.w paramw1, a.j.b.a.c.l.w paramw2, c paramc)
  {
    AppMethodBeat.i(122018);
    if ((a.j.b.a.c.l.y.an(paramw1)) && (a.j.b.a.c.l.y.an(paramw2))) {}
    for (int i = 1; (i != 0) || (paramc.d(paramw1, paramw2)); i = 0)
    {
      AppMethodBeat.o(122018);
      return true;
    }
    AppMethodBeat.o(122018);
    return false;
  }
  
  private j.a b(a parama1, a parama2, a.j.b.a.c.b.e parame)
  {
    AppMethodBeat.i(122012);
    parama1 = a(parama1, parama2, parame, false);
    AppMethodBeat.o(122012);
    return parama1;
  }
  
  private static <D extends a> boolean c(D paramD1, D paramD2)
  {
    AppMethodBeat.i(122009);
    if ((!paramD1.equals(paramD2)) && (b.Cvz.d(paramD1.edt(), paramD2.edt())))
    {
      AppMethodBeat.o(122009);
      return true;
    }
    paramD2 = paramD2.edt();
    paramD1 = d.d(paramD1).iterator();
    while (paramD1.hasNext())
    {
      a locala = (a)paramD1.next();
      if (b.Cvz.d(paramD2, locala))
      {
        AppMethodBeat.o(122009);
        return true;
      }
    }
    AppMethodBeat.o(122009);
    return false;
  }
  
  private static j.a d(a parama1, a parama2)
  {
    AppMethodBeat.i(122015);
    if ((((parama1 instanceof a.j.b.a.c.b.t)) && (!(parama2 instanceof a.j.b.a.c.b.t))) || (((parama1 instanceof ah)) && (!(parama2 instanceof ah))))
    {
      parama1 = j.a.azc("Member kind mismatch");
      AppMethodBeat.o(122015);
      return parama1;
    }
    if ((!(parama1 instanceof a.j.b.a.c.b.t)) && (!(parama1 instanceof ah)))
    {
      parama1 = new IllegalArgumentException("This type of CallableDescriptor cannot be checked for overridability: ".concat(String.valueOf(parama1)));
      AppMethodBeat.o(122015);
      throw parama1;
    }
    if (!parama1.edF().equals(parama2.edF()))
    {
      parama1 = j.a.azc("Name mismatch");
      AppMethodBeat.o(122015);
      return parama1;
    }
    parama1 = e(parama1, parama2);
    if (parama1 != null)
    {
      AppMethodBeat.o(122015);
      return parama1;
    }
    AppMethodBeat.o(122015);
    return null;
  }
  
  private static j.a e(a parama1, a parama2)
  {
    int j = 1;
    AppMethodBeat.i(122017);
    int i;
    if (parama1.edp() == null)
    {
      i = 1;
      if (parama2.edp() != null) {
        break label53;
      }
    }
    for (;;)
    {
      if (i == j) {
        break label58;
      }
      parama1 = j.a.azc("Receiver presence mismatch");
      AppMethodBeat.o(122017);
      return parama1;
      i = 0;
      break;
      label53:
      j = 0;
    }
    label58:
    if (parama1.edu().size() != parama2.edu().size())
    {
      parama1 = j.a.azc("Value parameter number mismatch");
      AppMethodBeat.o(122017);
      return parama1;
    }
    AppMethodBeat.o(122017);
    return null;
  }
  
  private static List<a.j.b.a.c.l.w> e(a parama)
  {
    AppMethodBeat.i(122020);
    ak localak = parama.edp();
    ArrayList localArrayList = new ArrayList();
    if (localak != null) {
      localArrayList.add(localak.eer());
    }
    parama = parama.edu().iterator();
    while (parama.hasNext()) {
      localArrayList.add(((au)parama.next()).eer());
    }
    AppMethodBeat.o(122020);
    return localArrayList;
  }
  
  public static boolean f(a parama1, a parama2)
  {
    AppMethodBeat.i(122024);
    a.j.b.a.c.l.w localw1 = parama1.eds();
    a.j.b.a.c.l.w localw2 = parama2.eds();
    if ((!$assertionsDisabled) && (localw1 == null))
    {
      parama1 = new AssertionError("Return type of " + parama1 + " is null");
      AppMethodBeat.o(122024);
      throw parama1;
    }
    if ((!$assertionsDisabled) && (localw2 == null))
    {
      parama1 = new AssertionError("Return type of " + parama2 + " is null");
      AppMethodBeat.o(122024);
      throw parama1;
    }
    if (!a(parama1, parama2))
    {
      AppMethodBeat.o(122024);
      return false;
    }
    boolean bool;
    if ((parama1 instanceof a.j.b.a.c.b.t))
    {
      if ((!$assertionsDisabled) && (!(parama2 instanceof a.j.b.a.c.b.t)))
      {
        parama1 = new AssertionError("b is " + parama2.getClass());
        AppMethodBeat.o(122024);
        throw parama1;
      }
      bool = a(parama1, localw1, parama2, localw2);
      AppMethodBeat.o(122024);
      return bool;
    }
    if ((parama1 instanceof ah))
    {
      if ((!$assertionsDisabled) && (!(parama2 instanceof ah)))
      {
        parama1 = new AssertionError("b is " + parama2.getClass());
        AppMethodBeat.o(122024);
        throw parama1;
      }
      ah localah1 = (ah)parama1;
      ah localah2 = (ah)parama2;
      aj localaj1 = localah1.eei();
      aj localaj2 = localah2.eei();
      if ((localaj1 == null) || (localaj2 == null)) {}
      for (bool = true; !bool; bool = a(localaj1, localaj2))
      {
        AppMethodBeat.o(122024);
        return false;
      }
      if ((localah1.eey()) && (localah2.eey()))
      {
        bool = Cwb.y(parama1.edr(), parama2.edr()).d(localw1, localw2);
        AppMethodBeat.o(122024);
        return bool;
      }
      if (((localah1.eey()) || (!localah2.eey())) && (a(parama1, localw1, parama2, localw2)))
      {
        AppMethodBeat.o(122024);
        return true;
      }
      AppMethodBeat.o(122024);
      return false;
    }
    parama1 = new IllegalArgumentException("Unexpected callable: " + parama1.getClass());
    AppMethodBeat.o(122024);
    throw parama1;
  }
  
  public static j.a.a g(a parama1, a parama2)
  {
    AppMethodBeat.i(122034);
    j.a.a locala = Cwb.b(parama2, parama1, null).Cwn;
    parama1 = Cwb.b(parama1, parama2, null).Cwn;
    if ((locala == j.a.a.Cwp) && (parama1 == j.a.a.Cwp))
    {
      parama1 = j.a.a.Cwp;
      AppMethodBeat.o(122034);
      return parama1;
    }
    if ((locala == j.a.a.Cwr) || (parama1 == j.a.a.Cwr))
    {
      parama1 = j.a.a.Cwr;
      AppMethodBeat.o(122034);
      return parama1;
    }
    parama1 = j.a.a.Cwq;
    AppMethodBeat.o(122034);
    return parama1;
  }
  
  private static <D extends a> Set<D> n(Set<D> paramSet)
  {
    AppMethodBeat.i(122008);
    j.2 local2 = new j.2();
    if (paramSet.size() <= 1)
    {
      AppMethodBeat.o(122008);
      return paramSet;
    }
    LinkedHashSet localLinkedHashSet = new LinkedHashSet();
    Iterator localIterator1 = paramSet.iterator();
    while (localIterator1.hasNext())
    {
      Object localObject1 = localIterator1.next();
      Iterator localIterator2 = localLinkedHashSet.iterator();
      for (;;)
      {
        if (!localIterator2.hasNext()) {
          break label155;
        }
        Object localObject2 = (o)local2.h(localObject1, localIterator2.next());
        a locala = (a)((o)localObject2).first;
        localObject2 = (a)((o)localObject2).second;
        if (c(locala, (a)localObject2)) {
          localIterator2.remove();
        } else {
          if (c((a)localObject2, locala)) {
            break;
          }
        }
      }
      label155:
      localLinkedHashSet.add(localObject1);
    }
    if ((!$assertionsDisabled) && (localLinkedHashSet.isEmpty()))
    {
      paramSet = new AssertionError("All candidates filtered out from ".concat(String.valueOf(paramSet)));
      AppMethodBeat.o(122008);
      throw paramSet;
    }
    AppMethodBeat.o(122008);
    return localLinkedHashSet;
  }
  
  private static Set<a.j.b.a.c.b.b> w(a.j.b.a.c.b.b paramb)
  {
    AppMethodBeat.i(122010);
    LinkedHashSet localLinkedHashSet = new LinkedHashSet();
    a(paramb, localLinkedHashSet);
    AppMethodBeat.o(122010);
    return localLinkedHashSet;
  }
  
  private c y(List<ar> paramList1, List<ar> paramList2)
  {
    AppMethodBeat.i(122016);
    if ((!$assertionsDisabled) && (paramList1.size() != paramList2.size()))
    {
      paramList1 = new AssertionError("Should be the same number of type parameters: " + paramList1 + " vs " + paramList2);
      AppMethodBeat.o(122016);
      throw paramList1;
    }
    if (paramList1.isEmpty())
    {
      paramList1 = a.j.b.a.c.l.a.d.b(this.Cwc);
      AppMethodBeat.o(122016);
      return paramList1;
    }
    HashMap localHashMap = new HashMap();
    int i = 0;
    while (i < paramList1.size())
    {
      localHashMap.put(((ar)paramList1.get(i)).ecx(), ((ar)paramList2.get(i)).ecx());
      i += 1;
    }
    paramList1 = a.j.b.a.c.l.a.d.b(new j.3(this, localHashMap));
    AppMethodBeat.o(122016);
    return paramList1;
  }
  
  public final j.a a(a parama1, a parama2, a.j.b.a.c.b.e parame, boolean paramBoolean)
  {
    AppMethodBeat.i(122013);
    Object localObject1 = a(parama1, parama2, paramBoolean);
    if (((j.a)localObject1).Cwn == j.a.a.Cwp) {}
    Object localObject2;
    Object localObject3;
    for (int i = 1;; i = 0)
    {
      localObject2 = Cwa.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (e)((Iterator)localObject2).next();
        if ((((e)localObject3).efw() != e.a.CvO) && ((i == 0) || (((e)localObject3).efw() != e.a.CvP)))
        {
          localObject3 = ((e)localObject3).a(parama1, parama2, parame);
          switch (j.9.Cwj[localObject3.ordinal()])
          {
          default: 
            break;
          case 1: 
            i = 1;
          }
        }
      }
    }
    parama1 = j.a.azd("External condition failed");
    AppMethodBeat.o(122013);
    return parama1;
    parama1 = j.a.azc("External condition");
    AppMethodBeat.o(122013);
    return parama1;
    if (i == 0)
    {
      AppMethodBeat.o(122013);
      return localObject1;
    }
    localObject1 = Cwa.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (e)((Iterator)localObject1).next();
      if (((e)localObject2).efw() == e.a.CvO)
      {
        localObject3 = ((e)localObject2).a(parama1, parama2, parame);
        switch (j.9.Cwj[localObject3.ordinal()])
        {
        default: 
          break;
        case 1: 
          parama1 = new IllegalStateException("Contract violation in " + localObject2.getClass().getName() + " condition. It's not supposed to end with success");
          AppMethodBeat.o(122013);
          throw parama1;
        case 2: 
          parama1 = j.a.azd("External condition failed");
          AppMethodBeat.o(122013);
          return parama1;
        case 3: 
          parama1 = j.a.azc("External condition");
          AppMethodBeat.o(122013);
          return parama1;
        }
      }
    }
    parama1 = j.a.enQ();
    AppMethodBeat.o(122013);
    return parama1;
  }
  
  public final j.a a(a parama1, a parama2, boolean paramBoolean)
  {
    int j = 0;
    int i = 0;
    AppMethodBeat.i(122014);
    Object localObject = d(parama1, parama2);
    if (localObject != null)
    {
      AppMethodBeat.o(122014);
      return localObject;
    }
    List localList1 = e(parama1);
    List localList2 = e(parama2);
    List localList3 = parama1.edr();
    List localList4 = parama2.edr();
    if (localList3.size() != localList4.size())
    {
      while (i < localList1.size())
      {
        if (!c.CCi.d((a.j.b.a.c.l.w)localList1.get(i), (a.j.b.a.c.l.w)localList2.get(i)))
        {
          parama1 = j.a.azc("Type parameter number mismatch");
          AppMethodBeat.o(122014);
          return parama1;
        }
        i += 1;
      }
      parama1 = j.a.azd("Type parameter number mismatch");
      AppMethodBeat.o(122014);
      return parama1;
    }
    localObject = y(localList3, localList4);
    i = 0;
    while (i < localList3.size())
    {
      if (!a((ar)localList3.get(i), (ar)localList4.get(i), (c)localObject))
      {
        parama1 = j.a.azc("Type parameter bounds mismatch");
        AppMethodBeat.o(122014);
        return parama1;
      }
      i += 1;
    }
    i = 0;
    while (i < localList1.size())
    {
      if (!a((a.j.b.a.c.l.w)localList1.get(i), (a.j.b.a.c.l.w)localList2.get(i), (c)localObject))
      {
        parama1 = j.a.azc("Value parameter type mismatch");
        AppMethodBeat.o(122014);
        return parama1;
      }
      i += 1;
    }
    if (((parama1 instanceof a.j.b.a.c.b.t)) && ((parama2 instanceof a.j.b.a.c.b.t)) && (((a.j.b.a.c.b.t)parama1).edU() != ((a.j.b.a.c.b.t)parama2).edU()))
    {
      parama1 = j.a.azd("Incompatible suspendability");
      AppMethodBeat.o(122014);
      return parama1;
    }
    if (paramBoolean)
    {
      parama1 = parama1.eds();
      parama2 = parama2.eds();
      if ((parama1 != null) && (parama2 != null))
      {
        i = j;
        if (a.j.b.a.c.l.y.an(parama2))
        {
          i = j;
          if (a.j.b.a.c.l.y.an(parama1)) {
            i = 1;
          }
        }
        if ((i == 0) && (!((c)localObject).c(parama2, parama1)))
        {
          parama1 = j.a.azd("Return type mismatch");
          AppMethodBeat.o(122014);
          return parama1;
        }
      }
    }
    parama1 = j.a.enQ();
    AppMethodBeat.o(122014);
    return parama1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     a.j.b.a.c.i.j
 * JD-Core Version:    0.7.0.1
 */