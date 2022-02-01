package com.tencent.mm.plugin.ay;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webjsengine/WebJsEngineContextReporter;", "", "reportId", "", "type", "Lcom/tencent/mm/plugin/webjsengine/WebJsEngineContextReporter$Type;", "(JLcom/tencent/mm/plugin/webjsengine/WebJsEngineContextReporter$Type;)V", "baseReportId", "getReportId", "()J", "getType", "()Lcom/tencent/mm/plugin/webjsengine/WebJsEngineContextReporter$Type;", "report", "", "item", "Lcom/tencent/mm/plugin/webjsengine/WebJsEngineContextReporter$ReportItem;", "ContextConfigErr", "ContextDependenceErr", "ContextErr", "ContextJSAPIErr", "ContextJsErr", "ContextLibErr", "ContextScriptErr", "ContextStart", "ContextSucc", "ContextValidErr", "ReportItem", "Type", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
{
  final j WmN;
  private final long Wmc;
  private final long Wmd;
  
  public d(long paramLong, j paramj)
  {
    AppMethodBeat.i(266812);
    this.Wmc = paramLong;
    this.WmN = paramj;
    this.Wmd = 1478L;
    AppMethodBeat.o(266812);
  }
  
  public final void a(i parami)
  {
    AppMethodBeat.i(266818);
    s.u(parami, "item");
    h.OAn.p(this.Wmd, parami.value, 1L);
    if (this.Wmc > 0L) {
      h.OAn.p(this.Wmc, parami.value, 1L);
    }
    AppMethodBeat.o(266818);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webjsengine/WebJsEngineContextReporter$ContextDependenceErr;", "Lcom/tencent/mm/plugin/webjsengine/WebJsEngineContextReporter$ReportItem;", "()V", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    extends d.i
  {
    public a()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webjsengine/WebJsEngineContextReporter$ContextErr;", "Lcom/tencent/mm/plugin/webjsengine/WebJsEngineContextReporter$ReportItem;", "()V", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends d.i
  {
    public b()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webjsengine/WebJsEngineContextReporter$ContextJSAPIErr;", "Lcom/tencent/mm/plugin/webjsengine/WebJsEngineContextReporter$ReportItem;", "()V", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    extends d.i
  {
    public c()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webjsengine/WebJsEngineContextReporter$ContextJsErr;", "Lcom/tencent/mm/plugin/webjsengine/WebJsEngineContextReporter$ReportItem;", "()V", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    extends d.i
  {
    public d()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webjsengine/WebJsEngineContextReporter$ContextLibErr;", "Lcom/tencent/mm/plugin/webjsengine/WebJsEngineContextReporter$ReportItem;", "()V", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    extends d.i
  {
    public e()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webjsengine/WebJsEngineContextReporter$ContextScriptErr;", "Lcom/tencent/mm/plugin/webjsengine/WebJsEngineContextReporter$ReportItem;", "()V", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class f
    extends d.i
  {
    public f()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webjsengine/WebJsEngineContextReporter$ContextStart;", "Lcom/tencent/mm/plugin/webjsengine/WebJsEngineContextReporter$ReportItem;", "()V", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class g
    extends d.i
  {
    public g()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webjsengine/WebJsEngineContextReporter$ContextSucc;", "Lcom/tencent/mm/plugin/webjsengine/WebJsEngineContextReporter$ReportItem;", "()V", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class h
    extends d.i
  {
    public h()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webjsengine/WebJsEngineContextReporter$ReportItem;", "", "value", "", "(J)V", "getValue", "()J", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract class i
  {
    final long value;
    
    public i(long paramLong)
    {
      this.value = paramLong;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webjsengine/WebJsEngineContextReporter$Type;", "", "(Ljava/lang/String;I)V", "Main", "Engine", "Client", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum j
  {
    static
    {
      AppMethodBeat.i(266772);
      WmO = new j("Main", 0);
      WmP = new j("Engine", 1);
      WmQ = new j("Client", 2);
      WmR = new j[] { WmO, WmP, WmQ };
      AppMethodBeat.o(266772);
    }
    
    private j() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.ay.d
 * JD-Core Version:    0.7.0.1
 */