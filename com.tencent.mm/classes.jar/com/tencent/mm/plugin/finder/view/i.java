package com.tencent.mm.plugin.finder.view;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.constraint.ConstraintLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ch;
import com.tencent.mm.plugin.finder.feed.ab;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.protocal.protobuf.asd;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import d.l;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/view/FinderRelCardPresenter;", "Lcom/tencent/mm/plugin/finder/view/FoldedScrollPresenter;", "attachInfoItem", "Lcom/tencent/mm/plugin/finder/feed/FinderStreamCardFeed;", "(Lcom/tencent/mm/plugin/finder/feed/FinderStreamCardFeed;)V", "appContext", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "getAppContext", "()Landroid/content/Context;", "getItemLayoutType", "", "getLayoutParam", "Landroid/support/constraint/ConstraintLayout$LayoutParams;", "getList", "", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "getParentFeed", "getSpaceWidth", "hasMore", "", "jumpFoldedUI", "", "context", "jumpPos", "onItemClick", "pos", "plugin-finder_release"})
public final class i
  implements n
{
  private final Context appContext;
  private final ab tgM;
  
  public i(ab paramab)
  {
    AppMethodBeat.i(205821);
    this.tgM = paramab;
    this.appContext = ak.getContext();
    AppMethodBeat.o(205821);
  }
  
  public final void Z(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(205818);
    d.g.b.p.h(paramContext, "context");
    Object localObject1 = cPU();
    int i;
    if (!bu.ht((List)localObject1))
    {
      if (paramInt < ((List)localObject1).size()) {
        break label205;
      }
      i = ((List)localObject1).size() - 1;
    }
    for (;;)
    {
      ae.i("Finder.FinderFoldedScrollLayout", "jumpFoldedUI jumpPos ".concat(String.valueOf(paramInt)));
      Object localObject2 = FinderFoldedScrollLayout.tfJ;
      FinderFoldedScrollLayout.xO(((BaseFinderFeed)((List)localObject1).get(i)).lP());
      localObject2 = FinderFoldedScrollLayout.tfJ;
      FinderFoldedScrollLayout.xP(ch.aDc());
      localObject2 = new Intent();
      ((Intent)localObject2).putExtra("GET_REL_SCENE", this.tgM.sgG.GIH);
      ((Intent)localObject2).putExtra("TITLE_WORDING", this.tgM.sgG.DUV);
      ((Intent)localObject2).putExtra("CAN_LOAD_MORE", this.tgM.sgG.GII);
      ((Intent)localObject2).putExtra("NO_MORE_JUMP_HOT_TITLE", this.tgM.sgG.sjR);
      com.tencent.mm.plugin.finder.utils.p localp = com.tencent.mm.plugin.finder.utils.p.sXz;
      com.tencent.mm.plugin.finder.utils.p.a(i, (List)localObject1, null, (Intent)localObject2);
      localObject1 = com.tencent.mm.plugin.finder.utils.a.sVQ;
      com.tencent.mm.plugin.finder.utils.a.S(paramContext, (Intent)localObject2);
      AppMethodBeat.o(205818);
      return;
      label205:
      if (paramInt < 0) {
        i = 0;
      } else {
        i = paramInt;
      }
    }
  }
  
  public final BaseFinderFeed cPT()
  {
    return null;
  }
  
  public final List<BaseFinderFeed> cPU()
  {
    return (List)this.tgM.sgI;
  }
  
  public final int cPV()
  {
    return 1;
  }
  
  public final boolean cPW()
  {
    return false;
  }
  
  public final ConstraintLayout.LayoutParams cPX()
  {
    AppMethodBeat.i(205819);
    Object localObject = com.tencent.mm.plugin.finder.storage.b.sHP;
    if (((Number)com.tencent.mm.plugin.finder.storage.b.cKE().value()).intValue() == 1)
    {
      localObject = new ConstraintLayout.LayoutParams(com.tencent.mm.cb.a.fromDPToPix(this.appContext, 290), com.tencent.mm.cb.a.fromDPToPix(this.appContext, 336));
      AppMethodBeat.o(205819);
      return localObject;
    }
    localObject = new ConstraintLayout.LayoutParams(com.tencent.mm.cb.a.fromDPToPix(this.appContext, 148), com.tencent.mm.cb.a.fromDPToPix(this.appContext, 172));
    AppMethodBeat.o(205819);
    return localObject;
  }
  
  public final int cPY()
  {
    AppMethodBeat.i(205820);
    Object localObject = com.tencent.mm.plugin.finder.storage.b.sHP;
    if (((Number)com.tencent.mm.plugin.finder.storage.b.cKE().value()).intValue() == 1)
    {
      localObject = this.appContext;
      d.g.b.p.g(localObject, "appContext");
      i = (int)((Context)localObject).getResources().getDimension(2131165274);
      AppMethodBeat.o(205820);
      return i;
    }
    localObject = this.appContext;
    d.g.b.p.g(localObject, "appContext");
    int i = (int)((Context)localObject).getResources().getDimension(2131166296);
    AppMethodBeat.o(205820);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.i
 * JD-Core Version:    0.7.0.1
 */