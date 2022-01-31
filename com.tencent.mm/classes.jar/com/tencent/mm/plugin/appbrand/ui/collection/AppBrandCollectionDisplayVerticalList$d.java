package com.tencent.mm.plugin.appbrand.ui.collection;

import a.l;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Serializable;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
final class AppBrandCollectionDisplayVerticalList$d
  implements MenuItem.OnMenuItemClickListener
{
  AppBrandCollectionDisplayVerticalList$d(AppBrandCollectionDisplayVerticalList paramAppBrandCollectionDisplayVerticalList) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(135010);
    if (this.iRw.getActivity() == null)
    {
      AppMethodBeat.o(135010);
      return true;
    }
    paramMenuItem = AppBrandCollectionSortUI.iRE;
    paramMenuItem = this.iRw.getActivity();
    if (paramMenuItem == null) {
      a.f.b.j.ebi();
    }
    a.f.b.j.p(paramMenuItem, "activity!!");
    Context localContext = (Context)paramMenuItem;
    paramMenuItem = AppBrandCollectionDisplayVerticalList.b(this.iRw);
    if (paramMenuItem == null) {
      a.f.b.j.ebi();
    }
    paramMenuItem = paramMenuItem.iRT;
    int i = AppBrandCollectionDisplayVerticalList.c(this.iRw);
    String str = AppBrandCollectionDisplayVerticalList.d(this.iRw);
    a.f.b.j.q(localContext, "context");
    a.f.b.j.q(paramMenuItem, "dataList");
    a.f.b.j.q(str, "operateReportSceneId");
    Intent localIntent = new Intent(localContext, AppBrandCollectionSortUI.class);
    localIntent.putExtra("KEY_SORT_DATA_LIST", (Serializable)paramMenuItem);
    localIntent.putExtra("KEY_OPERATE_REPORT_SCENE", i);
    localIntent.putExtra("KEY_OPERATE_REPORT_SCENE_ID", str);
    if ((localContext instanceof Activity)) {}
    for (i = 0;; i = 268435456)
    {
      localIntent.addFlags(i);
      localContext.startActivity(localIntent);
      paramMenuItem = localContext;
      if (!(localContext instanceof Activity)) {
        paramMenuItem = null;
      }
      paramMenuItem = (Activity)paramMenuItem;
      if (paramMenuItem != null) {
        paramMenuItem.overridePendingTransition(2131034125, 2131034130);
      }
      AppBrandCollectionDisplayVerticalList.e(this.iRw);
      AppMethodBeat.o(135010);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.collection.AppBrandCollectionDisplayVerticalList.d
 * JD-Core Version:    0.7.0.1
 */