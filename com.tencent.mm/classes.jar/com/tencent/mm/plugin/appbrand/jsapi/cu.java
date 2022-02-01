package com.tencent.mm.plugin.appbrand.jsapi;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cu
  extends d<com.tencent.mm.plugin.appbrand.d>
{
  public static final int CTRL_INDEX = 215;
  public static final String NAME = "updatePerfData";
  private static final SparseArray<Integer> lCm;
  
  static
  {
    AppMethodBeat.i(147147);
    SparseArray localSparseArray = new SparseArray();
    lCm = localSparseArray;
    localSparseArray.put("firstRenderTime".hashCode(), Integer.valueOf(301));
    lCm.put("reRenderTime".hashCode(), Integer.valueOf(302));
    lCm.put("webview2AppServiceTotalTime".hashCode(), Integer.valueOf(402));
    lCm.put("webview2AppServiceDataSize".hashCode(), Integer.valueOf(403));
    lCm.put("webview2AppServiceNativeTime".hashCode(), Integer.valueOf(404));
    lCm.put("appService2WebviewTotalTime".hashCode(), Integer.valueOf(405));
    lCm.put("appService2WebviewDataSize".hashCode(), Integer.valueOf(406));
    lCm.put("appService2WebviewNativeTime".hashCode(), Integer.valueOf(407));
    AppMethodBeat.o(147147);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.cu
 * JD-Core Version:    0.7.0.1
 */