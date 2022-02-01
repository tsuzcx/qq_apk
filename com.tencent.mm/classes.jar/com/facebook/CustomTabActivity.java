package com.facebook;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.activities.HellActivity;

public class CustomTabActivity
  extends HellActivity
{
  public static final String CUSTOM_TAB_REDIRECT_ACTION;
  private static final int CUSTOM_TAB_REDIRECT_REQUEST_CODE = 2;
  public static final String DESTROY_ACTION;
  private BroadcastReceiver closeReceiver;
  
  static
  {
    AppMethodBeat.i(7604);
    CUSTOM_TAB_REDIRECT_ACTION = CustomTabActivity.class.getSimpleName() + ".action_customTabRedirect";
    DESTROY_ACTION = CustomTabActivity.class.getSimpleName() + ".action_destroy";
    AppMethodBeat.o(7604);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(7602);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 == 0)
    {
      paramIntent = new Intent(CUSTOM_TAB_REDIRECT_ACTION);
      paramIntent.putExtra(CustomTabMainActivity.EXTRA_URL, getIntent().getDataString());
      d.W(this).b(paramIntent);
      this.closeReceiver = new BroadcastReceiver()
      {
        public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
        {
          AppMethodBeat.i(7600);
          CustomTabActivity.this.finish();
          AppMethodBeat.o(7600);
        }
      };
      d.W(this).a(this.closeReceiver, new IntentFilter(DESTROY_ACTION));
    }
    AppMethodBeat.o(7602);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(7601);
    super.onCreate(paramBundle);
    paramBundle = new Intent(this, CustomTabMainActivity.class);
    paramBundle.setAction(CUSTOM_TAB_REDIRECT_ACTION);
    paramBundle.putExtra(CustomTabMainActivity.EXTRA_URL, getIntent().getDataString());
    paramBundle.addFlags(603979776);
    startActivityForResult(paramBundle, 2);
    AppMethodBeat.o(7601);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(7603);
    d.W(this).unregisterReceiver(this.closeReceiver);
    super.onDestroy();
    AppMethodBeat.o(7603);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.facebook.CustomTabActivity
 * JD-Core Version:    0.7.0.1
 */