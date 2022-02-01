package com.tencent.mm.plugin.ac;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;
import d.g.b.p;
import d.l;
import d.n.n;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/webjsengine/WebCanvasPerformanceReporter;", "", "reportId", "", "initStartTime", "appId", "", "(JJLjava/lang/String;)V", "getAppId", "()Ljava/lang/String;", "baseReportId", "bindStartTimeMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/plugin/webjsengine/WebCanvasPerformanceReporter$BindInfo;", "configCost", "configStartTime", "getConfigStartTime", "()J", "setConfigStartTime", "(J)V", "createStartTimeMap", "Lcom/tencent/mm/plugin/webjsengine/WebCanvasPerformanceReporter$CreateInfo;", "isMainContextStarted", "", "()Z", "setMainContextStarted", "(Z)V", "lastCreateStartTime", "magicBrushInitCost", "magicBrushInitStartTime", "getReportId", "addBindStartTime", "", "canvasId", "id", "addCreateStartTime", "elementId", "startTime", "onBasePkgRead", "duration", "onBizPkgRead", "onClientContextReady", "onConfigClientEnd", "onConfigEnd", "onConfigStart", "onJsInit", "info", "timeCost", "onMagicBrushInit", "onMagicBrushInitStart", "onMainContextReady", "onRafInit", "onScreen", "performance", "key", "report", "value", "reportWebCanvasRender", "resetBindStartTime", "canvasElementId", "BindInfo", "Companion", "CreateInfo", "webview-sdk_release"})
public final class b
{
  public static final b DRL;
  private final long DRB;
  public volatile boolean DRC;
  public long DRD;
  public final ConcurrentHashMap<String, c> DRE;
  public final ConcurrentHashMap<Integer, a> DRF;
  public long DRG;
  public long DRH;
  public long DRI;
  public long DRJ;
  private final long DRK;
  public final String appId;
  public final long gDi;
  
  static
  {
    AppMethodBeat.i(214013);
    DRL = new b((byte)0);
    AppMethodBeat.o(214013);
  }
  
  private b(long paramLong, String paramString)
  {
    AppMethodBeat.i(214011);
    this.DRK = 1498L;
    this.gDi = paramLong;
    this.appId = paramString;
    this.DRB = 1497L;
    this.DRE = new ConcurrentHashMap();
    this.DRF = new ConcurrentHashMap();
    this.DRG = System.currentTimeMillis();
    this.DRH = System.currentTimeMillis();
    AppMethodBeat.o(214011);
  }
  
  private final void fE(String paramString, int paramInt)
  {
    AppMethodBeat.i(214007);
    Map localMap = (Map)this.DRF;
    a locala = new a(System.currentTimeMillis(), paramInt, paramString);
    paramString = (c)this.DRE.get(paramString);
    if (paramString != null) {}
    for (boolean bool = paramString.DRP;; bool = false)
    {
      locala.DRP = bool;
      localMap.put(Integer.valueOf(paramInt), locala);
      AppMethodBeat.o(214007);
      return;
    }
  }
  
  public final void L(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(214010);
    g.yxI.n(this.DRB, paramLong1, paramLong2);
    g.yxI.n(this.DRK, paramLong1, paramLong2);
    AppMethodBeat.o(214010);
  }
  
  public final void a(a parama, String paramString, long paramLong)
  {
    AppMethodBeat.i(214009);
    if (!n.nF(paramString, "__popup_canvas__"))
    {
      if (parama.DRM)
      {
        L(74L, 1L);
        L(75L, paramLong);
        if (paramLong < 50L)
        {
          L(80L, 1L);
          AppMethodBeat.o(214009);
          return;
        }
        if (50L > paramLong) {
          if (101L <= paramLong) {
            break label119;
          }
        }
        for (;;)
        {
          if (paramLong > 300L)
          {
            L(83L, 1L);
            AppMethodBeat.o(214009);
            return;
            if (100L < paramLong) {
              break;
            }
            L(81L, 1L);
            AppMethodBeat.o(214009);
            return;
            label119:
            if (300L >= paramLong)
            {
              L(82L, 1L);
              AppMethodBeat.o(214009);
              return;
            }
          }
        }
        AppMethodBeat.o(214009);
        return;
      }
      if (parama.DRP) {
        break label252;
      }
      L(47L, 1L);
      L(48L, paramLong);
      if (50L <= paramLong) {
        break label214;
      }
      if (101L <= paramLong) {
        break label233;
      }
      label186:
      if (paramLong > 300L)
      {
        L(54L, 1L);
        label201:
        break label284;
      }
    }
    for (;;)
    {
      parama.DRO = ((int)paramLong);
      AppMethodBeat.o(214009);
      return;
      label214:
      if (100L < paramLong) {
        break;
      }
      L(52L, 1L);
      continue;
      label233:
      if (300L < paramLong) {
        break label186;
      }
      L(53L, 1L);
      continue;
      label252:
      L(71L, 1L);
      L(72L, paramLong);
      if (50L > paramLong) {}
      for (;;)
      {
        if (101L > paramLong)
        {
          label284:
          if (paramLong <= 300L) {
            break;
          }
          L(79L, 1L);
          break;
          if (100L >= paramLong)
          {
            L(77L, 1L);
            break;
          }
        }
      }
      if (300L < paramLong) {
        break label201;
      }
      L(78L, 1L);
    }
  }
  
