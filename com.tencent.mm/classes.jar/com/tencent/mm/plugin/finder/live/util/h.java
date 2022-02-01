package com.tencent.mm.plugin.finder.live.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/util/CDNStatistics;", "", "()V", "GOPStatisticsCache", "Lcom/tencent/mm/plugin/finder/live/util/StatisticsCache;", "getGOPStatisticsCache", "()Lcom/tencent/mm/plugin/finder/live/util/StatisticsCache;", "audioBitrateStatisticsCache", "getAudioBitrateStatisticsCache", "avPlayIntervalStatisticsCache", "getAvPlayIntervalStatisticsCache", "avRecIntervalStatisticsCache", "getAvRecIntervalStatisticsCache", "cacheList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getCacheList", "()Ljava/util/ArrayList;", "cpuStatisticsCache", "getCpuStatisticsCache", "frameRateStatisticsCache", "getFrameRateStatisticsCache", "heightStatisticsCache", "getHeightStatisticsCache", "netJitStatisticsCache", "getNetJitStatisticsCache", "netSpeedStatisticsCache", "getNetSpeedStatisticsCache", "sumCacheStatisticsCache", "getSumCacheStatisticsCache", "videoBitrateStatisticsCache", "getVideoBitrateStatisticsCache", "videoCacheStatisticsCache", "getVideoCacheStatisticsCache", "widthStatisticsCache", "getWidthStatisticsCache", "getLevelStr", "", "getRealTimeStr", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h
{
  final aa DIA;
  final aa DIB;
  final aa DIC;
  final aa DID;
  final aa DIE;
  private final ArrayList<aa> DIr;
  final aa DIs;
  final aa DIt;
  final aa DIu;
  final aa DIv;
  final aa DIw;
  final aa DIx;
  final aa DIy;
  final aa DIz;
  
  public h()
  {
    AppMethodBeat.i(351294);
    this.DIr = new ArrayList();
    this.DIs = new c().euo();
    this.DIt = new ae().euo();
    this.DIu = new d().euo();
    this.DIv = new o().euo();
    this.DIw = new ah().euo();
    this.DIx = new r().euo();
    this.DIy = new aa(new p().DIh, null, null);
    Object localObject = new w();
    ((w)localObject).DIj.add(new i("BadNetSpeed", 300, 4));
    ((w)localObject).DIj.add(new i("NormalNetSpeed", 1800, 4));
    ((w)localObject).DIj.add(new i("GoodNetSpeed", 2147483647, 4));
    this.DIz = new aa(((w)localObject).DIh, ((w)localObject).DIi, ((w)localObject).DIj);
    localObject = new v();
    ((v)localObject).DIj.add(new i("GoodNetJit", 3, 4));
    ((v)localObject).DIj.add(new i("NormalNetJit", 10, 4));
    ((v)localObject).DIj.add(new i("BadNetJit", 2147483647, 4));
    this.DIA = new aa(((v)localObject).DIh, ((v)localObject).DIi, ((v)localObject).DIj);
    localObject = new b();
    ((b)localObject).DIj.add(new i("GoodAVRecInterval", 10, 4));
    ((b)localObject).DIj.add(new i("NormalAVRecInterval", 50, 4));
    ((b)localObject).DIj.add(new i("BadAVRecInterval", 2147483647, 4));
    this.DIB = new aa(((b)localObject).DIh, ((b)localObject).DIi, ((b)localObject).DIj);
    localObject = new a();
    ((a)localObject).DIj.add(new i("GoodAVPlayInterval", 10, 4));
    ((a)localObject).DIj.add(new i("NormalAVPlayInterval", 50, 4));
    ((a)localObject).DIj.add(new i("BadAVPlayInterval", 2147483647, 4));
    this.DIC = new aa(((a)localObject).DIh, ((a)localObject).DIi, ((a)localObject).DIj);
    localObject = new af();
    ((af)localObject).DIj.add(new i("BadVideoCache", 100, 4));
    ((af)localObject).DIj.add(new i("NormalVideoCache", 1500, 4));
    ((af)localObject).DIj.add(new i("GoodVideoCache", 2147483647, 4));
    this.DID = new aa(((af)localObject).DIh, ((af)localObject).DIi, ((af)localObject).DIj);
    localObject = new ab();
    ((ab)localObject).DIj.add(new i("BadSumCacheSize", 100, 4));
    ((ab)localObject).DIj.add(new i("NormalSumCacheSize", 1500, 4));
    ((ab)localObject).DIj.add(new i("GoodSumCacheSize", 2147483647, 4));
    this.DIE = new aa(((ab)localObject).DIh, ((ab)localObject).DIi, ((ab)localObject).DIj);
    this.DIr.add(this.DIs);
    this.DIr.add(this.DIt);
    this.DIr.add(this.DIu);
    this.DIr.add(this.DIv);
    this.DIr.add(this.DIz);
    this.DIr.add(this.DIA);
    this.DIr.add(this.DIB);
    this.DIr.add(this.DIC);
    this.DIr.add(this.DID);
    this.DIr.add(this.DIE);
    AppMethodBeat.o(351294);
  }
  
  public final String euq()
  {
    Object localObject2 = null;
    AppMethodBeat.i(351321);
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append(this.DIw.DJF.key + ':' + this.DIw.DJF.value + '\n');
    localStringBuilder1.append(this.DIx.DJF.key + ':' + this.DIx.DJF.value + '\n');
    localStringBuilder1.append(this.DIy.DJF.key + ':' + this.DIy.DJF.value + '\n');
    StringBuilder localStringBuilder2 = new StringBuilder().append(this.DIs.DJF.key).append(':').append(this.DIs.DJF.value).append('(');
    Object localObject1 = this.DIs.DJG;
    if (localObject1 == null)
    {
      localObject1 = null;
      localStringBuilder1.append(localObject1 + ")\n");
      localStringBuilder2 = new StringBuilder().append(this.DIv.DJF.key).append(':').append(this.DIv.DJF.value).append('(');
      localObject1 = this.DIv.DJG;
      if (localObject1 != null) {
        break label988;
      }
      localObject1 = null;
      label306:
      localStringBuilder1.append(localObject1 + ")\n");
      localStringBuilder2 = new StringBuilder().append(this.DIt.DJF.key).append(':').append(this.DIt.DJF.value).append('(');
      localObject1 = this.DIt.DJG;
      if (localObject1 != null) {
        break label999;
      }
      localObject1 = null;
      label385:
      localStringBuilder1.append(localObject1 + ")\n");
      localStringBuilder2 = new StringBuilder().append(this.DIu.DJF.key).append(':').append(this.DIu.DJF.value).append('(');
      localObject1 = this.DIu.DJG;
      if (localObject1 != null) {
        break label1010;
      }
      localObject1 = null;
      label464:
      localStringBuilder1.append(localObject1 + ")\n");
      localStringBuilder2 = new StringBuilder().append(this.DIz.DJF.key).append(':').append(this.DIz.DJF.value).append('(');
      localObject1 = this.DIz.DJG;
      if (localObject1 != null) {
        break label1021;
      }
      localObject1 = null;
      label543:
      localStringBuilder1.append(localObject1 + ")\n");
      localStringBuilder2 = new StringBuilder().append(this.DIA.DJF.key).append(':').append(this.DIA.DJF.value).append('(');
      localObject1 = this.DIA.DJG;
      if (localObject1 != null) {
        break label1032;
      }
      localObject1 = null;
      label622:
      localStringBuilder1.append(localObject1 + ")\n");
      localStringBuilder2 = new StringBuilder().append(this.DIB.DJF.key).append(':').append(this.DIB.DJF.value).append('(');
      localObject1 = this.DIB.DJG;
      if (localObject1 != null) {
        break label1043;
      }
      localObject1 = null;
      label701:
      localStringBuilder1.append(localObject1 + ")\n");
      localStringBuilder2 = new StringBuilder().append(this.DIC.DJF.key).append(':').append(this.DIC.DJF.value).append('(');
      localObject1 = this.DIC.DJG;
      if (localObject1 != null) {
        break label1054;
      }
      localObject1 = null;
      label780:
      localStringBuilder1.append(localObject1 + ")\n");
      localStringBuilder2 = new StringBuilder().append(this.DID.DJF.key).append(':').append(this.DID.DJF.value).append('(');
      localObject1 = this.DID.DJG;
      if (localObject1 != null) {
        break label1065;
      }
      localObject1 = null;
      label859:
      localStringBuilder1.append(localObject1 + ")\n");
      localStringBuilder2 = new StringBuilder().append(this.DIE.DJF.key).append(':').append(this.DIE.DJF.value).append('(');
      localObject1 = this.DIE.DJG;
      if (localObject1 != null) {
        break label1076;
      }
    }
    label1032:
    label1043:
    label1054:
    label1065:
    label1076:
    for (localObject1 = localObject2;; localObject1 = Long.valueOf(((e)localObject1).DIn))
    {
      localStringBuilder1.append(localObject1 + ")\n");
      localObject1 = localStringBuilder1.toString();
      s.s(localObject1, "sb.toString()");
      AppMethodBeat.o(351321);
      return localObject1;
      localObject1 = Long.valueOf(((e)localObject1).DIn);
      break;
      label988:
      localObject1 = Long.valueOf(((e)localObject1).DIn);
      break label306;
      label999:
      localObject1 = Long.valueOf(((e)localObject1).DIn);
      break label385;
      label1010:
      localObject1 = Long.valueOf(((e)localObject1).DIn);
      break label464;
      label1021:
      localObject1 = Long.valueOf(((e)localObject1).DIn);
      break label543;
      localObject1 = Long.valueOf(((e)localObject1).DIn);
      break label622;
      localObject1 = Long.valueOf(((e)localObject1).DIn);
      break label701;
      localObject1 = Long.valueOf(((e)localObject1).DIn);
      break label780;
      localObject1 = Long.valueOf(((e)localObject1).DIn);
      break label859;
    }
  }
  
  public final String eur()
  {
    AppMethodBeat.i(351332);
    Object localObject1 = new StringBuilder();
    Iterator localIterator = ((Iterable)this.DIr).iterator();
    while (localIterator.hasNext())
    {
      Object localObject2 = ((aa)localIterator.next()).DJH;
      if (localObject2 != null)
      {
        localObject2 = ((Iterable)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          i locali = (i)((Iterator)localObject2).next();
          ((StringBuilder)localObject1).append("{" + locali.key + '(' + locali.value + "):" + locali.oZt + "};");
        }
      }
      ((StringBuilder)localObject1).append("\n");
    }
    localObject1 = ((StringBuilder)localObject1).toString();
    s.s(localObject1, "sb.toString()");
    AppMethodBeat.o(351332);
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.util.h
 * JD-Core Version:    0.7.0.1
 */