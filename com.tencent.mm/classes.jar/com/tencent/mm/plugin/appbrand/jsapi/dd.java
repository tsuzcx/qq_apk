package com.tencent.mm.plugin.appbrand.jsapi;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.g;

public final class dd
  extends c<g>
{
  public static final int CTRL_INDEX = 215;
  public static final String NAME = "updatePerfData";
  private static final SparseArray<Integer> rBl;
  
  static
  {
    AppMethodBeat.i(147147);
    SparseArray localSparseArray = new SparseArray();
    rBl = localSparseArray;
    localSparseArray.put("firstRenderTime".hashCode(), Integer.valueOf(301));
    rBl.put("reRenderTime".hashCode(), Integer.valueOf(302));
    rBl.put("webview2AppServiceTotalTime".hashCode(), Integer.valueOf(402));
    rBl.put("webview2AppServiceDataSize".hashCode(), Integer.valueOf(403));
    rBl.put("webview2AppServiceNativeTime".hashCode(), Integer.valueOf(404));
    rBl.put("appService2WebviewTotalTime".hashCode(), Integer.valueOf(405));
    rBl.put("appService2WebviewDataSize".hashCode(), Integer.valueOf(406));
    rBl.put("appService2WebviewNativeTime".hashCode(), Integer.valueOf(407));
    AppMethodBeat.o(147147);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.dd
 * JD-Core Version:    0.7.0.1
 */