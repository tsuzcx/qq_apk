package com.tencent.mm.plugin.finder.feed.logic;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.co.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.cgi.i;
import com.tencent.mm.plugin.finder.event.a.b;
import com.tencent.mm.plugin.finder.report.k;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.List;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/logic/FinderNoInterestedLogic;", "", "()V", "TAG", "", "TYPE_NO_INTERESTED_OF_AUTHOR", "", "TYPE_NO_INTERESTED_OF_FEED", "handleNoInterestedAuthor", "", "context", "Landroid/content/Context;", "feedId", "", "objectNonceId", "onSelectedCallback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "type", "", "plugin-finder_release"})
public final class c
{
  public static final c tUx;
  
  static
  {
    AppMethodBeat.i(166015);
    tUx = new c();
    AppMethodBeat.o(166015);
  }
  
  public static void a(Context paramContext, long paramLong, String paramString, b<? super Integer, ? extends List<Long>> paramb)
  {
    AppMethodBeat.i(244540);
    p.h(paramContext, "context");
    p.h(paramString, "objectNonceId");
    p.h(paramb, "onSelectedCallback");
    Object localObject = (List)paramb.invoke(Integer.valueOf(2));
    paramb = FinderReporterUIC.wzC;
    paramb = FinderReporterUIC.a.fH(paramContext);
    if (paramb != null) {}
    for (paramb = paramb.dIx();; paramb = null)
    {
      new i(paramLong, paramString, paramb).aYI().j((com.tencent.mm.vending.c.a)new a((List)localObject));
      e.Cxv.idkeyStat(1278L, 9L, 1L, false);
      paramString = k.vfA;
      paramString = paramContext.getClass().getSimpleName();
      p.g(paramString, "context.javaClass.simpleName");
      p.h(paramString, "page");
      paramb = k.Fc(paramLong);
      if (paramb != null)
      {
        localObject = paramb.getFeedObject();
        String str = ((com.tencent.mm.plugin.expt.b.c)g.af(com.tencent.mm.plugin.expt.b.c.class)).cMD();
        paramString = str + ',' + paramString + ',' + k.Fg(((FinderObject)localObject).id) + ',' + ((FinderObject)localObject).username + ',' + paramb.getMediaType() + ',' + ((FinderObject)localObject).recommendType + ',' + ((FinderObject)localObject).likeCount + ',' + ((FinderObject)localObject).commentCount + ',' + ((FinderObject)localObject).friendLikeCount + ",0,0,0,2";
        Log.i(k.TAG, "18946 ".concat(String.valueOf(paramString)));
        e.Cxv.kvStat(18946, paramString);
      }
      paramString = FinderReporterUIC.wzC;
      paramContext = FinderReporterUIC.a.fH(paramContext);
      if (paramContext == null) {
        break;
      }
      paramContext = FinderReporterUIC.b(paramContext);
      if (paramContext == null) {
        break;
      }
      paramContext.cZR().Et(paramLong);
      AppMethodBeat.o(244540);
      return;
    }
    AppMethodBeat.o(244540);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderFeedbackResponse;", "kotlin.jvm.PlatformType", "call"})
  static final class a<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    a(List paramList) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.logic.c
 * JD-Core Version:    0.7.0.1
 */