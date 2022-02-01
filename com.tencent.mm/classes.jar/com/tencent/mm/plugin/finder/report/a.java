package com.tencent.mm.plugin.finder.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.c;
import com.tencent.mm.g.b.a.aw;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.arn;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import d.g.b.p;
import d.l;
import java.util.concurrent.ConcurrentHashMap;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/report/FinderBulletSubtitleReporter;", "", "()V", "cache", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/plugin/finder/report/FinderBulletSubtitleReporter$FeedBulletData;", "getCache", "()Ljava/util/concurrent/ConcurrentHashMap;", "dequeReportData", "", "feedId", "everclosed", "", "everopened", "expocnt", "expotimes", "is_open", "value", "", "report20353", "mediaType", "action", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "start", "totalcnt", "FeedBulletData", "plugin-finder_release"})
public final class a
{
  private static final ConcurrentHashMap<Long, a> cache;
  public static final a swO;
  
  static
  {
    AppMethodBeat.i(203729);
    swO = new a();
    cache = new ConcurrentHashMap();
    AppMethodBeat.o(203729);
  }
  
  public static void G(long paramLong, int paramInt)
  {
    AppMethodBeat.i(203722);
    a locala = (a)cache.get(Long.valueOf(paramLong));
    if (locala != null)
    {
      locala.swR = paramInt;
      AppMethodBeat.o(203722);
      return;
    }
    AppMethodBeat.o(203722);
  }
  
  public static void H(long paramLong, int paramInt)
  {
    AppMethodBeat.i(203723);
    a locala = (a)cache.get(Long.valueOf(paramLong));
    if (locala != null)
    {
      locala.swS = paramInt;
      AppMethodBeat.o(203723);
      return;
    }
    AppMethodBeat.o(203723);
  }
  
  public static void a(long paramLong, int paramInt1, int paramInt2, arn paramarn)
  {
    AppMethodBeat.i(203728);
    p.h(paramarn, "contextObj");
    aw localaw = new aw();
    localaw.iE(c.rp(paramLong));
    localaw.dX(paramInt1);
    localaw.dY(paramarn.sch);
    localaw.dZ(paramInt2);
    localaw.iF(paramarn.sessionId);
    localaw.iG(paramarn.rfA);
    localaw.iH(paramarn.rfo);
    localaw.aLH();
    paramarn = i.syT;
    i.a((com.tencent.mm.plugin.report.a)localaw);
    AppMethodBeat.o(203728);
  }
  
  public static void start(long paramLong)
  {
    AppMethodBeat.i(203726);
    if (!cache.containsKey(Long.valueOf(paramLong))) {
      cache.put(Long.valueOf(paramLong), new a());
    }
    AppMethodBeat.o(203726);
  }
  
  public static void wB(long paramLong)
  {
    AppMethodBeat.i(203720);
    a locala = (a)cache.get(Long.valueOf(paramLong));
    if (locala != null)
    {
      locala.swP += 1;
      AppMethodBeat.o(203720);
      return;
    }
    AppMethodBeat.o(203720);
  }
  
  public static void wC(long paramLong)
  {
    AppMethodBeat.i(203721);
    a locala = (a)cache.get(Long.valueOf(paramLong));
    if (locala != null)
    {
      locala.swQ += 1;
      AppMethodBeat.o(203721);
      return;
    }
    AppMethodBeat.o(203721);
  }
  
  public static void wD(long paramLong)
  {
    AppMethodBeat.i(203724);
    a locala = (a)cache.get(Long.valueOf(paramLong));
    if (locala != null)
    {
      locala.swT = 1;
      AppMethodBeat.o(203724);
      return;
    }
    AppMethodBeat.o(203724);
  }
  
  public static void wE(long paramLong)
  {
    AppMethodBeat.i(203725);
    a locala = (a)cache.get(Long.valueOf(paramLong));
    if (locala != null)
    {
      locala.swU = 1;
      AppMethodBeat.o(203725);
      return;
    }
    AppMethodBeat.o(203725);
  }
  
  public static String wF(long paramLong)
  {
    int i = 1;
    AppMethodBeat.i(203727);
    Object localObject = (a)cache.get(Long.valueOf(paramLong));
    if (localObject == null)
    {
      AppMethodBeat.o(203727);
      return "";
    }
    p.g(localObject, "cache[feedId] ?: return \"\"");
    cache.remove(Long.valueOf(paramLong));
    e locale = g.ajR();
    p.g(locale, "MMKernel.storage()");
    if (locale.ajA().getBoolean(am.a.Jdu, true)) {}
    for (;;)
    {
      ((a)localObject).swS = i;
      localObject = "{expocnt:" + ((a)localObject).swP + ";expotimes:" + ((a)localObject).swQ + ";totalcnt:" + ((a)localObject).swR + ';' + "is_open:" + ((a)localObject).swS + ";everclosed:" + ((a)localObject).swT + ";everopened:" + ((a)localObject).swU + '}';
      AppMethodBeat.o(203727);
      return localObject;
      i = 0;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/report/FinderBulletSubtitleReporter$FeedBulletData;", "", "()V", "everclosed", "", "getEverclosed", "()I", "setEverclosed", "(I)V", "everopened", "getEveropened", "setEveropened", "expocnt", "getExpocnt", "setExpocnt", "expotimes", "getExpotimes", "setExpotimes", "is_open", "set_open", "totalcnt", "getTotalcnt", "setTotalcnt", "plugin-finder_release"})
  public static final class a
  {
    int swP;
    int swQ;
    int swR;
    int swS = 1;
    int swT;
    int swU;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.a
 * JD-Core Version:    0.7.0.1
 */