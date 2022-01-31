package a.j.b.a.c.i.e;

import a.a.v;
import a.f.a.b;
import a.j.b.a.c.b.ah;
import a.j.b.a.c.b.al;
import a.j.b.a.c.b.aw;
import a.j.b.a.c.b.l;
import a.j.b.a.c.c.a.a;
import a.j.b.a.c.f.f;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public abstract class i
  implements h
{
  public Collection<ah> a(f paramf, a parama)
  {
    a.f.b.j.q(paramf, "name");
    a.f.b.j.q(parama, "location");
    return (Collection)v.BMx;
  }
  
  public Collection<l> a(d paramd, b<? super f, Boolean> paramb)
  {
    a.f.b.j.q(paramd, "kindFilter");
    a.f.b.j.q(paramb, "nameFilter");
    return (Collection)v.BMx;
  }
  
  public Collection<al> b(f paramf, a parama)
  {
    a.f.b.j.q(paramf, "name");
    a.f.b.j.q(parama, "location");
    return (Collection)v.BMx;
  }
  
  public a.j.b.a.c.b.h c(f paramf, a parama)
  {
    a.f.b.j.q(paramf, "name");
    a.f.b.j.q(parama, "location");
    return null;
  }
  
  public void d(f paramf, a parama)
  {
    a.f.b.j.q(paramf, "name");
    a.f.b.j.q(parama, "location");
    a.f.b.j.q(paramf, "name");
    a.f.b.j.q(parama, "location");
    j localj = (j)this;
    a.f.b.j.q(paramf, "name");
    a.f.b.j.q(parama, "location");
    localj.b(paramf, parama);
  }
  
  public Set<f> eeT()
  {
    Object localObject1 = (Iterable)a(d.CxH, a.j.b.a.c.n.d.eoS());
    Collection localCollection = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      if ((localObject2 instanceof al)) {
        localCollection.add(localObject2);
      }
    }
    localObject1 = (Iterable)localCollection;
    localCollection = (Collection)new LinkedHashSet();
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext()) {
      localCollection.add(((al)((Iterator)localObject1).next()).edF());
    }
    return (Set)localCollection;
  }
  
  public Set<f> eeU()
  {
    Object localObject1 = (Iterable)a(d.CxI, a.j.b.a.c.n.d.eoS());
    Collection localCollection = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      if ((localObject2 instanceof aw)) {
        localCollection.add(localObject2);
      }
    }
    localObject1 = (Iterable)localCollection;
    localCollection = (Collection)new LinkedHashSet();
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext()) {
      localCollection.add(((aw)((Iterator)localObject1).next()).edF());
    }
    return (Set)localCollection;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     a.j.b.a.c.i.e.i
 * JD-Core Version:    0.7.0.1
 */