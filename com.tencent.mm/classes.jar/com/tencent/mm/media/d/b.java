package com.tencent.mm.media.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bv;
import d.a.j;
import d.g.b.p;
import d.o;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/media/decoder/DecodeHelper;", "", "path", "", "outputFPS", "", "startTime", "", "(Ljava/lang/String;IJ)V", "copyPts", "Landroid/support/v4/util/ArrayMap;", "", "frames", "", "inFPS", "lastPts", "maxFps", "", "minFps", "outFPS", "parents", "queue", "Ljava/util/PriorityQueue;", "Lkotlin/Pair;", "recentPts", "getStartTime", "()J", "vfrThreshold", "hasFrame", "", "initStrategy", "", "receiveFrame", "release", "sendPacket", "pts", "bufferIndex", "useStrategy", "strategy", "Lcom/tencent/mm/media/decoder/DecodeStrategy;", "Companion", "plugin-mediaeditor_release"})
public final class b
{
  public static final a hlc;
  private final List<Long> aEj;
  final PriorityQueue<o<Long, Integer>> bHb;
  long hkT;
  long hkU;
  final android.support.v4.e.a<Long, Long> hkV;
  final android.support.v4.e.a<Long, List<Long>> hkW;
  private int hkX;
  private int hkY;
  private double hkZ;
  private double hla;
  private final int hlb;
  private final long startTime;
  
  static
  {
    AppMethodBeat.i(93527);
    hlc = new a((byte)0);
    AppMethodBeat.o(93527);
  }
  
  public b(String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(93526);
    this.startTime = paramLong;
    this.hkT = -1L;
    this.hkU = -1L;
    this.hkV = new android.support.v4.e.a();
    this.hkW = new android.support.v4.e.a();
    this.hlb = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qFq, 10);
    double[] arrayOfDouble = new double[3];
    double[] tmp79_77 = arrayOfDouble;
    tmp79_77[0] = 0.0D;
    double[] tmp83_79 = tmp79_77;
    tmp83_79[1] = 0.0D;
    double[] tmp87_83 = tmp83_79;
    tmp87_83[2] = 0.0D;
    tmp87_83;
    this.aEj = j.j((Iterable)com.tencent.mm.media.k.b.a(paramString, tmp79_77));
    this.hkX = ((int)tmp79_77[2]);
    label179:
    int i;
    if (paramInt > 0)
    {
      this.hkY = paramInt;
      com.tencent.mm.plugin.report.service.g.yxI.A(986L, 114L);
      com.tencent.mm.plugin.report.service.g.yxI.n(986L, 115L, tmp79_77[2]);
      com.tencent.mm.plugin.report.service.g.yxI.n(986L, 116L, (tmp79_77[1] - tmp79_77[0]));
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
          this.hkU = ((Number)j.jn(this.aEj)).longValue();
        }
      }
      this.hkZ = tmp79_77[0];
      this.hla = tmp79_77[1];
      this.bHb = new PriorityQueue(Math.max(this.aEj.size(), 11), (Comparator)1.hld);
      boolean bool = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qFp, false);
      if ((!bv.fpT()) && (!bool)) {
        break label584;
      }
      if (this.hkX > this.hkY) {
        break label513;
      }
      ae.i("DecodeHelper", "use PassthroughDecodeStrategy");
      a((c)new k());
    }
    for (;;)
    {
      ae.i("DecodeHelper", "init decode helper, inFPS = " + this.hkX + ", outFPS = " + this.hkY + ", minFps:" + this.hkZ + ", maxFps:" + this.hla + ", vfrThreshold:" + this.hlb + ", valid frames = " + this.hkV.size() + ", lastPts:" + this.hkU + ", frames.size:" + this.aEj.size());
      AppMethodBeat.o(93526);
      return;
      paramInt = this.hkX;
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
      if ((this.aEj.size() > 2000) || (!com.tencent.mm.plugin.sight.base.b.dTs()))
      {
        ae.i("DecodeHelper", "use CfrDecodeStrategy");
        a((c)new a());
      }
      else
      {
        ae.i("DecodeHelper", "use VfrDecodeStrategy");
        a((c)new l());
        continue;
        label584:
        ae.i("DecodeHelper", "use PassthroughDecodeStrategy");
        a((c)new k());
      }
    }
  }
  
  private void a(c paramc)
  {
    AppMethodBeat.i(93525);
    p.h(paramc, "strategy");
    long l = System.currentTimeMillis();
    paramc.a(this.startTime, this.aEj, this.hkX, this.hkY, (Map)this.hkV, (Map)this.hkW);
    l = System.currentTimeMillis() - l;
    if ((paramc instanceof k))
    {
      com.tencent.mm.plugin.report.service.g.yxI.A(986L, 105L);
      com.tencent.mm.plugin.report.service.g.yxI.n(986L, 108L, l);
    }
    for (;;)
    {
      this.hkT = -1L;
      AppMethodBeat.o(93525);
      return;
      if ((paramc instanceof a))
      {
        com.tencent.mm.plugin.report.service.g.yxI.A(986L, 107L);
        com.tencent.mm.plugin.report.service.g.yxI.n(986L, 112L, l);
      }
      else if ((paramc instanceof l))
      {
        com.tencent.mm.plugin.report.service.g.yxI.A(986L, 106L);
        com.tencent.mm.plugin.report.service.g.yxI.n(986L, 110L, l);
      }
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/media/decoder/DecodeHelper$Companion;", "", "()V", "DEFAULT_QUEUE_CAPACITY", "", "REPORT_ID_STORY_VIDEO", "", "REPORT_KEY_ENCODE_CFR_COUNT", "REPORT_KEY_ENCODE_CFR_INIT_TIME", "REPORT_KEY_ENCODE_COUNT", "REPORT_KEY_ENCODE_FRAME_RATE", "REPORT_KEY_ENCODE_FRAME_RATE_DIFF", "REPORT_KEY_ENCODE_ORIGINAL_COUNT", "REPORT_KEY_ENCODE_PASSTHROUGH_COUNT", "REPORT_KEY_ENCODE_PASSTHROUGH_INIT_TIME", "REPORT_KEY_ENCODE_VFR_COUNT", "REPORT_KEY_ENCODE_VFR_INIT_TIME", "TAG", "", "plugin-mediaeditor_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.media.d.b
 * JD-Core Version:    0.7.0.1
 */