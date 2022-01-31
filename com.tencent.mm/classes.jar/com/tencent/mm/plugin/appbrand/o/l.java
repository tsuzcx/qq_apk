package com.tencent.mm.plugin.appbrand.o;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public final class l
{
  private static AtomicInteger gQQ = new AtomicInteger(1);
  public HashMap<String, k> goq = new HashMap();
  
  public static int amC()
  {
    return gQQ.incrementAndGet();
  }
  
  public static l amK()
  {
    return l.a.amL();
  }
  
  public final k vC(String paramString)
  {
    if (this.goq.containsKey(paramString)) {
      return (k)this.goq.get(paramString);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.o.l
 * JD-Core Version:    0.7.0.1
 */