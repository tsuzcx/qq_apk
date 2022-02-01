package com.tencent.mm.plugin.finder.utils;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cn.f;
import com.tencent.mm.model.cf;
import com.tencent.mm.plugin.finder.cgi.q;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vending.c.a;
import d.g.a.b;
import d.l;
import d.n.n;
import d.t;
import d.v;
import d.z;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/utils/FinderObjectStatusRefresher;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "objectStatusReqMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/plugin/finder/utils/FinderObjectStatusRefresher$ObjectStatusReqState;", "getObjectStatusReqMap", "()Ljava/util/concurrent/ConcurrentHashMap;", "canReqObjectStatus", "", "feedId", "clearObjectStatusStates", "", "createTriple", "Lkotlin/Triple;", "tips", "refreshInterval", "lastReqTime", "waitTime", "refreshObjectStatus", "context", "Landroid/content/Context;", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "scene", "", "cgiBack", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "result", "ObjectStatusReqState", "plugin-finder_release"})
public final class j
{
  private static final String TAG = "Finder.ObjectStatusRefresher";
  private static final ConcurrentHashMap<Long, j.a> sLp;
  public static final j sLq;
  
  static
  {
    AppMethodBeat.i(167895);
    sLq = new j();
    TAG = "Finder.ObjectStatusRefresher";
    sLp = new ConcurrentHashMap();
    AppMethodBeat.o(167895);
  }
  
  public static t<String, String, String> a(Context paramContext, BaseFinderFeed paramBaseFinderFeed, int paramInt, final b<? super t<String, String, String>, z> paramb)
  {
    AppMethodBeat.i(204479);
    d.g.b.p.h(paramContext, "context");
    d.g.b.p.h(paramBaseFinderFeed, "feed");
    d.g.b.p.h(paramb, "cgiBack");
    final long l1 = paramBaseFinderFeed.feedObject.getId();
    long l2 = cf.aCK() / 1000L;
    Object localObject = (j.a)sLp.get(Long.valueOf(l1));
    int i;
    if (localObject != null) {
      if (cf.aCK() / 1000L - ((j.a)localObject).sLr >= ((j.a)localObject).waitTime)
      {
        i = 1;
        if (i == 0) {
          break label240;
        }
        localObject = paramBaseFinderFeed.feedObject.getObjectNonceId();
        String str = paramBaseFinderFeed.feedObject.getUserName();
        FinderReporterUIC.a locala = FinderReporterUIC.tcM;
        paramContext = FinderReporterUIC.a.eY(paramContext);
        if (paramContext == null) {
          break label235;
        }
        paramContext = paramContext.cOu();
        label129:
        new q(l1, (String)localObject, 3, paramInt, str, false, null, null, 0L, null, false, true, null, paramContext, 0, 22496).aED().h((a)new b(paramBaseFinderFeed, l1, l2)).b((a)new c(paramBaseFinderFeed, paramb));
      }
    }
    for (;;)
    {
      paramContext = paramBaseFinderFeed.feedObject.getNotShareMsg();
      if (paramContext != null) {
        break label309;
      }
      paramContext = new v("null cannot be cast to non-null type kotlin.CharSequence");
      AppMethodBeat.o(204479);
      throw paramContext;
      i = 0;
      break;
      i = 1;
      break;
      label235:
      paramContext = null;
      break label129;
      label240:
      paramContext = (j.a)sLp.get(Long.valueOf(l1));
      if (paramContext != null) {
        ad.w(TAG, "can't request. lastReqTime=" + l2 + " lastReqTime=" + paramContext.sLr + " waitTime=" + paramContext.waitTime);
      }
    }
    label309:
    paramContext = aiS(n.trim((CharSequence)paramContext).toString());
    AppMethodBeat.o(204479);
    return paramContext;
  }
  
  private static t<String, String, String> aiS(String paramString)
  {
    AppMethodBeat.i(167894);
    Object localObject3 = "";
    Object localObject1 = "";
    Object localObject2 = "";
    Object localObject4 = n.a((CharSequence)paramString, new String[] { "#" });
    paramString = (String)localObject2;
    if (((List)localObject4).size() >= 3)
    {
      localObject2 = (String)d.a.j.E((List)localObject4, 0);
      if (localObject2 != null) {
        break label204;
      }
      localObject2 = "";
    }
    label204:
    for (;;)
    {
      String str = (String)d.a.j.E((List)localObject4, 1);
      if (str == null) {
        str = "";
      }
      for (;;)
      {
        localObject4 = (String)d.a.j.E((List)localObject4, 2);
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
        if (bt.isNullOrNil((String)localObject3))
        {
          localObject2 = p.sMo;
          localObject2 = p.dx("FinderSafeSelfSeeForward", 2131759344);
        }
        localObject3 = localObject1;
        if (bt.isNullOrNil((String)localObject1))
        {
          localObject1 = p.sMo;
          localObject3 = p.dx("FinderSafeSelfSeeShare", 2131759345);
        }
        localObject1 = paramString;
        if (bt.isNullOrNil(paramString))
        {
          paramString = p.sMo;
          localObject1 = p.dx("FinderSafeSelfSeeCollect", 2131759343);
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
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "result", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderGetCommentDetailResponse;", "kotlin.jvm.PlatformType", "call"})
  static final class b<_Ret, _Var>
    implements a<_Ret, _Var>
  {
    b(BaseFinderFeed paramBaseFinderFeed, long paramLong1, long paramLong2) {}
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "kotlin.jvm.PlatformType", "call", "(Lkotlin/Unit;)V"})
  static final class c<_Ret, _Var>
    implements a<_Ret, _Var>
  {
    c(BaseFinderFeed paramBaseFinderFeed, b paramb) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.j
 * JD-Core Version:    0.7.0.1
 */