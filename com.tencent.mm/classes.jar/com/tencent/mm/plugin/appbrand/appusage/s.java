package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.g.a;
import com.tencent.mm.am.g.c;
import com.tencent.mm.kernel.f;
import com.tencent.mm.model.cl;
import com.tencent.mm.model.cl.a;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.plugin.appbrand.af.o.a;
import com.tencent.mm.plugin.appbrand.utils.l;
import com.tencent.mm.plugin.messenger.foundation.a.v;
import com.tencent.mm.protocal.protobuf.dl;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import java.util.Arrays;

public final class s
{
  public static final s.c qPg;
  
  static
  {
    AppMethodBeat.i(44575);
    qPg = new s.c();
    AppMethodBeat.o(44575);
  }
  
  private static void b(boolean paramBoolean, long paramLong1, long paramLong2)
  {
    long l = 0L;
    AppMethodBeat.i(44567);
    aq localaq = com.tencent.mm.kernel.h.baE().ban();
    at.a locala = at.a.acNx;
    if (!paramBoolean) {}
    for (paramLong1 = l;; paramLong1 = Math.max(0L, paramLong1) + l)
    {
      localaq.set(locala, Long.valueOf(paramLong1));
      localaq = com.tencent.mm.kernel.h.baE().ban();
      locala = at.a.acNz;
      if (!paramBoolean) {
        paramLong2 = 9223372036854775807L;
      }
      localaq.set(locala, Long.valueOf(paramLong2));
      AppMethodBeat.o(44567);
      return;
      l = Util.nowSecond();
    }
  }
  
  public static boolean ciU()
  {
    AppMethodBeat.i(44568);
    if (!p.ciO())
    {
      AppMethodBeat.o(44568);
      return false;
    }
    if (!com.tencent.mm.kernel.h.baz())
    {
      AppMethodBeat.o(44568);
      return false;
    }
    boolean bool = ((Boolean)com.tencent.mm.kernel.h.baE().ban().get(at.a.acNA, Boolean.FALSE)).booleanValue();
    AppMethodBeat.o(44568);
    return bool;
  }
  
  static a ciV()
  {
    int i = 0;
    AppMethodBeat.i(44569);
    if (!ciW())
    {
      localObject = a.qPh;
      AppMethodBeat.o(44569);
      return localObject;
    }
    int j = ((Integer)com.tencent.mm.kernel.h.baE().ban().get(at.a.acNr, Integer.valueOf(0))).intValue();
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
    localObject = a.qPh;
    AppMethodBeat.o(44569);
    return localObject;
  }
  
  public static boolean ciW()
  {
    AppMethodBeat.i(44570);
    if (!com.tencent.mm.kernel.h.baz())
    {
      AppMethodBeat.o(44570);
      return false;
    }
    long l = ((Long)com.tencent.mm.kernel.h.baE().ban().get(at.a.acNo, Long.valueOf(0L))).longValue();
    if (l > Util.nowSecond()) {}
    for (boolean bool = true;; bool = false)
    {
      if ((!bool) && (l > 0L))
      {
        com.tencent.mm.kernel.h.baE().ban().set(at.a.acNo, Long.valueOf(0L));
        e locale = e.qPs;
        e.cja();
      }
      AppMethodBeat.o(44570);
      return bool;
    }
  }
  
  static void ciX()
  {
    AppMethodBeat.i(44571);
    if (!p.ciO())
    {
      AppMethodBeat.o(44571);
      return;
    }
    if (!com.tencent.mm.kernel.h.baz())
    {
      AppMethodBeat.o(44571);
      return;
    }
    e locale = e.qPs;
    if (!((Boolean)com.tencent.mm.kernel.h.baE().ban().get(at.a.acNu, Boolean.FALSE)).booleanValue())
    {
      e.a((String)com.tencent.mm.kernel.h.baE().ban().get(at.a.acNp, ""), ((Long)com.tencent.mm.kernel.h.baE().ban().get(at.a.acNq, Long.valueOf(0L))).longValue(), 0, e.cjc());
      com.tencent.mm.kernel.h.baE().ban().set(at.a.acNu, Boolean.TRUE);
    }
    AppMethodBeat.o(44571);
  }
  
  public static void ciY()
  {
    AppMethodBeat.i(44572);
    if (!com.tencent.mm.kernel.h.baz())
    {
      AppMethodBeat.o(44572);
      return;
    }
    if (ciW())
    {
      e(false, 0L);
      b(false, 0L, 0L);
      e locale = e.qPs;
      e.a((String)com.tencent.mm.kernel.h.baE().ban().get(at.a.acNp, ""), ((Long)com.tencent.mm.kernel.h.baE().ban().get(at.a.acNq, Long.valueOf(0L))).longValue(), 2, e.cjc());
    }
    AppMethodBeat.o(44572);
  }
  
