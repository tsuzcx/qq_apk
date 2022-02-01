package com.tencent.mm.plugin.ac;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webjsengine/WebCanvasPerformanceReporter;", "", "reportId", "", "initStartTime", "appId", "", "(JJLjava/lang/String;)V", "getAppId", "()Ljava/lang/String;", "baseReportId", "bindStartTimeMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/plugin/webjsengine/WebCanvasPerformanceReporter$BindInfo;", "configCost", "configStartTime", "getConfigStartTime", "()J", "setConfigStartTime", "(J)V", "createStartTimeMap", "Lcom/tencent/mm/plugin/webjsengine/WebCanvasPerformanceReporter$CreateInfo;", "isMainContextStarted", "", "()Z", "setMainContextStarted", "(Z)V", "lastCreateStartTime", "magicBrushInitCost", "magicBrushInitStartTime", "getReportId", "addBindStartTime", "", "canvasId", "id", "addCreateStartTime", "startTime", "onBasePkgRead", "duration", "onBizPkgRead", "onClientContextReady", "onConfigClientEnd", "onConfigEnd", "onConfigStart", "onJsInit", "info", "timeCost", "onMagicBrushInit", "onMagicBrushInitStart", "onMainContextReady", "onRafInit", "onScreen", "performance", "elementId", "key", "report", "value", "reportWebCanvasRender", "resetBindStartTime", "canvasElementId", "BindInfo", "Companion", "CreateInfo", "webview-sdk_release"})
public final class b
{
  public static final b IBK;
  private final long IBA;
  public volatile boolean IBB;
  private long IBC;
  public final ConcurrentHashMap<String, b.c> IBD;
  public final ConcurrentHashMap<Integer, b.a> IBE;
  public long IBF;
  public long IBG;
  public long IBH;
  private long IBI;
  private final long IBJ;
  public final String appId;
  public final long hpW;
  
  static
  {
    AppMethodBeat.i(224867);
    IBK = new b((byte)0);
    AppMethodBeat.o(224867);
  }
  
  private b(long paramLong, String paramString)
  {
    AppMethodBeat.i(224865);
    this.IBJ = 1498L;
    this.hpW = paramLong;
    this.appId = paramString;
    this.IBA = 1497L;
    this.IBD = new ConcurrentHashMap();
    this.IBE = new ConcurrentHashMap();
    this.IBF = System.currentTimeMillis();
    this.IBG = System.currentTimeMillis();
    AppMethodBeat.o(224865);
  }
  
  public final void Q(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(224864);
    h.CyF.n(this.IBA, paramLong1, paramLong2);
    h.CyF.n(this.IBJ, paramLong1, paramLong2);
    AppMethodBeat.o(224864);
  }
  
  public final void fXb()
  {
    AppMethodBeat.i(224861);
    this.IBC = System.currentTimeMillis();
    Q(10L, 1L);
    long l = this.IBC - this.hpW;
    Q(11L, l);
    Log.i("MicroMsg.WebCanvasPerformanceReporter", "performance: [ConfigStart]:" + l + "ms");
    AppMethodBeat.o(224861);
  }
  
  public final void fXc()
  {
    AppMethodBeat.i(224862);
    long l2 = System.currentTimeMillis();
    long l1 = l2 - this.hpW;
    Q(12L, l1);
    l2 -= this.IBC;
    Q(16L, l2);
    Log.i("MicroMsg.WebCanvasPerformanceReporter", "performance: [ConfigEnd]:" + l1 + "ms");
    this.IBI = l2;
    AppMethodBeat.o(224862);
  }
  
  public final void fXd()
  {
    AppMethodBeat.i(224863);
    this.IBB = true;
    long l2 = System.currentTimeMillis();
    long l1 = l2 - this.hpW;
    l2 -= this.IBC;
    Q(17L, l1);
    Log.i("MicroMsg.WebCanvasPerformanceReporter", "performance: [MainContextReady]:" + l1 + "ms, inject mainContextCost " + l2);
    if (50L > l2)
    {
      if (101L <= l2) {
        break label226;
      }
      label82:
      if (301L <= l2) {
        break label245;
      }
      label90:
      if (l2 > 500L) {
        Q(22L, 1L);
      }
    }
    for (;;)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.appId);
      ((StringBuilder)localObject).append(",");
      ((StringBuilder)localObject).append(this.IBH);
      ((StringBuilder)localObject).append(",");
      ((StringBuilder)localObject).append(this.IBI);
      ((StringBuilder)localObject).append(",");
      ((StringBuilder)localObject).append(l1);
      localObject = ((StringBuilder)localObject).toString();
      p.g(localObject, "StringBuilder().apply {\n…ast)\n        }.toString()");
      h.CyF.kvStat(20918, (String)localObject);
      AppMethodBeat.o(224863);
      return;
      if (100L < l2) {
        break;
      }
      Q(19L, 1L);
      continue;
      label226:
      if (300L < l2) {
        break label82;
      }
      Q(20L, 1L);
      continue;
      label245:
      if (500L < l2) {
        break label90;
      }
      Q(21L, 1L);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webjsengine/WebCanvasPerformanceReporter$Companion;", "", "()V", "SPLITOR", "", "TAG", "kvWebCanvasCreate", "", "kvWebCanvasMainContextInit", "kvWebCanvasRender", "webview-sdk_release"})
  public static final class b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ac.b
 * JD-Core Version:    0.7.0.1
 */