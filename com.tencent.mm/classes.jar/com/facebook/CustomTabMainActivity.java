package com.facebook;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.d;
import com.facebook.internal.CustomTab;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class CustomTabMainActivity
  extends Activity
{
  public static final String EXTRA_CHROME_PACKAGE;
  public static final String EXTRA_PARAMS;
  public static final String EXTRA_URL;
  private static final String OAUTH_DIALOG = "oauth";
  public static final String REFRESH_ACTION;
  private BroadcastReceiver redirectReceiver;
  private boolean shouldCloseCustomTab = true;
  
  static
  {
    AppMethodBeat.i(96587);
    EXTRA_PARAMS = CustomTabMainActivity.class.getSimpleName() + ".extra_params";
    EXTRA_CHROME_PACKAGE = CustomTabMainActivity.class.getSimpleName() + ".extra_chromePackage";
    EXTRA_URL = CustomTabMainActivity.class.getSimpleName() + ".extra_url";
    REFRESH_ACTION = CustomTabMainActivity.class.getSimpleName() + ".action_refresh";
    AppMethodBeat.o(96587);
  }
  
  public static final String getRedirectUrl()
  {
    AppMethodBeat.i(96582);
    String str = "fb" + FacebookSdk.getApplicationId() + "://authorize";
    AppMethodBeat.o(96582);
    return str;
  }
  
  private void sendResult(int paramInt, Intent paramIntent)
  {
    AppMethodBeat.i(96586);
    d.R(this).unregisterReceiver(this.redirectReceiver);
    if (paramIntent != null) {
      setResult(paramInt, paramIntent);
    }
    for (;;)
    {
      finish();
      AppMethodBeat.o(96586);
      return;
      setResult(paramInt);
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(96583);
    super.onCreate(paramBundle);
    if (CustomTabActivity.CUSTOM_TAB_REDIRECT_ACTION.equals(getIntent().getAction()))
    {
      setResult(0);
      finish();
      AppMethodBeat.o(96583);
      return;
    }
    if (paramBundle == null)
    {
      paramBundle = getIntent().getBundleExtra(EXTRA_PARAMS);
      String str = getIntent().getStringExtra(EXTRA_CHROME_PACKAGE);
      new CustomTab("oauth", paramBundle).openCustomTab(this, str);
      this.shouldCloseCustomTab = false;
      this.redirectReceiver = new CustomTabMainActivity.1(this);
      d.R(this).a(this.redirectReceiver, new IntentFilter(CustomTabActivity.CUSTOM_TAB_REDIRECT_ACTION));
    }
    AppMethodBeat.o(96583);
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(96584);
    super.onNewIntent(paramIntent);
    if (REFRESH_ACTION.equals(paramIntent.getAction()))
    {
      Intent localIntent = new Intent(CustomTabActivity.DESTROY_ACTION);
      d.R(this).c(localIntent);
      sendResult(-1, paramIntent);
      AppMethodBeat.o(96584);
      return;
    }
    if (CustomTabActivity.CUSTOM_TAB_REDIRECT_ACTION.equals(paramIntent.getAction())) {
      sendResult(-1, paramIntent);
    }
    AppMethodBeat.o(96584);
  }
  
  protected void onResume()
  {
    AppMethodBeat.i(96585);
    super.onResume();
    if (this.shouldCloseCustomTab) {
      sendResult(0, null);
    }
    this.shouldCloseCustomTab = true;
    AppMethodBeat.o(96585);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.facebook.CustomTabMainActivity
 * JD-Core Version:    0.7.0.1
 */