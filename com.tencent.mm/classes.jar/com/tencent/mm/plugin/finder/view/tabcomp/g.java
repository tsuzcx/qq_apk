package com.tencent.mm.plugin.finder.view.tabcomp;

import android.view.ViewGroup;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/tabcomp/FinderBaseTab;", "", "()V", "index", "", "getIndex", "()I", "setIndex", "(I)V", "priority", "getPriority", "setPriority", "getLayoutId", "getTabMargin", "", "onTabInflated", "", "tabView", "Landroid/view/ViewGroup;", "onTabStatusChanged", "isSelected", "", "setTabRedDot", "redDotText", "", "isTabSelected", "setTabTitle", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class g
{
  public int index;
  public int priority = 2147483647;
  
  public abstract void H(ViewGroup paramViewGroup);
  
  public void a(boolean paramBoolean, ViewGroup paramViewGroup)
  {
    s.u(paramViewGroup, "tabView");
  }
  
  public int[] dTO()
  {
    return new int[] { 0, 0 };
  }
  
  public abstract int getLayoutId();
  
  public abstract void vg(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.tabcomp.g
 * JD-Core Version:    0.7.0.1
 */