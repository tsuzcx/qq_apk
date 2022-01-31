package a.j.b.a.c.d.a.f;

import a.aa;
import a.f.a.b;
import a.j.b.a.c.b.a.i;
import a.j.b.a.c.b.au;
import a.j.b.a.c.d.a.a.a;
import a.j.b.a.c.l.av;
import a.j.b.a.c.l.ax;
import a.j.b.a.c.l.t;
import a.j.b.a.c.l.w;
import a.o;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collection<+La.j.b.a.c.l.w;>;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

final class l$b
{
  private final a.j.b.a.c.b.a.a ChY;
  private final w ChZ;
  private final Collection<w> Cia;
  private final boolean Cib;
  private final a.j.b.a.c.d.a.c.h Cic;
  private final a.a Cid;
  
  public l$b(a.j.b.a.c.b.a.a parama, w paramw, Collection<? extends w> paramCollection, boolean paramBoolean, a.j.b.a.c.d.a.c.h paramh, a.a parama1)
  {
    AppMethodBeat.i(120164);
    this.ChY = paramw;
    this.ChZ = paramCollection;
    this.Cia = paramBoolean;
    this.Cib = paramh;
    this.Cic = parama1;
    this.Cid = localObject;
    AppMethodBeat.o(120164);
  }
  
