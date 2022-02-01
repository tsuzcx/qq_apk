package com.tencent.mm.plugin.ay;

import androidx.compose.a.q.a..ExternalSyntheticBackport0;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webjsengine/WebCanvasPerformanceReporter;", "", "reportId", "", "initStartTime", "appId", "", "(JJLjava/lang/String;)V", "getAppId", "()Ljava/lang/String;", "baseReportId", "bindStartTimeMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/plugin/webjsengine/WebCanvasPerformanceReporter$BindInfo;", "configCost", "configStartTime", "getConfigStartTime", "()J", "setConfigStartTime", "(J)V", "createStartTimeMap", "Lcom/tencent/mm/plugin/webjsengine/WebCanvasPerformanceReporter$CreateInfo;", "isMainContextStarted", "", "()Z", "setMainContextStarted", "(Z)V", "lastCreateStartTime", "magicBrushInitCost", "magicBrushInitStartTime", "renderJsEngineInitStartTime", "getRenderJsEngineInitStartTime", "setRenderJsEngineInitStartTime", "getReportId", "addBindStartTime", "", "canvasId", "id", "addCreateStartTime", "startTime", "onBasePkgRead", "duration", "onBizPkgRead", "onClientContextReady", "createTime", "onConfigClientEnd", "onConfigEnd", "onConfigStart", "onMagicBrushInit", "onMagicBrushInitStart", "onMainContextReady", "performance", "elementId", "key", "report", "value", "resetBindStartTime", "canvasElementId", "BindInfo", "Companion", "CreateInfo", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final b Wmb;
  private final long Wmc;
  private final long Wmd;
  public volatile boolean Wme;
  private long Wmf;
  public final ConcurrentHashMap<String, c> Wmg;
  public final ConcurrentHashMap<Integer, a> Wmh;
  public long Wmi;
  public long Wmj;
  public long Wmk;
  private long Wml;
  public long Wmm;
  public final String appId;
  private final long mBX;
  
  static
  {
    AppMethodBeat.i(266829);
    Wmb = new b((byte)0);
    AppMethodBeat.o(266829);
  }
  
  private b(long paramLong, String paramString)
  {
    AppMethodBeat.i(266813);
    this.Wmc = 1498L;
    this.mBX = paramLong;
    this.appId = paramString;
    this.Wmd = 1497L;
    this.Wmg = new ConcurrentHashMap();
    this.Wmh = new ConcurrentHashMap();
    this.Wmi = System.currentTimeMillis();
    this.Wmj = System.currentTimeMillis();
    this.Wmm = System.currentTimeMillis();
    AppMethodBeat.o(266813);
  }
  
  public final void as(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(266837);
    h.OAn.p(this.Wmd, paramLong1, paramLong2);
    h.OAn.p(this.Wmc, paramLong1, paramLong2);
    AppMethodBeat.o(266837);
  }
  
  public final void xD(long paramLong)
  {
    AppMethodBeat.i(266833);
    this.Wmf = System.currentTimeMillis();
    as(10L, 1L);
    long l = this.Wmf;
    if (paramLong > 0L) {}
    for (;;)
    {
      paramLong = l - paramLong;
      as(11L, paramLong);
      Log.i("MicroMsg.WebCanvasPerformanceReporter", "performance: [ConfigStart]:" + paramLong + "ms");
      AppMethodBeat.o(266833);
      return;
      paramLong = this.mBX;
    }
  }
  
  public final void xE(long paramLong)
  {
    AppMethodBeat.i(266834);
    long l = System.currentTimeMillis();
    if (paramLong > 0L) {}
    for (;;)
    {
      paramLong = l - paramLong;
      as(12L, paramLong);
      l -= this.Wmf;
      as(16L, l);
      Log.i("MicroMsg.WebCanvasPerformanceReporter", "performance: [ConfigEnd]:" + paramLong + "ms");
      this.Wml = l;
      AppMethodBeat.o(266834);
      return;
      paramLong = this.mBX;
    }
  }
  
  public final void xF(long paramLong)
  {
    AppMethodBeat.i(266836);
    this.Wme = true;
    long l = System.currentTimeMillis();
    int i;
    if (paramLong > 0L)
    {
      paramLong = l - paramLong;
      l -= this.Wmf;
      as(17L, paramLong);
      Log.i("MicroMsg.WebCanvasPerformanceReporter", "performance: [MainContextReady]:" + paramLong + "ms, inject mainContextCost " + l);
      if (50L > l) {
        break label221;
      }
      if (l > 100L) {
        break label216;
      }
      i = 1;
      label94:
      if (i == 0) {
        break label226;
      }
      as(19L, 1L);
    }
    for (;;)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.appId);
      ((StringBuilder)localObject).append(",");
      ((StringBuilder)localObject).append(this.Wmk);
      ((StringBuilder)localObject).append(",");
      ((StringBuilder)localObject).append(this.Wml);
      ((StringBuilder)localObject).append(",");
      ((StringBuilder)localObject).append(paramLong);
      localObject = ((StringBuilder)localObject).toString();
      s.s(localObject, "StringBuilder().apply {\n…ast)\n        }.toString()");
      h.OAn.kvStat(20918, (String)localObject);
      AppMethodBeat.o(266836);
      return;
      paramLong = this.mBX;
      break;
      label216:
      i = 0;
      break label94;
      label221:
      i = 0;
      break label94;
      label226:
      if (101L <= l) {
        if (l <= 300L) {
          i = 1;
        }
      }
      for (;;)
      {
        if (i == 0) {
          break label271;
        }
        as(20L, 1L);
        break;
        i = 0;
        continue;
        i = 0;
      }
      label271:
      if (301L <= l) {
        if (l <= 500L) {
          i = 1;
        }
      }
      for (;;)
      {
        if (i == 0) {
          break label316;
        }
        as(21L, 1L);
        break;
        i = 0;
        continue;
        i = 0;
      }
      label316:
      if (l > 500L) {
        as(22L, 1L);
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webjsengine/WebCanvasPerformanceReporter$BindInfo;", "", "createTime", "", "elementId", "", "canvasId", "", "(JILjava/lang/String;)V", "getCanvasId", "()Ljava/lang/String;", "getCreateTime", "()J", "setCreateTime", "(J)V", "getElementId", "()I", "firstOnScreenCost", "getFirstOnScreenCost", "setFirstOnScreenCost", "(I)V", "hasRendered", "", "getHasRendered", "()Z", "setHasRendered", "(Z)V", "isClientContextStarted", "setClientContextStarted", "jsInitCost", "getJsInitCost", "setJsInitCost", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "toString", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public boolean Wmn;
    public boolean Wmo;
    private final int cMj;
    public long createTime;
    private final String rzx;
    
    public a(long paramLong, int paramInt, String paramString)
    {
      AppMethodBeat.i(266789);
      this.createTime = paramLong;
      this.cMj = paramInt;
      this.rzx = paramString;
      this.Wmo = true;
      AppMethodBeat.o(266789);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(266807);
      if (this == paramObject)
      {
        AppMethodBeat.o(266807);
        return true;
      }
      if (!(paramObject instanceof a))
      {
        AppMethodBeat.o(266807);
        return false;
      }
      paramObject = (a)paramObject;
      if (this.createTime != paramObject.createTime)
      {
        AppMethodBeat.o(266807);
        return false;
      }
      if (this.cMj != paramObject.cMj)
      {
        AppMethodBeat.o(266807);
        return false;
      }
      if (!s.p(this.rzx, paramObject.rzx))
      {
        AppMethodBeat.o(266807);
        return false;
      }
      AppMethodBeat.o(266807);
      return true;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(266804);
      int i = q.a..ExternalSyntheticBackport0.m(this.createTime);
      int j = this.cMj;
      int k = this.rzx.hashCode();
      AppMethodBeat.o(266804);
      return (i * 31 + j) * 31 + k;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(266796);
      String str = "BindInfo(createTime=" + this.createTime + ", elementId=" + this.cMj + ", canvasId=" + this.rzx + ')';
      AppMethodBeat.o(266796);
      return str;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webjsengine/WebCanvasPerformanceReporter$Companion;", "", "()V", "SPLITOR", "", "TAG", "kvWebCanvasCreate", "", "kvWebCanvasMainContextInit", "kvWebCanvasRender", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webjsengine/WebCanvasPerformanceReporter$CreateInfo;", "", "createTime", "", "isMainContextStarted", "", "(JZ)V", "configClientCost", "", "getConfigClientCost", "()I", "setConfigClientCost", "(I)V", "getCreateTime", "()J", "setCreateTime", "(J)V", "isClientContextStarted", "()Z", "setClientContextStarted", "(Z)V", "component1", "component2", "copy", "equals", "other", "hashCode", "toString", "", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
  {
    public final boolean Wme;
    public boolean Wmo;
    public int Wmp;
    private long createTime;
    
    public c(long paramLong, boolean paramBoolean)
    {
      this.createTime = paramLong;
      this.Wme = paramBoolean;
    }
    
    public final boolean equals(Object paramObject)
    {
      if (this == paramObject) {}
      do
      {
        return true;
        if (!(paramObject instanceof c)) {
          return false;
        }
        paramObject = (c)paramObject;
        if (this.createTime != paramObject.createTime) {
          return false;
        }
      } while (this.Wme == paramObject.Wme);
      return false;
    }
    
    public final int hashCode()
    {
      throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
    
    public final String toString()
    {
      AppMethodBeat.i(266790);
      String str = "CreateInfo(createTime=" + this.createTime + ", isMainContextStarted=" + this.Wme + ')';
      AppMethodBeat.o(266790);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.ay.b
 * JD-Core Version:    0.7.0.1
 */