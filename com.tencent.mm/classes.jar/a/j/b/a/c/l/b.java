package a.j.b.a.c.l;

import a.j.b.a.c.a.g;
import a.j.b.a.c.b.ab;
import a.j.b.a.c.b.e;
import a.j.b.a.c.b.l;
import a.j.b.a.c.b.y;
import a.j.b.a.c.f.f;
import a.j.b.a.c.i.c.a;
import a.j.b.a.c.i.d;
import a.j.b.a.c.k.i;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public abstract class b
  extends c
  implements an
{
  private int axc = 0;
  
  public b(i parami)
  {
    super(parami);
  }
  
  private static boolean d(a.j.b.a.c.b.h paramh)
  {
    return (!p.L(paramh)) && (!d.m(paramh));
  }
  
  public abstract e ecS();
  
  protected final w eeQ()
  {
    if (g.e(ecS())) {
      return null;
    }
    return a.G(ecS()).ecl();
  }
  
  public final g eec()
  {
    return a.G(ecS());
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof an)) {
      return false;
    }
    if (paramObject.hashCode() != hashCode()) {
      return false;
    }
    if (((an)paramObject).getParameters().size() != getParameters().size()) {
      return false;
    }
    Object localObject = ecS();
    paramObject = ((an)paramObject).ecR();
    if ((!d((a.j.b.a.c.b.h)localObject)) || ((paramObject != null) && (!d(paramObject)))) {
      return false;
    }
    if ((paramObject instanceof e))
    {
      localObject = (e)localObject;
      paramObject = (e)paramObject;
      if (!((e)localObject).edF().equals(paramObject.edF())) {
        return false;
      }
      localObject = ((e)localObject).ecv();
      for (paramObject = paramObject.ecv(); (localObject != null) && (paramObject != null); paramObject = paramObject.ecv())
      {
        if ((localObject instanceof y)) {
          return paramObject instanceof y;
        }
        if ((paramObject instanceof y)) {
          return false;
        }
        if ((localObject instanceof ab))
        {
          if (((paramObject instanceof ab)) && (((ab)localObject).eee().equals(((ab)paramObject).eee()))) {
            break;
          }
          return false;
        }
        if ((paramObject instanceof ab)) {
          return false;
        }
        if (!((l)localObject).edF().equals(paramObject.edF())) {
          return false;
        }
        localObject = ((l)localObject).ecv();
      }
      return true;
    }
    return false;
  }
  
  public final int hashCode()
  {
    int i = this.axc;
    if (i != 0) {
      return i;
    }
    e locale = ecS();
    if (d(locale)) {}
    for (i = d.n(locale).hashCode();; i = System.identityHashCode(this))
    {
      this.axc = i;
      return i;
    }
  }
  
  protected final Collection<w> sI(boolean paramBoolean)
  {
    Object localObject = ecS().ecv();
    if (!(localObject instanceof e)) {
      return Collections.emptyList();
    }
    a.j.b.a.c.n.h localh = new a.j.b.a.c.n.h();
    localObject = (e)localObject;
    localh.add(((e)localObject).edE());
    localObject = ((e)localObject).ecz();
    if ((paramBoolean) && (localObject != null)) {
      localh.add(((e)localObject).edE());
    }
    return localh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     a.j.b.a.c.l.b
 * JD-Core Version:    0.7.0.1
 */