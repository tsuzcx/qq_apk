package com.tencent.mm.plugin.appbrand.o;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public final class c
{
  private static AtomicInteger gQQ = new AtomicInteger(1);
  public HashMap<String, b> goq = new HashMap();
  
  public static int amC()
  {
    return gQQ.incrementAndGet();
  }
  
  public static c amD()
  {
    return c.a.amE();
  }
  
  public final b vs(String paramString)
  {
    if (this.goq.containsKey(paramString)) {
      return (b)this.goq.get(paramString);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.o.c
 * JD-Core Version:    0.7.0.1
 */