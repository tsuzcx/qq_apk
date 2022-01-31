package com.tencent.mm.plugin.appbrand.collector;

import android.os.Bundle;
import com.tencent.mm.sdk.platformtools.y;
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
  private Map<String, CollectSession> dHb = new a();
  private Map<String, Set<CollectSession>> fNv = new a();
  
  private boolean a(String paramString, CollectSession paramCollectSession)
  {
    if ((paramString == null) || (paramString.length() == 0) || (paramCollectSession == null)) {
      return false;
    }
    Set localSet = (Set)this.fNv.get(paramString);
    Object localObject = localSet;
    if (localSet == null)
    {
      localObject = new LinkedHashSet();
      this.fNv.put(paramString, localObject);
    }
    return ((Set)localObject).add(paramCollectSession);
  }
  
  private Set<CollectSession> sb(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      return null;
    }
    return (Set)this.fNv.get(paramString);
  }
  
  private CollectSession sc(String paramString)
  {
    CollectSession localCollectSession2 = (CollectSession)this.dHb.get(paramString);
    CollectSession localCollectSession1 = localCollectSession2;
    if (localCollectSession2 == null)
    {
      localCollectSession1 = new CollectSession(paramString);
      this.dHb.put(paramString, localCollectSession1);
    }
    return localCollectSession1;
  }
  
  public final void a(CollectSession paramCollectSession)
  {
    String str = paramCollectSession.id;
    CollectSession localCollectSession = (CollectSession)this.dHb.get(str);
    if (localCollectSession == null)
    {
      this.dHb.put(str, paramCollectSession);
      a(paramCollectSession.groupId, paramCollectSession);
      return;
    }
    Object localObject = paramCollectSession.fNl;
    paramCollectSession = (CollectSession)localObject;
    if (localCollectSession.fNl == null)
    {
      localCollectSession.fNl = ((TimePoint)localObject);
      return;
    }
    label76:
    long l;
    if (paramCollectSession != null)
    {
      localObject = paramCollectSession.name;
      l = paramCollectSession.fNx.get();
      if ((str != null) && (str.length() != 0)) {
        break label121;
      }
    }
    for (;;)
    {
      paramCollectSession = (TimePoint)paramCollectSession.fNy.get();
      break label76;
      break;
      label121:
      localCollectSession = sc(str);
      if (localCollectSession.fNl == null)
      {
        localCollectSession.rR((String)localObject);
        localCollectSession.fNl.fNx.set(l);
      }
      else
      {
        TimePoint localTimePoint = (TimePoint)localCollectSession.fNn.get(localObject);
        if (localTimePoint == null)
        {
          localCollectSession.rS((String)localObject);
          localCollectSession.fNm.fNx.set(l);
        }
        else
        {
          localTimePoint.fNx.set((l + localTimePoint.fNx.get() * localTimePoint.fNw.get()) / (localTimePoint.fNw.get() + 1));
          localTimePoint.fNw.getAndIncrement();
        }
      }
    }
  }
  
  public final CollectSession bf(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString1.length() == 0))
    {
      y.i("MicroMsg.SumCostTimeCollector", "join(%s) failed, sessionId is null or nil.", new Object[] { paramString2 });
      return null;
    }
    paramString1 = sc(paramString1);
    if (paramString1.fNl == null)
    {
      paramString1.rR(paramString2);
      return paramString1;
    }
    paramString1.rS(paramString2);
    return paramString1;
  }
  
  public final void bg(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString1.length() == 0) || (paramString2 == null) || (paramString2.length() == 0))
    {
      y.i("MicroMsg.SumCostTimeCollector", "setLastPointName(%s, %s) failed, sessionId is null or nil.", new Object[] { paramString1, paramString2 });
      return;
    }
    CollectSession localCollectSession = (CollectSession)this.dHb.get(paramString1);
    if (localCollectSession == null)
    {
      y.i("MicroMsg.SumCostTimeCollector", "setLastPointName(%s, %s) failed,", new Object[] { paramString1, paramString2 });
      return;
    }
    localCollectSession.fNo = paramString2;
  }
  
  public final int bh(String paramString1, String paramString2)
  {
    Set localSet = sb(paramString1);
    if ((localSet == null) || (localSet.isEmpty())) {
      y.i("MicroMsg.SumCostTimeCollector", "printAverage failed, set(%s) is empty.", new Object[] { paramString1 });
    }
    int i;
    int j;
    do
    {
      return 0;
      paramString1 = new LinkedHashSet(localSet).iterator();
      i = 0;
      j = 0;
      while (paramString1.hasNext())
      {
        int k = ((CollectSession)paramString1.next()).bOY.getInt(paramString2);
        if (k != 0)
        {
          j += k;
          i += 1;
        }
      }
    } while (i == 0);
    return j / i;
  }
  
  public final void c(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    if (!paramBoolean) {
      return;
    }
    if ((paramString2 == null) || (paramString2.length() == 0))
    {
      y.i("MicroMsg.SumCostTimeCollector", "tryToJoin(%s) failed, sessionId is null or nil.", new Object[] { paramString3 });
      return;
    }
    if ((paramString1 == null) || (paramString1.length() == 0))
    {
      y.i("MicroMsg.SumCostTimeCollector", "tryToJoin(%s) failed, groupId is null or nil.", new Object[] { paramString3 });
      return;
    }
    paramString2 = sc(paramString2);
    if (paramString2.fNl == null)
    {
      paramString2.groupId = paramString1;
      a(paramString1, paramString2);
      paramString2.rR(paramString3);
      return;
    }
    paramString2.rS(paramString3);
  }
  
  public final void clear()
  {
    this.dHb.clear();
    this.fNv.clear();
  }
  
  public final void j(String paramString1, String paramString2, boolean paramBoolean)
  {
    if (!paramBoolean) {
      return;
    }
    if ((paramString1 == null) || (paramString1.length() == 0))
    {
      y.i("MicroMsg.SumCostTimeCollector", "tryToJoin(%s) failed, sessionId is null or nil.", new Object[] { paramString2 });
      return;
    }
    paramString1 = sc(paramString1);
    if (paramString1.fNl == null)
    {
      paramString1.rR(paramString2);
      return;
    }
    paramString1.rS(paramString2);
  }
  
  public final void print(String paramString)
  {
    CollectSession localCollectSession = (CollectSession)this.dHb.get(paramString);
    if (localCollectSession == null)
    {
      y.i("MicroMsg.SumCostTimeCollector", "print failed, session(%s) is null", new Object[] { paramString });
      return;
    }
    TimePoint localTimePoint = localCollectSession.fNl;
    if (localTimePoint == null)
    {
      y.i("MicroMsg.SumCostTimeCollector", "print failed, the session(%s) do not have any point.", new Object[] { paramString });
      return;
    }
    paramString = e.a(localTimePoint);
    paramString.insert(0, String.format("session : %s\n", new Object[] { localCollectSession.id }));
    y.i("MicroMsg.SumCostTimeCollector", "%s", new Object[] { paramString.toString() });
  }
  
  public final CollectSession rT(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      return null;
    }
    return (CollectSession)this.dHb.get(paramString);
  }
  
  public final CollectSession rU(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      return null;
    }
    return (CollectSession)this.dHb.remove(paramString);
  }
  
  public final StringBuilder rV(String paramString)
  {
    Object localObject = sb(paramString);
    if ((localObject == null) || (((Set)localObject).isEmpty()))
    {
      y.i("MicroMsg.SumCostTimeCollector", "printAverage failed, set(%s) is empty.", new Object[] { paramString });
      return new StringBuilder().append(String.format("GroupId : %s, size : 0\n", new Object[] { paramString }));
    }
    LinkedHashSet localLinkedHashSet = new LinkedHashSet((Collection)localObject);
    TimePoint localTimePoint2 = new TimePoint();
    Iterator localIterator = localLinkedHashSet.iterator();
    while (localIterator.hasNext())
    {
      localObject = (CollectSession)localIterator.next();
      if ((((CollectSession)localObject).fNm == null) || ((((CollectSession)localObject).fNo != null) && (!((CollectSession)localObject).fNm.name.equals(((CollectSession)localObject).fNo))))
      {
        y.e("MicroMsg.SumCostTimeCollector", "error(%s), incorrect point count", new Object[] { ((CollectSession)localObject).id });
      }
      else
      {
        TimePoint localTimePoint1 = ((CollectSession)localObject).fNl;
        for (localObject = localTimePoint2; localTimePoint1 != null; localObject = (TimePoint)((TimePoint)localObject).fNy.get())
        {
          ((TimePoint)localObject).fNx.set((((TimePoint)localObject).fNx.get() * ((TimePoint)localObject).fNw.get() + localTimePoint1.fNx.get()) / ((TimePoint)localObject).fNw.incrementAndGet());
          ((TimePoint)localObject).name = localTimePoint1.name;
          localTimePoint1 = (TimePoint)localTimePoint1.fNy.get();
          if ((((TimePoint)localObject).fNy.get() == null) && (localTimePoint1 != null)) {
            ((TimePoint)localObject).fNy.set(new TimePoint());
          }
        }
      }
    }
    localObject = e.a(localTimePoint2);
    ((StringBuilder)localObject).insert(0, String.format("GroupId : %s, size : %d\n", new Object[] { paramString, Integer.valueOf(localLinkedHashSet.size()) }));
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.collector.h
 * JD-Core Version:    0.7.0.1
 */