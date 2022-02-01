package com.tencent.mm.plugin.appbrand.widget.desktop;

import java.util.List;
import kotlin.g.a.b;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/widget/desktop/AppBrandDesktopViewModel;", "", "()V", "getInitialDataList", "", "Lcom/tencent/mm/plugin/appbrand/widget/desktop/AppBrandDesktopView$AppBrandItem;", "getNextPageDataList", "", "callback", "Lkotlin/Function1;", "hasMore", "", "title", "", "viewType", "", "plugin-appbrand-integration_release"})
public abstract class c
{
  public abstract String aBd();
  
  public boolean aDl()
  {
    return false;
  }
  
  public abstract int cnA();
  
  public abstract List<AppBrandDesktopView.a> cnB();
  
  public abstract void z(b<? super List<? extends AppBrandDesktopView.a>, x> paramb);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.c
 * JD-Core Version:    0.7.0.1
 */