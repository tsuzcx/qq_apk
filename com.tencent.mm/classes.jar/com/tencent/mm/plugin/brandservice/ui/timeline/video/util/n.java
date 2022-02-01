package com.tencent.mm.plugin.brandservice.ui.timeline.video.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.brandservice.ui.timeline.video.b;
import com.tencent.mm.protocal.protobuf.aai;
import com.tencent.mm.protocal.protobuf.es;
import com.tencent.mm.protocal.protobuf.et;
import com.tencent.mm.protocal.protobuf.ev;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.b.p;
import d.l;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/MPDataReportHelper;", "", "()V", "TAG", "", "commentExposureMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/protocal/protobuf/CommentExposure;", "Lkotlin/collections/HashMap;", "getCommentExposureMap", "()Ljava/util/HashMap;", "setCommentExposureMap", "(Ljava/util/HashMap;)V", "controller", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/BizNativePageController;", "enterTimeInMs", "", "getEnterTimeInMs", "()J", "setEnterTimeInMs", "(J)V", "addCommReportItem", "", "key", "value", "items", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/AppMsgCommReportItem;", "init", "logReportData", "kv", "", "onCommentExposure", "comment", "Lcom/tencent/mm/protocal/protobuf/BizComment;", "onDestroy", "report10380", "actionType", "sharePageType", "extInfo", "report10945", "report17537", "eventType", "plugin-brandservice_release"})
public final class n
{
  private final String TAG;
  public b opy;
  public HashMap<String, aai> orM;
  public long orN;
  
  public n()
  {
    AppMethodBeat.i(7332);
    this.TAG = "MicroMsg.MPDataReportHelper";
    this.orM = new HashMap();
    this.orN = System.currentTimeMillis();
    AppMethodBeat.o(7332);
  }
  
  public static void a(String paramString1, String paramString2, LinkedList<ev> paramLinkedList)
  {
    AppMethodBeat.i(7330);
    ev localev = new ev();
    localev.key = paramString1;
    localev.hHZ = paramString2;
    paramLinkedList.add(localev);
    AppMethodBeat.o(7330);
  }
  
  public final void Ad(int paramInt)
  {
    AppMethodBeat.i(7328);
    Object localObject1 = new et();
    es locales = new es();
    locales.type = 3;
    Object localObject2 = this.opy;
    if (localObject2 == null) {
      p.bcb("controller");
    }
    localObject2 = ((b)localObject2).url;
    Object localObject3 = locales.FsS;
    p.g(localObject3, "reportData.item");
    a("#AppMsgUrl#", (String)localObject2, (LinkedList)localObject3);
    localObject2 = this.opy;
    if (localObject2 == null) {
      p.bcb("controller");
    }
    localObject2 = ((b)localObject2).hzm;
    localObject3 = locales.FsS;
    p.g(localObject3, "reportData.item");
    a("VideoId", (String)localObject2, (LinkedList)localObject3);
    localObject2 = new StringBuilder();
    localObject3 = this.opy;
    if (localObject3 == null) {
      p.bcb("controller");
    }
    localObject2 = ((b)localObject3).ooj;
    localObject3 = locales.FsS;
    p.g(localObject3, "reportData.item");
    a("SessionId", (String)localObject2, (LinkedList)localObject3);
    localObject2 = this.opy;
    if (localObject2 == null) {
      p.bcb("controller");
    }
    int i = ((b)localObject2).oog;
    localObject2 = locales.FsS;
    p.g(localObject2, "reportData.item");
    a("EnterId", String.valueOf(i), (LinkedList)localObject2);
    localObject2 = this.opy;
    if (localObject2 == null) {
      p.bcb("controller");
    }
    i = ((b)localObject2).scene;
    localObject2 = locales.FsS;
    p.g(localObject2, "reportData.item");
    a("Scene", String.valueOf(i), (LinkedList)localObject2);
    localObject2 = this.opy;
    if (localObject2 == null) {
      p.bcb("controller");
    }
    i = ((b)localObject2).ooi;
    localObject2 = locales.FsS;
    p.g(localObject2, "reportData.item");
    a("SubScene", String.valueOf(i), (LinkedList)localObject2);
    long l = System.currentTimeMillis();
    localObject2 = locales.FsS;
    p.g(localObject2, "reportData.item");
    a("ClientId", String.valueOf(l), (LinkedList)localObject2);
    localObject2 = locales.FsS;
    p.g(localObject2, "reportData.item");
    a("EventType", String.valueOf(paramInt), (LinkedList)localObject2);
    ((et)localObject1).FwA.add(locales);
    localObject2 = this.opy;
    if (localObject2 == null) {
      p.bcb("controller");
    }
    ((b)localObject2).a((et)localObject1);
    localObject1 = locales.FsS;
    p.g(localObject1, "reportData.item");
    b(17537, (LinkedList)localObject1);
    AppMethodBeat.o(7328);
  }
  
