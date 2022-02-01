package com.tencent.mm.plugin.appbrand.jsapi;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.d;

public final class cd
  extends a<d>
{
  public static final int CTRL_INDEX = 215;
  public static final String NAME = "updatePerfData";
  private static final SparseArray<Integer> jzR;
  
  static
  {
    AppMethodBeat.i(147147);
    SparseArray localSparseArray = new SparseArray();
    jzR = localSparseArray;
    localSparseArray.put("firstRenderTime".hashCode(), Integer.valueOf(301));
    jzR.put("reRenderTime".hashCode(), Integer.valueOf(302));
    jzR.put("webview2AppServiceTotalTime".hashCode(), Integer.valueOf(402));
    jzR.put("webview2AppServiceDataSize".hashCode(), Integer.valueOf(403));
    jzR.put("webview2AppServiceNativeTime".hashCode(), Integer.valueOf(404));
    jzR.put("appService2WebviewTotalTime".hashCode(), Integer.valueOf(405));
    jzR.put("appService2WebviewDataSize".hashCode(), Integer.valueOf(406));
    jzR.put("appService2WebviewNativeTime".hashCode(), Integer.valueOf(407));
    AppMethodBeat.o(147147);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.cd
 * JD-Core Version:    0.7.0.1
 */