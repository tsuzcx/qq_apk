package com.tencent.mm.plugin.finder.feed.logic;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cm.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.finder.event.a.b;
import com.tencent.mm.plugin.finder.report.i;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/feed/logic/FinderNoInterestedLogic;", "", "()V", "TAG", "", "TYPE_NO_INTERESTED_OF_AUTHOR", "", "TYPE_NO_INTERESTED_OF_FEED", "handleNoInterestedAuthor", "", "context", "Landroid/content/Context;", "feedId", "", "objectNonceId", "onSelectedCallback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "type", "", "plugin-finder_release"})
public final class b
{
  public static final b sjF;
  
  static
  {
    AppMethodBeat.i(166015);
    sjF = new b();
    AppMethodBeat.o(166015);
  }
  
  public static void a(Context paramContext, long paramLong, String paramString, d.g.a.b<? super Integer, ? extends List<Long>> paramb)
  {
    AppMethodBeat.i(202776);
    p.h(paramContext, "context");
    p.h(paramString, "objectNonceId");
    p.h(paramb, "onSelectedCallback");
    Object localObject = (List)paramb.invoke(Integer.valueOf(2));
    paramb = FinderReporterUIC.tnG;
    paramb = FinderReporterUIC.a.fc(paramContext);
    if (paramb != null) {}
    for (paramb = paramb.cQZ();; paramb = null)
    {
      new com.tencent.mm.plugin.finder.cgi.e(paramLong, paramString, paramb).aET().j((com.tencent.mm.vending.c.a)new a((List)localObject));
      com.tencent.mm.plugin.report.e.ywz.idkeyStat(1278L, 9L, 1L, false);
      paramString = i.syT;
      paramString = paramContext.getClass().getSimpleName();
      p.g(paramString, "context.javaClass.simpleName");
      p.h(paramString, "page");
      paramb = i.wJ(paramLong);
      if (paramb != null)
      {
        localObject = paramb.getFeedObject();
        String str = ((c)g.ab(c.class)).cos();
        paramString = str + ',' + paramString + ',' + i.wL(((FinderObject)localObject).id) + ',' + ((FinderObject)localObject).username + ',' + paramb.getMediaType() + ',' + ((FinderObject)localObject).recommendType + ',' + ((FinderObject)localObject).likeCount + ',' + ((FinderObject)localObject).commentCount + ',' + ((FinderObject)localObject).friendLikeCount + ",0,0,0,2";
        ae.i(i.TAG, "18946 ".concat(String.valueOf(paramString)));
        com.tencent.mm.plugin.report.e.ywz.kvStat(18946, paramString);
      }
      paramString = FinderReporterUIC.tnG;
      paramContext = FinderReporterUIC.a.fc(paramContext);
      if (paramContext == null) {
        break;
      }
      paramContext = FinderReporterUIC.b(paramContext);
      if (paramContext == null) {
        break;
      }
      paramContext.cAI().wn(paramLong);
      AppMethodBeat.o(202776);
      return;
    }
    AppMethodBeat.o(202776);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderFeedbackResponse;", "kotlin.jvm.PlatformType", "call"})
  static final class a<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    a(List paramList) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.logic.b
 * JD-Core Version:    0.7.0.1
 */