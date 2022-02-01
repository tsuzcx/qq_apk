package com.tencent.mm.plugin.finder.view;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cm;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.d;
import com.tencent.mm.plugin.finder.utils.a;
import com.tencent.mm.plugin.finder.utils.aj;
import com.tencent.mm.plugin.findersdk.d.a.a.b;
import com.tencent.mm.protocal.protobuf.asz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/view/FinderFoldedPresenter;", "Lcom/tencent/mm/plugin/finder/view/FoldedScrollPresenter;", "foldedLayout", "Lcom/tencent/mm/protocal/protobuf/FinderFoldedLayout;", "parent", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "(Lcom/tencent/mm/protocal/protobuf/FinderFoldedLayout;Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;)V", "getFoldedLayout", "()Lcom/tencent/mm/protocal/protobuf/FinderFoldedLayout;", "getParent", "()Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "getItemLayoutType", "", "getLayoutParam", "Landroidx/constraintlayout/widget/ConstraintLayout$LayoutParams;", "getList", "", "getParentFeed", "getSpaceWidth", "hasMore", "", "isShowLikeInfo", "jumpFoldedUI", "", "context", "Landroid/content/Context;", "jumpPos", "onItemClick", "pos", "plugin-finder_release"})
public final class h
  implements v
{
  private final BaseFinderFeed AXJ;
  private final asz foldedLayout;
  
  public h(asz paramasz, BaseFinderFeed paramBaseFinderFeed)
  {
    AppMethodBeat.i(289259);
    this.foldedLayout = paramasz;
    this.AXJ = paramBaseFinderFeed;
    AppMethodBeat.o(289259);
  }
  
  public final boolean aDl()
  {
    AppMethodBeat.i(289257);
    int i = this.foldedLayout.jlf;
    d locald = d.AjH;
    if (i >= ((Number)d.dTJ().aSr()).intValue())
    {
      AppMethodBeat.o(289257);
      return true;
    }
    AppMethodBeat.o(289257);
    return false;
  }
  
  public final void as(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(289258);
    p.k(paramContext, "context");
    Object localObject2 = this.foldedLayout;
    Object localObject4 = this.AXJ;
    Object localObject1 = this.AXJ.feedObject.getFoldedFeedList();
    int i;
    Object localObject3;
    if (!Util.isNullOrNil((List)localObject1))
    {
      if (paramInt < ((List)localObject1).size()) {
        break label245;
      }
      i = ((List)localObject1).size() - 1;
      Log.i("Finder.FinderFoldedScrollLayout", "jumpFoldedUI item " + localObject4 + " jumpPos " + paramInt);
      localObject3 = FinderFoldedScrollLayout.AXT;
      FinderFoldedScrollLayout.Nw(((BaseFinderFeed)((List)localObject1).get(i)).mf());
      localObject3 = FinderFoldedScrollLayout.AXT;
      FinderFoldedScrollLayout.Nx(cm.bfE());
      localObject3 = new Intent();
      ((Intent)localObject3).putExtra("FEED_ID", ((BaseFinderFeed)localObject4).feedObject.getId());
      ((Intent)localObject3).putExtra("FEED_NONCE_ID", ((BaseFinderFeed)localObject4).feedObject.getObjectNonceId());
      if (((asz)localObject2).xBI != 1) {
        break label259;
      }
      localObject4 = aj.AGc;
      ((Intent)localObject3).putExtra("NICKNAME", aj.ht(((asz)localObject2).username, ""));
      p.j(((Intent)localObject3).putExtra("FOLED_TYPE", 1), "intent.putExtra(Constant…utType.Folded_FriendLike)");
    }
    for (;;)
    {
      localObject2 = aj.AGc;
      aj.a(i, (List)localObject1, null, (Intent)localObject3);
      localObject1 = a.ACH;
      a.V(paramContext, (Intent)localObject3);
      AppMethodBeat.o(289258);
      return;
      label245:
      if (paramInt < 0)
      {
        i = 0;
        break;
      }
      i = paramInt;
      break;
      label259:
      if (((asz)localObject2).xBI == 2)
      {
        ((Intent)localObject3).putExtra("NICKNAME", ((BaseFinderFeed)localObject4).feedObject.getNickName());
        ((Intent)localObject3).putExtra("FOLED_TYPE", 2);
      }
    }
  }
  
  public final int dpz()
  {
    if (this.foldedLayout.xBI == 1) {
      return 1;
    }
    return 2;
  }
  
  public final BaseFinderFeed eiG()
  {
    return this.AXJ;
  }
  
  public final List<BaseFinderFeed> eiH()
  {
    AppMethodBeat.i(289256);
    List localList = this.AXJ.feedObject.getFoldedFeedList();
    AppMethodBeat.o(289256);
    return localList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.h
 * JD-Core Version:    0.7.0.1
 */