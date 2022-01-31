package com.tencent.mm.plugin.appbrand.game.e;

import com.tencent.mm.plugin.appbrand.g.b;
import java.util.HashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public final class a
{
  public static String appId = "";
  private static a gcZ;
  boolean bCk = false;
  private int gcU = 0;
  public long gcV = 0L;
  public long gcW = 0L;
  public CopyOnWriteArrayList<Long> gcX = new CopyOnWriteArrayList();
  HashMap<Integer, Integer> gcY = new HashMap();
  public g.b gda = new a.2(this);
  
  public static a ahj()
  {
    if (gcZ == null) {
      gcZ = new a();
    }
    return gcZ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.e.a
 * JD-Core Version:    0.7.0.1
 */