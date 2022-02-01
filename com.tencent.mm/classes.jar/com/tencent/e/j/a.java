package com.tencent.e.j;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public final class a
{
  private static a LVA;
  private static final AtomicLong LVB;
  private static final ThreadLocal<a> LVz;
  private static final ConcurrentHashMap<String, a> cpF;
  public final d LVC;
  private int LVD;
  public final String tag;
  
  static
  {
    AppMethodBeat.i(183407);
    LVz = new ThreadLocal();
    LVA = null;
    cpF = new ConcurrentHashMap();
    LVB = new AtomicLong(0L);
    AppMethodBeat.o(183407);
  }
  
  private a(String paramString)
  {
    AppMethodBeat.i(183392);
    this.LVD = 0;
    this.tag = paramString;
    this.LVC = new d(new b(new b.a() {}));
    cpF.put(this.tag, this);
    AppMethodBeat.o(183392);
  }
  
  static void a(a parama)
  {
    AppMethodBeat.i(183394);
    LVz.set(parama);
    AppMethodBeat.o(183394);
  }
  
  public static a aZF(String paramString)
  {
    AppMethodBeat.i(183393);
    paramString = new a(paramString + "@" + LVB.getAndIncrement());
    AppMethodBeat.o(183393);
    return paramString;
  }
  
  public static a aZG(String paramString)
  {
    AppMethodBeat.i(183400);
    paramString = (a)cpF.get(paramString);
    AppMethodBeat.o(183400);
    return paramString;
  }
  
  static a aZH(String paramString)
  {
    try
    {
      AppMethodBeat.i(183401);
      a locala2 = (a)cpF.get(paramString);
      a locala1 = locala2;
      if (locala2 == null) {
        locala1 = new a(paramString);
      }
      AppMethodBeat.o(183401);
      return locala1;
    }
    finally {}
  }
  
  public static a fVT()
  {
    AppMethodBeat.i(183396);
    if (LVA == null)
    {
      String str = p(Looper.getMainLooper());
      a locala2 = (a)cpF.get(str);
      locala1 = locala2;
      if (locala2 == null) {
        locala1 = new a(str);
      }
      LVA = locala1;
    }
    a locala1 = LVA;
    AppMethodBeat.o(183396);
    return locala1;
  }
  
  public static a fVU()
  {
    AppMethodBeat.i(183397);
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      locala = fVT();
      AppMethodBeat.o(183397);
      return locala;
    }
    a locala = (a)LVz.get();
    AppMethodBeat.o(183397);
    return locala;
  }
  
  public static String fVV()
  {
    AppMethodBeat.i(183398);
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      localObject = fVT().tag;
      AppMethodBeat.o(183398);
      return localObject;
    }
    Object localObject = (a)LVz.get();
    if (localObject == null)
    {
      AppMethodBeat.o(183398);
      return null;
    }
    localObject = ((a)localObject).tag;
    AppMethodBeat.o(183398);
    return localObject;
  }
  
  public static Collection<a> fVX()
  {
    AppMethodBeat.i(183402);
    Collection localCollection = cpF.values();
    AppMethodBeat.o(183402);
    return localCollection;
  }
  
  public static String p(Looper paramLooper)
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
    Iterator localIterator = cpF.values().iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).LVC.quit();
    }
    cpF.clear();
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
  
  public final d fVW()
  {
    return this.LVC;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(183405);
    int i = this.tag.hashCode();
    AppMethodBeat.o(183405);
    return i;
  }
  
  public final void quit()
  {
    AppMethodBeat.i(183399);
    this.LVC.quit();
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
 * Qualified Name:     com.tencent.e.j.a
 * JD-Core Version:    0.7.0.1
 */