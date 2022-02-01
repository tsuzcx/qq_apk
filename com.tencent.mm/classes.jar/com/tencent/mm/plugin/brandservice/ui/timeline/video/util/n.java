package com.tencent.mm.plugin.brandservice.ui.timeline.video.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.brandservice.ui.timeline.video.b;
import com.tencent.mm.protocal.protobuf.em;
import com.tencent.mm.protocal.protobuf.en;
import com.tencent.mm.protocal.protobuf.ep;
import com.tencent.mm.protocal.protobuf.xr;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.b.k;
import d.l;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/MPDataReportHelper;", "", "()V", "TAG", "", "commentExposureMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/protocal/protobuf/CommentExposure;", "Lkotlin/collections/HashMap;", "getCommentExposureMap", "()Ljava/util/HashMap;", "setCommentExposureMap", "(Ljava/util/HashMap;)V", "controller", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/BizNativePageController;", "enterTimeInMs", "", "getEnterTimeInMs", "()J", "setEnterTimeInMs", "(J)V", "addCommReportItem", "", "key", "value", "items", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/AppMsgCommReportItem;", "init", "logReportData", "kv", "", "onCommentExposure", "comment", "Lcom/tencent/mm/protocal/protobuf/BizComment;", "onDestroy", "report10380", "actionType", "sharePageType", "report10945", "report17537", "eventType", "plugin-brandservice_release"})
public final class n
{
  private final String TAG;
  public b njZ;
  public HashMap<String, xr> nmg;
  public long nmh;
  
  public n()
  {
    AppMethodBeat.i(7332);
    this.TAG = "MicroMsg.MPDataReportHelper";
    this.nmg = new HashMap();
    this.nmh = System.currentTimeMillis();
    AppMethodBeat.o(7332);
  }
  
  public static void a(String paramString1, String paramString2, LinkedList<ep> paramLinkedList)
  {
    AppMethodBeat.i(7330);
    ep localep = new ep();
    localep.key = paramString1;
    localep.gPh = paramString2;
    paramLinkedList.add(localep);
    AppMethodBeat.o(7330);
  }
  
