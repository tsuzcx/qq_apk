package com.tencent.mm.plugin.finder.view;

import androidx.constraintlayout.widget.ConstraintLayout.LayoutParams;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/FoldedScrollPresenter;", "", "getItemLayoutType", "", "getLayoutParam", "Landroidx/constraintlayout/widget/ConstraintLayout$LayoutParams;", "getList", "", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "getParentFeed", "getSpaceWidth", "hasMore", "", "isShowLikeInfo", "onItemClick", "", "context", "Landroid/content/Context;", "pos", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface y
{
  public abstract boolean aWl();
  
  public abstract List<BaseFinderFeed> aiJ();
  
  public abstract ConstraintLayout.LayoutParams dXB();
  
  public abstract boolean dXC();
  
  public abstract int dXD();
  
  public abstract int flA();
  
  public abstract BaseFinderFeed flz();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.y
 * JD-Core Version:    0.7.0.1
 */