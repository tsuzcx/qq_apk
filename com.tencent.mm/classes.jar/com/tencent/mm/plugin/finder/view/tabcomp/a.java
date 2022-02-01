package com.tencent.mm.plugin.finder.view.tabcomp;

import android.view.ViewGroup;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/view/tabcomp/FinderBaseTab;", "", "()V", "index", "", "getIndex", "()I", "setIndex", "(I)V", "getLayoutId", "getTabMargin", "", "onTabInflated", "", "tabView", "Landroid/view/ViewGroup;", "onTabStatusChanged", "isSelected", "", "setTabRedDot", "redDotText", "", "isTabSelected", "setTabTitle", "plugin-finder_release"})
public abstract class a
{
  public int index;
  
  public void a(boolean paramBoolean, ViewGroup paramViewGroup)
  {
    p.k(paramViewGroup, "tabView");
  }
  
  public abstract void aGC(String paramString);
  
  public int[] dmU()
  {
    return new int[] { 0, 0 };
  }
  
  public abstract int getLayoutId();
  
  public abstract void rx(boolean paramBoolean);
  
  public abstract void z(ViewGroup paramViewGroup);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.tabcomp.a
 * JD-Core Version:    0.7.0.1
 */