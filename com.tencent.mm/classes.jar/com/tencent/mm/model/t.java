package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.kernel.api.a;
import com.tencent.mm.kernel.api.f;
import com.tencent.mm.kernel.api.h;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storagebase.h.b;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public class t
  implements a, com.tencent.mm.kernel.api.c, f, h, com.tencent.mm.kernel.b.c
{
  private static ConcurrentHashMap<String, t> hEY;
  private volatile a hEU;
  private volatile Class<? extends ax> hEV;
  private volatile ax hEW;
  private volatile boolean hEX;
  
  static
  {
    AppMethodBeat.i(42788);
    hEY = new ConcurrentHashMap();
    AppMethodBeat.o(42788);
  }
  
  public t(a parama)
  {
    this.hEX = false;
    this.hEU = parama;
  }
  
  public t(Class<? extends ax> paramClass)
  {
    AppMethodBeat.i(42773);
    this.hEX = false;
    this.hEV = paramClass;
    a(this.hEV.getName(), this);
    AppMethodBeat.o(42773);
  }
  
  public static t a(String paramString, t paramt)
  {
    AppMethodBeat.i(42777);
    t localt = (t)hEY.putIfAbsent(paramString, paramt);
    if (localt == null) {
      com.tencent.mm.kernel.a.c.ajP().bt(paramt);
    }
    for (;;)
    {
      ad.i("MicroMsg.CompatSubCore", "registerCompatSubCoreWithNameIfAbsent %s, %s %s", new Object[] { paramString, paramt, bt.flS() });
      AppMethodBeat.o(42777);
      return paramt;
      paramt = localt;
    }
  }
  
  public static void aAk()
  {
    AppMethodBeat.i(42779);
    Iterator localIterator = hEY.values().iterator();
    while (localIterator.hasNext()) {
      ((t)localIterator.next()).reset();
    }
    AppMethodBeat.o(42779);
  }
  
  public static <T extends ax> T ap(Class<T> paramClass)
  {
    AppMethodBeat.i(42781);
    t localt2 = yZ(paramClass.getName());
    t localt1 = localt2;
    if (localt2 == null)
    {
      localt1 = new t(paramClass);
      a(paramClass.getName(), localt1);
    }
    paramClass = localt1.aAj();
    AppMethodBeat.o(42781);
    return paramClass;
  }
  
  private ax createSubCore()
  {
    AppMethodBeat.i(42776);
    try
    {
      ad.i("MicroMsg.CompatSubCore", "createSubCore(), %s %s", new Object[] { this.hEV, this.hEU });
      if (this.hEU != null)
      {
        localax = this.hEU.createSubCore();
        AppMethodBeat.o(42776);
        return localax;
      }
      ax localax = (ax)this.hEV.newInstance();
      AppMethodBeat.o(42776);
      return localax;
    }
    catch (InstantiationException localInstantiationException)
    {
      ad.printErrStackTrace("MicroMsg.CompatSubCore", localInstantiationException, "", new Object[0]);
      IllegalAccessError localIllegalAccessError1 = new IllegalAccessError(localInstantiationException.getMessage());
      AppMethodBeat.o(42776);
      throw localIllegalAccessError1;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      ad.printErrStackTrace("MicroMsg.CompatSubCore", localIllegalAccessException, "", new Object[0]);
      IllegalAccessError localIllegalAccessError2 = new IllegalAccessError(localIllegalAccessException.getMessage());
      AppMethodBeat.o(42776);
      throw localIllegalAccessError2;
    }
  }
  
  public static void ol(int paramInt)
  {
    AppMethodBeat.i(42780);
    Iterator localIterator = hEY.values().iterator();
    while (localIterator.hasNext())
    {
      ax localax = ((t)localIterator.next()).aAj();
      if (localax != null) {
        localax.clearPluginData(paramInt);
      }
    }
    AppMethodBeat.o(42780);
  }
  
  private void reset()
  {
    try
    {
      this.hEW = null;
      this.hEX = false;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static t yZ(String paramString)
  {
    AppMethodBeat.i(42778);
    t localt = (t)hEY.get(paramString);
    if (localt == null) {
      ad.i("MicroMsg.CompatSubCore", "compatSubCore is null by name %s", new Object[] { paramString });
    }
    for (;;)
    {
      AppMethodBeat.o(42778);
      return localt;
      com.tencent.mm.kernel.a.c.ajP().bs(localt);
    }
  }
  
  public final void a(ax paramax)
  {
    AppMethodBeat.i(42775);
    try
    {
      this.hEW = paramax;
      if ((this.hEV == null) && (this.hEW != null)) {
        this.hEV = this.hEW.getClass();
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(42775);
    }
  }
  
  public final ax aAj()
  {
    try
    {
      AppMethodBeat.i(42774);
      if (this.hEW == null) {
        a(createSubCore());
      }
      ax localax = this.hEW;
      AppMethodBeat.o(42774);
      return localax;
    }
    finally {}
  }
  
  public final void ajK()
  {
    AppMethodBeat.i(42785);
    ax localax = aAj();
    if (localax == null)
    {
      AppMethodBeat.o(42785);
      return;
    }
    if (!this.hEX)
    {
      AppMethodBeat.o(42785);
      return;
    }
    localax.onSdcardMount(e.abf());
    AppMethodBeat.o(42785);
  }
  
  public final void ajL()
  {
    AppMethodBeat.i(42786);
    aAj();
    AppMethodBeat.o(42786);
  }
  
  public HashMap<Integer, h.b> collectDatabaseFactory()
  {
    AppMethodBeat.i(42782);
    Object localObject = aAj();
    if (localObject == null)
    {
      AppMethodBeat.o(42782);
      return null;
    }
    localObject = ((ax)localObject).getBaseDBFactories();
    AppMethodBeat.o(42782);
    return localObject;
  }
  
  public void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(42783);
    ax localax = aAj();
    if (localax == null)
    {
      AppMethodBeat.o(42783);
      return;
    }
    localax.onAccountPostReset(paramc.gBH);
    this.hEX = true;
    AppMethodBeat.o(42783);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(42784);
    ax localax = aAj();
    if (localax == null)
    {
      AppMethodBeat.o(42784);
      return;
    }
    localax.onAccountRelease();
    AppMethodBeat.o(42784);
  }
  
  public String toString()
  {
    AppMethodBeat.i(42787);
    String str = super.toString() + " " + this.hEV + " " + this.hEU + " " + this.hEW;
    AppMethodBeat.o(42787);
    return str;
  }
  
  public void xb(String paramString) {}
  
  public static abstract interface a
  {
    public abstract ax createSubCore();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.model.t
 * JD-Core Version:    0.7.0.1
 */