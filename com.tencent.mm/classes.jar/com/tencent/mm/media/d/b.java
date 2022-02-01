package com.tencent.mm.media.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.o;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/media/decoder/DecodeHelper;", "", "path", "", "outputFPS", "", "startTime", "", "enableHevc", "", "(Ljava/lang/String;IJZ)V", "copyPts", "Landroidx/collection/ArrayMap;", "", "getEnableHevc", "()Z", "setEnableHevc", "(Z)V", "frameInterval", "getFrameInterval", "()J", "setFrameInterval", "(J)V", "frames", "", "inFPS", "lastPts", "maxFps", "", "minFps", "outFPS", "parents", "queue", "Ljava/util/PriorityQueue;", "Lkotlin/Pair;", "recentPts", "getStartTime", "vfrThreshold", "hasFrame", "initStrategy", "", "receiveFrame", "release", "sendPacket", "pts", "bufferIndex", "useStrategy", "strategy", "Lcom/tencent/mm/media/decoder/DecodeStrategy;", "Companion", "plugin-mediaeditor_release"})
public final class b
{
  public static final a kSK;
  final androidx.b.a<Long, List<Long>> kSA;
  final PriorityQueue<o<Long, Integer>> kSB;
  private final List<Long> kSC;
  private int kSD;
  private int kSE;
  private double kSF;
  private double kSG;
  private final int kSH;
  private long kSI;
  private boolean kSJ;
  long kSx;
  long kSy;
  final androidx.b.a<Long, Long> kSz;
  private final long startTime;
  
  static
  {
    AppMethodBeat.i(93527);
    kSK = new a((byte)0);
    AppMethodBeat.o(93527);
  }
  
