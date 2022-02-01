package com.tencent.mapsdk.internal;

import android.view.animation.Interpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public final class ig
  extends ie
{
  boolean b;
  private ArrayList<ie> c;
  private HashMap<ie, e> d;
  private ArrayList<e> e;
  private ArrayList<e> f;
  private boolean g;
  private a h;
  private boolean i;
  private long j;
  private it k;
  private long l;
  
  public ig()
  {
    AppMethodBeat.i(226091);
    this.c = new ArrayList();
    this.d = new HashMap();
    this.e = new ArrayList();
    this.f = new ArrayList();
    this.g = true;
    this.h = null;
    this.b = false;
    this.i = false;
    this.j = 0L;
    this.k = null;
    this.l = -1L;
    AppMethodBeat.o(226091);
  }
  
  private b a(ie paramie)
  {
    AppMethodBeat.i(226128);
    if (paramie != null)
    {
      this.g = true;
      paramie = new b(paramie);
      AppMethodBeat.o(226128);
      return paramie;
    }
    AppMethodBeat.o(226128);
    return null;
  }
  
  private void a(Collection<ie> paramCollection)
  {
    AppMethodBeat.i(226103);
    if ((paramCollection != null) && (paramCollection.size() > 0))
    {
      this.g = true;
      Iterator localIterator = paramCollection.iterator();
      paramCollection = null;
      while (localIterator.hasNext())
      {
        ie localie = (ie)localIterator.next();
        if (paramCollection == null) {
          paramCollection = a(localie);
        } else {
          paramCollection.a(localie);
        }
      }
    }
    AppMethodBeat.o(226103);
  }
  
  private void a(List<ie> paramList)
  {
    AppMethodBeat.i(226113);
    if ((paramList != null) && (paramList.size() > 0))
    {
      this.g = true;
      if (paramList.size() == 1)
      {
        a((ie)paramList.get(0));
        AppMethodBeat.o(226113);
        return;
      }
      int m = 0;
      while (m < paramList.size() - 1)
      {
        a((ie)paramList.get(m)).b((ie)paramList.get(m + 1));
        m += 1;
      }
    }
    AppMethodBeat.o(226113);
  }
  
  private void a(ie... paramVarArgs)
  {
    int m = 1;
    AppMethodBeat.i(226097);
    if (paramVarArgs != null)
    {
      this.g = true;
      b localb = a(paramVarArgs[0]);
      while (m < paramVarArgs.length)
      {
        localb.a(paramVarArgs[m]);
        m += 1;
      }
    }
    AppMethodBeat.o(226097);
  }
  
  private void b(ie... paramVarArgs)
  {
    int m = 0;
    AppMethodBeat.i(226108);
    if (paramVarArgs != null)
    {
      this.g = true;
      if (paramVarArgs.length == 1)
      {
        a(paramVarArgs[0]);
        AppMethodBeat.o(226108);
        return;
      }
      while (m < paramVarArgs.length - 1)
      {
        a(paramVarArgs[m]).b(paramVarArgs[(m + 1)]);
        m += 1;
      }
    }
    AppMethodBeat.o(226108);
  }
  
  private ig c(long paramLong)
  {
    AppMethodBeat.i(226137);
    if (paramLong < 0L)
    {
      localObject = new IllegalArgumentException("duration must be a value of zero or greater");
      AppMethodBeat.o(226137);
      throw ((Throwable)localObject);
    }
    Object localObject = this.e.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((e)((Iterator)localObject).next()).a.b(paramLong);
    }
    this.l = paramLong;
    AppMethodBeat.o(226137);
    return this;
  }
  
  private ArrayList<ie> i()
  {
    AppMethodBeat.i(226122);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.e.iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(((e)localIterator.next()).a);
    }
    AppMethodBeat.o(226122);
    return localArrayList;
  }
  
  private ig j()
  {
    AppMethodBeat.i(226146);
    ig localig = (ig)super.h();
    localig.g = true;
    localig.b = false;
    localig.i = false;
    localig.c = new ArrayList();
    localig.d = new HashMap();
    localig.e = new ArrayList();
    localig.f = new ArrayList();
    HashMap localHashMap = new HashMap();
    Object localObject3 = this.e.iterator();
    Object localObject2;
    Object localObject4;
    while (((Iterator)localObject3).hasNext())
    {
      localObject1 = (e)((Iterator)localObject3).next();
      localObject2 = ((e)localObject1).a();
      localHashMap.put(localObject1, localObject2);
      localig.e.add(localObject2);
      localig.d.put(((e)localObject2).a, localObject2);
      ((e)localObject2).b = null;
      ((e)localObject2).c = null;
      ((e)localObject2).e = null;
      ((e)localObject2).d = null;
      localObject4 = ((e)localObject2).a.a;
      if (localObject4 != null)
      {
        Iterator localIterator = ((ArrayList)localObject4).iterator();
        localObject1 = null;
        while (localIterator.hasNext())
        {
          ie.a locala = (ie.a)localIterator.next();
          if ((locala instanceof a))
          {
            localObject2 = localObject1;
            if (localObject1 == null) {
              localObject2 = new ArrayList();
            }
            ((ArrayList)localObject2).add(locala);
            localObject1 = localObject2;
          }
        }
        if (localObject1 != null)
        {
          localObject1 = ((ArrayList)localObject1).iterator();
          while (((Iterator)localObject1).hasNext()) {
            ((ArrayList)localObject4).remove((ie.a)((Iterator)localObject1).next());
          }
        }
      }
    }
    Object localObject1 = this.e.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject3 = (e)((Iterator)localObject1).next();
      localObject2 = (e)localHashMap.get(localObject3);
      if (((e)localObject3).b != null)
      {
        localObject3 = ((e)localObject3).b.iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (c)((Iterator)localObject3).next();
          ((e)localObject2).a(new c((e)localHashMap.get(((c)localObject4).c), ((c)localObject4).d));
        }
      }
    }
    AppMethodBeat.o(226146);
    return localig;
  }
  
  private void k()
  {
    AppMethodBeat.i(226161);
    Object localObject1;
    int n;
    Object localObject2;
    int i2;
    if (this.g)
    {
      this.f.clear();
      localObject1 = new ArrayList();
      n = this.e.size();
      m = 0;
      while (m < n)
      {
        localObject2 = (e)this.e.get(m);
        if ((((e)localObject2).b == null) || (((e)localObject2).b.size() == 0)) {
          ((ArrayList)localObject1).add(localObject2);
        }
        m += 1;
      }
      localObject2 = new ArrayList();
      while (((ArrayList)localObject1).size() > 0)
      {
        i1 = ((ArrayList)localObject1).size();
        m = 0;
        while (m < i1)
        {
          e locale1 = (e)((ArrayList)localObject1).get(m);
          this.f.add(locale1);
          if (locale1.e != null)
          {
            i2 = locale1.e.size();
            n = 0;
            while (n < i2)
            {
              e locale2 = (e)locale1.e.get(n);
              locale2.d.remove(locale1);
              if (locale2.d.size() == 0) {
                ((ArrayList)localObject2).add(locale2);
              }
              n += 1;
            }
          }
          m += 1;
        }
        ((ArrayList)localObject1).clear();
        ((ArrayList)localObject1).addAll((Collection)localObject2);
        ((ArrayList)localObject2).clear();
      }
      this.g = false;
      if (this.f.size() != this.e.size())
      {
        localObject1 = new IllegalStateException("Circular dependencies cannot exist in AnimatorSet");
        AppMethodBeat.o(226161);
        throw ((Throwable)localObject1);
      }
      AppMethodBeat.o(226161);
      return;
    }
    int i1 = this.e.size();
    int m = 0;
    while (m < i1)
    {
      localObject1 = (e)this.e.get(m);
      if ((((e)localObject1).b != null) && (((e)localObject1).b.size() > 0))
      {
        i2 = ((e)localObject1).b.size();
        n = 0;
        while (n < i2)
        {
          localObject2 = (c)((e)localObject1).b.get(n);
          if (((e)localObject1).d == null) {
            ((e)localObject1).d = new ArrayList();
          }
          if (!((e)localObject1).d.contains(((c)localObject2).c)) {
            ((e)localObject1).d.add(((c)localObject2).c);
          }
          n += 1;
        }
      }
      ((e)localObject1).f = false;
      m += 1;
    }
    AppMethodBeat.o(226161);
  }
  
  public final void a()
  {
    int i1 = 0;
    AppMethodBeat.i(226249);
    this.b = false;
    this.i = true;
    k();
    int i2 = this.f.size();
    int m = 0;
    Object localObject2;
    Object localObject3;
    while (m < i2)
    {
      localObject1 = (e)this.f.get(m);
      localObject2 = ((e)localObject1).a.a;
      if ((localObject2 != null) && (((ArrayList)localObject2).size() > 0))
      {
        localObject2 = new ArrayList((Collection)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (ie.a)((Iterator)localObject2).next();
          if (((localObject3 instanceof d)) || ((localObject3 instanceof a))) {
            ((e)localObject1).a.b((ie.a)localObject3);
          }
        }
      }
      m += 1;
    }
    Object localObject1 = new ArrayList();
    m = 0;
    int n;
    if (m < i2)
    {
      localObject2 = (e)this.f.get(m);
      if (this.h == null) {
        this.h = new a(this);
      }
      if ((((e)localObject2).b == null) || (((e)localObject2).b.size() == 0)) {
        ((ArrayList)localObject1).add(localObject2);
      }
      for (;;)
      {
        ((e)localObject2).a.a(this.h);
        m += 1;
        break;
        int i3 = ((e)localObject2).b.size();
        n = 0;
        while (n < i3)
        {
          localObject3 = (c)((e)localObject2).b.get(n);
          ((c)localObject3).c.a.a(new d(this, (e)localObject2, ((c)localObject3).d));
          n += 1;
        }
        ((e)localObject2).c = ((ArrayList)((e)localObject2).b.clone());
      }
    }
    if (this.j <= 0L)
    {
      localObject1 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (e)((Iterator)localObject1).next();
        ((e)localObject2).a.a();
        this.c.add(((e)localObject2).a);
      }
    }
    this.k = it.b(new double[] { 0.0D, 1.0D });
    this.k.b(this.j);
    this.k.a(new if()
    {
      boolean a = false;
      
      public final void a()
      {
        this.a = true;
      }
      
      public final void b(ie paramAnonymousie)
      {
        AppMethodBeat.i(222455);
        if (!this.a)
        {
          int j = this.b.size();
          int i = 0;
          while (i < j)
          {
            paramAnonymousie = (ig.e)this.b.get(i);
            paramAnonymousie.a.a();
            ig.a(ig.this).add(paramAnonymousie.a);
            i += 1;
          }
        }
        AppMethodBeat.o(222455);
      }
    });
    this.k.a();
    if (this.a != null)
    {
      localObject1 = (ArrayList)this.a.clone();
      n = ((ArrayList)localObject1).size();
      m = 0;
      while (m < n)
      {
        ((ie.a)((ArrayList)localObject1).get(m)).a(this);
        m += 1;
      }
    }
    if ((this.e.size() == 0) && (this.j == 0L))
    {
      this.i = false;
      if (this.a != null)
      {
        localObject1 = (ArrayList)this.a.clone();
        n = ((ArrayList)localObject1).size();
        m = i1;
        while (m < n)
        {
          ((ie.a)((ArrayList)localObject1).get(m)).b(this);
          m += 1;
        }
      }
    }
    AppMethodBeat.o(226249);
  }
  
  public final void a(long paramLong)
  {
    this.j = paramLong;
  }
  
  public final void a(Interpolator paramInterpolator)
  {
    AppMethodBeat.i(226194);
    Iterator localIterator = this.e.iterator();
    while (localIterator.hasNext()) {
      ((e)localIterator.next()).a.a(paramInterpolator);
    }
    AppMethodBeat.o(226194);
  }
  
  public final void b()
  {
    AppMethodBeat.i(226200);
    this.b = true;
    Object localObject;
    Iterator localIterator;
    if (this.i)
    {
      if (this.a == null) {
        break label184;
      }
      localObject = (ArrayList)this.a.clone();
      localIterator = ((ArrayList)localObject).iterator();
      while (localIterator.hasNext()) {
        ((ie.a)localIterator.next()).a();
      }
    }
    for (;;)
    {
      if ((this.k != null) && (this.k.f())) {
        this.k.b();
      }
      while (localObject != null)
      {
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          ((ie.a)((Iterator)localObject).next()).b(this);
        }
        if (this.f.size() > 0)
        {
          localIterator = this.f.iterator();
          while (localIterator.hasNext()) {
            ((e)localIterator.next()).a.b();
          }
        }
      }
      this.i = false;
      AppMethodBeat.o(226200);
      return;
      label184:
      localObject = null;
    }
  }
  
  public final void c()
  {
    AppMethodBeat.i(226210);
    this.b = true;
    if (this.i)
    {
      Iterator localIterator;
      if (this.f.size() != this.e.size())
      {
        k();
        localIterator = this.f.iterator();
        while (localIterator.hasNext())
        {
          e locale = (e)localIterator.next();
          if (this.h == null) {
            this.h = new a(this);
          }
          locale.a.a(this.h);
        }
      }
      if (this.k != null) {
        this.k.b();
      }
      if (this.f.size() > 0)
      {
        localIterator = this.f.iterator();
        while (localIterator.hasNext()) {
          ((e)localIterator.next()).a.c();
        }
      }
      if (this.a != null)
      {
        localIterator = ((ArrayList)this.a.clone()).iterator();
        while (localIterator.hasNext()) {
          ((ie.a)localIterator.next()).b(this);
        }
      }
      this.i = false;
    }
    AppMethodBeat.o(226210);
  }
  
  public final long d()
  {
    return this.j;
  }
  
  public final long e()
  {
    return this.l;
  }
  
  public final boolean f()
  {
    AppMethodBeat.i(226218);
    Iterator localIterator = this.e.iterator();
    while (localIterator.hasNext()) {
      if (((e)localIterator.next()).a.f())
      {
        AppMethodBeat.o(226218);
        return true;
      }
    }
    AppMethodBeat.o(226218);
    return false;
  }
  
  public final boolean g()
  {
    return this.i;
  }
  
  final class a
    implements ie.a
  {
    private ig b;
    
    a(ig paramig)
    {
      this.b = paramig;
    }
    
    public final void a()
    {
      AppMethodBeat.i(221725);
      if ((!ig.this.b) && (ig.a(ig.this).size() == 0) && (ig.this.a != null))
      {
        int j = ig.this.a.size();
        int i = 0;
        while (i < j)
        {
          ((ie.a)ig.this.a.get(i)).a();
          i += 1;
        }
      }
      AppMethodBeat.o(221725);
    }
    
    public final void a(ie paramie) {}
    
    public final void b() {}
    
    public final void b(ie paramie)
    {
      AppMethodBeat.i(221739);
      paramie.b(this);
      ig.a(ig.this).remove(paramie);
      ((ig.e)ig.b(this.b).get(paramie)).f = true;
      int j;
      if (!ig.this.b)
      {
        paramie = ig.c(this.b);
        j = paramie.size();
        i = 0;
        if (i >= j) {
          break label171;
        }
        if (((ig.e)paramie.get(i)).f) {}
      }
      label171:
      for (int i = 0;; i = 1)
      {
        if (i != 0)
        {
          if (ig.this.a != null)
          {
            paramie = (ArrayList)ig.this.a.clone();
            j = paramie.size();
            i = 0;
            for (;;)
            {
              if (i < j)
              {
                ((ie.a)paramie.get(i)).b(this.b);
                i += 1;
                continue;
                i += 1;
                break;
              }
            }
          }
          ig.d(this.b);
        }
        AppMethodBeat.o(221739);
        return;
      }
    }
  }
  
  public final class b
  {
    private ig.e b;
    
    b(ie paramie)
    {
      AppMethodBeat.i(221691);
      this.b = ((ig.e)ig.b(ig.this).get(paramie));
      if (this.b == null)
      {
        this.b = new ig.e(paramie);
        ig.b(ig.this).put(paramie, this.b);
        ig.e(ig.this).add(this.b);
      }
      AppMethodBeat.o(221691);
    }
    
    private b a(long paramLong)
    {
      AppMethodBeat.i(221709);
      it localit = it.b(new double[] { 0.0D, 1.0D });
      localit.b(paramLong);
      ig.e locale = (ig.e)ig.b(ig.this).get(localit);
      Object localObject = locale;
      if (locale == null)
      {
        localObject = new ig.e(localit);
        ig.b(ig.this).put(localit, localObject);
        ig.e(ig.this).add(localObject);
      }
      localObject = new ig.c((ig.e)localObject, 1);
      this.b.a((ig.c)localObject);
      AppMethodBeat.o(221709);
      return this;
    }
    
    private b c(ie paramie)
    {
      AppMethodBeat.i(221700);
      ig.e locale2 = (ig.e)ig.b(ig.this).get(paramie);
      ig.e locale1 = locale2;
      if (locale2 == null)
      {
        locale1 = new ig.e(paramie);
        ig.b(ig.this).put(paramie, locale1);
        ig.e(ig.this).add(locale1);
      }
      paramie = new ig.c(locale1, 1);
      this.b.a(paramie);
      AppMethodBeat.o(221700);
      return this;
    }
    
    public final b a(ie paramie)
    {
      AppMethodBeat.i(221718);
      ig.e locale2 = (ig.e)ig.b(ig.this).get(paramie);
      ig.e locale1 = locale2;
      if (locale2 == null)
      {
        locale1 = new ig.e(paramie);
        ig.b(ig.this).put(paramie, locale1);
        ig.e(ig.this).add(locale1);
      }
      locale1.a(new ig.c(this.b, 0));
      AppMethodBeat.o(221718);
      return this;
    }
    
    public final b b(ie paramie)
    {
      AppMethodBeat.i(221727);
      ig.e locale2 = (ig.e)ig.b(ig.this).get(paramie);
      ig.e locale1 = locale2;
      if (locale2 == null)
      {
        locale1 = new ig.e(paramie);
        ig.b(ig.this).put(paramie, locale1);
        ig.e(ig.this).add(locale1);
      }
      locale1.a(new ig.c(this.b, 1));
      AppMethodBeat.o(221727);
      return this;
    }
  }
  
  static final class c
  {
    static final int a = 0;
    static final int b = 1;
    public ig.e c;
    public int d;
    
    public c(ig.e parame, int paramInt)
    {
      this.c = parame;
      this.d = paramInt;
    }
  }
  
  static final class d
    implements ie.a
  {
    private ig a;
    private ig.e b;
    private int c;
    
    public d(ig paramig, ig.e parame, int paramInt)
    {
      this.a = paramig;
      this.b = parame;
      this.c = paramInt;
    }
    
    private void c(ie paramie)
    {
      AppMethodBeat.i(221664);
      if (this.a.b)
      {
        AppMethodBeat.o(221664);
        return;
      }
      int j = this.b.c.size();
      int i = 0;
      ig.c localc;
      if (i < j)
      {
        localc = (ig.c)this.b.c.get(i);
        if ((localc.d == this.c) && (localc.c.a == paramie)) {
          paramie.b(this);
        }
      }
      for (paramie = localc;; paramie = null)
      {
        this.b.c.remove(paramie);
        if (this.b.c.size() == 0)
        {
          this.b.a.a();
          ig.a(this.a).add(this.b.a);
        }
        AppMethodBeat.o(221664);
        return;
        i += 1;
        break;
      }
    }
    
    public final void a() {}
    
    public final void a(ie paramie)
    {
      AppMethodBeat.i(221699);
      if (this.c == 0) {
        c(paramie);
      }
      AppMethodBeat.o(221699);
    }
    
    public final void b() {}
    
    public final void b(ie paramie)
    {
      AppMethodBeat.i(221683);
      if (this.c == 1) {
        c(paramie);
      }
      AppMethodBeat.o(221683);
    }
  }
  
  static final class e
    implements Cloneable
  {
    public ie a;
    public ArrayList<ig.c> b = null;
    public ArrayList<ig.c> c = null;
    public ArrayList<e> d = null;
    public ArrayList<e> e = null;
    public boolean f = false;
    
    public e(ie paramie)
    {
      this.a = paramie;
    }
    
    public final e a()
    {
      AppMethodBeat.i(221694);
      try
      {
        e locale = (e)super.clone();
        locale.a = this.a.h();
        AppMethodBeat.o(221694);
        return locale;
      }
      catch (CloneNotSupportedException localCloneNotSupportedException)
      {
        AssertionError localAssertionError = new AssertionError();
        AppMethodBeat.o(221694);
        throw localAssertionError;
      }
    }
    
    public final void a(ig.c paramc)
    {
      AppMethodBeat.i(221686);
      if (this.b == null)
      {
        this.b = new ArrayList();
        this.d = new ArrayList();
      }
      this.b.add(paramc);
      if (!this.d.contains(paramc.c)) {
        this.d.add(paramc.c);
      }
      paramc = paramc.c;
      if (paramc.e == null) {
        paramc.e = new ArrayList();
      }
      paramc.e.add(this);
      AppMethodBeat.o(221686);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.ig
 * JD-Core Version:    0.7.0.1
 */