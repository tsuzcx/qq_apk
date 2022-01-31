package com.tencent.mm.kernel.c;

import com.tencent.mm.sdk.platformtools.y;
import java.lang.reflect.Modifier;
import java.util.concurrent.ConcurrentHashMap;

public final class d
{
  private static final d dNb = new d();
  public ConcurrentHashMap<Class<? extends a>, c> dMZ = new ConcurrentHashMap();
  public a dNa = null;
  
  public final <T extends a> T r(Class<T> paramClass)
  {
    c localc = (c)this.dMZ.get(paramClass);
    if ((!paramClass.isInterface()) && (Modifier.isAbstract(paramClass.getModifiers()))) {
      y.w("MicroMsg.ServiceHub", "Did you call service by using the service implementation class ?? Use interface class instead!! Carl is warning u!");
    }
    for (int i = 1;; i = 0)
    {
      if (localc != null) {}
      for (paramClass = localc.EA();; paramClass = null)
      {
        if (this.dNa != null) {
          this.dNa.a(paramClass);
        }
        return paramClass;
        y.e("MicroMsg.ServiceHub", "Service(%s) not found!!! ", new Object[] { paramClass });
        if (i != 0) {
          y.e("MicroMsg.ServiceHub", "This error must cause by using implementation class to call service! Use interface instead! Understand?");
        }
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(a parama);
    
    public abstract void a(c paramc);
    
    public abstract void b(c paramc);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.kernel.c.d
 * JD-Core Version:    0.7.0.1
 */