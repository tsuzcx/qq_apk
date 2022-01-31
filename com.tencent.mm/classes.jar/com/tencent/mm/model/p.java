package com.tencent.mm.model;

import com.tencent.mm.cf.h.d;
import com.tencent.mm.kernel.api.a;
import com.tencent.mm.kernel.api.h;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public class p
  implements a, com.tencent.mm.kernel.api.c, com.tencent.mm.kernel.api.f, h, com.tencent.mm.kernel.b.c
{
  private static ConcurrentHashMap<String, p> dUQ = new ConcurrentHashMap();
  private volatile a dUM;
  private volatile Class<? extends ar> dUN;
  private volatile ar dUO;
  private volatile boolean dUP = false;
  
  public p(a parama)
  {
    this.dUM = parama;
  }
  
  public p(Class<? extends ar> paramClass)
  {
    this.dUN = paramClass;
    a(this.dUN.getName(), this);
  }
  
  public static <T extends ar> T B(Class<T> paramClass)
  {
    p localp2 = gR(paramClass.getName());
    p localp1 = localp2;
    if (localp2 == null)
    {
      localp1 = new p(paramClass);
      a(paramClass.getName(), localp1);
    }
    return localp1.Gg();
  }
  
  public static void Gh()
  {
    Iterator localIterator = dUQ.values().iterator();
    while (localIterator.hasNext()) {
      ((p)localIterator.next()).reset();
    }
  }
  
  public static p a(String paramString, p paramp)
  {
    Object localObject = (p)dUQ.putIfAbsent(paramString, paramp);
    if (localObject == null)
    {
      localObject = com.tencent.mm.kernel.a.c.DY();
      y.i("MicroMsg.CallbacksProxy", "add pending callbacks %s", new Object[] { paramp });
      ((com.tencent.mm.kernel.a.c)localObject).dLO.putIfAbsent(paramp, ((com.tencent.mm.kernel.a.c)localObject).dLO);
    }
    for (;;)
    {
      y.i("MicroMsg.CompatSubCore", "registerCompatSubCoreWithNameIfAbsent %s, %s", new Object[] { paramString, paramp });
      return paramp;
      paramp = (p)localObject;
    }
  }
  
  private ar createSubCore()
  {
    try
    {
      y.i("MicroMsg.CompatSubCore", "createSubCore(), %s %s", new Object[] { this.dUN, this.dUM });
      if (this.dUM != null) {
        return this.dUM.createSubCore();
      }
      ar localar = (ar)this.dUN.newInstance();
      return localar;
    }
    catch (InstantiationException localInstantiationException)
    {
      y.printErrStackTrace("MicroMsg.CompatSubCore", localInstantiationException, "", new Object[0]);
      throw new IllegalAccessError(localInstantiationException.getMessage());
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      y.printErrStackTrace("MicroMsg.CompatSubCore", localIllegalAccessException, "", new Object[0]);
      throw new IllegalAccessError(localIllegalAccessException.getMessage());
    }
  }
  
  public static p gR(String paramString)
  {
    p localp = (p)dUQ.get(paramString);
    if (localp == null)
    {
      y.i("MicroMsg.CompatSubCore", "compatSubCore is null by name %s", new Object[] { paramString });
      return localp;
    }
    com.tencent.mm.kernel.a.c.DY().ai(localp);
    return localp;
  }
  
  public static void hG(int paramInt)
  {
    Iterator localIterator = dUQ.values().iterator();
    while (localIterator.hasNext())
    {
      ar localar = ((p)localIterator.next()).Gg();
      if (localar != null) {
        localar.gf(paramInt);
      }
    }
  }
  
  private void reset()
  {
    try
    {
      this.dUO = null;
      this.dUP = false;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void DU()
  {
    ar localar = Gg();
    if (localar == null) {}
    while (!this.dUP) {
      return;
    }
    localar.bi(com.tencent.mm.compatible.util.f.zF());
  }
  
  public final void DV()
  {
    Gg();
  }
  
  public final ar Gg()
  {
    try
    {
      if (this.dUO == null) {
        a(createSubCore());
      }
      ar localar = this.dUO;
      return localar;
    }
    finally {}
  }
  
  public final void a(ar paramar)
  {
    try
    {
      this.dUO = paramar;
      if ((this.dUN == null) && (this.dUO != null)) {
        this.dUN = this.dUO.getClass();
      }
      return;
    }
    finally {}
  }
  
  public HashMap<Integer, h.d> collectDatabaseFactory()
  {
    ar localar = Gg();
    if (localar == null) {
      return null;
    }
    return localar.xe();
  }
  
  public void gj(String paramString) {}
  
  public void onAccountInitialized(e.c paramc)
  {
    ar localar = Gg();
    if (localar == null) {
      return;
    }
    localar.bh(paramc.dKL);
    this.dUP = true;
  }
  
  public void onAccountRelease()
  {
    ar localar = Gg();
    if (localar == null) {
      return;
    }
    localar.onAccountRelease();
  }
  
  public String toString()
  {
    return super.toString() + " " + this.dUN + " " + this.dUM + " " + this.dUO;
  }
  
  public static abstract interface a
  {
    public abstract ar createSubCore();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.model.p
 * JD-Core Version:    0.7.0.1
 */