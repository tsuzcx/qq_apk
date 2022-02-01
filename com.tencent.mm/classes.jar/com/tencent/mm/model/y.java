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
  private static ConcurrentHashMap<String, y> lsv;
  private volatile a lsr;
  private volatile Class<? extends be> lss;
  private volatile be lst;
  private volatile boolean lsu;
  
  static
  {
    AppMethodBeat.i(42788);
    lsv = new ConcurrentHashMap();
    AppMethodBeat.o(42788);
  }
  
  public y(a parama)
  {
    this.lsu = false;
    this.lsr = parama;
  }
  
  public y(Class<? extends be> paramClass)
  {
    AppMethodBeat.i(42773);
    this.lsu = false;
    this.lss = paramClass;
    a(this.lss.getName(), this);
    AppMethodBeat.o(42773);
  }
  
  public static y PC(String paramString)
  {
    AppMethodBeat.i(42778);
    y localy = (y)lsv.get(paramString);
    if (localy == null) {
      Log.i("MicroMsg.CompatSubCore", "compatSubCore is null by name %s", new Object[] { paramString });
    }
    for (;;)
    {
      AppMethodBeat.o(42778);
      return localy;
      com.tencent.mm.kernel.a.c.aHV().bB(localy);
    }
  }
  
  public static y a(String paramString, y paramy)
  {
    AppMethodBeat.i(42777);
    y localy = (y)lsv.putIfAbsent(paramString, paramy);
    if (localy == null) {
      com.tencent.mm.kernel.a.c.aHV().bC(paramy);
    }
    for (;;)
    {
      Log.i("MicroMsg.CompatSubCore", "registerCompatSubCoreWithNameIfAbsent %s, %s %s", new Object[] { paramString, paramy, Util.getStack() });
      AppMethodBeat.o(42777);
      return paramy;
      paramy = localy;
    }
  }
  
  public static <T extends be> T as(Class<T> paramClass)
  {
    AppMethodBeat.i(42781);
    y localy2 = PC(paramClass.getName());
    y localy1 = localy2;
    if (localy2 == null)
    {
      localy1 = new y(paramClass);
      a(paramClass.getName(), localy1);
    }
    paramClass = localy1.bcW();
    AppMethodBeat.o(42781);
    return paramClass;
  }
  
  public static void bcX()
  {
    AppMethodBeat.i(42779);
    Iterator localIterator = lsv.values().iterator();
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
      Log.i("MicroMsg.CompatSubCore", "createSubCore(), %s %s", new Object[] { this.lss, this.lsr });
      if (this.lsr != null)
      {
        localbe = this.lsr.createSubCore();
        AppMethodBeat.o(42776);
        return localbe;
      }
      be localbe = (be)this.lss.newInstance();
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
      this.lst = null;
      this.lsu = false;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static void uH(int paramInt)
  {
    AppMethodBeat.i(42780);
    Iterator localIterator = lsv.values().iterator();
    while (localIterator.hasNext())
    {
      be localbe = ((y)localIterator.next()).bcW();
      if (localbe != null) {
        localbe.clearPluginData(paramInt);
      }
    }
    AppMethodBeat.o(42780);
  }
  
  public void MU(String paramString) {}
  
  public final void a(be parambe)
  {
    AppMethodBeat.i(42775);
    try
    {
      this.lst = parambe;
      if ((this.lss == null) && (this.lst != null)) {
        this.lss = this.lst.getClass();
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(42775);
    }
  }
  
  public final void aHQ()
  {
    AppMethodBeat.i(42785);
    be localbe = bcW();
    if (localbe == null)
    {
      AppMethodBeat.o(42785);
      return;
    }
    if (!this.lsu)
    {
      AppMethodBeat.o(42785);
      return;
    }
    localbe.onSdcardMount(e.avA());
    AppMethodBeat.o(42785);
  }
  
  public final void aHR()
  {
    AppMethodBeat.i(42786);
    bcW();
    AppMethodBeat.o(42786);
  }
  
  public final be bcW()
  {
    try
    {
      AppMethodBeat.i(42774);
      if (this.lst == null) {
        a(createSubCore());
      }
      be localbe = this.lst;
      AppMethodBeat.o(42774);
      return localbe;
    }
    finally {}
  }
  
  public HashMap<Integer, h.b> collectDatabaseFactory()
  {
    AppMethodBeat.i(42782);
    Object localObject = bcW();
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
    be localbe = bcW();
    if (localbe == null)
    {
      AppMethodBeat.o(42783);
      return;
    }
    localbe.onAccountPostReset(paramc.kcX);
    this.lsu = true;
    AppMethodBeat.o(42783);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(42784);
    be localbe = bcW();
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
    String str = super.toString() + " " + this.lss + " " + this.lsr + " " + this.lst;
    AppMethodBeat.o(42787);
    return str;
  }
  
  public static abstract interface a
  {
    public abstract be createSubCore();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.model.y
 * JD-Core Version:    0.7.0.1
 */