package com.tencent.mm.plugin.finder.live.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/util/TrtcStatistics;", "", "()V", "audioBitrateStatisticsCache", "Lcom/tencent/mm/plugin/finder/live/util/StatisticsCache;", "getAudioBitrateStatisticsCache", "()Lcom/tencent/mm/plugin/finder/live/util/StatisticsCache;", "cacheList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getCacheList", "()Ljava/util/ArrayList;", "cpuStatisticsCache", "getCpuStatisticsCache", "downlossStatisticsCache", "getDownlossStatisticsCache", "frameRateStatisticsCache", "getFrameRateStatisticsCache", "heightStatisticsCache", "getHeightStatisticsCache", "receiveBytesStatisticsCache", "getReceiveBytesStatisticsCache", "rttStatisticsCache", "getRttStatisticsCache", "sendBytesStatisticsCache", "getSendBytesStatisticsCache", "uplossStatisticsCache", "getUplossStatisticsCache", "videoBitrateStatisticsCache", "getVideoBitrateStatisticsCache", "widthStatisticsCache", "getWidthStatisticsCache", "getAverageStr", "", "getLevelStr", "getRealTimeStr", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ac
{
  private final ArrayList<aa> DIr;
  final aa DIs;
  final aa DIt;
  final aa DIu;
  final aa DIv;
  final aa DIw;
  final aa DIx;
  final aa DJI;
  final aa DJJ;
  final aa DJK;
  final aa DJL;
  final aa DJM;
  
  public ac()
  {
    AppMethodBeat.i(351266);
    this.DIr = new ArrayList();
    this.DIs = new c().euo();
    this.DIt = new ae().euo();
    this.DIu = new d().euo();
    Object localObject = new y();
    ((y)localObject).DIj.add(new i("GoodRtt", 50, 4));
    ((y)localObject).DIj.add(new i("NormalRtt", 100, 4));
    ((y)localObject).DIj.add(new i("BadRtt", 2147483647, 4));
    this.DJI = new aa(((y)localObject).DJD, ((y)localObject).DJE, ((y)localObject).DIj);
    localObject = new ad();
    ((ad)localObject).DIj.add(new i("GoodUploss", 5, 4));
    ((ad)localObject).DIj.add(new i("NormalUploss", 10, 4));
    ((ad)localObject).DIj.add(new i("BadUploss", 2147483647, 4));
    this.DJJ = new aa(((ad)localObject).DJN, ((ad)localObject).DJO, ((ad)localObject).DIj);
    localObject = new k();
    ((k)localObject).DIj.add(new i("GoodDownloss", 5, 4));
    ((k)localObject).DIj.add(new i("NormalDownloss", 10, 4));
    ((k)localObject).DIj.add(new i("BadDownloss", 2147483647, 4));
    this.DJK = new aa(((k)localObject).DIY, ((k)localObject).DIZ, ((k)localObject).DIj);
    localObject = new z();
    ((z)localObject).DIj.add(new i("BadSendBytes", 500, 4));
    ((z)localObject).DIj.add(new i("NormalSendBytes", 1800, 4));
    ((z)localObject).DIj.add(new i("GoodSendBytes", 2147483647, 4));
    this.DJL = new aa(((z)localObject).DIh, ((z)localObject).DIi, ((z)localObject).DIj);
    localObject = new x();
    ((x)localObject).DIj.add(new i("BadReceiveBytes", 500, 4));
    ((x)localObject).DIj.add(new i("NormalReceiveBytes", 1800, 4));
    ((x)localObject).DIj.add(new i("GoodReceiveBytes", 2147483647, 4));
    this.DJM = new aa(((x)localObject).DIh, ((x)localObject).DIi, ((x)localObject).DIj);
    this.DIv = new o().euo();
    this.DIw = new ah().euo();
    this.DIx = new r().euo();
    this.DIr.add(this.DIs);
    this.DIr.add(this.DIt);
    this.DIr.add(this.DIu);
    this.DIr.add(this.DJI);
    this.DIr.add(this.DJJ);
    this.DIr.add(this.DJK);
    this.DIr.add(this.DJL);
    this.DIr.add(this.DJM);
    this.DIr.add(this.DIv);
    AppMethodBeat.o(351266);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.util.ac
 * JD-Core Version:    0.7.0.1
 */