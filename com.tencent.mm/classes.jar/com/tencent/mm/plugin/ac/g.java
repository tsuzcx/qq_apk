package com.tencent.mm.plugin.ac;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webjsengine/WebJsEngineReporter;", "", "reportId", "", "(J)V", "baseReportId", "getReportId", "()J", "report", "", "item", "Lcom/tencent/mm/plugin/webjsengine/WebJsEngineReporter$ReportItem;", "ClientContextErr", "ClientContextJsErr", "ClientContextStart", "ClientContextSucc", "EngineContextErr", "EngineContextJsErr", "EngineContextStart", "EngineContextSucc", "IsolateStart", "IsolateSucc", "MainContextErr", "MainContextJsErr", "MainContextStart", "MainContextSucc", "ReportItem", "webview-sdk_release"})
public final class g
{
  private final long IBA = 1476L;
  private final long IBJ = 1477L;
  
  public final void a(o paramo)
  {
    AppMethodBeat.i(224903);
    p.h(paramo, "item");
    h.CyF.F(this.IBA, paramo.value);
    h.CyF.F(this.IBJ, paramo.value);
    AppMethodBeat.o(224903);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webjsengine/WebJsEngineReporter$ClientContextErr;", "Lcom/tencent/mm/plugin/webjsengine/WebJsEngineReporter$ReportItem;", "()V", "webview-sdk_release"})
  public static final class a
    extends g.o
  {
    public a()
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webjsengine/WebJsEngineReporter$ClientContextJsErr;", "Lcom/tencent/mm/plugin/webjsengine/WebJsEngineReporter$ReportItem;", "()V", "webview-sdk_release"})
  public static final class b
    extends g.o
  {
    public b()
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webjsengine/WebJsEngineReporter$ClientContextStart;", "Lcom/tencent/mm/plugin/webjsengine/WebJsEngineReporter$ReportItem;", "()V", "webview-sdk_release"})
  public static final class c
    extends g.o
  {
    public c()
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webjsengine/WebJsEngineReporter$ClientContextSucc;", "Lcom/tencent/mm/plugin/webjsengine/WebJsEngineReporter$ReportItem;", "()V", "webview-sdk_release"})
  public static final class d
    extends g.o
  {
    public d()
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webjsengine/WebJsEngineReporter$EngineContextErr;", "Lcom/tencent/mm/plugin/webjsengine/WebJsEngineReporter$ReportItem;", "()V", "webview-sdk_release"})
  public static final class e
    extends g.o
  {
    public e()
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webjsengine/WebJsEngineReporter$EngineContextJsErr;", "Lcom/tencent/mm/plugin/webjsengine/WebJsEngineReporter$ReportItem;", "()V", "webview-sdk_release"})
  public static final class f
    extends g.o
  {
    public f()
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webjsengine/WebJsEngineReporter$EngineContextStart;", "Lcom/tencent/mm/plugin/webjsengine/WebJsEngineReporter$ReportItem;", "()V", "webview-sdk_release"})
  public static final class g
    extends g.o
  {
    public g()
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webjsengine/WebJsEngineReporter$EngineContextSucc;", "Lcom/tencent/mm/plugin/webjsengine/WebJsEngineReporter$ReportItem;", "()V", "webview-sdk_release"})
  public static final class h
    extends g.o
  {
    public h()
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webjsengine/WebJsEngineReporter$IsolateStart;", "Lcom/tencent/mm/plugin/webjsengine/WebJsEngineReporter$ReportItem;", "()V", "webview-sdk_release"})
  public static final class i
    extends g.o
  {
    public i()
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webjsengine/WebJsEngineReporter$IsolateSucc;", "Lcom/tencent/mm/plugin/webjsengine/WebJsEngineReporter$ReportItem;", "()V", "webview-sdk_release"})
  public static final class j
    extends g.o
  {
    public j()
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webjsengine/WebJsEngineReporter$MainContextErr;", "Lcom/tencent/mm/plugin/webjsengine/WebJsEngineReporter$ReportItem;", "()V", "webview-sdk_release"})
  public static final class k
    extends g.o
  {
    public k()
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webjsengine/WebJsEngineReporter$MainContextJsErr;", "Lcom/tencent/mm/plugin/webjsengine/WebJsEngineReporter$ReportItem;", "()V", "webview-sdk_release"})
  public static final class l
    extends g.o
  {
    public l()
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webjsengine/WebJsEngineReporter$MainContextStart;", "Lcom/tencent/mm/plugin/webjsengine/WebJsEngineReporter$ReportItem;", "()V", "webview-sdk_release"})
  public static final class m
    extends g.o
  {
    public m()
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webjsengine/WebJsEngineReporter$MainContextSucc;", "Lcom/tencent/mm/plugin/webjsengine/WebJsEngineReporter$ReportItem;", "()V", "webview-sdk_release"})
  public static final class n
    extends g.o
  {
    public n()
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webjsengine/WebJsEngineReporter$ReportItem;", "", "value", "", "(J)V", "getValue", "()J", "webview-sdk_release"})
  public static abstract class o
  {
    final long value;
    
    public o(long paramLong)
    {
      this.value = paramLong;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ac.g
 * JD-Core Version:    0.7.0.1
 */