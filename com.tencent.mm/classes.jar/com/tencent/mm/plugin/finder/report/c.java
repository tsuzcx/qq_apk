package com.tencent.mm.plugin.finder.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.f.b.a.cs;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/report/FinderBulletSubtitleReporter;", "", "()V", "cache", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/plugin/finder/report/FinderBulletSubtitleReporter$FeedBulletData;", "getCache", "()Ljava/util/concurrent/ConcurrentHashMap;", "dequeReportData", "", "feedId", "everclosed", "", "everopened", "expocnt", "expotimes", "is_open", "value", "", "report20353", "mediaType", "action", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "start", "totalcnt", "FeedBulletData", "plugin-finder_release"})
public final class c
{
  private static final ConcurrentHashMap<Long, a> cache;
  public static final c zTT;
  
  static
  {
    AppMethodBeat.i(271002);
    zTT = new c();
    cache = new ConcurrentHashMap();
    AppMethodBeat.o(271002);
  }
  
  public static void L(long paramLong, int paramInt)
  {
    AppMethodBeat.i(270989);
    a locala = (a)cache.get(Long.valueOf(paramLong));
    if (locala != null)
    {
      locala.zTW = paramInt;
      AppMethodBeat.o(270989);
      return;
    }
    AppMethodBeat.o(270989);
  }
  
  public static void M(long paramLong, int paramInt)
  {
    AppMethodBeat.i(270990);
    a locala = (a)cache.get(Long.valueOf(paramLong));
    if (locala != null)
    {
      locala.zTX = paramInt;
      AppMethodBeat.o(270990);
      return;
    }
    AppMethodBeat.o(270990);
  }
  
  public static void Me(long paramLong)
  {
    AppMethodBeat.i(270985);
    a locala = (a)cache.get(Long.valueOf(paramLong));
    if (locala != null)
    {
      locala.zTU += 1;
      AppMethodBeat.o(270985);
      return;
    }
    AppMethodBeat.o(270985);
  }
  
  public static void Mf(long paramLong)
  {
    AppMethodBeat.i(270987);
    a locala = (a)cache.get(Long.valueOf(paramLong));
    if (locala != null)
    {
      locala.zTV += 1;
      AppMethodBeat.o(270987);
      return;
    }
    AppMethodBeat.o(270987);
  }
  
  public static void Mg(long paramLong)
  {
    AppMethodBeat.i(270992);
    a locala = (a)cache.get(Long.valueOf(paramLong));
    if (locala != null)
    {
      locala.zTY = 1;
      AppMethodBeat.o(270992);
      return;
    }
    AppMethodBeat.o(270992);
  }
  
  public static void Mh(long paramLong)
  {
    AppMethodBeat.i(270994);
    a locala = (a)cache.get(Long.valueOf(paramLong));
    if (locala != null)
    {
      locala.zTZ = 1;
      AppMethodBeat.o(270994);
      return;
    }
    AppMethodBeat.o(270994);
  }
  
  public static String Mi(long paramLong)
  {
    int i = 1;
    AppMethodBeat.i(270998);
    Object localObject = (a)cache.get(Long.valueOf(paramLong));
    if (localObject == null)
    {
      AppMethodBeat.o(270998);
      return "";
    }
    p.j(localObject, "cache[feedId] ?: return \"\"");
    cache.remove(Long.valueOf(paramLong));
    f localf = h.aHG();
    p.j(localf, "MMKernel.storage()");
    if (localf.aHp().getBoolean(ar.a.VBI, true)) {}
    for (;;)
    {
      ((a)localObject).zTX = i;
      localObject = "{expocnt:" + ((a)localObject).zTU + ";expotimes:" + ((a)localObject).zTV + ";totalcnt:" + ((a)localObject).zTW + ';' + "is_open:" + ((a)localObject).zTX + ";everclosed:" + ((a)localObject).zTY + ";everopened:" + ((a)localObject).zTZ + '}';
      AppMethodBeat.o(270998);
      return localObject;
      i = 0;
    }
  }
  
  public static void a(long paramLong, int paramInt1, int paramInt2, bid parambid)
  {
    AppMethodBeat.i(271000);
    p.k(parambid, "contextObj");
    cs localcs = new cs();
    localcs.nc(d.Fw(paramLong));
    localcs.gc(paramInt1);
    localcs.gd(parambid.xkX);
    localcs.ge(paramInt2);
    localcs.nd(parambid.sessionId);
    localcs.ne(parambid.wmL);
    localcs.nf(parambid.wmz);
    localcs.bpa();
    parambid = n.zWF;
    n.a((a)localcs);
    AppMethodBeat.o(271000);
  }
  
  public static void start(long paramLong)
  {
    AppMethodBeat.i(270996);
    if (!cache.containsKey(Long.valueOf(paramLong))) {
      cache.put(Long.valueOf(paramLong), new a());
    }
    AppMethodBeat.o(270996);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/report/FinderBulletSubtitleReporter$FeedBulletData;", "", "()V", "everclosed", "", "getEverclosed", "()I", "setEverclosed", "(I)V", "everopened", "getEveropened", "setEveropened", "expocnt", "getExpocnt", "setExpocnt", "expotimes", "getExpotimes", "setExpotimes", "is_open", "set_open", "totalcnt", "getTotalcnt", "setTotalcnt", "plugin-finder_release"})
  public static final class a
  {
    int zTU;
    int zTV;
    int zTW;
    int zTX = 1;
    int zTY;
    int zTZ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.c
 * JD-Core Version:    0.7.0.1
 */