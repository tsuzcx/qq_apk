package com.tencent.mm.plugin.appbrand.jsapi;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.d;

public final class cd
  extends a<d>
{
  public static final int CTRL_INDEX = 215;
  public static final String NAME = "updatePerfData";
  private static final SparseArray<Integer> kan;
  
  static
  {
    AppMethodBeat.i(147147);
    SparseArray localSparseArray = new SparseArray();
    kan = localSparseArray;
    localSparseArray.put("firstRenderTime".hashCode(), Integer.valueOf(301));
    kan.put("reRenderTime".hashCode(), Integer.valueOf(302));
    kan.put("webview2AppServiceTotalTime".hashCode(), Integer.valueOf(402));
    kan.put("webview2AppServiceDataSize".hashCode(), Integer.valueOf(403));
    kan.put("webview2AppServiceNativeTime".hashCode(), Integer.valueOf(404));
    kan.put("appService2WebviewTotalTime".hashCode(), Integer.valueOf(405));
    kan.put("appService2WebviewDataSize".hashCode(), Integer.valueOf(406));
    kan.put("appService2WebviewNativeTime".hashCode(), Integer.valueOf(407));
    AppMethodBeat.o(147147);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.cd
 * JD-Core Version:    0.7.0.1
 */