package com.tencent.mm.plugin.appbrand.ui;

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
import com.tencent.mm.plugin.appbrand.ba.c;
import com.tencent.mm.plugin.appbrand.ba.f;
import com.tencent.mm.plugin.appbrand.ba.g;
import com.tencent.mm.plugin.appbrand.ba.i;
import com.tencent.mm.plugin.appbrand.d.c.b;
import com.tencent.mm.plugin.appbrand.report.model.o;
import com.tencent.mm.plugin.appbrand.report.model.o.a;
import com.tencent.mm.plugin.appbrand.report.model.o.b;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aw;

public final class AppBrandNearbyEmptyUI
  extends MMActivity
{
  public final int getLayoutId()
  {
    return ba.g.app_brand_nearby_empty_ui;
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
    if (aw.jlc()) {
      overridePendingTransition(0, 0);
    }
    getContentView().setBackgroundColor(getContext().getResources().getColor(ba.c.normal_actionbar_color));
    setActionbarColor(getContext().getResources().getColor(ba.c.normal_actionbar_color));
    setMMTitle(ba.i.app_brand_nearby_list_title);
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
    paramBundle = (TextView)findViewById(ba.f.content_title);
    TextView localTextView = (TextView)findViewById(ba.f.content_message);
    switch (getIntent().getIntExtra("extra_enter_reason", 0))
    {
    default: 
      finish();
      AppMethodBeat.o(48664);
      return;
    case 0: 
      paramBundle = new o();
      paramBundle.tPY = o.b.tQl;
      paramBundle.tQc = o.a.tQe;
      paramBundle.report();
    }
    for (;;)
    {
      setResult(-1);
      AppMethodBeat.o(48664);
      return;
      paramBundle.setText(ba.i.app_brand_nearby_lbs_not_allowed_title);
      localTextView.setText(ba.i.app_brand_nearby_lbs_not_allowed_message);
      paramBundle = new o();
      paramBundle.tPY = o.b.tQl;
      paramBundle.tQc = o.a.tQf;
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