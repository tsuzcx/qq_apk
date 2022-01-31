package com.tencent.mm.plugin.brandservice.ui.timeline.video.util;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.brandservice.ui.timeline.video.b;
import com.tencent.mm.protocal.protobuf.dz;
import com.tencent.mm.protocal.protobuf.ea;
import com.tencent.mm.protocal.protobuf.ec;
import com.tencent.mm.protocal.protobuf.ed;
import com.tencent.mm.protocal.protobuf.ur;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/MPDataReportHelper;", "", "()V", "TAG", "", "commentExposureMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/protocal/protobuf/CommentExposure;", "Lkotlin/collections/HashMap;", "getCommentExposureMap", "()Ljava/util/HashMap;", "setCommentExposureMap", "(Ljava/util/HashMap;)V", "controller", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/BizNativePageController;", "enterTimeInMs", "", "getEnterTimeInMs", "()J", "setEnterTimeInMs", "(J)V", "addCommReportItem", "", "key", "value", "items", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/AppMsgCommReportItem;", "init", "logReportData", "kv", "", "onCommentExposure", "comment", "Lcom/tencent/mm/protocal/protobuf/BizComment;", "onDestroy", "report10380", "actionType", "sharePageType", "report10945", "report17537", "eventType", "plugin-brandservice_release"})
public final class g
{
  private final String TAG;
  private b jXn;
  private HashMap<String, ur> kin;
  private long kio;
  
  public g()
  {
    AppMethodBeat.i(15329);
    this.TAG = "MicroMsg.MPDataReportHelper";
    this.kin = new HashMap();
    this.kio = System.currentTimeMillis();
    AppMethodBeat.o(15329);
  }
  
  private static void a(String paramString1, String paramString2, LinkedList<ec> paramLinkedList)
  {
    AppMethodBeat.i(15328);
    ec localec = new ec();
    localec.key = paramString1;
    localec.fnF = paramString2;
    paramLinkedList.add(localec);
    AppMethodBeat.o(15328);
  }
  
  private final void aZO()
  {
    AppMethodBeat.i(152964);
    Object localObject1 = new ea();
    dz localdz = new dz();
    localdz.type = 1;
    Object localObject2 = this.jXn;
    if (localObject2 == null) {
      j.ays("controller");
    }
    int i = ((b)localObject2).scene;
    localObject2 = localdz.wnb;
    j.p(localObject2, "reportData.item");
    a("scene", String.valueOf(i), (LinkedList)localObject2);
    localObject2 = at.gU(ah.getContext());
    Object localObject3 = localdz.wnb;
    j.p(localObject3, "reportData.item");
    a("netType", (String)localObject2, (LinkedList)localObject3);
    long l = this.kio;
    localObject2 = localdz.wnb;
    j.p(localObject2, "reportData.item");
    a("StartTimeMs", String.valueOf(l), (LinkedList)localObject2);
    l = System.currentTimeMillis();
    localObject2 = localdz.wnb;
    j.p(localObject2, "reportData.item");
    a("EndTimeMs", String.valueOf(l), (LinkedList)localObject2);
    localObject2 = this.jXn;
    if (localObject2 == null) {
      j.ays("controller");
    }
    i = ((b)localObject2).fgh;
    localObject2 = localdz.wnb;
    j.p(localObject2, "reportData.item");
    a("ItemShowType", String.valueOf(i), (LinkedList)localObject2);
    localObject2 = new StringBuilder();
    localObject3 = this.jXn;
    if (localObject3 == null) {
      j.ays("controller");
    }
    localObject2 = ((b)localObject3).kfx;
    localObject3 = localdz.wnb;
    j.p(localObject3, "reportData.item");
    a("SessionId", (String)localObject2, (LinkedList)localObject3);
    localObject2 = this.jXn;
    if (localObject2 == null) {
      j.ays("controller");
    }
    i = ((b)localObject2).kfv;
    localObject2 = localdz.wnb;
    j.p(localObject2, "reportData.item");
    a("EnterId", String.valueOf(i), (LinkedList)localObject2);
    localObject2 = localdz.wnb;
    j.p(localObject2, "reportData.item");
    a("NativePage", "1", (LinkedList)localObject2);
    localObject2 = this.jXn;
    if (localObject2 == null) {
      j.ays("controller");
    }
    localObject2 = ((b)localObject2).url;
    localObject3 = localdz.wnb;
    j.p(localObject3, "reportData.item");
    a("#AppMsgUrl#", (String)localObject2, (LinkedList)localObject3);
    ((ea)localObject1).wpY.add(localdz);
    localObject2 = this.jXn;
    if (localObject2 == null) {
      j.ays("controller");
    }
    ((b)localObject2).a((ea)localObject1);
    localObject1 = localdz.wnb;
    j.p(localObject1, "reportData.item");
    b(10945, (LinkedList)localObject1);
    AppMethodBeat.o(152964);
  }
  
