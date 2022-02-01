package com.tencent.mm.plugin.finder.live.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/util/CDNStatistics;", "", "()V", "audioBitrateStatisticsCache", "Lcom/tencent/mm/plugin/finder/live/util/StatisticsCache;", "getAudioBitrateStatisticsCache", "()Lcom/tencent/mm/plugin/finder/live/util/StatisticsCache;", "avPlayIntervalStatisticsCache", "getAvPlayIntervalStatisticsCache", "avRecIntervalStatisticsCache", "getAvRecIntervalStatisticsCache", "cacheList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getCacheList", "()Ljava/util/ArrayList;", "cpuStatisticsCache", "getCpuStatisticsCache", "frameRateStatisticsCache", "getFrameRateStatisticsCache", "heightStatisticsCache", "getHeightStatisticsCache", "netJitStatisticsCache", "getNetJitStatisticsCache", "netSpeedStatisticsCache", "getNetSpeedStatisticsCache", "sumCacheStatisticsCache", "getSumCacheStatisticsCache", "videoBitrateStatisticsCache", "getVideoBitrateStatisticsCache", "videoCacheStatisticsCache", "getVideoCacheStatisticsCache", "widthStatisticsCache", "getWidthStatisticsCache", "getLevelStr", "", "getRealTimeStr", "plugin-finder-base_release"})
public final class h
{
  private final ArrayList<x> yPM;
  final x yPN;
  final x yPO;
  final x yPP;
  final x yPQ;
  final x yPR;
  final x yPS;
  final x yPT;
  final x yPU;
  final x yPV;
  final x yPW;
  final x yPX;
  final x yPY;
  
  public h()
  {
    AppMethodBeat.i(262083);
    this.yPM = new ArrayList();
    this.yPN = new c().dEo();
    this.yPO = new ab().dEo();
    this.yPP = new d().dEo();
    this.yPQ = new m().dEo();
    this.yPR = new ad().dEo();
    this.yPS = new o().dEo();
    Object localObject = new t();
    ((t)localObject).yPC.add(new i("BadNetSpeed", 300, 4));
    ((t)localObject).yPC.add(new i("NormalNetSpeed", 1800, 4));
    ((t)localObject).yPC.add(new i("GoodNetSpeed", 2147483647, 4));
    this.yPT = new x(((t)localObject).yPA, ((t)localObject).yPB, ((t)localObject).yPC);
    localObject = new s();
    ((s)localObject).yPC.add(new i("GoodNetJit", 3, 4));
    ((s)localObject).yPC.add(new i("NormalNetJit", 10, 4));
    ((s)localObject).yPC.add(new i("BadNetJit", 2147483647, 4));
    this.yPU = new x(((s)localObject).yPA, ((s)localObject).yPB, ((s)localObject).yPC);
    localObject = new b();
    ((b)localObject).yPC.add(new i("GoodAVRecInterval", 10, 4));
    ((b)localObject).yPC.add(new i("NormalAVRecInterval", 50, 4));
    ((b)localObject).yPC.add(new i("BadAVRecInterval", 2147483647, 4));
    this.yPV = new x(((b)localObject).yPA, ((b)localObject).yPB, ((b)localObject).yPC);
    localObject = new a();
    ((a)localObject).yPC.add(new i("GoodAVPlayInterval", 10, 4));
    ((a)localObject).yPC.add(new i("NormalAVPlayInterval", 50, 4));
    ((a)localObject).yPC.add(new i("BadAVPlayInterval", 2147483647, 4));
    this.yPW = new x(((a)localObject).yPA, ((a)localObject).yPB, ((a)localObject).yPC);
    localObject = new ac();
    ((ac)localObject).yPC.add(new i("BadVideoCache", 100, 4));
    ((ac)localObject).yPC.add(new i("NormalVideoCache", 1500, 4));
    ((ac)localObject).yPC.add(new i("GoodVideoCache", 2147483647, 4));
    this.yPX = new x(((ac)localObject).yPA, ((ac)localObject).yPB, ((ac)localObject).yPC);
    localObject = new y();
    ((y)localObject).yPC.add(new i("BadSumCacheSize", 100, 4));
    ((y)localObject).yPC.add(new i("NormalSumCacheSize", 1500, 4));
    ((y)localObject).yPC.add(new i("GoodSumCacheSize", 2147483647, 4));
    this.yPY = new x(((y)localObject).yPA, ((y)localObject).yPB, ((y)localObject).yPC);
    this.yPM.add(this.yPN);
    this.yPM.add(this.yPO);
    this.yPM.add(this.yPP);
    this.yPM.add(this.yPQ);
    this.yPM.add(this.yPT);
    this.yPM.add(this.yPU);
    this.yPM.add(this.yPV);
    this.yPM.add(this.yPW);
    this.yPM.add(this.yPX);
    this.yPM.add(this.yPY);
    AppMethodBeat.o(262083);
  }
  
