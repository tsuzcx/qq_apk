package com.tencent.mm.plugin.appbrand.jsapi;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.d;

public final class bq
  extends a<d>
{
  public static final int CTRL_INDEX = 215;
  public static final String NAME = "updatePerfData";
  private static final SparseArray<Integer> hAs;
  
  static
  {
    AppMethodBeat.i(101957);
    SparseArray localSparseArray = new SparseArray();
    hAs = localSparseArray;
    localSparseArray.put("firstRenderTime".hashCode(), Integer.valueOf(301));
    hAs.put("reRenderTime".hashCode(), Integer.valueOf(302));
    hAs.put("webview2AppServiceTotalTime".hashCode(), Integer.valueOf(402));
    hAs.put("webview2AppServiceDataSize".hashCode(), Integer.valueOf(403));
    hAs.put("webview2AppServiceNativeTime".hashCode(), Integer.valueOf(404));
    hAs.put("appService2WebviewTotalTime".hashCode(), Integer.valueOf(405));
    hAs.put("appService2WebviewDataSize".hashCode(), Integer.valueOf(406));
    hAs.put("appService2WebviewNativeTime".hashCode(), Integer.valueOf(407));
    AppMethodBeat.o(101957);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bq
 * JD-Core Version:    0.7.0.1
 */