package com.tencent.mm.plugin.appbrand.ui.recommend;

import a.f.b.j;
import a.l;
import android.app.Activity;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"com/tencent/mm/plugin/appbrand/ui/recommend/AppBrandLauncherRecommendList$uiLogic$2$1", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic;", "contentView", "Landroid/view/View;", "kotlin.jvm.PlatformType", "getContentView", "()Landroid/view/View;", "headerViewText", "", "getHeaderViewText", "()Ljava/lang/String;", "needHeader", "", "getNeedHeader", "()Z", "postOnUiThread", "", "runnable", "Ljava/lang/Runnable;", "plugin-appbrand-integration_release"})
public final class AppBrandLauncherRecommendList$uiLogic$2$1
  extends AppBrandRecommendUILogic
{
  private final boolean needHeader = true;
  
  AppBrandLauncherRecommendList$uiLogic$2$1(Activity paramActivity)
  {
    super(localActivity);
  }
  
  public final String aNx()
  {
    AppMethodBeat.i(135140);
    String str = this.iVL.iVK.getString(2131296821);
    j.p(str, "this@AppBrandLauncherRec…header_text_all_use_hint)");
    AppMethodBeat.o(135140);
    return str;
  }
  
  public final boolean aNy()
  {
    return this.needHeader;
  }
  
  public final View getContentView()
  {
    AppMethodBeat.i(135141);
    View localView = this.iVL.iVK.getContentView();
    AppMethodBeat.o(135141);
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recommend.AppBrandLauncherRecommendList.uiLogic.2.1
 * JD-Core Version:    0.7.0.1
 */