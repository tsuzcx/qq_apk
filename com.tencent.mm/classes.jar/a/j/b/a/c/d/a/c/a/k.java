package a.j.b.a.c.d.a.c.a;

import a.a.ad;
import a.a.v;
import a.j.b.a.c.b.a.g.a;
import a.j.b.a.c.b.ah;
import a.j.b.a.c.b.ak;
import a.j.b.a.c.b.al;
import a.j.b.a.c.b.am;
import a.j.b.a.c.b.ar;
import a.j.b.a.c.b.au;
import a.j.b.a.c.b.az;
import a.j.b.a.c.b.c.ai;
import a.j.b.a.c.b.t;
import a.j.b.a.c.b.w.a;
import a.j.b.a.c.d.a.b.e;
import a.j.b.a.c.d.a.c.m;
import a.j.b.a.c.d.a.e.n;
import a.j.b.a.c.d.a.e.q;
import a.j.b.a.c.d.a.e.x;
import a.j.b.a.c.d.a.p;
import a.j.b.a.c.i.b.s;
import a.j.b.a.c.i.e.c.a;
import a.o;
import a.u;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public abstract class k
  extends a.j.b.a.c.i.e.i
{
  private final a.j.b.a.c.k.c<a.j.b.a.c.f.f, Collection<al>> BZs;
  private final a.j.b.a.c.k.c<a.j.b.a.c.f.f, List<ah>> BZt;
  private final a.j.b.a.c.k.f<Collection<a.j.b.a.c.b.l>> BZu;
  final a.j.b.a.c.d.a.c.h Cfb;
  final a.j.b.a.c.k.f<b> Cgq;
  private final a.j.b.a.c.k.f Cgr;
  private final a.j.b.a.c.k.f Cgs;
  private final a.j.b.a.c.k.f Cgt;
  
  public k(a.j.b.a.c.d.a.c.h paramh)
  {
    this.Cfb = paramh;
    this.BZu = this.Cfb.Cfj.BRT.a((a.f.a.a)new k.c(this), (List)v.BMx);
    this.Cgq = this.Cfb.Cfj.BRT.l((a.f.a.a)new k.e(this));
    this.BZs = this.Cfb.Cfj.BRT.i((a.f.a.b)new k.g(this));
    this.Cgr = this.Cfb.Cfj.BRT.l((a.f.a.a)new k.f(this));
    this.Cgs = this.Cfb.Cfj.BRT.l((a.f.a.a)new k.i(this));
    this.Cgt = this.Cfb.Cfj.BRT.l((a.f.a.a)new k.d(this));
    this.BZt = this.Cfb.Cfj.BRT.i((a.f.a.b)new k.h(this));
  }
  
  protected static k.b a(a.j.b.a.c.d.a.c.h paramh, t paramt, List<? extends a.j.b.a.c.d.a.e.y> paramList)
  {
    a.f.b.j.q(paramh, "c");
    a.f.b.j.q(paramt, "function");
    a.f.b.j.q(paramList, "jValueParameters");
    Set localSet = (Set)new LinkedHashSet();
    Object localObject1 = a.a.j.p((Iterable)paramList);
    Collection localCollection = (Collection)new ArrayList(a.a.j.d((Iterable)localObject1));
    Iterator localIterator = ((Iterable)localObject1).iterator();
    boolean bool = false;
    int j;
    a.j.b.a.c.d.a.e.y localy;
    a.j.b.a.c.b.a.g localg;
    a.j.b.a.c.d.a.c.b.a locala;
    Object localObject2;
    Object localObject3;
    if (localIterator.hasNext())
    {
      localObject1 = (a.a.y)localIterator.next();
      j = ((a.a.y)localObject1).index;
      localy = (a.j.b.a.c.d.a.e.y)((a.a.y)localObject1).value;
      localg = a.j.b.a.c.d.a.c.f.a(paramh, (a.j.b.a.c.d.a.e.d)localy);
      locala = a.j.b.a.c.d.a.c.b.d.a(a.j.b.a.c.d.a.a.l.Cek, false, null, 3);
      localObject1 = p.Cdl;
      a.f.b.j.p(localObject1, "JvmAnnotationNames.PARAMETER_NAME_FQ_NAME");
      localObject1 = localg.i((a.j.b.a.c.f.b)localObject1);
      if (localObject1 != null)
      {
        localObject2 = a.j.b.a.c.i.c.a.m((a.j.b.a.c.b.a.c)localObject1);
        if (localObject2 != null)
        {
          localObject1 = localObject2;
          if (!(localObject2 instanceof s)) {
            localObject1 = null;
          }
          localObject1 = (s)localObject1;
          if (localObject1 != null) {
            localObject1 = (String)((s)localObject1).getValue();
          }
        }
      }
      while (localy.egB())
      {
        localObject3 = localy.egs();
        localObject2 = localObject3;
        if (!(localObject3 instanceof a.j.b.a.c.d.a.e.f)) {
          localObject2 = null;
        }
        localObject2 = (a.j.b.a.c.d.a.e.f)localObject2;
        if (localObject2 == null)
        {
          throw ((Throwable)new AssertionError("Vararg parameter should be an array: ".concat(String.valueOf(localy))));
          localObject1 = null;
        }
        else
        {
          localObject2 = paramh.Cfi.a((a.j.b.a.c.d.a.e.f)localObject2, locala, true);
          localObject2 = u.F(localObject2, paramh.Cfj.BUv.eec().l((a.j.b.a.c.l.w)localObject2));
          label321:
          localObject3 = (a.j.b.a.c.l.w)((o)localObject2).first;
          localObject2 = (a.j.b.a.c.l.w)((o)localObject2).second;
          if ((!a.f.b.j.e(paramt.edF().name, "equals")) || (paramList.size() != 1) || (!a.f.b.j.e(paramh.Cfj.BUv.eec().ecm(), localObject3))) {
            break label489;
          }
          localObject1 = a.j.b.a.c.f.f.ayT("other");
        }
      }
    }
    for (;;)
    {
      a.f.b.j.p(localObject1, "if (function.name.asStri…(\"p$index\")\n            }");
      localCollection.add(new ai((a.j.b.a.c.b.a)paramt, null, j, localg, (a.j.b.a.c.f.f)localObject1, (a.j.b.a.c.l.w)localObject3, false, false, false, (a.j.b.a.c.l.w)localObject2, (am)paramh.Cfj.CeN.a((a.j.b.a.c.d.a.e.l)localy)));
      break;
      localObject2 = u.F(paramh.Cfi.a(localy.egs(), locala), null);
      break label321;
      label489:
      if (localObject1 != null)
      {
        if (((CharSequence)localObject1).length() > 0) {}
        for (int i = 1;; i = 0)
        {
          if ((i == 0) || (!localSet.add(localObject1))) {
            break label540;
          }
          localObject1 = a.j.b.a.c.f.f.ayT((String)localObject1);
          break;
        }
      }
      label540:
      localObject1 = localy.edF();
      if (localObject1 == null) {
        bool = true;
      }
      if (localObject1 == null)
      {
        localObject1 = a.j.b.a.c.f.f.ayT("p".concat(String.valueOf(j)));
        continue;
        return new k.b(a.a.j.m((Iterable)localCollection), bool);
      }
    }
  }
  
  protected static a.j.b.a.c.l.w a(q paramq, a.j.b.a.c.d.a.c.h paramh)
  {
    a.f.b.j.q(paramq, "method");
    a.f.b.j.q(paramh, "c");
    boolean bool = paramq.egt().egg();
    a.j.b.a.c.d.a.c.b.a locala = a.j.b.a.c.d.a.c.b.d.a(a.j.b.a.c.d.a.a.l.Cek, bool, null, 2);
    return paramh.Cfi.a(paramq.egu(), locala);
  }
  
  private static boolean a(n paramn)
  {
    return (paramn.egx()) && (paramn.isStatic());
  }
  
  protected final e a(q paramq)
  {
    a.f.b.j.q(paramq, "method");
    Object localObject1 = a.j.b.a.c.d.a.c.f.a(this.Cfb, (a.j.b.a.c.d.a.e.d)paramq);
    e locale = e.a(efT(), (a.j.b.a.c.b.a.g)localObject1, paramq.edF(), (am)this.Cfb.Cfj.CeN.a((a.j.b.a.c.d.a.e.l)paramq));
    a.f.b.j.p(locale, "JavaMethodDescriptor.cre….source(method)\n        )");
    a.j.b.a.c.d.a.c.h localh = a.j.b.a.c.d.a.c.a.a(this.Cfb, (a.j.b.a.c.b.l)locale, (x)paramq, 0);
    Object localObject2 = (Iterable)paramq.edr();
    localObject1 = (Collection)new ArrayList(a.a.j.d((Iterable)localObject2));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (a.j.b.a.c.d.a.e.w)((Iterator)localObject2).next();
      localObject3 = localh.Cfk.a((a.j.b.a.c.d.a.e.w)localObject3);
      if (localObject3 == null) {
        a.f.b.j.ebi();
      }
      ((Collection)localObject1).add(localObject3);
    }
    localObject1 = (List)localObject1;
    localObject2 = a(localh, (t)locale, paramq.edu());
    Object localObject3 = a(paramq, (List)localObject1, a(paramq, localh), ((k.b)localObject2).Cgv);
    localObject1 = ((k.a)localObject3).Ceg;
    boolean bool1;
    if (localObject1 != null)
    {
      Object localObject4 = (a.j.b.a.c.b.a)locale;
      Object localObject5 = a.j.b.a.c.b.a.g.BXx;
      localObject1 = a.j.b.a.c.i.c.a((a.j.b.a.c.b.a)localObject4, (a.j.b.a.c.l.w)localObject1, g.a.eeH());
      localObject4 = edq();
      localObject5 = ((k.a)localObject3).BWy;
      List localList = ((k.a)localObject3).Ceh;
      a.j.b.a.c.l.w localw = ((k.a)localObject3).CaW;
      Object localObject6 = a.j.b.a.c.b.w.BWu;
      boolean bool2 = paramq.egw();
      if (paramq.egx()) {
        break label434;
      }
      bool1 = true;
      label312:
      localObject6 = w.a.ap(bool2, bool1);
      az localaz = paramq.ecE();
      if (((k.a)localObject3).Ceg == null) {
        break label439;
      }
      paramq = ad.a(u.F(e.Ceo, a.a.j.fQ(((k.b)localObject2).Cgv)));
      label354:
      locale.a((ak)localObject1, (ak)localObject4, (List)localObject5, localList, localw, (a.j.b.a.c.b.w)localObject6, localaz, paramq);
      locale.aq(((k.a)localObject3).BZO, ((k.b)localObject2).Cgw);
      if (((Collection)((k.a)localObject3).Cgu).isEmpty()) {
        break label446;
      }
    }
    label434:
    label439:
    label446:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        localh.Cfj.CeI.efK();
      }
      return locale;
      localObject1 = null;
      break;
      bool1 = false;
      break label312;
      paramq = ad.emptyMap();
      break label354;
    }
  }
  
  protected abstract k.a a(q paramq, List<? extends ar> paramList, a.j.b.a.c.l.w paramw, List<? extends au> paramList1);
  
  public Collection<ah> a(a.j.b.a.c.f.f paramf, a.j.b.a.c.c.a.a parama)
  {
    a.f.b.j.q(paramf, "name");
    a.f.b.j.q(parama, "location");
    if (!eeU().contains(paramf)) {
      return (Collection)v.BMx;
    }
    return (Collection)this.BZt.S(paramf);
  }
  
  public Collection<a.j.b.a.c.b.l> a(a.j.b.a.c.i.e.d paramd, a.f.a.b<? super a.j.b.a.c.f.f, Boolean> paramb)
  {
    a.f.b.j.q(paramd, "kindFilter");
    a.f.b.j.q(paramb, "nameFilter");
    return (Collection)this.BZu.invoke();
  }
  
  protected final List<a.j.b.a.c.b.l> a(a.j.b.a.c.i.e.d paramd, a.f.a.b<? super a.j.b.a.c.f.f, Boolean> paramb, a.j.b.a.c.c.a.a parama)
  {
    a.f.b.j.q(paramd, "kindFilter");
    a.f.b.j.q(paramb, "nameFilter");
    a.f.b.j.q(parama, "location");
    LinkedHashSet localLinkedHashSet = new LinkedHashSet();
    Object localObject = a.j.b.a.c.i.e.d.CxM;
    a.j.b.a.c.f.f localf;
    if (paramd.VQ(a.j.b.a.c.i.e.d.eoi()))
    {
      localObject = c(paramd, paramb).iterator();
      while (((Iterator)localObject).hasNext())
      {
        localf = (a.j.b.a.c.f.f)((Iterator)localObject).next();
        if (((Boolean)paramb.S(localf)).booleanValue()) {
          a.j.b.a.c.n.a.b((Collection)localLinkedHashSet, c(localf, parama));
        }
      }
    }
    localObject = a.j.b.a.c.i.e.d.CxM;
    if ((paramd.VQ(a.j.b.a.c.i.e.d.eof())) && (!paramd.Cxo.contains(c.a.Cxl)))
    {
      localObject = b(paramd, paramb).iterator();
      while (((Iterator)localObject).hasNext())
      {
        localf = (a.j.b.a.c.f.f)((Iterator)localObject).next();
        if (((Boolean)paramb.S(localf)).booleanValue()) {
          localLinkedHashSet.addAll(b(localf, parama));
        }
      }
    }
    localObject = a.j.b.a.c.i.e.d.CxM;
    if ((paramd.VQ(a.j.b.a.c.i.e.d.eog())) && (!paramd.Cxo.contains(c.a.Cxl)))
    {
      paramd = a(paramd).iterator();
      while (paramd.hasNext())
      {
        localObject = (a.j.b.a.c.f.f)paramd.next();
        if (((Boolean)paramb.S(localObject)).booleanValue()) {
          localLinkedHashSet.addAll(a((a.j.b.a.c.f.f)localObject, parama));
        }
      }
    }
    return a.a.j.m((Iterable)localLinkedHashSet);
  }
  
  protected abstract Set<a.j.b.a.c.f.f> a(a.j.b.a.c.i.e.d paramd);
  
  protected abstract void a(a.j.b.a.c.f.f paramf, Collection<ah> paramCollection);
  
  protected abstract void a(Collection<al> paramCollection, a.j.b.a.c.f.f paramf);
  
  protected boolean a(e parame)
  {
    a.f.b.j.q(parame, "receiver$0");
    return true;
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
  
  protected abstract Set<a.j.b.a.c.f.f> b(a.j.b.a.c.i.e.d paramd, a.f.a.b<? super a.j.b.a.c.f.f, Boolean> paramb);
  
  protected abstract Set<a.j.b.a.c.f.f> c(a.j.b.a.c.i.e.d paramd, a.f.a.b<? super a.j.b.a.c.f.f, Boolean> paramb);
  
  protected abstract ak edq();
  
  public final Set<a.j.b.a.c.f.f> eeT()
  {
    return (Set)a.j.b.a.c.k.h.a(this.Cgr, eOJ[0]);
  }
  
  public final Set<a.j.b.a.c.f.f> eeU()
  {
    return (Set)a.j.b.a.c.k.h.a(this.Cgs, eOJ[1]);
  }
  
  protected abstract b efS();
  
  protected abstract a.j.b.a.c.b.l efT();
  
  public String toString()
  {
    return "Lazy scope for " + efT();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     a.j.b.a.c.d.a.c.a.k
 * JD-Core Version:    0.7.0.1
 */