package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f.a;
import com.tencent.mm.al.f.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cc;
import com.tencent.mm.model.cc.a;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.appbrand.aa.l.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.cs;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import java.util.Arrays;

public final class t
{
  public static final t.c iUQ;
  
  static
  {
    AppMethodBeat.i(44575);
    iUQ = new t.c();
    AppMethodBeat.o(44575);
  }
  
  private static void a(boolean paramBoolean, long paramLong1, long paramLong2)
  {
    long l = 0L;
    AppMethodBeat.i(44567);
    ab localab = g.afB().afk();
    ae.a locala = ae.a.Flw;
    if (!paramBoolean) {}
    for (paramLong1 = l;; paramLong1 = Math.max(0L, paramLong1) + l)
    {
      localab.set(locala, Long.valueOf(paramLong1));
      localab = g.afB().afk();
      locala = ae.a.Fly;
      if (!paramBoolean) {
        paramLong2 = 9223372036854775807L;
      }
      localab.set(locala, Long.valueOf(paramLong2));
      AppMethodBeat.o(44567);
      return;
      l = bt.aGK();
    }
  }
  
  public static boolean aRO()
  {
    AppMethodBeat.i(44568);
    q.aRI();
    if (!g.afw())
    {
      AppMethodBeat.o(44568);
      return false;
    }
    boolean bool = ((Boolean)g.afB().afk().get(ae.a.Flz, Boolean.FALSE)).booleanValue();
    AppMethodBeat.o(44568);
    return bool;
  }
  
  static a aRP()
  {
    int i = 0;
    AppMethodBeat.i(44569);
    if (!aRQ())
    {
      localObject = a.iUR;
      AppMethodBeat.o(44569);
      return localObject;
    }
    int j = ((Integer)g.afB().afk().get(ae.a.Flq, Integer.valueOf(0))).intValue();
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
    localObject = a.iUR;
    AppMethodBeat.o(44569);
    return localObject;
  }
  
  public static boolean aRQ()
  {
    AppMethodBeat.i(44570);
    if (!g.afw())
    {
      AppMethodBeat.o(44570);
      return false;
    }
    long l = ((Long)g.afB().afk().get(ae.a.Fln, Long.valueOf(0L))).longValue();
    if (l > bt.aGK()) {}
    for (boolean bool = true;; bool = false)
    {
      if ((!bool) && (l > 0L))
      {
        g.afB().afk().set(ae.a.Fln, Long.valueOf(0L));
        e locale = e.iVc;
        e.aRU();
      }
      AppMethodBeat.o(44570);
      return bool;
    }
  }
  
  static void aRR()
  {
    AppMethodBeat.i(44571);
    q.aRI();
    if (!g.afw())
    {
      AppMethodBeat.o(44571);
      return;
    }
    e locale = e.iVc;
    if (!((Boolean)g.afB().afk().get(ae.a.Flt, Boolean.FALSE)).booleanValue())
    {
      e.a((String)g.afB().afk().get(ae.a.Flo, ""), ((Long)g.afB().afk().get(ae.a.Flp, Long.valueOf(0L))).longValue(), 0, e.aRW());
      g.afB().afk().set(ae.a.Flt, Boolean.TRUE);
    }
    AppMethodBeat.o(44571);
  }
  
  public static void aRS()
  {
    AppMethodBeat.i(44572);
    if (!g.afw())
    {
      AppMethodBeat.o(44572);
      return;
    }
    if (aRQ())
    {
      c(false, 0L);
      a(false, 0L, 0L);
      e locale = e.iVc;
      e.a((String)g.afB().afk().get(ae.a.Flo, ""), ((Long)g.afB().afk().get(ae.a.Flp, Long.valueOf(0L))).longValue(), 2, e.aRW());
    }
    AppMethodBeat.o(44572);
  }
  
