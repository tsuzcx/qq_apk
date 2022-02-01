package com.tencent.mm.plugin.brandservice.ui.timeline.video.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.fp;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.bs;
import d.l;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.LinkedList<Lcom.tencent.mm.protocal.protobuf.fp;>;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoResolutionHelper;", "", "()V", "TAG", "", "getInitResolution", "Lcom/tencent/mm/protocal/protobuf/AppMsgVideoUrlInfo;", "urlInfoList", "Ljava/util/LinkedList;", "setLastResolution", "", "type", "", "plugin-brandservice_release"})
public final class k
{
  private static final String TAG = "MicroMsg.BizVideoResolutionHelper";
  public static final k nOR;
  
  static
  {
    AppMethodBeat.i(7310);
    nOR = new k();
    TAG = "MicroMsg.BizVideoResolutionHelper";
    AppMethodBeat.o(7310);
  }
  
  public static final fp I(LinkedList<fp> paramLinkedList)
  {
    AppMethodBeat.i(7308);
    d.g.b.k.h(paramLinkedList, "urlInfoList");
    if (bs.gY((List)paramLinkedList))
    {
      AppMethodBeat.o(7308);
      return null;
    }
    Object localObject = aw.aKT(TAG);
    if (localObject != null) {}
    for (int i = ((aw)localObject).decodeInt("LastResolutionType", -1);; i = -1)
    {
      ac.i(TAG, "getInitResolution ".concat(String.valueOf(i)));
      localObject = paramLinkedList.get(0);
      d.g.b.k.g(localObject, "urlInfoList[0]");
      localObject = (fp)localObject;
      if (i != -1) {
        break;
      }
      AppMethodBeat.o(7308);
      return localObject;
    }
    Iterator localIterator = paramLinkedList.iterator();
    paramLinkedList = (LinkedList<fp>)localObject;
    if (localIterator.hasNext())
    {
      localObject = (fp)localIterator.next();
      if ((((fp)localObject).DSI > i) || ((paramLinkedList.DSI < i) && (paramLinkedList.DSI >= ((fp)localObject).DSI))) {
        break label181;
      }
      d.g.b.k.g(localObject, "info");
      paramLinkedList = (LinkedList<fp>)localObject;
      if (((fp)localObject).DSI != i) {
        paramLinkedList = (LinkedList<fp>)localObject;
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
  
  public static final void zr(int paramInt)
  {
    AppMethodBeat.i(7309);
    aw localaw = aw.aKT(TAG);
    if (localaw != null) {
      localaw.encode("LastResolutionType", paramInt);
    }
    if (localaw != null) {
      localaw.encode("LastResolutionTime", System.currentTimeMillis());
    }
    ac.i(TAG, "LastResolutionType ".concat(String.valueOf(paramInt)));
    AppMethodBeat.o(7309);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.video.util.k
 * JD-Core Version:    0.7.0.1
 */