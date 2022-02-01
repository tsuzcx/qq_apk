package com.tencent.mm.plugin.appbrand.page;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import androidx.core.content.a;
import com.tencent.luggage.wxa.a.b;
import com.tencent.luggage.wxa.a.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.widget.actionbar.b;
import com.tencent.mm.plugin.appbrand.widget.actionbar.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/page/AppBrandActionBarHomeButtonStyle;", "Lcom/tencent/mm/plugin/appbrand/widget/actionbar/AppBrandActionBar$AbsNavResetStyleListener;", "pageView", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;", "(Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;)V", "hidden", "", "navStyleApplied", "getNavAreaLeftMarginResourceId", "", "isNavStyleInvisible", "onBackButtonClicked", "view", "Landroid/view/View;", "resetNavStyle", "", "navButton", "Landroid/widget/ImageView;", "navArea", "navContainer", "Companion", "luggage-wxa-app_release"}, k=1, mv={1, 5, 1}, xi=48)
public class c
  extends b.a
{
  private static final c.a ttA;
  public boolean trn;
  private final ad ttB;
  public boolean ttC;
  
  static
  {
    AppMethodBeat.i(324882);
    ttA = new c.a((byte)0);
    AppMethodBeat.o(324882);
  }
  
  public c(ad paramad)
  {
    AppMethodBeat.i(324877);
    this.ttB = paramad;
    AppMethodBeat.o(324877);
  }
  
  private static final boolean a(View paramView1, View paramView2, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(324879);
    if (paramView1 != null)
    {
      paramView1.onTouchEvent(paramMotionEvent);
      AppMethodBeat.o(324879);
      return true;
    }
    AppMethodBeat.o(324879);
    return false;
  }
  
  public final void a(ImageView paramImageView, View paramView1, View paramView2)
  {
    AppMethodBeat.i(324894);
    this.ttC = true;
    if (this.ttB.cEC() == null)
    {
      AppMethodBeat.o(324894);
      return;
    }
    if (paramImageView != null)
    {
      Object localObject = paramImageView.getLayoutParams();
      if (localObject == null)
      {
        paramImageView = new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        AppMethodBeat.o(324894);
        throw paramImageView;
      }
      localObject = (LinearLayout.LayoutParams)localObject;
      i = paramImageView.getContext().getResources().getDimensionPixelOffset(a.b.app_brand_actionbar_home_nav_btn_h_w);
      ((LinearLayout.LayoutParams)localObject).height = i;
      ((LinearLayout.LayoutParams)localObject).width = i;
      ((LinearLayout.LayoutParams)localObject).gravity = 17;
      paramImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      ((LinearLayout.LayoutParams)localObject).leftMargin = 0;
      ((LinearLayout.LayoutParams)localObject).rightMargin = 0;
      paramImageView.clearColorFilter();
      paramImageView.setImageDrawable(a.m(paramImageView.getContext(), a.c.app_brand_action_bar_homebtn));
      paramImageView.setColorFilter(this.ttB.cEC().getForegroundColor(), PorterDuff.Mode.SRC_ATOP);
      paramImageView.setBackgroundResource(a.c.app_brand_back_home_button_background);
      i = paramImageView.getContext().getResources().getDimensionPixelOffset(a.b.SmallPadding);
      paramImageView.setPadding(i, paramImageView.getPaddingTop(), i, paramImageView.getPaddingBottom());
    }
    if (paramView1 != null)
    {
      paramImageView = paramView1.getLayoutParams();
      if (paramImageView == null)
      {
        paramImageView = new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        AppMethodBeat.o(324894);
        throw paramImageView;
      }
      paramImageView = (LinearLayout.LayoutParams)paramImageView;
      i = paramView1.getContext().getResources().getDimensionPixelOffset(a.b.app_brand_actionbar_home_nav_area_h_w);
      paramImageView.height = i;
      paramImageView.width = i;
      paramImageView.gravity = 17;
      paramImageView.leftMargin = paramView1.getContext().getResources().getDimensionPixelOffset(a.b.app_brand_actionbar_home_nav_area_margin_left);
      paramImageView.rightMargin = paramView1.getContext().getResources().getDimensionPixelOffset(a.b.app_brand_actionbar_home_nav_area_margin_right);
      paramView1.setLayoutParams((ViewGroup.LayoutParams)paramImageView);
      if (this.ttB.cEC().getForegroundColor() != -1) {
        break label352;
      }
    }
    label352:
    for (int i = a.c.app_brand_game_capsule_dark_background;; i = a.c.app_brand_game_capsule_light_background)
    {
      paramView1.setBackgroundResource(i);
      if (paramView2 != null) {
        paramView2.setOnTouchListener(new c..ExternalSyntheticLambda0(paramView1));
      }
      AppMethodBeat.o(324894);
      return;
    }
  }
  
  public final int cDN()
  {
    return a.b.app_brand_actionbar_home_nav_area_margin_left;
  }
  
  public boolean dz(View paramView)
  {
    AppMethodBeat.i(324901);
    s.u(paramView, "view");
    Log.i("MicroMsg.AppBrandActionBarHomeButtonStyle", "pageView click close button");
    if (this.ttB.cEC().cOU()) {
      Log.i("MicroMsg.AppBrandActionBarHomeButtonStyle", "pageView click close button, but nav area is hidden");
    }
    for (;;)
    {
      AppMethodBeat.o(324901);
      return true;
      paramView = this.ttB.getRuntime().getPageContainer();
      if (paramView != null) {
        paramView.cEn();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.c
 * JD-Core Version:    0.7.0.1
 */