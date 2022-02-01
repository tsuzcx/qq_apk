package midas.x;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

public class jm
{
  public int a = 15000;
  public int b = 15000;
  private final ArrayList<jk> c = new ArrayList();
  private final ArrayList<jk> d = new ArrayList();
  private final ArrayList<jk> e = new ArrayList();
  private jc f;
  private jb g;
  private jg h;
  private int i = 2;
  private final ConcurrentLinkedQueue<jd> j = new ConcurrentLinkedQueue();
  
  public jm(jj paramjj)
  {
    jh.a = paramjj;
    this.h = new jg(this);
    this.d.add(this.h);
    this.f = new jc();
    this.g = new jl();
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
    return new je(this, paramjn);
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
      jd localjd = (jd)localIterator.next();
      if ((localjd != null) && (paramString.equals(localjd.b()))) {
        localjd.a();
      }
    }
  }
  
  public void a(jd paramjd)
  {
    if (paramjd != null) {
      this.j.add(paramjd);
    }
  }
  
  public void a(jf paramjf)
  {
    if (paramjf != null) {
      this.h.a(paramjf);
    }
  }
  
  public void a(jk paramjk)
  {
    if (paramjk != null) {}
    try
    {
      this.c.add(paramjk);
    }
    finally {}
  }
  
  public ArrayList<jk> b()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(this.d);
    return localArrayList;
  }
  
  public void b(jd paramjd)
  {
    if (paramjd != null) {
      this.j.remove(paramjd);
    }
  }
  
  public void b(jk paramjk)
  {
    if (paramjk != null) {}
    try
    {
      this.e.add(paramjk);
    }
    finally {}
  }
  
  public int c()
  {
    return this.i;
  }
  
  public jc d()
  {
    return this.f;
  }
  
  public jb e()
  {
    return this.g;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     midas.x.jm
 * JD-Core Version:    0.7.0.1
 */