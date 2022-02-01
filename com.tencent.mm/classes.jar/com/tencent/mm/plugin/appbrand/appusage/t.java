package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.h.a;
import com.tencent.mm.an.h.c;
import com.tencent.mm.kernel.f;
import com.tencent.mm.model.ck;
import com.tencent.mm.model.ck.a;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.appbrand.ac.m.a;
import com.tencent.mm.plugin.messenger.foundation.a.v;
import com.tencent.mm.protocal.protobuf.db;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.util.Arrays;

public final class t
{
  public static final t.c nPo;
  
  static
  {
    AppMethodBeat.i(44575);
    nPo = new t.c();
    AppMethodBeat.o(44575);
  }
  
  private static void b(boolean paramBoolean, long paramLong1, long paramLong2)
  {
    long l = 0L;
    AppMethodBeat.i(44567);
    ao localao = com.tencent.mm.kernel.h.aHG().aHp();
    ar.a locala = ar.a.Vmc;
    if (!paramBoolean) {}
    for (paramLong1 = l;; paramLong1 = Math.max(0L, paramLong1) + l)
    {
      localao.set(locala, Long.valueOf(paramLong1));
      localao = com.tencent.mm.kernel.h.aHG().aHp();
      locala = ar.a.Vme;
      if (!paramBoolean) {
        paramLong2 = 9223372036854775807L;
      }
      localao.set(locala, Long.valueOf(paramLong2));
      AppMethodBeat.o(44567);
      return;
      l = Util.nowSecond();
    }
  }
  
