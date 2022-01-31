package com.tencent.mm.plugin.appbrand.share.a;

import android.view.View;
import android.widget.ImageView;
import com.tencent.mm.modelappbrand.f;
import com.tencent.mm.plugin.appbrand.dynamic.widget.IPCDynamicPageView;
import com.tencent.mm.plugin.appbrand.share.widget.WxaShareMessagePage;
import com.tencent.mm.plugin.appbrand.y.i;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;

final class a$2
  implements f
{
  a$2(a parama, WxaShareMessagePage paramWxaShareMessagePage) {}
  
  public final void y(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    case 2: 
    case 3: 
    default: 
      this.haT.getLoadingView().cKc();
      this.haT.getLoadingView().setVisibility(4);
      this.haT.getErrorImageView().setVisibility(0);
      this.haT.getWidgetPageView().setVisibility(4);
      this.haT.getErrorImageView().setImageResource(y.i.app_brand_share_page_cover_default);
      return;
    case 0: 
      this.haT.getLoadingView().setVisibility(0);
      this.haT.getErrorImageView().setVisibility(4);
      this.haT.getWidgetPageView().setVisibility(4);
      this.haT.getLoadingView().cKb();
      return;
    case 1: 
      this.haT.getLoadingView().cKc();
      this.haT.getLoadingView().setVisibility(4);
      this.haT.getErrorImageView().setVisibility(0);
      this.haT.getWidgetPageView().setVisibility(4);
      this.haT.getErrorImageView().setImageResource(y.i.dynamic_page_res_not_found);
      return;
    }
    this.haT.getLoadingView().setVisibility(4);
    this.haT.getErrorImageView().setVisibility(4);
    this.haT.getWidgetPageView().setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.share.a.a.2
 * JD-Core Version:    0.7.0.1
 */