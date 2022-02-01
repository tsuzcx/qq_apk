package com.tencent.mm.plugin.brandservice.ui.timeline.video.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.brandservice.ui.timeline.video.b;
import com.tencent.mm.protocal.protobuf.eo;
import com.tencent.mm.protocal.protobuf.ep;
import com.tencent.mm.protocal.protobuf.er;
import com.tencent.mm.protocal.protobuf.yj;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bs;
import d.g.b.k;
import d.l;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/MPDataReportHelper;", "", "()V", "TAG", "", "commentExposureMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/protocal/protobuf/CommentExposure;", "Lkotlin/collections/HashMap;", "getCommentExposureMap", "()Ljava/util/HashMap;", "setCommentExposureMap", "(Ljava/util/HashMap;)V", "controller", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/BizNativePageController;", "enterTimeInMs", "", "getEnterTimeInMs", "()J", "setEnterTimeInMs", "(J)V", "addCommReportItem", "", "key", "value", "items", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/AppMsgCommReportItem;", "init", "logReportData", "kv", "", "onCommentExposure", "comment", "Lcom/tencent/mm/protocal/protobuf/BizComment;", "onDestroy", "report10380", "actionType", "sharePageType", "extInfo", "report10945", "report17537", "eventType", "plugin-brandservice_release"})
public final class n
{
  private final String TAG;
  public b nMS;
  public HashMap<String, yj> nPg;
  public long nPh;
  
  public n()
  {
    AppMethodBeat.i(7332);
    this.TAG = "MicroMsg.MPDataReportHelper";
    this.nPg = new HashMap();
    this.nPh = System.currentTimeMillis();
    AppMethodBeat.o(7332);
  }
  
  public static void a(String paramString1, String paramString2, LinkedList<er> paramLinkedList)
  {
    AppMethodBeat.i(7330);
    er localer = new er();
    localer.key = paramString1;
    localer.hpH = paramString2;
    paramLinkedList.add(localer);
    AppMethodBeat.o(7330);
  }
  
  public final void aE(int paramInt, String paramString)
  {
    AppMethodBeat.i(199182);
    ep localep = new ep();
    eo localeo = new eo();
    localeo.type = 2;
    Object localObject1 = this.nMS;
    if (localObject1 == null) {
      k.aVY("controller");
    }
    localObject1 = ((b)localObject1).hhd;
    Object localObject2 = localeo.DNM;
    k.g(localObject2, "reportData.item");
    a("Vid", (String)localObject1, (LinkedList)localObject2);
    localObject1 = ax.iH(ai.getContext());
    localObject2 = localeo.DNM;
    k.g(localObject2, "reportData.item");
    a("Network", (String)localObject1, (LinkedList)localObject2);
    localObject1 = localeo.DNM;
    k.g(localObject1, "reportData.item");
    a("SharePageType", "2", (LinkedList)localObject1);
    localObject1 = this.nMS;
    if (localObject1 == null) {
      k.aVY("controller");
    }
    localObject1 = ((b)localObject1).url;
    localObject2 = localeo.DNM;
    k.g(localObject2, "reportData.item");
    a("ContentUrl", (String)localObject1, (LinkedList)localObject2);
    localObject1 = new StringBuilder();
    localObject2 = this.nMS;
    if (localObject2 == null) {
      k.aVY("controller");
    }
    localObject1 = ((b)localObject2).nLD;
    localObject2 = localeo.DNM;
    k.g(localObject2, "reportData.item");
    a("SessionId", (String)localObject1, (LinkedList)localObject2);
    localObject1 = this.nMS;
    if (localObject1 == null) {
      k.aVY("controller");
    }
    int i = ((b)localObject1).nLA;
    localObject1 = localeo.DNM;
    k.g(localObject1, "reportData.item");
    a("EnterId", String.valueOf(i), (LinkedList)localObject1);
    localObject1 = localeo.DNM;
    k.g(localObject1, "reportData.item");
    a("NativePage", "1", (LinkedList)localObject1);
    localObject1 = this.nMS;
    if (localObject1 == null) {
      k.aVY("controller");
    }
    localObject1 = ((b)localObject1).url;
    localObject2 = localeo.DNM;
    k.g(localObject2, "reportData.item");
    a("#AppMsgUrl#", (String)localObject1, (LinkedList)localObject2);
    localObject1 = localeo.DNM;
    k.g(localObject1, "reportData.item");
    a("ActionType", String.valueOf(paramInt), (LinkedList)localObject1);
    localObject1 = this.nMS;
    if (localObject1 == null) {
      k.aVY("controller");
    }
    localObject1 = ((b)localObject1).nLF;
    localObject2 = localeo.DNM;
    k.g(localObject2, "reportData.item");
    a("ChannelSessionId", (String)localObject1, (LinkedList)localObject2);
    localObject1 = this.nMS;
    if (localObject1 == null) {
      k.aVY("controller");
    }
    paramInt = ((b)localObject1).nLG;
    localObject1 = localeo.DNM;
    k.g(localObject1, "reportData.item");
    a("LandingPageType", String.valueOf(paramInt), (LinkedList)localObject1);
    localObject1 = this.nMS;
    if (localObject1 == null) {
      k.aVY("controller");
    }
    paramInt = ((b)localObject1).nLC;
    localObject1 = localeo.DNM;
    k.g(localObject1, "reportData.item");
    a("SubScene", String.valueOf(paramInt), (LinkedList)localObject1);
    localObject1 = this.nMS;
    if (localObject1 == null) {
      k.aVY("controller");
    }
    paramInt = ((b)localObject1).scene;
    localObject1 = localeo.DNM;
    k.g(localObject1, "reportData.item");
    a("Scene", String.valueOf(paramInt), (LinkedList)localObject1);
    localObject1 = localeo.DNM;
    k.g(localObject1, "reportData.item");
    a("ExtInfo", paramString, (LinkedList)localObject1);
    localep.DRi.add(localeo);
    paramString = this.nMS;
    if (paramString == null) {
      k.aVY("controller");
    }
    paramString.a(localep);
    paramString = localeo.DNM;
    k.g(paramString, "reportData.item");
    b(10380, paramString);
    AppMethodBeat.o(199182);
  }
  
