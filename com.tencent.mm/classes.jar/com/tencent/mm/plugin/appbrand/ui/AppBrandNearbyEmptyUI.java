package com.tencent.mm.plugin.appbrand.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.report.model.l;
import com.tencent.mm.plugin.appbrand.report.model.l.a;
import com.tencent.mm.plugin.appbrand.report.model.l.b;
import com.tencent.mm.ui.MMActivity;

public final class AppBrandNearbyEmptyUI
  extends MMActivity
{
  public final int getLayoutId()
  {
    return 2131493014;
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
    getContentView().setBackgroundColor(getContext().getResources().getColor(2131100705));
    setActionbarColor(getContext().getResources().getColor(2131100705));
    setMMTitle(2131755529);
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
      paramBundle = getSupportActionBar().getCustomView().findViewById(2131296416);
      if ((paramBundle != null) && (paramBundle.getLayoutParams() != null) && ((paramBundle.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)))
      {
        ((ViewGroup.MarginLayoutParams)paramBundle.getLayoutParams()).rightMargin = 0;
        paramBundle.requestLayout();
      }
    }
    paramBundle = (TextView)findViewById(2131298776);
    TextView localTextView = (TextView)findViewById(2131298766);
    switch (getIntent().getIntExtra("extra_enter_reason", 0))
    {
    default: 
      finish();
      AppMethodBeat.o(48664);
      return;
    case 0: 
      paramBundle = new l();
      paramBundle.myd = l.b.myq;
      paramBundle.myh = l.a.myj;
      paramBundle.report();
    }
    for (;;)
    {
      setResult(-1);
      AppMethodBeat.o(48664);
      return;
      paramBundle.setText(2131755528);
      localTextView.setText(2131755527);
      paramBundle = new l();
      paramBundle.myd = l.b.myq;
      paramBundle.myh = l.a.myk;
      paramBundle.report();
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandNearbyEmptyUI
 * JD-Core Version:    0.7.0.1
 */