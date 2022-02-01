package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f.a;
import com.tencent.mm.ak.f.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cc;
import com.tencent.mm.model.cc.a;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.appbrand.z.l.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.cu;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import java.util.Arrays;

public final class t
{
  public static final t.c jvg;
  
  static
  {
    AppMethodBeat.i(44575);
    jvg = new t.c();
    AppMethodBeat.o(44575);
  }
  
  private static void a(boolean paramBoolean, long paramLong1, long paramLong2)
  {
    long l = 0L;
    AppMethodBeat.i(44567);
    ae localae = g.agR().agA();
    ah.a locala = ah.a.GJl;
    if (!paramBoolean) {}
    for (paramLong1 = l;; paramLong1 = Math.max(0L, paramLong1) + l)
    {
      localae.set(locala, Long.valueOf(paramLong1));
      localae = g.agR().agA();
      locala = ah.a.GJn;
      if (!paramBoolean) {
        paramLong2 = 9223372036854775807L;
      }
      localae.set(locala, Long.valueOf(paramLong2));
      AppMethodBeat.o(44567);
      return;
      l = bs.aNx();
    }
  }
  
  public static boolean aYJ()
  {
    AppMethodBeat.i(44568);
    q.aYD();
    if (!g.agM())
    {
      AppMethodBeat.o(44568);
      return false;
    }
    boolean bool = ((Boolean)g.agR().agA().get(ah.a.GJo, Boolean.FALSE)).booleanValue();
    AppMethodBeat.o(44568);
    return bool;
  }
  
  static a aYK()
  {
    int i = 0;
    AppMethodBeat.i(44569);
    if (!aYL())
    {
      localObject = a.jvh;
      AppMethodBeat.o(44569);
      return localObject;
    }
    int j = ((Integer)g.agR().agA().get(ah.a.GJf, Integer.valueOf(0))).intValue();
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
    localObject = a.jvh;
    AppMethodBeat.o(44569);
    return localObject;
  }
  
  public static boolean aYL()
  {
    AppMethodBeat.i(44570);
    if (!g.agM())
    {
      AppMethodBeat.o(44570);
      return false;
    }
    long l = ((Long)g.agR().agA().get(ah.a.GJc, Long.valueOf(0L))).longValue();
    if (l > bs.aNx()) {}
    for (boolean bool = true;; bool = false)
    {
      if ((!bool) && (l > 0L))
      {
        g.agR().agA().set(ah.a.GJc, Long.valueOf(0L));
        e locale = e.jvs;
        e.aYP();
      }
      AppMethodBeat.o(44570);
      return bool;
    }
  }
  
  static void aYM()
  {
    AppMethodBeat.i(44571);
    q.aYD();
    if (!g.agM())
    {
      AppMethodBeat.o(44571);
      return;
    }
    e locale = e.jvs;
    if (!((Boolean)g.agR().agA().get(ah.a.GJi, Boolean.FALSE)).booleanValue())
    {
      e.a((String)g.agR().agA().get(ah.a.GJd, ""), ((Long)g.agR().agA().get(ah.a.GJe, Long.valueOf(0L))).longValue(), 0, e.aYR());
      g.agR().agA().set(ah.a.GJi, Boolean.TRUE);
    }
    AppMethodBeat.o(44571);
  }
  
  public static void aYN()
  {
    AppMethodBeat.i(44572);
    if (!g.agM())
    {
      AppMethodBeat.o(44572);
      return;
    }
    if (aYL())
    {
      c(false, 0L);
      a(false, 0L, 0L);
      e locale = e.jvs;
      e.a((String)g.agR().agA().get(ah.a.GJd, ""), ((Long)g.agR().agA().get(ah.a.GJe, Long.valueOf(0L))).longValue(), 2, e.aYR());
    }
    AppMethodBeat.o(44572);
  }
  
