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
  private static ConcurrentHashMap<String, t> gMk;
  private volatile a gMg;
  private volatile Class<? extends aw> gMh;
  private volatile aw gMi;
  private volatile boolean gMj;
  
  static
  {
    AppMethodBeat.i(42788);
    gMk = new ConcurrentHashMap();
    AppMethodBeat.o(42788);
  }
  
  public t(a parama)
  {
    this.gMj = false;
    this.gMg = parama;
  }
  
  public t(Class<? extends aw> paramClass)
  {
    AppMethodBeat.i(42773);
    this.gMj = false;
    this.gMh = paramClass;
    a(this.gMh.getName(), this);
    AppMethodBeat.o(42773);
  }
  
  public static t a(String paramString, t paramt)
  {
    AppMethodBeat.i(42777);
    t localt = (t)gMk.putIfAbsent(paramString, paramt);
    if (localt == null) {
      com.tencent.mm.kernel.a.c.afO().bu(paramt);
    }
    for (;;)
    {
      ad.i("MicroMsg.CompatSubCore", "registerCompatSubCoreWithNameIfAbsent %s, %s %s", new Object[] { paramString, paramt, bt.eGN() });
      AppMethodBeat.o(42777);
      return paramt;
      paramt = localt;
    }
  }
  
  public static <T extends aw> T ap(Class<T> paramClass)
  {
    AppMethodBeat.i(42781);
    t localt2 = sd(paramClass.getName());
    t localt1 = localt2;
    if (localt2 == null)
    {
      localt1 = new t(paramClass);
      a(paramClass.getName(), localt1);
    }
    paramClass = localt1.aqD();
    AppMethodBeat.o(42781);
    return paramClass;
  }
  
  public static void aqE()
  {
    AppMethodBeat.i(42779);
    Iterator localIterator = gMk.values().iterator();
    while (localIterator.hasNext()) {
      ((t)localIterator.next()).reset();
    }
    AppMethodBeat.o(42779);
  }
  
  private aw createSubCore()
  {
    AppMethodBeat.i(42776);
    try
    {
      ad.i("MicroMsg.CompatSubCore", "createSubCore(), %s %s", new Object[] { this.gMh, this.gMg });
      if (this.gMg != null)
      {
        localaw = this.gMg.createSubCore();
        AppMethodBeat.o(42776);
        return localaw;
      }
      aw localaw = (aw)this.gMh.newInstance();
      AppMethodBeat.o(42776);
      return localaw;
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
  
  public static void mX(int paramInt)
  {
    AppMethodBeat.i(42780);
    Iterator localIterator = gMk.values().iterator();
    while (localIterator.hasNext())
    {
      aw localaw = ((t)localIterator.next()).aqD();
      if (localaw != null) {
        localaw.clearPluginData(paramInt);
      }
    }
    AppMethodBeat.o(42780);
  }
  
  private void reset()
  {
    try
    {
      this.gMi = null;
      this.gMj = false;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static t sd(String paramString)
  {
    AppMethodBeat.i(42778);
    t localt = (t)gMk.get(paramString);
    if (localt == null) {
      ad.i("MicroMsg.CompatSubCore", "compatSubCore is null by name %s", new Object[] { paramString });
    }
    for (;;)
    {
      AppMethodBeat.o(42778);
      return localt;
      com.tencent.mm.kernel.a.c.afO().bt(localt);
    }
  }
  
  public final void a(aw paramaw)
  {
    AppMethodBeat.i(42775);
    try
    {
      this.gMi = paramaw;
      if ((this.gMh == null) && (this.gMi != null)) {
        this.gMh = this.gMi.getClass();
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(42775);
    }
  }
  
  public final void afJ()
  {
    AppMethodBeat.i(42785);
    aw localaw = aqD();
    if (localaw == null)
    {
      AppMethodBeat.o(42785);
      return;
    }
    if (!this.gMj)
    {
      AppMethodBeat.o(42785);
      return;
    }
    localaw.onSdcardMount(e.XG());
    AppMethodBeat.o(42785);
  }
  
  public final void afK()
  {
    AppMethodBeat.i(42786);
    aqD();
    AppMethodBeat.o(42786);
  }
  
  public final aw aqD()
  {
    try
    {
      AppMethodBeat.i(42774);
      if (this.gMi == null) {
        a(createSubCore());
      }
      aw localaw = this.gMi;
      AppMethodBeat.o(42774);
      return localaw;
    }
    finally {}
  }
  
  public HashMap<Integer, h.b> collectDatabaseFactory()
  {
    AppMethodBeat.i(42782);
    Object localObject = aqD();
    if (localObject == null)
    {
      AppMethodBeat.o(42782);
      return null;
    }
    localObject = ((aw)localObject).getBaseDBFactories();
    AppMethodBeat.o(42782);
    return localObject;
  }
  
  public void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(42783);
    aw localaw = aqD();
    if (localaw == null)
    {
      AppMethodBeat.o(42783);
      return;
    }
    localaw.onAccountPostReset(paramc.gdr);
    this.gMj = true;
    AppMethodBeat.o(42783);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(42784);
    aw localaw = aqD();
    if (localaw == null)
    {
      AppMethodBeat.o(42784);
      return;
    }
    localaw.onAccountRelease();
    AppMethodBeat.o(42784);
  }
  
  public void qW(String paramString) {}
  
  public String toString()
  {
    AppMethodBeat.i(42787);
    String str = super.toString() + " " + this.gMh + " " + this.gMg + " " + this.gMi;
    AppMethodBeat.o(42787);
    return str;
  }
  
  public static abstract interface a
  {
    public abstract aw createSubCore();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.model.t
 * JD-Core Version:    0.7.0.1
 */