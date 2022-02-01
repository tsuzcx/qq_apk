package com.tencent.mm.plugin.finder.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.c;
import com.tencent.mm.g.b.a.aw;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.aqy;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import d.g.b.p;
import d.l;
import java.util.concurrent.ConcurrentHashMap;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/report/FinderBulletSubtitleReporter;", "", "()V", "cache", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/plugin/finder/report/FinderBulletSubtitleReporter$FeedBulletData;", "getCache", "()Ljava/util/concurrent/ConcurrentHashMap;", "dequeReportData", "", "feedId", "everclosed", "", "everopened", "expocnt", "expotimes", "is_open", "value", "", "report20353", "mediaType", "action", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "start", "totalcnt", "FeedBulletData", "plugin-finder_release"})
public final class a
{
  private static final ConcurrentHashMap<Long, a> cache;
  public static final a smX;
  
  static
  {
    AppMethodBeat.i(203188);
    smX = new a();
    cache = new ConcurrentHashMap();
    AppMethodBeat.o(203188);
  }
  
  public static void G(long paramLong, int paramInt)
  {
    AppMethodBeat.i(203181);
    a locala = (a)cache.get(Long.valueOf(paramLong));
    if (locala != null)
    {
      locala.sna = paramInt;
      AppMethodBeat.o(203181);
      return;
    }
    AppMethodBeat.o(203181);
  }
  
  public static void H(long paramLong, int paramInt)
  {
    AppMethodBeat.i(203182);
    a locala = (a)cache.get(Long.valueOf(paramLong));
    if (locala != null)
    {
      locala.snb = paramInt;
      AppMethodBeat.o(203182);
      return;
    }
    AppMethodBeat.o(203182);
  }
  
  public static void a(long paramLong, int paramInt1, int paramInt2, aqy paramaqy)
  {
    AppMethodBeat.i(203187);
    p.h(paramaqy, "contextObj");
    aw localaw = new aw();
    localaw.iu(c.rc(paramLong));
    localaw.dW(paramInt1);
    localaw.dX(paramaqy.rTD);
    localaw.dY(paramInt2);
    localaw.iv(paramaqy.sessionId);
    localaw.iw(paramaqy.qXu);
    localaw.ix(paramaqy.qXj);
    localaw.aLk();
    paramaqy = h.soM;
    h.a((com.tencent.mm.plugin.report.a)localaw);
    AppMethodBeat.o(203187);
  }
  
  public static void start(long paramLong)
  {
    AppMethodBeat.i(203185);
    if (!cache.containsKey(Long.valueOf(paramLong))) {
      cache.put(Long.valueOf(paramLong), new a());
    }
    AppMethodBeat.o(203185);
  }
  
  public static void wl(long paramLong)
  {
    AppMethodBeat.i(203179);
    a locala = (a)cache.get(Long.valueOf(paramLong));
    if (locala != null)
    {
      locala.smY += 1;
      AppMethodBeat.o(203179);
      return;
    }
    AppMethodBeat.o(203179);
  }
  
  public static void wm(long paramLong)
  {
    AppMethodBeat.i(203180);
    a locala = (a)cache.get(Long.valueOf(paramLong));
    if (locala != null)
    {
      locala.smZ += 1;
      AppMethodBeat.o(203180);
      return;
    }
    AppMethodBeat.o(203180);
  }
  
  public static void wn(long paramLong)
  {
    AppMethodBeat.i(203183);
    a locala = (a)cache.get(Long.valueOf(paramLong));
    if (locala != null)
    {
      locala.snc = 1;
      AppMethodBeat.o(203183);
      return;
    }
    AppMethodBeat.o(203183);
  }
  
  public static void wo(long paramLong)
  {
    AppMethodBeat.i(203184);
    a locala = (a)cache.get(Long.valueOf(paramLong));
    if (locala != null)
    {
      locala.snd = 1;
      AppMethodBeat.o(203184);
      return;
    }
    AppMethodBeat.o(203184);
  }
  
  public static String wp(long paramLong)
  {
    int i = 1;
    AppMethodBeat.i(203186);
    Object localObject = (a)cache.get(Long.valueOf(paramLong));
    if (localObject == null)
    {
      AppMethodBeat.o(203186);
      return "";
    }
    p.g(localObject, "cache[feedId] ?: return \"\"");
    cache.remove(Long.valueOf(paramLong));
    e locale = g.ajC();
    p.g(locale, "MMKernel.storage()");
    if (locale.ajl().getBoolean(al.a.IIP, true)) {}
    for (;;)
    {
      ((a)localObject).snb = i;
      localObject = "{expocnt:" + ((a)localObject).smY + ";expotimes:" + ((a)localObject).smZ + ";totalcnt:" + ((a)localObject).sna + ';' + "is_open:" + ((a)localObject).snb + ";everclosed:" + ((a)localObject).snc + ";everopened:" + ((a)localObject).snd + '}';
      AppMethodBeat.o(203186);
      return localObject;
      i = 0;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/report/FinderBulletSubtitleReporter$FeedBulletData;", "", "()V", "everclosed", "", "getEverclosed", "()I", "setEverclosed", "(I)V", "everopened", "getEveropened", "setEveropened", "expocnt", "getExpocnt", "setExpocnt", "expotimes", "getExpotimes", "setExpotimes", "is_open", "set_open", "totalcnt", "getTotalcnt", "setTotalcnt", "plugin-finder_release"})
  public static final class a
  {
    int smY;
    int smZ;
    int sna;
    int snb = 1;
    int snc;
    int snd;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.a
 * JD-Core Version:    0.7.0.1
 */