package com.tencent.mm.plugin.brandservice.ui.timeline.video.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.fu;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bu;
import d.g.b.p;
import d.l;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.LinkedList<Lcom.tencent.mm.protocal.protobuf.fu;>;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoResolutionHelper;", "", "()V", "TAG", "", "getInitResolution", "Lcom/tencent/mm/protocal/protobuf/AppMsgVideoUrlInfo;", "urlInfoList", "Ljava/util/LinkedList;", "setLastResolution", "", "type", "", "plugin-brandservice_release"})
public final class k
{
  private static final String TAG = "MicroMsg.BizVideoResolutionHelper";
  public static final k oxT;
  
  static
  {
    AppMethodBeat.i(7310);
    oxT = new k();
    TAG = "MicroMsg.BizVideoResolutionHelper";
    AppMethodBeat.o(7310);
  }
  
  public static final void Ak(int paramInt)
  {
    AppMethodBeat.i(7309);
    ay localay = ay.aRW(TAG);
    if (localay != null) {
      localay.encode("LastResolutionType", paramInt);
    }
    if (localay != null) {
      localay.encode("LastResolutionTime", System.currentTimeMillis());
    }
    ae.i(TAG, "LastResolutionType ".concat(String.valueOf(paramInt)));
    AppMethodBeat.o(7309);
  }
  
  public static final fu I(LinkedList<fu> paramLinkedList)
  {
    AppMethodBeat.i(7308);
    p.h(paramLinkedList, "urlInfoList");
    if (bu.ht((List)paramLinkedList))
    {
      AppMethodBeat.o(7308);
      return null;
    }
    Object localObject = ay.aRW(TAG);
    if (localObject != null) {}
    for (int i = ((ay)localObject).decodeInt("LastResolutionType", -1);; i = -1)
    {
      ae.i(TAG, "getInitResolution ".concat(String.valueOf(i)));
      localObject = paramLinkedList.get(0);
      p.g(localObject, "urlInfoList[0]");
      localObject = (fu)localObject;
      if (i != -1) {
        break;
      }
      AppMethodBeat.o(7308);
      return localObject;
    }
    Iterator localIterator = paramLinkedList.iterator();
    paramLinkedList = (LinkedList<fu>)localObject;
    if (localIterator.hasNext())
    {
      localObject = (fu)localIterator.next();
      if ((((fu)localObject).FQz > i) || ((paramLinkedList.FQz < i) && (paramLinkedList.FQz >= ((fu)localObject).FQz))) {
        break label181;
      }
      p.g(localObject, "info");
      paramLinkedList = (LinkedList<fu>)localObject;
      if (((fu)localObject).FQz != i) {
        paramLinkedList = (LinkedList<fu>)localObject;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.video.util.k
 * JD-Core Version:    0.7.0.1
 */