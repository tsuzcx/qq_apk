package com.tencent.mm.plugin.finder.view;

import android.content.Context;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import java.util.List;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/view/FoldedScrollPresenter;", "", "getItemLayoutType", "", "getLayoutParam", "Landroid/support/constraint/ConstraintLayout$LayoutParams;", "getList", "", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "getParentFeed", "getSpaceWidth", "hasMore", "", "isShowLikeInfo", "onItemClick", "", "context", "Landroid/content/Context;", "pos", "plugin-finder_release"})
public abstract interface p
{
  public abstract List<BaseFinderFeed> GW();
  
  public abstract void ag(Context paramContext, int paramInt);
  
  public abstract int cZG();
  
  public abstract BaseFinderFeed dGI();
  
  public abstract boolean dGJ();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.p
 * JD-Core Version:    0.7.0.1
 */