package com.tencent.mm.plugin.finder.live.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/util/TrtcStatistics;", "", "()V", "audioBitrateStatisticsCache", "Lcom/tencent/mm/plugin/finder/live/util/StatisticsCache;", "getAudioBitrateStatisticsCache", "()Lcom/tencent/mm/plugin/finder/live/util/StatisticsCache;", "cacheList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getCacheList", "()Ljava/util/ArrayList;", "cpuStatisticsCache", "getCpuStatisticsCache", "downlossStatisticsCache", "getDownlossStatisticsCache", "frameRateStatisticsCache", "getFrameRateStatisticsCache", "heightStatisticsCache", "getHeightStatisticsCache", "receiveBytesStatisticsCache", "getReceiveBytesStatisticsCache", "rttStatisticsCache", "getRttStatisticsCache", "sendBytesStatisticsCache", "getSendBytesStatisticsCache", "uplossStatisticsCache", "getUplossStatisticsCache", "videoBitrateStatisticsCache", "getVideoBitrateStatisticsCache", "widthStatisticsCache", "getWidthStatisticsCache", "getAverageStr", "", "getLevelStr", "getRealTimeStr", "plugin-finder-base_release"})
public final class z
{
  private final ArrayList<x> yPM;
  final x yPN;
  final x yPO;
  final x yPP;
  final x yPQ;
  final x yPR;
  final x yPS;
  final x yQY;
  final x yQZ;
  final x yRa;
  final x yRb;
  final x yRc;
  
  public z()
  {
    AppMethodBeat.i(260177);
    this.yPM = new ArrayList();
    this.yPN = new c().dEo();
    this.yPO = new ab().dEo();
    this.yPP = new d().dEo();
    Object localObject = new v();
    ((v)localObject).yPC.add(new i("GoodRtt", 50, 4));
    ((v)localObject).yPC.add(new i("NormalRtt", 100, 4));
    ((v)localObject).yPC.add(new i("BadRtt", 2147483647, 4));
    this.yQY = new x(((v)localObject).yQT, ((v)localObject).yQU, ((v)localObject).yPC);
    localObject = new aa();
    ((aa)localObject).yPC.add(new i("GoodUploss", 5, 4));
    ((aa)localObject).yPC.add(new i("NormalUploss", 10, 4));
    ((aa)localObject).yPC.add(new i("BadUploss", 2147483647, 4));
    this.yQZ = new x(((aa)localObject).yRd, ((aa)localObject).yRe, ((aa)localObject).yPC);
    localObject = new l();
    ((l)localObject).yPC.add(new i("GoodDownloss", 5, 4));
    ((l)localObject).yPC.add(new i("NormalDownloss", 10, 4));
    ((l)localObject).yPC.add(new i("BadDownloss", 2147483647, 4));
    this.yRa = new x(((l)localObject).yQt, ((l)localObject).yQu, ((l)localObject).yPC);
    localObject = new w();
    ((w)localObject).yPC.add(new i("BadSendBytes", 500, 4));
    ((w)localObject).yPC.add(new i("NormalSendBytes", 1800, 4));
    ((w)localObject).yPC.add(new i("GoodSendBytes", 2147483647, 4));
    this.yRb = new x(((w)localObject).yPA, ((w)localObject).yPB, ((w)localObject).yPC);
    localObject = new u();
    ((u)localObject).yPC.add(new i("BadReceiveBytes", 500, 4));
    ((u)localObject).yPC.add(new i("NormalReceiveBytes", 1800, 4));
    ((u)localObject).yPC.add(new i("GoodReceiveBytes", 2147483647, 4));
    this.yRc = new x(((u)localObject).yPA, ((u)localObject).yPB, ((u)localObject).yPC);
    this.yPQ = new m().dEo();
    this.yPR = new ad().dEo();
    this.yPS = new o().dEo();
    this.yPM.add(this.yPN);
    this.yPM.add(this.yPO);
    this.yPM.add(this.yPP);
    this.yPM.add(this.yQY);
    this.yPM.add(this.yQZ);
    this.yPM.add(this.yRa);
    this.yPM.add(this.yRb);
    this.yPM.add(this.yRc);
    this.yPM.add(this.yPQ);
    AppMethodBeat.o(260177);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.util.z
 * JD-Core Version:    0.7.0.1
 */