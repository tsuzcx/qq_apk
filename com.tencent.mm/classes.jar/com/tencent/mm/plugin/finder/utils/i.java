package com.tencent.mm.plugin.finder.utils;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cn.f;
import com.tencent.mm.model.ce;
import com.tencent.mm.plugin.finder.cgi.m;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.vending.c.a;
import d.a.j;
import d.g.a.b;
import d.g.b.k;
import d.l;
import d.t;
import d.v;
import d.y;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/utils/FinderObjectStatusRefresher;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "objectStatusReqMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/plugin/finder/utils/FinderObjectStatusRefresher$ObjectStatusReqState;", "getObjectStatusReqMap", "()Ljava/util/concurrent/ConcurrentHashMap;", "canReqObjectStatus", "", "feedId", "clearObjectStatusStates", "", "createTriple", "Lkotlin/Triple;", "tips", "refreshInterval", "lastReqTime", "waitTime", "refreshObjectStatus", "context", "Landroid/content/Context;", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "scene", "", "cgiBack", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "result", "ObjectStatusReqState", "plugin-finder_release"})
public final class i
{
  private static final String TAG = "Finder.ObjectStatusRefresher";
  private static final ConcurrentHashMap<Long, i.a> rOS;
  public static final i rOT;
  
  static
  {
    AppMethodBeat.i(167895);
    rOT = new i();
    TAG = "Finder.ObjectStatusRefresher";
    rOS = new ConcurrentHashMap();
    AppMethodBeat.o(167895);
  }
  
  public static t<String, String, String> a(Context paramContext, BaseFinderFeed paramBaseFinderFeed, int paramInt, final b<? super t<String, String, String>, y> paramb)
  {
    AppMethodBeat.i(203609);
    k.h(paramContext, "context");
    k.h(paramBaseFinderFeed, "feed");
    k.h(paramb, "cgiBack");
    final long l1 = paramBaseFinderFeed.feedObject.getId();
    long l2 = ce.azH() / 1000L;
    Object localObject = (i.a)rOS.get(Long.valueOf(l1));
    int i;
    if (localObject != null) {
      if (ce.azH() / 1000L - ((i.a)localObject).rOU >= ((i.a)localObject).waitTime)
      {
        i = 1;
        if (i == 0) {
          break label239;
        }
        localObject = paramBaseFinderFeed.feedObject.getObjectNonceId();
        String str = paramBaseFinderFeed.feedObject.getUserName();
        FinderReporterUIC.a locala = FinderReporterUIC.seQ;
        paramContext = FinderReporterUIC.a.eV(paramContext);
        if (paramContext == null) {
          break label234;
        }
        paramContext = paramContext.cGb();
        label129:
        new m(l1, (String)localObject, 3, paramInt, str, false, null, null, 0L, null, false, true, null, paramContext, 6112).aBB().h((a)new b(paramBaseFinderFeed, l1, l2)).b((a)new c(paramBaseFinderFeed, paramb));
      }
    }
    for (;;)
    {
      paramContext = paramBaseFinderFeed.feedObject.getNotShareMsg();
      if (paramContext != null) {
        break label308;
      }
      paramContext = new v("null cannot be cast to non-null type kotlin.CharSequence");
      AppMethodBeat.o(203609);
      throw paramContext;
      i = 0;
      break;
      i = 1;
      break;
      label234:
      paramContext = null;
      break label129;
      label239:
      paramContext = (i.a)rOS.get(Long.valueOf(l1));
      if (paramContext != null) {
        ac.w(TAG, "can't request. lastReqTime=" + l2 + " lastReqTime=" + paramContext.rOU + " waitTime=" + paramContext.waitTime);
      }
    }
    label308:
    paramContext = aey(d.n.n.trim((CharSequence)paramContext).toString());
    AppMethodBeat.o(203609);
    return paramContext;
  }
  
  private static t<String, String, String> aey(String paramString)
  {
    AppMethodBeat.i(167894);
    Object localObject3 = "";
    Object localObject1 = "";
    Object localObject2 = "";
    Object localObject4 = d.n.n.a((CharSequence)paramString, new String[] { "#" });
    paramString = (String)localObject2;
    if (((List)localObject4).size() >= 3)
    {
      localObject2 = (String)j.C((List)localObject4, 0);
      if (localObject2 != null) {
        break label204;
      }
      localObject2 = "";
    }
    label204:
    for (;;)
    {
      String str = (String)j.C((List)localObject4, 1);
      if (str == null) {
        str = "";
      }
      for (;;)
      {
        localObject4 = (String)j.C((List)localObject4, 2);
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
        if (bs.isNullOrNil((String)localObject3))
        {
          localObject2 = n.rPN;
          localObject2 = n.dh("FinderSafeSelfSeeForward", 2131759344);
        }
        localObject3 = localObject1;
        if (bs.isNullOrNil((String)localObject1))
        {
          localObject1 = n.rPN;
          localObject3 = n.dh("FinderSafeSelfSeeShare", 2131759345);
        }
        localObject1 = paramString;
        if (bs.isNullOrNil(paramString))
        {
          paramString = n.rPN;
          localObject1 = n.dh("FinderSafeSelfSeeCollect", 2131759343);
        }
        paramString = new t(localObject2, localObject3, localObject1);
        AppMethodBeat.o(167894);
        return paramString;
      }
    }
  }
  
  public static String getTAG()
  {
    return TAG;
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "result", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderGetCommentDetailResponse;", "kotlin.jvm.PlatformType", "call"})
  static final class b<_Ret, _Var>
    implements a<_Ret, _Var>
  {
    b(BaseFinderFeed paramBaseFinderFeed, long paramLong1, long paramLong2) {}
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "kotlin.jvm.PlatformType", "call", "(Lkotlin/Unit;)V"})
  static final class c<_Ret, _Var>
    implements a<_Ret, _Var>
  {
    c(BaseFinderFeed paramBaseFinderFeed, b paramb) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.i
 * JD-Core Version:    0.7.0.1
 */