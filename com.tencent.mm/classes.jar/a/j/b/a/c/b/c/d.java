package a.j.b.a.c.b.c;

import a.f.a.b;
import a.j.b.a.c.b.a;
import a.j.b.a.c.b.a.g;
import a.j.b.a.c.b.a.g.a;
import a.j.b.a.c.b.ak;
import a.j.b.a.c.b.am;
import a.j.b.a.c.b.aq;
import a.j.b.a.c.b.ar;
import a.j.b.a.c.b.az;
import a.j.b.a.c.b.b.a;
import a.j.b.a.c.b.e;
import a.j.b.a.c.b.l;
import a.j.b.a.c.b.n;
import a.j.b.a.c.b.o;
import a.j.b.a.c.f.f;
import a.j.b.a.c.i.c;
import a.j.b.a.c.k.i;
import a.j.b.a.c.l.ad;
import a.j.b.a.c.l.an;
import a.j.b.a.c.l.au;
import a.j.b.a.c.l.av;
import a.j.b.a.c.l.ba;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public abstract class d
  extends k
  implements aq
{
  protected List<? extends ar> BYT;
  private final d.b BYU;
  protected final az BYV;
  
  public d(l paraml, g paramg, f paramf, am paramam, az paramaz)
  {
    super(paraml, paramg, paramf, paramam);
    this.BYV = paramaz;
    this.BYU = new d.b(this);
  }
  
  private aq eeL()
  {
    o localo = super.eeM();
    if (localo == null) {
      throw new a.v("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.TypeAliasDescriptor");
    }
    return (aq)localo;
  }
  
  public final <R, D> R a(n<R, D> paramn, D paramD)
  {
    a.f.b.j.q(paramn, "visitor");
    return paramn.a((aq)this, paramD);
  }
  
  public final a.j.b.a.c.b.w ecC()
  {
    return a.j.b.a.c.b.w.BWp;
  }
  
  public final az ecE()
  {
    return this.BYV;
  }
  
  public final boolean ecG()
  {
    return av.b((a.j.b.a.c.l.w)eeo(), (b)new d.a(this));
  }
  
  public final boolean ecJ()
  {
    return false;
  }
  
  public final boolean ecK()
  {
    return false;
  }
  
  public final boolean ecL()
  {
    return false;
  }
  
  public final List<ar> ecP()
  {
    List localList = this.BYT;
    if (localList == null) {
      a.f.b.j.ays("declaredTypeParametersImpl");
    }
    return localList;
  }
  
  public final an ecx()
  {
    return (an)this.BYU;
  }
  
  protected abstract i eeJ();
  
  public final Collection<af> eeK()
  {
    Object localObject1 = eeq();
    if (localObject1 == null) {
      return (Collection)a.a.v.BMx;
    }
    localObject1 = ((e)localObject1).ecA();
    a.f.b.j.p(localObject1, "classDescriptor.constructors");
    localObject1 = (Iterable)localObject1;
    Collection localCollection = (Collection)new ArrayList();
    Iterator localIterator = ((Iterable)localObject1).iterator();
    if (localIterator.hasNext())
    {
      Object localObject4 = (a.j.b.a.c.b.d)localIterator.next();
      localObject1 = ag.Cbe;
      Object localObject2 = eeJ();
      aq localaq = (aq)this;
      a.f.b.j.p(localObject4, "it");
      a.f.b.j.q(localObject2, "storageManager");
      a.f.b.j.q(localaq, "typeAliasDescriptor");
      a.f.b.j.q(localObject4, "constructor");
      localObject1 = ag.a.a(localaq);
      if (localObject1 == null) {
        localObject1 = null;
      }
      label131:
      Object localObject5;
      Object localObject3;
      for (;;)
      {
        if (localObject1 != null)
        {
          localCollection.add(localObject1);
          break;
          localObject5 = ((a.j.b.a.c.b.d)localObject4).a((au)localObject1);
          if (localObject5 == null)
          {
            localObject1 = null;
          }
          else
          {
            localObject3 = ((a.j.b.a.c.b.d)localObject4).ecM();
            Object localObject6 = ((a.j.b.a.c.b.d)localObject4).edy();
            a.f.b.j.p(localObject6, "constructor.kind");
            am localam = localaq.ecN();
            a.f.b.j.p(localam, "typeAliasDescriptor.source");
            localObject2 = new ag((i)localObject2, localaq, (a.j.b.a.c.b.d)localObject5, null, (g)localObject3, (b.a)localObject6, localam, (byte)0);
            localObject3 = p.a((a.j.b.a.c.b.t)localObject2, ((a.j.b.a.c.b.d)localObject4).edu(), (au)localObject1, false, false, null);
            if (localObject3 == null)
            {
              localObject1 = null;
            }
            else
            {
              a.f.b.j.p(localObject3, "FunctionDescriptorImpl.g…         ) ?: return null");
              localObject5 = a.j.b.a.c.l.t.ak((a.j.b.a.c.l.w)((a.j.b.a.c.b.d)localObject5).eds().eoL());
              localObject6 = localaq.edE();
              a.f.b.j.p(localObject6, "typeAliasDescriptor.defaultType");
              localObject5 = a.j.b.a.c.l.ag.b((ad)localObject5, (ad)localObject6);
              localObject6 = ((a.j.b.a.c.b.d)localObject4).edq();
              if (localObject6 == null) {
                break label410;
              }
              localObject4 = (a)localObject2;
              a.f.b.j.p(localObject6, "it");
              localObject1 = ((au)localObject1).b(((ak)localObject6).eer(), ba.CBX);
              localObject6 = g.BXx;
            }
          }
        }
      }
      label410:
      for (localObject1 = c.a((a)localObject4, (a.j.b.a.c.l.w)localObject1, g.a.eeH());; localObject1 = null)
      {
        ((ag)localObject2).a((ak)localObject1, null, localaq.ecP(), (List)localObject3, (a.j.b.a.c.l.w)localObject5, a.j.b.a.c.b.w.BWp, localaq.ecE());
        localObject1 = (af)localObject2;
        break label131;
        break;
      }
    }
    return (Collection)localCollection;
  }
  
  protected abstract List<ar> eeN();
  
  public String toString()
  {
    return "typealias " + this.BYN.name;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     a.j.b.a.c.b.c.d
 * JD-Core Version:    0.7.0.1
 */