package com.tencent.mm.plugin.appbrand.collector;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public final class h
  implements b
{
  private Map<String, CollectSession> eEE;
  private Map<String, Set<CollectSession>> hgF;
  
  public h()
  {
    AppMethodBeat.i(57045);
    this.eEE = new a();
    this.hgF = new a();
    AppMethodBeat.o(57045);
  }
  
  private boolean a(String paramString, CollectSession paramCollectSession)
  {
    AppMethodBeat.i(57046);
    if ((paramString == null) || (paramString.length() == 0) || (paramCollectSession == null))
    {
      AppMethodBeat.o(57046);
      return false;
    }
    Set localSet = (Set)this.hgF.get(paramString);
    Object localObject = localSet;
    if (localSet == null)
    {
      localObject = new LinkedHashSet();
      this.hgF.put(paramString, localObject);
    }
    boolean bool = ((Set)localObject).add(paramCollectSession);
    AppMethodBeat.o(57046);
    return bool;
  }
  
  private Set<CollectSession> zR(String paramString)
  {
    AppMethodBeat.i(57047);
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(57047);
      return null;
    }
    paramString = (Set)this.hgF.get(paramString);
    AppMethodBeat.o(57047);
    return paramString;
  }
  
  private CollectSession zS(String paramString)
  {
    AppMethodBeat.i(57049);
    CollectSession localCollectSession2 = (CollectSession)this.eEE.get(paramString);
    CollectSession localCollectSession1 = localCollectSession2;
    if (localCollectSession2 == null)
    {
      localCollectSession1 = new CollectSession(paramString);
      this.eEE.put(paramString, localCollectSession1);
    }
    AppMethodBeat.o(57049);
    return localCollectSession1;
  }
  
  public final void a(CollectSession paramCollectSession)
  {
    AppMethodBeat.i(57050);
    String str = paramCollectSession.id;
    CollectSession localCollectSession = (CollectSession)this.eEE.get(str);
    if (localCollectSession == null)
    {
      this.eEE.put(str, paramCollectSession);
      a(paramCollectSession.groupId, paramCollectSession);
      AppMethodBeat.o(57050);
      return;
    }
    Object localObject = paramCollectSession.hgv;
    paramCollectSession = (CollectSession)localObject;
    if (localCollectSession.hgv == null)
    {
      localCollectSession.hgv = ((TimePoint)localObject);
      AppMethodBeat.o(57050);
      return;
    }
    if (paramCollectSession != null)
    {
      localObject = paramCollectSession.name;
      long l = paramCollectSession.hgH.get();
      if ((str == null) || (str.length() == 0)) {}
      for (;;)
      {
        paramCollectSession = (TimePoint)paramCollectSession.hgI.get();
        break;
        localCollectSession = zS(str);
        if (localCollectSession.hgv == null)
        {
          localCollectSession.zH((String)localObject);
          localCollectSession.hgv.hgH.set(l);
        }
        else
        {
          TimePoint localTimePoint = (TimePoint)localCollectSession.hgx.get(localObject);
          if (localTimePoint == null)
          {
            localCollectSession.zI((String)localObject);
            localCollectSession.hgw.hgH.set(l);
          }
          else
          {
            localTimePoint.hgH.set((l + localTimePoint.hgH.get() * localTimePoint.hgG.get()) / (localTimePoint.hgG.get() + 1));
            localTimePoint.hgG.getAndIncrement();
          }
        }
      }
    }
    AppMethodBeat.o(57050);
  }
  
  public final CollectSession bH(String paramString1, String paramString2)
  {
    AppMethodBeat.i(57051);
    if ((paramString1 == null) || (paramString1.length() == 0))
    {
      ab.i("MicroMsg.SumCostTimeCollector", "join(%s) failed, sessionId is null or nil.", new Object[] { paramString2 });
      AppMethodBeat.o(57051);
      return null;
    }
    paramString1 = zS(paramString1);
    if (paramString1.hgv == null) {
      paramString1.zH(paramString2);
    }
    for (;;)
    {
      AppMethodBeat.o(57051);
      return paramString1;
      paramString1.zI(paramString2);
    }
  }
  
  public final void bI(String paramString1, String paramString2)
  {
    AppMethodBeat.i(57056);
    if ((paramString1 == null) || (paramString1.length() == 0) || (paramString2 == null) || (paramString2.length() == 0))
    {
      ab.i("MicroMsg.SumCostTimeCollector", "setLastPointName(%s, %s) failed, sessionId is null or nil.", new Object[] { paramString1, paramString2 });
      AppMethodBeat.o(57056);
      return;
    }
    CollectSession localCollectSession = (CollectSession)this.eEE.get(paramString1);
    if (localCollectSession == null)
    {
      ab.i("MicroMsg.SumCostTimeCollector", "setLastPointName(%s, %s) failed,", new Object[] { paramString1, paramString2 });
      AppMethodBeat.o(57056);
      return;
    }
    localCollectSession.hgy = paramString2;
    AppMethodBeat.o(57056);
  }
  
  public final int bJ(String paramString1, String paramString2)
  {
    AppMethodBeat.i(57059);
    Set localSet = zR(paramString1);
    if ((localSet == null) || (localSet.isEmpty()))
    {
      ab.i("MicroMsg.SumCostTimeCollector", "printAverage failed, set(%s) is empty.", new Object[] { paramString1 });
      AppMethodBeat.o(57059);
      return 0;
    }
    paramString1 = new LinkedHashSet(localSet).iterator();
    int i = 0;
    int j = 0;
    while (paramString1.hasNext())
    {
      int k = ((CollectSession)paramString1.next()).cwp.getInt(paramString2);
      if (k != 0)
      {
        j += k;
        i += 1;
      }
    }
    if (i == 0)
    {
      AppMethodBeat.o(57059);
      return 0;
    }
    i = j / i;
    AppMethodBeat.o(57059);
    return i;
  }
  
  public final void c(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    AppMethodBeat.i(57053);
    if (!paramBoolean)
    {
      AppMethodBeat.o(57053);
      return;
    }
    if ((paramString2 == null) || (paramString2.length() == 0))
    {
      ab.i("MicroMsg.SumCostTimeCollector", "tryToJoin(%s) failed, sessionId is null or nil.", new Object[] { paramString3 });
      AppMethodBeat.o(57053);
      return;
    }
    if ((paramString1 == null) || (paramString1.length() == 0))
    {
      ab.i("MicroMsg.SumCostTimeCollector", "tryToJoin(%s) failed, groupId is null or nil.", new Object[] { paramString3 });
      AppMethodBeat.o(57053);
      return;
    }
    paramString2 = zS(paramString2);
    if (paramString2.hgv == null)
    {
      paramString2.groupId = paramString1;
      a(paramString1, paramString2);
      paramString2.zH(paramString3);
      AppMethodBeat.o(57053);
      return;
    }
    paramString2.zI(paramString3);
    AppMethodBeat.o(57053);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(57048);
    this.eEE.clear();
    this.hgF.clear();
    AppMethodBeat.o(57048);
  }
  
  public final void l(String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(57052);
    if (!paramBoolean)
    {
      AppMethodBeat.o(57052);
      return;
    }
    if ((paramString1 == null) || (paramString1.length() == 0))
    {
      ab.i("MicroMsg.SumCostTimeCollector", "tryToJoin(%s) failed, sessionId is null or nil.", new Object[] { paramString2 });
      AppMethodBeat.o(57052);
      return;
    }
    paramString1 = zS(paramString1);
    if (paramString1.hgv == null)
    {
      paramString1.zH(paramString2);
      AppMethodBeat.o(57052);
      return;
    }
    paramString1.zI(paramString2);
    AppMethodBeat.o(57052);
  }
  
  public final void print(String paramString)
  {
    AppMethodBeat.i(57057);
    CollectSession localCollectSession = (CollectSession)this.eEE.get(paramString);
    if (localCollectSession == null)
    {
      ab.i("MicroMsg.SumCostTimeCollector", "print failed, session(%s) is null", new Object[] { paramString });
      AppMethodBeat.o(57057);
      return;
    }
    TimePoint localTimePoint = localCollectSession.hgv;
    if (localTimePoint == null)
    {
      ab.i("MicroMsg.SumCostTimeCollector", "print failed, the session(%s) do not have any point.", new Object[] { paramString });
      AppMethodBeat.o(57057);
      return;
    }
    paramString = e.a(localTimePoint);
    paramString.insert(0, String.format("session : %s\n", new Object[] { localCollectSession.id }));
    ab.i("MicroMsg.SumCostTimeCollector", "%s", new Object[] { paramString.toString() });
    AppMethodBeat.o(57057);
  }
  
  public final CollectSession zJ(String paramString)
  {
    AppMethodBeat.i(57054);
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(57054);
      return null;
    }
    paramString = (CollectSession)this.eEE.get(paramString);
    AppMethodBeat.o(57054);
    return paramString;
  }
  
  public final CollectSession zK(String paramString)
  {
    AppMethodBeat.i(57055);
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(57055);
      return null;
    }
    paramString = (CollectSession)this.eEE.remove(paramString);
    AppMethodBeat.o(57055);
    return paramString;
  }
  
  public final StringBuilder zL(String paramString)
  {
    AppMethodBeat.i(57058);
    Object localObject = zR(paramString);
    if ((localObject == null) || (((Set)localObject).isEmpty()))
    {
      ab.i("MicroMsg.SumCostTimeCollector", "printAverage failed, set(%s) is empty.", new Object[] { paramString });
      paramString = new StringBuilder().append(String.format("GroupId : %s, size : 0\n", new Object[] { paramString }));
      AppMethodBeat.o(57058);
      return paramString;
    }
    LinkedHashSet localLinkedHashSet = new LinkedHashSet((Collection)localObject);
    TimePoint localTimePoint2 = new TimePoint();
    Iterator localIterator = localLinkedHashSet.iterator();
    while (localIterator.hasNext())
    {
      localObject = (CollectSession)localIterator.next();
      if ((((CollectSession)localObject).hgw == null) || ((((CollectSession)localObject).hgy != null) && (!((CollectSession)localObject).hgw.name.equals(((CollectSession)localObject).hgy))))
      {
        ab.e("MicroMsg.SumCostTimeCollector", "error(%s), incorrect point count", new Object[] { ((CollectSession)localObject).id });
      }
      else
      {
        TimePoint localTimePoint1 = ((CollectSession)localObject).hgv;
        for (localObject = localTimePoint2; localTimePoint1 != null; localObject = (TimePoint)((TimePoint)localObject).hgI.get())
        {
          ((TimePoint)localObject).hgH.set((((TimePoint)localObject).hgH.get() * ((TimePoint)localObject).hgG.get() + localTimePoint1.hgH.get()) / ((TimePoint)localObject).hgG.incrementAndGet());
          ((TimePoint)localObject).name = localTimePoint1.name;
          localTimePoint1 = (TimePoint)localTimePoint1.hgI.get();
          if ((((TimePoint)localObject).hgI.get() == null) && (localTimePoint1 != null)) {
            ((TimePoint)localObject).hgI.set(new TimePoint());
          }
        }
      }
    }
    localObject = e.a(localTimePoint2);
    ((StringBuilder)localObject).insert(0, String.format("GroupId : %s, size : %d\n", new Object[] { paramString, Integer.valueOf(localLinkedHashSet.size()) }));
    AppMethodBeat.o(57058);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.collector.h
 * JD-Core Version:    0.7.0.1
 */