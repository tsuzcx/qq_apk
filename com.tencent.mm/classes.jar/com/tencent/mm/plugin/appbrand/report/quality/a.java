package com.tencent.mm.plugin.appbrand.report.quality;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.b.a.pd;
import com.tencent.mm.plugin.appbrand.ui.n;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.BitSet;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/report/quality/AppBrandQualityFlagsReport;", "", "()V", "reportFlags", "", "instanceId", "", "Companion", "plugin-appbrand-integration_release"})
public final class a
{
  private static final BitSet qMy;
  public static final a.a qMz;
  
  static
  {
    AppMethodBeat.i(283100);
    qMz = new a.a((byte)0);
    BitSet localBitSet = new BitSet();
    qMy = localBitSet;
    localBitSet.set(0, n.cka());
    qMy.set(1, n.cjZ());
    AppMethodBeat.o(283100);
  }
  
  public static void amN(String paramString)
  {
    AppMethodBeat.i(283097);
    p.k(paramString, "instanceId");
    pd localpd = new pd();
    localpd.Ga(a.a.getFlags());
    localpd.FZ(paramString);
    Log.d("MicroMsg.AppBrandQualityFlagsReport", "reportFlags: instanceId=" + paramString + ",flags=" + localpd.getFlags());
    localpd.bpa();
    AppMethodBeat.o(283097);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.quality.a
 * JD-Core Version:    0.7.0.1
 */