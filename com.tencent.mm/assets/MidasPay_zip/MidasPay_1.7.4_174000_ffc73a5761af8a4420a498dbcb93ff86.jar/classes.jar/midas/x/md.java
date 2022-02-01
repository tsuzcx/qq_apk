package midas.x;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentLinkedQueue;

public class md
{
  public int a = 15000;
  public int b = 15000;
  private final ArrayList<kv> c = new ArrayList();
  private final ArrayList<kv> d = new ArrayList();
  private final ArrayList<kv> e = new ArrayList();
  private int f = 2;
  private mc g = new mc(this);
  private kn h;
  private km i;
  private final ConcurrentLinkedQueue<ko> j = new ConcurrentLinkedQueue();
  
  public md()
  {
    this.d.add(new ma());
    this.d.add(new lz());
    this.d.add(this.g);
    this.h = new kn();
    this.i = new kw();
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
    return new mb(paramky, this);
  }
  
  public void a(ko paramko)
  {
    if (paramko != null) {
      this.j.add(paramko);
    }
  }
  
  public ArrayList<kv> b()
  {
    return this.d;
  }
  
  public void b(ko paramko)
  {
    if (paramko != null) {
      this.j.remove(paramko);
    }
  }
  
  public kn c()
  {
    return this.h;
  }
  
  public km d()
  {
    return this.i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     midas.x.md
 * JD-Core Version:    0.7.0.1
 */