package com.tencent.mm.plugin.appbrand;

import com.tencent.mm.sdk.platformtools.ai;
import java.util.HashSet;
import java.util.Set;

public class u
{
  private static volatile boolean fAo = false;
  private static volatile boolean fAp = false;
  private static final Set<a> fAq = new HashSet();
  
  public static void a(a parama)
  {
    try
    {
      boolean bool1 = fAo;
      boolean bool2 = fAp;
      if (!bool2)
      {
        fAq.add(parama);
        fAo = true;
        fAp = false;
      }
      if (bool1) {
        return;
      }
      if (bool2)
      {
        parama.aal();
        return;
      }
    }
    finally {}
    parama = new u.1();
    new ai().O(new u.2(parama));
  }
  
  public static boolean aaE()
  {
    try
    {
      boolean bool = fAp;
      return bool;
    }
    finally {}
  }
  
  public static abstract interface a
  {
    public abstract void aal();
    
    public abstract void aam();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.u
 * JD-Core Version:    0.7.0.1
 */