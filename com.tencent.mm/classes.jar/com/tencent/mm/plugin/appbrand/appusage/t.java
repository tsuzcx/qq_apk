package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.e.a;
import com.tencent.mm.al.e.c;
import com.tencent.mm.al.n;
import com.tencent.mm.al.x;
import com.tencent.mm.al.x.a;
import com.tencent.mm.model.cd;
import com.tencent.mm.model.cd.a;
import com.tencent.mm.modelgeo.d;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.appbrand.z.m.a;
import com.tencent.mm.plugin.messenger.foundation.a.r;
import com.tencent.mm.protocal.protobuf.cv;
import com.tencent.mm.protocal.protobuf.dtf;
import com.tencent.mm.protocal.protobuf.dtg;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import java.util.Arrays;

public final class t
{
  public static final c jOZ;
  
  static
  {
    AppMethodBeat.i(44575);
    jOZ = new c();
    AppMethodBeat.o(44575);
  }
  
  private static void a(boolean paramBoolean, long paramLong1, long paramLong2)
  {
    long l = 0L;
    AppMethodBeat.i(44567);
    ai localai = com.tencent.mm.kernel.g.ajC().ajl();
    al.a locala = al.a.IvD;
    if (!paramBoolean) {}
    for (paramLong1 = l;; paramLong1 = Math.max(0L, paramLong1) + l)
    {
      localai.set(locala, Long.valueOf(paramLong1));
      localai = com.tencent.mm.kernel.g.ajC().ajl();
      locala = al.a.IvF;
      if (!paramBoolean) {
        paramLong2 = 9223372036854775807L;
      }
      localai.set(locala, Long.valueOf(paramLong2));
      AppMethodBeat.o(44567);
      return;
      l = bt.aQJ();
    }
  }
  
