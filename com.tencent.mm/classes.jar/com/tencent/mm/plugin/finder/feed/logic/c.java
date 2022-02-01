package com.tencent.mm.plugin.finder.feed.logic;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.cgi.m;
import com.tencent.mm.plugin.finder.event.a.b;
import com.tencent.mm.plugin.finder.report.n;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.viewmodel.component.aj;
import com.tencent.mm.plugin.finder.viewmodel.component.aj.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.List;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/logic/FinderNoInterestedLogic;", "", "()V", "TAG", "", "TYPE_NO_INTERESTED_OF_AUTHOR", "", "TYPE_NO_INTERESTED_OF_FEED", "handleNoInterestedAuthor", "", "context", "Landroid/content/Context;", "feedId", "", "objectNonceId", "onSelectedCallback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "type", "", "plugin-finder_release"})
public final class c
{
  public static final c xFs;
  
  static
  {
    AppMethodBeat.i(166015);
    xFs = new c();
    AppMethodBeat.o(166015);
  }
  
  public static void a(Context paramContext, long paramLong, String paramString, b<? super Integer, ? extends List<Long>> paramb)
  {
    AppMethodBeat.i(258443);
    p.k(paramContext, "context");
    p.k(paramString, "objectNonceId");
    p.k(paramb, "onSelectedCallback");
    Object localObject = (List)paramb.invoke(Integer.valueOf(2));
    paramb = aj.Bnu;
    paramb = aj.a.fZ(paramContext);
    if (paramb != null) {}
    for (paramb = paramb.ekY();; paramb = null)
    {
      new m(paramLong, paramString, paramb).bhW().j((com.tencent.mm.vending.c.a)new a((List)localObject));
      com.tencent.mm.plugin.report.f.Iyx.idkeyStat(1278L, 9L, 1L, false);
      paramString = n.zWF;
      paramString = paramContext.getClass().getSimpleName();
      p.j(paramString, "context.javaClass.simpleName");
      p.k(paramString, "page");
      paramb = n.Hc(paramLong);
      if (paramb != null)
      {
        localObject = paramb.getFeedObject();
        String str = ((com.tencent.mm.plugin.expt.b.c)h.ae(com.tencent.mm.plugin.expt.b.c.class)).dbr();
        paramString = str + ',' + paramString + ',' + n.Mp(((FinderObject)localObject).id) + ',' + ((FinderObject)localObject).username + ',' + paramb.getMediaType() + ',' + ((FinderObject)localObject).recommendType + ',' + ((FinderObject)localObject).likeCount + ',' + ((FinderObject)localObject).commentCount + ',' + ((FinderObject)localObject).friendLikeCount + ",0,0,0,2";
        Log.i(n.TAG, "18946 ".concat(String.valueOf(paramString)));
        com.tencent.mm.plugin.report.f.Iyx.kvStat(18946, paramString);
      }
      paramString = aj.Bnu;
      paramContext = aj.a.fZ(paramContext);
      if (paramContext == null) {
        break;
      }
      paramContext = aj.b(paramContext);
      if (paramContext == null) {
        break;
      }
      paramContext.dpO().KI(paramLong);
      AppMethodBeat.o(258443);
      return;
    }
    AppMethodBeat.o(258443);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderFeedbackResponse;", "kotlin.jvm.PlatformType", "call"})
  static final class a<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    a(List paramList) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.logic.c
 * JD-Core Version:    0.7.0.1
 */