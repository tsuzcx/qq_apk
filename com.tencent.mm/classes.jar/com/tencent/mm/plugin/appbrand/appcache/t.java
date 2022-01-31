package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.mm.plugin.appbrand.appcache.a.a;
import java.util.HashSet;
import java.util.Set;

public final class t
{
  private static final Set<b> fCS = new HashSet();
  
  static t.a a(a parama)
  {
    for (;;)
    {
      int i;
      synchronized (fCS)
      {
        Object[] arrayOfObject = fCS.toArray();
        int j = arrayOfObject.length;
        i = 0;
        if (i >= j) {
          break;
        }
        ??? = ((b)arrayOfObject[i]).a(parama);
        if (??? != null) {
          return ???;
        }
      }
      i += 1;
    }
    return null;
  }
  
  public static void a(b paramb)
  {
    synchronized (fCS)
    {
      fCS.add(paramb);
      return;
    }
  }
  
  public static abstract interface b
  {
    public abstract t.a a(a parama);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.t
 * JD-Core Version:    0.7.0.1
 */