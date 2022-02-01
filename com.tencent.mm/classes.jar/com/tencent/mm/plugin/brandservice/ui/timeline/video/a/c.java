package com.tencent.mm.plugin.brandservice.ui.timeline.video.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoResolutionHelper;", "", "()V", "TAG", "", "getInitResolution", "Lcom/tencent/mm/protocal/protobuf/AppMsgVideoUrlInfo;", "urlInfoList", "Ljava/util/LinkedList;", "getLastResolution", "", "setLastResolution", "", "type", "plugin-brandservice_release"})
public final class c
{
  private static final String TAG = "MicroMsg.BizVideoResolutionHelper";
  public static final c sTc;
  
  static
  {
    AppMethodBeat.i(7310);
    sTc = new c();
    TAG = "MicroMsg.BizVideoResolutionHelper";
    AppMethodBeat.o(7310);
  }
  
  public static final void Hr(int paramInt)
  {
    AppMethodBeat.i(7309);
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV(TAG);
    if (localMultiProcessMMKV != null) {
      localMultiProcessMMKV.encode("LastResolutionType", paramInt);
    }
    if (localMultiProcessMMKV != null) {
      localMultiProcessMMKV.encode("LastResolutionTime", System.currentTimeMillis());
    }
    Log.i(TAG, "LastResolutionType ".concat(String.valueOf(paramInt)));
    AppMethodBeat.o(7309);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.video.a.c
 * JD-Core Version:    0.7.0.1
 */