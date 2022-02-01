package midas.x;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

public class eb
  implements bb
{
  public final ArrayList<cb> a = new ArrayList();
  public final ArrayList<cb> b = new ArrayList();
  public final ArrayList<cb> c = new ArrayList();
  public ta d;
  public sa e;
  public xa f;
  public int g = 2;
  public int h = 15000;
  public int i = 15000;
  public final ConcurrentLinkedQueue<ua> j = new ConcurrentLinkedQueue();
  
  public eb(ab paramab)
  {
    ya.a = paramab;
    this.f = new xa(this);
    this.b.add(this.f);
    this.d = new ta();
    this.e = new db();
  }
  
  public qa a(fb paramfb)
  {
    return new va(this, paramfb);
  }
  
  public sa a()
  {
    return this.e;
  }
  
  public void a(int paramInt)
  {
    this.g = paramInt;
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    Iterator localIterator = this.j.iterator();
    while (localIterator.hasNext())
    {
      ua localua = (ua)localIterator.next();
      if ((localua != null) && (paramString.equals(localua.b()))) {
        localua.cancel();
      }
    }
  }
  
  public void a(cb paramcb)
  {
    if (paramcb != null) {}
    try
    {
      this.a.add(paramcb);
    }
    finally {}
  }
  
  public void a(ua paramua)
  {
    if (paramua != null) {
      this.j.add(paramua);
    }
  }
  
  public void a(wa paramwa)
  {
    if (paramwa != null) {
      this.f.a(paramwa);
    }
  }
  
  public ta b()
  {
    return this.d;
  }
  
  public void b(cb paramcb)
  {
    if (paramcb != null) {}
    try
    {
      this.c.add(paramcb);
    }
    finally {}
  }
  
  public void b(ua paramua)
  {
    if (paramua != null) {
      this.j.remove(paramua);
    }
  }
  
  public ArrayList<cb> c()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(this.a);
    localArrayList.addAll(this.b);
    localArrayList.addAll(this.c);
    return localArrayList;
  }
  
  public ArrayList<cb> d()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(this.b);
    return localArrayList;
  }
  
  public int e()
  {
    return this.g;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.eb
 * JD-Core Version:    0.7.0.1
 */