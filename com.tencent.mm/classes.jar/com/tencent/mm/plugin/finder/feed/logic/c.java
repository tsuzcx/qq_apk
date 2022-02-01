package com.tencent.mm.plugin.finder.feed.logic;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.cgi.n;
import com.tencent.mm.plugin.finder.event.a;
import com.tencent.mm.plugin.finder.event.a.b;
import com.tencent.mm.plugin.finder.report.z;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.logic.d.a;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.plugin.finder.viewmodel.component.as.a;
import com.tencent.mm.plugin.findersdk.a.bn;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/logic/FinderNoInterestedLogic;", "", "()V", "TAG", "", "TYPE_NO_INTERESTED_OF_AUTHOR", "", "TYPE_NO_INTERESTED_OF_FEED", "handleNoInterestedAuthor", "", "context", "Landroid/content/Context;", "feedId", "", "objectNonceId", "onSelectedCallback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "type", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  public static final c Bep;
  
  static
  {
    AppMethodBeat.i(166015);
    Bep = new c();
    AppMethodBeat.o(166015);
  }
  
  private static final ah a(List paramList, b.a parama)
  {
    AppMethodBeat.i(363740);
    s.u(paramList, "$linkFeedId");
    Log.i("Finder.NoInterestedLogic", "[CgiFinderFeedBack] errType: %s, errCode: %s", new Object[] { Integer.valueOf(parama.errType), Integer.valueOf(parama.errCode) });
    if ((parama.errCode == 0) && (parama.errType == 0))
    {
      paramList = ((Iterable)paramList).iterator();
      while (paramList.hasNext())
      {
        long l = ((Number)paramList.next()).longValue();
        parama = com.tencent.mm.plugin.finder.storage.logic.d.FND;
        d.a.qs(l);
      }
    }
    paramList = ah.aiuX;
    AppMethodBeat.o(363740);
    return paramList;
  }
  
  public static void a(Context paramContext, long paramLong, String paramString, b<? super Integer, ? extends List<Long>> paramb)
  {
    AppMethodBeat.i(363729);
    s.u(paramContext, "context");
    s.u(paramString, "objectNonceId");
    s.u(paramb, "onSelectedCallback");
    Object localObject = (List)paramb.invoke(Integer.valueOf(2));
    paramb = as.GSQ;
    paramb = as.a.hu(paramContext);
    if (paramb == null) {}
    for (paramb = null;; paramb = paramb.fou())
    {
      new n(paramLong, paramString, paramb).bFJ().j(new c..ExternalSyntheticLambda0((List)localObject));
      com.tencent.mm.plugin.report.f.Ozc.idkeyStat(1278L, 9L, 1L, false);
      paramString = z.FrZ;
      paramString = paramContext.getClass().getSimpleName();
      s.s(paramString, "context.javaClass.simpleName");
      s.u(paramString, "page");
      paramb = z.jm(paramLong);
      if (paramb != null)
      {
        localObject = paramb.getFeedObject();
        String str = ((com.tencent.mm.plugin.expt.b.d)h.ax(com.tencent.mm.plugin.expt.b.d.class)).dHN();
        paramString = str + ',' + paramString + ',' + z.pL(((FinderObject)localObject).id) + ',' + ((FinderObject)localObject).username + ',' + paramb.getMediaType() + ',' + ((FinderObject)localObject).recommendType + ',' + ((FinderObject)localObject).likeCount + ',' + ((FinderObject)localObject).commentCount + ',' + ((FinderObject)localObject).friendLikeCount + ",0,0,0,2";
        Log.i(z.getTAG(), s.X("18946 ", paramString));
        com.tencent.mm.plugin.report.f.Ozc.kvStat(18946, paramString);
      }
      paramString = as.GSQ;
      paramContext = as.a.hu(paramContext);
      if (paramContext != null)
      {
        paramContext = ((bn)paramContext).foy();
        if (paramContext != null)
        {
          paramContext = paramContext.dYj();
          if (paramContext != null) {
            paramContext.ng(paramLong);
          }
        }
      }
      AppMethodBeat.o(363729);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.logic.c
 * JD-Core Version:    0.7.0.1
 */