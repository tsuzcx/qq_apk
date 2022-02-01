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
  private boolean cBB = com.tencent.matrix.a.cBz.cBB;
  public volatile boolean cDE = false;
  public b cDF;
  
  public a(b paramb)
  {
    this.cDF = paramb;
    paramb = paramb.cDN.iterator();
    while (paramb.hasNext()) {
      ((com.tencent.matrix.a.c.a.a)paramb.next()).a(this);
    }
  }
  
  public final <T extends com.tencent.matrix.a.c.a.a> T W(Class<T> paramClass)
  {
    Iterator localIterator = this.cDF.cDN.iterator();
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
    if (this.cDF.cDM) {
      com.tencent.matrix.a.cBz.b(this);
    }
  }
  
  public boolean isForeground()
  {
    return this.cBB;
  }
  
  public void onForeground(boolean paramBoolean)
  {
    this.cBB = paramBoolean;
    Iterator localIterator = this.cDF.cDN.iterator();
    while (localIterator.hasNext()) {
      ((com.tencent.matrix.a.c.a.a)localIterator.next()).bV(paramBoolean);
    }
  }
  
  public void start()
  {
    super.start();
    if (!this.cDE)
    {
      Iterator localIterator = this.cDF.cDN.iterator();
      while (localIterator.hasNext()) {
        ((com.tencent.matrix.a.c.a.a)localIterator.next()).Iq();
      }
      this.cDE = true;
    }
  }
  
  public void stop()
  {
    super.stop();
    if (this.cDE)
    {
      this.cDE = false;
      Iterator localIterator = this.cDF.cDN.iterator();
      while (localIterator.hasNext()) {
        ((com.tencent.matrix.a.c.a.a)localIterator.next()).Ir();
      }
    }
  }
  
  public static final class a
  {
    public a.b cDF = new a.b();
    
    public final a X(Class<? extends com.tencent.matrix.a.c.a.a> paramClass)
    {
      try
      {
        this.cDF.cDN.add(paramClass.newInstance());
        return this;
      }
      catch (Exception paramClass) {}
      return this;
    }
  }
  
  public static final class b
  {
    public a.c cDH = new b();
    public long cDI;
    public long cDJ;
    public long cDK;
    public boolean cDL = false;
    public boolean cDM = false;
    public LinkedList<com.tencent.matrix.a.c.a.a> cDN = new LinkedList();
  }
  
  public static abstract interface c
  {
    public abstract void In();
    
    public abstract void Io();
    
    public abstract void a(b.a parama);
    
    public abstract void a(Thread paramThread, List<c.b> paramList);
    
    public abstract void e(String paramString1, String paramString2, int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.matrix.a.c.a
 * JD-Core Version:    0.7.0.1
 */