  private static void c(boolean paramBoolean, long paramLong)
  {
    AppMethodBeat.i(44566);
    if (!paramBoolean)
    {
      g.agR().agA().set(ah.a.GJc, Long.valueOf(0L));
      AppMethodBeat.o(44566);
      return;
    }
    if (paramLong == 0L) {}
    for (paramLong = 9223372036854775807L;; paramLong = bs.aNx() + Math.max(0L, paramLong))
    {
      g.agR().agA().set(ah.a.GJc, Long.valueOf(paramLong));
      g.agR().agA().set(ah.a.GJo, Boolean.TRUE);
      g.agR().agA().set(ah.a.GJi, Boolean.FALSE);
      e locale = e.jvs;
      e.a((String)g.agR().agA().get(ah.a.GJd, ""), ((Long)g.agR().agA().get(ah.a.GJe, Long.valueOf(0L))).longValue(), 1, e.aYR());
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
      jvh = new a("NONE", 0, 0);
      jvi = new a("REDDOT", 1, 1);
      jvj = new a("NEW", 2, 2);
      jvk = new a[] { jvh, jvi, jvj };
      AppMethodBeat.o(44551);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
  }
  
  public static final class b
    implements cc.a
  {
    private static final b jvl;
    
    static
    {
      AppMethodBeat.i(44557);
      jvl = new b();
      AppMethodBeat.o(44557);
    }
    
    public static void AY()
    {
      AppMethodBeat.i(44553);
      q.aYD();
      ((com.tencent.mm.plugin.messenger.foundation.a.q)g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class)).getSysCmdMsgExtension().a("wxareddot", jvl, true);
      AppMethodBeat.o(44553);
    }
    
    public static void unregister()
    {
      AppMethodBeat.i(44554);
      q.aYD();
      ((com.tencent.mm.plugin.messenger.foundation.a.q)g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class)).getSysCmdMsgExtension().b("wxareddot", jvl, true);
      AppMethodBeat.o(44554);
    }
    
    public final void a(final f.a parama)
    {
      AppMethodBeat.i(44555);
      parama = z.a(parama.fXi.DPV);
      if (bs.isNullOrNil(parama))
      {
        AppMethodBeat.o(44555);
        return;
      }
      com.tencent.mm.plugin.appbrand.utils.e.bxj().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(44552);
          t.b.Jn(parama);
          AppMethodBeat.o(44552);
        }
      });
      AppMethodBeat.o(44555);
    }
    
    public final void a(f.c paramc) {}
  }
  
  public static final class d
  {
    public final String[] jvr;
    
    public d()
    {
      AppMethodBeat.i(44560);
      this.jvr = new String[9];
      Arrays.fill(this.jvr, "0");
      this.jvr[0] = ((String)g.agR().agA().get(ah.a.GJd, ""));
      this.jvr[1] = String.valueOf(g.agR().agA().get(ah.a.GJe, Long.valueOf(0L)));
      this.jvr[2] = String.valueOf(bs.aNx());
      AppMethodBeat.o(44560);
    }
    
    public final void aYO()
    {
      this.jvr[8] = "1";
    }
  }
  
  public static final class e
  {
    public static final e jvs;
    
    static
    {
      AppMethodBeat.i(44565);
      jvs = new e();
      AppMethodBeat.o(44565);
    }
    
    static void a(String paramString, long paramLong, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(44564);
      h.wUl.f(14112, new Object[] { Integer.valueOf(1), bs.nullAsNil(paramString), Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      AppMethodBeat.o(44564);
    }
    
    static void aYP()
    {
      AppMethodBeat.i(44561);
      a((String)g.agR().agA().get(ah.a.GJd, ""), ((Long)g.agR().agA().get(ah.a.GJe, Long.valueOf(0L))).longValue(), 3, aYR());
      AppMethodBeat.o(44561);
    }
    
    public static void aYQ()
    {
      AppMethodBeat.i(44562);
      a("", 0L, 1, 1);
      AppMethodBeat.o(44562);
    }
    
    static int aYR()
    {
      AppMethodBeat.i(44563);
      if (g.agR().agA().getBoolean(ah.a.GJj, false))
      {
        AppMethodBeat.o(44563);
        return 1;
      }
      int j = ((Integer)g.agR().agA().get(ah.a.GJg, Integer.valueOf(0))).intValue();
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