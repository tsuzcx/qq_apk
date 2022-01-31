package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cg.h.d;
import com.tencent.mm.kernel.api.a;
import com.tencent.mm.kernel.api.h;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public class q
  implements a, com.tencent.mm.kernel.api.c, com.tencent.mm.kernel.api.f, h, com.tencent.mm.kernel.b.c
{
  private static ConcurrentHashMap<String, q> fkZ;
  private volatile a fkV;
  private volatile Class<? extends at> fkW;
  private volatile at fkX;
  private volatile boolean fkY;
  
  static
  {
    AppMethodBeat.i(59738);
    fkZ = new ConcurrentHashMap();
    AppMethodBeat.o(59738);
  }
  
  public q(a parama)
  {
    this.fkY = false;
    this.fkV = parama;
  }
  
  public q(Class<? extends at> paramClass)
  {
    AppMethodBeat.i(59723);
    this.fkY = false;
    this.fkW = paramClass;
    a(this.fkW.getName(), this);
    AppMethodBeat.o(59723);
  }
  
  public static <T extends at> T S(Class<T> paramClass)
  {
    AppMethodBeat.i(59731);
    q localq2 = nA(paramClass.getName());
    q localq1 = localq2;
    if (localq2 == null)
    {
      localq1 = new q(paramClass);
      a(paramClass.getName(), localq1);
    }
    paramClass = localq1.Zk();
    AppMethodBeat.o(59731);
    return paramClass;
  }
  
  public static void Zl()
  {
    AppMethodBeat.i(59729);
    Iterator localIterator = fkZ.values().iterator();
    while (localIterator.hasNext()) {
      ((q)localIterator.next()).reset();
    }
    AppMethodBeat.o(59729);
  }
  
  public static q a(String paramString, q paramq)
  {
    AppMethodBeat.i(59727);
    q localq = (q)fkZ.putIfAbsent(paramString, paramq);
    if (localq == null) {
      com.tencent.mm.kernel.a.c.RX().as(paramq);
    }
    for (;;)
    {
      ab.i("MicroMsg.CompatSubCore", "registerCompatSubCoreWithNameIfAbsent %s, %s", new Object[] { paramString, paramq });
      AppMethodBeat.o(59727);
      return paramq;
      paramq = localq;
    }
  }
  
  private at createSubCore()
  {
    AppMethodBeat.i(59726);
    try
    {
      ab.i("MicroMsg.CompatSubCore", "createSubCore(), %s %s", new Object[] { this.fkW, this.fkV });
      if (this.fkV != null)
      {
        localat = this.fkV.createSubCore();
        AppMethodBeat.o(59726);
        return localat;
      }
      at localat = (at)this.fkW.newInstance();
      AppMethodBeat.o(59726);
      return localat;
    }
    catch (InstantiationException localInstantiationException)
    {
      ab.printErrStackTrace("MicroMsg.CompatSubCore", localInstantiationException, "", new Object[0]);
      IllegalAccessError localIllegalAccessError1 = new IllegalAccessError(localInstantiationException.getMessage());
      AppMethodBeat.o(59726);
      throw localIllegalAccessError1;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      ab.printErrStackTrace("MicroMsg.CompatSubCore", localIllegalAccessException, "", new Object[0]);
      IllegalAccessError localIllegalAccessError2 = new IllegalAccessError(localIllegalAccessException.getMessage());
      AppMethodBeat.o(59726);
      throw localIllegalAccessError2;
    }
  }
  
  public static void ks(int paramInt)
  {
    AppMethodBeat.i(59730);
    Iterator localIterator = fkZ.values().iterator();
    while (localIterator.hasNext())
    {
      at localat = ((q)localIterator.next()).Zk();
      if (localat != null) {
        localat.clearPluginData(paramInt);
      }
    }
    AppMethodBeat.o(59730);
  }
  
  public static q nA(String paramString)
  {
    AppMethodBeat.i(59728);
    q localq = (q)fkZ.get(paramString);
    if (localq == null) {
      ab.i("MicroMsg.CompatSubCore", "compatSubCore is null by name %s", new Object[] { paramString });
    }
    for (;;)
    {
      AppMethodBeat.o(59728);
      return localq;
      com.tencent.mm.kernel.a.c.RX().ar(localq);
    }
  }
  
  private void reset()
  {
    try
    {
      this.fkX = null;
      this.fkY = false;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void RS()
  {
    AppMethodBeat.i(59735);
    at localat = Zk();
    if (localat == null)
    {
      AppMethodBeat.o(59735);
      return;
    }
    if (!this.fkY)
    {
      AppMethodBeat.o(59735);
      return;
    }
    localat.onSdcardMount(com.tencent.mm.compatible.util.f.Mi());
    AppMethodBeat.o(59735);
  }
  
  public final void RT()
  {
    AppMethodBeat.i(59736);
    Zk();
    AppMethodBeat.o(59736);
  }
  
  public final at Zk()
  {
    try
    {
      AppMethodBeat.i(59724);
      if (this.fkX == null) {
        a(createSubCore());
      }
      at localat = this.fkX;
      AppMethodBeat.o(59724);
      return localat;
    }
    finally {}
  }
  
  public final void a(at paramat)
  {
    AppMethodBeat.i(59725);
    try
    {
      this.fkX = paramat;
      if ((this.fkW == null) && (this.fkX != null)) {
        this.fkW = this.fkX.getClass();
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(59725);
    }
  }
  
  public HashMap<Integer, h.d> collectDatabaseFactory()
  {
    AppMethodBeat.i(59732);
    Object localObject = Zk();
    if (localObject == null)
    {
      AppMethodBeat.o(59732);
      return null;
    }
    localObject = ((at)localObject).getBaseDBFactories();
    AppMethodBeat.o(59732);
    return localObject;
  }
  
  public void mE(String paramString) {}
  
  public void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(59733);
    at localat = Zk();
    if (localat == null)
    {
      AppMethodBeat.o(59733);
      return;
    }
    localat.onAccountPostReset(paramc.eIj);
    this.fkY = true;
    AppMethodBeat.o(59733);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(59734);
    at localat = Zk();
    if (localat == null)
    {
      AppMethodBeat.o(59734);
      return;
    }
    localat.onAccountRelease();
    AppMethodBeat.o(59734);
  }
  
  public String toString()
  {
    AppMethodBeat.i(59737);
    String str = super.toString() + " " + this.fkW + " " + this.fkV + " " + this.fkX;
    AppMethodBeat.o(59737);
    return str;
  }
  
  public static abstract interface a
  {
    public abstract at createSubCore();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.model.q
 * JD-Core Version:    0.7.0.1
 */