  public final void b(int paramInt, LinkedList<ep> paramLinkedList)
  {
    AppMethodBeat.i(7329);
    if ((ad.getLogLevel() <= 0) && (!bt.gL((List)paramLinkedList)))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      paramLinkedList = paramLinkedList.iterator();
      while (paramLinkedList.hasNext())
      {
        ep localep = (ep)paramLinkedList.next();
        localStringBuilder.append(localep.key).append(":").append(localep.gPh).append("  ");
      }
      ad.v(this.TAG, paramInt + ", " + localStringBuilder);
    }
    AppMethodBeat.o(7329);
  }
  
  public final void yD(int paramInt)
  {
    AppMethodBeat.i(7327);
    Object localObject1 = new en();
    em localem = new em();
    localem.type = 2;
    Object localObject2 = this.njZ;
    if (localObject2 == null) {
      k.aPZ("controller");
    }
    localObject2 = ((b)localObject2).gGC;
    Object localObject3 = localem.Cvr;
    k.g(localObject3, "reportData.item");
    a("Vid", (String)localObject2, (LinkedList)localObject3);
    localObject2 = ay.iw(aj.getContext());
    localObject3 = localem.Cvr;
    k.g(localObject3, "reportData.item");
    a("Network", (String)localObject2, (LinkedList)localObject3);
    localObject2 = localem.Cvr;
    k.g(localObject2, "reportData.item");
    a("SharePageType", "2", (LinkedList)localObject2);
    localObject2 = this.njZ;
    if (localObject2 == null) {
      k.aPZ("controller");
    }
    localObject2 = ((b)localObject2).url;
    localObject3 = localem.Cvr;
    k.g(localObject3, "reportData.item");
    a("ContentUrl", (String)localObject2, (LinkedList)localObject3);
    localObject2 = new StringBuilder();
    localObject3 = this.njZ;
    if (localObject3 == null) {
      k.aPZ("controller");
    }
    localObject2 = ((b)localObject3).niK;
    localObject3 = localem.Cvr;
    k.g(localObject3, "reportData.item");
    a("SessionId", (String)localObject2, (LinkedList)localObject3);
    localObject2 = this.njZ;
    if (localObject2 == null) {
      k.aPZ("controller");
    }
    int i = ((b)localObject2).niH;
    localObject2 = localem.Cvr;
    k.g(localObject2, "reportData.item");
    a("EnterId", String.valueOf(i), (LinkedList)localObject2);
    localObject2 = localem.Cvr;
    k.g(localObject2, "reportData.item");
    a("NativePage", "1", (LinkedList)localObject2);
    localObject2 = this.njZ;
    if (localObject2 == null) {
      k.aPZ("controller");
    }
    localObject2 = ((b)localObject2).url;
    localObject3 = localem.Cvr;
    k.g(localObject3, "reportData.item");
    a("#AppMsgUrl#", (String)localObject2, (LinkedList)localObject3);
    localObject2 = localem.Cvr;
    k.g(localObject2, "reportData.item");
    a("ActionType", String.valueOf(paramInt), (LinkedList)localObject2);
    localObject2 = this.njZ;
    if (localObject2 == null) {
      k.aPZ("controller");
    }
    localObject2 = ((b)localObject2).niM;
    localObject3 = localem.Cvr;
    k.g(localObject3, "reportData.item");
    a("ChannelSessionId", (String)localObject2, (LinkedList)localObject3);
    localObject2 = this.njZ;
    if (localObject2 == null) {
      k.aPZ("controller");
    }
    paramInt = ((b)localObject2).niN;
    localObject2 = localem.Cvr;
    k.g(localObject2, "reportData.item");
    a("LandingPageType", String.valueOf(paramInt), (LinkedList)localObject2);
    localObject2 = this.njZ;
    if (localObject2 == null) {
      k.aPZ("controller");
    }
    paramInt = ((b)localObject2).niJ;
    localObject2 = localem.Cvr;
    k.g(localObject2, "reportData.item");
    a("SubScene", String.valueOf(paramInt), (LinkedList)localObject2);
    localObject2 = this.njZ;
    if (localObject2 == null) {
      k.aPZ("controller");
    }
    paramInt = ((b)localObject2).scene;
    localObject2 = localem.Cvr;
    k.g(localObject2, "reportData.item");
    a("Scene", String.valueOf(paramInt), (LinkedList)localObject2);
    ((en)localObject1).CyM.add(localem);
    localObject2 = this.njZ;
    if (localObject2 == null) {
      k.aPZ("controller");
    }
    ((b)localObject2).a((en)localObject1);
    localObject1 = localem.Cvr;
    k.g(localObject1, "reportData.item");
    b(10380, (LinkedList)localObject1);
    AppMethodBeat.o(7327);
  }
  
  public final void yE(int paramInt)
  {
    AppMethodBeat.i(7328);
    Object localObject1 = new en();
    em localem = new em();
    localem.type = 3;
    Object localObject2 = this.njZ;
    if (localObject2 == null) {
      k.aPZ("controller");
    }
    localObject2 = ((b)localObject2).url;
    Object localObject3 = localem.Cvr;
    k.g(localObject3, "reportData.item");
    a("#AppMsgUrl#", (String)localObject2, (LinkedList)localObject3);
    localObject2 = this.njZ;
    if (localObject2 == null) {
      k.aPZ("controller");
    }
    localObject2 = ((b)localObject2).gGC;
    localObject3 = localem.Cvr;
    k.g(localObject3, "reportData.item");
    a("VideoId", (String)localObject2, (LinkedList)localObject3);
    localObject2 = new StringBuilder();
    localObject3 = this.njZ;
    if (localObject3 == null) {
      k.aPZ("controller");
    }
    localObject2 = ((b)localObject3).niK;
    localObject3 = localem.Cvr;
    k.g(localObject3, "reportData.item");
    a("SessionId", (String)localObject2, (LinkedList)localObject3);
    localObject2 = this.njZ;
    if (localObject2 == null) {
      k.aPZ("controller");
    }
    int i = ((b)localObject2).niH;
    localObject2 = localem.Cvr;
    k.g(localObject2, "reportData.item");
    a("EnterId", String.valueOf(i), (LinkedList)localObject2);
    localObject2 = this.njZ;
    if (localObject2 == null) {
      k.aPZ("controller");
    }
    i = ((b)localObject2).scene;
    localObject2 = localem.Cvr;
    k.g(localObject2, "reportData.item");
    a("Scene", String.valueOf(i), (LinkedList)localObject2);
    localObject2 = this.njZ;
    if (localObject2 == null) {
      k.aPZ("controller");
    }
    i = ((b)localObject2).niJ;
    localObject2 = localem.Cvr;
    k.g(localObject2, "reportData.item");
    a("SubScene", String.valueOf(i), (LinkedList)localObject2);
    long l = System.currentTimeMillis();
    localObject2 = localem.Cvr;
    k.g(localObject2, "reportData.item");
    a("ClientId", String.valueOf(l), (LinkedList)localObject2);
    localObject2 = localem.Cvr;
    k.g(localObject2, "reportData.item");
    a("EventType", String.valueOf(paramInt), (LinkedList)localObject2);
    ((en)localObject1).CyM.add(localem);
    localObject2 = this.njZ;
    if (localObject2 == null) {
      k.aPZ("controller");
    }
    ((b)localObject2).a((en)localObject1);
    localObject1 = localem.Cvr;
    k.g(localObject1, "reportData.item");
    b(17537, (LinkedList)localObject1);
    AppMethodBeat.o(7328);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.video.util.n
 * JD-Core Version:    0.7.0.1
 */