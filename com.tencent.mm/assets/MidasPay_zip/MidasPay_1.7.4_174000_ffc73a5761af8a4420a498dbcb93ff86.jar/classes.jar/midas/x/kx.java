package midas.x;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

public class kx
{
  public int a = 15000;
  public int b = 15000;
  private final ArrayList<kv> c = new ArrayList();
  private final ArrayList<kv> d = new ArrayList();
  private final ArrayList<kv> e = new ArrayList();
  private kn f;
  private km g;
  private kr h;
  private int i = 2;
  private final ConcurrentLinkedQueue<ko> j = new ConcurrentLinkedQueue();
  
  public kx(ku paramku)
  {
    ks.a = paramku;
    this.h = new kr(this);
    this.d.add(this.h);
    this.f = new kn();
    this.g = new kw();
  }
  
  public ArrayList<kv> a()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(this.c);
    localArrayList.addAll(this.d);
    localArrayList.addAll(this.e);
    return localArrayList;
  }
  
  public kk a(ky paramky)
  {
    return new kp(this, paramky);
  }
  
  public void a(int paramInt)
  {
    this.i = paramInt;
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    Iterator localIterator = this.j.iterator();
    while (localIterator.hasNext())
    {
      ko localko = (ko)localIterator.next();
      if ((localko != null) && (paramString.equals(localko.b()))) {
        localko.a();
      }
    }
  }
  
  public void a(ko paramko)
  {
    if (paramko != null) {
      this.j.add(paramko);
    }
  }
  
  public void a(kq paramkq)
  {
    if (paramkq != null) {
      this.h.a(paramkq);
    }
  }
  
  public void a(kv paramkv)
  {
    if (paramkv != null) {}
    try
    {
      this.c.add(paramkv);
    }
    finally {}
  }
  
  public ArrayList<kv> b()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(this.d);
    return localArrayList;
  }
  
  public void b(ko paramko)
  {
    if (paramko != null) {
      this.j.remove(paramko);
    }
  }
  
  public void b(kv paramkv)
  {
    if (paramkv != null) {}
    try
    {
      this.e.add(paramkv);
    }
    finally {}
  }
  
  public int c()
  {
    return this.i;
  }
  
  public kn d()
  {
    return this.f;
  }
  
  public km e()
  {
    return this.g;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     midas.x.kx
 * JD-Core Version:    0.7.0.1
 */