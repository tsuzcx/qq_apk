package com.tencent.mm.plugin.appbrand.ui;

import android.app.Dialog;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.plugin.appbrand.app.e;
import com.tencent.mm.plugin.appbrand.report.model.n;
import com.tencent.mm.plugin.appbrand.report.model.n.a;
import com.tencent.mm.plugin.appbrand.ui.banner.AppBrandStickyBannerLogic.b;
import com.tencent.mm.plugin.appbrand.ui.banner.f;
import com.tencent.mm.plugin.appbrand.y.f;
import com.tencent.mm.plugin.appbrand.y.j;
import com.tencent.mm.plugin.appbrand.y.k;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ak;
import com.tencent.mm.ui.widget.a.c.a;

@com.tencent.mm.ui.base.a(7)
public final class AppBrandGuideUI
  extends MMActivity
  implements f
{
  public final void aP(String paramString, int paramInt)
  {
    finish();
  }
  
  protected final int getLayoutId()
  {
    return -1;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    setTheme(y.k.MMTheme_NoTitleTranslucent);
    super.onCreate(paramBundle);
    ak.a(getWindow());
    paramBundle = e.aaR();
    if (paramBundle == null)
    {
      super.finish();
      return;
    }
    AppBrandStickyBannerLogic.b.d(this);
    Object localObject = new c.a(this);
    ((c.a)localObject).Ip(y.j.app_brand_entrance);
    ImageView localImageView = new ImageView(this);
    localImageView.setImageResource(y.f.app_brand_guide_image);
    TextView localTextView = new TextView(this);
    localTextView.setText(y.j.app_brand_guide_message);
    localTextView.setTextSize(2, 14.0F);
    localTextView.setTextColor(Color.argb(Math.round(137.70001F), 0, 0, 0));
    localTextView.setLineSpacing(0.0F, 1.2F);
    LinearLayout localLinearLayout = new LinearLayout(this);
    localLinearLayout.setOrientation(1);
    localLinearLayout.addView(localImageView, new LinearLayout.LayoutParams(-1, -2));
    localLinearLayout.addView(localTextView, new LinearLayout.LayoutParams(-1, -2));
    ((ViewGroup.MarginLayoutParams)localTextView.getLayoutParams()).topMargin = com.tencent.mm.cb.a.fromDPToPix(this, 16);
    ((c.a)localObject).ei(localLinearLayout);
    ((c.a)localObject).a(new AppBrandGuideUI.1(this));
    ((c.a)localObject).It(y.j.close_btn);
    ((c.a)localObject).b(new AppBrandGuideUI.2(this));
    ((c.a)localObject).Is(y.j.app_brand_guide_confirm_view_list);
    ((c.a)localObject).a(false, new AppBrandGuideUI.3(this));
    ((c.a)localObject).nW(false);
    ((c.a)localObject).nX(true);
    localObject = ((c.a)localObject).aoP();
    ((Dialog)localObject).setOnKeyListener(new AppBrandGuideUI.4(this));
    ((Dialog)localObject).show();
    n.a(n.a.gZG, paramBundle.hcO);
    paramBundle.hcN = false;
    paramBundle.hcO = null;
  }
  
  protected final void onDestroy()
  {
    super.onDestroy();
    AppBrandStickyBannerLogic.b.c(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandGuideUI
 * JD-Core Version:    0.7.0.1
 */