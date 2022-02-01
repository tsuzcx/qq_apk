package com.tencent.tencentmap.mapsdk.map;

import java.util.List;

class m
{
  t.a a = new t.a()
  {
    public void a()
    {
      if (m.a(m.this) == null) {}
      while ((m.a(m.this).b == null) || (m.a(m.this).b.a == null)) {
        return;
      }
      int j;
      synchronized (m.a(m.this).b.d)
      {
        j = m.a(m.this).b.a.size();
        if (j <= 0) {
          return;
        }
      }
      int i = 0;
      label93:
      i locali;
      if ((i < j) && (m.a(m.this) != null) && (m.a(m.this).b != null) && (m.a(m.this).b.a != null))
      {
        synchronized (m.a(m.this).b.d)
        {
          if (m.a(m.this).b.a.size() != j)
          {
            m.this.b(1);
            return;
          }
        }
        locali = (i)m.a(m.this).b.a.get(i);
        if (locali != null) {
          break label231;
        }
      }
      for (;;)
      {
        i += 1;
        break label93;
        break;
        label231:
        if (locali.m) {
          locali.c();
        }
      }
    }
  };
  t.a b = new t.a()
  {
    public void a()
    {
      if (m.a(m.this) == null) {}
      while ((m.a(m.this).b == null) || (m.a(m.this).b.a == null)) {
        return;
      }
      if (m.a(m.this).b.b != null)
      {
        ??? = null;
        synchronized (m.a(m.this).b.e)
        {
          if (m.a(m.this).b.b.size() > 0) {
            ??? = (f)m.a(m.this).b.b.remove(0);
          }
          if ((??? != null) && (q.a == q.a.c)) {
            if ((q.a((f)???)) || (m.b(m.this) >= 15)) {
              break label273;
            }
          }
        }
      }
      int j;
      for (;;)
      {
        synchronized (m.a(m.this).b.e)
        {
          m.a(m.this).b.b.add(???);
          m.this.a(1);
          m.c(m.this);
          synchronized (m.a(m.this).b.d)
          {
            j = m.a(m.this).b.a.size();
            if (j > 0) {
              break;
            }
            return;
          }
          localObject2 = finally;
          throw localObject2;
        }
        label273:
        localObject3.d();
      }
      int i = 0;
      label284:
      i locali;
      if (i < j)
      {
        synchronized (m.a(m.this).b.d)
        {
          if (m.a(m.this).b.a.size() != j)
          {
            m.this.a(1);
            return;
          }
        }
        locali = (i)m.a(m.this).b.a.get(i);
        if (locali != null) {
          break label383;
        }
      }
      for (;;)
      {
        i += 1;
        break label284;
        break;
        label383:
        locali.h();
      }
    }
  };
  private t c = null;
  private t d = null;
  private n e;
  private int f = 0;
  
  public m(n paramn)
  {
    this.e = paramn;
    this.c = new t(1, this.a);
    this.d = new t(2, this.b);
    this.c.a();
    this.d.a();
  }
  
  public void a()
  {
    this.d.b();
    this.c.c();
    this.b = null;
    this.a = null;
  }
  
  public void a(int paramInt)
  {
    if (this.e.a.d == true) {
      return;
    }
    this.d.a(paramInt);
  }
  
  public void b()
  {
    int j = this.e.b.a.size();
    int i = 0;
    if (i < j)
    {
      i locali = (i)this.e.b.a.get(i);
      if (locali == null) {}
      for (;;)
      {
        i += 1;
        break;
        locali.a();
      }
    }
  }
  
  public void b(int paramInt)
  {
    if (this.e.a.d == true) {
      return;
    }
    this.c.a(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.map.m
 * JD-Core Version:    0.7.0.1
 */