  public b(String paramString, int paramInt, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(258686);
    this.startTime = paramLong;
    this.kSJ = paramBoolean;
    this.kSx = -1L;
    this.kSy = -1L;
    this.kSz = new androidx.b.a();
    this.kSA = new androidx.b.a();
    this.kSH = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vFy, 10);
    this.kSI = 333L;
    double[] arrayOfDouble = new double[3];
    double[] tmp92_90 = arrayOfDouble;
    tmp92_90[0] = 0.0D;
    double[] tmp96_92 = tmp92_90;
    tmp96_92[1] = 0.0D;
    double[] tmp100_96 = tmp96_92;
    tmp100_96[2] = 0.0D;
    tmp100_96;
    this.kSC = j.n((Iterable)com.tencent.mm.media.k.b.a(paramString, tmp92_90));
    this.kSD = ((int)tmp92_90[2]);
    label192:
    int i;
    if (paramInt > 0)
    {
      this.kSE = paramInt;
      com.tencent.mm.plugin.report.service.h.IzE.F(986L, 114L);
      com.tencent.mm.plugin.report.service.h.IzE.p(986L, 115L, tmp92_90[2]);
      com.tencent.mm.plugin.report.service.h.IzE.p(986L, 116L, (tmp92_90[1] - tmp92_90[0]));
      paramInt = 0;
      if (paramInt >= 3) {
        break label518;
      }
      if (tmp92_90[paramInt] <= 0.0D) {
        break label505;
      }
      i = 1;
      label209:
      if (i != 0) {
        break label511;
      }
      paramInt = 0;
      label216:
      if (paramInt != 0)
      {
        if (((Collection)this.kSC).isEmpty()) {
          break label523;
        }
        paramInt = 1;
        label237:
        if (paramInt != 0) {
          this.kSy = ((Number)j.lq(this.kSC)).longValue();
        }
      }
      this.kSF = tmp92_90[0];
      this.kSG = tmp92_90[1];
      this.kSB = new PriorityQueue(Math.max(this.kSC.size(), 11), (Comparator)1.kSL);
      paramBoolean = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vFx, false);
      if ((!WeChatEnvironment.hasDebugger()) && (!paramBoolean)) {
        break label650;
      }
      if (this.kSD > this.kSE) {
        break label528;
      }
      Log.i("DecodeHelper", "use PassthroughDecodeStrategy");
      a((c)new l());
    }
    for (;;)
    {
      Log.i("DecodeHelper", "init decode helper, inFPS = " + this.kSD + ", outFPS = " + this.kSE + ", minFps:" + this.kSF + ", maxFps:" + this.kSG + ", vfrThreshold:" + this.kSH + ", valid frames = " + this.kSz.size() + ", lastPts:" + this.kSy + ", frames.size:" + this.kSC.size());
      AppMethodBeat.o(258686);
      return;
      paramInt = this.kSD;
      break;
      label505:
      i = 0;
      break label209;
      label511:
      paramInt += 1;
      break label192;
      label518:
      paramInt = 1;
      break label216;
      label523:
      paramInt = 0;
      break label237;
      label528:
      paramInt = com.tencent.mm.plugin.sight.base.c.fIt();
      if ((this.kSC.size() > paramInt) && (!com.tencent.mm.plugin.sight.base.c.fIu()) && (!com.tencent.mm.plugin.sight.base.c.av(false, this.kSJ)))
      {
        Log.i("DecodeHelper", "use CfrDecodeStrategy");
        a((c)new a());
      }
      else if (this.kSC.size() <= paramInt)
      {
        Log.i("DecodeHelper", "use VfrDecodeStrategy");
        a((c)new n());
      }
      else
      {
        Log.i("DecodeHelper", "use SimpleVfrDecodeStrategy");
        a((c)new m());
        continue;
        label650:
        Log.i("DecodeHelper", "use PassthroughDecodeStrategy");
        a((c)new l());
      }
    }
  }
  
  private void a(c paramc)
  {
    AppMethodBeat.i(93525);
    p.k(paramc, "strategy");
    long l = System.currentTimeMillis();
    paramc.a(this.startTime, this.kSC, this.kSD, this.kSE, (Map)this.kSz, (Map)this.kSA);
    l = System.currentTimeMillis() - l;
    if ((paramc instanceof l))
    {
      com.tencent.mm.plugin.report.service.h.IzE.F(986L, 105L);
      com.tencent.mm.plugin.report.service.h.IzE.p(986L, 108L, l);
    }
    for (;;)
    {
      this.kSx = -1L;
      AppMethodBeat.o(93525);
      return;
      if ((paramc instanceof a))
      {
        com.tencent.mm.plugin.report.service.h.IzE.F(986L, 107L);
        com.tencent.mm.plugin.report.service.h.IzE.p(986L, 112L, l);
        this.kSI = ((a)paramc).kSw;
      }
      else if ((paramc instanceof n))
      {
        com.tencent.mm.plugin.report.service.h.IzE.F(986L, 106L);
        com.tencent.mm.plugin.report.service.h.IzE.p(986L, 110L, l);
      }
      else if ((paramc instanceof m))
      {
        com.tencent.mm.plugin.report.service.h.IzE.F(986L, 149L);
        com.tencent.mm.plugin.report.service.h.IzE.p(986L, 150L, l);
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/media/decoder/DecodeHelper$Companion;", "", "()V", "DEFAULT_QUEUE_CAPACITY", "", "REPORT_ID_STORY_VIDEO", "", "REPORT_KEY_ENCODE_CFR_COUNT", "REPORT_KEY_ENCODE_CFR_INIT_TIME", "REPORT_KEY_ENCODE_COUNT", "REPORT_KEY_ENCODE_FRAME_RATE", "REPORT_KEY_ENCODE_FRAME_RATE_DIFF", "REPORT_KEY_ENCODE_ORIGINAL_COUNT", "REPORT_KEY_ENCODE_PASSTHROUGH_COUNT", "REPORT_KEY_ENCODE_PASSTHROUGH_INIT_TIME", "REPORT_KEY_ENCODE_SIMPLE_VFR_COUNT", "REPORT_KEY_ENCODE_SIMPLE_VFR_INIT_TIME", "REPORT_KEY_ENCODE_VFR_COUNT", "REPORT_KEY_ENCODE_VFR_INIT_TIME", "TAG", "", "plugin-mediaeditor_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.media.d.b
 * JD-Core Version:    0.7.0.1
 */