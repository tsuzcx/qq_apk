package com.tencent.mm.plugin.finder.utils;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b.a;
import com.tencent.mm.cp.f;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.finder.cgi.az;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.d;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.plugin.finder.viewmodel.component.as.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.ayl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.n.n;
import kotlin.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/utils/FinderObjectStatusRefresher;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "objectStatusReqMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/plugin/finder/utils/FinderObjectStatusRefresher$ObjectStatusReqState;", "getObjectStatusReqMap", "()Ljava/util/concurrent/ConcurrentHashMap;", "canReqObjectStatus", "", "feedId", "clearObjectStatusStates", "", "createTriple", "Lkotlin/Triple;", "tips", "refreshInterval", "lastReqTime", "waitTime", "refreshObjectStatus", "context", "Landroid/content/Context;", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "scene", "", "cgiBack", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "result", "ObjectStatusReqState", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class aa
{
  public static final aa GgZ;
  private static final ConcurrentHashMap<Long, aa.a> Gha;
  private static final String TAG;
  
  static
  {
    AppMethodBeat.i(167895);
    GgZ = new aa();
    TAG = "Finder.ObjectStatusRefresher";
    Gha = new ConcurrentHashMap();
    AppMethodBeat.o(167895);
  }
  
  private static final ah a(BaseFinderFeed paramBaseFinderFeed, long paramLong1, long paramLong2, b.a parama)
  {
    AppMethodBeat.i(333527);
    s.u(paramBaseFinderFeed, "$feed");
    if ((parama.errType == 0) && (parama.errCode == 0))
    {
      FinderObject localFinderObject = ((ayl)parama.ott).feedObject;
      if (localFinderObject != null)
      {
        Log.i(TAG, "lxl CgiGetFinderFeedComment change objectStatus, from:" + paramBaseFinderFeed.feedObject.getFeedObject().objectStatus + ", to:" + localFinderObject.objectStatus + ", waitTime:" + ((ayl)parama.ott).ZJn);
        paramBaseFinderFeed.feedObject.getFeedObject().objectStatus = localFinderObject.objectStatus;
      }
      if (paramBaseFinderFeed.feedObject.isOnlySelfSee())
      {
        long l = ((ayl)parama.ott).ZJn;
        Log.i(TAG, "[refreshInterval] feedId=" + paramLong1 + " lastReqTime=" + paramLong2 + " waitTime=" + l);
        Gha.put(Long.valueOf(paramLong1), new aa.a(paramLong2, l));
      }
    }
    paramBaseFinderFeed = ah.aiuX;
    AppMethodBeat.o(333527);
    return paramBaseFinderFeed;
  }
  
  private static final ah a(BaseFinderFeed paramBaseFinderFeed, kotlin.g.a.b paramb, ah paramah)
  {
    AppMethodBeat.i(333537);
    s.u(paramBaseFinderFeed, "$feed");
    s.u(paramb, "$cgiBack");
    paramBaseFinderFeed = paramBaseFinderFeed.feedObject.getNotShareMsg();
    if (paramBaseFinderFeed == null)
    {
      paramBaseFinderFeed = new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
      AppMethodBeat.o(333537);
      throw paramBaseFinderFeed;
    }
    paramBaseFinderFeed = n.bq((CharSequence)paramBaseFinderFeed).toString();
    Log.i(TAG, s.X("[refreshObjectStatus] tips=", paramBaseFinderFeed));
    paramb.invoke(aBz(paramBaseFinderFeed));
    paramBaseFinderFeed = ah.aiuX;
    AppMethodBeat.o(333537);
    return paramBaseFinderFeed;
  }
  
  public static u<String, String, String> a(Context paramContext, BaseFinderFeed paramBaseFinderFeed, kotlin.g.a.b<? super u<String, String, String>, ah> paramb)
  {
    AppMethodBeat.i(333508);
    s.u(paramContext, "context");
    s.u(paramBaseFinderFeed, "feed");
    s.u(paramb, "cgiBack");
    long l1 = paramBaseFinderFeed.feedObject.getId();
    long l2 = cn.bDu() / 1000L;
    Object localObject = (aa.a)Gha.get(Long.valueOf(l1));
    int i;
    if ((localObject != null) && (cn.bDu() / 1000L - ((aa.a)localObject).Ghb < ((aa.a)localObject).waitTime))
    {
      i = 0;
      if (i == 0) {
        break label226;
      }
      localObject = paramBaseFinderFeed.feedObject.getObjectNonceId();
      String str = paramBaseFinderFeed.feedObject.getUserName();
      as.a locala = as.GSQ;
      paramContext = as.a.hu(paramContext);
      if (paramContext != null) {
        break label218;
      }
      paramContext = null;
      label124:
      new az(l1, (String)localObject, 3, 2, str, false, null, null, 0L, null, false, true, null, paramContext, 0, null, 55264).bFJ().h(new aa..ExternalSyntheticLambda0(paramBaseFinderFeed, l1, l2)).b(new aa..ExternalSyntheticLambda1(paramBaseFinderFeed, paramb));
    }
    for (;;)
    {
      paramContext = paramBaseFinderFeed.feedObject.getNotShareMsg();
      if (paramContext != null) {
        break label296;
      }
      paramContext = new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
      AppMethodBeat.o(333508);
      throw paramContext;
      i = 1;
      break;
      label218:
      paramContext = paramContext.fou();
      break label124;
      label226:
      paramContext = (aa.a)Gha.get(Long.valueOf(l1));
      if (paramContext != null) {
        Log.w(TAG, "can't request. lastReqTime=" + l2 + " lastReqTime=" + paramContext.Ghb + " waitTime=" + paramContext.waitTime);
      }
    }
    label296:
    paramContext = aBz(n.bq((CharSequence)paramContext).toString());
    AppMethodBeat.o(333508);
    return paramContext;
  }
  
  private static u<String, String, String> aBz(String paramString)
  {
    AppMethodBeat.i(167894);
    Object localObject3 = "";
    Object localObject1 = "";
    Object localObject2 = "";
    Object localObject4 = n.a((CharSequence)paramString, new String[] { "#" });
    paramString = (String)localObject2;
    if (((List)localObject4).size() >= 3)
    {
      localObject2 = (String)p.ae((List)localObject4, 0);
      if (localObject2 != null) {
        break label229;
      }
      localObject2 = "";
      String str = (String)p.ae((List)localObject4, 1);
      if (str != null) {
        break label232;
      }
      str = "";
      label89:
      localObject4 = (String)p.ae((List)localObject4, 2);
      paramString = (String)localObject4;
      localObject3 = localObject2;
      localObject1 = str;
      if (localObject4 == null)
      {
        paramString = "";
        localObject1 = str;
        localObject3 = localObject2;
      }
    }
    localObject2 = localObject3;
    if (Util.isNullOrNil((String)localObject3))
    {
      localObject2 = av.GiL;
      localObject2 = av.eX("FinderSafeSelfSeeForward", e.h.finder_self_see_tips_forward);
    }
    localObject3 = localObject1;
    if (Util.isNullOrNil((String)localObject1))
    {
      localObject1 = av.GiL;
      localObject3 = av.eX("FinderSafeSelfSeeShare", e.h.finder_self_see_tips_sns);
    }
    localObject1 = paramString;
    if (Util.isNullOrNil(paramString))
    {
      paramString = d.FAy;
      if (((Number)d.eXJ().bmg()).intValue() != 0) {
        break label235;
      }
      paramString = av.GiL;
    }
    for (localObject1 = av.eX("FinderSafeSelfSeeCollect", e.h.finder_self_see_tips_fav);; localObject1 = av.eX("FinderSafeSelfSeeCollect", e.h.finder_self_see_tips_fav2))
    {
      paramString = new u(localObject2, localObject3, localObject1);
      AppMethodBeat.o(167894);
      return paramString;
      label229:
      break;
      label232:
      break label89;
      label235:
      paramString = av.GiL;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.aa
 * JD-Core Version:    0.7.0.1
 */