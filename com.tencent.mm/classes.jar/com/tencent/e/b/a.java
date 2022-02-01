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
  AtomicLong JZZ;
  private com.tencent.e.a JZj;
  private final d Kaa;
  volatile long Kab;
  private ConcurrentHashMap<String, a> cache;
  
  public a(Context paramContext, com.tencent.e.a parama)
  {
    AppMethodBeat.i(183202);
    this.cache = null;
    this.JZZ = new AtomicLong(0L);
    this.Kab = 0L;
    if (parama.JZg == null) {}
    for (paramContext = new b(paramContext);; paramContext = parama.JZg)
    {
      this.Kaa = paramContext;
      this.JZj = parama;
      fEh();
      AppMethodBeat.o(183202);
      return;
    }
  }
  
  private void fEh()
  {
    AppMethodBeat.i(183211);
    long l = SystemClock.uptimeMillis();
    this.Kaa.delete(this.JZj.uHV);
    StringBuilder localStringBuilder1 = new StringBuilder("[buildCache] successfully! \n");
    StringBuilder localStringBuilder2 = new StringBuilder();
    Iterator localIterator = this.Kaa.fEj().entrySet().iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      String str = (String)((Map.Entry)localObject).getKey();
      localObject = (a)((Map.Entry)localObject).getValue();
      localStringBuilder2.append("# ").append(str).append('-').append(((a)localObject).fEi()).append('\n');
      fEg().put(str, localObject);
      i += 1;
    }
    localStringBuilder1.append("# size:").append(i).append(" cost:").append(SystemClock.uptimeMillis() - l).append("ms\n");
    localStringBuilder1.append(localStringBuilder2);
    com.tencent.e.d.JZD.i("Experience", localStringBuilder1.toString(), new Object[0]);
    AppMethodBeat.o(183211);
  }
  
  public final void a(k paramk)
  {
    AppMethodBeat.i(183203);
    k.fEy().b(paramk.fEz());
    AppMethodBeat.o(183203);
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
          this.Kaa.n(paramConcurrentHashMap.values());
          com.tencent.e.d.JZD.i("Experience", "[persistCache] successfully! size=" + paramConcurrentHashMap.size() + " cost:" + (SystemClock.uptimeMillis() - l), new Object[0]);
          paramConcurrentHashMap.clear();
          AppMethodBeat.o(183212);
        }
        catch (Exception paramConcurrentHashMap)
        {
          com.tencent.e.d.JZD.e("Experience", "%s", new Object[] { paramConcurrentHashMap.toString() });
          AppMethodBeat.o(183212);
        }
        paramConcurrentHashMap = finally;
      }
    }
  }
  
  public final boolean aTB(String paramString)
  {
    AppMethodBeat.i(183209);
    if (paramString == null)
    {
      AppMethodBeat.o(183209);
      return true;
    }
    paramString = (a)fEg().get(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(183209);
      return true;
    }
    if (!paramString.fEi())
    {
      AppMethodBeat.o(183209);
      return true;
    }
    AppMethodBeat.o(183209);
    return false;
  }
  
  public final void b(k paramk)
  {
    AppMethodBeat.i(183204);
    k.fEy().a(paramk.fEz());
    AppMethodBeat.o(183204);
  }
  
  public final void c(k paramk)
  {
    AppMethodBeat.i(183205);
    k.fEy().a(paramk.fEz());
    Object localObject = paramk.fEA();
    b localb = new b(paramk.getKey(), localObject[0], localObject[1], paramk.Kby.getName());
    localObject = (a)fEg().get(localb.name);
    paramk = (k)localObject;
    if (localObject == null)
    {
      paramk = new a(localb.name);
      fEg().put(localb.name, paramk);
    }
    paramk.Kak.add(localb);
    paramk.Kag += (float)localb.vCR;
    paramk.Kah += (float)localb.time;
    int j = paramk.Kak.size();
    int i;
    if (paramk.Kai > localb.rate) {
      if (j <= 5000)
      {
        i = 1;
        if (i == 0) {
          paramk.Kad += paramk.Kai;
        }
        paramk.Kai = localb.rate;
      }
    }
    for (;;)
    {
      if (paramk.Kaj < localb.rate)
      {
        if (j <= 5000)
        {
          i = 1;
          label226:
          if (i == 0) {
            paramk.Kad += paramk.Kaj;
          }
          paramk.Kaj = localb.rate;
        }
      }
      else
      {
        if (i != 0)
        {
          float f = paramk.Kad;
          paramk.Kad = (localb.rate + f);
        }
        if (j > 5000) {
          break label388;
        }
      }
      label388:
      for (i = 0;; i = 2)
      {
        paramk.Kae = (paramk.Kad / (j - i));
        paramk.Kaf = ((paramk.Kag * 1.0F / j));
        paramk.cST = ((paramk.Kah * 1.0F / j));
        if ((this.JZZ.incrementAndGet() >= 5000L) && (System.currentTimeMillis() - this.Kab >= 600000L)) {
          com.tencent.e.h.JZN.aT(new com.tencent.e.i.h()
          {
            public final String getKey()
            {
              return "Experience#persistCache";
            }
            
            public final void run()
            {
              AppMethodBeat.i(183194);
              a.this.a(a.this.fEg());
              a.this.JZZ.set(0L);
              a.this.Kab = System.currentTimeMillis();
              AppMethodBeat.o(183194);
            }
          });
        }
        AppMethodBeat.o(183205);
        return;
        i = 0;
        break;
        i = 0;
        break label226;
      }
      i = 1;
    }
  }
  
  public final void d(k paramk)
  {
    AppMethodBeat.i(183206);
    paramk = paramk.fEz();
    k.fEy().d(paramk);
    AppMethodBeat.o(183206);
  }
  
  public final void e(k paramk)
  {
    AppMethodBeat.i(183207);
    k.fEy().a(paramk.fEz());
    AppMethodBeat.o(183207);
  }
  
  public final void f(k paramk)
  {
    AppMethodBeat.i(183208);
    k.fEy().a(paramk.fEz());
    AppMethodBeat.o(183208);
  }
  
  final ConcurrentHashMap<String, a> fEg()
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
    a(fEg());
    AppMethodBeat.o(183213);
  }
  
  public static final class a
  {
    float Kad;
    float Kae;
    long Kaf;
    float Kag;
    float Kah;
    float Kai;
    float Kaj;
    ConcurrentLinkedQueue<a.b> Kak;
    long cST;
    String name;
    
    public a(String paramString)
    {
      AppMethodBeat.i(183195);
      this.Kad = 0.0F;
      this.Kae = 0.0F;
      this.Kaf = 0L;
      this.cST = 0L;
      this.Kag = 0.0F;
      this.Kah = 0.0F;
      this.Kai = 1.0F;
      this.Kaj = 0.0F;
      this.Kak = new ConcurrentLinkedQueue();
      this.name = paramString;
      AppMethodBeat.o(183195);
    }
    
    public a(String paramString, float paramFloat, long paramLong)
    {
      AppMethodBeat.i(183196);
      this.Kad = 0.0F;
      this.Kae = 0.0F;
      this.Kaf = 0L;
      this.cST = 0L;
      this.Kag = 0.0F;
      this.Kah = 0.0F;
      this.Kai = 1.0F;
      this.Kaj = 0.0F;
      this.Kak = new ConcurrentLinkedQueue();
      this.name = paramString;
      this.Kae = paramFloat;
      this.Kaf = paramLong;
      AppMethodBeat.o(183196);
    }
    
    final boolean fEi()
    {
      return (this.Kaf >= 5000L) || (this.Kae >= 0.5F);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(183197);
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.name).append(" ");
      ((StringBuilder)localObject).append(this.Kae).append(" ");
      ((StringBuilder)localObject).append(fEi()).append(" ");
      ((StringBuilder)localObject).append(this.Kak.size());
      localObject = ((StringBuilder)localObject).toString();
      AppMethodBeat.o(183197);
      return localObject;
    }
  }
  
  public static final class b
  {
    String Kal;
    public String name;
    float rate;
    long time;
    long timestamp;
    long vCR;
    
    public b(String paramString1, long paramLong1, long paramLong2, String paramString2)
    {
      AppMethodBeat.i(183198);
      this.name = paramString1;
      this.vCR = paramLong1;
      this.time = paramLong2;
      this.Kal = paramString2;
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
      String str = this.name + " " + this.vCR + " " + this.time;
      AppMethodBeat.o(183201);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.e.b.a
 * JD-Core Version:    0.7.0.1
 */