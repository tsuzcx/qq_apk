package com.tencent.mm.plugin.appbrand.ui.collection;

import a.d.b.g;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.plugin.appbrand.y.a;
import java.io.Serializable;

final class a$d
  implements MenuItem.OnMenuItemClickListener
{
  a$d(a parama) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    paramMenuItem = AppBrandCollectionSortUI.hgp;
    paramMenuItem = this.hgh.getActivity();
    if (paramMenuItem == null) {
      g.cUk();
    }
    g.j(paramMenuItem, "activity!!");
    Context localContext = (Context)paramMenuItem;
    paramMenuItem = a.b(this.hgh);
    if (paramMenuItem == null) {
      g.cUk();
    }
    paramMenuItem = paramMenuItem.hgv;
    int i = a.c(this.hgh);
    String str = a.d(this.hgh);
    g.k(localContext, "context");
    g.k(paramMenuItem, "dataList");
    g.k(str, "operateReportSceneId");
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
        paramMenuItem.overridePendingTransition(y.a.alpha_in, y.a.anim_not_change);
      }
      a.e(this.hgh);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.collection.a.d
 * JD-Core Version:    0.7.0.1
 */