  public static boolean bJq()
  {
    AppMethodBeat.i(44568);
    q.bJk();
    if (!com.tencent.mm.kernel.h.aHB())
    {
      AppMethodBeat.o(44568);
      return false;
    }
    boolean bool = ((Boolean)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.Vmf, Boolean.FALSE)).booleanValue();
    AppMethodBeat.o(44568);
    return bool;
  }
  
  static a bJr()
  {
    int i = 0;
    AppMethodBeat.i(44569);
    if (!bJs())
    {
      localObject = a.nPp;
      AppMethodBeat.o(44569);
      return localObject;
    }
    int j = ((Integer)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VlW, Integer.valueOf(0))).intValue();
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
    localObject = a.nPp;
    AppMethodBeat.o(44569);
    return localObject;
  }
  
  public static boolean bJs()
  {
    AppMethodBeat.i(44570);
    if (!com.tencent.mm.kernel.h.aHB())
    {
      AppMethodBeat.o(44570);
      return false;
    }
    long l = ((Long)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VlT, Long.valueOf(0L))).longValue();
    if (l > Util.nowSecond()) {}
    for (boolean bool = true;; bool = false)
    {
      if ((!bool) && (l > 0L))
      {
        com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VlT, Long.valueOf(0L));
        e locale = e.nPA;
        e.bJw();
      }
      AppMethodBeat.o(44570);
      return bool;
    }
  }
  
  static void bJt()
  {
    AppMethodBeat.i(44571);
    q.bJk();
    if (!com.tencent.mm.kernel.h.aHB())
    {
      AppMethodBeat.o(44571);
      return;
    }
    e locale = e.nPA;
    if (!((Boolean)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VlZ, Boolean.FALSE)).booleanValue())
    {
      e.a((String)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VlU, ""), ((Long)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VlV, Long.valueOf(0L))).longValue(), 0, e.bJy());
      com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VlZ, Boolean.TRUE);
    }
    AppMethodBeat.o(44571);
  }
  
  public static void bJu()
  {
    AppMethodBeat.i(44572);
    if (!com.tencent.mm.kernel.h.aHB())
    {
      AppMethodBeat.o(44572);
      return;
    }
    if (bJs())
    {
      c(false, 0L);
      b(false, 0L, 0L);
      e locale = e.nPA;
      e.a((String)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VlU, ""), ((Long)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VlV, Long.valueOf(0L))).longValue(), 2, e.bJy());
    }
    AppMethodBeat.o(44572);
  }
  
  private static void c(boolean paramBoolean, long paramLong)
  {
    AppMethodBeat.i(44566);
    if (!paramBoolean)
    {
      com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VlT, Long.valueOf(0L));
      AppMethodBeat.o(44566);
      return;
    }
    if (paramLong == 0L) {}
    for (paramLong = 9223372036854775807L;; paramLong = Util.nowSecond() + Math.max(0L, paramLong))
    {
      com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VlT, Long.valueOf(paramLong));
      com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.Vmf, Boolean.TRUE);
      com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VlZ, Boolean.FALSE);
      e locale = e.nPA;
      e.a((String)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VlU, ""), ((Long)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VlV, Long.valueOf(0L))).longValue(), 1, e.bJy());
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
      nPp = new a("NONE", 0, 0);
      nPq = new a("REDDOT", 1, 1);
      nPr = new a("NEW", 2, 2);
      nPs = new a[] { nPp, nPq, nPr };
      AppMethodBeat.o(44551);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
  }
  
  public static final class b
    implements ck.a
  {
    private static final b nPt;
    
    static
    {
      AppMethodBeat.i(44557);
      nPt = new b();
      AppMethodBeat.o(44557);
    }
    
    public static void OO()
    {
      AppMethodBeat.i(44553);
      q.bJk();
      ((v)com.tencent.mm.kernel.h.ag(v.class)).getSysCmdMsgExtension().a("wxareddot", nPt, true);
      AppMethodBeat.o(44553);
    }
    
    public static void unregister()
    {
      AppMethodBeat.i(44554);
      q.bJk();
      ((v)com.tencent.mm.kernel.h.ag(v.class)).getSysCmdMsgExtension().b("wxareddot", nPt, true);
      AppMethodBeat.o(44554);
    }
    
    public final void a(final h.a parama)
    {
      AppMethodBeat.i(44555);
      parama = z.a(parama.jQG.RIF);
      if (Util.isNullOrNil(parama))
      {
        AppMethodBeat.o(44555);
        return;
      }
      com.tencent.mm.plugin.appbrand.utils.h.clV().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(44552);
          t.b.aeh(parama);
          AppMethodBeat.o(44552);
        }
      });
      AppMethodBeat.o(44555);
    }
    
    public final void a(h.c paramc) {}
  }
  
  public static final class d
  {
    public final String[] nPz;
    
    public d()
    {
      AppMethodBeat.i(44560);
      this.nPz = new String[9];
      Arrays.fill(this.nPz, "0");
      this.nPz[0] = ((String)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VlU, ""));
      this.nPz[1] = String.valueOf(com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VlV, Long.valueOf(0L)));
      this.nPz[2] = String.valueOf(Util.nowSecond());
      AppMethodBeat.o(44560);
    }
    
    public final void bJv()
    {
      this.nPz[8] = "1";
    }
  }
  
  public static final class e
  {
    public static final e nPA;
    
    static
    {
      AppMethodBeat.i(44565);
      nPA = new e();
      AppMethodBeat.o(44565);
    }
    
    static void a(String paramString, long paramLong, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(44564);
      com.tencent.mm.plugin.report.service.h.IzE.a(14112, new Object[] { Integer.valueOf(1), Util.nullAsNil(paramString), Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      AppMethodBeat.o(44564);
    }
    
    static void bJw()
    {
      AppMethodBeat.i(44561);
      a((String)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VlU, ""), ((Long)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VlV, Long.valueOf(0L))).longValue(), 3, bJy());
      AppMethodBeat.o(44561);
    }
    
    public static void bJx()
    {
      AppMethodBeat.i(44562);
      a("", 0L, 1, 1);
      AppMethodBeat.o(44562);
    }
    
    static int bJy()
    {
      AppMethodBeat.i(44563);
      if (com.tencent.mm.kernel.h.aHG().aHp().getBoolean(ar.a.Vma, false))
      {
        AppMethodBeat.o(44563);
        return 1;
      }
      int j = ((Integer)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VlX, Integer.valueOf(0))).intValue();
      int i = j;
      if (j > 0) {
        i = j + 1;
      }
      AppMethodBeat.o(44563);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.t
 * JD-Core Version:    0.7.0.1
 */