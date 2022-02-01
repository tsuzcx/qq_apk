package com.tencent.e.b;

import android.content.Context;
import android.os.SystemClock;
import com.tencent.e.d.a;
import com.tencent.e.i;
import com.tencent.e.i.k;
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
  AtomicLong ZvR;
  private final d ZvS;
  volatile long ZvT;
  private com.tencent.e.a Zvc;
  private ConcurrentHashMap<String, a> cache;
  
  public a(Context paramContext, com.tencent.e.a parama)
  {
    AppMethodBeat.i(183202);
    this.cache = null;
    this.ZvR = new AtomicLong(0L);
    this.ZvT = 0L;
    if (parama.ZuZ == null) {}
    for (paramContext = new b(paramContext);; paramContext = parama.ZuZ)
    {
      this.ZvS = paramContext;
      this.Zvc = parama;
      ipJ();
      AppMethodBeat.o(183202);
      return;
    }
  }
  
  private void ipJ()
  {
    AppMethodBeat.i(183211);
    long l = SystemClock.uptimeMillis();
    this.ZvS.delete(this.Zvc.EWH);
    StringBuilder localStringBuilder1 = new StringBuilder("[buildCache] successfully! \n");
    StringBuilder localStringBuilder2 = new StringBuilder();
    Iterator localIterator = this.ZvS.ipL().entrySet().iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      String str = (String)((Map.Entry)localObject).getKey();
      localObject = (a)((Map.Entry)localObject).getValue();
      localStringBuilder2.append("# ").append(str).append('-').append(((a)localObject).ipK()).append('\n');
      ipI().put(str, localObject);
      i += 1;
    }
    localStringBuilder1.append("# size:").append(i).append(" cost:").append(SystemClock.uptimeMillis() - l).append("ms\n");
    localStringBuilder1.append(localStringBuilder2);
    com.tencent.e.d.Zvw.i("Experience", localStringBuilder1.toString(), new Object[0]);
    AppMethodBeat.o(183211);
  }
  
  public final void Xq()
  {
    AppMethodBeat.i(183213);
    a(ipI());
    AppMethodBeat.o(183213);
  }
  
  public final void a(k paramk)
  {
    AppMethodBeat.i(183206);
    paramk = paramk.iqc();
    k.iqb().d(paramk);
    AppMethodBeat.o(183206);
  }
  
  public final void a(k paramk, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(244258);
    k.iqb().a(paramk.iqc());
    Object localObject = paramk.iqd();
    b localb = new b(paramk.getKey(), localObject[0], localObject[1], paramk.Zxn.getName());
    localObject = (a)ipI().get(localb.name);
    paramk = (k)localObject;
    if (localObject == null)
    {
      paramk = new a(localb.name);
      ipI().put(localb.name, paramk);
    }
    paramk.Zwc.add(localb);
    paramk.ZvY += (float)localb.GOR;
    paramk.ZvZ += (float)localb.time;
    int j = paramk.Zwc.size();
    int i = 1;
    if (paramk.Zwa > localb.rate)
    {
      if (j <= 5000)
      {
        i = 1;
        if (i == 0) {
          paramk.ZvV += paramk.Zwa;
        }
        paramk.Zwa = localb.rate;
      }
    }
    else
    {
      if (paramk.Zwb < localb.rate)
      {
        if (j > 5000) {
          break label396;
        }
        i = 1;
        label232:
        if (i == 0) {
          paramk.ZvV += paramk.Zwb;
        }
        paramk.Zwb = localb.rate;
      }
      if (i != 0)
      {
        float f = paramk.ZvV;
        paramk.ZvV = (localb.rate + f);
      }
      if (j > 5000) {
        break label402;
      }
    }
    label396:
    label402:
    for (i = 0;; i = 2)
    {
      paramk.ZvW = (paramk.ZvV / (j - i));
      paramk.ZvX = ((1.0F * paramk.ZvY / j));
      paramk.fpe = ((1.0F * paramk.ZvZ / j));
      if ((this.ZvR.incrementAndGet() >= 5000L) && (System.currentTimeMillis() - this.ZvT >= 600000L)) {
        com.tencent.e.h.ZvG.bf(new com.tencent.e.i.h()
        {
          public final String getKey()
          {
            return "Experience#persistCache";
          }
          
          public final void run()
          {
            AppMethodBeat.i(183194);
            a.this.a(a.this.ipI());
            a.this.ZvR.set(0L);
            a.this.ZvT = System.currentTimeMillis();
            AppMethodBeat.o(183194);
          }
        });
      }
      AppMethodBeat.o(244258);
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
          this.ZvS.o(paramConcurrentHashMap.values());
          com.tencent.e.d.Zvw.i("Experience", "[persistCache] successfully! size=" + paramConcurrentHashMap.size() + " cost:" + (SystemClock.uptimeMillis() - l), new Object[0]);
          paramConcurrentHashMap.clear();
          AppMethodBeat.o(183212);
        }
        catch (Exception paramConcurrentHashMap)
        {
          com.tencent.e.d.Zvw.e("Experience", "%s", new Object[] { paramConcurrentHashMap.toString() });
          AppMethodBeat.o(183212);
        }
        paramConcurrentHashMap = finally;
      }
    }
  }
  
  public final void b(k paramk)
  {
    AppMethodBeat.i(183204);
    k.iqb().a(paramk.iqc());
    AppMethodBeat.o(183204);
  }
  
  public final void c(k paramk)
  {
    AppMethodBeat.i(183207);
    k.iqb().a(paramk.iqc());
    AppMethodBeat.o(183207);
  }
  
  public final void d(k paramk)
  {
    AppMethodBeat.i(183203);
    k.iqb().b(paramk.iqc());
    AppMethodBeat.o(183203);
  }
  
  public final void e(k paramk)
  {
    AppMethodBeat.i(183208);
    k.iqb().a(paramk.iqc());
    AppMethodBeat.o(183208);
  }
  
  public final boolean fs(String paramString)
  {
    AppMethodBeat.i(183209);
    if (paramString == null)
    {
      AppMethodBeat.o(183209);
      return true;
    }
    paramString = (a)ipI().get(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(183209);
      return true;
    }
    if (!paramString.ipK())
    {
      AppMethodBeat.o(183209);
      return true;
    }
    AppMethodBeat.o(183209);
    return false;
  }
  
  final ConcurrentHashMap<String, a> ipI()
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
  
  public static final class a
  {
    float ZvV;
    float ZvW;
    long ZvX;
    float ZvY;
    float ZvZ;
    float Zwa;
    float Zwb;
    ConcurrentLinkedQueue<a.b> Zwc;
    long fpe;
    String name;
    
    public a(String paramString)
    {
      AppMethodBeat.i(183195);
      this.ZvV = 0.0F;
      this.ZvW = 0.0F;
      this.ZvX = 0L;
      this.fpe = 0L;
      this.ZvY = 0.0F;
      this.ZvZ = 0.0F;
      this.Zwa = 1.0F;
      this.Zwb = 0.0F;
      this.Zwc = new ConcurrentLinkedQueue();
      this.name = paramString;
      AppMethodBeat.o(183195);
    }
    
    public a(String paramString, float paramFloat, long paramLong)
    {
      AppMethodBeat.i(183196);
      this.ZvV = 0.0F;
      this.ZvW = 0.0F;
      this.ZvX = 0L;
      this.fpe = 0L;
      this.ZvY = 0.0F;
      this.ZvZ = 0.0F;
      this.Zwa = 1.0F;
      this.Zwb = 0.0F;
      this.Zwc = new ConcurrentLinkedQueue();
      this.name = paramString;
      this.ZvW = paramFloat;
      this.ZvX = paramLong;
      AppMethodBeat.o(183196);
    }
    
    final boolean ipK()
    {
      return (this.ZvX >= 5000L) || (this.ZvW >= 0.5F);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(183197);
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.name).append(" ");
      ((StringBuilder)localObject).append(this.ZvW).append(" ");
      ((StringBuilder)localObject).append(ipK()).append(" ");
      ((StringBuilder)localObject).append(this.Zwc.size());
      localObject = ((StringBuilder)localObject).toString();
      AppMethodBeat.o(183197);
      return localObject;
    }
  }
  
  public static final class b
  {
    long GOR;
    String Zwd;
    public String name;
    float rate;
    long time;
    long timestamp;
    
    public b(String paramString1, long paramLong1, long paramLong2, String paramString2)
    {
      AppMethodBeat.i(183198);
      this.name = paramString1;
      this.GOR = paramLong1;
      this.time = paramLong2;
      this.Zwd = paramString2;
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
      String str = this.name + " " + this.GOR + " " + this.time;
      AppMethodBeat.o(183201);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.e.b.a
 * JD-Core Version:    0.7.0.1
 */