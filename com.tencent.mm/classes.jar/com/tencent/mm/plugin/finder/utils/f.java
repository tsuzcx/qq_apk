package com.tencent.mm.plugin.finder.utils;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ce;
import com.tencent.mm.plugin.finder.cgi.h;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vending.c.a;
import d.a.j;
import d.g.a.b;
import d.g.b.k;
import d.l;
import d.n.n;
import d.t;
import d.v;
import d.y;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/utils/FinderObjectStatusRefresher;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "objectStatusReqMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/plugin/finder/utils/FinderObjectStatusRefresher$ObjectStatusReqState;", "getObjectStatusReqMap", "()Ljava/util/concurrent/ConcurrentHashMap;", "canReqObjectStatus", "", "feedId", "clearObjectStatusStates", "", "createTriple", "Lkotlin/Triple;", "tips", "refreshInterval", "lastReqTime", "waitTime", "refreshObjectStatus", "context", "Landroid/content/Context;", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "scene", "", "cgiBack", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "result", "ObjectStatusReqState", "plugin-finder_release"})
public final class f
{
  private static final String TAG = "Finder.ObjectStatusRefresher";
  private static final ConcurrentHashMap<Long, a> qSr;
  public static final f qSs;
  
  static
  {
    AppMethodBeat.i(167895);
    qSs = new f();
    TAG = "Finder.ObjectStatusRefresher";
    qSr = new ConcurrentHashMap();
    AppMethodBeat.o(167895);
  }
  
  private static t<String, String, String> ZL(String paramString)
  {
    AppMethodBeat.i(167894);
    Object localObject3 = "";
    Object localObject1 = "";
    Object localObject2 = "";
    Object localObject4 = n.a((CharSequence)paramString, new String[] { "#" });
    paramString = (String)localObject2;
    if (((List)localObject4).size() >= 3)
    {
      localObject2 = (String)j.C((List)localObject4, 0);
      if (localObject2 != null) {
        break label198;
      }
      localObject2 = "";
    }
    label198:
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
        if (bt.isNullOrNil((String)localObject3))
        {
          localObject2 = i.qTa;
          localObject2 = i.dc("FinderSafeSelfSeeForward", 2131759344);
        }
        localObject3 = localObject1;
        if (bt.isNullOrNil((String)localObject1))
        {
          localObject1 = i.qTa;
          localObject3 = i.dc("FinderSafeSelfSeeShare", 2131759345);
        }
        localObject1 = paramString;
        if (bt.isNullOrNil(paramString))
        {
          paramString = i.qTa;
          localObject1 = i.dc("FinderSafeSelfSeeCollect", 2131759343);
        }
        paramString = new t(localObject2, localObject3, localObject1);
        AppMethodBeat.o(167894);
        return paramString;
      }
    }
  }
  
  public static t<String, String, String> a(Context paramContext, BaseFinderFeed paramBaseFinderFeed, int paramInt, final b<? super t<String, String, String>, y> paramb)
  {
    AppMethodBeat.i(199633);
    k.h(paramContext, "context");
    k.h(paramBaseFinderFeed, "feed");
    k.h(paramb, "cgiBack");
    final long l1 = paramBaseFinderFeed.feedObject.getId();
    long l2 = ce.asQ() / 1000L;
    Object localObject = (a)qSr.get(Long.valueOf(l1));
    int i;
    if (localObject != null) {
      if (ce.asQ() / 1000L - ((a)localObject).qSt >= ((a)localObject).waitTime)
      {
        i = 1;
        if (i == 0) {
          break label239;
        }
        localObject = paramBaseFinderFeed.feedObject.getObjectNonceId();
        String str = paramBaseFinderFeed.feedObject.getUserName();
        FinderReporterUIC.a locala = FinderReporterUIC.Ljl;
        paramContext = FinderReporterUIC.a.lB(paramContext);
        if (paramContext == null) {
          break label234;
        }
        paramContext = paramContext.fXs();
        label129:
        new h(l1, (String)localObject, 3, paramInt, str, false, null, null, 0L, null, false, true, null, paramContext, 6112).auK().h((a)new b(paramBaseFinderFeed, l1, l2)).b((a)new c(paramBaseFinderFeed, paramb));
      }
    }
    for (;;)
    {
      paramContext = paramBaseFinderFeed.feedObject.getNotShareMsg();
      if (paramContext != null) {
        break label310;
      }
      paramContext = new v("null cannot be cast to non-null type kotlin.CharSequence");
      AppMethodBeat.o(199633);
      throw paramContext;
      i = 0;
      break;
      i = 1;
      break;
      label234:
      paramContext = null;
      break label129;
      label239:
      paramContext = (a)qSr.get(Long.valueOf(l1));
      if (paramContext != null) {
        ad.w(TAG, "can't request. lastReqTime=" + l2 + " lastReqTime=" + paramContext.qSt + " waitTime=" + paramContext.waitTime);
      }
    }
    label310:
    paramContext = ZL(n.trim((CharSequence)paramContext).toString());
    AppMethodBeat.o(199633);
    return paramContext;
  }
  
  public static String getTAG()
  {
    return TAG;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/utils/FinderObjectStatusRefresher$ObjectStatusReqState;", "", "lastReqTime", "", "waitTime", "(JJ)V", "getLastReqTime", "()J", "getWaitTime", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "plugin-finder_release"})
  public static final class a
  {
    final long qSt;
    final long waitTime;
    
    public a(long paramLong1, long paramLong2)
    {
      this.qSt = paramLong1;
      this.waitTime = paramLong2;
    }
    
    public final boolean equals(Object paramObject)
    {
      if (this != paramObject)
      {
        if ((paramObject instanceof a))
        {
          paramObject = (a)paramObject;
          if ((this.qSt != paramObject.qSt) || (this.waitTime != paramObject.waitTime)) {}
        }
      }
      else {
        return true;
      }
      return false;
    }
    
    public final int hashCode()
    {
      long l = this.qSt;
      int i = (int)(l ^ l >>> 32);
      l = this.waitTime;
      return i * 31 + (int)(l ^ l >>> 32);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(167890);
      String str = "ObjectStatusReqState(lastReqTime=" + this.qSt + ", waitTime=" + this.waitTime + ")";
      AppMethodBeat.o(167890);
      return str;
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "result", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderGetCommentDetailResponse;", "kotlin.jvm.PlatformType", "call"})
  static final class b<_Ret, _Var>
    implements a<_Ret, _Var>
  {
    b(BaseFinderFeed paramBaseFinderFeed, long paramLong1, long paramLong2) {}
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "kotlin.jvm.PlatformType", "call", "(Lkotlin/Unit;)V"})
  static final class c<_Ret, _Var>
    implements a<_Ret, _Var>
  {
    c(BaseFinderFeed paramBaseFinderFeed, b paramb) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.f
 * JD-Core Version:    0.7.0.1
 */