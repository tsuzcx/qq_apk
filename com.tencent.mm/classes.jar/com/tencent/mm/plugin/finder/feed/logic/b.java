package com.tencent.mm.plugin.finder.feed.logic;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.co.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.event.c.b;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.vending.c.a;
import d.g.b.k;
import d.l;
import java.util.List;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/logic/FinderNoInterestedLogic;", "", "()V", "TAG", "", "TYPE_NO_INTERESTED_OF_AUTHOR", "", "TYPE_NO_INTERESTED_OF_FEED", "handleNoInterestedAuthor", "", "context", "Landroid/content/Context;", "feedId", "", "objectNonceId", "onSelectedCallback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "type", "", "plugin-finder_release"})
public final class b
{
  public static final b qya;
  
  static
  {
    AppMethodBeat.i(166015);
    qya = new b();
    AppMethodBeat.o(166015);
  }
  
  public static void a(Context paramContext, long paramLong, String paramString, d.g.a.b<? super Integer, ? extends List<Long>> paramb)
  {
    AppMethodBeat.i(198128);
    k.h(paramContext, "context");
    k.h(paramString, "objectNonceId");
    k.h(paramb, "onSelectedCallback");
    Object localObject = (List)paramb.aA(Integer.valueOf(2));
    paramb = FinderReporterUIC.Ljl;
    paramb = FinderReporterUIC.a.lB(paramContext);
    if (paramb != null) {}
    for (paramb = paramb.fXs();; paramb = null)
    {
      new com.tencent.mm.plugin.finder.cgi.b(paramLong, paramString, paramb).auK().j((a)new a((List)localObject));
      e.vIY.idkeyStat(1278L, 9L, 1L, false);
      paramString = com.tencent.mm.plugin.finder.report.b.qFq;
      paramString = paramContext.getClass().getSimpleName();
      k.g(paramString, "context.javaClass.simpleName");
      k.h(paramString, "page");
      paramb = com.tencent.mm.plugin.finder.report.b.qh(paramLong);
      if (paramb != null)
      {
        localObject = paramb.getFeedObject();
        String str = ((com.tencent.mm.plugin.expt.a.c)g.ab(com.tencent.mm.plugin.expt.a.c.class)).cbk();
        paramString = str + ',' + paramString + ',' + com.tencent.mm.plugin.finder.report.b.qi(((FinderObject)localObject).id) + ',' + ((FinderObject)localObject).username + ',' + paramb.getMediaType() + ',' + ((FinderObject)localObject).recommendType + ',' + ((FinderObject)localObject).likeCount + ',' + ((FinderObject)localObject).commentCount + ',' + ((FinderObject)localObject).friendLikeCount + ",0,0,0,2";
        ad.i(com.tencent.mm.plugin.finder.report.b.TAG, "18946 ".concat(String.valueOf(paramString)));
        e.vIY.kvStat(18946, paramString);
      }
      paramString = FinderReporterUIC.Ljl;
      paramContext = FinderReporterUIC.a.lB(paramContext);
      if (paramContext == null) {
        break;
      }
      paramContext = FinderReporterUIC.b(paramContext);
      if (paramContext == null) {
        break;
      }
      paramContext.fSl().BC(paramLong);
      AppMethodBeat.o(198128);
      return;
    }
    AppMethodBeat.o(198128);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderFeedbackResponse;", "kotlin.jvm.PlatformType", "call"})
  static final class a<_Ret, _Var>
    implements a<_Ret, _Var>
  {
    a(List paramList) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.logic.b
 * JD-Core Version:    0.7.0.1
 */