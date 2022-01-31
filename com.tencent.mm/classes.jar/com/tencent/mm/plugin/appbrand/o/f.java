package com.tencent.mm.plugin.appbrand.o;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public final class f
{
  private static AtomicInteger gQQ = new AtomicInteger(1);
  public HashMap<String, d> goq = new HashMap();
  
  public static int amC()
  {
    return gQQ.incrementAndGet();
  }
  
  public static f amG()
  {
    return f.a.amH();
  }
  
  public final d vv(String paramString)
  {
    if (this.goq.containsKey(paramString)) {
      return (d)this.goq.get(paramString);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.o.f
 * JD-Core Version:    0.7.0.1
 */