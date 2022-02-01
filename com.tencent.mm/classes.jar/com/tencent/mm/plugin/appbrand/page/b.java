package com.tencent.mm.plugin.appbrand.page;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import androidx.core.content.a;
import com.tencent.luggage.wxa.a.b;
import com.tencent.luggage.wxa.a.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/page/AppBrandActionBarHomeButtonStyle;", "Lcom/tencent/mm/plugin/appbrand/widget/actionbar/AppBrandActionBar$AbsNavResetStyleListener;", "pageView", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;", "(Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;)V", "hidden", "", "navStyleApplied", "getNavAreaLeftMarginResourceId", "", "isNavStyleInvisible", "onBackButtonClicked", "view", "Landroid/view/View;", "resetNavStyle", "", "navButton", "Landroid/widget/ImageView;", "navArea", "navContainer", "Companion", "luggage-wxa-app_release"})
public class b
  extends com.tencent.mm.plugin.appbrand.widget.actionbar.b.a
{
  @Deprecated
  public static final b.a qoY;
  public boolean qmt;
  public boolean qoW;
  private final ad qoX;
  
  static
  {
    AppMethodBeat.i(242794);
    qoY = new b.a((byte)0);
    AppMethodBeat.o(242794);
  }
  
  public b(ad paramad)
  {
    AppMethodBeat.i(242793);
    this.qoX = paramad;
    AppMethodBeat.o(242793);
  }
  
  public final void a(ImageView paramImageView, View paramView1, View paramView2)
  {
    AppMethodBeat.i(242791);
    this.qoW = true;
    Object localObject;
    if (paramImageView != null)
    {
      localObject = paramImageView.getLayoutParams();
      if (localObject == null)
      {
        paramImageView = new t("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        AppMethodBeat.o(242791);
        throw paramImageView;
      }
      localObject = (LinearLayout.LayoutParams)localObject;
      Context localContext = paramImageView.getContext();
      p.j(localContext, "navButton.context");
      i = localContext.getResources().getDimensionPixelOffset(a.b.app_brand_actionbar_home_nav_btn_h_w);
      ((LinearLayout.LayoutParams)localObject).height = i;
      ((LinearLayout.LayoutParams)localObject).width = i;
      ((LinearLayout.LayoutParams)localObject).gravity = 17;
      paramImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      ((LinearLayout.LayoutParams)localObject).leftMargin = 0;
      ((LinearLayout.LayoutParams)localObject).rightMargin = 0;
      paramImageView.clearColorFilter();
      paramImageView.setImageDrawable(a.m(paramImageView.getContext(), a.c.app_brand_action_bar_homebtn));
      localObject = this.qoX.cdY();
      p.j(localObject, "pageView.actionBar");
      paramImageView.setColorFilter(((com.tencent.mm.plugin.appbrand.widget.actionbar.b)localObject).getForegroundColor(), PorterDuff.Mode.SRC_ATOP);
      paramImageView.setBackgroundResource(a.c.app_brand_back_home_button_background);
      localObject = paramImageView.getContext();
      p.j(localObject, "navButton.context");
      i = ((Context)localObject).getResources().getDimensionPixelOffset(a.b.SmallPadding);
      paramImageView.setPadding(i, paramImageView.getPaddingTop(), i, paramImageView.getPaddingBottom());
    }
    if (paramView1 != null)
    {
      paramImageView = paramView1.getLayoutParams();
      if (paramImageView == null)
      {
        paramImageView = new t("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        AppMethodBeat.o(242791);
        throw paramImageView;
      }
      paramImageView = (LinearLayout.LayoutParams)paramImageView;
      localObject = paramView1.getContext();
      p.j(localObject, "navArea.context");
      i = ((Context)localObject).getResources().getDimensionPixelOffset(a.b.app_brand_actionbar_home_nav_area_h_w);
      paramImageView.height = i;
      paramImageView.width = i;
      paramImageView.gravity = 17;
      localObject = paramView1.getContext();
      p.j(localObject, "navArea.context");
      paramImageView.leftMargin = ((Context)localObject).getResources().getDimensionPixelOffset(a.b.app_brand_actionbar_home_nav_area_margin_left);
      localObject = paramView1.getContext();
      p.j(localObject, "navArea.context");
      paramImageView.rightMargin = ((Context)localObject).getResources().getDimensionPixelOffset(a.b.app_brand_actionbar_home_nav_area_margin_right);
      paramView1.setLayoutParams((ViewGroup.LayoutParams)paramImageView);
      paramImageView = this.qoX.cdY();
      p.j(paramImageView, "pageView.actionBar");
      if (paramImageView.getForegroundColor() != -1) {
        break label413;
      }
    }
    label413:
    for (int i = a.c.app_brand_game_capsule_dark_background;; i = a.c.app_brand_game_capsule_light_background)
    {
      paramView1.setBackgroundResource(i);
      if (paramView2 == null) {
        break;
      }
      paramView2.setOnTouchListener((View.OnTouchListener)new b(paramView1));
      AppMethodBeat.o(242791);
      return;
    }
    AppMethodBeat.o(242791);
  }
  
  public boolean cS(View paramView)
  {
    AppMethodBeat.i(242792);
    p.k(paramView, "view");
    Log.i("MicroMsg.AppBrandActionBarHomeButtonStyle", "pageView click close button");
    paramView = this.qoX.cdY();
    p.j(paramView, "pageView.actionBar");
    if (paramView.cnb()) {
      Log.i("MicroMsg.AppBrandActionBarHomeButtonStyle", "pageView click close button, but nav area is hidden");
    }
    for (;;)
    {
      AppMethodBeat.o(242792);
      return true;
      paramView = this.qoX.getRuntime();
      p.j(paramView, "pageView.runtime");
      paramView = paramView.bBX();
      if (paramView != null) {
        paramView.cdH();
      }
    }
  }
  
  public final int cdp()
  {
    return a.b.app_brand_actionbar_home_nav_area_margin_left;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "<anonymous parameter 0>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "event", "Landroid/view/MotionEvent;", "onTouch"})
  static final class b
    implements View.OnTouchListener
  {
    b(View paramView) {}
    
    public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(243518);
      if (this.qoZ != null)
      {
        this.qoZ.onTouchEvent(paramMotionEvent);
        AppMethodBeat.o(243518);
        return true;
      }
      AppMethodBeat.o(243518);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.b
 * JD-Core Version:    0.7.0.1
 */