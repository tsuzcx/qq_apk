package com.tencent.mm.plugin.finder.live.component.msginterceptor.appmsg;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.component.msginterceptor.f;
import com.tencent.mm.plugin.finder.live.util.u;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.j;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.m;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.n;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.o;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.p;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.q;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.r;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.s;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.t;
import com.tencent.mm.plugin.finder.live.viewmodel.data.h;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.bdm;
import com.tencent.mm.protocal.protobuf.bds;
import com.tencent.mm.protocal.protobuf.bgh;
import com.tencent.mm.protocal.protobuf.dom;
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
import kotlin.a.p;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/component/msginterceptor/appmsg/LiveLinkMicAppMsgInterceptor;", "Lcom/tencent/mm/plugin/finder/live/component/msginterceptor/IFinderLiveAppMsgInterceptor;", "liveContext", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "(Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;)V", "dealWithMsgList", "", "msgList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;", "legalMsgType", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class l
  extends f
{
  public l(com.tencent.mm.plugin.finder.live.model.context.a parama)
  {
    super(parama);
    AppMethodBeat.i(353287);
    AppMethodBeat.o(353287);
  }
  
  public final void ap(LinkedList<bdm> paramLinkedList)
  {
    AppMethodBeat.i(353312);
    s.u(paramLinkedList, "msgList");
    j localj = (j)eji().business(j.class);
    s.u(paramLinkedList, "remoteLiveAppMsg");
    LinkedList localLinkedList = new LinkedList();
    Object localObject1 = (Iterable)paramLinkedList;
    paramLinkedList = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = ((Iterator)localObject1).next();
      localObject3 = (bdm)localObject2;
      if (k.contains(localj.EfO, ((bdm)localObject3).msg_type)) {
        paramLinkedList.add(localObject2);
      }
    }
    localLinkedList.addAll((Collection)paramLinkedList);
    Object localObject3 = ((Iterable)localLinkedList).iterator();
    label1028:
    while (((Iterator)localObject3).hasNext())
    {
      bdm localbdm = (bdm)((Iterator)localObject3).next();
      bds localbds = new bds();
      localObject1 = (com.tencent.mm.bx.a)localbds;
      paramLinkedList = localbdm.ZNY;
      if (paramLinkedList == null) {
        paramLinkedList = null;
      }
      try
      {
        for (;;)
        {
          ((com.tencent.mm.bx.a)localObject1).parseFrom(paramLinkedList);
          Log.i("MMFinder.LiveLinkMicSlice", "receive apply mic msg: [sessionId:" + localbdm.session_id + ", applyUserSdkId:" + localbds.ZlX + ']');
          paramLinkedList = localbdm.session_id;
          if (paramLinkedList == null) {
            break;
          }
          if (localj.EfG.get(paramLinkedList) == null) {
            break label308;
          }
          Log.i("MMFinder.LiveLinkMicSlice", s.X("has received mic apply, skip msg. sessionId:", paramLinkedList));
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
        label308:
        if (localj.Efy == 5)
        {
          Log.i("MMFinder.LiveLinkMicSlice", s.X("handleLinkMicMsg: in random match, skip msg. sessionId:", paramLinkedList));
          continue;
        }
        ((Map)localj.EfG).put(paramLinkedList, Integer.valueOf(0));
        paramLinkedList = localj.Eft;
        s.s(paramLinkedList, "linkMicUserList");
        p.e(paramLinkedList, (kotlin.g.a.b)new j.m(localbds));
        List localList = localj.Eft;
        String str = localbds.ZlX;
        paramLinkedList = localbdm.ZOb;
        if (paramLinkedList == null)
        {
          paramLinkedList = null;
          label405:
          localObject1 = localbdm.ZOb;
          if (localObject1 != null) {
            break label726;
          }
          localObject1 = null;
          label420:
          localObject2 = localbdm.ZOb;
          if (localObject2 != null) {
            break label754;
          }
          localObject2 = null;
          label435:
          localList.add(new h(str, paramLinkedList, (String)localObject1, (String)localObject2, localbds.ZOf, localbdm.session_id, null, false, 0, null, null, 0, 0, false, null, localbds.ZOw, localbdm.ZOb, false, 851904));
          paramLinkedList = localj.Efu;
          s.s(paramLinkedList, "newLinkMicUserList");
          p.e(paramLinkedList, (kotlin.g.a.b)new j.n(localbds));
          localList = localj.Efu;
          str = localbds.ZlX;
          paramLinkedList = localbdm.ZOb;
          if (paramLinkedList != null) {
            break label782;
          }
          paramLinkedList = null;
          label546:
          localObject1 = localbdm.ZOb;
          if (localObject1 != null) {
            break label804;
          }
          localObject1 = null;
          label561:
          localObject2 = localbdm.ZOb;
          if (localObject2 != null) {
            break label832;
          }
          localObject2 = null;
          label576:
          localList.add(new h(str, paramLinkedList, (String)localObject1, (String)localObject2, localbds.ZOf, localbdm.session_id, null, false, 0, null, null, 0, 0, false, null, localbds.ZOw, localbdm.ZOb, false, 851904));
          paramLinkedList = u.DJC;
          paramLinkedList = localj.Cvf;
          if (paramLinkedList != null) {
            break label860;
          }
        }
        label726:
        label860:
        for (l = 0L;; l = paramLinkedList.CJK)
        {
          if (!u.oG(l)) {
            break label868;
          }
          paramLinkedList = localj.Eft;
          s.s(paramLinkedList, "linkMicUserList");
          p.e(paramLinkedList, (kotlin.g.a.b)j.o.Egf);
          paramLinkedList = localj.Efu;
          s.s(paramLinkedList, "newLinkMicUserList");
          p.e(paramLinkedList, (kotlin.g.a.b)j.p.Egg);
          break;
          paramLinkedList = paramLinkedList.contact;
          if (paramLinkedList == null)
          {
            paramLinkedList = null;
            break label405;
          }
          paramLinkedList = paramLinkedList.headUrl;
          break label405;
          localObject1 = ((bgh)localObject1).contact;
          if (localObject1 == null)
          {
            localObject1 = null;
            break label420;
          }
          localObject1 = ((FinderContact)localObject1).username;
          break label420;
          label754:
          localObject2 = ((bgh)localObject2).contact;
          if (localObject2 == null)
          {
            localObject2 = null;
            break label435;
          }
          localObject2 = ((FinderContact)localObject2).nickname;
          break label435;
          paramLinkedList = paramLinkedList.contact;
          if (paramLinkedList == null)
          {
            paramLinkedList = null;
            break label546;
          }
          paramLinkedList = paramLinkedList.headUrl;
          break label546;
          localObject1 = ((bgh)localObject1).contact;
          if (localObject1 == null)
          {
            localObject1 = null;
            break label561;
          }
          localObject1 = ((FinderContact)localObject1).username;
          break label561;
          localObject2 = ((bgh)localObject2).contact;
          if (localObject2 == null)
          {
            localObject2 = null;
            break label576;
          }
          localObject2 = ((FinderContact)localObject2).nickname;
          break label576;
        }
        label782:
        label804:
        label832:
        label868:
        paramLinkedList = u.DJC;
        paramLinkedList = localj.Cvf;
        if (paramLinkedList == null) {}
        for (l = 0L;; l = paramLinkedList.CJK)
        {
          if (!u.oH(l)) {
            break label949;
          }
          paramLinkedList = localj.Eft;
          s.s(paramLinkedList, "linkMicUserList");
          p.e(paramLinkedList, (kotlin.g.a.b)j.q.Egh);
          paramLinkedList = localj.Efu;
          s.s(paramLinkedList, "newLinkMicUserList");
          p.e(paramLinkedList, (kotlin.g.a.b)j.r.Egi);
          break;
        }
        label949:
        paramLinkedList = u.DJC;
        paramLinkedList = localj.Cvf;
        if (paramLinkedList != null) {}
      }
      for (long l = 0L;; l = paramLinkedList.CJK)
      {
        if (!u.oI(l)) {
          break label1028;
        }
        paramLinkedList = localj.Eft;
        s.s(paramLinkedList, "linkMicUserList");
        p.e(paramLinkedList, (kotlin.g.a.b)j.s.Egj);
        paramLinkedList = localj.Efu;
        s.s(paramLinkedList, "newLinkMicUserList");
        p.e(paramLinkedList, (kotlin.g.a.b)j.t.Egk);
        break;
      }
    }
    Log.i("MMFinder.LiveLinkMicSlice", s.X("handleLinkMicMsg applyMicMsgList:", localLinkedList));
    AppMethodBeat.o(353312);
  }
  
  public final int[] ejj()
  {
    return new int[] { 20003 };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.component.msginterceptor.appmsg.l
 * JD-Core Version:    0.7.0.1
 */