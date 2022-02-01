package com.tencent.mapsdk.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class fu<T extends a>
{
  private static final int c = 50;
  private static final int e = 40;
  private final fk a;
  private final int b;
  private Set<T> d;
  private List<fu<T>> f = null;
  
  private fu(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4)
  {
    this(new fk(paramDouble1, paramDouble2, paramDouble3, paramDouble4));
    AppMethodBeat.i(221965);
    AppMethodBeat.o(221965);
  }
  
  private fu(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, int paramInt)
  {
    this(new fk(paramDouble1, paramDouble2, paramDouble3, paramDouble4), paramInt);
    AppMethodBeat.i(221979);
    AppMethodBeat.o(221979);
  }
  
  public fu(fk paramfk)
  {
    this(paramfk, 0);
  }
  
  private fu(fk paramfk, int paramInt)
  {
    this.a = paramfk;
    this.b = paramInt;
  }
  
  private void a()
  {
    AppMethodBeat.i(222009);
    this.f = new ArrayList(4);
    this.f.add(new fu(this.a.a, this.a.e, this.a.b, this.a.f, this.b + 1));
    this.f.add(new fu(this.a.e, this.a.c, this.a.b, this.a.f, this.b + 1));
    this.f.add(new fu(this.a.a, this.a.e, this.a.f, this.a.d, this.b + 1));
    this.f.add(new fu(this.a.e, this.a.c, this.a.f, this.a.d, this.b + 1));
    Object localObject = this.d;
    this.d = null;
    localObject = ((Set)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      a locala = (a)((Iterator)localObject).next();
      a(locala.a().a, locala.a().b, locala);
    }
    AppMethodBeat.o(222009);
  }
  
  private void a(double paramDouble1, double paramDouble2, T paramT)
  {
    AppMethodBeat.i(222000);
    fu localfu = this;
    while (localfu.f != null) {
      if (paramDouble2 < localfu.a.f)
      {
        if (paramDouble1 < localfu.a.e) {
          localfu = (fu)localfu.f.get(0);
        } else {
          localfu = (fu)localfu.f.get(1);
        }
      }
      else if (paramDouble1 < localfu.a.e) {
        localfu = (fu)localfu.f.get(2);
      } else {
        localfu = (fu)localfu.f.get(3);
      }
    }
    if (localfu.d == null) {
      localfu.d = new HashSet();
    }
    localfu.d.add(paramT);
    if ((localfu.d.size() > 50) && (localfu.b < 40)) {
      localfu.a();
    }
    AppMethodBeat.o(222000);
  }
  
  private void a(fk paramfk, Collection<T> paramCollection)
  {
    AppMethodBeat.i(222054);
    if (!this.a.a(paramfk))
    {
      AppMethodBeat.o(222054);
      return;
    }
    Object localObject;
    if (this.f != null)
    {
      localObject = this.f.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((fu)((Iterator)localObject).next()).a(paramfk, paramCollection);
      }
      AppMethodBeat.o(222054);
      return;
    }
    if (this.d != null)
    {
      localObject = this.a;
      if ((((fk)localObject).a >= paramfk.a) && (((fk)localObject).c <= paramfk.c) && (((fk)localObject).b >= paramfk.b) && (((fk)localObject).d <= paramfk.d)) {}
      for (int i = 1; i != 0; i = 0)
      {
        paramCollection.addAll(this.d);
        AppMethodBeat.o(222054);
        return;
      }
      localObject = this.d.iterator();
      while (((Iterator)localObject).hasNext())
      {
        a locala = (a)((Iterator)localObject).next();
        fl localfl = locala.a();
        if (paramfk.a(localfl.a, localfl.b)) {
          paramCollection.add(locala);
        }
      }
    }
    AppMethodBeat.o(222054);
  }
  
  private void b()
  {
    AppMethodBeat.i(222040);
    this.f = null;
    if (this.d != null) {
      this.d.clear();
    }
    AppMethodBeat.o(222040);
  }
  
  private boolean b(double paramDouble1, double paramDouble2, T paramT)
  {
    AppMethodBeat.i(222033);
    fu localfu = this;
    while (localfu.f != null) {
      if (paramDouble2 < localfu.a.f)
      {
        if (paramDouble1 < localfu.a.e) {
          localfu = (fu)localfu.f.get(0);
        } else {
          localfu = (fu)localfu.f.get(1);
        }
      }
      else if (paramDouble1 < localfu.a.e) {
        localfu = (fu)localfu.f.get(2);
      } else {
        localfu = (fu)localfu.f.get(3);
      }
    }
    if (localfu.d == null)
    {
      AppMethodBeat.o(222033);
      return false;
    }
    boolean bool = localfu.d.remove(paramT);
    AppMethodBeat.o(222033);
    return bool;
  }
  
  private boolean b(T paramT)
  {
    AppMethodBeat.i(222021);
    Object localObject = paramT.a();
    if (this.a.a(((fl)localObject).a, ((fl)localObject).b))
    {
      double d1 = ((fl)localObject).a;
      double d2 = ((fl)localObject).b;
      localObject = this;
      while (((fu)localObject).f != null) {
        if (d2 < ((fu)localObject).a.f)
        {
          if (d1 < ((fu)localObject).a.e) {
            localObject = (fu)((fu)localObject).f.get(0);
          } else {
            localObject = (fu)((fu)localObject).f.get(1);
          }
        }
        else if (d1 < ((fu)localObject).a.e) {
          localObject = (fu)((fu)localObject).f.get(2);
        } else {
          localObject = (fu)((fu)localObject).f.get(3);
        }
      }
      if (((fu)localObject).d == null)
      {
        AppMethodBeat.o(222021);
        return false;
      }
      boolean bool = ((fu)localObject).d.remove(paramT);
      AppMethodBeat.o(222021);
      return bool;
    }
    AppMethodBeat.o(222021);
    return false;
  }
  
  public final Collection<T> a(fk paramfk)
  {
    AppMethodBeat.i(222070);
    ArrayList localArrayList = new ArrayList();
    a(paramfk, localArrayList);
    AppMethodBeat.o(222070);
    return localArrayList;
  }
  
  public final void a(T paramT)
  {
    AppMethodBeat.i(222061);
    fl localfl = paramT.a();
    if (this.a.a(localfl.a, localfl.b)) {
      a(localfl.a, localfl.b, paramT);
    }
    AppMethodBeat.o(222061);
  }
  
  public static abstract interface a
  {
    public abstract fl a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mapsdk.internal.fu
 * JD-Core Version:    0.7.0.1
 */