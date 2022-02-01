package com.tencent.mm.plugin.appbrand.widget.desktop;

import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/widget/desktop/AppBrandDesktopViewModel;", "", "()V", "getInitialDataList", "", "Lcom/tencent/mm/plugin/appbrand/widget/desktop/AppBrandDesktopView$AppBrandItem;", "getNextPageDataList", "", "callback", "Lkotlin/Function1;", "hasMore", "", "title", "", "viewType", "", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class c
{
  public abstract String aUa();
  
  public boolean aWl()
  {
    return false;
  }
  
  public abstract void ab(b<? super List<? extends AppBrandDesktopView.a>, ah> paramb);
  
  public abstract int cPD();
  
  public abstract List<AppBrandDesktopView.a> cPE();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.c
 * JD-Core Version:    0.7.0.1
 */