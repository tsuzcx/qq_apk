package com.tencent.mm.plugin.finder.view;

import android.content.Context;
import android.content.Intent;
import android.support.constraint.ConstraintLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ch;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.utils.a;
import com.tencent.mm.protocal.protobuf.ank;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import d.l;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/view/FinderFoldedPresenter;", "Lcom/tencent/mm/plugin/finder/view/FoldedScrollPresenter;", "foldedLayout", "Lcom/tencent/mm/protocal/protobuf/FinderFoldedLayout;", "parent", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "(Lcom/tencent/mm/protocal/protobuf/FinderFoldedLayout;Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;)V", "getFoldedLayout", "()Lcom/tencent/mm/protocal/protobuf/FinderFoldedLayout;", "getParent", "()Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "getItemLayoutType", "", "getLayoutParam", "Landroid/support/constraint/ConstraintLayout$LayoutParams;", "getList", "", "getParentFeed", "getSpaceWidth", "hasMore", "", "jumpFoldedUI", "", "context", "Landroid/content/Context;", "jumpPos", "onItemClick", "pos", "plugin-finder_release"})
public final class g
  implements n
{
  private final ank foldedLayout;
  private final BaseFinderFeed tfy;
  
  public g(ank paramank, BaseFinderFeed paramBaseFinderFeed)
  {
    AppMethodBeat.i(205771);
    this.foldedLayout = paramank;
    this.tfy = paramBaseFinderFeed;
    AppMethodBeat.o(205771);
  }
  
  public final void Z(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(205770);
    d.g.b.p.h(paramContext, "context");
    Object localObject2 = this.foldedLayout;
    Object localObject4 = this.tfy;
    Object localObject1 = this.tfy.feedObject.getFoldedFeedList();
    int i;
    Object localObject3;
    if (!bu.ht((List)localObject1))
    {
      if (paramInt < ((List)localObject1).size()) {
        break label241;
      }
      i = ((List)localObject1).size() - 1;
      ae.i("Finder.FinderFoldedScrollLayout", "jumpFoldedUI item " + localObject4 + " jumpPos " + paramInt);
      localObject3 = FinderFoldedScrollLayout.tfJ;
      FinderFoldedScrollLayout.xO(((BaseFinderFeed)((List)localObject1).get(i)).lP());
      localObject3 = FinderFoldedScrollLayout.tfJ;
      FinderFoldedScrollLayout.xP(ch.aDc());
      localObject3 = new Intent();
      ((Intent)localObject3).putExtra("FEED_ID", ((BaseFinderFeed)localObject4).feedObject.getId());
      ((Intent)localObject3).putExtra("FEED_NONCE_ID", ((BaseFinderFeed)localObject4).feedObject.getObjectNonceId());
      if (((ank)localObject2).sgH != 1) {
        break label255;
      }
      localObject4 = com.tencent.mm.plugin.finder.utils.p.sXz;
      ((Intent)localObject3).putExtra("NICKNAME", com.tencent.mm.plugin.finder.utils.p.gC(((ank)localObject2).username, ""));
      ((Intent)localObject3).putExtra("FOLED_TYPE", 1);
    }
    for (;;)
    {
      localObject2 = com.tencent.mm.plugin.finder.utils.p.sXz;
      com.tencent.mm.plugin.finder.utils.p.a(i, (List)localObject1, null, (Intent)localObject3);
      localObject1 = a.sVQ;
      a.R(paramContext, (Intent)localObject3);
      AppMethodBeat.o(205770);
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
      if (((ank)localObject2).sgH == 2)
      {
        ((Intent)localObject3).putExtra("NICKNAME", ((BaseFinderFeed)localObject4).feedObject.getNickName());
        ((Intent)localObject3).putExtra("FOLED_TYPE", 2);
      }
    }
  }
  
  public final BaseFinderFeed cPT()
  {
    return this.tfy;
  }
  
  public final List<BaseFinderFeed> cPU()
  {
    AppMethodBeat.i(205768);
    List localList = this.tfy.feedObject.getFoldedFeedList();
    AppMethodBeat.o(205768);
    return localList;
  }
  
  public final int cPV()
  {
    if (this.foldedLayout.sgH == 1) {
      return 1;
    }
    return 2;
  }
  
  public final boolean cPW()
  {
    AppMethodBeat.i(205769);
    int i = this.foldedLayout.fVS;
    com.tencent.mm.plugin.finder.storage.b localb = com.tencent.mm.plugin.finder.storage.b.sHP;
    if (i >= ((Number)com.tencent.mm.plugin.finder.storage.b.cIO().value()).intValue())
    {
      AppMethodBeat.o(205769);
      return true;
    }
    AppMethodBeat.o(205769);
    return false;
  }
  
  public final ConstraintLayout.LayoutParams cPX()
  {
    return null;
  }
  
  public final int cPY()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.g
 * JD-Core Version:    0.7.0.1
 */