package com.tencent.e.j;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public final class a
{
  private static final ThreadLocal<a> Zxr;
  private static a Zxs;
  private static final AtomicLong Zxt;
  private static final ConcurrentHashMap<String, a> cDe;
  public final d Zxu;
  private int Zxv;
  public final String tag;
  
  static
  {
    AppMethodBeat.i(183407);
    Zxr = new ThreadLocal();
    Zxs = null;
    cDe = new ConcurrentHashMap();
    Zxt = new AtomicLong(0L);
    AppMethodBeat.o(183407);
  }
  
  private a(String paramString)
  {
    AppMethodBeat.i(183392);
    this.Zxv = 0;
    this.tag = paramString;
    this.Zxu = new d(new b(new b.a() {}));
    cDe.put(this.tag, this);
    AppMethodBeat.o(183392);
  }
  
  static void a(a parama)
  {
    AppMethodBeat.i(183394);
    Zxr.set(parama);
    AppMethodBeat.o(183394);
  }
  
  public static a bDn(String paramString)
  {
    AppMethodBeat.i(183393);
    paramString = new a(paramString + "@" + Zxt.getAndIncrement());
    AppMethodBeat.o(183393);
    return paramString;
  }
  
  public static a bDo(String paramString)
  {
    AppMethodBeat.i(183400);
    paramString = (a)cDe.get(paramString);
    AppMethodBeat.o(183400);
    return paramString;
  }
  
  static a bDp(String paramString)
  {
    try
    {
      AppMethodBeat.i(183401);
      a locala2 = (a)cDe.get(paramString);
      a locala1 = locala2;
      if (locala2 == null) {
        locala1 = new a(paramString);
      }
      AppMethodBeat.o(183401);
      return locala1;
    }
    finally {}
  }
  
  public static a iqe()
  {
    AppMethodBeat.i(183396);
    if (Zxs == null)
    {
      String str = l(Looper.getMainLooper());
      a locala2 = (a)cDe.get(str);
      locala1 = locala2;
      if (locala2 == null) {
        locala1 = new a(str);
      }
      Zxs = locala1;
    }
    a locala1 = Zxs;
    AppMethodBeat.o(183396);
    return locala1;
  }
  
  public static a iqf()
  {
    AppMethodBeat.i(183397);
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      locala = iqe();
      AppMethodBeat.o(183397);
      return locala;
    }
    a locala = (a)Zxr.get();
    AppMethodBeat.o(183397);
    return locala;
  }
  
  public static String iqg()
  {
    AppMethodBeat.i(183398);
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      localObject = iqe().tag;
      AppMethodBeat.o(183398);
      return localObject;
    }
    Object localObject = (a)Zxr.get();
    if (localObject == null)
    {
      AppMethodBeat.o(183398);
      return null;
    }
    localObject = ((a)localObject).tag;
    AppMethodBeat.o(183398);
    return localObject;
  }
  
  public static Collection<a> iqi()
  {
    AppMethodBeat.i(183402);
    Collection localCollection = cDe.values();
    AppMethodBeat.o(183402);
    return localCollection;
  }
  
  public static String l(Looper paramLooper)
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
    Iterator localIterator = cDe.values().iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).Zxu.quit();
    }
    cDe.clear();
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
  
  public final d iqh()
  {
    return this.Zxu;
  }
  
  public final void quit()
  {
    AppMethodBeat.i(183399);
    this.Zxu.quit();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.e.j.a
 * JD-Core Version:    0.7.0.1
 */