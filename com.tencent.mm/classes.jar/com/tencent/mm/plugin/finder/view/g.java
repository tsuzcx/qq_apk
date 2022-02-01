package com.tencent.mm.plugin.finder.view;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cf;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.utils.a;
import com.tencent.mm.protocal.protobuf.amx;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import d.l;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/view/FinderFoldedPresenter;", "Lcom/tencent/mm/plugin/finder/view/FoldedScrollPresenter;", "foldedLayout", "Lcom/tencent/mm/protocal/protobuf/FinderFoldedLayout;", "parent", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "(Lcom/tencent/mm/protocal/protobuf/FinderFoldedLayout;Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;)V", "getFoldedLayout", "()Lcom/tencent/mm/protocal/protobuf/FinderFoldedLayout;", "getParent", "()Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "getLayoutType", "", "getList", "", "getParentFeed", "hasMore", "", "jumpFoldedUI", "", "context", "Landroid/content/Context;", "jumpPos", "onItemClick", "pos", "plugin-finder_release"})
public final class g
  implements m
{
  private final amx foldedLayout;
  private final BaseFinderFeed sUk;
  
  public g(amx paramamx, BaseFinderFeed paramBaseFinderFeed)
  {
    AppMethodBeat.i(205137);
    this.foldedLayout = paramamx;
    this.sUk = paramBaseFinderFeed;
    AppMethodBeat.o(205137);
  }
  
  public final void Z(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(205136);
    d.g.b.p.h(paramContext, "context");
    Object localObject2 = this.foldedLayout;
    Object localObject4 = this.sUk;
    Object localObject1 = this.sUk.feedObject.getFoldedFeedList();
    int i;
    Object localObject3;
    if (!bt.hj((List)localObject1))
    {
      if (paramInt < ((List)localObject1).size()) {
        break label241;
      }
      i = ((List)localObject1).size() - 1;
      ad.i("Finder.FinderFoldedScrollLayout", "jumpFoldedUI item " + localObject4 + " jumpPos " + paramInt);
      localObject3 = FinderFoldedScrollLayout.sUv;
      FinderFoldedScrollLayout.xu(((BaseFinderFeed)((List)localObject1).get(i)).lP());
      localObject3 = FinderFoldedScrollLayout.sUv;
      FinderFoldedScrollLayout.xv(cf.aCM());
      localObject3 = new Intent();
      ((Intent)localObject3).putExtra("FEED_ID", ((BaseFinderFeed)localObject4).feedObject.getId());
      ((Intent)localObject3).putExtra("FEED_NONCE_ID", ((BaseFinderFeed)localObject4).feedObject.getObjectNonceId());
      if (((amx)localObject2).sUo != 1) {
        break label255;
      }
      localObject4 = com.tencent.mm.plugin.finder.utils.p.sMo;
      ((Intent)localObject3).putExtra("NICKNAME", com.tencent.mm.plugin.finder.utils.p.gx(((amx)localObject2).username, ""));
      ((Intent)localObject3).putExtra("FOLED_TYPE", 1);
    }
    for (;;)
    {
      localObject2 = com.tencent.mm.plugin.finder.utils.p.sMo;
      com.tencent.mm.plugin.finder.utils.p.a(i, (List)localObject1, null, (Intent)localObject3);
      localObject1 = a.sKD;
      a.R(paramContext, (Intent)localObject3);
      AppMethodBeat.o(205136);
      return;
      label241:
      if (paramInt < 0)
      {
        i = 0;
        break;
      }
      i = paramInt;
      break;
      label255:
      if (((amx)localObject2).sUo == 2)
      {
        ((Intent)localObject3).putExtra("NICKNAME", ((BaseFinderFeed)localObject4).feedObject.getNickName());
        ((Intent)localObject3).putExtra("FOLED_TYPE", 2);
      }
    }
  }
  
  public final BaseFinderFeed cNl()
  {
    return this.sUk;
  }
  
  public final List<BaseFinderFeed> cNm()
  {
    AppMethodBeat.i(205134);
    List localList = this.sUk.feedObject.getFoldedFeedList();
    AppMethodBeat.o(205134);
    return localList;
  }
  
  public final int cNn()
  {
    if (this.foldedLayout.sUo == 1) {
      return 1;
    }
    return 2;
  }
  
  public final boolean cNo()
  {
    AppMethodBeat.i(205135);
    int i = this.foldedLayout.fTM;
    com.tencent.mm.plugin.finder.storage.b localb = com.tencent.mm.plugin.finder.storage.b.sxa;
    if (i >= ((Number)com.tencent.mm.plugin.finder.storage.b.cGP().value()).intValue())
    {
      AppMethodBeat.o(205135);
      return true;
    }
    AppMethodBeat.o(205135);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.g
 * JD-Core Version:    0.7.0.1
 */