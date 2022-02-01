package com.tencent.mm.plugin.finder.utils;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cw.f;
import com.tencent.mm.model.cm;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.cgi.ag;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.viewmodel.component.aj.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vending.c.a;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.a.j;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.r;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/utils/FinderObjectStatusRefresher;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "objectStatusReqMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/plugin/finder/utils/FinderObjectStatusRefresher$ObjectStatusReqState;", "getObjectStatusReqMap", "()Ljava/util/concurrent/ConcurrentHashMap;", "canReqObjectStatus", "", "feedId", "clearObjectStatusStates", "", "createTriple", "Lkotlin/Triple;", "tips", "refreshInterval", "lastReqTime", "waitTime", "refreshObjectStatus", "context", "Landroid/content/Context;", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "scene", "", "cgiBack", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "result", "ObjectStatusReqState", "plugin-finder_release"})
public final class t
{
  private static final ConcurrentHashMap<Long, t.a> ADM;
  public static final t ADN;
  private static final String TAG = "Finder.ObjectStatusRefresher";
  
  static
  {
    AppMethodBeat.i(167895);
    ADN = new t();
    TAG = "Finder.ObjectStatusRefresher";
    ADM = new ConcurrentHashMap();
    AppMethodBeat.o(167895);
  }
  
  public static r<String, String, String> a(Context paramContext, BaseFinderFeed paramBaseFinderFeed, int paramInt, final b<? super r<String, String, String>, x> paramb)
  {
    AppMethodBeat.i(281937);
    p.k(paramContext, "context");
    p.k(paramBaseFinderFeed, "feed");
    p.k(paramb, "cgiBack");
    final long l1 = paramBaseFinderFeed.feedObject.getId();
    long l2 = cm.bfC() / 1000L;
    Object localObject = (t.a)ADM.get(Long.valueOf(l1));
    int i;
    if (localObject != null) {
      if (cm.bfC() / 1000L - ((t.a)localObject).ADO >= ((t.a)localObject).waitTime)
      {
        i = 1;
        if (i == 0) {
          break label240;
        }
        localObject = paramBaseFinderFeed.feedObject.getObjectNonceId();
        String str = paramBaseFinderFeed.feedObject.getUserName();
        aj.a locala = com.tencent.mm.plugin.finder.viewmodel.component.aj.Bnu;
        paramContext = aj.a.fZ(paramContext);
        if (paramContext == null) {
          break label235;
        }
        paramContext = paramContext.ekY();
        label129:
        new ag(l1, (String)localObject, 3, paramInt, str, false, null, null, 0L, null, false, true, null, paramContext, 0, null, 55264).bhW().h((a)new b(paramBaseFinderFeed, l1, l2)).b((a)new c(paramBaseFinderFeed, paramb));
      }
    }
    for (;;)
    {
      paramContext = paramBaseFinderFeed.feedObject.getNotShareMsg();
      if (paramContext != null) {
        break label309;
      }
      paramContext = new kotlin.t("null cannot be cast to non-null type kotlin.CharSequence");
      AppMethodBeat.o(281937);
      throw paramContext;
      i = 0;
      break;
      i = 1;
      break;
      label235:
      paramContext = null;
      break label129;
      label240:
      paramContext = (t.a)ADM.get(Long.valueOf(l1));
      if (paramContext != null) {
        Log.w(TAG, "can't request. lastReqTime=" + l2 + " lastReqTime=" + paramContext.ADO + " waitTime=" + paramContext.waitTime);
      }
    }
    label309:
    paramContext = aFC(n.bb((CharSequence)paramContext).toString());
    AppMethodBeat.o(281937);
    return paramContext;
  }
  
  private static r<String, String, String> aFC(String paramString)
  {
    AppMethodBeat.i(167894);
    Object localObject3 = "";
    Object localObject1 = "";
    Object localObject2 = "";
    Object localObject4 = n.a((CharSequence)paramString, new String[] { "#" });
    paramString = (String)localObject2;
    if (((List)localObject4).size() >= 3)
    {
      localObject2 = (String)j.M((List)localObject4, 0);
      if (localObject2 != null) {
        break label204;
      }
      localObject2 = "";
    }
    label204:
    for (;;)
    {
      String str = (String)j.M((List)localObject4, 1);
      if (str == null) {
        str = "";
      }
      for (;;)
      {
        localObject4 = (String)j.M((List)localObject4, 2);
        paramString = (String)localObject4;
        localObject3 = localObject2;
        localObject1 = str;
        if (localObject4 == null)
        {
          paramString = "";
          localObject1 = str;
          localObject3 = localObject2;
        }
        localObject2 = localObject3;
        if (Util.isNullOrNil((String)localObject3))
        {
          localObject2 = aj.AGc;
          localObject2 = aj.el("FinderSafeSelfSeeForward", b.j.finder_self_see_tips_forward);
        }
        localObject3 = localObject1;
        if (Util.isNullOrNil((String)localObject1))
        {
          localObject1 = aj.AGc;
          localObject3 = aj.el("FinderSafeSelfSeeShare", b.j.finder_self_see_tips_sns);
        }
        localObject1 = paramString;
        if (Util.isNullOrNil(paramString))
        {
          paramString = aj.AGc;
          localObject1 = aj.el("FinderSafeSelfSeeCollect", b.j.finder_self_see_tips_fav);
        }
        paramString = new r(localObject2, localObject3, localObject1);
        AppMethodBeat.o(167894);
        return paramString;
      }
    }
  }
  
  public static String getTAG()
  {
    return TAG;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "result", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderGetCommentDetailResponse;", "kotlin.jvm.PlatformType", "call"})
  static final class b<_Ret, _Var>
    implements a<_Ret, _Var>
  {
    b(BaseFinderFeed paramBaseFinderFeed, long paramLong1, long paramLong2) {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "kotlin.jvm.PlatformType", "call", "(Lkotlin/Unit;)V"})
  static final class c<_Ret, _Var>
    implements a<_Ret, _Var>
  {
    c(BaseFinderFeed paramBaseFinderFeed, b paramb) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.t
 * JD-Core Version:    0.7.0.1
 */