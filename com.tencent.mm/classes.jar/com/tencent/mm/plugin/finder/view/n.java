package com.tencent.mm.plugin.finder.view;

import android.content.Context;
import android.support.constraint.ConstraintLayout.LayoutParams;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import d.l;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/view/FoldedScrollPresenter;", "", "getItemLayoutType", "", "getLayoutParam", "Landroid/support/constraint/ConstraintLayout$LayoutParams;", "getList", "", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "getParentFeed", "getSpaceWidth", "hasMore", "", "onItemClick", "", "context", "Landroid/content/Context;", "pos", "plugin-finder_release"})
public abstract interface n
{
  public abstract void Z(Context paramContext, int paramInt);
  
  public abstract BaseFinderFeed cPT();
  
  public abstract List<BaseFinderFeed> cPU();
  
  public abstract int cPV();
  
  public abstract boolean cPW();
  
  public abstract ConstraintLayout.LayoutParams cPX();
  
  public abstract int cPY();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.n
 * JD-Core Version:    0.7.0.1
 */