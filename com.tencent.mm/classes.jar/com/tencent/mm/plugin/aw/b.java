package com.tencent.mm.plugin.aw;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webjsengine/WebCanvasPerformanceReporter;", "", "reportId", "", "initStartTime", "appId", "", "(JJLjava/lang/String;)V", "getAppId", "()Ljava/lang/String;", "baseReportId", "bindStartTimeMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/plugin/webjsengine/WebCanvasPerformanceReporter$BindInfo;", "configCost", "configStartTime", "getConfigStartTime", "()J", "setConfigStartTime", "(J)V", "createStartTimeMap", "Lcom/tencent/mm/plugin/webjsengine/WebCanvasPerformanceReporter$CreateInfo;", "isMainContextStarted", "", "()Z", "setMainContextStarted", "(Z)V", "lastCreateStartTime", "magicBrushInitCost", "magicBrushInitStartTime", "getReportId", "addBindStartTime", "", "canvasId", "id", "addCreateStartTime", "startTime", "onBasePkgRead", "duration", "onBizPkgRead", "onClientContextReady", "onConfigClientEnd", "onConfigEnd", "onConfigStart", "onJsInit", "info", "timeCost", "onMagicBrushInit", "onMagicBrushInitStart", "onMainContextReady", "onRafInit", "onScreen", "performance", "elementId", "key", "report", "value", "reportWebCanvasRender", "resetBindStartTime", "canvasElementId", "BindInfo", "Companion", "CreateInfo", "webview-sdk_release"})
public final class b
{
  public static final b PvX;
  private final long PvN;
  public volatile boolean PvO;
  private long PvP;
  public final ConcurrentHashMap<String, c> PvQ;
  public final ConcurrentHashMap<Integer, a> PvR;
  public long PvS;
  public long PvT;
  public long PvU;
  private long PvV;
  private final long PvW;
  public final String appId;
  public final long kbR;
  
  static
  {
    AppMethodBeat.i(212273);
    PvX = new b((byte)0);
    AppMethodBeat.o(212273);
  }
  
  private b(long paramLong, String paramString)
  {
    AppMethodBeat.i(212270);
    this.PvW = 1498L;
    this.kbR = paramLong;
    this.appId = paramString;
    this.PvN = 1497L;
    this.PvQ = new ConcurrentHashMap();
    this.PvR = new ConcurrentHashMap();
    this.PvS = System.currentTimeMillis();
    this.PvT = System.currentTimeMillis();
    AppMethodBeat.o(212270);
  }
  
  public final void V(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(212267);
    h.IzE.p(this.PvN, paramLong1, paramLong2);
    h.IzE.p(this.PvW, paramLong1, paramLong2);
    AppMethodBeat.o(212267);
  }
  
  public final void gPL()
  {
    AppMethodBeat.i(212260);
    this.PvP = System.currentTimeMillis();
    V(10L, 1L);
    long l = this.PvP - this.kbR;
    V(11L, l);
    Log.i("MicroMsg.WebCanvasPerformanceReporter", "performance: [ConfigStart]:" + l + "ms");
    AppMethodBeat.o(212260);
  }
  
  public final void gPM()
  {
    AppMethodBeat.i(212263);
    long l2 = System.currentTimeMillis();
    long l1 = l2 - this.kbR;
    V(12L, l1);
    l2 -= this.PvP;
    V(16L, l2);
    Log.i("MicroMsg.WebCanvasPerformanceReporter", "performance: [ConfigEnd]:" + l1 + "ms");
    this.PvV = l2;
    AppMethodBeat.o(212263);
  }
  
