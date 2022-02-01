package com.tencent.mapsdk.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;

public final class y
  implements ba, ns
{
  public static final int a = 60;
  private static final int l = 200;
  public ArrayList<iu> b;
  public final byte[] c;
  public a d;
  public int e;
  ix f;
  long g;
  boolean h;
  fh i;
  private ArrayList<iu> j;
  private ArrayList<iu> k;
  
  public y(ix paramix)
  {
    AppMethodBeat.i(223136);
    this.b = new ArrayList();
    this.c = new byte[0];
    this.j = new ArrayList();
    this.k = new ArrayList();
    this.e = 60;
    this.f = paramix;
    it.d(c());
    AppMethodBeat.o(223136);
  }
  
  private void a(double paramDouble1, double paramDouble2)
  {
    AppMethodBeat.i(223192);
    synchronized (this.c)
    {
      while ((!this.b.isEmpty()) && (((iu)this.b.get(this.b.size() - 1)).z == 3))
      {
        iu localiu = (iu)this.b.remove(this.b.size() - 1);
        paramDouble1 += localiu.A[0];
        paramDouble2 += localiu.A[1];
      }
      a(new iu(3, new double[] { paramDouble1, paramDouble2 }));
      AppMethodBeat.o(223192);
      return;
    }
  }
  
  private void a(fh paramfh)
  {
    this.i = paramfh;
  }
  
  private void b(int paramInt)
  {
    AppMethodBeat.i(223200);
    for (;;)
    {
      int m;
      synchronized (this.c)
      {
        m = this.b.size() - 1;
        if (m >= 0)
        {
          iu localiu = (iu)this.b.get(m);
          if (localiu.z == paramInt)
          {
            this.b.remove(m);
            localiu.b();
          }
        }
        else
        {
          AppMethodBeat.o(223200);
          return;
        }
      }
      m -= 1;
    }
  }
  
  private void h()
  {
    AppMethodBeat.i(223145);
    if (this.d != null) {
      this.d.destroy();
    }
    this.d = new a();
    this.d.start();
    AppMethodBeat.o(223145);
  }
  
  private void i()
  {
    AppMethodBeat.i(223153);
    if (this.d != null) {
      this.d.destroy();
    }
    AppMethodBeat.o(223153);
  }
  
  private void j()
  {
    this.e = 60;
  }
  
  private int k()
  {
    return this.e;
  }
  
  private void l()
  {
    if (this.d == null) {}
  }
  
  public final void a()
  {
    AppMethodBeat.i(223247);
    if (this.d != null) {
      this.d.a();
    }
    e();
    AppMethodBeat.o(223247);
  }
  
  public final void a(int paramInt)
  {
    if (paramInt <= 0) {
      return;
    }
    this.e = paramInt;
  }
  
  public final void a(iu paramiu)
  {
    AppMethodBeat.i(223288);
    synchronized (this.c)
    {
      if (this.b.size() > 200) {
        this.b.clear();
      }
      this.b.add(paramiu);
      AppMethodBeat.o(223288);
      return;
    }
  }
  
  public final void a(v paramv)
  {
    AppMethodBeat.i(223333);
    this.h = true;
    this.g = System.currentTimeMillis();
    AppMethodBeat.o(223333);
  }
  
  public final void b()
  {
    AppMethodBeat.i(223261);
    if (this.d != null) {
      this.d.b();
    }
    AppMethodBeat.o(223261);
  }
  
  public final long c()
  {
    long l2 = 1000L / this.e;
    long l1 = l2;
    if (l2 == 0L) {
      l1 = 1L;
    }
    return l1;
  }
  
  public final void d() {}
  
  public final void e()
  {
    AppMethodBeat.i(223304);
    int m;
    for (;;)
    {
      iu localiu;
      synchronized (this.c)
      {
        this.k.clear();
        this.j.clear();
        Iterator localIterator = this.b.iterator();
        m = 0;
        if (!localIterator.hasNext()) {
          break;
        }
        localiu = (iu)localIterator.next();
        if (localiu.D)
        {
          m = 1;
          this.j.add(localiu);
        }
      }
      this.k.add(localiu);
    }
    this.b.clear();
    Object localObject2;
    if (m != 0)
    {
      localObject2 = this.b;
      this.b = this.j;
      this.j = ((ArrayList)localObject2);
    }
    if (this.k.size() > 0)
    {
      localObject2 = this.k.iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((iu)((Iterator)localObject2).next()).b();
      }
    }
    AppMethodBeat.o(223304);
  }
  
  public final boolean f()
  {
    AppMethodBeat.i(223311);
    synchronized (this.c)
    {
      if (!this.b.isEmpty())
      {
        bool = true;
        AppMethodBeat.o(223311);
        return bool;
      }
      boolean bool = false;
    }
  }
  
  public final boolean g()
  {
    AppMethodBeat.i(223323);
    synchronized (this.c)
    {
      if (this.b.isEmpty())
      {
        AppMethodBeat.o(223323);
        return false;
      }
      iu localiu = (iu)this.b.get(0);
      if ((localiu != null) && (localiu.a(this.f))) {
        synchronized (this.c)
        {
          this.b.remove(localiu);
        }
      }
    }
    synchronized (this.c)
    {
      boolean bool = this.b.isEmpty();
      if (!bool)
      {
        AppMethodBeat.o(223323);
        return true;
        localObject1 = finally;
        AppMethodBeat.o(223323);
        throw localObject1;
        localObject2 = finally;
        AppMethodBeat.o(223323);
        throw localObject2;
      }
    }
    AppMethodBeat.o(223323);
    return false;
  }
  
  public final class a
    extends Thread
  {
    private boolean b;
    private boolean c;
    
    public a()
    {
      super();
    }
    
    public final void a()
    {
      try
      {
        this.c = true;
        return;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
    
    public final void b()
    {
      try
      {
        this.c = false;
        return;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
    
    public final void destroy()
    {
      try
      {
        AppMethodBeat.i(222663);
        this.b = false;
        interrupt();
        AppMethodBeat.o(222663);
        return;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
    
    public final void run()
    {
      AppMethodBeat.i(222675);
      for (;;)
      {
        if (this.b)
        {
          if (!this.c)
          {
            if (y.this.f != null) {
              y.this.f.c(iu.G);
            }
            if ((y.this.h) && (System.currentTimeMillis() - y.this.g > 50L))
            {
              y.this.h = false;
              kh.b("TDZ", "notify onStable");
              if (y.this.i != null) {
                y.this.i.u();
              }
            }
          }
          try
          {
            try
            {
              wait(y.this.c());
              continue;
            }
            finally
            {
              localObject = finally;
              AppMethodBeat.o(222675);
              throw localObject;
            }
            AppMethodBeat.o(222675);
          }
          catch (InterruptedException localInterruptedException)
          {
            Thread.currentThread().interrupt();
          }
        }
      }
    }
    
    public final void start()
    {
      try
      {
        AppMethodBeat.i(222645);
        this.b = true;
        super.start();
        AppMethodBeat.o(222645);
        return;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.y
 * JD-Core Version:    0.7.0.1
 */