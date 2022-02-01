package com.tencent.mm.plugin.finder.live.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b.a;
import com.tencent.mm.autogen.mmdata.rpt.cm;
import com.tencent.mm.cp.f;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.expt.hellhound.ext.session.a.c;
import com.tencent.mm.plugin.finder.live.model.cgi.m;
import com.tencent.mm.plugin.finder.live.report.q.bo;
import com.tencent.mm.plugin.finder.live.report.q.bu;
import com.tencent.mm.plugin.finder.live.report.q.u;
import com.tencent.mm.plugin.finder.live.viewmodel.data.g;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.bca;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/model/FinderLiveFeedFlowReporter;", "", "()V", "TAG", "", "cacheMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "", "clientValidWatchTime", "", "currentTask", "Ljava/lang/Runnable;", "timer", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "checkAlreadyInCache", "", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "needCalculateWatchNumberOnFeedFlow", "tabType", "commentScene", "reportJoinLive", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderJoinLiveResp;", "finderObject", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "reportJoinLiveOnFeedFlow", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "startPlayLiveOnFeedFlow", "stopPlayLiveOnFeedFlow", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class o
{
  private static final ConcurrentHashMap<String, Set<Long>> Bgw;
  public static final o CFQ;
  private static Runnable CFR;
  private static final int CFS;
  private static final MTimerHandler timer;
  
  static
  {
    AppMethodBeat.i(359443);
    CFQ = new o();
    Bgw = new ConcurrentHashMap();
    com.tencent.d.a.a.a.a.a locala = com.tencent.d.a.a.a.a.a.ahiX;
    CFS = ((Number)com.tencent.d.a.a.a.a.a.jTR().bmg()).intValue();
    timer = new MTimerHandler("FinderLiveFeedFlowReporter::Timer", (MTimerHandler.CallBack)new o.a(), false);
    AppMethodBeat.o(359443);
  }
  
  private static final ah a(bip parambip, FinderObject paramFinderObject, b.a parama)
  {
    AppMethodBeat.i(359426);
    s.u(parambip, "$liveInfo");
    s.u(paramFinderObject, "$finderObject");
    int i = parama.errType;
    int j = parama.errCode;
    Object localObject1;
    if ((i == 0) && (j == 0))
    {
      Object localObject2 = (ConcurrentMap)Bgw;
      String str = z.bAW();
      localObject1 = ((ConcurrentMap)localObject2).get(str);
      if (localObject1 != null) {
        break label189;
      }
      Log.i("Finder.FinderLiveFeedFlowReporter", s.X("create set for ", z.bAW()));
      Set localSet = Collections.synchronizedSet((Set)new HashSet());
      localObject2 = ((ConcurrentMap)localObject2).putIfAbsent(str, localSet);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = localSet;
      }
    }
    label189:
    for (;;)
    {
      ((Set)localObject1).add(Long.valueOf(parambip.liveId));
      Log.i("Finder.FinderLiveFeedFlowReporter", "add liveId:" + parambip.liveId + " to set");
      a((bca)parama.ott, paramFinderObject);
      parambip = ah.aiuX;
      AppMethodBeat.o(359426);
      return parambip;
    }
  }
  
  private static void a(bca parambca, FinderObject paramFinderObject)
  {
    AppMethodBeat.i(359404);
    long l2 = System.currentTimeMillis();
    cm localcm = new cm();
    long l1;
    Object localObject;
    label74:
    String str;
    int i;
    if (parambca == null)
    {
      l1 = 0L;
      localcm.lK(com.tencent.mm.plugin.expt.hellhound.core.b.hF(l1));
      localcm.lL(com.tencent.mm.plugin.expt.hellhound.core.b.hF(paramFinderObject.id));
      localcm.lM(paramFinderObject.username);
      localObject = paramFinderObject.objectDesc;
      if (localObject != null) {
        break label740;
      }
      localObject = "";
      localcm.lN(URLEncoder.encode((String)localObject, "UTF-8"));
      localcm.lO("");
      str = com.tencent.mm.plugin.expt.hellhound.core.b.bys();
      localObject = str;
      if (str == null) {
        localObject = "";
      }
      localcm.lP((String)localObject);
      str = com.tencent.mm.plugin.expt.hellhound.core.b.dIX();
      localObject = str;
      if (str == null) {
        localObject = "";
      }
      localcm.lQ((String)localObject);
      str = c.dLD().dHN();
      localObject = str;
      if (str == null) {
        localObject = "";
      }
      localcm.lR((String)localObject);
      localcm.lT("");
      localcm.lS(paramFinderObject.sessionBuffer);
      localcm.iwR = l2;
      if (parambca != null) {
        break label764;
      }
      i = 0;
      label213:
      l1 = l2 - i;
      if (l1 <= 0L) {
        break label786;
      }
    }
    for (;;)
    {
      localcm.iwS = l1;
      localcm.iwV = q.u.DwE.status;
      localcm.iwW = l2;
      localcm.ikE = q.bu.DDj.action;
      localcm.iwY = 0L;
      localcm.iwZ = q.bo.DBL.action;
      localcm.lU("");
      localcm.bMH();
      parambca = new StringBuilder();
      parambca.append("reportJoinLive, liveId=").append(localcm.iuJ).append(", feedId=").append(localcm.iuI).append(", username=").append(localcm.irj).append(", topic=").append(localcm.iwN).append(", commentScene=").append(localcm.iwO).append(", isPrivate=").append(localcm.iwP).append(", contextId=").append(localcm.ipT).append(", clickTabContextId=").append(localcm.ipU).append(", sessionId=").append(localcm.iqO).append(", sessionBuffer=").append(localcm.iqp).append(", shopPermit=").append(localcm.iwQ).append(", enterSessionId=");
      parambca.append(localcm.iwR).append(", liveTime=").append(localcm.iwS).append(", floatDuration=").append(localcm.iwU).append(", fullDuration=").append(localcm.iwT).append(", enterStatus=").append(localcm.iwV).append(", actionTS=").append(localcm.iwW).append(", action=").append(localcm.ikE).append(", enterIconType=").append(localcm.iwY).append(", pageType=").append(localcm.iwZ).append(", adData=").append(localcm.ixa).append(", scenenote=").append(localcm.ixb).append(", identityType=").append(localcm.ixc);
      parambca.append(", request_id=").append(localcm.ixd).append(", actionStyle=").append(localcm.ixh).append(", actionResult=").append(localcm.iwX).append(", couponId=").append(localcm.ixi).append(", chnlExtra=").append(localcm.ixf);
      Log.i("Finder.FinderLiveFeedFlowReporter", parambca.toString());
      AppMethodBeat.o(359404);
      return;
      localObject = parambca.liveInfo;
      if (localObject == null)
      {
        l1 = 0L;
        break;
      }
      l1 = ((bip)localObject).liveId;
      break;
      label740:
      str = ((FinderObjectDesc)localObject).description;
      localObject = str;
      if (str != null) {
        break label74;
      }
      localObject = "";
      break label74;
      label764:
      parambca = parambca.liveInfo;
      if (parambca == null)
      {
        i = 0;
        break label213;
      }
      i = parambca.startTime;
      break label213;
      label786:
      l1 = 0L;
    }
  }
  
  public static void b(FinderObject paramFinderObject, bui parambui)
  {
    Object localObject2 = null;
    AppMethodBeat.i(359380);
    s.u(paramFinderObject, "finderObject");
    Object localObject1 = paramFinderObject.liveInfo;
    int i;
    label42:
    label51:
    StringBuilder localStringBuilder;
    if (localObject1 == null)
    {
      i = 0;
      if (i <= 0) {
        break label162;
      }
      localObject1 = paramFinderObject.liveInfo;
      if (localObject1 != null) {
        break label151;
      }
      localObject1 = null;
      if (localObject1 == null) {
        break label162;
      }
      i = ((Integer)localObject1).intValue();
      localStringBuilder = new StringBuilder("startPlayLiveOnFeedFlow: validWatchTime:").append(i).append(", serverConfigTime:");
      localObject1 = paramFinderObject.liveInfo;
      if (localObject1 != null) {
        break label169;
      }
    }
    label151:
    label162:
    label169:
    for (localObject1 = localObject2;; localObject1 = Integer.valueOf(((bip)localObject1).ZSh))
    {
      Log.i("Finder.FinderLiveFeedFlowReporter", localObject1 + ", clientValidWatchTime:" + CFS);
      CFR = new o..ExternalSyntheticLambda1(paramFinderObject, parambui);
      timer.startTimer(i * 1000L, 0L);
      AppMethodBeat.o(359380);
      return;
      i = ((bip)localObject1).ZSh;
      break;
      localObject1 = Integer.valueOf(((bip)localObject1).ZSh);
      break label42;
      i = CFS;
      break label51;
    }
  }
  
  public static void bUp()
  {
    AppMethodBeat.i(359385);
    Log.i("Finder.FinderLiveFeedFlowReporter", "stopPlayLiveOnFeedFlow");
    CFR = null;
    timer.stopTimer();
    AppMethodBeat.o(359385);
  }
  
  private static final void c(FinderObject paramFinderObject, bui parambui)
  {
    AppMethodBeat.i(359417);
    s.u(paramFinderObject, "$finderObject");
    bip localbip = paramFinderObject.liveInfo;
    Object localObject1;
    long l1;
    String str1;
    long l2;
    String str2;
    String str3;
    Object localObject2;
    if (localbip != null)
    {
      localObject1 = aj.CGT;
      localObject1 = aj.egD();
      if (localObject1 != null) {
        break label138;
      }
      localObject1 = "";
      l1 = localbip.liveId;
      str1 = z.bAW();
      l2 = paramFinderObject.id;
      str2 = paramFinderObject.objectNonceId;
      str3 = paramFinderObject.sessionBuffer;
      if (aj.CGT != null) {
        break label182;
      }
      localObject2 = null;
    }
    for (;;)
    {
      new m(l1, null, str1, l2, 2, str2, str3, null, 0, parambui, 1, null, (String)localObject2, (String)localObject1, 0, null, null, 117120).bFJ().g(new o..ExternalSyntheticLambda0(localbip, paramFinderObject));
      AppMethodBeat.o(359417);
      return;
      label138:
      localObject1 = ((g)localObject1).Eby;
      if (localObject1 == null)
      {
        localObject1 = "";
        break;
      }
      localObject2 = ((FinderLiveBundle)localObject1).ecSource;
      localObject1 = localObject2;
      if (localObject2 != null) {
        break;
      }
      localObject1 = "";
      break;
      label182:
      localObject2 = aj.getLiveCore();
      if (localObject2 == null) {
        localObject2 = null;
      } else {
        localObject2 = ((com.tencent.mm.live.core.core.trtc.a)localObject2).mSd;
      }
    }
  }
  
  public static boolean j(BaseFinderFeed paramBaseFinderFeed)
  {
    AppMethodBeat.i(359412);
    Set localSet = (Set)Bgw.get(z.bAW());
    if (localSet == null)
    {
      AppMethodBeat.o(359412);
      return false;
    }
    paramBaseFinderFeed = paramBaseFinderFeed.feedObject.getFeedObject().liveInfo;
    if (paramBaseFinderFeed == null) {}
    for (paramBaseFinderFeed = null; paramBaseFinderFeed == null; paramBaseFinderFeed = Long.valueOf(paramBaseFinderFeed.liveId))
    {
      AppMethodBeat.o(359412);
      return false;
    }
    boolean bool = localSet.contains(Long.valueOf(paramBaseFinderFeed.longValue()));
    AppMethodBeat.o(359412);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.o
 * JD-Core Version:    0.7.0.1
 */