package com.facebook;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.d;
import com.facebook.internal.CustomTab;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.activities.HellActivity;

public class CustomTabMainActivity
  extends HellActivity
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
    AppMethodBeat.i(7611);
    EXTRA_PARAMS = CustomTabMainActivity.class.getSimpleName() + ".extra_params";
    EXTRA_CHROME_PACKAGE = CustomTabMainActivity.class.getSimpleName() + ".extra_chromePackage";
    EXTRA_URL = CustomTabMainActivity.class.getSimpleName() + ".extra_url";
    REFRESH_ACTION = CustomTabMainActivity.class.getSimpleName() + ".action_refresh";
    AppMethodBeat.o(7611);
  }
  
  public static final String getRedirectUrl()
  {
    AppMethodBeat.i(7606);
    String str = "fb" + FacebookSdk.getApplicationId() + "://authorize";
    AppMethodBeat.o(7606);
    return str;
  }
  
  private void sendResult(int paramInt, Intent paramIntent)
  {
    AppMethodBeat.i(7610);
    d.W(this).unregisterReceiver(this.redirectReceiver);
    if (paramIntent != null) {
      setResult(paramInt, paramIntent);
    }
    for (;;)
    {
      finish();
      AppMethodBeat.o(7610);
      return;
      setResult(paramInt);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(7607);
    super.onCreate(paramBundle);
    if (CustomTabActivity.CUSTOM_TAB_REDIRECT_ACTION.equals(getIntent().getAction()))
    {
      setResult(0);
      finish();
      AppMethodBeat.o(7607);
      return;
    }
    if (paramBundle == null)
    {
      paramBundle = getIntent().getBundleExtra(EXTRA_PARAMS);
      String str = getIntent().getStringExtra(EXTRA_CHROME_PACKAGE);
      new CustomTab("oauth", paramBundle).openCustomTab(this, str);
      this.shouldCloseCustomTab = false;
      this.redirectReceiver = new BroadcastReceiver()
      {
        private byte _hellAccFlag_;
        
        public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
        {
          AppMethodBeat.i(7605);
          paramAnonymousContext = new Intent(CustomTabMainActivity.this, CustomTabMainActivity.class);
          paramAnonymousContext.setAction(CustomTabMainActivity.REFRESH_ACTION);
          paramAnonymousContext.putExtra(CustomTabMainActivity.EXTRA_URL, paramAnonymousIntent.getStringExtra(CustomTabMainActivity.EXTRA_URL));
          paramAnonymousContext.addFlags(603979776);
          paramAnonymousIntent = CustomTabMainActivity.this;
          paramAnonymousContext = new com.tencent.mm.hellhoundlib.b.a().bl(paramAnonymousContext);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousIntent, paramAnonymousContext.axQ(), "com/facebook/CustomTabMainActivity$1", "onReceive", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousIntent.startActivity((Intent)paramAnonymousContext.pG(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousIntent, "com/facebook/CustomTabMainActivity$1", "onReceive", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(7605);
        }
      };
      d.W(this).a(this.redirectReceiver, new IntentFilter(CustomTabActivity.CUSTOM_TAB_REDIRECT_ACTION));
    }
    AppMethodBeat.o(7607);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(7608);
    super.onNewIntent(paramIntent);
    if (REFRESH_ACTION.equals(paramIntent.getAction()))
    {
      Intent localIntent = new Intent(CustomTabActivity.DESTROY_ACTION);
      d.W(this).b(localIntent);
      sendResult(-1, paramIntent);
      AppMethodBeat.o(7608);
      return;
    }
    if (CustomTabActivity.CUSTOM_TAB_REDIRECT_ACTION.equals(paramIntent.getAction())) {
      sendResult(-1, paramIntent);
    }
    AppMethodBeat.o(7608);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(7609);
    super.onResume();
    if (this.shouldCloseCustomTab) {
      sendResult(0, null);
    }
    this.shouldCloseCustomTab = true;
    AppMethodBeat.o(7609);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.facebook.CustomTabMainActivity
 * JD-Core Version:    0.7.0.1
 */