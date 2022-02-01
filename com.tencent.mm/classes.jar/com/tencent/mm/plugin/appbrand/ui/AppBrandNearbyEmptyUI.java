package com.tencent.mm.plugin.appbrand.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.au.c;
import com.tencent.mm.plugin.appbrand.au.f;
import com.tencent.mm.plugin.appbrand.au.g;
import com.tencent.mm.plugin.appbrand.au.i;
import com.tencent.mm.plugin.appbrand.c.c.b;
import com.tencent.mm.plugin.appbrand.report.model.l;
import com.tencent.mm.plugin.appbrand.report.model.l.a;
import com.tencent.mm.plugin.appbrand.report.model.l.b;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ar;

public final class AppBrandNearbyEmptyUI
  extends MMActivity
{
  public final int getLayoutId()
  {
    return au.g.app_brand_nearby_empty_ui;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(48664);
    super.onCreate(paramBundle);
    if (getIntent() == null)
    {
      finish();
      AppMethodBeat.o(48664);
      return;
    }
    if (ar.hIO()) {
      overridePendingTransition(0, 0);
    }
    getContentView().setBackgroundColor(getContext().getResources().getColor(au.c.normal_actionbar_color));
    setActionbarColor(getContext().getResources().getColor(au.c.normal_actionbar_color));
    setMMTitle(au.i.app_brand_nearby_list_title);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(48663);
        AppBrandNearbyEmptyUI.this.onBackPressed();
        AppMethodBeat.o(48663);
        return true;
      }
    });
    if (getSupportActionBar() != null)
    {
      paramBundle = getSupportActionBar().getCustomView().findViewById(c.b.actionbar_up_indicator);
      if ((paramBundle != null) && (paramBundle.getLayoutParams() != null) && ((paramBundle.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)))
      {
        ((ViewGroup.MarginLayoutParams)paramBundle.getLayoutParams()).rightMargin = 0;
        paramBundle.requestLayout();
      }
    }
    paramBundle = (TextView)findViewById(au.f.content_title);
    TextView localTextView = (TextView)findViewById(au.f.content_message);
    switch (getIntent().getIntExtra("extra_enter_reason", 0))
    {
    default: 
      finish();
      AppMethodBeat.o(48664);
      return;
    case 0: 
      paramBundle = new l();
      paramBundle.qLr = l.b.qLE;
      paramBundle.qLv = l.a.qLx;
      paramBundle.report();
    }
    for (;;)
    {
      setResult(-1);
      AppMethodBeat.o(48664);
      return;
      paramBundle.setText(au.i.app_brand_nearby_lbs_not_allowed_title);
      localTextView.setText(au.i.app_brand_nearby_lbs_not_allowed_message);
      paramBundle = new l();
      paramBundle.qLr = l.b.qLE;
      paramBundle.qLv = l.a.qLy;
      paramBundle.report();
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandNearbyEmptyUI
 * JD-Core Version:    0.7.0.1
 */