  public final void fF(String paramString, int paramInt)
  {
    AppMethodBeat.i(214008);
    p.h(paramString, "canvasId");
    if (!this.DRF.containsKey(Integer.valueOf(paramInt))) {
      fE(paramString, paramInt);
    }
    a locala = (a)this.DRF.get(Integer.valueOf(paramInt));
    if (locala != null)
    {
      if (locala.DRM) {
        locala.createTime = System.currentTimeMillis();
      }
      paramString = (c)this.DRE.get(paramString);
      if (paramString != null) {}
      for (boolean bool = paramString.DRP;; bool = false)
      {
        locala.DRP = bool;
        AppMethodBeat.o(214008);
        return;
      }
    }
    AppMethodBeat.o(214008);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/webjsengine/WebCanvasPerformanceReporter$BindInfo;", "", "createTime", "", "elementId", "", "canvasId", "", "(JILjava/lang/String;)V", "getCanvasId", "()Ljava/lang/String;", "getCreateTime", "()J", "setCreateTime", "(J)V", "getElementId", "()I", "firstOnScreenCost", "getFirstOnScreenCost", "setFirstOnScreenCost", "(I)V", "hasRendered", "", "getHasRendered", "()Z", "setHasRendered", "(Z)V", "isClientContextStarted", "setClientContextStarted", "jsInitCost", "getJsInitCost", "setJsInitCost", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "toString", "webview-sdk_release"})
  public static final class a
  {
    public boolean DRM;
    public int DRN;
    public int DRO;
    public boolean DRP;
    private final int biM;
    public long createTime;
    private final String kwD;
    
    public a(long paramLong, int paramInt, String paramString)
    {
      AppMethodBeat.i(214002);
      this.createTime = paramLong;
      this.biM = paramInt;
      this.kwD = paramString;
      this.DRP = true;
      AppMethodBeat.o(214002);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(214005);
      if (this != paramObject)
      {
        if ((paramObject instanceof a))
        {
          paramObject = (a)paramObject;
          if ((this.createTime != paramObject.createTime) || (this.biM != paramObject.biM) || (!p.i(this.kwD, paramObject.kwD))) {}
        }
      }
      else
      {
        AppMethodBeat.o(214005);
        return true;
      }
      AppMethodBeat.o(214005);
      return false;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(214004);
      long l = this.createTime;
      int j = (int)(l ^ l >>> 32);
      int k = this.biM;
      String str = this.kwD;
      if (str != null) {}
      for (int i = str.hashCode();; i = 0)
      {
        AppMethodBeat.o(214004);
        return i + (j * 31 + k) * 31;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(214003);
      String str = "BindInfo(createTime=" + this.createTime + ", elementId=" + this.biM + ", canvasId=" + this.kwD + ")";
      AppMethodBeat.o(214003);
      return str;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/webjsengine/WebCanvasPerformanceReporter$Companion;", "", "()V", "SPLITOR", "", "TAG", "kvWebCanvasCreate", "", "kvWebCanvasMainContextInit", "kvWebCanvasRender", "webview-sdk_release"})
  public static final class b {}
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/webjsengine/WebCanvasPerformanceReporter$CreateInfo;", "", "createTime", "", "isMainContextStarted", "", "elementId", "", "(JZI)V", "configClientCost", "getConfigClientCost", "()I", "setConfigClientCost", "(I)V", "getCreateTime", "()J", "setCreateTime", "(J)V", "getElementId", "isClientContextStarted", "()Z", "setClientContextStarted", "(Z)V", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "toString", "", "webview-sdk_release"})
  public static final class c
  {
    public final boolean DRC;
    public boolean DRP;
    public int DRQ;
    private final int biM;
    public long createTime;
    
    public c(long paramLong, boolean paramBoolean, int paramInt)
    {
      this.createTime = paramLong;
      this.DRC = paramBoolean;
      this.biM = paramInt;
    }
    
    public final boolean equals(Object paramObject)
    {
      if (this != paramObject)
      {
        if ((paramObject instanceof c))
        {
          paramObject = (c)paramObject;
          if ((this.createTime != paramObject.createTime) || (this.DRC != paramObject.DRC) || (this.biM != paramObject.biM)) {}
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
      AppMethodBeat.i(214006);
      String str = "CreateInfo(createTime=" + this.createTime + ", isMainContextStarted=" + this.DRC + ", elementId=" + this.biM + ")";
      AppMethodBeat.o(214006);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.ac.b
 * JD-Core Version:    0.7.0.1
 */