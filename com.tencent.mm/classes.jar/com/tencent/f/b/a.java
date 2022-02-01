package com.tencent.f.b;

import android.content.Context;
import android.os.SystemClock;
import com.tencent.f.d.a;
import com.tencent.f.i;
import com.tencent.f.i.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicLong;

public final class a
  implements c
{
  private com.tencent.f.a RSy;
  AtomicLong RTo;
  private final d RTp;
  volatile long RTq;
  private ConcurrentHashMap<String, a> cache;
  
  public a(Context paramContext, com.tencent.f.a parama)
  {
    AppMethodBeat.i(183202);
    this.cache = null;
    this.RTo = new AtomicLong(0L);
    this.RTq = 0L;
    if (parama.RSv == null) {}
    for (paramContext = new b(paramContext);; paramContext = parama.RSv)
    {
      this.RTp = paramContext;
      this.RSy = parama;
      hmj();
      AppMethodBeat.o(183202);
      return;
    }
  }
  
  private void hmj()
  {
    AppMethodBeat.i(183211);
    long l = SystemClock.uptimeMillis();
    this.RTp.delete(this.RSy.zrg);
    StringBuilder localStringBuilder1 = new StringBuilder("[buildCache] successfully! \n");
    StringBuilder localStringBuilder2 = new StringBuilder();
    Iterator localIterator = this.RTp.hml().entrySet().iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      String str = (String)((Map.Entry)localObject).getKey();
      localObject = (a)((Map.Entry)localObject).getValue();
      localStringBuilder2.append("# ").append(str).append('-').append(((a)localObject).hmk()).append('\n');
      hmi().put(str, localObject);
      i += 1;
    }
    localStringBuilder1.append("# size:").append(i).append(" cost:").append(SystemClock.uptimeMillis() - l).append("ms\n");
    localStringBuilder1.append(localStringBuilder2);
    com.tencent.f.d.RSS.i("Experience", localStringBuilder1.toString(), new Object[0]);
    AppMethodBeat.o(183211);
  }
  
  public final void a(k paramk)
  {
    AppMethodBeat.i(183206);
    paramk = paramk.hmB();
    k.hmA().d(paramk);
    AppMethodBeat.o(183206);
  }
  
  public final void a(k paramk, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(256667);
    k.hmA().a(paramk.hmB());
    Object localObject = paramk.hmC();
    b localb = new b(paramk.getKey(), localObject[0], localObject[1], paramk.RUL.getName());
    localObject = (a)hmi().get(localb.name);
    paramk = (k)localObject;
    if (localObject == null)
    {
      paramk = new a(localb.name);
      hmi().put(localb.name, paramk);
    }
    paramk.RTz.add(localb);
    paramk.RTv += (float)localb.AVw;
    paramk.RTw += (float)localb.time;
    int j = paramk.RTz.size();
    int i = 1;
    if (paramk.RTx > localb.rate)
    {
      if (j <= 5000)
      {
        i = 1;
        if (i == 0) {
          paramk.RTs += paramk.RTx;
        }
        paramk.RTx = localb.rate;
      }
    }
    else
    {
      if (paramk.RTy < localb.rate)
      {
        if (j > 5000) {
          break label396;
        }
        i = 1;
        label232:
        if (i == 0) {
          paramk.RTs += paramk.RTy;
        }
        paramk.RTy = localb.rate;
      }
      if (i != 0)
      {
        float f = paramk.RTs;
        paramk.RTs = (localb.rate + f);
      }
      if (j > 5000) {
        break label402;
      }
    }
    label396:
    label402:
    for (i = 0;; i = 2)
    {
      paramk.RTt = (paramk.RTs / (j - i));
      paramk.RTu = ((1.0F * paramk.RTv / j));
      paramk.dwv = ((1.0F * paramk.RTw / j));
      if ((this.RTo.incrementAndGet() >= 5000L) && (System.currentTimeMillis() - this.RTq >= 600000L)) {
        com.tencent.f.h.RTc.aY(new com.tencent.f.i.h()
        {
          public final String getKey()
          {
            return "Experience#persistCache";
          }
          
          public final void run()
          {
            AppMethodBeat.i(183194);
            a.this.a(a.this.hmi());
            a.this.RTo.set(0L);
            a.this.RTq = System.currentTimeMillis();
            AppMethodBeat.o(183194);
          }
        });
      }
      AppMethodBeat.o(256667);
      return;
      i = 0;
      break;
      i = 0;
      break label232;
    }
  }
  
  final void a(ConcurrentHashMap<String, a> paramConcurrentHashMap)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(183212);
        if (paramConcurrentHashMap.size() <= 0)
        {
          AppMethodBeat.o(183212);
          return;
        }
        l = SystemClock.uptimeMillis();
      }
      finally
      {
        try
        {
          long l;
          this.RTp.q(paramConcurrentHashMap.values());
          com.tencent.f.d.RSS.i("Experience", "[persistCache] successfully! size=" + paramConcurrentHashMap.size() + " cost:" + (SystemClock.uptimeMillis() - l), new Object[0]);
          paramConcurrentHashMap.clear();
          AppMethodBeat.o(183212);
        }
        catch (Exception paramConcurrentHashMap)
        {
          com.tencent.f.d.RSS.e("Experience", "%s", new Object[] { paramConcurrentHashMap.toString() });
          AppMethodBeat.o(183212);
        }
        paramConcurrentHashMap = finally;
      }
    }
  }
  
  public final void b(k paramk)
  {
    AppMethodBeat.i(183204);
    k.hmA().a(paramk.hmB());
    AppMethodBeat.o(183204);
  }
  
  public final void c(k paramk)
  {
    AppMethodBeat.i(183207);
    k.hmA().a(paramk.hmB());
    AppMethodBeat.o(183207);
  }
  
  public final void d(k paramk)
  {
    AppMethodBeat.i(183203);
    k.hmA().b(paramk.hmB());
    AppMethodBeat.o(183203);
  }
  
  public final void e(k paramk)
  {
    AppMethodBeat.i(183208);
    k.hmA().a(paramk.hmB());
    AppMethodBeat.o(183208);
  }
  
  public final boolean ez(String paramString)
  {
    AppMethodBeat.i(183209);
    if (paramString == null)
    {
      AppMethodBeat.o(183209);
      return true;
    }
    paramString = (a)hmi().get(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(183209);
      return true;
    }
    if (!paramString.hmk())
    {
      AppMethodBeat.o(183209);
      return true;
    }
    AppMethodBeat.o(183209);
    return false;
  }
  
  final ConcurrentHashMap<String, a> hmi()
  {
    AppMethodBeat.i(183210);
    if (this.cache == null) {}
    try
    {
      if (this.cache == null) {
        this.cache = new ConcurrentHashMap();
      }
      ConcurrentHashMap localConcurrentHashMap = this.cache;
      AppMethodBeat.o(183210);
      return localConcurrentHashMap;
    }
    finally
    {
      AppMethodBeat.o(183210);
    }
  }
  
  public final void onShutdown()
  {
    AppMethodBeat.i(183213);
    a(hmi());
    AppMethodBeat.o(183213);
  }
  
  public static final class a
  {
    float RTs;
    float RTt;
    long RTu;
    float RTv;
    float RTw;
    float RTx;
    float RTy;
    ConcurrentLinkedQueue<a.b> RTz;
    long dwv;
    String name;
    
    public a(String paramString)
    {
      AppMethodBeat.i(183195);
      this.RTs = 0.0F;
      this.RTt = 0.0F;
      this.RTu = 0L;
      this.dwv = 0L;
      this.RTv = 0.0F;
      this.RTw = 0.0F;
      this.RTx = 1.0F;
      this.RTy = 0.0F;
      this.RTz = new ConcurrentLinkedQueue();
      this.name = paramString;
      AppMethodBeat.o(183195);
    }
    
    public a(String paramString, float paramFloat, long paramLong)
    {
      AppMethodBeat.i(183196);
      this.RTs = 0.0F;
      this.RTt = 0.0F;
      this.RTu = 0L;
      this.dwv = 0L;
      this.RTv = 0.0F;
      this.RTw = 0.0F;
      this.RTx = 1.0F;
      this.RTy = 0.0F;
      this.RTz = new ConcurrentLinkedQueue();
      this.name = paramString;
      this.RTt = paramFloat;
      this.RTu = paramLong;
      AppMethodBeat.o(183196);
    }
    
    final boolean hmk()
    {
      return (this.RTu >= 5000L) || (this.RTt >= 0.5F);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(183197);
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.name).append(" ");
      ((StringBuilder)localObject).append(this.RTt).append(" ");
      ((StringBuilder)localObject).append(hmk()).append(" ");
      ((StringBuilder)localObject).append(this.RTz.size());
      localObject = ((StringBuilder)localObject).toString();
      AppMethodBeat.o(183197);
      return localObject;
    }
  }
  
  public static final class b
  {
    long AVw;
    String RTA;
    public String name;
    float rate;
    long time;
    long timestamp;
    
    public b(String paramString1, long paramLong1, long paramLong2, String paramString2)
    {
      AppMethodBeat.i(183198);
      this.name = paramString1;
      this.AVw = paramLong1;
      this.time = paramLong2;
      this.RTA = paramString2;
      if (paramLong2 <= 1L) {}
      for (;;)
      {
        this.rate = f;
        this.timestamp = System.currentTimeMillis();
        AppMethodBeat.o(183198);
        return;
        f = 1.0F * (float)paramLong1 / (float)paramLong2;
      }
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(183200);
      boolean bool = this.name.equals(paramObject);
      AppMethodBeat.o(183200);
      return bool;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(183199);
      int i = this.name.hashCode();
      AppMethodBeat.o(183199);
      return i;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(183201);
      String str = this.name + " " + this.AVw + " " + this.time;
      AppMethodBeat.o(183201);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.f.b.a
 * JD-Core Version:    0.7.0.1
 */