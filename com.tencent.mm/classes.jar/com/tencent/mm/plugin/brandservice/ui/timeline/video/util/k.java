package com.tencent.mm.plugin.brandservice.ui.timeline.video.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.fu;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.b.p;
import d.l;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.LinkedList<Lcom.tencent.mm.protocal.protobuf.fu;>;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoResolutionHelper;", "", "()V", "TAG", "", "getInitResolution", "Lcom/tencent/mm/protocal/protobuf/AppMsgVideoUrlInfo;", "urlInfoList", "Ljava/util/LinkedList;", "setLastResolution", "", "type", "", "plugin-brandservice_release"})
public final class k
{
  private static final String TAG = "MicroMsg.BizVideoResolutionHelper";
  public static final k orx;
  
  static
  {
    AppMethodBeat.i(7310);
    orx = new k();
    TAG = "MicroMsg.BizVideoResolutionHelper";
    AppMethodBeat.o(7310);
  }
  
  public static final void Aa(int paramInt)
  {
    AppMethodBeat.i(7309);
    ax localax = ax.aQz(TAG);
    if (localax != null) {
      localax.encode("LastResolutionType", paramInt);
    }
    if (localax != null) {
      localax.encode("LastResolutionTime", System.currentTimeMillis());
    }
    ad.i(TAG, "LastResolutionType ".concat(String.valueOf(paramInt)));
    AppMethodBeat.o(7309);
  }
  
  public static final fu I(LinkedList<fu> paramLinkedList)
  {
    AppMethodBeat.i(7308);
    p.h(paramLinkedList, "urlInfoList");
    if (bt.hj((List)paramLinkedList))
    {
      AppMethodBeat.o(7308);
      return null;
    }
    Object localObject = ax.aQz(TAG);
    if (localObject != null) {}
    for (int i = ((ax)localObject).decodeInt("LastResolutionType", -1);; i = -1)
    {
      ad.i(TAG, "getInitResolution ".concat(String.valueOf(i)));
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
      if ((((fu)localObject).Fyb > i) || ((paramLinkedList.Fyb < i) && (paramLinkedList.Fyb >= ((fu)localObject).Fyb))) {
        break label181;
      }
      p.g(localObject, "info");
      paramLinkedList = (LinkedList<fu>)localObject;
      if (((fu)localObject).Fyb != i) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.video.util.k
 * JD-Core Version:    0.7.0.1
 */