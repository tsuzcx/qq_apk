package com.tencent.mm.plugin.finder.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.g.b.a.cb;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/report/FinderBulletSubtitleReporter;", "", "()V", "cache", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/plugin/finder/report/FinderBulletSubtitleReporter$FeedBulletData;", "getCache", "()Ljava/util/concurrent/ConcurrentHashMap;", "dequeReportData", "", "feedId", "everclosed", "", "everopened", "expocnt", "expotimes", "is_open", "value", "", "report20353", "mediaType", "action", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "start", "totalcnt", "FeedBulletData", "plugin-finder_release"})
public final class c
{
  private static final ConcurrentHashMap<Long, a> cache;
  public static final c vdc;
  
  static
  {
    AppMethodBeat.i(250526);
    vdc = new c();
    cache = new ConcurrentHashMap();
    AppMethodBeat.o(250526);
  }
  
  public static void E(long paramLong, int paramInt)
  {
    AppMethodBeat.i(250519);
    a locala = (a)cache.get(Long.valueOf(paramLong));
    if (locala != null)
    {
      locala.vdf = paramInt;
      AppMethodBeat.o(250519);
      return;
    }
    AppMethodBeat.o(250519);
  }
  
  public static void EU(long paramLong)
  {
    AppMethodBeat.i(250517);
    a locala = (a)cache.get(Long.valueOf(paramLong));
    if (locala != null)
    {
      locala.vdd += 1;
      AppMethodBeat.o(250517);
      return;
    }
    AppMethodBeat.o(250517);
  }
  
  public static void EV(long paramLong)
  {
    AppMethodBeat.i(250518);
    a locala = (a)cache.get(Long.valueOf(paramLong));
    if (locala != null)
    {
      locala.vde += 1;
      AppMethodBeat.o(250518);
      return;
    }
    AppMethodBeat.o(250518);
  }
  
  public static void EW(long paramLong)
  {
    AppMethodBeat.i(250521);
    a locala = (a)cache.get(Long.valueOf(paramLong));
    if (locala != null)
    {
      locala.vdh = 1;
      AppMethodBeat.o(250521);
      return;
    }
    AppMethodBeat.o(250521);
  }
  
  public static void EX(long paramLong)
  {
    AppMethodBeat.i(250522);
    a locala = (a)cache.get(Long.valueOf(paramLong));
    if (locala != null)
    {
      locala.vdi = 1;
      AppMethodBeat.o(250522);
      return;
    }
    AppMethodBeat.o(250522);
  }
  
  public static String EY(long paramLong)
  {
    int i = 1;
    AppMethodBeat.i(250524);
    Object localObject = (a)cache.get(Long.valueOf(paramLong));
    if (localObject == null)
    {
      AppMethodBeat.o(250524);
      return "";
    }
    p.g(localObject, "cache[feedId] ?: return \"\"");
    cache.remove(Long.valueOf(paramLong));
    e locale = g.aAh();
    p.g(locale, "MMKernel.storage()");
    if (locale.azQ().getBoolean(ar.a.OmJ, true)) {}
    for (;;)
    {
      ((a)localObject).vdg = i;
      localObject = "{expocnt:" + ((a)localObject).vdd + ";expotimes:" + ((a)localObject).vde + ";totalcnt:" + ((a)localObject).vdf + ';' + "is_open:" + ((a)localObject).vdg + ";everclosed:" + ((a)localObject).vdh + ";everopened:" + ((a)localObject).vdi + '}';
      AppMethodBeat.o(250524);
      return localObject;
      i = 0;
    }
  }
  
  public static void F(long paramLong, int paramInt)
  {
    AppMethodBeat.i(250520);
    a locala = (a)cache.get(Long.valueOf(paramLong));
    if (locala != null)
    {
      locala.vdg = paramInt;
      AppMethodBeat.o(250520);
      return;
    }
    AppMethodBeat.o(250520);
  }
  
  public static void a(long paramLong, int paramInt1, int paramInt2, bbn parambbn)
  {
    AppMethodBeat.i(250525);
    p.h(parambbn, "contextObj");
    cb localcb = new cb();
    localcb.kM(d.zs(paramLong));
    localcb.fm(paramInt1);
    localcb.fn(parambbn.tCE);
    localcb.fo(paramInt2);
    localcb.kN(parambbn.sessionId);
    localcb.kO(parambbn.sGQ);
    localcb.kP(parambbn.sGE);
    localcb.bfK();
    parambbn = k.vfA;
    k.a((a)localcb);
    AppMethodBeat.o(250525);
  }
  
  public static void start(long paramLong)
  {
    AppMethodBeat.i(250523);
    if (!cache.containsKey(Long.valueOf(paramLong))) {
      cache.put(Long.valueOf(paramLong), new a());
    }
    AppMethodBeat.o(250523);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/report/FinderBulletSubtitleReporter$FeedBulletData;", "", "()V", "everclosed", "", "getEverclosed", "()I", "setEverclosed", "(I)V", "everopened", "getEveropened", "setEveropened", "expocnt", "getExpocnt", "setExpocnt", "expotimes", "getExpotimes", "setExpotimes", "is_open", "set_open", "totalcnt", "getTotalcnt", "setTotalcnt", "plugin-finder_release"})
  public static final class a
  {
    int vdd;
    int vde;
    int vdf;
    int vdg = 1;
    int vdh;
    int vdi;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.c
 * JD-Core Version:    0.7.0.1
 */