  public final void aH(int paramInt, String paramString)
  {
    AppMethodBeat.i(210131);
    et localet = new et();
    es locales = new es();
    locales.type = 2;
    Object localObject1 = this.opy;
    if (localObject1 == null) {
      p.bcb("controller");
    }
    localObject1 = ((b)localObject1).hzm;
    Object localObject2 = locales.FsS;
    p.g(localObject2, "reportData.item");
    a("Vid", (String)localObject1, (LinkedList)localObject2);
    localObject1 = ay.iR(aj.getContext());
    localObject2 = locales.FsS;
    p.g(localObject2, "reportData.item");
    a("Network", (String)localObject1, (LinkedList)localObject2);
    localObject1 = locales.FsS;
    p.g(localObject1, "reportData.item");
    a("SharePageType", "2", (LinkedList)localObject1);
    localObject1 = this.opy;
    if (localObject1 == null) {
      p.bcb("controller");
    }
    localObject1 = ((b)localObject1).url;
    localObject2 = locales.FsS;
    p.g(localObject2, "reportData.item");
    a("ContentUrl", (String)localObject1, (LinkedList)localObject2);
    localObject1 = new StringBuilder();
    localObject2 = this.opy;
    if (localObject2 == null) {
      p.bcb("controller");
    }
    localObject1 = ((b)localObject2).ooj;
    localObject2 = locales.FsS;
    p.g(localObject2, "reportData.item");
    a("SessionId", (String)localObject1, (LinkedList)localObject2);
    localObject1 = this.opy;
    if (localObject1 == null) {
      p.bcb("controller");
    }
    int i = ((b)localObject1).oog;
    localObject1 = locales.FsS;
    p.g(localObject1, "reportData.item");
    a("EnterId", String.valueOf(i), (LinkedList)localObject1);
    localObject1 = locales.FsS;
    p.g(localObject1, "reportData.item");
    a("NativePage", "1", (LinkedList)localObject1);
    localObject1 = this.opy;
    if (localObject1 == null) {
      p.bcb("controller");
    }
    localObject1 = ((b)localObject1).url;
    localObject2 = locales.FsS;
    p.g(localObject2, "reportData.item");
    a("#AppMsgUrl#", (String)localObject1, (LinkedList)localObject2);
    localObject1 = locales.FsS;
    p.g(localObject1, "reportData.item");
    a("ActionType", String.valueOf(paramInt), (LinkedList)localObject1);
    localObject1 = this.opy;
    if (localObject1 == null) {
      p.bcb("controller");
    }
    localObject1 = ((b)localObject1).ool;
    localObject2 = locales.FsS;
    p.g(localObject2, "reportData.item");
    a("ChannelSessionId", (String)localObject1, (LinkedList)localObject2);
    localObject1 = this.opy;
    if (localObject1 == null) {
      p.bcb("controller");
    }
    paramInt = ((b)localObject1).oom;
    localObject1 = locales.FsS;
    p.g(localObject1, "reportData.item");
    a("LandingPageType", String.valueOf(paramInt), (LinkedList)localObject1);
    localObject1 = this.opy;
    if (localObject1 == null) {
      p.bcb("controller");
    }
    paramInt = ((b)localObject1).ooi;
    localObject1 = locales.FsS;
    p.g(localObject1, "reportData.item");
    a("SubScene", String.valueOf(paramInt), (LinkedList)localObject1);
    localObject1 = this.opy;
    if (localObject1 == null) {
      p.bcb("controller");
    }
    paramInt = ((b)localObject1).scene;
    localObject1 = locales.FsS;
    p.g(localObject1, "reportData.item");
    a("Scene", String.valueOf(paramInt), (LinkedList)localObject1);
    localObject1 = locales.FsS;
    p.g(localObject1, "reportData.item");
    a("ExtInfo", paramString, (LinkedList)localObject1);
    localet.FwA.add(locales);
    paramString = this.opy;
    if (paramString == null) {
      p.bcb("controller");
    }
    paramString.a(localet);
    paramString = locales.FsS;
    p.g(paramString, "reportData.item");
    b(10380, paramString);
    AppMethodBeat.o(210131);
  }
  
  public final void b(int paramInt, LinkedList<ev> paramLinkedList)
  {
    AppMethodBeat.i(7329);
    if ((ad.getLogLevel() <= 0) && (!bt.hj((List)paramLinkedList)))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      paramLinkedList = paramLinkedList.iterator();
      while (paramLinkedList.hasNext())
      {
        ev localev = (ev)paramLinkedList.next();
        localStringBuilder.append(localev.key).append(":").append(localev.hHZ).append("  ");
      }
      ad.v(this.TAG, paramInt + ", " + localStringBuilder);
    }
    AppMethodBeat.o(7329);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.video.util.n
 * JD-Core Version:    0.7.0.1
 */