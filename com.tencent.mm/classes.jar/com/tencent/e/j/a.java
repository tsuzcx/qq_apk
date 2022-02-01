package com.tencent.e.j;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public final class a
{
  private static final ThreadLocal<a> IzU;
  private static a IzV;
  private static final AtomicLong IzW;
  private static final ConcurrentHashMap<String, a> cit;
  public final d IzX;
  private int IzY;
  public final String tag;
  
  static
  {
    AppMethodBeat.i(183407);
    IzU = new ThreadLocal();
    IzV = null;
    cit = new ConcurrentHashMap();
    IzW = new AtomicLong(0L);
    AppMethodBeat.o(183407);
  }
  
  private a(String paramString)
  {
    AppMethodBeat.i(183392);
    this.IzY = 0;
    this.tag = paramString;
    this.IzX = new d(new b(new b.a() {}));
    cit.put(this.tag, this);
    AppMethodBeat.o(183392);
  }
  
  static void a(a parama)
  {
    AppMethodBeat.i(183394);
    IzU.set(parama);
    AppMethodBeat.o(183394);
  }
  
  public static a aOc(String paramString)
  {
    AppMethodBeat.i(183393);
    paramString = new a(paramString + "@" + IzW.getAndIncrement());
    AppMethodBeat.o(183393);
    return paramString;
  }
  
  public static a aOd(String paramString)
  {
    AppMethodBeat.i(183400);
    paramString = (a)cit.get(paramString);
    AppMethodBeat.o(183400);
    return paramString;
  }
  
  static a aOe(String paramString)
  {
    try
    {
      AppMethodBeat.i(183401);
      a locala2 = (a)cit.get(paramString);
      a locala1 = locala2;
      if (locala2 == null) {
        locala1 = new a(paramString);
      }
      AppMethodBeat.o(183401);
      return locala1;
    }
    finally {}
  }
  
  public static a fol()
  {
    AppMethodBeat.i(183396);
    if (IzV == null)
    {
      String str = p(Looper.getMainLooper());
      a locala2 = (a)cit.get(str);
      locala1 = locala2;
      if (locala2 == null) {
        locala1 = new a(str);
      }
      IzV = locala1;
    }
    a locala1 = IzV;
    AppMethodBeat.o(183396);
    return locala1;
  }
  
  public static a fom()
  {
    AppMethodBeat.i(183397);
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      locala = fol();
      AppMethodBeat.o(183397);
      return locala;
    }
    a locala = (a)IzU.get();
    AppMethodBeat.o(183397);
    return locala;
  }
  
  public static String fon()
  {
    AppMethodBeat.i(183398);
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      localObject = fol().tag;
      AppMethodBeat.o(183398);
      return localObject;
    }
    Object localObject = (a)IzU.get();
    if (localObject == null)
    {
      AppMethodBeat.o(183398);
      return null;
    }
    localObject = ((a)localObject).tag;
    AppMethodBeat.o(183398);
    return localObject;
  }
  
  public static Collection<a> fop()
  {
    AppMethodBeat.i(183402);
    Collection localCollection = cit.values();
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
    Iterator localIterator = cit.values().iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).IzX.quit();
    }
    cit.clear();
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
  
  public final d foo()
  {
    return this.IzX;
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
    this.IzX.quit();
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