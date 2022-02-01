package com.tencent.mm.plugin.appbrand.collector;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
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
  private Map<String, CollectSession> mMap;
  private Map<String, Set<CollectSession>> qVg;
  
  public h()
  {
    AppMethodBeat.i(146110);
    this.mMap = new a();
    this.qVg = new a();
    AppMethodBeat.o(146110);
  }
  
  private Set<CollectSession> Xh(String paramString)
  {
    AppMethodBeat.i(146112);
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(146112);
      return null;
    }
    paramString = (Set)this.qVg.get(paramString);
    AppMethodBeat.o(146112);
    return paramString;
  }
  
  private CollectSession Xi(String paramString)
  {
    AppMethodBeat.i(146114);
    CollectSession localCollectSession2 = (CollectSession)this.mMap.get(paramString);
    CollectSession localCollectSession1 = localCollectSession2;
    if (localCollectSession2 == null)
    {
      localCollectSession1 = new CollectSession(paramString);
      this.mMap.put(paramString, localCollectSession1);
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
    Set localSet = (Set)this.qVg.get(paramString);
    Object localObject = localSet;
    if (localSet == null)
    {
      localObject = new LinkedHashSet();
      this.qVg.put(paramString, localObject);
    }
    boolean bool = ((Set)localObject).add(paramCollectSession);
    AppMethodBeat.o(146111);
    return bool;
  }
  
  public final CollectSession WY(String paramString)
  {
    AppMethodBeat.i(146119);
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(146119);
      return null;
    }
    paramString = (CollectSession)this.mMap.get(paramString);
    AppMethodBeat.o(146119);
    return paramString;
  }
  
  public final CollectSession WZ(String paramString)
  {
    AppMethodBeat.i(146120);
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(146120);
      return null;
    }
    paramString = (CollectSession)this.mMap.remove(paramString);
    AppMethodBeat.o(146120);
    return paramString;
  }
  
  public final void Xa(String paramString)
  {
    AppMethodBeat.i(146122);
    CollectSession localCollectSession = (CollectSession)this.mMap.get(paramString);
    if (localCollectSession == null)
    {
      Log.i("MicroMsg.SumCostTimeCollector", "print failed, session(%s) is null", new Object[] { paramString });
      AppMethodBeat.o(146122);
      return;
    }
    TimePoint localTimePoint = localCollectSession.qUW;
    if (localTimePoint == null)
    {
      Log.i("MicroMsg.SumCostTimeCollector", "print failed, the session(%s) do not have any point.", new Object[] { paramString });
      AppMethodBeat.o(146122);
      return;
    }
    paramString = e.a(localTimePoint);
    paramString.insert(0, String.format("session : %s\n", new Object[] { localCollectSession.id }));
    Log.i("MicroMsg.SumCostTimeCollector", "%s", new Object[] { paramString.toString() });
    AppMethodBeat.o(146122);
  }
  
  public final StringBuilder Xb(String paramString)
  {
    AppMethodBeat.i(146123);
    Object localObject = Xh(paramString);
    if ((localObject == null) || (((Set)localObject).isEmpty()))
    {
      Log.i("MicroMsg.SumCostTimeCollector", "printAverage failed, set(%s) is empty.", new Object[] { paramString });
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
      if ((((CollectSession)localObject).qUX == null) || ((((CollectSession)localObject).qUZ != null) && (!((CollectSession)localObject).qUX.name.equals(((CollectSession)localObject).qUZ))))
      {
        Log.e("MicroMsg.SumCostTimeCollector", "error(%s), incorrect point count", new Object[] { ((CollectSession)localObject).id });
      }
      else
      {
        TimePoint localTimePoint1 = ((CollectSession)localObject).qUW;
        for (localObject = localTimePoint2; localTimePoint1 != null; localObject = (TimePoint)((TimePoint)localObject).qVj.get())
        {
          ((TimePoint)localObject).qVi.set((((TimePoint)localObject).qVi.get() * ((TimePoint)localObject).qVh.get() + localTimePoint1.qVi.get()) / ((TimePoint)localObject).qVh.incrementAndGet());
          ((TimePoint)localObject).name = localTimePoint1.name;
          localTimePoint1 = (TimePoint)localTimePoint1.qVj.get();
          if ((((TimePoint)localObject).qVj.get() == null) && (localTimePoint1 != null)) {
            ((TimePoint)localObject).qVj.set(new TimePoint());
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
    CollectSession localCollectSession = (CollectSession)this.mMap.get(str);
    if (localCollectSession == null)
    {
      this.mMap.put(str, paramCollectSession);
      a(paramCollectSession.groupId, paramCollectSession);
      AppMethodBeat.o(146115);
      return;
    }
    Object localObject = paramCollectSession.qUW;
    paramCollectSession = (CollectSession)localObject;
    if (localCollectSession.qUW == null)
    {
      localCollectSession.qUW = ((TimePoint)localObject);
      AppMethodBeat.o(146115);
      return;
    }
    if (paramCollectSession != null)
    {
      localObject = paramCollectSession.name;
      long l = paramCollectSession.qVi.get();
      if ((str == null) || (str.length() == 0)) {}
      for (;;)
      {
        paramCollectSession = (TimePoint)paramCollectSession.qVj.get();
        break;
        localCollectSession = Xi(str);
        if (localCollectSession.qUW == null)
        {
          localCollectSession.WW((String)localObject);
          localCollectSession.qUW.qVi.set(l);
        }
        else
        {
          TimePoint localTimePoint = (TimePoint)localCollectSession.qUY.get(localObject);
          if (localTimePoint == null)
          {
            localCollectSession.WX((String)localObject);
            localCollectSession.qUX.qVi.set(l);
          }
          else
          {
            localTimePoint.qVi.set((l + localTimePoint.qVi.get() * localTimePoint.qVh.get()) / (localTimePoint.qVh.get() + 1));
            localTimePoint.qVh.getAndIncrement();
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
      Log.i("MicroMsg.SumCostTimeCollector", "tryToJoin(%s) failed, sessionId is null or nil.", new Object[] { paramString3 });
      AppMethodBeat.o(146118);
      return;
    }
    if ((paramString1 == null) || (paramString1.length() == 0))
    {
      Log.i("MicroMsg.SumCostTimeCollector", "tryToJoin(%s) failed, groupId is null or nil.", new Object[] { paramString3 });
      AppMethodBeat.o(146118);
      return;
    }
    paramString2 = Xi(paramString2);
    if (paramString2.qUW == null)
    {
      paramString2.groupId = paramString1;
      a(paramString1, paramString2);
      paramString2.WW(paramString3);
      AppMethodBeat.o(146118);
      return;
    }
    paramString2.WX(paramString3);
    AppMethodBeat.o(146118);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(146113);
    this.mMap.clear();
    this.qVg.clear();
    AppMethodBeat.o(146113);
  }
  
  public final CollectSession dp(String paramString1, String paramString2)
  {
    AppMethodBeat.i(146116);
    if ((paramString1 == null) || (paramString1.length() == 0))
    {
      Log.i("MicroMsg.SumCostTimeCollector", "join(%s) failed, sessionId is null or nil.", new Object[] { paramString2 });
      AppMethodBeat.o(146116);
      return null;
    }
    paramString1 = Xi(paramString1);
    if (paramString1.qUW == null) {
      paramString1.WW(paramString2);
    }
    for (;;)
    {
      AppMethodBeat.o(146116);
      return paramString1;
      paramString1.WX(paramString2);
    }
  }
  
  public final void dq(String paramString1, String paramString2)
  {
    AppMethodBeat.i(146121);
    if ((paramString1 == null) || (paramString1.length() == 0) || (paramString2 == null) || (paramString2.length() == 0))
    {
      Log.i("MicroMsg.SumCostTimeCollector", "setLastPointName(%s, %s) failed, sessionId is null or nil.", new Object[] { paramString1, paramString2 });
      AppMethodBeat.o(146121);
      return;
    }
    CollectSession localCollectSession = (CollectSession)this.mMap.get(paramString1);
    if (localCollectSession == null)
    {
      Log.i("MicroMsg.SumCostTimeCollector", "setLastPointName(%s, %s) failed,", new Object[] { paramString1, paramString2 });
      AppMethodBeat.o(146121);
      return;
    }
    localCollectSession.qUZ = paramString2;
    AppMethodBeat.o(146121);
  }
  
  public final int dr(String paramString1, String paramString2)
  {
    AppMethodBeat.i(146124);
    Set localSet = Xh(paramString1);
    if ((localSet == null) || (localSet.isEmpty()))
    {
      Log.i("MicroMsg.SumCostTimeCollector", "printAverage failed, set(%s) is empty.", new Object[] { paramString1 });
      AppMethodBeat.o(146124);
      return 0;
    }
    paramString1 = new LinkedHashSet(localSet).iterator();
    int i = 0;
    int j = 0;
    while (paramString1.hasNext())
    {
      int k = ((CollectSession)paramString1.next()).hMD.getInt(paramString2);
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
  
  public final void o(String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(146117);
    if (!paramBoolean)
    {
      AppMethodBeat.o(146117);
      return;
    }
    if ((paramString1 == null) || (paramString1.length() == 0))
    {
      Log.i("MicroMsg.SumCostTimeCollector", "tryToJoin(%s) failed, sessionId is null or nil.", new Object[] { paramString2 });
      AppMethodBeat.o(146117);
      return;
    }
    paramString1 = Xi(paramString1);
    if (paramString1.qUW == null)
    {
      paramString1.WW(paramString2);
      AppMethodBeat.o(146117);
      return;
    }
    paramString1.WX(paramString2);
    AppMethodBeat.o(146117);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.collector.h
 * JD-Core Version:    0.7.0.1
 */