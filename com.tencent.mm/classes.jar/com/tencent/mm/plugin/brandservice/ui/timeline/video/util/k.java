package com.tencent.mm.plugin.brandservice.ui.timeline.video.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.fn;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bt;
import d.l;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.LinkedList<Lcom.tencent.mm.protocal.protobuf.fn;>;
import java.util.List;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoResolutionHelper;", "", "()V", "TAG", "", "getInitResolution", "Lcom/tencent/mm/protocal/protobuf/AppMsgVideoUrlInfo;", "urlInfoList", "Ljava/util/LinkedList;", "setLastResolution", "", "type", "", "plugin-brandservice_release"})
public final class k
{
  private static final String TAG = "MicroMsg.BizVideoResolutionHelper";
  public static final k nlR;
  
  static
  {
    AppMethodBeat.i(7310);
    nlR = new k();
    TAG = "MicroMsg.BizVideoResolutionHelper";
    AppMethodBeat.o(7310);
  }
  
  public static final fn I(LinkedList<fn> paramLinkedList)
  {
    AppMethodBeat.i(7308);
    d.g.b.k.h(paramLinkedList, "urlInfoList");
    if (bt.gL((List)paramLinkedList))
    {
      AppMethodBeat.o(7308);
      return null;
    }
    Object localObject = ax.aFC(TAG);
    if (localObject != null) {}
    for (int i = ((ax)localObject).decodeInt("LastResolutionType", -1);; i = -1)
    {
      ad.i(TAG, "getInitResolution ".concat(String.valueOf(i)));
      localObject = paramLinkedList.get(0);
      d.g.b.k.g(localObject, "urlInfoList[0]");
      localObject = (fn)localObject;
      if (i != -1) {
        break;
      }
      AppMethodBeat.o(7308);
      return localObject;
    }
    Iterator localIterator = paramLinkedList.iterator();
    paramLinkedList = (LinkedList<fn>)localObject;
    if (localIterator.hasNext())
    {
      localObject = (fn)localIterator.next();
      if ((((fn)localObject).CAm > i) || ((paramLinkedList.CAm < i) && (paramLinkedList.CAm >= ((fn)localObject).CAm))) {
        break label181;
      }
      d.g.b.k.g(localObject, "info");
      paramLinkedList = (LinkedList<fn>)localObject;
      if (((fn)localObject).CAm != i) {
        paramLinkedList = (LinkedList<fn>)localObject;
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
  
  public static final void yA(int paramInt)
  {
    AppMethodBeat.i(7309);
    ax localax = ax.aFC(TAG);
    if (localax != null) {
      localax.encode("LastResolutionType", paramInt);
    }
    if (localax != null) {
      localax.encode("LastResolutionTime", System.currentTimeMillis());
    }
    ad.i(TAG, "LastResolutionType ".concat(String.valueOf(paramInt)));
    AppMethodBeat.o(7309);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.video.util.k
 * JD-Core Version:    0.7.0.1
 */