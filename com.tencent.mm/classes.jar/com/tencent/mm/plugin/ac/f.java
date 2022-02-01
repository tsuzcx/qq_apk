package com.tencent.mm.plugin.ac;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/webjsengine/WebJsEngineContextReporter;", "", "reportId", "", "type", "Lcom/tencent/mm/plugin/webjsengine/WebJsEngineContextReporter$Type;", "(JLcom/tencent/mm/plugin/webjsengine/WebJsEngineContextReporter$Type;)V", "baseReportId", "getReportId", "()J", "getType", "()Lcom/tencent/mm/plugin/webjsengine/WebJsEngineContextReporter$Type;", "report", "", "item", "Lcom/tencent/mm/plugin/webjsengine/WebJsEngineContextReporter$ReportItem;", "ContextConfigErr", "ContextDependenceErr", "ContextErr", "ContextJSAPIErr", "ContextJsErr", "ContextLibErr", "ContextScriptErr", "ContextStart", "ContextSucc", "ContextValidErr", "ReportItem", "Type", "webview-sdk_release"})
public final class f
{
  private final long DAp;
  private final long DAq;
  final j DAr;
  
  public f(long paramLong, j paramj)
  {
    AppMethodBeat.i(214202);
    this.DAq = paramLong;
    this.DAr = paramj;
    this.DAp = 1478L;
    AppMethodBeat.o(214202);
  }
  
  public final void a(i parami)
  {
    AppMethodBeat.i(214201);
    p.h(parami, "item");
    g.yhR.A(this.DAp, parami.value);
    g.yhR.A(this.DAq, parami.value);
    AppMethodBeat.o(214201);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/webjsengine/WebJsEngineContextReporter$ContextDependenceErr;", "Lcom/tencent/mm/plugin/webjsengine/WebJsEngineContextReporter$ReportItem;", "()V", "webview-sdk_release"})
  public static final class a
    extends f.i
  {
    public a()
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/webjsengine/WebJsEngineContextReporter$ContextErr;", "Lcom/tencent/mm/plugin/webjsengine/WebJsEngineContextReporter$ReportItem;", "()V", "webview-sdk_release"})
  public static final class b
    extends f.i
  {
    public b()
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/webjsengine/WebJsEngineContextReporter$ContextJSAPIErr;", "Lcom/tencent/mm/plugin/webjsengine/WebJsEngineContextReporter$ReportItem;", "()V", "webview-sdk_release"})
  public static final class c
    extends f.i
  {
    public c()
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/webjsengine/WebJsEngineContextReporter$ContextJsErr;", "Lcom/tencent/mm/plugin/webjsengine/WebJsEngineContextReporter$ReportItem;", "()V", "webview-sdk_release"})
  public static final class d
    extends f.i
  {
    public d()
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/webjsengine/WebJsEngineContextReporter$ContextLibErr;", "Lcom/tencent/mm/plugin/webjsengine/WebJsEngineContextReporter$ReportItem;", "()V", "webview-sdk_release"})
  public static final class e
    extends f.i
  {
    public e()
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/webjsengine/WebJsEngineContextReporter$ContextScriptErr;", "Lcom/tencent/mm/plugin/webjsengine/WebJsEngineContextReporter$ReportItem;", "()V", "webview-sdk_release"})
  public static final class f
    extends f.i
  {
    public f()
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/webjsengine/WebJsEngineContextReporter$ContextStart;", "Lcom/tencent/mm/plugin/webjsengine/WebJsEngineContextReporter$ReportItem;", "()V", "webview-sdk_release"})
  public static final class g
    extends f.i
  {
    public g()
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/webjsengine/WebJsEngineContextReporter$ContextSucc;", "Lcom/tencent/mm/plugin/webjsengine/WebJsEngineContextReporter$ReportItem;", "()V", "webview-sdk_release"})
  public static final class h
    extends f.i
  {
    public h()
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/webjsengine/WebJsEngineContextReporter$ReportItem;", "", "value", "", "(J)V", "getValue", "()J", "webview-sdk_release"})
  public static abstract class i
  {
    final long value;
    
    public i(long paramLong)
    {
      this.value = paramLong;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/webjsengine/WebJsEngineContextReporter$Type;", "", "(Ljava/lang/String;I)V", "Main", "Engine", "Client", "webview-sdk_release"})
  public static enum j
  {
    static
    {
      AppMethodBeat.i(214198);
      j localj1 = new j("Main", 0);
      DAs = localj1;
      j localj2 = new j("Engine", 1);
      DAt = localj2;
      j localj3 = new j("Client", 2);
      DAu = localj3;
      DAv = new j[] { localj1, localj2, localj3 };
      AppMethodBeat.o(214198);
    }
    
    private j() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.ac.f
 * JD-Core Version:    0.7.0.1
 */