package com.tencent.matrix.a.c;

import android.app.Application;
import com.tencent.matrix.a.c.a.b.a;
import com.tencent.matrix.a.c.a.c.b;
import com.tencent.matrix.e.c;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class a
  extends com.tencent.matrix.e.b
{
  private boolean cqc = com.tencent.matrix.a.cqa.cqc;
  public volatile boolean csb = false;
  public b csc;
  
  public a(b paramb)
  {
    this.csc = paramb;
    paramb = paramb.csk.iterator();
    while (paramb.hasNext()) {
      ((com.tencent.matrix.a.c.a.a)paramb.next()).a(this);
    }
  }
  
  public final <T extends com.tencent.matrix.a.c.a.a> T W(Class<T> paramClass)
  {
    Iterator localIterator = this.csc.csk.iterator();
    while (localIterator.hasNext())
    {
      com.tencent.matrix.a.c.a.a locala = (com.tencent.matrix.a.c.a.a)localIterator.next();
      if (paramClass.isAssignableFrom(locala.getClass())) {
        return locala;
      }
    }
    return null;
  }
  
  public String getTag()
  {
    return "BatteryMonitor";
  }
  
  public void init(Application paramApplication, c paramc)
  {
    super.init(paramApplication, paramc);
    if (this.csc.csj) {
      com.tencent.matrix.a.cqa.b(this);
    }
  }
  
  public boolean isForeground()
  {
    return this.cqc;
  }
  
  public void onForeground(boolean paramBoolean)
  {
    this.cqc = paramBoolean;
    Iterator localIterator = this.csc.csk.iterator();
    while (localIterator.hasNext()) {
      ((com.tencent.matrix.a.c.a.a)localIterator.next()).bT(paramBoolean);
    }
  }
  
  public void start()
  {
    super.start();
    if (!this.csb)
    {
      Iterator localIterator = this.csc.csk.iterator();
      while (localIterator.hasNext()) {
        ((com.tencent.matrix.a.c.a.a)localIterator.next()).GN();
      }
      this.csb = true;
    }
  }
  
  public void stop()
  {
    super.stop();
    if (this.csb)
    {
      this.csb = false;
      Iterator localIterator = this.csc.csk.iterator();
      while (localIterator.hasNext()) {
        ((com.tencent.matrix.a.c.a.a)localIterator.next()).GO();
      }
    }
  }
  
  public static final class a
  {
    public a.b csc = new a.b();
    
    public final a X(Class<? extends com.tencent.matrix.a.c.a.a> paramClass)
    {
      try
      {
        this.csc.csk.add(paramClass.newInstance());
        return this;
      }
      catch (Exception paramClass) {}
      return this;
    }
  }
  
  public static final class b
  {
    public a.c cse = new b();
    public long csf;
    public long csg;
    public long csh;
    public boolean csi = false;
    public boolean csj = false;
    public LinkedList<com.tencent.matrix.a.c.a.a> csk = new LinkedList();
  }
  
  public static abstract interface c
  {
    public abstract void GK();
    
    public abstract void GL();
    
    public abstract void a(b.a parama);
    
    public abstract void a(Thread paramThread, List<c.b> paramList);
    
    public abstract void e(String paramString1, String paramString2, int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.matrix.a.c.a
 * JD-Core Version:    0.7.0.1
 */