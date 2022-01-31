package com.tencent.mm.plugin.appbrand.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.widget.TextView;
import com.tencent.mm.plugin.appbrand.launching.ActivityStarterIpcDelegate;
import com.tencent.mm.plugin.appbrand.y.g;
import com.tencent.mm.plugin.appbrand.y.h;
import com.tencent.mm.plugin.appbrand.y.j;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.statusbar.DrawStatusBarActivity;

@com.tencent.mm.ui.base.a(19)
public final class AppBrand404PageUI
  extends DrawStatusBarActivity
{
  public static void a(int paramInt, ActivityStarterIpcDelegate paramActivityStarterIpcDelegate)
  {
    a(ae.getContext().getString(paramInt), paramActivityStarterIpcDelegate);
  }
  
  private static void a(String paramString, ActivityStarterIpcDelegate paramActivityStarterIpcDelegate)
  {
    paramString = new Intent(ae.getContext(), AppBrand404PageUI.class).putExtra("key_wording", paramString).putExtra("key_icon_url", null);
    if (paramActivityStarterIpcDelegate != null)
    {
      if (paramString != null)
      {
        Bundle localBundle = new Bundle(1);
        localBundle.putParcelable("intent", paramString);
        paramActivityStarterIpcDelegate.gIT.send(4660, localBundle);
      }
      return;
    }
    ai.d(new AppBrand404PageUI.1(paramString));
  }
  
  public static void show(int paramInt)
  {
    a(ae.getContext().getString(paramInt), null);
  }
  
  public final void finish()
  {
    super.finish();
  }
  
  protected final int getLayoutId()
  {
    return y.h.app_brand_404_page_ui;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    com.tencent.mm.ui.statusbar.a.d(this.mController.contentView, getStatusBarColor(), false);
    setMMTitle(y.j.app_brand_error);
    setBackBtn(new AppBrand404PageUI.2(this));
    paramBundle = (TextView)findViewById(y.g.app_brand_error_page_reason);
    String str = getIntent().getStringExtra("key_wording");
    bk.bl(str);
    if (paramBundle != null) {
      paramBundle.setText(str);
    }
  }
  
  protected final void onDestroy()
  {
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrand404PageUI
 * JD-Core Version:    0.7.0.1
 */