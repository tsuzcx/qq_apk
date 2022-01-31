package a.j.b.a.c.i.e;

import a.a.v;
import a.f.a.b;
import a.f.b.j;
import a.j.b.a.c.b.ah;
import a.j.b.a.c.b.al;
import a.j.b.a.c.b.l;
import a.j.b.a.c.b.t;
import a.j.b.a.c.k.h;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public abstract class e
  extends i
{
  private final a.j.b.a.c.k.f CxN;
  protected final a.j.b.a.c.b.e CxO;
  
  public e(a.j.b.a.c.k.i parami, a.j.b.a.c.b.e parame)
  {
    this.CxO = parame;
    this.CxN = parami.l((a.f.a.a)new e.a(this));
  }
  
  private final List<l> eok()
  {
    return (List)h.a(this.CxN, eOJ[0]);
  }
  
  public final Collection<ah> a(a.j.b.a.c.f.f paramf, a.j.b.a.c.c.a.a parama)
  {
    j.q(paramf, "name");
    j.q(parama, "location");
    Object localObject1 = (Iterable)eok();
    parama = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = ((Iterator)localObject1).next();
      if ((localObject2 instanceof ah)) {
        parama.add(localObject2);
      }
    }
    localObject1 = (Iterable)parama;
    parama = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = ((Iterator)localObject1).next();
      if (j.e(((ah)localObject2).edF(), paramf)) {
        parama.add(localObject2);
      }
    }
    return (Collection)parama;
  }
  
  public final Collection<l> a(d paramd, b<? super a.j.b.a.c.f.f, Boolean> paramb)
  {
    j.q(paramd, "kindFilter");
    j.q(paramb, "nameFilter");
    if (!paramd.VQ(d.CxB.Cxn)) {
      return (Collection)v.BMx;
    }
    return (Collection)eok();
  }
  
  public final Collection<al> b(a.j.b.a.c.f.f paramf, a.j.b.a.c.c.a.a parama)
  {
    j.q(paramf, "name");
    j.q(parama, "location");
    Object localObject1 = (Iterable)eok();
    parama = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = ((Iterator)localObject1).next();
      if ((localObject2 instanceof al)) {
        parama.add(localObject2);
      }
    }
    localObject1 = (Iterable)parama;
    parama = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = ((Iterator)localObject1).next();
      if (j.e(((al)localObject2).edF(), paramf)) {
        parama.add(localObject2);
      }
    }
    return (Collection)parama;
  }
  
  protected abstract List<t> ecV();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     a.j.b.a.c.i.e.e
 * JD-Core Version:    0.7.0.1
 */