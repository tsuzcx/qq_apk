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
  private boolean cAU = com.tencent.matrix.a.cAS.cAU;
  public volatile boolean cCX = false;
  public b cCY;
  
  public a(b paramb)
  {
    this.cCY = paramb;
    paramb = paramb.cDg.iterator();
    while (paramb.hasNext()) {
      ((com.tencent.matrix.a.c.a.a)paramb.next()).a(this);
    }
  }
  
  public final <T extends com.tencent.matrix.a.c.a.a> T W(Class<T> paramClass)
  {
    Iterator localIterator = this.cCY.cDg.iterator();
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
    if (this.cCY.cDf) {
      com.tencent.matrix.a.cAS.b(this);
    }
  }
  
  public boolean isForeground()
  {
    return this.cAU;
  }
  
  public void onForeground(boolean paramBoolean)
  {
    this.cAU = paramBoolean;
    Iterator localIterator = this.cCY.cDg.iterator();
    while (localIterator.hasNext()) {
      ((com.tencent.matrix.a.c.a.a)localIterator.next()).bV(paramBoolean);
    }
  }
  
  public void start()
  {
    super.start();
    if (!this.cCX)
    {
      Iterator localIterator = this.cCY.cDg.iterator();
      while (localIterator.hasNext()) {
        ((com.tencent.matrix.a.c.a.a)localIterator.next()).Ii();
      }
      this.cCX = true;
    }
  }
  
  public void stop()
  {
    super.stop();
    if (this.cCX)
    {
      this.cCX = false;
      Iterator localIterator = this.cCY.cDg.iterator();
      while (localIterator.hasNext()) {
        ((com.tencent.matrix.a.c.a.a)localIterator.next()).Ij();
      }
    }
  }
  
  public static final class a
  {
    public a.b cCY = new a.b();
    
    public final a X(Class<? extends com.tencent.matrix.a.c.a.a> paramClass)
    {
      try
      {
        this.cCY.cDg.add(paramClass.newInstance());
        return this;
      }
      catch (Exception paramClass) {}
      return this;
    }
  }
  
  public static final class b
  {
    public a.c cDa = new b();
    public long cDb;
    public long cDc;
    public long cDd;
    public boolean cDe = false;
    public boolean cDf = false;
    public LinkedList<com.tencent.matrix.a.c.a.a> cDg = new LinkedList();
  }
  
  public static abstract interface c
  {
    public abstract void If();
    
    public abstract void Ig();
    
    public abstract void a(b.a parama);
    
    public abstract void a(Thread paramThread, List<c.b> paramList);
    
    public abstract void e(String paramString1, String paramString2, int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.matrix.a.c.a
 * JD-Core Version:    0.7.0.1
 */