package com.tencent.mm.plugin.brandservice.ui.timeline.video.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.brandservice.ui.timeline.video.b;
import com.tencent.mm.protocal.protobuf.aal;
import com.tencent.mm.protocal.protobuf.es;
import com.tencent.mm.protocal.protobuf.et;
import com.tencent.mm.protocal.protobuf.ev;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bu;
import d.g.b.p;
import d.l;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/MPDataReportHelper;", "", "()V", "TAG", "", "commentExposureMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/protocal/protobuf/CommentExposure;", "Lkotlin/collections/HashMap;", "getCommentExposureMap", "()Ljava/util/HashMap;", "setCommentExposureMap", "(Ljava/util/HashMap;)V", "controller", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/BizNativePageController;", "enterTimeInMs", "", "getEnterTimeInMs", "()J", "setEnterTimeInMs", "(J)V", "addCommReportItem", "", "key", "value", "items", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/AppMsgCommReportItem;", "init", "logReportData", "kv", "", "onCommentExposure", "comment", "Lcom/tencent/mm/protocal/protobuf/BizComment;", "onDestroy", "report10380", "actionType", "sharePageType", "extInfo", "report10945", "report17537", "eventType", "plugin-brandservice_release"})
public final class n
{
  private final String TAG;
  public b ovq;
  public HashMap<String, aal> oyi;
  public long oyj;
  
  public n()
  {
    AppMethodBeat.i(7332);
    this.TAG = "MicroMsg.MPDataReportHelper";
    this.oyi = new HashMap();
    this.oyj = System.currentTimeMillis();
    AppMethodBeat.o(7332);
  }
  
  public static void a(String paramString1, String paramString2, LinkedList<ev> paramLinkedList)
  {
    AppMethodBeat.i(7330);
    ev localev = new ev();
    localev.key = paramString1;
    localev.hKR = paramString2;
    paramLinkedList.add(localev);
    AppMethodBeat.o(7330);
  }
  
  public final void An(int paramInt)
  {
    AppMethodBeat.i(7328);
    Object localObject1 = new et();
    es locales = new es();
    locales.type = 3;
    Object localObject2 = this.ovq;
    if (localObject2 == null) {
      p.bdF("controller");
    }
    localObject2 = ((b)localObject2).url;
    Object localObject3 = locales.FLq;
    p.g(localObject3, "reportData.item");
    a("#AppMsgUrl#", (String)localObject2, (LinkedList)localObject3);
    localObject2 = this.ovq;
    if (localObject2 == null) {
      p.bdF("controller");
    }
    localObject2 = ((b)localObject2).hCa;
    localObject3 = locales.FLq;
    p.g(localObject3, "reportData.item");
    a("VideoId", (String)localObject2, (LinkedList)localObject3);
    localObject2 = new StringBuilder();
    localObject3 = this.ovq;
    if (localObject3 == null) {
      p.bdF("controller");
    }
    localObject2 = ((b)localObject3).oua;
    localObject3 = locales.FLq;
    p.g(localObject3, "reportData.item");
    a("SessionId", (String)localObject2, (LinkedList)localObject3);
    localObject2 = this.ovq;
    if (localObject2 == null) {
      p.bdF("controller");
    }
    int i = ((b)localObject2).otX;
    localObject2 = locales.FLq;
    p.g(localObject2, "reportData.item");
    a("EnterId", String.valueOf(i), (LinkedList)localObject2);
    localObject2 = this.ovq;
    if (localObject2 == null) {
      p.bdF("controller");
    }
    i = ((b)localObject2).scene;
    localObject2 = locales.FLq;
    p.g(localObject2, "reportData.item");
    a("Scene", String.valueOf(i), (LinkedList)localObject2);
    localObject2 = this.ovq;
    if (localObject2 == null) {
      p.bdF("controller");
    }
    i = ((b)localObject2).otZ;
    localObject2 = locales.FLq;
    p.g(localObject2, "reportData.item");
    a("SubScene", String.valueOf(i), (LinkedList)localObject2);
    long l = System.currentTimeMillis();
    localObject2 = locales.FLq;
    p.g(localObject2, "reportData.item");
    a("ClientId", String.valueOf(l), (LinkedList)localObject2);
    localObject2 = locales.FLq;
    p.g(localObject2, "reportData.item");
    a("EventType", String.valueOf(paramInt), (LinkedList)localObject2);
    ((et)localObject1).FOY.add(locales);
    localObject2 = this.ovq;
    if (localObject2 == null) {
      p.bdF("controller");
    }
    ((b)localObject2).a((et)localObject1);
    localObject1 = locales.FLq;
    p.g(localObject1, "reportData.item");
    b(17537, (LinkedList)localObject1);
    AppMethodBeat.o(7328);
  }
  
