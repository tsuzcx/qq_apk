package com.tencent.mm.plugin.appbrand.share.a;

import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.f;
import com.tencent.mm.plugin.appbrand.dynamic.widget.IPCDynamicPageView;
import com.tencent.mm.plugin.appbrand.share.widget.WxaShareMessagePage;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;

final class a$2
  implements f
{
  a$2(a parama, WxaShareMessagePage paramWxaShareMessagePage) {}
  
  public final void I(View paramView, int paramInt)
  {
    AppMethodBeat.i(132740);
    switch (paramInt)
    {
    case 2: 
    case 3: 
    default: 
      this.iJD.getLoadingView().dOW();
      this.iJD.getLoadingView().setVisibility(4);
      this.iJD.getErrorImageView().setVisibility(0);
      this.iJD.getWidgetPageView().setVisibility(4);
      this.iJD.getErrorImageView().setImageResource(2131230887);
      AppMethodBeat.o(132740);
      return;
    case 0: 
      this.iJD.getLoadingView().setVisibility(0);
      this.iJD.getErrorImageView().setVisibility(4);
      this.iJD.getWidgetPageView().setVisibility(4);
      this.iJD.getLoadingView().dOV();
      AppMethodBeat.o(132740);
      return;
    case 1: 
      this.iJD.getLoadingView().dOW();
      this.iJD.getLoadingView().setVisibility(4);
      this.iJD.getErrorImageView().setVisibility(0);
      this.iJD.getWidgetPageView().setVisibility(4);
      this.iJD.getErrorImageView().setImageResource(2131231255);
      AppMethodBeat.o(132740);
      return;
    }
    this.iJD.getLoadingView().setVisibility(4);
    this.iJD.getErrorImageView().setVisibility(4);
    this.iJD.getWidgetPageView().setVisibility(0);
    AppMethodBeat.o(132740);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.share.a.a.2
 * JD-Core Version:    0.7.0.1
 */