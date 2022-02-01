package com.tencent.mm.plugin.finder.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/report/FinderShareReporter;", "", "()V", "report21673", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "eventCode", "", "eventTime", "", "index", "report21856", "Companion", "plugin-finder_release"})
public final class m
{
  private static final m vfC;
  public static final a vfD;
  
  static
  {
    AppMethodBeat.i(250712);
    vfD = new a((byte)0);
    vfC = new m();
    AppMethodBeat.o(250712);
  }
  
  public static void a(bbn parambbn, int paramInt, long paramLong)
  {
    AppMethodBeat.i(250711);
    if (parambbn != null)
    {
      Log.i("Finder.FinderShareReporter", "FinderShareReporter.report21856, sessionId = " + parambbn.sessionId + ", clickTabContextId = " + parambbn.sGE + ", contextId = " + parambbn.sGQ + ", commentScene = " + parambbn.tCE + ", eventCode = " + paramInt + ", eventTime = " + paramLong);
      h.CyF.a(21856, new Object[] { parambbn.sessionId, parambbn.sGE, parambbn.sGQ, Integer.valueOf(parambbn.tCE), Integer.valueOf(paramInt), Long.valueOf(paramLong) });
    }
    AppMethodBeat.o(250711);
  }
  
  public static void a(bbn parambbn, int paramInt1, long paramLong, int paramInt2)
  {
    AppMethodBeat.i(250710);
    if (parambbn != null)
    {
      Log.i("Finder.FinderShareReporter", "FinderShareReporter.report21673, sessionId = " + parambbn.sessionId + ", clickTabContextId = " + parambbn.sGE + ", contextId = " + parambbn.sGQ + ", commentScene = " + parambbn.tCE + ", eventCode = " + paramInt1 + ", eventTime = " + paramLong + ", index = " + paramInt2);
      h.CyF.a(21673, new Object[] { parambbn.sessionId, parambbn.sGE, parambbn.sGQ, Integer.valueOf(parambbn.tCE), Integer.valueOf(paramInt1), Long.valueOf(paramLong), Integer.valueOf(paramInt2) });
    }
    AppMethodBeat.o(250710);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/report/FinderShareReporter$Companion;", "", "()V", "EVENT_CODE_CLICK", "", "EVENT_CODE_SHOW", "EVENT_EXPOSE_ANIMATION", "EVENT_EXPOSE_STATIC", "INSTANCE", "Lcom/tencent/mm/plugin/finder/report/FinderShareReporter;", "getINSTANCE", "()Lcom/tencent/mm/plugin/finder/report/FinderShareReporter;", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.m
 * JD-Core Version:    0.7.0.1
 */