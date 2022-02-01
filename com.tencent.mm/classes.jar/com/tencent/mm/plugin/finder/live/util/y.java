package com.tencent.mm.plugin.finder.live.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.g.b.p;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/util/TrtcStatistics;", "", "()V", "audioBitrateStatisticsCache", "Lcom/tencent/mm/plugin/finder/live/util/StatisticsCache;", "getAudioBitrateStatisticsCache", "()Lcom/tencent/mm/plugin/finder/live/util/StatisticsCache;", "cacheList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getCacheList", "()Ljava/util/ArrayList;", "cpuStatisticsCache", "getCpuStatisticsCache", "downlossStatisticsCache", "getDownlossStatisticsCache", "frameRateStatisticsCache", "getFrameRateStatisticsCache", "heightStatisticsCache", "getHeightStatisticsCache", "receiveBytesStatisticsCache", "getReceiveBytesStatisticsCache", "rttStatisticsCache", "getRttStatisticsCache", "sendBytesStatisticsCache", "getSendBytesStatisticsCache", "uplossStatisticsCache", "getUplossStatisticsCache", "videoBitrateStatisticsCache", "getVideoBitrateStatisticsCache", "widthStatisticsCache", "getWidthStatisticsCache", "getAverageStr", "", "getLevelStr", "getRealTimeStr", "plugin-finder_release"})
public final class y
{
  private final ArrayList<w> uwf;
  public final w uwg;
  public final w uwh;
  public final w uwi;
  public final w uwj;
  public final w uwk;
  public final w uwl;
  public final w uxp;
  public final w uxq;
  public final w uxr;
  public final w uxs;
  public final w uxt;
  
  public y()
  {
    AppMethodBeat.i(247304);
    this.uwf = new ArrayList();
    this.uwg = new c().did();
    this.uwh = new aa().did();
    this.uwi = new d().did();
    Object localObject = new u();
    ((u)localObject).uvW.add(new i("GoodRtt", 50, 4));
    ((u)localObject).uvW.add(new i("NormalRtt", 100, 4));
    ((u)localObject).uvW.add(new i("BadRtt", 2147483647, 4));
    this.uxp = new w(((u)localObject).uxk, ((u)localObject).uxl, ((u)localObject).uvW);
    localObject = new z();
    ((z)localObject).uvW.add(new i("GoodUploss", 5, 4));
    ((z)localObject).uvW.add(new i("NormalUploss", 10, 4));
    ((z)localObject).uvW.add(new i("BadUploss", 2147483647, 4));
    this.uxq = new w(((z)localObject).uxu, ((z)localObject).uxv, ((z)localObject).uvW);
    localObject = new l();
    ((l)localObject).uvW.add(new i("GoodDownloss", 5, 4));
    ((l)localObject).uvW.add(new i("NormalDownloss", 10, 4));
    ((l)localObject).uvW.add(new i("BadDownloss", 2147483647, 4));
    this.uxr = new w(((l)localObject).uwM, ((l)localObject).uwN, ((l)localObject).uvW);
    localObject = new v();
    ((v)localObject).uvW.add(new i("BadSendBytes", 500, 4));
    ((v)localObject).uvW.add(new i("NormalSendBytes", 1800, 4));
    ((v)localObject).uvW.add(new i("GoodSendBytes", 2147483647, 4));
    this.uxs = new w(((v)localObject).uvU, ((v)localObject).uvV, ((v)localObject).uvW);
    localObject = new t();
    ((t)localObject).uvW.add(new i("BadReceiveBytes", 500, 4));
    ((t)localObject).uvW.add(new i("NormalReceiveBytes", 1800, 4));
    ((t)localObject).uvW.add(new i("GoodReceiveBytes", 2147483647, 4));
    this.uxt = new w(((t)localObject).uvU, ((t)localObject).uvV, ((t)localObject).uvW);
    this.uwj = new m().did();
    this.uwk = new ac().did();
    this.uwl = new o().did();
    this.uwf.add(this.uwg);
    this.uwf.add(this.uwh);
    this.uwf.add(this.uwi);
    this.uwf.add(this.uxp);
    this.uwf.add(this.uxq);
    this.uwf.add(this.uxr);
    this.uwf.add(this.uxs);
    this.uwf.add(this.uxt);
    this.uwf.add(this.uwj);
    AppMethodBeat.o(247304);
  }
  
  public final String dif()
  {
    AppMethodBeat.i(247303);
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
    AppMethodBeat.o(247303);
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.util.y
 * JD-Core Version:    0.7.0.1
 */