  private static void e(boolean paramBoolean, long paramLong)
  {
    AppMethodBeat.i(44566);
    if (!paramBoolean)
    {
      com.tencent.mm.kernel.h.baE().ban().set(at.a.acNo, Long.valueOf(0L));
      AppMethodBeat.o(44566);
      return;
    }
    if (paramLong == 0L) {}
    for (paramLong = 9223372036854775807L;; paramLong = Util.nowSecond() + Math.max(0L, paramLong))
    {
      com.tencent.mm.kernel.h.baE().ban().set(at.a.acNo, Long.valueOf(paramLong));
      com.tencent.mm.kernel.h.baE().ban().set(at.a.acNA, Boolean.TRUE);
      com.tencent.mm.kernel.h.baE().ban().set(at.a.acNu, Boolean.FALSE);
      e locale = e.qPs;
      e.a((String)com.tencent.mm.kernel.h.baE().ban().get(at.a.acNp, ""), ((Long)com.tencent.mm.kernel.h.baE().ban().get(at.a.acNq, Long.valueOf(0L))).longValue(), 1, e.cjc());
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
      qPh = new a("NONE", 0, 0);
      qPi = new a("REDDOT", 1, 1);
      qPj = new a("NEW", 2, 2);
      qPk = new a[] { qPh, qPi, qPj };
      AppMethodBeat.o(44551);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
  }
  
  public static final class b
    implements cl.a
  {
    private static final b qPl;
    
    static
    {
      AppMethodBeat.i(44557);
      qPl = new b();
      AppMethodBeat.o(44557);
    }
    
    public static void aoW()
    {
      AppMethodBeat.i(44553);
      if (!p.ciO())
      {
        AppMethodBeat.o(44553);
        return;
      }
      ((v)com.tencent.mm.kernel.h.az(v.class)).getSysCmdMsgExtension().a("wxareddot", qPl, true);
      AppMethodBeat.o(44553);
    }
    
    public static void unregister()
    {
      AppMethodBeat.i(44554);
      if (!p.ciO())
      {
        AppMethodBeat.o(44554);
        return;
      }
      ((v)com.tencent.mm.kernel.h.az(v.class)).getSysCmdMsgExtension().b("wxareddot", qPl, true);
      AppMethodBeat.o(44554);
    }
    
    public final void a(final g.a parama)
    {
      AppMethodBeat.i(44555);
      parama = w.a(parama.mpN.YFG);
      if (Util.isNullOrNil(parama))
      {
        AppMethodBeat.o(44555);
        return;
      }
      l.cNm().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(44552);
          s.b.WK(parama);
          AppMethodBeat.o(44552);
        }
      });
      AppMethodBeat.o(44555);
    }
    
    public final void a(g.c paramc) {}
  }
  
  public static final class d
  {
    public final String[] qPr;
    
    public d()
    {
      AppMethodBeat.i(44560);
      this.qPr = new String[9];
      Arrays.fill(this.qPr, "0");
      this.qPr[0] = ((String)com.tencent.mm.kernel.h.baE().ban().get(at.a.acNp, ""));
      this.qPr[1] = String.valueOf(com.tencent.mm.kernel.h.baE().ban().get(at.a.acNq, Long.valueOf(0L)));
      this.qPr[2] = String.valueOf(Util.nowSecond());
      AppMethodBeat.o(44560);
    }
    
    public final void ciZ()
    {
      this.qPr[8] = "1";
    }
  }
  
  public static final class e
  {
    public static final e qPs;
    
    static
    {
      AppMethodBeat.i(44565);
      qPs = new e();
      AppMethodBeat.o(44565);
    }
    
    static void a(String paramString, long paramLong, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(44564);
      com.tencent.mm.plugin.report.service.h.OAn.b(14112, new Object[] { Integer.valueOf(1), Util.nullAsNil(paramString), Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      AppMethodBeat.o(44564);
    }
    
    static void cja()
    {
      AppMethodBeat.i(44561);
      a((String)com.tencent.mm.kernel.h.baE().ban().get(at.a.acNp, ""), ((Long)com.tencent.mm.kernel.h.baE().ban().get(at.a.acNq, Long.valueOf(0L))).longValue(), 3, cjc());
      AppMethodBeat.o(44561);
    }
    
    public static void cjb()
    {
      AppMethodBeat.i(44562);
      a("", 0L, 1, 1);
      AppMethodBeat.o(44562);
    }
    
    static int cjc()
    {
      AppMethodBeat.i(44563);
      if (com.tencent.mm.kernel.h.baE().ban().getBoolean(at.a.acNv, false))
      {
        AppMethodBeat.o(44563);
        return 1;
      }
      int j = ((Integer)com.tencent.mm.kernel.h.baE().ban().get(at.a.acNs, Integer.valueOf(0))).intValue();
      int i = j;
      if (j > 0) {
        i = j + 1;
      }
      AppMethodBeat.o(44563);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.s
 * JD-Core Version:    0.7.0.1
 */