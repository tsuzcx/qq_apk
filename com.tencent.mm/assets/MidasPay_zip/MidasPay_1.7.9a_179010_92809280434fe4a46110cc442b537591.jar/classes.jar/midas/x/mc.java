package midas.x;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentLinkedQueue;

public class mc
  implements bb
{
  public final ArrayList<cb> a = new ArrayList();
  public final ArrayList<cb> b = new ArrayList();
  public final ArrayList<cb> c = new ArrayList();
  public int d = 15000;
  public int e = 15000;
  public lc f = new lc(this);
  public ta g;
  public sa h;
  public final ConcurrentLinkedQueue<ua> i = new ConcurrentLinkedQueue();
  
  public mc()
  {
    this.b.add(new jc());
    this.b.add(new ic());
    this.b.add(this.f);
    this.g = new ta();
    this.h = new db();
  }
  
  public qa a(fb paramfb)
  {
    return new kc(paramfb, this);
  }
  
  public sa a()
  {
    return this.h;
  }
  
  public void a(ua paramua)
  {
    if (paramua != null) {
      this.i.add(paramua);
    }
  }
  
  public ta b()
  {
    return this.g;
  }
  
  public void b(ua paramua)
  {
    if (paramua != null) {
      this.i.remove(paramua);
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
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.mc
 * JD-Core Version:    0.7.0.1
 */