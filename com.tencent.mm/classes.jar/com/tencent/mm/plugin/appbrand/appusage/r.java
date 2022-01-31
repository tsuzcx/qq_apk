package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.w;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelgeo.d;
import com.tencent.mm.protocal.protobuf.cot;
import com.tencent.mm.protocal.protobuf.cou;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;

public final class r
{
  public static final r.c hbP;
  
  static
  {
    AppMethodBeat.i(129643);
    hbP = new r.c();
    AppMethodBeat.o(129643);
  }
  
  private static void a(boolean paramBoolean, long paramLong1, long paramLong2)
  {
    long l = 0L;
    AppMethodBeat.i(129635);
    z localz = g.RL().Ru();
    ac.a locala = ac.a.yDa;
    if (!paramBoolean) {}
    for (paramLong1 = l;; paramLong1 = Math.max(0L, paramLong1) + l)
    {
      localz.set(locala, Long.valueOf(paramLong1));
      localz = g.RL().Ru();
      locala = ac.a.yDc;
      if (!paramBoolean) {
        paramLong2 = 9223372036854775807L;
      }
      localz.set(locala, Long.valueOf(paramLong2));
      AppMethodBeat.o(129635);
      return;
      l = bo.aox();
    }
  }
  
  public static boolean axm()
  {
    AppMethodBeat.i(129636);
    q.axe();
    if (!g.RG())
    {
      AppMethodBeat.o(129636);
      return false;
    }
    boolean bool = ((Boolean)g.RL().Ru().get(ac.a.yDd, Boolean.FALSE)).booleanValue();
    AppMethodBeat.o(129636);
    return bool;
  }
  
  static a axn()
  {
    int i = 0;
    AppMethodBeat.i(129637);
    if (!axo())
    {
      localObject = a.hbQ;
      AppMethodBeat.o(129637);
      return localObject;
    }
    int j = ((Integer)g.RL().Ru().get(ac.a.yCU, Integer.valueOf(0))).intValue();
    Object localObject = a.values();
    int k = localObject.length;
    while (i < k)
    {
      a locala = localObject[i];
      if (locala.value == j)
      {
        AppMethodBeat.o(129637);
        return locala;
      }
      i += 1;
    }
    localObject = a.hbQ;
    AppMethodBeat.o(129637);
    return localObject;
  }
  
  public static boolean axo()
  {
    AppMethodBeat.i(129638);
    if (!g.RG())
    {
      AppMethodBeat.o(129638);
      return false;
    }
    long l = ((Long)g.RL().Ru().get(ac.a.yCR, Long.valueOf(0L))).longValue();
    if (l > bo.aox()) {}
    for (boolean bool = true;; bool = false)
    {
      if ((!bool) && (l > 0L))
      {
        g.RL().Ru().set(ac.a.yCR, Long.valueOf(0L));
        r.e locale = r.e.hcb;
        r.e.axu();
      }
      AppMethodBeat.o(129638);
      return bool;
    }
  }
  
  static void axp()
  {
    AppMethodBeat.i(129639);
    q.axe();
    if (!g.RG())
    {
      AppMethodBeat.o(129639);
      return;
    }
    r.e locale = r.e.hcb;
    if (!((Boolean)g.RL().Ru().get(ac.a.yCX, Boolean.FALSE)).booleanValue())
    {
      r.e.a((String)g.RL().Ru().get(ac.a.yCS, ""), ((Long)g.RL().Ru().get(ac.a.yCT, Long.valueOf(0L))).longValue(), 0, r.e.axw());
      g.RL().Ru().set(ac.a.yCX, Boolean.TRUE);
    }
    AppMethodBeat.o(129639);
  }
  
  public static void axq()
  {
    AppMethodBeat.i(129640);
    if (!g.RG())
    {
      AppMethodBeat.o(129640);
      return;
    }
    if (axo())
    {
      c(false, 0L);
      a(false, 0L, 0L);
      r.e locale = r.e.hcb;
      r.e.a((String)g.RL().Ru().get(ac.a.yCS, ""), ((Long)g.RL().Ru().get(ac.a.yCT, Long.valueOf(0L))).longValue(), 2, r.e.axw());
    }
    AppMethodBeat.o(129640);
  }
  
  private static void c(boolean paramBoolean, long paramLong)
  {
    AppMethodBeat.i(129634);
    if (!paramBoolean)
    {
      g.RL().Ru().set(ac.a.yCR, Long.valueOf(0L));
      AppMethodBeat.o(129634);
      return;
    }
    if (paramLong == 0L) {}
    for (paramLong = 9223372036854775807L;; paramLong = bo.aox() + Math.max(0L, paramLong))
    {
      g.RL().Ru().set(ac.a.yCR, Long.valueOf(paramLong));
      g.RL().Ru().set(ac.a.yDd, Boolean.TRUE);
      g.RL().Ru().set(ac.a.yCX, Boolean.FALSE);
      r.e locale = r.e.hcb;
      r.e.a((String)g.RL().Ru().get(ac.a.yCS, ""), ((Long)g.RL().Ru().get(ac.a.yCT, Long.valueOf(0L))).longValue(), 1, r.e.axw());
      AppMethodBeat.o(129634);
      return;
    }
  }
  
  public static enum a
  {
    public final int value;
    
    static
    {
      AppMethodBeat.i(129619);
      hbQ = new a("NONE", 0, 0);
      hbR = new a("REDDOT", 1, 1);
      hbS = new a("NEW", 2, 2);
      hbT = new a[] { hbQ, hbR, hbS };
      AppMethodBeat.o(129619);
    }
    
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