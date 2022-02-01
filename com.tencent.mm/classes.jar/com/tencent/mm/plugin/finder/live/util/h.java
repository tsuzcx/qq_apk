package com.tencent.mm.plugin.finder.live.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/util/CDNStatistics;", "", "()V", "audioBitrateStatisticsCache", "Lcom/tencent/mm/plugin/finder/live/util/StatisticsCache;", "getAudioBitrateStatisticsCache", "()Lcom/tencent/mm/plugin/finder/live/util/StatisticsCache;", "avPlayIntervalStatisticsCache", "getAvPlayIntervalStatisticsCache", "avRecIntervalStatisticsCache", "getAvRecIntervalStatisticsCache", "cacheList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getCacheList", "()Ljava/util/ArrayList;", "cpuStatisticsCache", "getCpuStatisticsCache", "frameRateStatisticsCache", "getFrameRateStatisticsCache", "heightStatisticsCache", "getHeightStatisticsCache", "netJitStatisticsCache", "getNetJitStatisticsCache", "netSpeedStatisticsCache", "getNetSpeedStatisticsCache", "sumCacheStatisticsCache", "getSumCacheStatisticsCache", "videoBitrateStatisticsCache", "getVideoBitrateStatisticsCache", "videoCacheStatisticsCache", "getVideoCacheStatisticsCache", "widthStatisticsCache", "getWidthStatisticsCache", "getLevelStr", "", "getRealTimeStr", "plugin-finder_release"})
public final class h
{
  private final ArrayList<w> uwf;
  public final w uwg;
  public final w uwh;
  public final w uwi;
  public final w uwj;
  public final w uwk;
  public final w uwl;
  public final w uwm;
  public final w uwn;
  public final w uwo;
  public final w uwp;
  public final w uwq;
  public final w uwr;
  
  public h()
  {
    AppMethodBeat.i(247241);
    this.uwf = new ArrayList();
    this.uwg = new c().did();
    this.uwh = new aa().did();
    this.uwi = new d().did();
    this.uwj = new m().did();
    this.uwk = new ac().did();
    this.uwl = new o().did();
    Object localObject = new s();
    ((s)localObject).uvW.add(new i("BadNetSpeed", 300, 4));
    ((s)localObject).uvW.add(new i("NormalNetSpeed", 1800, 4));
    ((s)localObject).uvW.add(new i("GoodNetSpeed", 2147483647, 4));
    this.uwm = new w(((s)localObject).uvU, ((s)localObject).uvV, ((s)localObject).uvW);
    localObject = new r();
    ((r)localObject).uvW.add(new i("GoodNetJit", 3, 4));
    ((r)localObject).uvW.add(new i("NormalNetJit", 10, 4));
    ((r)localObject).uvW.add(new i("BadNetJit", 2147483647, 4));
    this.uwn = new w(((r)localObject).uvU, ((r)localObject).uvV, ((r)localObject).uvW);
    localObject = new b();
    ((b)localObject).uvW.add(new i("GoodAVRecInterval", 10, 4));
    ((b)localObject).uvW.add(new i("NormalAVRecInterval", 50, 4));
    ((b)localObject).uvW.add(new i("BadAVRecInterval", 2147483647, 4));
    this.uwo = new w(((b)localObject).uvU, ((b)localObject).uvV, ((b)localObject).uvW);
    localObject = new a();
    ((a)localObject).uvW.add(new i("GoodAVPlayInterval", 10, 4));
    ((a)localObject).uvW.add(new i("NormalAVPlayInterval", 50, 4));
    ((a)localObject).uvW.add(new i("BadAVPlayInterval", 2147483647, 4));
    this.uwp = new w(((a)localObject).uvU, ((a)localObject).uvV, ((a)localObject).uvW);
    localObject = new ab();
    ((ab)localObject).uvW.add(new i("BadVideoCache", 100, 4));
    ((ab)localObject).uvW.add(new i("NormalVideoCache", 1500, 4));
    ((ab)localObject).uvW.add(new i("GoodVideoCache", 2147483647, 4));
    this.uwq = new w(((ab)localObject).uvU, ((ab)localObject).uvV, ((ab)localObject).uvW);
    localObject = new x();
    ((x)localObject).uvW.add(new i("BadSumCacheSize", 100, 4));
    ((x)localObject).uvW.add(new i("NormalSumCacheSize", 1500, 4));
    ((x)localObject).uvW.add(new i("GoodSumCacheSize", 2147483647, 4));
    this.uwr = new w(((x)localObject).uvU, ((x)localObject).uvV, ((x)localObject).uvW);
    this.uwf.add(this.uwg);
    this.uwf.add(this.uwh);
    this.uwf.add(this.uwi);
    this.uwf.add(this.uwj);
    this.uwf.add(this.uwm);
    this.uwf.add(this.uwn);
    this.uwf.add(this.uwo);
    this.uwf.add(this.uwp);
    this.uwf.add(this.uwq);
    this.uwf.add(this.uwr);
    AppMethodBeat.o(247241);
  }
  
  public final String dif()
  {
    AppMethodBeat.i(247240);
    Object localObject1 = new StringBuilder();
    Iterator localIterator = ((Iterable)this.uwf).iterator();
    while (localIterator.hasNext())
    {
      Object localObject2 = ((w)localIterator.next()).uxo;
      if (localObject2 != null)
      {
        localObject2 = ((Iterable)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          i locali = (i)((Iterator)localObject2).next();
          ((StringBuilder)localObject1).append("{" + locali.key + '(' + locali.value + "):" + locali.hjI + "};");
        }
      }
      ((StringBuilder)localObject1).append("\n");
    }
    localObject1 = ((StringBuilder)localObject1).toString();
    p.g(localObject1, "sb.toString()");
    AppMethodBeat.o(247240);
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.util.h
 * JD-Core Version:    0.7.0.1
 */