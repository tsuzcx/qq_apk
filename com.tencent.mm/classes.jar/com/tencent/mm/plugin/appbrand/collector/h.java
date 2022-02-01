package com.tencent.mm.plugin.appbrand.collector;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
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
  private Map<String, CollectSession> gen;
  private Map<String, Set<CollectSession>> jBd;
  
  public h()
  {
    AppMethodBeat.i(146110);
    this.gen = new a();
    this.jBd = new a();
    AppMethodBeat.o(146110);
  }
  
  private Set<CollectSession> JJ(String paramString)
  {
    AppMethodBeat.i(146112);
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(146112);
      return null;
    }
    paramString = (Set)this.jBd.get(paramString);
    AppMethodBeat.o(146112);
    return paramString;
  }
  
  private CollectSession JK(String paramString)
  {
    AppMethodBeat.i(146114);
    CollectSession localCollectSession2 = (CollectSession)this.gen.get(paramString);
    CollectSession localCollectSession1 = localCollectSession2;
    if (localCollectSession2 == null)
    {
      localCollectSession1 = new CollectSession(paramString);
      this.gen.put(paramString, localCollectSession1);
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
    Set localSet = (Set)this.jBd.get(paramString);
    Object localObject = localSet;
    if (localSet == null)
    {
      localObject = new LinkedHashSet();
      this.jBd.put(paramString, localObject);
    }
    boolean bool = ((Set)localObject).add(paramCollectSession);
    AppMethodBeat.o(146111);
    return bool;
  }
  
  public final CollectSession JB(String paramString)
  {
    AppMethodBeat.i(146119);
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(146119);
      return null;
    }
    paramString = (CollectSession)this.gen.get(paramString);
    AppMethodBeat.o(146119);
    return paramString;
  }
  
  public final CollectSession JC(String paramString)
  {
    AppMethodBeat.i(146120);
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(146120);
      return null;
    }
    paramString = (CollectSession)this.gen.remove(paramString);
    AppMethodBeat.o(146120);
    return paramString;
  }
  
  public final StringBuilder JD(String paramString)
  {
    AppMethodBeat.i(146123);
    Object localObject = JJ(paramString);
    if ((localObject == null) || (((Set)localObject).isEmpty()))
    {
      ac.i("MicroMsg.SumCostTimeCollector", "printAverage failed, set(%s) is empty.", new Object[] { paramString });
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
      if ((((CollectSession)localObject).jAU == null) || ((((CollectSession)localObject).jAW != null) && (!((CollectSession)localObject).jAU.name.equals(((CollectSession)localObject).jAW))))
      {
        ac.e("MicroMsg.SumCostTimeCollector", "error(%s), incorrect point count", new Object[] { ((CollectSession)localObject).id });
      }
      else
      {
        TimePoint localTimePoint1 = ((CollectSession)localObject).jAT;
        for (localObject = localTimePoint2; localTimePoint1 != null; localObject = (TimePoint)((TimePoint)localObject).jBg.get())
        {
          ((TimePoint)localObject).jBf.set((((TimePoint)localObject).jBf.get() * ((TimePoint)localObject).jBe.get() + localTimePoint1.jBf.get()) / ((TimePoint)localObject).jBe.incrementAndGet());
          ((TimePoint)localObject).name = localTimePoint1.name;
          localTimePoint1 = (TimePoint)localTimePoint1.jBg.get();
          if ((((TimePoint)localObject).jBg.get() == null) && (localTimePoint1 != null)) {
            ((TimePoint)localObject).jBg.set(new TimePoint());
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
    CollectSession localCollectSession = (CollectSession)this.gen.get(str);
    if (localCollectSession == null)
    {
      this.gen.put(str, paramCollectSession);
      a(paramCollectSession.groupId, paramCollectSession);
      AppMethodBeat.o(146115);
      return;
    }
    Object localObject = paramCollectSession.jAT;
    paramCollectSession = (CollectSession)localObject;
    if (localCollectSession.jAT == null)
    {
      localCollectSession.jAT = ((TimePoint)localObject);
      AppMethodBeat.o(146115);
      return;
    }
    if (paramCollectSession != null)
    {
      localObject = paramCollectSession.name;
      long l = paramCollectSession.jBf.get();
      if ((str == null) || (str.length() == 0)) {}
      for (;;)
      {
        paramCollectSession = (TimePoint)paramCollectSession.jBg.get();
        break;
        localCollectSession = JK(str);
        if (localCollectSession.jAT == null)
        {
          localCollectSession.ta((String)localObject);
          localCollectSession.jAT.jBf.set(l);
        }
        else
        {
          TimePoint localTimePoint = (TimePoint)localCollectSession.jAV.get(localObject);
          if (localTimePoint == null)
          {
            localCollectSession.JA((String)localObject);
            localCollectSession.jAU.jBf.set(l);
          }
          else
          {
            localTimePoint.jBf.set((l + localTimePoint.jBf.get() * localTimePoint.jBe.get()) / (localTimePoint.jBe.get() + 1));
            localTimePoint.jBe.getAndIncrement();
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
      ac.i("MicroMsg.SumCostTimeCollector", "tryToJoin(%s) failed, sessionId is null or nil.", new Object[] { paramString3 });
      AppMethodBeat.o(146118);
      return;
    }
    if ((paramString1 == null) || (paramString1.length() == 0))
    {
      ac.i("MicroMsg.SumCostTimeCollector", "tryToJoin(%s) failed, groupId is null or nil.", new Object[] { paramString3 });
      AppMethodBeat.o(146118);
      return;
    }
    paramString2 = JK(paramString2);
    if (paramString2.jAT == null)
    {
      paramString2.groupId = paramString1;
      a(paramString1, paramString2);
      paramString2.ta(paramString3);
      AppMethodBeat.o(146118);
      return;
    }
    paramString2.JA(paramString3);
    AppMethodBeat.o(146118);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(146113);
    this.gen.clear();
    this.jBd.clear();
    AppMethodBeat.o(146113);
  }
  
  public final CollectSession cx(String paramString1, String paramString2)
  {
    AppMethodBeat.i(146116);
    if ((paramString1 == null) || (paramString1.length() == 0))
    {
      ac.i("MicroMsg.SumCostTimeCollector", "join(%s) failed, sessionId is null or nil.", new Object[] { paramString2 });
      AppMethodBeat.o(146116);
      return null;
    }
    paramString1 = JK(paramString1);
    if (paramString1.jAT == null) {
      paramString1.ta(paramString2);
    }
    for (;;)
    {
      AppMethodBeat.o(146116);
      return paramString1;
      paramString1.JA(paramString2);
    }
  }
  
  public final void cy(String paramString1, String paramString2)
  {
    AppMethodBeat.i(146121);
    if ((paramString1 == null) || (paramString1.length() == 0) || (paramString2 == null) || (paramString2.length() == 0))
    {
      ac.i("MicroMsg.SumCostTimeCollector", "setLastPointName(%s, %s) failed, sessionId is null or nil.", new Object[] { paramString1, paramString2 });
      AppMethodBeat.o(146121);
      return;
    }
    CollectSession localCollectSession = (CollectSession)this.gen.get(paramString1);
    if (localCollectSession == null)
    {
      ac.i("MicroMsg.SumCostTimeCollector", "setLastPointName(%s, %s) failed,", new Object[] { paramString1, paramString2 });
      AppMethodBeat.o(146121);
      return;
    }
    localCollectSession.jAW = paramString2;
    AppMethodBeat.o(146121);
  }
  
  public final int cz(String paramString1, String paramString2)
  {
    AppMethodBeat.i(146124);
    Set localSet = JJ(paramString1);
    if ((localSet == null) || (localSet.isEmpty()))
    {
      ac.i("MicroMsg.SumCostTimeCollector", "printAverage failed, set(%s) is empty.", new Object[] { paramString1 });
      AppMethodBeat.o(146124);
      return 0;
    }
    paramString1 = new LinkedHashSet(localSet).iterator();
    int i = 0;
    int j = 0;
    while (paramString1.hasNext())
    {
      int k = ((CollectSession)paramString1.next()).djw.getInt(paramString2);
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
      ac.i("MicroMsg.SumCostTimeCollector", "tryToJoin(%s) failed, sessionId is null or nil.", new Object[] { paramString2 });
      AppMethodBeat.o(146117);
      return;
    }
    paramString1 = JK(paramString1);
    if (paramString1.jAT == null)
    {
      paramString1.ta(paramString2);
      AppMethodBeat.o(146117);
      return;
    }
    paramString1.JA(paramString2);
    AppMethodBeat.o(146117);
  }
  
  public final void print(String paramString)
  {
    AppMethodBeat.i(146122);
    CollectSession localCollectSession = (CollectSession)this.gen.get(paramString);
    if (localCollectSession == null)
    {
      ac.i("MicroMsg.SumCostTimeCollector", "print failed, session(%s) is null", new Object[] { paramString });
      AppMethodBeat.o(146122);
      return;
    }
    TimePoint localTimePoint = localCollectSession.jAT;
    if (localTimePoint == null)
    {
      ac.i("MicroMsg.SumCostTimeCollector", "print failed, the session(%s) do not have any point.", new Object[] { paramString });
      AppMethodBeat.o(146122);
      return;
    }
    paramString = e.a(localTimePoint);
    paramString.insert(0, String.format("session : %s\n", new Object[] { localCollectSession.id }));
    ac.i("MicroMsg.SumCostTimeCollector", "%s", new Object[] { paramString.toString() });
    AppMethodBeat.o(146122);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.collector.h
 * JD-Core Version:    0.7.0.1
 */