package com.tencent.mm.plugin.appbrand.o;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public final class i
{
  private static AtomicInteger gQQ = new AtomicInteger(1);
  public HashMap<String, g> goq = new HashMap();
  
  public static int amC()
  {
    return gQQ.incrementAndGet();
  }
  
  public static i amI()
  {
    return i.a.amJ();
  }
  
  public final g vx(String paramString)
  {
    if (this.goq.containsKey(paramString)) {
      return (g)this.goq.get(paramString);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.o.i
 * JD-Core Version:    0.7.0.1
 */