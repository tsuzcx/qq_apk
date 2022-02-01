package com.tencent.mm.media.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bu;
import d.a.j;
import d.g.b.p;
import d.o;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/media/decoder/DecodeHelper;", "", "path", "", "outputFPS", "", "startTime", "", "(Ljava/lang/String;IJ)V", "copyPts", "Landroid/support/v4/util/ArrayMap;", "", "frames", "", "inFPS", "lastPts", "maxFps", "", "minFps", "outFPS", "parents", "queue", "Ljava/util/PriorityQueue;", "Lkotlin/Pair;", "recentPts", "getStartTime", "()J", "vfrThreshold", "hasFrame", "", "initStrategy", "", "receiveFrame", "release", "sendPacket", "pts", "bufferIndex", "useStrategy", "strategy", "Lcom/tencent/mm/media/decoder/DecodeStrategy;", "Companion", "plugin-mediaeditor_release"})
public final class b
{
  public static final a hio;
  private final List<Long> aEj;
  final PriorityQueue<o<Long, Integer>> bHb;
  long hif;
  long hig;
  final android.support.v4.e.a<Long, Long> hih;
  final android.support.v4.e.a<Long, List<Long>> hii;
  private int hij;
  private int hik;
  private double hil;
  private double him;
  private final int hin;
  private final long startTime;
  
  static
  {
    AppMethodBeat.i(93527);
    hio = new a((byte)0);
    AppMethodBeat.o(93527);
  }
  
  public b(String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(93526);
    this.startTime = paramLong;
    this.hif = -1L;
    this.hig = -1L;
    this.hih = new android.support.v4.e.a();
    this.hii = new android.support.v4.e.a();
    this.hin = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qyk, 10);
    double[] arrayOfDouble = new double[3];
    double[] tmp79_77 = arrayOfDouble;
    tmp79_77[0] = 0.0D;
    double[] tmp83_79 = tmp79_77;
    tmp83_79[1] = 0.0D;
    double[] tmp87_83 = tmp83_79;
    tmp87_83[2] = 0.0D;
    tmp87_83;
    this.aEj = j.j((Iterable)com.tencent.mm.media.k.b.a(paramString, tmp79_77));
    this.hij = ((int)tmp79_77[2]);
    label179:
    int i;
    if (paramInt > 0)
    {
      this.hik = paramInt;
      com.tencent.mm.plugin.report.service.g.yhR.A(986L, 114L);
      com.tencent.mm.plugin.report.service.g.yhR.n(986L, 115L, tmp79_77[2]);
      com.tencent.mm.plugin.report.service.g.yhR.n(986L, 116L, (tmp79_77[1] - tmp79_77[0]));
      paramInt = 0;
      if (paramInt >= 3) {
        break label503;
      }
      if (tmp79_77[paramInt] <= 0.0D) {
        break label490;
      }
      i = 1;
      label196:
      if (i != 0) {
        break label496;
      }
      paramInt = 0;
      label203:
      if (paramInt != 0)
      {
        if (((Collection)this.aEj).isEmpty()) {
          break label508;
        }
        paramInt = 1;
        label224:
        if (paramInt != 0) {
          this.hig = ((Number)j.je(this.aEj)).longValue();
        }
      }
      this.hil = tmp79_77[0];
      this.him = tmp79_77[1];
      this.bHb = new PriorityQueue(Math.max(this.aEj.size(), 11), (Comparator)1.hip);
      boolean bool = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qyj, false);
      if ((!bu.flY()) && (!bool)) {
        break label584;
      }
      if (this.hij > this.hik) {
        break label513;
      }
      ad.i("DecodeHelper", "use PassthroughDecodeStrategy");
      a((c)new k());
    }
    for (;;)
    {
      ad.i("DecodeHelper", "init decode helper, inFPS = " + this.hij + ", outFPS = " + this.hik + ", minFps:" + this.hil + ", maxFps:" + this.him + ", vfrThreshold:" + this.hin + ", valid frames = " + this.hih.size() + ", lastPts:" + this.hig + ", frames.size:" + this.aEj.size());
      AppMethodBeat.o(93526);
      return;
      paramInt = this.hij;
      break;
      label490:
      i = 0;
      break label196;
      label496:
      paramInt += 1;
      break label179;
      label503:
      paramInt = 1;
      break label203;
      label508:
      paramInt = 0;
      break label224;
      label513:
      if ((this.aEj.size() > 2000) || (!com.tencent.mm.plugin.sight.base.b.dPV()))
      {
        ad.i("DecodeHelper", "use CfrDecodeStrategy");
        a((c)new a());
      }
      else
      {
        ad.i("DecodeHelper", "use VfrDecodeStrategy");
        a((c)new l());
        continue;
        label584:
        ad.i("DecodeHelper", "use PassthroughDecodeStrategy");
        a((c)new k());
      }
    }
  }
  
  private void a(c paramc)
  {
    AppMethodBeat.i(93525);
    p.h(paramc, "strategy");
    long l = System.currentTimeMillis();
    paramc.a(this.startTime, this.aEj, this.hij, this.hik, (Map)this.hih, (Map)this.hii);
    l = System.currentTimeMillis() - l;
    if ((paramc instanceof k))
    {
      com.tencent.mm.plugin.report.service.g.yhR.A(986L, 105L);
      com.tencent.mm.plugin.report.service.g.yhR.n(986L, 108L, l);
    }
    for (;;)
    {
      this.hif = -1L;
      AppMethodBeat.o(93525);
      return;
      if ((paramc instanceof a))
      {
        com.tencent.mm.plugin.report.service.g.yhR.A(986L, 107L);
        com.tencent.mm.plugin.report.service.g.yhR.n(986L, 112L, l);
      }
      else if ((paramc instanceof l))
      {
        com.tencent.mm.plugin.report.service.g.yhR.A(986L, 106L);
        com.tencent.mm.plugin.report.service.g.yhR.n(986L, 110L, l);
      }
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/media/decoder/DecodeHelper$Companion;", "", "()V", "DEFAULT_QUEUE_CAPACITY", "", "REPORT_ID_STORY_VIDEO", "", "REPORT_KEY_ENCODE_CFR_COUNT", "REPORT_KEY_ENCODE_CFR_INIT_TIME", "REPORT_KEY_ENCODE_COUNT", "REPORT_KEY_ENCODE_FRAME_RATE", "REPORT_KEY_ENCODE_FRAME_RATE_DIFF", "REPORT_KEY_ENCODE_ORIGINAL_COUNT", "REPORT_KEY_ENCODE_PASSTHROUGH_COUNT", "REPORT_KEY_ENCODE_PASSTHROUGH_INIT_TIME", "REPORT_KEY_ENCODE_VFR_COUNT", "REPORT_KEY_ENCODE_VFR_INIT_TIME", "TAG", "", "plugin-mediaeditor_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.media.d.b
 * JD-Core Version:    0.7.0.1
 */