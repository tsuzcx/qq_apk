package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.e.a;
import com.tencent.mm.ak.e.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.x;
import com.tencent.mm.ak.x.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.cf;
import com.tencent.mm.model.cf.a;
import com.tencent.mm.modelgeo.d;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.appbrand.utils.f;
import com.tencent.mm.plugin.appbrand.y.m.a;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.protocal.protobuf.cv;
import com.tencent.mm.protocal.protobuf.duc;
import com.tencent.mm.protocal.protobuf.dud;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import java.util.Arrays;

public final class t
{
  public static final c jSr;
  
  static
  {
    AppMethodBeat.i(44575);
    jSr = new c();
    AppMethodBeat.o(44575);
  }
  
  private static void a(boolean paramBoolean, long paramLong1, long paramLong2)
  {
    long l = 0L;
    AppMethodBeat.i(44567);
    aj localaj = com.tencent.mm.kernel.g.ajR().ajA();
    am.a locala = am.a.IQb;
    if (!paramBoolean) {}
    for (paramLong1 = l;; paramLong1 = Math.max(0L, paramLong1) + l)
    {
      localaj.set(locala, Long.valueOf(paramLong1));
      localaj = com.tencent.mm.kernel.g.ajR().ajA();
      locala = am.a.IQd;
      if (!paramBoolean) {
        paramLong2 = 9223372036854775807L;
      }
      localaj.set(locala, Long.valueOf(paramLong2));
      AppMethodBeat.o(44567);
      return;
      l = bu.aRi();
    }
  }
  
