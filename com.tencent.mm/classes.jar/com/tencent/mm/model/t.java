package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.kernel.api.a;
import com.tencent.mm.kernel.api.f;
import com.tencent.mm.kernel.api.h;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storagebase.h.b;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public class t
  implements a, com.tencent.mm.kernel.api.c, f, h, com.tencent.mm.kernel.b.c
{
  private static ConcurrentHashMap<String, t> hmK;
  private volatile a hmG;
  private volatile Class<? extends aw> hmH;
  private volatile aw hmI;
  private volatile boolean hmJ;
  
  static
  {
    AppMethodBeat.i(42788);
    hmK = new ConcurrentHashMap();
    AppMethodBeat.o(42788);
  }
  
  public t(a parama)
  {
    this.hmJ = false;
    this.hmG = parama;
  }
  
  public t(Class<? extends aw> paramClass)
  {
    AppMethodBeat.i(42773);
    this.hmJ = false;
    this.hmH = paramClass;
    a(this.hmH.getName(), this);
    AppMethodBeat.o(42773);
  }
  
  public static t a(String paramString, t paramt)
  {
    AppMethodBeat.i(42777);
    t localt = (t)hmK.putIfAbsent(paramString, paramt);
    if (localt == null) {
      com.tencent.mm.kernel.a.c.ahe().br(paramt);
    }
    for (;;)
    {
      ac.i("MicroMsg.CompatSubCore", "registerCompatSubCoreWithNameIfAbsent %s, %s %s", new Object[] { paramString, paramt, bs.eWi() });
      AppMethodBeat.o(42777);
      return paramt;
      paramt = localt;
    }
  }
  
  public static <T extends aw> T ap(Class<T> paramClass)
  {
    AppMethodBeat.i(42781);
    t localt2 = wg(paramClass.getName());
    t localt1 = localt2;
    if (localt2 == null)
    {
      localt1 = new t(paramClass);
      a(paramClass.getName(), localt1);
    }
    paramClass = localt1.axt();
    AppMethodBeat.o(42781);
    return paramClass;
  }
  
  public static void axu()
  {
    AppMethodBeat.i(42779);
    Iterator localIterator = hmK.values().iterator();
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
      ac.i("MicroMsg.CompatSubCore", "createSubCore(), %s %s", new Object[] { this.hmH, this.hmG });
      if (this.hmG != null)
      {
        localaw = this.hmG.createSubCore();
        AppMethodBeat.o(42776);
        return localaw;
      }
      aw localaw = (aw)this.hmH.newInstance();
      AppMethodBeat.o(42776);
      return localaw;
    }
    catch (InstantiationException localInstantiationException)
    {
      ac.printErrStackTrace("MicroMsg.CompatSubCore", localInstantiationException, "", new Object[0]);
      IllegalAccessError localIllegalAccessError1 = new IllegalAccessError(localInstantiationException.getMessage());
      AppMethodBeat.o(42776);
      throw localIllegalAccessError1;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      ac.printErrStackTrace("MicroMsg.CompatSubCore", localIllegalAccessException, "", new Object[0]);
      IllegalAccessError localIllegalAccessError2 = new IllegalAccessError(localIllegalAccessException.getMessage());
      AppMethodBeat.o(42776);
      throw localIllegalAccessError2;
    }
  }
  
  public static void nL(int paramInt)
  {
    AppMethodBeat.i(42780);
    Iterator localIterator = hmK.values().iterator();
    while (localIterator.hasNext())
    {
      aw localaw = ((t)localIterator.next()).axt();
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
      this.hmI = null;
      this.hmJ = false;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static t wg(String paramString)
  {
    AppMethodBeat.i(42778);
    t localt = (t)hmK.get(paramString);
    if (localt == null) {
      ac.i("MicroMsg.CompatSubCore", "compatSubCore is null by name %s", new Object[] { paramString });
    }
    for (;;)
    {
      AppMethodBeat.o(42778);
      return localt;
      com.tencent.mm.kernel.a.c.ahe().bq(localt);
    }
  }
  
  public final void a(aw paramaw)
  {
    AppMethodBeat.i(42775);
    try
    {
      this.hmI = paramaw;
      if ((this.hmH == null) && (this.hmI != null)) {
        this.hmH = this.hmI.getClass();
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(42775);
    }
  }
  
  public final void agZ()
  {
    AppMethodBeat.i(42785);
    aw localaw = axt();
    if (localaw == null)
    {
      AppMethodBeat.o(42785);
      return;
    }
    if (!this.hmJ)
    {
      AppMethodBeat.o(42785);
      return;
    }
    localaw.onSdcardMount(e.YD());
    AppMethodBeat.o(42785);
  }
  
  public final void aha()
  {
    AppMethodBeat.i(42786);
    axt();
    AppMethodBeat.o(42786);
  }
  
  public final aw axt()
  {
    try
    {
      AppMethodBeat.i(42774);
      if (this.hmI == null) {
        a(createSubCore());
      }
      aw localaw = this.hmI;
      AppMethodBeat.o(42774);
      return localaw;
    }
    finally {}
  }
  
  public HashMap<Integer, h.b> collectDatabaseFactory()
  {
    AppMethodBeat.i(42782);
    Object localObject = axt();
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
    aw localaw = axt();
    if (localaw == null)
    {
      AppMethodBeat.o(42783);
      return;
    }
    localaw.onAccountPostReset(paramc.ghX);
    this.hmJ = true;
    AppMethodBeat.o(42783);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(42784);
    aw localaw = axt();
    if (localaw == null)
    {
      AppMethodBeat.o(42784);
      return;
    }
    localaw.onAccountRelease();
    AppMethodBeat.o(42784);
  }
  
  public String toString()
  {
    AppMethodBeat.i(42787);
    String str = super.toString() + " " + this.hmH + " " + this.hmG + " " + this.hmI;
    AppMethodBeat.o(42787);
    return str;
  }
  
  public void ul(String paramString) {}
  
  public static abstract interface a
  {
    public abstract aw createSubCore();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.model.t
 * JD-Core Version:    0.7.0.1
 */