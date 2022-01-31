package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.w;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelgeo.a.a;
import com.tencent.mm.protocal.c.cbn;
import com.tencent.mm.protocal.c.cbo;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;

public final class r
{
  public static final r.c fIX = new r.c();
  
  private static void a(boolean paramBoolean, long paramLong1, long paramLong2)
  {
    long l = 0L;
    z localz = g.DP().Dz();
    ac.a locala = ac.a.uta;
    if (!paramBoolean) {}
    for (paramLong1 = l;; paramLong1 = Math.max(0L, paramLong1) + l)
    {
      localz.c(locala, Long.valueOf(paramLong1));
      localz = g.DP().Dz();
      locala = ac.a.utc;
      if (!paramBoolean) {
        paramLong2 = 9223372036854775807L;
      }
      localz.c(locala, Long.valueOf(paramLong2));
      return;
      l = bk.UX();
    }
  }
  
  public static boolean adi()
  {
    q.acY();
    if (!g.DK()) {
      return false;
    }
    return ((Boolean)g.DP().Dz().get(ac.a.utd, Boolean.valueOf(false))).booleanValue();
  }
  
  static a adj()
  {
    int i = 0;
    Object localObject;
    if (!adk())
    {
      localObject = a.fIY;
      return localObject;
    }
    int j = ((Integer)g.DP().Dz().get(ac.a.usU, Integer.valueOf(0))).intValue();
    a[] arrayOfa = a.values();
    int k = arrayOfa.length;
    for (;;)
    {
      if (i >= k) {
        break label76;
      }
      a locala = arrayOfa[i];
      localObject = locala;
      if (locala.value == j) {
        break;
      }
      i += 1;
    }
    label76:
    return a.fIY;
  }
  
  public static boolean adk()
  {
    if (!g.DK()) {
      return false;
    }
    long l = ((Long)g.DP().Dz().get(ac.a.usR, Long.valueOf(0L))).longValue();
    if (l > bk.UX()) {}
    for (boolean bool = true;; bool = false)
    {
      if ((!bool) && (l > 0L))
      {
        g.DP().Dz().c(ac.a.usR, Long.valueOf(0L));
        r.e locale = r.e.fJj;
        r.e.a((String)g.DP().Dz().get(ac.a.usS, ""), ((Long)g.DP().Dz().get(ac.a.usT, Long.valueOf(0L))).longValue(), 3, r.e.ado());
      }
      return bool;
    }
  }
  
  static void adl()
  {
    q.acY();
    if (!g.DK()) {}
    do
    {
      return;
      r.e locale = r.e.fJj;
    } while (((Boolean)g.DP().Dz().get(ac.a.usX, Boolean.valueOf(false))).booleanValue());
    r.e.a((String)g.DP().Dz().get(ac.a.usS, ""), ((Long)g.DP().Dz().get(ac.a.usT, Long.valueOf(0L))).longValue(), 0, r.e.ado());
    g.DP().Dz().c(ac.a.usX, Boolean.valueOf(true));
  }
  
  public static void adm()
  {
    if (!g.DK()) {}
    while (!adk()) {
      return;
    }
    b(false, 0L);
    a(false, 0L, 0L);
    r.e locale = r.e.fJj;
    r.e.a((String)g.DP().Dz().get(ac.a.usS, ""), ((Long)g.DP().Dz().get(ac.a.usT, Long.valueOf(0L))).longValue(), 2, r.e.ado());
  }
  
  private static void b(boolean paramBoolean, long paramLong)
  {
    if (!paramBoolean)
    {
      g.DP().Dz().c(ac.a.usR, Long.valueOf(0L));
      return;
    }
    if (paramLong == 0L) {}
    for (paramLong = 9223372036854775807L;; paramLong = bk.UX() + Math.max(0L, paramLong))
    {
      g.DP().Dz().c(ac.a.usR, Long.valueOf(paramLong));
      g.DP().Dz().c(ac.a.utd, Boolean.valueOf(true));
      g.DP().Dz().c(ac.a.usX, Boolean.valueOf(false));
      r.e locale = r.e.fJj;
      r.e.a((String)g.DP().Dz().get(ac.a.usS, ""), ((Long)g.DP().Dz().get(ac.a.usT, Long.valueOf(0L))).longValue(), 1, r.e.ado());
      return;
    }
  }
  
  public static enum a
  {
    public final int value;
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.r
 * JD-Core Version:    0.7.0.1
 */