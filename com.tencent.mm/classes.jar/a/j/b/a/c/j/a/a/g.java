package a.j.b.a.c.j.a.a;

import a.a.ad;
import a.a.v;
import a.f.a.b;
import a.j.b.a.c.b.ah;
import a.j.b.a.c.b.al;
import a.j.b.a.c.b.aq;
import a.j.b.a.c.b.e;
import a.j.b.a.c.b.l;
import a.j.b.a.c.e.a.ab;
import a.j.b.a.c.e.a.o;
import a.j.b.a.c.e.a.u;
import a.j.b.a.c.g.q;
import a.j.b.a.c.j.a.r;
import a.j.b.a.c.k.c;
import a.y;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public abstract class g
  extends a.j.b.a.c.i.e.i
{
  private final c<a.j.b.a.c.f.f, Collection<al>> BZs;
  private final c<a.j.b.a.c.f.f, Collection<ah>> BZt;
  private final Map<a.j.b.a.c.f.f, byte[]> CAb;
  private final Map<a.j.b.a.c.f.f, byte[]> CAc;
  private final Map<a.j.b.a.c.f.f, byte[]> CAd;
  private final a.j.b.a.c.k.d<a.j.b.a.c.f.f, aq> CAe;
  private final a.j.b.a.c.k.f CAf;
  private final a.j.b.a.c.k.f CAg;
  private final a.j.b.a.c.k.f Cgr;
  final a.j.b.a.c.j.a.k CyY;
  
  protected g(a.j.b.a.c.j.a.k paramk, Collection<a.o> paramCollection, Collection<a.u> paramCollection1, Collection<a.ab> paramCollection2, a.f.a.a<? extends Collection<a.j.b.a.c.f.f>> parama)
  {
    this.CyY = paramk;
    paramk = (Iterable)paramCollection;
    Object localObject1 = (Map)new LinkedHashMap();
    Object localObject2 = paramk.iterator();
    Object localObject3;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = ((Iterator)localObject2).next();
      paramk = (q)localObject3;
      a.j.b.a.c.f.f localf = r.b(this.CyY.BOc, ((a.o)paramk).ClT);
      paramCollection = ((Map)localObject1).get(localf);
      paramk = paramCollection;
      if (paramCollection == null)
      {
        paramk = new ArrayList();
        ((Map)localObject1).put(localf, paramk);
      }
      ((List)paramk).add(localObject3);
    }
    this.CAb = bb((Map)localObject1);
    paramk = (Iterable)paramCollection1;
    paramCollection1 = (Map)new LinkedHashMap();
    localObject1 = paramk.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = ((Iterator)localObject1).next();
      paramk = (q)localObject2;
      localObject3 = r.b(this.CyY.BOc, ((a.u)paramk).ClT);
      paramCollection = paramCollection1.get(localObject3);
      paramk = paramCollection;
      if (paramCollection == null)
      {
        paramk = new ArrayList();
        paramCollection1.put(localObject3, paramk);
      }
      ((List)paramk).add(localObject2);
    }
    this.CAc = bb(paramCollection1);
    paramk = (Iterable)paramCollection2;
    paramCollection1 = (Map)new LinkedHashMap();
    paramCollection2 = paramk.iterator();
    while (paramCollection2.hasNext())
    {
      localObject1 = paramCollection2.next();
      paramk = (q)localObject1;
      localObject2 = r.b(this.CyY.BOc, ((a.ab)paramk).ClT);
      paramCollection = paramCollection1.get(localObject2);
      paramk = paramCollection;
      if (paramCollection == null)
      {
        paramk = new ArrayList();
        paramCollection1.put(localObject2, paramk);
      }
      ((List)paramk).add(localObject1);
    }
    this.CAd = bb(paramCollection1);
    this.BZs = this.CyY.CiZ.BRT.i((b)new g.e(this));
    this.BZt = this.CyY.CiZ.BRT.i((b)new g.f(this));
    this.CAe = this.CyY.CiZ.BRT.j((b)new g.g(this));
    this.Cgr = this.CyY.CiZ.BRT.l((a.f.a.a)new d(this));
    this.CAf = this.CyY.CiZ.BRT.l((a.f.a.a)new g.h(this));
    this.CAg = this.CyY.CiZ.BRT.l((a.f.a.a)new g.a(parama));
  }
  
  private final e C(a.j.b.a.c.f.f paramf)
  {
    return this.CyY.CiZ.i(A(paramf));
  }
  
  private final void a(Collection<l> paramCollection, a.j.b.a.c.i.e.d paramd, b<? super a.j.b.a.c.f.f, Boolean> paramb, a.j.b.a.c.c.a.a parama)
  {
    Object localObject1 = a.j.b.a.c.i.e.d.CxM;
    Object localObject2;
    if (paramd.VQ(a.j.b.a.c.i.e.d.eog()))
    {
      localObject2 = (Collection)eeU();
      localObject1 = new ArrayList();
      localObject2 = ((Collection)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (a.j.b.a.c.f.f)((Iterator)localObject2).next();
        if (((Boolean)paramb.S(localObject3)).booleanValue()) {
          ((ArrayList)localObject1).addAll(a((a.j.b.a.c.f.f)localObject3, parama));
        }
      }
      localObject2 = (List)localObject1;
      Object localObject3 = a.j.b.a.c.i.g.a.CvZ;
      a.f.b.j.p(localObject3, "MemberComparator.NameAnd…MemberComparator.INSTANCE");
      a.a.j.a((List)localObject2, (Comparator)localObject3);
      paramCollection.addAll((Collection)localObject1);
    }
    localObject1 = a.j.b.a.c.i.e.d.CxM;
    if (paramd.VQ(a.j.b.a.c.i.e.d.eof()))
    {
      localObject1 = (Collection)eeT();
      paramd = new ArrayList();
      localObject1 = ((Collection)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (a.j.b.a.c.f.f)((Iterator)localObject1).next();
        if (((Boolean)paramb.S(localObject2)).booleanValue()) {
          paramd.addAll(b((a.j.b.a.c.f.f)localObject2, parama));
        }
      }
      paramb = (List)paramd;
      parama = a.j.b.a.c.i.g.a.CvZ;
      a.f.b.j.p(parama, "MemberComparator.NameAnd…MemberComparator.INSTANCE");
      a.a.j.a(paramb, (Comparator)parama);
      paramCollection.addAll((Collection)paramd);
    }
  }
  
  private static Map<a.j.b.a.c.f.f, byte[]> bb(Map<a.j.b.a.c.f.f, ? extends Collection<? extends a.j.b.a.c.g.a>> paramMap)
  {
    Map localMap = (Map)new LinkedHashMap(ad.TQ(paramMap.size()));
    paramMap = ((Iterable)paramMap.entrySet()).iterator();
    while (paramMap.hasNext())
    {
      Object localObject2 = paramMap.next();
      Object localObject1 = ((Map.Entry)localObject2).getKey();
      Object localObject3 = (Map.Entry)localObject2;
      localObject2 = new ByteArrayOutputStream();
      Object localObject4 = (Iterable)((Map.Entry)localObject3).getValue();
      localObject3 = (Collection)new ArrayList(a.a.j.d((Iterable)localObject4));
      localObject4 = ((Iterable)localObject4).iterator();
      while (((Iterator)localObject4).hasNext())
      {
        ((a.j.b.a.c.g.a)((Iterator)localObject4).next()).d((OutputStream)localObject2);
        ((Collection)localObject3).add(y.BMg);
      }
      localMap.put(localObject1, ((ByteArrayOutputStream)localObject2).toByteArray());
    }
    return localMap;
  }
  
  private final Set<a.j.b.a.c.f.f> eoy()
  {
    return this.CAd.keySet();
  }
  
  protected abstract a.j.b.a.c.f.a A(a.j.b.a.c.f.f paramf);
  
  protected boolean D(a.j.b.a.c.f.f paramf)
  {
    a.f.b.j.q(paramf, "name");
    return eoz().contains(paramf);
  }
  
  public Collection<ah> a(a.j.b.a.c.f.f paramf, a.j.b.a.c.c.a.a parama)
  {
    a.f.b.j.q(paramf, "name");
    a.f.b.j.q(parama, "location");
    if (!eeU().contains(paramf)) {
      return (Collection)v.BMx;
    }
    return (Collection)this.BZt.S(paramf);
  }
  
  protected void a(a.j.b.a.c.f.f paramf, Collection<ah> paramCollection)
  {
    a.f.b.j.q(paramf, "name");
    a.f.b.j.q(paramCollection, "descriptors");
  }
  
  public Collection<al> b(a.j.b.a.c.f.f paramf, a.j.b.a.c.c.a.a parama)
  {
    a.f.b.j.q(paramf, "name");
    a.f.b.j.q(parama, "location");
    if (!eeT().contains(paramf)) {
      return (Collection)v.BMx;
    }
    return (Collection)this.BZs.S(paramf);
  }
  
  protected final Collection<l> b(a.j.b.a.c.i.e.d paramd, b<? super a.j.b.a.c.f.f, Boolean> paramb, a.j.b.a.c.c.a.a parama)
  {
    a.f.b.j.q(paramd, "kindFilter");
    a.f.b.j.q(paramb, "nameFilter");
    a.f.b.j.q(parama, "location");
    ArrayList localArrayList = new ArrayList(0);
    Object localObject = a.j.b.a.c.i.e.d.CxM;
    if (paramd.VQ(a.j.b.a.c.i.e.d.eoc())) {
      c((Collection)localArrayList, paramb);
    }
    a((Collection)localArrayList, paramd, paramb, parama);
    parama = a.j.b.a.c.i.e.d.CxM;
    if (paramd.VQ(a.j.b.a.c.i.e.d.eoi()))
    {
      parama = eoz().iterator();
      while (parama.hasNext())
      {
        localObject = (a.j.b.a.c.f.f)parama.next();
        if (((Boolean)paramb.S(localObject)).booleanValue()) {
          a.j.b.a.c.n.a.b((Collection)localArrayList, C((a.j.b.a.c.f.f)localObject));
        }
      }
    }
    parama = a.j.b.a.c.i.e.d.CxM;
    if (paramd.VQ(a.j.b.a.c.i.e.d.eod()))
    {
      paramd = eoy().iterator();
      while (paramd.hasNext())
      {
        parama = (a.j.b.a.c.f.f)paramd.next();
        if (((Boolean)paramb.S(parama)).booleanValue()) {
          a.j.b.a.c.n.a.b((Collection)localArrayList, this.CAe.S(parama));
        }
      }
    }
    return (Collection)a.j.b.a.c.n.a.av(localArrayList);
  }
  
  protected void b(a.j.b.a.c.f.f paramf, Collection<al> paramCollection)
  {
    a.f.b.j.q(paramf, "name");
    a.f.b.j.q(paramCollection, "functions");
  }
  
  public a.j.b.a.c.b.h c(a.j.b.a.c.f.f paramf, a.j.b.a.c.c.a.a parama)
  {
    a.f.b.j.q(paramf, "name");
    a.f.b.j.q(parama, "location");
    if (D(paramf)) {
      return (a.j.b.a.c.b.h)C(paramf);
    }
    if (eoy().contains(paramf)) {
      return (a.j.b.a.c.b.h)this.CAe.S(paramf);
    }
    return null;
  }
  
  protected abstract void c(Collection<l> paramCollection, b<? super a.j.b.a.c.f.f, Boolean> paramb);
  
  public final Set<a.j.b.a.c.f.f> eeT()
  {
    return (Set)a.j.b.a.c.k.h.a(this.Cgr, eOJ[0]);
  }
  
  public final Set<a.j.b.a.c.f.f> eeU()
  {
    return (Set)a.j.b.a.c.k.h.a(this.CAf, eOJ[1]);
  }
  
  protected abstract Set<a.j.b.a.c.f.f> eow();
  
  protected abstract Set<a.j.b.a.c.f.f> eox();
  
  public final Set<a.j.b.a.c.f.f> eoz()
  {
    return (Set)a.j.b.a.c.k.h.a(this.CAg, eOJ[2]);
  }
  
  static final class d
    extends a.f.b.k
    implements a.f.a.a<Set<? extends a.j.b.a.c.f.f>>
  {
    d(g paramg)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     a.j.b.a.c.j.a.a.g
 * JD-Core Version:    0.7.0.1
 */