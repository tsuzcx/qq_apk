package com.tencent.mm.plugin.brandservice.ui.timeline.video.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.brandservice.ui.timeline.video.b;
import com.tencent.mm.protocal.protobuf.acd;
import com.tencent.mm.protocal.protobuf.ff;
import com.tencent.mm.protocal.protobuf.fg;
import com.tencent.mm.protocal.protobuf.fi;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/MPDataReportHelper;", "", "()V", "TAG", "", "commentExposureMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/protocal/protobuf/CommentExposure;", "Lkotlin/collections/HashMap;", "getCommentExposureMap", "()Ljava/util/HashMap;", "setCommentExposureMap", "(Ljava/util/HashMap;)V", "controller", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/BizNativePageController;", "enterTimeInMs", "", "getEnterTimeInMs", "()J", "setEnterTimeInMs", "(J)V", "addCommReportItem", "", "key", "value", "items", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/AppMsgCommReportItem;", "init", "logReportData", "kv", "", "onCommentExposure", "comment", "Lcom/tencent/mm/protocal/protobuf/BizComment;", "onDestroy", "report10380", "actionType", "sharePageType", "extInfo", "report10945", "report17537", "eventType", "plugin-brandservice_release"})
public final class n
{
  private final String TAG;
  public b pIL;
  public HashMap<String, acd> pLM;
  public long pLN;
  
  public n()
  {
    AppMethodBeat.i(7332);
    this.TAG = "MicroMsg.MPDataReportHelper";
    this.pLM = new HashMap();
    this.pLN = System.currentTimeMillis();
    AppMethodBeat.o(7332);
  }
  
  public static void a(String paramString1, String paramString2, LinkedList<fi> paramLinkedList)
  {
    AppMethodBeat.i(7330);
    fi localfi = new fi();
    localfi.key = paramString1;
    localfi.iFF = paramString2;
    paramLinkedList.add(localfi);
    AppMethodBeat.o(7330);
  }
  
  public final void DS(int paramInt)
  {
    AppMethodBeat.i(7328);
    Object localObject1 = new fg();
    ff localff = new ff();
    localff.type = 3;
    Object localObject2 = this.pIL;
    if (localObject2 == null) {
      p.btv("controller");
    }
    localObject2 = ((b)localObject2).url;
    Object localObject3 = localff.KEQ;
    p.g(localObject3, "reportData.item");
    a("#AppMsgUrl#", (String)localObject2, (LinkedList)localObject3);
    localObject2 = this.pIL;
    if (localObject2 == null) {
      p.btv("controller");
    }
    localObject2 = ((b)localObject2).vid;
    localObject3 = localff.KEQ;
    p.g(localObject3, "reportData.item");
    a("VideoId", (String)localObject2, (LinkedList)localObject3);
    localObject2 = new StringBuilder();
    localObject3 = this.pIL;
    if (localObject3 == null) {
      p.btv("controller");
    }
    localObject2 = ((b)localObject3).pHx;
    localObject3 = localff.KEQ;
    p.g(localObject3, "reportData.item");
    a("SessionId", (String)localObject2, (LinkedList)localObject3);
    localObject2 = this.pIL;
    if (localObject2 == null) {
      p.btv("controller");
    }
    int i = ((b)localObject2).pHu;
    localObject2 = localff.KEQ;
    p.g(localObject2, "reportData.item");
    a("EnterId", String.valueOf(i), (LinkedList)localObject2);
    localObject2 = this.pIL;
    if (localObject2 == null) {
      p.btv("controller");
    }
    i = ((b)localObject2).scene;
    localObject2 = localff.KEQ;
    p.g(localObject2, "reportData.item");
    a("Scene", String.valueOf(i), (LinkedList)localObject2);
    localObject2 = this.pIL;
    if (localObject2 == null) {
      p.btv("controller");
    }
    i = ((b)localObject2).pHw;
    localObject2 = localff.KEQ;
    p.g(localObject2, "reportData.item");
    a("SubScene", String.valueOf(i), (LinkedList)localObject2);
    long l = System.currentTimeMillis();
    localObject2 = localff.KEQ;
    p.g(localObject2, "reportData.item");
    a("ClientId", String.valueOf(l), (LinkedList)localObject2);
    localObject2 = localff.KEQ;
    p.g(localObject2, "reportData.item");
    a("EventType", String.valueOf(paramInt), (LinkedList)localObject2);
    ((fg)localObject1).KIG.add(localff);
    localObject2 = this.pIL;
    if (localObject2 == null) {
      p.btv("controller");
    }
    ((b)localObject2).a((fg)localObject1);
    localObject1 = localff.KEQ;
    p.g(localObject1, "reportData.item");
    b(17537, (LinkedList)localObject1);
    AppMethodBeat.o(7328);
  }
  
