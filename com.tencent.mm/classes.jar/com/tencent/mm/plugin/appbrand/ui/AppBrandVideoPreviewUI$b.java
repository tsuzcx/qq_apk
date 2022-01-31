package com.tencent.mm.plugin.appbrand.ui;

import a.f.b.j;
import a.l;
import a.v;
import android.view.View;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.d.e;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "it", "", "onVisibilityChanged"})
final class AppBrandVideoPreviewUI$b
  implements d.e
{
  AppBrandVideoPreviewUI$b(AppBrandVideoPreviewUI paramAppBrandVideoPreviewUI, View paramView) {}
  
  public final void onVisibilityChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(143987);
    if (!paramBoolean)
    {
      localObject = this.iPV;
      j.p(localObject, "additionView");
      localObject = ((View)localObject).getLayoutParams();
      if (localObject == null)
      {
        localObject = new v("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        AppMethodBeat.o(143987);
        throw ((Throwable)localObject);
      }
      ((RelativeLayout.LayoutParams)localObject).bottomMargin = AppBrandVideoPreviewUI.e(this.iPU);
      AppMethodBeat.o(143987);
      return;
    }
    Object localObject = this.iPV;
    j.p(localObject, "additionView");
    localObject = ((View)localObject).getLayoutParams();
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
      AppMethodBeat.o(143987);
      throw ((Throwable)localObject);
    }
    ((RelativeLayout.LayoutParams)localObject).bottomMargin = AppBrandVideoPreviewUI.f(this.iPU);
    AppMethodBeat.o(143987);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandVideoPreviewUI.b
 * JD-Core Version:    0.7.0.1
 */