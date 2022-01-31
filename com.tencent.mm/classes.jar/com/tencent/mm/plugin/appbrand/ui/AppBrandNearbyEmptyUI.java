package com.tencent.mm.plugin.appbrand.ui;

import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.plugin.appbrand.report.model.k;
import com.tencent.mm.plugin.appbrand.report.model.k.a;
import com.tencent.mm.plugin.appbrand.report.model.k.b;
import com.tencent.mm.plugin.appbrand.y.g;
import com.tencent.mm.plugin.appbrand.y.h;
import com.tencent.mm.plugin.appbrand.y.j;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.statusbar.DrawStatusBarActivity;

public final class AppBrandNearbyEmptyUI
  extends DrawStatusBarActivity
{
  protected final int getLayoutId()
  {
    return y.h.app_brand_nearby_empty_ui;
  }
  
  public final int getStatusBarColor()
  {
    if ((Build.VERSION.SDK_INT >= 23) && (l.b(getWindow()))) {
      return -855310;
    }
    if (Build.VERSION.SDK_INT >= 21) {
      return AppBrandLauncherUI.hcS;
    }
    return super.getStatusBarColor();
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (getIntent() == null)
    {
      finish();
      return;
    }
    this.mController.contentView.setBackgroundColor(-855310);
    ta(-855310);
    setMMTitle(y.j.app_brand_nearby_list_title);
    oX(-16777216);
    setBackBtn(new AppBrandNearbyEmptyUI.1(this));
    m.b(this);
    paramBundle = (TextView)findViewById(y.g.content_title);
    TextView localTextView = (TextView)findViewById(y.g.content_message);
    switch (getIntent().getIntExtra("extra_enter_reason", 0))
    {
    default: 
      finish();
      return;
    case 0: 
      paramBundle = new k();
      paramBundle.gZc = k.b.gZp;
      paramBundle.gZg = k.a.gZi;
      paramBundle.wn();
    }
    for (;;)
    {
      setResult(-1);
      return;
      paramBundle.setText(y.j.app_brand_nearby_lbs_not_allowed_title);
      localTextView.setText(y.j.app_brand_nearby_lbs_not_allowed_message);
      paramBundle = new k();
      paramBundle.gZc = k.b.gZp;
      paramBundle.gZg = k.a.gZj;
      paramBundle.wn();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandNearbyEmptyUI
 * JD-Core Version:    0.7.0.1
 */