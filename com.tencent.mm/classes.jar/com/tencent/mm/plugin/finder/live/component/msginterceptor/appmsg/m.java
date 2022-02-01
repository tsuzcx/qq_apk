package com.tencent.mm.plugin.finder.live.component.msginterceptor.appmsg;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.model.g;
import com.tencent.mm.plugin.finder.live.component.msginterceptor.f;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.j;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.u;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.v;
import com.tencent.mm.plugin.finder.live.viewmodel.data.h;
import com.tencent.mm.protocal.protobuf.FinderAuthInfo;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.bdm;
import com.tencent.mm.protocal.protobuf.bdt;
import com.tencent.mm.protocal.protobuf.bgh;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.a.k;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/component/msginterceptor/appmsg/LiveLinkMicPkAppMsgInterceptor;", "Lcom/tencent/mm/plugin/finder/live/component/msginterceptor/IFinderLiveAppMsgInterceptor;", "liveContext", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "(Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;)V", "dealWithMsgList", "", "msgList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;", "legalMsgType", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class m
  extends f
{
  public m(com.tencent.mm.plugin.finder.live.model.context.a parama)
  {
    super(parama);
    AppMethodBeat.i(353289);
    AppMethodBeat.o(353289);
  }
  
  public final void ap(LinkedList<bdm> paramLinkedList)
  {
    AppMethodBeat.i(353316);
    s.u(paramLinkedList, "msgList");
    j localj = (j)eji().business(j.class);
    s.u(paramLinkedList, "remoteLiveAppMsg");
    LinkedList localLinkedList = new LinkedList();
    Object localObject1 = (Iterable)paramLinkedList;
    paramLinkedList = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    Object localObject2;
    Object localObject3;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = ((Iterator)localObject1).next();
      localObject3 = (bdm)localObject2;
      if (k.contains(localj.EfR, ((bdm)localObject3).msg_type)) {
        paramLinkedList.add(localObject2);
      }
    }
    localLinkedList.addAll((Collection)paramLinkedList);
    Iterator localIterator = ((Iterable)localLinkedList).iterator();
    bdm localbdm;
    bdt localbdt;
    label314:
    int i;
    label394:
    label496:
    List localList;
    String str1;
    for (;;)
    {
      if (!localIterator.hasNext()) {
        break label1084;
      }
      localbdm = (bdm)localIterator.next();
      localbdt = new bdt();
      localObject1 = (com.tencent.mm.bx.a)localbdt;
      paramLinkedList = localbdm.ZNY;
      if (paramLinkedList == null) {
        paramLinkedList = null;
      }
      try
      {
        for (;;)
        {
          ((com.tencent.mm.bx.a)localObject1).parseFrom(paramLinkedList);
          Log.i("MMFinder.LiveLinkMicSlice", "receive apply mic pk msg: [sessionId:" + localbdm.session_id + ", pkUserSdkId:" + localbdt.ZOj + ", pkSdkLiveId:" + localbdt.ZOk + ']');
          localObject1 = localbdm.session_id;
          if (localObject1 == null) {
            break;
          }
          if (localj.EfG.get(localObject1) == null) {
            break label314;
          }
          Log.i("MMFinder.LiveLinkMicSlice", s.X("has received mic pk apply, skip msg. sessionId:", localObject1));
          break;
          paramLinkedList = paramLinkedList.toByteArray();
        }
      }
      catch (Exception paramLinkedList)
      {
        for (;;)
        {
          Log.printDebugStack("safeParser", "", new Object[] { paramLinkedList });
        }
        ((Map)localj.EfG).put(localObject1, Integer.valueOf(0));
        paramLinkedList = localj.Eft;
        s.s(paramLinkedList, "linkMicUserList");
        kotlin.a.p.e(paramLinkedList, (kotlin.g.a.b)new j.u(localbdt));
        if (localj.Efy == 5)
        {
          localObject2 = new StringBuilder("handleLinkMicPkMsg: in random match, buffer size:");
          paramLinkedList = localbdt.ZOn;
          if (paramLinkedList == null)
          {
            paramLinkedList = null;
            Log.i("MMFinder.LiveLinkMicSlice", paramLinkedList + ", sessionId:" + (String)localObject1 + ", pkUserSdkId:" + localbdt.ZOj + ", pkSdkLiveId:" + localbdt.ZOk);
            paramLinkedList = localbdt.ZOn;
            if (paramLinkedList != null) {
              break label496;
            }
          }
          for (i = 0; i > 0; i = paramLinkedList.Op.length)
          {
            paramLinkedList = com.tencent.mm.live.model.p.mZf;
            paramLinkedList = com.tencent.mm.live.model.p.bhS();
            if (paramLinkedList == null) {
              break;
            }
            paramLinkedList.onRandomMicAccept(localbdm, localbdt);
            break;
            paramLinkedList = Integer.valueOf(paramLinkedList.Op.length);
            break label394;
          }
        }
        localList = localj.Eft;
        str1 = localbdt.ZOj;
        paramLinkedList = localbdm.ZOb;
        if (paramLinkedList != null) {
          break label828;
        }
      }
    }
    paramLinkedList = null;
    label531:
    localObject1 = localbdm.ZOb;
    label543:
    label558:
    String str2;
    label586:
    Object localObject4;
    if (localObject1 == null)
    {
      localObject1 = null;
      localObject2 = localbdm.ZOb;
      if (localObject2 != null) {
        break label872;
      }
      localObject2 = null;
      str2 = localbdm.session_id;
      i = localbdt.ZOk;
      localObject3 = localbdm.ZOb;
      if (localObject3 != null) {
        break label900;
      }
      localObject3 = null;
      localObject4 = localbdm.ZOb;
      if (localObject4 != null) {
        break label928;
      }
      localObject4 = null;
      label601:
      localList.add(new h(str1, paramLinkedList, (String)localObject1, (String)localObject2, 2, str2, null, true, i, (FinderAuthInfo)localObject3, (String)localObject4, 0, 0, false, localbdt.ZOx, 0L, localbdm.ZOb, false, 899072));
      paramLinkedList = localj.Efu;
      s.s(paramLinkedList, "newLinkMicUserList");
      kotlin.a.p.e(paramLinkedList, (kotlin.g.a.b)new j.v(localbdt));
      localList = localj.Efu;
      str1 = localbdt.ZOj;
      paramLinkedList = localbdm.ZOb;
      if (paramLinkedList != null) {
        break label956;
      }
      paramLinkedList = null;
      label706:
      localObject1 = localbdm.ZOb;
      if (localObject1 != null) {
        break label978;
      }
      localObject1 = null;
      label718:
      localObject2 = localbdm.ZOb;
      if (localObject2 != null) {
        break label1000;
      }
      localObject2 = null;
      label733:
      str2 = localbdm.session_id;
      i = localbdt.ZOk;
      localObject3 = localbdm.ZOb;
      if (localObject3 != null) {
        break label1028;
      }
      localObject3 = null;
      label761:
      localObject4 = localbdm.ZOb;
      if (localObject4 != null) {
        break label1056;
      }
      localObject4 = null;
    }
    for (;;)
    {
      localList.add(new h(str1, paramLinkedList, (String)localObject1, (String)localObject2, 2, str2, null, true, i, (FinderAuthInfo)localObject3, (String)localObject4, 0, 0, false, localbdt.ZOx, 0L, localbdm.ZOb, false, 899072));
      break;
      label828:
      paramLinkedList = paramLinkedList.contact;
      if (paramLinkedList == null)
      {
        paramLinkedList = null;
        break label531;
      }
      paramLinkedList = paramLinkedList.headUrl;
      break label531;
      localObject1 = ((bgh)localObject1).contact;
      if (localObject1 == null)
      {
        localObject1 = null;
        break label543;
      }
      localObject1 = ((FinderContact)localObject1).username;
      break label543;
      label872:
      localObject2 = ((bgh)localObject2).contact;
      if (localObject2 == null)
      {
        localObject2 = null;
        break label558;
      }
      localObject2 = ((FinderContact)localObject2).nickname;
      break label558;
      label900:
      localObject3 = ((bgh)localObject3).contact;
      if (localObject3 == null)
      {
        localObject3 = null;
        break label586;
      }
      localObject3 = ((FinderContact)localObject3).authInfo;
      break label586;
      label928:
      localObject4 = ((bgh)localObject4).contact;
      if (localObject4 == null)
      {
        localObject4 = null;
        break label601;
      }
      localObject4 = ((FinderContact)localObject4).signature;
      break label601;
      label956:
      paramLinkedList = paramLinkedList.contact;
      if (paramLinkedList == null)
      {
        paramLinkedList = null;
        break label706;
      }
      paramLinkedList = paramLinkedList.headUrl;
      break label706;
      label978:
      localObject1 = ((bgh)localObject1).contact;
      if (localObject1 == null)
      {
        localObject1 = null;
        break label718;
      }
      localObject1 = ((FinderContact)localObject1).username;
      break label718;
      label1000:
      localObject2 = ((bgh)localObject2).contact;
      if (localObject2 == null)
      {
        localObject2 = null;
        break label733;
      }
      localObject2 = ((FinderContact)localObject2).nickname;
      break label733;
      label1028:
      localObject3 = ((bgh)localObject3).contact;
      if (localObject3 == null)
      {
        localObject3 = null;
        break label761;
      }
      localObject3 = ((FinderContact)localObject3).authInfo;
      break label761;
      label1056:
      localObject4 = ((bgh)localObject4).contact;
      if (localObject4 == null) {
        localObject4 = null;
      } else {
        localObject4 = ((FinderContact)localObject4).signature;
      }
    }
    label1084:
    Log.i("MMFinder.LiveLinkMicSlice", s.X("handleLinkMicPkMsg applyMicPkMsgList:", localLinkedList));
    AppMethodBeat.o(353316);
  }
  
  public final int[] ejj()
  {
    return new int[] { 20015 };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.component.msginterceptor.appmsg.m
 * JD-Core Version:    0.7.0.1
 */