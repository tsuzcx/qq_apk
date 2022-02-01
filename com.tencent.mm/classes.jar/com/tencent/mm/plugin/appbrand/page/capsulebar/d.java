package com.tencent.mm.plugin.appbrand.page.capsulebar;

import android.content.Context;
import android.graphics.Canvas;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.tencent.luggage.wxa.a.a;
import com.tencent.luggage.wxa.a.c;
import com.tencent.luggage.wxa.a.d;
import com.tencent.luggage.wxa.a.e;
import com.tencent.luggage.wxa.a.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.cc;
import com.tencent.mm.plugin.appbrand.widget.actionbar.AppBrandCapsuleHomeButton;
import com.tencent.mm.plugin.appbrand.widget.actionbar.AppBrandOptionButton;

public final class d
  extends FrameLayout
  implements g, cc
{
  private int qwX;
  private AppBrandOptionButton qwY;
  private AppBrandCapsuleHomeButton qwZ;
  private LinearLayout qxa;
  private View qxb;
  public View qxc;
  
  public d(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(243781);
    this.qwX = 0;
    LayoutInflater.from(paramContext).inflate(a.e.app_brand_capsule_bar_view_layout, this);
    this.qwY = ((AppBrandOptionButton)findViewById(a.d.actionbar_capsule_option_btn));
    this.qwZ = ((AppBrandCapsuleHomeButton)findViewById(a.d.actionbar_capsule_home_btn));
    this.qxa = ((LinearLayout)findViewById(a.d.actionbar_capsule_area));
    this.qxb = findViewById(a.d.actionbar_capsule_divider);
    this.qwY.setAccessibilityLabel(getContext().getString(a.g.app_brand_accessibility_option_button));
    this.qwZ.setAccessibilityLabel(getContext().getString(a.g.app_brand_accessibility_close_button));
    AppMethodBeat.o(243781);
  }
  
  public final boolean d(Canvas paramCanvas)
  {
    AppMethodBeat.i(243782);
    draw(paramCanvas);
    AppMethodBeat.o(243782);
    return true;
  }
  
  public final View getCapsuleContentAreaView()
  {
    return this.qxa;
  }
  
  public final AppBrandCapsuleHomeButton getCapsuleHomeButton()
  {
    return this.qwZ;
  }
  
  public final AppBrandOptionButton getOptionBtn()
  {
    return this.qwY;
  }
  
  public final void setHomeButtonOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(243786);
    this.qwZ.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(243786);
  }
  
  public final void setOptionButtonOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(243787);
    this.qwY.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(243787);
  }
  
  public final void setStyleColor(int paramInt)
  {
    AppMethodBeat.i(243784);
    if (paramInt == this.qwX)
    {
      AppMethodBeat.o(243784);
      return;
    }
    if (paramInt == -1)
    {
      this.qwX = -1;
      this.qxb.setBackgroundResource(a.a.app_brand_capsule_divider_dark);
      this.qxa.setBackgroundResource(a.c.app_brand_game_capsule_dark_background);
      this.qwY.setColor(-1);
      this.qwZ.setColor(-1);
    }
    for (;;)
    {
      if (this.qxc != null)
      {
        this.qxc.animate().cancel();
        removeView(this.qxc);
      }
      AppMethodBeat.o(243784);
      return;
      this.qwX = -16777216;
      this.qxb.setBackgroundResource(a.a.app_brand_capsule_divider_light);
      this.qxa.setBackgroundResource(a.c.app_brand_game_capsule_light_background);
      this.qwY.setColor(-16777216);
      this.qwZ.setColor(-16777216);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.capsulebar.d
 * JD-Core Version:    0.7.0.1
 */