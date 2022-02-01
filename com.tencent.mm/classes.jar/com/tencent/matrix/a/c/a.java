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
  private boolean csU = com.tencent.matrix.a.csS.csU;
  public volatile boolean cuT = false;
  public b cuU;
  
  public a(b paramb)
  {
    this.cuU = paramb;
    paramb = paramb.cvc.iterator();
    while (paramb.hasNext()) {
      ((com.tencent.matrix.a.c.a.a)paramb.next()).a(this);
    }
  }
  
  public final <T extends com.tencent.matrix.a.c.a.a> T W(Class<T> paramClass)
  {
    Iterator localIterator = this.cuU.cvc.iterator();
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
    if (this.cuU.cvb) {
      com.tencent.matrix.a.csS.b(this);
    }
  }
  
  public boolean isForeground()
  {
    return this.csU;
  }
  
  public void onForeground(boolean paramBoolean)
  {
    this.csU = paramBoolean;
    Iterator localIterator = this.cuU.cvc.iterator();
    while (localIterator.hasNext()) {
      ((com.tencent.matrix.a.c.a.a)localIterator.next()).bS(paramBoolean);
    }
  }
  
  public void start()
  {
    super.start();
    if (!this.cuT)
    {
      Iterator localIterator = this.cuU.cvc.iterator();
      while (localIterator.hasNext()) {
        ((com.tencent.matrix.a.c.a.a)localIterator.next()).Hc();
      }
      this.cuT = true;
    }
  }
  
  public void stop()
  {
    super.stop();
    if (this.cuT)
    {
      this.cuT = false;
      Iterator localIterator = this.cuU.cvc.iterator();
      while (localIterator.hasNext()) {
        ((com.tencent.matrix.a.c.a.a)localIterator.next()).Hd();
      }
    }
  }
  
  public static final class a
  {
    public a.b cuU = new a.b();
    
    public final a X(Class<? extends com.tencent.matrix.a.c.a.a> paramClass)
    {
      try
      {
        this.cuU.cvc.add(paramClass.newInstance());
        return this;
      }
      catch (Exception paramClass) {}
      return this;
    }
  }
  
  public static final class b
  {
    public a.c cuW = new b();
    public long cuX;
    public long cuY;
    public long cuZ;
    public boolean cva = false;
    public boolean cvb = false;
    public LinkedList<com.tencent.matrix.a.c.a.a> cvc = new LinkedList();
  }
  
  public static abstract interface c
  {
    public abstract void GZ();
    
    public abstract void Ha();
    
    public abstract void a(b.a parama);
    
    public abstract void a(Thread paramThread, List<c.b> paramList);
    
    public abstract void e(String paramString1, String paramString2, int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.matrix.a.c.a
 * JD-Core Version:    0.7.0.1
 */