  public static boolean bch()
  {
    AppMethodBeat.i(44568);
    q.bcb();
    if (!com.tencent.mm.kernel.g.ajx())
    {
      AppMethodBeat.o(44568);
      return false;
    }
    boolean bool = ((Boolean)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.IvG, Boolean.FALSE)).booleanValue();
    AppMethodBeat.o(44568);
    return bool;
  }
  
  static a bci()
  {
    int i = 0;
    AppMethodBeat.i(44569);
    if (!bcj())
    {
      localObject = a.jPa;
      AppMethodBeat.o(44569);
      return localObject;
    }
    int j = ((Integer)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.Ivx, Integer.valueOf(0))).intValue();
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
    localObject = a.jPa;
    AppMethodBeat.o(44569);
    return localObject;
  }
  
  public static boolean bcj()
  {
    AppMethodBeat.i(44570);
    if (!com.tencent.mm.kernel.g.ajx())
    {
      AppMethodBeat.o(44570);
      return false;
    }
    long l = ((Long)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.Ivu, Long.valueOf(0L))).longValue();
    if (l > bt.aQJ()) {}
    for (boolean bool = true;; bool = false)
    {
      if ((!bool) && (l > 0L))
      {
        com.tencent.mm.kernel.g.ajC().ajl().set(al.a.Ivu, Long.valueOf(0L));
        e locale = e.jPl;
        e.bcn();
      }
      AppMethodBeat.o(44570);
      return bool;
    }
  }
  
  static void bck()
  {
    AppMethodBeat.i(44571);
    q.bcb();
    if (!com.tencent.mm.kernel.g.ajx())
    {
      AppMethodBeat.o(44571);
      return;
    }
    e locale = e.jPl;
    if (!((Boolean)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.IvA, Boolean.FALSE)).booleanValue())
    {
      e.a((String)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.Ivv, ""), ((Long)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.Ivw, Long.valueOf(0L))).longValue(), 0, e.bcp());
      com.tencent.mm.kernel.g.ajC().ajl().set(al.a.IvA, Boolean.TRUE);
    }
    AppMethodBeat.o(44571);
  }
  
  public static void bcl()
  {
    AppMethodBeat.i(44572);
    if (!com.tencent.mm.kernel.g.ajx())
    {
      AppMethodBeat.o(44572);
      return;
    }
    if (bcj())
    {
      c(false, 0L);
      a(false, 0L, 0L);
      e locale = e.jPl;
      e.a((String)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.Ivv, ""), ((Long)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.Ivw, Long.valueOf(0L))).longValue(), 2, e.bcp());
    }
    AppMethodBeat.o(44572);
  }
  
  private static void c(boolean paramBoolean, long paramLong)
  {
    AppMethodBeat.i(44566);
    if (!paramBoolean)
    {
      com.tencent.mm.kernel.g.ajC().ajl().set(al.a.Ivu, Long.valueOf(0L));
      AppMethodBeat.o(44566);
      return;
    }
    if (paramLong == 0L) {}
    for (paramLong = 9223372036854775807L;; paramLong = bt.aQJ() + Math.max(0L, paramLong))
    {
      com.tencent.mm.kernel.g.ajC().ajl().set(al.a.Ivu, Long.valueOf(paramLong));
      com.tencent.mm.kernel.g.ajC().ajl().set(al.a.IvG, Boolean.TRUE);
      com.tencent.mm.kernel.g.ajC().ajl().set(al.a.IvA, Boolean.FALSE);
      e locale = e.jPl;
      e.a((String)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.Ivv, ""), ((Long)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.Ivw, Long.valueOf(0L))).longValue(), 1, e.bcp());
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
      jPa = new a("NONE", 0, 0);
      jPb = new a("REDDOT", 1, 1);
      jPc = new a("NEW", 2, 2);
      jPd = new a[] { jPa, jPb, jPc };
      AppMethodBeat.o(44551);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
  }
  
  public static final class b
    implements cd.a
  {
    private static final b jPe;
    
    static
    {
      AppMethodBeat.i(44557);
      jPe = new b();
      AppMethodBeat.o(44557);
    }
    
    public static void Cx()
    {
      AppMethodBeat.i(44553);
      q.bcb();
      ((r)com.tencent.mm.kernel.g.ad(r.class)).getSysCmdMsgExtension().a("wxareddot", jPe, true);
      AppMethodBeat.o(44553);
    }
    
    public static void unregister()
    {
      AppMethodBeat.i(44554);
      q.bcb();
      ((r)com.tencent.mm.kernel.g.ad(r.class)).getSysCmdMsgExtension().b("wxareddot", jPe, true);
      AppMethodBeat.o(44554);
    }
    
    public final void a(final e.a parama)
    {
      AppMethodBeat.i(44555);
      parama = z.a(parama.gqE.Fvk);
      if (bt.isNullOrNil(parama))
      {
        AppMethodBeat.o(44555);
        return;
      }
      com.tencent.mm.plugin.appbrand.utils.e.bBp().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(44552);
          t.b.MG(parama);
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
    public final String[] jPk;
    
    public d()
    {
      AppMethodBeat.i(44560);
      this.jPk = new String[9];
      Arrays.fill(this.jPk, "0");
      this.jPk[0] = ((String)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.Ivv, ""));
      this.jPk[1] = String.valueOf(com.tencent.mm.kernel.g.ajC().ajl().get(al.a.Ivw, Long.valueOf(0L)));
      this.jPk[2] = String.valueOf(bt.aQJ());
      AppMethodBeat.o(44560);
    }
    
    public final void bcm()
    {
      this.jPk[8] = "1";
    }
  }
  
  public static final class e
  {
    public static final e jPl;
    
    static
    {
      AppMethodBeat.i(44565);
      jPl = new e();
      AppMethodBeat.o(44565);
    }
    
    static void a(String paramString, long paramLong, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(44564);
      com.tencent.mm.plugin.report.service.g.yhR.f(14112, new Object[] { Integer.valueOf(1), bt.nullAsNil(paramString), Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      AppMethodBeat.o(44564);
    }
    
    static void bcn()
    {
      AppMethodBeat.i(44561);
      a((String)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.Ivv, ""), ((Long)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.Ivw, Long.valueOf(0L))).longValue(), 3, bcp());
      AppMethodBeat.o(44561);
    }
    
    public static void bco()
    {
      AppMethodBeat.i(44562);
      a("", 0L, 1, 1);
      AppMethodBeat.o(44562);
    }
    
    static int bcp()
    {
      AppMethodBeat.i(44563);
      if (com.tencent.mm.kernel.g.ajC().ajl().getBoolean(al.a.IvB, false))
      {
        AppMethodBeat.o(44563);
        return 1;
      }
      int j = ((Integer)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.Ivy, Integer.valueOf(0))).intValue();
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