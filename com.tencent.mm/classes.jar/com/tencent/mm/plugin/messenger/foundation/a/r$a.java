package com.tencent.mm.plugin.messenger.foundation.a;

import java.util.concurrent.ConcurrentHashMap;
import junit.framework.Assert;

public final class r$a
{
  private static ConcurrentHashMap<Integer, r> mdj = new ConcurrentHashMap();
  
  public static void a(int paramInt, r paramr)
  {
    if (mdj.get(Integer.valueOf(paramInt)) == null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      mdj.put(Integer.valueOf(paramInt), paramr);
      return;
    }
  }
  
  public static r tD(int paramInt)
  {
    return (r)mdj.get(Integer.valueOf(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.foundation.a.r.a
 * JD-Core Version:    0.7.0.1
 */