  public final void gPN()
  {
    AppMethodBeat.i(212266);
    this.PvO = true;
    long l2 = System.currentTimeMillis();
    long l1 = l2 - this.kbR;
    l2 -= this.PvP;
    V(17L, l1);
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
        V(22L, 1L);
      }
    }
    for (;;)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.appId);
      ((StringBuilder)localObject).append(",");
      ((StringBuilder)localObject).append(this.PvU);
      ((StringBuilder)localObject).append(",");
      ((StringBuilder)localObject).append(this.PvV);
      ((StringBuilder)localObject).append(",");
      ((StringBuilder)localObject).append(l1);
      localObject = ((StringBuilder)localObject).toString();
      p.j(localObject, "StringBuilder().apply {\n…ast)\n        }.toString()");
      h.IzE.kvStat(20918, (String)localObject);
      AppMethodBeat.o(212266);
      return;
      if (100L < l2) {
        break;
      }
      V(19L, 1L);
      continue;
      label226:
      if (300L < l2) {
        break label82;
      }
      V(20L, 1L);
      continue;
      label245:
      if (500L < l2) {
        break label90;
      }
      V(21L, 1L);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webjsengine/WebCanvasPerformanceReporter$BindInfo;", "", "createTime", "", "elementId", "", "canvasId", "", "(JILjava/lang/String;)V", "getCanvasId", "()Ljava/lang/String;", "getCreateTime", "()J", "setCreateTime", "(J)V", "getElementId", "()I", "firstOnScreenCost", "getFirstOnScreenCost", "setFirstOnScreenCost", "(I)V", "hasRendered", "", "getHasRendered", "()Z", "setHasRendered", "(Z)V", "isClientContextStarted", "setClientContextStarted", "jsInitCost", "getJsInitCost", "setJsInitCost", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "toString", "webview-sdk_release"})
  public static final class a
  {
    public boolean PvY;
    public boolean PvZ;
    private final int aSn;
    public long createTime;
    private final String owd;
    
    public a(long paramLong, int paramInt, String paramString)
    {
      AppMethodBeat.i(205541);
      this.createTime = paramLong;
      this.aSn = paramInt;
      this.owd = paramString;
      this.PvZ = true;
      AppMethodBeat.o(205541);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(205545);
      if (this != paramObject)
      {
        if ((paramObject instanceof a))
        {
          paramObject = (a)paramObject;
          if ((this.createTime != paramObject.createTime) || (this.aSn != paramObject.aSn) || (!p.h(this.owd, paramObject.owd))) {}
        }
      }
      else
      {
        AppMethodBeat.o(205545);
        return true;
      }
      AppMethodBeat.o(205545);
      return false;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(205544);
      long l = this.createTime;
      int j = (int)(l ^ l >>> 32);
      int k = this.aSn;
      String str = this.owd;
      if (str != null) {}
      for (int i = str.hashCode();; i = 0)
      {
        AppMethodBeat.o(205544);
        return i + (j * 31 + k) * 31;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(205543);
      String str = "BindInfo(createTime=" + this.createTime + ", elementId=" + this.aSn + ", canvasId=" + this.owd + ")";
      AppMethodBeat.o(205543);
      return str;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webjsengine/WebCanvasPerformanceReporter$Companion;", "", "()V", "SPLITOR", "", "TAG", "kvWebCanvasCreate", "", "kvWebCanvasMainContextInit", "kvWebCanvasRender", "webview-sdk_release"})
  public static final class b {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webjsengine/WebCanvasPerformanceReporter$CreateInfo;", "", "createTime", "", "isMainContextStarted", "", "(JZ)V", "configClientCost", "", "getConfigClientCost", "()I", "setConfigClientCost", "(I)V", "getCreateTime", "()J", "setCreateTime", "(J)V", "isClientContextStarted", "()Z", "setClientContextStarted", "(Z)V", "component1", "component2", "copy", "equals", "other", "hashCode", "toString", "", "webview-sdk_release"})
  public static final class c
  {
    public final boolean PvO;
    public boolean PvZ;
    public int Pwa;
    public long createTime;
    
    public c(long paramLong, boolean paramBoolean)
    {
      this.createTime = paramLong;
      this.PvO = paramBoolean;
    }
    
    public final boolean equals(Object paramObject)
    {
      if (this != paramObject)
      {
        if ((paramObject instanceof c))
        {
          paramObject = (c)paramObject;
          if ((this.createTime != paramObject.createTime) || (this.PvO != paramObject.PvO)) {}
        }
      }
      else {
        return true;
      }
      return false;
    }
    
    public final int hashCode()
    {
      throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
    
    public final String toString()
    {
      AppMethodBeat.i(206339);
      String str = "CreateInfo(createTime=" + this.createTime + ", isMainContextStarted=" + this.PvO + ")";
      AppMethodBeat.o(206339);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.aw.b
 * JD-Core Version:    0.7.0.1
 */