  public final String dEq()
  {
    Object localObject2 = null;
    AppMethodBeat.i(262081);
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append(this.yPR.yQV.key + ':' + this.yPR.yQV.value + '\n');
    localStringBuilder1.append(this.yPS.yQV.key + ':' + this.yPS.yQV.value + '\n');
    StringBuilder localStringBuilder2 = new StringBuilder().append(this.yPN.yQV.key).append(':').append(this.yPN.yQV.value).append('(');
    Object localObject1 = this.yPN.yQW;
    if (localObject1 != null)
    {
      localObject1 = Long.valueOf(((e)localObject1).yPG);
      localStringBuilder1.append(localObject1 + ")\n");
      localStringBuilder2 = new StringBuilder().append(this.yPQ.yQV.key).append(':').append(this.yPQ.yQV.value).append('(');
      localObject1 = this.yPQ.yQW;
      if (localObject1 == null) {
        break label996;
      }
      localObject1 = Long.valueOf(((e)localObject1).yPG);
      label267:
      localStringBuilder1.append(localObject1 + ")\n");
      localStringBuilder2 = new StringBuilder().append(this.yPO.yQV.key).append(':').append(this.yPO.yQV.value).append('(');
      localObject1 = this.yPO.yQW;
      if (localObject1 == null) {
        break label1001;
      }
      localObject1 = Long.valueOf(((e)localObject1).yPG);
      label352:
      localStringBuilder1.append(localObject1 + ")\n");
      localStringBuilder2 = new StringBuilder().append(this.yPP.yQV.key).append(':').append(this.yPP.yQV.value).append('(');
      localObject1 = this.yPP.yQW;
      if (localObject1 == null) {
        break label1006;
      }
      localObject1 = Long.valueOf(((e)localObject1).yPG);
      label437:
      localStringBuilder1.append(localObject1 + ")\n");
      localStringBuilder2 = new StringBuilder().append(this.yPT.yQV.key).append(':').append(this.yPT.yQV.value).append('(');
      localObject1 = this.yPT.yQW;
      if (localObject1 == null) {
        break label1011;
      }
      localObject1 = Long.valueOf(((e)localObject1).yPG);
      label522:
      localStringBuilder1.append(localObject1 + ")\n");
      localStringBuilder2 = new StringBuilder().append(this.yPU.yQV.key).append(':').append(this.yPU.yQV.value).append('(');
      localObject1 = this.yPU.yQW;
      if (localObject1 == null) {
        break label1016;
      }
      localObject1 = Long.valueOf(((e)localObject1).yPG);
      label607:
      localStringBuilder1.append(localObject1 + ")\n");
      localStringBuilder2 = new StringBuilder().append(this.yPV.yQV.key).append(':').append(this.yPV.yQV.value).append('(');
      localObject1 = this.yPV.yQW;
      if (localObject1 == null) {
        break label1021;
      }
      localObject1 = Long.valueOf(((e)localObject1).yPG);
      label692:
      localStringBuilder1.append(localObject1 + ")\n");
      localStringBuilder2 = new StringBuilder().append(this.yPW.yQV.key).append(':').append(this.yPW.yQV.value).append('(');
      localObject1 = this.yPW.yQW;
      if (localObject1 == null) {
        break label1026;
      }
      localObject1 = Long.valueOf(((e)localObject1).yPG);
      label777:
      localStringBuilder1.append(localObject1 + ")\n");
      localStringBuilder2 = new StringBuilder().append(this.yPX.yQV.key).append(':').append(this.yPX.yQV.value).append('(');
      localObject1 = this.yPX.yQW;
      if (localObject1 == null) {
        break label1031;
      }
    }
    label1026:
    label1031:
    for (localObject1 = Long.valueOf(((e)localObject1).yPG);; localObject1 = null)
    {
      localStringBuilder1.append(localObject1 + ")\n");
      localStringBuilder2 = new StringBuilder().append(this.yPY.yQV.key).append(':').append(this.yPY.yQV.value).append('(');
      e locale = this.yPY.yQW;
      localObject1 = localObject2;
      if (locale != null) {
        localObject1 = Long.valueOf(locale.yPG);
      }
      localStringBuilder1.append(localObject1 + ")\n");
      localObject1 = localStringBuilder1.toString();
      p.j(localObject1, "sb.toString()");
      AppMethodBeat.o(262081);
      return localObject1;
      localObject1 = null;
      break;
      label996:
      localObject1 = null;
      break label267;
      label1001:
      localObject1 = null;
      break label352;
      label1006:
      localObject1 = null;
      break label437;
      label1011:
      localObject1 = null;
      break label522;
      label1016:
      localObject1 = null;
      break label607;
      label1021:
      localObject1 = null;
      break label692;
      localObject1 = null;
      break label777;
    }
  }
  
  public final String dEr()
  {
    AppMethodBeat.i(262082);
    Object localObject1 = new StringBuilder();
    Iterator localIterator = ((Iterable)this.yPM).iterator();
    while (localIterator.hasNext())
    {
      Object localObject2 = ((x)localIterator.next()).yQX;
      if (localObject2 != null)
      {
        localObject2 = ((Iterable)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          i locali = (i)((Iterator)localObject2).next();
          ((StringBuilder)localObject1).append("{" + locali.key + '(' + locali.value + "):" + locali.mgw + "};");
        }
      }
      ((StringBuilder)localObject1).append("\n");
    }
    localObject1 = ((StringBuilder)localObject1).toString();
    p.j(localObject1, "sb.toString()");
    AppMethodBeat.o(262082);
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.util.h
 * JD-Core Version:    0.7.0.1
 */