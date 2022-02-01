package com.tencent.f.j;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public final class a
{
  private static final ThreadLocal<a> RUP;
  private static a RUQ;
  private static final AtomicLong RUR;
  private static final ConcurrentHashMap<String, a> cCB;
  public final d RUS;
  private int RUT;
  public final String tag;
  
  static
  {
    AppMethodBeat.i(183407);
    RUP = new ThreadLocal();
    RUQ = null;
    cCB = new ConcurrentHashMap();
    RUR = new AtomicLong(0L);
    AppMethodBeat.o(183407);
  }
  
  private a(String paramString)
  {
    AppMethodBeat.i(183392);
    this.RUT = 0;
    this.tag = paramString;
    this.RUS = new d(new b(new b.a() {}));
    cCB.put(this.tag, this);
    AppMethodBeat.o(183392);
  }
  
  static void a(a parama)
  {
    AppMethodBeat.i(183394);
    RUP.set(parama);
    AppMethodBeat.o(183394);
  }
  
  public static a bqt(String paramString)
  {
    AppMethodBeat.i(183393);
    paramString = new a(paramString + "@" + RUR.getAndIncrement());
    AppMethodBeat.o(183393);
    return paramString;
  }
  
  public static a bqu(String paramString)
  {
    AppMethodBeat.i(183400);
    paramString = (a)cCB.get(paramString);
    AppMethodBeat.o(183400);
    return paramString;
  }
  
  static a bqv(String paramString)
  {
    try
    {
      AppMethodBeat.i(183401);
      a locala2 = (a)cCB.get(paramString);
      a locala1 = locala2;
      if (locala2 == null) {
        locala1 = new a(paramString);
      }
      AppMethodBeat.o(183401);
      return locala1;
    }
    finally {}
  }
  
  public static a hmD()
  {
    AppMethodBeat.i(183396);
    if (RUQ == null)
    {
      String str = j(Looper.getMainLooper());
      a locala2 = (a)cCB.get(str);
      locala1 = locala2;
      if (locala2 == null) {
        locala1 = new a(str);
      }
      RUQ = locala1;
    }
    a locala1 = RUQ;
    AppMethodBeat.o(183396);
    return locala1;
  }
  
  public static a hmE()
  {
    AppMethodBeat.i(183397);
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      locala = hmD();
      AppMethodBeat.o(183397);
      return locala;
    }
    a locala = (a)RUP.get();
    AppMethodBeat.o(183397);
    return locala;
  }
  
  public static String hmF()
  {
    AppMethodBeat.i(183398);
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      localObject = hmD().tag;
      AppMethodBeat.o(183398);
      return localObject;
    }
    Object localObject = (a)RUP.get();
    if (localObject == null)
    {
      AppMethodBeat.o(183398);
      return null;
    }
    localObject = ((a)localObject).tag;
    AppMethodBeat.o(183398);
    return localObject;
  }
  
  public static Collection<a> hmH()
  {
    AppMethodBeat.i(183402);
    Collection localCollection = cCB.values();
    AppMethodBeat.o(183402);
    return localCollection;
  }
  
  public static String j(Looper paramLooper)
  {
    AppMethodBeat.i(183395);
    if (paramLooper == null)
    {
      AppMethodBeat.o(183395);
      return null;
    }
    paramLooper = paramLooper.getThread();
    paramLooper = paramLooper.getName() + "@" + paramLooper.getId();
    AppMethodBeat.o(183395);
    return paramLooper;
  }
  
  public static void release()
  {
    AppMethodBeat.i(183403);
    Iterator localIterator = cCB.values().iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).RUS.quit();
    }
    cCB.clear();
    AppMethodBeat.o(183403);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(183406);
    if ((paramObject instanceof a))
    {
      boolean bool = ((a)paramObject).tag.equals(this.tag);
      AppMethodBeat.o(183406);
      return bool;
    }
    AppMethodBeat.o(183406);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(183405);
    int i = this.tag.hashCode();
    AppMethodBeat.o(183405);
    return i;
  }
  
  public final d hmG()
  {
    return this.RUS;
  }
  
  public final void quit()
  {
    AppMethodBeat.i(183399);
    this.RUS.quit();
    AppMethodBeat.o(183399);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(183404);
    String str = "[" + this.tag + "]";
    AppMethodBeat.o(183404);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.f.j.a
 * JD-Core Version:    0.7.0.1
 */