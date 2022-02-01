package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.kernel.api.a;
import com.tencent.mm.kernel.api.f;
import com.tencent.mm.kernel.api.h;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storagebase.h.b;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public class u
  implements a, com.tencent.mm.kernel.api.c, f, h, com.tencent.mm.kernel.b.c
{
  private static ConcurrentHashMap<String, u> hHQ;
  private volatile a hHM;
  private volatile Class<? extends az> hHN;
  private volatile az hHO;
  private volatile boolean hHP;
  
  static
  {
    AppMethodBeat.i(42788);
    hHQ = new ConcurrentHashMap();
    AppMethodBeat.o(42788);
  }
  
  public u(a parama)
  {
    this.hHP = false;
    this.hHM = parama;
  }
  
  public u(Class<? extends az> paramClass)
  {
    AppMethodBeat.i(42773);
    this.hHP = false;
    this.hHN = paramClass;
    a(this.hHN.getName(), this);
    AppMethodBeat.o(42773);
  }
  
  public static u a(String paramString, u paramu)
  {
    AppMethodBeat.i(42777);
    u localu = (u)hHQ.putIfAbsent(paramString, paramu);
    if (localu == null) {
      com.tencent.mm.kernel.a.c.ake().bt(paramu);
    }
    for (;;)
    {
      ae.i("MicroMsg.CompatSubCore", "registerCompatSubCoreWithNameIfAbsent %s, %s %s", new Object[] { paramString, paramu, bu.fpN() });
      AppMethodBeat.o(42777);
      return paramu;
      paramu = localu;
    }
  }
  
  public static void aAA()
  {
    AppMethodBeat.i(42779);
    Iterator localIterator = hHQ.values().iterator();
    while (localIterator.hasNext()) {
      ((u)localIterator.next()).reset();
    }
    AppMethodBeat.o(42779);
  }
  
  public static <T extends az> T ap(Class<T> paramClass)
  {
    AppMethodBeat.i(42781);
    u localu2 = zJ(paramClass.getName());
    u localu1 = localu2;
    if (localu2 == null)
    {
      localu1 = new u(paramClass);
      a(paramClass.getName(), localu1);
    }
    paramClass = localu1.aAz();
    AppMethodBeat.o(42781);
    return paramClass;
  }
  
  private az createSubCore()
  {
    AppMethodBeat.i(42776);
    try
    {
      ae.i("MicroMsg.CompatSubCore", "createSubCore(), %s %s", new Object[] { this.hHN, this.hHM });
      if (this.hHM != null)
      {
        localaz = this.hHM.createSubCore();
        AppMethodBeat.o(42776);
        return localaz;
      }
      az localaz = (az)this.hHN.newInstance();
      AppMethodBeat.o(42776);
      return localaz;
    }
    catch (InstantiationException localInstantiationException)
    {
      ae.printErrStackTrace("MicroMsg.CompatSubCore", localInstantiationException, "", new Object[0]);
      IllegalAccessError localIllegalAccessError1 = new IllegalAccessError(localInstantiationException.getMessage());
      AppMethodBeat.o(42776);
      throw localIllegalAccessError1;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      ae.printErrStackTrace("MicroMsg.CompatSubCore", localIllegalAccessException, "", new Object[0]);
      IllegalAccessError localIllegalAccessError2 = new IllegalAccessError(localIllegalAccessException.getMessage());
      AppMethodBeat.o(42776);
      throw localIllegalAccessError2;
    }
  }
  
  public static void oo(int paramInt)
  {
    AppMethodBeat.i(42780);
    Iterator localIterator = hHQ.values().iterator();
    while (localIterator.hasNext())
    {
      az localaz = ((u)localIterator.next()).aAz();
      if (localaz != null) {
        localaz.clearPluginData(paramInt);
      }
    }
    AppMethodBeat.o(42780);
  }
  
  private void reset()
  {
    try
    {
      this.hHO = null;
      this.hHP = false;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static u zJ(String paramString)
  {
    AppMethodBeat.i(42778);
    u localu = (u)hHQ.get(paramString);
    if (localu == null) {
      ae.i("MicroMsg.CompatSubCore", "compatSubCore is null by name %s", new Object[] { paramString });
    }
    for (;;)
    {
      AppMethodBeat.o(42778);
      return localu;
      com.tencent.mm.kernel.a.c.ake().bs(localu);
    }
  }
  
  public final void a(az paramaz)
  {
    AppMethodBeat.i(42775);
    try
    {
      this.hHO = paramaz;
      if ((this.hHN == null) && (this.hHO != null)) {
        this.hHN = this.hHO.getClass();
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(42775);
    }
  }
  
  public final az aAz()
  {
    try
    {
      AppMethodBeat.i(42774);
      if (this.hHO == null) {
        a(createSubCore());
      }
      az localaz = this.hHO;
      AppMethodBeat.o(42774);
      return localaz;
    }
    finally {}
  }
  
  public final void ajZ()
  {
    AppMethodBeat.i(42785);
    az localaz = aAz();
    if (localaz == null)
    {
      AppMethodBeat.o(42785);
      return;
    }
    if (!this.hHP)
    {
      AppMethodBeat.o(42785);
      return;
    }
    localaz.onSdcardMount(e.abo());
    AppMethodBeat.o(42785);
  }
  
  public final void aka()
  {
    AppMethodBeat.i(42786);
    aAz();
    AppMethodBeat.o(42786);
  }
  
  public HashMap<Integer, h.b> collectDatabaseFactory()
  {
    AppMethodBeat.i(42782);
    Object localObject = aAz();
    if (localObject == null)
    {
      AppMethodBeat.o(42782);
      return null;
    }
    localObject = ((az)localObject).getBaseDBFactories();
    AppMethodBeat.o(42782);
    return localObject;
  }
  
  public void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(42783);
    az localaz = aAz();
    if (localaz == null)
    {
      AppMethodBeat.o(42783);
      return;
    }
    localaz.onAccountPostReset(paramc.gEo);
    this.hHP = true;
    AppMethodBeat.o(42783);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(42784);
    az localaz = aAz();
    if (localaz == null)
    {
      AppMethodBeat.o(42784);
      return;
    }
    localaz.onAccountRelease();
    AppMethodBeat.o(42784);
  }
  
  public String toString()
  {
    AppMethodBeat.i(42787);
    String str = super.toString() + " " + this.hHN + " " + this.hHM + " " + this.hHO;
    AppMethodBeat.o(42787);
    return str;
  }
  
  public void xK(String paramString) {}
  
  public static abstract interface a
  {
    public abstract az createSubCore();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.model.u
 * JD-Core Version:    0.7.0.1
 */