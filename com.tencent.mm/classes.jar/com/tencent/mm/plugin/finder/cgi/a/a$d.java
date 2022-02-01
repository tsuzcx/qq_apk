package com.tencent.mm.plugin.finder.cgi.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.cgi.ai.a;
import com.tencent.mm.plugin.finder.cgi.g.c;
import com.tencent.mm.plugin.finder.feed.model.x.c;
import com.tencent.mm.plugin.finder.feed.z;
import com.tencent.mm.protocal.protobuf.dyy;
import com.tencent.mm.protocal.protobuf.dzm;
import com.tencent.mm.sdk.platformtools.ad;
import d.a.j;
import d.a.v;
import d.g.b.k;
import d.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/cgi/fetcher/FinderLbsFeedFetcher$fetch$1", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderGetNearbyList$Callback;", "onFetchDone", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderGetNearbyListResp;", "pullType", "plugin-finder_release"})
public final class a$d
  implements ai.a
{
  public a$d(a.a parama, g.c paramc) {}
  
  public final void a(int paramInt1, int paramInt2, String paramString, dyy paramdyy, int paramInt3)
  {
    AppMethodBeat.i(197343);
    k.h(paramdyy, "resp");
    x.c localc = new x.c(paramInt1, paramInt2, paramString);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      this.KKc.KJS.KJZ = paramdyy.lastBuffer;
      paramString = paramdyy.Lxu;
      Object localObject1;
      if (paramString != null)
      {
        localObject1 = (Iterable)paramString;
        paramString = (Collection)new ArrayList(j.a((Iterable)localObject1, 10));
        localObject1 = ((Iterable)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (dzm)((Iterator)localObject1).next();
          z localz = z.KNQ;
          k.g(localObject2, "section");
          paramString.add(z.a((dzm)localObject2));
        }
        paramString = (List)paramString;
        Object localObject2 = new StringBuilder("incrementList size: ");
        localObject1 = localc.getIncrementList();
        if (localObject1 == null) {
          break label263;
        }
        localObject1 = Integer.valueOf(((List)localObject1).size());
        label179:
        ad.i("Finder.FinderLbsFeedFetcher", localObject1);
        localc.setIncrementList(paramString);
        localc.setPullType(paramInt3);
        localc.setLastBuffer(paramdyy.lastBuffer);
        if (paramdyy.continueFlag != 1) {
          break label269;
        }
      }
      label263:
      label269:
      for (boolean bool = true;; bool = false)
      {
        localc.setHasMore(bool);
        this.KKd.a(localc);
        AppMethodBeat.o(197343);
        return;
        paramString = (List)v.Jgl;
        break;
        localObject1 = null;
        break label179;
      }
    }
    localc.setHasMore(true);
    AppMethodBeat.o(197343);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.a.a.d
 * JD-Core Version:    0.7.0.1
 */