  public final void b(int paramInt, LinkedList<er> paramLinkedList)
  {
    AppMethodBeat.i(7329);
    if ((ac.getLogLevel() <= 0) && (!bs.gY((List)paramLinkedList)))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      paramLinkedList = paramLinkedList.iterator();
      while (paramLinkedList.hasNext())
      {
        er localer = (er)paramLinkedList.next();
        localStringBuilder.append(localer.key).append(":").append(localer.hpH).append("  ");
      }
      ac.v(this.TAG, paramInt + ", " + localStringBuilder);
    }
    AppMethodBeat.o(7329);
  }
  
  public final void zu(int paramInt)
  {
    AppMethodBeat.i(7328);
    Object localObject1 = new ep();
    eo localeo = new eo();
    localeo.type = 3;
    Object localObject2 = this.nMS;
    if (localObject2 == null) {
      k.aVY("controller");
    }
    localObject2 = ((b)localObject2).url;
    Object localObject3 = localeo.DNM;
    k.g(localObject3, "reportData.item");
    a("#AppMsgUrl#", (String)localObject2, (LinkedList)localObject3);
    localObject2 = this.nMS;
    if (localObject2 == null) {
      k.aVY("controller");
    }
    localObject2 = ((b)localObject2).hhd;
    localObject3 = localeo.DNM;
    k.g(localObject3, "reportData.item");
    a("VideoId", (String)localObject2, (LinkedList)localObject3);
    localObject2 = new StringBuilder();
    localObject3 = this.nMS;
    if (localObject3 == null) {
      k.aVY("controller");
    }
    localObject2 = ((b)localObject3).nLD;
    localObject3 = localeo.DNM;
    k.g(localObject3, "reportData.item");
    a("SessionId", (String)localObject2, (LinkedList)localObject3);
    localObject2 = this.nMS;
    if (localObject2 == null) {
      k.aVY("controller");
    }
    int i = ((b)localObject2).nLA;
    localObject2 = localeo.DNM;
    k.g(localObject2, "reportData.item");
    a("EnterId", String.valueOf(i), (LinkedList)localObject2);
    localObject2 = this.nMS;
    if (localObject2 == null) {
      k.aVY("controller");
    }
    i = ((b)localObject2).scene;
    localObject2 = localeo.DNM;
    k.g(localObject2, "reportData.item");
    a("Scene", String.valueOf(i), (LinkedList)localObject2);
    localObject2 = this.nMS;
    if (localObject2 == null) {
      k.aVY("controller");
    }
    i = ((b)localObject2).nLC;
    localObject2 = localeo.DNM;
    k.g(localObject2, "reportData.item");
    a("SubScene", String.valueOf(i), (LinkedList)localObject2);
    long l = System.currentTimeMillis();
    localObject2 = localeo.DNM;
    k.g(localObject2, "reportData.item");
    a("ClientId", String.valueOf(l), (LinkedList)localObject2);
    localObject2 = localeo.DNM;
    k.g(localObject2, "reportData.item");
    a("EventType", String.valueOf(paramInt), (LinkedList)localObject2);
    ((ep)localObject1).DRi.add(localeo);
    localObject2 = this.nMS;
    if (localObject2 == null) {
      k.aVY("controller");
    }
    ((b)localObject2).a((ep)localObject1);
    localObject1 = localeo.DNM;
    k.g(localObject1, "reportData.item");
    b(17537, (LinkedList)localObject1);
    AppMethodBeat.o(7328);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.video.util.n
 * JD-Core Version:    0.7.0.1
 */