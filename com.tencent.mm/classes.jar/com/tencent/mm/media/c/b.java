package com.tencent.mm.media.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bt;
import d.a.j;
import d.o;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/media/decoder/DecodeHelper;", "", "path", "", "outputFPS", "", "startTime", "", "(Ljava/lang/String;IJ)V", "copyPts", "Landroid/support/v4/util/ArrayMap;", "", "frames", "", "inFPS", "lastPts", "maxFps", "", "minFps", "outFPS", "parents", "queue", "Ljava/util/PriorityQueue;", "Lkotlin/Pair;", "recentPts", "getStartTime", "()J", "vfrThreshold", "hasFrame", "", "initStrategy", "", "receiveFrame", "release", "sendPacket", "pts", "bufferIndex", "useStrategy", "strategy", "Lcom/tencent/mm/media/decoder/DecodeStrategy;", "Companion", "plugin-mediaeditor_release"})
public final class b
{
  public static final a gOo;
  private final List<Long> aCs;
  final PriorityQueue<o<Long, Integer>> bwN;
  long gOf;
  long gOg;
  final android.support.v4.e.a<Long, Long> gOh;
  final android.support.v4.e.a<Long, List<Long>> gOi;
  private int gOj;
  private int gOk;
  private double gOl;
  private double gOm;
  private final int gOn;
  private final long startTime;
  
  static
  {
    AppMethodBeat.i(93527);
    gOo = new a((byte)0);
    AppMethodBeat.o(93527);
  }
  
  public b(String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(93526);
    this.startTime = paramLong;
    this.gOf = -1L;
    this.gOg = -1L;
    this.gOh = new android.support.v4.e.a();
    this.gOi = new android.support.v4.e.a();
    this.gOn = ((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pTE, 10);
    double[] arrayOfDouble = new double[3];
    double[] tmp79_77 = arrayOfDouble;
    tmp79_77[0] = 0.0D;
    double[] tmp83_79 = tmp79_77;
    tmp83_79[1] = 0.0D;
    double[] tmp87_83 = tmp83_79;
    tmp87_83[2] = 0.0D;
    tmp87_83;
    this.aCs = j.j((Iterable)com.tencent.mm.media.j.b.a(paramString, tmp79_77));
    this.gOj = ((int)tmp79_77[2]);
    label179:
    int i;
    if (paramInt > 0)
    {
      this.gOk = paramInt;
      h.wUl.A(986L, 114L);
      h.wUl.n(986L, 115L, tmp79_77[2]);
      h.wUl.n(986L, 116L, (tmp79_77[1] - tmp79_77[0]));
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
        if (((Collection)this.aCs).isEmpty()) {
          break label508;
        }
        paramInt = 1;
        label224:
        if (paramInt != 0) {
          this.gOg = ((Number)j.iQ(this.aCs)).longValue();
        }
      }
      this.gOl = tmp79_77[0];
      this.gOm = tmp79_77[1];
      this.bwN = new PriorityQueue(Math.max(this.aCs.size(), 11), (Comparator)1.gOp);
      boolean bool = ((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pTD, false);
      if ((!bt.eWo()) && (!bool)) {
        break label578;
      }
      if (this.gOj > this.gOk) {
        break label513;
      }
      ac.i("DecodeHelper", "use PassthroughDecodeStrategy");
      a((c)new k());
    }
    for (;;)
    {
      ac.i("DecodeHelper", "init decode helper, inFPS = " + this.gOj + ", outFPS = " + this.gOk + ", minFps:" + this.gOl + ", maxFps:" + this.gOm + ", vfrThreshold:" + this.gOn + ", valid frames = " + this.gOh.size() + ", lastPts:" + this.gOg + ", frames.size:" + this.aCs.size());
      AppMethodBeat.o(93526);
      return;
      paramInt = this.gOj;
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
      if (this.aCs.size() > 2000)
      {
        ac.i("DecodeHelper", "use CfrDecodeStrategy");
        a((c)new a());
      }
      else
      {
        ac.i("DecodeHelper", "use VfrDecodeStrategy");
        a((c)new l());
        continue;
        label578:
        ac.i("DecodeHelper", "use PassthroughDecodeStrategy");
        a((c)new k());
      }
    }
  }
  
  private void a(c paramc)
  {
    AppMethodBeat.i(93525);
    d.g.b.k.h(paramc, "strategy");
    long l = System.currentTimeMillis();
    paramc.a(this.startTime, this.aCs, this.gOj, this.gOk, (Map)this.gOh, (Map)this.gOi);
    l = System.currentTimeMillis() - l;
    if ((paramc instanceof k))
    {
      h.wUl.A(986L, 105L);
      h.wUl.n(986L, 108L, l);
    }
    for (;;)
    {
      this.gOf = -1L;
      AppMethodBeat.o(93525);
      return;
      if ((paramc instanceof a))
      {
        h.wUl.A(986L, 107L);
        h.wUl.n(986L, 112L, l);
      }
      else if ((paramc instanceof l))
      {
        h.wUl.A(986L, 106L);
        h.wUl.n(986L, 110L, l);
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/media/decoder/DecodeHelper$Companion;", "", "()V", "DEFAULT_QUEUE_CAPACITY", "", "REPORT_ID_STORY_VIDEO", "", "REPORT_KEY_ENCODE_CFR_COUNT", "REPORT_KEY_ENCODE_CFR_INIT_TIME", "REPORT_KEY_ENCODE_COUNT", "REPORT_KEY_ENCODE_FRAME_RATE", "REPORT_KEY_ENCODE_FRAME_RATE_DIFF", "REPORT_KEY_ENCODE_ORIGINAL_COUNT", "REPORT_KEY_ENCODE_PASSTHROUGH_COUNT", "REPORT_KEY_ENCODE_PASSTHROUGH_INIT_TIME", "REPORT_KEY_ENCODE_VFR_COUNT", "REPORT_KEY_ENCODE_VFR_INIT_TIME", "TAG", "", "plugin-mediaeditor_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.media.c.b
 * JD-Core Version:    0.7.0.1
 */