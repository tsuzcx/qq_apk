package midas.x;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ks
{
  public int a = 15000;
  public int b = 15000;
  private final ArrayList<jk> c = new ArrayList();
  private final ArrayList<jk> d = new ArrayList();
  private final ArrayList<jk> e = new ArrayList();
  private int f = 2;
  private kr g = new kr(this);
  private jc h;
  private jb i;
  private final ConcurrentLinkedQueue<jd> j = new ConcurrentLinkedQueue();
  
  public ks()
  {
    this.d.add(new kp());
    this.d.add(new ko());
    this.d.add(this.g);
    this.h = new jc();
    this.i = new jl();
  }
  
  public ArrayList<jk> a()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(this.c);
    localArrayList.addAll(this.d);
    localArrayList.addAll(this.e);
    return localArrayList;
  }
  
  public iz a(jn paramjn)
  {
    return new kq(paramjn, this);
  }
  
  public void a(jd paramjd)
  {
    if (paramjd != null) {
      this.j.add(paramjd);
    }
  }
  
  public ArrayList<jk> b()
  {
    return this.d;
  }
  
  public void b(jd paramjd)
  {
    if (paramjd != null) {
      this.j.remove(paramjd);
    }
  }
  
  public jc c()
  {
    return this.h;
  }
  
  public jb d()
  {
    return this.i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     midas.x.ks
 * JD-Core Version:    0.7.0.1
 */