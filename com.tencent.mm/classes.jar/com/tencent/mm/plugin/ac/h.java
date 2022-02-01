package com.tencent.mm.plugin.ac;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/webjsengine/WebJsEngineContextReporter;", "", "reportId", "", "type", "Lcom/tencent/mm/plugin/webjsengine/WebJsEngineContextReporter$Type;", "(JLcom/tencent/mm/plugin/webjsengine/WebJsEngineContextReporter$Type;)V", "baseReportId", "getReportId", "()J", "getType", "()Lcom/tencent/mm/plugin/webjsengine/WebJsEngineContextReporter$Type;", "report", "", "item", "Lcom/tencent/mm/plugin/webjsengine/WebJsEngineContextReporter$ReportItem;", "ContextConfigErr", "ContextDependenceErr", "ContextErr", "ContextJSAPIErr", "ContextJsErr", "ContextLibErr", "ContextScriptErr", "ContextStart", "ContextSucc", "ContextValidErr", "ReportItem", "Type", "webview-sdk_release"})
public final class h
{
  private final long DRB;
  private final long DRK;
  final j DSo;
  
  public h(long paramLong, j paramj)
  {
    AppMethodBeat.i(214042);
    this.DRK = paramLong;
    this.DSo = paramj;
    this.DRB = 1478L;
    AppMethodBeat.o(214042);
  }
  
  public final void a(i parami)
  {
    AppMethodBeat.i(214041);
    p.h(parami, "item");
    g.yxI.A(this.DRB, parami.value);
    g.yxI.A(this.DRK, parami.value);
    AppMethodBeat.o(214041);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/webjsengine/WebJsEngineContextReporter$ContextDependenceErr;", "Lcom/tencent/mm/plugin/webjsengine/WebJsEngineContextReporter$ReportItem;", "()V", "webview-sdk_release"})
  public static final class a
    extends h.i
  {
    public a()
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/webjsengine/WebJsEngineContextReporter$ContextErr;", "Lcom/tencent/mm/plugin/webjsengine/WebJsEngineContextReporter$ReportItem;", "()V", "webview-sdk_release"})
  public static final class b
    extends h.i
  {
    public b()
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/webjsengine/WebJsEngineContextReporter$ContextJSAPIErr;", "Lcom/tencent/mm/plugin/webjsengine/WebJsEngineContextReporter$ReportItem;", "()V", "webview-sdk_release"})
  public static final class c
    extends h.i
  {
    public c()
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/webjsengine/WebJsEngineContextReporter$ContextJsErr;", "Lcom/tencent/mm/plugin/webjsengine/WebJsEngineContextReporter$ReportItem;", "()V", "webview-sdk_release"})
  public static final class d
    extends h.i
  {
    public d()
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/webjsengine/WebJsEngineContextReporter$ContextLibErr;", "Lcom/tencent/mm/plugin/webjsengine/WebJsEngineContextReporter$ReportItem;", "()V", "webview-sdk_release"})
  public static final class e
    extends h.i
  {
    public e()
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/webjsengine/WebJsEngineContextReporter$ContextScriptErr;", "Lcom/tencent/mm/plugin/webjsengine/WebJsEngineContextReporter$ReportItem;", "()V", "webview-sdk_release"})
  public static final class f
    extends h.i
  {
    public f()
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/webjsengine/WebJsEngineContextReporter$ContextStart;", "Lcom/tencent/mm/plugin/webjsengine/WebJsEngineContextReporter$ReportItem;", "()V", "webview-sdk_release"})
  public static final class g
    extends h.i
  {
    public g()
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/webjsengine/WebJsEngineContextReporter$ContextSucc;", "Lcom/tencent/mm/plugin/webjsengine/WebJsEngineContextReporter$ReportItem;", "()V", "webview-sdk_release"})
  public static final class h
    extends h.i
  {
    public h()
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/webjsengine/WebJsEngineContextReporter$ReportItem;", "", "value", "", "(J)V", "getValue", "()J", "webview-sdk_release"})
  public static abstract class i
  {
    final long value;
    
    public i(long paramLong)
    {
      this.value = paramLong;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/webjsengine/WebJsEngineContextReporter$Type;", "", "(Ljava/lang/String;I)V", "Main", "Engine", "Client", "webview-sdk_release"})
  public static enum j
  {
    static
    {
      AppMethodBeat.i(214038);
      j localj1 = new j("Main", 0);
      DSp = localj1;
      j localj2 = new j("Engine", 1);
      DSq = localj2;
      j localj3 = new j("Client", 2);
      DSr = localj3;
      DSs = new j[] { localj1, localj2, localj3 };
      AppMethodBeat.o(214038);
    }
    
    private j() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.ac.h
 * JD-Core Version:    0.7.0.1
 */