  public final void aL(int paramInt, String paramString)
  {
    AppMethodBeat.i(195988);
    fg localfg = new fg();
    ff localff = new ff();
    localff.type = 2;
    Object localObject1 = this.pIL;
    if (localObject1 == null) {
      p.btv("controller");
    }
    localObject1 = ((b)localObject1).vid;
    Object localObject2 = localff.KEQ;
    p.g(localObject2, "reportData.item");
    a("Vid", (String)localObject1, (LinkedList)localObject2);
    localObject1 = NetStatusUtil.getFormatedNetType(MMApplicationContext.getContext());
    localObject2 = localff.KEQ;
    p.g(localObject2, "reportData.item");
    a("Network", (String)localObject1, (LinkedList)localObject2);
    localObject1 = localff.KEQ;
    p.g(localObject1, "reportData.item");
    a("SharePageType", "2", (LinkedList)localObject1);
    localObject1 = this.pIL;
    if (localObject1 == null) {
      p.btv("controller");
    }
    localObject1 = ((b)localObject1).url;
    localObject2 = localff.KEQ;
    p.g(localObject2, "reportData.item");
    a("ContentUrl", (String)localObject1, (LinkedList)localObject2);
    localObject1 = new StringBuilder();
    localObject2 = this.pIL;
    if (localObject2 == null) {
      p.btv("controller");
    }
    localObject1 = ((b)localObject2).pHx;
    localObject2 = localff.KEQ;
    p.g(localObject2, "reportData.item");
    a("SessionId", (String)localObject1, (LinkedList)localObject2);
    localObject1 = this.pIL;
    if (localObject1 == null) {
      p.btv("controller");
    }
    int i = ((b)localObject1).pHu;
    localObject1 = localff.KEQ;
    p.g(localObject1, "reportData.item");
    a("EnterId", String.valueOf(i), (LinkedList)localObject1);
    localObject1 = localff.KEQ;
    p.g(localObject1, "reportData.item");
    a("NativePage", "1", (LinkedList)localObject1);
    localObject1 = this.pIL;
    if (localObject1 == null) {
      p.btv("controller");
    }
    localObject1 = ((b)localObject1).url;
    localObject2 = localff.KEQ;
    p.g(localObject2, "reportData.item");
    a("#AppMsgUrl#", (String)localObject1, (LinkedList)localObject2);
    localObject1 = localff.KEQ;
    p.g(localObject1, "reportData.item");
    a("ActionType", String.valueOf(paramInt), (LinkedList)localObject1);
    localObject1 = this.pIL;
    if (localObject1 == null) {
      p.btv("controller");
    }
    localObject1 = ((b)localObject1).pHz;
    localObject2 = localff.KEQ;
    p.g(localObject2, "reportData.item");
    a("ChannelSessionId", (String)localObject1, (LinkedList)localObject2);
    localObject1 = this.pIL;
    if (localObject1 == null) {
      p.btv("controller");
    }
    paramInt = ((b)localObject1).pHA;
    localObject1 = localff.KEQ;
    p.g(localObject1, "reportData.item");
    a("LandingPageType", String.valueOf(paramInt), (LinkedList)localObject1);
    localObject1 = this.pIL;
    if (localObject1 == null) {
      p.btv("controller");
    }
    paramInt = ((b)localObject1).pHw;
    localObject1 = localff.KEQ;
    p.g(localObject1, "reportData.item");
    a("SubScene", String.valueOf(paramInt), (LinkedList)localObject1);
    localObject1 = this.pIL;
    if (localObject1 == null) {
      p.btv("controller");
    }
    paramInt = ((b)localObject1).scene;
    localObject1 = localff.KEQ;
    p.g(localObject1, "reportData.item");
    a("Scene", String.valueOf(paramInt), (LinkedList)localObject1);
    localObject1 = localff.KEQ;
    p.g(localObject1, "reportData.item");
    a("ExtInfo", paramString, (LinkedList)localObject1);
    localfg.KIG.add(localff);
    paramString = this.pIL;
    if (paramString == null) {
      p.btv("controller");
    }
    paramString.a(localfg);
    paramString = localff.KEQ;
    p.g(paramString, "reportData.item");
    b(10380, paramString);
    AppMethodBeat.o(195988);
  }
  
  public final void b(int paramInt, LinkedList<fi> paramLinkedList)
  {
    AppMethodBeat.i(7329);
    if ((Log.getLogLevel() <= 0) && (!Util.isNullOrNil((List)paramLinkedList)))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      paramLinkedList = paramLinkedList.iterator();
      while (paramLinkedList.hasNext())
      {
        fi localfi = (fi)paramLinkedList.next();
        localStringBuilder.append(localfi.key).append(":").append(localfi.iFF).append("  ");
      }
      Log.v(this.TAG, paramInt + ", " + localStringBuilder);
    }
    AppMethodBeat.o(7329);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.video.util.n
 * JD-Core Version:    0.7.0.1
 */