  private static d S(w paramw)
  {
    e locale = null;
    AppMethodBeat.i(120159);
    Object localObject1;
    Object localObject2;
    w localw;
    label69:
    int i;
    if (t.ai(paramw))
    {
      localObject1 = t.aj(paramw);
      localObject1 = new o(((a.j.b.a.c.l.q)localObject1).CBm, ((a.j.b.a.c.l.q)localObject1).CBn);
      localObject2 = (w)((o)localObject1).first;
      localw = (w)((o)localObject1).second;
      localObject1 = a.j.b.a.c.a.b.c.BVe;
      if (!((w)localObject2).egH()) {
        break label143;
      }
      localObject1 = g.Chz;
      a.f.b.j.q(localObject2, "type");
      localObject2 = av.aD((w)localObject2);
      if ((localObject2 == null) || (!a.j.b.a.c.a.b.c.i((a.j.b.a.c.b.e)localObject2))) {
        break label163;
      }
      i = 1;
      label98:
      if (i == 0) {
        break label168;
      }
      locale = e.Chv;
    }
    label143:
    label163:
    label168:
    label211:
    for (;;)
    {
      paramw = new d((g)localObject1, locale, paramw.eoL() instanceof f);
      AppMethodBeat.o(120159);
      return paramw;
      localObject1 = new o(paramw, paramw);
      break;
      if (!localw.egH())
      {
        localObject1 = g.ChA;
        break label69;
      }
      localObject1 = null;
      break label69;
      i = 0;
      break label98;
      a.f.b.j.q(localw, "type");
      localObject2 = av.aD(localw);
      if ((localObject2 != null) && (a.j.b.a.c.a.b.c.h((a.j.b.a.c.b.e)localObject2))) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label211;
        }
        locale = e.Chw;
        break;
      }
    }
  }
  
  private final List<p> T(w paramw)
  {
    AppMethodBeat.i(120162);
    ArrayList localArrayList = new ArrayList(1);
    new l.b.f(localArrayList).a(paramw, this.Cic);
    paramw = (List)localArrayList;
    AppMethodBeat.o(120162);
    return paramw;
  }
  
  private final d a(w paramw, Collection<? extends w> paramCollection, d paramd, boolean paramBoolean)
  {
    AppMethodBeat.i(120163);
    Object localObject2 = (Iterable)paramCollection;
    Object localObject1 = (Collection)new ArrayList(a.a.j.d((Iterable)localObject2));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((Collection)localObject1).add(S((w)((Iterator)localObject2).next()));
    }
    List localList = (List)localObject1;
    localObject2 = (Iterable)localList;
    localObject1 = (Collection)new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = ((d)((Iterator)localObject2).next()).Chq;
      if (localObject3 != null) {
        ((Collection)localObject1).add(localObject3);
      }
    }
    Object localObject3 = a.a.j.o((Iterable)localObject1);
    localObject2 = (Iterable)localList;
    localObject1 = (Collection)new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject4 = ((d)((Iterator)localObject2).next()).Chp;
      if (localObject4 != null) {
        ((Collection)localObject1).add(localObject4);
      }
    }
    Object localObject4 = a.a.j.o((Iterable)localObject1);
    paramCollection = (Iterable)paramCollection;
    localObject2 = (Collection)new ArrayList();
    Object localObject5 = paramCollection.iterator();
    if (((Iterator)localObject5).hasNext())
    {
      paramCollection = (w)((Iterator)localObject5).next();
      a.f.b.j.q(paramCollection, "receiver$0");
      localObject1 = ax.aG(paramCollection);
      if (localObject1 != null) {
        break label730;
      }
    }
    for (;;)
    {
      paramCollection = S(paramCollection).Chp;
      if (paramCollection == null) {
        break;
      }
      ((Collection)localObject2).add(paramCollection);
      break;
      localObject5 = a.a.j.o((Iterable)localObject2);
      paramd = a(paramw, paramBoolean, paramd);
      int i;
      label372:
      label381:
      g localg;
      label402:
      label452:
      label459:
      label480:
      label488:
      int j;
      if (!paramd.Chs)
      {
        i = 1;
        if (i == 0) {
          break label638;
        }
        paramw = paramd;
        if (paramw == null) {
          break label643;
        }
        paramCollection = paramw.Chp;
        localg = paramd.Chp;
        if ((!this.Cib) || (!paramBoolean)) {
          break label648;
        }
        bool = true;
        localObject1 = n.a((Set)localObject4, paramCollection, bool);
        if (localObject1 == null) {
          break label676;
        }
        localObject2 = this.ChY;
        paramw = (w)localObject2;
        if (!(localObject2 instanceof au)) {
          paramw = null;
        }
        paramw = (au)paramw;
        if (paramw == null) {
          break label654;
        }
        paramw = paramw.eeu();
        if (paramw == null) {
          break label659;
        }
        i = 1;
        if ((i == 0) || (!paramBoolean) || (localObject1 != g.Chz)) {
          break label665;
        }
        i = 1;
        if (i != 0) {
          break label671;
        }
        paramw = (w)localObject1;
        localObject1 = (e)n.a((Set)localObject3, e.Chw, e.Chv, paramd.Chq, bool);
        if ((localg == paramCollection) && (!(a.f.b.j.e(localObject5, localObject4) ^ true))) {
          break label681;
        }
        i = 1;
        label531:
        if (!paramd.Chr)
        {
          paramCollection = (Iterable)localList;
          if (((Collection)paramCollection).isEmpty()) {
            break label687;
          }
          paramCollection = paramCollection.iterator();
          while (paramCollection.hasNext()) {
            if (((d)paramCollection.next()).Chr)
            {
              j = 1;
              label590:
              if (j == 0) {
                break label693;
              }
            }
          }
        }
      }
      label643:
      label648:
      label654:
      label659:
      label665:
      label671:
      label676:
      label681:
      label687:
      label693:
      for (paramBoolean = true;; paramBoolean = false)
      {
        if ((paramw != null) || (i == 0)) {
          break label699;
        }
        paramw = n.a(n.a((Set)localObject5, localg, bool), (e)localObject1, true, paramBoolean);
        AppMethodBeat.o(120163);
        return paramw;
        i = 0;
        break;
        label638:
        paramw = null;
        break label372;
        paramCollection = null;
        break label381;
        bool = false;
        break label402;
        paramw = null;
        break label452;
        i = 0;
        break label459;
        i = 0;
        break label480;
        paramw = null;
        break label488;
        paramw = null;
        break label488;
        i = 0;
        break label531;
        j = 0;
        break label590;
      }
      label699:
      if (paramw == null) {}
      for (boolean bool = true;; bool = false)
      {
        paramw = n.a(paramw, (e)localObject1, bool, paramBoolean);
        AppMethodBeat.o(120163);
        return paramw;
      }
      label730:
      paramCollection = (Collection<? extends w>)localObject1;
    }
  }
  
  private final d a(w paramw, boolean paramBoolean, d paramd)
  {
    g localg = null;
    AppMethodBeat.i(120160);
    Object localObject1;
    Object localObject2;
    l.b.e locale;
    if ((paramBoolean) && (this.ChY != null))
    {
      localObject1 = i.a(this.ChY.ecM(), paramw.ecM());
      localObject2 = new l.b.d((a.j.b.a.c.b.a.g)localObject1);
      locale = l.b.e.Cik;
      if (paramBoolean)
      {
        paramd = this.Cic.efL();
        if (paramd == null) {
          break label281;
        }
        paramd = paramd.b(this.Cid);
      }
      label79:
      localObject1 = (Iterable)localObject1;
      l locall = this.Cie;
      Iterator localIterator = ((Iterable)localObject1).iterator();
      while (localIterator.hasNext())
      {
        localObject1 = locall.i((a.j.b.a.c.b.a.c)localIterator.next());
        if (localObject1 != null)
        {
          label133:
          if (localObject1 != null) {
            break label314;
          }
          if ((paramd == null) || (paramd.Chp == null)) {
            break label292;
          }
          paramd = new h(paramd.Chp, paramd.Chs);
        }
      }
    }
    for (;;)
    {
      label165:
      if (paramd != null)
      {
        localObject1 = paramd.ChD;
        label175:
        localObject2 = (e)locale.h(((l.b.d)localObject2).b(a.j.b.a.c.d.a.q.efF(), e.Chv), ((l.b.d)localObject2).b(a.j.b.a.c.d.a.q.efG(), e.Chw));
        if (paramd != null) {
          localg = paramd.ChD;
        }
        if ((localg != g.ChA) || (!a.j.b.a.c.l.c.a.aE(paramw))) {
          break label303;
        }
        paramBoolean = true;
        label234:
        if ((paramd == null) || (paramd.ChE != true)) {
          break label308;
        }
      }
      label281:
      label292:
      label303:
      label308:
      for (boolean bool = true;; bool = false)
      {
        paramw = new d((g)localObject1, (e)localObject2, paramBoolean, bool);
        AppMethodBeat.o(120160);
        return paramw;
        localObject1 = paramw.ecM();
        break;
        paramd = null;
        break label79;
        localObject1 = null;
        break label133;
        paramd = null;
        break label165;
        localObject1 = null;
        break label175;
        paramBoolean = false;
        break label234;
      }
      label314:
      paramd = (d)localObject1;
    }
  }
  
  private final b<Integer, d> egM()
  {
    AppMethodBeat.i(120161);
    Object localObject2 = (Iterable)this.Cia;
    Object localObject1 = (Collection)new ArrayList(a.a.j.d((Iterable)localObject2));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((Collection)localObject1).add(T((w)((Iterator)localObject2).next()));
    }
    localObject2 = (List)localObject1;
    List localList = T(this.ChZ);
    Object localObject3;
    int i;
    label180:
    label186:
    label192:
    int j;
    label198:
    int m;
    if (this.Cib)
    {
      localObject1 = (Iterable)this.Cia;
      if ((!(localObject1 instanceof Collection)) || (!((Collection)localObject1).isEmpty()))
      {
        localObject1 = ((Iterable)localObject1).iterator();
        if (((Iterator)localObject1).hasNext())
        {
          localObject3 = (w)((Iterator)localObject1).next();
          if (!a.j.b.a.c.l.a.c.CCi.d((w)localObject3, this.ChZ))
          {
            i = 1;
            if (i == 0) {
              break label272;
            }
            i = 1;
            if (i == 0) {
              break label279;
            }
            i = 1;
            if (i == 0) {
              break label284;
            }
            j = 1;
            localObject3 = new d[j];
            m = localObject3.length;
            j = 0;
          }
        }
      }
    }
    for (;;)
    {
      if (j >= m) {
        break label455;
      }
      boolean bool;
      if (j == 0)
      {
        bool = true;
        label224:
        if ((!bool) && (i != 0)) {
          break label301;
        }
      }
      label272:
      label279:
      label284:
      label301:
      for (int k = 1;; k = 0)
      {
        if ((!aa.BMh) || (k != 0)) {
          break label306;
        }
        localObject1 = (Throwable)new AssertionError("Only head type constructors should be computed");
        AppMethodBeat.o(120161);
        throw ((Throwable)localObject1);
        i = 0;
        break label180;
        break;
        i = 0;
        break label186;
        i = 0;
        break label192;
        j = localList.size();
        break label198;
        bool = false;
        break label224;
      }
      label306:
      localObject1 = (p)localList.get(j);
      w localw = ((p)localObject1).BPZ;
      d locald = ((p)localObject1).Ciu;
      localObject1 = (Iterable)localObject2;
      Collection localCollection = (Collection)new ArrayList();
      Iterator localIterator = ((Iterable)localObject1).iterator();
      label424:
      while (localIterator.hasNext())
      {
        localObject1 = (p)a.a.j.w((List)localIterator.next(), j);
        if (localObject1 != null) {}
        for (localObject1 = ((p)localObject1).BPZ;; localObject1 = null)
        {
          if (localObject1 == null) {
            break label424;
          }
          localCollection.add(localObject1);
          break;
        }
      }
      localObject3[j] = a(localw, (Collection)(List)localCollection, locald, bool);
      j += 1;
    }
    label455:
    localObject1 = (b)new l.b.a((d[])localObject3);
    AppMethodBeat.o(120161);
    return localObject1;
  }
  
  public final l.a a(r paramr)
  {
    AppMethodBeat.i(120158);
    b localb = egM();
    if (paramr != null) {}
    boolean bool;
    for (paramr = (b)new l.b.b(paramr, localb);; paramr = null)
    {
      bool = av.b(this.ChZ, (b)l.b.c.Cii);
      w localw = this.ChZ;
      Object localObject = paramr;
      if (paramr == null) {
        localObject = localb;
      }
      paramr = s.a(localw, (b)localObject);
      if (paramr == null) {
        break;
      }
      paramr = new l.a(paramr, true, bool);
      AppMethodBeat.o(120158);
      return paramr;
    }
    paramr = new l.a(this.ChZ, false, bool);
    AppMethodBeat.o(120158);
    return paramr;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     a.j.b.a.c.d.a.f.l.b
 * JD-Core Version:    0.7.0.1
 */