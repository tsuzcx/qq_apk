package a.j.b.a.c.n;

import TT;;
import a.a.ad;
import a.a.e;
import a.f.b.j;
import a.f.b.z;
import a.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public final class i<T>
  extends AbstractSet<T>
{
  private static final int CFk = 5;
  public static final i.b CFl;
  private Object data;
  private int size;
  
  static
  {
    AppMethodBeat.i(122972);
    CFl = new i.b((byte)0);
    CFk = 5;
    AppMethodBeat.o(122972);
  }
  
  public static final <T> i<T> epb()
  {
    AppMethodBeat.i(122973);
    i locali = i.b.epb();
    AppMethodBeat.o(122973);
    return locali;
  }
  
  public final boolean add(T paramT)
  {
    AppMethodBeat.i(122970);
    if (size() == 0) {
      this.data = paramT;
    }
    Object localObject;
    do
    {
      for (;;)
      {
        this.size = (size() + 1);
        AppMethodBeat.o(122970);
        return true;
        if (size() != 1) {
          break;
        }
        if (j.e(this.data, paramT))
        {
          AppMethodBeat.o(122970);
          return false;
        }
        this.data = new Object[] { this.data, paramT };
      }
      if (size() < CFk)
      {
        localObject = this.data;
        if (localObject == null)
        {
          paramT = new v("null cannot be cast to non-null type kotlin.Array<T>");
          AppMethodBeat.o(122970);
          throw paramT;
        }
        localObject = (Object[])localObject;
        if (e.contains((Object[])localObject, paramT))
        {
          AppMethodBeat.o(122970);
          return false;
        }
        if (size() == CFk - 1)
        {
          localObject = Arrays.copyOf((Object[])localObject, localObject.length);
          j.q(localObject, "elements");
          localObject = (LinkedHashSet)e.a((Object[])localObject, (Collection)new LinkedHashSet(ad.TQ(localObject.length)));
          ((LinkedHashSet)localObject).add(paramT);
        }
        for (paramT = (TT)localObject;; paramT = (TT)localObject)
        {
          this.data = paramT;
          break;
          localObject = Arrays.copyOf((Object[])localObject, size() + 1);
          localObject[(localObject.length - 1)] = paramT;
        }
      }
      localObject = this.data;
      if (localObject == null)
      {
        paramT = new v("null cannot be cast to non-null type kotlin.collections.MutableSet<T>");
        AppMethodBeat.o(122970);
        throw paramT;
      }
    } while (z.dm(localObject).add(paramT));
    AppMethodBeat.o(122970);
    return false;
  }
  
  public final void clear()
  {
    this.data = null;
    this.size = 0;
  }
  
  public final boolean contains(Object paramObject)
  {
    AppMethodBeat.i(122971);
    if (size() == 0)
    {
      AppMethodBeat.o(122971);
      return false;
    }
    if (size() == 1)
    {
      bool = j.e(this.data, paramObject);
      AppMethodBeat.o(122971);
      return bool;
    }
    if (size() < CFk)
    {
      localObject = this.data;
      if (localObject == null)
      {
        paramObject = new v("null cannot be cast to non-null type kotlin.Array<T>");
        AppMethodBeat.o(122971);
        throw paramObject;
      }
      bool = e.contains((Object[])localObject, paramObject);
      AppMethodBeat.o(122971);
      return bool;
    }
    Object localObject = this.data;
    if (localObject == null)
    {
      paramObject = new v("null cannot be cast to non-null type kotlin.collections.Set<T>");
      AppMethodBeat.o(122971);
      throw paramObject;
    }
    boolean bool = ((Set)localObject).contains(paramObject);
    AppMethodBeat.o(122971);
    return bool;
  }
  
  public final Iterator<T> iterator()
  {
    AppMethodBeat.i(122969);
    if (size() == 0)
    {
      localObject = Collections.emptySet().iterator();
      AppMethodBeat.o(122969);
      return localObject;
    }
    if (size() == 1)
    {
      localObject = (Iterator)new i.c(this.data);
      AppMethodBeat.o(122969);
      return localObject;
    }
    if (size() < CFk)
    {
      localObject = this.data;
      if (localObject == null)
      {
        localObject = new v("null cannot be cast to non-null type kotlin.Array<T>");
        AppMethodBeat.o(122969);
        throw ((Throwable)localObject);
      }
      localObject = (Iterator)new i.a((Object[])localObject);
      AppMethodBeat.o(122969);
      return localObject;
    }
    Object localObject = this.data;
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type kotlin.collections.MutableSet<T>");
      AppMethodBeat.o(122969);
      throw ((Throwable)localObject);
    }
    localObject = z.dm(localObject).iterator();
    AppMethodBeat.o(122969);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     a.j.b.a.c.n.i
 * JD-Core Version:    0.7.0.1
 */