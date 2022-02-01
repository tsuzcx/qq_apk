package com.tencent.mm.media.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
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

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/media/decoder/DecodeHelper;", "", "path", "", "outputFPS", "", "startTime", "", "enableHevc", "", "(Ljava/lang/String;IJZ)V", "copyPts", "Landroid/support/v4/util/ArrayMap;", "", "getEnableHevc", "()Z", "setEnableHevc", "(Z)V", "frameInterval", "getFrameInterval", "()J", "setFrameInterval", "(J)V", "frames", "", "inFPS", "lastPts", "maxFps", "", "minFps", "outFPS", "parents", "queue", "Ljava/util/PriorityQueue;", "Lkotlin/Pair;", "recentPts", "getStartTime", "vfrThreshold", "hasFrame", "initStrategy", "", "receiveFrame", "release", "sendPacket", "pts", "bufferIndex", "useStrategy", "strategy", "Lcom/tencent/mm/media/decoder/DecodeStrategy;", "Companion", "plugin-mediaeditor_release"})
public final class b
{
  public static final b.a idZ;
  private final List<Long> aEj;
  final PriorityQueue<o<Long, Integer>> bHs;
  long idQ;
  long idR;
  final android.support.v4.e.a<Long, Long> idS;
  final android.support.v4.e.a<Long, List<Long>> idT;
  private int idU;
  private int idV;
  private double idW;
  private double idX;
  private final int idY;
  private boolean iiD;
  private long ost;
  private final long startTime;
  
  static
  {
    AppMethodBeat.i(93527);
    idZ = new b.a((byte)0);
    AppMethodBeat.o(93527);
  }
  
  public b(String paramString, int paramInt, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(258660);
    this.startTime = paramLong;
    this.iiD = paramBoolean;
    this.idQ = -1L;
    this.idR = -1L;
    this.idS = new android.support.v4.e.a();
    this.idT = new android.support.v4.e.a();
    this.idY = ((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.rYC, 10);
    this.ost = 333L;
    double[] arrayOfDouble = new double[3];
    double[] tmp92_90 = arrayOfDouble;
    tmp92_90[0] = 0.0D;
    double[] tmp96_92 = tmp92_90;
    tmp96_92[1] = 0.0D;
    double[] tmp100_96 = tmp96_92;
    tmp100_96[2] = 0.0D;
    tmp100_96;
    this.aEj = j.n((Iterable)com.tencent.mm.media.k.b.a(paramString, tmp92_90));
    this.idU = ((int)tmp92_90[2]);
    label192:
    int i;
    if (paramInt > 0)
    {
      this.idV = paramInt;
      h.CyF.F(986L, 114L);
      h.CyF.n(986L, 115L, tmp92_90[2]);
      h.CyF.n(986L, 116L, (tmp92_90[1] - tmp92_90[0]));
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
        if (((Collection)this.aEj).isEmpty()) {
          break label523;
        }
        paramInt = 1;
        label237:
        if (paramInt != 0) {
          this.idR = ((Number)j.ku(this.aEj)).longValue();
        }
      }
      this.idW = tmp92_90[0];
      this.idX = tmp92_90[1];
      this.bHs = new PriorityQueue(Math.max(this.aEj.size(), 11), (Comparator)b.1.iea);
      paramBoolean = ((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.rYB, false);
      if ((!WeChatEnvironment.hasDebugger()) && (!paramBoolean)) {
        break label610;
      }
      if (this.idU > this.idV) {
        break label528;
      }
      Log.i("DecodeHelper", "use PassthroughDecodeStrategy");
      a((c)new k());
    }
    for (;;)
    {
      Log.i("DecodeHelper", "init decode helper, inFPS = " + this.idU + ", outFPS = " + this.idV + ", minFps:" + this.idW + ", maxFps:" + this.idX + ", vfrThreshold:" + this.idY + ", valid frames = " + this.idS.size() + ", lastPts:" + this.idR + ", frames.size:" + this.aEj.size());
      AppMethodBeat.o(258660);
      return;
      paramInt = this.idU;
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
      if ((this.aEj.size() > 2000) && (!com.tencent.mm.plugin.sight.base.b.eVr()) && (!com.tencent.mm.plugin.sight.base.b.aj(false, this.iiD)))
      {
        Log.i("DecodeHelper", "use CfrDecodeStrategy");
        a((c)new a());
      }
      else
      {
        Log.i("DecodeHelper", "use VfrDecodeStrategy");
        a((c)new l());
        continue;
        label610:
        Log.i("DecodeHelper", "use PassthroughDecodeStrategy");
        a((c)new k());
      }
    }
  }
  
  private void a(c paramc)
  {
    AppMethodBeat.i(93525);
    p.h(paramc, "strategy");
    long l = System.currentTimeMillis();
    paramc.a(this.startTime, this.aEj, this.idU, this.idV, (Map)this.idS, (Map)this.idT);
    l = System.currentTimeMillis() - l;
    if ((paramc instanceof k))
    {
      h.CyF.F(986L, 105L);
      h.CyF.n(986L, 108L, l);
    }
    for (;;)
    {
      this.idQ = -1L;
      AppMethodBeat.o(93525);
      return;
      if ((paramc instanceof a))
      {
        h.CyF.F(986L, 107L);
        h.CyF.n(986L, 112L, l);
        this.ost = ((a)paramc).oss;
      }
      else if ((paramc instanceof l))
      {
        h.CyF.F(986L, 106L);
        h.CyF.n(986L, 110L, l);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.media.d.b
 * JD-Core Version:    0.7.0.1
 */