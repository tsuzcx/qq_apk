package com.tencent.mm.plugin.appbrand.jsapi;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.d;

public final class cg
  extends a<d>
{
  public static final int CTRL_INDEX = 215;
  public static final String NAME = "updatePerfData";
  private static final SparseArray<Integer> kuJ;
  
  static
  {
    AppMethodBeat.i(147147);
    SparseArray localSparseArray = new SparseArray();
    kuJ = localSparseArray;
    localSparseArray.put("firstRenderTime".hashCode(), Integer.valueOf(301));
    kuJ.put("reRenderTime".hashCode(), Integer.valueOf(302));
    kuJ.put("webview2AppServiceTotalTime".hashCode(), Integer.valueOf(402));
    kuJ.put("webview2AppServiceDataSize".hashCode(), Integer.valueOf(403));
    kuJ.put("webview2AppServiceNativeTime".hashCode(), Integer.valueOf(404));
    kuJ.put("appService2WebviewTotalTime".hashCode(), Integer.valueOf(405));
    kuJ.put("appService2WebviewDataSize".hashCode(), Integer.valueOf(406));
    kuJ.put("appService2WebviewNativeTime".hashCode(), Integer.valueOf(407));
    AppMethodBeat.o(147147);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.cg
 * JD-Core Version:    0.7.0.1
 */