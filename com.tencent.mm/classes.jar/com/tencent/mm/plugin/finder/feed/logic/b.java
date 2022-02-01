package com.tencent.mm.plugin.finder.feed.logic;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cn.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.a.c;
import com.tencent.mm.plugin.finder.event.a.b;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.sdk.platformtools.ac;
import d.g.b.k;
import d.l;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/feed/logic/FinderNoInterestedLogic;", "", "()V", "TAG", "", "TYPE_NO_INTERESTED_OF_AUTHOR", "", "TYPE_NO_INTERESTED_OF_FEED", "handleNoInterestedAuthor", "", "context", "Landroid/content/Context;", "feedId", "", "objectNonceId", "onSelectedCallback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "type", "", "plugin-finder_release"})
public final class b
{
  public static final b rmm;
  
  static
  {
    AppMethodBeat.i(166015);
    rmm = new b();
    AppMethodBeat.o(166015);
  }
  
  public static void a(Context paramContext, long paramLong, String paramString, d.g.a.b<? super Integer, ? extends List<Long>> paramb)
  {
    AppMethodBeat.i(202036);
    k.h(paramContext, "context");
    k.h(paramString, "objectNonceId");
    k.h(paramb, "onSelectedCallback");
    Object localObject = (List)paramb.ay(Integer.valueOf(2));
    paramb = FinderReporterUIC.seQ;
    paramb = FinderReporterUIC.a.eV(paramContext);
    if (paramb != null) {}
    for (paramb = paramb.cGb();; paramb = null)
    {
      new com.tencent.mm.plugin.finder.cgi.d(paramLong, paramString, paramb).aBB().j((com.tencent.mm.vending.c.a)new b.a((List)localObject));
      e.wTc.idkeyStat(1278L, 9L, 1L, false);
      paramString = com.tencent.mm.plugin.finder.report.d.rxr;
      paramString = paramContext.getClass().getSimpleName();
      k.g(paramString, "context.javaClass.simpleName");
      k.h(paramString, "page");
      paramb = com.tencent.mm.plugin.finder.report.d.ur(paramLong);
      if (paramb != null)
      {
        localObject = paramb.getFeedObject();
        String str = ((c)g.ab(c.class)).cit();
        paramString = str + ',' + paramString + ',' + com.tencent.mm.plugin.finder.report.d.ut(((FinderObject)localObject).id) + ',' + ((FinderObject)localObject).username + ',' + paramb.getMediaType() + ',' + ((FinderObject)localObject).recommendType + ',' + ((FinderObject)localObject).likeCount + ',' + ((FinderObject)localObject).commentCount + ',' + ((FinderObject)localObject).friendLikeCount + ",0,0,0,2";
        ac.i(com.tencent.mm.plugin.finder.report.d.TAG, "18946 ".concat(String.valueOf(paramString)));
        e.wTc.kvStat(18946, paramString);
      }
      paramString = FinderReporterUIC.seQ;
      paramContext = FinderReporterUIC.a.eV(paramContext);
      if (paramContext == null) {
        break;
      }
      paramContext = FinderReporterUIC.b(paramContext);
      if (paramContext == null) {
        break;
      }
      paramContext.ctb().ua(paramLong);
      AppMethodBeat.o(202036);
      return;
    }
    AppMethodBeat.o(202036);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.logic.b
 * JD-Core Version:    0.7.0.1
 */