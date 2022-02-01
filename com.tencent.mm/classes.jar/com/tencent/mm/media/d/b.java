package com.tencent.mm.media.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/media/decoder/DecodeHelper;", "", "path", "", "outputFPS", "", "startTime", "", "enableHevc", "", "(Ljava/lang/String;IJZ)V", "copyPts", "Landroidx/collection/ArrayMap;", "", "getEnableHevc", "()Z", "setEnableHevc", "(Z)V", "frameInterval", "getFrameInterval", "()J", "setFrameInterval", "(J)V", "frames", "", "inFPS", "lastPts", "maxFps", "", "minFps", "outFPS", "parents", "queue", "Ljava/util/PriorityQueue;", "Lkotlin/Pair;", "recentPts", "getStartTime", "vfrThreshold", "hasFrame", "initStrategy", "", "receiveFrame", "release", "sendPacket", "pts", "bufferIndex", "useStrategy", "strategy", "Lcom/tencent/mm/media/decoder/DecodeStrategy;", "Companion", "plugin-mediaeditor_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final b.a nyg;
  private boolean nyh;
  long nyi;
  long nyj;
  final androidx.b.a<Long, Long> nyk;
  final androidx.b.a<Long, List<Long>> nyl;
  final PriorityQueue<r<Long, Integer>> nym;
  private final List<Long> nyn;
  private int nyo;
  private int nyp;
  private double nyq;
  private double nyr;
  private final int nys;
  private long nyt;
  private final long startTime;
  
  static
  {
    AppMethodBeat.i(93527);
    nyg = new b.a((byte)0);
    AppMethodBeat.o(93527);
  }
  
  public b(String paramString, int paramInt, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(236911);
    this.startTime = paramLong;
    this.nyh = paramBoolean;
    this.nyi = -1L;
    this.nyj = -1L;
    this.nyk = new androidx.b.a();
    this.nyl = new androidx.b.a();
    this.nys = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yUX, 10);
    this.nyt = 333L;
    double[] arrayOfDouble = new double[3];
    arrayOfDouble[0] = 0.0D;
    arrayOfDouble[1] = 0.0D;
    arrayOfDouble[2] = 0.0D;
    this.nyn = p.n((Iterable)com.tencent.mm.media.util.b.a(paramString, arrayOfDouble));
    this.nyo = ((int)arrayOfDouble[2]);
    label193:
    int i;
    if (paramInt > 0)
    {
      this.nyp = paramInt;
      com.tencent.mm.plugin.report.service.h.OAn.p(986L, 114L, 1L);
      com.tencent.mm.plugin.report.service.h.OAn.p(986L, 115L, arrayOfDouble[2]);
      com.tencent.mm.plugin.report.service.h.OAn.p(986L, 116L, (arrayOfDouble[1] - arrayOfDouble[0]));
      paramInt = 0;
      if (paramInt >= 3) {
        break label516;
      }
      if (arrayOfDouble[paramInt] <= 0.0D) {
        break label503;
      }
      i = 1;
      label210:
      if (i != 0) {
        break label509;
      }
      paramInt = 0;
      label217:
      if (paramInt != 0)
      {
        if (((Collection)this.nyn).isEmpty()) {
          break label521;
        }
        paramInt = 1;
        label238:
        if (paramInt != 0) {
          this.nyj = ((Number)p.oM(this.nyn)).longValue();
        }
      }
      this.nyq = arrayOfDouble[0];
      this.nyr = arrayOfDouble[1];
      this.nym = new PriorityQueue(Math.max(this.nyn.size(), 11), b..ExternalSyntheticLambda0.INSTANCE);
      paramBoolean = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yUW, false);
      if ((!WeChatEnvironment.hasDebugger()) && (!paramBoolean)) {
        break label664;
      }
      if (this.nyo > this.nyp) {
        break label526;
      }
      Log.i("DecodeHelper", "use PassthroughDecodeStrategy");
      a((c)new k());
    }
    for (;;)
    {
      Log.i("DecodeHelper", "init decode helper, inFPS = " + this.nyo + ", outFPS = " + this.nyp + ", minFps:" + this.nyq + ", maxFps:" + this.nyr + ", vfrThreshold:" + this.nys + ", valid frames = " + this.nyk.size() + ", lastPts:" + this.nyj + ", frames.size:" + this.nyn.size());
      AppMethodBeat.o(236911);
      return;
      paramInt = this.nyo;
      break;
      label503:
      i = 0;
      break label210;
      label509:
      paramInt += 1;
      break label193;
      label516:
      paramInt = 1;
      break label217;
      label521:
      paramInt = 0;
      break label238;
      label526:
      paramInt = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yUY, 3660);
      if ((this.nyn.size() > paramInt) && (!com.tencent.mm.plugin.sight.base.c.gYn()) && (!com.tencent.mm.plugin.sight.base.c.aO(false, this.nyh)))
      {
        Log.i("DecodeHelper", "use CfrDecodeStrategy");
        a((c)new a());
      }
      else if (this.nyn.size() <= paramInt)
      {
        Log.i("DecodeHelper", "use VfrDecodeStrategy");
        a((c)new m());
      }
      else
      {
        Log.i("DecodeHelper", "use SimpleVfrDecodeStrategy");
        a((c)new l());
        continue;
        label664:
        Log.i("DecodeHelper", "use PassthroughDecodeStrategy");
        a((c)new k());
      }
    }
  }
  
  private static final int a(r paramr1, r paramr2)
  {
    AppMethodBeat.i(236917);
    int i = (int)(((Number)paramr1.bsC).longValue() - ((Number)paramr2.bsC).longValue());
    AppMethodBeat.o(236917);
    return i;
  }
  
  private void a(c paramc)
  {
    AppMethodBeat.i(93525);
    s.u(paramc, "strategy");
    long l = System.currentTimeMillis();
    paramc.a(this.startTime, this.nyn, this.nyo, this.nyp, (Map)this.nyk, (Map)this.nyl);
    l = System.currentTimeMillis() - l;
    if ((paramc instanceof k))
    {
      com.tencent.mm.plugin.report.service.h.OAn.p(986L, 105L, 1L);
      com.tencent.mm.plugin.report.service.h.OAn.p(986L, 108L, l);
    }
    for (;;)
    {
      this.nyi = -1L;
      AppMethodBeat.o(93525);
      return;
      if ((paramc instanceof a))
      {
        com.tencent.mm.plugin.report.service.h.OAn.p(986L, 107L, 1L);
        com.tencent.mm.plugin.report.service.h.OAn.p(986L, 112L, l);
        this.nyt = ((a)paramc).nyf;
      }
      else if ((paramc instanceof m))
      {
        com.tencent.mm.plugin.report.service.h.OAn.p(986L, 106L, 1L);
        com.tencent.mm.plugin.report.service.h.OAn.p(986L, 110L, l);
      }
      else if ((paramc instanceof l))
      {
        com.tencent.mm.plugin.report.service.h.OAn.p(986L, 149L, 1L);
        com.tencent.mm.plugin.report.service.h.OAn.p(986L, 150L, l);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.media.d.b
 * JD-Core Version:    0.7.0.1
 */