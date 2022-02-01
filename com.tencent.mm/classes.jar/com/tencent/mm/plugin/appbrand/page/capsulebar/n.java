package com.tencent.mm.plugin.appbrand.page.capsulebar;

import android.view.View;
import android.view.View.OnClickListener;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/page/capsulebar/IAppBrandHalfScreenCapsuleBar;", "", "animateHeaderAlpha", "", "alpha", "", "currentAnimationViewAlpha", "getViewsNeedResponseAlphaAnimation", "", "Landroid/view/View;", "isHeaderTransparent", "", "isTouchCloseButton", "rx", "ry", "setCloseBtnListener", "listener", "Landroid/view/View$OnClickListener;", "setHeaderAlpha", "percent", "setShareBtnListener", "setTitle", "name", "", "setTitleClickListener", "setWxaIconUrl", "url", "showHeader", "show", "animate", "callback", "Lcom/tencent/mm/plugin/appbrand/page/capsulebar/CallBack;", "showShareButton", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface n
{
  public abstract boolean cGo();
  
  public abstract float cGp();
  
  public abstract List<View> getViewsNeedResponseAlphaAnimation();
  
  public abstract void kz(boolean paramBoolean);
  
  public abstract void setCloseBtnListener(View.OnClickListener paramOnClickListener);
  
  public abstract void setShareBtnListener(View.OnClickListener paramOnClickListener);
  
  public abstract void setTitle(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.capsulebar.n
 * JD-Core Version:    0.7.0.1
 */