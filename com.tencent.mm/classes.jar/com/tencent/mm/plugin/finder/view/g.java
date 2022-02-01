package com.tencent.mm.plugin.finder.view;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.c;
import com.tencent.mm.plugin.finder.storage.config.b;
import com.tencent.mm.plugin.finder.utils.a;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.protocal.protobuf.ard;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.List;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/view/FinderFoldedPresenter;", "Lcom/tencent/mm/plugin/finder/view/FoldedScrollPresenter;", "foldedLayout", "Lcom/tencent/mm/protocal/protobuf/FinderFoldedLayout;", "parent", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "(Lcom/tencent/mm/protocal/protobuf/FinderFoldedLayout;Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;)V", "getFoldedLayout", "()Lcom/tencent/mm/protocal/protobuf/FinderFoldedLayout;", "getParent", "()Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "getItemLayoutType", "", "getLayoutParam", "Landroid/support/constraint/ConstraintLayout$LayoutParams;", "getList", "", "getParentFeed", "getSpaceWidth", "hasMore", "", "isShowLikeInfo", "jumpFoldedUI", "", "context", "Landroid/content/Context;", "jumpPos", "onItemClick", "pos", "plugin-finder_release"})
public final class g
  implements p
{
  private final ard foldedLayout;
  private final BaseFinderFeed wmG;
  
  public g(ard paramard, BaseFinderFeed paramBaseFinderFeed)
  {
    AppMethodBeat.i(254824);
    this.foldedLayout = paramard;
    this.wmG = paramBaseFinderFeed;
    AppMethodBeat.o(254824);
  }
  
  public final List<BaseFinderFeed> GW()
  {
    AppMethodBeat.i(254821);
    List localList = this.wmG.feedObject.getFoldedFeedList();
    AppMethodBeat.o(254821);
    return localList;
  }
  
  public final void ag(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(254823);
    kotlin.g.b.p.h(paramContext, "context");
    Object localObject2 = this.foldedLayout;
    Object localObject4 = this.wmG;
    Object localObject1 = this.wmG.feedObject.getFoldedFeedList();
    int i;
    Object localObject3;
    if (!Util.isNullOrNil((List)localObject1))
    {
      if (paramInt < ((List)localObject1).size()) {
        break label245;
      }
      i = ((List)localObject1).size() - 1;
      Log.i("Finder.FinderFoldedScrollLayout", "jumpFoldedUI item " + localObject4 + " jumpPos " + paramInt);
      localObject3 = FinderFoldedScrollLayout.wmQ;
      FinderFoldedScrollLayout.Gw(((BaseFinderFeed)((List)localObject1).get(i)).lT());
      localObject3 = FinderFoldedScrollLayout.wmQ;
      FinderFoldedScrollLayout.Gx(cl.aWA());
      localObject3 = new Intent();
      ((Intent)localObject3).putExtra("FEED_ID", ((BaseFinderFeed)localObject4).feedObject.getId());
      ((Intent)localObject3).putExtra("FEED_NONCE_ID", ((BaseFinderFeed)localObject4).feedObject.getObjectNonceId());
      if (((ard)localObject2).tQR != 1) {
        break label259;
      }
      localObject4 = y.vXH;
      ((Intent)localObject3).putExtra("NICKNAME", y.hf(((ard)localObject2).username, ""));
      kotlin.g.b.p.g(((Intent)localObject3).putExtra("FOLED_TYPE", 1), "intent.putExtra(Constant…utType.Folded_FriendLike)");
    }
    for (;;)
    {
      localObject2 = y.vXH;
      y.a(i, (List)localObject1, null, (Intent)localObject3);
      localObject1 = a.vUU;
      a.V(paramContext, (Intent)localObject3);
      AppMethodBeat.o(254823);
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
      if (((ard)localObject2).tQR == 2)
      {
        ((Intent)localObject3).putExtra("NICKNAME", ((BaseFinderFeed)localObject4).feedObject.getNickName());
        ((Intent)localObject3).putExtra("FOLED_TYPE", 2);
      }
    }
  }
  
  public final int cZG()
  {
    if (this.foldedLayout.tQR == 1) {
      return 1;
    }
    return 2;
  }
  
  public final BaseFinderFeed dGI()
  {
    return this.wmG;
  }
  
  public final boolean dGJ()
  {
    AppMethodBeat.i(254822);
    int i = this.foldedLayout.gAZ;
    c localc = c.vCb;
    if (i >= ((Number)c.dsu().value()).intValue())
    {
      AppMethodBeat.o(254822);
      return true;
    }
    AppMethodBeat.o(254822);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.g
 * JD-Core Version:    0.7.0.1
 */