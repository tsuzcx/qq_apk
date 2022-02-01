package com.tencent.mm.plugin.finder.view;

import android.content.Context;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import d.l;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/view/FoldedScrollPresenter;", "", "getLayoutType", "", "getList", "", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "getParentFeed", "hasMore", "", "onItemClick", "", "context", "Landroid/content/Context;", "pos", "plugin-finder_release"})
public abstract interface m
{
  public abstract void Z(Context paramContext, int paramInt);
  
  public abstract BaseFinderFeed cNl();
  
  public abstract List<BaseFinderFeed> cNm();
  
  public abstract int cNn();
  
  public abstract boolean cNo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.m
 * JD-Core Version:    0.7.0.1
 */