  private final void b(int paramInt, LinkedList<ec> paramLinkedList)
  {
    AppMethodBeat.i(15327);
    if ((ab.getLogLevel() <= 0) && (!bo.es((List)paramLinkedList)))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      paramLinkedList = paramLinkedList.iterator();
      while (paramLinkedList.hasNext())
      {
        ec localec = (ec)paramLinkedList.next();
        localStringBuilder.append(localec.key).append(":").append(localec.fnF).append("  ");
      }
      ab.v(this.TAG, paramInt + ", " + localStringBuilder);
    }
    AppMethodBeat.o(15327);
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(152963);
    j.q(paramb, "controller");
    this.jXn = paramb;
    AppMethodBeat.o(152963);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(152966);
    if (this.kin.size() > 0)
    {
      Object localObject1 = new LinkedList();
      Object localObject2 = this.kin.entrySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Object localObject3 = ((Iterator)localObject2).next();
        j.p(localObject3, "it.next()");
        localObject3 = ((Map.Entry)localObject3).getValue();
        j.p(localObject3, "entry.value");
        ((LinkedList)localObject1).add((ur)localObject3);
      }
      localObject2 = new ed();
      ((ed)localObject2).wpZ = ((LinkedList)localObject1);
      localObject1 = this.jXn;
      if (localObject1 == null) {
        j.ays("controller");
      }
      ((b)localObject1).a((ed)localObject2);
      this.kin.clear();
    }
    aZO();
    AppMethodBeat.o(152966);
  }
  
  public final void sK(int paramInt)
  {
    AppMethodBeat.i(15326);
    Object localObject1 = new ea();
    dz localdz = new dz();
    localdz.type = 2;
    Object localObject2 = this.jXn;
    if (localObject2 == null) {
      j.ays("controller");
    }
    localObject2 = ((b)localObject2).fgl;
    Object localObject3 = localdz.wnb;
    j.p(localObject3, "reportData.item");
    a("Vid", (String)localObject2, (LinkedList)localObject3);
    localObject2 = at.gU(ah.getContext());
    localObject3 = localdz.wnb;
    j.p(localObject3, "reportData.item");
    a("Network", (String)localObject2, (LinkedList)localObject3);
    localObject2 = localdz.wnb;
    j.p(localObject2, "reportData.item");
    a("SharePageType", "2", (LinkedList)localObject2);
    localObject2 = this.jXn;
    if (localObject2 == null) {
      j.ays("controller");
    }
    localObject2 = ((b)localObject2).url;
    localObject3 = localdz.wnb;
    j.p(localObject3, "reportData.item");
    a("ContentUrl", (String)localObject2, (LinkedList)localObject3);
    localObject2 = new StringBuilder();
    localObject3 = this.jXn;
    if (localObject3 == null) {
      j.ays("controller");
    }
    localObject2 = ((b)localObject3).kfx;
    localObject3 = localdz.wnb;
    j.p(localObject3, "reportData.item");
    a("SessionId", (String)localObject2, (LinkedList)localObject3);
    localObject2 = this.jXn;
    if (localObject2 == null) {
      j.ays("controller");
    }
    int i = ((b)localObject2).kfv;
    localObject2 = localdz.wnb;
    j.p(localObject2, "reportData.item");
    a("EnterId", String.valueOf(i), (LinkedList)localObject2);
    localObject2 = localdz.wnb;
    j.p(localObject2, "reportData.item");
    a("NativePage", "1", (LinkedList)localObject2);
    localObject2 = this.jXn;
    if (localObject2 == null) {
      j.ays("controller");
    }
    localObject2 = ((b)localObject2).url;
    localObject3 = localdz.wnb;
    j.p(localObject3, "reportData.item");
    a("#AppMsgUrl#", (String)localObject2, (LinkedList)localObject3);
    localObject2 = localdz.wnb;
    j.p(localObject2, "reportData.item");
    a("ActionType", String.valueOf(paramInt), (LinkedList)localObject2);
    ((ea)localObject1).wpY.add(localdz);
    localObject2 = this.jXn;
    if (localObject2 == null) {
      j.ays("controller");
    }
    ((b)localObject2).a((ea)localObject1);
    localObject1 = localdz.wnb;
    j.p(localObject1, "reportData.item");
    b(10380, (LinkedList)localObject1);
    AppMethodBeat.o(15326);
  }
  
  public final void sL(int paramInt)
  {
    AppMethodBeat.i(152965);
    Object localObject1 = new ea();
    dz localdz = new dz();
    localdz.type = 3;
    Object localObject2 = this.jXn;
    if (localObject2 == null) {
      j.ays("controller");
    }
    localObject2 = ((b)localObject2).url;
    Object localObject3 = localdz.wnb;
    j.p(localObject3, "reportData.item");
    a("#AppMsgUrl#", (String)localObject2, (LinkedList)localObject3);
    localObject2 = this.jXn;
    if (localObject2 == null) {
      j.ays("controller");
    }
    localObject2 = ((b)localObject2).fgl;
    localObject3 = localdz.wnb;
    j.p(localObject3, "reportData.item");
    a("VideoId", (String)localObject2, (LinkedList)localObject3);
    localObject2 = new StringBuilder();
    localObject3 = this.jXn;
    if (localObject3 == null) {
      j.ays("controller");
    }
    localObject2 = ((b)localObject3).kfx;
    localObject3 = localdz.wnb;
    j.p(localObject3, "reportData.item");
    a("SessionId", (String)localObject2, (LinkedList)localObject3);
    localObject2 = this.jXn;
    if (localObject2 == null) {
      j.ays("controller");
    }
    int i = ((b)localObject2).kfv;
    localObject2 = localdz.wnb;
    j.p(localObject2, "reportData.item");
    a("EnterId", String.valueOf(i), (LinkedList)localObject2);
    localObject2 = this.jXn;
    if (localObject2 == null) {
      j.ays("controller");
    }
    i = ((b)localObject2).scene;
    localObject2 = localdz.wnb;
    j.p(localObject2, "reportData.item");
    a("Scene", String.valueOf(i), (LinkedList)localObject2);
    localObject2 = this.jXn;
    if (localObject2 == null) {
      j.ays("controller");
    }
    i = ((b)localObject2).kbN;
    localObject2 = localdz.wnb;
    j.p(localObject2, "reportData.item");
    a("SubScene", String.valueOf(i), (LinkedList)localObject2);
    long l = System.currentTimeMillis();
    localObject2 = localdz.wnb;
    j.p(localObject2, "reportData.item");
    a("ClientId", String.valueOf(l), (LinkedList)localObject2);
    localObject2 = localdz.wnb;
    j.p(localObject2, "reportData.item");
    a("EventType", String.valueOf(paramInt), (LinkedList)localObject2);
    ((ea)localObject1).wpY.add(localdz);
    localObject2 = this.jXn;
    if (localObject2 == null) {
      j.ays("controller");
    }
    ((b)localObject2).a((ea)localObject1);
    localObject1 = localdz.wnb;
    j.p(localObject1, "reportData.item");
    b(17537, (LinkedList)localObject1);
    AppMethodBeat.o(152965);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.video.util.g
 * JD-Core Version:    0.7.0.1
 */