  public final void aG(int paramInt, String paramString)
  {
    AppMethodBeat.i(209165);
    et localet = new et();
    es locales = new es();
    locales.type = 2;
    Object localObject1 = this.ovq;
    if (localObject1 == null) {
      p.bdF("controller");
    }
    localObject1 = ((b)localObject1).hCa;
    Object localObject2 = locales.FLq;
    p.g(localObject2, "reportData.item");
    a("Vid", (String)localObject1, (LinkedList)localObject2);
    localObject1 = az.iW(ak.getContext());
    localObject2 = locales.FLq;
    p.g(localObject2, "reportData.item");
    a("Network", (String)localObject1, (LinkedList)localObject2);
    localObject1 = locales.FLq;
    p.g(localObject1, "reportData.item");
    a("SharePageType", "2", (LinkedList)localObject1);
    localObject1 = this.ovq;
    if (localObject1 == null) {
      p.bdF("controller");
    }
    localObject1 = ((b)localObject1).url;
    localObject2 = locales.FLq;
    p.g(localObject2, "reportData.item");
    a("ContentUrl", (String)localObject1, (LinkedList)localObject2);
    localObject1 = new StringBuilder();
    localObject2 = this.ovq;
    if (localObject2 == null) {
      p.bdF("controller");
    }
    localObject1 = ((b)localObject2).oua;
    localObject2 = locales.FLq;
    p.g(localObject2, "reportData.item");
    a("SessionId", (String)localObject1, (LinkedList)localObject2);
    localObject1 = this.ovq;
    if (localObject1 == null) {
      p.bdF("controller");
    }
    int i = ((b)localObject1).otX;
    localObject1 = locales.FLq;
    p.g(localObject1, "reportData.item");
    a("EnterId", String.valueOf(i), (LinkedList)localObject1);
    localObject1 = locales.FLq;
    p.g(localObject1, "reportData.item");
    a("NativePage", "1", (LinkedList)localObject1);
    localObject1 = this.ovq;
    if (localObject1 == null) {
      p.bdF("controller");
    }
    localObject1 = ((b)localObject1).url;
    localObject2 = locales.FLq;
    p.g(localObject2, "reportData.item");
    a("#AppMsgUrl#", (String)localObject1, (LinkedList)localObject2);
    localObject1 = locales.FLq;
    p.g(localObject1, "reportData.item");
    a("ActionType", String.valueOf(paramInt), (LinkedList)localObject1);
    localObject1 = this.ovq;
    if (localObject1 == null) {
      p.bdF("controller");
    }
    localObject1 = ((b)localObject1).ouc;
    localObject2 = locales.FLq;
    p.g(localObject2, "reportData.item");
    a("ChannelSessionId", (String)localObject1, (LinkedList)localObject2);
    localObject1 = this.ovq;
    if (localObject1 == null) {
      p.bdF("controller");
    }
    paramInt = ((b)localObject1).oud;
    localObject1 = locales.FLq;
    p.g(localObject1, "reportData.item");
    a("LandingPageType", String.valueOf(paramInt), (LinkedList)localObject1);
    localObject1 = this.ovq;
    if (localObject1 == null) {
      p.bdF("controller");
    }
    paramInt = ((b)localObject1).otZ;
    localObject1 = locales.FLq;
    p.g(localObject1, "reportData.item");
    a("SubScene", String.valueOf(paramInt), (LinkedList)localObject1);
    localObject1 = this.ovq;
    if (localObject1 == null) {
      p.bdF("controller");
    }
    paramInt = ((b)localObject1).scene;
    localObject1 = locales.FLq;
    p.g(localObject1, "reportData.item");
    a("Scene", String.valueOf(paramInt), (LinkedList)localObject1);
    localObject1 = locales.FLq;
    p.g(localObject1, "reportData.item");
    a("ExtInfo", paramString, (LinkedList)localObject1);
    localet.FOY.add(locales);
    paramString = this.ovq;
    if (paramString == null) {
      p.bdF("controller");
    }
    paramString.a(localet);
    paramString = locales.FLq;
    p.g(paramString, "reportData.item");
    b(10380, paramString);
    AppMethodBeat.o(209165);
  }
  
  public final void b(int paramInt, LinkedList<ev> paramLinkedList)
  {
    AppMethodBeat.i(7329);
    if ((ae.getLogLevel() <= 0) && (!bu.ht((List)paramLinkedList)))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      paramLinkedList = paramLinkedList.iterator();
      while (paramLinkedList.hasNext())
      {
        ev localev = (ev)paramLinkedList.next();
        localStringBuilder.append(localev.key).append(":").append(localev.hKR).append("  ");
      }
      ae.v(this.TAG, paramInt + ", " + localStringBuilder);
    }
    AppMethodBeat.o(7329);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.video.util.n
 * JD-Core Version:    0.7.0.1
 */