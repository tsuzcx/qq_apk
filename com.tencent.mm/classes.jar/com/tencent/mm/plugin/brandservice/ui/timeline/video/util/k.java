package com.tencent.mm.plugin.brandservice.ui.timeline.video.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.gh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.LinkedList<Lcom.tencent.mm.protocal.protobuf.gh;>;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoResolutionHelper;", "", "()V", "TAG", "", "getInitResolution", "Lcom/tencent/mm/protocal/protobuf/AppMsgVideoUrlInfo;", "urlInfoList", "Ljava/util/LinkedList;", "getLastResolution", "", "setLastResolution", "", "type", "plugin-brandservice_release"})
public final class k
{
  private static final String TAG = "MicroMsg.BizVideoResolutionHelper";
  public static final k pLx;
  
  static
  {
    AppMethodBeat.i(7310);
    pLx = new k();
    TAG = "MicroMsg.BizVideoResolutionHelper";
    AppMethodBeat.o(7310);
  }
  
  public static final void DP(int paramInt)
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
  
  public static final gh K(LinkedList<gh> paramLinkedList)
  {
    AppMethodBeat.i(7308);
    p.h(paramLinkedList, "urlInfoList");
    if (Util.isNullOrNil((List)paramLinkedList))
    {
      AppMethodBeat.o(7308);
      return null;
    }
    Object localObject = MultiProcessMMKV.getMMKV(TAG);
    if (localObject != null) {}
    for (int i = ((MultiProcessMMKV)localObject).decodeInt("LastResolutionType", -1);; i = -1)
    {
      Log.i(TAG, "getInitResolution ".concat(String.valueOf(i)));
      localObject = paramLinkedList.get(0);
      p.g(localObject, "urlInfoList[0]");
      localObject = (gh)localObject;
      if (i != -1) {
        break;
      }
      AppMethodBeat.o(7308);
      return localObject;
    }
    Iterator localIterator = paramLinkedList.iterator();
    paramLinkedList = (LinkedList<gh>)localObject;
    if (localIterator.hasNext())
    {
      localObject = (gh)localIterator.next();
      if ((((gh)localObject).KKg > i) || ((paramLinkedList.KKg < i) && (paramLinkedList.KKg >= ((gh)localObject).KKg))) {
        break label181;
      }
      p.g(localObject, "info");
      paramLinkedList = (LinkedList<gh>)localObject;
      if (((gh)localObject).KKg != i) {
        paramLinkedList = (LinkedList<gh>)localObject;
      }
    }
    label181:
    for (;;)
    {
      break;
      AppMethodBeat.o(7308);
      return paramLinkedList;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.video.util.k
 * JD-Core Version:    0.7.0.1
 */