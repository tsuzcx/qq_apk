package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h.a;
import com.tencent.mm.ak.h.c;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cj;
import com.tencent.mm.model.cj.a;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.appbrand.ac.m.a;
import com.tencent.mm.plugin.appbrand.utils.f;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.de;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.util.Arrays;

public final class t
{
  public static final c kVb;
  
  static
  {
    AppMethodBeat.i(44575);
    kVb = new c();
    AppMethodBeat.o(44575);
  }
  
  private static void b(boolean paramBoolean, long paramLong1, long paramLong2)
  {
    long l = 0L;
    AppMethodBeat.i(44567);
    ao localao = g.aAh().azQ();
    ar.a locala = ar.a.NYc;
    if (!paramBoolean) {}
    for (paramLong1 = l;; paramLong1 = Math.max(0L, paramLong1) + l)
    {
      localao.set(locala, Long.valueOf(paramLong1));
      localao = g.aAh().azQ();
      locala = ar.a.NYe;
      if (!paramBoolean) {
        paramLong2 = 9223372036854775807L;
      }
      localao.set(locala, Long.valueOf(paramLong2));
      AppMethodBeat.o(44567);
      return;
      l = Util.nowSecond();
    }
  }
  
  public static boolean byb()
  {
    AppMethodBeat.i(44568);
    q.bxV();
    if (!g.aAc())
    {
      AppMethodBeat.o(44568);
      return false;
    }
    boolean bool = ((Boolean)g.aAh().azQ().get(ar.a.NYf, Boolean.FALSE)).booleanValue();
    AppMethodBeat.o(44568);
    return bool;
  }
  
  static a byc()
  {
    int i = 0;
    AppMethodBeat.i(44569);
    if (!byd())
    {
      localObject = a.kVc;
      AppMethodBeat.o(44569);
      return localObject;
    }
    int j = ((Integer)g.aAh().azQ().get(ar.a.NXW, Integer.valueOf(0))).intValue();
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
    localObject = a.kVc;
    AppMethodBeat.o(44569);
    return localObject;
  }
  
  public static boolean byd()
  {
    AppMethodBeat.i(44570);
    if (!g.aAc())
    {
      AppMethodBeat.o(44570);
      return false;
    }
    long l = ((Long)g.aAh().azQ().get(ar.a.NXT, Long.valueOf(0L))).longValue();
    if (l > Util.nowSecond()) {}
    for (boolean bool = true;; bool = false)
    {
      if ((!bool) && (l > 0L))
      {
        g.aAh().azQ().set(ar.a.NXT, Long.valueOf(0L));
        e locale = e.kVn;
        e.byh();
      }
      AppMethodBeat.o(44570);
      return bool;
    }
  }
  
  static void bye()
  {
    AppMethodBeat.i(44571);
    q.bxV();
    if (!g.aAc())
    {
      AppMethodBeat.o(44571);
      return;
    }
    e locale = e.kVn;
    if (!((Boolean)g.aAh().azQ().get(ar.a.NXZ, Boolean.FALSE)).booleanValue())
    {
      e.a((String)g.aAh().azQ().get(ar.a.NXU, ""), ((Long)g.aAh().azQ().get(ar.a.NXV, Long.valueOf(0L))).longValue(), 0, e.byj());
      g.aAh().azQ().set(ar.a.NXZ, Boolean.TRUE);
    }
    AppMethodBeat.o(44571);
  }
  
  public static void byf()
  {
    AppMethodBeat.i(44572);
    if (!g.aAc())
    {
      AppMethodBeat.o(44572);
      return;
    }
    if (byd())
    {
      c(false, 0L);
      b(false, 0L, 0L);
      e locale = e.kVn;
      e.a((String)g.aAh().azQ().get(ar.a.NXU, ""), ((Long)g.aAh().azQ().get(ar.a.NXV, Long.valueOf(0L))).longValue(), 2, e.byj());
    }
    AppMethodBeat.o(44572);
  }
  
