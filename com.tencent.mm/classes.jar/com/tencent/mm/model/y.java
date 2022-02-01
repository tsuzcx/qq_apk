package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.kernel.api.a;
import com.tencent.mm.kernel.api.f;
import com.tencent.mm.kernel.api.h;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storagebase.h.b;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public class y
  implements a, com.tencent.mm.kernel.api.c, f, h, com.tencent.mm.kernel.b.c
{
  private static ConcurrentHashMap<String, y> ojT;
  private volatile a ojP;
  private volatile Class<? extends be> ojQ;
  private volatile be ojR;
  private volatile boolean ojS;
  
  static
  {
    AppMethodBeat.i(42788);
    ojT = new ConcurrentHashMap();
    AppMethodBeat.o(42788);
  }
  
  public y(a parama)
  {
    this.ojS = false;
    this.ojP = parama;
  }
  
  public y(Class<? extends be> paramClass)
  {
    AppMethodBeat.i(42773);
    this.ojS = false;
    this.ojQ = paramClass;
    a(this.ojQ.getName(), this);
    AppMethodBeat.o(42773);
  }
  
  public static y Ix(String paramString)
  {
    AppMethodBeat.i(42778);
    y localy = (y)ojT.get(paramString);
    if (localy == null) {
      Log.i("MicroMsg.CompatSubCore", "compatSubCore is null by name %s", new Object[] { paramString });
    }
    for (;;)
    {
      AppMethodBeat.o(42778);
      return localy;
      com.tencent.mm.kernel.a.c.baR().cU(localy);
    }
  }
  
  public static y a(String paramString, y paramy)
  {
    AppMethodBeat.i(42777);
    y localy = (y)ojT.putIfAbsent(paramString, paramy);
    if (localy == null) {
      com.tencent.mm.kernel.a.c.baR().cV(paramy);
    }
    for (;;)
    {
      Log.i("MicroMsg.CompatSubCore", "registerCompatSubCoreWithNameIfAbsent %s, %s %s", new Object[] { paramString, paramy, Util.getStack() });
      AppMethodBeat.o(42777);
      return paramy;
      paramy = localy;
    }
  }
  
  public static <T extends be> T aL(Class<T> paramClass)
  {
    AppMethodBeat.i(42781);
    y localy2 = Ix(paramClass.getName());
    y localy1 = localy2;
    if (localy2 == null)
    {
      localy1 = new y(paramClass);
      a(paramClass.getName(), localy1);
    }
    paramClass = localy1.bAJ();
    AppMethodBeat.o(42781);
    return paramClass;
  }
  
  public static void bAK()
  {
    AppMethodBeat.i(42779);
    Iterator localIterator = ojT.values().iterator();
    while (localIterator.hasNext()) {
      ((y)localIterator.next()).reset();
    }
    AppMethodBeat.o(42779);
  }
  
  private be createSubCore()
  {
    AppMethodBeat.i(42776);
    try
    {
      Log.i("MicroMsg.CompatSubCore", "createSubCore(), %s %s", new Object[] { this.ojQ, this.ojP });
      if (this.ojP != null)
      {
        localbe = this.ojP.createSubCore();
        AppMethodBeat.o(42776);
        return localbe;
      }
      be localbe = (be)this.ojQ.newInstance();
      AppMethodBeat.o(42776);
      return localbe;
    }
    catch (InstantiationException localInstantiationException)
    {
      Log.printErrStackTrace("MicroMsg.CompatSubCore", localInstantiationException, "", new Object[0]);
      IllegalAccessError localIllegalAccessError1 = new IllegalAccessError(localInstantiationException.getMessage());
      AppMethodBeat.o(42776);
      throw localIllegalAccessError1;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      Log.printErrStackTrace("MicroMsg.CompatSubCore", localIllegalAccessException, "", new Object[0]);
      IllegalAccessError localIllegalAccessError2 = new IllegalAccessError(localIllegalAccessException.getMessage());
      AppMethodBeat.o(42776);
      throw localIllegalAccessError2;
    }
  }
  
  private void reset()
  {
    try
    {
      this.ojR = null;
      this.ojS = false;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static void uT(int paramInt)
  {
    AppMethodBeat.i(42780);
    Iterator localIterator = ojT.values().iterator();
    while (localIterator.hasNext())
    {
      be localbe = ((y)localIterator.next()).bAJ();
      if (localbe != null) {
        localbe.clearPluginData(paramInt);
      }
    }
    AppMethodBeat.o(42780);
  }
  
  public void FD(String paramString) {}
  
  public final void a(be parambe)
  {
    AppMethodBeat.i(42775);
    try
    {
      this.ojR = parambe;
      if ((this.ojQ == null) && (this.ojR != null)) {
        this.ojQ = this.ojR.getClass();
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(42775);
    }
  }
  
  public final be bAJ()
  {
    try
    {
      AppMethodBeat.i(42774);
      if (this.ojR == null) {
        a(createSubCore());
      }
      be localbe = this.ojR;
      AppMethodBeat.o(42774);
      return localbe;
    }
    finally {}
  }
  
  public final void baN()
  {
    AppMethodBeat.i(42785);
    be localbe = bAJ();
    if (localbe == null)
    {
      AppMethodBeat.o(42785);
      return;
    }
    if (!this.ojS)
    {
      AppMethodBeat.o(42785);
      return;
    }
    localbe.onSdcardMount(e.aPU());
    AppMethodBeat.o(42785);
  }
  
  public final void baO()
  {
    AppMethodBeat.i(42786);
    bAJ();
    AppMethodBeat.o(42786);
  }
  
  public HashMap<Integer, h.b> collectDatabaseFactory()
  {
    AppMethodBeat.i(42782);
    Object localObject = bAJ();
    if (localObject == null)
    {
      AppMethodBeat.o(42782);
      return null;
    }
    localObject = ((be)localObject).getBaseDBFactories();
    AppMethodBeat.o(42782);
    return localObject;
  }
  
  public void onAccountInitialized(f.c paramc)
  {
    AppMethodBeat.i(42783);
    be localbe = bAJ();
    if (localbe == null)
    {
      AppMethodBeat.o(42783);
      return;
    }
    localbe.onAccountPostReset(paramc.mDg);
    this.ojS = true;
    AppMethodBeat.o(42783);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(42784);
    be localbe = bAJ();
    if (localbe == null)
    {
      AppMethodBeat.o(42784);
      return;
    }
    localbe.onAccountRelease();
    AppMethodBeat.o(42784);
  }
  
  public String toString()
  {
    AppMethodBeat.i(42787);
    String str = super.toString() + " " + this.ojQ + " " + this.ojP + " " + this.ojR;
    AppMethodBeat.o(42787);
    return str;
  }
  
  public static abstract interface a
  {
    public abstract be createSubCore();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.model.y
 * JD-Core Version:    0.7.0.1
 */