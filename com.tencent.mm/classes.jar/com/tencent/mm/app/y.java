package com.tencent.mm.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.report.PluginReport;
import com.tencent.mm.plugin.zero.PluginZero;
import com.tencent.mm.plugin.zero.a.d;

public final class y
  extends k
{
  public final void aBZ()
  {
    AppMethodBeat.i(239316);
    h.baA().mCA = d.class;
    aD(PluginZero.class);
    aD(PluginReport.class);
    FF("com.tencent.mm.plugin.abtest.PluginABTest");
    FF("com.tencent.mm.plugin.hook.PluginHook");
    FF("com.tencent.mm.plugin.sensitive_api_check.Plugin");
    FF("com.tencent.mm.sensitive.PluginSensitive");
    FF("com.tencent.mm.plugin.expt.PluginExpt");
    FF("com.tencent.mm.plugin.expansions.PluginExpansions");
    FG("com.tencent.mm.plugin.performance.PluginPerformance");
    FG("com.tencent.mm.plugin.appbrand.app.PluginAppBrand");
    FG("com.tencent.mm.plugin.normsg.PluginNormsg");
    FG("com.tencent.mm.gpu.PluginGpuRes");
    FG("com.tencent.mm.plugin.crashfix.PluginSystemCrashFix");
    FG("com.tencent.mm.wlogcat.PluginLogcat");
    AppMethodBeat.o(239316);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.app.y
 * JD-Core Version:    0.7.0.1
 */