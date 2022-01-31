package com.tencent.mm.plugin.appbrand.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.report.model.k;
import com.tencent.mm.plugin.appbrand.report.model.k.a;
import com.tencent.mm.plugin.appbrand.report.model.k.b;
import com.tencent.mm.ui.MMActivity;

public final class AppBrandNearbyEmptyUI
  extends MMActivity
{
  public final int getLayoutId()
  {
    return 2130968699;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(132993);
    super.onCreate(paramBundle);
    if (getIntent() == null)
    {
      finish();
      AppMethodBeat.o(132993);
      return;
    }
    getContentView().setBackgroundColor(-855310);
    setActionbarColor(-855310);
    setMMTitle(2131296744);
    setMMTitleColor(-16777216);
    setBackBtn(new AppBrandNearbyEmptyUI.1(this));
    q.b(this);
    paramBundle = (TextView)findViewById(2131821264);
    TextView localTextView = (TextView)findViewById(2131821265);
    switch (getIntent().getIntExtra("extra_enter_reason", 0))
    {
    default: 
      finish();
      AppMethodBeat.o(132993);
      return;
    case 0: 
      paramBundle = new k();
      paramBundle.iHs = k.b.iHF;
      paramBundle.iHw = k.a.iHy;
      paramBundle.IE();
    }
    for (;;)
    {
      setResult(-1);
      AppMethodBeat.o(132993);
      return;
      paramBundle.setText(2131296743);
      localTextView.setText(2131296742);
      paramBundle = new k();
      paramBundle.iHs = k.b.iHF;
      paramBundle.iHw = k.a.iHz;
      paramBundle.IE();
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