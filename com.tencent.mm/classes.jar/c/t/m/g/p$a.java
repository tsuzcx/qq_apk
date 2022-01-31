package c.t.m.g;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class p$a
{
  String a;
  String b;
  private String c;
  private List<n> d;
  private List<n> e;
  private List<n> f;
  private List<n> g;
  
  public p$a(String paramString)
  {
    this.c = paramString;
  }
  
  public final List<n> a()
  {
    ArrayList localArrayList = new ArrayList();
    List localList = this.d;
    if ((localList != null) && (localList.size() > 0)) {
      localArrayList.addAll(localList);
    }
    localList = this.e;
    if ((localList != null) && (localList.size() > 0)) {
      localArrayList.addAll(localList);
    }
    localList = this.f;
    if ((localList != null) && (localList.size() > 0)) {
      localArrayList.addAll(localList);
    }
    localList = this.g;
    if ((localList != null) && (localList.size() > 0)) {
      localArrayList.addAll(localList);
    }
    return localArrayList;
  }
  
  public final void a(n paramn)
  {
    if (paramn == null) {
      return;
    }
    if (paramn.e == 1)
    {
      if (this.d == null) {
        this.d = new ArrayList();
      }
      this.d.add(paramn);
      return;
    }
    if (paramn.e == 2)
    {
      if (this.e == null) {
        this.e = new ArrayList();
      }
      this.e.add(paramn);
      return;
    }
    if (paramn.e == 3)
    {
      if (this.f == null) {
        this.f = new ArrayList();
      }
      this.f.add(paramn);
      return;
    }
    if (paramn.e == 4)
    {
      if (this.g == null) {
        this.g = new ArrayList();
      }
      this.g.add(paramn);
      return;
    }
    if (this.d == null) {
      this.d = new ArrayList();
    }
    this.d.add(paramn);
  }
  
  public final void b(n paramn)
  {
    if (paramn == null) {}
    for (;;)
    {
      return;
      try
      {
        if (paramn.e == 1)
        {
          if ((this.d == null) || (this.d.isEmpty()) || (!paramn.a((n)this.d.get(0)))) {
            continue;
          }
          this.d.remove(0);
          continue;
        }
      }
      finally {}
      if ((paramn.e == 2) && (this.e != null) && (!this.e.isEmpty()) && (paramn.a((n)this.e.get(0)))) {
        this.e.remove(0);
      }
    }
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Appid：" + null + " domain：" + this.a + "\r\n");
    localStringBuilder.append("apn：" + this.c + " ckIP：" + null + "\r\n");
    Iterator localIterator = a().iterator();
    while (localIterator.hasNext())
    {
      n localn = (n)localIterator.next();
      localStringBuilder.append("accessIP：" + localn.toString() + "\r\n");
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     c.t.m.g.p.a
 * JD-Core Version:    0.7.0.1
 */