package com.tencent.mm.plugin.finder.view.tabcomp;

import android.view.ViewGroup;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/view/tabcomp/FinderBaseTab;", "", "()V", "index", "", "getIndex", "()I", "setIndex", "(I)V", "getLayoutId", "getTabMargin", "", "onTabInflated", "", "tabView", "Landroid/view/ViewGroup;", "onTabStatusChanged", "isSelected", "", "setTabRedDot", "redDotText", "", "isTabSelected", "setTabTitle", "plugin-finder_release"})
public abstract class a
{
  public int index;
  
  public void a(boolean paramBoolean, ViewGroup paramViewGroup)
  {
    p.h(paramViewGroup, "tabView");
  }
  
  public abstract void by(String paramString, boolean paramBoolean);
  
  public int[] cXC()
  {
    return new int[] { 0, 0 };
  }
  
  public abstract int getLayoutId();
  
  public abstract void pd(boolean paramBoolean);
  
  public abstract void u(ViewGroup paramViewGroup);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.tabcomp.a
 * JD-Core Version:    0.7.0.1
 */