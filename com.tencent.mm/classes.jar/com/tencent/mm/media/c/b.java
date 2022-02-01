package com.tencent.mm.media.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bu;
import d.a.j;
import d.o;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/media/decoder/DecodeHelper;", "", "path", "", "outputFPS", "", "startTime", "", "(Ljava/lang/String;IJ)V", "copyPts", "Landroid/support/v4/util/ArrayMap;", "", "frames", "", "inFPS", "lastPts", "maxFps", "", "minFps", "outFPS", "parents", "queue", "Ljava/util/PriorityQueue;", "Lkotlin/Pair;", "recentPts", "getStartTime", "()J", "vfrThreshold", "hasFrame", "", "initStrategy", "", "receiveFrame", "release", "sendPacket", "pts", "bufferIndex", "useStrategy", "strategy", "Lcom/tencent/mm/media/decoder/DecodeStrategy;", "Companion", "plugin-mediaeditor_release"})
public final class b
{
  public static final a gnC;
  private final List<Long> aBz;
  final PriorityQueue<o<Long, Integer>> bzf;
  private double gnA;
  private final int gnB;
  long gnt;
  long gnu;
  final android.support.v4.e.a<Long, Long> gnv;
  final android.support.v4.e.a<Long, List<Long>> gnw;
  private int gnx;
  private int gny;
  private double gnz;
  private final long startTime;
  
  static
  {
    AppMethodBeat.i(93527);
    gnC = new a((byte)0);
    AppMethodBeat.o(93527);
  }
  
  public b(String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(93526);
    this.startTime = paramLong;
    this.gnt = -1L;
    this.gnu = -1L;
    this.gnv = new android.support.v4.e.a();
    this.gnw = new android.support.v4.e.a();
    this.gnB = ((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.ppT, 10);
    double[] arrayOfDouble = new double[3];
    double[] tmp79_77 = arrayOfDouble;
    tmp79_77[0] = 0.0D;
    double[] tmp83_79 = tmp79_77;
    tmp83_79[1] = 0.0D;
    double[] tmp87_83 = tmp83_79;
    tmp87_83[2] = 0.0D;
    tmp87_83;
    this.aBz = j.k((Iterable)com.tencent.mm.media.j.b.a(paramString, tmp79_77));
    this.gnx = ((int)tmp79_77[2]);
    label179:
    int i;
    if (paramInt > 0)
    {
      this.gny = paramInt;
      h.vKh.D(986L, 114L);
      h.vKh.m(986L, 115L, tmp79_77[2]);
      h.vKh.m(986L, 116L, (tmp79_77[1] - tmp79_77[0]));
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
        if (((Collection)this.aBz).isEmpty()) {
          break label508;
        }
        paramInt = 1;
        label224:
        if (paramInt != 0) {
          this.gnu = ((Number)j.iA(this.aBz)).longValue();
        }
      }
      this.gnz = tmp79_77[0];
      this.gnA = tmp79_77[1];
      this.bzf = new PriorityQueue(Math.max(this.aBz.size(), 11), (Comparator)1.gnD);
      boolean bool = ((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.ppS, false);
      if ((!bu.eGT()) && (!bool)) {
        break label578;
      }
      if (this.gnx > this.gny) {
        break label513;
      }
      ad.i("DecodeHelper", "use PassthroughDecodeStrategy");
      a((c)new k());
    }
    for (;;)
    {
      ad.i("DecodeHelper", "init decode helper, inFPS = " + this.gnx + ", outFPS = " + this.gny + ", minFps:" + this.gnz + ", maxFps:" + this.gnA + ", vfrThreshold:" + this.gnB + ", valid frames = " + this.gnv.size() + ", lastPts:" + this.gnu + ", frames.size:" + this.aBz.size());
      AppMethodBeat.o(93526);
      return;
      paramInt = this.gnx;
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
      if (this.aBz.size() > 2000)
      {
        ad.i("DecodeHelper", "use CfrDecodeStrategy");
        a((c)new a());
      }
      else
      {
        ad.i("DecodeHelper", "use VfrDecodeStrategy");
        a((c)new l());
        continue;
        label578:
        ad.i("DecodeHelper", "use PassthroughDecodeStrategy");
        a((c)new k());
      }
    }
  }
  
  private void a(c paramc)
  {
    AppMethodBeat.i(93525);
    d.g.b.k.h(paramc, "strategy");
    long l = System.currentTimeMillis();
    paramc.a(this.startTime, this.aBz, this.gnx, this.gny, (Map)this.gnv, (Map)this.gnw);
    l = System.currentTimeMillis() - l;
    if ((paramc instanceof k))
    {
      h.vKh.D(986L, 105L);
      h.vKh.m(986L, 108L, l);
    }
    for (;;)
    {
      this.gnt = -1L;
      AppMethodBeat.o(93525);
      return;
      if ((paramc instanceof a))
      {
        h.vKh.D(986L, 107L);
        h.vKh.m(986L, 112L, l);
      }
      else if ((paramc instanceof l))
      {
        h.vKh.D(986L, 106L);
        h.vKh.m(986L, 110L, l);
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/media/decoder/DecodeHelper$Companion;", "", "()V", "DEFAULT_QUEUE_CAPACITY", "", "REPORT_ID_STORY_VIDEO", "", "REPORT_KEY_ENCODE_CFR_COUNT", "REPORT_KEY_ENCODE_CFR_INIT_TIME", "REPORT_KEY_ENCODE_COUNT", "REPORT_KEY_ENCODE_FRAME_RATE", "REPORT_KEY_ENCODE_FRAME_RATE_DIFF", "REPORT_KEY_ENCODE_ORIGINAL_COUNT", "REPORT_KEY_ENCODE_PASSTHROUGH_COUNT", "REPORT_KEY_ENCODE_PASSTHROUGH_INIT_TIME", "REPORT_KEY_ENCODE_VFR_COUNT", "REPORT_KEY_ENCODE_VFR_INIT_TIME", "TAG", "", "plugin-mediaeditor_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.media.c.b
 * JD-Core Version:    0.7.0.1
 */