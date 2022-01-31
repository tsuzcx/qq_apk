package a.j.b.a.c.d.a.f;

import a.aa;
import a.f.b.k;
import a.j.b.a.c.b.ah;
import a.j.b.a.c.b.au;
import a.j.b.a.c.b.b.a;
import a.j.b.a.c.b.c.y;
import a.j.b.a.c.b.c.z;
import a.j.b.a.c.d.a.a.a;
import a.j.b.a.c.d.a.p;
import a.j.b.a.c.d.a.q;
import a.j.b.a.c.i.b.s;
import a.j.b.a.c.l.av;
import a.j.b.a.c.l.w;
import a.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class l
{
  private final a.j.b.a.c.n.e CbS;
  private final a.j.b.a.c.d.a.a CeS;
  
  public l(a.j.b.a.c.d.a.a parama, a.j.b.a.c.n.e parame)
  {
    AppMethodBeat.i(120178);
    this.CeS = parama;
    this.CbS = parame;
    AppMethodBeat.o(120178);
  }
  
  private final <D extends a.j.b.a.c.b.b> D a(D paramD, a.j.b.a.c.d.a.c.h paramh)
  {
    AppMethodBeat.i(120175);
    if (!(paramD instanceof a.j.b.a.c.d.a.b.b))
    {
      AppMethodBeat.o(120175);
      return paramD;
    }
    if (((a.j.b.a.c.d.a.b.b)paramD).edy() == b.a.BVY)
    {
      localObject1 = ((a.j.b.a.c.d.a.b.b)paramD).edx();
      a.f.b.j.p(localObject1, "original");
      if (((a.j.b.a.c.b.b)localObject1).edw().size() == 1)
      {
        AppMethodBeat.o(120175);
        return paramD;
      }
    }
    a.j.b.a.c.d.a.c.h localh = a.j.b.a.c.d.a.c.a.b(paramh, paramD.ecM());
    if ((paramD instanceof a.j.b.a.c.d.a.b.f))
    {
      paramh = ((a.j.b.a.c.d.a.b.f)paramD).CaP;
      if ((paramh != null) && (!paramh.isDefault))
      {
        paramh = ((a.j.b.a.c.d.a.b.f)paramD).CaP;
        if (paramh == null) {
          a.f.b.j.ebi();
        }
        a.f.b.j.p(paramh, "getter!!");
        paramh = (a.j.b.a.c.b.b)paramh;
        if (((a.j.b.a.c.d.a.b.b)paramD).edp() == null) {
          break label276;
        }
        if ((paramh instanceof a.j.b.a.c.b.t)) {
          break label1466;
        }
      }
    }
    label276:
    label920:
    label926:
    label1064:
    label1460:
    label1466:
    for (Object localObject1 = null;; localObject1 = paramh)
    {
      localObject1 = (a.j.b.a.c.b.t)localObject1;
      label188:
      Object localObject2;
      if (localObject1 != null)
      {
        localObject1 = (au)((a.j.b.a.c.b.t)localObject1).a(a.j.b.a.c.d.a.b.e.Ceo);
        localObject2 = a(paramD, (au)localObject1, localh, (a.f.a.b)l.d.Cim).a(null);
        label209:
        if ((paramD instanceof a.j.b.a.c.d.a.b.e)) {
          break label1460;
        }
      }
      for (localObject1 = null;; localObject1 = paramD)
      {
        localObject1 = (a.j.b.a.c.d.a.b.e)localObject1;
        Object localObject3;
        if (localObject1 != null)
        {
          localObject3 = a.j.b.a.c.d.b.t.Cjx;
          localObject3 = ((a.j.b.a.c.d.a.b.e)localObject1).ecv();
          if (localObject3 == null)
          {
            paramD = new v("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
            AppMethodBeat.o(120175);
            throw paramD;
            paramh = paramD;
            break;
            localObject1 = null;
            break label188;
            localObject2 = null;
            break label209;
          }
          localObject1 = a.j.b.a.c.d.b.t.a((a.j.b.a.c.b.e)localObject3, a.j.b.a.c.d.b.r.a((a.j.b.a.c.b.t)localObject1, false, false, 3));
          if (localObject1 != null)
          {
            localObject3 = (j)i.egI().get(localObject1);
            if (localObject3 == null) {
              break label457;
            }
            if (((j)localObject3).ChU.size() != ((a.j.b.a.c.d.a.b.b)paramD).edu().size()) {
              break label452;
            }
          }
        }
        label452:
        for (int i = 1;; i = 0)
        {
          if ((!aa.BMh) || (i != 0)) {
            break label457;
          }
          paramD = (Throwable)new AssertionError("Predefined enhancement info for " + paramD + " has " + ((j)localObject3).ChU.size() + ", but " + ((a.j.b.a.c.d.a.b.b)paramD).edu().size() + " expected");
          AppMethodBeat.o(120175);
          throw paramD;
          localObject3 = null;
          break;
        }
        label457:
        localObject1 = paramh.edu();
        a.f.b.j.p(localObject1, "annotationOwnerForMember.valueParameters");
        localObject1 = (Iterable)localObject1;
        Collection localCollection = (Collection)new ArrayList(a.a.j.d((Iterable)localObject1));
        Iterator localIterator = ((Iterable)localObject1).iterator();
        label584:
        label608:
        Object localObject5;
        if (localIterator.hasNext())
        {
          au localau = (au)localIterator.next();
          localObject4 = a(paramD, localau, localh, (a.f.a.b)new l.f(localau));
          l.a locala;
          label730:
          boolean bool1;
          if (localObject3 != null)
          {
            localObject1 = ((j)localObject3).ChU;
            if (localObject1 != null)
            {
              localObject1 = (r)a.a.j.w((List)localObject1, localau.getIndex());
              locala = ((l.b)localObject4).a((r)localObject1);
              if (!locala.ChW) {
                break label841;
              }
              localObject4 = locala.BPZ;
              a.f.b.j.p(localau, "p");
              a.f.b.j.q(localau, "receiver$0");
              localObject1 = localau.ecM();
              localObject5 = p.Cdm;
              a.f.b.j.p(localObject5, "JvmAnnotationNames.DEFAULT_VALUE_FQ_NAME");
              localObject1 = ((a.j.b.a.c.b.a.g)localObject1).i((a.j.b.a.c.f.b)localObject5);
              if (localObject1 == null) {
                break label869;
              }
              localObject5 = a.j.b.a.c.i.c.a.m((a.j.b.a.c.b.a.c)localObject1);
              if (localObject5 == null) {
                break label869;
              }
              localObject1 = localObject5;
              if (!(localObject5 instanceof s)) {
                localObject1 = null;
              }
              localObject1 = (s)localObject1;
              if (localObject1 == null) {
                break label869;
              }
              localObject1 = (String)((s)localObject1).getValue();
              if (localObject1 == null) {
                break label869;
              }
              localObject1 = (a.j.b.a.c.d.a.b.a)new a.j.b.a.c.d.a.b.h((String)localObject1);
              if (!(localObject1 instanceof a.j.b.a.c.d.a.b.h)) {
                break label926;
              }
              if (a.j.b.a.c.d.a.u.a((w)localObject4, ((a.j.b.a.c.d.a.b.h)localObject1).value) == null) {
                break label920;
              }
              bool1 = true;
              label757:
              if ((!bool1) || (!localau.edw().isEmpty())) {
                break label979;
              }
              bool1 = true;
              if ((!locala.ChW) && (bool1 == localau.eet())) {
                break label985;
              }
            }
          }
          label841:
          label979:
          label985:
          for (boolean bool2 = true;; bool2 = false)
          {
            localCollection.add(new c(locala.BPZ, bool1, bool2, locala.ChX));
            break;
            localObject1 = null;
            break label584;
            a.f.b.j.p(localau, "p");
            localObject4 = localau.eer();
            a.f.b.j.p(localObject4, "p.type");
            break label608;
            label869:
            localObject1 = localau.ecM();
            localObject5 = p.Cdn;
            a.f.b.j.p(localObject5, "JvmAnnotationNames.DEFAULT_NULL_FQ_NAME");
            if (((a.j.b.a.c.b.a.g)localObject1).j((a.j.b.a.c.f.b)localObject5))
            {
              localObject1 = (a.j.b.a.c.d.a.b.a)a.j.b.a.c.d.a.b.g.Cez;
              break label730;
            }
            localObject1 = null;
            break label730;
            bool1 = false;
            break label757;
            if (a.f.b.j.e(localObject1, a.j.b.a.c.d.a.b.g.Cez))
            {
              bool1 = av.aC((w)localObject4);
              break label757;
            }
            if (localObject1 == null)
            {
              bool1 = localau.eet();
              break label757;
            }
            paramD = new a.m();
            AppMethodBeat.o(120175);
            throw paramD;
            bool1 = false;
            break label780;
          }
        }
        localObject1 = (List)localCollection;
        Object localObject4 = (a.j.b.a.c.b.a.a)paramh;
        if (!(paramD instanceof ah)) {}
        for (paramh = null;; paramh = paramD)
        {
          paramh = (ah)paramh;
          label1145:
          label1151:
          int j;
          if ((paramh != null) && (a.j.b.a.c.d.a.c.a.c.e(paramh) == true))
          {
            paramh = a.a.CbV;
            localObject4 = a(paramD, (a.j.b.a.c.b.a.a)localObject4, true, localh, paramh, (a.f.a.b)l.e.Cin);
            if (localObject3 == null) {
              break label1363;
            }
            paramh = ((j)localObject3).ChT;
            localObject3 = ((l.b)localObject4).a(paramh);
            if (((localObject2 == null) || (((l.a)localObject2).ChX != true)) && (!((l.a)localObject3).ChX))
            {
              paramh = (Iterable)localObject1;
              if (((Collection)paramh).isEmpty()) {
                break label1368;
              }
              paramh = paramh.iterator();
            }
            while (paramh.hasNext()) {
              if (((c)paramh.next()).ChX)
              {
                i = 1;
                if (i == 0) {
                  break label1373;
                }
                i = 1;
                if (((localObject2 == null) || (((l.a)localObject2).ChW != true)) && (!((l.a)localObject3).ChW))
                {
                  paramh = (Iterable)localObject1;
                  if (((Collection)paramh).isEmpty()) {
                    break label1378;
                  }
                  paramh = paramh.iterator();
                }
                while (paramh.hasNext()) {
                  if (((c)paramh.next()).ChW)
                  {
                    j = 1;
                    label1225:
                    if ((j == 0) && (i == 0)) {
                      break label1448;
                    }
                    if (i == 0) {
                      break label1384;
                    }
                    paramh = a.u.F(a.j.b.a.c.i.a.enP(), new a.j.b.a.c.d.a.g((a.j.b.a.c.b.l)paramD));
                    label1256:
                    localObject4 = (a.j.b.a.c.d.a.b.b)paramD;
                    if (localObject2 == null) {
                      break label1389;
                    }
                  }
                }
              }
            }
          }
          label1363:
          label1368:
          label1373:
          label1378:
          label1384:
          label1389:
          for (paramD = ((l.a)localObject2).BPZ;; paramD = null)
          {
            localObject2 = (Iterable)localObject1;
            localObject1 = (Collection)new ArrayList(a.a.j.d((Iterable)localObject2));
            localObject2 = ((Iterable)localObject2).iterator();
            while (((Iterator)localObject2).hasNext())
            {
              localObject5 = (c)((Iterator)localObject2).next();
              ((Collection)localObject1).add(new a.j.b.a.c.d.a.b.j(((l.a)localObject5).BPZ, ((c)localObject5).CeA));
            }
            paramh = a.a.CbT;
            break;
            paramh = null;
            break label1064;
            i = 0;
            break label1145;
            i = 0;
            break label1151;
            j = 0;
            break label1225;
            paramh = null;
            break label1256;
          }
          paramD = ((a.j.b.a.c.d.a.b.b)localObject4).a(paramD, (List)localObject1, ((l.a)localObject3).BPZ, paramh);
          if (paramD == null)
          {
            paramD = new v("null cannot be cast to non-null type D");
            AppMethodBeat.o(120175);
            throw paramD;
          }
          paramD = (a.j.b.a.c.b.b)paramD;
          AppMethodBeat.o(120175);
          return paramD;
          AppMethodBeat.o(120175);
          return paramD;
        }
      }
    }
  }
  
  private final l.b a(a.j.b.a.c.b.b paramb, a.j.b.a.c.b.a.a parama, boolean paramBoolean, a.j.b.a.c.d.a.c.h paramh, a.a parama1, a.f.a.b<? super a.j.b.a.c.b.b, ? extends w> paramb1)
  {
    AppMethodBeat.i(120177);
    w localw = (w)paramb1.S(paramb);
    Collection localCollection = paramb.edw();
    a.f.b.j.p(localCollection, "this.overriddenDescriptors");
    Object localObject = (Iterable)localCollection;
    localCollection = (Collection)new ArrayList(a.a.j.d((Iterable)localObject));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      a.j.b.a.c.b.b localb = (a.j.b.a.c.b.b)((Iterator)localObject).next();
      a.f.b.j.p(localb, "it");
      localCollection.add((w)paramb1.S(localb));
    }
    paramb = new l.b(this, parama, localw, (Collection)localCollection, paramBoolean, a.j.b.a.c.d.a.c.a.b(paramh, ((w)paramb1.S(paramb)).ecM()), parama1);
    AppMethodBeat.o(120177);
    return paramb;
  }
  
  private final l.b a(a.j.b.a.c.b.b paramb, au paramau, a.j.b.a.c.d.a.c.h paramh, a.f.a.b<? super a.j.b.a.c.b.b, ? extends w> paramb1)
  {
    AppMethodBeat.i(120176);
    a.j.b.a.c.b.a.a locala = (a.j.b.a.c.b.a.a)paramau;
    if (paramau != null)
    {
      paramau = a.j.b.a.c.d.a.c.a.b(paramh, paramau.ecM());
      if (paramau != null) {
        break label54;
      }
    }
    for (;;)
    {
      paramb = a(paramb, locala, false, paramh, a.a.CbU, paramb1);
      AppMethodBeat.o(120176);
      return paramb;
      label54:
      paramh = paramau;
    }
  }
  
  private static h h(a.j.b.a.c.b.a.c paramc)
  {
    AppMethodBeat.i(120171);
    a.j.b.a.c.i.b.f localf = a.j.b.a.c.i.c.a.m(paramc);
    paramc = localf;
    if (!(localf instanceof a.j.b.a.c.i.b.i)) {
      paramc = null;
    }
    paramc = (a.j.b.a.c.i.b.i)paramc;
    if (paramc == null)
    {
      paramc = new h(g.ChA);
      AppMethodBeat.o(120171);
      return paramc;
    }
    paramc = paramc.CwH.name;
    switch (paramc.hashCode())
    {
    }
    do
    {
      do
      {
        do
        {
          AppMethodBeat.o(120171);
          return null;
        } while (!paramc.equals("MAYBE"));
        for (;;)
        {
          paramc = new h(g.Chz);
          AppMethodBeat.o(120171);
          return paramc;
          if (!paramc.equals("NEVER")) {
            break;
          }
        }
      } while (!paramc.equals("UNKNOWN"));
      paramc = new h(g.ChB);
      AppMethodBeat.o(120171);
      return paramc;
    } while (!paramc.equals("ALWAYS"));
    paramc = new h(g.ChA);
    AppMethodBeat.o(120171);
    return paramc;
  }
  
  private final h j(a.j.b.a.c.b.a.c paramc)
  {
    AppMethodBeat.i(120173);
    a.j.b.a.c.f.b localb = paramc.eee();
    if (localb == null)
    {
      AppMethodBeat.o(120173);
      return null;
    }
    if (q.efx().contains(localb))
    {
      paramc = new h(g.Chz);
      AppMethodBeat.o(120173);
      return paramc;
    }
    if (q.efA().contains(localb))
    {
      paramc = new h(g.ChA);
      AppMethodBeat.o(120173);
      return paramc;
    }
    if (a.f.b.j.e(localb, q.efy()))
    {
      paramc = h(paramc);
      AppMethodBeat.o(120173);
      return paramc;
    }
    if ((a.f.b.j.e(localb, q.efB())) && (this.CbS.CES))
    {
      paramc = new h(g.Chz);
      AppMethodBeat.o(120173);
      return paramc;
    }
    if ((a.f.b.j.e(localb, q.efC())) && (this.CbS.CES))
    {
      paramc = new h(g.ChA);
      AppMethodBeat.o(120173);
      return paramc;
    }
    if (a.f.b.j.e(localb, q.efE()))
    {
      paramc = new h(g.ChA, true);
      AppMethodBeat.o(120173);
      return paramc;
    }
    if (a.f.b.j.e(localb, q.efD()))
    {
      paramc = new h(g.Chz, true);
      AppMethodBeat.o(120173);
      return paramc;
    }
    AppMethodBeat.o(120173);
    return null;
  }
  
  public final <D extends a.j.b.a.c.b.b> Collection<D> a(a.j.b.a.c.d.a.c.h paramh, Collection<? extends D> paramCollection)
  {
    AppMethodBeat.i(120174);
    a.f.b.j.q(paramh, "c");
    a.f.b.j.q(paramCollection, "platformSignatures");
    Object localObject = (Iterable)paramCollection;
    paramCollection = (Collection)new ArrayList(a.a.j.d((Iterable)localObject));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      paramCollection.add(a((a.j.b.a.c.b.b)((Iterator)localObject).next(), paramh));
    }
    paramh = (Collection)paramCollection;
    AppMethodBeat.o(120174);
    return paramh;
  }
  
  public final h i(a.j.b.a.c.b.a.c paramc)
  {
    AppMethodBeat.i(120172);
    a.f.b.j.q(paramc, "annotationDescriptor");
    Object localObject = j(paramc);
    if (localObject != null)
    {
      AppMethodBeat.o(120172);
      return localObject;
    }
    localObject = this.CeS.d(paramc);
    if (localObject == null)
    {
      AppMethodBeat.o(120172);
      return null;
    }
    paramc = this.CeS.f(paramc);
    if (paramc.eoX())
    {
      AppMethodBeat.o(120172);
      return null;
    }
    localObject = j((a.j.b.a.c.b.a.c)localObject);
    if (localObject != null)
    {
      paramc = h.a((h)localObject, paramc.eoW());
      AppMethodBeat.o(120172);
      return paramc;
    }
    AppMethodBeat.o(120172);
    return null;
  }
  
  static final class b$b
    extends k
    implements a.f.a.b<Integer, d>
  {
    b$b(r paramr, a.f.a.b paramb)
    {
      super();
    }
  }
  
  static final class b$d
    extends k
    implements a.f.a.m<List<? extends a.j.b.a.c.f.b>, T, T>
  {
    b$d(a.j.b.a.c.b.a.g paramg)
    {
      super();
    }
    
    public final <T> T b(List<a.j.b.a.c.f.b> paramList, T paramT)
    {
      AppMethodBeat.i(120153);
      a.f.b.j.q(paramList, "receiver$0");
      a.f.b.j.q(paramT, "qualifier");
      paramList = (Iterable)paramList;
      if ((!(paramList instanceof Collection)) || (!((Collection)paramList).isEmpty()))
      {
        paramList = paramList.iterator();
        if (paramList.hasNext())
        {
          a.j.b.a.c.f.b localb = (a.j.b.a.c.f.b)paramList.next();
          if (this.Cij.i(localb) != null)
          {
            i = 1;
            label84:
            if (i == 0) {
              break label104;
            }
          }
        }
      }
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label111;
        }
        AppMethodBeat.o(120153);
        return paramT;
        i = 0;
        break label84;
        label104:
        break;
      }
      label111:
      AppMethodBeat.o(120153);
      return null;
    }
  }
  
  static final class c
    extends l.a
  {
    final boolean CeA;
    
    public c(w paramw, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
    {
      super(paramBoolean2, paramBoolean3);
      AppMethodBeat.i(120165);
      this.CeA = paramBoolean1;
      AppMethodBeat.o(120165);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     a.j.b.a.c.d.a.f.l
 * JD-Core Version:    0.7.0.1
 */