  private static void c(boolean paramBoolean, long paramLong)
  {
    AppMethodBeat.i(44566);
    if (!paramBoolean)
    {
      g.aAh().azQ().set(ar.a.NXT, Long.valueOf(0L));
      AppMethodBeat.o(44566);
      return;
    }
    if (paramLong == 0L) {}
    for (paramLong = 9223372036854775807L;; paramLong = Util.nowSecond() + Math.max(0L, paramLong))
    {
      g.aAh().azQ().set(ar.a.NXT, Long.valueOf(paramLong));
      g.aAh().azQ().set(ar.a.NYf, Boolean.TRUE);
      g.aAh().azQ().set(ar.a.NXZ, Boolean.FALSE);
      e locale = e.kVn;
      e.a((String)g.aAh().azQ().get(ar.a.NXU, ""), ((Long)g.aAh().azQ().get(ar.a.NXV, Long.valueOf(0L))).longValue(), 1, e.byj());
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
      kVc = new a("NONE", 0, 0);
      kVd = new a("REDDOT", 1, 1);
      kVe = new a("NEW", 2, 2);
      kVf = new a[] { kVc, kVd, kVe };
      AppMethodBeat.o(44551);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
  }
  
  public static final class b
    implements cj.a
  {
    private static final b kVg;
    
    static
    {
      AppMethodBeat.i(44557);
      kVg = new b();
      AppMethodBeat.o(44557);
    }
    
    public static void LW()
    {
      AppMethodBeat.i(44553);
      q.bxV();
      ((s)g.ah(s.class)).getSysCmdMsgExtension().a("wxareddot", kVg, true);
      AppMethodBeat.o(44553);
    }
    
    public static void unregister()
    {
      AppMethodBeat.i(44554);
      q.bxV();
      ((s)g.ah(s.class)).getSysCmdMsgExtension().b("wxareddot", kVg, true);
      AppMethodBeat.o(44554);
    }
    
    public final void a(final h.a parama)
    {
      AppMethodBeat.i(44555);
      parama = z.a(parama.heO.KHn);
      if (Util.isNullOrNil(parama))
      {
        AppMethodBeat.o(44555);
        return;
      }
      f.bZn().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(44552);
          t.b.Wv(parama);
          AppMethodBeat.o(44552);
        }
      });
      AppMethodBeat.o(44555);
    }
    
    public final void a(h.c paramc) {}
  }
  
  public static final class c {}
  
  public static final class d
  {
    public final String[] kVm;
    
    public d()
    {
      AppMethodBeat.i(44560);
      this.kVm = new String[9];
      Arrays.fill(this.kVm, "0");
      this.kVm[0] = ((String)g.aAh().azQ().get(ar.a.NXU, ""));
      this.kVm[1] = String.valueOf(g.aAh().azQ().get(ar.a.NXV, Long.valueOf(0L)));
      this.kVm[2] = String.valueOf(Util.nowSecond());
      AppMethodBeat.o(44560);
    }
    
    public final void byg()
    {
      this.kVm[8] = "1";
    }
  }
  
  public static final class e
  {
    public static final e kVn;
    
    static
    {
      AppMethodBeat.i(44565);
      kVn = new e();
      AppMethodBeat.o(44565);
    }
    
    static void a(String paramString, long paramLong, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(44564);
      h.CyF.a(14112, new Object[] { Integer.valueOf(1), Util.nullAsNil(paramString), Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      AppMethodBeat.o(44564);
    }
    
    static void byh()
    {
      AppMethodBeat.i(44561);
      a((String)g.aAh().azQ().get(ar.a.NXU, ""), ((Long)g.aAh().azQ().get(ar.a.NXV, Long.valueOf(0L))).longValue(), 3, byj());
      AppMethodBeat.o(44561);
    }
    
    public static void byi()
    {
      AppMethodBeat.i(44562);
      a("", 0L, 1, 1);
      AppMethodBeat.o(44562);
    }
    
    static int byj()
    {
      AppMethodBeat.i(44563);
      if (g.aAh().azQ().getBoolean(ar.a.NYa, false))
      {
        AppMethodBeat.o(44563);
        return 1;
      }
      int j = ((Integer)g.aAh().azQ().get(ar.a.NXX, Integer.valueOf(0))).intValue();
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