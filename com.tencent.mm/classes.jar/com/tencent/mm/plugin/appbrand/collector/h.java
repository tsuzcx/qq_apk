package com.tencent.mm.plugin.appbrand.collector;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
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
  private Map<String, CollectSession> fZH;
  private Map<String, Set<CollectSession>> jaQ;
  
  public h()
  {
    AppMethodBeat.i(146110);
    this.fZH = new a();
    this.jaQ = new a();
    AppMethodBeat.o(146110);
  }
  
  private Set<CollectSession> FF(String paramString)
  {
    AppMethodBeat.i(146112);
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(146112);
      return null;
    }
    paramString = (Set)this.jaQ.get(paramString);
    AppMethodBeat.o(146112);
    return paramString;
  }
  
  private CollectSession FG(String paramString)
  {
    AppMethodBeat.i(146114);
    CollectSession localCollectSession2 = (CollectSession)this.fZH.get(paramString);
    CollectSession localCollectSession1 = localCollectSession2;
    if (localCollectSession2 == null)
    {
      localCollectSession1 = new CollectSession(paramString);
      this.fZH.put(paramString, localCollectSession1);
    }
    AppMethodBeat.o(146114);
    return localCollectSession1;
  }
  
  private boolean a(String paramString, CollectSession paramCollectSession)
  {
    AppMethodBeat.i(146111);
    if ((paramString == null) || (paramString.length() == 0) || (paramCollectSession == null))
    {
      AppMethodBeat.o(146111);
      return false;
    }
    Set localSet = (Set)this.jaQ.get(paramString);
    Object localObject = localSet;
    if (localSet == null)
    {
      localObject = new LinkedHashSet();
      this.jaQ.put(paramString, localObject);
    }
    boolean bool = ((Set)localObject).add(paramCollectSession);
    AppMethodBeat.o(146111);
    return bool;
  }
  
  public final CollectSession Fx(String paramString)
  {
    AppMethodBeat.i(146119);
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(146119);
      return null;
    }
    paramString = (CollectSession)this.fZH.get(paramString);
    AppMethodBeat.o(146119);
    return paramString;
  }
  
  public final CollectSession Fy(String paramString)
  {
    AppMethodBeat.i(146120);
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(146120);
      return null;
    }
    paramString = (CollectSession)this.fZH.remove(paramString);
    AppMethodBeat.o(146120);
    return paramString;
  }
  
  public final StringBuilder Fz(String paramString)
  {
    AppMethodBeat.i(146123);
    Object localObject = FF(paramString);
    if ((localObject == null) || (((Set)localObject).isEmpty()))
    {
      ad.i("MicroMsg.SumCostTimeCollector", "printAverage failed, set(%s) is empty.", new Object[] { paramString });
      paramString = new StringBuilder().append(String.format("GroupId : %s, size : 0\n", new Object[] { paramString }));
      AppMethodBeat.o(146123);
      return paramString;
    }
    LinkedHashSet localLinkedHashSet = new LinkedHashSet((Collection)localObject);
    TimePoint localTimePoint2 = new TimePoint();
    Iterator localIterator = localLinkedHashSet.iterator();
    while (localIterator.hasNext())
    {
      localObject = (CollectSession)localIterator.next();
      if ((((CollectSession)localObject).jaH == null) || ((((CollectSession)localObject).jaJ != null) && (!((CollectSession)localObject).jaH.name.equals(((CollectSession)localObject).jaJ))))
      {
        ad.e("MicroMsg.SumCostTimeCollector", "error(%s), incorrect point count", new Object[] { ((CollectSession)localObject).id });
      }
      else
      {
        TimePoint localTimePoint1 = ((CollectSession)localObject).jaG;
        for (localObject = localTimePoint2; localTimePoint1 != null; localObject = (TimePoint)((TimePoint)localObject).jaT.get())
        {
          ((TimePoint)localObject).jaS.set((((TimePoint)localObject).jaS.get() * ((TimePoint)localObject).jaR.get() + localTimePoint1.jaS.get()) / ((TimePoint)localObject).jaR.incrementAndGet());
          ((TimePoint)localObject).name = localTimePoint1.name;
          localTimePoint1 = (TimePoint)localTimePoint1.jaT.get();
          if ((((TimePoint)localObject).jaT.get() == null) && (localTimePoint1 != null)) {
            ((TimePoint)localObject).jaT.set(new TimePoint());
          }
        }
      }
    }
    localObject = e.a(localTimePoint2);
    ((StringBuilder)localObject).insert(0, String.format("GroupId : %s, size : %d\n", new Object[] { paramString, Integer.valueOf(localLinkedHashSet.size()) }));
    AppMethodBeat.o(146123);
    return localObject;
  }
  
  public final void a(CollectSession paramCollectSession)
  {
    AppMethodBeat.i(146115);
    String str = paramCollectSession.id;
    CollectSession localCollectSession = (CollectSession)this.fZH.get(str);
    if (localCollectSession == null)
    {
      this.fZH.put(str, paramCollectSession);
      a(paramCollectSession.groupId, paramCollectSession);
      AppMethodBeat.o(146115);
      return;
    }
    Object localObject = paramCollectSession.jaG;
    paramCollectSession = (CollectSession)localObject;
    if (localCollectSession.jaG == null)
    {
      localCollectSession.jaG = ((TimePoint)localObject);
      AppMethodBeat.o(146115);
      return;
    }
    if (paramCollectSession != null)
    {
      localObject = paramCollectSession.name;
      long l = paramCollectSession.jaS.get();
      if ((str == null) || (str.length() == 0)) {}
      for (;;)
      {
        paramCollectSession = (TimePoint)paramCollectSession.jaT.get();
        break;
        localCollectSession = FG(str);
        if (localCollectSession.jaG == null)
        {
          localCollectSession.pP((String)localObject);
          localCollectSession.jaG.jaS.set(l);
        }
        else
        {
          TimePoint localTimePoint = (TimePoint)localCollectSession.jaI.get(localObject);
          if (localTimePoint == null)
          {
            localCollectSession.Fw((String)localObject);
            localCollectSession.jaH.jaS.set(l);
          }
          else
          {
            localTimePoint.jaS.set((l + localTimePoint.jaS.get() * localTimePoint.jaR.get()) / (localTimePoint.jaR.get() + 1));
            localTimePoint.jaR.getAndIncrement();
          }
        }
      }
    }
    AppMethodBeat.o(146115);
  }
  
  public final void c(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    AppMethodBeat.i(146118);
    if (!paramBoolean)
    {
      AppMethodBeat.o(146118);
      return;
    }
    if ((paramString2 == null) || (paramString2.length() == 0))
    {
      ad.i("MicroMsg.SumCostTimeCollector", "tryToJoin(%s) failed, sessionId is null or nil.", new Object[] { paramString3 });
      AppMethodBeat.o(146118);
      return;
    }
    if ((paramString1 == null) || (paramString1.length() == 0))
    {
      ad.i("MicroMsg.SumCostTimeCollector", "tryToJoin(%s) failed, groupId is null or nil.", new Object[] { paramString3 });
      AppMethodBeat.o(146118);
      return;
    }
    paramString2 = FG(paramString2);
    if (paramString2.jaG == null)
    {
      paramString2.groupId = paramString1;
      a(paramString1, paramString2);
      paramString2.pP(paramString3);
      AppMethodBeat.o(146118);
      return;
    }
    paramString2.Fw(paramString3);
    AppMethodBeat.o(146118);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(146113);
    this.fZH.clear();
    this.jaQ.clear();
    AppMethodBeat.o(146113);
  }
  
  public final CollectSession cn(String paramString1, String paramString2)
  {
    AppMethodBeat.i(146116);
    if ((paramString1 == null) || (paramString1.length() == 0))
    {
      ad.i("MicroMsg.SumCostTimeCollector", "join(%s) failed, sessionId is null or nil.", new Object[] { paramString2 });
      AppMethodBeat.o(146116);
      return null;
    }
    paramString1 = FG(paramString1);
    if (paramString1.jaG == null) {
      paramString1.pP(paramString2);
    }
    for (;;)
    {
      AppMethodBeat.o(146116);
      return paramString1;
      paramString1.Fw(paramString2);
    }
  }
  
  public final void co(String paramString1, String paramString2)
  {
    AppMethodBeat.i(146121);
    if ((paramString1 == null) || (paramString1.length() == 0) || (paramString2 == null) || (paramString2.length() == 0))
    {
      ad.i("MicroMsg.SumCostTimeCollector", "setLastPointName(%s, %s) failed, sessionId is null or nil.", new Object[] { paramString1, paramString2 });
      AppMethodBeat.o(146121);
      return;
    }
    CollectSession localCollectSession = (CollectSession)this.fZH.get(paramString1);
    if (localCollectSession == null)
    {
      ad.i("MicroMsg.SumCostTimeCollector", "setLastPointName(%s, %s) failed,", new Object[] { paramString1, paramString2 });
      AppMethodBeat.o(146121);
      return;
    }
    localCollectSession.jaJ = paramString2;
    AppMethodBeat.o(146121);
  }
  
  public final int cp(String paramString1, String paramString2)
  {
    AppMethodBeat.i(146124);
    Set localSet = FF(paramString1);
    if ((localSet == null) || (localSet.isEmpty()))
    {
      ad.i("MicroMsg.SumCostTimeCollector", "printAverage failed, set(%s) is empty.", new Object[] { paramString1 });
      AppMethodBeat.o(146124);
      return 0;
    }
    paramString1 = new LinkedHashSet(localSet).iterator();
    int i = 0;
    int j = 0;
    while (paramString1.hasNext())
    {
      int k = ((CollectSession)paramString1.next()).dlO.getInt(paramString2);
      if (k != 0)
      {
        j += k;
        i += 1;
      }
    }
    if (i == 0)
    {
      AppMethodBeat.o(146124);
      return 0;
    }
    i = j / i;
    AppMethodBeat.o(146124);
    return i;
  }
  
  public final void k(String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(146117);
    if (!paramBoolean)
    {
      AppMethodBeat.o(146117);
      return;
    }
    if ((paramString1 == null) || (paramString1.length() == 0))
    {
      ad.i("MicroMsg.SumCostTimeCollector", "tryToJoin(%s) failed, sessionId is null or nil.", new Object[] { paramString2 });
      AppMethodBeat.o(146117);
      return;
    }
    paramString1 = FG(paramString1);
    if (paramString1.jaG == null)
    {
      paramString1.pP(paramString2);
      AppMethodBeat.o(146117);
      return;
    }
    paramString1.Fw(paramString2);
    AppMethodBeat.o(146117);
  }
  
  public final void print(String paramString)
  {
    AppMethodBeat.i(146122);
    CollectSession localCollectSession = (CollectSession)this.fZH.get(paramString);
    if (localCollectSession == null)
    {
      ad.i("MicroMsg.SumCostTimeCollector", "print failed, session(%s) is null", new Object[] { paramString });
      AppMethodBeat.o(146122);
      return;
    }
    TimePoint localTimePoint = localCollectSession.jaG;
    if (localTimePoint == null)
    {
      ad.i("MicroMsg.SumCostTimeCollector", "print failed, the session(%s) do not have any point.", new Object[] { paramString });
      AppMethodBeat.o(146122);
      return;
    }
    paramString = e.a(localTimePoint);
    paramString.insert(0, String.format("session : %s\n", new Object[] { localCollectSession.id }));
    ad.i("MicroMsg.SumCostTimeCollector", "%s", new Object[] { paramString.toString() });
    AppMethodBeat.o(146122);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.collector.h
 * JD-Core Version:    0.7.0.1
 */