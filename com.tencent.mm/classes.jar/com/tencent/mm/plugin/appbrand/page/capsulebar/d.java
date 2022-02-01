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
import com.tencent.mm.plugin.appbrand.page.cg;
import com.tencent.mm.plugin.appbrand.widget.actionbar.AppBrandCapsuleHomeButton;
import com.tencent.mm.plugin.appbrand.widget.actionbar.AppBrandOptionButton;

public final class d
  extends FrameLayout
  implements k, cg
{
  private int tBW;
  private AppBrandOptionButton tBX;
  private AppBrandCapsuleHomeButton tBY;
  private LinearLayout tBZ;
  private View tCa;
  public View tCb;
  
  public d(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(325255);
    this.tBW = 0;
    LayoutInflater.from(paramContext).inflate(a.e.app_brand_capsule_bar_view_layout, this);
    this.tBX = ((AppBrandOptionButton)findViewById(a.d.actionbar_capsule_option_btn));
    this.tBY = ((AppBrandCapsuleHomeButton)findViewById(a.d.actionbar_capsule_home_btn));
    this.tBZ = ((LinearLayout)findViewById(a.d.actionbar_capsule_area));
    this.tCa = findViewById(a.d.actionbar_capsule_divider);
    this.tBX.setAccessibilityLabel(getContext().getString(a.g.app_brand_accessibility_option_button));
    this.tBY.setAccessibilityLabel(getContext().getString(a.g.app_brand_accessibility_close_button));
    AppMethodBeat.o(325255);
  }
  
  public final boolean g(Canvas paramCanvas)
  {
    AppMethodBeat.i(325260);
    draw(paramCanvas);
    AppMethodBeat.o(325260);
    return true;
  }
  
  public final View getCapsuleContentAreaView()
  {
    return this.tBZ;
  }
  
  public final AppBrandCapsuleHomeButton getCapsuleHomeButton()
  {
    return this.tBY;
  }
  
  public final AppBrandOptionButton getOptionBtn()
  {
    return this.tBX;
  }
  
  public final void setHomeButtonOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(325288);
    this.tBY.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(325288);
  }
  
  public final void setOptionButtonOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(325297);
    this.tBX.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(325297);
  }
  
  public final void setStyleColor(int paramInt)
  {
    AppMethodBeat.i(325267);
    if (paramInt == this.tBW)
    {
      AppMethodBeat.o(325267);
      return;
    }
    if (paramInt == -1)
    {
      this.tBW = -1;
      this.tCa.setBackgroundResource(a.a.app_brand_capsule_divider_dark);
      this.tBZ.setBackgroundResource(a.c.app_brand_game_capsule_dark_background);
      this.tBX.setColor(-1);
      this.tBY.setColor(-1);
    }
    for (;;)
    {
      if (this.tCb != null)
      {
        this.tCb.animate().cancel();
        removeView(this.tCb);
      }
      AppMethodBeat.o(325267);
      return;
      this.tBW = -16777216;
      this.tCa.setBackgroundResource(a.a.app_brand_capsule_divider_light);
      this.tBZ.setBackgroundResource(a.c.app_brand_game_capsule_light_background);
      this.tBX.setColor(-16777216);
      this.tBY.setColor(-16777216);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.capsulebar.d
 * JD-Core Version:    0.7.0.1
 */