  private static void c(boolean paramBoolean, long paramLong)
  {
    AppMethodBeat.i(44566);
    if (!paramBoolean)
    {
      g.afB().afk().set(ae.a.Fln, Long.valueOf(0L));
      AppMethodBeat.o(44566);
      return;
    }
    if (paramLong == 0L) {}
    for (paramLong = 9223372036854775807L;; paramLong = bt.aGK() + Math.max(0L, paramLong))
    {
      g.afB().afk().set(ae.a.Fln, Long.valueOf(paramLong));
      g.afB().afk().set(ae.a.Flz, Boolean.TRUE);
      g.afB().afk().set(ae.a.Flt, Boolean.FALSE);
      e locale = e.iVc;
      e.a((String)g.afB().afk().get(ae.a.Flo, ""), ((Long)g.afB().afk().get(ae.a.Flp, Long.valueOf(0L))).longValue(), 1, e.aRW());
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
      iUR = new a("NONE", 0, 0);
      iUS = new a("REDDOT", 1, 1);
      iUT = new a("NEW", 2, 2);
      iUU = new a[] { iUR, iUS, iUT };
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
    private static final b iUV;
    
    static
    {
      AppMethodBeat.i(44557);
      iUV = new b();
      AppMethodBeat.o(44557);
    }
    
    public static void Bu()
    {
      AppMethodBeat.i(44553);
      q.aRI();
      ((com.tencent.mm.plugin.messenger.foundation.a.q)g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class)).getSysCmdMsgExtension().a("wxareddot", iUV, true);
      AppMethodBeat.o(44553);
    }
    
    public static void unregister()
    {
      AppMethodBeat.i(44554);
      q.aRI();
      ((com.tencent.mm.plugin.messenger.foundation.a.q)g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class)).getSysCmdMsgExtension().b("wxareddot", iUV, true);
      AppMethodBeat.o(44554);
    }
    
    public final void a(final f.a parama)
    {
      AppMethodBeat.i(44555);
      parama = z.a(parama.fTo.Cxz);
      if (bt.isNullOrNil(parama))
      {
        AppMethodBeat.o(44555);
        return;
      }
      com.tencent.mm.plugin.appbrand.utils.e.bqm().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(44552);
          t.b.Fj(parama);
          AppMethodBeat.o(44552);
        }
      });
      AppMethodBeat.o(44555);
    }
    
    public final void a(f.c paramc) {}
  }
  
  public static final class d
  {
    public final String[] iVb;
    
    public d()
    {
      AppMethodBeat.i(44560);
      this.iVb = new String[9];
      Arrays.fill(this.iVb, "0");
      this.iVb[0] = ((String)g.afB().afk().get(ae.a.Flo, ""));
      this.iVb[1] = String.valueOf(g.afB().afk().get(ae.a.Flp, Long.valueOf(0L)));
      this.iVb[2] = String.valueOf(bt.aGK());
      AppMethodBeat.o(44560);
    }
    
    public final void aRT()
    {
      this.iVb[8] = "1";
    }
  }
  
  public static final class e
  {
    public static final e iVc;
    
    static
    {
      AppMethodBeat.i(44565);
      iVc = new e();
      AppMethodBeat.o(44565);
    }
    
    static void a(String paramString, long paramLong, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(44564);
      h.vKh.f(14112, new Object[] { Integer.valueOf(1), bt.nullAsNil(paramString), Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      AppMethodBeat.o(44564);
    }
    
    static void aRU()
    {
      AppMethodBeat.i(44561);
      a((String)g.afB().afk().get(ae.a.Flo, ""), ((Long)g.afB().afk().get(ae.a.Flp, Long.valueOf(0L))).longValue(), 3, aRW());
      AppMethodBeat.o(44561);
    }
    
    public static void aRV()
    {
      AppMethodBeat.i(44562);
      a("", 0L, 1, 1);
      AppMethodBeat.o(44562);
    }
    
    static int aRW()
    {
      AppMethodBeat.i(44563);
      if (g.afB().afk().getBoolean(ae.a.Flu, false))
      {
        AppMethodBeat.o(44563);
        return 1;
      }
      int j = ((Integer)g.afB().afk().get(ae.a.Flr, Integer.valueOf(0))).intValue();
      int i = j;
      if (j > 0) {
        i = j + 1;
      }
      AppMethodBeat.o(44563);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.t
 * JD-Core Version:    0.7.0.1
 */