  public static boolean bcM()
  {
    AppMethodBeat.i(44568);
    q.bcG();
    if (!com.tencent.mm.kernel.g.ajM())
    {
      AppMethodBeat.o(44568);
      return false;
    }
    boolean bool = ((Boolean)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IQe, Boolean.FALSE)).booleanValue();
    AppMethodBeat.o(44568);
    return bool;
  }
  
  static a bcN()
  {
    int i = 0;
    AppMethodBeat.i(44569);
    if (!bcO())
    {
      localObject = a.jSs;
      AppMethodBeat.o(44569);
      return localObject;
    }
    int j = ((Integer)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IPV, Integer.valueOf(0))).intValue();
    Object localObject = a.values();
    int k = localObject.length;
    while (i < k)
    {
      a locala = localObject[i];
      if (locala.value == j)
      {
        AppMethodBeat.o(44569);
        return locala;
      }
      i += 1;
    }
    localObject = a.jSs;
    AppMethodBeat.o(44569);
    return localObject;
  }
  
  public static boolean bcO()
  {
    AppMethodBeat.i(44570);
    if (!com.tencent.mm.kernel.g.ajM())
    {
      AppMethodBeat.o(44570);
      return false;
    }
    long l = ((Long)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IPS, Long.valueOf(0L))).longValue();
    if (l > bu.aRi()) {}
    for (boolean bool = true;; bool = false)
    {
      if ((!bool) && (l > 0L))
      {
        com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IPS, Long.valueOf(0L));
        e locale = e.jSD;
        e.bcS();
      }
      AppMethodBeat.o(44570);
      return bool;
    }
  }
  
  static void bcP()
  {
    AppMethodBeat.i(44571);
    q.bcG();
    if (!com.tencent.mm.kernel.g.ajM())
    {
      AppMethodBeat.o(44571);
      return;
    }
    e locale = e.jSD;
    if (!((Boolean)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IPY, Boolean.FALSE)).booleanValue())
    {
      e.a((String)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IPT, ""), ((Long)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IPU, Long.valueOf(0L))).longValue(), 0, e.bcU());
      com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IPY, Boolean.TRUE);
    }
    AppMethodBeat.o(44571);
  }
  
  public static void bcQ()
  {
    AppMethodBeat.i(44572);
    if (!com.tencent.mm.kernel.g.ajM())
    {
      AppMethodBeat.o(44572);
      return;
    }
    if (bcO())
    {
      c(false, 0L);
      a(false, 0L, 0L);
      e locale = e.jSD;
      e.a((String)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IPT, ""), ((Long)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IPU, Long.valueOf(0L))).longValue(), 2, e.bcU());
    }
    AppMethodBeat.o(44572);
  }
  
  private static void c(boolean paramBoolean, long paramLong)
  {
    AppMethodBeat.i(44566);
    if (!paramBoolean)
    {
      com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IPS, Long.valueOf(0L));
      AppMethodBeat.o(44566);
      return;
    }
    if (paramLong == 0L) {}
    for (paramLong = 9223372036854775807L;; paramLong = bu.aRi() + Math.max(0L, paramLong))
    {
      com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IPS, Long.valueOf(paramLong));
      com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IQe, Boolean.TRUE);
      com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IPY, Boolean.FALSE);
      e locale = e.jSD;
      e.a((String)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IPT, ""), ((Long)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IPU, Long.valueOf(0L))).longValue(), 1, e.bcU());
      AppMethodBeat.o(44566);
      return;
    }
  }
  
  public static enum a
  {
    public final int value;
    
    static
    {
      AppMethodBeat.i(44551);
      jSs = new a("NONE", 0, 0);
      jSt = new a("REDDOT", 1, 1);
      jSu = new a("NEW", 2, 2);
      jSv = new a[] { jSs, jSt, jSu };
      AppMethodBeat.o(44551);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
  }
  
  public static final class b
    implements cf.a
  {
    private static final b jSw;
    
    static
    {
      AppMethodBeat.i(44557);
      jSw = new b();
      AppMethodBeat.o(44557);
    }
    
    public static void CA()
    {
      AppMethodBeat.i(44553);
      q.bcG();
      ((s)com.tencent.mm.kernel.g.ad(s.class)).getSysCmdMsgExtension().a("wxareddot", jSw, true);
      AppMethodBeat.o(44553);
    }
    
    public static void unregister()
    {
      AppMethodBeat.i(44554);
      q.bcG();
      ((s)com.tencent.mm.kernel.g.ad(s.class)).getSysCmdMsgExtension().b("wxareddot", jSw, true);
      AppMethodBeat.o(44554);
    }
    
    public final void a(final e.a parama)
    {
      AppMethodBeat.i(44555);
      parama = z.a(parama.gte.FNI);
      if (bu.isNullOrNil(parama))
      {
        AppMethodBeat.o(44555);
        return;
      }
      f.bCj().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(44552);
          t.b.Nn(parama);
          AppMethodBeat.o(44552);
        }
      });
      AppMethodBeat.o(44555);
    }
    
    public final void a(e.c paramc) {}
  }
  
  public static final class c {}
  
  public static final class d
  {
    public final String[] jSC;
    
    public d()
    {
      AppMethodBeat.i(44560);
      this.jSC = new String[9];
      Arrays.fill(this.jSC, "0");
      this.jSC[0] = ((String)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IPT, ""));
      this.jSC[1] = String.valueOf(com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IPU, Long.valueOf(0L)));
      this.jSC[2] = String.valueOf(bu.aRi());
      AppMethodBeat.o(44560);
    }
    
    public final void bcR()
    {
      this.jSC[8] = "1";
    }
  }
  
  public static final class e
  {
    public static final e jSD;
    
    static
    {
      AppMethodBeat.i(44565);
      jSD = new e();
      AppMethodBeat.o(44565);
    }
    
    static void a(String paramString, long paramLong, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(44564);
      com.tencent.mm.plugin.report.service.g.yxI.f(14112, new Object[] { Integer.valueOf(1), bu.nullAsNil(paramString), Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      AppMethodBeat.o(44564);
    }
    
    static void bcS()
    {
      AppMethodBeat.i(44561);
      a((String)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IPT, ""), ((Long)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IPU, Long.valueOf(0L))).longValue(), 3, bcU());
      AppMethodBeat.o(44561);
    }
    
    public static void bcT()
    {
      AppMethodBeat.i(44562);
      a("", 0L, 1, 1);
      AppMethodBeat.o(44562);
    }
    
    static int bcU()
    {
      AppMethodBeat.i(44563);
      if (com.tencent.mm.kernel.g.ajR().ajA().getBoolean(am.a.IPZ, false))
      {
        AppMethodBeat.o(44563);
        return 1;
      }
      int j = ((Integer)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IPW, Integer.valueOf(0))).intValue();
      int i = j;
      if (j > 0) {
        i = j + 1;
      }
      AppMethodBeat.o(44563);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.t
 * JD-Core Version:    0.7.0.1
 */