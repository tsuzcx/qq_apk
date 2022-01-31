package com.tencent.mm.plugin.appbrand.ui;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.app.g;
import com.tencent.mm.plugin.appbrand.report.model.n;
import com.tencent.mm.plugin.appbrand.report.model.n.a;
import com.tencent.mm.plugin.appbrand.ui.banner.AppBrandStickyBannerLogic.b;
import com.tencent.mm.plugin.appbrand.ui.banner.f;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.widget.b.c.a;

@com.tencent.mm.ui.base.a(7)
public final class AppBrandGuideUI
  extends MMActivity
  implements f
{
  public final void bf(String paramString, int paramInt)
  {
    AppMethodBeat.i(132963);
    finish();
    AppMethodBeat.o(132963);
  }
  
  public final int getLayoutId()
  {
    return -1;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(132961);
    setTheme(2131492900);
    super.onCreate(paramBundle);
    af.a(getWindow());
    paramBundle = g.auE();
    if (paramBundle == null)
    {
      super.finish();
      AppMethodBeat.o(132961);
      return;
    }
    AppBrandStickyBannerLogic.b.d(this);
    Object localObject = new c.a(this);
    ((c.a)localObject).Rb(2131296630);
    ImageView localImageView = new ImageView(this);
    localImageView.setImageResource(2130837746);
    TextView localTextView = new TextView(this);
    localTextView.setText(2131296676);
    localTextView.setTextSize(2, 14.0F);
    localTextView.setTextColor(Color.argb(Math.round(137.70001F), 0, 0, 0));
    localTextView.setLineSpacing(0.0F, 1.2F);
    LinearLayout localLinearLayout = new LinearLayout(this);
    localLinearLayout.setOrientation(1);
    localLinearLayout.addView(localImageView, new LinearLayout.LayoutParams(-1, -2));
    localLinearLayout.addView(localTextView, new LinearLayout.LayoutParams(-1, -2));
    ((ViewGroup.MarginLayoutParams)localTextView.getLayoutParams()).topMargin = com.tencent.mm.cb.a.fromDPToPix(this, 16);
    ((c.a)localObject).fu(localLinearLayout);
    ((c.a)localObject).a(new AppBrandGuideUI.1(this));
    ((c.a)localObject).Rj(2131298417);
    ((c.a)localObject).b(new AppBrandGuideUI.2(this));
    ((c.a)localObject).Ri(2131296675);
    ((c.a)localObject).a(false, new AppBrandGuideUI.3(this));
    ((c.a)localObject).rG(false);
    ((c.a)localObject).rH(true);
    localObject = ((c.a)localObject).aLZ();
    ((Dialog)localObject).setOnKeyListener(new AppBrandGuideUI.4(this));
    ((Dialog)localObject).show();
    n.a(n.a.iHY, paramBundle.iMB);
    paramBundle.iMA = false;
    paramBundle.iMB = null;
    AppMethodBeat.o(132961);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(132962);
    super.onDestroy();
    AppBrandStickyBannerLogic.b.c(this);
    AppMethodBeat.o(132962);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandGuideUI
 * JD-Core Version:    0.7.0.1
 */